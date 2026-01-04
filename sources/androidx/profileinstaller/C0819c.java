package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import p695v0.ExecutorC13317e;

/* renamed from: androidx.profileinstaller.c */
/* loaded from: classes.dex */
public class C0819c {

    /* renamed from: a */
    public static final c f4268a = new a();

    /* renamed from: b */
    public static final c f4269b = new b();

    /* renamed from: androidx.profileinstaller.c$a */
    public class a implements c {
        @Override // androidx.profileinstaller.C0819c.c
        /* renamed from: a */
        public void mo5051a(int i10, Object obj) {
        }

        @Override // androidx.profileinstaller.C0819c.c
        /* renamed from: b */
        public void mo5052b(int i10, Object obj) {
        }
    }

    /* renamed from: androidx.profileinstaller.c$b */
    public class b implements c {
        @Override // androidx.profileinstaller.C0819c.c
        /* renamed from: a */
        public void mo5051a(int i10, Object obj) {
            Log.d("ProfileInstaller", i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? "" : "DIAGNOSTIC_PROFILE_IS_COMPRESSED" : "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_REF_PROFILE_EXISTS" : "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_CURRENT_PROFILE_EXISTS");
        }

        @Override // androidx.profileinstaller.C0819c.c
        /* renamed from: b */
        public void mo5052b(int i10, Object obj) {
            String str;
            switch (i10) {
                case 1:
                    str = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    str = "RESULT_ALREADY_INSTALLED";
                    break;
                case 3:
                    str = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    str = "RESULT_NOT_WRITABLE";
                    break;
                case 5:
                    str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    str = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    str = "RESULT_PARSE_EXCEPTION";
                    break;
                case 9:
                default:
                    str = "";
                    break;
                case 10:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case 11:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
            }
            if (i10 == 6 || i10 == 7 || i10 == 8) {
                Log.e("ProfileInstaller", str, (Throwable) obj);
            } else {
                Log.d("ProfileInstaller", str);
            }
        }
    }

    /* renamed from: androidx.profileinstaller.c$c */
    public interface c {
        /* renamed from: a */
        void mo5051a(int i10, Object obj);

        /* renamed from: b */
        void mo5052b(int i10, Object obj);
    }

    /* renamed from: b */
    public static boolean m5082b(File file) {
        return new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
    }

    /* renamed from: c */
    public static void m5083c(Context context, Executor executor, c cVar) {
        m5082b(context.getFilesDir());
        m5087g(executor, cVar, 11, null);
    }

    /* renamed from: d */
    public static boolean m5084d(PackageInfo packageInfo, File file, c cVar) throws IOException {
        File file2 = new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        if (!file2.exists()) {
            return false;
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file2));
            try {
                long j10 = dataInputStream.readLong();
                dataInputStream.close();
                boolean z10 = j10 == packageInfo.lastUpdateTime;
                if (z10) {
                    cVar.mo5052b(2, null);
                }
                return z10;
            } finally {
            }
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: f */
    public static void m5086f(PackageInfo packageInfo, File file) throws IOException {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    /* renamed from: g */
    public static void m5087g(Executor executor, final c cVar, final int i10, final Object obj) {
        executor.execute(new Runnable() { // from class: v0.f
            @Override // java.lang.Runnable
            public final void run() {
                cVar.mo5052b(i10, obj);
            }
        });
    }

    /* renamed from: h */
    public static boolean m5088h(AssetManager assetManager, String str, PackageInfo packageInfo, File file, String str2, Executor executor, c cVar) throws IOException {
        C0818b c0818b = new C0818b(assetManager, executor, cVar, str2, "dexopt/baseline.prof", "dexopt/baseline.profm", new File(new File("/data/misc/profiles/cur/0", str), "primary.prof"));
        if (!c0818b.m5072e()) {
            return false;
        }
        boolean zM5080n = c0818b.m5076i().m5079m().m5080n();
        if (zM5080n) {
            m5086f(packageInfo, file);
        }
        return zM5080n;
    }

    /* renamed from: i */
    public static void m5089i(Context context) throws PackageManager.NameNotFoundException {
        m5090j(context, new ExecutorC13317e(), f4268a);
    }

    /* renamed from: j */
    public static void m5090j(Context context, Executor executor, c cVar) throws PackageManager.NameNotFoundException {
        m5091k(context, executor, cVar, false);
    }

    /* renamed from: k */
    public static void m5091k(Context context, Executor executor, c cVar, boolean z10) throws PackageManager.NameNotFoundException {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        boolean z11 = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (!z10 && m5084d(packageInfo, filesDir, cVar)) {
                Log.d("ProfileInstaller", "Skipping profile installation for " + context.getPackageName());
                C0820d.m5095c(context, false);
                return;
            }
            Log.d("ProfileInstaller", "Installing profile for " + context.getPackageName());
            if (m5088h(assets, packageName, packageInfo, filesDir, name, executor, cVar) && z10) {
                z11 = true;
            }
            C0820d.m5095c(context, z11);
        } catch (PackageManager.NameNotFoundException e10) {
            cVar.mo5052b(7, e10);
            C0820d.m5095c(context, false);
        }
    }

    /* renamed from: l */
    public static void m5092l(Context context, Executor executor, c cVar) throws PackageManager.NameNotFoundException, IOException {
        try {
            m5086f(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            m5087g(executor, cVar, 10, null);
        } catch (PackageManager.NameNotFoundException e10) {
            m5087g(executor, cVar, 7, e10);
        }
    }
}
