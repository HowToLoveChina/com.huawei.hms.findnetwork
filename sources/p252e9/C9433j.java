package p252e9;

import android.content.Context;
import p015ak.C0213f;
import p514o9.C11828b;

/* renamed from: e9.j */
/* loaded from: classes3.dex */
public class C9433j {

    /* renamed from: b */
    public static C9433j f47133b = new C9433j();

    /* renamed from: a */
    public C11828b f47134a;

    /* renamed from: a */
    public static String m59163a() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return "";
        }
        return contextM1377a.getFilesDir() + "/gradeImageCache/";
    }

    /* renamed from: c */
    public static C9433j m59164c() {
        return f47133b;
    }

    /* renamed from: b */
    public C11828b m59165b() {
        if (this.f47134a == null) {
            this.f47134a = new C11828b(m59163a());
        }
        return this.f47134a;
    }
}
