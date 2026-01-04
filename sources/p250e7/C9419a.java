package p250e7;

import android.util.Log;
import java.util.IllegalFormatException;

/* renamed from: e7.a */
/* loaded from: classes2.dex */
public class C9419a {

    /* renamed from: e7.a$b */
    public static class b extends Throwable {
        private static final long serialVersionUID = 7129050843360571879L;

        /* renamed from: a */
        public String f47081a;

        /* renamed from: b */
        public Throwable f47082b;

        /* renamed from: c */
        public Throwable f47083c;

        /* renamed from: c */
        public final void m59085c(Throwable th2) {
            this.f47082b = th2;
        }

        /* renamed from: d */
        public void m59086d(String str) {
            this.f47081a = str;
        }

        @Override // java.lang.Throwable
        public synchronized Throwable getCause() {
            Throwable th2;
            th2 = this.f47082b;
            if (th2 == this) {
                th2 = null;
            }
            return th2;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.f47081a;
        }

        @Override // java.lang.Throwable
        public String toString() {
            Throwable th2 = this.f47083c;
            if (th2 == null) {
                return "";
            }
            String name = th2.getClass().getName();
            if (this.f47081a == null) {
                return name;
            }
            String str = name + ": ";
            if (this.f47081a.startsWith(str)) {
                return this.f47081a;
            }
            return str + this.f47081a;
        }

        public b(Throwable th2) {
            this.f47083c = th2;
        }
    }

    /* renamed from: a */
    public static String m59075a(String str) {
        return "LanguagePlugin_" + str;
    }

    /* renamed from: b */
    public static void m59076b(String str, Object obj) {
    }

    /* renamed from: c */
    public static void m59077c(String str, Object obj) {
        Log.e(m59075a(str), obj == null ? "null" : obj.toString());
    }

    /* renamed from: d */
    public static void m59078d(String str, String str2, Throwable th2) {
        Log.e(m59075a(str), str2, m59079e(th2));
    }

    /* renamed from: e */
    public static Throwable m59079e(Throwable th2) {
        if (th2 == null) {
            return null;
        }
        b bVar = new b(th2);
        bVar.setStackTrace(th2.getStackTrace());
        bVar.m59086d(C9421c.m59091a(th2.getMessage()));
        Throwable cause = th2.getCause();
        b bVar2 = bVar;
        while (cause != null) {
            b bVar3 = new b(cause);
            bVar3.setStackTrace(cause.getStackTrace());
            bVar3.m59086d(C9421c.m59091a(cause.getMessage()));
            bVar2.m59085c(bVar3);
            cause = cause.getCause();
            bVar2 = bVar3;
        }
        return bVar;
    }

    /* renamed from: f */
    public static void m59080f(String str, Object obj) {
        Log.i(m59075a(str), obj == null ? "null" : obj.toString());
    }

    /* renamed from: g */
    public static void m59081g(String str, Object obj) {
        Log.w(m59075a(str), obj == null ? "null" : obj.toString());
    }

    /* renamed from: h */
    public static void m59082h(String str, String str2, Throwable th2) {
        Log.w(m59075a(str), str2, m59079e(th2));
    }

    /* renamed from: i */
    public static void m59083i(String str, String str2, Object... objArr) {
        if (str2 == null) {
            Log.w("LanguagePlugin_Logger", "format is null, not log");
            return;
        }
        try {
            Log.w(m59075a(str), C9421c.m59092b(str2, objArr));
        } catch (IllegalFormatException e10) {
            m59082h("LanguagePlugin_Logger", "log format error" + str2, e10);
        }
    }
}
