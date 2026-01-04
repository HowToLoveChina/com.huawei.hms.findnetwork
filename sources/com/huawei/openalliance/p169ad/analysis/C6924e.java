package com.huawei.openalliance.p169ad.analysis;

import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;

/* renamed from: com.huawei.openalliance.ad.analysis.e */
/* loaded from: classes8.dex */
public class C6924e {

    /* renamed from: a */
    private int f31968a;

    /* renamed from: b */
    private ContentRecord f31969b;

    /* renamed from: c */
    private AppInfo f31970c;

    /* renamed from: d */
    private AppDownloadTask f31971d;

    /* renamed from: e */
    private boolean f31972e;

    public C6924e(int i10) {
        this.f31968a = i10;
    }

    /* renamed from: a */
    public int m39140a() {
        return this.f31968a;
    }

    /* renamed from: b */
    public AppInfo m39145b() {
        return this.f31970c;
    }

    /* renamed from: c */
    public ContentRecord m39146c() {
        return this.f31969b;
    }

    /* renamed from: d */
    public AppDownloadTask m39147d() {
        return this.f31971d;
    }

    /* renamed from: e */
    public boolean m39148e() {
        return this.f31972e;
    }

    /* renamed from: a */
    public void m39141a(ContentRecord contentRecord) {
        this.f31969b = contentRecord;
    }

    /* renamed from: a */
    public void m39142a(AppDownloadTask appDownloadTask) {
        this.f31971d = appDownloadTask;
    }

    /* renamed from: a */
    public void m39143a(AppInfo appInfo) {
        this.f31970c = appInfo;
    }

    /* renamed from: a */
    public void m39144a(boolean z10) {
        this.f31972e = z10;
    }
}
