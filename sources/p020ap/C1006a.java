package p020ap;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.hicloud.router.data.AppInfo;
import com.huawei.hicloud.router.data.SwitchInfo;
import java.util.ArrayList;
import java.util.Map;
import p037bp.C1270a;
import p207cp.C8932a;
import p232dp.InterfaceC9282a;
import p850zo.InterfaceC14350a;
import p850zo.InterfaceC14351b;

/* renamed from: ap.a */
/* loaded from: classes.dex */
public class C1006a {

    /* renamed from: a */
    public static volatile InterfaceC9282a f5037a;

    /* renamed from: b */
    public static final C1006a f5038b = new C1006a();

    /* renamed from: k */
    public static C1006a m5936k() {
        if (f5037a == null) {
            synchronized (C1006a.class) {
                try {
                    if (f5037a == null) {
                        f5037a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
                    }
                } finally {
                }
            }
        }
        return f5038b;
    }

    /* renamed from: A */
    public boolean m5937A(Context context, long j10) {
        if (f5037a != null) {
            return f5037a.mo58376K(context, j10);
        }
        C8932a.m56653w("CloudAlbumCaller", "isShowNotify router unregister");
        return false;
    }

    /* renamed from: B */
    public boolean m5938B() {
        if (f5037a != null) {
            return f5037a.mo58441m();
        }
        C8932a.m56653w("CloudAlbumCaller", "isSupportCloudAlbumSdk router unregister");
        return false;
    }

    /* renamed from: C */
    public boolean m5939C() {
        if (f5037a != null) {
            return f5037a.mo58373I0();
        }
        C8932a.m56653w("CloudAlbumCaller", "isSupportSmartAlbum router unregister");
        return false;
    }

    /* renamed from: D */
    public void m5940D(Context context) {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "notifyAfterSignAgreement router unregister");
        } else {
            f5037a.mo58462w0(context);
        }
    }

    /* renamed from: E */
    public void m5941E() {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "notifyReDownloadOriginal router unregister");
        } else {
            f5037a.mo58362D();
        }
    }

    /* renamed from: F */
    public void m5942F(Context context, int i10) {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "notifySaveOriginal router unregister");
        } else {
            f5037a.mo58452r0(context, i10);
        }
    }

    /* renamed from: G */
    public void m5943G(Context context, Bundle bundle, int i10) {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "notifySwitchChanged router unregister");
        } else {
            f5037a.mo58396U(context, bundle, i10);
        }
    }

    /* renamed from: H */
    public void m5944H() {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "notifySyncTipEmpty router unregister");
        } else {
            f5037a.mo58463x();
        }
    }

    /* renamed from: I */
    public void m5945I(Context context, String str) {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "pushReceiveMsg router unregister");
        } else {
            f5037a.mo58356A(context, str);
        }
    }

    /* renamed from: J */
    public void m5946J(Context context, String str) {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "pushReceiveMsgV2 router unregister");
        } else {
            f5037a.mo58366F(context, str);
        }
    }

    /* renamed from: K */
    public void m5947K(Context context, Map<String, Boolean> map) {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "putSwitchInfo router unregister");
        } else {
            f5037a.mo58365E0(context, map);
        }
    }

    /* renamed from: L */
    public void m5948L(InterfaceC14350a interfaceC14350a) {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "queryDisuseStatus router unregister");
        } else {
            f5037a.mo58426g(interfaceC14350a);
        }
    }

    /* renamed from: M */
    public void m5949M(Object obj, Handler handler) {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "register router unregister");
        } else {
            f5037a.mo58374J(obj, handler);
        }
    }

    /* renamed from: N */
    public void m5950N(InterfaceC14351b interfaceC14351b, Context context) {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "resumeCloudAlbum router unregister");
        } else {
            f5037a.mo58379L0(interfaceC14351b, context);
        }
    }

    /* renamed from: O */
    public void m5951O(boolean z10, Context context) {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "setGeneralAlbumSwitch router unregister");
        } else {
            f5037a.mo58402X(z10, context);
        }
    }

    /* renamed from: P */
    public void m5952P(boolean z10, Context context) {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "setInheritGeneralAlbumSwitch router unregister");
        } else {
            f5037a.mo58420e(z10, context);
        }
    }

    /* renamed from: Q */
    public void m5953Q(boolean z10, Context context) {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "setOpenInheritGeneralAlbumSwitch router unregister");
        } else {
            f5037a.mo58437k(z10, context);
        }
    }

    /* renamed from: R */
    public void m5954R(Context context, int i10, long j10) {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "updateShelveStatus router unregister");
        } else {
            f5037a.mo58439l(context, i10, j10);
        }
    }

    /* renamed from: a */
    public void m5955a() {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "addSyncAccountModuleClient router unregister");
        } else {
            f5037a.mo58418d0();
        }
    }

    /* renamed from: b */
    public void m5956b(Context context, InterfaceC14351b interfaceC14351b) {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "checkExistMediaFile router unregister");
        } else {
            f5037a.mo58428g1(context, interfaceC14351b);
        }
    }

    /* renamed from: c */
    public void m5957c(Context context) {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "checkServiceStatus router unregister");
        } else {
            f5037a.mo58450q0(context);
        }
    }

    /* renamed from: d */
    public void m5958d() {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "cleanUserDataCache router unregister");
        } else {
            f5037a.mo58391R0();
        }
    }

    /* renamed from: e */
    public void m5959e(Context context, InterfaceC14351b interfaceC14351b) {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "clearRecycleAlbum router unregister");
        } else {
            f5037a.mo58400W(context, interfaceC14351b);
        }
    }

    /* renamed from: f */
    public void m5960f(Context context) {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "clearTaskAndUpgrade router unregister");
        } else {
            f5037a.mo58421e0(context);
        }
    }

    /* renamed from: g */
    public void m5961g() {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "closeAfterCloudClean router unregister");
        } else {
            f5037a.mo58461w();
        }
    }

    /* renamed from: h */
    public ArrayList<AppInfo> m5962h(Context context) {
        if (f5037a != null) {
            return f5037a.mo58381M0(context);
        }
        C8932a.m56653w("CloudAlbumCaller", "generalCustomAlbums router unregister");
        return new ArrayList<>();
    }

    /* renamed from: i */
    public Class m5963i() {
        if (f5037a != null) {
            return f5037a.mo58447p();
        }
        C8932a.m56653w("CloudAlbumCaller", "getCloudAlbumClass router unregister");
        return null;
    }

    /* renamed from: j */
    public int m5964j(Context context) {
        if (f5037a != null) {
            return f5037a.mo58363D0(context);
        }
        C8932a.m56653w("CloudAlbumCaller", "getInheritGeneralAlbumRaw router unregister");
        return -1;
    }

    /* renamed from: l */
    public int m5965l(Context context) {
        if (f5037a != null) {
            return f5037a.mo58431h1(context);
        }
        C8932a.m56653w("CloudAlbumCaller", "getNotUploaded router unregister");
        return 0;
    }

    /* renamed from: m */
    public long m5966m(String str) {
        if (f5037a != null) {
            return f5037a.mo58445o(str);
        }
        C8932a.m56653w("CloudAlbumCaller", "getPathAvailSize router unregister");
        return 0L;
    }

    /* renamed from: n */
    public long m5967n(Context context) {
        if (f5037a != null) {
            return f5037a.mo58408a(context);
        }
        C8932a.m56653w("CloudAlbumCaller", "getReleaseSpace router unregister");
        return 0L;
    }

    /* renamed from: o */
    public void m5968o(Handler handler) {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "getShareAlbumInfo router unregister");
        } else {
            f5037a.mo58446o0(handler);
        }
    }

    /* renamed from: p */
    public int m5969p(Context context) {
        if (f5037a != null) {
            return f5037a.mo58394T(context);
        }
        C8932a.m56653w("CloudAlbumCaller", "getShelveStatus router unregister");
        return -2;
    }

    /* renamed from: q */
    public SwitchInfo m5970q(Context context) {
        if (f5037a != null) {
            return f5037a.mo58451r(context);
        }
        C8932a.m56653w("CloudAlbumCaller", "getSwitchInfo router unregister");
        return new SwitchInfo();
    }

    /* renamed from: r */
    public Bundle m5971r(Context context) {
        if (f5037a != null) {
            return f5037a.mo58430h0(context);
        }
        C8932a.m56653w("CloudAlbumCaller", "getUploadStatus router unregister");
        return new Bundle();
    }

    /* renamed from: s */
    public void m5972s(Context context, InterfaceC14351b interfaceC14351b, int i10) {
        if (f5037a == null) {
            C8932a.m56653w("CloudAlbumCaller", "getUsedSize router unregister");
        } else {
            f5037a.mo58458u0(context, interfaceC14351b, i10);
        }
    }

    /* renamed from: t */
    public boolean m5973t() {
        if (f5037a != null) {
            return f5037a.mo58422e1();
        }
        C8932a.m56653w("CloudAlbumCaller", "inRetentionPeriod router unregister");
        return true;
    }

    /* renamed from: u */
    public boolean m5974u() {
        if (f5037a != null) {
            return f5037a.isGallerySupportSetting();
        }
        C8932a.m56653w("CloudAlbumCaller", "isGallerySupportSetting router unregister");
        return false;
    }

    /* renamed from: v */
    public boolean m5975v(Context context) {
        if (f5037a != null) {
            return f5037a.mo58417d(context);
        }
        C8932a.m56653w("CloudAlbumCaller", "isGeneralAlbumOn router unregister");
        return false;
    }

    /* renamed from: w */
    public boolean m5976w(Context context) {
        if (f5037a != null) {
            return f5037a.mo58384O(context);
        }
        C8932a.m56653w("CloudAlbumCaller", "isInheritGeneralAlbumOn router unregister");
        return false;
    }

    /* renamed from: x */
    public boolean m5977x() {
        if (f5037a != null) {
            return f5037a.mo58442m0();
        }
        C8932a.m56653w("CloudAlbumCaller", "isMobileDataEnable router unregister");
        return false;
    }

    /* renamed from: y */
    public boolean m5978y() {
        if (f5037a != null) {
            return f5037a.mo58385O0();
        }
        C8932a.m56653w("CloudAlbumCaller", "isMobileSwitchOn router unregister");
        return false;
    }

    /* renamed from: z */
    public boolean m5979z(Context context) {
        if (f5037a != null) {
            return f5037a.mo58358B(context);
        }
        C8932a.m56653w("CloudAlbumCaller", "isOpenInheritGeneralAlbumOn router unregister");
        return false;
    }
}
