package p020ap;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.huawei.hicloud.notification.p106db.bean.RecommendCardReport;
import com.huawei.hicloud.router.data.CloudSpaceUsageItemColor;
import com.huawei.hicloud.router.data.UserBackupInfo;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p037bp.C1270a;
import p207cp.C8932a;
import p232dp.InterfaceC9283b;

/* renamed from: ap.b */
/* loaded from: classes.dex */
public class C1007b {

    /* renamed from: a */
    public static volatile InterfaceC9283b f5039a;

    /* renamed from: b */
    public static final C1007b f5040b = new C1007b();

    /* renamed from: s */
    public static C1007b m5980s() {
        if (f5039a == null) {
            synchronized (C1007b.class) {
                try {
                    if (f5039a == null) {
                        f5039a = (InterfaceC9283b) C1270a.m7534b().m7535a(InterfaceC9283b.class);
                    }
                } finally {
                }
            }
        }
        return f5040b;
    }

    /* renamed from: A */
    public String m5981A() {
        if (f5039a != null) {
            return f5039a.mo58508g0();
        }
        C8932a.m56653w("CloudBackupCaller", "getUserGradeCode router unregister");
        return "";
    }

    /* renamed from: B */
    public void m5982B(String str, boolean z10) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "gradeRefreshCheckBackupFrequency router unregister");
        } else {
            f5039a.mo58498b0(str, z10);
        }
    }

    /* renamed from: C */
    public boolean m5983C() {
        if (f5039a != null) {
            return f5039a.mo58493Y();
        }
        C8932a.m56653w("CloudBackupCaller", "hasManualBackupOrRestore router unregister");
        return false;
    }

    /* renamed from: D */
    public boolean m5984D() {
        if (f5039a != null) {
            return f5039a.mo58484P();
        }
        C8932a.m56653w("CloudBackupCaller", "inCloudRestore router unregister");
        return false;
    }

    /* renamed from: E */
    public boolean m5985E(String str) {
        if (f5039a != null) {
            return f5039a.mo58478J(str);
        }
        C8932a.m56653w("CloudBackupCaller", "inCloudRestoreModule router unregister");
        return false;
    }

    /* renamed from: F */
    public void m5986F() {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "initViewMapping router unregister");
        } else {
            f5039a.mo58477I();
        }
    }

    /* renamed from: G */
    public void m5987G(String str) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "onPushReceived router unregister");
        } else {
            f5039a.mo58507g(str);
        }
    }

    /* renamed from: H */
    public void m5988H() {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "openCloudBackup router unregister");
        } else {
            f5039a.mo58474F();
        }
    }

    /* renamed from: I */
    public void m5989I() {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "queryRefreshConfig router unregister");
        } else {
            f5039a.mo58479K();
        }
    }

    /* renamed from: J */
    public void m5990J() {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "queryStorageData router unregister");
        } else {
            f5039a.mo58473E();
        }
    }

    /* renamed from: K */
    public Object m5991K(boolean z10, boolean z11, boolean z12) throws C9721b {
        if (f5039a != null) {
            return f5039a.mo58476H(z10, z11, z12);
        }
        C8932a.m56653w("CloudBackupCaller", "queryUserBackupInfo router unregister");
        return null;
    }

    /* renamed from: L */
    public void m5992L(Context context) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "redirectManageCloudSpace router unregister");
        } else {
            f5039a.mo58472D(context);
        }
    }

    /* renamed from: M */
    public void m5993M(String str) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "queryRefreshConfig router unregister");
        } else {
            f5039a.mo58495a(str);
        }
    }

    /* renamed from: N */
    public void m5994N(Handler.Callback callback) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "registerBackupCb router unregister");
            return;
        }
        C8932a.m56652i("CloudBackupCaller", "registerBackupCb callback： " + callback);
        f5039a.mo58512i0(callback);
    }

    /* renamed from: O */
    public void m5995O(Context context, ArrayList<String> arrayList) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "reportBackupModuleSwitch router unregister");
        } else {
            f5039a.mo58485Q(context, arrayList);
        }
    }

    /* renamed from: P */
    public void m5996P(RecommendCardReport recommendCardReport, String str) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "reportRecommendCardEvent router unregister");
        } else {
            f5039a.mo58519m(recommendCardReport, str);
        }
    }

    /* renamed from: Q */
    public void m5997Q(Context context) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "reportSpaceUse router unregister");
        } else {
            f5039a.mo58524o0(context);
        }
    }

    /* renamed from: R */
    public void m5998R(Context context) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "reset router unregister");
        } else {
            f5039a.mo58489U(context);
        }
    }

    /* renamed from: S */
    public void m5999S(String str, String str2) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "sendHonorGuideNotification router unregister");
        } else {
            f5039a.mo58514j0(str, str2);
        }
    }

    /* renamed from: T */
    public void m6000T(Message message) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "sendMessage router unregister");
        } else {
            f5039a.mo58486R(message);
        }
    }

    /* renamed from: U */
    public void m6001U(Context context) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "sendPowerNotify router unregister");
        } else {
            f5039a.mo58511i(context);
        }
    }

    /* renamed from: V */
    public void m6002V(String str) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "sendPresentTask router unregister");
        } else {
            f5039a.mo58518l0(str);
        }
    }

    /* renamed from: W */
    public void m6003W(Context context) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "tryReportSpaceUse router unregister");
        } else {
            f5039a.mo58497b(context);
        }
    }

    /* renamed from: X */
    public void m6004X(Context context) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "unBindDecisionService router unregister");
        } else {
            f5039a.mo58491W(context);
        }
    }

    /* renamed from: Y */
    public void m6005Y(Handler.Callback callback) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "unregisterBackupCb router unregister");
            return;
        }
        C8932a.m56652i("CloudBackupCaller", "unregisterBackupCb callback： " + callback);
        f5039a.mo58528s(callback);
    }

    /* renamed from: Z */
    public void m6006Z(Handler.Callback callback) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "unregisterCloudBackupService router unregister");
        } else {
            f5039a.mo58469A(callback);
        }
    }

    /* renamed from: a */
    public void m6007a(Context context, String str) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "bindDecisionService router unregister");
        } else {
            f5039a.mo58505f(context, str);
        }
    }

    /* renamed from: a0 */
    public void m6008a0(UserBackupInfo.UserDeviceInfo userDeviceInfo) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "updateDeviceRecord router unregister");
        } else {
            f5039a.mo58503e(userDeviceInfo);
        }
    }

    /* renamed from: b */
    public void m6009b() {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "sendHonorGuideNotification router unregister");
        } else {
            f5039a.mo58496a0();
        }
    }

    /* renamed from: b0 */
    public void m6010b0(List<UserBackupInfo.UserDeviceInfo> list) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "updateDeviceRecord router unregister");
        } else {
            f5039a.mo58502d0(list);
        }
    }

    /* renamed from: c */
    public void m6011c(Context context) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "cancelSiteNotification router unregister");
        } else {
            f5039a.mo58529t(context);
        }
    }

    /* renamed from: c0 */
    public void m6012c0() {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "updateTime router unregister");
        } else {
            f5039a.mo58504e0();
        }
    }

    /* renamed from: d */
    public void m6013d() {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "cancelSpaceNotEnoughNotify router unregister");
        } else {
            f5039a.mo58523o();
        }
    }

    /* renamed from: e */
    public void m6014e(String str) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "queryRefreshConfig router unregister");
        } else {
            f5039a.mo58521n(str);
        }
    }

    /* renamed from: f */
    public boolean m6015f(Context context, long j10) throws C9721b {
        if (f5039a != null) {
            return f5039a.mo58492X(context, j10);
        }
        C8932a.m56653w("CloudBackupCaller", "checkUserSpace router unregister");
        return false;
    }

    /* renamed from: g */
    public List<CloudSpaceUsageItemColor> m6016g() {
        if (f5039a != null) {
            return f5039a.mo58527r();
        }
        C8932a.m56653w("CloudBackupCaller", "createUsageItems router unregister");
        return new ArrayList();
    }

    /* renamed from: h */
    public boolean m6017h() {
        if (f5039a != null) {
            return f5039a.mo58470B();
        }
        C8932a.m56653w("CloudBackupCaller", "getAlbumBackUpSwitch router unregister");
        return false;
    }

    /* renamed from: i */
    public String m6018i() {
        if (f5039a != null) {
            return f5039a.mo58499c();
        }
        C8932a.m56653w("CloudBackupCaller", "getBakAppList router unregister");
        return null;
    }

    /* renamed from: j */
    public boolean m6019j() {
        if (f5039a != null) {
            return f5039a.mo58509h();
        }
        C8932a.m56653w("CloudBackupCaller", "getBackupAppsSwitch router unregister");
        return false;
    }

    /* renamed from: k */
    public void m6020k(int i10) {
        if (f5039a == null) {
            C8932a.m56653w("CloudBackupCaller", "getBackupLinkAddress router unregister");
        } else {
            f5039a.mo58516k0(i10);
        }
    }

    /* renamed from: l */
    public boolean m6021l() {
        if (f5039a != null) {
            return f5039a.mo58471C();
        }
        C8932a.m56653w("CloudBackupCaller", "getBackupWechatSwitch router unregister");
        return false;
    }

    /* renamed from: m */
    public String m6022m() {
        if (f5039a != null) {
            return f5039a.mo58526q();
        }
        C8932a.m56653w("CloudBackupCaller", "getBakAppList router unregister");
        return null;
    }

    /* renamed from: n */
    public long m6023n() {
        if (f5039a != null) {
            return f5039a.mo58535z();
        }
        C8932a.m56653w("CloudBackupCaller", "getBakSize router unregister");
        return 0L;
    }

    /* renamed from: o */
    public String m6024o(String str) {
        if (f5039a != null) {
            return f5039a.mo58533x(str);
        }
        C8932a.m56653w("CloudBackupCaller", "getCloudSpaceUsageLanguage router unregister");
        return null;
    }

    /* renamed from: p */
    public UserBackupInfo m6025p(boolean z10, int i10) throws C9721b {
        if (f5039a != null) {
            return f5039a.mo58506f0(z10, i10);
        }
        C8932a.m56653w("CloudBackupCaller", "getDeviceList router unregister");
        return new UserBackupInfo();
    }

    /* renamed from: q */
    public UserBackupInfo m6026q(boolean z10, boolean z11, boolean z12, int i10) throws C9721b {
        if (f5039a != null) {
            return f5039a.mo58520m0(z10, z11, true, z12, i10);
        }
        C8932a.m56653w("CloudBackupCaller", "getDeviceList router unregister");
        return new UserBackupInfo();
    }

    /* renamed from: r */
    public Long m6027r() {
        if (f5039a != null) {
            return f5039a.mo58501d();
        }
        C8932a.m56653w("CloudBackupCaller", "getInitOpenTime router unregister");
        return Long.valueOf(System.currentTimeMillis());
    }

    /* renamed from: t */
    public String m6028t(String str) {
        if (f5039a != null) {
            return String.valueOf(f5039a.mo58480L(str));
        }
        C8932a.m56653w("CloudBackupCaller", "getSplitNotifyShowStatus router unregister");
        return null;
    }

    /* renamed from: u */
    public int m6029u(Context context) {
        if (f5039a != null) {
            return f5039a.mo58482N(context);
        }
        C8932a.m56653w("CloudBackupCaller", "getNotifyLeftDays router unregister");
        return 0;
    }

    /* renamed from: v */
    public int m6030v() {
        if (f5039a != null) {
            return f5039a.mo58531v();
        }
        C8932a.m56653w("CloudBackupCaller", "getPauseBattery router unregister");
        return 10;
    }

    /* renamed from: w */
    public String m6031w(String str) {
        if (f5039a != null) {
            return f5039a.mo58494Z(str);
        }
        C8932a.m56653w("CloudBackupCaller", "getSpaceDisplayDefaultName router unregister");
        return "";
    }

    /* renamed from: x */
    public String m6032x(String str) {
        if (f5039a != null) {
            return f5039a.mo58487S(str);
        }
        C8932a.m56653w("CloudBackupCaller", "getSplitNotifyShowStatus router unregister");
        return null;
    }

    /* renamed from: y */
    public String m6033y(Throwable th2) {
        if (f5039a != null) {
            return f5039a.mo58475G(th2);
        }
        C8932a.m56653w("CloudBackupCaller", "getStackTrace router is null");
        return "";
    }

    /* renamed from: z */
    public int m6034z() {
        if (f5039a != null) {
            return f5039a.mo58510h0();
        }
        C8932a.m56653w("CloudBackupCaller", "getUnClearMonths router unregister");
        return 0;
    }
}
