package com.huawei.location.crowdsourcing;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import as.C1016d;
import br.InterfaceC1273a;
import com.huawei.hms.support.api.location.common.LocationConstant;
import com.huawei.location.crowdsourcing.Config;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.StatusChangeMethods;
import com.huawei.secure.android.common.intent.SafeIntent;
import cr.C8944a;
import es.C9548m;
import es.C9550o;
import hu.C10343b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p234dr.C9298d;

/* renamed from: com.huawei.location.crowdsourcing.c */
/* loaded from: classes8.dex */
public final class C6747c {

    /* renamed from: k */
    public static volatile boolean f31276k = false;

    /* renamed from: l */
    @SuppressLint({"StaticFieldLeak"})
    public static Context f31277l;

    /* renamed from: a */
    public c f31278a;

    /* renamed from: b */
    public a f31279b;

    /* renamed from: c */
    public final List<InterfaceC1273a> f31280c = Collections.synchronizedList(new ArrayList());

    /* renamed from: d */
    public long f31281d;

    /* renamed from: e */
    public double f31282e;

    /* renamed from: f */
    public double f31283f;

    /* renamed from: g */
    public C6750f f31284g;

    /* renamed from: h */
    public C6752h f31285h;

    /* renamed from: i */
    public C6745a f31286i;

    /* renamed from: j */
    public final b f31287j;

    /* renamed from: com.huawei.location.crowdsourcing.c$a */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = new SafeIntent(intent).getAction();
            if (action == null) {
                C1016d.m6183c("Crowdsourcing", "get null action");
            } else if (!action.equals("android.intent.action.SIM_STATE_CHANGED")) {
                C1016d.m6183c("Crowdsourcing", "receive unknown action,action:".concat(action));
            } else {
                C1016d.m6181a("Crowdsourcing", "onReceive action=".concat(action));
                C6747c.this.f31287j.obtainMessage(2).sendToTarget();
            }
        }

        public /* synthetic */ a(C6747c c6747c, int i10) {
            this();
        }
    }

    /* renamed from: com.huawei.location.crowdsourcing.c$b */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) throws IOException {
            int i10 = message.what;
            if (i10 == 1) {
                C1016d.m6186f("Crowdsourcing", "handleMessage: LOCATION_CHANGED");
                Object obj = message.obj;
                if (obj instanceof Location) {
                    C6747c.m38337g(C6747c.this, (Location) obj);
                    return;
                } else {
                    C1016d.m6183c("Crowdsourcing", "handleMessage not location obj");
                    return;
                }
            }
            if (i10 == 0) {
                C1016d.m6186f("Crowdsourcing", "begin init");
                if (C6747c.m38338h(C6747c.this, getLooper())) {
                    C1016d.m6186f("Crowdsourcing", "init finished");
                    return;
                }
                C1016d.m6183c("Crowdsourcing", "init failed");
                C6747c.m38336f(C6747c.this);
                getLooper().quitSafely();
                return;
            }
            if (i10 != 2) {
                C1016d.m6183c("Crowdsourcing", "unknown msg:" + message.what);
            } else {
                if (Config.C6744b.f31261a.m38318z(C9298d.m58596a(C6747c.m38332b()))) {
                    C1016d.m6186f("Crowdsourcing", "check mcc success");
                    return;
                }
                C1016d.m6183c("Crowdsourcing", "check mcc failed");
                C6747c.m38336f(C6747c.this);
                getLooper().quitSafely();
            }
        }
    }

    /* renamed from: com.huawei.location.crowdsourcing.c$c */
    public class c implements LocationListener {
        public c() {
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            if (location == null) {
                C1016d.m6183c("Crowdsourcing", "location null");
                return;
            }
            C10343b c10343b = new C10343b(location.getExtras());
            if (c10343b.m63683e() != null && c10343b.m63686h("accuracyType") == 1 && C9550o.m59635h()) {
                C1016d.m6181a("Crowdsourcing", "approximate not collect");
            } else {
                C6747c.this.f31287j.obtainMessage(1, location).sendToTarget();
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            C1016d.m6181a("Crowdsourcing", "onProviderDisabled");
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
            C1016d.m6181a("Crowdsourcing", "onProviderEnabled");
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i10, Bundle bundle) {
            C1016d.m6181a("Crowdsourcing", StatusChangeMethods.STATUS_CHANGE);
        }

        public /* synthetic */ c(C6747c c6747c, int i10) {
            this();
        }
    }

    public C6747c(Looper looper) {
        this.f31287j = new b(looper);
    }

    /* renamed from: a */
    public static boolean m38331a(C6747c c6747c) {
        c6747c.getClass();
        if (!C9548m.m59619b(f31277l, LocationConstant.BACKGROUND_PERMISSION)) {
            C1016d.m6190j("Crowdsourcing", "can not access background location");
        }
        return C9548m.m59619b(f31277l, "android.permission.ACCESS_FINE_LOCATION") && C9548m.m59619b(f31277l, "android.permission.ACCESS_COARSE_LOCATION");
    }

    /* renamed from: b */
    public static Context m38332b() {
        return f31277l;
    }

    /* renamed from: e */
    public static void m38335e(Context context) {
        if (f31276k) {
            C1016d.m6181a("Crowdsourcing", "double start");
            return;
        }
        if (context == null) {
            C1016d.m6183c("Crowdsourcing", "context is null");
            return;
        }
        synchronized (C6747c.class) {
            try {
                if (f31276k) {
                    C1016d.m6181a("Crowdsourcing", "double start");
                    return;
                }
                C1016d.m6186f("Crowdsourcing", "start");
                f31277l = context.getApplicationContext();
                HandlerThread handlerThread = new HandlerThread("Crowdsourcing");
                handlerThread.start();
                new C6747c(handlerThread.getLooper()).f31287j.obtainMessage(0).sendToTarget();
                f31276k = true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: f */
    public static void m38336f(C6747c c6747c) {
        c6747c.getClass();
        C1016d.m6190j("Crowdsourcing", "Stop");
        if (f31276k) {
            try {
                c cVar = c6747c.f31278a;
                if (cVar != null) {
                    Object systemService = f31277l.getSystemService(JsbMapKeyNames.H5_LOC);
                    if (systemService instanceof LocationManager) {
                        ((LocationManager) systemService).removeUpdates(cVar);
                    } else {
                        C1016d.m6183c("Crowdsourcing", "not get LocationManager");
                    }
                    c6747c.f31278a = null;
                }
                a aVar = c6747c.f31279b;
                if (aVar != null) {
                    m38332b().unregisterReceiver(aVar);
                    c6747c.f31279b = null;
                }
                Iterator<InterfaceC1273a> it = c6747c.f31280c.iterator();
                while (it.hasNext()) {
                    it.next().mo7544a();
                    c6747c.f31280c.clear();
                }
                C6745a c6745a = c6747c.f31286i;
                if (c6745a != null) {
                    c6745a.m38325e();
                    c6747c.f31286i = null;
                }
            } catch (Exception unused) {
                C1016d.m6183c("Crowdsourcing", "Stop exception");
            }
        }
    }

    /* renamed from: g */
    public static void m38337g(C6747c c6747c, Location location) throws IOException {
        c6747c.getClass();
        long jAbs = Math.abs(System.currentTimeMillis() - c6747c.f31281d);
        if (jAbs < Config.C6744b.f31261a.m38295A()) {
            C1016d.m6181a("Crowdsourcing", "not need collect, collect interval check failed. timeDiff:" + jAbs);
            return;
        }
        float[] fArr = new float[1];
        Location.distanceBetween(location.getLatitude(), location.getLongitude(), c6747c.f31282e, c6747c.f31283f, fArr);
        float f10 = fArr[0];
        if (f10 < Config.C6744b.f31261a.m38310p()) {
            C1016d.m6181a("Crowdsourcing", "not need collect, collect distance check failed. distanceDiff:" + f10);
            return;
        }
        C1016d.m6181a("Crowdsourcing", "collect");
        List<ScanResult> listM38348e = c6747c.f31284g.m38348e();
        List<C8944a> listM38353c = c6747c.f31285h.m38353c();
        if (listM38348e == null && listM38353c == null) {
            C1016d.m6181a("Crowdsourcing", "no wifi and no cell, not collect");
            return;
        }
        c6747c.f31286i.m38326f(location, listM38348e, listM38353c);
        c6747c.f31281d = System.currentTimeMillis();
        c6747c.f31282e = location.getLatitude();
        c6747c.f31283f = location.getLongitude();
    }

    /* renamed from: h */
    public static boolean m38338h(C6747c c6747c, Looper looper) {
        String str;
        String str2;
        String str3;
        c6747c.getClass();
        Config config = Config.C6744b.f31261a;
        c6747c.f31280c.add(config);
        int i10 = 0;
        if (!config.m38317y(f31277l, looper)) {
            str3 = "config init failed";
        } else {
            if (!config.m38304j()) {
                C6750f c6750f = new C6750f(looper);
                c6747c.f31284g = c6750f;
                c6747c.f31280c.add(c6750f);
                C6752h c6752h = new C6752h();
                c6747c.f31285h = c6752h;
                c6747c.f31280c.add(c6752h);
                try {
                    C6745a c6745a = new C6745a(looper, f31277l.getFilesDir().getCanonicalPath());
                    c6747c.f31286i = c6745a;
                    c6747c.f31280c.add(c6745a);
                    c6747c.f31284g.m38347d();
                    c6747c.f31285h.getClass();
                    if (!C9548m.m59619b(f31277l, "android.permission.ACCESS_FINE_LOCATION")) {
                        str2 = "cellCollector init failed";
                    } else {
                        if (c6747c.f31286i.m38323b()) {
                            a aVar = new a(c6747c, i10);
                            c6747c.f31279b = aVar;
                            f31277l.registerReceiver(aVar, new IntentFilter("android.intent.action.SIM_STATE_CHANGED"));
                            C1016d.m6186f("Crowdsourcing", "sim state change register success");
                            c cVar = new c(c6747c, i10);
                            c6747c.f31278a = cVar;
                            if (!m38331a(c6747c)) {
                                C1016d.m6183c("Crowdsourcing", "check permission failed");
                                return false;
                            }
                            Object systemService = f31277l.getSystemService(JsbMapKeyNames.H5_LOC);
                            if (systemService instanceof LocationManager) {
                                try {
                                    ((LocationManager) systemService).requestLocationUpdates("passive", 0L, 0.0f, cVar);
                                    C1016d.m6186f("Crowdsourcing", "location listener register success");
                                    return true;
                                } catch (IllegalArgumentException unused) {
                                    str = "LocationManager requestLocationUpdates throw IllegalArgumentException";
                                } catch (SecurityException unused2) {
                                    str = "LocationManager requestLocationUpdates throw SecurityException";
                                } catch (Exception unused3) {
                                    str = "LocationManager requestLocationUpdates throw other exception";
                                }
                            } else {
                                str = "not get LocationManager";
                            }
                            C1016d.m6183c("Crowdsourcing", str);
                            return false;
                        }
                        str2 = "recorder init failed";
                    }
                    C1016d.m6183c("Crowdsourcing", str2);
                    return false;
                } catch (IOException unused4) {
                    C1016d.m6183c("Crowdsourcing", "get folder path failed");
                    return false;
                }
            }
            str3 = "switch is closed";
        }
        C1016d.m6183c("Crowdsourcing", str3);
        return false;
    }
}
