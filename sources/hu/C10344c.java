package hu;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: hu.c */
/* loaded from: classes5.dex */
public class C10344c {

    /* renamed from: a */
    public static final String f50032a = "SafeUri";

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static boolean m63703a(Uri uri, String str, boolean z10) {
        if (uri != null && !TextUtils.isEmpty(str)) {
            try {
                return uri.getBooleanQueryParameter(str, z10);
            } catch (Exception e10) {
                Log.e(f50032a, "getBooleanQueryParameter: " + e10.getMessage());
            }
        }
        return z10;
    }

    /* renamed from: b */
    public static String m63704b(Uri uri, String str) {
        if (uri != null && !TextUtils.isEmpty(str)) {
            try {
                return uri.getQueryParameter(str);
            } catch (Exception e10) {
                Log.e(f50032a, "getQueryParameter: " + e10.getMessage());
            }
        }
        return "";
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    public static Set<String> m63705c(Uri uri) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (uri == null) {
            return linkedHashSet;
        }
        try {
            return uri.getQueryParameterNames();
        } catch (Exception e10) {
            Log.e(f50032a, "getQueryParameterNames: " + e10.getMessage());
            return linkedHashSet;
        }
    }
}
