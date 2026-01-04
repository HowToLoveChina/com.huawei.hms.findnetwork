package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import java.io.Serializable;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class Monitor implements Serializable {
    private static final long serialVersionUID = -478373722166817617L;
    private String eventType;
    private int retryFlag = 1;

    @InterfaceC6929a
    private List<String> url;

    /* renamed from: a */
    public String m40347a() {
        return this.eventType;
    }

    /* renamed from: b */
    public List<String> m40351b() {
        return this.url;
    }

    /* renamed from: c */
    public int m40352c() {
        return this.retryFlag;
    }

    /* renamed from: a */
    public void m40348a(int i10) {
        this.retryFlag = i10;
    }

    /* renamed from: a */
    public void m40349a(String str) {
        this.eventType = str;
    }

    /* renamed from: a */
    public void m40350a(List<String> list) {
        this.url = list;
    }
}
