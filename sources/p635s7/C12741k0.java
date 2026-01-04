package p635s7;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import org.json.JSONObject;
import p650t7.C12974k0;
import p764x6.AbstractC13709a;
import p765x7.C13721c;

/* renamed from: s7.k0 */
/* loaded from: classes2.dex */
public class C12741k0 extends AbstractC12758w {

    /* renamed from: l */
    public String f58347l;

    /* renamed from: m */
    public String f58348m;

    /* renamed from: n */
    public int f58349n;

    public C12741k0(Context context, String str, String str2, int i10) throws Throwable {
        this.f60186b = context;
        this.f58348m = str;
        this.f58347l = str2;
        this.f58349n = i10;
        this.f60187c = m80109h("/JPJX/CloudPhoto");
        this.f58397k = "share.reportresult";
        m80115r();
        m80104c(str);
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", this.f58397k);
        jSONObject.put("resource", PowerKitApplyUtil.GROUP_ALBUM);
        jSONObject.put("shareId", this.f58348m);
        jSONObject.put("ownerId", this.f58347l);
        jSONObject.put("result", this.f58349n);
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "Share.Permissions.update";
        return new C12974k0(this.f58348m, this.f58347l, this.f58349n);
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        Bundle bundleM82485a = C13721c.m82485a(str);
        bundleM82485a.putString("shareId", this.f58348m);
        bundleM82485a.putString("ownerID", this.f58347l);
        bundleM82485a.putInt("ShareConfirmResult", this.f58349n);
        return bundleM82485a;
    }
}
