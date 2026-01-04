package p415k2;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.C1554j;
import com.bumptech.glide.ComponentCallbacks2C1546b;
import com.bumptech.glide.ComponentCallbacks2C1555k;
import com.bumptech.glide.request.RequestOptions;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import p003a2.InterfaceC0009d;
import p542p2.AbstractC12076c;
import p564q2.InterfaceC12275b;
import p599r2.C12459b;
import p630s2.C12676k;
import p630s2.C12677l;
import p725w1.InterfaceC13516a;
import p759x1.InterfaceC13681f;
import p759x1.InterfaceC13688m;
import p829z1.AbstractC14071j;

/* renamed from: k2.f */
/* loaded from: classes.dex */
public class C10977f {

    /* renamed from: a */
    public final InterfaceC13516a f52011a;

    /* renamed from: b */
    public final Handler f52012b;

    /* renamed from: c */
    public final List<b> f52013c;

    /* renamed from: d */
    public final ComponentCallbacks2C1555k f52014d;

    /* renamed from: e */
    public final InterfaceC0009d f52015e;

    /* renamed from: f */
    public boolean f52016f;

    /* renamed from: g */
    public boolean f52017g;

    /* renamed from: h */
    public boolean f52018h;

    /* renamed from: i */
    public C1554j<Bitmap> f52019i;

    /* renamed from: j */
    public a f52020j;

    /* renamed from: k */
    public boolean f52021k;

    /* renamed from: l */
    public a f52022l;

    /* renamed from: m */
    public Bitmap f52023m;

    /* renamed from: n */
    public InterfaceC13688m<Bitmap> f52024n;

    /* renamed from: o */
    public a f52025o;

    /* renamed from: p */
    public int f52026p;

    /* renamed from: q */
    public int f52027q;

    /* renamed from: r */
    public int f52028r;

    /* renamed from: k2.f$a */
    public static class a extends AbstractC12076c<Bitmap> {

        /* renamed from: d */
        public final Handler f52029d;

        /* renamed from: e */
        public final int f52030e;

        /* renamed from: f */
        public final long f52031f;

        /* renamed from: g */
        public Bitmap f52032g;

        public a(Handler handler, int i10, long j10) {
            this.f52029d = handler;
            this.f52030e = i10;
            this.f52031f = j10;
        }

        @Override // p542p2.InterfaceC12082i
        /* renamed from: h */
        public void mo66338h(Drawable drawable) {
            this.f52032g = null;
        }

        /* renamed from: i */
        public Bitmap m66339i() {
            return this.f52032g;
        }

        @Override // p542p2.InterfaceC12082i
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void mo53348c(Bitmap bitmap, InterfaceC12275b<? super Bitmap> interfaceC12275b) {
            this.f52032g = bitmap;
            this.f52029d.sendMessageAtTime(this.f52029d.obtainMessage(1, this), this.f52031f);
        }
    }

    /* renamed from: k2.f$b */
    public interface b {
        /* renamed from: a */
        void mo66303a();
    }

    /* renamed from: k2.f$c */
    public class c implements Handler.Callback {
        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                C10977f.this.m66331m((a) message.obj);
                return true;
            }
            if (i10 != 2) {
                return false;
            }
            C10977f.this.f52014d.m8979m((a) message.obj);
            return false;
        }
    }

    public C10977f(ComponentCallbacks2C1546b componentCallbacks2C1546b, InterfaceC13516a interfaceC13516a, int i10, int i11, InterfaceC13688m<Bitmap> interfaceC13688m, Bitmap bitmap) {
        this(componentCallbacks2C1546b.m8907f(), ComponentCallbacks2C1546b.m8904t(componentCallbacks2C1546b.m8909h()), interfaceC13516a, null, m66320i(ComponentCallbacks2C1546b.m8904t(componentCallbacks2C1546b.m8909h()), i10, i11), interfaceC13688m, bitmap);
    }

    /* renamed from: g */
    public static InterfaceC13681f m66319g() {
        return new C12459b(Double.valueOf(Math.random()));
    }

    /* renamed from: i */
    public static C1554j<Bitmap> m66320i(ComponentCallbacks2C1555k componentCallbacks2C1555k, int i10, int i11) {
        return componentCallbacks2C1555k.m8976j().apply(RequestOptions.diskCacheStrategyOf(AbstractC14071j.f62955b).useAnimationPool(true).skipMemoryCache(true).override(i10, i11));
    }

    /* renamed from: a */
    public void m66321a() {
        this.f52013c.clear();
        m66332n();
        m66335q();
        a aVar = this.f52020j;
        if (aVar != null) {
            this.f52014d.m8979m(aVar);
            this.f52020j = null;
        }
        a aVar2 = this.f52022l;
        if (aVar2 != null) {
            this.f52014d.m8979m(aVar2);
            this.f52022l = null;
        }
        a aVar3 = this.f52025o;
        if (aVar3 != null) {
            this.f52014d.m8979m(aVar3);
            this.f52025o = null;
        }
        this.f52011a.clear();
        this.f52021k = true;
    }

    /* renamed from: b */
    public ByteBuffer m66322b() {
        return this.f52011a.getData().asReadOnlyBuffer();
    }

    /* renamed from: c */
    public Bitmap m66323c() {
        a aVar = this.f52020j;
        return aVar != null ? aVar.m66339i() : this.f52023m;
    }

    /* renamed from: d */
    public int m66324d() {
        a aVar = this.f52020j;
        if (aVar != null) {
            return aVar.f52030e;
        }
        return -1;
    }

    /* renamed from: e */
    public Bitmap m66325e() {
        return this.f52023m;
    }

    /* renamed from: f */
    public int m66326f() {
        return this.f52011a.mo81278c();
    }

    /* renamed from: h */
    public int m66327h() {
        return this.f52028r;
    }

    /* renamed from: j */
    public int m66328j() {
        return this.f52011a.mo81283h() + this.f52026p;
    }

    /* renamed from: k */
    public int m66329k() {
        return this.f52027q;
    }

    /* renamed from: l */
    public final void m66330l() {
        if (!this.f52016f || this.f52017g) {
            return;
        }
        if (this.f52018h) {
            C12676k.m76273a(this.f52025o == null, "Pending target must be null when starting from the first frame");
            this.f52011a.mo81281f();
            this.f52018h = false;
        }
        a aVar = this.f52025o;
        if (aVar != null) {
            this.f52025o = null;
            m66331m(aVar);
            return;
        }
        this.f52017g = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + this.f52011a.mo81279d();
        this.f52011a.mo81277b();
        this.f52022l = new a(this.f52012b, this.f52011a.mo81282g(), jUptimeMillis);
        this.f52019i.apply(RequestOptions.signatureOf(m66319g())).m8970s(this.f52011a).m8962k(this.f52022l);
    }

    /* renamed from: m */
    public void m66331m(a aVar) {
        this.f52017g = false;
        if (this.f52021k) {
            this.f52012b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f52016f) {
            if (this.f52018h) {
                this.f52012b.obtainMessage(2, aVar).sendToTarget();
                return;
            } else {
                this.f52025o = aVar;
                return;
            }
        }
        if (aVar.m66339i() != null) {
            m66332n();
            a aVar2 = this.f52020j;
            this.f52020j = aVar;
            for (int size = this.f52013c.size() - 1; size >= 0; size--) {
                this.f52013c.get(size).mo66303a();
            }
            if (aVar2 != null) {
                this.f52012b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        m66330l();
    }

    /* renamed from: n */
    public final void m66332n() {
        Bitmap bitmap = this.f52023m;
        if (bitmap != null) {
            this.f52015e.mo15b(bitmap);
            this.f52023m = null;
        }
    }

    /* renamed from: o */
    public void m66333o(InterfaceC13688m<Bitmap> interfaceC13688m, Bitmap bitmap) {
        this.f52024n = (InterfaceC13688m) C12676k.m76276d(interfaceC13688m);
        this.f52023m = (Bitmap) C12676k.m76276d(bitmap);
        this.f52019i = this.f52019i.apply(new RequestOptions().transform(interfaceC13688m));
        this.f52026p = C12677l.m76284g(bitmap);
        this.f52027q = bitmap.getWidth();
        this.f52028r = bitmap.getHeight();
    }

    /* renamed from: p */
    public final void m66334p() {
        if (this.f52016f) {
            return;
        }
        this.f52016f = true;
        this.f52021k = false;
        m66330l();
    }

    /* renamed from: q */
    public final void m66335q() {
        this.f52016f = false;
    }

    /* renamed from: r */
    public void m66336r(b bVar) {
        if (this.f52021k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.f52013c.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = this.f52013c.isEmpty();
        this.f52013c.add(bVar);
        if (zIsEmpty) {
            m66334p();
        }
    }

    /* renamed from: s */
    public void m66337s(b bVar) {
        this.f52013c.remove(bVar);
        if (this.f52013c.isEmpty()) {
            m66335q();
        }
    }

    public C10977f(InterfaceC0009d interfaceC0009d, ComponentCallbacks2C1555k componentCallbacks2C1555k, InterfaceC13516a interfaceC13516a, Handler handler, C1554j<Bitmap> c1554j, InterfaceC13688m<Bitmap> interfaceC13688m, Bitmap bitmap) {
        this.f52013c = new ArrayList();
        this.f52014d = componentCallbacks2C1555k;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f52015e = interfaceC0009d;
        this.f52012b = handler;
        this.f52019i = c1554j;
        this.f52011a = interfaceC13516a;
        m66333o(interfaceC13688m, bitmap);
    }
}
