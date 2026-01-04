package com.huawei.hms.findnetwork.comm.log;

import android.text.TextUtils;
import com.huawei.hms.app.CoreApplication;
import com.huawei.hms.support.log.KitLog;

/* loaded from: classes8.dex */
public class ApkLogImpl {
    private static final String DEFAULT_COMMON_TAG = "HmsFindNetworkCommonLog_61502320_";
    private static final KitLog HMS_KIT_LOG;
    private static final int LOG_PRIORITY_DEBUG = 3;
    private static final int LOG_PRIORITY_INFO = 4;
    private volatile String mCommonTag = DEFAULT_COMMON_TAG;

    static {
        KitLog kitLog = new KitLog();
        HMS_KIT_LOG = kitLog;
        kitLog.init(CoreApplication.getCoreBaseContext(), 4, "FindNetwork");
    }

    /* renamed from: d */
    public void m31918d(String str, String str2) {
        TextUtils.isEmpty(str2);
    }

    /* renamed from: e */
    public void m31919e(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        HMS_KIT_LOG.e(this.mCommonTag + str, str2);
    }

    /* renamed from: i */
    public void m31921i(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        HMS_KIT_LOG.i(this.mCommonTag + str, str2);
    }

    public void init(String str) {
        this.mCommonTag = str;
    }

    /* renamed from: w */
    public void m31922w(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        HMS_KIT_LOG.w(this.mCommonTag + str, str2);
    }

    /* renamed from: e */
    public void m31920e(String str, String str2, Throwable th2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        HMS_KIT_LOG.e(this.mCommonTag + str, str2, th2);
    }
}
