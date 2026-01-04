package com.huawei.android.remotecontrol.http;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.offlinelocate.bean.OfflineLocateResponse;
import com.huawei.android.remotecontrol.sharing.bean.FriendInfo;
import com.huawei.android.remotecontrol.sharing.bean.QueryLocateResponse;
import com.huawei.android.remotecontrol.sharing.bean.ShareGrantGetResponse;
import com.huawei.android.remotecontrol.sharing.bean.ShareGrantInfo;
import com.huawei.android.remotecontrol.sharing.bean.SystemConfigResponse;
import com.huawei.android.remotecontrol.tag.bean.TagBindResponse;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.secure.android.common.util.SafeBase64;
import fk.C9721b;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.LinkedHashMap;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p521og.C11877j;
import p681uj.C13195l;
import p809yg.C13981a;
import ro.C12612a;
import sg.C12797b;

/* loaded from: classes4.dex */
public class PhoneFinderServer {

    /* renamed from: b */
    public static final Gson f19814b = new Gson();

    /* renamed from: a */
    public Context f19815a;

    public PhoneFinderServer(Context context) {
        this.f19815a = context;
    }

    /* renamed from: e */
    public static byte[] m26190e(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(bArr2);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(2, keyFactory.generatePrivate(pKCS8EncodedKeySpec), new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
            return cipher.doFinal(bArr);
        } catch (Exception e10) {
            C13981a.m83988e("PhoneFinderServer", "decrypt Exception: " + e10.getMessage());
            return new byte[0];
        }
    }

    /* renamed from: a */
    public int m26191a(FriendInfo friendInfo) throws JSONException, C9721b {
        if (friendInfo == null) {
            return 1;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("friendInfo", new JSONObject(friendInfo.toString()));
        } catch (JSONException e10) {
            C13981a.m83988e("PhoneFinderServer", "addFriend JSONObject exception:" + e10.getMessage());
        }
        RequestModeConfig.getInstance().setMode(3086, true);
        String strM26207r = m26207r(C12797b.m76774a("01038"), jSONObject.toString(), 3086, "/RemoteControl/Client/Friend/Add");
        if (TextUtils.isEmpty(strM26207r)) {
            C13981a.m83988e("PhoneFinderServer", "addFriend responseInfo is null");
            return 1;
        }
        BaseResponse baseResponse = (BaseResponse) m26197h(strM26207r, BaseResponse.class);
        if (baseResponse != null) {
            return baseResponse.resultCode;
        }
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x003e A[Catch: b -> 0x003c, TRY_LEAVE, TryCatch #0 {b -> 0x003c, blocks: (B:29:0x0027, B:31:0x002d, B:33:0x0033, B:36:0x003e), top: B:46:0x0027 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m26192b(java.lang.String r6) {
        /*
            r5 = this;
            vj.e r0 = p709vj.C13452e.m80781L()
            boolean r0 = r0.m80842P0()
            android.content.Context r1 = r5.f19815a
            boolean r1 = bf.C1175a.m7389k(r1)
            android.content.Context r5 = r5.f19815a
            com.huawei.android.remotecontrol.util.account.bean.AccountInfo r5 = pg.AbstractC12139d.m72766e(r5)
            java.lang.String r5 = r5.getCountryCode()
            vj.e r2 = p709vj.C13452e.m80781L()
            java.lang.String r2 = r2.m80942m()
            java.lang.String r3 = "PhoneFinderServer"
            r4 = 0
            if (r0 == 0) goto L3e
            if (r1 == 0) goto L3e
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: fk.C9721b -> L3c
            if (r0 != 0) goto L3e
            boolean r5 = r5.equals(r2)     // Catch: fk.C9721b -> L3c
            if (r5 != 0) goto L3e
            tm.c r5 = tm.C13040c.m78609F()     // Catch: fk.C9721b -> L3c
            java.lang.String r5 = r5.m78623O()     // Catch: fk.C9721b -> L3c
            goto L60
        L3c:
            r5 = move-exception
            goto L47
        L3e:
            tm.c r5 = tm.C13040c.m78609F()     // Catch: fk.C9721b -> L3c
            java.lang.String r5 = r5.m78622N()     // Catch: fk.C9721b -> L3c
            goto L60
        L47:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "cannot get phoneFinder address from grs: "
            r0.append(r1)
            java.lang.String r5 = r5.getMessage()
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            p809yg.C13981a.m83988e(r3, r5)
            r5 = r4
        L60:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "domain is "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            p809yg.C13981a.m83987d(r3, r0)
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L80
            java.lang.String r5 = "domain is empty"
            p809yg.C13981a.m83988e(r3, r5)
            return r4
        L80:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            r0.append(r6)
            java.lang.String r5 = r0.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.remotecontrol.http.PhoneFinderServer.m26192b(java.lang.String):java.lang.String");
    }

    /* renamed from: c */
    public TagBindResponse m26193c(String str) throws C9721b {
        RequestModeConfig.getInstance().setMode(3104, false);
        String strM26207r = m26207r(C12797b.m76774a("01050"), str, 3104, "/RemoteControl/Client/CheckTagBind");
        if (!TextUtils.isEmpty(strM26207r)) {
            return (TagBindResponse) m26197h(strM26207r, TagBindResponse.class);
        }
        C13981a.m83988e("PhoneFinderServer", "checkTagBindStatus responseInfo is null");
        return null;
    }

    /* renamed from: d */
    public void m26194d() throws C9721b {
        RequestModeConfig.getInstance().setMode(3090, true);
        BaseResponse baseResponse = (BaseResponse) m26197h(m26207r(C12797b.m76774a("01034"), "", 3090, "/RemoteControl/Client/LocationShareInactive"), BaseResponse.class);
        if (baseResponse != null) {
            C13981a.m83989i("PhoneFinderServer", "closeLocationShareSwitch response code:" + baseResponse.resultCode);
        }
        if (baseResponse != null && baseResponse.resultCode != 0) {
            throw new C9721b(baseResponse.resultCode, "closeLocationShareSwitch fail");
        }
    }

    /* renamed from: f */
    public boolean m26195f(FriendInfo friendInfo) throws JSONException, C9721b {
        if (friendInfo == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("friendInfo", new JSONObject(friendInfo.toString()));
        } catch (JSONException e10) {
            C13981a.m83988e("PhoneFinderServer", "deleteFriend JSONObject exception:" + e10.getMessage());
        }
        RequestModeConfig.getInstance().setMode(3087, true);
        String strM26207r = m26207r(C12797b.m76774a("01039"), jSONObject.toString(), 3087, "/RemoteControl/Client/Friend/Delete");
        if (TextUtils.isEmpty(strM26207r)) {
            C13981a.m83988e("PhoneFinderServer", "deleteFriend responseInfo is null");
            return false;
        }
        BaseResponse baseResponse = (BaseResponse) m26197h(strM26207r, BaseResponse.class);
        if (baseResponse == null) {
            return false;
        }
        C13981a.m83989i("PhoneFinderServer", "deleteShareGrant response code:" + baseResponse.resultCode);
        return baseResponse.resultCode == 0;
    }

    /* renamed from: g */
    public boolean m26196g(ShareGrantInfo shareGrantInfo) throws JSONException, C9721b {
        if (shareGrantInfo == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("shareGrantInfo", new JSONObject(shareGrantInfo.toString()));
        } catch (JSONException e10) {
            C13981a.m83988e("PhoneFinderServer", "deleteShareGrant JSONObject exception:" + e10.getMessage());
        }
        RequestModeConfig.getInstance().setMode(3094, true);
        String strM26207r = m26207r(C12797b.m76774a("01041"), jSONObject.toString(), 3094, "/RemoteControl/Client/ShareGrant/Delete");
        if (TextUtils.isEmpty(strM26207r)) {
            C13981a.m83988e("PhoneFinderServer", "deleteShareGrant responseInfo is null");
            return false;
        }
        BaseResponse baseResponse = (BaseResponse) m26197h(strM26207r, BaseResponse.class);
        if (baseResponse == null) {
            return false;
        }
        C13981a.m83989i("PhoneFinderServer", "deleteFriend response code:" + baseResponse.resultCode);
        return baseResponse.resultCode == 0;
    }

    /* renamed from: h */
    public final <T> T m26197h(String str, Class<T> cls) {
        try {
            return (T) f19814b.fromJson(str, (Class) cls);
        } catch (JsonSyntaxException unused) {
            C13981a.m83988e("PhoneFinderServer", "fromJson Exception:");
            return null;
        }
    }

    /* renamed from: i */
    public JSONArray m26198i() throws C9721b {
        RequestModeConfig.getInstance().setMode(3085, true);
        JSONArray jSONArray = new JSONArray();
        String strM26207r = m26207r(C12797b.m76774a("01031"), "", 3085, "/RemoteControl/Client/Friend/Get");
        if (TextUtils.isEmpty(strM26207r)) {
            C13981a.m83988e("PhoneFinderServer", "responseInfo is null");
            return jSONArray;
        }
        try {
            JSONObject jSONObject = new JSONObject(strM26207r);
            if (jSONObject.has("friendInfoList")) {
                return (JSONArray) jSONObject.get("friendInfoList");
            }
        } catch (JSONException e10) {
            C13981a.m83988e("PhoneFinderServer", "getResponseBundle json exception: " + e10.getMessage());
        }
        return jSONArray;
    }

    /* renamed from: j */
    public ShareGrantGetResponse m26199j() throws C9721b {
        String strM76774a = C12797b.m76774a("01042");
        C12797b c12797b = new C12797b();
        c12797b.m76785k(this.f19815a, "PhoneFinderServer", "0", "getSenderShareGrantInfoList request start", null, "01032", strM76774a, "queryShareGrantInfo", true, null);
        RequestModeConfig.getInstance().setMode(3097, true);
        ShareGrantGetResponse shareGrantGetResponse = (ShareGrantGetResponse) m26197h(m26207r(strM76774a, "", 3097, "/RemoteControl/Client/ShareGrant2Receiver/Get"), ShareGrantGetResponse.class);
        if (shareGrantGetResponse == null || shareGrantGetResponse.resultCode != 0) {
            c12797b.m76785k(this.f19815a, "PhoneFinderServer", String.valueOf(shareGrantGetResponse.resultCode), "getSenderShareGrantInfoList request failed", null, "01032", strM76774a, "queryShareGrantInfo", true, null);
        } else {
            c12797b.m76785k(this.f19815a, "PhoneFinderServer", "0", "getSenderShareGrantInfoList request success", null, "01032", strM76774a, "queryShareGrantInfo", true, null);
        }
        return shareGrantGetResponse;
    }

    /* renamed from: k */
    public List<ShareGrantInfo> m26200k() throws C9721b {
        RequestModeConfig.getInstance().setMode(3088, true);
        ShareGrantGetResponse shareGrantGetResponse = (ShareGrantGetResponse) m26197h(m26207r(C12797b.m76774a("01032"), "", 3088, "/RemoteControl/Client/ShareGrant/Get"), ShareGrantGetResponse.class);
        if (shareGrantGetResponse != null) {
            return shareGrantGetResponse.getShareGrantInfoList();
        }
        return null;
    }

    /* renamed from: l */
    public SystemConfigResponse m26201l(String str) throws C9721b {
        RequestModeConfig.getInstance().setMode(3091, false);
        String strM26207r = m26207r(C12797b.m76774a("01031"), str, 3091, "/RemoteControl/Client/SystemConfigGet");
        if (!TextUtils.isEmpty(strM26207r)) {
            return (SystemConfigResponse) m26197h(strM26207r, SystemConfigResponse.class);
        }
        C13981a.m83988e("PhoneFinderServer", "responseInfo is null");
        return null;
    }

    /* renamed from: m */
    public final void m26202m(String str, String str2) {
        try {
            BaseResponse baseResponse = (BaseResponse) m26197h(str, BaseResponse.class);
            if (baseResponse == null || baseResponse.getResultCode() != 401) {
                return;
            }
            C13195l.m79272J().m79325o0(str2);
        } catch (Exception e10) {
            C13981a.m83988e("PhoneFinderServer", "handleRequestFail Exception: " + e10.getMessage());
        }
    }

    /* renamed from: n */
    public void m26203n() throws C9721b {
        RequestModeConfig.getInstance().setMode(3089, true);
        BaseResponse baseResponse = (BaseResponse) m26197h(m26207r(C12797b.m76774a("01033"), "", 3089, "/RemoteControl/Client/LocationShareActive"), BaseResponse.class);
        if (baseResponse != null) {
            C13981a.m83989i("PhoneFinderServer", "openLocationShareSwitch response code:" + baseResponse.resultCode);
        }
        if (baseResponse != null && baseResponse.resultCode != 0) {
            throw new C9721b(baseResponse.resultCode, "openLocationShareSwitch fail");
        }
    }

    /* renamed from: o */
    public boolean m26204o(String str, String str2) throws JSONException, C9721b, NoSuchAlgorithmException {
        JSONObject jSONObject = new JSONObject();
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(3072);
            KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
            byte[] encoded = keyPairGenerateKeyPair.getPublic().getEncoded();
            if (encoded != null && encoded.length != 0) {
                jSONObject.put("publickey", SafeBase64.encodeToString(encoded, 2));
                jSONObject.put("version", "v11");
                jSONObject.put("offlinePrivateKey", str);
                jSONObject.put("offlineStatus", 1);
                jSONObject.put("offlineMKVersion", str2);
                String strM76774a = C12797b.m76774a("01035");
                C13981a.m83989i("PhoneFinderServer", "openOfflineLocateSwitch traceId:" + strM76774a);
                RequestModeConfig.getInstance().setMode(3095, true);
                OfflineLocateResponse offlineLocateResponse = (OfflineLocateResponse) m26197h(m26207r(strM76774a, jSONObject.toString(), 3095, "/RemoteControl/ClientUpdate"), OfflineLocateResponse.class);
                if (offlineLocateResponse != null) {
                    C13981a.m83989i("PhoneFinderServer", "openOfflineLocateSwitch response code:" + offlineLocateResponse.resultCode);
                }
                if (offlineLocateResponse == null || offlineLocateResponse.getResultCode() != 0) {
                    return false;
                }
                return m26205p(offlineLocateResponse, keyPairGenerateKeyPair);
            }
            C13981a.m83988e("PhoneFinderServer", "encodePublicKey is empty");
            return false;
        } catch (NoSuchAlgorithmException | JSONException e10) {
            C13981a.m83988e("PhoneFinderServer", "openOfflineLocateSwitch request exception: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: p */
    public final boolean m26205p(OfflineLocateResponse offlineLocateResponse, KeyPair keyPair) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (keyPair == null) {
            C13981a.m83988e("PhoneFinderServer", "parseMacKey keyPair is empty");
            return false;
        }
        if (offlineLocateResponse == null || TextUtils.isEmpty(offlineLocateResponse.getCmacKey())) {
            C13981a.m83988e("PhoneFinderServer", "parseMacKey response or macKey is empty");
            return false;
        }
        byte[] bArrM26190e = m26190e(SafeBase64.decode(offlineLocateResponse.getCmacKey(), 2), keyPair.getPrivate().getEncoded());
        String str = bArrM26190e != null ? new String(bArrM26190e, StandardCharsets.UTF_8) : null;
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("PhoneFinderServer", "decryptCmacKey is empty");
            return false;
        }
        C11877j.m71256c1(this.f19815a, str);
        return true;
    }

    /* renamed from: q */
    public QueryLocateResponse m26206q(String str, Integer num, String str2, Integer num2, Integer num3, String str3) throws JSONException, C9721b {
        JSONObject jSONObject = new JSONObject();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        try {
            jSONObject.put("operation", "shareLocate");
            if (num != null) {
                jSONObject.put("destDeviceType", num.intValue());
            }
            if (num3 != null) {
                jSONObject.put("relationType", num3.intValue());
            }
            if (num2 != null) {
                jSONObject.put(VastAttribute.SEQUENCE, num2.intValue());
            }
            if (!C4633d0.m28404a(str3)) {
                jSONObject.put("senderUserId", str3);
            }
            if (!C4633d0.m28404a(str2)) {
                jSONObject.put("locateVersion", str2);
            }
            linkedHashMap.put("body", jSONObject.toString());
            jSONObject.put("deviceId", str);
        } catch (JSONException e10) {
            C13981a.m83988e("PhoneFinderServer", "queryLocate body json exception: " + e10.getMessage());
        }
        String strM76774a = C12797b.m76774a("01044");
        C12797b c12797b = new C12797b();
        c12797b.m76785k(this.f19815a, "PhoneFinderServer", "0", "queryLocate start", null, String.valueOf(3099), strM76774a, "shareQueryLocate", true, linkedHashMap);
        RequestModeConfig.getInstance().setMode(3099, true);
        QueryLocateResponse queryLocateResponse = (QueryLocateResponse) m26197h(m26207r(strM76774a, jSONObject.toString(), 3099, "/RemoteControl/Client/QueryLocate"), QueryLocateResponse.class);
        if (queryLocateResponse != null) {
            C13981a.m83989i("PhoneFinderServer", "sendLocate response code:" + queryLocateResponse.resultCode);
        }
        if (queryLocateResponse == null || queryLocateResponse.resultCode != 0) {
            c12797b.m76785k(this.f19815a, "PhoneFinderServer", "001_3004", "queryLocate fail, resultCode:" + queryLocateResponse.resultCode, null, String.valueOf(3099), null, "shareQueryLocate", true, linkedHashMap);
        } else {
            c12797b.m76785k(this.f19815a, "PhoneFinderServer", "0", "queryLocate success", null, String.valueOf(3099), strM76774a, "shareQueryLocate", true, linkedHashMap);
        }
        return queryLocateResponse;
    }

    /* renamed from: r */
    public final String m26207r(String str, String str2, int i10, String str3) throws C9721b {
        try {
            C13981a.m83987d("PhoneFinderServer", "request start");
            String strM26192b = m26192b(str3);
            C4348f c4348f = new C4348f(this.f19815a, "", str, str2, i10);
            String str4 = (String) C12612a.m76107g(strM26192b, c4348f, null);
            if (TextUtils.isEmpty(str4)) {
                throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "response is null", "PhoneFinderServer");
            }
            m26202m(str4, c4348f.m26241a());
            return str4;
        } catch (C9721b e10) {
            C13981a.m83988e("PhoneFinderServer", "request CException error: " + e10.toString());
            throw e10;
        } catch (Exception e11) {
            C13981a.m83988e("PhoneFinderServer", "request error: " + e11.getMessage());
            throw new C9721b(4001, e11.getMessage(), "PhoneFinderServer");
        }
    }

    /* renamed from: s */
    public BaseResponse m26208s(String str, Integer num, Integer num2, String str2) throws JSONException, C9721b {
        String strM76774a = C12797b.m76774a("01043");
        JSONObject jSONObject = new JSONObject();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if (num != null) {
            try {
                jSONObject.put("destDeviceType", num.intValue());
            } catch (JSONException e10) {
                C13981a.m83988e("PhoneFinderServer", "sendLocate body json exception: " + e10.getMessage());
            }
        }
        if (num2 != null) {
            jSONObject.put("relationType", num2.intValue());
        }
        if (!C4633d0.m28404a(str2)) {
            jSONObject.put("senderUserId", str2);
        }
        linkedHashMap.put("body", jSONObject.toString());
        jSONObject.put("deviceId", str);
        C12797b c12797b = new C12797b();
        c12797b.m76785k(this.f19815a, "PhoneFinderServer", "0", "sendLocate start", null, String.valueOf(3098), strM76774a, "shareSendLocate", true, linkedHashMap);
        RequestModeConfig.getInstance().setMode(3098, true);
        BaseResponse baseResponse = (BaseResponse) m26197h(m26207r(strM76774a, jSONObject.toString(), 3098, "/RemoteControl/Client/SendLocate"), BaseResponse.class);
        if (baseResponse != null) {
            C13981a.m83989i("PhoneFinderServer", "sendLocate response code:" + baseResponse.resultCode);
        }
        if (baseResponse == null || baseResponse.resultCode != 0) {
            c12797b.m76785k(this.f19815a, "PhoneFinderServer", "001_3004", "sendLocate fail, resultCode:" + baseResponse.resultCode, null, "01043", null, "shareSendLocate", true, linkedHashMap);
        } else {
            c12797b.m76785k(this.f19815a, "PhoneFinderServer", "0", "sendLocate success", null, String.valueOf(3098), strM76774a, "shareSendLocate", true, linkedHashMap);
        }
        return baseResponse;
    }

    /* renamed from: t */
    public int m26209t(ShareGrantInfo shareGrantInfo) throws JSONException, C9721b {
        if (shareGrantInfo == null) {
            return 1;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("shareGrantInfo", new JSONObject(shareGrantInfo.toString()));
        } catch (JSONException e10) {
            C13981a.m83988e("PhoneFinderServer", "setShareTime JSONObject exception:" + e10.getMessage());
        }
        RequestModeConfig.getInstance().setMode(3093, true);
        String strM26207r = m26207r(C12797b.m76774a("01040"), jSONObject.toString(), 3093, "/RemoteControl/Client/ShareGrant/Add");
        if (TextUtils.isEmpty(strM26207r)) {
            C13981a.m83988e("PhoneFinderServer", "SetShareTime responseInfo is null");
            return 1;
        }
        BaseResponse baseResponse = (BaseResponse) m26197h(strM26207r, BaseResponse.class);
        if (baseResponse != null) {
            return baseResponse.resultCode;
        }
        return 1;
    }
}
