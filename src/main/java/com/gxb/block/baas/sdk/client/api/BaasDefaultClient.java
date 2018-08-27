package com.gxb.block.baas.sdk.client.api;

import com.alibaba.fastjson.JSON;
import com.gxb.block.baas.sdk.client.utils.HttpUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.InputStream;

/**
 * @Description
 * @Author Hanawa
 * @Date 2018/3/12
 * @Version 1.0
 */
public class BaasDefaultClient implements BaasClient {

    private String url;
    private boolean isPost = true;

    public BaasDefaultClient() {
    }

    public BaasDefaultClient(String url) {
        this.url = url;
    }

    @Override public <T extends BaasResponse> T execute(BaasRequest<T> request) throws BaasApiException {
        String result = isPost ? HttpUtils.getPostRespJson(this.url, request.toMap()) : HttpUtils.getGetRespJson(url);
        return StringUtils.isEmpty(result) ? null : JSON.parseObject(result, request.getResponseClass());
    }

    @Override public <T extends BaasResponse> T executeFormData(BaasRequest<T> request, String dataName, File data) throws BaasApiException {
        String result = HttpUtils.getPostFormDataRespJson(this.url, request.toMap(), dataName, data);
        return StringUtils.isEmpty(result) ? null : JSON.parseObject(result, request.getResponseClass());
    }

    @Override
    public String execute(String url) {
        return HttpUtils.getGetRespJson(url);
    }

    @Override public InputStream download() {
        return HttpUtils.getGetFile(this.url);
    }

    @Override public <T extends BaasResponse> T executeFormData(BaasRequest<T> request, String dataName, byte[] data) throws BaasApiException {
        String result = HttpUtils.getPostFormDataRespJson(this.url, request.toMap(), dataName, data);
        return StringUtils.isEmpty(result) ? null : JSON.parseObject(result, request.getResponseClass());
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isPost() {
        return isPost;
    }

    public void setPost(boolean post) {
        isPost = post;
    }
}
