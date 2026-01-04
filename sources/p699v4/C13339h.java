package p699v4;

import com.huawei.android.backup.filelogic.utils.C2111d;
import java.io.Closeable;
import java.io.IOException;

/* renamed from: v4.h */
/* loaded from: classes.dex */
public class C13339h {
    /* renamed from: a */
    public static void m80014a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                C2111d.m12648d("IoUtils", "close failed.");
            }
        }
    }
}
