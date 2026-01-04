package com.baidu.geocoder.p064a;

import android.text.TextUtils;
import com.baidu.location.LocationClient;
import com.baidu.location.p065a.C1534f;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.baidu.geocoder.a.d */
/* loaded from: classes.dex */
public class C1520d {
    /* renamed from: a */
    public static String m8637a(double d10, double d11, String str) {
        String str2;
        Map<String, String> mapM8640a = m8640a(Double.toString(d11) + "," + Double.toString(d10), C1534f.f6658d, str);
        String strM8639a = m8639a(mapM8640a);
        if (TextUtils.isEmpty(strM8639a)) {
            str2 = " makeRgcParamToPost(), mapToStr return error.";
        } else {
            String strM8638a = m8638a(strM8639a);
            if (TextUtils.isEmpty(strM8638a)) {
                C1534f.m8725c("makeRgcParamToPost(), get the sn is empty");
            }
            mapM8640a.put("sn", strM8638a);
            String strM8639a2 = m8639a(mapM8640a);
            if (!TextUtils.isEmpty(strM8639a2)) {
                return strM8639a2;
            }
            str2 = " makeRgcParamToPost(), mapToStr return error after add sn";
        }
        C1534f.m8725c(str2);
        return null;
    }

    /* renamed from: b */
    private static String m8641b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b10 : bArrDigest) {
                stringBuffer.append(Integer.toHexString((b10 & 255) | 256).substring(1, 3));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e10) {
            C1534f.m8725c("calculateMD5(), NoSuchAlgorithmException msg: " + e10.getMessage());
            return "";
        }
    }

    /* renamed from: a */
    private static String m8638a(String str) {
        try {
            return m8641b(URLEncoder.encode("/geocoder/v2/?" + str + C1534f.f6665k, Constants.UTF_8));
        } catch (UnsupportedEncodingException unused) {
            C1534f.m8725c("calculateSN(), get UnsupportedEncodingException. ");
            return null;
        }
    }

    /* renamed from: a */
    private static String m8639a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(sb2)) {
                sb2.append("&");
            }
            sb2.append(entry.getKey());
            sb2.append("=");
            sb2.append(entry.getValue());
        }
        return sb2.toString();
    }

    /* renamed from: a */
    private static Map<String, String> m8640a(String str, String str2, String str3) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", str2);
        treeMap.put(JsbMapKeyNames.H5_LOC, str);
        treeMap.put("output", "json");
        treeMap.put("pois", "1");
        treeMap.put("coordtype", "wgs84ll");
        treeMap.put("latest_admin", "1");
        treeMap.put("prod", C1534f.f6660f + LocationClient.mContext.getPackageName());
        treeMap.put("oem", "huawei");
        treeMap.put(FaqConstants.FAQ_CHANNEL, "nl.nl1103");
        treeMap.put("build", "n817");
        treeMap.put("os", C1534f.m8728f());
        treeMap.put("uuid", C1534f.f6675u);
        treeMap.put("mb", C1534f.m8726d());
        treeMap.put(RemoteMessageConst.FROM, "BaiduNLP");
        treeMap.put(FaqConstants.FAQ_EMUI_LANGUAGE, C1534f.m8727e());
        treeMap.put("language_auto", "1");
        return treeMap;
    }
}
