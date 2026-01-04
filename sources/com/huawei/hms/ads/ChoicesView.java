package com.huawei.hms.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7022dk;
import com.huawei.openalliance.p169ad.C7650rz;
import com.huawei.openalliance.p169ad.C7653sb;
import com.huawei.openalliance.p169ad.C7654sc;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7752az;

/* loaded from: classes8.dex */
public class ChoicesView extends ImageView {

    /* renamed from: a */
    private C7022dk f23145a;

    /* renamed from: com.huawei.hms.ads.ChoicesView$1 */
    public class RunnableC50621 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f23146a;

        public RunnableC50621(String str) {
            this.f23146a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7653sb c7653sb = new C7653sb();
            c7653sb.m47181b(false);
            c7653sb.m47185c(true);
            c7653sb.m47180b("icon");
            c7653sb.m47187d(this.f23146a);
            C7654sc c7654scM47158a = new C7650rz(ChoicesView.this.getContext(), c7653sb).m47158a();
            if (c7654scM47158a != null) {
                String strM47207a = c7654scM47158a.m47207a();
                if (TextUtils.isEmpty(strM47207a)) {
                    return;
                }
                String strM41968c = ChoicesView.this.f23145a.m41968c(strM47207a);
                if (TextUtils.isEmpty(strM41968c)) {
                    return;
                }
                C7752az.m47690a(ChoicesView.this.getContext(), strM41968c, new C7752az.a() { // from class: com.huawei.hms.ads.ChoicesView.1.1
                    @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
                    /* renamed from: a */
                    public void mo30231a() {
                        AbstractC7185ho.m43817a("ChoicesView", "download icon fail, use local icon");
                        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.hms.ads.ChoicesView.1.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ChoicesView.this.m30230b();
                            }
                        });
                    }

                    @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
                    /* renamed from: a */
                    public void mo30232a(final Drawable drawable) {
                        if (drawable != null) {
                            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.hms.ads.ChoicesView.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ChoicesView.this.setImageDrawable(drawable);
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    public ChoicesView(Context context) throws Resources.NotFoundException {
        super(context, null);
        m30227a(context);
    }

    /* renamed from: b */
    public void m30230b() {
        AbstractC7185ho.m43817a("ChoicesView", "updateIcon from local.");
        setImageResource(C6849R.drawable.hiad_choices_adchoice);
    }

    public void setAdChoiceIcon(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AbstractC7185ho.m43817a("ChoicesView", "updateIcon from server.");
        AbstractC7834m.m48484d(new RunnableC50621(str));
    }

    public ChoicesView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        m30227a(context);
    }

    /* renamed from: a */
    public void m30228a() {
        setImageResource(C6849R.drawable.hiad_choices_close_btn);
    }

    public ChoicesView(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        m30227a(context);
    }

    /* renamed from: a */
    public void m30229a(int i10) {
        AbstractC7185ho.m43818a("ChoicesView", "changeChoiceViewSize dp = %d", Integer.valueOf(i10));
        Resources resources = getContext().getResources();
        setLayoutParams(new RelativeLayout.LayoutParams(resources.getDimensionPixelSize(i10), resources.getDimensionPixelSize(i10)));
    }

    public ChoicesView(Context context, AttributeSet attributeSet, int i10, int i11) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        m30227a(context);
    }

    /* renamed from: a */
    private void m30227a(Context context) throws Resources.NotFoundException {
        Resources resources = getContext().getResources();
        int i10 = C6849R.dimen.hiad_24_dp;
        int dimensionPixelSize = resources.getDimensionPixelSize(i10);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(i10);
        AbstractC7185ho.m43818a("ChoicesView", "adChoiceViewWidth = %d", Integer.valueOf(dimensionPixelSize));
        setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2));
        setImageResource(C6849R.drawable.hiad_hm_info);
        this.f23145a = C7019dh.m41937a(context, Constants.NORMAL_CACHE);
    }
}
