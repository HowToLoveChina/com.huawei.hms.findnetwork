package sd;

import android.content.Context;
import gp.C10028c;
import java.util.concurrent.CountDownLatch;
import p015ak.C0209d;
import p015ak.C0212e0;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* renamed from: sd.a */
/* loaded from: classes3.dex */
public class C12778a extends AbstractC12367d {

    /* renamed from: a */
    public Context f58429a;

    /* renamed from: b */
    public CountDownLatch f58430b;

    public C12778a(Context context, CountDownLatch countDownLatch) {
        this.f58429a = context;
        this.f58430b = countDownLatch;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.concurrent.CountDownLatch] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.concurrent.CountDownLatch] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.concurrent.CountDownLatch] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        ?? r62;
        ?? r63;
        C11839m.m70688i("RestSettingsTask", "RestSettingsTask call");
        try {
            try {
                C0212e0.m1366p(this.f58429a, "hicloud_settings_status", "settings_success", false);
                C0212e0.m1371u(this.f58429a, "hicloud_settings_status", "last_config_time", 0L);
                C11829c.m70621u1(this.f58429a);
                C0209d.m1334z2(this.f58429a, "hicloud_cloudPhoto_nmd", C10028c.m62182c0().m62424z0());
                r63 = this.f58430b;
                r62 = r63;
                this = r63;
            } catch (Exception e10) {
                C11839m.m70687e("RestSettingsTask", "setSettingsLogOff error: " + e10.toString());
                ?? r64 = this.f58430b;
                r62 = r64;
                this = r64;
                if (r64 != 0) {
                }
            }
            if (r63 != 0) {
                r62.countDown();
                this = r62;
            }
        } catch (Throwable th2) {
            CountDownLatch countDownLatch = this.f58430b;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            throw th2;
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.EXIT;
    }
}
