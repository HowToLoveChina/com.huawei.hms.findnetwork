package p239dw;

import android.content.Context;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import p239dw.C9334i;
import p857zv.C14389c;

/* renamed from: dw.s */
/* loaded from: classes9.dex */
public class C9351s {

    /* renamed from: a */
    public Context f46752a;

    /* renamed from: b */
    public NetworkCapability f46753b;

    /* renamed from: c */
    public String f46754c;

    /* renamed from: d */
    public InterfaceC9323c0 f46755d;

    /* renamed from: e */
    public C9341l0 f46756e;

    /* renamed from: f */
    public CredentialClient f46757f;

    /* renamed from: g */
    public String f46758g;

    public C9351s(CredentialClient credentialClient, Context context, NetworkCapability networkCapability, InterfaceC9323c0 interfaceC9323c0, String str) {
        this.f46757f = credentialClient;
        this.f46752a = context;
        this.f46753b = networkCapability;
        this.f46754c = str;
        this.f46755d = interfaceC9323c0;
        this.f46756e = new C9341l0(context, interfaceC9323c0, networkCapability);
    }

    /* renamed from: a */
    public final Credential m58707a(int i10, String str, String str2) throws C14389c {
        C9334i.a aVar = new C9334i.a();
        aVar.f46733a = this.f46757f;
        aVar.f46734b = this.f46752a;
        aVar.f46736d = this.f46756e;
        aVar.f46735c = this.f46753b;
        C9334i c9334i = new C9334i(aVar);
        try {
            return c9334i.m58678a(i10, this.f46755d.mo58658a(), this.f46754c, str, str2, c9334i);
        } finally {
            this.f46758g = c9334i.m58679b();
        }
    }
}
