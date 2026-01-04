package com.huawei.android.hicloud.cloudbackup.callable;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class CBCallBack {
    private static final String TAG = "CBCallBack";
    private static final Object LOCK = new Object();
    private static CBCallBack callBack = new CBCallBack();
    private volatile List<Handler.Callback> mCallbacks = new ArrayList();
    private volatile Handler callbackHandler = null;

    private CBCallBack() {
    }

    public static CBCallBack getInstance() {
        return callBack;
    }

    public boolean registerCallback(Handler.Callback callback) {
        synchronized (LOCK) {
            try {
                if (callback == null) {
                    return false;
                }
                C11839m.m70686d(TAG, "register callback");
                return this.mCallbacks.add(callback);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public synchronized void removeMessage(int i10) {
        if (this.callbackHandler != null) {
            this.callbackHandler.removeMessages(i10);
        }
    }

    public synchronized void sendMessage(Message message) {
        sendMessageDelayed(message, 0L);
    }

    public synchronized void sendMessageDelayed(Message message, long j10) {
        try {
            if (this.callbackHandler == null) {
                this.callbackHandler = new Handler(Looper.getMainLooper()) { // from class: com.huawei.android.hicloud.cloudbackup.callable.CBCallBack.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message2) {
                        synchronized (CBCallBack.LOCK) {
                            try {
                                Iterator it = CBCallBack.this.mCallbacks.iterator();
                                while (it.hasNext()) {
                                    ((Handler.Callback) it.next()).handleMessage(message2);
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    }
                };
            }
            this.callbackHandler.sendMessageDelayed(message, j10);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void unregisterCallback(Handler.Callback callback) {
        if (callback != null) {
            C11839m.m70686d(TAG, "unregister callback");
            synchronized (LOCK) {
                this.mCallbacks.remove(callback);
            }
        }
    }
}
