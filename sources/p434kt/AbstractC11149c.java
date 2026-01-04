package p434kt;

import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import p405jt.AbstractC10915a;

/* renamed from: kt.c */
/* loaded from: classes2.dex */
public abstract class AbstractC11149c {
    /* renamed from: a */
    public static void m67060a(File file) {
        if (file == null) {
            return;
        }
        int i10 = 0;
        while (i10 < 10 && file != null && !AbstractC11152f.m67070b(m67062c(file))) {
            i10++;
            if (file.exists()) {
                AbstractC10915a.m65969a("FileUtil", "current file exists");
                if (file.isFile()) {
                    m67061b(file);
                    return;
                }
                return;
            }
            File parentFile = file.getParentFile();
            if (parentFile != null && TextUtils.equals(m67062c(parentFile), m67062c(file))) {
                AbstractC10915a.m65978j("FileUtil", "parent file is the same as current");
                return;
            }
            file = parentFile;
        }
    }

    /* renamed from: b */
    public static boolean m67061b(File file) {
        try {
            File file2 = new File(file.getCanonicalPath() + System.currentTimeMillis());
            if (file.renameTo(file2)) {
                return file2.delete();
            }
            return false;
        } catch (IOException unused) {
            AbstractC10915a.m65978j("FileUtil", "deleteSingleFile IOException");
            return false;
        }
    }

    /* renamed from: c */
    public static String m67062c(File file) {
        if (file == null) {
            return null;
        }
        try {
            return file.getCanonicalPath();
        } catch (IOException e10) {
            AbstractC10915a.m65970b("FileUtil", "get path error, " + e10.getClass().getSimpleName());
            return "";
        }
    }

    /* renamed from: d */
    public static boolean m67063d(File file) {
        if (file == null || file.mkdirs()) {
            return true;
        }
        m67060a(file);
        return file.mkdirs();
    }
}
