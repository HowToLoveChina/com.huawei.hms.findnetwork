package p532os;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import as.C1016d;
import com.huawei.hwcloudjs.p164f.C6661f;
import com.huawei.secure.android.common.intent.SafeBroadcastReceiver;
import es.C9548m;
import java.util.List;
import p433ks.C11146a;
import p531or.C11991a;

/* renamed from: os.a */
/* loaded from: classes8.dex */
public final class C12023a {

    /* renamed from: a */
    public WifiManager f55786a;

    /* renamed from: b */
    public Context f55787b;

    /* renamed from: c */
    public a f55788c;

    /* renamed from: d */
    public SafeBroadcastReceiver f55789d;

    /* renamed from: e */
    public boolean f55790e = true;

    /* renamed from: os.a$a */
    public interface a {
        /* renamed from: a */
        void mo68705a();

        /* renamed from: b */
        void mo68706b(List<ScanResult> list);
    }

    public C12023a() {
        Context contextM72145a = C11991a.m72145a();
        this.f55787b = contextM72145a;
        Object systemService = contextM72145a.getApplicationContext().getSystemService(C6661f.f30885g);
        if (systemService instanceof WifiManager) {
            this.f55786a = (WifiManager) systemService;
            C1016d.m6186f("WifiScanManager", "WifiScanManager init");
        }
    }

    /* renamed from: c */
    public static void m72148c(C12023a c12023a, Intent intent) {
        String str;
        String str2;
        if (c12023a.f55788c == null) {
            str = "onReceiveWifi, wifiScanLister is null";
        } else {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action) && "android.net.wifi.SCAN_RESULTS".equals(action)) {
                c12023a.f55790e = true;
                WifiManager wifiManager = c12023a.f55786a;
                if (wifiManager == null) {
                    str2 = "onReceiveWifi, WiFiManager is null";
                } else {
                    try {
                        List<ScanResult> scanResults = wifiManager.getScanResults();
                        if (!scanResults.isEmpty()) {
                            c12023a.f55788c.mo68706b(scanResults);
                            return;
                        }
                        str2 = "onReceiveWifi, wifi scan result is null";
                    } catch (Exception unused) {
                        str2 = "onReceiveWifi, remoteException";
                    }
                }
                C1016d.m6183c("WifiScanManager", str2);
                a aVar = c12023a.f55788c;
                C11146a.m67058a(10000);
                aVar.mo68705a();
                return;
            }
            str = "onReceiveWifi, action is invalid";
        }
        C1016d.m6183c("WifiScanManager", str);
    }

    /* renamed from: a */
    public final void m72150a() {
        SafeBroadcastReceiver safeBroadcastReceiver;
        Context context = this.f55787b;
        if (context == null || (safeBroadcastReceiver = this.f55789d) == null) {
            return;
        }
        try {
            context.unregisterReceiver(safeBroadcastReceiver);
        } catch (Exception unused) {
            C1016d.m6183c("WifiScanManager", "unregisterReceiver error");
        }
        this.f55789d = null;
    }

    /* renamed from: b */
    public final void m72151b(a aVar) {
        if (!C9548m.m59619b(this.f55787b, "android.permission.ACCESS_WIFI_STATE") || !C9548m.m59619b(this.f55787b, "android.permission.CHANGE_WIFI_STATE")) {
            C11146a.m67058a(10000);
            aVar.mo68705a();
            return;
        }
        this.f55788c = aVar;
        if (this.f55789d == null) {
            C1016d.m6186f("WifiScanManager", "registeredWifiBroadcast");
            this.f55789d = new C12024b(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            this.f55787b.registerReceiver(this.f55789d, intentFilter);
        }
        WifiManager wifiManager = this.f55786a;
        if (wifiManager == null) {
            C1016d.m6183c("WifiScanManager", "WifiScanManager is null");
            C11146a.m67058a(10000);
            aVar.mo68705a();
        } else {
            try {
                wifiManager.startScan();
                this.f55790e = false;
            } catch (Exception unused) {
                C1016d.m6183c("WifiScanManager", "WifiScanManager throw Exception");
                C11146a.m67058a(10000);
                aVar.mo68705a();
            }
        }
    }
}
