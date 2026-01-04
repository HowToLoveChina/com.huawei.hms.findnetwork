package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$styleable;
import p540p0.C12062c;

/* renamed from: androidx.fragment.app.m */
/* loaded from: classes.dex */
public class LayoutInflaterFactory2C0755m implements LayoutInflater.Factory2 {

    /* renamed from: a */
    public final FragmentManager f4064a;

    /* renamed from: androidx.fragment.app.m$a */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a */
        public final /* synthetic */ C0766x f4065a;

        public a(C0766x c0766x) {
            this.f4065a = c0766x;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Fragment fragmentM4839k = this.f4065a.m4839k();
            this.f4065a.m4841m();
            AbstractC0747g0.m4743n((ViewGroup) fragmentM4839k.f3704I.getParent(), LayoutInflaterFactory2C0755m.this.f4064a).m4753j();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public LayoutInflaterFactory2C0755m(FragmentManager fragmentManager) {
        this.f4064a = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        C0766x c0766xM4606v;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f4064a);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(R$styleable.Fragment_android_name);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.Fragment_android_id, -1);
        String string = typedArrayObtainStyledAttributes.getString(R$styleable.Fragment_android_tag);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !C0753k.m4794b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id2 = view != null ? view.getId() : 0;
        if (id2 == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment fragmentM4568h0 = resourceId != -1 ? this.f4064a.m4568h0(resourceId) : null;
        if (fragmentM4568h0 == null && string != null) {
            fragmentM4568h0 = this.f4064a.m4571i0(string);
        }
        if (fragmentM4568h0 == null && id2 != -1) {
            fragmentM4568h0 = this.f4064a.m4568h0(id2);
        }
        if (fragmentM4568h0 == null) {
            fragmentM4568h0 = this.f4064a.m4601t0().mo4623a(context.getClassLoader(), attributeValue);
            fragmentM4568h0.f3737o = true;
            fragmentM4568h0.f3746x = resourceId != 0 ? resourceId : id2;
            fragmentM4568h0.f3747y = id2;
            fragmentM4568h0.f3748z = string;
            fragmentM4568h0.f3738p = true;
            FragmentManager fragmentManager = this.f4064a;
            fragmentM4568h0.f3742t = fragmentManager;
            fragmentM4568h0.f3743u = fragmentManager.m4607v0();
            fragmentM4568h0.m4451x0(this.f4064a.m4607v0().m4798i(), attributeSet, fragmentM4568h0.f3724b);
            c0766xM4606v = this.f4064a.m4573j(fragmentM4568h0);
            if (FragmentManager.m4492I0(2)) {
                Log.v("FragmentManager", "Fragment " + fragmentM4568h0 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (fragmentM4568h0.f3738p) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id2) + " with another fragment for " + attributeValue);
            }
            fragmentM4568h0.f3738p = true;
            FragmentManager fragmentManager2 = this.f4064a;
            fragmentM4568h0.f3742t = fragmentManager2;
            fragmentM4568h0.f3743u = fragmentManager2.m4607v0();
            fragmentM4568h0.m4451x0(this.f4064a.m4607v0().m4798i(), attributeSet, fragmentM4568h0.f3724b);
            c0766xM4606v = this.f4064a.m4606v(fragmentM4568h0);
            if (FragmentManager.m4492I0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + fragmentM4568h0 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        ViewGroup viewGroup = (ViewGroup) view;
        C12062c.m72208g(fragmentM4568h0, viewGroup);
        fragmentM4568h0.f3703H = viewGroup;
        c0766xM4606v.m4841m();
        c0766xM4606v.m4838j();
        View view2 = fragmentM4568h0.f3704I;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (fragmentM4568h0.f3704I.getTag() == null) {
            fragmentM4568h0.f3704I.setTag(string);
        }
        fragmentM4568h0.f3704I.addOnAttachStateChangeListener(new a(c0766xM4606v));
        return fragmentM4568h0.f3704I;
    }
}
