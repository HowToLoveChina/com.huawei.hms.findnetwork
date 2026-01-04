package com.huawei.hms.network.embedded;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.network.netdiag.cache.SignalInfoCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.network.embedded.l5 */
/* loaded from: classes8.dex */
public class C5995l5 {

    /* renamed from: e */
    public static final String f27376e = "DispatcherMessage";

    /* renamed from: a */
    public Handler f27377a = null;

    /* renamed from: b */
    public final ConcurrentHashMap<Integer, AbstractC6072r4> f27378b;

    /* renamed from: c */
    public List<Integer> f27379c;

    /* renamed from: d */
    public HandlerThread f27380d;

    /* renamed from: com.huawei.hms.network.embedded.l5$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                AbstractC6072r4 abstractC6072r4 = (AbstractC6072r4) C5995l5.this.f27378b.get(Integer.valueOf(message.what));
                if (abstractC6072r4 != null) {
                    Logger.m32143v(C5995l5.f27376e, "the handler message will obtain, what =" + message.what);
                    abstractC6072r4.updateCacheInfo(message.obj);
                } else {
                    Logger.m32141i(C5995l5.f27376e, "please register firstly");
                }
            } catch (RuntimeException unused) {
                Logger.m32141i(C5995l5.f27376e, "the handler has exception!");
            } catch (Throwable th2) {
                HianalyticsHelper.getInstance().reportException(th2, CrashHianalyticsData.EVENT_ID_CRASH);
            }
        }
    }

    public C5995l5() {
        ConcurrentHashMap<Integer, AbstractC6072r4> concurrentHashMap = new ConcurrentHashMap<>();
        this.f27378b = concurrentHashMap;
        this.f27379c = Collections.unmodifiableList(new ArrayList(Arrays.asList(1001)));
        HandlerThread handlerThread = new HandlerThread("netdiag_thread");
        this.f27380d = handlerThread;
        handlerThread.start();
        concurrentHashMap.put(1003, C6085s4.getInstance());
        concurrentHashMap.put(1002, C6098t4.getInstance());
        concurrentHashMap.put(1001, SignalInfoCache.getInstance());
    }

    /* renamed from: b */
    private synchronized Handler m34655b() {
        Handler handler = this.f27377a;
        if (handler != null) {
            return handler;
        }
        Looper looper = this.f27380d.getLooper();
        if (looper == null) {
            return null;
        }
        a aVar = new a(looper);
        this.f27377a = aVar;
        return aVar;
    }

    /* renamed from: a */
    public synchronized void m34656a() {
        m34660a(this.f27379c);
    }

    /* renamed from: b */
    public synchronized void m34661b(Message message) {
        try {
            if (m34655b() != null) {
                m34655b().sendMessage(message);
            } else {
                Logger.m32141i(f27376e, "hander is null,this time will abort!");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public void m34657a(int i10) {
        this.f27378b.remove(Integer.valueOf(i10));
    }

    /* renamed from: a */
    public void m34658a(int i10, AbstractC6072r4 abstractC6072r4) {
        this.f27378b.put(Integer.valueOf(i10), abstractC6072r4);
    }

    /* renamed from: a */
    public synchronized void m34659a(Message message) {
        try {
            if (m34655b() != null) {
                m34655b().handleMessage(message);
            } else {
                Logger.m32141i(f27376e, "hander is null,this time will abort!");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public synchronized void m34660a(List<Integer> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            Message messageObtain = Message.obtain();
            messageObtain.what = list.get(i10).intValue();
            m34661b(messageObtain);
        }
    }
}
