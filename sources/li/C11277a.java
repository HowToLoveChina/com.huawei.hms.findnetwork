package li;

import com.huawei.cloud.base.http.AbstractC4594a;
import com.huawei.cloud.base.util.C4627a0;
import java.io.IOException;
import java.io.OutputStream;
import ni.AbstractC11708c;
import ni.AbstractC11709d;

/* renamed from: li.a */
/* loaded from: classes.dex */
public class C11277a extends AbstractC4594a {

    /* renamed from: c */
    public final Object f52914c;

    /* renamed from: d */
    public final AbstractC11708c f52915d;

    /* renamed from: e */
    public String f52916e;

    public C11277a(AbstractC11708c abstractC11708c, Object obj) {
        super("application/json; charset=UTF-8");
        this.f52915d = (AbstractC11708c) C4627a0.m28391d(abstractC11708c);
        this.f52914c = C4627a0.m28391d(obj);
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4605h, com.huawei.cloud.base.util.InterfaceC4631c0
    /* renamed from: a */
    public void mo28157a(OutputStream outputStream) throws IOException {
        AbstractC11709d abstractC11709dMo69828a = this.f52915d.mo69828a(outputStream, m28155e());
        if (this.f52916e != null) {
            abstractC11709dMo69828a.mo69855s();
            abstractC11709dMo69828a.mo69846j(this.f52916e);
        }
        abstractC11709dMo69828a.m69839c(this.f52914c);
        if (this.f52916e != null) {
            abstractC11709dMo69828a.mo69845i();
        }
        abstractC11709dMo69828a.mo69838b();
    }

    /* renamed from: g */
    public final Object m67681g() {
        return this.f52914c;
    }

    /* renamed from: h */
    public C11277a m67682h(String str) {
        this.f52916e = str;
        return this;
    }
}
