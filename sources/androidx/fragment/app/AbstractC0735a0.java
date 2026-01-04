package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.AbstractC0791h;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import p540p0.C12062c;

/* renamed from: androidx.fragment.app.a0 */
/* loaded from: classes.dex */
public abstract class AbstractC0735a0 {

    /* renamed from: a */
    public final C0753k f3890a;

    /* renamed from: b */
    public final ClassLoader f3891b;

    /* renamed from: d */
    public int f3893d;

    /* renamed from: e */
    public int f3894e;

    /* renamed from: f */
    public int f3895f;

    /* renamed from: g */
    public int f3896g;

    /* renamed from: h */
    public int f3897h;

    /* renamed from: i */
    public boolean f3898i;

    /* renamed from: k */
    public String f3900k;

    /* renamed from: l */
    public int f3901l;

    /* renamed from: m */
    public CharSequence f3902m;

    /* renamed from: n */
    public int f3903n;

    /* renamed from: o */
    public CharSequence f3904o;

    /* renamed from: p */
    public ArrayList<String> f3905p;

    /* renamed from: q */
    public ArrayList<String> f3906q;

    /* renamed from: s */
    public ArrayList<Runnable> f3908s;

    /* renamed from: c */
    public ArrayList<a> f3892c = new ArrayList<>();

    /* renamed from: j */
    public boolean f3899j = true;

    /* renamed from: r */
    public boolean f3907r = false;

    /* renamed from: androidx.fragment.app.a0$a */
    public static final class a {

        /* renamed from: a */
        public int f3909a;

        /* renamed from: b */
        public Fragment f3910b;

        /* renamed from: c */
        public boolean f3911c;

        /* renamed from: d */
        public int f3912d;

        /* renamed from: e */
        public int f3913e;

        /* renamed from: f */
        public int f3914f;

        /* renamed from: g */
        public int f3915g;

        /* renamed from: h */
        public AbstractC0791h.c f3916h;

        /* renamed from: i */
        public AbstractC0791h.c f3917i;

        public a() {
        }

        public a(int i10, Fragment fragment) {
            this.f3909a = i10;
            this.f3910b = fragment;
            this.f3911c = false;
            AbstractC0791h.c cVar = AbstractC0791h.c.RESUMED;
            this.f3916h = cVar;
            this.f3917i = cVar;
        }

        public a(int i10, Fragment fragment, boolean z10) {
            this.f3909a = i10;
            this.f3910b = fragment;
            this.f3911c = z10;
            AbstractC0791h.c cVar = AbstractC0791h.c.RESUMED;
            this.f3916h = cVar;
            this.f3917i = cVar;
        }

        public a(int i10, Fragment fragment, AbstractC0791h.c cVar) {
            this.f3909a = i10;
            this.f3910b = fragment;
            this.f3911c = false;
            this.f3916h = fragment.f3713R;
            this.f3917i = cVar;
        }
    }

    public AbstractC0735a0(C0753k c0753k, ClassLoader classLoader) {
        this.f3890a = c0753k;
        this.f3891b = classLoader;
    }

    /* renamed from: b */
    public AbstractC0735a0 m4662b(int i10, Fragment fragment) {
        mo4652n(i10, fragment, null, 1);
        return this;
    }

    /* renamed from: c */
    public AbstractC0735a0 m4663c(int i10, Fragment fragment, String str) {
        mo4652n(i10, fragment, str, 1);
        return this;
    }

    /* renamed from: d */
    public AbstractC0735a0 m4664d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.f3703H = viewGroup;
        return m4663c(viewGroup.getId(), fragment, str);
    }

    /* renamed from: e */
    public AbstractC0735a0 m4665e(Fragment fragment, String str) {
        mo4652n(0, fragment, str, 1);
        return this;
    }

    /* renamed from: f */
    public void m4666f(a aVar) {
        this.f3892c.add(aVar);
        aVar.f3912d = this.f3893d;
        aVar.f3913e = this.f3894e;
        aVar.f3914f = this.f3895f;
        aVar.f3915g = this.f3896g;
    }

    /* renamed from: g */
    public AbstractC0735a0 m4667g(Fragment fragment) {
        m4666f(new a(7, fragment));
        return this;
    }

    /* renamed from: h */
    public abstract int mo4647h();

    /* renamed from: i */
    public abstract int mo4648i();

    /* renamed from: j */
    public abstract void mo4649j();

    /* renamed from: k */
    public abstract void mo4650k();

    /* renamed from: l */
    public AbstractC0735a0 mo4651l(Fragment fragment) {
        m4666f(new a(6, fragment));
        return this;
    }

    /* renamed from: m */
    public AbstractC0735a0 m4668m() {
        if (this.f3898i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f3899j = false;
        return this;
    }

    /* renamed from: n */
    public void mo4652n(int i10, Fragment fragment, String str, int i11) {
        String str2 = fragment.f3712Q;
        if (str2 != null) {
            C12062c.m72207f(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.f3748z;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f3748z + " now " + str);
            }
            fragment.f3748z = str;
        }
        if (i10 != 0) {
            if (i10 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i12 = fragment.f3746x;
            if (i12 != 0 && i12 != i10) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f3746x + " now " + i10);
            }
            fragment.f3746x = i10;
            fragment.f3747y = i10;
        }
        m4666f(new a(i11, fragment));
    }

    /* renamed from: o */
    public AbstractC0735a0 mo4653o(Fragment fragment) {
        m4666f(new a(4, fragment));
        return this;
    }

    /* renamed from: p */
    public abstract boolean mo4654p();

    /* renamed from: q */
    public AbstractC0735a0 mo4655q(Fragment fragment) {
        m4666f(new a(3, fragment));
        return this;
    }

    /* renamed from: r */
    public AbstractC0735a0 m4669r(int i10, Fragment fragment) {
        return m4670s(i10, fragment, null);
    }

    /* renamed from: s */
    public AbstractC0735a0 m4670s(int i10, Fragment fragment, String str) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        mo4652n(i10, fragment, str, 2);
        return this;
    }

    /* renamed from: t */
    public AbstractC0735a0 mo4656t(Fragment fragment, AbstractC0791h.c cVar) {
        m4666f(new a(10, fragment, cVar));
        return this;
    }

    /* renamed from: u */
    public AbstractC0735a0 m4671u(boolean z10) {
        this.f3907r = z10;
        return this;
    }

    /* renamed from: v */
    public AbstractC0735a0 mo4657v(Fragment fragment) {
        m4666f(new a(5, fragment));
        return this;
    }
}
