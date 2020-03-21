package com.neoniou.blog.exception;

/**
 * @author neo.zzj
 */
public enum ExceptionEnum {

    /**
     * Exception enums
     */
    INIT_DATABASE_FAIL(500, "初始化数据库失败！"),
    CATEGORY_REPEAT(400, "分类已存在！"),
    ADD_POST_FAIL(408, "文章新增失败！"),
    REQUEST_FORBIDDEN(403, "Request Forbidden"),
    ;
    private int statusCode;
    private String message;

    ExceptionEnum() {
    }

    ExceptionEnum(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}