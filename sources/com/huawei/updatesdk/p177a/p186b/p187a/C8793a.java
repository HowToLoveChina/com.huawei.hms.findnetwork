package com.huawei.updatesdk.p177a.p186b.p187a;

import android.content.Context;

/* renamed from: com.huawei.updatesdk.a.b.a.a */
/* loaded from: classes9.dex */
public class C8793a {

    /* renamed from: b */
    private static final Object f45101b = new Object();

    /* renamed from: c */
    private static volatile C8793a f45102c;

    /* renamed from: a */
    private final Context f45103a;

    private C8793a(Context context) {
        this.f45103a = context.getApplicationContext();
    }

    /* renamed from: c */
    public static C8793a m56132c() {
        return f45102c;
    }

    /* renamed from: a */
    public Context m56133a() {
        return this.f45103a;
    }

    /* renamed from: b */
    public String m56134b() {
        Context context = this.f45103a;
        return (context == null || context.getFilesDir() == null) ? "" : this.f45103a.getFilesDir().getAbsolutePath();
    }

    /* renamed from: a */
    public static void m56131a(Context context) {
        if (f45102c == null) {
            synchronized (f45101b) {
                try {
                    if (f45102c == null) {
                        f45102c = new C8793a(context);
                    }
                } finally {
                }
            }
        }
    }
}
