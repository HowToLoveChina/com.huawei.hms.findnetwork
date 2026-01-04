package bf;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import bf.AbstractC1177c;
import com.google.gson.Gson;
import com.huawei.android.remotecontrol.bluetooth.locate.AncillaryDeviceLocationInfo;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.controller.PhoneFinderEncryptData;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.android.remotecontrol.http.C4344b;
import com.huawei.android.remotecontrol.http.C4346d;
import com.huawei.android.remotecontrol.util.account.bean.AccountInfo;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.userk.bean.UserKeyBaseReq;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import eg.AbstractC9478g;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import p012ab.C0087b;
import p015ak.C0213f;
import p283fa.C9679b;
import p520of.C11860j;
import p521og.C11869b;
import p521og.C11870c;
import p521og.C11877j;
import p521og.C11881n;
import p576qf.InterfaceC12348a;
import p616rk.C12515a;
import p655te.C13009a;
import p709vj.C13452e;
import p772xe.C13781f;
import p774xg.C13811a;
import p809yg.C13981a;
import pg.AbstractC12139d;
import se.C12791m;
import sg.C12797b;

/* renamed from: bf.c */
/* loaded from: classes4.dex */
public abstract class AbstractC1177c {

    /* renamed from: j */
    public static final Gson f5578j = new Gson();

    /* renamed from: k */
    public static String f5579k;

    /* renamed from: a */
    public Context f5580a;

    /* renamed from: b */
    public PushCmdParser f5581b;

    /* renamed from: d */
    public Object f5583d;

    /* renamed from: e */
    public String f5584e;

    /* renamed from: i */
    public boolean f5588i;

    /* renamed from: f */
    public int f5585f = 0;

    /* renamed from: g */
    public String f5586g = "";

    /* renamed from: h */
    public int f5587h = -1;

    /* renamed from: c */
    public int f5582c = 0;

    /* renamed from: bf.c$a */
    public class a extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ String f5589a;

        /* renamed from: b */
        public final /* synthetic */ JSONObject f5590b;

        /* renamed from: c */
        public final /* synthetic */ Context f5591c;

        /* renamed from: d */
        public final /* synthetic */ String f5592d;

        /* renamed from: e */
        public final /* synthetic */ int f5593e;

        /* renamed from: f */
        public final /* synthetic */ long f5594f;

        /* renamed from: g */
        public final /* synthetic */ Handler.Callback f5595g;

        /* renamed from: h */
        public final /* synthetic */ String f5596h;

        public a(String str, JSONObject jSONObject, Context context, String str2, int i10, long j10, Handler.Callback callback, String str3) {
            this.f5589a = str;
            this.f5590b = jSONObject;
            this.f5591c = context;
            this.f5592d = str2;
            this.f5593e = i10;
            this.f5594f = j10;
            this.f5595g = callback;
            this.f5596h = str3;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            JSONObject jSONObject;
            C13981a.m83989i("ControlObject", "handleControlResult operation = " + this.f5589a);
            if ("locate".equals(this.f5589a) && (jSONObject = this.f5590b) != null) {
                try {
                    jSONObject.put("isLockScreen", C13811a.m82820q(this.f5591c));
                } catch (JSONException unused) {
                    C13981a.m83988e("ControlObject", "getLockScreen JSONObject fail");
                }
            }
            JSONObject jSONObjectM7414n = AbstractC1177c.m7414n(this.f5589a, this.f5592d, this.f5593e, this.f5590b, this.f5594f, this.f5591c);
            if (jSONObjectM7414n != null) {
                String string = jSONObjectM7414n.toString();
                RequestModeConfig.getInstance().setMode(Integer.valueOf(AbstractC1177c.m7415v(this.f5589a)), false);
                C4346d.m26226e(AbstractC1177c.m7415v(this.f5589a), string, this.f5595g, this.f5591c, this.f5596h);
            }
        }
    }

    /* renamed from: bf.c$b */
    public class b extends AbstractC9478g {
        public b() {
        }

        /* renamed from: d */
        public static /* synthetic */ void m7442d(boolean z10) {
            if (z10) {
                return;
            }
            C11860j.m71010N0("updateUserKey retry");
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C13981a.m83989i("ControlObject", "begin to get userKey again");
            try {
                byte[] userKey = new C0087b(C9679b.m60452d().m60455e()).m680c(AbstractC1177c.this.f5581b.getTraceID(), 10, UserKeyBaseReq.KEY_TYPE_AES_128).getUserKey();
                if (userKey != null) {
                    AbstractC12139d.m72766e(AbstractC1177c.this.f5580a).setUserKey(new String(Base64.encode(userKey, 0), Constants.UTF_8));
                    if (C1175a.m7389k(C0213f.m1377a())) {
                        AbstractC12139d.m72772k(AbstractC1177c.this.f5580a.getApplicationContext(), new InterfaceC12348a() { // from class: bf.d
                            @Override // p576qf.InterfaceC12348a
                            public final void onResult(boolean z10) {
                                AbstractC1177c.b.m7442d(z10);
                            }
                        });
                    }
                } else {
                    C13981a.m83988e("ControlObject", "getUserKey is empty again");
                }
            } catch (Exception e10) {
                C13981a.m83988e("ControlObject", "getUserKey again error," + e10.getMessage());
            }
        }
    }

    /* renamed from: bf.c$c */
    public class c extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ String f5598a;

        /* renamed from: b */
        public final /* synthetic */ long f5599b;

        /* renamed from: c */
        public final /* synthetic */ String f5600c;

        /* renamed from: d */
        public final /* synthetic */ int f5601d;

        /* renamed from: e */
        public final /* synthetic */ Object f5602e;

        /* renamed from: f */
        public final /* synthetic */ long f5603f;

        /* renamed from: g */
        public final /* synthetic */ Context f5604g;

        /* renamed from: h */
        public final /* synthetic */ Handler.Callback f5605h;

        /* renamed from: i */
        public final /* synthetic */ String f5606i;

        public c(String str, long j10, String str2, int i10, Object obj, long j11, Context context, Handler.Callback callback, String str3) {
            this.f5598a = str;
            this.f5599b = j10;
            this.f5600c = str2;
            this.f5601d = i10;
            this.f5602e = obj;
            this.f5603f = j11;
            this.f5604g = context;
            this.f5605h = callback;
            this.f5606i = str3;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            C13981a.m83989i("ControlObject", "ReportTask excute with operation:" + this.f5598a + ",taskId:" + this.f5599b);
            JSONObject jSONObjectM7414n = AbstractC1177c.m7414n(this.f5598a, this.f5600c, this.f5601d, this.f5602e, this.f5603f, this.f5604g);
            if (jSONObjectM7414n != null) {
                AbstractC1177c.this.f5584e = jSONObjectM7414n.toString();
                RequestModeConfig.getInstance().setMode(Integer.valueOf(AbstractC1177c.m7415v(this.f5598a)), false);
                C4346d.m26226e(AbstractC1177c.m7415v(this.f5598a), AbstractC1177c.this.f5584e, this.f5605h, this.f5604g, this.f5606i);
            }
        }
    }

    /* renamed from: bf.c$d */
    public static class d implements Handler.Callback {

        /* renamed from: a */
        public Handler.Callback f5608a;

        /* renamed from: b */
        public PushCmdParser f5609b;

        /* renamed from: c */
        public int f5610c;

        /* renamed from: d */
        public Context f5611d;

        public d(Handler.Callback callback, PushCmdParser pushCmdParser, int i10, Context context) {
            this.f5608a = callback;
            this.f5609b = pushCmdParser;
            this.f5610c = i10;
            this.f5611d = context;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Handler.Callback callback = this.f5608a;
            if (callback != null) {
                callback.handleMessage(message);
            }
            C13981a.m83989i("ControlObject", "operation :" + this.f5609b.getOperation() + ", errcode :" + this.f5610c);
            return false;
        }
    }

    public AbstractC1177c(PushCmdParser pushCmdParser, Context context) {
        this.f5580a = context;
        this.f5581b = pushCmdParser;
    }

    /* renamed from: B */
    public static void m7401B(Context context, int i10, PushCmdParser pushCmdParser, JSONObject jSONObject, Handler.Callback callback) {
        if (pushCmdParser == null) {
            C13981a.m83988e("ControlObject", "parser null");
        } else {
            m7402C(context, i10, pushCmdParser.getOperation(), pushCmdParser.getSessionId(), pushCmdParser.getTraceID(), jSONObject, callback);
        }
    }

    /* renamed from: C */
    public static void m7402C(Context context, int i10, String str, String str2, String str3, JSONObject jSONObject, Handler.Callback callback) {
        C12515a.m75110o().m75175e(new a(str, jSONObject, context, str2, i10, System.currentTimeMillis(), callback, str3), false);
    }

    /* renamed from: F */
    public static /* synthetic */ void m7403F(boolean z10) {
        if (z10) {
            return;
        }
        C11860j.m71010N0("updateUserKey location");
    }

    /* renamed from: N */
    public static void m7404N(PushCmdParser pushCmdParser, Context context) {
        m7401B(context, 4, pushCmdParser, null, new C4344b(3114, 4, pushCmdParser == null ? "" : pushCmdParser.getOperation(), context));
    }

    /* renamed from: O */
    public static void m7405O(PushCmdParser pushCmdParser, Context context) {
        m7401B(context, 5, pushCmdParser, null, new C4344b(3114, 5, pushCmdParser == null ? "" : pushCmdParser.getOperation(), context));
    }

    /* renamed from: R */
    public static void m7406R(PushCmdParser pushCmdParser, Context context) {
        m7401B(context, 9, pushCmdParser, null, new C4344b(3114, 9, pushCmdParser == null ? "" : pushCmdParser.getOperation(), context));
    }

    /* renamed from: S */
    public static void m7407S(PushCmdParser pushCmdParser, Context context) throws JSONException {
        JSONObject jSONObject;
        String operation = pushCmdParser == null ? "" : pushCmdParser.getOperation();
        if ("perDevicelocate".equals(operation)) {
            AncillaryDeviceLocationInfo ancillaryDeviceLocationInfo = new AncillaryDeviceLocationInfo();
            ancillaryDeviceLocationInfo.setOperationType("perDevicelocate");
            String cmdParamValue = pushCmdParser.getCmdParamValue("cptList");
            String cmdParamValue2 = pushCmdParser.getCmdParamValue("perDeviceType");
            ancillaryDeviceLocationInfo.setCptList(cmdParamValue);
            new C13781f(ErrorCode.ERROR_REWARD_AD_NO, System.currentTimeMillis(), pushCmdParser.getCmdParamValue("perDeviceId"), cmdParamValue, cmdParamValue2, context, ancillaryDeviceLocationInfo, pushCmdParser.getTraceID(), null, new d(null, pushCmdParser, ErrorCode.ERROR_REWARD_AD_NO, context)).m82741i();
            return;
        }
        if ("perDevicebell".equals(operation) || "cancelPerDevicebell".equals(operation)) {
            new C12791m(context, 3032, ErrorCode.ERROR_REWARD_AD_NO, pushCmdParser, pushCmdParser.getCmdParamValue("cptList"), operation, new d(null, pushCmdParser, ErrorCode.ERROR_REWARD_AD_NO, context)).m76759h();
            return;
        }
        if ("perDeviceInactive".equals(operation)) {
            C13981a.m83989i("ControlObject", "Receive cmd: ancillary device inactive");
            return;
        }
        if ("locate".equals(pushCmdParser.getOperation())) {
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("batteryStatus", C13811a.m82816m(context));
                } catch (JSONException unused) {
                    C13981a.m83988e("ControlObject", "JSONObject fail");
                    m7413l(C0213f.m1377a());
                    m7401B(context, ErrorCode.ERROR_REWARD_AD_NO, pushCmdParser, jSONObject, new d(null, pushCmdParser, ErrorCode.ERROR_REWARD_AD_NO, context));
                }
            } catch (JSONException unused2) {
                jSONObject = null;
            }
            m7413l(C0213f.m1377a());
        } else {
            jSONObject = null;
        }
        m7401B(context, ErrorCode.ERROR_REWARD_AD_NO, pushCmdParser, jSONObject, new d(null, pushCmdParser, ErrorCode.ERROR_REWARD_AD_NO, context));
    }

    /* renamed from: T */
    public static void m7408T(PushCmdParser pushCmdParser, Context context) {
        m7401B(context, 104, pushCmdParser, null, new C4344b(3114, 104, pushCmdParser == null ? "" : pushCmdParser.getOperation(), context));
    }

    /* renamed from: U */
    public static void m7409U(PushCmdParser pushCmdParser, Context context) {
        m7401B(context, 6, pushCmdParser, null, new C4344b(3114, 6, pushCmdParser == null ? "" : pushCmdParser.getOperation(), context));
    }

    /* renamed from: l */
    public static void m7413l(Context context) {
        if (C11877j.m71204E(context)) {
            C13981a.m83989i("ControlObject", "checkLostMode need report cache result");
            int iM71299r = C11877j.m71299r(context);
            m7402C(context, iM71299r, "openLostPattern", "", "", null, new C4344b(3114, iM71299r, "openLostPattern", context));
        }
    }

    /* renamed from: n */
    public static JSONObject m7414n(String str, String str2, int i10, Object obj, long j10, Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            AccountInfo accountInfoM72766e = AbstractC12139d.m72766e(context);
            jSONObject.put("operation", str);
            jSONObject.put("sessionID", str2);
            jSONObject.put("result", i10);
            jSONObject.put("deviceID", accountInfoM72766e.getDeviceID());
            jSONObject.put(JsbMapKeyNames.H5_DEVICE_TYPE, accountInfoM72766e.getDeviceType());
            jSONObject.put("deviceTicket", C11870c.m71153a(accountInfoM72766e.getDeviceTicket()));
            jSONObject.put("serviceToken", C11870c.m71155c(accountInfoM72766e.getServiceToken()));
            if (context != null && "com.huawei.hidisk".equals(context.getPackageName())) {
                jSONObject.put("appType", 2);
            } else if (context == null || !"com.huawei.android.ds".equals(context.getPackageName())) {
                jSONObject.put("appType", 1);
            } else {
                jSONObject.put("appType", 0);
            }
            jSONObject.put("reportTime", j10);
            if (obj != null) {
                jSONObject.put("info", obj);
            }
            if (StringUtil.equals(str, "locate")) {
                C13981a.m83989i("ControlObject", "set clientStatus:" + f5579k);
                jSONObject.put("clientStatus", f5579k);
            }
            jSONObject.put("version", "v11");
            return jSONObject;
        } catch (JSONException unused) {
            C13981a.m83988e("ControlObject", "encaseControlResult JSONException");
            return null;
        }
    }

    /* renamed from: v */
    public static int m7415v(String str) {
        return "shareLocate".equals(str) ? 4 : 3;
    }

    /* renamed from: A */
    public void m7416A(long j10, Handler.Callback callback) {
        m7418E(new d(callback, this.f5581b, this.f5582c, this.f5580a), this.f5581b, this.f5582c, this.f5583d, j10, this.f5580a);
    }

    /* renamed from: D */
    public void m7417D(Handler.Callback callback) {
        m7418E(new d(callback, this.f5581b, this.f5582c, this.f5580a), this.f5581b, this.f5582c, this.f5583d, System.currentTimeMillis(), this.f5580a);
    }

    /* renamed from: E */
    public final void m7418E(Handler.Callback callback, PushCmdParser pushCmdParser, int i10, Object obj, long j10, Context context) {
        if (pushCmdParser == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String operation = pushCmdParser.getOperation();
        String sessionId = pushCmdParser.getSessionId();
        String traceID = pushCmdParser.getTraceID();
        C13981a.m83989i("ControlObject", "handleNormalControlResult with operation:" + operation + ",taskId:" + jCurrentTimeMillis + ", result: " + i10);
        C12515a.m75110o().m75175e(new c(operation, jCurrentTimeMillis, sessionId, i10, obj, j10, context, callback, traceID), false);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ReportTask addto threadpool by taskId:");
        sb2.append(jCurrentTimeMillis);
        C13981a.m83989i("ControlObject", sb2.toString());
    }

    /* renamed from: G */
    public void m7419G() {
        this.f5588i = true;
    }

    /* renamed from: H */
    public void m7420H() {
        this.f5586g = "[PowerLowMode]";
    }

    /* renamed from: I */
    public void m7421I() {
        this.f5586g = "[ShareLocate]";
    }

    /* renamed from: J */
    public boolean mo7422J() {
        return true;
    }

    /* renamed from: K */
    public final void m7423K() {
        new C12797b().m76784j(this.f5580a, "ControlObject", "001_3005", this.f5586g + "userKey is empty,encrypt or decrypt error", null, this.f5581b.getOperation(), this.f5581b.getTraceID(), "getUserKey", false);
        if (C1175a.m7389k(this.f5580a) && C13452e.m80781L().m80842P0() && C13452e.m80781L().m80971t0().equals(AbstractC12139d.m72766e(this.f5580a).getUserID())) {
            C12515a.m75110o().m75175e(new b(), true);
        }
    }

    /* renamed from: L */
    public void m7424L(String str, int i10, int i11) {
        String strM80790C = C13452e.m80781L().m80790C();
        Context context = this.f5580a;
        C13009a.m78307b(context, str, C13009a.m78311f(context, this.f5581b.getTraceID(), i10, i11), strM80790C);
        UBAAnalyze.m29946G("CKP", "HUAWEICLOUD", str, C13009a.m78311f(this.f5580a, this.f5581b.getTraceID(), i10, i11), strM80790C);
    }

    /* renamed from: M */
    public void m7425M() {
        m7404N(this.f5581b, this.f5580a);
    }

    /* renamed from: P */
    public void m7426P(String str, String str2, int i10, int i11, String str3, int i12, String str4, String str5, String str6, boolean z10) {
        m7424L(str2, i10, i11);
        m7427Q(str, str3, i12, str4, null, str5, str6, z10, null);
    }

    /* renamed from: Q */
    public void m7427Q(String str, String str2, int i10, String str3, String str4, String str5, String str6, boolean z10, LinkedHashMap<String, String> linkedHashMap) {
        C12797b c12797b = new C12797b();
        if (linkedHashMap != null) {
            Context context = this.f5580a;
            PushCmdParser pushCmdParser = this.f5581b;
            c12797b.m76785k(context, str, str2, str3, str4, str5, pushCmdParser != null ? pushCmdParser.getTraceID() : null, str6, z10, linkedHashMap);
        } else if (i10 == -1) {
            Context context2 = this.f5580a;
            PushCmdParser pushCmdParser2 = this.f5581b;
            c12797b.m76784j(context2, str, str2, str3, str4, str5, pushCmdParser2 != null ? pushCmdParser2.getTraceID() : null, str6, z10);
        } else {
            Context context3 = this.f5580a;
            PushCmdParser pushCmdParser3 = this.f5581b;
            c12797b.m76782h(context3, str, str2, i10, str3, str4, str5, pushCmdParser3 != null ? pushCmdParser3.getTraceID() : null, str6, z10);
        }
    }

    /* renamed from: V */
    public void m7428V(int i10) {
        this.f5587h = i10;
    }

    /* renamed from: m */
    public String m7429m(String str, int i10) {
        if (i10 != 1 || TextUtils.isEmpty(str)) {
            C13981a.m83990w("ControlObject", "data is empty or isCrypt = 0");
            return str;
        }
        try {
            PhoneFinderEncryptData phoneFinderEncryptData = (PhoneFinderEncryptData) f5578j.fromJson(URLDecoder.decode(str, Constants.UTF_8), PhoneFinderEncryptData.class);
            String userKey = AbstractC12139d.m72766e(this.f5580a).getUserKey();
            if (TextUtils.isEmpty(userKey)) {
                C13981a.m83988e("ControlObject", "decryptData userKey is empty");
                m7423K();
                return "";
            }
            String strM71138e = C11869b.m71138e(phoneFinderEncryptData, C11881n.m71352b(userKey));
            if (TextUtils.isEmpty(strM71138e)) {
                m7430o("decrypt data error");
            }
            return strM71138e;
        } catch (Exception e10) {
            C13981a.m83988e("ControlObject", "fromJson PhoneFinderEncryptData exception" + e10.getMessage());
            return "";
        }
    }

    /* renamed from: o */
    public final void m7430o(String str) {
        new C12797b().m76784j(this.f5580a, "ControlObject", "001_3006", this.f5586g + " " + str, null, this.f5581b.getOperation(), this.f5581b.getTraceID(), "encryptError", false);
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b4  */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m7431p(java.lang.String r8) {
        /*
            r7 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            java.lang.String r1 = ""
            java.lang.String r2 = "ControlObject"
            if (r0 == 0) goto L10
            java.lang.String r7 = "encryptData: data is empty"
            p809yg.C13981a.m83988e(r2, r7)
            return r1
        L10:
            android.content.Context r0 = r7.f5580a
            com.huawei.android.remotecontrol.util.account.bean.AccountInfo r0 = pg.AbstractC12139d.m72766e(r0)
            java.lang.String r0 = r0.getUserKey()
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto La8
            java.lang.String r3 = "encryptData userKey is empty"
            p809yg.C13981a.m83988e(r2, r3)
            ab.b r3 = new ab.b     // Catch: java.lang.Exception -> L85
            fa.b r4 = p283fa.C9679b.m60452d()     // Catch: java.lang.Exception -> L85
            ab.a r4 = r4.m60455e()     // Catch: java.lang.Exception -> L85
            r3.<init>(r4)     // Catch: java.lang.Exception -> L85
            com.huawei.android.remotecontrol.controller.cmd.PushCmdParser r4 = r7.f5581b     // Catch: java.lang.Exception -> L85
            java.lang.String r4 = r4.getTraceID()     // Catch: java.lang.Exception -> L85
            java.lang.String r5 = "AES_128"
            r6 = 10
            com.huawei.android.hicloud.security.bean.UserKeyObject r3 = r3.m680c(r4, r6, r5)     // Catch: java.lang.Exception -> L85
            byte[] r3 = r3.getUserKey()     // Catch: java.lang.Exception -> L85
            if (r3 == 0) goto L89
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Exception -> L85
            r5 = 0
            byte[] r3 = android.util.Base64.encode(r3, r5)     // Catch: java.lang.Exception -> L85
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Exception -> L85
            r4.<init>(r3, r5)     // Catch: java.lang.Exception -> L85
            android.content.Context r0 = r7.f5580a     // Catch: java.lang.Exception -> L83
            com.huawei.android.remotecontrol.util.account.bean.AccountInfo r0 = pg.AbstractC12139d.m72766e(r0)     // Catch: java.lang.Exception -> L83
            r0.setUserKey(r4)     // Catch: java.lang.Exception -> L83
            android.content.Context r0 = p015ak.C0213f.m1377a()     // Catch: java.lang.Exception -> L83
            boolean r0 = bf.C1175a.m7389k(r0)     // Catch: java.lang.Exception -> L83
            if (r0 == 0) goto La7
            android.content.Context r0 = r7.f5580a     // Catch: java.lang.Exception -> L83
            com.huawei.android.remotecontrol.util.account.bean.AccountInfo r0 = pg.AbstractC12139d.m72766e(r0)     // Catch: java.lang.Exception -> L83
            java.lang.String r0 = r0.getDeviceID()     // Catch: java.lang.Exception -> L83
            java.lang.String r3 = "report network info, update User Key"
            p520of.C11860j.m71000I0(r0, r3)     // Catch: java.lang.Exception -> L83
            android.content.Context r0 = r7.f5580a     // Catch: java.lang.Exception -> L83
            android.content.Context r0 = r0.getApplicationContext()     // Catch: java.lang.Exception -> L83
            bf.b r3 = new bf.b     // Catch: java.lang.Exception -> L83
            r3.<init>()     // Catch: java.lang.Exception -> L83
            pg.AbstractC12139d.m72772k(r0, r3)     // Catch: java.lang.Exception -> L83
            goto La7
        L83:
            r0 = move-exception
            goto L8f
        L85:
            r3 = move-exception
            r4 = r0
            r0 = r3
            goto L8f
        L89:
            java.lang.String r3 = "getUserKey is empty again"
            p809yg.C13981a.m83988e(r2, r3)     // Catch: java.lang.Exception -> L85
            goto La8
        L8f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "getUserKey again error,"
            r3.append(r5)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            p809yg.C13981a.m83988e(r2, r0)
        La7:
            r0 = r4
        La8:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto Lb4
            java.lang.String r7 = "reTryGetUserKey, userKey is empty"
            p809yg.C13981a.m83988e(r2, r7)
            return r1
        Lb4:
            byte[] r0 = p521og.C11881n.m71352b(r0)
            com.huawei.android.remotecontrol.controller.PhoneFinderEncryptData r0 = p521og.C11869b.m71144k(r8, r0)
            if (r0 == 0) goto Lc5
            com.google.gson.Gson r7 = bf.AbstractC1177c.f5578j
            java.lang.String r7 = r7.toJson(r0)
            return r7
        Lc5:
            java.lang.String r0 = "encrypt data error"
            r7.m7430o(r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: bf.AbstractC1177c.m7431p(java.lang.String):java.lang.String");
    }

    /* renamed from: q */
    public String m7432q(String str) {
        if (C11881n.m71338A(this.f5580a)) {
            String userKey = AbstractC12139d.m72766e(this.f5580a).getUserKey();
            if (TextUtils.isEmpty(userKey)) {
                C13981a.m83988e("ControlObject", "encryptData userKey is empty");
                m7423K();
                return "";
            }
            PhoneFinderEncryptData phoneFinderEncryptDataM71144k = C11869b.m71144k(str, C11881n.m71352b(userKey));
            if (phoneFinderEncryptDataM71144k != null) {
                return f5578j.toJson(phoneFinderEncryptDataM71144k);
            }
            m7430o("encrypt data error");
        }
        return str;
    }

    /* renamed from: r */
    public int m7433r() {
        return this.f5587h;
    }

    /* renamed from: s */
    public boolean m7434s(String str) {
        PushCmdParser pushCmdParser = this.f5581b;
        if (pushCmdParser != null) {
            return pushCmdParser.getBooleanVal(str);
        }
        return false;
    }

    /* renamed from: t */
    public String m7435t(JSONObject jSONObject, String str) {
        if (!jSONObject.has(str)) {
            return "";
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException e10) {
            C13981a.m83988e("ControlObject", "getFromJson error:" + e10.getMessage());
            return "";
        }
    }

    /* renamed from: u */
    public JSONObject m7436u(String str) {
        PushCmdParser pushCmdParser = this.f5581b;
        if (pushCmdParser != null) {
            return pushCmdParser.getJsonObj(str);
        }
        return null;
    }

    /* renamed from: w */
    public String m7437w() {
        PushCmdParser pushCmdParser = this.f5581b;
        return pushCmdParser != null ? pushCmdParser.getPushCmd() : "";
    }

    /* renamed from: x */
    public int m7438x(String str) throws JSONException {
        int i10 = 1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(MapKeyNames.RESULT_CODE)) {
                i10 = jSONObject.getInt(MapKeyNames.RESULT_CODE);
            } else {
                C13981a.m83988e("ControlObject", "getResultCode->json has no resultCode");
            }
        } catch (JSONException unused) {
            C13981a.m83988e("ControlObject", "getResultCode JSONException");
        }
        return i10;
    }

    /* renamed from: y */
    public String m7439y(String str) {
        try {
            return m7435t(new JSONObject(str), "resultDesc");
        } catch (JSONException unused) {
            C13981a.m83988e("ControlObject", "getResultCode JSONException");
            return "";
        }
    }

    /* renamed from: z */
    public abstract void mo7440z();
}
