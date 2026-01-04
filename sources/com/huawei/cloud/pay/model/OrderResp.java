package com.huawei.cloud.pay.model;

import java.util.List;

/* loaded from: classes5.dex */
public class OrderResp extends Response {
    private List<Order> orders;

    public List<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(List<Order> list) {
        this.orders = list;
    }
}
