package com.huawei.openalliance.p169ad.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ViewGroup;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;

/* renamed from: com.huawei.openalliance.ad.activity.e */
/* loaded from: classes8.dex */
public abstract class AbstractActivityC6905e extends AbstractActivityC6906f {

    /* renamed from: p */
    protected ViewGroup f31812p;

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    private void m38788b() {
        AbstractC7811dd.m48295a(this.f31812p, this);
    }

    /* renamed from: a */
    public abstract void mo38587a();

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) {
        StringBuilder sb2;
        super.onCreate(bundle);
        try {
            mo38587a();
            m38788b();
        } catch (Exception e10) {
            e = e10;
            sb2 = new StringBuilder();
            sb2.append("error occurs,");
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("PPSBaseActivity", sb2.toString());
            AbstractC7185ho.m43815a(5, e);
        } catch (Throwable th2) {
            e = th2;
            sb2 = new StringBuilder();
            sb2.append("error occurs,");
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("PPSBaseActivity", sb2.toString());
            AbstractC7185ho.m43815a(5, e);
        }
    }
}
