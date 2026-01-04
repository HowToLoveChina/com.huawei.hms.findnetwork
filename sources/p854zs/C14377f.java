package p854zs;

import as.C1016d;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import p531or.C11991a;

/* renamed from: zs.f */
/* loaded from: classes8.dex */
public final class C14377f {
    /* renamed from: a */
    public static void m85596a(String str) throws IOException {
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = C11991a.m72145a().openFileOutput("ephData", 0);
            try {
                fileOutputStreamOpenFileOutput.write(str.getBytes(StandardCharsets.UTF_8));
                fileOutputStreamOpenFileOutput.close();
            } finally {
            }
        } catch (IOException unused) {
            C1016d.m6183c("FileUtil", "save to file failed");
        }
    }
}
