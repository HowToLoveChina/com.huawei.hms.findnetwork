package com.huawei.hms.locationSdk;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.gson.JsonSyntaxException;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationRequestHelper;
import com.huawei.hms.support.api.location.common.PermissionUtil;
import com.huawei.location.lite.common.report.C6791a;
import com.huawei.location.lite.common.report.ReportBuilder;
import es.C9538c;
import es.C9542g;
import es.C9545j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import p531or.C11991a;
import p588qr.C12390b;

/* renamed from: com.huawei.hms.locationSdk.d0 */
/* loaded from: classes8.dex */
public class C5705d0 implements Handler.Callback {

    /* renamed from: a */
    private C5752s f25494a;

    /* renamed from: b */
    private C5762v0 f25495b;

    /* renamed from: c */
    private HandlerThread f25496c;

    /* renamed from: d */
    private final AtomicBoolean f25497d;

    /* renamed from: e */
    private long f25498e;

    /* renamed from: f */
    private int f25499f;

    /* renamed from: g */
    private C5746q f25500g;

    /* renamed from: h */
    private Handler f25501h;

    /* renamed from: i */
    private AtomicInteger f25502i;

    /* renamed from: j */
    private String f25503j;

    /* renamed from: k */
    private String f25504k;

    /* renamed from: com.huawei.hms.locationSdk.d0$b */
    public static class b {

        /* renamed from: a */
        private static final C5705d0 f25505a = new C5705d0();
    }

    private C5705d0() {
        this.f25497d = new AtomicBoolean(false);
        this.f25502i = new AtomicInteger(0);
        m33053d();
    }

    /* renamed from: b */
    public static C5705d0 m33051b() {
        return b.f25505a;
    }

    /* renamed from: c */
    private void m33052c() {
        if (this.f25494a == null) {
            this.f25494a = new C5752s(this.f25500g);
        }
        if (this.f25495b == null) {
            this.f25495b = new C5762v0();
        }
    }

    /* renamed from: d */
    private void m33053d() {
        if (m33055f()) {
            try {
                this.f25500g = (C5746q) C9542g.m59588a().fromJson(C12390b.m74456g().m74461e("gnssException"), C5746q.class);
            } catch (JsonSyntaxException unused) {
                HMSLocationLog.m36660e("LocationCallbackStatusAnalyzer", "", "config to json failed");
            }
            if (this.f25500g == null) {
                C5746q c5746q = new C5746q();
                this.f25500g = c5746q;
                c5746q.m33150h();
            }
            HMSLocationLog.m36662i("LocationCallbackStatusAnalyzer", "", this.f25500g.toString());
        }
    }

    /* renamed from: e */
    private boolean m33054e() {
        if (PermissionUtil.isPermissionAvailable(C11991a.m72145a(), "android.permission.ACCESS_FINE_LOCATION") && this.f25500g.m33145c() != 0) {
            return this.f25500g.m33144b() == null || this.f25500g.m33144b().contains(C11991a.m72145a().getApplicationContext().getPackageName());
        }
        return false;
    }

    /* renamed from: f */
    private boolean m33055f() {
        int iM59567f = C9538c.m59567f(C11991a.m72145a());
        return iM59567f == 8 || iM59567f == 0 || iM59567f == 1;
    }

    /* renamed from: g */
    private void m33056g() throws IllegalArgumentException {
        HMSLocationLog.m36662i("LocationCallbackStatusAnalyzer", "", "post network request");
        FusedLocationProviderClient fusedLocationProviderClient = new FusedLocationProviderClient(C11991a.m72145a());
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setPriority(102);
        locationRequest.setNumUpdates(1);
        locationRequest.setExpirationDuration(10000L);
        locationRequest.putExtras(LocationRequestHelper.CP_TRANS_ID, this.f25504k);
        fusedLocationProviderClient.requestLocationUpdates(locationRequest, new LocationCallback(), m33046a());
    }

    /* renamed from: h */
    private void m33057h() {
        Handler handler = this.f25501h;
        if (handler != null) {
            handler.removeMessages(1);
            Handler handler2 = this.f25501h;
            handler2.sendMessageDelayed(handler2.obtainMessage(1), this.f25500g.m33146d() * 1000);
        }
    }

    /* renamed from: i */
    private synchronized void m33058i() {
        if (this.f25497d.get()) {
            if (this.f25500g.m33145c() != 0 && this.f25500g.m33145c() != 2) {
                if (this.f25499f == this.f25500g.m33147e()) {
                    HMSLocationLog.m36662i("LocationCallbackStatusAnalyzer", "", "report reach max count");
                    return;
                }
                if (System.currentTimeMillis() - (this.f25500g.m33143a() * 1000) < this.f25498e) {
                    HMSLocationLog.m36662i("LocationCallbackStatusAnalyzer", "", "report not reach time");
                    return;
                }
                this.f25499f++;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("GnssFrameStatus", this.f25494a.m33159a());
                    jSONObject.put("LocationInfo", this.f25495b.m33182a());
                    if (!TextUtils.isEmpty(this.f25504k)) {
                        jSONObject.put(LocationRequestHelper.CP_TRANS_ID, this.f25504k);
                    }
                } catch (JSONException unused) {
                    HMSLocationLog.m36660e("LocationCallbackStatusAnalyzer", "", "buildBody exception");
                }
                this.f25498e = System.currentTimeMillis();
                ReportBuilder reportBuilder = new ReportBuilder();
                reportBuilder.setApiName("Location_GnssException_SDK");
                reportBuilder.setWLANScan();
                reportBuilder.setLocationEnable(C9545j.m59603d(C11991a.m72145a()));
                reportBuilder.setTransactionID(this.f25503j);
                reportBuilder.setExt(jSONObject.toString());
                C6791a.m38458h().m38466k(1, reportBuilder.getEventId(), reportBuilder.build());
                m33050a(jSONObject);
                m33056g();
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        m33058i();
        m33057h();
        return false;
    }

    /* renamed from: j */
    public synchronized void m33061j() {
        if (!this.f25497d.get()) {
            HMSLocationLog.m36663w("LocationCallbackStatusAnalyzer", "", "is stopped,do nothing");
            return;
        }
        if (this.f25502i.decrementAndGet() > 0) {
            HMSLocationLog.m36663w("LocationCallbackStatusAnalyzer", "", "also have gnss request,not stop");
            return;
        }
        this.f25497d.set(false);
        HMSLocationLog.m36663w("LocationCallbackStatusAnalyzer", "", "stop analyzer");
        C5752s c5752s = this.f25494a;
        if (c5752s != null) {
            c5752s.m33161c();
            this.f25494a = null;
        }
        C5762v0 c5762v0 = this.f25495b;
        if (c5762v0 != null) {
            c5762v0.m33184b();
            this.f25495b = null;
        }
        this.f25499f = 0;
        Handler handler = this.f25501h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public /* synthetic */ C5705d0(a aVar) {
        this();
    }

    /* renamed from: a */
    private synchronized Looper m33046a() {
        try {
            if (this.f25496c == null) {
                HandlerThread handlerThread = new HandlerThread("Loc_AnalyzerHandler");
                this.f25496c = handlerThread;
                handlerThread.start();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f25496c.getLooper();
    }

    /* renamed from: b */
    public synchronized void m33060b(final HWLocation hWLocation) {
        Handler handler;
        if (this.f25497d.get() && (handler = this.f25501h) != null) {
            handler.post(new Runnable() { // from class: com.huawei.hms.locationSdk.y1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f25605a.m33048a(hWLocation);
                }
            });
        }
    }

    /* renamed from: a */
    private List<String> m33047a(String str, int i10) {
        String strSubstring;
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i11 = 0;
        int i12 = i10;
        while (true) {
            if (i12 >= length) {
                try {
                    strSubstring = str.substring(i11, length);
                } catch (Exception unused) {
                    return arrayList;
                }
            } else {
                strSubstring = str.substring(i11, i12);
            }
            arrayList.add(strSubstring);
            i11 = i12;
            i12 += i10;
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m33048a(HWLocation hWLocation) {
        m33057h();
        C5762v0 c5762v0 = this.f25495b;
        if (c5762v0 != null) {
            c5762v0.m33185b(hWLocation);
        }
    }

    /* renamed from: a */
    private void m33050a(JSONObject jSONObject) {
        String str;
        String strReplace = jSONObject.toString().replace("\\", "");
        if (strReplace.length() > 4000) {
            List<String> listM33047a = m33047a(strReplace, 4000);
            HMSLocationLog.m36662i("LocationCallbackStatusAnalyzer", "", "reportBody log start");
            Iterator<String> it = listM33047a.iterator();
            while (it.hasNext()) {
                HMSLocationLog.m36662i("LocationCallbackStatusAnalyzer", "", it.next());
            }
            str = "reportBody log end";
        } else {
            str = "reportBody:" + strReplace;
        }
        HMSLocationLog.m36662i("LocationCallbackStatusAnalyzer", "", str);
    }

    /* renamed from: a */
    public synchronized void m33059a(String str, String str2) {
        if (m33055f() && m33054e()) {
            this.f25503j = str;
            this.f25504k = str2;
            this.f25502i.incrementAndGet();
            if (this.f25497d.get()) {
                HMSLocationLog.m36663w("LocationCallbackStatusAnalyzer", "", "analyzer is started");
                return;
            }
            if (this.f25501h == null) {
                this.f25501h = new Handler(m33046a(), this);
            }
            m33052c();
            boolean z10 = this.f25500g.m33145c() == 1 || this.f25500g.m33145c() == 2;
            HMSLocationLog.m36662i("LocationCallbackStatusAnalyzer", "", "start gnss:" + this.f25494a.m33160a(this.f25500g.m33148f(), m33046a(), z10) + ",statLocation:" + this.f25495b.m33183a(this.f25500g.m33148f(), m33046a(), z10));
            this.f25497d.set(true);
            Handler handler = this.f25501h;
            if (handler != null) {
                handler.removeMessages(1);
                Handler handler2 = this.f25501h;
                handler2.sendMessageDelayed(handler2.obtainMessage(1), 10000L);
            }
            return;
        }
        HMSLocationLog.m36663w("LocationCallbackStatusAnalyzer", "", "not support analyzer:" + Build.VERSION.SDK_INT);
    }
}
