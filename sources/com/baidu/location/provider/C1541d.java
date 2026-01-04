package com.baidu.location.provider;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.location.Jni;
import com.baidu.location.LocationClient;
import com.baidu.location.p065a.C1532d;
import com.baidu.location.p065a.C1534f;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: com.baidu.location.provider.d */
/* loaded from: classes.dex */
public class C1541d {

    /* renamed from: d */
    private static int f6765d = 0;

    /* renamed from: g */
    private static final int f6766g = 5;

    /* renamed from: h */
    private static final int f6767h = 1000;

    /* renamed from: a */
    private final long f6768a;

    /* renamed from: b */
    private LocationManager f6769b;

    /* renamed from: c */
    private c f6770c;

    /* renamed from: e */
    private boolean f6771e;

    /* renamed from: f */
    private Location f6772f;

    /* renamed from: i */
    private SQLiteDatabase f6773i;

    /* renamed from: j */
    private final String f6774j;

    /* renamed from: k */
    private final String f6775k;

    /* renamed from: l */
    private final String f6776l;

    /* renamed from: m */
    private final String f6777m;

    /* renamed from: n */
    private final String f6778n;

    /* renamed from: o */
    private final String f6779o;

    /* renamed from: p */
    private File f6780p;

    /* renamed from: q */
    private GpsStatus f6781q;

    /* renamed from: r */
    private a f6782r;

    /* renamed from: com.baidu.location.provider.d$a */
    public class a implements GpsStatus.Listener {

        /* renamed from: a */
        long f6783a;

        private a() {
            this.f6783a = 0L;
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i10) {
            if (C1541d.this.f6769b == null) {
                return;
            }
            int i11 = 0;
            if (i10 != 2) {
                if (i10 != 4) {
                    return;
                }
                if (!C1541d.this.f6771e && System.currentTimeMillis() - this.f6783a < 10000) {
                    return;
                }
                if (C1541d.this.f6781q == null) {
                    C1541d c1541d = C1541d.this;
                    c1541d.f6781q = c1541d.f6769b.getGpsStatus(null);
                } else {
                    C1541d.this.f6769b.getGpsStatus(C1541d.this.f6781q);
                }
                Iterator<GpsSatellite> it = C1541d.this.f6781q.getSatellites().iterator();
                while (it.hasNext()) {
                    if (it.next().usedInFix()) {
                        i11++;
                    }
                }
            }
            int unused = C1541d.f6765d = i11;
        }

        public /* synthetic */ a(C1541d c1541d, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* renamed from: com.baidu.location.provider.d$b */
    public static class b {

        /* renamed from: a */
        private static C1541d f6785a = new C1541d();

        private b() {
        }
    }

    /* renamed from: com.baidu.location.provider.d$c */
    public class c implements LocationListener {

        /* renamed from: b */
        private long f6787b;

        private c() {
            this.f6787b = 0L;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            long jElapsedRealtimeNanos;
            long j10;
            if (location == null || !location.getProvider().equals("gps")) {
                return;
            }
            if (System.currentTimeMillis() - this.f6787b < 10000) {
                C1534f.m8725c("10秒之内");
                return;
            }
            if (!C1541d.m8841a(C1541d.this.f6772f, location, false)) {
                C1534f.m8725c("和上次相同");
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f6787b = jCurrentTimeMillis;
            location.setTime(jCurrentTimeMillis);
            C1544g c1544gM8764i = WifiMan.m8749a().m8764i();
            C1544g c1544g = null;
            if (c1544gM8764i == null || c1544gM8764i.f6816a == null || c1544gM8764i.m8882b() <= 0) {
                C1534f.m8725c("wifi为空");
            } else {
                long j11 = 0;
                try {
                    jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
                } catch (Error unused) {
                    jElapsedRealtimeNanos = 0;
                }
                if (jElapsedRealtimeNanos > 0) {
                    Iterator<ScanResult> it = c1544gM8764i.f6816a.iterator();
                    long j12 = 0;
                    while (it.hasNext()) {
                        try {
                            j10 = (jElapsedRealtimeNanos - it.next().timestamp) / 1000000;
                        } catch (Throwable th2) {
                            if (C1534f.f6655a) {
                                th2.printStackTrace();
                            }
                            j10 = 0;
                        }
                        j12 += j10;
                    }
                    j11 = j12;
                }
                if (j11 / c1544gM8764i.m8882b() <= 10) {
                    C1534f.m8725c("wifi有效");
                } else {
                    C1534f.m8725c("wifi无效");
                    c1544gM8764i = null;
                }
                c1544g = c1544gM8764i;
            }
            C1541d.this.m8839a(new C1538a(C1539b.m8784a().m8799e()), c1544g, new Location(location), "&og=2&prod=SDKHW5.5.10:buildn817:" + LocationClient.mContext.getPackageName());
            C1541d.this.f6772f = location;
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i10, Bundle bundle) {
        }

        public /* synthetic */ c(C1541d c1541d, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private C1541d() {
        this.f6768a = 1000L;
        this.f6769b = null;
        this.f6770c = null;
        this.f6771e = false;
        this.f6774j = "LO";
        this.f6775k = "con";
        this.f6776l = "INSERT INTO LO (con) VALUES (%s);";
        this.f6777m = "DELETE FROM LO WHERE id NOT IN (SELECT id FROM LO LIMIT 1000);";
        this.f6778n = "DELETE FROM LO WHERE con IN (%s);";
        this.f6779o = "SELECT * FROM LO LIMIT 5";
        this.f6782r = null;
    }

    /* renamed from: c */
    public synchronized void m8849c() {
        if (this.f6771e) {
            LocationManager locationManager = this.f6769b;
            if (locationManager == null) {
                return;
            }
            try {
                locationManager.removeUpdates(this.f6770c);
            } catch (Exception unused) {
            }
            this.f6769b = null;
            this.f6771e = false;
        }
    }

    public /* synthetic */ C1541d(AnonymousClass1 anonymousClass1) {
        this();
    }

    /* renamed from: b */
    public static String m8843b(Location location) {
        if (location == null) {
            return null;
        }
        float speed = (float) (location.getSpeed() * 3.6d);
        if (!location.hasSpeed()) {
            speed = -1.0f;
        }
        return String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(location.hasBearing() ? location.getBearing() : -1.0f), Integer.valueOf((int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f)), Integer.valueOf(f6765d), Double.valueOf(location.hasAltitude() ? location.getAltitude() : 555.0d), Long.valueOf(location.getTime() / 1000));
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x0070  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.ArrayList<java.lang.String> m8848b() {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r6.f6773i     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L77
            if (r1 == 0) goto L7c
            boolean r1 = r1.isOpen()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L77
            if (r1 == 0) goto L7c
            android.database.sqlite.SQLiteDatabase r1 = r6.f6773i     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L77
            java.lang.String r2 = "SELECT * FROM LO LIMIT 5"
            android.database.Cursor r1 = r1.rawQuery(r2, r0)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L77
            if (r1 == 0) goto L70
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6b
            if (r2 == 0) goto L70
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6b
            r2.<init>()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6b
            java.lang.String r3 = "查出个数："
            r2.append(r3)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6b
            int r3 = r1.getCount()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6b
            r2.append(r3)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6b
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6b
            com.baidu.location.p065a.C1534f.m8725c(r2)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6b
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6b
            r2.<init>()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6b
        L39:
            boolean r0 = r1.isAfterLast()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L67
            if (r0 != 0) goto L69
            java.lang.String r0 = "con"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L67
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L67
            r2.add(r0)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L67
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L67
            r3.<init>()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L67
            java.lang.String r4 = "查出结果："
            r3.append(r4)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L67
            r3.append(r0)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L67
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L67
            com.baidu.location.p065a.C1534f.m8725c(r0)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L67
            r1.moveToNext()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L67
            goto L39
        L64:
            r0 = move-exception
            goto Lb3
        L67:
            r0 = move-exception
            goto L8a
        L69:
            r0 = r1
            goto L7d
        L6b:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L8a
        L70:
            r2 = r0
            goto L69
        L72:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto Lb3
        L77:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
            goto L8a
        L7c:
            r2 = r0
        L7d:
            if (r0 == 0) goto Lb1
            r0.close()     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L85
            goto Lb1
        L83:
            r0 = move-exception
            goto Lbe
        L85:
            r0 = move-exception
        L86:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L83
            goto Lb1
        L8a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64
            r3.<init>()     // Catch: java.lang.Throwable -> L64
            java.lang.String r4 = "插库出现异常"
            r3.append(r4)     // Catch: java.lang.Throwable -> L64
            java.lang.String r4 = r0.getMessage()     // Catch: java.lang.Throwable -> L64
            r3.append(r4)     // Catch: java.lang.Throwable -> L64
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L64
            com.baidu.location.p065a.C1534f.m8725c(r3)     // Catch: java.lang.Throwable -> L64
            boolean r3 = com.baidu.location.p065a.C1534f.f6655a     // Catch: java.lang.Throwable -> L64
            if (r3 == 0) goto La9
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L64
        La9:
            if (r1 == 0) goto Lb1
            r1.close()     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> Laf
            goto Lb1
        Laf:
            r0 = move-exception
            goto L86
        Lb1:
            monitor-exit(r6)
            return r2
        Lb3:
            if (r1 == 0) goto Lbd
            r1.close()     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> Lb9
            goto Lbd
        Lb9:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L83
        Lbd:
            throw r0     // Catch: java.lang.Throwable -> L83
        Lbe:
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.provider.C1541d.m8848b():java.util.ArrayList");
    }

    /* renamed from: a */
    public static C1541d m8837a() {
        return b.f6785a;
    }

    /* renamed from: a */
    public static String m8838a(Location location) {
        String strM8843b = m8843b(location);
        if (strM8843b == null) {
            return strM8843b;
        }
        return strM8843b + "&g_tp=0";
    }

    /* renamed from: a */
    public synchronized void m8846a(Context context) {
        if (this.f6771e) {
            return;
        }
        try {
            this.f6769b = (LocationManager) context.getApplicationContext().getSystemService(JsbMapKeyNames.H5_LOC);
            a aVar = new a();
            this.f6782r = aVar;
            this.f6769b.addGpsStatusListener(aVar);
            c cVar = new c();
            this.f6770c = cVar;
            this.f6769b.requestLocationUpdates("passive", 1000L, 0.0f, cVar);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.f6771e = true;
        try {
            File file = new File(LocationClient.mContext.getFilesDir(), "location.db");
            this.f6780p = file;
            if (!file.exists()) {
                this.f6780p.createNewFile();
            }
            C1534f.m8725c(this.f6780p.getAbsolutePath());
            this.f6773i = SQLiteDatabase.openOrCreateDatabase(this.f6780p, (SQLiteDatabase.CursorFactory) null);
        } catch (Exception e11) {
            C1534f.m8725c("file create error " + e11.getMessage());
            e11.printStackTrace();
        }
        SQLiteDatabase sQLiteDatabase = this.f6773i;
        if (sQLiteDatabase == null) {
            C1534f.m8725c("gpsman inited");
            return;
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS LO (id INTEGER PRIMARY KEY AUTOINCREMENT,con TEXT);");
        } catch (Exception e12) {
            C1534f.m8725c("db init error " + e12.getMessage());
            if (C1534f.f6655a) {
                e12.printStackTrace();
            }
        }
        C1534f.m8725c("gpsman inited");
        return;
    }

    /* renamed from: a */
    public synchronized void m8839a(C1538a c1538a, C1544g c1544g, Location location, String str) {
        String strM8714a = C1534f.m8714a(c1538a, c1544g, location, str + String.format(Locale.CHINA, "&ofl=%s|0", 1), 1);
        if (strM8714a != null) {
            C1534f.m8725c("gps:    " + strM8714a);
            String strEncodeOfflineLocationUpdateRequest = Jni.encodeOfflineLocationUpdateRequest(strM8714a);
            try {
                SQLiteDatabase sQLiteDatabase = this.f6773i;
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    this.f6773i.execSQL(String.format("INSERT INTO LO (con) VALUES (%s);", "\"" + strEncodeOfflineLocationUpdateRequest + "\""));
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("插库成功");
                    sb2.append(strEncodeOfflineLocationUpdateRequest);
                    C1534f.m8725c(sb2.toString());
                    this.f6773i.execSQL("DELETE FROM LO WHERE id NOT IN (SELECT id FROM LO LIMIT 1000);");
                }
            } catch (Exception e10) {
                C1534f.m8725c("插库或删除出现异常" + e10.getMessage());
                if (C1534f.f6655a) {
                    e10.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public void m8847a(ArrayList<String> arrayList) throws SQLException {
        try {
            SQLiteDatabase sQLiteDatabase = this.f6773i;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && arrayList != null && arrayList.size() > 0) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    stringBuffer.append("\"");
                    stringBuffer.append(arrayList.get(i10));
                    stringBuffer.append("\"");
                    if (i10 != arrayList.size() - 1) {
                        stringBuffer.append(",");
                    }
                }
                this.f6773i.execSQL(String.format("DELETE FROM LO WHERE con IN (%s);", stringBuffer.toString()));
                C1534f.m8725c("删除多余的数据成功");
            }
        } catch (Exception e10) {
            C1534f.m8725c("删除出现异常");
            e10.printStackTrace();
        }
    }

    /* renamed from: a */
    public static boolean m8841a(Location location, Location location2, boolean z10) {
        if (location == location2) {
            return false;
        }
        if (location == null || location2 == null) {
            return true;
        }
        float speed = location2.getSpeed();
        if (z10 && !C1532d.m8702a().m8704a(location2.getLongitude(), location2.getLatitude()) && speed < 5.0f) {
            return true;
        }
        float fDistanceTo = location2.distanceTo(location);
        return speed > C1534f.f6677w ? fDistanceTo > C1534f.f6679y : speed > C1534f.f6676v ? fDistanceTo > C1534f.f6678x : fDistanceTo > 5.0f;
    }
}
