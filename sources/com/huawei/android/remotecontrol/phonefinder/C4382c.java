package com.huawei.android.remotecontrol.phonefinder;

import android.content.Context;
import bf.C1175a;
import p520of.C11860j;
import p809yg.C13981a;

/* renamed from: com.huawei.android.remotecontrol.phonefinder.c */
/* loaded from: classes4.dex */
public class C4382c extends AbstractC4380a {

    /* renamed from: d */
    public static final C4382c f20023d = new C4382c();

    /* renamed from: c */
    public String f20024c;

    /* renamed from: d */
    public static C4382c m26442d() {
        return f20023d;
    }

    @Override // com.huawei.android.remotecontrol.phonefinder.AbstractC4380a
    /* renamed from: c */
    public void mo26440c(Context context) {
        C13981a.m83989i("UpdateActivationInfoRetry", "NetworkChangeReceiver release, retry update activation info");
        if (C1175a.m7389k(context)) {
            C11860j.m70996G0(this.f20024c);
        }
    }

    /* renamed from: e */
    public void m26443e(String str) {
        this.f20024c = str;
    }
}
