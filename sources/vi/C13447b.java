package vi;

/* renamed from: vi.b */
/* loaded from: classes.dex */
public class C13447b extends Exception {

    /* renamed from: a */
    public int f60556a;

    public C13447b(int i10, String str) {
        super(str);
        this.f60556a = i10;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb2 = new StringBuilder("{");
        sb2.append("code=");
        sb2.append(this.f60556a);
        String message = getMessage();
        if (message != null && !message.isEmpty()) {
            sb2.append(", message=");
            sb2.append(getMessage());
        }
        sb2.append("}");
        return sb2.toString();
    }
}
