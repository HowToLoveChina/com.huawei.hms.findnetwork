package p257eh;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.appgallery.coreservice.C4565h;
import com.huawei.hms.framework.network.grs.GrsApp;

/* renamed from: eh.h */
/* loaded from: classes4.dex */
public class C9486h {

    /* renamed from: c */
    public static final Object f47259c = new Object();

    /* renamed from: d */
    public static C9486h f47260d;

    /* renamed from: a */
    public String f47261a = "";

    /* renamed from: b */
    public String f47262b = "";

    /* renamed from: a */
    public static C9486h m59338a() {
        C9486h c9486h;
        synchronized (f47259c) {
            try {
                if (f47260d == null) {
                    f47260d = new C9486h();
                }
                c9486h = f47260d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c9486h;
    }

    /* renamed from: b */
    public String m59339b(Context context) {
        String strM59336a = new C4565h(context).m59336a("grs_app_name", "");
        this.f47262b = strM59336a;
        return strM59336a;
    }

    /* renamed from: c */
    public void m59340c(Context context, String str) {
        if (str == null) {
            str = "";
        }
        if (this.f47262b.equals(str)) {
            return;
        }
        this.f47262b = str;
        new C4565h(context).m59337b("grs_app_name", str);
    }

    /* renamed from: d */
    public String m59341d(Context context) {
        String strM59336a = new C4565h(context).m59336a("hc", "");
        this.f47261a = strM59336a;
        if (TextUtils.isEmpty(strM59336a)) {
            this.f47261a = GrsApp.getInstance().getIssueCountryCode(context);
        }
        return this.f47261a;
    }

    /* renamed from: e */
    public void m59342e(Context context, String str) {
        if (str == null) {
            str = "";
        }
        if (this.f47261a.equals(str)) {
            return;
        }
        this.f47261a = str;
        new C4565h(context).m59337b("hc", str);
    }
}
