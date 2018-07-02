package com.gxb.block.baas.sdk.client.api.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.gxb.block.baas.sdk.client.api.BaasResponse;
import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author Hanawa
 * @Date 2018/3/13
 * @Version 1.0
 */
@Data
public class ProviderResp extends BaasResponse {
    private static final long serialVersionUID = -6495682334341870137L;
    private Result data;


    @Data
    public static class Result {
        @JSONField(name = "baas_account_id")
        private String baasAccountId;
        @JSONField(name = "baas_account_dev_id")
        private String baasAccountDevId;
        private String name;
        private String description;
        private List<Fee> fees;
    }

    @Data
    public static class Fee {
        @JSONField(name = "fee_per_kbytes")
        private Integer feePerKBytes;
        @JSONField(name = "asset_id")
        private String assetId;
    }
}
