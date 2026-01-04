package p216d4;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.ads.adsrec.C2093e;
import java.util.List;
import p277f4.C9655a;
import p384j4.AbstractC10702a;
import p405jt.AbstractC10915a;

/* renamed from: d4.f */
/* loaded from: classes.dex */
public class C9008f implements InterfaceC9032s {

    /* renamed from: a */
    public Context f45627a;

    /* renamed from: b */
    public InterfaceC9028p f45628b;

    /* renamed from: d4.f$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ C9020l f45629a;

        /* renamed from: b */
        public final /* synthetic */ int f45630b;

        public a(C9020l c9020l, int i10) {
            this.f45629a = c9020l;
            this.f45630b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2093e c2093e = new C2093e(C9008f.this.f45627a);
            C9020l c9020l = this.f45629a;
            if (c9020l != null) {
                c2093e.mo12537d(c9020l.m56941l());
                c2093e.mo12531a(this.f45629a.m56946q(), this.f45630b);
            }
        }
    }

    public C9008f(Context context, InterfaceC9028p interfaceC9028p) {
        this.f45627a = context.getApplicationContext();
        this.f45628b = interfaceC9028p;
    }

    @Override // p216d4.InterfaceC9032s
    /* renamed from: a */
    public <T> C9020l mo12549a(C9655a c9655a, C9020l c9020l) {
        AbstractC10915a.m65972d("FullRecallTask", "recall via api");
        if (c9655a == null) {
            return null;
        }
        m56885h(c9655a);
        String strM56882e = m56882e(c9655a);
        if (TextUtils.isEmpty(strM56882e)) {
            AbstractC10915a.m65978j("FullRecallTask", "no slot id");
            return null;
        }
        int iM56961g = C9027o0.m56955b(this.f45627a).m56961g(strM56882e);
        C9020l c9020lMo56873a = m56884g(this.f45627a, iM56961g, this.f45628b).mo56873a(c9655a, c9020l);
        if (c9020lMo56873a != null) {
            c9020lMo56873a.m56942m(iM56961g);
            m56883f(c9020lMo56873a.m56935c(), c9655a.m60307m());
        }
        return c9020lMo56873a;
    }

    @Override // p216d4.InterfaceC9032s
    /* renamed from: b */
    public <T> C9020l mo12550b(C9655a c9655a, T t10) {
        AbstractC10915a.m65972d("FullRecallTask", "recall");
        if (c9655a == null) {
            return null;
        }
        m56885h(c9655a);
        String strM56882e = m56882e(c9655a);
        if (TextUtils.isEmpty(strM56882e)) {
            AbstractC10915a.m65978j("FullRecallTask", "no slot id");
            return null;
        }
        int iM56961g = C9027o0.m56955b(this.f45627a).m56961g(strM56882e);
        C9020l c9020lMo56874b = m56881d(this.f45627a, iM56961g, this.f45628b).mo56874b(c9655a, t10);
        if (c9020lMo56874b != null) {
            c9020lMo56874b.m56942m(iM56961g);
            m56883f(c9020lMo56874b.m56935c(), c9655a.m60307m());
        }
        return c9020lMo56874b;
    }

    /* renamed from: d */
    public InterfaceC9011g0 m56881d(Context context, int i10, InterfaceC9028p interfaceC9028p) {
        AbstractC10915a.m65973e("FullRecallTask", "create recall strategy: %s", Integer.valueOf(i10));
        return i10 != 1 ? i10 != 2 ? new C9009f0(context, interfaceC9028p) : new C9037x(context, interfaceC9028p) : new C9007e0(context, interfaceC9028p);
    }

    /* renamed from: e */
    public final String m56882e(C9655a c9655a) {
        List<String> listM60296b = c9655a.m60296b();
        if (listM60296b == null || listM60296b.size() <= 0) {
            return null;
        }
        return listM60296b.get(0);
    }

    /* renamed from: f */
    public final void m56883f(C9020l c9020l, int i10) {
        AbstractC10702a.m65329h(new a(c9020l, i10));
    }

    /* renamed from: g */
    public InterfaceC9011g0 m56884g(Context context, int i10, InterfaceC9028p interfaceC9028p) {
        AbstractC10915a.m65973e("FullRecallTask", "create recall strategy via api: %s", Integer.valueOf(i10));
        return (i10 == 1 || i10 == 2) ? new C9007e0(context, interfaceC9028p) : new C9009f0(context, interfaceC9028p);
    }

    /* renamed from: h */
    public final void m56885h(C9655a c9655a) {
        AbstractC9017j0.m56928b(c9655a.m60304j(), c9655a.m60307m(), c9655a.m60300f());
    }
}
