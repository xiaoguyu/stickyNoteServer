package com.cppdebug.stickyNoteServer.common.response;


import lombok.Getter;

import java.io.Serializable;

/**
 * @author wjw
 * @description: 通用返回结果
 * @title: CommonResult
 * @date 2022/3/6 14:49
 */
@Getter
public class CommonResult<T> implements Serializable {
    /**
     * 错误编码
     */
    private final int errno;
    /**
     * 提示消息
     */
    private final String msg;
    /**
     * 返回数据
     */
    private final T data;

    public CommonResult(ResponseCodeEnum codeEnum, T data) {
        this.errno = codeEnum.getCode();
        this.msg = codeEnum.getName();
        this.data = data;
    }

    public CommonResult(int errno, String msg, T data) {
        this.errno = errno;
        this.msg = msg;
        this.data = data;
    }

    public static CommonResult ok() {
        return new CommonResult(ResponseCodeEnum.SUCCESS, null);
    }

    public static <T> CommonResult<T> ok(T data) {
        return new CommonResult<T>(ResponseCodeEnum.SUCCESS, data);
    }

    public static CommonResult fail() {
        return new CommonResult(ResponseCodeEnum.FAIL, null);
    }

    public static CommonResult fail(String errmsg) {
        return new CommonResult(ResponseCodeEnum.FAIL.getCode(), errmsg, null);
    }

    public static CommonResult fail(int errno, String errmsg) {
        return new CommonResult(errno, errmsg, null);
    }

    public static <T> CommonResult<T> fail(int errno, String errmsg, T data) {
        return new CommonResult(errno, errmsg, data);
    }

    /**
     * 参数不对
     */
    public static CommonResult badArgument() {
        return new CommonResult(ResponseCodeEnum.BAD_ARGUMENT, null);
    }

    /**
     * 参数值不对
     */
    public static CommonResult badArgumentValue() {
        return new CommonResult(ResponseCodeEnum.BAD_ARGUMENT_VALUE, null);
    }

    /**
     * 未登录
     */
    public static CommonResult unlogin() {
        return new CommonResult(ResponseCodeEnum.UNLOGIN, null);
    }

    /**
     * 无权限
     */
    public static CommonResult noPermission() {
        return new CommonResult(ResponseCodeEnum.NO_PERMISSION, null);
    }

    /**
     * 用于无法通过系统校验，抛出runtimeexception
     */
    public static CommonResult unCheck(String errmsg) {
        return new CommonResult(ResponseCodeEnum.NO_PERMISSION.getCode(), errmsg, null);
    }

    /**
     * 系统内部错误
     */
    public static CommonResult serious(String errmsg) {
        return new CommonResult(ResponseCodeEnum.SERIOUS.getCode(), errmsg, null);
    }

}
