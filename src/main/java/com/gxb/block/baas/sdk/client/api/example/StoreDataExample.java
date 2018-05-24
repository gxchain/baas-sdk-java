package com.gxb.block.baas.sdk.client.api.example;

import com.alibaba.fastjson.JSON;
import com.gxb.block.baas.sdk.client.api.BaasApiException;
import com.gxb.block.baas.sdk.client.api.BaasClient;
import com.gxb.block.baas.sdk.client.api.BaasDefaultClient;
import com.gxb.block.baas.sdk.client.api.client.StoreDataClient;
import com.gxb.block.baas.sdk.client.api.request.GetStoreDataFeeReq;
import com.gxb.block.baas.sdk.client.api.request.StoreDataReq;
import com.gxb.block.baas.sdk.client.api.response.GetStoreDataFeeResp;
import com.gxb.block.baas.sdk.client.api.response.StoreDataResp;
import com.gxb.block.baas.sdk.client.enums.BaasErrEnum;
import org.apache.commons.io.FileUtils;
import org.springframework.util.DigestUtils;

import java.io.File;
import java.io.IOException;

import static com.gxb.block.baas.sdk.client.api.BaasConstants.*;

/**
 * @Description 存储数据例子
 * @Author Hanawa
 * @Date 2018/3/13
 * @Version 1.0
 */
public class StoreDataExample {

    public static void main(String[] args) throws BaasApiException {
        StoreDataClient client = new StoreDataClient(EXAMPLE_ACCOUNT, EXAMPLE_PRIVATE_KEY, EXAMPLE_PUBLIC_KEY, true, URL_HEADER);
        System.out.println(JSON.toJSONString(client.storeString("Hello World!")));
    }
}
