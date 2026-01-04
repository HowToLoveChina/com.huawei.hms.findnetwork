package hk;

import java.io.File;
import java.io.IOException;
import p015ak.C0219i;
import p399jk.AbstractC10896a;

/* renamed from: hk.b */
/* loaded from: classes6.dex */
public class C10279b {

    /* renamed from: a */
    public static String f49758a;

    static {
        f49758a = C0219i.m1463a() >= 17 ? "/mnt/media_rw/cifs" : "/data/samba/cifs";
    }

    /* renamed from: a */
    public static String m63452a(File file) {
        if (file == null) {
            return null;
        }
        try {
            String path = file.getPath();
            return (path == null || !path.startsWith(f49758a)) ? file.getCanonicalPath() : file.getAbsolutePath();
        } catch (IOException unused) {
            AbstractC10896a.m65886e("FilePathUtil", "CanonicalPath is not avaliable.");
            return file.getAbsolutePath();
        }
    }
}
