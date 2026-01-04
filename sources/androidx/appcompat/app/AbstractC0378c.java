package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.C0388m;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import p024b0.C1085a;
import p024b0.C1090f;
import p438l.C11208b;

/* renamed from: androidx.appcompat.app.c */
/* loaded from: classes.dex */
public abstract class AbstractC0378c {

    /* renamed from: a */
    public static C0388m.a f1360a = new C0388m.a(new C0388m.b());

    /* renamed from: b */
    public static int f1361b = -100;

    /* renamed from: c */
    public static C1090f f1362c = null;

    /* renamed from: d */
    public static C1090f f1363d = null;

    /* renamed from: e */
    public static Boolean f1364e = null;

    /* renamed from: f */
    public static boolean f1365f = false;

    /* renamed from: g */
    public static final C11208b<WeakReference<AbstractC0378c>> f1366g = new C11208b<>();

    /* renamed from: h */
    public static final Object f1367h = new Object();

    /* renamed from: i */
    public static final Object f1368i = new Object();

    /* renamed from: androidx.appcompat.app.c$a */
    public static class a {
        /* renamed from: a */
        public static LocaleList m2208a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    /* renamed from: androidx.appcompat.app.c$b */
    public static class b {
        /* renamed from: a */
        public static LocaleList m2209a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        /* renamed from: b */
        public static void m2210b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    /* renamed from: E */
    public static void m2194E(AbstractC0378c abstractC0378c) {
        synchronized (f1367h) {
            m2195F(abstractC0378c);
        }
    }

    /* renamed from: F */
    public static void m2195F(AbstractC0378c abstractC0378c) {
        synchronized (f1367h) {
            try {
                Iterator<WeakReference<AbstractC0378c>> it = f1366g.iterator();
                while (it.hasNext()) {
                    AbstractC0378c abstractC0378c2 = it.next().get();
                    if (abstractC0378c2 == abstractC0378c || abstractC0378c2 == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: N */
    public static void m2196N(final Context context) {
        if (m2205u(context)) {
            if (C1085a.m6463c()) {
                if (f1365f) {
                    return;
                }
                f1360a.execute(new Runnable() { // from class: androidx.appcompat.app.b
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        AbstractC0378c.m2206v(context);
                    }
                });
                return;
            }
            synchronized (f1368i) {
                try {
                    C1090f c1090f = f1362c;
                    if (c1090f == null) {
                        if (f1363d == null) {
                            f1363d = C1090f.m6475b(C0388m.m2241b(context));
                        }
                        if (f1363d.m6479e()) {
                        } else {
                            f1362c = f1363d;
                        }
                    } else if (!c1090f.equals(f1363d)) {
                        C1090f c1090f2 = f1362c;
                        f1363d = c1090f2;
                        C0388m.m2240a(context, c1090f2.m6481g());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: d */
    public static void m2198d(AbstractC0378c abstractC0378c) {
        synchronized (f1367h) {
            m2195F(abstractC0378c);
            f1366g.add(new WeakReference<>(abstractC0378c));
        }
    }

    /* renamed from: h */
    public static AbstractC0378c m2199h(Activity activity, InterfaceC0376a interfaceC0376a) {
        return new AppCompatDelegateImpl(activity, interfaceC0376a);
    }

    /* renamed from: i */
    public static AbstractC0378c m2200i(Dialog dialog, InterfaceC0376a interfaceC0376a) {
        return new AppCompatDelegateImpl(dialog, interfaceC0376a);
    }

    /* renamed from: k */
    public static C1090f m2201k() {
        if (C1085a.m6463c()) {
            Object objM2203o = m2203o();
            if (objM2203o != null) {
                return C1090f.m6477h(b.m2209a(objM2203o));
            }
        } else {
            C1090f c1090f = f1362c;
            if (c1090f != null) {
                return c1090f;
            }
        }
        return C1090f.m6476d();
    }

    /* renamed from: m */
    public static int m2202m() {
        return f1361b;
    }

    /* renamed from: o */
    public static Object m2203o() {
        Context contextMo2121l;
        Iterator<WeakReference<AbstractC0378c>> it = f1366g.iterator();
        while (it.hasNext()) {
            AbstractC0378c abstractC0378c = it.next().get();
            if (abstractC0378c != null && (contextMo2121l = abstractC0378c.mo2121l()) != null) {
                return contextMo2121l.getSystemService("locale");
            }
        }
        return null;
    }

    /* renamed from: q */
    public static C1090f m2204q() {
        return f1362c;
    }

    /* renamed from: u */
    public static boolean m2205u(Context context) {
        if (f1364e == null) {
            try {
                Bundle bundle = AppLocalesMetadataHolderService.m2192a(context).metaData;
                if (bundle != null) {
                    f1364e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f1364e = Boolean.FALSE;
            }
        }
        return f1364e.booleanValue();
    }

    /* renamed from: v */
    public static /* synthetic */ void m2206v(Context context) throws IOException {
        C0388m.m2242c(context);
        f1365f = true;
    }

    /* renamed from: A */
    public abstract void mo2053A();

    /* renamed from: B */
    public abstract void mo2055B(Bundle bundle);

    /* renamed from: C */
    public abstract void mo2057C();

    /* renamed from: D */
    public abstract void mo2059D();

    /* renamed from: G */
    public abstract boolean mo2063G(int i10);

    /* renamed from: H */
    public abstract void mo2065H(int i10);

    /* renamed from: I */
    public abstract void mo2067I(View view);

    /* renamed from: J */
    public abstract void mo2069J(View view, ViewGroup.LayoutParams layoutParams);

    /* renamed from: K */
    public void mo2071K(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    /* renamed from: L */
    public void mo2073L(int i10) {
    }

    /* renamed from: M */
    public abstract void mo2075M(CharSequence charSequence);

    /* renamed from: e */
    public abstract void mo2112e(View view, ViewGroup.LayoutParams layoutParams);

    @Deprecated
    /* renamed from: f */
    public void m2207f(Context context) {
    }

    /* renamed from: g */
    public Context mo2115g(Context context) {
        m2207f(context);
        return context;
    }

    /* renamed from: j */
    public abstract <T extends View> T mo2119j(int i10);

    /* renamed from: l */
    public Context mo2121l() {
        return null;
    }

    /* renamed from: n */
    public int mo2124n() {
        return -100;
    }

    /* renamed from: p */
    public abstract MenuInflater mo2127p();

    /* renamed from: r */
    public abstract ActionBar mo2130r();

    /* renamed from: s */
    public abstract void mo2132s();

    /* renamed from: t */
    public abstract void mo2134t();

    /* renamed from: w */
    public abstract void mo2138w(Configuration configuration);

    /* renamed from: x */
    public abstract void mo2140x(Bundle bundle);

    /* renamed from: y */
    public abstract void mo2142y();

    /* renamed from: z */
    public abstract void mo2144z(Bundle bundle);
}
