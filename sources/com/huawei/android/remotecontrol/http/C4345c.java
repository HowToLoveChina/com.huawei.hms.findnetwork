package com.huawei.android.remotecontrol.http;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import fk.C9721b;
import p809yg.C13981a;
import ro.C12612a;

/* renamed from: com.huawei.android.remotecontrol.http.c */
/* loaded from: classes4.dex */
public class C4345c {

    /* renamed from: a */
    public String f19825a;

    /* renamed from: b */
    public Handler.Callback f19826b;

    /* renamed from: c */
    public Context f19827c;

    /* renamed from: d */
    public String f19828d;

    /* renamed from: e */
    public String f19829e;

    /* renamed from: f */
    public int f19830f;

    public C4345c(String str, Handler.Callback callback, Context context, String str2, String str3, int i10) {
        this.f19825a = str;
        this.f19826b = callback;
        this.f19827c = context;
        this.f19828d = str2;
        this.f19829e = str3;
        this.f19830f = i10;
    }

    /* renamed from: a */
    public final void m26219a() {
        Message messageObtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("result", String.valueOf(-100));
        bundle.putString("requestInfo", this.f19825a);
        messageObtain.setData(bundle);
        Handler.Callback callback = this.f19826b;
        if (callback != null) {
            callback.handleMessage(messageObtain);
        }
    }

    /* renamed from: b */
    public final boolean m26220b() {
        String str = this.f19828d;
        if (str == null || str.isEmpty()) {
            C13981a.m83988e("HttpConnectionHelper", "url is invalid");
            return false;
        }
        if (str.startsWith("https://")) {
            return true;
        }
        C13981a.m83988e("HttpConnectionHelper", "url is invalid");
        return false;
    }

    /* renamed from: c */
    public void m26221c(C4348f c4348f) {
        if (!m26220b()) {
            C13981a.m83988e("HttpConnectionHelper", "runHttpsRequest，param error");
            return;
        }
        try {
            C13981a.m83989i("HttpConnectionHelper", "PhoneFinder request, x-hw-trace-id = " + this.f19829e + ", reqEvent: " + this.f19830f);
            if (c4348f == null) {
                c4348f = new C4348f(this.f19827c, "", this.f19829e, this.f19825a, this.f19830f);
            }
            String str = (String) C12612a.m76107g(this.f19828d, c4348f, null);
            Message messageObtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putString("result", "200");
            bundle.putString("requestInfo", this.f19825a);
            bundle.putString("response_info", str);
            bundle.putString("access_token", c4348f.m26241a());
            messageObtain.setData(bundle);
            Handler.Callback callback = this.f19826b;
            if (callback != null) {
                callback.handleMessage(messageObtain);
            }
        } catch (C9721b e10) {
            C13981a.m83988e("HttpConnectionHelper", "CException, code:" + e10.m60659c() + " status" + e10.m60663g() + " message:" + e10.getMessage());
            m26219a();
        }
    }
}
