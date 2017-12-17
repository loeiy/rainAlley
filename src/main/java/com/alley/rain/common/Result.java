package com.alley.rain.common;


import com.alley.rain.enums.ActionCodeEnum;

import java.io.Serializable;

/**
 * 类Result.java的实现描述：返回结果
 * 
 * @author Administrator 2016年2月1日 下午1:22:30
 */
public class Result implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7018644655421921872L;
    /**
     * 是否成功
     */

    private boolean           isSuccess;

    /**
     * 错误代码
     */
    private ActionCodeEnum code;

    public Result() {
        this.isSuccess = false;
        this.code = ActionCodeEnum.ActionFailed;
    }

    public Result(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Result(boolean isSuccess, ActionCodeEnum code) {
        this.isSuccess = isSuccess;
        this.code = code;
    }


    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public ActionCodeEnum getCode() {
        return code;
    }

    public void setCode(ActionCodeEnum code) {
        this.code = code;
        if(code == ActionCodeEnum.ActionSuccessed || code == ActionCodeEnum.TransSuccessed){
            this.isSuccess = true;
        }
    }
}
