package p594qx;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;
import p376ix.C10631a;
import p537ox.C12056a;

/* renamed from: qx.b */
/* loaded from: classes9.dex */
public class C12423b {
    /* renamed from: a */
    public static long m74572a(File file, C12056a c12056a) throws IOException {
        if (file == null || !file.exists() || !file.canRead()) {
            throw new C10631a("input file is null or does not exist or cannot read. Cannot calculate CRC for the file");
        }
        byte[] bArr = new byte[16384];
        CRC32 crc32 = new CRC32();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int i10 = fileInputStream.read(bArr);
                if (i10 == -1) {
                    long value = crc32.getValue();
                    fileInputStream.close();
                    return value;
                }
                crc32.update(bArr, 0, i10);
                if (c12056a != null) {
                    c12056a.m72204l(i10);
                    if (c12056a.m72197e()) {
                        c12056a.m72201i(C12056a.a.CANCELLED);
                        c12056a.m72202j(C12056a.b.READY);
                        fileInputStream.close();
                        return 0L;
                    }
                }
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
