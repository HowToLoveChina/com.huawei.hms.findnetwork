package p701v6;

/* renamed from: v6.f */
/* loaded from: classes2.dex */
public class C13359f extends Exception {

    /* renamed from: a */
    public String f60228a;

    public C13359f(String str, String str2) {
        super(str2);
        this.f60228a = str;
    }

    /* renamed from: b */
    public String m80149b() {
        return this.f60228a;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "ReportException{code='" + this.f60228a + "', message='" + getMessage() + "'}";
    }
}
