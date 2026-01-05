package p374iv;

/* renamed from: iv.c */
/* loaded from: classes9.dex */
public class Exception_C10624c extends Exception {

    /* renamed from: a */
    public final int err;

    public Exception_C10624c(String str) {
        super(str);
        this.err = 100001;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "[errorCode:" + this.err + " message:" + getMessage() + "]";
    }
}
