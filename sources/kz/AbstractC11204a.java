package kz;

import java.lang.reflect.Array;
import p463lz.AbstractC11379a;

/* renamed from: kz.a */
/* loaded from: classes9.dex */
public abstract class AbstractC11204a {

    /* renamed from: a */
    public final int f52563a;

    /* renamed from: b */
    public final int[] f52564b = new int[4];

    /* renamed from: c */
    public final C11206c f52565c = new C11206c();

    /* renamed from: d */
    public final short[][] f52566d;

    /* renamed from: e */
    public final short[] f52567e;

    /* renamed from: f */
    public final short[] f52568f;

    /* renamed from: g */
    public final short[] f52569g;

    /* renamed from: h */
    public final short[] f52570h;

    /* renamed from: i */
    public final short[][] f52571i;

    /* renamed from: j */
    public final short[][] f52572j;

    /* renamed from: k */
    public final short[][] f52573k;

    /* renamed from: l */
    public final short[] f52574l;

    /* renamed from: kz.a$a */
    public abstract class a {

        /* renamed from: a */
        public final short[] f52575a = new short[2];

        /* renamed from: b */
        public final short[][] f52576b;

        /* renamed from: c */
        public final short[][] f52577c;

        /* renamed from: d */
        public final short[] f52578d;

        public a() {
            Class cls = Short.TYPE;
            this.f52576b = (short[][]) Array.newInstance((Class<?>) cls, 16, 8);
            this.f52577c = (short[][]) Array.newInstance((Class<?>) cls, 16, 8);
            this.f52578d = new short[256];
        }

        /* renamed from: a */
        public void m67248a() {
            AbstractC11379a.m68239a(this.f52575a);
            int i10 = 0;
            while (true) {
                short[][] sArr = this.f52576b;
                if (i10 >= sArr.length) {
                    break;
                }
                AbstractC11379a.m68239a(sArr[i10]);
                i10++;
            }
            for (int i11 = 0; i11 < this.f52576b.length; i11++) {
                AbstractC11379a.m68239a(this.f52577c[i11]);
            }
            AbstractC11379a.m68239a(this.f52578d);
        }
    }

    /* renamed from: kz.a$b */
    public abstract class b {

        /* renamed from: a */
        public final int f52580a;

        /* renamed from: b */
        public final int f52581b;

        /* renamed from: kz.a$b$a */
        public abstract class a {

            /* renamed from: a */
            public final short[] f52583a = new short[768];

            public a() {
            }

            /* renamed from: a */
            public void m67250a() {
                AbstractC11379a.m68239a(this.f52583a);
            }
        }

        public b(int i10, int i11) {
            this.f52580a = i10;
            this.f52581b = (1 << i11) - 1;
        }

        /* renamed from: a */
        public final int m67249a(int i10, int i11) {
            int i12 = this.f52580a;
            return (i10 >> (8 - i12)) + ((this.f52581b & i11) << i12);
        }
    }

    public AbstractC11204a(int i10) {
        Class cls = Short.TYPE;
        this.f52566d = (short[][]) Array.newInstance((Class<?>) cls, 12, 16);
        this.f52567e = new short[12];
        this.f52568f = new short[12];
        this.f52569g = new short[12];
        this.f52570h = new short[12];
        this.f52571i = (short[][]) Array.newInstance((Class<?>) cls, 12, 16);
        this.f52572j = (short[][]) Array.newInstance((Class<?>) cls, 4, 64);
        this.f52573k = new short[][]{new short[2], new short[2], new short[4], new short[4], new short[8], new short[8], new short[16], new short[16], new short[32], new short[32]};
        this.f52574l = new short[16];
        this.f52563a = (1 << i10) - 1;
    }

    /* renamed from: a */
    public static final int m67246a(int i10) {
        if (i10 < 6) {
            return i10 - 2;
        }
        return 3;
    }

    /* renamed from: b */
    public void mo67247b() {
        int[] iArr = this.f52564b;
        int i10 = 0;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        this.f52565c.m67263c();
        int i11 = 0;
        while (true) {
            short[][] sArr = this.f52566d;
            if (i11 >= sArr.length) {
                break;
            }
            AbstractC11379a.m68239a(sArr[i11]);
            i11++;
        }
        AbstractC11379a.m68239a(this.f52567e);
        AbstractC11379a.m68239a(this.f52568f);
        AbstractC11379a.m68239a(this.f52569g);
        AbstractC11379a.m68239a(this.f52570h);
        int i12 = 0;
        while (true) {
            short[][] sArr2 = this.f52571i;
            if (i12 >= sArr2.length) {
                break;
            }
            AbstractC11379a.m68239a(sArr2[i12]);
            i12++;
        }
        int i13 = 0;
        while (true) {
            short[][] sArr3 = this.f52572j;
            if (i13 >= sArr3.length) {
                break;
            }
            AbstractC11379a.m68239a(sArr3[i13]);
            i13++;
        }
        while (true) {
            short[][] sArr4 = this.f52573k;
            if (i10 >= sArr4.length) {
                AbstractC11379a.m68239a(this.f52574l);
                return;
            } else {
                AbstractC11379a.m68239a(sArr4[i10]);
                i10++;
            }
        }
    }
}
