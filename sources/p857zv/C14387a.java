package p857zv;

import p374iv.Exception_C10623b;

/* renamed from: zv.a */
/* loaded from: classes9.dex */
public class Exception_C14387a extends Exception_C10623b {

    /* renamed from: b */
    public transient ErrorCode err;

    public Exception_C14387a(long j10, String str) {
        super(str);
        this.err = new ErrorCode(j10);
    }

    /* renamed from: b */
    public int getErrorCode() {
        return (int) this.err.getCode();
    }
}
