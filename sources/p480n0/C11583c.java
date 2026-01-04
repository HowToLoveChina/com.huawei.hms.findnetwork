package p480n0;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.emoji2.text.C0688e;

/* renamed from: n0.c */
/* loaded from: classes.dex */
public final class C11583c extends InputConnectionWrapper {

    /* renamed from: a */
    public final TextView f53743a;

    /* renamed from: b */
    public final a f53744b;

    /* renamed from: n0.c$a */
    public static class a {
        /* renamed from: a */
        public boolean m69151a(InputConnection inputConnection, Editable editable, int i10, int i11, boolean z10) {
            return C0688e.m4222e(inputConnection, editable, i10, i11, z10);
        }

        /* renamed from: b */
        public void m69152b(EditorInfo editorInfo) {
            if (C0688e.m4225h()) {
                C0688e.m4221b().m4240u(editorInfo);
            }
        }
    }

    public C11583c(TextView textView, InputConnection inputConnection, EditorInfo editorInfo, a aVar) {
        super(inputConnection, false);
        this.f53743a = textView;
        this.f53744b = aVar;
        aVar.m69152b(editorInfo);
    }

    /* renamed from: a */
    public final Editable m69150a() {
        return this.f53743a.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i10, int i11) {
        return this.f53744b.m69151a(this, m69150a(), i10, i11, false) || super.deleteSurroundingText(i10, i11);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i10, int i11) {
        return this.f53744b.m69151a(this, m69150a(), i10, i11, true) || super.deleteSurroundingTextInCodePoints(i10, i11);
    }

    public C11583c(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new a());
    }
}
