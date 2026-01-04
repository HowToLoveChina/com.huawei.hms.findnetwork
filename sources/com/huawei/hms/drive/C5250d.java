package com.huawei.hms.drive;

import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* renamed from: com.huawei.hms.drive.d */
/* loaded from: classes8.dex */
public class C5250d implements Closeable, Flushable {

    /* renamed from: a */
    private static final Pattern f24301a = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* renamed from: b */
    private static final String[] f24302b = new String[128];

    /* renamed from: c */
    private static final String[] f24303c;

    /* renamed from: d */
    private final Writer f24304d;

    /* renamed from: e */
    private int[] f24305e = new int[32];

    /* renamed from: f */
    private int f24306f = 0;

    /* renamed from: g */
    private String f24307g;

    /* renamed from: h */
    private String f24308h;

    /* renamed from: i */
    private boolean f24309i;

    /* renamed from: j */
    private boolean f24310j;

    /* renamed from: k */
    private String f24311k;

    /* renamed from: l */
    private boolean f24312l;

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f24302b[i10] = String.format("\\u%04x", Integer.valueOf(i10));
        }
        String[] strArr = f24302b;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f24303c = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public C5250d(Writer writer) {
        m31489a(6);
        this.f24308h = ":";
        this.f24312l = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f24304d = writer;
    }

    /* renamed from: f */
    private int m31493f() {
        int i10 = this.f24306f;
        if (i10 != 0) {
            return this.f24305e[i10 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    /* renamed from: g */
    private void m31494g() throws IOException {
        if (this.f24311k != null) {
            m31496i();
            m31492d(this.f24311k);
            this.f24311k = null;
        }
    }

    /* renamed from: h */
    private void m31495h() throws IOException {
        if (this.f24307g == null) {
            return;
        }
        this.f24304d.write(10);
        int i10 = this.f24306f;
        for (int i11 = 1; i11 < i10; i11++) {
            this.f24304d.write(this.f24307g);
        }
    }

    /* renamed from: i */
    private void m31496i() throws IOException {
        int iM31493f = m31493f();
        if (iM31493f == 5) {
            this.f24304d.write(44);
        } else if (iM31493f != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m31495h();
        m31491b(4);
    }

    /* renamed from: j */
    private void m31497j() throws IOException {
        int iM31493f = m31493f();
        if (iM31493f == 1) {
            m31491b(2);
            m31495h();
            return;
        }
        if (iM31493f == 2) {
            this.f24304d.append(',');
            m31495h();
        } else {
            if (iM31493f == 4) {
                this.f24304d.append((CharSequence) this.f24308h);
                m31491b(5);
                return;
            }
            if (iM31493f != 6) {
                if (iM31493f != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f24309i) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            m31491b(7);
        }
    }

    /* renamed from: a */
    public final void m31502a(String str) {
        if (str.length() == 0) {
            this.f24307g = null;
            this.f24308h = ":";
        } else {
            this.f24307g = str;
            this.f24308h = ": ";
        }
    }

    /* renamed from: b */
    public C5250d m31504b() throws IOException {
        return m31488a(1, 2, ']');
    }

    /* renamed from: c */
    public C5250d m31507c() throws IOException {
        m31494g();
        return m31487a(3, '{');
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f24304d.close();
        int i10 = this.f24306f;
        if (i10 > 1 || (i10 == 1 && this.f24305e[i10 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f24306f = 0;
    }

    /* renamed from: d */
    public C5250d m31509d() throws IOException {
        return m31488a(3, 5, '}');
    }

    /* renamed from: e */
    public C5250d m31510e() throws IOException {
        if (this.f24311k != null) {
            if (!this.f24312l) {
                this.f24311k = null;
                return this;
            }
            m31494g();
        }
        m31497j();
        this.f24304d.write("null");
        return this;
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f24306f == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f24304d.flush();
    }

    /* renamed from: b */
    private void m31491b(int i10) {
        this.f24305e[this.f24306f - 1] = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m31492d(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f24310j
            if (r0 == 0) goto L7
            java.lang.String[] r0 = com.huawei.hms.drive.C5250d.f24303c
            goto L9
        L7:
            java.lang.String[] r0 = com.huawei.hms.drive.C5250d.f24302b
        L9:
            java.io.Writer r1 = r8.f24304d
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = r3
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.f24304d
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f24304d
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f24304d
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r8 = r8.f24304d
            r8.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.drive.C5250d.m31492d(java.lang.String):void");
    }

    /* renamed from: b */
    public C5250d m31505b(String str) throws IOException {
        if (str != null) {
            if (this.f24311k == null) {
                if (this.f24306f != 0) {
                    this.f24311k = str;
                    return this;
                }
                throw new IllegalStateException("JsonWriter is closed.");
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("name == null");
    }

    /* renamed from: c */
    public C5250d m31508c(String str) throws IOException {
        if (str == null) {
            return m31510e();
        }
        m31494g();
        m31497j();
        m31492d(str);
        return this;
    }

    /* renamed from: a */
    public final void m31503a(boolean z10) {
        this.f24309i = z10;
    }

    /* renamed from: a */
    public C5250d m31498a() throws IOException {
        m31494g();
        return m31487a(1, '[');
    }

    /* renamed from: a */
    private C5250d m31487a(int i10, char c10) throws IOException {
        m31497j();
        m31489a(i10);
        this.f24304d.write(c10);
        return this;
    }

    /* renamed from: b */
    public C5250d m31506b(boolean z10) throws IOException {
        m31494g();
        m31497j();
        this.f24304d.write(z10 ? FaqConstants.DISABLE_HA_REPORT : "false");
        return this;
    }

    /* renamed from: a */
    private C5250d m31488a(int i10, int i11, char c10) throws IOException {
        int iM31493f = m31493f();
        if (iM31493f != i11 && iM31493f != i10) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f24311k == null) {
            this.f24306f--;
            if (iM31493f == i11) {
                m31495h();
            }
            this.f24304d.write(c10);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.f24311k);
    }

    /* renamed from: a */
    private void m31489a(int i10) {
        int i11 = this.f24306f;
        int[] iArr = this.f24305e;
        if (i11 == iArr.length) {
            this.f24305e = Arrays.copyOf(iArr, i11 * 2);
        }
        int[] iArr2 = this.f24305e;
        int i12 = this.f24306f;
        this.f24306f = i12 + 1;
        iArr2[i12] = i10;
    }

    /* renamed from: a */
    public C5250d m31499a(double d10) throws IOException {
        m31494g();
        if (!this.f24309i && (Double.isNaN(d10) || Double.isInfinite(d10))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d10);
        }
        m31497j();
        this.f24304d.append((CharSequence) Double.toString(d10));
        return this;
    }

    /* renamed from: a */
    public C5250d m31500a(long j10) throws IOException {
        m31494g();
        m31497j();
        this.f24304d.write(Long.toString(j10));
        return this;
    }

    /* renamed from: a */
    private static boolean m31490a(Class<? extends Number> cls) {
        return cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    /* renamed from: a */
    public C5250d m31501a(Number number) throws IOException {
        if (number == null) {
            return m31510e();
        }
        m31494g();
        String string = number.toString();
        if (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!m31490a((Class<? extends Number>) cls) && !f24301a.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        } else if (!this.f24309i) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + string);
        }
        m31497j();
        this.f24304d.append((CharSequence) string);
        return this;
    }
}
