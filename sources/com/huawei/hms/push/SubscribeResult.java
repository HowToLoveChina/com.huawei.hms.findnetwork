package com.huawei.hms.push;

import com.huawei.hms.push.notification.SubscribedItem;
import com.huawei.hms.support.api.client.Result;
import java.util.List;

/* loaded from: classes8.dex */
public class SubscribeResult extends Result {

    /* renamed from: a */
    private String f29661a;

    /* renamed from: b */
    private List<SubscribedItem> f29662b;

    public String getErrorMsg() {
        return this.f29661a;
    }

    public List<SubscribedItem> getSubscribedItems() {
        return this.f29662b;
    }

    public void setErrorMsg(String str) {
        this.f29661a = str;
    }

    public void setSubscribedItems(List<SubscribedItem> list) {
        this.f29662b = list;
    }
}
