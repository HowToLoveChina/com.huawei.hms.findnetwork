package p557pq;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* renamed from: pq.a */
/* loaded from: classes8.dex */
public class C12203a extends C12204b {

    /* renamed from: pq.a$b */
    public static class b {

        /* renamed from: a */
        public static final C12203a f56578a = new C12203a();
    }

    /* renamed from: d */
    public static C12203a m73358d() {
        return b.f56578a;
    }

    public C12203a() {
        super(2, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingDeque(), "AccountPicker-Core-Pool");
    }
}
