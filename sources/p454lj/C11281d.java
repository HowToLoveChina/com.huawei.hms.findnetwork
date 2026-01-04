package p454lj;

import java.util.Map;
import p054cj.C1442a;

/* renamed from: lj.d */
/* loaded from: classes5.dex */
public class C11281d {
    /* renamed from: a */
    public static String m67707a(Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            C1442a.m8289e("CampaignRequestSpliceUtil", "genRestFullRequestParams,params invalid");
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            sb2.append(entry.getKey());
            sb2.append("=");
            sb2.append(entry.getValue().toString());
            sb2.append("&");
        }
        int length = sb2.length();
        return sb2.delete(length - 1, length).toString();
    }

    /* renamed from: b */
    public static String m67708b(String str, String str2, String str3) {
        boolean z10;
        boolean z11 = true;
        String str4 = "";
        if (str == null || str.isEmpty()) {
            z10 = false;
        } else {
            str4 = "activityCode=" + str;
            z10 = true;
        }
        if (str2 == null || str2.isEmpty()) {
            z11 = z10;
        } else {
            if (z10) {
                str4 = str4 + "&";
            }
            str4 = str4 + "pageSize=" + str2;
        }
        if (str3 == null || str3.isEmpty()) {
            return str4;
        }
        if (z11) {
            str4 = str4 + "&";
        }
        return str4 + "pageNo=" + str3;
    }
}
