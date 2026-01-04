package p480n0;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import p243e0.C9373h;

/* renamed from: n0.a */
/* loaded from: classes.dex */
public final class C11581a {

    /* renamed from: a */
    public final b f53735a;

    /* renamed from: b */
    public int f53736b = Integer.MAX_VALUE;

    /* renamed from: c */
    public int f53737c = 0;

    /* renamed from: n0.a$a */
    public static class a extends b {

        /* renamed from: a */
        public final EditText f53738a;

        /* renamed from: b */
        public final C11587g f53739b;

        public a(EditText editText, boolean z10) {
            this.f53738a = editText;
            C11587g c11587g = new C11587g(editText, z10);
            this.f53739b = c11587g;
            editText.addTextChangedListener(c11587g);
            editText.setEditableFactory(C11582b.getInstance());
        }

        @Override // p480n0.C11581a.b
        /* renamed from: a */
        public KeyListener mo69147a(KeyListener keyListener) {
            if (keyListener instanceof C11585e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new C11585e(keyListener);
        }

        @Override // p480n0.C11581a.b
        /* renamed from: b */
        public InputConnection mo69148b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof C11583c ? inputConnection : new C11583c(this.f53738a, inputConnection, editorInfo);
        }

        @Override // p480n0.C11581a.b
        /* renamed from: c */
        public void mo69149c(boolean z10) {
            this.f53739b.m69178c(z10);
        }
    }

    /* renamed from: n0.a$b */
    public static class b {
        /* renamed from: a */
        public KeyListener mo69147a(KeyListener keyListener) {
            throw null;
        }

        /* renamed from: b */
        public InputConnection mo69148b(InputConnection inputConnection, EditorInfo editorInfo) {
            throw null;
        }

        /* renamed from: c */
        public void mo69149c(boolean z10) {
            throw null;
        }
    }

    public C11581a(EditText editText, boolean z10) {
        C9373h.m58746g(editText, "editText cannot be null");
        this.f53735a = new a(editText, z10);
    }

    /* renamed from: a */
    public KeyListener m69144a(KeyListener keyListener) {
        return this.f53735a.mo69147a(keyListener);
    }

    /* renamed from: b */
    public InputConnection m69145b(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f53735a.mo69148b(inputConnection, editorInfo);
    }

    /* renamed from: c */
    public void m69146c(boolean z10) {
        this.f53735a.mo69149c(z10);
    }
}
