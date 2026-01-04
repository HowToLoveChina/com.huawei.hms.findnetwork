package com.baidu.location.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.location.p065a.C1534f;
import com.huawei.hwcloudjs.p164f.C6661f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* renamed from: com.baidu.location.provider.c */
/* loaded from: classes.dex */
public class C1540c {

    /* renamed from: A */
    private static final int f6732A = 17;

    /* renamed from: B */
    private static final int f6733B = 18;

    /* renamed from: C */
    private static final int f6734C = 19;

    /* renamed from: d */
    private static Method f6735d = null;

    /* renamed from: e */
    private static Method f6736e = null;

    /* renamed from: f */
    private static Method f6737f = null;

    /* renamed from: g */
    private static Method f6738g = null;

    /* renamed from: h */
    private static Method f6739h = null;

    /* renamed from: i */
    private static Class<?> f6740i = null;

    /* renamed from: n */
    private static final long f6741n = 10;

    /* renamed from: o */
    private static Object f6742o = new Object();

    /* renamed from: p */
    private static C1540c f6743p = null;

    /* renamed from: u */
    private static final int f6744u = 11;

    /* renamed from: v */
    private static final int f6745v = 12;

    /* renamed from: w */
    private static final int f6746w = 13;

    /* renamed from: x */
    private static final int f6747x = 14;

    /* renamed from: y */
    private static final int f6748y = 15;

    /* renamed from: z */
    private static final int f6749z = 16;

    /* renamed from: a */
    private Context f6750a;

    /* renamed from: b */
    private TelephonyManager f6751b;

    /* renamed from: j */
    private WifiManager f6753j;

    /* renamed from: l */
    private String f6755l;

    /* renamed from: c */
    private C1538a f6752c = new C1538a();

    /* renamed from: k */
    private a f6754k = null;

    /* renamed from: m */
    private String f6756m = null;

    /* renamed from: q */
    private long f6757q = 0;

    /* renamed from: r */
    private long f6758r = 0;

    /* renamed from: s */
    private long f6759s = 0;

    /* renamed from: t */
    private int f6760t = -1;

    /* renamed from: com.baidu.location.provider.c$a */
    public class a {

        /* renamed from: a */
        public List<ScanResult> f6762a;

        /* renamed from: c */
        private long f6764c;

        public a(List<ScanResult> list) {
            this.f6764c = 0L;
            this.f6762a = list;
            this.f6764c = System.currentTimeMillis();
            m8830b();
        }

        /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
            jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* renamed from: b */
        private void m8830b() {
            /*
                r7 = this;
                int r0 = r7.m8831a()
                r1 = 1
                if (r0 >= r1) goto L8
                return
            L8:
                java.util.List<android.net.wifi.ScanResult> r0 = r7.f6762a
                int r0 = r0.size()
                int r0 = r0 - r1
                r2 = r1
            L10:
                if (r0 < r1) goto L4d
                if (r2 == 0) goto L4d
                r2 = 0
                r3 = r2
            L16:
                if (r2 >= r0) goto L49
                java.util.List<android.net.wifi.ScanResult> r4 = r7.f6762a
                java.lang.Object r4 = r4.get(r2)
                android.net.wifi.ScanResult r4 = (android.net.wifi.ScanResult) r4
                int r4 = r4.level
                java.util.List<android.net.wifi.ScanResult> r5 = r7.f6762a
                int r6 = r2 + 1
                java.lang.Object r5 = r5.get(r6)
                android.net.wifi.ScanResult r5 = (android.net.wifi.ScanResult) r5
                int r5 = r5.level
                if (r4 >= r5) goto L47
                java.util.List<android.net.wifi.ScanResult> r3 = r7.f6762a
                java.lang.Object r3 = r3.get(r6)
                android.net.wifi.ScanResult r3 = (android.net.wifi.ScanResult) r3
                java.util.List<android.net.wifi.ScanResult> r4 = r7.f6762a
                java.lang.Object r5 = r4.get(r2)
                r4.set(r6, r5)
                java.util.List<android.net.wifi.ScanResult> r4 = r7.f6762a
                r4.set(r2, r3)
                r3 = r1
            L47:
                r2 = r6
                goto L16
            L49:
                int r0 = r0 + (-1)
                r2 = r3
                goto L10
            L4d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.provider.C1540c.a.m8830b():void");
        }

        /* renamed from: a */
        public int m8831a() {
            List<ScanResult> list = this.f6762a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        /* JADX WARN: Removed duplicated region for block: B:51:0x00fc  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x011e  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x011b A[EDGE_INSN: B:89:0x011b->B:55:0x011b BREAK  A[LOOP:0: B:14:0x003e->B:57:0x0120], SYNTHETIC] */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String m8832a(int r25) {
            /*
                Method dump skipped, instructions count: 471
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.provider.C1540c.a.m8832a(int):java.lang.String");
        }
    }

    public C1540c(Context context) {
        this.f6750a = null;
        this.f6751b = null;
        this.f6753j = null;
        this.f6755l = null;
        Context applicationContext = context.getApplicationContext();
        this.f6750a = applicationContext;
        String packageName = applicationContext.getPackageName();
        try {
            this.f6751b = (TelephonyManager) this.f6750a.getSystemService("phone");
        } catch (Exception e10) {
            if (C1534f.f6655a) {
                e10.printStackTrace();
            }
        }
        this.f6755l = "&prod=SDKHW5.5.10:buildn817:" + packageName + "|&coor=wgs84";
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&fw=");
        stringBuffer.append("5.5");
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&resid=");
        stringBuffer.append("11");
        stringBuffer.append("&uuid=");
        stringBuffer.append(C1534f.f6675u);
        stringBuffer.append("&first=1");
        stringBuffer.append("&os=A");
        stringBuffer.append(Build.VERSION.SDK);
        String strM8731i = C1534f.m8731i();
        if (!TextUtils.isEmpty(strM8731i)) {
            stringBuffer.append("&qcip6c=" + strM8731i);
        }
        this.f6755l += stringBuffer.toString();
        this.f6753j = (WifiManager) this.f6750a.getApplicationContext().getSystemService(C6661f.f30885g);
    }

    /* renamed from: a */
    private static int m8801a(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0 ? 1 : 0;
        } catch (Exception unused) {
            return 1;
        }
    }

    /* renamed from: b */
    private int m8809b(int i10) {
        if (i10 == Integer.MAX_VALUE) {
            return -1;
        }
        return i10;
    }

    /* renamed from: i */
    private boolean m8814i() {
        WifiManager wifiManager = this.f6753j;
        if (wifiManager == null) {
            return false;
        }
        try {
            if (!wifiManager.isWifiEnabled()) {
                if (!this.f6753j.isScanAlwaysAvailable()) {
                    return false;
                }
            }
            return true;
        } catch (Exception | NoSuchMethodError unused) {
            return false;
        }
    }

    /* renamed from: j */
    private boolean m8815j() {
        TelephonyManager telephonyManager = this.f6751b;
        if (telephonyManager == null) {
            return true;
        }
        try {
            return telephonyManager.getSimState() != 1;
        } catch (Exception e10) {
            if (!C1534f.f6655a) {
                return true;
            }
            e10.printStackTrace();
            return true;
        }
    }

    /* renamed from: k */
    private boolean m8816k() {
        int i10;
        try {
            i10 = Settings.Secure.getInt(this.f6750a.getContentResolver(), "location_mode", -1);
            C1534f.m8725c("location mode = " + i10);
        } catch (Exception e10) {
            if (C1534f.f6655a) {
                e10.printStackTrace();
            }
        }
        return i10 != 0;
    }

    /* renamed from: l */
    private boolean m8817l() {
        return m8801a(this.f6750a, "android.permission.ACCESS_COARSE_LOCATION") == 1 && m8801a(this.f6750a, "android.permission.ACCESS_FINE_LOCATION") == 1;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: m */
    private C1538a m8818m() {
        try {
            List<CellInfo> allCellInfo = this.f6751b.getAllCellInfo();
            if (allCellInfo == null || allCellInfo.size() <= 0) {
                C1534f.m8725c("getAllCellInfo = null");
                return null;
            }
            C1538a c1538a = null;
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo.isRegistered()) {
                    boolean z10 = c1538a != null;
                    C1538a c1538aM8805a = m8805a(cellInfo);
                    if (c1538aM8805a != null) {
                        if (c1538aM8805a.m8769b()) {
                            C1534f.m8725c(" cell res.isValid() = " + c1538aM8805a.m8775h());
                            if (z10) {
                                c1538a.f6717k = c1538aM8805a.m8778k();
                                return c1538a;
                            }
                        } else {
                            C1534f.m8725c(" !res.isValid()");
                            c1538aM8805a = null;
                        }
                        if (c1538a == null) {
                            c1538a = c1538aM8805a;
                        }
                    }
                }
            }
            return c1538a;
        } catch (Throwable th2) {
            if (!C1534f.f6655a) {
                return null;
            }
            th2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public String m8819n() {
        WifiInfo wifiInfoM8829h = m8829h();
        if (wifiInfoM8829h == null) {
            return null;
        }
        try {
            String bssid = wifiInfoM8829h.getBSSID();
            String strReplace = bssid != null ? bssid.replace(":", "") : null;
            if (strReplace.length() != 12) {
                return null;
            }
            return new String(strReplace);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: o */
    private String m8820o() {
        WifiInfo wifiInfoM8829h = m8829h();
        if (wifiInfoM8829h == null) {
            return null;
        }
        try {
            String bssid = wifiInfoM8829h.getBSSID();
            String strReplace = bssid != null ? bssid.replace(":", "") : null;
            if (strReplace.length() != 12) {
                return null;
            }
            int rssi = wifiInfoM8829h.getRssi();
            if (rssi < 0) {
                rssi = -rssi;
            }
            String str = new String(strReplace);
            try {
                return "&wf=" + str + ";" + rssi + ";" + wifiInfoM8829h.getSSID() + "&wf_n=1";
            } catch (Exception unused) {
                return str;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    /* renamed from: c */
    public C1544g m8824c() {
        a aVar = this.f6754k;
        if (aVar != null) {
            return new C1544g(aVar.f6762a, this.f6758r);
        }
        return null;
    }

    /* renamed from: d */
    public int m8825d() {
        return this.f6760t;
    }

    /* renamed from: e */
    public String m8826e() {
        try {
            WifiInfo connectionInfo = this.f6753j.getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getMacAddress();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* renamed from: f */
    public String m8827f() {
        this.f6760t = -1;
        try {
            String strM8812c = m8812c(15);
            if (strM8812c == null && this.f6760t < 0) {
                if (!m8815j()) {
                    this.f6760t = 11;
                } else if (!m8814i()) {
                    this.f6760t = 12;
                } else if (!m8816k()) {
                    this.f6760t = 14;
                } else if (m8817l()) {
                    this.f6760t = 19;
                } else {
                    this.f6760t = 13;
                }
            }
            return strM8812c;
        } catch (Exception e10) {
            if (!C1534f.f6655a) {
                return null;
            }
            e10.printStackTrace();
            return null;
        }
    }

    /* renamed from: g */
    public Location m8828g() {
        C1538a c1538a;
        int i10;
        int i11;
        C1538a c1538a2 = this.f6752c;
        if (c1538a2 == null || !c1538a2.m8769b() || (i10 = (c1538a = this.f6752c).f6711e) >= Integer.MAX_VALUE || (i11 = c1538a.f6712f) >= Integer.MAX_VALUE) {
            return null;
        }
        double d10 = i11 / 14400.0d;
        Location location = new Location("network");
        location.setAccuracy(2000.0f);
        location.setLatitude(i10 / 14400.0d);
        location.setLongitude(d10);
        return location;
    }

    /* renamed from: h */
    public WifiInfo m8829h() {
        WifiManager wifiManager = this.f6753j;
        if (wifiManager == null) {
            return null;
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null && connectionInfo.getBSSID() != null && connectionInfo.getRssi() > -100) {
                String bssid = connectionInfo.getBSSID();
                if (bssid != null) {
                    String strReplace = bssid.replace(":", "");
                    if (!"000000000000".equals(strReplace)) {
                        if ("".equals(strReplace)) {
                        }
                    }
                    return null;
                }
                return connectionInfo;
            }
        } catch (Error | Exception unused) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0175 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0165 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m8812c(int r10) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.provider.C1540c.m8812c(int):java.lang.String");
    }

    /* renamed from: b */
    public C1538a m8823b() {
        return this.f6752c;
    }

    /* renamed from: a */
    public WifiManager m8821a() {
        return this.f6753j;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(1:4)(6:6|(2:8|(5:13|53|14|(2:20|(1:23))|(1:12))(0))(2:30|(1:32)(1:33))|(3:55|35|(1:37))|51|43|50)|5|(0)|51|43|50) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x017f, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0182, code lost:
    
        if (com.baidu.location.p065a.C1534f.f6655a != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0184, code lost:
    
        r8.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0187, code lost:
    
        r0.f6713g = java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a1 A[PHI: r1
  0x00a1: PHI (r1v16 int) = (r1v14 int), (r1v17 int) binds: [B:28:0x00d4, B:11:0x009f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.baidu.location.provider.C1538a m8805a(android.telephony.CellInfo r9) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.provider.C1540c.m8805a(android.telephony.CellInfo):com.baidu.location.provider.a");
    }

    /* renamed from: a */
    public static C1540c m8807a(Context context) {
        C1540c c1540c;
        synchronized (f6742o) {
            try {
                if (f6743p == null) {
                    f6743p = new C1540c(context);
                }
                c1540c = f6743p;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c1540c;
    }

    /* renamed from: a */
    public String m8822a(int i10) {
        try {
            return m8812c(i10);
        } catch (Exception e10) {
            if (!C1534f.f6655a) {
                return null;
            }
            e10.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private void m8808a(CellLocation cellLocation) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int i10;
        if (cellLocation == null || this.f6751b == null) {
            return;
        }
        C1538a c1538a = new C1538a();
        String networkOperator = this.f6751b.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() > 0) {
            try {
                if (networkOperator.length() >= 3) {
                    int iIntValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (iIntValue < 0) {
                        iIntValue = this.f6752c.f6709c;
                    }
                    c1538a.f6709c = iIntValue;
                }
                String strSubstring = networkOperator.substring(3);
                if (strSubstring != null) {
                    char[] charArray = strSubstring.toCharArray();
                    i10 = 0;
                    while (i10 < charArray.length && Character.isDigit(charArray[i10])) {
                        i10++;
                    }
                } else {
                    i10 = 0;
                }
                int iIntValue2 = Integer.valueOf(strSubstring.substring(0, i10)).intValue();
                if (iIntValue2 < 0) {
                    iIntValue2 = this.f6752c.f6710d;
                }
                c1538a.f6710d = iIntValue2;
            } catch (Exception unused) {
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            c1538a.f6707a = gsmCellLocation.getLac();
            c1538a.f6708b = gsmCellLocation.getCid();
            c1538a.f6715i = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            c1538a.f6715i = 'c';
            if (f6740i == null) {
                try {
                    Class<?> cls = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    f6740i = cls;
                    f6735d = cls.getMethod("getBaseStationId", new Class[0]);
                    f6736e = f6740i.getMethod("getNetworkId", new Class[0]);
                    f6737f = f6740i.getMethod("getSystemId", new Class[0]);
                    f6738g = f6740i.getMethod("getBaseStationLatitude", new Class[0]);
                    f6739h = f6740i.getMethod("getBaseStationLongitude", new Class[0]);
                } catch (Exception unused2) {
                    f6740i = null;
                    return;
                }
            }
            Class<?> cls2 = f6740i;
            if (cls2 != null && cls2.isInstance(cellLocation)) {
                try {
                    int iIntValue3 = ((Integer) f6737f.invoke(cellLocation, new Object[0])).intValue();
                    if (iIntValue3 < 0) {
                        iIntValue3 = this.f6752c.f6710d;
                    }
                    c1538a.f6710d = iIntValue3;
                    c1538a.f6708b = ((Integer) f6735d.invoke(cellLocation, new Object[0])).intValue();
                    c1538a.f6707a = ((Integer) f6736e.invoke(cellLocation, new Object[0])).intValue();
                    Object objInvoke = f6738g.invoke(cellLocation, new Object[0]);
                    C1534f.m8725c("bslocation lat " + (((Integer) objInvoke).intValue() / 14400.0d));
                    if (((Integer) objInvoke).intValue() < Integer.MAX_VALUE) {
                        c1538a.f6711e = ((Integer) objInvoke).intValue();
                    }
                    Object objInvoke2 = f6739h.invoke(cellLocation, new Object[0]);
                    C1534f.m8725c("bslocation lon " + (((Integer) objInvoke2).intValue() / 14400.0d));
                    if (((Integer) objInvoke2).intValue() < Integer.MAX_VALUE) {
                        c1538a.f6712f = ((Integer) objInvoke2).intValue();
                    }
                } catch (Exception unused3) {
                    return;
                }
            }
        }
        if (c1538a.m8769b()) {
            this.f6752c = c1538a;
        } else {
            this.f6752c = null;
        }
    }
}
