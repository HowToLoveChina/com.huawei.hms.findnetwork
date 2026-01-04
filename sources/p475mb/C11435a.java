package p475mb;

import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.service.C5021o;
import fk.C9721b;
import p292fn.C9734g;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* renamed from: mb.a */
/* loaded from: classes3.dex */
public class C11435a extends AbstractC12367d {

    /* renamed from: c */
    public static final Object f53275c = new Object();

    /* renamed from: a */
    public C5021o f53276a;

    /* renamed from: b */
    public String f53277b;

    public C11435a(String str) {
        this.f53277b = str;
    }

    /* renamed from: c */
    private void m68489c() {
        C11839m.m70688i("QueryGuideInfoConfigTask", "downloadConfig");
        if (this.f53276a == null) {
            this.f53276a = new C5021o(null);
        }
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                C11839m.m70687e("QueryGuideInfoConfigTask", "getLatestConfig exception: " + e10.toString());
                if (NotifyUtil.procFlowControlException(e10, "HiCloudOperPageHints")) {
                    return;
                }
                if (e10.m60659c() == 304) {
                    C11839m.m70688i("QueryGuideInfoConfigTask", "getLatestConfig HTTP_NOT_MODIFY");
                    return;
                } else {
                    if (!this.f53276a.isExceptionNeedRetry(e10) || i10 >= 2) {
                        return;
                    }
                    C11839m.m70688i("QueryGuideInfoConfigTask", "getLatestConfig exception retry, retry num: " + i10);
                }
            }
            if (this.f53276a.getLatestConfig()) {
                C11839m.m70688i("QueryGuideInfoConfigTask", "getLatestConfig OK");
                C9734g.m60767a().m60769c("HiCloudOperPageHints");
                return;
            }
            C11839m.m70687e("QueryGuideInfoConfigTask", "getLatestConfig failed");
            if (i10 >= 2) {
                return;
            }
            C11839m.m70688i("QueryGuideInfoConfigTask", "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        if (p459lp.C11327e.m68063f("HiCloudOperPageHints") >= r2) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0066, code lost:
    
        p514o9.C11839m.m70688i("QueryGuideInfoConfigTask", "version updated, query config");
        m68489c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006f, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
    
        p514o9.C11839m.m70688i("QueryGuideInfoConfigTask", "version not update, update view");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0075, code lost:
    
        return false;
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m68490d() {
        /*
            r7 = this;
            java.lang.String r0 = "queryConfigVersion"
            java.lang.String r1 = "QueryGuideInfoConfigTask"
            p514o9.C11839m.m70688i(r1, r0)
            com.huawei.hicloud.service.o r0 = r7.f53276a
            if (r0 != 0) goto L13
            com.huawei.hicloud.service.o r0 = new com.huawei.hicloud.service.o
            r2 = 0
            r0.<init>(r2)
            r7.f53276a = r0
        L13:
            r0 = 0
            r2 = r0
        L15:
            r3 = 2
            if (r2 > r3) goto L5a
            com.huawei.hicloud.service.o r4 = r7.f53276a     // Catch: fk.C9721b -> L1f
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
            com.huawei.hicloud.service.o r5 = r7.f53276a
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
            java.lang.String r4 = "HiCloudOperPageHints"
            long r4 = p459lp.C11327e.m68063f(r4)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L70
            java.lang.String r0 = "version updated, query config"
            p514o9.C11839m.m70688i(r1, r0)
            r7.m68489c()
            r7 = 1
            return r7
        L70:
            java.lang.String r7 = "version not update, update view"
            p514o9.C11839m.m70688i(r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p475mb.C11435a.m68490d():boolean");
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        synchronized (f53275c) {
            try {
                if (this.f53277b.equals("get_version")) {
                    m68490d();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.QUERY_GUIDE_H5_TASK;
    }
}
