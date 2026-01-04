package p759x1;

import java.io.IOException;

/* renamed from: x1.e */
/* loaded from: classes.dex */
public final class C13680e extends IOException {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    public final int f61609a;

    public C13680e(String str, int i10) {
        this(str, i10, null);
    }

    public C13680e(int i10) {
        this("Http request failed", i10);
    }

    public C13680e(String str, int i10, Throwable th2) {
        super(str + ", status code: " + i10, th2);
        this.f61609a = i10;
    }
}
