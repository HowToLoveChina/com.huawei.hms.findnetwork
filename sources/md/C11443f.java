package md;

import android.os.Bundle;
import android.os.Message;

/* renamed from: md.f */
/* loaded from: classes3.dex */
public class C11443f {

    /* renamed from: a */
    public Message f53312a;

    public C11443f(Message message) {
        this.f53312a = message;
    }

    /* renamed from: b */
    public static C11443f m68551b() {
        return new C11443f(Message.obtain());
    }

    /* renamed from: a */
    public Message m68552a() {
        return this.f53312a;
    }

    /* renamed from: c */
    public void m68553c(Bundle bundle) {
        this.f53312a.setData(bundle);
    }

    /* renamed from: d */
    public void m68554d(int i10) {
        this.f53312a.arg2 = i10;
    }

    /* renamed from: e */
    public void m68555e(int i10) {
        this.f53312a.what = i10;
    }

    /* renamed from: f */
    public void m68556f(int i10) {
        this.f53312a.arg1 = i10;
    }
}
