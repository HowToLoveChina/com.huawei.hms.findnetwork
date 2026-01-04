package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;

@DataKeep
/* loaded from: classes8.dex */
public class ShareInfo {
    private String description;

    @InterfaceC6929a
    private String iconUrl;

    @InterfaceC6929a
    private String shareUrl;
    private String title;

    /* renamed from: a */
    public String m40442a() {
        return this.iconUrl;
    }

    /* renamed from: b */
    public String m40444b() {
        return this.title;
    }

    /* renamed from: c */
    public String m40446c() {
        return this.description;
    }

    /* renamed from: d */
    public String m40448d() {
        return this.shareUrl;
    }

    /* renamed from: a */
    public void m40443a(String str) {
        this.iconUrl = str;
    }

    /* renamed from: b */
    public void m40445b(String str) {
        this.title = str;
    }

    /* renamed from: c */
    public void m40447c(String str) {
        this.description = str;
    }

    /* renamed from: d */
    public void m40449d(String str) {
        this.shareUrl = str;
    }
}
