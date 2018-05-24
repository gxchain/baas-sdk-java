package com.gxb.block.baas.sdk.client.api.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.primitives.Bytes;
import com.gxb.block.baas.sdk.client.api.BaasConstants;
import com.gxb.block.baas.sdk.client.api.BaasRequest;
import com.gxb.block.baas.sdk.client.api.response.StoreDataResp;
import com.gxchain.common.ws.client.graphenej.objects.AssetAmount;
import com.gxchain.common.ws.client.graphenej.objects.UserAccount;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

import static com.gxb.block.baas.sdk.client.api.BaasConstants.KBYTE_NUM;

/**
 * @Description
 * @Author Hanawa
 * @Date 2018/3/12
 * @Version 1.0
 */
@Data public class StoreDataReq extends BaseOnChainReq implements BaasRequest<StoreDataResp> {

    private String from;
    private String to = BaasConstants.BAAS_ACCOUNT;
    @JSONField(name = "proxy_account") private String proxyAccount = BaasConstants.BAAS_ACCOUNT;
    private int percent = 0;
    private Long amount;
    private String assetId = "1.3.1";
    private String memo;
    private String signatures;
    private byte[] data;

    @Override public Class<StoreDataResp> getResponseClass() {
        return StoreDataResp.class;
    }

    @Override public byte[] toBytes() {
        byte[] fromBytes = new UserAccount(from).toBytes();
        byte[] toBytes = new UserAccount(to).toBytes();
        byte[] proxyAccountBytes = new UserAccount(proxyAccount).toBytes();
        byte[] amountBytes = new AssetAmount(amount, assetId).toBytes();
        byte[] percentBytes = new byte[] {(byte) percent, (byte) (percent >> 8)};
        byte[] memoPrefixBytes = new byte[] {(byte) memo.length()};
        byte[] memoBytes = memo.getBytes();
        byte[] expirationBytes = getExpirationBytes();
        return Bytes.concat(fromBytes, toBytes, proxyAccountBytes, amountBytes, percentBytes, memoPrefixBytes, memoBytes, expirationBytes, new byte[] {0});
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("from", from);
        map.put("to", to);
        map.put("proxy_account", proxyAccount);
        map.put("percent", String.valueOf(percent));
        map.put("amount", amount + "");
        map.put("asset_id", assetId);
        map.put("memo", memo);
        map.put("expiration", getExpiration() + "");
        map.put("signatures", signatures);
        return map;
    }

    @Override public String sign(String priKey, String pubKey) {
        return super.sign(priKey, pubKey);
    }
}
