package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.C0688e;
import androidx.emoji2.text.C0696m;
import java.util.Arrays;

/* renamed from: androidx.emoji2.text.h */
/* loaded from: classes.dex */
public final class C0691h {

    /* renamed from: a */
    public final C0688e.i f3633a;

    /* renamed from: b */
    public final C0696m f3634b;

    /* renamed from: c */
    public C0688e.d f3635c;

    /* renamed from: d */
    public final boolean f3636d;

    /* renamed from: e */
    public final int[] f3637e;

    /* renamed from: androidx.emoji2.text.h$a */
    public static final class a {
        /* renamed from: a */
        public static int m4267a(CharSequence charSequence, int i10, int i11) {
            int length = charSequence.length();
            if (i10 < 0 || length < i10 || i11 < 0) {
                return -1;
            }
            while (true) {
                boolean z10 = false;
                while (i11 != 0) {
                    i10--;
                    if (i10 < 0) {
                        return z10 ? -1 : 0;
                    }
                    char cCharAt = charSequence.charAt(i10);
                    if (z10) {
                        if (!Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        i11--;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i11--;
                    } else {
                        if (Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        z10 = true;
                    }
                }
                return i10;
            }
        }

        /* renamed from: b */
        public static int m4268b(CharSequence charSequence, int i10, int i11) {
            int length = charSequence.length();
            if (i10 < 0 || length < i10 || i11 < 0) {
                return -1;
            }
            while (true) {
                boolean z10 = false;
                while (i11 != 0) {
                    if (i10 >= length) {
                        if (z10) {
                            return -1;
                        }
                        return length;
                    }
                    char cCharAt = charSequence.charAt(i10);
                    if (z10) {
                        if (!Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i11--;
                        i10++;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i11--;
                        i10++;
                    } else {
                        if (Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i10++;
                        z10 = true;
                    }
                }
                return i10;
            }
        }
    }

    /* renamed from: androidx.emoji2.text.h$b */
    public static final class b {

        /* renamed from: a */
        public int f3638a = 1;

        /* renamed from: b */
        public final C0696m.a f3639b;

        /* renamed from: c */
        public C0696m.a f3640c;

        /* renamed from: d */
        public C0696m.a f3641d;

        /* renamed from: e */
        public int f3642e;

        /* renamed from: f */
        public int f3643f;

        /* renamed from: g */
        public final boolean f3644g;

        /* renamed from: h */
        public final int[] f3645h;

        public b(C0696m.a aVar, boolean z10, int[] iArr) {
            this.f3639b = aVar;
            this.f3640c = aVar;
            this.f3644g = z10;
            this.f3645h = iArr;
        }

        /* renamed from: d */
        public static boolean m4269d(int i10) {
            return i10 == 65039;
        }

        /* renamed from: f */
        public static boolean m4270f(int i10) {
            return i10 == 65038;
        }

        /* renamed from: a */
        public int m4271a(int i10) {
            C0696m.a aVarM4304a = this.f3640c.m4304a(i10);
            int iM4275g = 2;
            if (this.f3638a != 2) {
                if (aVarM4304a == null) {
                    iM4275g = m4275g();
                } else {
                    this.f3638a = 2;
                    this.f3640c = aVarM4304a;
                    this.f3643f = 1;
                }
            } else if (aVarM4304a != null) {
                this.f3640c = aVarM4304a;
                this.f3643f++;
            } else if (m4270f(i10)) {
                iM4275g = m4275g();
            } else if (!m4269d(i10)) {
                if (this.f3640c.m4305b() != null) {
                    iM4275g = 3;
                    if (this.f3643f != 1 || m4276h()) {
                        this.f3641d = this.f3640c;
                        m4275g();
                    } else {
                        iM4275g = m4275g();
                    }
                } else {
                    iM4275g = m4275g();
                }
            }
            this.f3642e = i10;
            return iM4275g;
        }

        /* renamed from: b */
        public C0690g m4272b() {
            return this.f3640c.m4305b();
        }

        /* renamed from: c */
        public C0690g m4273c() {
            return this.f3641d.m4305b();
        }

        /* renamed from: e */
        public boolean m4274e() {
            return this.f3638a == 2 && this.f3640c.m4305b() != null && (this.f3643f > 1 || m4276h());
        }

        /* renamed from: g */
        public final int m4275g() {
            this.f3638a = 1;
            this.f3640c = this.f3639b;
            this.f3643f = 0;
            return 1;
        }

        /* renamed from: h */
        public final boolean m4276h() {
            if (this.f3640c.m4305b().m4257j() || m4269d(this.f3642e)) {
                return true;
            }
            if (this.f3644g) {
                if (this.f3645h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f3645h, this.f3640c.m4305b().m4249b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public C0691h(C0696m c0696m, C0688e.i iVar, C0688e.d dVar, boolean z10, int[] iArr) {
        this.f3633a = iVar;
        this.f3634b = c0696m;
        this.f3635c = dVar;
        this.f3636d = z10;
        this.f3637e = iArr;
    }

    /* renamed from: b */
    public static boolean m4259b(Editable editable, KeyEvent keyEvent, boolean z10) {
        AbstractC0692i[] abstractC0692iArr;
        if (m4263g(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!m4262f(selectionStart, selectionEnd) && (abstractC0692iArr = (AbstractC0692i[]) editable.getSpans(selectionStart, selectionEnd, AbstractC0692i.class)) != null && abstractC0692iArr.length > 0) {
            for (AbstractC0692i abstractC0692i : abstractC0692iArr) {
                int spanStart = editable.getSpanStart(abstractC0692i);
                int spanEnd = editable.getSpanEnd(abstractC0692i);
                if ((z10 && spanStart == selectionStart) || ((!z10 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m4260c(InputConnection inputConnection, Editable editable, int i10, int i11, boolean z10) {
        int iMax;
        int iMin;
        if (editable != null && inputConnection != null && i10 >= 0 && i11 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (m4262f(selectionStart, selectionEnd)) {
                return false;
            }
            if (z10) {
                iMax = a.m4267a(editable, selectionStart, Math.max(i10, 0));
                iMin = a.m4268b(editable, selectionEnd, Math.max(i11, 0));
                if (iMax == -1 || iMin == -1) {
                    return false;
                }
            } else {
                iMax = Math.max(selectionStart - i10, 0);
                iMin = Math.min(selectionEnd + i11, editable.length());
            }
            AbstractC0692i[] abstractC0692iArr = (AbstractC0692i[]) editable.getSpans(iMax, iMin, AbstractC0692i.class);
            if (abstractC0692iArr != null && abstractC0692iArr.length > 0) {
                for (AbstractC0692i abstractC0692i : abstractC0692iArr) {
                    int spanStart = editable.getSpanStart(abstractC0692i);
                    int spanEnd = editable.getSpanEnd(abstractC0692i);
                    iMax = Math.min(spanStart, iMax);
                    iMin = Math.max(spanEnd, iMin);
                }
                int iMax2 = Math.max(iMax, 0);
                int iMin2 = Math.min(iMin, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(iMax2, iMin2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m4261d(Editable editable, int i10, KeyEvent keyEvent) {
        boolean zM4259b;
        if (i10 != 67) {
            if (i10 == 112) {
                zM4259b = m4259b(editable, keyEvent, true);
            }
            return false;
        }
        zM4259b = m4259b(editable, keyEvent, false);
        if (zM4259b) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public static boolean m4262f(int i10, int i11) {
        return i10 == -1 || i11 == -1 || i10 != i11;
    }

    /* renamed from: g */
    public static boolean m4263g(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    /* renamed from: a */
    public final void m4264a(Spannable spannable, C0690g c0690g, int i10, int i11) {
        spannable.setSpan(this.f3633a.m4247a(c0690g), i10, i11, 33);
    }

    /* renamed from: e */
    public final boolean m4265e(CharSequence charSequence, int i10, int i11, C0690g c0690g) {
        if (c0690g.m4251d() == 0) {
            c0690g.m4258k(this.f3635c.mo4219a(charSequence, i10, i11, c0690g.m4255h()));
        }
        return c0690g.m4251d() == 2;
    }

    /* renamed from: h */
    public CharSequence m4266h(CharSequence charSequence, int i10, int i11, int i12, boolean z10) {
        C0699p c0699p;
        int iCharCount;
        AbstractC0692i[] abstractC0692iArr;
        boolean z11 = charSequence instanceof C0697n;
        if (z11) {
            ((C0697n) charSequence).m4308a();
        }
        if (!z11) {
            try {
                c0699p = charSequence instanceof Spannable ? new C0699p((Spannable) charSequence) : (!(charSequence instanceof Spanned) || ((Spanned) charSequence).nextSpanTransition(i10 + (-1), i11 + 1, AbstractC0692i.class) > i11) ? null : new C0699p(charSequence);
            } finally {
                if (z11) {
                    ((C0697n) charSequence).m4310d();
                }
            }
        }
        if (c0699p != null && (abstractC0692iArr = (AbstractC0692i[]) c0699p.getSpans(i10, i11, AbstractC0692i.class)) != null && abstractC0692iArr.length > 0) {
            for (AbstractC0692i abstractC0692i : abstractC0692iArr) {
                int spanStart = c0699p.getSpanStart(abstractC0692i);
                int spanEnd = c0699p.getSpanEnd(abstractC0692i);
                if (spanStart != i11) {
                    c0699p.removeSpan(abstractC0692i);
                }
                i10 = Math.min(spanStart, i10);
                i11 = Math.max(spanEnd, i11);
            }
        }
        if (i10 != i11 && i10 < charSequence.length()) {
            if (i12 != Integer.MAX_VALUE && c0699p != null) {
                i12 -= ((AbstractC0692i[]) c0699p.getSpans(0, c0699p.length(), AbstractC0692i.class)).length;
            }
            b bVar = new b(this.f3634b.m4301f(), this.f3636d, this.f3637e);
            int iCodePointAt = Character.codePointAt(charSequence, i10);
            int i13 = 0;
            C0699p c0699p2 = c0699p;
            loop1: while (true) {
                iCharCount = i10;
                while (i10 < i11 && i13 < i12) {
                    int iM4271a = bVar.m4271a(iCodePointAt);
                    if (iM4271a == 1) {
                        iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                        if (iCharCount < i11) {
                            iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                        }
                        i10 = iCharCount;
                    } else if (iM4271a == 2) {
                        i10 += Character.charCount(iCodePointAt);
                        if (i10 < i11) {
                            iCodePointAt = Character.codePointAt(charSequence, i10);
                        }
                    } else if (iM4271a == 3) {
                        if (z10 || !m4265e(charSequence, iCharCount, i10, bVar.m4273c())) {
                            if (c0699p2 == null) {
                                c0699p2 = new C0699p((Spannable) new SpannableString(charSequence));
                            }
                            m4264a(c0699p2, bVar.m4273c(), iCharCount, i10);
                            i13++;
                        }
                    }
                }
                break loop1;
            }
            if (bVar.m4274e() && i13 < i12 && (z10 || !m4265e(charSequence, iCharCount, i10, bVar.m4272b()))) {
                if (c0699p2 == null) {
                    c0699p2 = new C0699p(charSequence);
                }
                m4264a(c0699p2, bVar.m4272b(), iCharCount, i10);
            }
            if (c0699p2 == null) {
                if (z11) {
                    ((C0697n) charSequence).m4310d();
                }
                return charSequence;
            }
            Spannable spannableM4322b = c0699p2.m4322b();
            if (z11) {
                ((C0697n) charSequence).m4310d();
            }
            return spannableM4322b;
        }
        return charSequence;
    }
}
