package com.huawei.hms.base.log;

import android.content.Context;
import com.huawei.hms.support.log.HMSExtLogger;

/* renamed from: com.huawei.hms.base.log.a */
/* loaded from: classes8.dex */
public class C5129a implements InterfaceC5132d {

    /* renamed from: a */
    private final HMSExtLogger f23389a;

    /* renamed from: b */
    private InterfaceC5132d f23390b;

    public C5129a(HMSExtLogger hMSExtLogger) {
        this.f23389a = hMSExtLogger;
    }

    @Override // com.huawei.hms.base.log.InterfaceC5132d
    /* renamed from: a */
    public void mo30612a(Context context, String str) {
        InterfaceC5132d interfaceC5132d = this.f23390b;
        if (interfaceC5132d != null) {
            interfaceC5132d.mo30612a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.InterfaceC5132d
    /* renamed from: a */
    public void mo30613a(InterfaceC5132d interfaceC5132d) {
        this.f23390b = interfaceC5132d;
    }

    @Override // com.huawei.hms.base.log.InterfaceC5132d
    /* renamed from: a */
    public void mo30614a(String str, int i10, String str2, String str3) {
        HMSExtLogger hMSExtLogger = this.f23389a;
        if (hMSExtLogger != null) {
            if (i10 == 3) {
                hMSExtLogger.m36978d(str2, str3);
            } else if (i10 == 4) {
                hMSExtLogger.m36980i(str2, str3);
            } else if (i10 != 5) {
                hMSExtLogger.m36979e(str2, str3);
            } else {
                hMSExtLogger.m36981w(str2, str3);
            }
        }
        InterfaceC5132d interfaceC5132d = this.f23390b;
        if (interfaceC5132d != null) {
            interfaceC5132d.mo30614a(str, i10, str2, str3);
        }
    }
}
