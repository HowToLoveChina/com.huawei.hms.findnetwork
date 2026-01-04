package p530oq;

import android.content.Context;

/* renamed from: oq.c */
/* loaded from: classes8.dex */
public class C11990c extends C11989b {

    /* renamed from: d */
    public static C11990c f55782d;

    public C11990c(Context context, String str) {
        super(context, str);
    }

    /* renamed from: k */
    public static synchronized C11990c m72144k(Context context) {
        try {
            if (f55782d == null) {
                f55782d = new C11990c(context, "com.huawei.hwid.site_list_info");
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f55782d;
    }
}
