package com.gxb.block.baas.sdk.client.api.response;

import com.gxb.block.baas.sdk.client.api.BaasResponse;
import lombok.Data;

/**
 * @Description
 * @Author Hanawa
 * @Date 2018/3/12
 * @Version 1.0
 */
@Data public class StoreDataResp extends BaasResponse {
    private static final long serialVersionUID = -5880418430743519483L;
    private Result data;


    @Data public class Result {
        private String txid;
        private String cid;
    }

}
