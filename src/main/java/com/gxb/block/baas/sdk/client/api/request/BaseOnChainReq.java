package com.gxb.block.baas.sdk.client.api.request;

import com.gxb.block.baas.sdk.client.utils.Varint;
import com.gxchain.common.signature.SignatureUtil;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

/**
 * @Description 需要上链的base request
 * @Author Hanawa
 * @Date 2018/4/28
 * @Version 1.0
 */
public abstract class BaseOnChainReq {

    private long expiration = DateUtils.addHours(new Date(), 8).getTime() / 1000 + 60;

    abstract byte[] toBytes();

    byte[] getExpirationBytes() {
        return Varint.writeUnsignedSize(this.expiration);
    }

    String sign(String priKey, String pubKey) {
        String signature = SignatureUtil.signature(this.toBytes(), priKey);
        while (!SignatureUtil.verify(this.toBytes(), signature, pubKey, true)) {
            this.expiration += 1;
            signature = SignatureUtil.signature(this.toBytes(), priKey);
        }
        return signature;
    }

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }
}
