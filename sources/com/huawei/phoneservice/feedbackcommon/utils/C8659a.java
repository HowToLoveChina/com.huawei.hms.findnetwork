package com.huawei.phoneservice.feedbackcommon.utils;

import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: com.huawei.phoneservice.feedbackcommon.utils.a */
/* loaded from: classes5.dex */
public class C8659a {

    /* renamed from: a */
    public SortedMap<String, String> f40334a = new TreeMap();

    public C8659a(String str) {
        if (str == null) {
            return;
        }
        for (String str2 : str.split("&")) {
            int iIndexOf = str2.indexOf("=");
            this.f40334a.put(str2.substring(0, iIndexOf), str2.substring(iIndexOf + 1));
        }
    }

    /* renamed from: a */
    public String m53381a(String str) throws UnsupportedEncodingException {
        String str2 = this.f40334a.get(URLEncoder.encode(str, Constants.UTF_8));
        if (str2 == null) {
            return null;
        }
        return URLDecoder.decode(str2, Constants.UTF_8);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(512);
        for (Map.Entry<String, String> entry : this.f40334a.entrySet()) {
            String key = entry.getKey();
            if (sb2.length() > 0) {
                sb2.append("&");
            }
            sb2.append(key);
            sb2.append("=");
            sb2.append(entry.getValue());
        }
        return sb2.toString();
    }
}
