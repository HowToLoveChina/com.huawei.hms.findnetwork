package p229di;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import p229di.C9142g;

/* renamed from: di.j */
/* loaded from: classes4.dex */
public class C9145j {
    /* renamed from: a */
    public static FileOutputStream m57479a(File file) throws FileNotFoundException {
        try {
            FileOutputStream fileOutputStream = (FileOutputStream) C9142g.a.m57468c("com.huawei.libcore.io.ExternalStorageFileOutputStream", File.class).m57471e(file).m57472f();
            return fileOutputStream == null ? new FileOutputStream(file) : fileOutputStream;
        } catch (Exception unused) {
            return new FileOutputStream(file);
        }
    }
}
