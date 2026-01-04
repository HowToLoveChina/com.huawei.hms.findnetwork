package com.huawei.openalliance.p169ad.views;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.InterpolatorC7160gq;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import java.util.ArrayList;

/* renamed from: com.huawei.openalliance.ad.views.l */
/* loaded from: classes2.dex */
public class C8136l extends C8134j {

    /* renamed from: f */
    protected ImageView f37931f;

    public C8136l(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m50331b() {
        if (this.f37931f == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new InterpolatorC7160gq(0.33f, 0.0f, 0.67f, 1.0f));
        ArrayList arrayList = new ArrayList(4);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f37931f, "rotation", 0.0f, -7.0f);
        objectAnimatorOfFloat.setDuration(150L);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f37931f, "rotation", -7.0f, 7.0f);
        objectAnimatorOfFloat2.setDuration(400L);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f37931f, "rotation", 7.0f, -4.5f);
        objectAnimatorOfFloat3.setDuration(350L);
        arrayList.add(objectAnimatorOfFloat3);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.f37931f, "rotation", -4.5f, 2.0f);
        objectAnimatorOfFloat4.setDuration(350L);
        arrayList.add(objectAnimatorOfFloat4);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.f37931f, "rotation", 2.0f, 0.0f);
        objectAnimatorOfFloat5.setDuration(250L);
        arrayList.add(objectAnimatorOfFloat5);
        this.f37931f.invalidate();
        animatorSet.playSequentially(arrayList);
        animatorSet.start();
    }

    public String getViewTag() {
        return "PPSBaseTwistView";
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        AbstractC7185ho.m43821b(getViewTag(), "w=%s, h=%s, oldw=%s, oldh=%s", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
        this.f37931f.post(new Runnable() { // from class: com.huawei.openalliance.ad.views.l.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43821b(C8136l.this.getViewTag(), "imageView %s %s", Integer.valueOf(C8136l.this.f37931f.getWidth()), Integer.valueOf(C8136l.this.f37931f.getHeight()));
                C8136l.this.f37931f.setPivotX(r0.getWidth() / 2.0f);
                C8136l.this.f37931f.setPivotY(r0.getHeight() + AbstractC7741ao.m47535a(C8136l.this.getContext(), 80.0f));
                C8136l.this.m50331b();
            }
        });
    }

    public C8136l(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public C8136l(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
