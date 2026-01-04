package p416k3;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import p303g.C9816d;

/* renamed from: k3.a */
/* loaded from: classes.dex */
public class C10981a {

    /* renamed from: a */
    public static final int[] f52040a = {R.attr.theme, R$attr.theme};

    /* renamed from: b */
    public static final int[] f52041b = {R$attr.materialThemeOverlay};

    /* renamed from: a */
    public static int m66346a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f52040a);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    /* renamed from: b */
    public static int m66347b(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f52041b, i10, i11);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    /* renamed from: c */
    public static Context m66348c(Context context, AttributeSet attributeSet, int i10, int i11) {
        int iM66347b = m66347b(context, attributeSet, i10, i11);
        boolean z10 = (context instanceof C9816d) && ((C9816d) context).m61006c() == iM66347b;
        if (iM66347b == 0 || z10) {
            return context;
        }
        C9816d c9816d = new C9816d(context, iM66347b);
        int iM66346a = m66346a(context, attributeSet);
        if (iM66346a != 0) {
            c9816d.getTheme().applyStyle(iM66346a, true);
        }
        return c9816d;
    }
}
