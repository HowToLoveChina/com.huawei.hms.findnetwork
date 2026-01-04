package p020ap;

import android.content.Context;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import java.util.LinkedHashMap;
import java.util.List;
import p037bp.C1270a;
import p207cp.C8932a;
import p232dp.InterfaceC9285d;

/* renamed from: ap.d */
/* loaded from: classes.dex */
public class C1009d {

    /* renamed from: a */
    public static volatile InterfaceC9285d f5043a;

    /* renamed from: b */
    public static final C1009d f5044b = new C1009d();

    /* renamed from: e */
    public static C1009d m6109e() {
        if (f5043a == null) {
            synchronized (C1009d.class) {
                try {
                    if (f5043a == null) {
                        f5043a = (InterfaceC9285d) C1270a.m7534b().m7535a(InterfaceC9285d.class);
                    }
                } finally {
                }
            }
        }
        return f5044b;
    }

    /* renamed from: a */
    public void m6110a(String str) {
        if (f5043a == null) {
            C8932a.m56653w("CommonDriveCaller", "activeCloud router unregister");
        } else {
            f5043a.activeCloud(str);
        }
    }

    /* renamed from: b */
    public void m6111b() {
        if (f5043a == null) {
            C8932a.m56653w("CommonDriveCaller", "checkServerControlStatus router unregister");
        } else {
            f5043a.mo17172e();
        }
    }

    /* renamed from: c */
    public void m6112c() {
        if (f5043a == null) {
            C8932a.m56653w("CommonDriveCaller", "clearStockActiveStatus router unregister");
        } else {
            f5043a.mo17179l();
        }
    }

    /* renamed from: d */
    public String m6113d() {
        if (f5043a != null) {
            return String.valueOf(f5043a.mo17188u());
        }
        C8932a.m56653w("CommonDriveCaller", "getHMSVersionCode unregister");
        return "";
    }

    /* renamed from: f */
    public String m6114f(String str, String str2, String str3) {
        if (f5043a != null) {
            return f5043a.getParam(str, str2, str3);
        }
        C8932a.m56653w("CommonDriveCaller", "getParam unregister");
        return "";
    }

    /* renamed from: g */
    public int m6115g() {
        if (f5043a != null) {
            return f5043a.mo17189v();
        }
        C8932a.m56653w("CommonDriveCaller", "getResetStatus router unregister");
        return 0;
    }

    /* renamed from: h */
    public String m6116h() {
        if (f5043a != null) {
            return String.valueOf(f5043a.mo17190w());
        }
        C8932a.m56653w("CommonDriveCaller", "getSupportIapVer unregister");
        return "";
    }

    /* renamed from: i */
    public boolean m6117i() {
        if (f5043a != null) {
            return f5043a.mo17184q();
        }
        C8932a.m56653w("CommonDriveCaller", "isActiveCloudAuto router unregister");
        return false;
    }

    /* renamed from: j */
    public boolean m6118j(Context context) {
        if (f5043a != null) {
            return f5043a.mo17191x(context);
        }
        C8932a.m56653w("CommonDriveCaller", "isNotificationEnabled router unregister");
        return false;
    }

    /* renamed from: k */
    public boolean m6119k(List<String> list, List<String> list2, String str, int i10, LinkedHashMap<String, String> linkedHashMap) {
        if (f5043a != null) {
            return f5043a.mo17177j(list, list2, str, i10, linkedHashMap);
        }
        C8932a.m56653w("CommonDriveCaller", "isParamSatisfy unregister");
        return false;
    }

    /* renamed from: l */
    public void m6120l(AppStatus appStatus) {
        if (f5043a == null) {
            C8932a.m56653w("CommonDriveCaller", "onFrontAppClick router unregister");
        } else {
            f5043a.mo17186s(appStatus);
        }
    }

    /* renamed from: m */
    public void m6121m(String str) {
        if (f5043a == null) {
            C8932a.m56653w("CommonDriveCaller", "onReceiveResetMsg router unregister");
        } else {
            f5043a.mo17170c(str);
        }
    }

    /* renamed from: n */
    public void m6122n(String str) {
        if (f5043a == null) {
            C8932a.m56653w("CommonDriveCaller", "onReceiveResetMsg router unregister");
        } else {
            f5043a.mo17176i(str);
        }
    }

    /* renamed from: o */
    public void m6123o(Context context, String str, int i10, long j10) {
        if (f5043a == null) {
            C8932a.m56653w("CommonDriveCaller", "setAutoBackupTimerrouter unregister");
        } else {
            f5043a.mo17192y(context, str, i10, j10);
        }
    }

    /* renamed from: p */
    public void m6124p() {
        if (f5043a == null) {
            C8932a.m56653w("CommonDriveCaller", "setHasEnteredMainActivity router unregister");
        } else {
            f5043a.mo17180m();
        }
    }
}
