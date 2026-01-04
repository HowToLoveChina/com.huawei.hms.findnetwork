package com.huawei.updatesdk.p177a.p178a.p183d.p184i;

import android.content.Context;
import com.huawei.updatesdk.p177a.p178a.p183d.C8784f;
import com.huawei.updatesdk.p177a.p186b.p189c.p190c.AbstractC8799b;
import java.util.ArrayList;
import java.util.Set;

/* renamed from: com.huawei.updatesdk.a.a.d.i.b */
/* loaded from: classes9.dex */
public class C8788b extends AbstractC8799b {
    private String abis_;
    private String deviceFeatures_;
    private int dpi_;
    private String preferLan_;

    /* renamed from: com.huawei.updatesdk.a.a.d.i.b$b */
    public static class b {

        /* renamed from: a */
        private final Context f45083a;

        /* renamed from: b */
        private boolean f45084b;

        /* renamed from: c */
        private Set<String> f45085c;

        /* renamed from: d */
        private String[] f45086d;

        /* renamed from: e */
        private boolean f45087e;

        public b(Context context) {
            this.f45083a = context;
        }

        /* renamed from: b */
        private String m56083b() {
            ArrayList arrayList = new ArrayList(C8789c.m56099c(this.f45083a));
            Set<String> set = this.f45085c;
            if (set != null) {
                for (String str : set) {
                    if (!arrayList.contains(str)) {
                        arrayList.add(str);
                    }
                }
            }
            return this.f45087e ? C8784f.m56056a(C8789c.m56090a(arrayList, this.f45086d), ",") : C8784f.m56056a(arrayList, ",");
        }

        /* renamed from: a */
        public b m56084a(boolean z10) {
            this.f45084b = z10;
            return this;
        }

        /* renamed from: a */
        public C8788b m56085a() {
            C8788b c8788b = new C8788b();
            c8788b.abis_ = C8784f.m56058a(C8789c.m56111i(), ",");
            c8788b.dpi_ = Integer.parseInt(C8789c.m56103e(this.f45083a));
            c8788b.preferLan_ = m56083b();
            if (this.f45084b) {
                c8788b.deviceFeatures_ = C8789c.m56087a(this.f45083a);
            }
            return c8788b;
        }
    }

    private C8788b() {
    }
}
