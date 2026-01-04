package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import java.io.IOException;
import java.nio.ByteBuffer;
import p024b0.C1094j;
import p243e0.C9373h;
import p465m0.C11387b;

/* renamed from: androidx.emoji2.text.m */
/* loaded from: classes.dex */
public final class C0696m {

    /* renamed from: a */
    public final C11387b f3666a;

    /* renamed from: b */
    public final char[] f3667b;

    /* renamed from: c */
    public final a f3668c = new a(1024);

    /* renamed from: d */
    public final Typeface f3669d;

    /* renamed from: androidx.emoji2.text.m$a */
    public static class a {

        /* renamed from: a */
        public final SparseArray<a> f3670a;

        /* renamed from: b */
        public C0690g f3671b;

        public a() {
            this(1);
        }

        /* renamed from: a */
        public a m4304a(int i10) {
            SparseArray<a> sparseArray = this.f3670a;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i10);
        }

        /* renamed from: b */
        public final C0690g m4305b() {
            return this.f3671b;
        }

        /* renamed from: c */
        public void m4306c(C0690g c0690g, int i10, int i11) {
            a aVarM4304a = m4304a(c0690g.m4249b(i10));
            if (aVarM4304a == null) {
                aVarM4304a = new a();
                this.f3670a.put(c0690g.m4249b(i10), aVarM4304a);
            }
            if (i11 > i10) {
                aVarM4304a.m4306c(c0690g, i10 + 1, i11);
            } else {
                aVarM4304a.f3671b = c0690g;
            }
        }

        public a(int i10) {
            this.f3670a = new SparseArray<>(i10);
        }
    }

    public C0696m(Typeface typeface, C11387b c11387b) {
        this.f3669d = typeface;
        this.f3666a = c11387b;
        this.f3667b = new char[c11387b.m68289k() * 2];
        m4297a(c11387b);
    }

    /* renamed from: b */
    public static C0696m m4296b(Typeface typeface, ByteBuffer byteBuffer) throws IOException {
        try {
            C1094j.m6490a("EmojiCompat.MetadataRepo.create");
            return new C0696m(typeface, C0695l.m4289b(byteBuffer));
        } finally {
            C1094j.m6491b();
        }
    }

    /* renamed from: a */
    public final void m4297a(C11387b c11387b) {
        int iM68289k = c11387b.m68289k();
        for (int i10 = 0; i10 < iM68289k; i10++) {
            C0690g c0690g = new C0690g(this, i10);
            Character.toChars(c0690g.m4253f(), this.f3667b, i10 * 2);
            m4303h(c0690g);
        }
    }

    /* renamed from: c */
    public char[] m4298c() {
        return this.f3667b;
    }

    /* renamed from: d */
    public C11387b m4299d() {
        return this.f3666a;
    }

    /* renamed from: e */
    public int m4300e() {
        return this.f3666a.m68290l();
    }

    /* renamed from: f */
    public a m4301f() {
        return this.f3668c;
    }

    /* renamed from: g */
    public Typeface m4302g() {
        return this.f3669d;
    }

    /* renamed from: h */
    public void m4303h(C0690g c0690g) {
        C9373h.m58746g(c0690g, "emoji metadata cannot be null");
        C9373h.m58740a(c0690g.m4250c() > 0, "invalid metadata codepoint length");
        this.f3668c.m4306c(c0690g, 0, c0690g.m4250c() - 1);
    }
}
