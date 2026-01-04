package p306g2;

import p759x1.C13683h;

/* renamed from: g2.m */
/* loaded from: classes.dex */
public abstract class AbstractC9861m {

    /* renamed from: a */
    public static final AbstractC9861m f48430a = new a();

    /* renamed from: b */
    public static final AbstractC9861m f48431b = new b();

    /* renamed from: c */
    public static final AbstractC9861m f48432c = new e();

    /* renamed from: d */
    public static final AbstractC9861m f48433d = new c();

    /* renamed from: e */
    public static final AbstractC9861m f48434e;

    /* renamed from: f */
    public static final AbstractC9861m f48435f;

    /* renamed from: g */
    public static final AbstractC9861m f48436g;

    /* renamed from: h */
    public static final C13683h<AbstractC9861m> f48437h;

    /* renamed from: i */
    public static final boolean f48438i;

    /* renamed from: g2.m$a */
    public static class a extends AbstractC9861m {
        @Override // p306g2.AbstractC9861m
        /* renamed from: a */
        public g mo61257a(int i10, int i11, int i12, int i13) {
            return g.QUALITY;
        }

        @Override // p306g2.AbstractC9861m
        /* renamed from: b */
        public float mo61258b(int i10, int i11, int i12, int i13) {
            if (Math.min(i11 / i13, i10 / i12) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r0);
        }
    }

    /* renamed from: g2.m$b */
    public static class b extends AbstractC9861m {
        @Override // p306g2.AbstractC9861m
        /* renamed from: a */
        public g mo61257a(int i10, int i11, int i12, int i13) {
            return g.MEMORY;
        }

        @Override // p306g2.AbstractC9861m
        /* renamed from: b */
        public float mo61258b(int i10, int i11, int i12, int i13) {
            int iCeil = (int) Math.ceil(Math.max(i11 / i13, i10 / i12));
            return 1.0f / (r1 << (Math.max(1, Integer.highestOneBit(iCeil)) >= iCeil ? 0 : 1));
        }
    }

    /* renamed from: g2.m$c */
    public static class c extends AbstractC9861m {
        @Override // p306g2.AbstractC9861m
        /* renamed from: a */
        public g mo61257a(int i10, int i11, int i12, int i13) {
            return mo61258b(i10, i11, i12, i13) == 1.0f ? g.QUALITY : AbstractC9861m.f48432c.mo61257a(i10, i11, i12, i13);
        }

        @Override // p306g2.AbstractC9861m
        /* renamed from: b */
        public float mo61258b(int i10, int i11, int i12, int i13) {
            return Math.min(1.0f, AbstractC9861m.f48432c.mo61258b(i10, i11, i12, i13));
        }
    }

    /* renamed from: g2.m$d */
    public static class d extends AbstractC9861m {
        @Override // p306g2.AbstractC9861m
        /* renamed from: a */
        public g mo61257a(int i10, int i11, int i12, int i13) {
            return g.QUALITY;
        }

        @Override // p306g2.AbstractC9861m
        /* renamed from: b */
        public float mo61258b(int i10, int i11, int i12, int i13) {
            return Math.max(i12 / i10, i13 / i11);
        }
    }

    /* renamed from: g2.m$e */
    public static class e extends AbstractC9861m {
        @Override // p306g2.AbstractC9861m
        /* renamed from: a */
        public g mo61257a(int i10, int i11, int i12, int i13) {
            return AbstractC9861m.f48438i ? g.QUALITY : g.MEMORY;
        }

        @Override // p306g2.AbstractC9861m
        /* renamed from: b */
        public float mo61258b(int i10, int i11, int i12, int i13) {
            if (AbstractC9861m.f48438i) {
                return Math.min(i12 / i10, i13 / i11);
            }
            if (Math.max(i11 / i13, i10 / i12) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r0);
        }
    }

    /* renamed from: g2.m$f */
    public static class f extends AbstractC9861m {
        @Override // p306g2.AbstractC9861m
        /* renamed from: a */
        public g mo61257a(int i10, int i11, int i12, int i13) {
            return g.QUALITY;
        }

        @Override // p306g2.AbstractC9861m
        /* renamed from: b */
        public float mo61258b(int i10, int i11, int i12, int i13) {
            return 1.0f;
        }
    }

    /* renamed from: g2.m$g */
    public enum g {
        MEMORY,
        QUALITY
    }

    static {
        d dVar = new d();
        f48434e = dVar;
        f48435f = new f();
        f48436g = dVar;
        f48437h = C13683h.m82279f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
        f48438i = true;
    }

    /* renamed from: a */
    public abstract g mo61257a(int i10, int i11, int i12, int i13);

    /* renamed from: b */
    public abstract float mo61258b(int i10, int i11, int i12, int i13);
}
