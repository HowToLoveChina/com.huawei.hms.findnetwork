package p540p0;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kw.C11172e0;
import kw.C11182j0;
import kw.C11194u;
import p692uw.C13264g;
import p692uw.C13267j;

/* renamed from: p0.c */
/* loaded from: classes.dex */
public final class C12062c {

    /* renamed from: a */
    public static final C12062c f55861a = new C12062c();

    /* renamed from: b */
    public static c f55862b = c.f55873d;

    /* renamed from: p0.c$a */
    public enum a {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    /* renamed from: p0.c$b */
    public interface b {
    }

    /* renamed from: p0.c$c */
    public static final class c {

        /* renamed from: c */
        public static final a f55872c = new a(null);

        /* renamed from: d */
        public static final c f55873d = new c(C11182j0.m67159a(), null, C11172e0.m67135d());

        /* renamed from: a */
        public final Set<a> f55874a;

        /* renamed from: b */
        public final Map<String, Set<Class<? extends AbstractC12067h>>> f55875b;

        /* renamed from: p0.c$c$a */
        public static final class a {
            public /* synthetic */ a(C13264g c13264g) {
                this();
            }

            public a() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Set<? extends a> set, b bVar, Map<String, ? extends Set<Class<? extends AbstractC12067h>>> map) {
            C13267j.m79677e(set, ParamConstants.Param.FLAGS);
            C13267j.m79677e(map, "allowedViolations");
            this.f55874a = set;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Set<Class<? extends AbstractC12067h>>> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            this.f55875b = linkedHashMap;
        }

        /* renamed from: a */
        public final Set<a> m72218a() {
            return this.f55874a;
        }

        /* renamed from: b */
        public final b m72219b() {
            return null;
        }

        /* renamed from: c */
        public final Map<String, Set<Class<? extends AbstractC12067h>>> m72220c() {
            return this.f55875b;
        }
    }

    /* renamed from: d */
    public static final void m72206d(String str, AbstractC12067h abstractC12067h) {
        C13267j.m79677e(abstractC12067h, "$violation");
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, abstractC12067h);
        throw abstractC12067h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: f */
    public static final void m72207f(Fragment fragment, String str) {
        C13267j.m79677e(fragment, "fragment");
        C13267j.m79677e(str, "previousFragmentId");
        C12060a c12060a = new C12060a(fragment, str);
        C12062c c12062c = f55861a;
        c12062c.m72214e(c12060a);
        c cVarM72212b = c12062c.m72212b(fragment);
        if (cVarM72212b.m72218a().contains(a.DETECT_FRAGMENT_REUSE) && c12062c.m72216l(cVarM72212b, fragment.getClass(), c12060a.getClass())) {
            c12062c.m72213c(cVarM72212b, c12060a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    public static final void m72208g(Fragment fragment, ViewGroup viewGroup) {
        C13267j.m79677e(fragment, "fragment");
        C12063d c12063d = new C12063d(fragment, viewGroup);
        C12062c c12062c = f55861a;
        c12062c.m72214e(c12063d);
        c cVarM72212b = c12062c.m72212b(fragment);
        if (cVarM72212b.m72218a().contains(a.DETECT_FRAGMENT_TAG_USAGE) && c12062c.m72216l(cVarM72212b, fragment.getClass(), c12063d.getClass())) {
            c12062c.m72213c(cVarM72212b, c12063d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: h */
    public static final void m72209h(Fragment fragment) {
        C13267j.m79677e(fragment, "fragment");
        C12064e c12064e = new C12064e(fragment);
        C12062c c12062c = f55861a;
        c12062c.m72214e(c12064e);
        c cVarM72212b = c12062c.m72212b(fragment);
        if (cVarM72212b.m72218a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && c12062c.m72216l(cVarM72212b, fragment.getClass(), c12064e.getClass())) {
            c12062c.m72213c(cVarM72212b, c12064e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: i */
    public static final void m72210i(Fragment fragment, boolean z10) {
        C13267j.m79677e(fragment, "fragment");
        C12065f c12065f = new C12065f(fragment, z10);
        C12062c c12062c = f55861a;
        c12062c.m72214e(c12065f);
        c cVarM72212b = c12062c.m72212b(fragment);
        if (cVarM72212b.m72218a().contains(a.DETECT_SET_USER_VISIBLE_HINT) && c12062c.m72216l(cVarM72212b, fragment.getClass(), c12065f.getClass())) {
            c12062c.m72213c(cVarM72212b, c12065f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: j */
    public static final void m72211j(Fragment fragment, ViewGroup viewGroup) {
        C13267j.m79677e(fragment, "fragment");
        C13267j.m79677e(viewGroup, "container");
        C12068i c12068i = new C12068i(fragment, viewGroup);
        C12062c c12062c = f55861a;
        c12062c.m72214e(c12068i);
        c cVarM72212b = c12062c.m72212b(fragment);
        if (cVarM72212b.m72218a().contains(a.DETECT_WRONG_FRAGMENT_CONTAINER) && c12062c.m72216l(cVarM72212b, fragment.getClass(), c12068i.getClass())) {
            c12062c.m72213c(cVarM72212b, c12068i);
        }
    }

    /* renamed from: b */
    public final c m72212b(Fragment fragment) {
        while (fragment != null) {
            if (fragment.m4379X()) {
                FragmentManager fragmentManagerM4341D = fragment.m4341D();
                C13267j.m79676d(fragmentManagerM4341D, "declaringFragment.parentFragmentManager");
                if (fragmentManagerM4341D.m4508B0() != null) {
                    c cVarM4508B0 = fragmentManagerM4341D.m4508B0();
                    C13267j.m79674b(cVarM4508B0);
                    return cVarM4508B0;
                }
            }
            fragment = fragment.m4339C();
        }
        return f55862b;
    }

    /* renamed from: c */
    public final void m72213c(c cVar, final AbstractC12067h abstractC12067h) {
        Fragment fragmentM72221b = abstractC12067h.m72221b();
        final String name = fragmentM72221b.getClass().getName();
        if (cVar.m72218a().contains(a.PENALTY_LOG)) {
            Log.d("FragmentStrictMode", "Policy violation in " + name, abstractC12067h);
        }
        cVar.m72219b();
        if (cVar.m72218a().contains(a.PENALTY_DEATH)) {
            m72215k(fragmentM72221b, new Runnable() { // from class: p0.b
                @Override // java.lang.Runnable
                public final void run() {
                    C12062c.m72206d(name, abstractC12067h);
                }
            });
        }
    }

    /* renamed from: e */
    public final void m72214e(AbstractC12067h abstractC12067h) {
        if (FragmentManager.m4492I0(3)) {
            Log.d("FragmentManager", "StrictMode violation in " + abstractC12067h.m72221b().getClass().getName(), abstractC12067h);
        }
    }

    /* renamed from: k */
    public final void m72215k(Fragment fragment, Runnable runnable) {
        if (!fragment.m4379X()) {
            runnable.run();
            return;
        }
        Handler handlerM4799j = fragment.m4341D().m4607v0().m4799j();
        C13267j.m79676d(handlerM4799j, "fragment.parentFragmentManager.host.handler");
        if (C13267j.m79673a(handlerM4799j.getLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            handlerM4799j.post(runnable);
        }
    }

    /* renamed from: l */
    public final boolean m72216l(c cVar, Class<? extends Fragment> cls, Class<? extends AbstractC12067h> cls2) {
        Set<Class<? extends AbstractC12067h>> set = cVar.m72220c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (C13267j.m79673a(cls2.getSuperclass(), AbstractC12067h.class) || !C11194u.m67184n(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
