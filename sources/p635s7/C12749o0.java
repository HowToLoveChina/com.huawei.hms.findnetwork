package p635s7;

import android.content.Context;
import android.os.Bundle;
import p650t7.C12978m0;
import p764x6.AbstractC13709a;
import p765x7.C13720b;
import p765x7.C13721c;

/* renamed from: s7.o0 */
/* loaded from: classes2.dex */
public class C12749o0 extends AbstractC12758w {
    public C12749o0(Context context, String str, String str2) {
        this.f60186b = context;
        this.f60189e = str;
        this.f60190f = str2;
        m76585v(str2);
        this.f60187c = m80109h(C13720b.m82484e());
        this.f58397k = "cloudphoto.unlock";
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        this.f60188d = C13721c.m82489e(this.f58397k);
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        this.f58397k = "General.Locks.delete";
        return new C12978m0();
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        return C13721c.m82485a(str);
    }
}
