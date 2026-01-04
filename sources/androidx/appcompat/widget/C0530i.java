package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* renamed from: androidx.appcompat.widget.i */
/* loaded from: classes.dex */
public class C0530i {
    /* renamed from: a */
    public static InputConnection m3032a(InputConnection inputConnection, EditorInfo editorInfo, View view) {
        if (inputConnection != null && editorInfo.hintText == null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (!(parent instanceof View)) {
                    break;
                }
                if (parent instanceof InterfaceC0537l0) {
                    editorInfo.hintText = ((InterfaceC0537l0) parent).m3063a();
                    break;
                }
                parent = parent.getParent();
            }
        }
        return inputConnection;
    }
}
