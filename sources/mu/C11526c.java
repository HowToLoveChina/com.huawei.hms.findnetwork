package mu;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.net.MalformedURLException;
import java.net.URL;
import lu.C11345d;

/* renamed from: mu.c */
/* loaded from: classes5.dex */
public class C11526c {
    /* renamed from: a */
    public static String m68804a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return !URLUtil.isNetworkUrl(str) ? str : m68805b(str);
        }
        C11345d.m68154f("UriUtil", "whiteListUrl is null");
        return null;
    }

    @TargetApi(9)
    /* renamed from: b */
    public static String m68805b(String str) {
        if (TextUtils.isEmpty(str)) {
            C11345d.m68154f("UriUtil", "url is null");
            return str;
        }
        try {
            if (URLUtil.isNetworkUrl(str)) {
                return new URL(str.replaceAll("[\\\\#]", "/")).getHost();
            }
            C11345d.m68152d("UriUtil", "url don't starts with http or https");
            return "";
        } catch (MalformedURLException e10) {
            C11345d.m68152d("UriUtil", "getHostByURI error  MalformedURLException : " + e10.getMessage());
            return "";
        }
    }

    /* renamed from: c */
    public static boolean m68806c(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            C11345d.m68152d("UriUtil", "whitelist is null");
            return false;
        }
        for (String str2 : strArr) {
            if (m68807d(str, str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m68807d(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String strDecode = Uri.decode(str);
            String strDecode2 = Uri.decode(str2);
            if (!strDecode.contains("..") && !strDecode2.contains(SplitAppUtil.SPLIT_APP_SUFFIX)) {
                if (str.contains("..") || str.contains(SplitAppUtil.SPLIT_APP_SUFFIX)) {
                    Log.e("UriUtil", "url contains unsafe char");
                    return false;
                }
                if (!str2.equals(str)) {
                    if (!str.startsWith(str2 + Constants.QUESTION_STR)) {
                        if (!str.startsWith(str2 + "#")) {
                            if (!str2.endsWith("/")) {
                                return false;
                            }
                            if (Uri.parse(strDecode).getPathSegments().size() - Uri.parse(strDecode2).getPathSegments().size() != 1) {
                                return false;
                            }
                            return str.startsWith(str2);
                        }
                    }
                }
                return true;
            }
            Log.e("UriUtil", "url contains unsafe char");
        }
        return false;
    }

    /* renamed from: e */
    public static boolean m68808e(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            C11345d.m68152d("UriUtil", "whitelist is null");
            return false;
        }
        for (String str2 : strArr) {
            if (m68809f(str, str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public static boolean m68809f(String str, String str2) {
        String strM68805b = m68805b(str);
        if (TextUtils.isEmpty(strM68805b) || TextUtils.isEmpty(str2)) {
            C11345d.m68152d("UriUtil", "url or whitelist is null");
            return false;
        }
        String strM68804a = m68804a(str2);
        if (TextUtils.isEmpty(strM68804a)) {
            Log.e("UriUtil", "whitelist host is null");
            return false;
        }
        if (strM68804a.equals(strM68805b)) {
            return true;
        }
        if (strM68805b.endsWith(strM68804a)) {
            try {
                String strSubstring = strM68805b.substring(0, strM68805b.length() - strM68804a.length());
                if (strSubstring.endsWith(".")) {
                    return strSubstring.matches("^[A-Za-z0-9.-]+$");
                }
                return false;
            } catch (IndexOutOfBoundsException e10) {
                C11345d.m68152d("UriUtil", "IndexOutOfBoundsException" + e10.getMessage());
            } catch (Exception e11) {
                C11345d.m68152d("UriUtil", "Exception : " + e11.getMessage());
                return false;
            }
        }
        return false;
    }

    /* renamed from: g */
    public static boolean m68810g(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return TextUtils.equals(m68805b(str), m68804a(str2));
        }
        Log.e("UriUtil", "isUrlHostSameWhitelist: url or host is null");
        return false;
    }

    /* renamed from: h */
    public static boolean m68811h(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            C11345d.m68152d("UriUtil", "whitelist is null");
            return false;
        }
        for (String str2 : strArr) {
            if (m68810g(str, str2)) {
                return true;
            }
        }
        return false;
    }
}
