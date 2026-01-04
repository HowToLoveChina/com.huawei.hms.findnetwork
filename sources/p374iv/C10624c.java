package p374iv;

/* renamed from: iv.c */
/* loaded from: classes9.dex */
public class C10624c extends Exception {

    /* renamed from: a */
    public final int f51065a;

    public C10624c(String str) {
        super(str);
        this.f51065a = 100001;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "[errorCode:" + this.f51065a + " message:" + getMessage() + "]";
    }
}
