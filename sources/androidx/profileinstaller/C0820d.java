package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import p464m.C11385c;

/* renamed from: androidx.profileinstaller.d */
/* loaded from: classes.dex */
public final class C0820d {

    /* renamed from: a */
    public static final C11385c<c> f4270a = C11385c.m68274r();

    /* renamed from: b */
    public static final Object f4271b = new Object();

    /* renamed from: c */
    public static c f4272c = null;

    /* renamed from: androidx.profileinstaller.d$a */
    public static class a {
        /* renamed from: a */
        public static PackageInfo m5096a(PackageManager packageManager, Context context) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    /* renamed from: androidx.profileinstaller.d$b */
    public static class b {

        /* renamed from: a */
        public final int f4273a;

        /* renamed from: b */
        public final int f4274b;

        /* renamed from: c */
        public final long f4275c;

        /* renamed from: d */
        public final long f4276d;

        public b(int i10, int i11, long j10, long j11) {
            this.f4273a = i10;
            this.f4274b = i11;
            this.f4275c = j10;
            this.f4276d = j11;
        }

        /* renamed from: a */
        public static b m5097a(File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th2) {
                try {
                    dataInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }

        /* renamed from: b */
        public void m5098b(File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f4273a);
                dataOutputStream.writeInt(this.f4274b);
                dataOutputStream.writeLong(this.f4275c);
                dataOutputStream.writeLong(this.f4276d);
                dataOutputStream.close();
            } catch (Throwable th2) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f4274b == bVar.f4274b && this.f4275c == bVar.f4275c && this.f4273a == bVar.f4273a && this.f4276d == bVar.f4276d;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f4274b), Long.valueOf(this.f4275c), Integer.valueOf(this.f4273a), Long.valueOf(this.f4276d));
        }
    }

    /* renamed from: androidx.profileinstaller.d$c */
    public static class c {

        /* renamed from: a */
        public final int f4277a;

        /* renamed from: b */
        public final boolean f4278b;

        /* renamed from: c */
        public final boolean f4279c;

        /* renamed from: d */
        public final boolean f4280d;

        public c(int i10, boolean z10, boolean z11, boolean z12) {
            this.f4277a = i10;
            this.f4279c = z11;
            this.f4278b = z10;
            this.f4280d = z12;
        }
    }

    /* renamed from: a */
    public static long m5093a(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? a.m5096a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    /* renamed from: b */
    public static c m5094b(int i10, boolean z10, boolean z11, boolean z12) {
        c cVar = new c(i10, z10, z11, z12);
        f4272c = cVar;
        f4270a.mo68264p(cVar);
        return f4272c;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0047 A[Catch: all -> 0x0012, TryCatch #1 {, blocks: (B:9:0x000c, B:11:0x0010, B:16:0x0019, B:22:0x002e, B:34:0x0041, B:36:0x0047, B:37:0x004d, B:39:0x004f, B:45:0x0072, B:51:0x0095, B:52:0x0099, B:54:0x00aa, B:63:0x00bb, B:65:0x00c1, B:80:0x00dd, B:83:0x00e3, B:86:0x00ea, B:88:0x00f4, B:93:0x0100, B:94:0x0104, B:90:0x00fa, B:57:0x00b1, B:58:0x00b5, B:96:0x0106, B:97:0x010c, B:32:0x003f, B:31:0x003c), top: B:103:0x000c, inners: #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x004f A[Catch: all -> 0x0012, TryCatch #1 {, blocks: (B:9:0x000c, B:11:0x0010, B:16:0x0019, B:22:0x002e, B:34:0x0041, B:36:0x0047, B:37:0x004d, B:39:0x004f, B:45:0x0072, B:51:0x0095, B:52:0x0099, B:54:0x00aa, B:63:0x00bb, B:65:0x00c1, B:80:0x00dd, B:83:0x00e3, B:86:0x00ea, B:88:0x00f4, B:93:0x0100, B:94:0x0104, B:90:0x00fa, B:57:0x00b1, B:58:0x00b5, B:96:0x0106, B:97:0x010c, B:32:0x003f, B:31:0x003c), top: B:103:0x000c, inners: #2, #4 }] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.profileinstaller.C0820d.c m5095c(android.content.Context r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.C0820d.m5095c(android.content.Context, boolean):androidx.profileinstaller.d$c");
    }
}
