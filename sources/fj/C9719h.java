package fj;

import com.huawei.cloud.pay.p098ui.activity.BasePayActivity;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: fj.h */
/* loaded from: classes5.dex */
public class C9719h {

    /* renamed from: b */
    public static C9719h f47945b;

    /* renamed from: a */
    public ArrayList<BasePayActivity> f47946a = new ArrayList<>();

    /* renamed from: d */
    public static synchronized C9719h m60646d() {
        try {
            if (f47945b == null) {
                f47945b = new C9719h();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f47945b;
    }

    /* renamed from: e */
    public static void m60647e() {
        C9719h c9719h = f47945b;
        if (c9719h != null) {
            c9719h.m60649b();
        }
        f47945b = null;
    }

    /* renamed from: a */
    public void m60648a(BasePayActivity basePayActivity) {
        this.f47946a.add(basePayActivity);
    }

    /* renamed from: b */
    public final void m60649b() {
        this.f47946a.clear();
    }

    /* renamed from: c */
    public void m60650c() {
        Iterator<BasePayActivity> it = this.f47946a.iterator();
        while (it.hasNext()) {
            it.next().finish();
        }
        m60649b();
    }

    /* renamed from: f */
    public void m60651f(BasePayActivity basePayActivity) {
        this.f47946a.remove(basePayActivity);
    }
}
