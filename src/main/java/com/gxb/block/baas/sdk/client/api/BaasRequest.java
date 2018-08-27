package com.gxb.block.baas.sdk.client.api;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

/**
 * @Description 统一请求接口
 * @Author Hanawa
 * @Date 2018/3/12
 * @Version 1.0
 */
public interface BaasRequest<T extends BaasResponse> {
    @JSONField(serialize = false)
    Class<T> getResponseClass();

    @JSONField(serialize = false)
    Map<String, String> toMap();
}
