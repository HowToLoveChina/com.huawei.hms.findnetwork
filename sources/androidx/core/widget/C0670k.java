package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import p273f0.C9588c;
import p273f0.InterfaceC9589c0;

/* renamed from: androidx.core.widget.k */
/* loaded from: classes.dex */
public final class C0670k implements InterfaceC9589c0 {

    /* renamed from: androidx.core.widget.k$a */
    public static final class a {
        /* renamed from: a */
        public static CharSequence m4116a(Context context, ClipData.Item item, int i10) {
            if ((i10 & 1) == 0) {
                return item.coerceToStyledText(context);
            }
            CharSequence charSequenceCoerceToText = item.coerceToText(context);
            return charSequenceCoerceToText instanceof Spanned ? charSequenceCoerceToText.toString() : charSequenceCoerceToText;
        }
    }

    /* renamed from: b */
    public static CharSequence m4113b(Context context, ClipData.Item item, int i10) {
        return a.m4116a(context, item, i10);
    }

    /* renamed from: c */
    public static void m4114c(Editable editable, CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int iMax = Math.max(0, Math.min(selectionStart, selectionEnd));
        int iMax2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, iMax2);
        editable.replace(iMax, iMax2, charSequence);
    }

    @Override // p273f0.InterfaceC9589c0
    /* renamed from: a */
    public C9588c mo4115a(View view, C9588c c9588c) {
        if (Log.isLoggable("ReceiveContent", 3)) {
            Log.d("ReceiveContent", "onReceive: " + c9588c);
        }
        if (c9588c.m59795d() == 2) {
            return c9588c;
        }
        ClipData clipDataM59793b = c9588c.m59793b();
        int iM59794c = c9588c.m59794c();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z10 = false;
        for (int i10 = 0; i10 < clipDataM59793b.getItemCount(); i10++) {
            CharSequence charSequenceM4113b = m4113b(context, clipDataM59793b.getItemAt(i10), iM59794c);
            if (charSequenceM4113b != null) {
                if (z10) {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), charSequenceM4113b);
                } else {
                    m4114c(editable, charSequenceM4113b);
                    z10 = true;
                }
            }
        }
        return null;
    }
}
