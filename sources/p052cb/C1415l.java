package p052cb;

import java.lang.Thread;
import p514o9.C11839m;

/* renamed from: cb.l */
/* loaded from: classes3.dex */
public class C1415l implements Thread.UncaughtExceptionHandler {
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        C11839m.m70688i("UncaughtExceptionHandlerForDownload", "DownApkThread uncaughtException:" + th2.getMessage());
    }
}
