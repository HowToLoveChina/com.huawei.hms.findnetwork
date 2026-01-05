package com.huawei.wisesecurity.ucs.credential;

import android.content.Context;
import aw.C1029b;
import com.huawei.wisesecurity.ucs.credential.entity.AccessKey;
import com.huawei.wisesecurity.ucs.credential.entity.KeyEncryptKey;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import cv.InterfaceC8954a;
import org.json.JSONException;
import org.json.JSONObject;
import p239dw.KekStore;
import p239dw.C9320b;
import p239dw.C9344n;
import p239dw.C9348p;
import p374iv.C10622a;
import p374iv.C10626e;
import p500nv.C11756a;
import p535ov.InterfaceC12037d;
import p535ov.InterfaceC12044k;
import p857zv.Exception_C14389c;
import p857zv.C14391e;

/* loaded from: classes9.dex */
public class Credential {

    /* renamed from: AK */
    private static final String f45384AK = "accessKey";

    /* renamed from: DK */
    private static final String f45385DK = "dataKey";
    private static final byte[] EMPTY_BYTES = new byte[0];
    private static final String EXPIRE_TIME = "expireTime";
    private static final String KEK = "kek";

    /* renamed from: SK */
    private static final String f45386SK = "secretKey";
    private static final String TAG = "Credential";

    @InterfaceC12044k
    private String accessKey;

    /* renamed from: ak */
    private AccessKey f45387ak;

    @InterfaceC12044k
    private String dataKey;

    @InterfaceC12037d(max = Long.MAX_VALUE, min = 1)
    private long expireTime;
    private KeyEncryptKey kek;

    @InterfaceC12044k
    private String rawKek;

    @InterfaceC12044k
    private String secretKey;

    private Credential() {
    }

    private byte[] base64DecodeForNative(String str) {
        try {
            return InterfaceC8954a.f45454a.mo56697b(str);
        } catch (C10622a unused) {
            return EMPTY_BYTES;
        }
    }

    public static Credential fromString(Context context, String str, C9348p c9348p) throws Exception_C14389c {
        try {
            Credential credential = new Credential();
            JSONObject jSONObject = new JSONObject(str);
            credential.secretKey = jSONObject.optString(f45386SK);
            credential.dataKey = jSONObject.optString(f45385DK);
            credential.accessKey = jSONObject.optString(f45384AK);
            credential.rawKek = jSONObject.optString(KEK);
            credential.expireTime = jSONObject.optLong("expireTime");
            credential.kek = KeyEncryptKey.fromString(context, credential.rawKek);
            credential.checkParam();
            credential.f45387ak = AccessKey.fromString(credential.accessKey);
            c9348p.m58703m(credential.getAppPkgName()).m58702l(credential.getAkskVersion()).m58704n(getCty(credential.getKekVersion()));
            if (credential.f45387ak.hasAkskVersion()) {
                UcsLib.checkNativeLibrary();
                StringBuilder sb2 = new StringBuilder();
                if (!UcsLib.checkPkgNameCertFP(context, credential.f45387ak.getAppPkgName(), credential.f45387ak.getAppCertFP(), sb2)) {
                    String str2 = "check AppPkgName appCertFP fail " + sb2.toString();
                    C1029b.m6231b(TAG, str2, new Object[0]);
                    throw new Exception_C14389c(1023L, str2);
                }
            }
            KekStore.m58710c(credential).putKeyParam(credential, context);
            return credential;
        } catch (JSONException e10) {
            C1029b.m6231b(TAG, "parse credentialStr get json exception : {0}", e10.getMessage());
            StringBuilder sbM58651a = C9320b.m58651a("parse credentialStr get json exception : ");
            sbM58651a.append(e10.getMessage());
            throw new Exception_C14389c(1002L, sbM58651a.toString());
        } catch (Exception_C14389c e11) {
            C1029b.m6231b(TAG, "parse credentialStr get UCS exception : errorCode : {0} errorMsg : {1}", Long.valueOf(e11.getErrorCode()), e11.getMessage());
            throw e11;
        } catch (Exception e12) {
            StringBuilder sbM58651a2 = C9320b.m58651a("parse credentialStr get exception : ");
            sbM58651a2.append(e12.getMessage());
            String string = sbM58651a2.toString();
            throw C9344n.m58700a(TAG, string, new Object[0], 2001L, string);
        }
    }

    private static String getCty(int i10) {
        return i10 != 0 ? i10 != 3 ? i10 != 6 ? i10 != 7 ? "" : "Huks_EC" : "AndroidKS_EC" : "AndroidKS" : "Kid";
    }

    public void checkParam() throws Exception_C14389c {
        try {
            C11756a.m70079b(this);
        } catch (C10626e e10) {
            StringBuilder sbM58651a = C9320b.m58651a("credential get param exception : ");
            sbM58651a.append(e10.getMessage());
            throw new C14391e(sbM58651a.toString());
        }
    }

    public String getAccessKey() {
        return this.accessKey;
    }

    public int getAkskVersion() {
        return this.f45387ak.getAkskVersion();
    }

    public int getAlg() {
        return this.kek.getAlg();
    }

    public String getAppCertFP() {
        return this.f45387ak.getAppCertFP();
    }

    public String getAppPkgName() {
        return this.f45387ak.getAppPkgName();
    }

    public String getDataKey() {
        return this.dataKey;
    }

    public byte[] getDataKeyBytes() {
        return base64DecodeForNative(this.dataKey);
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public int getKekAlg() {
        return this.kek.getKekAlg();
    }

    public byte[] getKekBytes() {
        return base64DecodeForNative(this.kek.getKey());
    }

    public String getKekString() {
        return this.kek.getKey();
    }

    public int getKekVersion() {
        return this.kek.getVersion();
    }

    public String getRawKek() {
        return this.rawKek;
    }

    public String getSecretKey() {
        return this.secretKey;
    }

    public byte[] getSecretKeyBytes() {
        return base64DecodeForNative(this.secretKey);
    }

    public String toString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f45386SK, this.secretKey);
            jSONObject.put(f45384AK, this.accessKey);
            jSONObject.put(f45385DK, this.dataKey);
            jSONObject.put(KEK, this.rawKek);
            jSONObject.put("expireTime", this.expireTime);
            return jSONObject.toString();
        } catch (JSONException e10) {
            C1029b.m6231b(TAG, "Credential toString exception : {0}", e10.getMessage());
            return "";
        }
    }
}
