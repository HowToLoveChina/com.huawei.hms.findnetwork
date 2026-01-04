package p042c0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import p042c0.C1374g;
import p243e0.InterfaceC9366a;
import p438l.C11211e;
import p438l.C11213g;
import p723w.C13507f;

/* renamed from: c0.f */
/* loaded from: classes.dex */
public class C1373f {

    /* renamed from: a */
    public static final C11211e<String, Typeface> f5889a = new C11211e<>(16);

    /* renamed from: b */
    public static final ExecutorService f5890b = C1375h.m7910a("fonts-androidx", 10, 10000);

    /* renamed from: c */
    public static final Object f5891c = new Object();

    /* renamed from: d */
    public static final C11213g<String, ArrayList<InterfaceC9366a<e>>> f5892d = new C11213g<>();

    /* renamed from: c0.f$a */
    public class a implements Callable<e> {

        /* renamed from: a */
        public final /* synthetic */ String f5893a;

        /* renamed from: b */
        public final /* synthetic */ Context f5894b;

        /* renamed from: c */
        public final /* synthetic */ C1372e f5895c;

        /* renamed from: d */
        public final /* synthetic */ int f5896d;

        public a(String str, Context context, C1372e c1372e, int i10) {
            this.f5893a = str;
            this.f5894b = context;
            this.f5895c = c1372e;
            this.f5896d = i10;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public e call() {
            return C1373f.m7888c(this.f5893a, this.f5894b, this.f5895c, this.f5896d);
        }
    }

    /* renamed from: c0.f$b */
    public class b implements InterfaceC9366a<e> {

        /* renamed from: a */
        public final /* synthetic */ C1368a f5897a;

        public b(C1368a c1368a) {
            this.f5897a = c1368a;
        }

        @Override // p243e0.InterfaceC9366a
        /* renamed from: a */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f5897a.m7867b(eVar);
        }
    }

    /* renamed from: c0.f$c */
    public class c implements Callable<e> {

        /* renamed from: a */
        public final /* synthetic */ String f5898a;

        /* renamed from: b */
        public final /* synthetic */ Context f5899b;

        /* renamed from: c */
        public final /* synthetic */ C1372e f5900c;

        /* renamed from: d */
        public final /* synthetic */ int f5901d;

        public c(String str, Context context, C1372e c1372e, int i10) {
            this.f5898a = str;
            this.f5899b = context;
            this.f5900c = c1372e;
            this.f5901d = i10;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public e call() {
            try {
                return C1373f.m7888c(this.f5898a, this.f5899b, this.f5900c, this.f5901d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    /* renamed from: c0.f$d */
    public class d implements InterfaceC9366a<e> {

        /* renamed from: a */
        public final /* synthetic */ String f5902a;

        public d(String str) {
            this.f5902a = str;
        }

        @Override // p243e0.InterfaceC9366a
        /* renamed from: a */
        public void accept(e eVar) {
            synchronized (C1373f.f5891c) {
                try {
                    C11213g<String, ArrayList<InterfaceC9366a<e>>> c11213g = C1373f.f5892d;
                    ArrayList<InterfaceC9366a<e>> arrayList = c11213g.get(this.f5902a);
                    if (arrayList == null) {
                        return;
                    }
                    c11213g.remove(this.f5902a);
                    for (int i10 = 0; i10 < arrayList.size(); i10++) {
                        arrayList.get(i10).accept(eVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: a */
    public static String m7886a(C1372e c1372e, int i10) {
        return c1372e.m7882d() + "-" + i10;
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: b */
    public static int m7887b(C1374g.a aVar) {
        int i10 = 1;
        if (aVar.m7901c() != 0) {
            return aVar.m7901c() != 1 ? -3 : -2;
        }
        C1374g.b[] bVarArrM7900b = aVar.m7900b();
        if (bVarArrM7900b != null && bVarArrM7900b.length != 0) {
            i10 = 0;
            for (C1374g.b bVar : bVarArrM7900b) {
                int iM7903b = bVar.m7903b();
                if (iM7903b != 0) {
                    if (iM7903b < 0) {
                        return -3;
                    }
                    return iM7903b;
                }
            }
        }
        return i10;
    }

    /* renamed from: c */
    public static e m7888c(String str, Context context, C1372e c1372e, int i10) {
        C11211e<String, Typeface> c11211e = f5889a;
        Typeface typefaceM67307c = c11211e.m67307c(str);
        if (typefaceM67307c != null) {
            return new e(typefaceM67307c);
        }
        try {
            C1374g.a aVarM7874e = C1371d.m7874e(context, c1372e, null);
            int iM7887b = m7887b(aVarM7874e);
            if (iM7887b != 0) {
                return new e(iM7887b);
            }
            Typeface typefaceM81247b = C13507f.m81247b(context, null, aVarM7874e.m7900b(), i10);
            if (typefaceM81247b == null) {
                return new e(-3);
            }
            c11211e.m67308d(str, typefaceM81247b);
            return new e(typefaceM81247b);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        }
    }

    /* renamed from: d */
    public static Typeface m7889d(Context context, C1372e c1372e, int i10, Executor executor, C1368a c1368a) {
        String strM7886a = m7886a(c1372e, i10);
        Typeface typefaceM67307c = f5889a.m67307c(strM7886a);
        if (typefaceM67307c != null) {
            c1368a.m7867b(new e(typefaceM67307c));
            return typefaceM67307c;
        }
        b bVar = new b(c1368a);
        synchronized (f5891c) {
            try {
                C11213g<String, ArrayList<InterfaceC9366a<e>>> c11213g = f5892d;
                ArrayList<InterfaceC9366a<e>> arrayList = c11213g.get(strM7886a);
                if (arrayList != null) {
                    arrayList.add(bVar);
                    return null;
                }
                ArrayList<InterfaceC9366a<e>> arrayList2 = new ArrayList<>();
                arrayList2.add(bVar);
                c11213g.put(strM7886a, arrayList2);
                c cVar = new c(strM7886a, context, c1372e, i10);
                if (executor == null) {
                    executor = f5890b;
                }
                C1375h.m7911b(executor, cVar, new d(strM7886a));
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: e */
    public static Typeface m7890e(Context context, C1372e c1372e, C1368a c1368a, int i10, int i11) {
        String strM7886a = m7886a(c1372e, i10);
        Typeface typefaceM67307c = f5889a.m67307c(strM7886a);
        if (typefaceM67307c != null) {
            c1368a.m7867b(new e(typefaceM67307c));
            return typefaceM67307c;
        }
        if (i11 == -1) {
            e eVarM7888c = m7888c(strM7886a, context, c1372e, i10);
            c1368a.m7867b(eVarM7888c);
            return eVarM7888c.f5903a;
        }
        try {
            e eVar = (e) C1375h.m7912c(f5890b, new a(strM7886a, context, c1372e, i10), i11);
            c1368a.m7867b(eVar);
            return eVar.f5903a;
        } catch (InterruptedException unused) {
            c1368a.m7867b(new e(-3));
            return null;
        }
    }

    /* renamed from: c0.f$e */
    public static final class e {

        /* renamed from: a */
        public final Typeface f5903a;

        /* renamed from: b */
        public final int f5904b;

        public e(int i10) {
            this.f5903a = null;
            this.f5904b = i10;
        }

        @SuppressLint({"WrongConstant"})
        /* renamed from: a */
        public boolean m7895a() {
            return this.f5904b == 0;
        }

        @SuppressLint({"WrongConstant"})
        public e(Typeface typeface) {
            this.f5903a = typeface;
            this.f5904b = 0;
        }
    }
}
