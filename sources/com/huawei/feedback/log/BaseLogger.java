package com.huawei.feedback.log;

import android.text.TextUtils;
import android.util.Log;
import ck.C1443a;
import com.huawei.feedback.mail.bean.AppLog;
import p399jk.AbstractC10896a;

/* loaded from: classes5.dex */
public class BaseLogger extends AbstractC10896a {
    private static final String TAG_PREFIX = "Sync";

    public static void appendFeedBack(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        AppLogManager.getInstance().appendLog(new AppLog("E", str, str2));
    }

    /* renamed from: d */
    public static void m28729d(String str, String str2) {
        m28730d(TAG_PREFIX, str, str2);
    }

    /* renamed from: e */
    public static void m28731e(String str, String str2) {
        m28732e(TAG_PREFIX, str, str2);
    }

    /* renamed from: i */
    public static void m28733i(String str, String str2) {
        m28734i(TAG_PREFIX, str, str2);
    }

    /* renamed from: w */
    public static void m28735w(String str, String str2) {
        m28736w(TAG_PREFIX, str, str2);
    }

    /* renamed from: d */
    public static void m28730d(String str, String str2, String str3) {
        if (C1443a.f6214b.booleanValue()) {
            String tag = AbstractC10896a.formatTag(str, str2);
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            Log.d(tag, str3);
        }
    }

    /* renamed from: e */
    public static void m28732e(String str, String str2, String str3) {
        String tag = AbstractC10896a.formatTag(str, str2);
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        Log.e(tag, str3);
        AppLogManager.getInstance().appendLog(new AppLog("E", str2, str3));
    }

    /* renamed from: i */
    public static void m28734i(String str, String str2, String str3) {
        String tag = AbstractC10896a.formatTag(str, str2);
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        Log.i(tag, str3);
        AppLogManager.getInstance().appendLog(new AppLog("I", str2, str3));
    }

    /* renamed from: w */
    public static void m28736w(String str, String str2, String str3) {
        String tag = AbstractC10896a.formatTag(str, str2);
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        Log.w(tag, str3);
        AppLogManager.getInstance().appendLog(new AppLog("W", str2, str3));
    }
}
