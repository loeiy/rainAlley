/*
 * Copyright 1999-2024 Colotnet.com All right reserved. This software is the confidential and proprietary information of
 * Colotnet.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Colotnet.com.
 */
package com.alley.rain.common;


import com.alley.rain.enums.ActionCodeEnum;

import java.util.List;

/**
 * 类QueryResult.java的实现描述：查询返回结果
 * 
 * @author Administrator 2016年2月1日 下午1:23:33
 */
public class QueryResult<T> extends Result {

    /**
     * 
     */
    private static final long serialVersionUID = -7616663907405360892L;

    /**
     * 数据的结果集
     */
    private List<T>           results;
    /**
     * 分页信息
     */
    private PageResult     pageResult;

    public QueryResult(boolean isSuccess, ActionCodeEnum code, List<T> results) {
        super(isSuccess, code);
        this.results = results;
        
    }

    public QueryResult(boolean isSuccess, List<T> results) {
        super(isSuccess);
        this.results = results;
    }

    public QueryResult() {
        super(false);
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
        //返回分页信息
        PageResult pageResult=new PageResult(results);
        this.setPageResult(pageResult);
    }

    public void setPageInfo(List<?> results){
        PageResult pageResult=new PageResult(results);
        this.setPageResult(pageResult);
    }

    /**
     * @return the pageResult
     */
    public PageResult getPageResult() {
        return pageResult;
    }

    /**
     * @param pageResult the pageResult to set
     */
    public void setPageResult(PageResult pageResult) {
        this.pageResult = pageResult;
    }

}
