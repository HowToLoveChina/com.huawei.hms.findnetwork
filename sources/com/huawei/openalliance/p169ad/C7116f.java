package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;

/* renamed from: com.huawei.openalliance.ad.f */
/* loaded from: classes8.dex */
public class C7116f {

    /* renamed from: a */
    protected String f32764a;

    /* renamed from: b */
    protected Context f32765b;

    /* renamed from: c */
    protected String f32766c;

    /* renamed from: d */
    protected InterfaceC7135fs f32767d;

    /* renamed from: e */
    protected InterfaceC7135fs f32768e;

    /* renamed from: f */
    protected InterfaceC7137fu f32769f;

    /* renamed from: g */
    protected RemoteCallResultCallback<String> f32770g;

    /* renamed from: h */
    protected boolean f32771h;

    public C7116f(Context context, RemoteCallResultCallback<String> remoteCallResultCallback, String str) {
        this.f32771h = false;
        this.f32765b = context;
        this.f32770g = remoteCallResultCallback;
        this.f32766c = str;
        this.f32767d = C7103es.m43094a(context);
        this.f32768e = C7104et.m43127b(context);
        this.f32769f = C7106ev.m43144a(context);
        this.f32771h = true;
    }

    public C7116f(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback, String str2) {
        this.f32771h = false;
        this.f32764a = str;
        this.f32765b = context;
        this.f32770g = remoteCallResultCallback;
        this.f32766c = str2;
        this.f32767d = C7103es.m43094a(context);
        this.f32768e = C7104et.m43127b(context);
        this.f32769f = C7106ev.m43144a(context);
    }
}
