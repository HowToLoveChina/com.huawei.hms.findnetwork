package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.push.HmsMessaging;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.util.UUID;
import p443l4.AbstractC11229a;

/* renamed from: com.huawei.hms.opendevice.b */
/* loaded from: classes8.dex */
public class C6264b {
    /* renamed from: a */
    public static DeleteTokenReq m36409a(Context context, String str, String str2, String str3, String str4) {
        DeleteTokenReq deleteTokenReq = new DeleteTokenReq();
        deleteTokenReq.setAppId(str);
        deleteTokenReq.setScope(str4);
        deleteTokenReq.setProjectId(str2);
        deleteTokenReq.setPkgName(context.getPackageName());
        deleteTokenReq.setSubjectId(str3);
        if (TextUtils.isEmpty(str)) {
            deleteTokenReq.setAppId(Util.getAppId(context));
        }
        if (TextUtils.isEmpty(str4)) {
            deleteTokenReq.setScope(HmsMessaging.DEFAULT_TOKEN_SCOPE);
        }
        if (TextUtils.isEmpty(str2)) {
            deleteTokenReq.setProjectId(m36414c(context));
        }
        return deleteTokenReq;
    }

    /* renamed from: b */
    public static TokenReq m36411b(Context context, String str, String str2) {
        return m36412b(context, str, null, null, str2);
    }

    /* renamed from: c */
    public static String m36414c(Context context) {
        return AbstractC11229a.m67436d(context).mo66356b("client/project_id");
    }

    /* renamed from: d */
    public static boolean m36415d(Context context) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                if (!TextUtils.isEmpty(bundle.getString("com.huawei.hms.client.service.name:base"))) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            HMSLog.m36986e(HmsInstanceId.TAG, "isIntegratedBaseSdk failed.");
            return true;
        }
    }

    /* renamed from: b */
    public static TokenReq m36410b(Context context, String str) {
        return m36412b(context, null, null, str, null);
    }

    /* renamed from: b */
    public static TokenReq m36412b(Context context, String str, String str2, String str3, String str4) {
        TokenReq tokenReq = new TokenReq();
        tokenReq.setPackageName(context.getPackageName());
        tokenReq.setAppId(str);
        tokenReq.setScope(str4);
        tokenReq.setProjectId(str2);
        tokenReq.setSubjectId(str3);
        tokenReq.setMultiSender(false);
        if (TextUtils.isEmpty(str)) {
            tokenReq.setAppId(Util.getAppId(context));
        }
        if (TextUtils.isEmpty(str2)) {
            tokenReq.setProjectId(m36414c(context));
        }
        if (TextUtils.isEmpty(str4)) {
            tokenReq.setScope(HmsMessaging.DEFAULT_TOKEN_SCOPE);
        }
        C6271i c6271iM36434a = C6271i.m36434a(context);
        if (!c6271iM36434a.getBoolean("hasRequestAgreement")) {
            tokenReq.setFirstTime(true);
            c6271iM36434a.saveBoolean("hasRequestAgreement", true);
        } else {
            tokenReq.setFirstTime(false);
        }
        return tokenReq;
    }

    /* renamed from: a */
    public static DeleteTokenReq m36408a(Context context, String str, String str2) {
        return m36409a(context, str, null, null, str2);
    }

    /* renamed from: a */
    public static DeleteTokenReq m36407a(Context context, String str) {
        return m36409a(context, null, null, str, null);
    }

    /* renamed from: a */
    public static DeleteTokenReq m36406a(Context context) {
        return m36409a(context, null, null, null, null);
    }

    /* renamed from: b */
    public static synchronized String m36413b(Context context) {
        String string;
        try {
            PushPreferences pushPreferences = new PushPreferences(context, "aaid");
            if (pushPreferences.containsKey("aaid")) {
                string = pushPreferences.getString("aaid");
            } else {
                string = UUID.randomUUID().toString();
                pushPreferences.saveString("aaid", string);
                pushPreferences.saveLong("creationTime", Long.valueOf(System.currentTimeMillis()));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return string;
    }
}
