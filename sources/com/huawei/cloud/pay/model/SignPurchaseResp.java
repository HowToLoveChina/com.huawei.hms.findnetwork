package com.huawei.cloud.pay.model;

import com.google.gson.JsonObject;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class SignPurchaseResp extends Response implements Serializable {
    private static final long serialVersionUID = 3213641397795898772L;
    private String applicationId;

    /* renamed from: id */
    private String f21417id;
    private Payload payload;
    private Integer priceType;
    private JsonObject reservedInfor;

    public String getApplicationId() {
        return this.applicationId;
    }

    public String getId() {
        return this.f21417id;
    }

    public Payload getPayload() {
        return this.payload;
    }

    public Integer getPriceType() {
        return this.priceType;
    }

    public JsonObject getReservedInfor() {
        return this.reservedInfor;
    }

    public void setApplicationId(String str) {
        this.applicationId = str;
    }

    public void setId(String str) {
        this.f21417id = str;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public void setPriceType(Integer num) {
        this.priceType = num;
    }

    public void setReservedInfor(JsonObject jsonObject) {
        this.reservedInfor = jsonObject;
    }
}
