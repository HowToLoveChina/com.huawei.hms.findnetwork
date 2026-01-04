package p042c0;

import android.graphics.Typeface;
import android.os.Handler;
import p042c0.C1373f;
import p042c0.C1374g;

/* renamed from: c0.a */
/* loaded from: classes.dex */
public class C1368a {

    /* renamed from: a */
    public final C1374g.c f5874a;

    /* renamed from: b */
    public final Handler f5875b;

    /* renamed from: c0.a$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ C1374g.c f5876a;

        /* renamed from: b */
        public final /* synthetic */ Typeface f5877b;

        public a(C1374g.c cVar, Typeface typeface) {
            this.f5876a = cVar;
            this.f5877b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5876a.mo7909b(this.f5877b);
        }
    }

    /* renamed from: c0.a$b */
    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ C1374g.c f5879a;

        /* renamed from: b */
        public final /* synthetic */ int f5880b;

        public b(C1374g.c cVar, int i10) {
            this.f5879a = cVar;
            this.f5880b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5879a.mo7908a(this.f5880b);
        }
    }

    public C1368a(C1374g.c cVar, Handler handler) {
        this.f5874a = cVar;
        this.f5875b = handler;
    }

    /* renamed from: a */
    public final void m7866a(int i10) {
        this.f5875b.post(new b(this.f5874a, i10));
    }

    /* renamed from: b */
    public void m7867b(C1373f.e eVar) {
        if (eVar.m7895a()) {
            m7868c(eVar.f5903a);
        } else {
            m7866a(eVar.f5904b);
        }
    }

    /* renamed from: c */
    public final void m7868c(Typeface typeface) {
        this.f5875b.post(new a(this.f5874a, typeface));
    }
}
