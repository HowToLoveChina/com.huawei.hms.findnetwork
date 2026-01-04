package p216d4;

import android.content.Context;
import com.huawei.ads.adsrec.C2094k0;
import com.huawei.ads.adsrec.C2097s;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import p277f4.C9655a;
import p384j4.AbstractC10708g;
import p405jt.AbstractC10915a;

/* renamed from: d4.x */
/* loaded from: classes.dex */
public class C9037x extends AbstractC9039z {

    /* renamed from: d4.x$a */
    public class a implements Callable<C9020l> {

        /* renamed from: a */
        public final /* synthetic */ C9655a f45693a;

        /* renamed from: b */
        public final /* synthetic */ Object f45694b;

        public a(C9655a c9655a, Object obj) {
            this.f45693a = c9655a;
            this.f45694b = obj;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C9020l call() {
            return new C2094k0(C9037x.this.f45699a).mo12550b(this.f45693a, this.f45694b);
        }
    }

    /* renamed from: d4.x$b */
    public class b implements Callable<C9020l> {

        /* renamed from: a */
        public final /* synthetic */ C9655a f45696a;

        /* renamed from: b */
        public final /* synthetic */ Object f45697b;

        public b(C9655a c9655a, Object obj) {
            this.f45696a = c9655a;
            this.f45697b = obj;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C9020l call() {
            return new C2097s(C9037x.this.f45699a).mo12550b(this.f45696a, this.f45697b);
        }
    }

    public C9037x(Context context, InterfaceC9028p interfaceC9028p) {
        super(context, interfaceC9028p);
    }

    @Override // p216d4.InterfaceC9011g0
    /* renamed from: a */
    public <T> C9020l mo56873a(C9655a c9655a, C9020l c9020l) {
        return c9020l;
    }

    @Override // p216d4.InterfaceC9011g0
    /* renamed from: b */
    public <T> C9020l mo56874b(C9655a c9655a, T t10) {
        C9020l c9020l;
        AbstractC10915a.m65972d("LRFS", "recall");
        Future futureM65387a = AbstractC10708g.m65387a(new a(c9655a, t10));
        Future futureM65387a2 = AbstractC10708g.m65387a(new b(c9655a, t10));
        C9020l c9020l2 = null;
        try {
            c9020l = (C9020l) futureM65387a.get();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            c9655a.m60301g(1);
            InterfaceC9028p interfaceC9028p = this.f45700b;
            if (interfaceC9028p != null) {
                interfaceC9028p.mo12559a(c9020l);
            }
            boolean zM56991c = m56991c(c9020l);
            AbstractC10915a.m65973e("LRFS", "ad rsp empty: %s", Boolean.valueOf(zM56991c));
            if (!zM56991c) {
                return c9020l;
            }
            c9020l2 = (C9020l) futureM65387a2.get();
            c9655a.m60301g(0);
            return c9020l2;
        } catch (Throwable th3) {
            th = th3;
            c9020l2 = c9020l;
            AbstractC10915a.m65979k("LRFS", "recall with future error: %s", th.getClass().getSimpleName());
            return c9020l2;
        }
    }

    /* renamed from: c */
    public final boolean m56991c(C9020l c9020l) {
        if (c9020l == null) {
            return true;
        }
        return c9020l.m56947r();
    }
}
