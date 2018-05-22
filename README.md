# Introduction

This is a Java project.
If you just enjoy the BaaS service. you can go to [BaaS API](https://doc.gxb.io/gxchain/api/baas-api.html).


# Storage Usage

```java
// The storage fee needs to be called to obtain the rate interface and calculate the value based on the size of the data to be saved. For example: 1.2 KB data cost is 2 * 20 = 40
// 存取费用 需要调用获取费率接口再根据要存数据的大小计算得出该值 eg: 1.2KB的数据费用amount为 2*20=40
Amount amount = Amount.builder().amount(20L).assetId("1.3.1").build();
// raw data
// 原始数据
String data = "123";
// raw data MD5 value
// 数据MD5值
String dataMd5 = DigestUtils.md5DigestAsHex(data.getBytes());
// Your Account YOUR_ACCOUNT_ID Account ID can be obtained by entering account name through the block browser
// 你的账户YOUR_ACCOUNT_ID 可通过区块浏览器输入账户名得到账户id
String from = "YOUR_ACCOUNT_ID";
// Build request body
// 构建请求体
StoreDataReq request = new StoreDataReq();
request.setFrom(YOUR_ACCOUNT_ID);
request.setMemo(dataMd5);
request.setData(dataBytes);
// The cost of access, currently 20, needs to call the get rate interface and calculate the value based on the size of the data to be saved. eg: 1.2KB data cost amount is 2*20=40
// 存取费用,目前为20 需要调用获取费率接口再根据要存数据的大小计算得出该值 eg: 1.2KB的数据费用amount为 2*20=40
request.setAmount(request.calculateAmount(20L));
// Where YOUR_PRIVATE_KEY / YOUR_PUBLIC_KEY is your account's private and public keys, respectively
// 其中YOUR_PRIVATE_KEY / YOUR_PUBLIC_KEY分别为你的帐户对应的私钥和公钥
request.setSignatures(request.sign(YOUR_PRIVATE_KEY,YOUR_PUBLIC_KEY));

// response
// 获取返回
BaasClient baasClient = new BaasDefaultClient(url); // url为请求路径
StoreDataResp resp = baasClient.executeFormData(request,"data",request.getData());
```

You can get more from **com.gxb.block.baas.sdk.client.api.example**.

# Dev Documents

https://doc.gxb.io/gxchain/api/baas-api.html
