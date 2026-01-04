package p042c0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import p243e0.C9373h;
import p723w.C13507f;

/* renamed from: c0.g */
/* loaded from: classes.dex */
public class C1374g {

    /* renamed from: c0.g$a */
    public static class a {

        /* renamed from: a */
        public final int f5905a;

        /* renamed from: b */
        public final b[] f5906b;

        @Deprecated
        public a(int i10, b[] bVarArr) {
            this.f5905a = i10;
            this.f5906b = bVarArr;
        }

        /* renamed from: a */
        public static a m7899a(int i10, b[] bVarArr) {
            return new a(i10, bVarArr);
        }

        /* renamed from: b */
        public b[] m7900b() {
            return this.f5906b;
        }

        /* renamed from: c */
        public int m7901c() {
            return this.f5905a;
        }
    }

    /* renamed from: c0.g$b */
    public static class b {

        /* renamed from: a */
        public final Uri f5907a;

        /* renamed from: b */
        public final int f5908b;

        /* renamed from: c */
        public final int f5909c;

        /* renamed from: d */
        public final boolean f5910d;

        /* renamed from: e */
        public final int f5911e;

        @Deprecated
        public b(Uri uri, int i10, int i11, boolean z10, int i12) {
            this.f5907a = (Uri) C9373h.m58745f(uri);
            this.f5908b = i10;
            this.f5909c = i11;
            this.f5910d = z10;
            this.f5911e = i12;
        }

        /* renamed from: a */
        public static b m7902a(Uri uri, int i10, int i11, boolean z10, int i12) {
            return new b(uri, i10, i11, z10, i12);
        }

        /* renamed from: b */
        public int m7903b() {
            return this.f5911e;
        }

        /* renamed from: c */
        public int m7904c() {
            return this.f5908b;
        }

        /* renamed from: d */
        public Uri m7905d() {
            return this.f5907a;
        }

        /* renamed from: e */
        public int m7906e() {
            return this.f5909c;
        }

        /* renamed from: f */
        public boolean m7907f() {
            return this.f5910d;
        }
    }

    /* renamed from: c0.g$c */
    public static class c {
        /* renamed from: a */
        public void mo7908a(int i10) {
            throw null;
        }

        /* renamed from: b */
        public void mo7909b(Typeface typeface) {
            throw null;
        }
    }

    /* renamed from: a */
    public static Typeface m7896a(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return C13507f.m81247b(context, cancellationSignal, bVarArr, 0);
    }

    /* renamed from: b */
    public static a m7897b(Context context, CancellationSignal cancellationSignal, C1372e c1372e) throws PackageManager.NameNotFoundException {
        return C1371d.m7874e(context, c1372e, cancellationSignal);
    }

    /* renamed from: c */
    public static Typeface m7898c(Context context, C1372e c1372e, int i10, boolean z10, int i11, Handler handler, c cVar) {
        C1368a c1368a = new C1368a(cVar, handler);
        return z10 ? C1373f.m7890e(context, c1372e, c1368a, i10, i11) : C1373f.m7889d(context, c1372e, i10, null, c1368a);
    }
}
