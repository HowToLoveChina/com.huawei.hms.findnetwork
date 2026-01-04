package com.huawei.hms.drive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.huawei.hms.drive.bk */
/* loaded from: classes8.dex */
public enum EnumC5206bk {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");


    /* renamed from: f */
    final String f23982f;

    EnumC5206bk(String str) {
        this.f23982f = str;
    }

    /* renamed from: a */
    public static EnumC5206bk m31166a(String str) {
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
    public static List<EnumC5206bk> m31167a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(m31166a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }
}
