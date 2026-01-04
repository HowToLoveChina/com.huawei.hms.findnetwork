package com.huawei.hms.support.api.safetydetect.p860default;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

/* renamed from: com.huawei.hms.support.api.safetydetect.default.z */
/* loaded from: classes8.dex */
public class C6385z {

    /* renamed from: b */
    private static final String f29906b = "z";

    /* renamed from: a */
    private final SharedPreferences f29907a;

    private C6385z(Context context) {
        this.f29907a = context.createDeviceProtectedStorageContext().getSharedPreferences("safetydetect.token", 0);
    }

    /* renamed from: a */
    public static C6385z m36768a(Context context) {
        return new C6385z(context);
    }

    /* renamed from: a */
    public String m36769a(String str) {
        String string = this.f29907a.getString(str, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        Log.i(f29906b, "Get String from sp failed " + str);
        return "";
    }

    /* renamed from: a */
    public void m36770a(String str, String str2) {
        this.f29907a.edit().putString(str, str2).apply();
    }
}
