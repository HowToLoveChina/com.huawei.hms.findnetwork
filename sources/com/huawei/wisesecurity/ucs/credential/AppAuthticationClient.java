package com.huawei.wisesecurity.ucs.credential;

import android.content.Context;
import android.text.TextUtils;
import aw.C1029b;
import com.huawei.openalliance.p169ad.p171db.bean.SdkCfgSha256Record;
import com.huawei.wisesecurity.ucs.credential.crypto.signer.CredentialSignAlg;
import com.huawei.wisesecurity.ucs.credential.entity.SkDkEntity;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import cw.C8958c;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p239dw.AbstractC9353u;
import p239dw.C9320b;
import p239dw.C9324d;
import p267ev.EnumC9566e;
import p318gv.C10054a;
import p374iv.C10626e;
import p500nv.C11756a;
import p535ov.InterfaceC12042i;
import p857zv.C14387a;
import p857zv.C14389c;
import p857zv.C14391e;

@Deprecated
/* loaded from: classes9.dex */
public class AppAuthticationClient {
    private CredentialSignAlg alg;
    private Context context;
    private Credential credential;
    private String extra;

    @Deprecated
    public static class Builder {

        @InterfaceC12042i
        private CredentialSignAlg alg = CredentialSignAlg.HMAC_SHA256;

        @InterfaceC12042i
        private Context context;

        @InterfaceC12042i
        private Credential credential;
        private String extra;

        public Builder alg(CredentialSignAlg credentialSignAlg) {
            this.alg = credentialSignAlg;
            return this;
        }

        public AppAuthticationClient build() throws C14389c {
            try {
                C11756a.m70079b(this);
                return new AppAuthticationClient(this.context, this.credential, this.extra, this.alg);
            } catch (C10626e e10) {
                StringBuilder sbM58651a = C9320b.m58651a("AppAuthticationClient check param error : ");
                sbM58651a.append(e10.getMessage());
                throw new C14391e(sbM58651a.toString());
            }
        }

        public Builder context(Context context) {
            this.context = context;
            return this;
        }

        public Builder credential(Credential credential) {
            this.credential = credential;
            return this;
        }

        public Builder extra(String str) {
            this.extra = str;
            return this;
        }
    }

    private AppAuthticationClient(Context context, Credential credential, String str, CredentialSignAlg credentialSignAlg) {
        this.context = context;
        this.credential = credential;
        this.extra = str;
        this.alg = credentialSignAlg;
    }

    @Deprecated
    public String getAppAuthtication() throws JSONException, C14389c {
        String strM56711c;
        String str;
        String str2;
        String strM56711c2 = "";
        try {
            C9324d c9324d = new C9324d();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("alg", "HS256");
                strM56711c = C8958c.m56711c(jSONObject.toString().getBytes(StandardCharsets.UTF_8), 10);
            } catch (JSONException | C14389c e10) {
                C1029b.m6231b("AppAuthticationJws", "generate Header exception: {0}", e10.getMessage());
                strM56711c = "";
            }
            c9324d.f46698a = strM56711c;
            if (this.credential.getAkskVersion() < 1) {
                List<String> pkgNameCertFP = UcsLib.getPkgNameCertFP(this.context);
                str2 = pkgNameCertFP.get(0);
                str = pkgNameCertFP.get(1);
            } else {
                str = "";
                str2 = str;
            }
            String str3 = this.extra;
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(SdkCfgSha256Record.PKGNAME, str2);
                jSONObject2.put("certSig", str);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("extra", str3);
                }
                strM56711c2 = C8958c.m56711c(jSONObject2.toString().getBytes(StandardCharsets.UTF_8), 10);
            } catch (JSONException | C14389c e11) {
                C1029b.m6231b("AppAuthticationJws", "generate PayLoad exception: {0}", e11.getMessage());
            }
            c9324d.f46699b = strM56711c2;
            c9324d.f46700c = C8958c.m56711c(new C10054a.b().m62495c(SkDkEntity.from(this.credential.getSecretKeyBytes()).decryptSkDk(AbstractC9353u.m58709a(this.credential))).m62494b(EnumC9566e.HMAC_SHA256).m62493a().getSignHandler().from(c9324d.m58662b()).sign(), 10);
            return c9324d.m58661a();
        } catch (UnsupportedOperationException unused) {
            throw new C14389c(2001L, "new String UnsupportedOperationException..");
        } catch (C14387a e12) {
            throw new C14389c(1022L, e12.getMessage());
        } catch (Exception e13) {
            StringBuilder sbM58651a = C9320b.m58651a("app info auth Exception : ");
            sbM58651a.append(e13.getMessage());
            throw new C14389c(2001L, sbM58651a.toString());
        }
    }
}
