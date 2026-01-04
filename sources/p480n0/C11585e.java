package p480n0;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.text.C0688e;

/* renamed from: n0.e */
/* loaded from: classes.dex */
public final class C11585e implements KeyListener {

    /* renamed from: a */
    public final KeyListener f53749a;

    /* renamed from: b */
    public final a f53750b;

    /* renamed from: n0.e$a */
    public static class a {
        /* renamed from: a */
        public boolean m69156a(Editable editable, int i10, KeyEvent keyEvent) {
            return C0688e.m4223f(editable, i10, keyEvent);
        }
    }

    public C11585e(KeyListener keyListener) {
        this(keyListener, new a());
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View view, Editable editable, int i10) {
        this.f53749a.clearMetaKeyState(view, editable, i10);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.f53749a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i10, KeyEvent keyEvent) {
        return this.f53750b.m69156a(editable, i10, keyEvent) || this.f53749a.onKeyDown(view, editable, i10, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f53749a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View view, Editable editable, int i10, KeyEvent keyEvent) {
        return this.f53749a.onKeyUp(view, editable, i10, keyEvent);
    }

    public C11585e(KeyListener keyListener, a aVar) {
        this.f53749a = keyListener;
        this.f53750b = aVar;
    }
}
