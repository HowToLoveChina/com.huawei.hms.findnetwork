package p503ny;

import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/* renamed from: ny.a */
/* loaded from: classes9.dex */
public final class C11767a {

    /* renamed from: a */
    public static final FileTime f54364a = FileTime.from(Instant.EPOCH);

    /* renamed from: b */
    public static final long f54365b = TimeUnit.SECONDS.toNanos(1) / 100;

    /* renamed from: c */
    public static final long f54366c = TimeUnit.MILLISECONDS.toNanos(1) / 100;

    /* renamed from: a */
    public static FileTime m70096a(long j10) {
        long jAddExact = Math.addExact(j10, -116444736000000000L);
        long j11 = f54365b;
        return FileTime.from(Instant.ofEpochSecond(Math.floorDiv(jAddExact, j11), Math.floorMod(jAddExact, j11) * 100));
    }
}
