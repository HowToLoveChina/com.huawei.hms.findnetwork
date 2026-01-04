package p372ip;

import android.content.Context;
import android.content.Intent;
import cn.C1461a;
import com.huawei.hicloud.bean.HiCloudSysParamMapCache;
import com.huawei.hicloud.service.C5003b0;
import fk.C9721b;
import java.util.concurrent.CountDownLatch;
import p015ak.C0209d;
import p015ak.C0213f;
import p292fn.C9728a;
import p292fn.C9733f;
import p292fn.C9735h;
import p459lp.C11326d;
import p459lp.C11327e;
import p581qk.AbstractC12367d;
import p664u0.C13108a;
import p846zj.C14306d;

/* renamed from: ip.d */
/* loaded from: classes7.dex */
public class C10586d extends AbstractC12367d {

    /* renamed from: a */
    public CountDownLatch f50938a;

    public C10586d() {
        this.f50938a = null;
    }

    private void getVersion() {
        long configVersion;
        C5003b0 c5003b0 = new C5003b0(null);
        int i10 = 0;
        while (true) {
            if (i10 > 2) {
                configVersion = 0;
                break;
            }
            try {
                configVersion = c5003b0.getConfigVersion();
                break;
            } catch (C9721b e10) {
                C1461a.m8358e("HiCloudSysParamConfigTask", "get hicloudSysParam config version exception: " + e10.toString());
                if (!c5003b0.isExceptionNeedRetry(e10) || i10 >= 2) {
                    C9733f.m60705z().m60742f0();
                    return;
                }
                C1461a.m8359i("HiCloudSysParamConfigTask", "get hicloudSysParam config version exception retry, retry num: " + i10);
                i10++;
            }
        }
        if (C11327e.m68063f("HiCloudSysParam") >= configVersion) {
            C1461a.m8360w("HiCloudSysParamConfigTask", "getVersion fail. localVersion > latestVersion");
        } else {
            C1461a.m8359i("HiCloudSysParamConfigTask", "hicloudSysParam version updated, query config");
            m64962c(c5003b0);
        }
    }

    /* renamed from: c */
    public final void m64962c(C5003b0 c5003b0) {
        if (c5003b0 == null) {
            c5003b0 = new C5003b0(null);
        }
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                C1461a.m8358e("HiCloudSysParamConfigTask", "get hicloudSysParam config exception: " + e10.toString());
                if (e10.m60659c() == 304) {
                    C1461a.m8358e("HiCloudSysParamConfigTask", "HTTP_NOT_MODIFY extract sync module config");
                } else if (c5003b0.isExceptionNeedRetry(e10) && i10 < 2) {
                    C1461a.m8359i("HiCloudSysParamConfigTask", "getLatestConfig exception retry, retry num: " + i10);
                }
                C9733f.m60705z().m60742f0();
                return;
            }
            if (c5003b0.getLatestConfig()) {
                C1461a.m8359i("HiCloudSysParamConfigTask", "get hicloudSysParam config success");
                C9733f.m60705z().m60749j();
                m64963d();
                C9728a.m60681f().m60691k(true);
                HiCloudSysParamMapCache.refreshSysParamMapCache();
                C9735h.m60771f().m60775d();
                C14306d.m85216q(C11326d.m68045g());
                return;
            }
            C1461a.m8358e("HiCloudSysParamConfigTask", "get hicloudSysParam config failed");
            if (i10 >= 2) {
                C9733f.m60705z().m60742f0();
                return;
            }
            C1461a.m8359i("HiCloudSysParamConfigTask", "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        try {
            try {
                getVersion();
            } catch (Exception e10) {
                C1461a.m8358e("HiCloudSysParamConfigTask", "HiCloudSysParamConfigTask error" + e10.toString());
            }
        } finally {
            C0209d.m1275l(this.f50938a);
        }
    }

    /* renamed from: d */
    public final void m64963d() {
        Intent intent = new Intent("com.huawei.android.hicloud.intent.omconfigupdate");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C1461a.m8358e("HiCloudSysParamConfigTask", "context is null");
        } else {
            C13108a.m78878b(contextM1377a).m78881d(intent);
        }
    }

    public C10586d(CountDownLatch countDownLatch) {
        this.f50938a = countDownLatch;
    }
}
