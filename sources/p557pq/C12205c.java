package p557pq;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* renamed from: pq.c */
/* loaded from: classes8.dex */
public class C12205c extends C12204b {

    /* renamed from: pq.c$b */
    public static class b {

        /* renamed from: a */
        public static final C12205c f56584a = new C12205c();
    }

    /* renamed from: d */
    public static C12205c m73363d() {
        return b.f56584a;
    }

    public C12205c() {
        super(1, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingDeque(), "AccountPicker-FileSystem-Pool");
    }
}
