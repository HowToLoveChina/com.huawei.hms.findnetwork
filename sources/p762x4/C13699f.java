package p762x4;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import p006a5.AbstractC0048c;
import p762x4.AbstractC13696c;

/* renamed from: x4.f */
/* loaded from: classes.dex */
public class C13699f {

    /* renamed from: f */
    public static volatile boolean f61669f = false;

    /* renamed from: a */
    public Context f61670a;

    /* renamed from: b */
    public AbstractC0048c f61671b;

    /* renamed from: c */
    public Handler.Callback f61672c;

    /* renamed from: d */
    public Object f61673d;

    /* renamed from: e */
    public String f61674e;

    public C13699f(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, String str, Object obj) {
        this.f61670a = context;
        this.f61671b = abstractC0048c;
        this.f61672c = callback;
        this.f61674e = str;
        this.f61673d = obj;
    }

    /* renamed from: a */
    public static boolean m82413a() {
        return f61669f;
    }

    /* renamed from: b */
    public void m82414b(int i10, int i11, int i12, Handler.Callback callback, Object obj) {
        if (callback != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = i10;
            messageObtain.arg1 = i11;
            messageObtain.arg2 = i12;
            messageObtain.obj = obj;
            callback.handleMessage(messageObtain);
        }
    }

    /* renamed from: c */
    public void m82415c(AbstractC13696c.a aVar, Handler.Callback callback, Object obj, Bundle bundle) {
        if (callback == null || aVar == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = aVar.m82366a();
        messageObtain.arg1 = aVar.m82367b();
        messageObtain.arg2 = aVar.m82368c();
        messageObtain.obj = obj;
        messageObtain.setData(bundle);
        callback.handleMessage(messageObtain);
    }
}
