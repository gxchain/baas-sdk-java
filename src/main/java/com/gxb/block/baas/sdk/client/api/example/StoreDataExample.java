package com.gxb.block.baas.sdk.client.api.example;

import com.alibaba.fastjson.JSON;
import com.gxb.block.baas.sdk.client.api.BaasApiException;
import com.gxb.block.baas.sdk.client.api.BaasClient;
import com.gxb.block.baas.sdk.client.api.BaasDefaultClient;
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
        //                ExecutorService executorService = Executors.newFixedThreadPool(20);
        //
        //                StringBuilder data = new StringBuilder("alkndlavnoiernv./'po[w20394131-=+_{};'");
        //                for (int i = 0; i < 10000; i++) {
        //                    int finalI = i;
        //                    executorService.execute(()-> {
        //                        try {
        //                            test(data.append(finalI).toString());
        //                        } catch (BaasApiException e) {
        //                            e.printStackTrace();
        //                        }
        //                        System.out.println("执行index:"+finalI);
        //                    });
        //                }
        //                executorService.shutdown();
        //                executorService.awaitTermination(1, TimeUnit.HOURS);
        //                System.out.println(JSON.toJSONString(ApiResult.<String>builder().data("data").build()));

                testString("alkndlavnoiernv./'po[w20394131-=+_{};'");
//        testFile(new File("/Users/hanawa/Desktop/hello.txt"));
        //        test("123");
    }

    public static void testString(String data) throws BaasApiException {
        testStore(data.getBytes());
    }

    public static void testFile(File file) throws BaasApiException {
        try {
            byte[] dataBytes = FileUtils.readFileToByteArray(file);
            testStore(dataBytes);
        } catch (IOException e) {
            throw new BaasApiException(e);
        }
    }

    private static void testStore(byte[] dataBytes) throws BaasApiException{

        long startTime = System.currentTimeMillis();
        String getFeeUrl = EXAMPLE_BAAS_URL + "api/storeFee";
        String storeUrl = EXAMPLE_BAAS_URL + "api/store";

        int length = dataBytes.length;
        String dataMd5 = DigestUtils.md5DigestAsHex(dataBytes);

        GetStoreDataFeeReq feeReq = new GetStoreDataFeeReq();

        BaasClient getFeeClient = new BaasDefaultClient(getFeeUrl, false);

        if (length > 2 * MBYTE_NUM) {
            throw new BaasApiException(BaasErrEnum.STORE_DATA_OVER_SIZE);
        }

        GetStoreDataFeeResp feeResp = getFeeClient.execute(feeReq);
        if (null == feeResp || null == feeResp.getData()) {
            System.out.println("unknow error");
            System.exit(0);
        }

        StoreDataReq request = new StoreDataReq();
        request.setFrom(EXAMPLE_ACCOUNT);
        request.setMemo(dataMd5);
        request.setData(dataBytes);
        request.setAmount(request.calculateAmount(feeResp.getData().getPricePerKByte()));
        request.setSignatures(request.sign(EXAMPLE_PRIVATE_KEY,EXAMPLE_PUBLIC_KEY));

        System.out.println("请求数据：" + JSON.toJSONString(request));

        BaasClient baasClient = new BaasDefaultClient(storeUrl);
        StoreDataResp resp = baasClient.executeFormData(request, "data", request.getData());
        System.out.println("返回结果:" + JSON.toJSONString(resp));
        System.out.println("耗时:" + (System.currentTimeMillis() - startTime) / 1000.0 + " s");

    }
}
