package p229di;

import java.io.File;
import p229di.C9142g;

/* renamed from: di.h */
/* loaded from: classes4.dex */
public class C9143h {
    /* renamed from: a */
    public static File m57476a(String str) {
        try {
            File file = (File) C9142g.a.m57468c("com.huawei.libcore.io.ExternalStorageFile", String.class).m57471e(str).m57472f();
            return file == null ? new File(str) : file;
        } catch (Exception unused) {
            return new File(str);
        }
    }

    /* renamed from: b */
    public static File m57477b(String str, String str2) {
        try {
            File file = (File) C9142g.a.m57468c("com.huawei.libcore.io.ExternalStorageFile", String.class, String.class).m57471e(str, str2).m57472f();
            return file == null ? new File(str, str2) : file;
        } catch (Exception unused) {
            return new File(str, str2);
        }
    }
}
