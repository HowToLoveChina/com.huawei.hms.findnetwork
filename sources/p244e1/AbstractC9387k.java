package p244e1;

import java.io.Closeable;
import java.io.IOException;

/* renamed from: e1.k */
/* loaded from: classes.dex */
public abstract class AbstractC9387k implements Cloneable, Closeable {

    /* renamed from: a */
    public boolean f46890a;

    /* renamed from: c */
    public char f46892c;

    /* renamed from: d */
    public a f46893d;

    /* renamed from: e */
    public Boolean f46894e;

    /* renamed from: b */
    public int f46891b = -1;

    /* renamed from: f */
    public int f46895f = 0;

    /* renamed from: g */
    public boolean f46896g = false;

    /* renamed from: e1.k$a */
    public enum a {
        Object,
        Array,
        Value
    }

    /* renamed from: e1.k$b */
    public static class b extends AbstractC9387k {

        /* renamed from: h */
        public final String f46901h;

        public b(String str) {
            this.f46901h = str;
            mo58845w();
            m58846x();
        }

        @Override // p244e1.AbstractC9387k
        /* renamed from: t */
        public final void mo58844t() {
            char cCharAt;
            int i10 = this.f46891b;
            do {
                i10++;
                if (i10 >= this.f46901h.length() || (cCharAt = this.f46901h.charAt(i10)) == '\\') {
                    mo58845w();
                    while (true) {
                        char c10 = this.f46892c;
                        if (c10 == '\\') {
                            mo58845w();
                            if (this.f46892c == 'u') {
                                mo58845w();
                                mo58845w();
                                mo58845w();
                                mo58845w();
                                mo58845w();
                            } else {
                                mo58845w();
                            }
                        } else if (c10 == '\"') {
                            mo58845w();
                            return;
                        } else if (this.f46890a) {
                            return;
                        } else {
                            mo58845w();
                        }
                    }
                }
            } while (cCharAt != '\"');
            int i11 = i10 + 1;
            this.f46892c = this.f46901h.charAt(i11);
            this.f46891b = i11;
        }

        @Override // p244e1.AbstractC9387k
        /* renamed from: w */
        public void mo58845w() {
            int i10 = this.f46891b + 1;
            this.f46891b = i10;
            if (i10 < this.f46901h.length()) {
                this.f46892c = this.f46901h.charAt(this.f46891b);
            } else {
                this.f46892c = (char) 0;
                this.f46890a = true;
            }
        }
    }

    /* renamed from: u */
    public static AbstractC9387k m58841u(String str) {
        return new b(str);
    }

    /* renamed from: v */
    public static final boolean m58842v(char c10) {
        return c10 == ' ' || c10 == '\t' || c10 == '\r' || c10 == '\n' || c10 == '\f' || c10 == '\b';
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:181:? A[SYNTHETIC] */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m58843s() {
        /*
            Method dump skipped, instructions count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p244e1.AbstractC9387k.m58843s():boolean");
    }

    /* renamed from: t */
    public abstract void mo58844t();

    /* renamed from: w */
    public abstract void mo58845w();

    /* renamed from: x */
    public void m58846x() {
        while (m58842v(this.f46892c)) {
            mo58845w();
        }
    }

    /* renamed from: y */
    public boolean m58847y() {
        Boolean bool = this.f46894e;
        if (bool != null) {
            return bool.booleanValue();
        }
        while (m58843s()) {
            m58846x();
            this.f46895f++;
            if (this.f46890a) {
                this.f46894e = Boolean.TRUE;
                return true;
            }
            if (!this.f46896g) {
                this.f46894e = Boolean.FALSE;
                return false;
            }
            m58846x();
            if (this.f46890a) {
                this.f46894e = Boolean.TRUE;
                return true;
            }
        }
        this.f46894e = Boolean.FALSE;
        return false;
    }
}
