package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.profileinstaller.C0819c;
import androidx.profileinstaller.ProfileInstallerInitializer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p794y0.InterfaceC13899b;

/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements InterfaceC13899b<C0816b> {

    /* renamed from: androidx.profileinstaller.ProfileInstallerInitializer$a */
    public static class C0815a {
        /* renamed from: a */
        public static Handler m5062a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    /* renamed from: androidx.profileinstaller.ProfileInstallerInitializer$b */
    public static class C0816b {
    }

    /* renamed from: k */
    public static void m5058k(final Context context) {
        new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new Runnable() { // from class: v0.i
            @Override // java.lang.Runnable
            public final void run() throws PackageManager.NameNotFoundException {
                C0819c.m5089i(context);
            }
        });
    }

    @Override // p794y0.InterfaceC13899b
    /* renamed from: a */
    public List<Class<? extends InterfaceC13899b<?>>> mo4189a() {
        return Collections.emptyList();
    }

    @Override // p794y0.InterfaceC13899b
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0816b mo4190b(Context context) {
        final Context applicationContext = context.getApplicationContext();
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: v0.g
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j10) {
                this.f60086a.m5061h(applicationContext, j10);
            }
        });
        return new C0816b();
    }

    /* renamed from: g */
    public void m5060g(final Context context) {
        C0815a.m5062a(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: v0.h
            @Override // java.lang.Runnable
            public final void run() {
                ProfileInstallerInitializer.m5058k(context);
            }
        }, new Random().nextInt(Math.max(1000, 1)) + 5000);
    }

    /* renamed from: h */
    public final /* synthetic */ void m5061h(Context context, long j10) {
        m5060g(context);
    }
}
