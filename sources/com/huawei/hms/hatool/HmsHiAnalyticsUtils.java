package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;
import org.json.JSONException;

/* loaded from: classes8.dex */
public class HmsHiAnalyticsUtils {
    public static void enableLog() {
        C5519c.m32462a();
    }

    public static boolean getInitFlag() {
        return AbstractC5513a.m32423b();
    }

    public static void init(Context context, boolean z10, boolean z11, boolean z12, String str, String str2) {
        new C5516b(context).m32443a(z10).m32446c(z11).m32445b(z12).m32441a(0, str).m32441a(1, str).m32442a(str2).m32444a();
    }

    public static void onEvent(Context context, String str, String str2) throws JSONException {
        AbstractC5513a.m32421a(context, str, str2);
    }

    public static void onReport() {
        AbstractC5513a.m32424c();
    }

    public static void onStreamEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap) throws JSONException {
        AbstractC5513a.m32422b(i10, str, linkedHashMap);
    }

    public static void onEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap) throws JSONException {
        AbstractC5513a.m32420a(i10, str, linkedHashMap);
    }
}
