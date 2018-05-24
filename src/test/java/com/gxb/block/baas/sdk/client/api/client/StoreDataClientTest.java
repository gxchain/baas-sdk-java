package com.gxb.block.baas.sdk.client.api.client;

import com.alibaba.fastjson.JSON;
import com.gxb.block.baas.sdk.client.api.BaasConstants;
import org.junit.Test;

import static com.gxb.block.baas.sdk.client.api.BaasConstants.*;
import static org.junit.Assert.*;

/**
 * @Description
 * @Author Hanawa
 * @Date 2018/5/24
 * @Version 1.0
 */
public class StoreDataClientTest {

    private StoreDataClient storeDataClient = new StoreDataClient(EXAMPLE_ACCOUNT,
            EXAMPLE_PRIVATE_KEY, EXAMPLE_PUBLIC_KEY, false, URL_DEVELOPER_HEADER);

    @Test
    public void store() {
        System.out.println(JSON.toJSONString(storeDataClient.store("test".getBytes())));
    }

    @Test
    public void getStoreDataReq() {
        System.out.println(storeDataClient.getStoreDataReq("QmaZrwThXyZm8Rxs93Tih3L6p4Q8NqYEXp32iN4PeAqDgv"));
    }
}
