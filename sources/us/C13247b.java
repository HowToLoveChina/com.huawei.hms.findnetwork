package us;

import java.io.File;
import java.util.Comparator;

/* renamed from: us.b */
/* loaded from: classes8.dex */
public final class C13247b implements Comparator<File> {
    @Override // java.util.Comparator
    public final int compare(File file, File file2) {
        long jLastModified = file.lastModified() - file2.lastModified();
        if (jLastModified > 0) {
            return -1;
        }
        return jLastModified == 0 ? 0 : 1;
    }
}
