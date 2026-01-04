package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* renamed from: com.huawei.hms.base.log.c */
/* loaded from: classes8.dex */
public class C5131c implements InterfaceC5132d {

    /* renamed from: a */
    private InterfaceC5132d f23394a;

    @Override // com.huawei.hms.base.log.InterfaceC5132d
    /* renamed from: a */
    public void mo30612a(Context context, String str) {
        InterfaceC5132d interfaceC5132d = this.f23394a;
        if (interfaceC5132d != null) {
            interfaceC5132d.mo30612a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.InterfaceC5132d
    /* renamed from: a */
    public void mo30613a(InterfaceC5132d interfaceC5132d) {
        this.f23394a = interfaceC5132d;
    }

    @Override // com.huawei.hms.base.log.InterfaceC5132d
    /* renamed from: a */
    public void mo30614a(String str, int i10, String str2, String str3) {
        Log.println(i10, "HMSSDK_" + str2, str3);
        InterfaceC5132d interfaceC5132d = this.f23394a;
        if (interfaceC5132d != null) {
            interfaceC5132d.mo30614a(str, i10, str2, str3);
        }
    }
}
