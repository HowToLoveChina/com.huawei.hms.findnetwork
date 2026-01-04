package p629s1;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;

/* renamed from: s1.d */
/* loaded from: classes.dex */
public class C12665d {

    /* renamed from: a */
    public static boolean f58159a = true;

    /* renamed from: b */
    public static Context f58160b;

    /* renamed from: s1.d$a */
    public static class a {
        /* renamed from: a */
        public static void m76242a(String str, String str2) {
            if (C12665d.f58159a) {
                Log.d(str, str2);
            }
        }

        /* renamed from: b */
        public static void m76243b(String str, String str2) {
            Log.e(str, str2);
        }

        /* renamed from: c */
        public static void m76244c(String str, String str2) {
            Log.i(str, str2);
        }

        /* renamed from: d */
        public static void m76245d(String str, String str2) {
            Log.w(str, str2);
        }
    }

    /* renamed from: a */
    public static void m76239a(String str, String str2) throws Throwable {
        if (f58159a) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    Context context = f58160b;
                    if (context != null && context.getCacheDir() != null) {
                        File file = new File(f58160b.getCacheDir().getAbsolutePath() + "/" + str);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("writeFile file path:");
                        sb2.append(file.getAbsolutePath());
                        a.m76242a("Util", sb2.toString());
                        if (file.exists()) {
                            file.delete();
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            fileOutputStream2.write(str2.getBytes());
                            fileOutputStream = fileOutputStream2;
                        } catch (Exception e10) {
                            fileOutputStream = fileOutputStream2;
                            e = e10;
                            a.m76243b("Util", e.toString());
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            fileOutputStream = fileOutputStream2;
                            th = th2;
                            try {
                                fileOutputStream.close();
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e12) {
                e = e12;
            }
            try {
                fileOutputStream.close();
            } catch (Exception e13) {
                e13.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    public static boolean m76241c() {
        return f58159a;
    }
}
