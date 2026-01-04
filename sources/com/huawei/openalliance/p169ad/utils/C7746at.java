package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;

/* renamed from: com.huawei.openalliance.ad.utils.at */
/* loaded from: classes2.dex */
public class C7746at {

    /* renamed from: a */
    private static final String f35841a = "com.huawei.openalliance.ad.utils.at";

    /* renamed from: b */
    private final Context f35842b;

    /* renamed from: c */
    private final AppInfo f35843c;

    /* renamed from: com.huawei.openalliance.ad.utils.at$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7741ao.m47550a(C7746at.this.f35842b, C7746at.this.f35843c.getPrivacyLink());
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.at$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7741ao.m47550a(C7746at.this.f35842b, C7746at.this.f35843c.getPermissionUrl());
        }
    }

    public C7746at(Context context, AppInfo appInfo) {
        this.f35842b = context;
        this.f35843c = appInfo;
    }

    @JavascriptInterface
    public void showPageDetail(int i10) {
        AbstractC7185ho.m43820b(f35841a, "show page details type:" + i10);
        if (i10 == 1) {
            m47606a();
        } else {
            if (i10 != 2) {
                return;
            }
            m47608b();
        }
    }

    /* renamed from: a */
    private void m47606a() {
        String str = f35841a;
        AbstractC7185ho.m43820b(str, "load privacyUrl start.");
        AppInfo appInfo = this.f35843c;
        if (appInfo == null || TextUtils.isEmpty(appInfo.getPrivacyLink())) {
            AbstractC7185ho.m43820b(str, "load privacy url is empty.");
        } else {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.at.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbstractC7741ao.m47550a(C7746at.this.f35842b, C7746at.this.f35843c.getPrivacyLink());
                }
            });
        }
    }

    /* renamed from: b */
    private void m47608b() {
        String str = f35841a;
        AbstractC7185ho.m43820b(str, "load permissionUrl start.");
        AppInfo appInfo = this.f35843c;
        if (appInfo == null || TextUtils.isEmpty(appInfo.getPermissionUrl())) {
            AbstractC7185ho.m43820b(str, "load permission url is empty.");
        } else {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.at.2
                public AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbstractC7741ao.m47550a(C7746at.this.f35842b, C7746at.this.f35843c.getPermissionUrl());
                }
            });
        }
    }
}
