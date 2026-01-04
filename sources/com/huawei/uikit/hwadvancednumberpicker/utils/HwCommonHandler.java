package com.huawei.uikit.hwadvancednumberpicker.utils;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class HwCommonHandler extends Handler {

    /* renamed from: a */
    private WeakReference<MessageHandler> f41044a;

    public interface MessageHandler {
        void handleMessage(Message message);
    }

    public HwCommonHandler(MessageHandler messageHandler) {
        this.f41044a = new WeakReference<>(messageHandler);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        MessageHandler messageHandler = this.f41044a.get();
        if (messageHandler != null) {
            messageHandler.handleMessage(message);
        }
    }
}
