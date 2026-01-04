package com.huawei.updatesdk.service.otaupdate;

import android.content.Intent;
import com.huawei.updatesdk.p177a.p178a.C8774a;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.updatesdk.service.otaupdate.d */
/* loaded from: classes9.dex */
public class C8869d {

    /* renamed from: a */
    private WeakReference<CheckUpdateCallBack> f45242a;

    /* renamed from: com.huawei.updatesdk.service.otaupdate.d$a */
    public static class a {

        /* renamed from: a */
        private static final C8869d f45243a = new C8869d();
    }

    /* renamed from: a */
    public static C8869d m56446a() {
        return a.f45243a;
    }

    /* renamed from: b */
    public void m56450b(Intent intent) {
        String str;
        WeakReference<CheckUpdateCallBack> weakReference = this.f45242a;
        if (weakReference != null) {
            CheckUpdateCallBack checkUpdateCallBack = weakReference.get();
            if (checkUpdateCallBack != null) {
                checkUpdateCallBack.onUpdateInfo(intent);
                return;
            }
            str = "setUpdateCallBackMsg callBack is null";
        } else {
            str = "setUpdateCallBackMsg updateCallBack is null";
        }
        C8774a.m56010c("CallbackManager", str);
    }

    /* renamed from: a */
    public void m56447a(int i10) {
        String str;
        WeakReference<CheckUpdateCallBack> weakReference = this.f45242a;
        if (weakReference != null) {
            CheckUpdateCallBack checkUpdateCallBack = weakReference.get();
            if (checkUpdateCallBack != null) {
                checkUpdateCallBack.onMarketStoreError(i10);
                return;
            }
            str = "setGetMarketInfoCallBack callBack is null";
        } else {
            str = "setGetMarketInfoCallBack updateCallBack is null";
        }
        C8774a.m56010c("CallbackManager", str);
    }

    /* renamed from: a */
    public void m56448a(Intent intent) {
        CheckUpdateCallBack checkUpdateCallBack;
        WeakReference<CheckUpdateCallBack> weakReference = this.f45242a;
        if (weakReference == null || (checkUpdateCallBack = weakReference.get()) == null) {
            return;
        }
        checkUpdateCallBack.onMarketInstallInfo(intent);
    }

    /* renamed from: a */
    public void m56449a(CheckUpdateCallBack checkUpdateCallBack) {
        this.f45242a = new WeakReference<>(checkUpdateCallBack);
    }
}
