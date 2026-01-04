package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;

/* renamed from: com.huawei.openalliance.ad.do */
/* loaded from: classes8.dex */
public abstract class AbstractC7026do {

    /* renamed from: a */
    private Context f32236a;

    /* renamed from: b */
    private a f32237b;

    /* renamed from: com.huawei.openalliance.ad.do$a */
    public interface a {
        /* renamed from: a */
        void mo42028a(AppInfo appInfo);

        /* renamed from: b */
        void mo42029b(AppInfo appInfo);

        /* renamed from: c */
        void mo42030c(AppInfo appInfo);
    }

    public AbstractC7026do(Context context) {
        this.f32236a = context;
    }

    /* renamed from: a */
    public Context m42022a() {
        return this.f32236a;
    }

    /* renamed from: a */
    public abstract void mo42025a(AppInfo appInfo, ContentRecord contentRecord, long j10);

    /* renamed from: b */
    public void m42026b(AppInfo appInfo) {
        a aVar = this.f32237b;
        if (aVar != null) {
            aVar.mo42029b(appInfo);
        }
    }

    /* renamed from: c */
    public void m42027c(AppInfo appInfo) {
        a aVar = this.f32237b;
        if (aVar != null) {
            aVar.mo42030c(appInfo);
        }
    }

    /* renamed from: a */
    public void m42023a(a aVar) {
        this.f32237b = aVar;
    }

    /* renamed from: a */
    public void m42024a(AppInfo appInfo) {
        a aVar = this.f32237b;
        if (aVar != null) {
            aVar.mo42028a(appInfo);
        }
    }
}
