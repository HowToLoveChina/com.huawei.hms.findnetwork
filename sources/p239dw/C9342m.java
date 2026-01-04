package p239dw;

import aw.C1029b;
import com.huawei.wisesecurity.ucs.credential.outer.GrsCapability;

/* renamed from: dw.m */
/* loaded from: classes9.dex */
public class C9342m implements InterfaceC9323c0 {

    /* renamed from: a */
    public GrsCapability f46750a;

    public C9342m(GrsCapability grsCapability) {
        this.f46750a = grsCapability;
    }

    @Override // p239dw.InterfaceC9323c0
    /* renamed from: a */
    public String mo58658a() {
        return m58699b("ROOT") + "/tsms/v2/credentials";
    }

    /* renamed from: b */
    public final String m58699b(String str) {
        String strSynGetGrsUrl = this.f46750a.synGetGrsUrl("com.huawei.tsms", str);
        C1029b.m6234e("OuterGrsUrlImpl", "synGetGrsUrl : {0}", strSynGetGrsUrl);
        return strSynGetGrsUrl;
    }

    @Override // p239dw.InterfaceC9323c0
    /* renamed from: a */
    public String mo58659a(String str, String str2) {
        return m58699b("CDN") + "tsms/" + str + "/" + str2;
    }

    @Override // p239dw.InterfaceC9323c0
    /* renamed from: b */
    public String mo58660b() {
        return m58699b("HA");
    }
}
