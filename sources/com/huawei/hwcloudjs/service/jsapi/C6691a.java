package com.huawei.hwcloudjs.service.jsapi;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.huawei.hwcloudjs.p164f.C6659d;
import com.huawei.hwcloudjs.p164f.C6663h;
import com.huawei.hwcloudjs.service.jsapi.bean.BrowserInfo;

/* renamed from: com.huawei.hwcloudjs.service.jsapi.a */
/* loaded from: classes8.dex */
public final class C6691a {

    /* renamed from: a */
    private static final String f31020a = "JsCoreHelper";

    /* renamed from: b */
    private static C6691a f31021b = new C6691a();

    private C6691a() {
    }

    /* renamed from: a */
    public static C6691a m37993a() {
        return f31021b;
    }

    /* renamed from: a */
    public BrowserInfo m37994a(Context context) {
        C6659d.m37882c(f31020a, "getBrowserInfo begin", true);
        BrowserInfo browserInfo = new BrowserInfo();
        String packageName = context.getPackageName();
        browserInfo.setBrowserType(packageName);
        browserInfo.setClientVersion(C6663h.m37902b(context, packageName));
        browserInfo.setClientVersionCode(C6663h.m37900a(context, packageName) + "");
        return browserInfo;
    }

    /* renamed from: a */
    public String m37995a(Context context, String str) throws PackageManager.NameNotFoundException {
        Signature[] signatureArr;
        C6659d.m37882c(f31020a, "getAppSign begin", true);
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return "";
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            return (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) ? "" : signatureArr[0].toCharsString();
        } catch (PackageManager.NameNotFoundException unused) {
            C6659d.m37881b(f31020a, "getSign PackageManager.NameNotFoundException", true);
            return "";
        }
    }
}
