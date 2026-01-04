package uk;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.Set;
import p399jk.AbstractC10896a;

/* renamed from: uk.d */
/* loaded from: classes6.dex */
public class C13206d {
    /* renamed from: a */
    public static String m79401a(String str, String str2, String str3) {
        if (str.contains(Constants.QUESTION_STR)) {
            return str + "&" + str2 + "=" + str3;
        }
        return str + Constants.QUESTION_STR + str2 + "=" + str3;
    }

    /* renamed from: b */
    public static String m79402b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return Uri.parse(str).getQueryParameter(str2);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("UrlUtil", "getParamValue  e." + e10.toString());
            return "";
        }
    }

    /* renamed from: c */
    public static String m79403c(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            Uri uri = Uri.parse(str);
            Uri.Builder builderBuildUpon = uri.buildUpon();
            builderBuildUpon.clearQuery();
            str = builderBuildUpon.build().toString();
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            if (!queryParameterNames.contains(str2)) {
                str = m79401a(str, str2, str3);
            }
            for (String str4 : queryParameterNames) {
                String queryParameter = uri.getQueryParameter(str4);
                if (TextUtils.equals(str4, str2)) {
                    queryParameter = str3;
                } else if (URLUtil.isNetworkUrl(queryParameter)) {
                    queryParameter = m79403c(queryParameter, str2, str3);
                }
                str = m79401a(str, str4, queryParameter);
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("UrlUtil", "replaceALLParam  e." + e10.toString());
        }
        return str;
    }
}
