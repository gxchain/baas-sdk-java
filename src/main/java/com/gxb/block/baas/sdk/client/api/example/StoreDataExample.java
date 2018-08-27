package com.gxb.block.baas.sdk.client.api.example;

import com.alibaba.fastjson.JSON;
import com.gxb.block.baas.sdk.client.api.BaasApiException;
import com.gxb.block.baas.sdk.client.api.client.StoreDataClient;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.gxb.block.baas.sdk.client.api.BaasConstants.*;

/**
 * @Description 存储数据例子
 * @Author Hanawa
 * @Date 2018/3/13
 * @Version 1.0
 */
public class StoreDataExample {

    // 该例子为开发者测试环境的测试账号
    private static String EXAMPLE_ACCOUNT = "1.2.61";
    private static String EXAMPLE_PUBLIC_KEY = "GXC7B6EzUVAat9adeWX89CQWT6WXyPQJEyQRbrPxpRXDdY1mXm9RH";
    private static String EXAMPLE_PRIVATE_KEY = "5JnDdu5s4jFeQ7Kqovgdcae5t1spodJFPuJzs4Xpd88Grhx8GGV";
//    private static String EXAMPLE_ACCOUNT = "1.2.393";
//    private static String EXAMPLE_PUBLIC_KEY = "GXC7ENvzqrE8VNTRsucCZ7swsJ8fg6tLtqsKW7QWFQ4DJXRYj4pyK";
//    private static String EXAMPLE_PRIVATE_KEY = "5Hwm6MZ9T8y4XoxqCKq4VhzB9P6LuNWHYpHiHp1c9bD5ssrJLup";
//    private static final String EXAMPLE_PUBLIC_KEY = "GXC8435JoLsmNgEzJBqkSzqfz65isQA1XfTvkGycG5KAdgsq4BhwV";
//    private static final String EXAMPLE_PRIVATE_KEY = "5KAYWd4oGVN6ZMcXej9DB74gqNZhcZP7fWtn2MKoCmsUwzJjQVy";
//    private static final String EXAMPLE_ACCOUNT = "1.2.391";


    public static void main(String[] args) throws BaasApiException {
        StoreDataExample example = new StoreDataExample();
        StoreDataClient client = new StoreDataClient(EXAMPLE_ACCOUNT, EXAMPLE_PRIVATE_KEY, EXAMPLE_PUBLIC_KEY, true);
//		example.loop(client);
        example.println(client);
    }

    private void println(StoreDataClient client) {
        System.out.println(JSON.toJSONString(client.storeString("{\"amount\":20,\"assetId\":\"1.3.1\",\"data\":\"eyJkYXRhS2V5IjoiR1hDOEdqbVM5ZlUydGk1SExpR2hXZ1FZZjJVQmVOV2RkTUVOTGNtZHVjNHhmdTNQTjgyVHkiLCJtZDVDaGVja3N1bSI6Ijc5YjY3OWRjYTUzMDZhZDg1ODE2ODE5ZDAwNDVhMDRlIiwiZGF0YVNpZ24iOiIxZjY4OTUxNDQ1YzdlODA0MzQzZjQyOWQ1MGM0OTYwMTcwNTRhNjVjZjc2ZWEyNGFiMWMxOWZlNDgzMzcwYWI0NmYyNTNiMTNlNTljNmM4M2IwNjZmYjM0NjlmMjQ1ZDk3ZjM3M2IxY2JhYzg3NmJkNjg0NjQzNzZkODZlYTQ4YzNkIiwiZGF0YUNvZGUiOiJibG9ja2NpdHlfbGFiZWwiLCJjb250ZW50IjoiW3tcImxhYmVsXCI6XCJSRUFMTkFNRV9FTEVNRU5UQVJZXCIsXCJ0aW1lXCI6XCIyMDE4LTA3LTE4IDE2OjE4OjM1XCJ9LHtcImxhYmVsXCI6XCJDT05TVEVMTEFUSU9OX0dFTUlOSVwiLFwidGltZVwiOlwiMjAxOC0wNy0xOCAxNjoxODozNVwifSx7XCJsYWJlbFwiOlwiTUlORVJfSlVOSU9SX01JTkVSXCIsXCJ0aW1lXCI6XCIyMDE4LTA3LTE4IDE2OjE4OjM1XCJ9XSJ9\",\"expiration\":1531931896,\"from\":\"1.2.85\",\"memo\":\"30ee426c58ab54b26f16015d05076f9e\",\"percent\":0,\"proxyAccount\":\"1.2.60\",\"signatures\":\"2067701bc948244ad9f7c3b1fca8b7033b18c13bf6ec9a96854af034526235ea501873fee19be9d6968aa39e576beab0503e55ff856ac4116a452591564c5e50fc\",\"to\":\"1.2.60\"}")));
    }

    private void loop(StoreDataClient client) {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 1; i < 100000; i++) {
            if (i % 1000 == 0) {
                try {
                    System.out.println("sleeping...");
                    Thread.sleep(900000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            executorService.submit(() -> new StoreDataExample().println(client));
        }
    }
}
