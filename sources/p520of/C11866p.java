package p520of;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bf.C1175a;
import com.huawei.android.remotecontrol.config.ParamConfig;
import com.huawei.android.remotecontrol.http.C4344b;
import com.huawei.android.remotecontrol.http.C4347e;
import com.huawei.android.remotecontrol.util.account.bean.AccountInfo;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0241z;
import p521og.C11877j;
import p575qe.C12347f;
import p577qg.C12354d;
import p611rf.C12500h;
import p611rf.C12505m;
import p809yg.C13981a;
import pg.AbstractC12139d;

/* renamed from: of.p */
/* loaded from: classes4.dex */
public class C11866p {

    /* renamed from: a */
    public static boolean f54918a = false;

    /* renamed from: b */
    public static String f54919b;

    /* renamed from: d */
    public static void m71105d(Handler.Callback callback) {
        C13981a.m83989i("QueryDeviceActiveManager", "doQueryCurrentDeviceActive");
        Context contextM74301m = C12347f.m74285n().m74301m();
        m71114m(AbstractC12139d.m72766e(contextM74301m).getDeviceID(), AbstractC12139d.m72766e(contextM74301m).getDeviceType(), callback, false, "", 8).m75045o();
    }

    /* renamed from: e */
    public static boolean m71106e() {
        C13981a.m83989i("QueryDeviceActiveManager", "doQueryCurrentDeviceActive");
        Context contextM74301m = C12347f.m74285n().m74301m();
        return m71107f(AbstractC12139d.m72766e(contextM74301m).getDeviceID(), AbstractC12139d.m72766e(contextM74301m).getDeviceType(), 8);
    }

    /* renamed from: f */
    public static boolean m71107f(String str, String str2, int i10) throws InterruptedException {
        C13981a.m83989i("QueryDeviceActiveManager", "doQueryDeviceActiveByAccount");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        m71114m(str, str2, new Handler.Callback() { // from class: of.m
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return C11866p.m71121t(countDownLatch, message);
            }
        }, false, "", i10).m75045o();
        try {
            C13981a.m83989i("QueryDeviceActiveManager", "doQueryDeviceActiveByAccount wait:" + countDownLatch.await(5000L, TimeUnit.MILLISECONDS));
        } catch (Exception e10) {
            C13981a.m83988e("QueryDeviceActiveManager", "doQueryDeviceActiveByAccount Exception:" + e10.getMessage());
        }
        boolean zM71117p = m71117p();
        m71124w(false);
        C13981a.m83989i("QueryDeviceActiveManager", "doQueryDeviceActiveByAccount isActive: " + zM71117p);
        return zM71117p;
    }

    /* renamed from: g */
    public static void m71108g(Handler.Callback callback) {
        C13981a.m83989i("QueryDeviceActiveManager", "doQueryDeviceActive");
        Context contextM74301m = C12347f.m74285n().m74301m();
        m71114m(AbstractC12139d.m72766e(contextM74301m).getDeviceID(), AbstractC12139d.m72766e(contextM74301m).getDeviceType(), callback, false, "", 7).m75045o();
    }

    /* renamed from: h */
    public static void m71109h() {
        C13981a.m83989i("QueryDeviceActiveManager", "doQueryDeviceParams");
        Context contextM74301m = C12347f.m74285n().m74301m();
        String deviceID = AbstractC12139d.m72766e(contextM74301m).getDeviceID();
        String deviceType = AbstractC12139d.m72766e(contextM74301m).getDeviceType();
        if (TextUtils.isEmpty(deviceID) || TextUtils.isEmpty(deviceType)) {
            C13981a.m83988e("QueryDeviceActiveManager", "doQueryDeviceParams error, accountInfo empty");
        } else {
            m71114m(deviceID, deviceType, new Handler.Callback() { // from class: of.n
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    return C11866p.m71120s(message);
                }
            }, false, null, 1).m75045o();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0092  */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m71110i() throws org.json.JSONException, java.lang.InterruptedException {
        /*
            java.lang.String r0 = "QueryDeviceActiveManager"
            java.lang.String r1 = "doQueryLockScrChallenge"
            p809yg.C13981a.m83989i(r0, r1)
            java.util.concurrent.CountDownLatch r2 = new java.util.concurrent.CountDownLatch
            r3 = 1
            r2.<init>(r3)
            qe.f r4 = p575qe.C12347f.m74285n()
            android.content.Context r4 = r4.m74301m()
            com.huawei.android.remotecontrol.util.account.bean.AccountInfo r5 = pg.AbstractC12139d.m72766e(r4)
            java.lang.String r6 = r5.getDeviceID()
            com.huawei.android.remotecontrol.util.account.bean.AccountInfo r4 = pg.AbstractC12139d.m72766e(r4)
            java.lang.String r7 = r4.getDeviceType()
            java.lang.String r4 = "query lockScrChallenge"
            java.lang.String r5 = ""
            java.lang.String r12 = "QueryActiveStatus"
            p520of.C11860j.m71002J0(r1, r12, r4, r5)
            long r4 = java.lang.System.currentTimeMillis()
            of.o r8 = new of.o
            r8.<init>()
            java.lang.String r10 = ""
            r11 = 6
            r9 = 0
            rf.h r6 = m71114m(r6, r7, r8, r9, r10, r11)
            r6.m75045o()
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Exception -> L61
            r7 = 5000(0x1388, double:2.4703E-320)
            boolean r2 = r2.await(r7, r6)     // Catch: java.lang.Exception -> L61
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5f
            r6.<init>()     // Catch: java.lang.Exception -> L5f
            java.lang.String r7 = "doQueryLockScrChallenge wait:"
            r6.append(r7)     // Catch: java.lang.Exception -> L5f
            r6.append(r2)     // Catch: java.lang.Exception -> L5f
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L5f
            p809yg.C13981a.m83989i(r0, r6)     // Catch: java.lang.Exception -> L5f
            goto L7b
        L5f:
            r6 = move-exception
            goto L63
        L61:
            r6 = move-exception
            r2 = r3
        L63:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "doQueryLockScrChallenge Exception:"
            r7.append(r8)
            java.lang.String r6 = r6.getMessage()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            p809yg.C13981a.m83988e(r0, r6)
        L7b:
            java.lang.String r6 = m71113l()
            r7 = 0
            m71125x(r7)
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            java.lang.String r8 = "wait"
            r7.put(r8, r2)     // Catch: org.json.JSONException -> La1
            java.lang.String r2 = "challenge"
            if (r6 == 0) goto L92
            goto L93
        L92:
            r3 = 0
        L93:
            r7.put(r2, r3)     // Catch: org.json.JSONException -> La1
            java.lang.String r2 = "duringTime"
            long r8 = java.lang.System.currentTimeMillis()     // Catch: org.json.JSONException -> La1
            long r8 = r8 - r4
            r7.put(r2, r8)     // Catch: org.json.JSONException -> La1
            goto Lba
        La1:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "doQueryLockScrChallenge JSONException:"
            r3.append(r4)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            p809yg.C13981a.m83988e(r0, r2)
        Lba:
            java.lang.String r0 = "query lockScrChallenge result"
            java.lang.String r2 = r7.toString()
            p520of.C11860j.m71002J0(r1, r12, r0, r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p520of.C11866p.m71110i():java.lang.String");
    }

    /* renamed from: j */
    public static void m71111j(Handler.Callback callback) {
        C13981a.m83989i("QueryDeviceActiveManager", "doQueryPushDeviceParams");
        Context contextM74301m = C12347f.m74285n().m74301m();
        m71114m(AbstractC12139d.m72766e(contextM74301m).getDeviceID(), AbstractC12139d.m72766e(contextM74301m).getDeviceType(), callback, false, null, 1).m75045o();
    }

    /* renamed from: k */
    public static boolean m71112k(JSONObject jSONObject) {
        C13981a.m83989i("QueryDeviceActiveManager", "getActiveStatus");
        if (jSONObject == null) {
            return false;
        }
        try {
            return 1 == jSONObject.getInt("active");
        } catch (JSONException unused) {
            C13981a.m83988e("QueryDeviceActiveManager", "isActiveStatus JSONException");
            return false;
        }
    }

    /* renamed from: l */
    public static String m71113l() {
        return f54919b;
    }

    /* renamed from: m */
    public static C12500h m71114m(String str, String str2, Handler.Callback callback, boolean z10, String str3, int i10) {
        C13981a.m83989i("QueryDeviceActiveManager", "doQueryDeviceActive, sceneCode: " + i10);
        AccountInfo accountInfoM72766e = AbstractC12139d.m72766e(C12347f.m74285n().m74301m());
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C13981a.m83988e("QueryDeviceActiveManager", "doQueryDeviceActive, deviceId or deviceType empty");
        }
        if (!TextUtils.isEmpty(str3) && !str3.equals(accountInfoM72766e.getSiteID())) {
            accountInfoM72766e.setSiteID(str3);
        }
        return new C12500h(str, C0241z.m1685c(str2), callback, z10, i10);
    }

    /* renamed from: n */
    public static C12500h m71115n(boolean z10, String str, int i10) {
        Context contextM74301m = C12347f.m74285n().m74301m();
        AccountInfo accountInfoM72766e = AbstractC12139d.m72766e(contextM74301m);
        if (!TextUtils.isEmpty(str) && !str.equals(accountInfoM72766e.getSiteID())) {
            accountInfoM72766e.setSiteID(str);
        }
        return m71114m(accountInfoM72766e.getDeviceID(), accountInfoM72766e.getDeviceType(), new C4344b(SNSCode.Status.GET_USER_UNREAD_MSG_FAIL, i10, contextM74301m), z10, str, i10);
    }

    /* renamed from: o */
    public static JSONArray m71116o() {
        C13981a.m83989i("QueryDeviceActiveManager", "getReqSocId");
        if (C1175a.m7385g(false)) {
            C13981a.m83989i("QueryDeviceActiveManager", "has auth flag");
            return null;
        }
        JSONArray jSONArrayM7393o = C1175a.m7393o();
        if (jSONArrayM7393o == null) {
            C13981a.m83990w("QueryDeviceActiveManager", "socId is null");
            C11860j.m71002J0("SOC_ID_METHOD_NOT_FOUND", "QueryActiveStatus", "socId is null", "");
            return null;
        }
        if (jSONArrayM7393o.length() != 0 && !TextUtils.isEmpty(jSONArrayM7393o.toString())) {
            return jSONArrayM7393o;
        }
        C13981a.m83990w("QueryDeviceActiveManager", "socId is empty");
        C11860j.m71002J0("SOC_ID_EMPTY", "QueryActiveStatus", "socId is empty", "");
        return jSONArrayM7393o;
    }

    /* renamed from: p */
    public static boolean m71117p() {
        return f54918a;
    }

    /* renamed from: s */
    public static boolean m71120s(Message message) {
        C13981a.m83989i("QueryDeviceActiveManager", "onUpdateQueryParams");
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        if (iM1685c != 200) {
            C13981a.m83988e("QueryDeviceActiveManager", "onUpdateQueryParams error, result: " + iM1685c);
            return false;
        }
        String string = message.getData().getString("response_info");
        C13981a.m83987d("QueryDeviceActiveManager", "onUpdateQueryParams, responseInfo: " + string);
        int iM26233d = C4347e.m26233d(string);
        if (iM26233d != 0) {
            if (iM26233d != 401) {
                return true;
            }
            C13981a.m83989i("QueryDeviceActiveManager", "updateDeviceTicket: getParameter");
            new C12505m().m75087f();
            return false;
        }
        try {
            ParamConfig.getInstance().upDateParam((JSONObject) new JSONObject(string).get("params"));
            return true;
        } catch (JSONException e10) {
            C13981a.m83988e("QueryDeviceActiveManager", "onQueryResult:JSONException=" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: t */
    public static boolean m71121t(CountDownLatch countDownLatch, Message message) throws JSONException {
        C13981a.m83989i("QueryDeviceActiveManager", "parseRspActive");
        if (200 == C0241z.m1685c(message.getData().getString("result"))) {
            String string = message.getData().getString("response_info");
            C13981a.m83987d("QueryDeviceActiveManager", "doQueryDeviceActiveByAccount parseRspActive: " + string);
            int iM26233d = C4347e.m26233d(string);
            C13981a.m83989i("QueryDeviceActiveManager", "report code = " + iM26233d);
            if (iM26233d == 0) {
                try {
                    JSONObject jSONObject = new JSONObject(string).getJSONObject("params");
                    m71124w(m71112k(jSONObject));
                    C12354d.m74327C(jSONObject, "proactive");
                } catch (JSONException unused) {
                    C13981a.m83988e("QueryDeviceActiveManager", "request error");
                }
            }
        }
        countDownLatch.countDown();
        return true;
    }

    /* renamed from: u */
    public static boolean m71122u(CountDownLatch countDownLatch, Message message) {
        C13981a.m83989i("QueryDeviceActiveManager", "parseRspChallenge");
        if (200 == C0241z.m1685c(message.getData().getString("result"))) {
            String string = message.getData().getString("response_info");
            C13981a.m83987d("QueryDeviceActiveManager", "parseRspChallenge responseInfo: " + string);
            int iM26233d = C4347e.m26233d(string);
            C13981a.m83989i("QueryDeviceActiveManager", "report code = " + iM26233d);
            if (iM26233d == 0) {
                try {
                    m71125x(new JSONObject(string).getJSONObject("params").getString("lockScrChallenge"));
                    C11860j.m71002J0("doQueryLockScrChallenge", "QueryActiveStatus", "query lockScrChallenge response", "");
                } catch (JSONException unused) {
                    C13981a.m83988e("QueryDeviceActiveManager", "parseRspChallenge request error");
                }
            }
        }
        countDownLatch.countDown();
        return true;
    }

    /* renamed from: v */
    public static void m71123v(JSONObject jSONObject) {
        C13981a.m83989i("QueryDeviceActiveManager", "saveDomainName");
        try {
            if (!jSONObject.has("domainName")) {
                C13981a.m83989i("QueryDeviceActiveManager", "DomainName empty");
                return;
            }
            String string = jSONObject.getString("domainName");
            if (!jSONObject.has(HwPayConstant.KEY_SITE_ID)) {
                C13981a.m83989i("QueryDeviceActiveManager", "siteId empty");
                return;
            }
            String string2 = jSONObject.getString(HwPayConstant.KEY_SITE_ID);
            C13981a.m83989i("QueryDeviceActiveManager", "saveDomainName domain: " + string);
            Context contextM74301m = C12347f.m74285n().m74301m();
            C11877j.m71300r0(contextM74301m, "https://" + string);
            C11877j.m71303s0(contextM74301m, string2);
        } catch (JSONException unused) {
            C13981a.m83988e("QueryDeviceActiveManager", "saveDomainName params has not domain or siteId");
        }
    }

    /* renamed from: w */
    public static void m71124w(boolean z10) {
        f54918a = z10;
    }

    /* renamed from: x */
    public static void m71125x(String str) {
        f54919b = str;
    }
}
