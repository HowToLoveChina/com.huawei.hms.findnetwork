package com.huawei.openalliance.p169ad.beans.vast;

import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;

/* loaded from: classes8.dex */
public class VastIcon {
    private int height;

    @InterfaceC6929a
    private String htmlResource;

    @InterfaceC6929a
    private String iconIframRes;
    private String program;
    private StaticResource staticResource;
    private int width;
    private String xPos;
    private String yPos;

    /* renamed from: a */
    public int m41023a() {
        return this.height;
    }

    /* renamed from: b */
    public int m41027b() {
        return this.width;
    }

    /* renamed from: c */
    public StaticResource m41030c() {
        return this.staticResource;
    }

    /* renamed from: d */
    public void m41032d(String str) {
        this.iconIframRes = str;
    }

    /* renamed from: e */
    public void m41033e(String str) {
        this.htmlResource = str;
    }

    /* renamed from: a */
    public void m41024a(int i10) {
        this.height = i10;
    }

    /* renamed from: b */
    public void m41028b(int i10) {
        this.width = i10;
    }

    /* renamed from: c */
    public void m41031c(String str) {
        this.yPos = str;
    }

    /* renamed from: a */
    public void m41025a(StaticResource staticResource) {
        this.staticResource = staticResource;
    }

    /* renamed from: b */
    public void m41029b(String str) {
        this.xPos = str;
    }

    /* renamed from: a */
    public void m41026a(String str) {
        this.program = str;
    }
}
