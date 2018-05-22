package com.gxb.block.baas.sdk.client.api;

import com.gxb.block.baas.sdk.client.enums.BaasErrEnum;
import lombok.Getter;

/**
 * @Description
 * @Author Hanawa
 * @Date 2018/3/12
 * @Version 1.0
 */
public class BaasApiException extends Exception {
    @Getter private int errCode;
    @Getter private String errMsg;

    public BaasApiException() {
        super("Deprecated request");
    }

    public BaasApiException(BaasErrEnum errEnum) {
        this(errEnum.getErrCode(), errEnum.getErrMsg());
    }

    public BaasApiException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public BaasApiException(String message) {
        super(message);
    }

    public BaasApiException(Throwable cause) {
        super(cause);
    }

    public BaasApiException(int errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
