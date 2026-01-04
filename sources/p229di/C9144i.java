package p229di;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import p229di.C9142g;

/* renamed from: di.i */
/* loaded from: classes4.dex */
public class C9144i {
    /* renamed from: a */
    public static FileInputStream m57478a(File file) throws FileNotFoundException {
        try {
            FileInputStream fileInputStream = (FileInputStream) C9142g.a.m57468c("com.huawei.libcore.io.ExternalStorageFileInputStream", File.class).m57471e(file).m57472f();
            return fileInputStream == null ? new FileInputStream(file) : fileInputStream;
        } catch (Exception unused) {
            return new FileInputStream(file);
        }
    }
}
