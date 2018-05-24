package com.gxb.block.baas.sdk.client.api;

import com.alibaba.fastjson.JSON;
import com.gxb.block.baas.sdk.client.api.BaasApiException;
import com.gxb.block.baas.sdk.client.api.BaasClient;
import com.gxb.block.baas.sdk.client.api.BaasRequest;
import com.gxb.block.baas.sdk.client.api.BaasResponse;
import com.gxb.block.baas.sdk.client.utils.HttpUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

/**
 * @Description
 * @Author Hanawa
 * @Date 2018/3/12
 * @Version 1.0
 */
@Data @AllArgsConstructor public class BaasDefaultClient implements BaasClient {

    private String url;
    private boolean isPost = true;

    public BaasDefaultClient(){
    }

    public BaasDefaultClient(String url) {
        this.url = url;
    }

    @Override public <T extends BaasResponse> T execute(BaasRequest<T> request) throws BaasApiException {
        String result = isPost ? HttpUtils.getPostRespJson(getUrl(), request.toMap()) : HttpUtils.getGetRespJson(url);
        return StringUtils.isEmpty(result) ? null : JSON.parseObject(result, request.getResponseClass());
    }

    @Override public <T extends BaasResponse> T executeFormData(BaasRequest<T> request, String dataName, File data) throws BaasApiException {
        String result = HttpUtils.getPostFormDataRespJson(getUrl(), request.toMap(), dataName, data);
        return StringUtils.isEmpty(result) ? null : JSON.parseObject(result, request.getResponseClass());
    }

    @Override
    public String execute(String url) throws BaasApiException {
        return HttpUtils.getGetRespJson(url);
    }

    @Override public InputStream download() {
        return HttpUtils.getGetFile(getUrl());
    }

    @Override public <T extends BaasResponse> T executeFormData(BaasRequest<T> request, String dataName, byte[] data) throws BaasApiException {
        String result = HttpUtils.getPostFormDataRespJson(getUrl(), request.toMap(), dataName, data);
        return StringUtils.isEmpty(result) ? null : JSON.parseObject(result, request.getResponseClass());
    }
}
