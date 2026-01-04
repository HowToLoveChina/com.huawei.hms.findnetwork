package com.huawei.wisesecurity.ucs.credential.entity;

import cw.C8958c;
import org.json.JSONException;
import org.json.JSONObject;
import p239dw.C9320b;
import p374iv.C10626e;
import p500nv.C11756a;
import p535ov.InterfaceC12044k;
import p857zv.C14389c;

/* loaded from: classes9.dex */
public class AccessKey {
    private static final String AKSK_VERSION = "akskVersion";
    private static final String APP_CERT_FP = "appCertFP";
    private static final String APP_PKG_NAME = "appPkgName";
    private int akskVersion;

    @InterfaceC12044k
    private String appCertFP;

    @InterfaceC12044k
    private String appPkgName;

    public static AccessKey fromString(String str) throws C14389c {
        try {
            AccessKey accessKey = new AccessKey();
            JSONObject jSONObject = new JSONObject(C8958c.m56710b(str, 0));
            accessKey.akskVersion = jSONObject.optInt(AKSK_VERSION);
            accessKey.appPkgName = jSONObject.optString(APP_PKG_NAME);
            accessKey.appCertFP = jSONObject.optString(APP_CERT_FP);
            if (accessKey.hasAkskVersion()) {
                C11756a.m70079b(accessKey);
            }
            return accessKey;
        } catch (C10626e e10) {
            StringBuilder sbM58651a = C9320b.m58651a("accessKey param invalid : ");
            sbM58651a.append(e10.getMessage());
            throw new C14389c(1001L, sbM58651a.toString());
        } catch (JSONException e11) {
            StringBuilder sbM58651a2 = C9320b.m58651a("accessKey param is not a valid json string : ");
            sbM58651a2.append(e11.getMessage());
            throw new C14389c(1001L, sbM58651a2.toString());
        }
    }

    public int getAkskVersion() {
        return this.akskVersion;
    }

    public String getAppCertFP() {
        return this.appCertFP;
    }

    public String getAppPkgName() {
        return this.appPkgName;
    }

    public boolean hasAkskVersion() {
        return this.akskVersion >= 1;
    }
}
