package com.huawei.hms.push;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.p137ha.PushAnalyticsCenter;
import com.huawei.hms.push.utils.p137ha.PushBaseAnalytics;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.p171db.bean.SdkCfgSha256Record;

/* renamed from: com.huawei.hms.push.l */
/* loaded from: classes8.dex */
public class C6293l {

    /* renamed from: a */
    private static final String f29673a = "l";

    /* renamed from: a */
    public static void m36536a(Context context, String str, String str2, String str3) {
        PushBaseAnalytics pushAnalytics = PushAnalyticsCenter.getInstance().getPushAnalytics();
        if (pushAnalytics == null) {
            return;
        }
        Bundle bundleM36534a = m36534a(context, str, str2);
        HMSLog.m36988i(f29673a, "eventId:" + str3);
        pushAnalytics.report(context, str3, bundleM36534a);
    }

    /* renamed from: a */
    private static Bundle m36534a(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(JsbMapKeyNames.JSSDK_VER, String.valueOf(61300300));
        bundle.putString(SdkCfgSha256Record.PKGNAME, context.getPackageName());
        bundle.putString("aaid", HmsInstanceId.getInstance(context).getId());
        PushProxy proxy = ProxyCenter.getProxy();
        if (proxy != null) {
            bundle.putString("proxyType", proxy.getProxyType());
        }
        bundle.putString(RemoteMessageConst.MSGID, str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(RemoteMessageConst.ANALYTIC_INFO, str2);
        }
        return bundle;
    }

    /* renamed from: a */
    public static void m36535a(Context context, Bundle bundle, String str) {
        PushBaseAnalytics pushAnalytics;
        if (bundle == null || (pushAnalytics = PushAnalyticsCenter.getInstance().getPushAnalytics()) == null) {
            return;
        }
        bundle.putString("sdk_version", String.valueOf(61300300));
        HMSLog.m36988i(f29673a, "eventId:" + str);
        pushAnalytics.report(context, str, bundle);
    }
}
