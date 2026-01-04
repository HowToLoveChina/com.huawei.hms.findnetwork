package com.huawei.hicloud.notification.task;

import cn.C1461a;
import com.huawei.hicloud.notification.manager.HiCloudWebViewPolicyManager;
import com.huawei.hicloud.service.C5005c0;
import fk.C9721b;
import p459lp.C11327e;
import p581qk.AbstractC12367d;

/* loaded from: classes6.dex */
public class HiCloudWebViewConfigTask extends AbstractC12367d {
    private static final String TAG = "HiCloudWebViewConfigTask";

    private void getConfig(C5005c0 c5005c0) {
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
                if (c5005c0.getLatestConfig()) {
                    C1461a.m8359i(TAG, "get hicloudWebView config success");
                    HiCloudWebViewPolicyManager.getInstance().reloadParseLocalFile();
                } else {
                    C1461a.m8358e(TAG, "get hicloudWebView config failed, retry num: " + i10);
                }
                return;
            } catch (C9721b e10) {
                C1461a.m8358e(TAG, "get hicloudWebView config exception: " + e10.getMessage());
                if (e10.m60659c() == 304) {
                    C1461a.m8358e(TAG, "HTTP_NOT_MODIFY extract webview allowlist config");
                } else if (c5005c0.isExceptionNeedRetry(e10)) {
                    C1461a.m8360w(TAG, "getLatestConfig exception retry, retry num: " + i10);
                }
            }
        }
    }

    private void getVersion() {
        long configVersion;
        C1461a.m8357d(TAG, "getVersion");
        C5005c0 c5005c0 = new C5005c0(null);
        int i10 = 0;
        while (true) {
            if (i10 > 2) {
                configVersion = 0;
                break;
            }
            try {
                configVersion = c5005c0.getConfigVersion();
                break;
            } catch (C9721b e10) {
                C1461a.m8358e(TAG, "get hicloudWebView config version exception: " + e10.getMessage());
                if (!c5005c0.isExceptionNeedRetry(e10)) {
                    return;
                }
                C1461a.m8359i(TAG, "get hicloudWebView config version exception retry, retry num: " + i10);
                i10++;
            }
        }
        long jM68063f = C11327e.m68063f("HiCloudWebViewAllownlist");
        C1461a.m8357d(TAG, "localVersion=" + jM68063f + ", latestVersion=" + configVersion);
        if (jM68063f >= configVersion) {
            C1461a.m8360w(TAG, "getVersion fail. localVersion >= latestVersion");
        } else {
            C1461a.m8359i(TAG, "hicloudWebView version updated, query config");
            getConfig(c5005c0);
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        getVersion();
    }
}
