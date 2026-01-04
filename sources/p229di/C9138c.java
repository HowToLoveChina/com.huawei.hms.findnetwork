package p229di;

import p229di.C9142g;

/* renamed from: di.c */
/* loaded from: classes4.dex */
public class C9138c {
    /* renamed from: a */
    public static String m57454a() {
        try {
            return (String) C9142g.a.m57468c("com.huawei.system.BuildEx$OsBrand", new Class[0]).m57473h("EMUI").m57472f();
        } catch (Exception unused) {
            return "emui";
        }
    }

    /* renamed from: b */
    public static String m57455b() {
        try {
            return (String) C9142g.a.m57468c("com.huawei.system.BuildEx$OsBrand", new Class[0]).m57473h("HARMONY").m57472f();
        } catch (Exception unused) {
            return "harmony";
        }
    }

    /* renamed from: c */
    public static String m57456c() {
        try {
            return (String) C9142g.a.m57468c("com.huawei.system.BuildEx", new Class[0]).m57470d("getOsBrand", new Object[0]).m57472f();
        } catch (Exception unused) {
            return "";
        }
    }
}
