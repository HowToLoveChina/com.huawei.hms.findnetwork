package p229di;

import android.os.Environment;
import java.io.File;
import p229di.C9142g;

/* renamed from: di.l */
/* loaded from: classes4.dex */
public class C9147l {
    /* renamed from: a */
    public static File[] m57482a(Environment environment, String str) {
        try {
            return (File[]) C9142g.a.m57467b(environment, String.class).m57470d("buildExternalStorageAppCacheDirs", str).m57472f();
        } catch (Exception unused) {
            return new File[0];
        }
    }

    /* renamed from: b */
    public static File[] m57483b(Environment environment, String str) {
        try {
            return (File[]) C9142g.a.m57467b(environment, String.class).m57470d("buildExternalStorageAppFilesDirs", str).m57472f();
        } catch (Exception unused) {
            return new File[0];
        }
    }

    /* renamed from: c */
    public static File[] m57484c(Environment environment, String str) {
        try {
            return (File[]) C9142g.a.m57467b(environment, String.class).m57470d("buildExternalStorageAppMediaDirs", str).m57472f();
        } catch (Exception unused) {
            return new File[0];
        }
    }
}
