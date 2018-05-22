package com.gxb.block.baas.sdk.client.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description 通用的支付资产model
 * @Author Hanawa
 * @Date 2018/3/12
 * @Version 1.0
 */
@Data @Builder @AllArgsConstructor @NoArgsConstructor public class Amount implements Serializable {
    private static final long serialVersionUID = -7981551583853222205L;
    @JSONField(name = "asset_id")
    private String assetId;
    private Long amount;
}
