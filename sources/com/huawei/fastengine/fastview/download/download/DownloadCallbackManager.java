package com.huawei.fastengine.fastview.download.download;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class DownloadCallbackManager {
    private static DownloadCallbackManager instance = new DownloadCallbackManager();
    private Map<String, CallbackResult> callbacks = new HashMap();
    private int callbackId = 0;

    public interface CallbackResult {
        public static final int COMPLETED = 0;
        public static final int FAILURE = 2;
        public static final int USER_CANCEL = 1;

        void onCallback(int i10);
    }

    private DownloadCallbackManager() {
    }

    public static DownloadCallbackManager getInstance() {
        return instance;
    }

    public synchronized String add(CallbackResult callbackResult) {
        this.callbackId++;
        this.callbacks.put(this.callbackId + "", callbackResult);
        return this.callbackId + "";
    }

    public synchronized void close() {
        this.callbacks.clear();
    }

    public synchronized void consume(String str, int i10) {
        CallbackResult callbackResultRemove = this.callbacks.remove(str);
        if (callbackResultRemove != null) {
            callbackResultRemove.onCallback(i10);
        }
    }
}
