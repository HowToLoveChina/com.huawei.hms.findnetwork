package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7523nr;
import com.huawei.openalliance.p169ad.InterfaceC7182hl;
import com.huawei.openalliance.p169ad.InterfaceC7539og;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8126s;

/* renamed from: com.huawei.openalliance.ad.views.ae */
/* loaded from: classes2.dex */
public class C8070ae extends RelativeLayout implements InterfaceC8126s {

    /* renamed from: a */
    private static final String f37493a = "ae";

    /* renamed from: b */
    private InterfaceC7539og f37494b;

    /* renamed from: c */
    private int f37495c;

    /* renamed from: d */
    private int f37496d;

    /* renamed from: e */
    private int f37497e;

    /* renamed from: f */
    private View f37498f;

    /* renamed from: g */
    private float f37499g;

    public C8070ae(Context context, int i10, int i11, int i12) {
        super(context);
        this.f37496d = 0;
        this.f37497e = i10;
        this.f37495c = i11;
        m49990b(i12);
    }

    /* renamed from: a */
    public void m49991a() {
        setVisibility(0);
        if (this.f37498f == null) {
            this.f37494b.mo46202a(this.f37495c, true);
        }
    }

    /* renamed from: b */
    public void m49993b() {
        setVisibility(8);
    }

    public int getOrientation() {
        return this.f37497e;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        AbstractC7185ho.m43818a(f37493a, "onSizeChanged w: %d h: %d oldw: %d oldh: %d", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
        m49989a(i10, i11);
    }

    public void setSloganShowListener(InterfaceC7182hl interfaceC7182hl) {
        this.f37494b.mo46201a(interfaceC7182hl);
    }

    public void setWideSloganResId(int i10) {
        this.f37496d = i10;
    }

    /* renamed from: b */
    private void m49990b(int i10) {
        this.f37494b = new C7523nr(getContext(), this, i10);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8126s
    /* renamed from: a */
    public void mo49992a(int i10) {
        ImageView imageView;
        if (AbstractC7811dd.m48317c(getContext())) {
            AbstractC7185ho.m43823c(f37493a, "showImageView - activity finished, not add view");
            return;
        }
        View view = this.f37498f;
        if (view instanceof ImageView) {
            imageView = (ImageView) view;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f37498f = imageView;
            addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
        }
        imageView.setImageResource(i10);
    }

    /* renamed from: a */
    private void m49989a(int i10, int i11) {
        int i12;
        String str;
        if (i10 <= 0 || i11 <= 0) {
            return;
        }
        float f10 = (i10 * 1.0f) / i11;
        float fAbs = Math.abs(this.f37499g - f10);
        String str2 = f37493a;
        AbstractC7185ho.m43818a(str2, "ratio: %s diff:%s", Float.valueOf(f10), Float.valueOf(fAbs));
        if (fAbs > 0.01f) {
            this.f37499g = f10;
            if (f10 <= 0.9f || (i12 = this.f37496d) <= 0) {
                i12 = this.f37495c;
                str = "pick defaultSloganResId";
            } else {
                str = "pick wideSloganResId";
            }
            AbstractC7185ho.m43817a(str2, str);
            this.f37494b.mo46202a(i12, false);
        }
    }
}
