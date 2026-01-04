package p241dy;

import java.io.IOException;

/* renamed from: dy.a */
/* loaded from: classes9.dex */
public class C9360a extends IOException {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    public final long f46766a;

    /* renamed from: b */
    public final int f46767b;

    public C9360a(long j10, int i10) {
        super(m58724b(j10, i10));
        this.f46766a = j10;
        this.f46767b = i10;
    }

    /* renamed from: b */
    public static String m58724b(long j10, int i10) {
        return j10 + " kb of memory would be needed; limit was " + i10 + " kb. If the file is not corrupt, consider increasing the memory limit.";
    }
}
