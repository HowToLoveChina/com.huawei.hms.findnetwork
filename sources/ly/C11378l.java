package ly;

import java.nio.file.attribute.FileTime;
import java.util.concurrent.TimeUnit;

/* renamed from: ly.l */
/* loaded from: classes9.dex */
public final class C11378l {

    /* renamed from: a */
    public static final long f53108a = TimeUnit.MILLISECONDS.toNanos(1) / 100;

    /* renamed from: a */
    public static long m68237a(FileTime fileTime) {
        if (fileTime != null) {
            return fileTime.to(TimeUnit.SECONDS);
        }
        return 0L;
    }

    /* renamed from: b */
    public static FileTime m68238b(long j10) {
        return FileTime.from(j10, TimeUnit.SECONDS);
    }
}
