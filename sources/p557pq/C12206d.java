package p557pq;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: pq.d */
/* loaded from: classes8.dex */
public class C12206d extends C12204b {

    /* renamed from: pq.d$a */
    public static class a {

        /* renamed from: a */
        public static final C12206d f56585a = new C12206d();
    }

    public C12206d() {
        super(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), "AccountPicker-global-task-Pool");
    }

    /* renamed from: d */
    public static C12206d m73365d() {
        return a.f56585a;
    }
}
