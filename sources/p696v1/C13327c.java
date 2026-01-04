package p696v1;

import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: v1.c */
/* loaded from: classes.dex */
public final class C13327c {

    /* renamed from: a */
    public static final Charset f60141a = Charset.forName("US-ASCII");

    /* renamed from: b */
    public static final Charset f60142b = Charset.forName(Constants.UTF_8);

    /* renamed from: a */
    public static void m79929a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: b */
    public static void m79930b(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                m79930b(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }
}
