package com.huawei.location.crowdsourcing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import as.C1016d;
import br.InterfaceC1273a;
import com.huawei.hwcloudjs.p164f.C6661f;
import com.huawei.location.crowdsourcing.Config;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import p234dr.InterfaceC9297c;
import p234dr.InterfaceC9299e;

/* renamed from: com.huawei.location.crowdsourcing.f */
/* loaded from: classes8.dex */
public final class C6750f implements InterfaceC1273a {

    /* renamed from: a */
    public long f31293a;

    /* renamed from: b */
    public final c f31294b;

    /* renamed from: c */
    public List<ScanResult> f31295c = new LinkedList();

    /* renamed from: d */
    public a f31296d;

    /* renamed from: com.huawei.location.crowdsourcing.f$a */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String strConcat;
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            if (action == null) {
                strConcat = "get null action";
            } else {
                if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                    boolean booleanExtra = safeIntent.getBooleanExtra("resultsUpdated", false);
                    C1016d.m6181a("WifiCollector", "onReceive action=" + action + " isUpdated=" + booleanExtra);
                    if (booleanExtra) {
                        c cVar = C6750f.this.f31294b;
                        cVar.getClass();
                        cVar.obtainMessage(0, Long.valueOf(System.currentTimeMillis())).sendToTarget();
                        return;
                    }
                    return;
                }
                strConcat = "receive unknown action,action:".concat(action);
            }
            C1016d.m6183c("WifiCollector", strConcat);
        }

        public /* synthetic */ a(C6750f c6750f, int i10) {
            this();
        }
    }

    /* renamed from: com.huawei.location.crowdsourcing.f$b */
    public static class b implements Comparator<ScanResult> {
        public b() {
        }

        public /* synthetic */ b(int i10) {
            this();
        }

        @Override // java.util.Comparator
        public final int compare(ScanResult scanResult, ScanResult scanResult2) {
            ScanResult scanResult3 = scanResult;
            ScanResult scanResult4 = scanResult2;
            long j10 = scanResult3.timestamp - scanResult4.timestamp;
            if (j10 != 0) {
                return j10 > 0 ? 1 : -1;
            }
            int i10 = scanResult3.level - scanResult4.level;
            if (i10 != 0) {
                return i10;
            }
            int iCompareTo = scanResult3.BSSID.compareTo(scanResult4.BSSID);
            return iCompareTo != 0 ? iCompareTo : scanResult3.SSID.compareTo(scanResult4.SSID);
        }
    }

    /* renamed from: com.huawei.location.crowdsourcing.f$c */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what != 0) {
                C1016d.m6183c("WifiCollector", "unknown msg:" + message.what);
            } else {
                Object obj = message.obj;
                if (obj instanceof Long) {
                    C6750f.m38343h(C6750f.this, ((Long) obj).longValue());
                } else {
                    C1016d.m6183c("WifiCollector", "handleMessage not location obj");
                }
            }
        }
    }

    public C6750f(Looper looper) {
        this.f31294b = new c(looper);
    }

    /* renamed from: h */
    public static void m38343h(C6750f c6750f, long j10) {
        c6750f.f31293a = j10;
    }

    /* renamed from: i */
    public static void m38344i(List list) {
        final long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        final long jM38302h = Config.C6744b.f31261a.m38302h();
        InterfaceC9297c interfaceC9297c = new InterfaceC9297c() { // from class: com.huawei.location.crowdsourcing.d
            @Override // p234dr.InterfaceC9297c
            /* renamed from: a */
            public final boolean mo38339a(Object obj) {
                return C6750f.m38345j(jElapsedRealtimeNanos, jM38302h, (ScanResult) obj);
            }
        };
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (interfaceC9297c.mo38339a(it.next())) {
                it.remove();
            }
        }
    }

    /* renamed from: j */
    public static /* synthetic */ boolean m38345j(long j10, long j11, ScanResult scanResult) {
        long jAbs = Math.abs(scanResult.timestamp - j10);
        if (jAbs <= j11) {
            return false;
        }
        C1016d.m6181a("WifiCollector", "remove expired(μs). timeDiff:" + jAbs);
        return true;
    }

    /* renamed from: k */
    public static /* synthetic */ boolean m38346k(ScanResult scanResult, ScanResult scanResult2) {
        return TextUtils.equals(scanResult.BSSID, scanResult2.BSSID) && scanResult.timestamp == scanResult2.timestamp;
    }

    @Override // br.InterfaceC1273a
    /* renamed from: a */
    public final void mo7544a() {
        C1016d.m6190j("WifiCollector", "Stop");
        a aVar = this.f31296d;
        if (aVar != null) {
            C6747c.m38332b().unregisterReceiver(aVar);
        }
    }

    /* renamed from: d */
    public final boolean m38347d() {
        a aVar = new a(this, 0);
        this.f31296d = aVar;
        C6747c.m38332b().registerReceiver(aVar, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        C1016d.m6186f("WifiCollector", "wifi scan finish register success");
        return true;
    }

    /* renamed from: e */
    public final List<ScanResult> m38348e() {
        List<ScanResult> scanResults;
        Config config = Config.C6744b.f31261a;
        if (!config.m38309o()) {
            C1016d.m6181a("WifiCollector", "no need get wifi");
            return null;
        }
        if (Math.abs(System.currentTimeMillis() - this.f31293a) > Config.C6744b.f31261a.m38297c()) {
            C1016d.m6181a("WifiCollector", "not fresh");
            return null;
        }
        Object systemService = C6747c.m38332b().getApplicationContext().getSystemService(C6661f.f30885g);
        if (systemService instanceof WifiManager) {
            scanResults = ((WifiManager) systemService).getScanResults();
        } else {
            C1016d.m6181a("WifiCollector", "no wifi service");
            scanResults = new ArrayList<>();
        }
        m38344i(scanResults);
        int iM38307m = Config.C6744b.f31261a.m38307m();
        int size = scanResults.size();
        if (size > iM38307m) {
            C1016d.m6181a("WifiCollector", "limit ap num from " + size + " to " + iM38307m);
            Collections.sort(scanResults, new b(0));
            scanResults.subList(0, size - iM38307m).clear();
        }
        if (scanResults.isEmpty()) {
            C1016d.m6181a("WifiCollector", "no available ap info");
            return null;
        }
        if (!m38349f(scanResults)) {
            C1016d.m6181a("WifiCollector", "no update");
            return null;
        }
        C1016d.m6181a("WifiCollector", "ap list size." + scanResults.size());
        config.m38299e();
        return this.f31295c;
    }

    /* renamed from: f */
    public final boolean m38349f(List<ScanResult> list) {
        List<ScanResult> list2 = this.f31295c;
        InterfaceC9299e interfaceC9299e = new InterfaceC9299e() { // from class: com.huawei.location.crowdsourcing.e
            @Override // p234dr.InterfaceC9299e
            public final boolean compare(Object obj, Object obj2) {
                return C6750f.m38346k((ScanResult) obj, (ScanResult) obj2);
            }
        };
        if (list2.size() == list.size()) {
            for (ScanResult scanResult : list2) {
                Iterator<ScanResult> it = list.iterator();
                while (it.hasNext()) {
                    if (!interfaceC9299e.compare(scanResult, it.next())) {
                    }
                }
            }
            return false;
        }
        this.f31295c = list;
        return true;
    }
}
