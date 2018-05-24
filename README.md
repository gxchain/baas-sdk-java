# Introduction

This is a Java project.
If you just enjoy the BaaS service. you can go to [BaaS API](https://doc.gxb.io/gxchain/api/baas-api.html).


# Storage Usage

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
StoreDataResp resp = client.store("Hello World!".getBytes());
```

You can get more from **com.gxb.block.baas.sdk.client.api.client.StoreClient**.

# Dev Documents

https://doc.gxb.io/gxchain/api/baas-api.html
