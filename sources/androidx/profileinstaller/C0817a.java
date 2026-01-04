package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

/* renamed from: androidx.profileinstaller.a */
/* loaded from: classes.dex */
public class C0817a {

    /* renamed from: androidx.profileinstaller.a$a */
    public static class a {
        /* renamed from: a */
        public static File m5065a(Context context) {
            return context.getCodeCacheDir();
        }
    }

    /* renamed from: androidx.profileinstaller.a$b */
    public static class b {
        /* renamed from: a */
        public static Context m5066a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }
    }

    /* renamed from: a */
    public static boolean m5063a(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z10 = true;
        for (File file2 : fileArrListFiles) {
            z10 = m5063a(file2) && z10;
        }
        return z10;
    }

    /* renamed from: b */
    public static void m5064b(Context context, ProfileInstallReceiver.C0814a c0814a) {
        if (m5063a(Build.VERSION.SDK_INT >= 34 ? b.m5066a(context).getCacheDir() : a.m5065a(b.m5066a(context)))) {
            c0814a.mo5052b(14, null);
        } else {
            c0814a.mo5052b(15, null);
        }
    }
}
