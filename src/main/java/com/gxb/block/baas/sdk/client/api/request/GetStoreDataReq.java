package com.gxb.block.baas.sdk.client.api.request;

import com.gxb.block.baas.sdk.client.api.BaasRequest;
import com.gxb.block.baas.sdk.client.api.response.GetStoreDataResp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author Hanawa
 * @Date 2018/3/13
 * @Version 1.0
 */
public class GetStoreDataReq implements BaasRequest<GetStoreDataResp> {

    private String data_cid;

    @Override public Class<GetStoreDataResp> getResponseClass() {
        return GetStoreDataResp.class;
    }

    @Override public Map<String, String> toMap() {
        Map<String,String> map = new HashMap<>();
        map.put("dataCid",data_cid);
        return map;
    }

    public String getData_cid() {
        return data_cid;
    }

    public void setData_cid(String data_cid) {
        this.data_cid = data_cid;
    }
}
