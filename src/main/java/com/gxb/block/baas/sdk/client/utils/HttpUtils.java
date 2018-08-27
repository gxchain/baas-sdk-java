package com.gxb.block.baas.sdk.client.utils;

import org.apache.commons.io.FileUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author Hanawa
 * @Date 2018/4/10
 * @Version 1.0
 */
public class HttpUtils {

    private static CloseableHttpClient httpClient = HttpClients.createDefault();

    public static String getPostRespJson(String url, Map<String, String> params) {
        List<NameValuePair> pairs = new ArrayList<>();
        if (null != params) {
            params.forEach((k, v) -> pairs.add(new BasicNameValuePair(k, v)));
        }

        HttpPost httpPost = new HttpPost(url);
        EntityBuilder entityBuilder = EntityBuilder.create();
        entityBuilder.setParameters(pairs);

        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getGetRespJson(String url) {
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            return EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static InputStream getGetFile(String url) {
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            return response.getEntity().getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPostFormDataRespJson(String url, Map<String, String> params, String dataName, byte[] data) {
        HttpPost httpPost = new HttpPost(url);

        MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
        params.forEach(entityBuilder::addTextBody);
        entityBuilder.addBinaryBody(dataName, data);

        httpPost.setEntity(entityBuilder.build());

        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getPostFormDataRespJson(String url, Map<String, String> param, String dataName, File file) {
        try {
            byte[] dataBytes = FileUtils.readFileToByteArray(file);
            return getPostFormDataRespJson(url, param, dataName, dataBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
