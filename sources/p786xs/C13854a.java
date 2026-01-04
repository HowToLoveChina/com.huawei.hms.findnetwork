package p786xs;

import java.io.File;
import java.util.Comparator;

/* renamed from: xs.a */
/* loaded from: classes8.dex */
public final class C13854a implements Comparator<File> {
    @Override // java.util.Comparator
    public final int compare(File file, File file2) {
        return (int) (file2.lastModified() - file.lastModified());
    }
}
