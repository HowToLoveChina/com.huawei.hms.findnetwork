package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.android.hicloud.sync.wifi.datamanager.ExtractOWiFiHelper;
import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.Scheme;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.utils.cz */
/* loaded from: classes2.dex */
public abstract class AbstractC7806cz {
    /* renamed from: a */
    public static int m48145a(String str, int i10) {
        try {
            return m48165b(str) ? i10 : Integer.parseInt(str);
        } catch (NumberFormatException e10) {
            AbstractC7185ho.m43823c("StringUtils", "parseIntOrDefault exception: " + e10.getClass().getSimpleName());
            return i10;
        }
    }

    /* renamed from: b */
    public static String m48162b(Object obj) {
        return obj == null ? "null" : "not null";
    }

    /* renamed from: c */
    private static Object m48167c(Object obj) {
        if (obj instanceof Bundle) {
            return m48164b((Bundle) obj);
        }
        try {
            return JSONObject.wrap(obj);
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("StringUtils", "wrap Exception:" + th2.getClass().getSimpleName());
            return JSONObject.NULL;
        }
    }

    /* renamed from: d */
    public static String m48170d(String str) {
        if (m48165b(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, Constants.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            AbstractC7185ho.m43826d("StringUtils", "unsupport encoding");
            return null;
        }
    }

    /* renamed from: e */
    public static String m48172e(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    /* renamed from: f */
    public static String m48174f(String str) {
        return TextUtils.isEmpty(str) ? "" : str.contains("://") ? m48188q(str) : m48189r(str);
    }

    /* renamed from: g */
    public static String m48176g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        if (length <= 3) {
            if (length > 1) {
                str = str.substring(0, length - 1);
            }
            sb2.append(str);
            sb2.append(Constants.CONFUSION_CHARS);
        } else {
            int i10 = (length / 5) + 1;
            String strSubstring = str.substring(0, Math.min(3, i10));
            String strSubstring2 = str.substring(length - Math.min(3, i10));
            sb2.append(strSubstring);
            sb2.append(Constants.CONFUSION_CHARS);
            sb2.append(strSubstring2);
        }
        return sb2.toString();
    }

    /* renamed from: h */
    public static Integer m48178h(String str) {
        if (m48165b(str)) {
            return null;
        }
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException e10) {
            AbstractC7185ho.m43826d("StringUtils", "toInteger NumberFormatException:" + e10.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: i */
    public static Long m48180i(String str) {
        if (m48165b(str)) {
            return null;
        }
        try {
            return Long.valueOf(str);
        } catch (NumberFormatException e10) {
            AbstractC7185ho.m43826d("StringUtils", "toLong NumberFormatException:" + e10.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: j */
    public static boolean m48181j(String str) {
        return str != null && (str.startsWith(Scheme.HTTP.toString()) || str.startsWith(Scheme.HTTPS.toString()));
    }

    /* renamed from: k */
    public static String m48182k(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!URLUtil.isNetworkUrl(str)) {
                AbstractC7185ho.m43823c("StringUtils", "url don't starts with http or https");
                return null;
            }
            if (str.contains("{")) {
                str = str.replaceAll("\\{", "");
            }
            if (str.contains("}")) {
                str = str.replaceAll("\\}", "");
            }
            return new URI(str).getHost();
        } catch (URISyntaxException e10) {
            AbstractC7185ho.m43826d("StringUtils", "getHostByURI error : " + e10.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: l */
    public static String m48183l(String str) {
        return TextUtils.isEmpty(str) ? str : str.toUpperCase(Locale.ENGLISH);
    }

    /* renamed from: m */
    public static String m48184m(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return AbstractC7836o.m48492a(str.getBytes(Constants.UTF_8));
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("StringUtils", "base64Encode Exception: %s", th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: n */
    public static String m48185n(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            if (str.length() > 100) {
                str = str.substring(0, 100);
            }
            return AbstractC7836o.m48492a(str.getBytes(Constants.UTF_8));
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("StringUtils", "formatInput Exception: %s", th2.getClass().getSimpleName());
            return "";
        }
    }

    /* renamed from: o */
    public static boolean m48186o(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches("^[0-9]+,[0-9]+$", str) && str.length() < 100;
    }

    /* renamed from: p */
    public static boolean m48187p(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches("^[0-9\\*\\+\\-\\.]*$", str) && str.length() < 100;
    }

    /* renamed from: q */
    private static String m48188q(String str) {
        StringBuilder sb2 = new StringBuilder();
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (scheme != null) {
            sb2.append(scheme);
            sb2.append("://");
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            lastPathSegment = URLUtil.isNetworkUrl(str) ? m48182k(str) : uri.getHost();
        } else {
            sb2.append(Constants.CONFUSION_CHARS);
            sb2.append(C5929g4.f26852n);
        }
        if (lastPathSegment != null) {
            int length = lastPathSegment.length();
            if (length > 3) {
                sb2.append((CharSequence) lastPathSegment, 0, 3);
            } else if (length > 1) {
                sb2.append((CharSequence) lastPathSegment, 0, length - 1);
            }
        }
        sb2.append(Constants.CONFUSION_CHARS);
        return sb2.toString();
    }

    /* renamed from: r */
    private static String m48189r(String str) {
        int i10;
        int iLastIndexOf = str.lastIndexOf("/");
        if (iLastIndexOf >= 0 && (i10 = iLastIndexOf + 1) < str.length()) {
            str = str.substring(i10);
        }
        int length = str.length();
        if (length > 3) {
            return str.substring(0, 3) + Constants.CONFUSION_CHARS;
        }
        if (length <= 1) {
            return Constants.CONFUSION_CHARS;
        }
        return str.substring(0, length - 1) + Constants.CONFUSION_CHARS;
    }

    /* renamed from: a */
    public static long m48146a(String str, long j10) {
        try {
            return m48165b(str) ? j10 : Long.parseLong(str);
        } catch (NumberFormatException e10) {
            AbstractC7185ho.m43823c("StringUtils", "parseLongOrDefault exception: " + e10.getClass().getSimpleName());
            return j10;
        }
    }

    /* renamed from: b */
    public static List<Integer> m48163b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String[] strArrSplit = str.split(str2);
        ArrayList arrayList = new ArrayList();
        for (String str3 : strArrSplit) {
            try {
                arrayList.add(Integer.valueOf(Integer.parseInt(str3)));
            } catch (Throwable unused) {
                AbstractC7185ho.m43823c("StringUtils", "parse integer list error.");
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public static String m48168c(String str) {
        String str2;
        if (m48165b(str)) {
            return str;
        }
        try {
            return URLDecoder.decode(str, Constants.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            str2 = "unsupport encoding";
            AbstractC7185ho.m43826d("StringUtils", str2);
            return null;
        } catch (Exception unused2) {
            str2 = "decode error";
            AbstractC7185ho.m43826d("StringUtils", str2);
            return null;
        }
    }

    /* renamed from: d */
    public static boolean m48171d(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && (str.startsWith(Scheme.HTTP.toString()) || str.startsWith(Scheme.HTTPS.toString()))) {
            String[] strArrSplit = str2.split(",");
            String strM48182k = m48182k(str);
            AbstractC7185ho.m43820b("StringUtils", "host:" + strM48182k);
            if (!TextUtils.isEmpty(strM48182k)) {
                return Arrays.asList(strArrSplit).contains(strM48182k);
            }
        }
        return false;
    }

    /* renamed from: e */
    public static boolean m48173e(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return TextUtils.equals(str, str2);
    }

    /* renamed from: f */
    public static String m48175f(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        boolean zIsEmpty = TextUtils.isEmpty(str2);
        String strTrim = str.trim();
        return !zIsEmpty ? strTrim.replace(str2, "") : strTrim;
    }

    /* renamed from: g */
    public static boolean m48177g(String str, String str2) {
        return TextUtils.isEmpty(m48175f(str, str2));
    }

    /* renamed from: h */
    public static String m48179h(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return str2.lastIndexOf(".") == -1 ? str2 : str2.substring(0, str2.lastIndexOf("."));
        }
        String strReplaceAll = str2.replaceAll("." + str.replace(".java", ""), "");
        int iIndexOf = strReplaceAll.indexOf("$");
        return iIndexOf != -1 ? strReplaceAll.substring(0, iIndexOf) : strReplaceAll;
    }

    /* renamed from: a */
    public static Float m48147a(String str, Float f10) {
        if (m48165b(str)) {
            return f10;
        }
        try {
            return Float.valueOf(str);
        } catch (NumberFormatException e10) {
            AbstractC7185ho.m43826d("StringUtils", "toFloat NumberFormatException:" + e10.getClass().getSimpleName());
            return f10;
        }
    }

    /* renamed from: b */
    public static JSONObject m48164b(Bundle bundle) {
        if (bundle == null) {
            return new JSONObject();
        }
        Set<String> setKeySet = bundle.keySet();
        JSONObject jSONObject = new JSONObject();
        for (String str : setKeySet) {
            try {
                jSONObject.put(str, m48167c(bundle.get(str)));
            } catch (Throwable th2) {
                AbstractC7185ho.m43823c("StringUtils", "converBundleToJson Exception:" + th2.getClass().getSimpleName());
            }
        }
        return jSONObject;
    }

    /* renamed from: c */
    public static String m48169c(String str, String str2) {
        return (TextUtils.isEmpty(str) || str2 == null || str.lastIndexOf(str2) != str.length() + (-1)) ? str : str.substring(0, str.length() - 1);
    }

    /* renamed from: a */
    public static Integer m48148a(String str) {
        try {
            return Integer.valueOf((int) Double.parseDouble(str));
        } catch (Exception e10) {
            AbstractC7185ho.m43826d("StringUtils", "parseStringToInt ex:" + e10.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m48165b(String str) {
        return str == null || str.trim().length() == 0;
    }

    /* renamed from: a */
    public static String m48149a(Context context) {
        return (context != null && C7844w.m48512a(context).m48517b()) ? Constants.TV_SUFFIX : "";
    }

    /* renamed from: b */
    public static Integer[] m48166b(JSONArray jSONArray) {
        String[] strArrM48161a = m48161a(jSONArray);
        if (AbstractC7760bg.m47769a(strArrM48161a)) {
            return new Integer[0];
        }
        Integer[] numArr = new Integer[strArrM48161a.length];
        for (int i10 = 0; i10 < strArrM48161a.length; i10++) {
            try {
                numArr[i10] = Integer.valueOf(Integer.parseInt(strArrM48161a[i10]));
            } catch (Throwable unused) {
                numArr[i10] = null;
                AbstractC7185ho.m43823c("StringUtils", "toIntegerArray exception.");
            }
        }
        return numArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m48150a(android.content.Context r5, int r6, java.lang.String r7, java.lang.Object... r8) {
        /*
            java.lang.String r0 = "getChinaString "
            java.lang.String r1 = "StringUtils"
            android.content.res.Resources r2 = r5.getResources()
            r3 = 0
            com.huawei.openalliance.ad.co r4 = com.huawei.openalliance.p169ad.C6982bz.m41148a(r5)     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            boolean r4 = r4.mo41170a()     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            if (r4 == 0) goto L5f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            r4.<init>()     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            r4.append(r7)     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            java.lang.String r7 = "_zh"
            r4.append(r7)     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            java.lang.String r4 = "string"
            java.lang.String r5 = r5.getPackageName()     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            int r5 = r2.getIdentifier(r7, r4, r5)     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            if (r8 == 0) goto L39
            java.lang.String r3 = r2.getString(r5, r8)     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            goto L5f
        L35:
            r5 = move-exception
            goto L3e
        L37:
            r5 = move-exception
            goto L59
        L39:
            java.lang.String r3 = r2.getString(r5)     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            goto L5f
        L3e:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
        L43:
            r7.append(r0)
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43826d(r1, r5)
            goto L5f
        L59:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            goto L43
        L5f:
            if (r3 != 0) goto L6f
            if (r8 == 0) goto L6b
            int r5 = r8.length
            if (r5 <= 0) goto L6b
            java.lang.String r3 = r2.getString(r6, r8)
            goto L6f
        L6b:
            java.lang.String r3 = r2.getString(r6)
        L6f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.utils.AbstractC7806cz.m48150a(android.content.Context, int, java.lang.String, java.lang.Object[]):java.lang.String");
    }

    /* renamed from: a */
    public static String m48151a(Context context, String str) {
        StringBuilder sb2;
        if (TextUtils.isEmpty(str) || context == null) {
            return "";
        }
        String str2 = str + m48149a(context);
        Resources resources = context.getResources();
        try {
            return resources.getString(resources.getIdentifier(str2, ExtractOWiFiHelper.STING_NODE, context.getPackageName()));
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            sb2.append("getChinaString ");
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43826d("StringUtils", sb2.toString());
            return "";
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            sb2.append("getChinaString ");
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43826d("StringUtils", sb2.toString());
            return "";
        }
    }

    /* renamed from: a */
    public static String m48152a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return m48164b(bundle).toString();
    }

    /* renamed from: a */
    public static String m48153a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    /* renamed from: a */
    public static String m48154a(String str, Context context) throws Throwable {
        BufferedReader bufferedReader;
        IOException e10;
        InputStream inputStreamOpen = context.getAssets().open(str);
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, Constants.UTF_8));
            while (true) {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb2.append(line + "\n");
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        AbstractC7805cy.m48142a(bufferedReader2);
                        AbstractC7805cy.m48142a((Closeable) inputStreamOpen);
                        throw th;
                    }
                } catch (IOException e11) {
                    e10 = e11;
                    AbstractC7185ho.m43826d("StringUtils", "getStringFromAsset, " + e10.getClass().getSimpleName());
                    AbstractC7805cy.m48142a(bufferedReader);
                    AbstractC7805cy.m48142a((Closeable) inputStreamOpen);
                    return sb2.toString();
                }
            }
        } catch (IOException e12) {
            bufferedReader = null;
            e10 = e12;
        } catch (Throwable th3) {
            th = th3;
            AbstractC7805cy.m48142a(bufferedReader2);
            AbstractC7805cy.m48142a((Closeable) inputStreamOpen);
            throw th;
        }
        AbstractC7805cy.m48142a(bufferedReader);
        AbstractC7805cy.m48142a((Closeable) inputStreamOpen);
        return sb2.toString();
    }

    /* renamed from: a */
    public static String m48155a(Collection<String> collection, String str) {
        StringBuilder sb2 = new StringBuilder();
        if (collection != null && !collection.isEmpty()) {
            boolean z10 = true;
            for (String str2 : collection) {
                if (!z10) {
                    sb2.append(str);
                }
                sb2.append(str2);
                z10 = false;
            }
        }
        return sb2.toString();
    }

    /* renamed from: a */
    public static String m48156a(List<String> list, String str) {
        StringBuilder sb2 = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            boolean z10 = true;
            for (String str2 : list) {
                if (!z10) {
                    sb2.append(str);
                }
                sb2.append(str2);
                z10 = false;
            }
        }
        return sb2.toString();
    }

    /* renamed from: a */
    public static List<String> m48157a(String str, String str2) {
        return TextUtils.isEmpty(str) ? Collections.emptyList() : new ArrayList(Arrays.asList(str.split(str2)));
    }

    /* renamed from: a */
    public static List<String> m48158a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (AbstractC7760bg.m47767a(list)) {
            return arrayList;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String strM48168c = m48168c(it.next());
            if (strM48168c != null) {
                arrayList.add(strM48168c);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m48159a(StringBuilder sb2, char c10) {
        int iLastIndexOf;
        if (sb2 == null || (iLastIndexOf = sb2.lastIndexOf(String.valueOf(c10))) == -1 || iLastIndexOf != sb2.length() - 1) {
            return;
        }
        sb2.deleteCharAt(sb2.length() - 1);
    }

    /* renamed from: a */
    public static boolean m48160a(Set<String> set, String str) {
        if (!AbstractC7760bg.m47767a(set) && !TextUtils.isEmpty(str)) {
            return set.contains(str);
        }
        AbstractC7185ho.m43817a("StringUtils", "ModelList or ModelName is empty");
        return true;
    }

    /* renamed from: a */
    public static String[] m48161a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return new String[0];
        }
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            strArr[i10] = jSONArray.optString(i10);
        }
        return strArr;
    }
}
