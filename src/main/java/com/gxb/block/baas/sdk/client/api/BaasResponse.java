package com.gxb.block.baas.sdk.client.api;

import java.io.Serializable;

/**
 * @Description 请求返回抽象类
 * @Author Hanawa
 * @Date 2018/3/12
 * @Version 1.0
 */
public abstract class BaasResponse implements Serializable {
    private static final long serialVersionUID = -8953054088680330201L;
    private Integer code;
    private String msg;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
