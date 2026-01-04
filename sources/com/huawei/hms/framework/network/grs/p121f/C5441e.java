package com.huawei.hms.framework.network.grs.p121f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p120e.C5434a;
import com.huawei.hms.framework.network.grs.p122g.C5443b;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.huawei.hms.framework.network.grs.f.e */
/* loaded from: classes8.dex */
public class C5441e {

    /* renamed from: a */
    private static final String f24932a = "e";

    /* renamed from: b */
    public static final Set<String> f24933b = Collections.unmodifiableSet(new a(16));

    /* renamed from: com.huawei.hms.framework.network.grs.f.e$a */
    public class a extends HashSet<String> {
        public a(int i10) {
            super(i10);
            add("ser_country");
            add("reg_country");
            add("issue_country");
            add("geo_ip");
        }
    }

    /* renamed from: a */
    private static String m32236a(Context context, C5434a c5434a, String str, GrsBaseInfo grsBaseInfo, boolean z10) {
        String str2;
        StringBuilder sb2;
        String str3;
        String serCountry = grsBaseInfo.getSerCountry();
        String regCountry = grsBaseInfo.getRegCountry();
        String issueCountry = grsBaseInfo.getIssueCountry();
        for (String str4 : str.split(">")) {
            if (f24933b.contains(str4.trim())) {
                if (!"ser_country".equals(str4.trim()) || TextUtils.isEmpty(serCountry) || "UNKNOWN".equals(serCountry)) {
                    if ("reg_country".equals(str4.trim()) && !TextUtils.isEmpty(regCountry) && !"UNKNOWN".equals(regCountry)) {
                        Logger.m32141i(f24932a, "current route_by is regCountry and routerCountry is: " + regCountry);
                        return regCountry;
                    }
                    if ("issue_country".equals(str4.trim()) && !TextUtils.isEmpty(issueCountry) && !"UNKNOWN".equals(issueCountry)) {
                        Logger.m32141i(f24932a, "current route_by is issueCountry and routerCountry is: " + issueCountry);
                        return issueCountry;
                    }
                    if ("geo_ip".equals(str4.trim())) {
                        serCountry = new C5443b(context, c5434a, grsBaseInfo).m32245a(z10);
                        str2 = f24932a;
                        sb2 = new StringBuilder();
                        str3 = "current route_by is geo_ip and routerCountry is: ";
                    }
                } else {
                    str2 = f24932a;
                    sb2 = new StringBuilder();
                    str3 = "current route_by is serCountry and routerCountry is: ";
                }
                sb2.append(str3);
                sb2.append(serCountry);
                Logger.m32141i(str2, sb2.toString());
                return serCountry;
            }
        }
        return "";
    }

    /* renamed from: b */
    public static String m32237b(Context context, C5434a c5434a, String str, GrsBaseInfo grsBaseInfo, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            Logger.m32145w(f24932a, "routeBy must be not empty string or null.");
            return null;
        }
        if (!"no_route".equals(str) && !"unconditional".equals(str)) {
            return m32236a(context, c5434a, str, grsBaseInfo, z10);
        }
        Logger.m32143v(f24932a, "routeBy equals NO_ROUTE_POLICY");
        return "no_route_country";
    }
}
