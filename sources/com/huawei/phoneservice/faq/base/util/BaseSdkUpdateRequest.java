package com.huawei.phoneservice.faq.base.util;

import androidx.annotation.Keep;
import com.huawei.hms.network.httpclient.util.PreConnectManager;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes4.dex */
public abstract class BaseSdkUpdateRequest<T> implements SdkUpdateListener {

    /* renamed from: a */
    public T f38686a;

    /* renamed from: b */
    public Timer f38687b;

    @Keep
    public BaseSdkUpdateRequest(T t10) {
        this.f38686a = t10;
    }

    /* renamed from: a */
    public void m51807a() {
        Timer timer = this.f38687b;
        if (timer != null) {
            timer.cancel();
        }
    }

    /* renamed from: b */
    public void m51808b(TimerTask timerTask) {
        Timer timer = new Timer();
        this.f38687b = timer;
        timer.schedule(timerTask, PreConnectManager.CONNECT_SUCCESS_INTERNAL);
    }

    @Keep
    public abstract void onCallback(String str, String str2, String str3, T t10);

    @Override // com.huawei.phoneservice.faq.base.util.SdkUpdateListener
    public void onSdkUpdate(String str, String str2, String str3) {
        onCallback(str, str2, str3, this.f38686a);
    }
}
