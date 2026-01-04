package p216d4;

import android.content.Context;
import com.huawei.ads.adsrec.C2094k0;
import com.huawei.ads.adsrec.C2097s;
import java.util.List;
import java.util.concurrent.Callable;
import p277f4.C9655a;

/* renamed from: d4.e0 */
/* loaded from: classes.dex */
public class C9007e0 extends AbstractC9039z {

    /* renamed from: d4.e0$a */
    public class a implements Callable<C9020l> {

        /* renamed from: a */
        public final /* synthetic */ C9655a f45621a;

        /* renamed from: b */
        public final /* synthetic */ Object f45622b;

        public a(C9655a c9655a, Object obj) {
            this.f45621a = c9655a;
            this.f45622b = obj;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C9020l call() {
            return new C2097s(C9007e0.this.f45699a).mo12550b(this.f45621a, this.f45622b);
        }
    }

    /* renamed from: d4.e0$b */
    public class b implements Callable<C9020l> {

        /* renamed from: a */
        public final /* synthetic */ C9655a f45624a;

        /* renamed from: b */
        public final /* synthetic */ Object f45625b;

        public b(C9655a c9655a, Object obj) {
            this.f45624a = c9655a;
            this.f45625b = obj;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C9020l call() {
            return C9007e0.this.m56877f(this.f45624a, this.f45625b);
        }
    }

    public C9007e0(Context context, InterfaceC9028p interfaceC9028p) {
        super(context, interfaceC9028p);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    @Override // p216d4.InterfaceC9011g0
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> p216d4.C9020l mo56873a(p277f4.C9655a r3, p216d4.C9020l r4) {
        /*
            r2 = this;
            com.huawei.ads.adsrec.s r0 = new com.huawei.ads.adsrec.s
            android.content.Context r1 = r2.f45699a
            r0.<init>(r1)
            r0.mo12549a(r3, r4)
            if (r4 == 0) goto L1f
            java.util.List r0 = r4.m56946q()
            boolean r1 = p384j4.AbstractC10706e.m65374a(r0)
            if (r1 != 0) goto L1a
            r2.m56875d(r3, r0, r4)
            goto L27
        L1a:
            d4.l r4 = r2.m56876e(r3, r4)
            goto L27
        L1f:
            java.lang.String r0 = "CRFS"
            java.lang.String r1 = "no ad response"
            p405jt.AbstractC10915a.m65972d(r0, r1)
            goto L1a
        L27:
            d4.p r2 = r2.f45700b
            if (r2 == 0) goto L2e
            r2.mo12559a(r4)
        L2e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p216d4.C9007e0.mo56873a(f4.a, d4.l):d4.l");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004e A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #0 {all -> 0x0052, blocks: (B:3:0x001a, B:15:0x0047, B:16:0x004a, B:18:0x004e), top: B:25:0x001a }] */
    @Override // p216d4.InterfaceC9011g0
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> p216d4.C9020l mo56874b(p277f4.C9655a r5, T r6) {
        /*
            r4 = this;
            java.lang.String r0 = "recall"
            java.lang.String r1 = "CRFS"
            p405jt.AbstractC10915a.m65972d(r1, r0)
            d4.e0$a r0 = new d4.e0$a
            r0.<init>(r5, r6)
            java.util.concurrent.Future r0 = p384j4.AbstractC10708g.m65387a(r0)
            d4.e0$b r2 = new d4.e0$b
            r2.<init>(r5, r6)
            java.util.concurrent.Future r6 = p384j4.AbstractC10708g.m65387a(r2)
            r2 = 0
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L52
            d4.l r0 = (p216d4.C9020l) r0     // Catch: java.lang.Throwable -> L52
            if (r0 != 0) goto L32
            java.lang.String r2 = "no ad response"
            p405jt.AbstractC10915a.m65972d(r1, r2)     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r6 = r6.get()     // Catch: java.lang.Throwable -> L2f
        L2b:
            d4.l r6 = (p216d4.C9020l) r6     // Catch: java.lang.Throwable -> L2f
            r2 = r6
            goto L46
        L2f:
            r4 = move-exception
            r2 = r0
            goto L55
        L32:
            java.util.List r2 = r0.m56946q()     // Catch: java.lang.Throwable -> L2f
            boolean r3 = p384j4.AbstractC10706e.m65374a(r2)     // Catch: java.lang.Throwable -> L2f
            if (r3 != 0) goto L41
            r4.m56875d(r5, r2, r0)     // Catch: java.lang.Throwable -> L2f
            r2 = r0
            goto L4a
        L41:
            java.lang.Object r6 = r6.get()     // Catch: java.lang.Throwable -> L2f
            goto L2b
        L46:
            r6 = 1
            r5.m60301g(r6)     // Catch: java.lang.Throwable -> L52
        L4a:
            d4.p r4 = r4.f45700b     // Catch: java.lang.Throwable -> L52
            if (r4 == 0) goto L54
            r4.mo12559a(r2)     // Catch: java.lang.Throwable -> L52
            goto L54
        L52:
            r4 = move-exception
            goto L55
        L54:
            return r2
        L55:
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getSimpleName()
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.String r5 = "recall with future error: %s"
            p405jt.AbstractC10915a.m65979k(r1, r5, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p216d4.C9007e0.mo56874b(f4.a, java.lang.Object):d4.l");
    }

    /* renamed from: d */
    public final void m56875d(C9655a c9655a, List<C9031r> list, C9020l c9020l) {
        for (C9031r c9031r : list) {
            if (c9031r.m56978s()) {
                c9031r.m56976q();
                C9031r c9031rM56948a = C9021l0.m56948a(this.f45699a, c9655a.m60304j(), c9031r.m56976q(), c9655a.m60307m());
                if (c9031rM56948a != null) {
                    c9031r.m56968i(c9031rM56948a);
                }
            }
            if (!c9031r.m56978s()) {
                c9020l.m56937g(200);
            }
        }
    }

    /* renamed from: e */
    public final C9020l m56876e(C9655a c9655a, C9020l c9020l) {
        return new C2094k0(this.f45699a).mo12549a(c9655a, c9020l);
    }

    /* renamed from: f */
    public final <T> C9020l m56877f(C9655a c9655a, T t10) {
        return new C2094k0(this.f45699a).mo12550b(c9655a, t10);
    }
}
