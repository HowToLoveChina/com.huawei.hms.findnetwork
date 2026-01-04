package p520of;

import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import bf.C1175a;
import com.huawei.android.remotecontrol.http.C4344b;
import com.huawei.android.remotecontrol.http.C4347e;
import com.huawei.android.remotecontrol.offlinelocate.C4375j;
import com.huawei.android.remotecontrol.p093ui.activation.ActivationNormalActivity;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.android.remotecontrol.util.account.bean.AccountInfo;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.userk.bean.UserKeyBaseReq;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import eg.AbstractC9478g;
import eg.C9475d;
import eg.C9476e;
import fk.C9721b;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import mk.C11477c;
import org.json.JSONException;
import org.json.JSONObject;
import p012ab.C0087b;
import p013ah.AbstractC0200e;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0226l0;
import p015ak.C0241z;
import p227dg.C9120m0;
import p237du.C9310c;
import p283fa.C9679b;
import p521og.C11870c;
import p521og.C11873f;
import p521og.C11875h;
import p521og.C11877j;
import p521og.C11880m;
import p521og.C11881n;
import p575qe.C12347f;
import p576qf.InterfaceC12348a;
import p577qg.C12354d;
import p611rf.C12496d;
import p611rf.C12497e;
import p611rf.C12498f;
import p611rf.C12499g;
import p611rf.C12503k;
import p611rf.C12504l;
import p611rf.C12505m;
import p616rk.C12515a;
import p655te.C13009a;
import p664u0.C13108a;
import p677ue.C13168a;
import p681uj.C13195l;
import p684un.C13222a;
import p684un.C13230i;
import p709vj.C13452e;
import p709vj.InterfaceC13449b;
import p809yg.C13981a;
import p843zg.C14300a;
import pg.AbstractC12139d;
import sg.C12796a;
import sg.C12797b;
import tm.C13040c;
import tm.C13042e;
import ug.C13171a;
import ug.C13172b;
import wf.C13604i;
import ye.C13978y;

/* renamed from: of.j */
/* loaded from: classes4.dex */
public class C11860j {

    /* renamed from: a */
    public static Context f54884a = null;

    /* renamed from: b */
    public static int f54885b = 0;

    /* renamed from: c */
    public static int f54886c = 0;

    /* renamed from: d */
    public static boolean f54887d = false;

    /* renamed from: e */
    public static boolean f54888e = false;

    /* renamed from: g */
    public static ServiceConnection f54890g;

    /* renamed from: i */
    public static Handler f54892i;

    /* renamed from: l */
    public static boolean f54895l;

    /* renamed from: f */
    public static final Messenger f54889f = new Messenger(new j(Looper.getMainLooper()));

    /* renamed from: h */
    public static boolean f54891h = false;

    /* renamed from: j */
    public static Messenger f54893j = null;

    /* renamed from: k */
    public static volatile boolean f54894k = false;

    /* renamed from: m */
    public static String f54896m = null;

    /* renamed from: of.j$a */
    public class a extends AbstractC9478g {
        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C4375j.m26420v();
            C11860j.m71087v();
            C11860j.m71054g0();
        }
    }

    /* renamed from: of.j$b */
    public class b extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ String f54897a;

        /* renamed from: b */
        public final /* synthetic */ boolean f54898b;

        public b(String str, boolean z10) {
            this.f54897a = str;
            this.f54898b = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C13981a.m83989i("PhoneFinder", "begin to get userKey");
            try {
                byte[] userKey = new C0087b(C9679b.m60452d().m60455e()).m680c(C11873f.m71178f().m71182d().get("activetrue"), 10, UserKeyBaseReq.KEY_TYPE_AES_128).getUserKey();
                if (userKey != null) {
                    AbstractC12139d.m72766e(C11860j.m71007M()).setUserKey(new String(Base64.encode(userKey, 0), StandardCharsets.UTF_8));
                } else {
                    C13981a.m83988e("PhoneFinder", "getUserKey is empty");
                }
                C11860j.m71000I0(AbstractC12139d.m72766e(C11860j.m71007M()).getDeviceID(), "phoneFinderReceivedTicket, update User Key");
                Context contextM74301m = C12347f.m74285n().m74301m();
                final String str = this.f54897a;
                final boolean z10 = this.f54898b;
                AbstractC12139d.m72772k(contextM74301m, new InterfaceC12348a() { // from class: of.k
                    @Override // p576qf.InterfaceC12348a
                    public final void onResult(boolean z11) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                        C11860j.m71071n(str, z11, z10);
                    }
                });
            } catch (Exception e10) {
                C13981a.m83988e("PhoneFinder", "getUserKey error," + e10.getMessage());
                C11860j.m71000I0(AbstractC12139d.m72766e(C11860j.m71007M()).getDeviceID(), "phoneFinderReceivedTicket exception:" + e10.getMessage());
                Context contextM74301m2 = C12347f.m74285n().m74301m();
                final String str2 = this.f54897a;
                final boolean z11 = this.f54898b;
                AbstractC12139d.m72772k(contextM74301m2, new InterfaceC12348a() { // from class: of.l
                    @Override // p576qf.InterfaceC12348a
                    public final void onResult(boolean z12) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                        C11860j.m71071n(str2, z12, z11);
                    }
                });
            }
        }
    }

    /* renamed from: of.j$c */
    public class c extends AbstractC9478g {
        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C13981a.m83989i("PhoneFinder", "begin to get pk");
            C11852b.m70957b().m70958c(C0213f.m1377a());
        }
    }

    /* renamed from: of.j$d */
    public class d extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ Context f54899a;

        /* renamed from: b */
        public final /* synthetic */ C4344b f54900b;

        public d(Context context, C4344b c4344b) {
            this.f54899a = context;
            this.f54900b = c4344b;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (!C11853c.m70968g().m70971f(this.f54899a)) {
                C11860j.m71072n0(39);
            } else {
                AbstractC12139d.m72767f(C12347f.m74285n().m74301m(), true);
                C11860j.m70989D(this.f54900b);
            }
        }
    }

    /* renamed from: of.j$e */
    public class e extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ Context f54901a;

        /* renamed from: b */
        public final /* synthetic */ boolean f54902b;

        /* renamed from: c */
        public final /* synthetic */ String f54903c;

        /* renamed from: d */
        public final /* synthetic */ C4344b f54904d;

        public e(Context context, boolean z10, String str, C4344b c4344b) {
            this.f54901a = context;
            this.f54902b = z10;
            this.f54903c = str;
            this.f54904d = c4344b;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (!C11853c.m70968g().m70971f(this.f54901a)) {
                C11860j.m71072n0(39);
            } else {
                AbstractC12139d.m72767f(C12347f.m74285n().m74301m(), true);
                C11860j.m70991E(this.f54902b, this.f54903c, this.f54904d);
            }
        }
    }

    /* renamed from: of.j$f */
    public class f implements InterfaceC13449b {

        /* renamed from: a */
        public final /* synthetic */ Context f54905a;

        /* renamed from: b */
        public final /* synthetic */ int f54906b;

        public f(Context context, int i10) {
            this.f54905a = context;
            this.f54906b = i10;
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: L */
        public void mo13808L(Exception exc) {
            C13981a.m83989i("PhoneFinder", "authFailed");
            boolean unused = C11860j.f54894k = false;
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: Q */
        public boolean mo13814Q(Bundle bundle) {
            return false;
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: W */
        public void mo13820W(Bundle bundle) {
            C13981a.m83989i("PhoneFinder", "onLogin");
            C11860j.m71055g1(this.f54905a, bundle, false);
            C11877j.m71307t1(this.f54905a);
            C11860j.m71022T0(this.f54905a, this.f54906b);
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: e */
        public void mo13829e(OperationCanceledException operationCanceledException) {
            C13981a.m83989i("PhoneFinder", "authCanceled");
            boolean unused = C11860j.f54894k = false;
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: m0 */
        public void mo13838m0(Bundle bundle) {
            C13981a.m83989i("PhoneFinder", "getUserInfoSuccess");
        }
    }

    /* renamed from: of.j$g */
    public class g extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ Context f54907a;

        /* renamed from: b */
        public final /* synthetic */ int f54908b;

        public g(Context context, int i10) {
            this.f54907a = context;
            this.f54908b = i10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (C11853c.m70968g().m70971f(this.f54907a)) {
                C11860j.m71093y(this.f54907a, this.f54908b);
                return;
            }
            C13981a.m83988e("PhoneFinder", "sendPhoneFinderOn checkClientTaKey fail");
            Bundle bundle = new Bundle();
            bundle.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 39);
            C11860j.m71074o0(bundle, false, true);
        }
    }

    /* renamed from: of.j$h */
    public class h implements ServiceConnection {

        /* renamed from: a */
        public final /* synthetic */ int f54909a;

        public h(int i10) {
            this.f54909a = i10;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws RemoteException {
            C13981a.m83989i("PhoneFinder", "sendPhoneFinderOn onServiceConnected");
            C11860j.m71024U0(iBinder, false, this.f54909a);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C13981a.m83987d("PhoneFinder", "onServiceDisconnected");
            Messenger unused = C11860j.f54893j = null;
            boolean unused2 = C11860j.f54894k = false;
        }
    }

    /* renamed from: of.j$i */
    public class i extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ String f54910a;

        /* renamed from: b */
        public final /* synthetic */ String f54911b;

        public i(String str, String str2) {
            this.f54910a = str;
            this.f54911b = str2;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C12796a c12796a = new C12796a();
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            Context contextM74301m = C12347f.m74285n().m74301m();
            linkedHashMap.put("isAccountExist", String.valueOf(AbstractC12139d.m72768g(contextM74301m)));
            linkedHashMap.put("isPhoneFindOpen", String.valueOf(C1175a.m7389k(contextM74301m)));
            linkedHashMap.put("isDeviceIdError", this.f54910a);
            c12796a.m76772e(contextM74301m, "PhoneFinder", "01076", this.f54911b, "0", "01076", null, "update TA, check deviceID error", linkedHashMap);
        }
    }

    /* renamed from: of.j$j */
    public static class j extends Handler {
        public j(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public final void m71101a(Message message) {
            int i10 = message.what;
            if (i10 == 15) {
                C11860j.m71068l0();
            } else if (i10 == 16) {
                C11860j.m71084t0(false, message);
            } else {
                if (i10 != 42) {
                    return;
                }
                C11860j.m71080r0(false);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            C11875h.m71193d(C12347f.m74285n().m74301m());
            int i10 = message.what;
            if (i10 == 5) {
                C13981a.m83989i("PhoneFinder", "MSG_PHONEFINDER_OPEN_SUCCESS");
                boolean unused = C11860j.f54894k = false;
                C11860j.m71092x0();
                return;
            }
            if (i10 == 6) {
                C13981a.m83989i("PhoneFinder", "MSG_PHONEFINDER_OPEN_FAIL");
                boolean unused2 = C11860j.f54894k = false;
                C11860j.m71074o0(message.getData(), false, true);
                return;
            }
            if (i10 == 10) {
                boolean unused3 = C11860j.f54894k = false;
                C11860j.m71066k0();
                return;
            }
            if (i10 == 19) {
                C13981a.m83989i("PhoneFinder", "MSG_PHONEFINDER_OPEN_SUCCESS_BACK");
                boolean unused4 = C11860j.f54894k = false;
                C11860j.m71092x0();
                return;
            }
            if (i10 == 20) {
                C13981a.m83989i("PhoneFinder", "MSG_PHONEFINDER_OPEN_FAIL_BACK");
                boolean unused5 = C11860j.f54894k = false;
                C11860j.m71074o0(message.getData(), false, true);
            } else if (i10 == 24) {
                C13981a.m83989i("PhoneFinder", "MSG_PHONEFINDER_OPEN_UNSUPPORTED");
                boolean unused6 = C11860j.f54894k = false;
                C11860j.m71082s0(false, message.getData());
            } else {
                if (i10 != 25) {
                    m71101a(message);
                    return;
                }
                C13981a.m83989i("PhoneFinder", "MSG_PHONEFINDER_OPEN_UNSUPPORTED_BACK");
                boolean unused7 = C11860j.f54894k = false;
                C11860j.m71082s0(true, message.getData());
            }
        }
    }

    /* renamed from: A */
    public static void m70983A(final Context context) {
        try {
            if (!C13452e.m80781L().m80842P0()) {
                C13981a.m83989i("PhoneFinder", "checkTaData not login");
                return;
            }
            if (!C1175a.m7389k(context)) {
                C13981a.m83989i("PhoneFinder", "checkTaData switch off");
                return;
            }
            AccountInfo accountInfoM72766e = AbstractC12139d.m72766e(context);
            if (C1175a.m7381c(accountInfoM72766e)) {
                C13981a.m83989i("PhoneFinder", "checkTaData data exist");
                return;
            }
            if (System.currentTimeMillis() - C11877j.m71284m(context) < 86400000) {
                C13981a.m83989i("PhoneFinder", "checkTaData time limit");
                return;
            }
            if (!C11853c.m70968g().m70972h(context)) {
                C13981a.m83989i("PhoneFinder", "checkTaData ta key is empty");
                return;
            }
            C11877j.m71309u0(context, System.currentTimeMillis());
            accountInfoM72766e.setAccountName(C13452e.m80781L().m80900d());
            accountInfoM72766e.setDeviceID(C13452e.m80781L().m80950o());
            accountInfoM72766e.setServiceToken("");
            accountInfoM72766e.setDeviceType(C13452e.m80781L().m80966s());
            accountInfoM72766e.setUserID4RC(C13452e.m80781L().m80971t0());
            accountInfoM72766e.setSiteID4RC(String.valueOf(C13452e.m80781L().m80947n0()));
            accountInfoM72766e.setAccountType(C13452e.m80781L().m80905e());
            accountInfoM72766e.setCountryCode(C13452e.m80781L().m80942m());
            new C12505m(1, C12797b.m76774a("01077"), new Handler.Callback() { // from class: of.g
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    return C11860j.m71033Z(context, message);
                }
            }).m75087f();
        } catch (Exception e10) {
            C13981a.m83988e("PhoneFinder", "checkAntiTheftData error " + e10.getMessage());
        }
    }

    /* renamed from: A0 */
    public static void m70984A0() {
        C13981a.m83989i("PhoneFinder", "handleMessage->phoneFinderRemoteBindSuccess");
        m71052f1();
        AbstractC12139d.m72764c(C12347f.m74285n().m74301m());
        C13108a.m78878b(m71007M()).m78881d(new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_REMOTEBIND_SUCCESS"));
    }

    /* renamed from: B */
    public static void m70985B(Context context, int i10) {
        C13981a.m83989i("PhoneFinder", "checkLoginState");
        m70994F0(false, AbstractC12139d.m72766e(C0213f.m1377a()));
        if (!m71025V()) {
            C13195l.m79272J().m79337u0(new f(context, i10), false);
        } else {
            m71055g1(context, null, false);
            C11877j.m71307t1(context);
            m71022T0(context, i10);
        }
    }

    /* renamed from: B0 */
    public static void m70986B0(String str, boolean z10, boolean z11) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("PhoneFinder", "processPhoneFinderOpenSuccess, writeSuccess: " + z10 + ", isRepeatActive: " + z11);
        if (!z10) {
            C13981a.m83988e("PhoneFinder", "updateEncryptedAccountInfo fail");
            Bundle bundle = new Bundle();
            bundle.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 38);
            m71078q0(bundle, true);
            m71010N0("write DT for open phone find");
            return;
        }
        AbstractC12139d.m72767f(C12347f.m74285n().m74301m(), true);
        String deviceIDEncrypted = AbstractC12139d.m72766e(C12347f.m74285n().m74301m()).getDeviceIDEncrypted();
        String deviceTicket = AbstractC12139d.m72766e(C12347f.m74285n().m74301m()).getDeviceTicket();
        if (TextUtils.isEmpty(deviceIDEncrypted) || TextUtils.isEmpty(deviceTicket)) {
            C13981a.m83988e("PhoneFinder", "deviceIdEncrypted isEmpty");
            Bundle bundle2 = new Bundle();
            bundle2.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 38);
            m71078q0(bundle2, true);
            return;
        }
        C13981a.m83989i("PhoneFinder", "phone finder open success");
        f54894k = false;
        C11877j.m71243X0(m71007M(), Boolean.TRUE);
        m71092x0();
        C10028c.m62182c0().m62321e2(true);
        m71089w();
        if (z11) {
            m71058h1(1, null);
        }
        C12354d.m74326B(str);
        C9120m0.m57401k1(m71007M());
    }

    /* renamed from: C */
    public static void m70987C() {
        Context contextM74301m = C12347f.m74285n().m74301m();
        C1175a.m7398t(false, contextM74301m);
        C11875h.m71193d(contextM74301m);
    }

    /* renamed from: C0 */
    public static void m70988C0(Context context, String str, int i10) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("PhoneFinder", "processQuerySuccess");
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("params")) {
                C13981a.m83987d("PhoneFinder", "json has no params");
                f54894k = false;
                return;
            }
            final JSONObject jSONObject2 = (JSONObject) jSONObject.get("params");
            C13981a.m83987d("PhoneFinder", "jsonParams=" + jSONObject2);
            if ((jSONObject2.has("active") ? jSONObject2.getInt("active") : 0) == 0) {
                C13981a.m83987d("PhoneFinder", "query result: device is not active");
                m71088v0(-1);
                m70985B(context, i10);
                return;
            }
            String string = jSONObject2.has(JsbMapKeyNames.H5_USER_ID) ? jSONObject2.getString(JsbMapKeyNames.H5_USER_ID) : null;
            if (string != null && string.equals(C13452e.m80781L().m80971t0()) && string.equals(AbstractC12139d.m72766e(context).getUserID())) {
                new C12505m(1, C12797b.m76774a("01062"), new Handler.Callback() { // from class: of.i
                    @Override // android.os.Handler.Callback
                    public final boolean handleMessage(Message message) {
                        return C11860j.m71045d0(jSONObject2, message);
                    }
                }).m75087f();
            } else {
                f54894k = false;
                m70992E0(context, i10);
            }
        } catch (JSONException e10) {
            C13981a.m83989i("PhoneFinder", "queryCurrentDeviceActive exception:" + e10.getMessage());
            f54894k = false;
        }
    }

    /* renamed from: D */
    public static void m70989D(C4344b c4344b) {
        C13981a.m83989i("PhoneFinder", "deRegistration");
        if (m71007M() == null) {
            C13981a.m83988e("PhoneFinder", "doDeRegistration:getContext() is null");
            return;
        }
        String deviceID = AbstractC12139d.m72766e(m71007M()).getDeviceID();
        String deviceType = AbstractC12139d.m72766e(m71007M()).getDeviceType();
        String serviceToken = AbstractC12139d.m72766e(m71007M()).getServiceToken();
        String deviceTicket = AbstractC12139d.m72766e(m71007M()).getDeviceTicket();
        if (!f54887d) {
            if (TextUtils.isEmpty(deviceID)) {
                C13981a.m83988e("PhoneFinder", "doDeRegistration:deviceID is empty");
                new C12797b().m76784j(m71007M(), "PhoneFinder", "001_3011", "deviceId is empty", null, "01060", null, "inActive", true);
                return;
            } else if (TextUtils.isEmpty(deviceType)) {
                C13981a.m83988e("PhoneFinder", "doDeRegistration:deviceType is empty");
                new C12797b().m76784j(m71007M(), "PhoneFinder", "001_3011", "deviceType is empty", null, "01060", null, "inActive", true);
                return;
            } else if (TextUtils.isEmpty(deviceTicket)) {
                C13981a.m83990w("PhoneFinder", "doDeRegistration:deviceTicket is empty");
            }
        }
        new C12499g(null, deviceID, "", C0241z.m1685c(deviceType), serviceToken, "v11", null, null, 0, c4344b, m71007M(), C13172b.m79206b(m71007M()), deviceTicket, null).m75025f();
    }

    /* renamed from: D0 */
    public static void m70990D0(Message message) {
        C13981a.m83989i("PhoneFinder", "processRepeatActive");
        m70994F0(false, AbstractC12139d.m72766e(C0213f.m1377a()));
        String strM80971t0 = C13452e.m80781L().m80971t0();
        String strM80905e = C13452e.m80781L().m80905e();
        Context contextM74301m = C12347f.m74285n().m74301m();
        AccountInfo accountInfoM72766e = AbstractC12139d.m72766e(contextM74301m);
        if (!C13171a.m79199e() || !strM80971t0.equals(accountInfoM72766e.getUserID()) || strM80905e == null || !strM80905e.equals(accountInfoM72766e.getAccountType()) || !C13171a.m79195a()) {
            Bundle bundle = new Bundle();
            bundle.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 42);
            m71074o0(bundle, false, false);
        } else {
            C13981a.m83989i("PhoneFinder", "writeHiSyncAccount No Need To Update And Register");
            C11881n.m71368r(m71007M());
            m71055g1(contextM74301m, null, true);
            C11877j.m71307t1(contextM74301m);
            m71084t0(true, message);
        }
    }

    /* renamed from: E */
    public static void m70991E(boolean z10, String str, C4344b c4344b) {
        C13981a.m83989i("PhoneFinder", "deRegistrationV3");
        new C12497e(z10, str, c4344b).m75011g();
    }

    /* renamed from: E0 */
    public static void m70992E0(Context context, int i10) {
        Bundle bundle = new Bundle();
        if (3 == i10 || 4 == i10) {
            bundle.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 46);
        } else {
            bundle.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 37);
        }
        m71074o0(bundle, false, false);
        if (5 == i10 || 11 == i10 || context == null) {
            return;
        }
        C13981a.m83989i("PhoneFinder", "start activation activity");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) ActivationNormalActivity.class));
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        context.startActivity(intent);
    }

    /* renamed from: F */
    public static void m70993F() {
        C13981a.m83989i("PhoneFinder", "doBindService");
        if (m71007M() == null) {
            C13981a.m83988e("PhoneFinder", "doBindService->getContext() is null");
            return;
        }
        Intent intent = new Intent("com.huawei.remotecontrol.intent.action.REGISTRATION");
        intent.setClassName(m71007M(), "com.huawei.android.remotecontrol.registration.ControlService");
        m71007M().bindService(intent, f54890g, 1);
        f54891h = true;
    }

    /* renamed from: F0 */
    public static void m70994F0(boolean z10, AccountInfo accountInfo) {
        C13981a.m83987d("PhoneFinder", "beforeActivation is " + z10);
        if (!z10) {
            if (C13452e.m80781L().m80842P0()) {
                String strM80942m = C13452e.m80781L().m80942m();
                String strM78612C = C13040c.m78609F().m78612C();
                if (strM80942m == null || strM80942m.equalsIgnoreCase(strM78612C)) {
                    m71019S(strM80942m);
                    return;
                } else {
                    m71021T(strM80942m);
                    return;
                }
            }
            return;
        }
        if (accountInfo == null) {
            C13981a.m83988e("PhoneFinder", "accountInfo not exist");
            m71019S(C13452e.m80781L().m80942m());
            return;
        }
        String countryCode = accountInfo.getCountryCode();
        if (TextUtils.isEmpty(countryCode)) {
            C13981a.m83988e("PhoneFinder", "accountInfo userLockCountryCode is empty");
            m71019S(C13452e.m80781L().m80942m());
        } else if (countryCode.equalsIgnoreCase(C13040c.m78609F().m78612C())) {
            m71019S(countryCode);
        } else {
            m71021T(countryCode);
        }
    }

    /* renamed from: G */
    public static void m70995G(Context context, C4344b c4344b) {
        C13981a.m83989i("PhoneFinder", "doDeRegistration");
        if (!C11853c.m70968g().m70972h(context) || TextUtils.isEmpty(AbstractC12139d.m72766e(context).getDeviceID())) {
            C12515a.m75110o().m75175e(new d(context, c4344b), false);
        } else {
            m70989D(c4344b);
        }
    }

    /* renamed from: G0 */
    public static void m70996G0(String str) {
        C13981a.m83989i("PhoneFinder", "refreshPushToken");
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("PhoneFinder", "pushToken is empty");
        } else if (C0209d.m1166E1()) {
            new C12503k(str, m71007M(), "v11").m75066d();
        } else {
            C13981a.m83989i("PhoneFinder", "stop refreshPushToken: is not OwnerUser");
        }
    }

    /* renamed from: H */
    public static void m70997H(Context context, boolean z10, String str, C4344b c4344b) {
        C13981a.m83989i("PhoneFinder", "doDeRegistration");
        if (!C11853c.m70968g().m70972h(context) || TextUtils.isEmpty(AbstractC12139d.m72766e(context).getDeviceID())) {
            C12515a.m75110o().m75175e(new e(context, z10, str, c4344b), false);
        } else {
            m70991E(z10, str, c4344b);
        }
    }

    /* renamed from: H0 */
    public static void m70998H0(Handler handler) {
        f54892i = handler;
    }

    /* renamed from: I */
    public static void m70999I(int i10) {
        C13981a.m83987d("PhoneFinder", "doRemoteBind");
        if (m71007M() != null) {
            String deviceID = AbstractC12139d.m72766e(m71007M()).getDeviceID();
            String deviceType = AbstractC12139d.m72766e(m71007M()).getDeviceType();
            String serviceToken = AbstractC12139d.m72766e(m71007M()).getServiceToken();
            String deviceTicket = AbstractC12139d.m72766e(m71007M()).getDeviceTicket();
            String challengeString = AbstractC12139d.m72766e(m71007M()).getChallengeString();
            if (!TextUtils.isEmpty(challengeString)) {
                new C12496d(deviceID, C0241z.m1685c(deviceType), serviceToken, challengeString, deviceTicket, new C4344b(i10, m71007M()), m71007M(), i10).m75002e();
            } else {
                C13981a.m83988e("PhoneFinder", "doRemoteBind->challenge is empty");
                new C12796a().m76773f(C0213f.m1377a(), "001_3004", "unbind error: challenge is empty", "001_3004", "01012", null, "activeUnbind", null);
            }
        }
    }

    /* renamed from: I0 */
    public static void m71000I0(String str, String str2) {
        if (TextUtils.isEmpty(str) || C11870c.m71156d(str)) {
            return;
        }
        C13981a.m83989i("PhoneFinder", "reportBiUpdateTaDeviceIdError, scene=" + str2);
        C12515a.m75110o().m75175e(new i(str, str2), false);
    }

    /* renamed from: J */
    public static void m71001J() {
        if (f54891h) {
            if (m71007M() == null) {
                C13981a.m83988e("PhoneFinder", "doUnbindService->getContext() is null");
                return;
            }
            if (f54890g == null) {
                C13981a.m83988e("PhoneFinder", "doUnbindService->mConnection is null");
                return;
            }
            try {
                m71007M().unbindService(f54890g);
                f54891h = false;
            } catch (Exception e10) {
                C13981a.m83988e("PhoneFinder", "serviceConnection exception e = " + e10.getMessage());
            }
        }
    }

    /* renamed from: J0 */
    public static void m71002J0(String str, String str2, String str3, String str4) {
        C13981a.m83989i("PhoneFinder", "reportDeviceEvent");
        m71004K0(str, str2, str3, str4, false, false);
    }

    /* renamed from: K */
    public static int m71003K() {
        C13981a.m83989i("PhoneFinder", "getAntiRollbackFlag");
        if (!m71031Y()) {
            C13981a.m83988e("PhoneFinder", "getFactoryVersion not supported");
            return 0;
        }
        String strM7387i = C1175a.m7387i();
        if (strM7387i == null) {
            C13981a.m83988e("PhoneFinder", "getFactoryVersion not exist");
            return 1;
        }
        if (strM7387i.equals("")) {
            C13981a.m83988e("PhoneFinder", "read factory version error");
            return 1;
        }
        if (!strM7387i.matches("^0000EmotionUI_(\\d+\\.){2}\\d+")) {
            C13981a.m83988e("PhoneFinder", "malformed factory version name " + strM7387i);
            return 1;
        }
        String[] strArrSplit = strM7387i.split("_");
        if (strArrSplit.length != 2) {
            C13981a.m83988e("PhoneFinder", "malformed factory version name " + strM7387i);
            return 1;
        }
        try {
            return Integer.parseInt(strArrSplit[1].split("\\.")[0]) < 14 ? 2 : 1;
        } catch (NumberFormatException unused) {
            C13981a.m83988e("PhoneFinder", "malformed factory version number " + strArrSplit[0]);
            return 1;
        }
    }

    /* renamed from: K0 */
    public static void m71004K0(String str, String str2, String str3, String str4, boolean z10, boolean z11) {
        C13981a.m83989i("PhoneFinder", "reportDeviceEventBase:" + z11);
        Context contextM74301m = C12347f.m74285n().m74301m();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if (z10) {
            linkedHashMap.put("deviceId", C9310c.m58618b(C12498f.m75015b(contextM74301m)));
        }
        if (str4 != null) {
            linkedHashMap.put("info", str4);
        }
        if (z11) {
            new C12796a().m76772e(contextM74301m, "PhoneFinder", "", str3, "", str2, "", str, linkedHashMap);
        } else {
            new C12797b().m76785k(contextM74301m, "PhoneFinder", "", str3, "", str2, "", str, true, linkedHashMap);
        }
        linkedHashMap.put("errorReason", str3);
        UBAAnalyze.m29947H("CKP", str, linkedHashMap);
        C13222a.m79461c(contextM74301m, C13222a.m79464f(contextM74301m, str, "1", C13452e.m80781L().m80971t0(), "2"));
    }

    /* renamed from: L */
    public static int m71005L() {
        return f54886c;
    }

    /* renamed from: L0 */
    public static void m71006L0(String str, String str2, String str3, String str4) {
        C13981a.m83989i("PhoneFinder", "reportDeviceEventWithSn");
        m71004K0(str, str2, str3, str4, true, true);
    }

    /* renamed from: M */
    public static synchronized Context m71007M() {
        try {
            if (f54884a == null) {
                f54884a = C12347f.m74285n().m74301m();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f54884a;
    }

    /* renamed from: M0 */
    public static void m71008M0(boolean z10, boolean z11) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Intent intent = new Intent("com.huawei.android.remotecontrol.intent.PHONEFINDER_RESULT");
        intent.putExtra("phonefinder_result", z10);
        m71007M().sendBroadcast(intent, "com.huawei.remotocontrol.permission.REMOTECALL");
        if (z11) {
            C13108a.m78878b(m71007M()).m78881d(intent);
        }
        C14300a.m85169b(z10);
    }

    /* renamed from: N */
    public static String m71009N() {
        return !TextUtils.isEmpty(f54896m) ? f54896m : C11877j.m71296q(C0213f.m1377a());
    }

    /* renamed from: N0 */
    public static void m71010N0(String str) {
        C12797b c12797b = new C12797b();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("isAccountExist", String.valueOf(AbstractC12139d.m72768g(f54884a)));
        linkedHashMap.put("isPhoneFindOpen", String.valueOf(C1175a.m7389k(f54884a)));
        linkedHashMap.put("lockVersion", C1175a.m7388j());
        c12797b.m76785k(f54884a, "PhoneFinder", "001_1004", str, "-1", "001_1004", null, "update ta date error", true, linkedHashMap);
    }

    /* renamed from: O */
    public static int m71011O() {
        return f54885b;
    }

    /* renamed from: O0 */
    public static void m71012O0(JSONObject jSONObject) {
        if (!AbstractC12139d.m72769h(C0213f.m1377a())) {
            C12354d.m74327C(jSONObject, "proactive");
        } else if (m71003K() != 1) {
            C12354d.m74327C(jSONObject, "proactive");
        }
    }

    /* renamed from: P */
    public static void m71013P() {
        C12515a.m75110o().m75172d(new c());
    }

    /* renamed from: P0 */
    public static void m71014P0(Context context) {
        C13981a.m83989i("PhoneFinder", "sendLogOffToPhoneFinder");
        if (context != null) {
            m70995G(context, new C4344b(SNSCode.Status.USER_NOT_FOUND, 100, context));
            String strM80790C = C13452e.m80781L().m80790C();
            C13009a.m78307b(context.getApplicationContext(), "CLOUDBACKUP_CLOSE_PHONEFINDER", "1", strM80790C);
            UBAAnalyze.m29946G("CKP", "HUAWEICLOUD", "CLOUDBACKUP_CLOSE_PHONEFINDER", "1", strM80790C);
            new C12797b().m76784j(context, "PhoneFinder", "001_3011", "sendLogOffToPhoneFinder", null, "01060", null, "inActive", true);
        }
    }

    /* renamed from: Q */
    public static void m71015Q(String str, boolean z10) {
        C12515a.m75110o().m75175e(new b(str, z10), false);
    }

    /* renamed from: Q0 */
    public static void m71016Q0(Context context) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("PhoneFinder", "sendLogOffToPhoneFinderNoInActive");
        if (context != null) {
            String strM80790C = C13452e.m80781L().m80790C();
            C13009a.m78307b(context.getApplicationContext(), "CLOUDBACKUP_CLOSE_PHONEFINDER", "1", strM80790C);
            UBAAnalyze.m29946G("CKP", "HUAWEICLOUD", "CLOUDBACKUP_CLOSE_PHONEFINDER", "1", strM80790C);
        }
        m71090w0();
    }

    /* renamed from: R */
    public static boolean m71017R(String str) {
        C13981a.m83989i("PhoneFinder", "hasLocalActivationLock");
        if (TextUtils.isEmpty(str)) {
            C13981a.m83990w("PhoneFinder", "cloudUID is empty");
            return false;
        }
        if (!C1175a.m7389k(m71007M())) {
            C13981a.m83989i("PhoneFinder", "phone finder switch off");
            return false;
        }
        if (TextUtils.isEmpty(AbstractC12139d.m72766e(m71007M()).getAccountName())) {
            C13981a.m83990w("PhoneFinder", "account name in TEE is null or empty.");
            return false;
        }
        if (str.equals(AbstractC12139d.m72766e(m71007M()).getUserID4RC())) {
            return false;
        }
        C13981a.m83988e("PhoneFinder", "uid not match");
        return true;
    }

    /* renamed from: R0 */
    public static void m71018R0(Context context, boolean z10, String str) {
        C13981a.m83989i("PhoneFinder", "sendLogOffToPhoneFinderV3");
        if (context != null) {
            m70997H(context, z10, str, new C4344b(SNSCode.Status.USER_NOT_FOUND, 100, context));
            String strM80790C = C13452e.m80781L().m80790C();
            C13009a.m78307b(context.getApplicationContext(), "CLOUDBACKUP_CLOSE_PHONEFINDER", "1", strM80790C);
            UBAAnalyze.m29946G("CKP", "HUAWEICLOUD", "CLOUDBACKUP_CLOSE_PHONEFINDER", "1", strM80790C);
            new C12796a().m76772e(context, "PhoneFinder", "001_3011", z10 ? "closePhoneFinderByVt" : "closePhoneFinderByLockSign", null, "01060", null, "inActive", null);
        }
    }

    /* renamed from: S */
    public static void m71019S(String str) {
        C13981a.m83989i("PhoneFinder", "initGrsParam");
        C13040c.m78609F().m78652i0(C12347f.m74285n().m74301m(), str, false);
    }

    /* renamed from: S0 */
    public static void m71020S0(String str, Context context, Bundle bundle) {
        C13981a.m83989i("PhoneFinder", "sendLogOnBroadcastToPhoneFinder");
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("PhoneFinder", "userId is empty");
            return;
        }
        if (C1175a.m7395q(m71007M(), str)) {
            C13981a.m83990w("PhoneFinder", "uid not match");
            m71080r0(false);
            return;
        }
        if (!str.equals(AbstractC12139d.m72766e(context).getUserID4RC())) {
            C13981a.m83990w("PhoneFinder", "userId do not equals currentUserID");
            C1175a.m7383e(context);
        }
        C11875h.m71192c(context);
        C11875h.m71191b(context);
    }

    /* renamed from: T */
    public static void m71021T(String str) {
        C13981a.m83989i("PhoneFinder", "invalid and InitGrsParam");
        C13040c.m78609F().m78649h();
        C13040c.m78609F().m78647g();
        C13040c.m78609F().m78652i0(C12347f.m74285n().m74301m(), str, true);
    }

    /* renamed from: T0 */
    public static void m71022T0(Context context, int i10) {
        C13981a.m83989i("PhoneFinder", "sendPhoneFinderOn");
        if (!f54894k) {
            m71037a1(1);
            m71030X0(500);
        }
        f54894k = true;
        if (C11853c.m70968g().m70972h(context)) {
            m71093y(context, i10);
        } else {
            C13981a.m83989i("PhoneFinder", "get client key");
            C12515a.m75110o().m75175e(new g(context, i10), false);
        }
    }

    /* renamed from: U */
    public static boolean m71023U() {
        return f54888e;
    }

    /* renamed from: U0 */
    public static void m71024U0(IBinder iBinder, boolean z10, int i10) throws RemoteException {
        if (!C0209d.m1166E1()) {
            C13981a.m83990w("PhoneFinder", "sub User not support findPhone");
            f54894k = false;
            return;
        }
        f54893j = new Messenger(iBinder);
        try {
            C13981a.m83989i("PhoneFinder", "sendPhoneFinderOn");
            Message messageObtain = Message.obtain((Handler) null, 1);
            Bundle bundle = new Bundle();
            bundle.putBoolean("isBack", z10);
            bundle.putInt("regist_type", i10);
            messageObtain.setData(bundle);
            messageObtain.replyTo = f54889f;
            f54893j.send(messageObtain);
        } catch (RemoteException e10) {
            C13981a.m83988e("PhoneFinder", "sendPhoneFinderOn RemoteException" + e10.getMessage());
        }
    }

    /* renamed from: V */
    public static boolean m71025V() {
        return !TextUtils.isEmpty(C13452e.m80781L().m80971t0());
    }

    /* renamed from: V0 */
    public static void m71026V0() {
        AbstractC12139d.m72766e(m71007M()).setChallengeString(AbstractC0200e.m1107f());
        m71000I0(AbstractC12139d.m72766e(m71007M()).getDeviceID(), "sendRemoteBind, update Challenge String");
        AbstractC12139d.m72776o(m71007M(), new InterfaceC12348a() { // from class: of.h
            @Override // p576qf.InterfaceC12348a
            public final void onResult(boolean z10) {
                C11860j.m71048e0(z10);
            }
        });
        C13981a.m83989i("PhoneFinder", "sendRemoteBindReportToPhoneFinder onServiceConnected");
        m70999I(3015);
    }

    /* renamed from: W */
    public static boolean m71027W() {
        return f54894k;
    }

    /* renamed from: W0 */
    public static void m71028W0() {
        m70999I(3016);
    }

    /* renamed from: X */
    public static boolean m71029X() {
        if (!C1175a.m7389k(m71007M())) {
            return f54894k;
        }
        C13981a.m83987d("PhoneFinder", "phoneFinder switch is open");
        return false;
    }

    /* renamed from: X0 */
    public static void m71030X0(int i10) {
        f54886c = i10;
    }

    /* renamed from: Y */
    public static boolean m71031Y() {
        C13981a.m83989i("PhoneFinder", "isSupportV3");
        byte[] bArrM7386h = C1175a.m7386h();
        if (bArrM7386h == null || bArrM7386h.length < 2) {
            C13981a.m83989i("PhoneFinder", "configs null");
            return false;
        }
        if (bArrM7386h[0] == 3) {
            return true;
        }
        C13981a.m83989i("PhoneFinder", "rom version not supported");
        return false;
    }

    /* renamed from: Y0 */
    public static void m71032Y0(boolean z10) {
        f54887d = z10;
    }

    /* renamed from: Z */
    public static /* synthetic */ boolean m71033Z(Context context, Message message) {
        if (TextUtils.isEmpty(message.getData().getString("ticket"))) {
            C13981a.m83989i("PhoneFinder", "checkTaData dt is empty");
            return false;
        }
        m70990D0(message);
        new C12797b().m76784j(context, "PhoneFinder", "001_3010", "update ta data", null, "01051", null, "taReadError", true);
        return false;
    }

    /* renamed from: Z0 */
    public static void m71034Z0(String str) {
        f54896m = str;
        C11877j.m71318y0(C0213f.m1377a(), str);
    }

    /* renamed from: a0 */
    public static /* synthetic */ boolean m71036a0(Context context, int i10, Message message) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("PhoneFinder", "queryCurrentDeviceActive");
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        if (200 != iM1685c) {
            C13981a.m83989i("PhoneFinder", "queryCurrentDeviceActive Fail:" + iM1685c);
            Bundle bundle = new Bundle();
            bundle.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 45);
            m71074o0(bundle, false, false);
            return true;
        }
        String string = message.getData().getString("response_info");
        C13981a.m83987d("PhoneFinder", "queryCurrentDeviceActive:" + string);
        int iM26233d = C4347e.m26233d(string);
        C13981a.m83989i("PhoneFinder", "report code = " + iM26233d);
        if (iM26233d == 0 || 3001 == iM26233d) {
            m70988C0(context, string, i10);
            return true;
        }
        C13981a.m83989i("PhoneFinder", "queryCurrentDeviceActive Fail:" + iM26233d);
        Bundle bundle2 = new Bundle();
        bundle2.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, iM26233d);
        m71074o0(bundle2, false, false);
        return true;
    }

    /* renamed from: a1 */
    public static void m71037a1(int i10) {
        f54885b = i10;
    }

    /* renamed from: b0 */
    public static /* synthetic */ void m71039b0() {
        C11880m.m71336c(m71007M(), R$string.phonefinder_device_deleted_tips_update);
    }

    /* renamed from: b1 */
    public static void m71040b1() {
        f54894k = true;
    }

    /* renamed from: c0 */
    public static /* synthetic */ void m71042c0(boolean z10) {
        if (z10) {
            return;
        }
        m71010N0("updateChallengeString RemoteBindReportFail");
    }

    /* renamed from: c1 */
    public static void m71043c1(Context context, int i10) {
        C13981a.m83989i("PhoneFinder", "startActivatePhoneActivity requestCode=" + i10);
        if (context == null) {
            C13981a.m83988e("PhoneFinder", "startActivatePhoneActivity context null");
            return;
        }
        C13981a.m83989i("PhoneFinder", "start activation activity from guide");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) ActivationNormalActivity.class));
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i10);
        } else {
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            context.startActivity(intent);
        }
    }

    /* renamed from: d0 */
    public static /* synthetic */ boolean m71045d0(JSONObject jSONObject, Message message) {
        if (TextUtils.isEmpty(message.getData().getString("ticket"))) {
            Bundle bundle = new Bundle();
            bundle.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 40);
            m71074o0(bundle, false, false);
        } else {
            m70990D0(message);
            m71012O0(jSONObject);
        }
        return false;
    }

    /* renamed from: d1 */
    public static void m71046d1(Activity activity) {
        if (activity == null) {
            C13981a.m83988e("PhoneFinder", "check context null");
            return;
        }
        C13981a.m83989i("PhoneFinder", "start activation activity from wap");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(activity, (Class<?>) ActivationNormalActivity.class));
        activity.startActivityForResult(intent, 10044);
    }

    /* renamed from: e0 */
    public static /* synthetic */ void m71048e0(boolean z10) {
        if (z10) {
            return;
        }
        m71010N0("updateChallengeString startRemoteBind");
    }

    /* renamed from: e1 */
    public static void m71049e1() {
        f54892i = null;
    }

    /* renamed from: f0 */
    public static void m71051f0(final Context context, final int i10, boolean z10) {
        C13981a.m83989i("PhoneFinder", "openPhoneFinderInBack=" + i10);
        f54894k = true;
        f54895l = z10;
        if (C13195l.m79272J().m79306V(C13452e.m80781L().m80905e())) {
            C13981a.m83989i("PhoneFinder", "FAIL_BY_THIRD_ACCOUNT");
            f54894k = false;
            Bundle bundle = new Bundle();
            bundle.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 43);
            m71074o0(bundle, false, false);
            return;
        }
        if (!C0209d.m1166E1()) {
            C13981a.m83990w("PhoneFinder", "sub User not support findPhone");
            f54894k = false;
            Bundle bundle2 = new Bundle();
            bundle2.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 44);
            m71074o0(bundle2, false, false);
            return;
        }
        if (!C1175a.m7389k(context)) {
            m70985B(context, i10);
            return;
        }
        if (!C1175a.m7385g(true) || AbstractC12139d.m72768g(context)) {
            m70994F0(true, AbstractC12139d.m72766e(C0213f.m1377a()));
            C11866p.m71105d(new Handler.Callback() { // from class: of.d
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    return C11860j.m71036a0(context, i10, message);
                }
            });
        } else {
            C13981a.m83990w("PhoneFinder", "phone is open, accountInfo not exist");
            C1175a.m7398t(false, f54884a);
            m70985B(context, i10);
        }
    }

    /* renamed from: f1 */
    public static void m71052f1() {
        Context contextM74301m = C12347f.m74285n().m74301m();
        String strM71252b0 = C11877j.m71252b0(contextM74301m);
        C13981a.m83989i("PhoneFinder", "unRegisterPushToken");
        if (TextUtils.isEmpty(strM71252b0)) {
            C13981a.m83990w("PhoneFinder", "unRegisterPushToken token is empty.");
        } else {
            C11877j.m71274i1(contextM74301m, Boolean.FALSE);
        }
    }

    /* renamed from: g0 */
    public static void m71054g0() {
        if (!AbstractC12139d.m72769h(m71007M())) {
            C13981a.m83989i("PhoneFinder", "not need open share locate switch");
            return;
        }
        if (C13604i.m81782e().m81790i() == 0) {
            C11877j.m71295p1(C12347f.m74285n().m74301m(), true);
            m71064j1(true);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("gradeCode", C13452e.m80781L().m80790C());
        C13230i.m79504I().m79590k0("mecloud_findmyphone_click_location_share_switch", "1", "2", C13452e.m80781L().m80971t0(), linkedHashMap);
        UBAAnalyze.m29979g0("PVP", "mecloud_findmyphone_click_location_share_switch", "1", "19", "1", "2", linkedHashMap);
        C12515a.m75110o().m75172d(new C9475d());
    }

    /* renamed from: g1 */
    public static void m71055g1(Context context, Bundle bundle, boolean z10) {
        C13981a.m83989i("PhoneFinder", "updateAccountInfo");
        AccountInfo accountInfo = new AccountInfo();
        if (m71025V()) {
            accountInfo.setAccountName(C13452e.m80781L().m80900d());
            accountInfo.setDeviceID(C13452e.m80781L().m80950o());
            accountInfo.setServiceToken("");
            accountInfo.setDeviceType(C13452e.m80781L().m80966s());
            accountInfo.setUserID4RC(C13452e.m80781L().m80971t0());
            accountInfo.setSiteID4RC(String.valueOf(C13452e.m80781L().m80947n0()));
            accountInfo.setAccountType(C13452e.m80781L().m80905e());
            accountInfo.setCountryCode(C13452e.m80781L().m80942m());
        } else if (bundle != null) {
            accountInfo.setAccountName(bundle.getString("accountName"));
            accountInfo.setDeviceID(bundle.getString("deviceID"));
            accountInfo.setServiceToken("");
            accountInfo.setDeviceType(bundle.getString(JsbMapKeyNames.H5_DEVICE_TYPE));
            accountInfo.setUserID4RC(bundle.getString(JsbMapKeyNames.H5_USER_ID));
            accountInfo.setSiteID4RC(bundle.getString(HwPayConstant.KEY_SITE_ID));
            accountInfo.setAccountType(bundle.getString("accountType"));
            accountInfo.setCountryCode(bundle.getString("countryCode"));
        }
        if (TextUtils.isEmpty(accountInfo.getAccountName())) {
            C13981a.m83988e("PhoneFinder", "writeAccount have the invalid  params name");
            Bundle bundle2 = new Bundle();
            bundle2.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 45);
            m71074o0(bundle2, false, false);
            return;
        }
        if (TextUtils.isEmpty(accountInfo.getUserID())) {
            C13981a.m83988e("PhoneFinder", "writeAccount have the invalid  params userId");
            Bundle bundle3 = new Bundle();
            bundle3.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 45);
            m71074o0(bundle3, false, false);
            return;
        }
        if (z10) {
            AccountInfo accountInfoM72766e = AbstractC12139d.m72766e(context);
            accountInfo.setDeviceTicket(accountInfoM72766e.getDeviceTicket());
            accountInfo.setChallengeString(accountInfoM72766e.getChallengeString());
        }
        AbstractC12139d.m72765d();
        AbstractC12139d.m72773l(accountInfo);
    }

    /* renamed from: h0 */
    public static void m71057h0(Bundle bundle) {
        C13981a.m83989i("PhoneFinder", "handleMessage->phoneFinderActivationAccountSuccess");
        Intent intent = new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_ACCOUNTINFO_SUCCESS");
        intent.putExtras(bundle);
        C13108a.m78878b(m71007M()).m78881d(intent);
    }

    /* renamed from: h1 */
    public static void m71058h1(int i10, String str) {
        C13981a.m83989i("PhoneFinder", "updatePublicKey, action = " + i10);
        new C12504l(m71007M(), i10, "v11", str).m75076f();
    }

    /* renamed from: i0 */
    public static void m71060i0(Bundle bundle) {
        C13981a.m83989i("PhoneFinder", "handleMessage->phoneFinderActivationAppealSuccess");
        Intent intent = new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_APPEAL_SUCCESS");
        intent.putExtras(bundle);
        C13108a.m78878b(m71007M()).m78881d(intent);
    }

    /* renamed from: i1 */
    public static void m71061i1(int i10, String str, String str2) {
        C13981a.m83989i("PhoneFinder", "updatePublicKey, action = " + i10);
        new C12504l(m71007M(), i10, str, str2).m75076f();
    }

    /* renamed from: j0 */
    public static void m71063j0(Bundle bundle) {
        C13981a.m83989i("PhoneFinder", "handleMessage->phoneFinderActivationConnectFail");
        Intent intent = new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_SITE_ERROR");
        intent.putExtra(RemoteMessageConst.MessageBody.PARAM, bundle);
        intent.putExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 14);
        C13108a.m78878b(m71007M()).m78881d(intent);
    }

    /* renamed from: j1 */
    public static void m71064j1(boolean z10) {
        Intent intent = new Intent("com.huawei.hidisk.remotecontrol.intent.location.share.state");
        intent.putExtra(MapKeyNames.RESULT_CODE, z10);
        C13108a.m78878b(m71007M()).m78881d(intent);
    }

    /* renamed from: k0 */
    public static void m71066k0() {
        C13981a.m83989i("PhoneFinder", "handleMessage->phoneFinderAuthFail");
        if (!C1175a.m7389k(m71007M())) {
            m71052f1();
        }
        m71001J();
        if (m71007M() != null) {
            C13108a.m78878b(m71007M()).m78881d(new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_OPEN_AUTH_FAILE"));
        } else {
            C13981a.m83987d("PhoneFinder", "IncomingHandler->handleMessage->MSG_PHONEFINDER_OPEN_AUTH_FAILE->getContext() is null");
        }
        if (f54892i != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
            f54892i.sendMessage(messageObtain);
        }
    }

    /* renamed from: l0 */
    public static void m71068l0() {
        C13108a.m78878b(m71007M()).m78881d(new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_QUERY_ACTIVE_AUTH_FAILE"));
    }

    /* renamed from: m0 */
    public static void m71070m0() {
        C13981a.m83989i("PhoneFinder", "handleMessage->phoneFinderCloseAuthFail");
        m71001J();
        if (m71007M() == null) {
            C13981a.m83987d("PhoneFinder", "IncomingHandler->handleMessage->phoneFinderCloseAuthFail->getContext() is null");
        } else {
            C13108a.m78878b(m71007M()).m78881d(new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_CLOSE_AUTH_FAILE"));
        }
    }

    /* renamed from: n */
    public static /* synthetic */ void m71071n(String str, boolean z10, boolean z11) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        m70986B0(str, z10, z11);
    }

    /* renamed from: n0 */
    public static void m71072n0(int i10) {
        C13981a.m83989i("PhoneFinder", "handleMessage->phoneFinderLogoffFail");
        m71001J();
        if (m71007M() == null) {
            C13981a.m83987d("PhoneFinder", "IncomingHandler->handleMessage->MSG_PHONEFINDER_LOGOFF_DEREGISTRATION_COMPLETED->getContext() is null");
            return;
        }
        C13108a c13108aM78878b = C13108a.m78878b(m71007M());
        Intent intent = new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_FAIL");
        intent.putExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, i10);
        c13108aM78878b.m78881d(intent);
    }

    /* renamed from: o0 */
    public static void m71074o0(Bundle bundle, boolean z10, boolean z11) {
        m71076p0(bundle, z10, z11, true);
    }

    /* renamed from: p0 */
    public static void m71076p0(Bundle bundle, boolean z10, boolean z11, boolean z12) {
        C13981a.m83989i("PhoneFinder", "phoneFinderOpenFail");
        f54894k = false;
        m71052f1();
        m71001J();
        if (z12) {
            AbstractC12139d.m72767f(C0213f.m1377a(), true);
        }
        if (m71007M() != null) {
            int iM71315x = C11877j.m71315x(m71007M());
            C13981a.m83987d("PhoneFinder", "getUISwitchToFile=" + iM71315x);
            if (-1 == iM71315x) {
                if (z11) {
                    m70987C();
                }
                Intent intent = new Intent("com.huawei.android.remotecontrol.intent.PHONEFINDER_RESULT");
                intent.putExtra("phonefinder_result", false);
                if (bundle != null) {
                    int i10 = bundle.getInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE);
                    intent.putExtra("socId_has_register", bundle.getBoolean("socId_has_register", false));
                    intent.putExtra("lock_oversea_repeat", bundle.getBoolean("lock_oversea_repeat", false));
                    intent.putExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, i10);
                    C11877j.m71237U0(m71007M(), Boolean.valueOf(i10 == 3001));
                }
                if (!z10) {
                    C13108a.m78878b(m71007M()).m78881d(intent);
                }
                m71007M().sendBroadcast(intent, "com.huawei.remotocontrol.permission.REMOTECALL");
            }
        } else {
            C13981a.m83987d("PhoneFinder", "getContext() is null");
        }
        if (f54895l) {
            m71095z(false);
        }
        if (f54892i != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
            f54892i.sendMessage(messageObtain);
        }
    }

    /* renamed from: q0 */
    public static void m71078q0(Bundle bundle, boolean z10) {
        m71076p0(bundle, false, true, false);
    }

    /* renamed from: r0 */
    public static void m71080r0(boolean z10) {
        C13981a.m83989i("PhoneFinder", "phoneFinderOpenFailUidNotMatch");
        Bundle bundle = new Bundle();
        bundle.putInt(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 37);
        m71074o0(bundle, z10, false);
    }

    /* renamed from: s0 */
    public static void m71082s0(boolean z10, Bundle bundle) {
        m71074o0(bundle, z10, true);
    }

    /* renamed from: t0 */
    public static void m71084t0(boolean z10, Message message) {
        C13981a.m83989i("PhoneFinder", "handleMessage phoneFinderReceivedTicket");
        Bundle data = message.getData();
        String string = data.getString("ticket");
        String string2 = data.getString("resp_ticket");
        AbstractC12139d.m72766e(m71007M()).setDeviceTicket(C11870c.m71153a(string));
        C13042e.m78685c().m78689d("key_country_code", C11477c.m68636f(AbstractC12139d.m72766e(m71007M()).getCountryCode()));
        m71015Q(string2, z10);
        m71013P();
    }

    /* renamed from: u0 */
    public static void m71086u0(int i10) {
        C13981a.m83989i("PhoneFinder", "handleMessage->phoneFinderRemoteBindFail");
        Intent intent = new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_REMOTEBIND_FAIL");
        intent.putExtra(MapKeyNames.RESULT_CODE, i10);
        C13108a.m78878b(m71007M()).m78881d(intent);
    }

    /* renamed from: v */
    public static void m71087v() {
        C13981a.m83989i("PhoneFinder", "get bluetooth device");
        new C13168a("getBindDeviceList", new Bundle()).m79190g();
        if (C13978y.m83904W(m71007M(), "boundedWearableDevice")) {
            C13978y.m83903T().m83949J(m71007M());
        }
    }

    /* renamed from: v0 */
    public static void m71088v0(int i10) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("PhoneFinder", "handleMessage MSG_PHONE_FINDER_DEVICE_DELETE, sceneCode: " + i10);
        m71052f1();
        if (m71007M() != null) {
            m70987C();
            C12347f.m74285n().m74300l(m71007M());
            C11875h.m71193d(m71007M());
            C13108a.m78878b(m71007M()).m78881d(new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_DEVICE_DEL"));
            m71008M0(false, false);
            String strM80790C = C13452e.m80781L().m80790C();
            C13009a.m78307b(m71007M(), "CLOUDBACKUP_ON_DELETE_PHONEFINDER", "1", strM80790C);
            UBAAnalyze.m29946G("CKP", "HUAWEICLOUD", "CLOUDBACKUP_ON_DELETE_PHONEFINDER", "1", strM80790C);
        } else {
            C13981a.m83987d("PhoneFinder", "IncomingHandler->handleMessage->MSG_PHONE_FINDER_OPEN_FAIL->getContext() is null");
        }
        if (i10 == 5 || i10 == 7) {
            return;
        }
        C0226l0.m1584d(new Runnable() { // from class: of.f
            @Override // java.lang.Runnable
            public final void run() {
                C11860j.m71039b0();
            }
        });
    }

    /* renamed from: w */
    public static void m71089w() {
        C12515a.m75110o().m75172d(new a());
    }

    /* renamed from: w0 */
    public static void m71090w0() throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("PhoneFinder", "handleMessage->MSG_PHONEFINDER_DEREGISTER_COMPLETED");
        m71052f1();
        if (m71007M() == null) {
            C13981a.m83987d("PhoneFinder", "IncomingHandler->handleMessage->MSG_PHONEFINDER_LOGOFF_DEREGISTRATION_COMPLETED->getContext() is null");
            return;
        }
        m70987C();
        C13981a.m83989i("PhoneFinder", "send phone finder deRegistration completed");
        C13108a.m78878b(m71007M()).m78881d(new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_COMPLETED"));
        m71008M0(false, false);
    }

    /* renamed from: x */
    public static void m71091x() {
        C12515a.m75110o().m75175e(new C9476e(C12347f.m74285n().m74301m(), true), false);
    }

    /* renamed from: x0 */
    public static void m71092x0() throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("PhoneFinder", "handleMessage->MSG_PHONEFINDER_OPEN_SUCCESS");
        f54894k = false;
        m71001J();
        if (m71007M() != null) {
            int iM71315x = C11877j.m71315x(m71007M());
            C13981a.m83989i("PhoneFinder", "getUISwitchToFile=" + iM71315x);
            if (-1 == iM71315x) {
                C13981a.m83989i("PhoneFinder", "phone finder Ui switch has opened");
                m71091x();
                m71008M0(true, true);
            }
            C11875h.m71194e(m71007M(), false);
            C11877j.m71208G(m71007M());
        } else {
            C13981a.m83988e("PhoneFinder", "IncomingHandler->handleMessage->MSG_PHONEFINDER_OPEN_SUCCESS->getContext() is null");
        }
        if (f54895l) {
            m71095z(true);
        }
        if (f54892i != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = ConnectionResult.RESOLUTION_REQUIRED;
            f54892i.sendMessage(messageObtain);
        }
    }

    /* renamed from: y */
    public static void m71093y(Context context, int i10) {
        C13981a.m83989i("PhoneFinder", "bindControlService");
        if (C1175a.m7395q(m71007M(), C13452e.m80781L().m80971t0())) {
            C13981a.m83989i("PhoneFinder", "sendPhoneFinderOn: open phoneFinder fail, uid not match");
            m71080r0(false);
        } else {
            f54890g = new h(i10);
            m70993F();
        }
    }

    /* renamed from: y0 */
    public static void m71094y0() {
        C13981a.m83989i("PhoneFinder", "handleMessage->phoneFinderRemoteBindReportFail");
        AbstractC12139d.m72766e(m71007M()).setChallengeString("");
        m71000I0(AbstractC12139d.m72766e(m71007M()).getDeviceID(), "phonefinderRemoteBindReportFail, update Challenge String");
        AbstractC12139d.m72776o(C12347f.m74285n().m74301m(), new InterfaceC12348a() { // from class: of.e
            @Override // p576qf.InterfaceC12348a
            public final void onResult(boolean z10) {
                C11860j.m71042c0(z10);
            }
        });
        C13108a.m78878b(m71007M()).m78881d(new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_REMOTEBINDREPORT_FAIL"));
    }

    /* renamed from: z */
    public static void m71095z(boolean z10) {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent("com.huawei.android.hiphonefinder.action.FINISH_OPEN_PHONEFINDER"));
        C0209d.m1302r2(hiCloudSafeIntent, "com.huawei.android.findmyphone");
        hiCloudSafeIntent.putExtra("phonefinder_result", z10);
        m71007M().sendBroadcast(hiCloudSafeIntent, "com.huawei.android.findmyphone.permission.bussiness");
        f54895l = false;
    }

    /* renamed from: z0 */
    public static void m71096z0(Bundle bundle) {
        C13981a.m83989i("PhoneFinder", "handleMessage->phonefinderRemoteBindReportSuccess");
        Intent intent = new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_REMOTEBINDREPORT_SUCCESS");
        intent.putExtras(bundle);
        C13108a.m78878b(m71007M()).m78881d(intent);
    }
}
