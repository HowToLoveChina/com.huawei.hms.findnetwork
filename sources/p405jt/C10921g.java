package p405jt;

import android.content.Context;
import com.huawei.hms.support.log.KitLog;
import p434kt.AbstractC11150d;
import p434kt.AbstractC11153g;

/* renamed from: jt.g */
/* loaded from: classes2.dex */
public class C10921g {

    /* renamed from: d */
    public static volatile C10921g f51806d;

    /* renamed from: e */
    public static final byte[] f51807e = new byte[0];

    /* renamed from: a */
    public KitLog f51808a;

    /* renamed from: b */
    public boolean f51809b = false;

    /* renamed from: c */
    public int f51810c = 4;

    public C10921g() {
        if (AbstractC11150d.m67064a("com.huawei.hms.support.log.KitLog")) {
            this.f51808a = new KitLog();
        }
    }

    /* renamed from: a */
    public static C10921g m66006a() {
        if (f51806d == null) {
            synchronized (f51807e) {
                try {
                    if (f51806d == null) {
                        f51806d = new C10921g();
                    }
                } finally {
                }
            }
        }
        return f51806d;
    }

    /* renamed from: b */
    public void m66007b(Context context, int i10, String str) {
        KitLog kitLog = this.f51808a;
        if (kitLog != null && context != null) {
            kitLog.init(context.getApplicationContext(), i10, str);
        }
        this.f51810c = i10;
        this.f51809b = true;
    }

    /* renamed from: c */
    public void m66008c(String str, String str2) {
        KitLog kitLog = this.f51808a;
        if (kitLog != null) {
            kitLog.d(str, str2);
        }
    }

    /* renamed from: d */
    public boolean m66009d(int i10) {
        return this.f51809b && i10 >= this.f51810c;
    }

    /* renamed from: e */
    public void m66010e(String str, String str2) {
        KitLog kitLog = this.f51808a;
        if (kitLog != null) {
            kitLog.e(str, str2);
        }
    }

    /* renamed from: f */
    public void m66011f(String str, String str2, Object... objArr) {
        if (this.f51808a != null) {
            m66010e(str, AbstractC11153g.m67072b(str2, objArr));
        }
    }

    /* renamed from: g */
    public void m66012g(String str, String str2) {
        KitLog kitLog = this.f51808a;
        if (kitLog != null) {
            kitLog.i(str, str2);
        }
    }

    /* renamed from: h */
    public void m66013h(String str, String str2, Object... objArr) {
        if (this.f51808a != null) {
            m66012g(str, AbstractC11153g.m67072b(str2, objArr));
        }
    }

    /* renamed from: i */
    public void m66014i(String str, String str2) {
        KitLog kitLog = this.f51808a;
        if (kitLog != null) {
            kitLog.w(str, str2);
        }
    }

    /* renamed from: j */
    public void m66015j(String str, String str2, Object... objArr) {
        if (this.f51808a != null) {
            m66014i(str, AbstractC11153g.m67072b(str2, objArr));
        }
    }
}
