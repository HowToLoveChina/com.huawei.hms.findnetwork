package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes8.dex */
public class Skip {
    private int height;
    private String textPos;
    private int textSize;

    /* renamed from: a */
    public String m40450a() {
        return this.textPos;
    }

    /* renamed from: b */
    public int m40453b() {
        return this.height;
    }

    /* renamed from: c */
    public int m40455c() {
        return this.textSize;
    }

    /* renamed from: a */
    public void m40451a(int i10) {
        this.height = i10;
    }

    /* renamed from: b */
    public void m40454b(int i10) {
        this.textSize = i10;
    }

    /* renamed from: a */
    public void m40452a(String str) {
        this.textPos = str;
    }
}
