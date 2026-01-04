package com.huawei.hms.network.embedded;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.huawei.hms.network.embedded.y7 */
/* loaded from: classes8.dex */
public enum EnumC6166y7 {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");


    /* renamed from: a */
    public final String f29145a;

    EnumC6166y7(String str) {
        this.f29145a = str;
    }

    /* renamed from: a */
    public static EnumC6166y7 m35840a(String str) {
        str.hashCode();
        switch (str) {
            case "TLSv1.1":
                return TLS_1_1;
            case "TLSv1.2":
                return TLS_1_2;
            case "TLSv1.3":
                return TLS_1_3;
            case "SSLv3":
                return SSL_3_0;
            case "TLSv1":
                return TLS_1_0;
            default:
                throw new IllegalArgumentException("Unexpected TLS version: " + str);
        }
    }

    /* renamed from: a */
    public String m35842a() {
        return this.f29145a;
    }

    /* renamed from: a */
    public static List<EnumC6166y7> m35841a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(m35840a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }
}
