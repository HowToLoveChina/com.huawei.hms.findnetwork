package com.huawei.hms.ads.inner;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7687ti;
import com.huawei.openalliance.p169ad.inter.HiAd;
import p208cq.InterfaceC8936d;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;

/* renamed from: com.huawei.hms.ads.inner.a */
/* loaded from: classes8.dex */
public class C5077a {

    /* renamed from: com.huawei.hms.ads.inner.a$a */
    public static class a implements InterfaceC8936d {
        private a() {
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // p208cq.InterfaceC8936d
        public void onCanceled() {
            AbstractC7185ho.m43820b("LockScreenOpener", "unlock screen canceled.");
        }
    }

    /* renamed from: com.huawei.hms.ads.inner.a$b */
    public static class b implements InterfaceC8938f {
        private b() {
        }

        public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // p208cq.InterfaceC8938f
        public void onFailure(Exception exc) {
            AbstractC7185ho.m43821b("LockScreenOpener", "unlock fail, exception is %s.", exc.getMessage());
        }
    }

    /* renamed from: com.huawei.hms.ads.inner.a$c */
    public static class c implements InterfaceC8939g<Boolean> {

        /* renamed from: a */
        private final AbstractC7687ti f23214a;

        public c(AbstractC7687ti abstractC7687ti) {
            this.f23214a = abstractC7687ti;
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a */
        public void onSuccess(Boolean bool) {
            AbstractC7185ho.m43821b("LockScreenOpener", "onSuccess ret: %s.", bool);
            if (this.f23214a != null) {
                AbstractC7185ho.m43820b("LockScreenOpener", "action excute");
                this.f23214a.mo47233a();
            }
        }
    }

    /* renamed from: a */
    public static void m30321a(Context context, InterfaceC8939g<Boolean> interfaceC8939g) {
        AbstractC7185ho.m43820b("LockScreenOpener", "onLockScreenOpen.");
        try {
            if (!(context instanceof Activity)) {
                AbstractC7185ho.m43823c("LockScreenOpener", "param activity is not Activity!");
                interfaceC8939g.onSuccess(Boolean.TRUE);
                return;
            }
            Task<Boolean> taskM45027a = HiAd.getInstance(context).getAskForUnlockScreen().m45027a(context);
            taskM45027a.addOnSuccessListener(interfaceC8939g);
            taskM45027a.addOnCanceledListener(new a());
            taskM45027a.addOnFailureListener(new b());
            AbstractC7185ho.m43820b("LockScreenOpener", "task is set.");
        } catch (NullPointerException unused) {
            AbstractC7185ho.m43823c("LockScreenOpener", "get task err, NullPointerException");
            interfaceC8939g.onSuccess(Boolean.TRUE);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("LockScreenOpener", "listen task err: %s.", th2.getClass().getSimpleName());
        }
    }
}
