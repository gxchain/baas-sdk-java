package com.gxb.block.baas.sdk.client.api.request;

import com.gxb.block.baas.sdk.client.api.BaasRequest;
import com.gxb.block.baas.sdk.client.api.response.GetStoreDataFeeResp;

import java.util.Map;

/**
 * @Description
 * @Author Hanawa
 * @Date 2018/3/13
 * @Version 1.0
 */
public class GetStoreDataFeeReq implements BaasRequest<GetStoreDataFeeResp> {
    @Override public Class<GetStoreDataFeeResp> getResponseClass() {
        return GetStoreDataFeeResp.class;
    }

    @Override public Map<String, String> toMap() {
        return null;
    }
}
