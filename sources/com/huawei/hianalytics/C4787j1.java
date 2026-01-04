package com.huawei.hianalytics;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.UserManager;
import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.core.log.HiLog;

/* renamed from: com.huawei.hianalytics.j1 */
/* loaded from: classes5.dex */
public class C4787j1 {

    /* renamed from: a */
    public static final C4787j1 f21836a = new C4787j1();

    /* renamed from: a */
    public boolean f21837a = false;

    @TargetApi(24)
    /* renamed from: a */
    public boolean m28952a() {
        if (this.f21837a) {
            return true;
        }
        Context appContext = EnvUtils.getAppContext();
        if (appContext == null) {
            return false;
        }
        try {
            UserManager userManager = (UserManager) appContext.getSystemService("user");
            if (userManager != null) {
                this.f21837a = userManager.isUserUnlocked();
            } else {
                this.f21837a = false;
            }
        } catch (Exception unused) {
            this.f21837a = false;
            HiLog.m28808e("UserManagerPro", "user locked exception");
        }
        return this.f21837a;
    }
}
