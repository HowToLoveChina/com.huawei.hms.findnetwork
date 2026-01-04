package p369ii;

import com.huawei.cloud.base.http.AbstractC4619v;
import com.huawei.cloud.base.http.C4595a0;
import com.huawei.cloud.base.http.C4604g;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4612o;
import com.huawei.cloud.base.http.C4613p;
import com.huawei.cloud.base.http.C4615r;
import com.huawei.cloud.base.http.InterfaceC4608k;
import com.huawei.cloud.base.http.InterfaceC4614q;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.hms.drive.C5284g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p811yi.C13986a;

/* renamed from: ii.b */
/* loaded from: classes.dex */
public final class C10511b {

    /* renamed from: c */
    public static C4604g f50670c;

    /* renamed from: a */
    public List<b<?, ?>> f50671a = new ArrayList();

    /* renamed from: b */
    public final C4613p f50672b;

    /* renamed from: ii.b$a */
    public class a implements InterfaceC4608k {

        /* renamed from: a */
        public InterfaceC4608k f50673a;

        public a(InterfaceC4608k interfaceC4608k) {
            this.f50673a = interfaceC4608k;
        }

        @Override // com.huawei.cloud.base.http.InterfaceC4608k
        /* renamed from: c */
        public void mo28207c(C4612o c4612o) throws IOException {
            InterfaceC4608k interfaceC4608k = this.f50673a;
            if (interfaceC4608k != null) {
                interfaceC4608k.mo28207c(c4612o);
            }
            for (b<?, ?> bVar : C10511b.this.f50671a) {
                InterfaceC4608k interfaceC4608kM28279k = bVar.f50678d.m28279k();
                if (interfaceC4608kM28279k != null) {
                    interfaceC4608kM28279k.mo28207c(bVar.f50678d);
                }
            }
        }
    }

    /* renamed from: ii.b$b */
    public static class b<T, E> {

        /* renamed from: a */
        public final InterfaceC10510a<T, E> f50675a;

        /* renamed from: b */
        public final Class<T> f50676b;

        /* renamed from: c */
        public final Class<E> f50677c;

        /* renamed from: d */
        public final C4612o f50678d;

        public b(InterfaceC10510a<T, E> interfaceC10510a, Class<T> cls, Class<E> cls2, C4612o c4612o) {
            this.f50675a = interfaceC10510a;
            this.f50676b = cls;
            this.f50677c = cls2;
            this.f50678d = c4612o;
        }
    }

    public C10511b(AbstractC4619v abstractC4619v, InterfaceC4614q interfaceC4614q) {
        this.f50672b = interfaceC4614q == null ? abstractC4619v.createRequestFactory() : abstractC4619v.createRequestFactory(interfaceC4614q);
    }

    /* renamed from: b */
    public static C4604g m64596b() {
        return f50670c;
    }

    /* renamed from: a */
    public void m64597a() throws IOException {
        boolean z10;
        C4627a0.m28394g(!this.f50671a.isEmpty());
        C4612o c4612oM28298b = this.f50672b.m28298b(f50670c, null);
        c4612oM28298b.m28277i().set("x-hw-trace-id", C5284g.m31720a(C5284g.m31721b(c4612oM28298b.getClass().getName())));
        c4612oM28298b.m28277i().set("x-hw-app-id", C13986a.f62675b);
        c4612oM28298b.m28277i().set("version", "5.2.0.100");
        c4612oM28298b.m28277i().m28228T(C13986a.f62676c + "/" + C13986a.f62677d);
        c4612oM28298b.m28261B(new a(c4612oM28298b.m28279k()));
        c4612oM28298b.m28262C(this.f50671a.get(0).f50678d.m28281m());
        int iM28280l = c4612oM28298b.m28280l();
        do {
            z10 = iM28280l > 0;
            C4595a0 c4595a0 = new C4595a0();
            c4595a0.m28156f().m28258m("mixed");
            Iterator<b<?, ?>> it = this.f50671a.iterator();
            int i10 = 1;
            while (it.hasNext()) {
                c4595a0.m28158g(new C4595a0.a(new C4609l().m28215F(null).set("Content-ID", Integer.valueOf(i10)), new C10513d(it.next().f50678d)));
                i10++;
            }
            c4612oM28298b.m28292x(c4595a0);
            C4615r c4615rM28272d = c4612oM28298b.m28272d();
            try {
                C10512c c10512c = new C10512c(c4615rM28272d.m28306c(), "--" + c4615rM28272d.m28309f().m28252e("boundary"), this.f50671a, z10);
                while (c10512c.f50684f) {
                    c10512c.m64607e();
                }
                c4615rM28272d.m28304a();
                List<b<?, ?>> list = c10512c.f50685g;
                if (list.isEmpty()) {
                    break;
                }
                this.f50671a = list;
                iM28280l--;
            } catch (Throwable th2) {
                c4615rM28272d.m28304a();
                throw th2;
            }
        } while (z10);
        this.f50671a.clear();
    }

    /* renamed from: c */
    public <T, E> C10511b m64598c(C4612o c4612o, Class<T> cls, Class<E> cls2, InterfaceC10510a<T, E> interfaceC10510a) throws IOException {
        C4627a0.m28391d(c4612o);
        C4627a0.m28391d(interfaceC10510a);
        C4627a0.m28391d(cls);
        C4627a0.m28391d(cls2);
        this.f50671a.add(new b<>(interfaceC10510a, cls, cls2, c4612o));
        return this;
    }

    /* renamed from: d */
    public C10511b m64599d(C4604g c4604g) {
        f50670c = c4604g;
        return this;
    }

    /* renamed from: e */
    public int m64600e() {
        return this.f50671a.size();
    }
}
