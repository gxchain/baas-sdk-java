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

    private static String EXAMPLE_ACCOUNT = "1.2.61";
    private static String EXAMPLE_PUBLIC_KEY = "GXC7B6EzUVAat9adeWX89CQWT6WXyPQJEyQRbrPxpRXDdY1mXm9RH";
    private static String EXAMPLE_PRIVATE_KEY = "5JnDdu5s4jFeQ7Kqovgdcae5t1spodJFPuJzs4Xpd88Grhx8GGV";

    private StoreDataClient storeDataClient = new StoreDataClient(EXAMPLE_ACCOUNT,
            EXAMPLE_PRIVATE_KEY, EXAMPLE_PUBLIC_KEY);

    @Test
    public void store() {
        System.out.println(JSON.toJSONString(storeDataClient.store("Hello GXChain!".getBytes())));
    }

    @Test
    public void getStoreDataReq() {
        System.out.println(storeDataClient.getRawStringData("QmaZrwThXyZm8Rxs93Tih3L6p4Q8NqYEXp32iN4PeAqDgv"));
    }
}
