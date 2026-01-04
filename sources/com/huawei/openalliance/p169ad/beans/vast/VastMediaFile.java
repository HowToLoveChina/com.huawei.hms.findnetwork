package com.huawei.openalliance.p169ad.beans.vast;

import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;

/* loaded from: classes8.dex */
public class VastMediaFile {
    private String delivery;
    private int height;

    /* renamed from: id */
    private String f32021id;
    private String type;

    @InterfaceC6929a
    private String url;
    private int width;

    /* renamed from: a */
    public String m41034a() {
        return this.type;
    }

    /* renamed from: b */
    public int m41037b() {
        return this.width;
    }

    /* renamed from: c */
    public int m41040c() {
        return this.height;
    }

    /* renamed from: d */
    public String m41042d() {
        return this.url;
    }

    /* renamed from: a */
    public void m41035a(int i10) {
        this.width = i10;
    }

    /* renamed from: b */
    public void m41038b(int i10) {
        this.height = i10;
    }

    /* renamed from: c */
    public void m41041c(String str) {
        this.type = str;
    }

    /* renamed from: d */
    public void m41043d(String str) {
        this.url = str;
    }

    /* renamed from: a */
    public void m41036a(String str) {
        this.f32021id = str;
    }

    /* renamed from: b */
    public void m41039b(String str) {
        this.delivery = str;
    }
}
