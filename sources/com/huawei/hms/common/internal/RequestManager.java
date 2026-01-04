package com.huawei.hms.common.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes8.dex */
public class RequestManager implements Handler.Callback {
    public static final int NOTIFY_CONNECT_FAILED = 10012;
    public static final int NOTIFY_CONNECT_SUCCESS = 10011;
    public static final int NOTIFY_CONNECT_SUSPENDED = 10013;

    /* renamed from: b */
    private static volatile RequestManager f23500b;

    /* renamed from: c */
    private static Handler f23501c;

    /* renamed from: a */
    private static final Object f23499a = new Object();

    /* renamed from: d */
    private static Queue<HuaweiApi.RequestHandler> f23502d = new ConcurrentLinkedQueue();

    /* renamed from: e */
    private static Map<String, HuaweiApi.RequestHandler> f23503e = new LinkedHashMap();

    private RequestManager(Looper looper) {
        f23501c = new Handler(looper, this);
    }

    public static void addRequestToQueue(HuaweiApi.RequestHandler requestHandler) {
        f23502d.add(requestHandler);
    }

    public static void addToConnectedReqMap(final String str, final HuaweiApi.RequestHandler requestHandler) {
        if (f23501c == null) {
            return;
        }
        HMSLog.m36988i("RequestManager", "addToConnectedReqMap");
        f23501c.post(new Runnable() { // from class: com.huawei.hms.common.internal.RequestManager.1
            @Override // java.lang.Runnable
            public void run() {
                RequestManager.f23503e.put(str, requestHandler);
            }
        });
    }

    /* renamed from: b */
    private void m30696b() {
        while (!f23502d.isEmpty()) {
            HuaweiApi.RequestHandler requestHandlerPoll = f23502d.poll();
            if (requestHandlerPoll != null) {
                Object client = requestHandlerPoll.getClient();
                if (client instanceof BaseHmsClient) {
                    BaseHmsClient baseHmsClient = (BaseHmsClient) client;
                    baseHmsClient.setService(IAIDLInvoke.Stub.asInterface(baseHmsClient.getAdapter().getServiceBinder()));
                    requestHandlerPoll.onConnected();
                }
            }
        }
    }

    /* renamed from: c */
    private void m30697c() {
        HMSLog.m36988i("RequestManager", "NOTIFY_CONNECT_SUSPENDED.");
        while (!f23502d.isEmpty()) {
            f23502d.poll().onConnectionSuspended(1);
        }
        m30698d();
    }

    /* renamed from: d */
    private void m30698d() {
        HMSLog.m36988i("RequestManager", "notifyRunningRequestConnectSuspend, connectedReqMap.size(): " + f23503e.size());
        Iterator<Map.Entry<String, HuaweiApi.RequestHandler>> it = f23503e.entrySet().iterator();
        while (it.hasNext()) {
            try {
                it.next().getValue().onConnectionSuspended(1);
            } catch (RuntimeException e10) {
                HMSLog.m36986e("RequestManager", "NOTIFY_CONNECT_SUSPENDED Exception: " + e10.getMessage());
            }
            it.remove();
        }
    }

    public static Handler getHandler() {
        return f23501c;
    }

    public static RequestManager getInstance() {
        synchronized (f23499a) {
            try {
                if (f23500b == null) {
                    HandlerThread handlerThread = new HandlerThread("RequestManager");
                    handlerThread.start();
                    f23500b = new RequestManager(handlerThread.getLooper());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f23500b;
    }

    public static void removeReqByTransId(final String str) {
        if (f23501c == null) {
            return;
        }
        HMSLog.m36988i("RequestManager", "removeReqByTransId");
        f23501c.post(new Runnable() { // from class: com.huawei.hms.common.internal.RequestManager.2
            @Override // java.lang.Runnable
            public void run() {
                RequestManager.f23503e.remove(str);
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message == null) {
            return false;
        }
        HMSLog.m36988i("RequestManager", "RequestManager handleMessage.");
        switch (message.what) {
            case NOTIFY_CONNECT_SUCCESS /* 10011 */:
                m30696b();
                break;
            case NOTIFY_CONNECT_FAILED /* 10012 */:
                m30695a(message);
                break;
            case NOTIFY_CONNECT_SUSPENDED /* 10013 */:
                m30697c();
                break;
            default:
                HMSLog.m36988i("RequestManager", "handleMessage unknown msg:" + message.what);
                break;
        }
        return false;
    }

    /* renamed from: a */
    private void m30695a(Message message) {
        HMSLog.m36988i("RequestManager", "NOTIFY_CONNECT_FAILED.");
        try {
            BaseHmsClient.ConnectionResultWrapper connectionResultWrapper = (BaseHmsClient.ConnectionResultWrapper) message.obj;
            HuaweiApi.RequestHandler request = connectionResultWrapper.getRequest();
            f23502d.remove(request);
            request.onConnectionFailed(connectionResultWrapper.getConnectionResult());
        } catch (RuntimeException e10) {
            HMSLog.m36986e("RequestManager", "<handleConnectFailed> handle Failed" + e10.getMessage());
        }
    }
}
