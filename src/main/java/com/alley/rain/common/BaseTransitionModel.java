package com.alley.rain.common;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BaseTransitionModel implements Serializable {

    private static List<String> exceptClassName = new ArrayList<>(Arrays.asList("int","java.lang.Integer","boolean","java.lang.Boolean","char","java.lang.Character",
    "short","java.lang.Short","long","java.lang.Long","float","java.lang.Float","double","java.lang.Double"));

    public BaseTransitionModel() {};

    /**
     * 按照本类注解构建
     * @param obj
     */
    protected void constructByAnnotation(Object obj){
        try{
            transitionByAnotation(obj,this);
        }catch (Exception e){

        }
    }

    /**
     * 按照名称构建
     * @param obj
     * @return
     */
    protected void constructByName(Object obj){
        try{
            transition(obj,this);
        }catch (Exception e){

        }
    }

    /**
     * 按照注解格式化并获取对象
     * @param targetClass
     * @param <T>
     * @return
     */
    public  <T> T generateByAnnotation(Class<T> targetClass){
        try{
            T target = targetClass.newInstance();
            transitionByAnotation(this,target);
            return target;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 格式化并获取对象
     * @param targetClass
     * @param <T>
     * @return
     */
    public  <T> T generateByName(Class<T> targetClass){
        try{
            T target = targetClass.newInstance();
            transition(this,target);
            return target;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 格式化并获取对象
     * @param targetClass
     * @param additionalProperty Map<转化目标对象属性，当前对象属性>
     * @param <T>
     * @return
     */
    public  <T> T generateByNameAndMap(Class<T> targetClass, Map<String,String> additionalProperty){
        try{
            T target = targetClass.newInstance();
            transition(this,target);
            transition(this,additionalProperty);
            return target;
        }catch (Exception e){
            return null;
        }
    }
    /**
     * 仅根据Map映射格式化并获取对象
     * @param targetClass
     * @param additionalProperty Map<转化目标对象属性，当前对象属性>
     * @param <T>
     * @return
     */
    public <T> T generateByMapOnly(Class<T> targetClass, Map<String,String> additionalProperty){
        try{
            T target = targetClass.newInstance();
            transition(this,additionalProperty);
            return target;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 根据字段同名进行初始化
     * @param target
     */
    private void transition(Object source,Object target){
        Field[] fields = getFields(target.getClass());
        for(Field field:fields){
            transition(source, target,field.getName(),field.getName());
        }
    }

    /**
     * 根据注解
     * @param target
     */
    private void transitionByAnotation(Object source,Object target){
        Field[] fields = getFields(target.getClass());
        //是否只允许通过注解，默认必须通过注解
        Transition typeTransitionInfo = target.getClass().getAnnotation(Transition.class);
        boolean onlyAnnotation = typeTransitionInfo == null ? true : typeTransitionInfo.annotationOnly();
        for(Field field:fields){
            Transition transitionInfo = field.getAnnotation(Transition.class);
            if(transitionInfo != null) {    //注解不为空的时候
                String sourceName = field.getName(); //默认名字匹配
                if(!StringUtils.isEmpty(transitionInfo.from())) //注解提供名称，按照名称匹配
                    sourceName = transitionInfo.from();
                transition(source,target, sourceName, field.getName());
            }else{ //未提供注解
                if(!onlyAnnotation)//如果不是必须通过注解
                    transition(source,target, field.getName(), field.getName());   //按照名称匹配
            }
        }
    }

    /**
     * 根据映射Map进行初始化赋值
     * @param target
     * @param additionalProperty
     */
    private void transition(Object source, Object target, Map<String,String> additionalProperty) {
        for(Map.Entry<String,String> entry: additionalProperty.entrySet()){
            transition(source, target,entry.getValue(),entry.getKey());
        }
    }

    private void transition(Object sourceObj, Object targetObj ,String source,String target){
        try{
            Field targetField = getField(targetObj.getClass(),target);
            Field sourceField = getField(sourceObj.getClass(),source);
            if(targetField.getType().equals(sourceField.getType())||
                    (exceptClassName.contains(targetField.getType().getTypeName()) &&
                            exceptClassName.contains(sourceField.getType().getTypeName()))){
                //获取对方的set方法
                Method setter = getMethod(targetObj.getClass(),targetField,"set",targetField.getType());
                //获取自身的get方法
                Method getter = getMethod(sourceObj.getClass(),sourceField,"get");
                //set
                if(getter != null && setter != null)
                    setter.invoke(targetObj,getter.invoke(sourceObj));
            }
        }catch (Exception e){
            // fuck stupid java designer
            // getField function should return null when field not found
            // instead of throw a fucking exception
            // so I have to catch this fucking exception
            // but this is exactly not an excetion at all
            // fuck !!!!
        }
    }

    private Method getMethod(Class clazz, Field field, String Prefix, Class<?>... parameterTypes){
            Method[] methods = clazz.getMethods(); //获取所有方法
            for(Method method:methods){
                String lowerName = method.getName().toLowerCase();
                String targetName = (Prefix + field.getName()).toLowerCase();
                boolean hasMatch = false;
                if(lowerName.equals(targetName)){
                    hasMatch = true;
                }else if(field.getType().equals(boolean.class) || field.getType().equals(Boolean.class)){ //如果是bool值
                    targetName = field.getName().toLowerCase();
                    if(lowerName.equals(targetName)){       //直接相等的
                        hasMatch = true;
                    }else{
                        targetName = (Prefix + field.getName().substring(2)).toLowerCase(); //去掉is + 前缀的
                        if(lowerName.equals(targetName)){
                            hasMatch = true;
                        }else{
                            targetName = ("is" + field.getName()).toLowerCase();    //直接加is的
                            if(lowerName.equals(targetName)) {
                                hasMatch = true;
                            }
                        }
                    }
                }
                if(hasMatch)
                    return getMethod(clazz,method.getName(),parameterTypes);
            }
            return  null;
    }

    //获取方法
    private Method getMethod(Class clazz, String methodName, Class<?>... parameterTypes){
        try {
            return clazz.getMethod(methodName,parameterTypes);
        } catch (Exception e) {
            return null;
        }
    }

    //递归获取所有的属性
    private Field[] getFields(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        Class superClass = clazz.getSuperclass();
        if (superClass != null) {
            return  (Field[]) ArrayUtils.addAll(fields,superClass.getDeclaredFields());
        }else {
            return fields;
        }
    }

    //递归获取属性
    private Field getField(Class clazz, String fieldName) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            Class superClass = clazz.getSuperclass();
            if (superClass == null) {
                return null;
            } else {
                return getField(superClass, fieldName);
            }
        }
    }

    /**
     * 根据field获取getter名称
     * @param fieldName
     * @return
     */
    private String genGetSetName(String fieldName, String type){
        char[] chars = fieldName.toCharArray();
        if(Character.isLowerCase(chars[0])) {   //如果是小写
            chars[0] = Character.toUpperCase(chars[0]); //转化成大写
        }
        return  type + String.valueOf(chars);
    }


}
