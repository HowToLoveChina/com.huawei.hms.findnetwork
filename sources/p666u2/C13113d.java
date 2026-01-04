package p666u2;

import android.util.Property;
import android.view.ViewGroup;
import com.google.android.material.R$id;

/* renamed from: u2.d */
/* loaded from: classes.dex */
public class C13113d extends Property<ViewGroup, Float> {

    /* renamed from: a */
    public static final Property<ViewGroup, Float> f59603a = new C13113d("childrenAlpha");

    public C13113d(String str) {
        super(Float.class, str);
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(ViewGroup viewGroup) {
        Float f10 = (Float) viewGroup.getTag(R$id.mtrl_internal_children_alpha_tag);
        return f10 != null ? f10 : Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(ViewGroup viewGroup, Float f10) {
        float fFloatValue = f10.floatValue();
        viewGroup.setTag(R$id.mtrl_internal_children_alpha_tag, f10);
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            viewGroup.getChildAt(i10).setAlpha(fFloatValue);
        }
    }
}
