package ng;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import ck.C1443a;
import p015ak.C0219i;
import p514o9.C11842p;

/* renamed from: ng.h */
/* loaded from: classes4.dex */
public class C11701h {
    /* renamed from: a */
    public static String m69779a(String str, Context context) {
        StringBuilder sb2;
        String str2 = "phoneservice;MasterCloudwap";
        if (!C11842p.m70771U0() && !C11842p.m70735I0()) {
            str2 = "phoneservice;MasterCloudwap;Mobile";
        } else if (!TextUtils.isEmpty(str) && str.contains("Mobile")) {
            str = str.replace("Mobile", "");
        }
        if (str.endsWith(";")) {
            sb2 = new StringBuilder(str + str2);
        } else {
            sb2 = new StringBuilder(str + ";" + str2);
        }
        sb2.append(m69782d(context));
        sb2.append(m69783e());
        sb2.append(m69784f());
        sb2.append(m69781c());
        return sb2.toString();
    }

    /* renamed from: b */
    public static String m69780b(String str, Context context) {
        StringBuilder sb2;
        String str2 = "phoneservice;Cloudwap";
        if (!C11842p.m70771U0() && !C11842p.m70735I0()) {
            str2 = "phoneservice;Cloudwap;Mobile";
        } else if (!TextUtils.isEmpty(str) && str.contains("Mobile")) {
            str = str.replace("Mobile", "");
        }
        if (str.endsWith(";")) {
            sb2 = new StringBuilder(str + str2);
        } else {
            sb2 = new StringBuilder(str + ";" + str2);
        }
        sb2.append(m69782d(context));
        sb2.append(m69783e());
        sb2.append(m69784f());
        sb2.append(m69781c());
        return sb2.toString();
    }

    /* renamed from: c */
    public static String m69781c() {
        return ";APILevel(" + C0219i.m1463a() + ")";
    }

    /* renamed from: d */
    public static String m69782d(Context context) {
        return ";appVersion(" + C1443a.f6213a + ")";
    }

    /* renamed from: e */
    public static String m69783e() {
        return ";romVersion(" + C11703j.m69813i() + ")";
    }

    /* renamed from: f */
    public static String m69784f() {
        return ";terminalType(" + Build.MODEL + ")";
    }
}
