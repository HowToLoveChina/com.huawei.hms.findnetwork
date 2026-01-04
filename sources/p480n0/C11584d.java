package p480n0;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.C0688e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* renamed from: n0.d */
/* loaded from: classes.dex */
public final class C11584d implements InputFilter {

    /* renamed from: a */
    public final TextView f53745a;

    /* renamed from: b */
    public C0688e.e f53746b;

    /* renamed from: n0.d$a */
    public static class a extends C0688e.e {

        /* renamed from: a */
        public final Reference<TextView> f53747a;

        /* renamed from: b */
        public final Reference<C11584d> f53748b;

        public a(TextView textView, C11584d c11584d) {
            this.f53747a = new WeakReference(textView);
            this.f53748b = new WeakReference(c11584d);
        }

        @Override // androidx.emoji2.text.C0688e.e
        /* renamed from: b */
        public void mo2836b() {
            CharSequence text;
            CharSequence charSequenceM4234o;
            super.mo2836b();
            TextView textView = this.f53747a.get();
            if (m69155c(textView, this.f53748b.get()) && textView.isAttachedToWindow() && text != (charSequenceM4234o = C0688e.m4221b().m4234o((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(charSequenceM4234o);
                int selectionEnd = Selection.getSelectionEnd(charSequenceM4234o);
                textView.setText(charSequenceM4234o);
                if (charSequenceM4234o instanceof Spannable) {
                    C11584d.m69153b((Spannable) charSequenceM4234o, selectionStart, selectionEnd);
                }
            }
        }

        /* renamed from: c */
        public final boolean m69155c(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }
    }

    public C11584d(TextView textView) {
        this.f53745a = textView;
    }

    /* renamed from: b */
    public static void m69153b(Spannable spannable, int i10, int i11) {
        if (i10 >= 0 && i11 >= 0) {
            Selection.setSelection(spannable, i10, i11);
        } else if (i10 >= 0) {
            Selection.setSelection(spannable, i10);
        } else if (i11 >= 0) {
            Selection.setSelection(spannable, i11);
        }
    }

    /* renamed from: a */
    public final C0688e.e m69154a() {
        if (this.f53746b == null) {
            this.f53746b = new a(this.f53745a, this);
        }
        return this.f53746b;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
        if (this.f53745a.isInEditMode()) {
            return charSequence;
        }
        int iM4227d = C0688e.m4221b().m4227d();
        if (iM4227d != 0) {
            if (iM4227d == 1) {
                if ((i13 == 0 && i12 == 0 && spanned.length() == 0 && charSequence == this.f53745a.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i10 != 0 || i11 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i10, i11);
                }
                return C0688e.m4221b().m4235p(charSequence, 0, charSequence.length());
            }
            if (iM4227d != 3) {
                return charSequence;
            }
        }
        C0688e.m4221b().m4238s(m69154a());
        return charSequence;
    }
}
