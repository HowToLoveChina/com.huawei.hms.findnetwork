package p306g2;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: g2.s */
/* loaded from: classes.dex */
public final class C9867s {

    /* renamed from: j */
    public static volatile C9867s f48463j;

    /* renamed from: d */
    public int f48468d;

    /* renamed from: g */
    public static final boolean f48460g = false;

    /* renamed from: h */
    public static final boolean f48461h = true;

    /* renamed from: i */
    public static final File f48462i = new File("/proc/self/fd");

    /* renamed from: k */
    public static volatile int f48464k = -1;

    /* renamed from: e */
    public boolean f48469e = true;

    /* renamed from: f */
    public final AtomicBoolean f48470f = new AtomicBoolean(false);

    /* renamed from: a */
    public final boolean f48465a = m61292f();

    /* renamed from: b */
    public final int f48466b = 20000;

    /* renamed from: c */
    public final int f48467c = 0;

    /* renamed from: b */
    public static C9867s m61291b() {
        if (f48463j == null) {
            synchronized (C9867s.class) {
                try {
                    if (f48463j == null) {
                        f48463j = new C9867s();
                    }
                } finally {
                }
            }
        }
        return f48463j;
    }

    /* renamed from: f */
    public static boolean m61292f() {
        return (m61293g() || m61294h()) ? false : true;
    }

    /* renamed from: g */
    public static boolean m61293g() {
        return false;
    }

    /* renamed from: h */
    public static boolean m61294h() {
        return false;
    }

    /* renamed from: a */
    public final boolean m61295a() {
        return f48460g && !this.f48470f.get();
    }

    /* renamed from: c */
    public final int m61296c() {
        return f48464k != -1 ? f48464k : this.f48466b;
    }

    /* renamed from: d */
    public final synchronized boolean m61297d() {
        try {
            boolean z10 = true;
            int i10 = this.f48468d + 1;
            this.f48468d = i10;
            if (i10 >= 50) {
                this.f48468d = 0;
                int length = f48462i.list().length;
                long jM61296c = m61296c();
                if (length >= jM61296c) {
                    z10 = false;
                }
                this.f48469e = z10;
                if (!z10 && Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + jM61296c);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f48469e;
    }

    /* renamed from: e */
    public boolean m61298e(int i10, int i11, boolean z10, boolean z11) {
        if (!z10) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        }
        if (!this.f48465a) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by device model");
            }
            return false;
        }
        if (!f48461h) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
            }
            return false;
        }
        if (m61295a()) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by app state");
            }
            return false;
        }
        if (z11) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        }
        int i12 = this.f48467c;
        if (i10 < i12) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because width is too small");
            }
            return false;
        }
        if (i11 < i12) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because height is too small");
            }
            return false;
        }
        if (m61297d()) {
            return true;
        }
        if (Log.isLoggable("HardwareConfig", 2)) {
            Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
        }
        return false;
    }

    @TargetApi(26)
    /* renamed from: i */
    public boolean m61299i(int i10, int i11, BitmapFactory.Options options, boolean z10, boolean z11) {
        boolean zM61298e = m61298e(i10, i11, z10, z11);
        if (zM61298e) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return zM61298e;
    }
}
