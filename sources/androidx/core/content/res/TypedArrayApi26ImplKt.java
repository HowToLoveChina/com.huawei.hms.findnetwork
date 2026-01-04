package androidx.core.content.res;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import p692uw.C13267j;

/* loaded from: classes.dex */
final class TypedArrayApi26ImplKt {
    public static final TypedArrayApi26ImplKt INSTANCE = new TypedArrayApi26ImplKt();

    private TypedArrayApi26ImplKt() {
    }

    public static final Typeface getFont(TypedArray typedArray, int i10) {
        C13267j.m79677e(typedArray, "typedArray");
        Typeface font = typedArray.getFont(i10);
        C13267j.m79674b(font);
        return font;
    }
}
