package com.huawei.android.remotecontrol.phonefinder;

import android.content.Context;
import bf.C1175a;
import p520of.C11860j;
import p809yg.C13981a;

/* renamed from: com.huawei.android.remotecontrol.phonefinder.b */
/* loaded from: classes4.dex */
public class C4381b extends AbstractC4380a {

    /* renamed from: c */
    public static final C4381b f20022c = new C4381b();

    /* renamed from: d */
    public static C4381b m26441d() {
        return f20022c;
    }

    @Override // com.huawei.android.remotecontrol.phonefinder.AbstractC4380a
    /* renamed from: c */
    public void mo26440c(Context context) {
        C13981a.m83989i("PhonefinderDeRegistionRetry", "NetworkChangeReceiver release, retry phoneFinder deRegistration");
        if (C1175a.m7389k(context)) {
            return;
        }
        C11860j.m71014P0(context);
    }
}
