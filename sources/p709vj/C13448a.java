package p709vj;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.cloud.base.util.C4633d0;
import p015ak.C0213f;
import p015ak.C0214f0;

@SuppressLint({"ApplySharedPref"})
/* renamed from: vj.a */
/* loaded from: classes5.dex */
public class C13448a {

    /* renamed from: c */
    public static final Object f60557c = new Object();

    /* renamed from: d */
    @SuppressLint({"StaticFieldLeak"})
    public static C13448a f60558d;

    /* renamed from: a */
    public SharedPreferences f60559a;

    /* renamed from: b */
    public Context f60560b;

    public C13448a(Context context) {
        this.f60560b = context;
        this.f60559a = C0214f0.m1382b(context, "account_h5_sp", 0);
    }

    /* renamed from: c */
    public static C13448a m80777c() {
        C13448a c13448a;
        synchronized (f60557c) {
            try {
                C13448a c13448a2 = f60558d;
                if (c13448a2 == null || c13448a2.f60560b == null || c13448a2.f60559a == null) {
                    f60558d = new C13448a(C0213f.m1377a());
                }
                c13448a = f60558d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c13448a;
    }

    /* renamed from: a */
    public void m80778a() {
        SharedPreferences sharedPreferences = this.f60559a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().commit();
        }
    }

    /* renamed from: b */
    public String m80779b(String str) {
        if (this.f60559a == null || C4633d0.m28404a(str)) {
            return null;
        }
        return this.f60559a.getString(str, null);
    }

    /* renamed from: d */
    public void m80780d(String str, String str2) {
        if (this.f60559a == null || C4633d0.m28404a(str)) {
            return;
        }
        this.f60559a.edit().putString(str, str2).commit();
    }
}
