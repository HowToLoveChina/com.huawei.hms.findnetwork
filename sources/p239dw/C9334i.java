package p239dw;

import android.content.Context;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import java.util.HashMap;
import java.util.Map;
import p857zv.Exception_C14389c;

/* renamed from: dw.i */
/* loaded from: classes9.dex */
public class C9334i {

    /* renamed from: a */
    public final Map<Integer, AbstractC9328f> f46727a = new HashMap();

    /* renamed from: b */
    public CredentialClient f46728b;

    /* renamed from: c */
    public Context f46729c;

    /* renamed from: d */
    public NetworkCapability f46730d;

    /* renamed from: e */
    public C9341l0 f46731e;

    /* renamed from: f */
    public int f46732f;

    /* renamed from: dw.i$a */
    public static final class a {

        /* renamed from: a */
        public CredentialClient f46733a;

        /* renamed from: b */
        public Context f46734b;

        /* renamed from: c */
        public NetworkCapability f46735c;

        /* renamed from: d */
        public C9341l0 f46736d;
    }

    public C9334i(a aVar) throws Exception_C14389c {
        this.f46728b = aVar.f46733a;
        this.f46729c = aVar.f46734b;
        this.f46730d = aVar.f46735c;
        this.f46731e = aVar.f46736d;
        m58680c();
    }

    /* renamed from: a */
    public Credential m58678a(int i10, String str, String str2, String str3, String str4, C9334i c9334i) throws Exception_C14389c {
        this.f46732f = i10;
        AbstractC9328f abstractC9328f = this.f46727a.get(Integer.valueOf(i10));
        if (abstractC9328f != null) {
            return abstractC9328f.mo58667c(str, str2, str3, str4, c9334i);
        }
        throw new Exception_C14389c(2001L, "applyCredential get inner error, apply flag not found.");
    }

    /* renamed from: b */
    public String m58679b() {
        int i10 = this.f46732f;
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? "" : "Huks_EC" : "AndroidKS_EC" : "AndroidKS" : "Kid";
    }

    /* renamed from: c */
    public final void m58680c() throws Exception_C14389c {
        this.f46727a.put(0, new C9330g(this.f46728b, this.f46729c, this.f46730d, this.f46731e));
        this.f46727a.put(1, new C9347o0(this.f46728b, this.f46729c, this.f46730d));
        this.f46727a.put(2, new UcsECKeyStoreHandler(this.f46728b, this.f46729c, this.f46730d));
        this.f46727a.put(3, new C9327e0(this.f46728b, this.f46729c, this.f46730d));
    }
}
