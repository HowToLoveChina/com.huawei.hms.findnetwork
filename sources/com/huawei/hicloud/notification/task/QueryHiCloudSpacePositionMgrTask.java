package com.huawei.hicloud.notification.task;

import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.service.C5032z;
import fk.C9721b;
import p292fn.C9734g;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* loaded from: classes6.dex */
public class QueryHiCloudSpacePositionMgrTask extends AbstractC12367d {
    private static final String TAG = "QueryHiCloudSpacePositionMgrTask";

    private void getConfig(C5032z c5032z) {
        if (c5032z == null) {
            c5032z = new C5032z(null);
        }
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "get config exception: " + e10.toString());
                if (NotifyUtil.procFlowControlException(e10, "HiCloudSpacePositionMgr")) {
                    return;
                }
                if (e10.m60659c() == 304) {
                    NotifyLogger.m29914e(TAG, "HTTP_NOT_MODIFY extract sync module config");
                    return;
                } else {
                    if (!c5032z.isExceptionNeedRetry(e10) || i10 >= 2) {
                        return;
                    }
                    NotifyLogger.m29915i(TAG, "getConfig exception retry, retry num: " + i10);
                }
            }
            if (c5032z.getLatestConfig()) {
                NotifyLogger.m29915i(TAG, "get config success");
                C9734g.m60767a().m60769c("HiCloudSpacePositionMgr");
                return;
            }
            NotifyLogger.m29914e(TAG, "get config fail");
            if (i10 >= 2) {
                return;
            }
            NotifyLogger.m29915i(TAG, "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0059, code lost:
    
        if (p459lp.C11327e.m68063f("HiCloudSpacePositionMgr") >= r2) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i(com.huawei.hicloud.notification.task.QueryHiCloudSpacePositionMgrTask.TAG, "version updated, query config");
        getConfig(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0064, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i(com.huawei.hicloud.notification.task.QueryHiCloudSpacePositionMgrTask.TAG, "version not updated");
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0069, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void getConfigVersion() {
        /*
            r7 = this;
            java.lang.String r0 = "getConfigVersion"
            java.lang.String r1 = "QueryHiCloudSpacePositionMgrTask"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            com.huawei.hicloud.service.z r0 = new com.huawei.hicloud.service.z
            r2 = 0
            r0.<init>(r2)
            r2 = 0
        Le:
            r3 = 2
            if (r2 > r3) goto L4f
            long r2 = r0.getConfigVersion()     // Catch: fk.C9721b -> L16
            goto L51
        L16:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "getConfigVersion exception: "
            r5.append(r6)
            java.lang.String r6 = r4.toString()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r1, r5)
            boolean r4 = r0.isExceptionNeedRetry(r4)
            if (r4 == 0) goto L4e
            if (r2 >= r3) goto L4e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getConfigVersion exception retry, retry num: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r3)
            int r2 = r2 + 1
            goto Le
        L4e:
            return
        L4f:
            r2 = 0
        L51:
            java.lang.String r4 = "HiCloudSpacePositionMgr"
            long r4 = p459lp.C11327e.m68063f(r4)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L64
            java.lang.String r2 = "version updated, query config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r2)
            r7.getConfig(r0)
            goto L69
        L64:
            java.lang.String r7 = "version not updated"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r7)
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.task.QueryHiCloudSpacePositionMgrTask.getConfigVersion():void");
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        getConfigVersion();
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.RECOMMEND_CARD;
    }
}
