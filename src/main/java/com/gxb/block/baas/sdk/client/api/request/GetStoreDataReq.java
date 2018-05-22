package com.gxb.block.baas.sdk.client.api.request;

import com.gxb.block.baas.sdk.client.api.BaasRequest;
import com.gxb.block.baas.sdk.client.api.response.GetStoreDataResp;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author Hanawa
 * @Date 2018/3/13
 * @Version 1.0
 */
@Data public class GetStoreDataReq implements BaasRequest<GetStoreDataResp> {

    private String data_cid;

    @Override public Class<GetStoreDataResp> getResponseClass() {
        return GetStoreDataResp.class;
    }

    @Override public Map<String, String> toMap() {
        Map<String,String> map = new HashMap<>();
        map.put("dataCid",data_cid);
        return map;
    }
}
