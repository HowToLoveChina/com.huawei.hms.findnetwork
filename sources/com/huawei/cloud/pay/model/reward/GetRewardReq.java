package com.huawei.cloud.pay.model.reward;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import p054cj.C1442a;

/* loaded from: classes5.dex */
public class GetRewardReq {
    private Integer count;
    private String cursor;
    private Integer status;
    private String orderby = "effectEndTime";
    private String type = "1";

    public GetRewardReq(String str, Integer num, Integer num2) {
        this.cursor = str;
        this.status = num;
        this.count = num2;
    }

    public Integer getCount() {
        return this.count;
    }

    public String getCursor() {
        return this.cursor;
    }

    public String getOrderBy() {
        return this.orderby;
    }

    public int getStatus() {
        return this.status.intValue();
    }

    public String getType() {
        return this.type;
    }

    public void setCount(Integer num) {
        this.count = num;
    }

    public void setCursor(String str) {
        this.cursor = str;
    }

    public void setOrderBy(String str) {
        this.orderby = str;
    }

    public void setStatus(int i10) {
        this.status = Integer.valueOf(i10);
    }

    public void setType(String str) {
        this.type = str;
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap(5);
        for (Field field : getClass().getDeclaredFields()) {
            try {
                if (Objects.nonNull(field.get(this))) {
                    map.put(field.getName(), field.get(this));
                }
            } catch (Exception e10) {
                C1442a.m8289e("GetRewardReq", "field.get err" + e10.getMessage());
            }
        }
        return map;
    }
}
