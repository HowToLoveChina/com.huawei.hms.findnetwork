package com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6932d;
import java.io.Serializable;

@DataKeep
/* loaded from: classes8.dex */
public class Image implements Serializable {
    private static final long serialVersionUID = -8414679420743760437L;

    @InterfaceC6932d(m39225a = "Ext")
    private ImageExt ext;

    @InterfaceC6932d(m39225a = "H")
    private int height;
    private String localPath;
    private String url;

    @InterfaceC6932d(m39225a = "W")
    private int width;

    /* renamed from: a */
    public String m40573a() {
        return this.url;
    }

    /* renamed from: b */
    public int m40577b() {
        return this.width;
    }

    /* renamed from: c */
    public int m40580c() {
        return this.height;
    }

    /* renamed from: d */
    public ImageExt m40581d() {
        return this.ext;
    }

    /* renamed from: e */
    public String m40582e() {
        return this.localPath;
    }

    /* renamed from: a */
    public void m40574a(int i10) {
        this.width = i10;
    }

    /* renamed from: b */
    public void m40578b(int i10) {
        this.height = i10;
    }

    /* renamed from: a */
    public void m40575a(ImageExt imageExt) {
        this.ext = imageExt;
    }

    /* renamed from: b */
    public void m40579b(String str) {
        this.localPath = str;
    }

    /* renamed from: a */
    public void m40576a(String str) {
        this.url = str;
    }
}
