package com.gxb.block.baas.sdk.client.api.response;

import com.gxb.block.baas.sdk.client.api.BaasResponse;

/**
 * @Description
 * @Author Hanawa
 * @Date 2018/3/13
 * @Version 1.0
 */
public class GetStoreDataResp extends BaasResponse {
    private static final long serialVersionUID = 2662378705590389122L;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
