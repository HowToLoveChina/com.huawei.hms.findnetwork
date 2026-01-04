package com.baidu.location.provider;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.location.p065a.C1534f;
import com.huawei.hwcloudjs.p164f.C6661f;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class WifiMan {

    /* renamed from: a */
    public static final int f6693a = 15;

    /* renamed from: b */
    public static final long f6694b = 10000;

    /* renamed from: c */
    public static final long f6695c = 10000;

    /* renamed from: d */
    public static long f6696d;

    /* renamed from: g */
    private static WifiMan f6697g;

    /* renamed from: e */
    private long f6698e = 10000;

    /* renamed from: f */
    private boolean f6699f = true;

    /* renamed from: h */
    private WifiManager f6700h = null;

    /* renamed from: i */
    private WifiScanListener f6701i = null;

    /* renamed from: j */
    private C1544g f6702j = null;

    /* renamed from: k */
    private long f6703k = 0;

    /* renamed from: l */
    private boolean f6704l = false;

    /* renamed from: m */
    private Context f6705m;

    public class WifiScanListener extends BroadcastReceiver {
        private WifiScanListener() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context != null && intent.getAction().equals("android.net.wifi.SCAN_RESULTS")) {
                WifiMan.f6696d = System.currentTimeMillis() / 1000;
                WifiMan.this.m8754m();
                C1534f.m8725c("WifiScan finished, in callback.");
            }
        }
    }

    private WifiMan() {
    }

    /* renamed from: a */
    public static WifiMan m8749a() {
        if (f6697g == null) {
            f6697g = new WifiMan();
        }
        return f6697g;
    }

    /* renamed from: l */
    private String m8753l() {
        DhcpInfo dhcpInfo;
        WifiManager wifiManager = this.f6700h;
        if (wifiManager == null || (dhcpInfo = wifiManager.getDhcpInfo()) == null) {
            return null;
        }
        return m8750a(dhcpInfo.gateway);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m8754m() {
        WifiManager wifiManager = this.f6700h;
        if (wifiManager == null) {
            return;
        }
        try {
            C1544g c1544g = new C1544g(wifiManager.getScanResults(), this.f6703k);
            C1544g c1544g2 = this.f6702j;
            if (c1544g2 == null || !c1544g.m8881a(c1544g2)) {
                this.f6702j = c1544g;
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public List<WifiConfiguration> m8757b() {
        try {
            WifiManager wifiManager = this.f6700h;
            if (wifiManager != null) {
                return wifiManager.getConfiguredNetworks();
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public synchronized void m8758c() {
        try {
            if (this.f6704l) {
                try {
                    if (this.f6699f) {
                        this.f6705m.unregisterReceiver(this.f6701i);
                    }
                    f6696d = 0L;
                } catch (Exception e10) {
                    if (C1534f.f6655a) {
                        e10.printStackTrace();
                    }
                }
                this.f6701i = null;
                this.f6700h = null;
                this.f6704l = false;
                C1534f.m8725c("wifimanager stop ...");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: d */
    public boolean m8759d() {
        String str;
        if (this.f6700h == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j10 = this.f6703k;
        if (jCurrentTimeMillis - j10 > 0) {
            long j11 = jCurrentTimeMillis - (f6696d * 1000);
            long j12 = this.f6698e;
            if (j11 <= j12) {
                str = "wifi valid time < 10S";
            } else if (jCurrentTimeMillis - j10 <= j12) {
                str = "wifi scan time < 10S";
            } else if (m8761f()) {
                String strM8753l = m8753l();
                if (strM8753l != null && (strM8753l.equals("192.168.43.1") || strM8753l.equals("172.20.10.1"))) {
                    C1534f.m8725c("wifi connect move ap , should scan wifi");
                    if (jCurrentTimeMillis - this.f6703k <= 10000) {
                        return false;
                    }
                } else if (jCurrentTimeMillis - this.f6703k <= 360000) {
                    str = "wifi connect scan time < 360S";
                }
            }
            C1534f.m8725c(str);
            return false;
        }
        return m8760e();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: e */
    public boolean m8760e() {
        try {
            if (this.f6699f && (this.f6700h.isWifiEnabled() || this.f6700h.isScanAlwaysAvailable())) {
                this.f6700h.startScan();
                this.f6703k = System.currentTimeMillis();
                C1534f.m8725c("wifimanager start scan ...");
                return true;
            }
        } catch (Exception unused) {
        } catch (NoSuchMethodError unused2) {
            this.f6700h.startScan();
            this.f6703k = System.currentTimeMillis();
            C1534f.m8725c("wifimanager start scan ...");
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public boolean m8761f() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f6705m.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType() == 1;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: g */
    public String m8762g() {
        WifiInfo connectionInfo;
        WifiManager wifiManager = this.f6700h;
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return null;
        }
        try {
            String bssid = connectionInfo.getBSSID();
            if (bssid == null) {
                return null;
            }
            String strReplace = bssid.replace(":", "");
            if ("000000000000".equals(strReplace)) {
                return null;
            }
            if ("".equals(strReplace)) {
                return null;
            }
            return strReplace;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: h */
    public boolean m8763h() {
        WifiManager wifiManager = this.f6700h;
        if (wifiManager == null) {
            return false;
        }
        try {
            return wifiManager.isScanAlwaysAvailable();
        } catch (NoSuchMethodError unused) {
            return false;
        }
    }

    /* renamed from: i */
    public C1544g m8764i() {
        return (!(this.f6699f && this.f6702j == null) && this.f6702j.m8892h()) ? this.f6702j : m8766k();
    }

    /* renamed from: j */
    public C1544g m8765j() {
        C1544g c1544g = this.f6702j;
        return (c1544g == null || !c1544g.m8893i()) ? m8766k() : this.f6702j;
    }

    /* renamed from: k */
    public C1544g m8766k() {
        WifiManager wifiManager;
        if (this.f6699f && (wifiManager = this.f6700h) != null) {
            try {
                return new C1544g(wifiManager.getScanResults(), this.f6703k);
            } catch (Exception unused) {
            }
        }
        return new C1544g(null, 0L);
    }

    /* renamed from: a */
    private String m8750a(long j10) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf((int) (j10 & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j10 >> 8) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j10 >> 16) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j10 >> 24) & 255)));
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public synchronized void m8755a(Context context) {
        if (this.f6704l) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.f6705m = applicationContext;
        this.f6700h = (WifiManager) applicationContext.getSystemService(C6661f.f30885g);
        WifiScanListener wifiScanListener = new WifiScanListener();
        this.f6701i = wifiScanListener;
        try {
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (!this.f6699f) {
            this.f6704l = true;
            C1534f.m8725c("wifimanager start ...");
            C1534f.m8725c("wifiman inited");
            return;
        } else {
            this.f6705m.registerReceiver(wifiScanListener, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            this.f6704l = true;
            C1534f.m8725c("wifimanager start ...");
            C1534f.m8725c("wifiman inited");
            return;
        }
    }

    /* renamed from: a */
    public static boolean m8752a(C1544g c1544g, C1544g c1544g2, float f10) {
        if (c1544g != null && c1544g2 != null) {
            List<ScanResult> list = c1544g.f6816a;
            List<ScanResult> list2 = c1544g2.f6816a;
            if (list == list2) {
                return true;
            }
            if (list != null && list2 != null) {
                int size = list.size();
                int size2 = list2.size();
                float f11 = size + size2;
                if (size == 0 && size2 == 0) {
                    return true;
                }
                if (size != 0 && size2 != 0) {
                    int i10 = 0;
                    for (int i11 = 0; i11 < size; i11++) {
                        String str = list.get(i11).BSSID;
                        if (str != null) {
                            int i12 = 0;
                            while (true) {
                                if (i12 >= size2) {
                                    break;
                                }
                                if (str.equals(list2.get(i12).BSSID)) {
                                    i10++;
                                    break;
                                }
                                i12++;
                            }
                        }
                    }
                    C1534f.m8725c(String.format(Locale.CHINA, "same %d,total %f,rate %f...", Integer.valueOf(i10), Float.valueOf(f11), Float.valueOf(f10)));
                    if (i10 * 2 >= f11 * f10) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m8756a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("wpa|wep", 2).matcher(str).find();
    }
}
