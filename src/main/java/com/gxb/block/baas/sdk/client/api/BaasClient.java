package com.gxb.block.baas.sdk.client.api;

import java.io.File;
import java.io.InputStream;

/**
 * @Author Hanawa
 * @Date 2018/3/2
 * @Version 1.0
 */
public interface BaasClient {
    <T extends BaasResponse> T execute(BaasRequest<T> request) throws BaasApiException;

    <T extends BaasResponse> T executeFormData(BaasRequest<T> request, String dataName,byte[] data) throws BaasApiException;

    <T extends BaasResponse> T executeFormData(BaasRequest<T> request, String dataName,File data) throws BaasApiException;

    InputStream download();
}
