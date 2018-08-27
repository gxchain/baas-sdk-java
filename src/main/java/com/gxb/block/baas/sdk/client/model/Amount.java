package com.gxb.block.baas.sdk.client.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.primitives.Bytes;
import com.gxchain.common.signature.utils.Util;
import com.gxchain.common.signature.utils.Varint;

import java.io.*;

/**
 * @Description 通用的支付资产model
 * @Author Hanawa
 * @Date 2018/3/12
 * @Version 1.0
 */
public class Amount implements Serializable {
    private static final long serialVersionUID = -7981551583853222205L;
    @JSONField(name = "asset_id")
    private String assetId;
    private Long amount;

    public Amount(String assetId, Long amount) {
        this.assetId = assetId;
        this.amount = amount;
    }

    public byte[] toBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutput out = new DataOutputStream(byteArrayOutputStream);
        try {
            Varint.writeUnsignedVarLong(Long.parseLong(this.assetId.split("\\.")[2]), out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Getting asset id
        byte[] assetId = byteArrayOutputStream.toByteArray();
        byte[] value = Util.revertLong(this.amount);

        // Concatenating and returning value + asset id
        return Bytes.concat(value, assetId);
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
