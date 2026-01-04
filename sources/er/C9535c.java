package er;

import android.content.Context;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.text.TextUtils;
import as.C1016d;
import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudjs.p164f.C6661f;
import com.huawei.riemann.location.common.utils.Constant;
import cr.C8944a;
import hu.C10343b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* renamed from: er.c */
/* loaded from: classes8.dex */
public final class C9535c {

    /* renamed from: a */
    public transient long f47404a;

    /* renamed from: b */
    @SerializedName("HappenTime")
    private String f47405b;

    /* renamed from: c */
    @SerializedName("LAT")
    private String f47406c;

    /* renamed from: d */
    @SerializedName("LON")
    private String f47407d;

    /* renamed from: e */
    @SerializedName("ALT")
    private String f47408e;

    /* renamed from: f */
    @SerializedName("ACC")
    private int f47409f;

    /* renamed from: g */
    @SerializedName("BEARING")
    private int f47410g;

    /* renamed from: h */
    @SerializedName("SPEED")
    private int f47411h;

    /* renamed from: i */
    @SerializedName("FIX_TIME")
    private long f47412i;

    /* renamed from: j */
    @SerializedName("TYPE")
    private int f47413j;

    /* renamed from: k */
    @SerializedName("DIFF_TIME")
    private long f47414k = 2147483647L;

    /* renamed from: l */
    @SerializedName("BOOTTIME")
    private long f47415l;

    /* renamed from: m */
    @SerializedName("CURRENTCELL")
    private List<C9534b> f47416m;

    /* renamed from: n */
    @SerializedName("NEIGHBORCELL")
    private List<C9534b> f47417n;

    /* renamed from: o */
    @SerializedName("WIFIAPINFO")
    private List<C9533a> f47418o;

    /* renamed from: p */
    @SerializedName("AVGPRESSURE")
    private float f47419p;

    /* renamed from: q */
    @SerializedName("SRCTYPE")
    private int f47420q;

    /* renamed from: r */
    @SerializedName("ARSTATUS")
    private int f47421r;

    /* renamed from: a */
    public final void m59538a(Location location) {
        this.f47405b = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date());
        if (location != null) {
            this.f47406c = location.getLatitude() + "";
            this.f47407d = location.getLongitude() + "";
            this.f47408e = location.getAltitude() + "";
            this.f47409f = (int) location.getAccuracy();
            this.f47410g = (int) location.getBearing();
            this.f47411h = (int) location.getSpeed();
            this.f47412i = location.getTime();
            this.f47404a = (location.getElapsedRealtimeNanos() / 1000) / 1000;
            String provider = location.getProvider();
            this.f47413j = (!TextUtils.isEmpty(provider) && provider.equals("gps")) ? 0 : 1;
            this.f47420q = new C10343b(location.getExtras()).m63687i(Constant.LOCATION_SOURCE_TYPE, -1);
        }
        this.f47415l = SystemClock.elapsedRealtime();
        this.f47419p = 0.0f;
    }

    /* renamed from: b */
    public final void m59539b(List<C8944a> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (C8944a c8944a : list) {
            if (c8944a.m56665a().isRegistered()) {
                C9534b c9534b = new C9534b();
                c9534b.m59536c(c8944a);
                arrayList.add(c9534b);
            } else {
                C9534b c9534b2 = new C9534b();
                c9534b2.m59535a(c8944a);
                arrayList2.add(c9534b2);
            }
        }
        if (arrayList2.size() != 0) {
            if (arrayList.size() == 1) {
                if (C9534b.m59534e((C9534b) arrayList.get(0), arrayList2)) {
                    C9534b.m59533b((C9534b) arrayList.get(0), arrayList2);
                }
            } else if (arrayList.size() == 2) {
                C9534b c9534b3 = (C9534b) arrayList.get(0);
                C9534b c9534b4 = (C9534b) arrayList.get(1);
                if (c9534b3 == null || c9534b4 == null || !c9534b3.m59537d(c9534b4)) {
                    C9534b c9534b5 = (C9534b) arrayList.get(0);
                    C9534b c9534b6 = (C9534b) arrayList.get(1);
                    ArrayList arrayList3 = new ArrayList(arrayList2.size());
                    ArrayList arrayList4 = new ArrayList(arrayList2.size());
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        C9534b c9534b7 = (C9534b) it.next();
                        if (c9534b5.m59537d(c9534b7)) {
                            arrayList3.add(c9534b7);
                        } else if (c9534b6.m59537d(c9534b7)) {
                            arrayList4.add(c9534b7);
                        } else {
                            C1016d.m6181a("LocCellInfo", "neighborCellBy5GRules: not fit");
                        }
                    }
                    if (C9534b.m59534e(c9534b3, arrayList3)) {
                        C9534b.m59533b(c9534b3, arrayList3);
                    }
                    if (C9534b.m59534e(c9534b4, arrayList4)) {
                        C9534b.m59533b(c9534b4, arrayList4);
                    }
                } else {
                    boolean zM59534e = C9534b.m59534e(c9534b3, arrayList2);
                    boolean zM59534e2 = C9534b.m59534e(c9534b4, arrayList2);
                    if (zM59534e) {
                        C9534b.m59533b(c9534b3, arrayList2);
                    }
                    if (zM59534e2) {
                        C9534b.m59533b(c9534b4, arrayList2);
                    }
                }
            } else {
                C1016d.m6181a("LocCellInfo", "neighborCellBy5GRules: Not supported Three SIM Card");
            }
        }
        this.f47416m = arrayList;
        this.f47417n = arrayList2;
    }

    /* renamed from: c */
    public final void m59540c(List<ScanResult> list, Context context) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Object systemService = context.getApplicationContext().getSystemService(C6661f.f30885g);
        String bssid = "";
        if (systemService instanceof WifiManager) {
            WifiInfo connectionInfo = ((WifiManager) systemService).getConnectionInfo();
            if (connectionInfo != null) {
                bssid = connectionInfo.getBSSID();
            }
        } else {
            C1016d.m6181a("LocWifiInfo", "not get WIFI_SERVICE");
        }
        for (ScanResult scanResult : list) {
            C9533a c9533a = new C9533a();
            c9533a.m59532b(scanResult, bssid);
            this.f47414k = Math.min(this.f47414k, (int) Math.abs(this.f47404a - c9533a.m59531a()));
            arrayList.add(c9533a);
        }
        this.f47418o = arrayList;
    }

    public final String toString() {
        return "CommonParam{happenTime='" + this.f47405b + "', latitude=" + this.f47406c + ", longitude=" + this.f47407d + ", altitude=" + this.f47408e + ", accuracy=" + this.f47409f + ", bearing=" + this.f47410g + ", speed=" + this.f47411h + ", locationTime=" + this.f47412i + ", type=" + this.f47413j + ", diffTime=" + this.f47414k + ", bootTime=" + this.f47415l + ", currentCells=" + this.f47416m + ", neighborCells=" + this.f47417n + ", wifiInfos=" + this.f47418o + ", avgPressure=" + this.f47419p + ", sourceType=" + this.f47420q + ", arStatus=" + this.f47421r + ", locationBootTime=" + this.f47404a + '}';
    }
}
