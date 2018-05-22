package com.gxb.block.baas.sdk.client.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author Hanawa
 * @Date 2018/3/15
 * @Version 1.0
 */
@AllArgsConstructor public enum BaasErrEnum {

    UNKNOW_ERROR(0, "未知错误"),


    STORE_DATA_OVER_SIZE(10, "存储的数据超过了限制");


    @Getter private int errCode;
    @Getter private String errMsg;
}
