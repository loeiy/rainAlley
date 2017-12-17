package com.alley.rain.common;


import com.alley.rain.enums.ActionCodeEnum;

public class SingleResult<T> extends Result {

    private static final long serialVersionUID = -3284587087945229723L;

    private T result;

    public SingleResult(boolean isSuccess, ActionCodeEnum code, T result) {
        super(isSuccess, code);
        this.result = result;
    }

    public SingleResult(boolean isSuccess, ActionCodeEnum code) {
        super(isSuccess, code);
        this.result = null;
    }

    public SingleResult(boolean isSuccess, T result) {
        super(isSuccess);
        this.result = result;
    }

    public SingleResult() {
        super(false);
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
