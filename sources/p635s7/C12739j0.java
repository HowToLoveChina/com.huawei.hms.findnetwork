package p635s7;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import org.json.JSONObject;
import p650t7.C12972j0;
import p764x6.AbstractC13709a;
import p765x7.C13721c;

/* renamed from: s7.j0 */
/* loaded from: classes2.dex */
public class C12739j0 extends AbstractC12758w {

    /* renamed from: l */
    public String f58340l = PowerKitApplyUtil.GROUP_ALBUM;

    /* renamed from: m */
    public String f58341m;

    /* renamed from: n */
    public int f58342n;

    public C12739j0(Context context, String str, int i10) throws Throwable {
        this.f60186b = context;
        this.f58341m = str;
        this.f58342n = i10;
        this.f60187c = m80109h("/JPJX/CloudPhoto");
        this.f58397k = "share.update.privilege";
        m80115r();
        m80104c(str);
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("shareId", this.f58341m);
        jSONObject.put("privilege", this.f58342n);
        jSONObject.put("resource", this.f58340l);
        jSONObject.put("cmd", this.f58397k);
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "Share.Permissions.update";
        return new C12972j0(this.f58341m, this.f58342n);
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        Bundle bundleM82485a = C13721c.m82485a(str);
        bundleM82485a.putString("shareId", this.f58341m);
        bundleM82485a.putInt("privilege", this.f58342n);
        return bundleM82485a;
    }
}
