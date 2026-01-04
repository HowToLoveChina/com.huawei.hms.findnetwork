package com.huawei.hianalytics.core.transport;

import com.huawei.hianalytics.core.C4740f;
import com.huawei.hianalytics.core.C4741g;
import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.transport.net.TransportHandler;
import com.huawei.hms.network.NetworkKit;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class TransportHandlerFactory {

    /* renamed from: a */
    public static boolean f21693a = false;

    /* renamed from: com.huawei.hianalytics.core.transport.TransportHandlerFactory$a */
    public class C4744a extends NetworkKit.Callback {

        /* renamed from: a */
        public final /* synthetic */ CountDownLatch f21694a;

        public C4744a(CountDownLatch countDownLatch) {
            this.f21694a = countDownLatch;
        }

        @Override // com.huawei.hms.network.NetworkKit.Callback
        public void onResult(boolean z10) {
            this.f21694a.countDown();
        }
    }

    /* renamed from: a */
    public static void m28813a() throws InterruptedException {
        if (f21693a) {
            return;
        }
        f21693a = true;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        NetworkKit.init(EnvUtils.getAppContext(), new C4744a(countDownLatch));
        try {
            HiLog.m28809i("TransportHandler", "initNetworkKitSync await " + countDownLatch.await(3000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException unused) {
            HiLog.m28812w("TransportHandler", "InterruptedException");
        }
    }

    public static TransportHandler create(String str, Map<String, String> map, byte[] bArr, int i10) {
        return create(str, map, bArr, i10, false);
    }

    public static TransportHandler create(String str, Map<String, String> map, byte[] bArr, int i10, boolean z10) {
        try {
            int i11 = NetworkKit.f25630j;
            m28813a();
            return new C4741g(str, map, bArr, i10, z10);
        } catch (Exception unused) {
            HiLog.m28812w("TransportHandler", "visit NetworkKit Exception");
            return new C4740f(str, map, bArr);
        }
    }
}
