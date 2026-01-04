package es;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: es.d */
/* loaded from: classes8.dex */
public class C9539d {

    /* renamed from: es.d$a */
    public class a implements ThreadFactory {

        /* renamed from: a */
        public final AtomicInteger f47444a = new AtomicInteger(0);

        /* renamed from: b */
        public final /* synthetic */ String f47445b;

        public a(String str) {
            this.f47445b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Location_" + this.f47445b + "_" + this.f47444a.getAndIncrement());
        }
    }

    /* renamed from: a */
    public static ThreadFactory m59580a(String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new NullPointerException("ThreadName is empty");
        }
        return new a(str);
    }
}
