package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import p273f0.C9588c;
import p273f0.C9603h0;

/* renamed from: androidx.appcompat.widget.l */
/* loaded from: classes.dex */
public final class C0536l {

    /* renamed from: androidx.appcompat.widget.l$a */
    public static final class a {
        /* renamed from: a */
        public static boolean m3061a(DragEvent dragEvent, TextView textView, Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
                C9603h0.m59882f0(textView, new C9588c.a(dragEvent.getClipData(), 3).m59797a());
                textView.endBatchEdit();
                return true;
            } catch (Throwable th2) {
                textView.endBatchEdit();
                throw th2;
            }
        }

        /* renamed from: b */
        public static boolean m3062b(DragEvent dragEvent, View view, Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            C9603h0.m59882f0(view, new C9588c.a(dragEvent.getClipData(), 3).m59797a());
            return true;
        }
    }

    /* renamed from: a */
    public static boolean m3058a(View view, DragEvent dragEvent) {
        if (Build.VERSION.SDK_INT < 31 && dragEvent.getLocalState() == null && C9603h0.m59838D(view) != null) {
            Activity activityM3060c = m3060c(view);
            if (activityM3060c == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + view);
                return false;
            }
            if (dragEvent.getAction() == 1) {
                return !(view instanceof TextView);
            }
            if (dragEvent.getAction() == 3) {
                return view instanceof TextView ? a.m3061a(dragEvent, (TextView) view, activityM3060c) : a.m3062b(dragEvent, view, activityM3060c);
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m3059b(TextView textView, int i10) {
        if (Build.VERSION.SDK_INT >= 31 || C9603h0.m59838D(textView) == null || !(i10 == 16908322 || i10 == 16908337)) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            C9603h0.m59882f0(textView, new C9588c.a(primaryClip, 1).m59799c(i10 != 16908322 ? 1 : 0).m59797a());
        }
        return true;
    }

    /* renamed from: c */
    public static Activity m3060c(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
