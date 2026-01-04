package kotlinx.coroutines.internal;

import mw.InterfaceC11537d;
import tw.InterfaceC13086l;

/* renamed from: kotlinx.coroutines.internal.e */
/* loaded from: classes9.dex */
public final class C11088e {

    /* renamed from: a */
    public static final C11104u f52304a = new C11104u("UNDEFINED");

    /* renamed from: b */
    public static final C11104u f52305b = new C11104u("REUSABLE_CLAIMED");

    /* JADX WARN: Removed duplicated region for block: B:82:0x008f A[Catch: all -> 0x0068, DONT_GENERATE, TryCatch #0 {all -> 0x0068, blocks: (B:66:0x003f, B:68:0x004d, B:70:0x0053, B:83:0x0092, B:73:0x006a, B:75:0x007a, B:80:0x0089, B:82:0x008f, B:88:0x009f, B:91:0x00a8, B:90:0x00a5, B:78:0x0080), top: B:99:0x003f, inners: #1 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> void m66753b(mw.InterfaceC11537d<? super T> r6, java.lang.Object r7, tw.InterfaceC13086l<? super java.lang.Throwable, p408jw.C10951q> r8) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.internal.C11087d
            if (r0 == 0) goto Lb2
            kotlinx.coroutines.internal.d r6 = (kotlinx.coroutines.internal.C11087d) r6
            java.lang.Object r8 = p040bx.C1340r.m7826c(r7, r8)
            bx.t r0 = r6.f52300d
            mw.f r1 = r6.getContext()
            boolean r0 = r0.mo7788d(r1)
            r1 = 1
            if (r0 == 0) goto L26
            r6.f52302f = r8
            r6.f5794c = r1
            bx.t r7 = r6.f52300d
            mw.f r8 = r6.getContext()
            r7.mo7787c(r8, r6)
            goto Lb5
        L26:
            bx.i1 r0 = p040bx.C1319i1.f5807a
            bx.j0 r0 = r0.m7775a()
            boolean r2 = r0.m7780C()
            if (r2 == 0) goto L3b
            r6.f52302f = r8
            r6.f5794c = r1
            r0.m7785n(r6)
            goto Lb5
        L3b:
            r0.m7779A(r1)
            r2 = 0
            mw.f r3 = r6.getContext()     // Catch: java.lang.Throwable -> L68
            bx.u0$b r4 = p040bx.InterfaceC1347u0.f5846g2     // Catch: java.lang.Throwable -> L68
            mw.f$b r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L68
            bx.u0 r3 = (p040bx.InterfaceC1347u0) r3     // Catch: java.lang.Throwable -> L68
            if (r3 == 0) goto L6a
            boolean r4 = r3.mo7662s()     // Catch: java.lang.Throwable -> L68
            if (r4 != 0) goto L6a
            java.util.concurrent.CancellationException r7 = r3.mo7707t()     // Catch: java.lang.Throwable -> L68
            r6.mo7741a(r8, r7)     // Catch: java.lang.Throwable -> L68
            jw.k$a r8 = p408jw.C10945k.f51855a     // Catch: java.lang.Throwable -> L68
            java.lang.Object r7 = p408jw.C10946l.m66073a(r7)     // Catch: java.lang.Throwable -> L68
            java.lang.Object r7 = p408jw.C10945k.m66070b(r7)     // Catch: java.lang.Throwable -> L68
            r6.mo7657d(r7)     // Catch: java.lang.Throwable -> L68
            goto L92
        L68:
            r7 = move-exception
            goto La9
        L6a:
            mw.d<T> r8 = r6.f52301e     // Catch: java.lang.Throwable -> L68
            java.lang.Object r3 = r6.f52303g     // Catch: java.lang.Throwable -> L68
            mw.f r4 = r8.getContext()     // Catch: java.lang.Throwable -> L68
            java.lang.Object r3 = kotlinx.coroutines.internal.C11108y.m66819c(r4, r3)     // Catch: java.lang.Throwable -> L68
            kotlinx.coroutines.internal.u r5 = kotlinx.coroutines.internal.C11108y.f52334a     // Catch: java.lang.Throwable -> L68
            if (r3 == r5) goto L7f
            bx.k1 r8 = p040bx.C1342s.m7830c(r8, r4, r3)     // Catch: java.lang.Throwable -> L68
            goto L80
        L7f:
            r8 = r2
        L80:
            mw.d<T> r5 = r6.f52301e     // Catch: java.lang.Throwable -> L9c
            r5.mo7657d(r7)     // Catch: java.lang.Throwable -> L9c
            jw.q r7 = p408jw.C10951q.f51861a     // Catch: java.lang.Throwable -> L9c
            if (r8 == 0) goto L8f
            boolean r7 = r8.m7810l0()     // Catch: java.lang.Throwable -> L68
            if (r7 == 0) goto L92
        L8f:
            kotlinx.coroutines.internal.C11108y.m66817a(r4, r3)     // Catch: java.lang.Throwable -> L68
        L92:
            boolean r7 = r0.m7782E()     // Catch: java.lang.Throwable -> L68
            if (r7 != 0) goto L92
        L98:
            r0.m7783k(r1)
            goto Lb5
        L9c:
            r7 = move-exception
            if (r8 == 0) goto La5
            boolean r8 = r8.m7810l0()     // Catch: java.lang.Throwable -> L68
            if (r8 == 0) goto La8
        La5:
            kotlinx.coroutines.internal.C11108y.m66817a(r4, r3)     // Catch: java.lang.Throwable -> L68
        La8:
            throw r7     // Catch: java.lang.Throwable -> L68
        La9:
            r6.m7745h(r7, r2)     // Catch: java.lang.Throwable -> Lad
            goto L98
        Lad:
            r6 = move-exception
            r0.m7783k(r1)
            throw r6
        Lb2:
            r6.mo7657d(r7)
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.C11088e.m66753b(mw.d, java.lang.Object, tw.l):void");
    }

    /* renamed from: c */
    public static /* synthetic */ void m66754c(InterfaceC11537d interfaceC11537d, Object obj, InterfaceC13086l interfaceC13086l, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            interfaceC13086l = null;
        }
        m66753b(interfaceC11537d, obj, interfaceC13086l);
    }
}
