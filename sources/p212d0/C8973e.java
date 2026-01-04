package p212d0;

import java.util.Locale;

/* renamed from: d0.e */
/* loaded from: classes.dex */
public final class C8973e {

    /* renamed from: a */
    public static final InterfaceC8972d f45506a = new e(null, false);

    /* renamed from: b */
    public static final InterfaceC8972d f45507b = new e(null, true);

    /* renamed from: c */
    public static final InterfaceC8972d f45508c;

    /* renamed from: d */
    public static final InterfaceC8972d f45509d;

    /* renamed from: e */
    public static final InterfaceC8972d f45510e;

    /* renamed from: f */
    public static final InterfaceC8972d f45511f;

    /* renamed from: d0.e$a */
    public static class a implements c {

        /* renamed from: b */
        public static final a f45512b = new a(true);

        /* renamed from: a */
        public final boolean f45513a;

        public a(boolean z10) {
            this.f45513a = z10;
        }

        @Override // p212d0.C8973e.c
        /* renamed from: a */
        public int mo56780a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            boolean z10 = false;
            while (i10 < i12) {
                int iM56778a = C8973e.m56778a(Character.getDirectionality(charSequence.charAt(i10)));
                if (iM56778a != 0) {
                    if (iM56778a != 1) {
                        continue;
                        i10++;
                        z10 = z10;
                    } else if (!this.f45513a) {
                        return 1;
                    }
                } else if (this.f45513a) {
                    return 0;
                }
                z10 = true;
                i10++;
                z10 = z10;
            }
            if (z10) {
                return this.f45513a ? 1 : 0;
            }
            return 2;
        }
    }

    /* renamed from: d0.e$b */
    public static class b implements c {

        /* renamed from: a */
        public static final b f45514a = new b();

        @Override // p212d0.C8973e.c
        /* renamed from: a */
        public int mo56780a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            int iM56779b = 2;
            while (i10 < i12 && iM56779b == 2) {
                iM56779b = C8973e.m56779b(Character.getDirectionality(charSequence.charAt(i10)));
                i10++;
            }
            return iM56779b;
        }
    }

    /* renamed from: d0.e$c */
    public interface c {
        /* renamed from: a */
        int mo56780a(CharSequence charSequence, int i10, int i11);
    }

    /* renamed from: d0.e$d */
    public static abstract class d implements InterfaceC8972d {

        /* renamed from: a */
        public final c f45515a;

        public d(c cVar) {
            this.f45515a = cVar;
        }

        @Override // p212d0.InterfaceC8972d
        /* renamed from: a */
        public boolean mo56777a(CharSequence charSequence, int i10, int i11) {
            if (charSequence == null || i10 < 0 || i11 < 0 || charSequence.length() - i11 < i10) {
                throw new IllegalArgumentException();
            }
            return this.f45515a == null ? mo56781b() : m56782c(charSequence, i10, i11);
        }

        /* renamed from: b */
        public abstract boolean mo56781b();

        /* renamed from: c */
        public final boolean m56782c(CharSequence charSequence, int i10, int i11) {
            int iMo56780a = this.f45515a.mo56780a(charSequence, i10, i11);
            if (iMo56780a == 0) {
                return true;
            }
            if (iMo56780a != 1) {
                return mo56781b();
            }
            return false;
        }
    }

    /* renamed from: d0.e$e */
    public static class e extends d {

        /* renamed from: b */
        public final boolean f45516b;

        public e(c cVar, boolean z10) {
            super(cVar);
            this.f45516b = z10;
        }

        @Override // p212d0.C8973e.d
        /* renamed from: b */
        public boolean mo56781b() {
            return this.f45516b;
        }
    }

    /* renamed from: d0.e$f */
    public static class f extends d {

        /* renamed from: b */
        public static final f f45517b = new f();

        public f() {
            super(null);
        }

        @Override // p212d0.C8973e.d
        /* renamed from: b */
        public boolean mo56781b() {
            return C8974f.m56783a(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f45514a;
        f45508c = new e(bVar, false);
        f45509d = new e(bVar, true);
        f45510e = new e(a.f45512b, false);
        f45511f = f.f45517b;
    }

    /* renamed from: a */
    public static int m56778a(int i10) {
        if (i10 != 0) {
            return (i10 == 1 || i10 == 2) ? 0 : 2;
        }
        return 1;
    }

    /* renamed from: b */
    public static int m56779b(int i10) {
        if (i10 != 0) {
            if (i10 == 1 || i10 == 2) {
                return 0;
            }
            switch (i10) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
