package com.gxb.block.baas.sdk.client.api.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.gxb.block.baas.sdk.client.api.BaasResponse;

import java.util.List;

/**
 * @Description
 * @Author Hanawa
 * @Date 2018/3/13
 * @Version 1.0
 */
public class ProviderResp extends BaasResponse {
    private static final long serialVersionUID = -6495682334341870137L;
    private Result data;


    public static class Result {
        @JSONField(name = "account_id")
        private String accountId;
        private String name;
        private String description;
        private List<Fee> fees;

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<Fee> getFees() {
            return fees;
        }

        public void setFees(List<Fee> fees) {
            this.fees = fees;
        }
    }

    public static class Fee {
        @JSONField(name = "fee_per_kbytes")
        private Integer feePerKBytes;
        @JSONField(name = "asset_id")
        private String assetId;

        public Integer getFeePerKBytes() {
            return feePerKBytes;
        }

        public void setFeePerKBytes(Integer feePerKBytes) {
            this.feePerKBytes = feePerKBytes;
        }

        public String getAssetId() {
            return assetId;
        }

        public void setAssetId(String assetId) {
            this.assetId = assetId;
        }
    }

    public Result getData() {
        return data;
    }

    public void setData(Result data) {
        this.data = data;
    }
}
