package com.huawei.location.lite.common.http;

import android.content.Context;
import p531or.C11991a;
import p785xr.C13851a;
import tr.C13058b;
import tr.InterfaceC13059c;
import tr.InterfaceC13061e;

/* loaded from: classes8.dex */
public class HttpClientEx {

    /* renamed from: a */
    public final InterfaceC13059c f31369a;

    public HttpClientEx() {
        this(C11991a.m72145a(), new C13058b());
    }

    /* renamed from: a */
    public InterfaceC13061e m38437a(C13851a c13851a) {
        return new SubmitEx(c13851a, this.f31369a);
    }

    public HttpClientEx(Context context) {
        this(context, new C13058b());
    }

    public HttpClientEx(Context context, C13058b c13058b) {
        C6784a c6784a = new C6784a(c13058b, context);
        this.f31369a = c6784a;
        c6784a.init();
    }
}
