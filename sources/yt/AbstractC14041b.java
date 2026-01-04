package yt;

import p787xt.C13865a;

/* renamed from: yt.b */
/* loaded from: classes5.dex */
public abstract class AbstractC14041b {

    /* renamed from: a */
    public static final String f62826a = "ExceptionHandler";

    /* renamed from: a */
    public final void m84241a(Throwable th2) {
        C13865a.m83193g(f62826a, "bandageExceptionHappened ");
        try {
            mo8145b(th2);
        } catch (Throwable unused) {
            C13865a.m83189c(f62826a, "bandageExceptionHappened");
        }
    }

    /* renamed from: b */
    public abstract void mo8145b(Throwable th2);

    /* renamed from: c */
    public abstract void mo8146c(Thread thread, Throwable th2);

    /* renamed from: d */
    public final void m84242d(Thread thread, Throwable th2) {
        C13865a.m83193g(f62826a, "uncaughtExceptionHappened ");
        try {
            mo8146c(thread, th2);
        } catch (Throwable unused) {
            C13865a.m83189c(f62826a, "uncaughtExceptionHappened");
        }
    }
}
