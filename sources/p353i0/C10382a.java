package p353i0;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import p243e0.C9373h;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* renamed from: i0.a */
/* loaded from: classes.dex */
public final class C10382a {

    /* renamed from: a */
    public static final String[] f50170a = new String[0];

    /* renamed from: i0.a$a */
    public static class a {
        /* renamed from: a */
        public static void m63837a(EditorInfo editorInfo, CharSequence charSequence, int i10) {
            editorInfo.setInitialSurroundingSubText(charSequence, i10);
        }
    }

    /* renamed from: a */
    public static boolean m63830a(CharSequence charSequence, int i10, int i11) {
        if (i11 == 0) {
            return Character.isLowSurrogate(charSequence.charAt(i10));
        }
        if (i11 != 1) {
            return false;
        }
        return Character.isHighSurrogate(charSequence.charAt(i10));
    }

    /* renamed from: b */
    public static boolean m63831b(int i10) {
        int i11 = i10 & 4095;
        return i11 == 129 || i11 == 225 || i11 == 18;
    }

    /* renamed from: c */
    public static void m63832c(EditorInfo editorInfo, String[] strArr) {
        editorInfo.contentMimeTypes = strArr;
    }

    /* renamed from: d */
    public static void m63833d(EditorInfo editorInfo, CharSequence charSequence, int i10) {
        C9373h.m58745f(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            a.m63837a(editorInfo, charSequence, i10);
            return;
        }
        int i11 = editorInfo.initialSelStart;
        int i12 = editorInfo.initialSelEnd;
        int i13 = i11 > i12 ? i12 - i10 : i11 - i10;
        int i14 = i11 > i12 ? i11 - i10 : i12 - i10;
        int length = charSequence.length();
        if (i10 < 0 || i13 < 0 || i14 > length) {
            m63835f(editorInfo, null, 0, 0);
            return;
        }
        if (m63831b(editorInfo.inputType)) {
            m63835f(editorInfo, null, 0, 0);
        } else if (length <= 2048) {
            m63835f(editorInfo, charSequence, i13, i14);
        } else {
            m63836g(editorInfo, charSequence, i13, i14);
        }
    }

    /* renamed from: e */
    public static void m63834e(EditorInfo editorInfo, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            a.m63837a(editorInfo, charSequence, 0);
        } else {
            m63833d(editorInfo, charSequence, 0);
        }
    }

    /* renamed from: f */
    public static void m63835f(EditorInfo editorInfo, CharSequence charSequence, int i10, int i11) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i10);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i11);
    }

    /* renamed from: g */
    public static void m63836g(EditorInfo editorInfo, CharSequence charSequence, int i10, int i11) {
        int i12 = i11 - i10;
        int i13 = i12 > 1024 ? 0 : i12;
        int i14 = 2048 - i13;
        int iMin = Math.min(charSequence.length() - i11, i14 - Math.min(i10, (int) (i14 * 0.8d)));
        int iMin2 = Math.min(i10, i14 - iMin);
        int i15 = i10 - iMin2;
        if (m63830a(charSequence, i15, 0)) {
            i15++;
            iMin2--;
        }
        if (m63830a(charSequence, (i11 + iMin) - 1, 1)) {
            iMin--;
        }
        m63835f(editorInfo, i13 != i12 ? TextUtils.concat(charSequence.subSequence(i15, i15 + iMin2), charSequence.subSequence(i11, iMin + i11)) : charSequence.subSequence(i15, iMin2 + i13 + iMin + i15), iMin2, i13 + iMin2);
    }
}
