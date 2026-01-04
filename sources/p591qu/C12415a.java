package p591qu;

import com.huawei.hmf.tasks.Task;
import com.huawei.wearengine.auth.Permission;
import java.util.concurrent.Callable;
import p208cq.C8943k;
import su.C12860b;

/* renamed from: qu.a */
/* loaded from: classes9.dex */
public class C12415a {

    /* renamed from: b */
    public static volatile C12415a f57241b;

    /* renamed from: a */
    public C12416b f57242a = C12416b.m74554c();

    /* renamed from: qu.a$a */
    public class a implements Callable<Boolean> {

        /* renamed from: a */
        public final /* synthetic */ Permission f57243a;

        public a(Permission permission) {
            this.f57243a = permission;
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() {
            C12860b.m77201e(this.f57243a, "Permission can not be null!");
            return Boolean.valueOf(C12415a.this.f57242a.m74556d(this.f57243a));
        }
    }

    /* renamed from: c */
    public static C12415a m74550c() {
        if (f57241b == null) {
            synchronized (C12415a.class) {
                try {
                    if (f57241b == null) {
                        f57241b = new C12415a();
                    }
                } finally {
                }
            }
        }
        return f57241b;
    }

    /* renamed from: b */
    public Task<Boolean> m74551b(Permission permission) {
        return C8943k.m56662b(new a(permission));
    }
}
