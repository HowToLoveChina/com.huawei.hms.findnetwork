package p308g4;

import p405jt.AbstractC10915a;

/* renamed from: g4.f */
/* loaded from: classes.dex */
public class RunnableC9882f implements Runnable {

    /* renamed from: a */
    public final Runnable f48515a;

    public RunnableC9882f(Runnable runnable) {
        this.f48515a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.f48515a;
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th2) {
                AbstractC10915a.m65970b("TaskWrapper", "exception in task run");
                AbstractC10915a.m65977i(5, th2);
            }
        }
    }
}
