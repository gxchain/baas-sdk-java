package com.gxb.block.baas.sdk.client.api;

import com.gxb.block.baas.sdk.client.api.request.ProviderReq;
import com.gxb.block.baas.sdk.client.api.response.ProviderResp;

import javax.annotation.Nullable;

/**
 * @Description
 * @Author Hanawa
 * @Date 2018/3/13
 * @Version 1.0
 */
public interface BaasConstants {
    Integer KBYTE_NUM = 1024;
    Integer FEE_PER_KBYTE = 20;
    String ASSET_ID_GXS = "1.3.1";

    // 线上 路径
    String URL_HEADER = "https://baas.gxchain.cn/api/";
    // 开发者 路径
    String URL_DEVELOPER_HEADER = "https://baas-developer.gxchain.cn/api/";

    // 线上 正式节点BaaS账户，对应gxs-wallet
    String BAAS_ACCOUNT = "1.2.639287";
    // 开发者 测试节点BaaS账户，对应gxs-wallet
    String BAAS_DEV_ACCOUNT = "1.2.241";


    @Nullable
    static ProviderResp getProvider() {
        try {
            return new BaasDefaultClient(URL_HEADER + "storage/provider").execute(new ProviderReq());
        } catch (BaasApiException e) {
            e.printStackTrace();
        }
        return null;
    }
}
