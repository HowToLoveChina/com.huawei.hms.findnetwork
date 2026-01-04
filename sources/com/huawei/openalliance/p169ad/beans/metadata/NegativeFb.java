package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes8.dex */
public class NegativeFb implements Serializable {
    private static final long serialVersionUID = 30456300;

    /* renamed from: id */
    private long f32011id;
    private String label;
    private int type;

    /* renamed from: a */
    public long m40353a() {
        return this.f32011id;
    }

    /* renamed from: b */
    public String m40357b() {
        return this.label;
    }

    /* renamed from: c */
    public int m40358c() {
        return this.type;
    }

    /* renamed from: a */
    public void m40354a(int i10) {
        this.type = i10;
    }

    /* renamed from: a */
    public void m40355a(long j10) {
        this.f32011id = j10;
    }

    /* renamed from: a */
    public void m40356a(String str) {
        this.label = str;
    }
}
