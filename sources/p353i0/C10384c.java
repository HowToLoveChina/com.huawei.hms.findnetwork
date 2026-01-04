package p353i0;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import p243e0.C9368c;
import p243e0.C9373h;
import p273f0.C9588c;
import p273f0.C9603h0;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* renamed from: i0.c */
/* loaded from: classes.dex */
public final class C10384c {

    /* renamed from: i0.c$a */
    public class a extends InputConnectionWrapper {

        /* renamed from: a */
        public final /* synthetic */ b f50172a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InputConnection inputConnection, boolean z10, b bVar) {
            super(inputConnection, z10);
            this.f50172a = bVar;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitContent(InputContentInfo inputContentInfo, int i10, Bundle bundle) {
            if (this.f50172a.mo63838a(C10385d.m63844f(inputContentInfo), i10, bundle)) {
                return true;
            }
            return super.commitContent(inputContentInfo, i10, bundle);
        }
    }

    /* renamed from: i0.c$b */
    public interface b {
        /* renamed from: a */
        boolean mo63838a(C10385d c10385d, int i10, Bundle bundle);
    }

    /* renamed from: b */
    public static b m63840b(final View view) {
        C9373h.m58745f(view);
        return new b() { // from class: i0.b
            @Override // p353i0.C10384c.b
            /* renamed from: a */
            public final boolean mo63838a(C10385d c10385d, int i10, Bundle bundle) {
                return C10384c.m63843e(view, c10385d, i10, bundle);
            }
        };
    }

    /* renamed from: c */
    public static InputConnection m63841c(View view, InputConnection inputConnection, EditorInfo editorInfo) {
        return m63842d(inputConnection, editorInfo, m63840b(view));
    }

    @Deprecated
    /* renamed from: d */
    public static InputConnection m63842d(InputConnection inputConnection, EditorInfo editorInfo, b bVar) {
        C9368c.m58732d(inputConnection, "inputConnection must be non-null");
        C9368c.m58732d(editorInfo, "editorInfo must be non-null");
        C9368c.m58732d(bVar, "onCommitContentListener must be non-null");
        return new a(inputConnection, false, bVar);
    }

    /* renamed from: e */
    public static /* synthetic */ boolean m63843e(View view, C10385d c10385d, int i10, Bundle bundle) {
        if ((i10 & 1) != 0) {
            try {
                c10385d.m63848d();
                InputContentInfo inputContentInfo = (InputContentInfo) c10385d.m63849e();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo);
            } catch (Exception e10) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e10);
                return false;
            }
        }
        return C9603h0.m59882f0(view, new C9588c.a(new ClipData(c10385d.m63846b(), new ClipData.Item(c10385d.m63845a())), 2).m59800d(c10385d.m63847c()).m59798b(bundle).m59797a()) == null;
    }
}
