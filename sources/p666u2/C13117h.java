package p666u2;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import java.util.ArrayList;
import java.util.List;
import p438l.C11213g;

/* renamed from: u2.h */
/* loaded from: classes.dex */
public class C13117h {

    /* renamed from: a */
    public final C11213g<String, C13118i> f59610a = new C11213g<>();

    /* renamed from: b */
    public final C11213g<String, PropertyValuesHolder[]> f59611b = new C11213g<>();

    /* renamed from: a */
    public static void m78896a(C13117h c13117h, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            c13117h.m78907l(objectAnimator.getPropertyName(), objectAnimator.getValues());
            c13117h.m78908m(objectAnimator.getPropertyName(), C13118i.m78909b(objectAnimator));
        } else {
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }

    /* renamed from: c */
    public static C13117h m78897c(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        if (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return m78898d(context, resourceId);
    }

    /* renamed from: d */
    public static C13117h m78898d(Context context, int i10) throws Resources.NotFoundException {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i10);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return m78899e(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return m78899e(arrayList);
        } catch (Exception e10) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i10), e10);
            return null;
        }
    }

    /* renamed from: e */
    public static C13117h m78899e(List<Animator> list) {
        C13117h c13117h = new C13117h();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            m78896a(c13117h, list.get(i10));
        }
        return c13117h;
    }

    /* renamed from: b */
    public final PropertyValuesHolder[] m78900b(PropertyValuesHolder[] propertyValuesHolderArr) {
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i10 = 0; i10 < propertyValuesHolderArr.length; i10++) {
            propertyValuesHolderArr2[i10] = propertyValuesHolderArr[i10].clone();
        }
        return propertyValuesHolderArr2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C13117h) {
            return this.f59610a.equals(((C13117h) obj).f59610a);
        }
        return false;
    }

    /* renamed from: f */
    public <T> ObjectAnimator m78901f(String str, T t10, Property<T, ?> property) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(t10, m78902g(str));
        objectAnimatorOfPropertyValuesHolder.setProperty(property);
        m78903h(str).m78911a(objectAnimatorOfPropertyValuesHolder);
        return objectAnimatorOfPropertyValuesHolder;
    }

    /* renamed from: g */
    public PropertyValuesHolder[] m78902g(String str) {
        if (m78905j(str)) {
            return m78900b(this.f59611b.get(str));
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: h */
    public C13118i m78903h(String str) {
        if (m78906k(str)) {
            return this.f59610a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public int hashCode() {
        return this.f59610a.hashCode();
    }

    /* renamed from: i */
    public long m78904i() {
        int size = this.f59610a.size();
        long jMax = 0;
        for (int i10 = 0; i10 < size; i10++) {
            C13118i c13118iM67335m = this.f59610a.m67335m(i10);
            jMax = Math.max(jMax, c13118iM67335m.m78912c() + c13118iM67335m.m78913d());
        }
        return jMax;
    }

    /* renamed from: j */
    public boolean m78905j(String str) {
        return this.f59611b.get(str) != null;
    }

    /* renamed from: k */
    public boolean m78906k(String str) {
        return this.f59610a.get(str) != null;
    }

    /* renamed from: l */
    public void m78907l(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f59611b.put(str, propertyValuesHolderArr);
    }

    /* renamed from: m */
    public void m78908m(String str, C13118i c13118i) {
        this.f59610a.put(str, c13118i);
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f59610a + "}\n";
    }
}
