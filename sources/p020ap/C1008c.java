package p020ap;

import android.content.Context;
import android.os.Handler;
import android.os.Messenger;
import android.text.TextUtils;
import com.huawei.hicloud.base.bean.ExiterSyncData;
import gp.C10028c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import p037bp.C1270a;
import p207cp.C8932a;
import p232dp.InterfaceC9284c;
import p709vj.C13452e;
import p815ym.AbstractC14026a;

/* renamed from: ap.c */
/* loaded from: classes.dex */
public class C1008c {

    /* renamed from: a */
    public static volatile InterfaceC9284c f5041a;

    /* renamed from: b */
    public static final C1008c f5042b = new C1008c();

    /* renamed from: v */
    public static C1008c m6035v() {
        if (f5041a == null) {
            synchronized (C1008c.class) {
                try {
                    if (f5041a == null) {
                        f5041a = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
                    }
                } finally {
                }
            }
        }
        return f5042b;
    }

    /* renamed from: A */
    public List<String> m6036A(Context context) {
        if (f5041a != null) {
            return f5041a.mo17147r0(context);
        }
        C8932a.m56653w("CloudSyncCaller", "getSyncDataBaseListFromSp router unregister");
        return new ArrayList();
    }

    /* renamed from: B */
    public List<String> m6037B(Context context) {
        if (f5041a != null) {
            return f5041a.mo17126h(context);
        }
        C8932a.m56653w("CloudSyncCaller", "getSyncFullDataListFromSp router unregister");
        return new ArrayList();
    }

    /* renamed from: C */
    public String m6038C(String str) {
        if (f5041a != null) {
            return f5041a.mo17080A0(str);
        }
        C8932a.m56653w("CloudSyncCaller", "getSyncTypeDataBaseId router unregister");
        return "";
    }

    /* renamed from: D */
    public int m6039D(Context context, Messenger messenger) {
        if (f5041a != null) {
            return f5041a.mo17093H(context, messenger);
        }
        C8932a.m56653w("CloudSyncCaller", "getAllOpenSyncTypes router unregister");
        return 0;
    }

    /* renamed from: E */
    public boolean m6040E(String str) {
        if (f5041a != null) {
            return f5041a.mo17125g0(str);
        }
        C8932a.m56653w("CloudSyncCaller", "doSyncContactRemote router unregister");
        return false;
    }

    /* renamed from: F */
    public void m6041F(Context context) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "deleteSyncData router unregister");
        } else {
            f5041a.mo17108W(context);
        }
    }

    /* renamed from: G */
    public void m6042G(Context context) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "startNotepadSync router unregister");
        } else {
            f5041a.mo17120e(context);
        }
    }

    /* renamed from: H */
    public final boolean m6043H() {
        return C13452e.m80781L().m80791C0();
    }

    /* renamed from: I */
    public boolean m6044I(Context context) {
        if (f5041a != null) {
            return f5041a.mo17105T(context);
        }
        C8932a.m56653w("CloudSyncCaller", "isCloudSyncSwitchOpen router unregister");
        return false;
    }

    /* renamed from: J */
    public boolean m6045J(List<String> list, String str) {
        if (!m6043H()) {
            C8932a.m56653w("CloudSyncCaller", "isInCloudSyncBasicDataList, not change mode!");
            return true;
        }
        if (AbstractC14026a.m84159a(list)) {
            C8932a.m56653w("CloudSyncCaller", "isInCloudSyncBasicDataList, baseList is null");
            return true;
        }
        if (!list.contains(str)) {
            return false;
        }
        C8932a.m56651d("CloudSyncCaller", "isInCloudSyncBasicDataList, dataBaseCid is: " + str);
        return true;
    }

    /* renamed from: K */
    public void m6046K(Context context, String str, int i10) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "getAllOpenSyncTypes router unregister");
        } else {
            f5041a.mo17087E(context, str, i10);
        }
    }

    /* renamed from: L */
    public void m6047L(Context context, String str, boolean z10) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "getAllOpenSyncTypes router unregister");
        } else {
            f5041a.mo17112a(context, str, z10);
        }
    }

    /* renamed from: M */
    public void m6048M(Context context, Handler handler, String str, String str2, int i10) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "startService router unregister");
        } else {
            f5041a.mo17135l0(context, handler, str, str2, i10);
        }
    }

    /* renamed from: N */
    public void m6049N(Context context, Messenger messenger) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "getAllOpenSyncTypes router unregister");
        } else {
            f5041a.mo17079A(context, messenger);
        }
    }

    /* renamed from: O */
    public void m6050O(Context context, String str, boolean z10) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "queryRefreshConfig router unregister");
        } else {
            f5041a.mo17139n0(context, str, z10);
        }
    }

    /* renamed from: P */
    public void m6051P(Context context, Handler handler, boolean z10) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "refreshSyncDataListFromServer router unregister");
        } else {
            f5041a.mo17081B(context, handler, z10);
        }
    }

    /* renamed from: Q */
    public boolean m6052Q(Context context, CountDownLatch countDownLatch) {
        if (f5041a != null) {
            return f5041a.mo17144q(context, countDownLatch);
        }
        C8932a.m56653w("CloudSyncCaller", "refreshSyncDataListFromServerAwait router unregister");
        return false;
    }

    /* renamed from: R */
    public void m6053R(Context context, boolean z10) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "registerGalleryAtlasSwitch router unregister");
        } else {
            f5041a.mo17109X(context, z10);
        }
    }

    /* renamed from: S */
    public void m6054S(String str) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "removeFlowControlRetryMap router unregister");
        } else {
            f5041a.mo17156w(str);
        }
    }

    /* renamed from: T */
    public void m6055T(Context context, String str, int i10, String str2, String str3, String str4, String str5, LinkedHashMap<String, String> linkedHashMap) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "isV2Version router unregister");
        } else {
            f5041a.mo17134l(context, str, i10, str2, str3, str4, str5, linkedHashMap);
        }
    }

    /* renamed from: U */
    public void m6056U(Context context, String str) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "resetLostRefund router unregister");
        } else {
            f5041a.mo17104S(context, str);
        }
    }

    /* renamed from: V */
    public boolean m6057V(String str) {
        if (f5041a != null) {
            return f5041a.mo17107V(str);
        }
        C8932a.m56653w("CloudSyncCaller", "resetSyncData router unregister");
        return false;
    }

    /* renamed from: W */
    public void m6058W(Context context, String str) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "queryRefreshConfig router unregister");
        } else {
            f5041a.mo17090F0(context, str);
        }
    }

    /* renamed from: X */
    public void m6059X(Context context, boolean z10) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "getAllOpenSyncTypes router unregister");
        } else {
            f5041a.mo17101P(context, z10);
        }
    }

    /* renamed from: Y */
    public void m6060Y(Context context, String str) {
        C8932a.m56652i("CloudSyncCaller", "saveDownGradeNNFullSwitch from " + str);
        List<String> listM6037B = m6035v().m6037B(context);
        if (listM6037B.isEmpty()) {
            C8932a.m56653w("CloudSyncCaller", "closeFullSync allToOffService is empty");
            return;
        }
        C10028c c10028cM62183d0 = C10028c.m62183d0(context);
        for (String str2 : listM6037B) {
            if (!TextUtils.equals(str2, "atlas")) {
                int iM62286W = C10028c.m62182c0().m62286W(str2);
                if (2 != iM62286W) {
                    C8932a.m56652i("CloudSyncCaller", "saveDownGradeNNFullSwitch setFullSwitchStatus is exist : " + str2 + ",fullSwitchStatus:" + iM62286W);
                } else {
                    boolean zM62388s = C10028c.m62182c0().m62388s(str2);
                    c10028cM62183d0.m62245M2(str2, Integer.valueOf(zM62388s ? 1 : 0));
                    C8932a.m56652i("CloudSyncCaller", "saveDownGradeNNFullSwitch setFullSwitchStatus appName: " + str2 + ",switchStatus:" + zM62388s);
                }
            }
        }
    }

    /* renamed from: Z */
    public void m6061Z(String str) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "sendDataToDs router unregister");
        } else {
            f5041a.mo17091G(str);
        }
    }

    /* renamed from: a */
    public void m6062a(boolean z10, int i10) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "doSyncContactRemote router unregister");
        } else {
            f5041a.mo17131j0(z10, i10);
        }
    }

    /* renamed from: a0 */
    public void m6063a0(Context context, String str, int i10) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "setSwitch4H5Set router unregister");
        } else {
            f5041a.mo17089F(context, str, i10);
        }
    }

    /* renamed from: b */
    public void m6064b() {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "applyCloudSyncRouter router unregister");
        } else {
            f5041a.mo17151t0();
        }
    }

    /* renamed from: b0 */
    public void m6065b0(Context context, int i10, String str) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "startBrowserSync router unregister");
        } else {
            f5041a.mo17113a0(context, i10, str);
        }
    }

    /* renamed from: c */
    public void m6066c(Context context, String str) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "getAllOpenSyncTypes router unregister");
        } else {
            f5041a.mo17130j(context, str);
        }
    }

    /* renamed from: c0 */
    public void m6067c0(Context context, int i10, String str) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "startCalendarSync router unregister");
        } else {
            f5041a.mo17154v(context, i10, str);
        }
    }

    /* renamed from: d */
    public int m6068d(Context context, String str, String str2) {
        if (f5041a != null) {
            return f5041a.mo17103R(context, str, str2);
        }
        C8932a.m56653w("CloudSyncCaller", "queryRefreshConfig router unregister");
        return 0;
    }

    /* renamed from: d0 */
    public void m6069d0(int i10) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "startContactSync router unregister");
        } else {
            f5041a.mo17088E0(i10);
        }
    }

    /* renamed from: e */
    public void m6070e(Context context) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "getAllOpenSyncTypes router unregister");
        } else {
            f5041a.mo17128i(context);
        }
    }

    /* renamed from: e0 */
    public void m6071e0(Context context, int i10, String str) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "startContactSyncWithAIDL router unregister");
        } else {
            f5041a.mo17159x0(context, i10, str);
        }
    }

    /* renamed from: f */
    public void m6072f(Context context, String str) {
        C8932a.m56652i("CloudSyncCaller", "closeFullSync from " + str);
        List<String> listM6037B = m6035v().m6037B(context);
        if (listM6037B.isEmpty()) {
            C8932a.m56653w("CloudSyncCaller", "closeFullSync allToOffService is empty");
            return;
        }
        C10028c c10028cM62183d0 = C10028c.m62183d0(context);
        for (String str2 : listM6037B) {
            if (!TextUtils.equals(str2, "atlas")) {
                c10028cM62183d0.m62245M2(str2, 2);
                C8932a.m56652i("CloudSyncCaller", "saveDownGradeNNFullSwitch setFullSwitchStatus appName: " + str2 + ",switchStatus:2");
            }
        }
    }

    /* renamed from: f0 */
    public void m6073f0(Context context, String str) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "getAllOpenSyncTypes router unregister");
        } else {
            f5041a.mo17150t(context, str);
        }
    }

    /* renamed from: g */
    public void m6074g(Context context, String str, String str2) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "getAllOpenSyncTypes router unregister");
        } else {
            f5041a.mo17106U(context, str, str2);
        }
    }

    /* renamed from: g0 */
    public void m6075g0(Context context, String str, int i10, String str2) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "startNotepadSync router unregister");
        } else {
            f5041a.mo17099N(context, str, i10, str2);
        }
    }

    /* renamed from: h */
    public void m6076h(Context context, String str) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "clearLastSyncInfo router unregister");
        } else {
            f5041a.mo17083C(context, str);
        }
    }

    /* renamed from: h0 */
    public void m6077h0(Context context, int i10, String str) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "startNotepadSync router unregister");
        } else {
            f5041a.mo17145q0(context, i10, str);
        }
    }

    /* renamed from: i */
    public void m6078i(Context context, String str) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "getAllOpenSyncTypes router unregister");
        } else {
            f5041a.mo17146r(context, str);
        }
    }

    /* renamed from: i0 */
    public void m6079i0(Context context, String str) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "getAllOpenSyncTypes router unregister");
        } else {
            f5041a.mo17163z0(context, str);
        }
    }

    /* renamed from: j */
    public void m6080j(Context context, String str, String str2, int i10) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "getAllOpenSyncTypes router unregister");
        } else {
            f5041a.mo17114b(context, str, str2, i10);
        }
    }

    /* renamed from: j0 */
    public void m6081j0(Context context) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "startService router unregister");
        } else {
            f5041a.mo17155v0(context);
        }
    }

    /* renamed from: k */
    public void m6082k(Context context, String str) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "clearSyncRetryAlarm router unregister");
        } else {
            f5041a.mo17123f0(context, str);
        }
    }

    /* renamed from: k0 */
    public void m6083k0(Context context, String str) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "startService router unregister");
        } else {
            f5041a.mo17098M(context, str);
        }
    }

    /* renamed from: l */
    public void m6084l(Context context, String str) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "getAllOpenSyncTypes router unregister");
        } else {
            f5041a.mo17133k0(context, str);
        }
    }

    /* renamed from: l0 */
    public void m6085l0(Context context) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "stopService router unregister");
        } else {
            f5041a.mo17153u0(context);
        }
    }

    /* renamed from: m */
    public void m6086m(Context context, String str) {
        C8932a.m56652i("CloudSyncCaller", "closeFullSync from " + str);
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "closeFullSync router unregister");
            return;
        }
        List<String> listM6037B = m6035v().m6037B(context);
        if (listM6037B.isEmpty()) {
            C8932a.m56653w("CloudSyncCaller", "closeFullSync allToOffService is empty");
            return;
        }
        C10028c c10028cM62183d0 = C10028c.m62183d0(context);
        for (String str2 : listM6037B) {
            if (str2 != "atlas" && c10028cM62183d0.m62388s(str2)) {
                C8932a.m56652i("CloudSyncCaller", "closeFullSync from " + str + " syncType " + str2 + " result:" + f5041a.mo17115b0(str2, 0, str));
            }
        }
    }

    /* renamed from: m0 */
    public void m6087m0(Context context, int i10, String str) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "stopService router unregister");
        } else {
            f5041a.mo17136m(context, i10, str);
        }
    }

    /* renamed from: n */
    public void m6088n(String str) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "startBrowserSync router unregister");
        } else {
            f5041a.mo17116c(str);
        }
    }

    /* renamed from: n0 */
    public void m6089n0(Context context) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "startWlanSync router unregister");
        } else {
            f5041a.mo17110Y(context);
        }
    }

    /* renamed from: o */
    public void m6090o(String str) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "queryRefreshConfig router unregister");
        } else {
            f5041a.mo17097L(str);
        }
    }

    /* renamed from: o0 */
    public void m6091o0(Context context, String str, int i10, int i11, String str2) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "stopBrowserSync router unregister");
        } else {
            f5041a.mo17158x(context, str, i10, i11, str2);
        }
    }

    /* renamed from: p */
    public void m6092p(Context context, Handler handler, List<ExiterSyncData> list, String str) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "deleteSyncData router unregister");
        } else {
            f5041a.mo17124g(context, handler, list, str);
        }
    }

    /* renamed from: p0 */
    public void m6093p0(Context context, String str, int i10, int i11, String str2) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "stopCalendarSync router unregister");
        } else {
            f5041a.mo17092G0(context, str, i10, i11, str2);
        }
    }

    /* renamed from: q */
    public void m6094q() {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "getAllOpenSyncTypes router unregister");
        } else {
            f5041a.doBackupPhoneManager();
        }
    }

    /* renamed from: q0 */
    public void m6095q0(Context context, String str, int i10, int i11, String str2) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "stopContactSync router unregister");
        } else {
            f5041a.mo17127h0(context, str, i10, i11, str2);
        }
    }

    /* renamed from: r */
    public void m6096r(int i10, int i11) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "doSyncContactRemote router unregister");
        } else {
            f5041a.mo17082B0(i10, i11);
        }
    }

    /* renamed from: r0 */
    public void m6097r0(Context context, String str, int i10, int i11, String str2) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "stopContactSyncWithAIDL router unregister");
        } else {
            f5041a.mo17100O(context, str, i10, i11, str2);
        }
    }

    /* renamed from: s */
    public void m6098s(int i10, int i11) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "doSyncWlanRemote router unregister");
        } else {
            f5041a.mo17129i0(i10, i11);
        }
    }

    /* renamed from: s0 */
    public void m6099s0(Context context, String str, int i10, int i11, String str2) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "stopFrameworkSync router unregister");
        } else {
            f5041a.mo17141o0(context, str, i10, i11, str2);
        }
    }

    /* renamed from: t */
    public List<String> m6100t(Context context) {
        if (f5041a != null) {
            return f5041a.mo17096K(context);
        }
        C8932a.m56653w("CloudSyncCaller", "getAllOpenSyncTypes router unregister");
        return new ArrayList();
    }

    /* renamed from: t0 */
    public void m6101t0(Context context, String str, int i10, int i11, String str2) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "stopNotepadSync router unregister");
        } else {
            f5041a.mo17157w0(context, str, i10, i11, str2);
        }
    }

    /* renamed from: u */
    public int m6102u(Context context, Messenger messenger) {
        if (f5041a != null) {
            return f5041a.mo17138n(context, messenger);
        }
        C8932a.m56653w("CloudSyncCaller", "getAllOpenSyncTypes router unregister");
        return -1;
    }

    /* renamed from: u0 */
    public void m6103u0(Context context, String str) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "stopService router unregister");
        } else {
            f5041a.mo17111Z(context, str);
        }
    }

    /* renamed from: v0 */
    public void m6104v0(Context context, String str, int i10, int i11, String str2) {
        if (f5041a == null) {
            C8932a.m56653w("CloudSyncCaller", "stopWlanSync router unregister");
        } else {
            f5041a.mo17094I(context, str, i10, i11, str2);
        }
    }

    /* renamed from: w */
    public int m6105w(Context context, Messenger messenger, String str) {
        if (f5041a != null) {
            return f5041a.mo17162z(context, messenger, str);
        }
        C8932a.m56653w("CloudSyncCaller", "getAllOpenSyncTypes router unregister");
        return -1;
    }

    /* renamed from: x */
    public int m6106x() {
        if (f5041a != null) {
            return f5041a.mo17117c0();
        }
        C8932a.m56653w("CloudSyncCaller", "getQuotaNormalContactNum router unregister");
        return 0;
    }

    /* renamed from: y */
    public int m6107y(Context context, Messenger messenger) {
        if (f5041a != null) {
            return f5041a.mo17085D(context, messenger);
        }
        C8932a.m56653w("CloudSyncCaller", "getAllOpenSyncTypes router unregister");
        return 0;
    }

    /* renamed from: z */
    public int m6108z(Context context, String str) {
        if (f5041a != null) {
            return f5041a.mo17143p0(context, str);
        }
        C8932a.m56653w("CloudSyncCaller", "getSwitch4H5Set router unregister");
        return -1;
    }
}
