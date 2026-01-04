package p239dw;

import android.content.Context;
import aw.C1029b;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;

/* renamed from: dw.f0 */
/* loaded from: classes9.dex */
public class C9329f0 implements InterfaceC9323c0 {

    /* renamed from: a */
    public GrsClient f46709a;

    public C9329f0(Context context, String str) {
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setSerCountry(str);
        this.f46709a = new GrsClient(context, grsBaseInfo);
    }

    @Override // p239dw.InterfaceC9323c0
    /* renamed from: a */
    public String mo58658a() {
        return m58673b("ROOT") + "/tsms/v2/credentials";
    }

    /* renamed from: b */
    public final String m58673b(String str) {
        String strSynGetGrsUrl = this.f46709a.synGetGrsUrl("com.huawei.tsms", str);
        C1029b.m6234e("InnerGrsUrlImpl", "synGetGrsUrl : {0}", strSynGetGrsUrl);
        return strSynGetGrsUrl;
    }

    @Override // p239dw.InterfaceC9323c0
    /* renamed from: a */
    public String mo58659a(String str, String str2) {
        return m58673b("CDN") + "tsms/" + str + "/" + str2;
    }

    @Override // p239dw.InterfaceC9323c0
    /* renamed from: b */
    public String mo58660b() {
        return m58673b("HA");
    }
}
