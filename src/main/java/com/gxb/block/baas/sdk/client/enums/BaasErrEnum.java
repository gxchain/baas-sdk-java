package com.gxb.block.baas.sdk.client.enums;


/**
 * @Author Hanawa
 * @Date 2018/3/15
 * @Version 1.0
 */
public enum BaasErrEnum {

    UNKNOW_ERROR(0, "未知错误"),


    STORE_DATA_OVER_SIZE(10, "存储的数据超过了限制");


    private int errCode;
    private String errMsg;

    BaasErrEnum(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
