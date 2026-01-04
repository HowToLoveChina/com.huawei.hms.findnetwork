package p480n0;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.C0688e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* renamed from: n0.g */
/* loaded from: classes.dex */
public final class C11587g implements TextWatcher {

    /* renamed from: a */
    public final EditText f53756a;

    /* renamed from: b */
    public final boolean f53757b;

    /* renamed from: c */
    public C0688e.e f53758c;

    /* renamed from: d */
    public int f53759d = Integer.MAX_VALUE;

    /* renamed from: e */
    public int f53760e = 0;

    /* renamed from: f */
    public boolean f53761f = true;

    /* renamed from: n0.g$a */
    public static class a extends C0688e.e {

        /* renamed from: a */
        public final Reference<EditText> f53762a;

        public a(EditText editText) {
            this.f53762a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.C0688e.e
        /* renamed from: b */
        public void mo2836b() {
            super.mo2836b();
            C11587g.m69176b(this.f53762a.get(), 1);
        }
    }

    public C11587g(EditText editText, boolean z10) {
        this.f53756a = editText;
        this.f53757b = z10;
    }

    /* renamed from: b */
    public static void m69176b(EditText editText, int i10) {
        if (i10 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            C0688e.m4221b().m4234o(editableText);
            C11584d.m69153b(editableText, selectionStart, selectionEnd);
        }
    }

    /* renamed from: a */
    public final C0688e.e m69177a() {
        if (this.f53758c == null) {
            this.f53758c = new a(this.f53756a);
        }
        return this.f53758c;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    /* renamed from: c */
    public void m69178c(boolean z10) {
        if (this.f53761f != z10) {
            if (this.f53758c != null) {
                C0688e.m4221b().m4239t(this.f53758c);
            }
            this.f53761f = z10;
            if (z10) {
                m69176b(this.f53756a, C0688e.m4221b().m4227d());
            }
        }
    }

    /* renamed from: d */
    public final boolean m69179d() {
        return (this.f53761f && (this.f53757b || C0688e.m4225h())) ? false : true;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        if (this.f53756a.isInEditMode() || m69179d() || i11 > i12 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iM4227d = C0688e.m4221b().m4227d();
        if (iM4227d != 0) {
            if (iM4227d == 1) {
                C0688e.m4221b().m4237r((Spannable) charSequence, i10, i10 + i12, this.f53759d, this.f53760e);
                return;
            } else if (iM4227d != 3) {
                return;
            }
        }
        C0688e.m4221b().m4238s(m69177a());
    }
}
