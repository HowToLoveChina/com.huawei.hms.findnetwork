package p601r4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import p229di.C9144i;
import p699v4.C13334c;

/* renamed from: r4.c */
/* loaded from: classes.dex */
public class C12463c {
    /* renamed from: a */
    public static FileInputStream m74719a(File file) throws FileNotFoundException {
        return (file == null || !C12461a.m74715b(C13334c.m79991x(file))) ? new FileInputStream(file) : C9144i.m57478a(file);
    }
}
