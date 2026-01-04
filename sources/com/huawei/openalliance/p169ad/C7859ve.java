package com.huawei.openalliance.p169ad;

import android.graphics.drawable.Drawable;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7750ax;
import com.huawei.openalliance.p169ad.utils.C7752az;
import com.huawei.openalliance.p169ad.views.PPSRewardView;

/* renamed from: com.huawei.openalliance.ad.ve */
/* loaded from: classes8.dex */
public class C7859ve implements C7752az.a {

    /* renamed from: a */
    private final PPSRewardView f36240a;

    public C7859ve(PPSRewardView pPSRewardView) {
        this.f36240a = pPSRewardView;
    }

    @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
    /* renamed from: a */
    public void mo30231a() {
        AbstractC7185ho.m43820b("RewardViewOIDL", "get icon failed");
    }

    @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
    /* renamed from: a */
    public void mo30232a(final Drawable drawable) {
        if (drawable != null) {
            final Drawable drawableM47676a = C7750ax.m47676a(this.f36240a.getContext(), drawable, 5.0f, 8.0f);
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.ve.1
                @Override // java.lang.Runnable
                public void run() {
                    C7859ve.this.f36240a.m49593a(drawable, drawableM47676a);
                }
            });
        }
    }
}
