package com.gxb.block.baas.sdk.client.api.request;

import com.gxb.block.baas.sdk.client.api.BaasRequest;
import com.gxb.block.baas.sdk.client.api.response.ProviderResp;

import java.util.Map;

/**
 * @Description
 * @Author Hanawa
 * @Date 2018/3/13
 * @Version 1.0
 */
public class ProviderReq implements BaasRequest<ProviderResp> {
    @Override public Class<ProviderResp> getResponseClass() {
        return ProviderResp.class;
    }

    @Override public Map<String, String> toMap() {
        return null;
    }
}
