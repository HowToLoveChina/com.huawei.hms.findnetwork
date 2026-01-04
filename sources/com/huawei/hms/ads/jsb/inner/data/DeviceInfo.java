package com.huawei.hms.ads.jsb.inner.data;

import com.huawei.openalliance.p169ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes8.dex */
public class DeviceInfo {
    private String i18n;
    private boolean isChina;
    private String language;

    /* renamed from: a */
    public void m30365a(String str) {
        this.language = str;
    }

    /* renamed from: b */
    public void m30367b(String str) {
        this.i18n = str;
    }

    /* renamed from: a */
    public void m30366a(boolean z10) {
        this.isChina = z10;
    }
}
