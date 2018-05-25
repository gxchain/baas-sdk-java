# Introduction

This is a Java project.
If you just enjoy the BaaS service. you can go to [BaaS API](https://doc.gxb.io/gxchain/api/baas-api.html).


# Storage Usage

## store String/File/byte[]

```js
// build store client
// 构建存储客户端
// EXAMPLE_ACCOUNT is your account id
// EXAMPLE_PRIVATE_KEY is your account private key
// EXAMPLE_PUBLIC_KEY is your account public key
// * Attention: Your EXAMPLE_PRIVATE_KEY and EXAMPLE_PUBLIC_KEY can not be uploaded.
StoreClient client = new StoreClient(EXAMPLE_ACCOUNT, EXAMPLE_PRIVATE_KEY, EXAMPLE_PUBLIC_KEY, false);
// response
// 获取返回
// byte[]
StoreDataResp resp = client.store("Hello GXChain!".getBytes());
// String
StoreDataResp respString = client.storeString("Hello GXChain!");
// File
StoreDataResp respFile = client.storeFile(new File(FILE_PATH));
```

You can get more from **com.gxb.block.baas.sdk.client.api.client.StoreClient**.

## get upload file/string/byte[]

```js
StoreClient client = new StoreClient(EXAMPLE_ACCOUNT, EXAMPLE_PRIVATE_KEY, EXAMPLE_PUBLIC_KEY, false);
// File 
File file = client.downloadFile(CID,FILE_PATH);
// String
String str = client.getRawString(CID);
// byte[]
byte[] bytes = client.getRawBytes(CID);
```

# Dev Documents

https://doc.gxb.io/gxchain/api/baas-api.html
