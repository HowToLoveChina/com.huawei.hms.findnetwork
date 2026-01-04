package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: okhttp3.j0 */
/* loaded from: classes9.dex */
public enum EnumC11943j0 {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");


    /* renamed from: a */
    public final String f55607a;

    EnumC11943j0(String str) {
        this.f55607a = str;
    }

    /* renamed from: b */
    public static EnumC11943j0 m71792b(String str) {
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

    /* renamed from: e */
    public static List<EnumC11943j0> m71793e(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(m71792b(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: f */
    public String m71794f() {
        return this.f55607a;
    }
}
