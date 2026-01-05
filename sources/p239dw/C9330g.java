package p239dw;

import android.content.Context;
import aw.C1029b;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.entity.ErrorBody;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import cw.C8957b;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;
import p857zv.Exception_C14389c;

/* renamed from: dw.g */
/* loaded from: classes9.dex */
public class C9330g extends AbstractC9328f {

    /* renamed from: h */
    public C9341l0 f46710h;

    /* renamed from: i */
    public boolean f46711i;

    public C9330g(CredentialClient credentialClient, Context context, NetworkCapability networkCapability, C9341l0 c9341l0) throws Exception_C14389c {
        super(credentialClient, context, networkCapability);
        this.f46711i = true;
        this.f46710h = c9341l0;
    }

    @Override // p239dw.AbstractC9328f
    /* renamed from: a */
    public Credential mo58666a(String str) throws Exception_C14389c, NumberFormatException {
        try {
            int i10 = Integer.parseInt(new JSONObject(str).getString("expire"));
            if (i10 == 0) {
                return this.m_credential.genCredentialFromString(str);
            }
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new Exception_C14389c(1017L, "unenable expire.");
                }
                throw new Exception_C14389c(1016L, "so version is unenable.");
            }
            if (!this.f46711i) {
                throw new Exception_C14389c(1021L, "c1 vision is unenable.");
            }
            C1029b.m6230a("KidHandler", "c1 version expired, start to force update c1!", new Object[0]);
            this.f46710h.m58698b(true, new C9338k());
            this.f46711i = false;
            return m58672b(this.f46704c, this.f46705d, this.f46706e, this.f46707f);
        } catch (NumberFormatException e10) {
            StringBuilder sbM58651a = C9320b.m58651a("parse TSMS resp expire error : ");
            sbM58651a.append(e10.getMessage());
            throw new Exception_C14389c(2001L, sbM58651a.toString());
        } catch (JSONException e11) {
            StringBuilder sbM58651a2 = C9320b.m58651a("parse TSMS resp get json error : ");
            sbM58651a2.append(e11.getMessage());
            throw new Exception_C14389c(1002L, sbM58651a2.toString());
        }
    }

    @Override // p239dw.AbstractC9328f
    /* renamed from: c */
    public Credential mo58667c(String str, String str2, String str3, String str4, C9334i c9334i) throws Exception_C14389c {
        C1029b.m6234e("KidHandler", "applyCredential use KidHandler.", new Object[0]);
        return m58672b(str, str2, str3, str4);
    }

    @Override // p239dw.AbstractC9328f
    /* renamed from: d */
    public String mo58668d(NetworkResponse networkResponse) throws Exception_C14389c {
        if (networkResponse.isSuccessful()) {
            return networkResponse.getBody();
        }
        ErrorBody errorBodyFromString = ErrorBody.fromString(networkResponse.getBody());
        StringBuilder sbM58651a = C9320b.m58651a("tsms service error, ");
        sbM58651a.append(errorBodyFromString.getErrorMessage());
        String string = sbM58651a.toString();
        throw C9344n.m58700a("KidHandler", string, new Object[0], ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS, string);
    }

    @Override // p239dw.AbstractC9328f
    /* renamed from: e */
    public void mo58669e() throws Exception_C14389c, IOException {
        C9341l0 c9341l0 = this.f46710h;
        C9338k c9338k = new C9338k();
        if (c9338k.m58691c(c9341l0.f46748b)) {
            c9341l0.m58698b(false, c9338k);
            return;
        }
        try {
            C9339k0.m58692a(c9341l0.f46748b, c9338k);
        } catch (Exception_C14389c e10) {
            C1029b.m6236g("KeyComponentManger", "Init using local file failed, code = {0}, msg = {1}", Long.valueOf(e10.getErrorCode()), e10.getMessage());
            C1029b.m6234e("KeyComponentManger", "Try update data = componnet from server", new Object[0]);
            c9341l0.m58698b(true, c9338k);
        }
    }

    @Override // p239dw.AbstractC9328f
    /* renamed from: f */
    public String mo58670f() throws Exception_C14389c {
        int iM56703b = C8957b.m56703b("Local-C1-Version", -1, this.m_context);
        C1029b.m6230a("KidHandler", "c1 version is " + iM56703b + ", so version is " + ((int) UcsLib.ucsGetSoVersion()), new Object[0]);
        return new String(UcsLib.genReqJws(this.m_context, this.f46705d, this.f46706e, 0, iM56703b), StandardCharsets.UTF_8);
    }
}
