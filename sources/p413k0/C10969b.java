package p413k0;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* renamed from: k0.b */
/* loaded from: classes.dex */
public class C10969b {

    /* renamed from: k0.b$a */
    public interface a<T> {
        /* renamed from: a */
        void mo66229a(T t10, Rect rect);
    }

    /* renamed from: k0.b$b */
    public interface b<T, V> {
        /* renamed from: a */
        V mo66231a(T t10, int i10);

        /* renamed from: b */
        int mo66232b(T t10);
    }

    /* renamed from: k0.b$c */
    public static class c<T> implements Comparator<T> {

        /* renamed from: a */
        public final Rect f51967a = new Rect();

        /* renamed from: b */
        public final Rect f51968b = new Rect();

        /* renamed from: c */
        public final boolean f51969c;

        /* renamed from: d */
        public final a<T> f51970d;

        public c(boolean z10, a<T> aVar) {
            this.f51969c = z10;
            this.f51970d = aVar;
        }

        @Override // java.util.Comparator
        public int compare(T t10, T t11) {
            Rect rect = this.f51967a;
            Rect rect2 = this.f51968b;
            this.f51970d.mo66229a(t10, rect);
            this.f51970d.mo66229a(t11, rect2);
            int i10 = rect.top;
            int i11 = rect2.top;
            if (i10 < i11) {
                return -1;
            }
            if (i10 > i11) {
                return 1;
            }
            int i12 = rect.left;
            int i13 = rect2.left;
            if (i12 < i13) {
                return this.f51969c ? 1 : -1;
            }
            if (i12 > i13) {
                return this.f51969c ? -1 : 1;
            }
            int i14 = rect.bottom;
            int i15 = rect2.bottom;
            if (i14 < i15) {
                return -1;
            }
            if (i14 > i15) {
                return 1;
            }
            int i16 = rect.right;
            int i17 = rect2.right;
            if (i16 < i17) {
                return this.f51969c ? 1 : -1;
            }
            if (i16 > i17) {
                return this.f51969c ? -1 : 1;
            }
            return 0;
        }
    }

    /* renamed from: a */
    public static boolean m66235a(int i10, Rect rect, Rect rect2, Rect rect3) {
        boolean zM66236b = m66236b(i10, rect, rect2);
        if (m66236b(i10, rect, rect3) || !zM66236b) {
            return false;
        }
        return !m66244j(i10, rect, rect3) || i10 == 17 || i10 == 66 || m66245k(i10, rect, rect2) < m66247m(i10, rect, rect3);
    }

    /* renamed from: b */
    public static boolean m66236b(int i10, Rect rect, Rect rect2) {
        if (i10 != 17) {
            if (i10 != 33) {
                if (i10 != 66) {
                    if (i10 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    /* renamed from: c */
    public static <L, T> T m66237c(L l10, b<L, T> bVar, a<T> aVar, T t10, Rect rect, int i10) {
        Rect rect2 = new Rect(rect);
        if (i10 == 17) {
            rect2.offset(rect.width() + 1, 0);
        } else if (i10 == 33) {
            rect2.offset(0, rect.height() + 1);
        } else if (i10 == 66) {
            rect2.offset(-(rect.width() + 1), 0);
        } else {
            if (i10 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect2.offset(0, -(rect.height() + 1));
        }
        int iMo66232b = bVar.mo66232b(l10);
        Rect rect3 = new Rect();
        T t11 = null;
        for (int i11 = 0; i11 < iMo66232b; i11++) {
            T tMo66231a = bVar.mo66231a(l10, i11);
            if (tMo66231a != t10) {
                aVar.mo66229a(tMo66231a, rect3);
                if (m66242h(i10, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    t11 = tMo66231a;
                }
            }
        }
        return t11;
    }

    /* renamed from: d */
    public static <L, T> T m66238d(L l10, b<L, T> bVar, a<T> aVar, T t10, int i10, boolean z10, boolean z11) {
        int iMo66232b = bVar.mo66232b(l10);
        ArrayList arrayList = new ArrayList(iMo66232b);
        for (int i11 = 0; i11 < iMo66232b; i11++) {
            arrayList.add(bVar.mo66231a(l10, i11));
        }
        Collections.sort(arrayList, new c(z10, aVar));
        if (i10 == 1) {
            return (T) m66240f(t10, arrayList, z11);
        }
        if (i10 == 2) {
            return (T) m66239e(t10, arrayList, z11);
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }

    /* renamed from: e */
    public static <T> T m66239e(T t10, ArrayList<T> arrayList, boolean z10) {
        int size = arrayList.size();
        int iLastIndexOf = (t10 == null ? -1 : arrayList.lastIndexOf(t10)) + 1;
        if (iLastIndexOf < size) {
            return arrayList.get(iLastIndexOf);
        }
        if (!z10 || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    /* renamed from: f */
    public static <T> T m66240f(T t10, ArrayList<T> arrayList, boolean z10) {
        int size = arrayList.size();
        int iIndexOf = (t10 == null ? size : arrayList.indexOf(t10)) - 1;
        if (iIndexOf >= 0) {
            return arrayList.get(iIndexOf);
        }
        if (!z10 || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    /* renamed from: g */
    public static int m66241g(int i10, int i11) {
        return (i10 * 13 * i10) + (i11 * i11);
    }

    /* renamed from: h */
    public static boolean m66242h(int i10, Rect rect, Rect rect2, Rect rect3) {
        if (!m66243i(rect, rect2, i10)) {
            return false;
        }
        if (m66243i(rect, rect3, i10) && !m66235a(i10, rect, rect2, rect3)) {
            return !m66235a(i10, rect, rect3, rect2) && m66241g(m66245k(i10, rect, rect2), m66249o(i10, rect, rect2)) < m66241g(m66245k(i10, rect, rect3), m66249o(i10, rect, rect3));
        }
        return true;
    }

    /* renamed from: i */
    public static boolean m66243i(Rect rect, Rect rect2, int i10) {
        if (i10 == 17) {
            int i11 = rect.right;
            int i12 = rect2.right;
            return (i11 > i12 || rect.left >= i12) && rect.left > rect2.left;
        }
        if (i10 == 33) {
            int i13 = rect.bottom;
            int i14 = rect2.bottom;
            return (i13 > i14 || rect.top >= i14) && rect.top > rect2.top;
        }
        if (i10 == 66) {
            int i15 = rect.left;
            int i16 = rect2.left;
            return (i15 < i16 || rect.right <= i16) && rect.right < rect2.right;
        }
        if (i10 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i17 = rect.top;
        int i18 = rect2.top;
        return (i17 < i18 || rect.bottom <= i18) && rect.bottom < rect2.bottom;
    }

    /* renamed from: j */
    public static boolean m66244j(int i10, Rect rect, Rect rect2) {
        if (i10 == 17) {
            return rect.left >= rect2.right;
        }
        if (i10 == 33) {
            return rect.top >= rect2.bottom;
        }
        if (i10 == 66) {
            return rect.right <= rect2.left;
        }
        if (i10 == 130) {
            return rect.bottom <= rect2.top;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    /* renamed from: k */
    public static int m66245k(int i10, Rect rect, Rect rect2) {
        return Math.max(0, m66246l(i10, rect, rect2));
    }

    /* renamed from: l */
    public static int m66246l(int i10, Rect rect, Rect rect2) {
        int i11;
        int i12;
        if (i10 == 17) {
            i11 = rect.left;
            i12 = rect2.right;
        } else if (i10 == 33) {
            i11 = rect.top;
            i12 = rect2.bottom;
        } else if (i10 == 66) {
            i11 = rect2.left;
            i12 = rect.right;
        } else {
            if (i10 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i11 = rect2.top;
            i12 = rect.bottom;
        }
        return i11 - i12;
    }

    /* renamed from: m */
    public static int m66247m(int i10, Rect rect, Rect rect2) {
        return Math.max(1, m66248n(i10, rect, rect2));
    }

    /* renamed from: n */
    public static int m66248n(int i10, Rect rect, Rect rect2) {
        int i11;
        int i12;
        if (i10 == 17) {
            i11 = rect.left;
            i12 = rect2.left;
        } else if (i10 == 33) {
            i11 = rect.top;
            i12 = rect2.top;
        } else if (i10 == 66) {
            i11 = rect2.right;
            i12 = rect.right;
        } else {
            if (i10 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i11 = rect2.bottom;
            i12 = rect.bottom;
        }
        return i11 - i12;
    }

    /* renamed from: o */
    public static int m66249o(int i10, Rect rect, Rect rect2) {
        if (i10 != 17) {
            if (i10 != 33) {
                if (i10 != 66) {
                    if (i10 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }
}
