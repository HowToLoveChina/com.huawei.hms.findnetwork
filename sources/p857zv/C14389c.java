package p857zv;

/* renamed from: zv.c */
/* loaded from: classes9.dex */
public class Exception_C14389c extends Exception {

    /* renamed from: a */
    public transient ErrorCode err;

    public Exception_C14389c(long j10, String str) {
        super(str);
        this.err = new ErrorCode(j10);
    }

    /* renamed from: b */
    public long getErrorCode() {
        return this.err.getCode();
    }
}
