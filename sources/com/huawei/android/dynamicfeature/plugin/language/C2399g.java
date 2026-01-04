package com.huawei.android.dynamicfeature.plugin.language;

import android.content.Context;
import android.content.Intent;
import p250e7.C9419a;

/* renamed from: com.huawei.android.dynamicfeature.plugin.language.g */
/* loaded from: classes2.dex */
public class C2399g {

    /* renamed from: a */
    public static final String f11483a = "g";

    /* renamed from: com.huawei.android.dynamicfeature.plugin.language.g$a */
    public static class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f11484a;

        public a(Context context) {
            this.f11484a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            new LanguageInstaller(this.f11484a).m14975j();
        }
    }

    /* renamed from: a */
    public static void m15001a(Context context, Intent intent) {
        if (context == null) {
            return;
        }
        C9419a.m59080f(f11483a, "LocaleChangedReceiverMethodProvied received locale changed. app is " + context.getPackageName());
        C2397e.m14993a().execute(new a(context));
    }
}
