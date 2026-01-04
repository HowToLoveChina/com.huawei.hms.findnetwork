package p376ix;

import java.io.IOException;

/* renamed from: ix.a */
/* loaded from: classes9.dex */
public class C10631a extends IOException {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    public a f51086a;

    /* renamed from: ix.a$a */
    public enum a {
        WRONG_PASSWORD,
        TASK_CANCELLED_EXCEPTION,
        CHECKSUM_MISMATCH,
        UNKNOWN_COMPRESSION_METHOD,
        FILE_NOT_FOUND,
        UNSUPPORTED_ENCRYPTION,
        UNKNOWN
    }

    public C10631a(String str) {
        super(str);
        this.f51086a = a.UNKNOWN;
    }

    public C10631a(Exception exc) {
        super(exc);
        this.f51086a = a.UNKNOWN;
    }

    public C10631a(String str, Exception exc) {
        super(str, exc);
        this.f51086a = a.UNKNOWN;
    }

    public C10631a(String str, a aVar) {
        super(str);
        a aVar2 = a.WRONG_PASSWORD;
        this.f51086a = aVar;
    }
}
