package p239dw;

import android.content.Context;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkRequest;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse;
import java.io.IOException;
import p857zv.Exception_C14389c;

/* renamed from: dw.f */
/* loaded from: classes9.dex */
public abstract class AbstractC9328f {

    /* renamed from: a */
    public NetworkCapability m_capability;

    /* renamed from: b */
    public Context m_context;

    /* renamed from: c */
    public String f46704c;

    /* renamed from: d */
    public String f46705d;

    /* renamed from: e */
    public String f46706e;

    /* renamed from: f */
    public String f46707f;

    /* renamed from: g */
    public CredentialClient m_credential;

    public AbstractC9328f(CredentialClient credentialClient, Context context, NetworkCapability networkCapability) {
        this.m_credential = credentialClient;
        this.m_context = context;
        this.m_capability = networkCapability;
    }

    /* renamed from: g */
    public static boolean m58671g(String str) {
        return "tsms.1018".equalsIgnoreCase(str) || "tsms.1019".equalsIgnoreCase(str);
    }

    /* renamed from: a */
    public abstract Credential mo58666a(String str) throws Exception_C14389c;

    /* renamed from: b */
    public Credential m58672b(String str, String str2, String str3, String str4) throws Exception_C14389c {
        try {
            mo58669e();
            this.f46704c = str;
            this.f46705d = str2;
            this.f46706e = str3;
            this.f46707f = str4;
            NetworkResponse networkResponsePost = this.m_capability.post(new NetworkRequest(str, C9355w.m58716b(str2, str3, str4), C9355w.m58715a(mo58670f())));
            int code = networkResponsePost.getCode();
            if ((code < 200 || code >= 300) && code != 400 && code != 403 && code != 500) {
                throw new Exception_C14389c(1013L, "tsms req error, return " + networkResponsePost.getCode());
            }
            return mo58666a(mo58668d(networkResponsePost));
        } catch (IOException e10) {
            StringBuilder sbM58651a = C9320b.m58651a("get credential from TSMS fail : ");
            sbM58651a.append(e10.getMessage());
            String string = sbM58651a.toString();
            throw C9344n.m58700a("ApplyCredentialHandler", string, new Object[0], 1006L, string);
        }
    }

    /* renamed from: c */
    public abstract Credential mo58667c(String str, String str2, String str3, String str4, C9334i c9334i) throws Exception_C14389c;

    /* renamed from: d */
    public abstract String mo58668d(NetworkResponse networkResponse) throws Exception_C14389c;

    /* renamed from: e */
    public abstract void mo58669e() throws Exception_C14389c;

    /* renamed from: f */
    public abstract String mo58670f() throws Exception_C14389c;
}
