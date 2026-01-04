package p303g;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
import p273f0.C9615n0;
import p273f0.C9619p0;
import p273f0.InterfaceC9617o0;

/* renamed from: g.g */
/* loaded from: classes.dex */
public class C9819g {

    /* renamed from: c */
    public Interpolator f48259c;

    /* renamed from: d */
    public InterfaceC9617o0 f48260d;

    /* renamed from: e */
    public boolean f48261e;

    /* renamed from: b */
    public long f48258b = -1;

    /* renamed from: f */
    public final C9619p0 f48262f = new a();

    /* renamed from: a */
    public final ArrayList<C9615n0> f48257a = new ArrayList<>();

    /* renamed from: g.g$a */
    public class a extends C9619p0 {

        /* renamed from: a */
        public boolean f48263a = false;

        /* renamed from: b */
        public int f48264b = 0;

        public a() {
        }

        @Override // p273f0.InterfaceC9617o0
        /* renamed from: b */
        public void mo2156b(View view) {
            int i10 = this.f48264b + 1;
            this.f48264b = i10;
            if (i10 == C9819g.this.f48257a.size()) {
                InterfaceC9617o0 interfaceC9617o0 = C9819g.this.f48260d;
                if (interfaceC9617o0 != null) {
                    interfaceC9617o0.mo2156b(null);
                }
                m61020d();
            }
        }

        @Override // p273f0.C9619p0, p273f0.InterfaceC9617o0
        /* renamed from: c */
        public void mo2157c(View view) {
            if (this.f48263a) {
                return;
            }
            this.f48263a = true;
            InterfaceC9617o0 interfaceC9617o0 = C9819g.this.f48260d;
            if (interfaceC9617o0 != null) {
                interfaceC9617o0.mo2157c(null);
            }
        }

        /* renamed from: d */
        public void m61020d() {
            this.f48264b = 0;
            this.f48263a = false;
            C9819g.this.m61013b();
        }
    }

    /* renamed from: a */
    public void m61012a() {
        if (this.f48261e) {
            Iterator<C9615n0> it = this.f48257a.iterator();
            while (it.hasNext()) {
                it.next().m60109c();
            }
            this.f48261e = false;
        }
    }

    /* renamed from: b */
    public void m61013b() {
        this.f48261e = false;
    }

    /* renamed from: c */
    public C9819g m61014c(C9615n0 c9615n0) {
        if (!this.f48261e) {
            this.f48257a.add(c9615n0);
        }
        return this;
    }

    /* renamed from: d */
    public C9819g m61015d(C9615n0 c9615n0, C9615n0 c9615n02) {
        this.f48257a.add(c9615n0);
        c9615n02.m60115j(c9615n0.m60110d());
        this.f48257a.add(c9615n02);
        return this;
    }

    /* renamed from: e */
    public C9819g m61016e(long j10) {
        if (!this.f48261e) {
            this.f48258b = j10;
        }
        return this;
    }

    /* renamed from: f */
    public C9819g m61017f(Interpolator interpolator) {
        if (!this.f48261e) {
            this.f48259c = interpolator;
        }
        return this;
    }

    /* renamed from: g */
    public C9819g m61018g(InterfaceC9617o0 interfaceC9617o0) {
        if (!this.f48261e) {
            this.f48260d = interfaceC9617o0;
        }
        return this;
    }

    /* renamed from: h */
    public void m61019h() {
        if (this.f48261e) {
            return;
        }
        Iterator<C9615n0> it = this.f48257a.iterator();
        while (it.hasNext()) {
            C9615n0 next = it.next();
            long j10 = this.f48258b;
            if (j10 >= 0) {
                next.m60111f(j10);
            }
            Interpolator interpolator = this.f48259c;
            if (interpolator != null) {
                next.m60112g(interpolator);
            }
            if (this.f48260d != null) {
                next.m60113h(this.f48262f);
            }
            next.m60117l();
        }
        this.f48261e = true;
    }
}
