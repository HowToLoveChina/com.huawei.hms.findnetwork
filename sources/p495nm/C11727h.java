package p495nm;

import java.util.ArrayList;
import java.util.List;

/* renamed from: nm.h */
/* loaded from: classes6.dex */
public class C11727h {

    /* renamed from: a */
    public List<String> f54250a;

    /* renamed from: b */
    public List<String> f54251b;

    /* renamed from: nm.h$b */
    public static class b {

        /* renamed from: a */
        public static final C11727h f54252a = new C11727h();
    }

    /* renamed from: b */
    public static final C11727h m69967b() {
        return b.f54252a;
    }

    /* renamed from: a */
    public void m69968a() {
        List<String> list = this.f54250a;
        if (list != null) {
            list.clear();
        }
        List<String> list2 = this.f54251b;
        if (list2 != null) {
            list2.clear();
        }
    }

    /* renamed from: c */
    public List<String> m69969c() {
        List<String> list = this.f54251b;
        return list == null ? new ArrayList() : list;
    }

    /* renamed from: d */
    public List<String> m69970d() {
        List<String> list = this.f54250a;
        return list == null ? new ArrayList() : list;
    }

    /* renamed from: e */
    public void m69971e(List<String> list) {
        this.f54251b = list;
    }

    /* renamed from: f */
    public void m69972f(List<String> list) {
        this.f54250a = list;
    }

    public C11727h() {
    }
}
