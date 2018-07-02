package com.gxb.block.baas.sdk.client.api.client;

import com.alibaba.fastjson.JSON;
import com.gxb.block.baas.sdk.client.api.BaasApiException;
import com.gxb.block.baas.sdk.client.api.BaasConstants;
import com.gxb.block.baas.sdk.client.api.BaasDefaultClient;
import com.gxb.block.baas.sdk.client.api.request.StoreDataReq;
import com.gxb.block.baas.sdk.client.api.response.ProviderResp;
import com.gxb.block.baas.sdk.client.api.response.StoreDataResp;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

import java.io.File;
import java.io.IOException;

import static com.gxb.block.baas.sdk.client.api.BaasConstants.ASSET_ID_GXS;
import static com.gxb.block.baas.sdk.client.api.BaasConstants.KBYTE_NUM;

/**
 * @Description
 * @Author Hanawa
 * @Date 2018/5/24
 * @Version 1.0
 */
public class StoreDataClient extends BaasDefaultClient {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String STORE_URL = "storage/store";
    //    private static final String STORE_FEE_URL = "storeFee";// 1.0.0-RELEASE
    private static final String STORE_FEE_URL = "storage/store/fee"; // 1.0.1-RELEASE
    private static final String GET_DATA_URL_BODY = "storage/data/";
    private final int percent = 0;

    private String priKey;
    private String pubKey;
    private String accountId;
    private String urlHeader;
    private boolean isDev;
    private String assetId = BaasConstants.ASSET_ID_GXS;
    private String baasAccountId;
    private String baasAccountDevId;
    private Integer feePerKByte;

    public StoreDataClient(String accountId, String priKey, String pubKey) {
        this(accountId, priKey, pubKey, false);
    }

    public StoreDataClient(String accountId, String priKey, String pubKey, boolean isDev) {
        this(accountId, priKey, pubKey, isDev, isDev ? BaasConstants.URL_DEVELOPER_HEADER :
                BaasConstants.URL_HEADER);
    }

    public StoreDataClient(String accountId, String priKey, String pubKey, boolean isDev, String urlHeader) {
        this.accountId = accountId;
        this.priKey = priKey;
        this.pubKey = pubKey;
        this.urlHeader = urlHeader;
        this.isDev = isDev;
        init();
    }


    /**
     * 上传String
     *
     * @param rawString 原始String
     * @return
     */
    public StoreDataResp storeString(String rawString) {
        return this.store(rawString.getBytes());
    }

    /**
     * 上传文件
     *
     * @param rawFile 原始文件
     * @return
     */
    public StoreDataResp storeFile(File rawFile) {
        try {
            return this.store(FileUtils.readFileToByteArray(rawFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 上传数据
     *
     * @param rawData 数据bytes
     * @return
     */
    public StoreDataResp store(byte[] rawData) {
        try {
            StoreDataReq storeDataReq = new StoreDataReq();

            // md5
            String memo = DigestUtils.md5DigestAsHex(rawData);

            storeDataReq.setFrom(accountId);
            storeDataReq.setTo(this.isDev ? baasAccountDevId : baasAccountId);
            storeDataReq.setProxyAccount(this.isDev ? baasAccountDevId : baasAccountId);
            storeDataReq.setData(rawData);
            storeDataReq.setAmount(calculateAmount(rawData, this.feePerKByte));
            storeDataReq.setMemo(memo);
            storeDataReq.setPercent(this.percent);
            storeDataReq.setAssetId(this.assetId);

            // sign
            String sign = storeDataReq.sign(this.priKey, this.pubKey);

            storeDataReq.setSignatures(sign);

            logger.info("请求参数为:{}", JSON.toJSONString(storeDataReq));
            this.setUrl(this.urlHeader + STORE_URL);
            return this.executeFormData(storeDataReq, "data", rawData);

        } catch (BaasApiException e) {
            logger.info(e.getMessage(), e);
        }

        return null;
    }

    /**
     * 获取已存储的Buffer
     *
     * @param cid
     * @return
     */
    public byte[] getRawBytes(String cid) {
        try {
            this.setUrl(this.urlHeader + GET_DATA_URL_BODY + cid);
            return IOUtils.toByteArray(this.download());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取已存储的数据
     *
     * @param cid 存进ipfs的cid值
     * @return
     */
    public String getRawStringData(String cid) {
        try {
            return this.execute(this.urlHeader + GET_DATA_URL_BODY + cid);
        } catch (BaasApiException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 获取已存储的文件
     *
     * @param cid        存进ipfs的cid值
     * @param targetFile 要下载到的文件
     */
    public void downloadFile(String cid, File targetFile) {
        try {
            this.setUrl(this.urlHeader + GET_DATA_URL_BODY + cid);
            FileUtils.copyInputStreamToFile(this.download(), targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Long calculateAmount(byte[] data, Integer feeKByte) {
        long f = data.length / KBYTE_NUM * feeKByte;
        return data.length % KBYTE_NUM == 0 ? f : f + feeKByte;
    }

    private void init() {
        ProviderResp provider = BaasConstants.getProvider();
        if (null == provider || null == provider.getData()) {
            this.baasAccountId = BaasConstants.BAAS_ACCOUNT;
            this.baasAccountDevId = BaasConstants.BAAS_DEV_ACCOUNT;
            this.feePerKByte = BaasConstants.FEE_PER_KBYTE;
        } else {
            this.baasAccountId = provider.getData().getBaasAccountId();
            this.baasAccountDevId = provider.getData().getBaasAccountDevId();
            this.feePerKByte = provider.getData().getFees().stream().filter(a -> ASSET_ID_GXS.equals(a.getAssetId())).findAny().map(ProviderResp.Fee::getFeePerKBytes).orElse(BaasConstants.FEE_PER_KBYTE);
        }
    }


}
