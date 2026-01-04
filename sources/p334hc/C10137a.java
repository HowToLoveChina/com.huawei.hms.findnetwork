package p334hc;

import android.content.Context;
import android.content.Intent;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.service.C5010f;
import fk.C9721b;
import p015ak.C0213f;
import p292fn.C9734g;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p664u0.C13108a;

/* renamed from: hc.a */
/* loaded from: classes3.dex */
public class C10137a extends AbstractC12367d {

    /* renamed from: d */
    public static final Object f49426d = new Object();

    /* renamed from: a */
    public Context f49427a = C0213f.m1377a();

    /* renamed from: b */
    public C5010f f49428b;

    /* renamed from: c */
    public String f49429c;

    public C10137a(String str) {
        this.f49429c = str;
    }

    /* renamed from: c */
    private void m63182c() {
        C11839m.m70688i("QuerySafeInfoTask", "downloadConfig");
        if (this.f49428b == null) {
            this.f49428b = new C5010f(null);
        }
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                C11839m.m70687e("QuerySafeInfoTask", "getLatestConfig exception: " + e10.toString());
                if (NotifyUtil.procFlowControlException(e10, "HiCloudFooterLink")) {
                    return;
                }
                if (e10.m60659c() == 304) {
                    m63184e();
                    return;
                } else {
                    if (!this.f49428b.isExceptionNeedRetry(e10) || i10 >= 2) {
                        return;
                    }
                    C11839m.m70688i("QuerySafeInfoTask", "getLatestConfig exception retry, retry num: " + i10);
                }
            }
            if (this.f49428b.getLatestConfig()) {
                C9734g.m60767a().m60769c("HiCloudFooterLink");
                m63184e();
                return;
            }
            C11839m.m70687e("QuerySafeInfoTask", "getLatestConfig failed");
            if (i10 >= 2) {
                return;
            }
            C11839m.m70688i("QuerySafeInfoTask", "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        if (p459lp.C11327e.m68063f("HiCloudFooterLink") >= r2) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0066, code lost:
    
        p514o9.C11839m.m70688i("QuerySafeInfoTask", "version updated, query config");
        m63182c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006f, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
    
        p514o9.C11839m.m70688i("QuerySafeInfoTask", "version not update, update view");
        m63184e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0078, code lost:
    
        return false;
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m63183d() {
        /*
            r7 = this;
            java.lang.String r0 = "queryConfigVersion"
            java.lang.String r1 = "QuerySafeInfoTask"
            p514o9.C11839m.m70688i(r1, r0)
            com.huawei.hicloud.service.f r0 = r7.f49428b
            if (r0 != 0) goto L13
            com.huawei.hicloud.service.f r0 = new com.huawei.hicloud.service.f
            r2 = 0
            r0.<init>(r2)
            r7.f49428b = r0
        L13:
            r0 = 0
            r2 = r0
        L15:
            r3 = 2
            if (r2 > r3) goto L5a
            com.huawei.hicloud.service.f r4 = r7.f49428b     // Catch: fk.C9721b -> L1f
            long r2 = r4.getConfigVersion()     // Catch: fk.C9721b -> L1f
            goto L5c
        L1f:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "queryConfigVersion exception: "
            r5.append(r6)
            java.lang.String r6 = r4.toString()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            p514o9.C11839m.m70687e(r1, r5)
            com.huawei.hicloud.service.f r5 = r7.f49428b
            boolean r4 = r5.isExceptionNeedRetry(r4)
            if (r4 == 0) goto L59
            if (r2 >= r3) goto L59
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "queryConfigVersion exception retry, retry num: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            p514o9.C11839m.m70688i(r1, r3)
            int r2 = r2 + 1
            goto L15
        L59:
            return r0
        L5a:
            r2 = 0
        L5c:
            java.lang.String r4 = "HiCloudFooterLink"
            long r4 = p459lp.C11327e.m68063f(r4)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L70
            java.lang.String r0 = "version updated, query config"
            p514o9.C11839m.m70688i(r1, r0)
            r7.m63182c()
            r7 = 1
            return r7
        L70:
            java.lang.String r2 = "version not update, update view"
            p514o9.C11839m.m70688i(r1, r2)
            r7.m63184e()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p334hc.C10137a.m63183d():boolean");
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        synchronized (f49426d) {
            try {
                if (this.f49429c.equals("get_version")) {
                    m63183d();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: e */
    public final void m63184e() {
        C13108a.m78878b(this.f49427a).m78881d(new Intent("com.huawei.hicloud.intent.action.SAFE_INFO_CONFIG_SUCCESS"));
    }
}
