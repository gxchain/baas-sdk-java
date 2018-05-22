package com.gxb.block.baas.sdk.client.api.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.gxb.block.baas.sdk.client.api.BaasResponse;
import lombok.Data;

/**
 * @Description
 * @Author Hanawa
 * @Date 2018/3/13
 * @Version 1.0
 */
@Data public class GetStoreDataFeeResp extends BaasResponse {
    private static final long serialVersionUID = -6495682334341870137L;
    private Result data;


    @Data public class Result {
        @JSONField(name = "price_per_kbyte")
        private long pricePerKByte;
    }
}
