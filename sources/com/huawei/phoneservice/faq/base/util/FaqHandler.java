package com.huawei.phoneservice.faq.base.util;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.Keep;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class FaqHandler extends Handler {

    /* renamed from: a */
    public WeakReference<CallBack> f38695a;

    @FunctionalInterface
    @Keep
    public interface CallBack {
        void handleMessage(int i10, Message message);
    }

    @Keep
    public FaqHandler(CallBack callBack) {
        if (callBack != null) {
            this.f38695a = new WeakReference<>(callBack);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        CallBack callBack;
        super.handleMessage(message);
        WeakReference<CallBack> weakReference = this.f38695a;
        if (weakReference == null || (callBack = weakReference.get()) == null) {
            return;
        }
        callBack.handleMessage(message.what, message);
    }
}
