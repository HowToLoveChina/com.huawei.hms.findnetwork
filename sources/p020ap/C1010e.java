package p020ap;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import java.util.function.Consumer;
import p037bp.C1270a;
import p207cp.C8932a;
import p232dp.InterfaceC9287f;
import p709vj.C13452e;

/* renamed from: ap.e */
/* loaded from: classes.dex */
public class C1010e {

    /* renamed from: a */
    public static volatile InterfaceC9287f f5045a;

    /* renamed from: b */
    public static final C1010e f5046b = new C1010e();

    /* renamed from: b */
    public static C1010e m6125b() {
        if (f5045a == null) {
            synchronized (C1010e.class) {
                try {
                    if (f5045a == null) {
                        f5045a = (InterfaceC9287f) C1270a.m7534b().m7535a(InterfaceC9287f.class);
                    }
                } finally {
                }
            }
        }
        return f5046b;
    }

    /* renamed from: A */
    public void m6126A(Context context) {
        if (f5045a == null) {
            C8932a.m56653w("PhoneFinderCaller", "setSuggestActivityEnabled router unregister");
        } else {
            f5045a.mo58542E(context);
        }
    }

    /* renamed from: B */
    public void m6127B(Context context, int i10) {
        if (f5045a == null) {
            C8932a.m56653w("PhoneFinderCaller", "checkAndStartActivatePhoneActivity router unregister");
        } else {
            f5045a.mo58544G(context, i10);
        }
    }

    /* renamed from: C */
    public void m6128C(Consumer<Location> consumer, Context context) {
        if (f5045a == null) {
            C8932a.m56653w("PhoneFinderCaller", "startLocate router unregister");
        } else {
            f5045a.mo58545H(consumer, context);
        }
    }

    /* renamed from: D */
    public void m6129D(Bundle bundle) {
        f5045a.mo58553P(bundle);
    }

    /* renamed from: E */
    public void m6130E() {
        if (f5045a == null) {
            C8932a.m56653w("PhoneFinderCaller", "registerSwitchChangeCallback router unregister");
        } else {
            f5045a.mo58556S();
        }
    }

    /* renamed from: F */
    public void m6131F(Context context) {
        if (f5045a == null) {
            C8932a.m56653w("PhoneFinderCaller", "updatePublicKey router unregister");
        } else {
            f5045a.mo58543F(context);
        }
    }

    /* renamed from: G */
    public Location m6132G(Location location) {
        if (f5045a != null) {
            return f5045a.mo58554Q(location);
        }
        C8932a.m56653w("PhoneFinderCaller", "wgs84ToGcj02 router unregister");
        return null;
    }

    /* renamed from: H */
    public void m6133H(Context context, boolean z10) {
        if (f5045a == null) {
            C8932a.m56653w("PhoneFinderCaller", "writeLastlocSwitchStatusToFile router unregister");
        } else {
            f5045a.mo58560c(context, z10);
        }
    }

    /* renamed from: I */
    public void m6134I(Context context, boolean z10) {
        if (f5045a == null) {
            C8932a.m56653w("PhoneFinderCaller", "writeLastlocSwitchStatusToFile router unregister");
        } else {
            f5045a.mo58570m(context, z10);
        }
    }

    /* renamed from: J */
    public void m6135J(Context context) {
        if (f5045a == null) {
            C8932a.m56653w("PhoneFinderCaller", "writeUISwitchToFile router unregister");
        } else {
            f5045a.mo58581x(context);
        }
    }

    /* renamed from: a */
    public String m6136a(Context context) {
        if (f5045a != null) {
            return f5045a.mo58572o(context);
        }
        C8932a.m56653w("PhoneFinderCaller", "getAccountTypeFromPhoneFinder router unregister");
        return C13452e.m80781L().m80905e();
    }

    /* renamed from: c */
    public boolean m6137c(String str, String str2) {
        if (f5045a != null) {
            return f5045a.mo58577t(str, str2);
        }
        C8932a.m56653w("PhoneFinderCaller", "getPhoneFinderByDevice router unregister");
        return false;
    }

    /* renamed from: d */
    public boolean m6138d(Context context) {
        if (f5045a != null) {
            return f5045a.mo58574q(context);
        }
        C8932a.m56653w("PhoneFinderCaller", "getPhoneFinderSwitch router unregister");
        return false;
    }

    /* renamed from: e */
    public boolean m6139e(Context context) {
        if (f5045a != null) {
            return f5045a.mo58548K(context);
        }
        C8932a.m56653w("PhoneFinderCaller", "getPhoneFinderSwitchCheckUid router unregister");
        return false;
    }

    /* renamed from: f */
    public int m6140f(Context context) {
        if (f5045a != null) {
            return f5045a.mo58546I(context);
        }
        C8932a.m56653w("PhoneFinderCaller", "getUISwitchToFile router unregister");
        return 0;
    }

    /* renamed from: g */
    public String m6141g(Context context) {
        if (f5045a != null) {
            return f5045a.mo58571n(context);
        }
        C8932a.m56653w("PhoneFinderCaller", "getUserIDFromPhoneFinder router unregister");
        return null;
    }

    /* renamed from: h */
    public boolean m6142h(String str) {
        if (f5045a != null) {
            return f5045a.mo58552O(str);
        }
        C8932a.m56653w("PhoneFinderCaller", "hasLocalActivationLock router unregister");
        return false;
    }

    /* renamed from: i */
    public boolean m6143i(Context context) {
        if (f5045a != null) {
            return f5045a.mo58568k(context);
        }
        C8932a.m56653w("PhoneFinderCaller", "isLastLocReportSwitchOpen router unregister");
        return false;
    }

    /* renamed from: j */
    public boolean m6144j() {
        if (f5045a != null) {
            return f5045a.mo58562e();
        }
        C8932a.m56653w("PhoneFinderCaller", "isSendPhoneFinderOning router unregister");
        return false;
    }

    /* renamed from: k */
    public boolean m6145k() {
        if (f5045a != null) {
            return f5045a.mo58569l();
        }
        C8932a.m56653w("PhoneFinderCaller", "isPhoneFinderOning router unregister");
        return false;
    }

    /* renamed from: l */
    public boolean m6146l(Context context, String str) {
        if (f5045a != null) {
            return f5045a.mo58580w(context, str);
        }
        C8932a.m56653w("PhoneFinderCaller", "isPhoneFinderSwitchInvalid router unregister");
        return false;
    }

    /* renamed from: m */
    public boolean m6147m(Context context) {
        if (f5045a != null) {
            return f5045a.mo58550M(context);
        }
        C8932a.m56653w("PhoneFinderCaller", "isShareLocateSwitchOpen router unregister");
        return false;
    }

    /* renamed from: n */
    public boolean m6148n(String str) {
        if (f5045a != null) {
            return f5045a.mo58563f(str);
        }
        C8932a.m56653w("PhoneFinderCaller", "isShowPhoneFinderFeature router unregister");
        return false;
    }

    /* renamed from: o */
    public boolean m6149o() {
        if (f5045a != null) {
            return f5045a.isSupportAntiTheft();
        }
        C8932a.m56653w("PhoneFinderCaller", "isSupportAntiTheft router unregister");
        return false;
    }

    /* renamed from: p */
    public boolean m6150p(Context context) {
        if (f5045a != null) {
            return f5045a.mo58538A(context);
        }
        C8932a.m56653w("PhoneFinderCaller", "isROMSupportedV3 router unregister");
        return false;
    }

    /* renamed from: q */
    public void m6151q(Context context, int i10) {
        if (f5045a == null) {
            C8932a.m56653w("PhoneFinderCaller", "openPhoneFinderInBack router unregister");
        } else {
            f5045a.mo58564g(context, i10);
        }
    }

    /* renamed from: r */
    public boolean m6152r(Location location) {
        if (f5045a != null) {
            return f5045a.mo58561d(location);
        }
        C8932a.m56653w("PhoneFinderCaller", "outOfChina router unregister");
        return false;
    }

    /* renamed from: s */
    public String m6153s(Context context) {
        if (f5045a != null) {
            return f5045a.mo58555R(context);
        }
        C8932a.m56653w("PhoneFinderCaller", "writePushTokenToFile router unregister");
        return null;
    }

    /* renamed from: t */
    public void m6154t(Activity activity, Consumer<Location> consumer) {
        if (f5045a == null) {
            C8932a.m56653w("PhoneFinderCaller", "registerMapRetry router unregister");
        } else {
            f5045a.mo58582y(activity, consumer);
        }
    }

    /* renamed from: u */
    public void m6155u(Handler handler) {
        if (f5045a == null) {
            C8932a.m56653w("PhoneFinderCaller", "registerSwitchChangeCallback router unregister");
        } else {
            f5045a.mo58567j(handler);
        }
    }

    /* renamed from: v */
    public void m6156v(Context context) {
        if (f5045a == null) {
            C8932a.m56653w("PhoneFinderCaller", "sendLogOffToPhoneFinder router unregister");
        } else {
            f5045a.mo58557T(context);
        }
    }

    /* renamed from: w */
    public void m6157w(Context context, String str) {
        if (f5045a == null) {
            C8932a.m56653w("PhoneFinderCaller", "sendLogOffToPhoneFinder router unregister");
        } else {
            f5045a.mo58565h(context, str);
        }
    }

    /* renamed from: x */
    public void m6158x(String str, Context context, Bundle bundle) {
        if (f5045a == null) {
            C8932a.m56653w("PhoneFinderCaller", "sendLogOnBroadcastToPhoneFinder router unregister");
        } else {
            f5045a.mo58541D(str, context, bundle);
        }
    }

    /* renamed from: y */
    public void m6159y(String str) {
        if (f5045a == null) {
            C8932a.m56653w("PhoneFinderCaller", "setFrpToken router unregister");
        } else {
            f5045a.mo58576s(str);
        }
    }

    /* renamed from: z */
    public void m6160z() {
        if (f5045a == null) {
            C8932a.m56653w("PhoneFinderCaller", "setSendPhoneFinderOn router unregister");
        } else {
            f5045a.mo58558a();
        }
    }
}
