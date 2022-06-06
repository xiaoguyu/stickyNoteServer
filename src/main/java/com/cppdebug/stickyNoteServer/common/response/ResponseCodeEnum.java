package com.cppdebug.stickyNoteServer.common.response;

/**
 * @author wjw
 * @description: 请求响应编码枚举类
 * @title: ResponseCodeEnum
 * @date 2022/3/4 16:42
 */
public enum ResponseCodeEnum {

    /**
     * http状态码
     * 信息响应（100-199）
     * 成功响应（200-299）
     * 消息重定向（300–399）
     * 客户错误响应（400–499）
     * 服务器错误响应（500–599）
     */

    SUCCESS(0, "成功"),
    FAIL(-1, "失败"),
    UNLOGIN(401, "请登录"),
    NO_PERMISSION(402, "无权限"),
    BAD_ARGUMENT(501, "参数不对"),
    BAD_ARGUMENT_VALUE(502, "参数值不对"),
    UN_CHECK(503, "系统错误"),
    SERIOUS(509, "系统内部错误");

    private final int code;
    private final String name;

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    ResponseCodeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
