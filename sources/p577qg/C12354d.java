package p577qg;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bf.C1175a;
import com.huawei.android.remotecontrol.http.C4347e;
import com.huawei.android.remotecontrol.p093ui.activation.CheckCredentialActivity;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.function.Consumer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p520of.C11860j;
import p520of.C11866p;
import p521og.C11868a;
import p521og.C11877j;
import p575qe.C12347f;
import p576qf.InterfaceC12348a;
import p611rf.C12493a;
import p611rf.C12501i;
import p611rf.C12502j;
import p664u0.C13108a;
import p809yg.C13981a;
import pg.AbstractC12139d;

/* renamed from: qg.d */
/* loaded from: classes4.dex */
public class C12354d {

    /* renamed from: a */
    public static String f57155a = "";

    /* renamed from: A */
    public static void m74325A(String str, String str2) throws JSONException {
        C13981a.m83987d("ActiveCredentialUtil", "reportSceneIdBi");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("issue_scene_detail", str);
            jSONObject.put("issue_mode", str2);
            jSONObject.put("issue_type", "passive");
        } catch (JSONException e10) {
            C13981a.m83988e("ActiveCredentialUtil", "reportCredentialBi JSONException:" + e10.getMessage());
        }
        C11860j.m71006L0("queryActivationLockCredential", "01072", "antiTheft call provider", jSONObject.toString());
    }

    /* renamed from: B */
    public static void m74326B(String str) {
        C13981a.m83989i("ActiveCredentialUtil", "saveCredential");
        try {
            m74327C(new JSONObject(str), "proactive");
        } catch (Exception unused) {
            C13981a.m83988e("ActiveCredentialUtil", "saveActivationCredential failed");
        }
    }

    /* renamed from: C */
    public static void m74327C(JSONObject jSONObject, String str) {
        C13981a.m83989i("ActiveCredentialUtil", "saveActivationCredential");
        try {
            JSONObject jSONObject2 = (JSONObject) jSONObject.opt("activationLockCredential");
            if (jSONObject2 == null) {
                C13981a.m83989i("ActiveCredentialUtil", "activationLockCredential is empty");
                m74355u("fail", str, "", "", "", "no credential");
                if ("passive".equals(str)) {
                    m74329E(1001, "");
                    return;
                }
                return;
            }
            final int iM26231b = C4347e.m26231b(jSONObject, "bypassTimes");
            C13981a.m83989i("ActiveCredentialUtil", "bypassTimes = " + iM26231b);
            if ("passive".equals(str)) {
                m74330F(1000, jSONObject2.toString(), iM26231b);
            } else {
                C1175a.m7397s(jSONObject2, new InterfaceC12348a() { // from class: qg.a
                    @Override // p576qf.InterfaceC12348a
                    public final void onResult(boolean z10) {
                        C12354d.m74349o(iM26231b, z10);
                    }
                });
            }
            m74355u("success", str, String.valueOf(iM26231b), C4347e.m26237h(jSONObject2, "version"), C4347e.m26237h(jSONObject2, "status"), "success");
        } catch (Exception e10) {
            C13981a.m83988e("ActiveCredentialUtil", "saveActivationCredential failed: " + e10.getMessage());
        }
    }

    /* renamed from: D */
    public static void m74328D(String str) {
        C13981a.m83989i("ActiveCredentialUtil", "saveActiveCredentialDomain");
        if (TextUtils.isEmpty(str)) {
            C13981a.m83989i("ActiveCredentialUtil", "saveActiveCredentialDomain, responseInfo is empty");
            return;
        }
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("params");
            if (jSONObjectOptJSONObject == null) {
                C13981a.m83988e("ActiveCredentialUtil", "saveActiveCredentialDomain, params is null");
                return;
            }
            String strOptString = jSONObjectOptJSONObject.optString("domainName");
            String strOptString2 = jSONObjectOptJSONObject.optString(HwPayConstant.KEY_SITE_ID);
            C13981a.m83987d("ActiveCredentialUtil", "saveActiveCredentialDomain, DomainName: " + strOptString + ", siteId: " + strOptString2);
            C11877j.m71294p0(strOptString);
            C11877j.m71297q0(strOptString2);
        } catch (JSONException e10) {
            C13981a.m83988e("ActiveCredentialUtil", "saveActiveCredentialDomain, Exception: " + e10.getMessage());
        }
    }

    /* renamed from: E */
    public static void m74329E(int i10, String str) {
        m74330F(i10, str, -1);
    }

    /* renamed from: F */
    public static void m74330F(int i10, String str, int i11) {
        C13981a.m83989i("ActiveCredentialUtil", "sendActiveTokenBroadCast errorCode:" + i10);
        Intent intent = new Intent("com.huawei.hicloud.phonefinder.GET_ACTIVE_TOKEN_RESULT");
        intent.putExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, String.valueOf(i10));
        intent.putExtra("token", str);
        intent.putExtra("bypassTimes", i11);
        C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
    }

    /* renamed from: G */
    public static void m74331G(String str) {
        f57155a = str;
    }

    /* renamed from: H */
    public static void m74332H() {
        C11868a.m71128d().m71130b(CheckCredentialActivity.class);
        Context contextM74301m = C12347f.m74285n().m74301m();
        Intent intent = new Intent(contextM74301m, (Class<?>) CheckCredentialActivity.class);
        intent.putExtra("showErrorPage", true);
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        contextM74301m.startActivity(intent);
    }

    /* renamed from: I */
    public static void m74333I() {
        C13981a.m83989i("ActiveCredentialUtil", "showNetworkErrorDialog");
        try {
            C11868a.m71128d().m71130b(CheckCredentialActivity.class);
            Context contextM74301m = C12347f.m74285n().m74301m();
            Intent intent = new Intent(contextM74301m, (Class<?>) CheckCredentialActivity.class);
            intent.putExtra("showNetworkError", true);
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            contextM74301m.startActivity(intent);
        } catch (Exception e10) {
            C13981a.m83988e("ActiveCredentialUtil", "showNetworkErrorDialog startActivity err:" + e10.getMessage());
        }
    }

    /* renamed from: J */
    public static void m74334J() {
        C11868a.m71128d().m71130b(CheckCredentialActivity.class);
        Context contextM74301m = C12347f.m74285n().m74301m();
        Intent intent = new Intent(contextM74301m, (Class<?>) CheckCredentialActivity.class);
        intent.putExtra("showTaErrorPage", true);
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        contextM74301m.startActivity(intent);
    }

    /* renamed from: d */
    public static void m74338d(String str, final Consumer<Boolean> consumer) {
        C13981a.m83989i("ActiveCredentialUtil", "checkActiveCredential");
        new C12493a(str, new Handler.Callback() { // from class: qg.c
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return C12354d.m74347m(consumer, message);
            }
        }).m74989c();
    }

    /* renamed from: e */
    public static String m74339e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.has("mobile") ? jSONObject.optString("mobile") : "";
            if (TextUtils.isEmpty(strOptString) && jSONObject.has("email")) {
                strOptString = jSONObject.optString("email");
            }
            return (TextUtils.isEmpty(strOptString) && jSONObject.has("petalMail")) ? jSONObject.optString("petalMail") : strOptString;
        } catch (JSONException e10) {
            C13981a.m83988e("ActiveCredentialUtil", "getAccountName, JSONException: " + e10.getMessage());
            return "";
        }
    }

    /* renamed from: f */
    public static boolean m74340f(String str) {
        C13981a.m83989i("ActiveCredentialUtil", "getActiveStatus");
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("params");
            if (jSONObjectOptJSONObject != null) {
                return 1 == jSONObjectOptJSONObject.getInt("active");
            }
            C13981a.m83988e("ActiveCredentialUtil", "getActiveStatus, params is null");
            return false;
        } catch (JSONException e10) {
            C13981a.m83988e("ActiveCredentialUtil", "getActiveStatus, JSONException: " + e10.getMessage());
            C13981a.m83989i("ActiveCredentialUtil", "getActiveStatus, status is false");
            return false;
        }
    }

    /* renamed from: g */
    public static JSONObject m74341g(String str) {
        C13981a.m83989i("ActiveCredentialUtil", "getParamsJsonObject");
        try {
            return new JSONObject(str).optJSONObject("params");
        } catch (Exception e10) {
            C13981a.m83988e("ActiveCredentialUtil", "getParamsJsonObject, JSONException: " + e10.getMessage());
            return new JSONObject();
        }
    }

    /* renamed from: h */
    public static String m74342h(String str) {
        JSONObject jSONObject;
        C13981a.m83989i("ActiveCredentialUtil", "getSiteIdFromSiteIdError");
        if (TextUtils.isEmpty(str)) {
            C13981a.m83989i("ActiveCredentialUtil", "getSiteIdFromSiteIdError, responseInfo is empty");
            return "";
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e10) {
            C13981a.m83988e("ActiveCredentialUtil", "getSiteIdFromSiteIdError, Exception: " + e10.getMessage());
        }
        if (!jSONObject.has(HwPayConstant.KEY_SITE_ID)) {
            C13981a.m83989i("ActiveCredentialUtil", "getSiteIdFromSiteIdError, siteId is empty");
            return "";
        }
        String strOptString = jSONObject.optString(HwPayConstant.KEY_SITE_ID);
        C13981a.m83989i("ActiveCredentialUtil", "getSiteIdFromSiteIdError, siteId: " + strOptString);
        if (!TextUtils.isEmpty(strOptString)) {
            C11877j.m71297q0(strOptString);
            return strOptString;
        }
        return "";
    }

    /* renamed from: i */
    public static void m74343i(String str, boolean z10) throws JSONException {
        C13981a.m83989i("ActiveCredentialUtil", "handleResponseQueryWithSocId");
        if (!m74340f(str)) {
            JSONObject jSONObjectM74341g = m74341g(str);
            if (m74345k(jSONObjectM74341g)) {
                m74327C(jSONObjectM74341g, "passive");
                return;
            }
            m74329E(1001, "");
            m74358x("fail", "query with socIdCert, no credential. isShowDialog: " + z10);
            return;
        }
        C13981a.m83989i("ActiveCredentialUtil", "handleResponseQueryWithSocId has active");
        Context contextM74301m = C12347f.m74285n().m74301m();
        try {
            JSONObject jSONObjectM74341g2 = m74341g(str);
            if (m74345k(jSONObjectM74341g2)) {
                m74327C(jSONObjectM74341g2, "passive");
                return;
            }
            if (!z10) {
                C13981a.m83989i("ActiveCredentialUtil", "handleResponseQueryWithSocId not showDialog");
                m74329E(1006, "");
                return;
            }
            if (jSONObjectM74341g2 == null) {
                C13981a.m83988e("ActiveCredentialUtil", "getActiveStatus, params is null");
                return;
            }
            String strM74339e = m74339e(jSONObjectM74341g2.optString("accountInfo"));
            C11868a.m71128d().m71130b(CheckCredentialActivity.class);
            Intent intent = new Intent(contextM74301m, (Class<?>) CheckCredentialActivity.class);
            intent.putExtra(JsbMapKeyNames.H5_USER_ID, jSONObjectM74341g2.optString(JsbMapKeyNames.H5_USER_ID));
            intent.putExtra("parentUid", jSONObjectM74341g2.optString("parentUid"));
            intent.putExtra(HwPayConstant.KEY_SITE_ID, jSONObjectM74341g2.optString(HwPayConstant.KEY_SITE_ID));
            intent.putExtra("deviceId", jSONObjectM74341g2.optString("deviceId"));
            intent.putExtra(JsbMapKeyNames.H5_DEVICE_TYPE, jSONObjectM74341g2.optString(JsbMapKeyNames.H5_DEVICE_TYPE));
            intent.putExtra("parentAccountName", jSONObjectM74341g2.optString("parentAccountName"));
            intent.putExtra("accountName", strM74339e);
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            contextM74301m.startActivity(intent);
        } catch (Exception unused) {
            C13981a.m83988e("ActiveCredentialUtil", "responseInfo JSONException");
        }
    }

    /* renamed from: j */
    public static void m74344j(String str, boolean z10) throws JSONException {
        C13981a.m83989i("ActiveCredentialUtil", "handleResponseQueryWithSocIdOrigin");
        boolean zM74340f = m74340f(str);
        JSONObject jSONObjectM74341g = m74341g(str);
        if (zM74340f) {
            if (m74345k(jSONObjectM74341g)) {
                m74327C(jSONObjectM74341g, "passive");
                return;
            } else if (z10) {
                m74332H();
                return;
            } else {
                C13981a.m83989i("ActiveCredentialUtil", "handleResponseQueryWithSocId not showDialog");
                m74329E(1007, "");
                return;
            }
        }
        if (m74345k(jSONObjectM74341g)) {
            m74327C(jSONObjectM74341g, "passive");
            return;
        }
        m74329E(1001, "");
        m74358x("fail", "query with socIdOrigin, no credential. isShowDialog: " + z10);
    }

    /* renamed from: k */
    public static boolean m74345k(JSONObject jSONObject) {
        C13981a.m83989i("ActiveCredentialUtil", "hasActiveCredential");
        try {
            JSONObject jSONObject2 = (JSONObject) jSONObject.opt("activationLockCredential");
            if (jSONObject2 == null) {
                C13981a.m83990w("ActiveCredentialUtil", "hasActiveCredential, credentialInfo is null");
                return false;
            }
            String strOptString = jSONObject2.optString("status");
            String strOptString2 = jSONObject2.optString("signature");
            if (strOptString.isEmpty() || strOptString2.isEmpty()) {
                C13981a.m83990w("ActiveCredentialUtil", "hasActiveCredential, credentialInfo is empty");
                return false;
            }
            C13981a.m83990w("ActiveCredentialUtil", "hasActiveCredential, has credentialInfo");
            return true;
        } catch (Exception e10) {
            C13981a.m83988e("ActiveCredentialUtil", "hasActiveCredential, JSONException: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: l */
    public static boolean m74346l(String str, String str2) {
        JSONObject jSONObjectM74341g;
        C13981a.m83989i("ActiveCredentialUtil", "isCrossSiteIdScene, siteId: " + str2);
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("ActiveCredentialUtil", "isCrossSiteIdScene responseInfo is empty");
            return false;
        }
        try {
            jSONObjectM74341g = m74341g(str);
        } catch (Exception e10) {
            C13981a.m83988e("ActiveCredentialUtil", "isCrossSiteIdScene Exception: " + e10.getMessage());
        }
        if (jSONObjectM74341g == null) {
            C13981a.m83988e("ActiveCredentialUtil", "isCrossSiteIdScene, paramsJsonObject is null");
            return false;
        }
        String strOptString = jSONObjectM74341g.optString(HwPayConstant.KEY_SITE_ID);
        if (!m74345k(jSONObjectM74341g) && !TextUtils.isEmpty(strOptString) && !TextUtils.equals(str2, strOptString)) {
            C13981a.m83989i("ActiveCredentialUtil", "isCrossSiteIdScene, siteId not match");
            return true;
        }
        return false;
    }

    /* renamed from: m */
    public static /* synthetic */ boolean m74347m(Consumer consumer, Message message) {
        return m74350p(message, consumer);
    }

    /* renamed from: n */
    public static /* synthetic */ boolean m74348n(boolean z10, String str, boolean z11, String str2, Message message) {
        return m74351q(message, z10, str, z11, str2);
    }

    /* renamed from: o */
    public static /* synthetic */ void m74349o(int i10, boolean z10) {
        if (!z10 || i10 <= 0) {
            return;
        }
        new C12502j().m75060a();
    }

    /* renamed from: p */
    public static boolean m74350p(Message message, Consumer<Boolean> consumer) throws JSONException {
        C13981a.m83989i("ActiveCredentialUtil", "parseCheckActiveCredential");
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        if (iM1685c != 200) {
            C13981a.m83988e("ActiveCredentialUtil", "parseCheckActiveCredential error, result: " + iM1685c);
            m74329E(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "");
            m74358x("fail", "parseCheckActiveCredential, result is " + iM1685c);
            consumer.accept(Boolean.FALSE);
            return false;
        }
        try {
            String string = message.getData().getString("response_info");
            C13981a.m83987d("ActiveCredentialUtil", "parseCheckActiveCredential, responseInfo: " + string);
            int iM26233d = C4347e.m26233d(string);
            C13981a.m83989i("ActiveCredentialUtil", "parseCheckActiveCredential, resultCode:" + iM26233d);
            if (iM26233d == 0) {
                JSONObject jSONObject = new JSONObject(string);
                if (m74345k(jSONObject)) {
                    m74327C(jSONObject, "passive");
                    C11877j.m71294p0("");
                    consumer.accept(Boolean.TRUE);
                } else {
                    m74358x("fail", "parseCheckActiveCredential, no credential");
                    m74329E(1009, "");
                    consumer.accept(Boolean.FALSE);
                }
            } else {
                m74358x("fail", "parseCheckActiveCredential resultCode is " + iM26233d);
                m74329E(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "");
                consumer.accept(Boolean.FALSE);
            }
            return true;
        } catch (Exception e10) {
            C13981a.m83989i("ActiveCredentialUtil", "parseCheckActiveCredential, Exception:" + e10.getMessage());
            consumer.accept(Boolean.FALSE);
            return true;
        }
    }

    /* renamed from: q */
    public static boolean m74351q(Message message, boolean z10, String str, boolean z11, String str2) throws JSONException {
        C13981a.m83989i("ActiveCredentialUtil", "parseQueryActiveCredential, isSocIdCert: " + z10);
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        if (iM1685c != 200) {
            C13981a.m83988e("ActiveCredentialUtil", "parseQueryActiveCredential error, result: " + iM1685c);
            if (!z11 || "1000".equals(str)) {
                m74329E(1002, "");
            } else {
                m74333I();
            }
            m74358x("fail", "parseQueryActiveCredential, result is " + iM1685c + ", isShowDialog: " + z11);
            return false;
        }
        String string = message.getData().getString("response_info");
        C13981a.m83987d("ActiveCredentialUtil", "parseQueryActiveCredential, responseInfo: " + string);
        int iM26233d = C4347e.m26233d(string);
        C13981a.m83989i("ActiveCredentialUtil", "parseQueryActiveCredential, resultCode: " + iM26233d);
        if (iM26233d == 0 || iM26233d == 3001) {
            if (!m74346l(string, str2)) {
                if (z10) {
                    m74343i(string, z11);
                    return true;
                }
                m74344j(string, z11);
                return true;
            }
            C13981a.m83989i("ActiveCredentialUtil", "parseQueryActiveCredential, siteId not match, request again");
            m74328D(string);
            String strM71272i = C11877j.m71272i();
            m74352r(z10, str, z11, strM71272i);
            m74358x(String.valueOf(iM26233d), "QueryActiveCredential resultCode,siteId:" + strM71272i + ", isShowDialog: " + z11);
            return false;
        }
        if (iM26233d == 3005 && z10) {
            m74352r(false, str, z11, null);
            m74358x("fail", "parseQueryActiveCredential resultCode is " + iM26233d + ", isShowDialog: " + z11);
            return true;
        }
        if (iM26233d != 14) {
            C13981a.m83988e("ActiveCredentialUtil", "parseQueryActiveCredential fail");
            m74329E(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "");
            m74358x("fail", "parseQueryActiveCredential resultCode is " + iM26233d + ", isShowDialog: " + z11);
            return false;
        }
        String strM74342h = m74342h(string);
        if (TextUtils.isEmpty(strM74342h) || TextUtils.equals(str2, strM74342h)) {
            return true;
        }
        C13981a.m83989i("ActiveCredentialUtil", "siteId not match, request again");
        m74352r(z10, str, z11, strM74342h);
        m74358x(String.valueOf(iM26233d), "QueryActiveCredential resultCode,siteId:" + strM74342h + ", isShowDialog: " + z11);
        return true;
    }

    /* renamed from: r */
    public static void m74352r(boolean z10, final String str, final boolean z11, final String str2) {
        JSONArray jSONArrayM71116o;
        C13981a.m83989i("ActiveCredentialUtil", "queryActiveCredential, siteId: " + str2);
        int i10 = 2;
        if (z10 && (jSONArrayM71116o = C11866p.m71116o()) != null && jSONArrayM71116o.length() != 0 && !TextUtils.isEmpty(jSONArrayM71116o.toString())) {
            i10 = 1;
        }
        Context contextM74301m = C12347f.m74285n().m74301m();
        if (TextUtils.isEmpty(str2)) {
            str2 = AbstractC12139d.m72766e(contextM74301m).getSiteID();
        }
        final boolean z12 = 1 == i10;
        C13981a.m83989i("ActiveCredentialUtil", "queryActiveCredential, hasSocId: " + z12 + ", sceneCode: " + i10 + ", siteId: " + str2);
        new C12501i(i10, str2, z11, new Handler.Callback() { // from class: qg.b
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return C12354d.m74348n(z12, str, z11, str2, message);
            }
        }).m75057h();
    }

    /* renamed from: s */
    public static void m74353s(String str) {
        C13981a.m83989i("ActiveCredentialUtil", "reportCredentialDamagedShow");
        C11860j.m71006L0("credentialDamageShow", "01072", str, "");
    }

    /* renamed from: t */
    public static void m74354t(String str) throws JSONException {
        C13981a.m83989i("ActiveCredentialUtil", "reportCredentialDialogShow");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("control_type", f57155a);
        } catch (JSONException e10) {
            C13981a.m83988e("ActiveCredentialUtil", "doQueryLockScrChallenge JSONException:" + e10.getMessage());
        }
        C11860j.m71006L0("checkCredentialDialogShow", "01072", str, jSONObject.toString());
    }

    /* renamed from: u */
    public static void m74355u(String str, String str2, String str3, String str4, String str5, String str6) throws JSONException {
        C13981a.m83989i("ActiveCredentialUtil", "reportParseCredential");
        String str7 = C0209d.m1203Q1(C0213f.m1377a()) ? "desktop" : "oobe";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("issue_result", str);
            jSONObject.put("issue_scene", str7);
            jSONObject.put("issue_type", str2);
            jSONObject.put("bypass_time", str3);
            jSONObject.put("lock_version", str4);
            jSONObject.put("status", str5);
        } catch (JSONException e10) {
            C13981a.m83988e("ActiveCredentialUtil", "doQueryLockScrChallenge JSONException:" + e10.getMessage());
        }
        C11860j.m71006L0("parseActivationLockCredential", "01072", str6, jSONObject.toString());
    }

    /* renamed from: v */
    public static void m74356v(String str, String str2, String str3) throws JSONException {
        C13981a.m83989i("ActiveCredentialUtil", "reportPasswordCheck");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("password_check_result", str2);
        } catch (JSONException e10) {
            C13981a.m83988e("ActiveCredentialUtil", "doQueryLockScrChallenge JSONException:" + e10.getMessage());
        }
        C11860j.m71006L0(str, "01072", str3, jSONObject.toString());
    }

    /* renamed from: w */
    public static void m74357w(String str, String str2, String str3, String str4) throws JSONException {
        C13981a.m83989i("ActiveCredentialUtil", "reportQueryCredential");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("issue_result", str);
            jSONObject.put("issue_scene", str3);
            jSONObject.put("issue_type", str2);
        } catch (JSONException e10) {
            C13981a.m83988e("ActiveCredentialUtil", "doQueryLockScrChallenge JSONException:" + e10.getMessage());
        }
        C11860j.m71006L0("queryActivationLockCredential", "01072", str4, jSONObject.toString());
    }

    /* renamed from: x */
    public static void m74358x(String str, String str2) throws JSONException {
        C13981a.m83989i("ActiveCredentialUtil", "reportQueryCredentialPassive");
        m74357w(str, "passive", "desktop", str2);
    }

    /* renamed from: y */
    public static void m74359y(String str, boolean z10) throws JSONException {
        C13981a.m83987d("ActiveCredentialUtil", "reportResultBi");
        m74360z(str, z10, "");
    }

    /* renamed from: z */
    public static void m74360z(String str, boolean z10, String str2) throws JSONException {
        C13981a.m83987d("ActiveCredentialUtil", "reportResultBi");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, str);
            jSONObject.put("token", String.valueOf(z10));
            jSONObject.put("issue_type", "passive");
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("callback_save_result", str2);
            }
        } catch (JSONException e10) {
            C13981a.m83988e("ActiveCredentialUtil", "reportResultBi JSONException:" + e10.getMessage());
        }
        C11860j.m71006L0("queryActivationLockCredential", "01072", "antiTheft call provider result", jSONObject.toString());
    }
}
