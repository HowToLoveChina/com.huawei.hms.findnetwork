package p829z1;

import android.util.Log;
import com.huawei.hms.network.embedded.C5929g4;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p759x1.EnumC13676a;
import p759x1.InterfaceC13681f;

/* renamed from: z1.q */
/* loaded from: classes.dex */
public final class C14078q extends Exception {

    /* renamed from: g */
    public static final StackTraceElement[] f63034g = new StackTraceElement[0];
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    public final List<Throwable> f63035a;

    /* renamed from: b */
    public InterfaceC13681f f63036b;

    /* renamed from: c */
    public EnumC13676a f63037c;

    /* renamed from: d */
    public Class<?> f63038d;

    /* renamed from: e */
    public String f63039e;

    /* renamed from: f */
    public Exception f63040f;

    public C14078q(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    /* renamed from: c */
    public static void m84398c(List<Throwable> list, Appendable appendable) {
        try {
            m84399d(list, appendable);
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    /* renamed from: d */
    public static void m84399d(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            appendable.append("Cause (").append(String.valueOf(i11)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th2 = list.get(i10);
            if (th2 instanceof C14078q) {
                ((C14078q) th2).m84405j(appendable);
            } else {
                m84400e(th2, appendable);
            }
            i10 = i11;
        }
    }

    /* renamed from: e */
    public static void m84400e(Throwable th2, Appendable appendable) throws IOException {
        try {
            appendable.append(th2.getClass().toString()).append(": ").append(th2.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th2);
        }
    }

    /* renamed from: b */
    public final void m84401b(Throwable th2, List<Throwable> list) {
        if (!(th2 instanceof C14078q)) {
            list.add(th2);
            return;
        }
        Iterator<Throwable> it = ((C14078q) th2).m84402f().iterator();
        while (it.hasNext()) {
            m84401b(it.next(), list);
        }
    }

    /* renamed from: f */
    public List<Throwable> m84402f() {
        return this.f63035a;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    /* renamed from: g */
    public List<Throwable> m84403g() {
        ArrayList arrayList = new ArrayList();
        m84401b(this, arrayList);
        return arrayList;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb2 = new StringBuilder(71);
        sb2.append(this.f63039e);
        sb2.append(this.f63038d != null ? ", " + this.f63038d : "");
        sb2.append(this.f63037c != null ? ", " + this.f63037c : "");
        sb2.append(this.f63036b != null ? ", " + this.f63036b : "");
        List<Throwable> listM84403g = m84403g();
        if (listM84403g.isEmpty()) {
            return sb2.toString();
        }
        if (listM84403g.size() == 1) {
            sb2.append("\nThere was 1 root cause:");
        } else {
            sb2.append("\nThere were ");
            sb2.append(listM84403g.size());
            sb2.append(" root causes:");
        }
        for (Throwable th2 : listM84403g) {
            sb2.append('\n');
            sb2.append(th2.getClass().getName());
            sb2.append(C5929g4.f26849k);
            sb2.append(th2.getMessage());
            sb2.append(C5929g4.f26850l);
        }
        sb2.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb2.toString();
    }

    /* renamed from: h */
    public void m84404h(String str) {
        List<Throwable> listM84403g = m84403g();
        int size = listM84403g.size();
        int i10 = 0;
        while (i10 < size) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Root cause (");
            int i11 = i10 + 1;
            sb2.append(i11);
            sb2.append(" of ");
            sb2.append(size);
            sb2.append(")");
            Log.i(str, sb2.toString(), listM84403g.get(i10));
            i10 = i11;
        }
    }

    /* renamed from: j */
    public final void m84405j(Appendable appendable) throws IOException {
        m84400e(this, appendable);
        m84398c(m84402f(), new a(appendable));
    }

    /* renamed from: k */
    public void m84406k(InterfaceC13681f interfaceC13681f, EnumC13676a enumC13676a) {
        m84407l(interfaceC13681f, enumC13676a, null);
    }

    /* renamed from: l */
    public void m84407l(InterfaceC13681f interfaceC13681f, EnumC13676a enumC13676a, Class<?> cls) {
        this.f63036b = interfaceC13681f;
        this.f63037c = enumC13676a;
        this.f63038d = cls;
    }

    /* renamed from: m */
    public void m84408m(Exception exc) {
        this.f63040f = exc;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() throws IOException {
        printStackTrace(System.err);
    }

    public C14078q(String str, Throwable th2) {
        this(str, (List<Throwable>) Collections.singletonList(th2));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) throws IOException {
        m84405j(printStream);
    }

    public C14078q(String str, List<Throwable> list) {
        this.f63039e = str;
        setStackTrace(f63034g);
        this.f63035a = list;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) throws IOException {
        m84405j(printWriter);
    }

    /* renamed from: z1.q$a */
    public static final class a implements Appendable {

        /* renamed from: a */
        public final Appendable f63041a;

        /* renamed from: b */
        public boolean f63042b = true;

        public a(Appendable appendable) {
            this.f63041a = appendable;
        }

        /* renamed from: a */
        public final CharSequence m84409a(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c10) throws IOException {
            if (this.f63042b) {
                this.f63042b = false;
                this.f63041a.append("  ");
            }
            this.f63042b = c10 == '\n';
            this.f63041a.append(c10);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) throws IOException {
            CharSequence charSequenceM84409a = m84409a(charSequence);
            return append(charSequenceM84409a, 0, charSequenceM84409a.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i10, int i11) throws IOException {
            CharSequence charSequenceM84409a = m84409a(charSequence);
            boolean z10 = false;
            if (this.f63042b) {
                this.f63042b = false;
                this.f63041a.append("  ");
            }
            if (charSequenceM84409a.length() > 0 && charSequenceM84409a.charAt(i11 - 1) == '\n') {
                z10 = true;
            }
            this.f63042b = z10;
            this.f63041a.append(charSequenceM84409a, i10, i11);
            return this;
        }
    }
}
