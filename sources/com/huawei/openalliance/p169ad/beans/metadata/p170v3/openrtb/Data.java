package com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes8.dex */
public class Data implements Serializable {
    private static final long serialVersionUID = 98359189956699056L;
    private int len;
    private int type;
    private String value;

    /* renamed from: a */
    public int m40567a() {
        return this.type;
    }

    /* renamed from: b */
    public String m40570b() {
        return this.value;
    }

    /* renamed from: c */
    public int m40572c() {
        return this.len;
    }

    /* renamed from: a */
    public void m40568a(int i10) {
        this.type = i10;
    }

    /* renamed from: b */
    public void m40571b(int i10) {
        this.len = i10;
    }

    /* renamed from: a */
    public void m40569a(String str) {
        this.value = str;
    }
}
