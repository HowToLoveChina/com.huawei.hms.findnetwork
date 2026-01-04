package p213d1;

import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p320gz.C10072a;

/* renamed from: d1.a */
/* loaded from: classes.dex */
public abstract class AbstractC8975a implements InterfaceC8978d {

    /* renamed from: c */
    public static final Set<AbstractC8975a> f45519c = new HashSet();

    /* renamed from: a */
    public final String f45520a;

    /* renamed from: b */
    public final String f45521b;

    /* renamed from: d1.a$a */
    public static class a {

        /* renamed from: a */
        public static final Set<String> f45522a = new HashSet(Arrays.asList(C8983i.m56812d().mo56804a()));
    }

    /* renamed from: d1.a$b */
    public static class b extends AbstractC8975a {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // p213d1.AbstractC8975a
        /* renamed from: c */
        public final boolean mo56788c() {
            return true;
        }
    }

    /* renamed from: d1.a$c */
    public static class c extends AbstractC8975a {
        public c(String str, String str2) {
            super(str, str2);
        }

        @Override // p213d1.AbstractC8975a
        /* renamed from: c */
        public final boolean mo56788c() {
            return true;
        }
    }

    /* renamed from: d1.a$d */
    public static class d extends AbstractC8975a {
        public d(String str, String str2) {
            super(str, str2);
        }

        @Override // p213d1.AbstractC8975a
        /* renamed from: c */
        public final boolean mo56788c() {
            return false;
        }
    }

    /* renamed from: d1.a$e */
    public static class e extends AbstractC8975a {
        public e(String str, String str2) {
            super(str, str2);
        }

        @Override // p213d1.AbstractC8975a
        /* renamed from: c */
        public final boolean mo56788c() {
            return true;
        }
    }

    /* renamed from: d1.a$f */
    public static class f extends AbstractC8975a {
        public f(String str, String str2) {
            super(str, str2);
        }

        @Override // p213d1.AbstractC8975a
        /* renamed from: c */
        public final boolean mo56788c() {
            return true;
        }
    }

    /* renamed from: d1.a$g */
    public static class g extends AbstractC8975a {
        public g(String str, String str2) {
            super(str, str2);
        }

        @Override // p213d1.AbstractC8975a
        /* renamed from: c */
        public final boolean mo56788c() {
            return true;
        }
    }

    /* renamed from: d1.a$h */
    public static class h extends AbstractC8975a {
        public h(String str, String str2) {
            super(str, str2);
        }

        @Override // p213d1.AbstractC8975a
        /* renamed from: c */
        public final boolean mo56788c() {
            return true;
        }
    }

    /* renamed from: d1.a$i */
    public static class i extends AbstractC8975a {
        public i(String str, String str2) {
            super(str, str2);
        }

        @Override // p213d1.AbstractC8975a
        /* renamed from: c */
        public final boolean mo56788c() {
            return Build.VERSION.SDK_INT >= 33;
        }
    }

    public AbstractC8975a(String str, String str2) {
        this.f45520a = str;
        this.f45521b = str2;
        f45519c.add(this);
    }

    /* renamed from: e */
    public static Set<AbstractC8975a> m56785e() {
        return Collections.unmodifiableSet(f45519c);
    }

    @Override // p213d1.InterfaceC8978d
    /* renamed from: a */
    public String mo56786a() {
        return this.f45520a;
    }

    @Override // p213d1.InterfaceC8978d
    /* renamed from: b */
    public boolean mo56787b() {
        return mo56788c() || mo56789d();
    }

    /* renamed from: c */
    public abstract boolean mo56788c();

    /* renamed from: d */
    public boolean mo56789d() {
        return C10072a.m62694b(a.f45522a, this.f45521b);
    }
}
