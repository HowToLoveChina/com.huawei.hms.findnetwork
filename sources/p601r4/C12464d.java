package p601r4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import p229di.C9145j;
import p699v4.C13334c;

/* renamed from: r4.d */
/* loaded from: classes.dex */
public class C12464d {
    /* renamed from: a */
    public static FileOutputStream m74720a(File file) throws FileNotFoundException {
        return (file == null || !C12461a.m74715b(C13334c.m79991x(file))) ? new FileOutputStream(file) : C9145j.m57479a(file);
    }
}
