package com.gxb.block.baas.sdk.client.api.response;

import com.gxb.block.baas.sdk.client.api.BaasResponse;

/**
 * @Description
 * @Author Hanawa
 * @Date 2018/3/12
 * @Version 1.0
 */
public class StoreDataResp extends BaasResponse {
    private static final long serialVersionUID = -5880418430743519483L;
    private Result data;

    public class Result {
        private String txid;
        private String cid;

        public String getTxid() {
            return txid;
        }

        public void setTxid(String txid) {
            this.txid = txid;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }
    }

    public Result getData() {
        return data;
    }

    public void setData(Result data) {
        this.data = data;
    }
}
