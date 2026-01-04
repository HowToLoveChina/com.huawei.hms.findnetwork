package p763x5;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.feedback.constant.FeedbackConst;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p229di.C9142g;
import pe.C12132a;
import pe.InterfaceC12133b;

/* renamed from: x5.a */
/* loaded from: classes.dex */
public class C13703a {

    /* renamed from: e */
    public static final String f61692e;

    /* renamed from: f */
    public static final String f61693f;

    /* renamed from: g */
    public static final Map<String, String> f61694g;

    /* renamed from: h */
    public static final Object f61695h;

    /* renamed from: i */
    public static C13703a f61696i;

    /* renamed from: a */
    public boolean f61697a;

    /* renamed from: b */
    public boolean f61698b = false;

    /* renamed from: c */
    public InterfaceC12133b f61699c = new a();

    /* renamed from: d */
    public C12132a f61700d;

    /* renamed from: x5.a$a */
    public class a implements InterfaceC12133b {
        public a() {
        }

        @Override // pe.InterfaceC12133b, p046c4.InterfaceC1384b
        /* renamed from: a */
        public void mo7939a() {
            C2111d.m12653i("ClonePowerKit", "PowerKitConnection onServiceDisconnected");
            C13703a.this.f61697a = false;
        }

        @Override // pe.InterfaceC12133b, p046c4.InterfaceC1384b
        /* renamed from: b */
        public void mo7940b() {
            C2111d.m12653i("ClonePowerKit", "PowerKitConnection onServiceConnected");
            C13703a.this.f61697a = true;
        }
    }

    static {
        String str = C9142g.m57463b() ? "com.hihonor.email" : FeedbackConst.Mail.EMUI10_EMAIL_PKG_NAME;
        f61692e = str;
        String str2 = C9142g.m57463b() ? "com.hihonor.securitymgr" : "com.huawei.securitymgr";
        f61693f = str2;
        HashMap map = new HashMap();
        f61694g = map;
        f61695h = new Object();
        f61696i = new C13703a();
        map.put(NavigationUtils.SMS_SCHEMA_PREF, "com.android.phone");
        map.put("chatSms", "com.android.phone");
        map.put("Memo", "com.example.android.notepad");
        map.put("soundrecorder", "com.android.soundrecorder");
        map.put("calendar", "com.android.providers.calendar");
        map.put("email", str);
        map.put("hwKeyChain", str2);
        map.put("HwIdOobe", "com.huawei.hwid");
        map.put("huaweiBrowser", "com.android.browser");
    }

    /* renamed from: c */
    public static C13703a m82444c() {
        return f61696i;
    }

    /* renamed from: b */
    public final boolean m82445b(String str) {
        return f61694g.containsKey(str);
    }

    /* renamed from: d */
    public final String m82446d(String str) {
        return f61694g.get(str);
    }

    /* renamed from: e */
    public void m82447e(Context context) {
        C2111d.m12653i("ClonePowerKit", "init");
        synchronized (f61695h) {
            this.f61698b = true;
            try {
                this.f61700d = C12132a.m72750b(context, this.f61699c);
            } catch (NoSuchMethodError | SecurityException unused) {
                this.f61698b = false;
                C2111d.m12657m("ClonePowerKit", "Init fail err");
            }
        }
    }

    /* renamed from: f */
    public void m82448f(String str) {
        String strM82446d;
        if (TextUtils.isEmpty(str)) {
            C2111d.m12646b("ClonePowerKit", "moduleName is null");
            return;
        }
        synchronized (f61695h) {
            try {
                if (this.f61700d == null) {
                    C2111d.m12658n("ClonePowerKit", "powerKit is null ,moduleName: ", str);
                    return;
                }
                if (m82445b(str)) {
                    C2111d.m12654j("ClonePowerKit", "need keepAlive moduleName = ", str, ";isInit = ", Boolean.valueOf(this.f61698b), ";mIsPowerKitConnected = ", Boolean.valueOf(this.f61697a));
                    if (this.f61698b && this.f61697a) {
                        try {
                            strM82446d = m82446d(str);
                        } catch (RemoteException unused) {
                            C2111d.m12648d("ClonePowerKit", "applyForResourceUse fail!");
                        }
                        if (strM82446d == null) {
                            C2111d.m12657m("ClonePowerKit", "threadName is null");
                            return;
                        }
                        C2111d.m12654j("ClonePowerKit", "applyForResourceUse result = ", Boolean.valueOf(this.f61700d.m72751a(strM82446d, 65535, 1800000L, "clone need backup or restore data")));
                        C13706d c13706d = new C13706d();
                        c13706d.m82452b(new C13707e()).m82452b(new C13704b()).m82452b(new C13708f());
                        c13706d.mo82451a(this.f61700d, str, 65535, 1800000L, "clone need backup or restore data");
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: g */
    public void m82449g() {
        C2111d.m12653i("ClonePowerKit", "keep all alive");
        Iterator<String> it = f61694g.keySet().iterator();
        while (it.hasNext()) {
            m82448f(it.next());
        }
    }

    /* renamed from: h */
    public void m82450h() {
        C2111d.m12653i("ClonePowerKit", "release");
        synchronized (f61695h) {
            this.f61700d = null;
            this.f61698b = false;
        }
    }
}
