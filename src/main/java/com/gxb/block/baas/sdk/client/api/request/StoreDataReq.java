package com.gxb.block.baas.sdk.client.api.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.primitives.Bytes;
import com.gxb.block.baas.sdk.client.api.BaasConstants;
import com.gxb.block.baas.sdk.client.api.BaasRequest;
import com.gxb.block.baas.sdk.client.api.response.StoreDataResp;
import com.gxb.block.baas.sdk.client.model.Amount;
import com.gxb.block.baas.sdk.client.model.UserAccount;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author Hanawa
 * @Date 2018/3/12
 * @Version 1.0
 */
public class StoreDataReq extends BaseOnChainReq implements BaasRequest<StoreDataResp> {

    private String from;
    private String to = BaasConstants.BAAS_ACCOUNT;
    @JSONField(name = "proxy_account")
    private String proxyAccount = BaasConstants.BAAS_ACCOUNT;
    private int percent = 0;
    private Long amount;
    private String assetId = "1.3.1";
    private String memo;
    private String signatures;
    private byte[] data;

    @Override
    public Class<StoreDataResp> getResponseClass() {
        return StoreDataResp.class;
    }

    @Override
    public byte[] toBytes() {
        byte[] fromBytes = new UserAccount(from).toBytes();
        byte[] toBytes = new UserAccount(to).toBytes();
        byte[] proxyAccountBytes = new UserAccount(proxyAccount).toBytes();
        byte[] amountBytes = new Amount(assetId, amount).toBytes();
        byte[] percentBytes = new byte[]{(byte) percent, (byte) (percent >> 8)};
        byte[] memoPrefixBytes = new byte[]{(byte) memo.length()};
        byte[] memoBytes = memo.getBytes();
        byte[] expirationBytes = getExpirationBytes();
        return Bytes.concat(fromBytes, toBytes, proxyAccountBytes, amountBytes, percentBytes, memoPrefixBytes, memoBytes, expirationBytes, new byte[]{0});
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

    @Override
    public String sign(String priKey, String pubKey) {
        return super.sign(priKey, pubKey);
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getProxyAccount() {
        return proxyAccount;
    }

    public void setProxyAccount(String proxyAccount) {
        this.proxyAccount = proxyAccount;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getSignatures() {
        return signatures;
    }

    public void setSignatures(String signatures) {
        this.signatures = signatures;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "StoreDataReq{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", proxyAccount='" + proxyAccount + '\'' +
                ", percent=" + percent +
                ", amount=" + amount +
                ", assetId='" + assetId + '\'' +
                ", memo='" + memo + '\'' +
                ", signatures='" + signatures + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
