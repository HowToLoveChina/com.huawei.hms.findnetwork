package sx;

import java.io.IOException;
import java.util.Arrays;
import org.json.JSONException;

/* renamed from: sx.c */
/* loaded from: classes9.dex */
public class C12873c extends Throwable {
    private static final long serialVersionUID = 7129050843360571879L;

    /* renamed from: a */
    public String f58635a;

    /* renamed from: b */
    public Throwable f58636b;

    /* renamed from: c */
    public Throwable f58637c;

    public C12873c(Throwable th2) {
        this.f58637c = th2;
        StackTraceElement[] stackTrace = th2.getStackTrace();
        int i10 = ((th2 instanceof IOException) || (th2 instanceof JSONException)) ? 8 : 20;
        if (stackTrace.length > i10) {
            setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTrace, i10));
        } else {
            setStackTrace(stackTrace);
        }
        m77229e(m77227b(th2.getMessage()));
    }

    /* renamed from: c */
    public static Throwable m77226c(Throwable th2) {
        if (th2 == null) {
            return null;
        }
        C12873c c12873c = new C12873c(th2);
        Throwable cause = th2.getCause();
        C12873c c12873c2 = c12873c;
        while (cause != null) {
            C12873c c12873c3 = new C12873c(cause);
            c12873c2.m77228d(c12873c3);
            cause = cause.getCause();
            c12873c2 = c12873c3;
        }
        return c12873c;
    }

    /* renamed from: b */
    public String m77227b(String str) {
        if (str == null || str.trim().isEmpty()) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i10 = 0; i10 < charArray.length; i10++) {
            if (i10 % 2 != 0) {
                charArray[i10] = '*';
            }
        }
        return new String(charArray);
    }

    /* renamed from: d */
    public final void m77228d(Throwable th2) {
        this.f58636b = th2;
    }

    /* renamed from: e */
    public void m77229e(String str) {
        this.f58635a = str;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        Throwable th2 = this.f58636b;
        if (th2 == this) {
            return null;
        }
        return th2;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f58635a;
    }

    @Override // java.lang.Throwable
    public String toString() {
        Throwable th2 = this.f58637c;
        if (th2 == null) {
            return "";
        }
        String name = th2.getClass().getName();
        if (this.f58635a == null) {
            return name;
        }
        String str = name + ": ";
        if (this.f58635a.startsWith(str)) {
            return this.f58635a;
        }
        return str + this.f58635a;
    }
}
