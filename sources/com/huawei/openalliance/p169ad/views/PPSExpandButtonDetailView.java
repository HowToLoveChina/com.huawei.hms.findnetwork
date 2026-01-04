package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;

/* loaded from: classes2.dex */
public class PPSExpandButtonDetailView extends PPSAppDetailView {

    /* renamed from: e */
    private RelativeLayout f36641e;

    public PPSExpandButtonDetailView(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.p169ad.views.PPSAppDetailView
    /* renamed from: a */
    public int mo48921a(Context context) {
        boolean zM47592n = AbstractC7741ao.m47592n(context);
        int i10 = this.f36512c;
        return zM47592n ? i10 == 1 ? C6849R.layout.hiad_landing_elderly_friendly_detail_half : C6849R.layout.hiad_landing_elderly_friendly_detail : i10 == 1 ? C6849R.layout.hiad_landing_expand_button_detail_half : C6849R.layout.hiad_landing_expand_button_detail;
    }

    @Override // com.huawei.openalliance.p169ad.views.PPSAppDetailView
    /* renamed from: b */
    public void mo48964b(Context context) {
        this.f36511b = (AppDownloadButton) findViewById(C6849R.id.app_download_btn);
        Resources resources = context.getResources();
        this.f36511b.setFixedWidth(true);
        this.f36511b.setTextColor(resources.getColor(C6849R.color.hiad_emui_8_btn_color));
    }

    @Override // com.huawei.openalliance.p169ad.views.PPSAppDetailView
    public int getDetailStyle() {
        return 2;
    }

    public void setExtraViewVisibility(int i10) {
        if (i10 == 0) {
            return;
        }
        SixElementsView sixElementsView = this.f36513d;
        if (sixElementsView != null) {
            sixElementsView.setVisibility(i10);
        }
        this.f36641e = (RelativeLayout) findViewById(C6849R.id.app_download_btn_rl);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, C6849R.id.app_description);
        if (i10 != 0 || AbstractC7741ao.m47592n(getContext())) {
            Resources resources = getResources();
            int i11 = C6849R.dimen.hiad_16_dp;
            layoutParams.setMargins(0, resources.getDimensionPixelSize(i11), 0, getResources().getDimensionPixelSize(i11));
        } else {
            layoutParams.addRule(8);
            layoutParams.addRule(14);
            layoutParams.bottomMargin = getResources().getDimensionPixelSize(C6849R.dimen.hiad_16_dp);
        }
        this.f36641e.setLayoutParams(layoutParams);
    }

    public PPSExpandButtonDetailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.huawei.openalliance.p169ad.views.PPSAppDetailView
    /* renamed from: a */
    public void mo48958a(int i10) {
        AbstractC7185ho.m43821b("ExBtnDetailView", "updateDetailViewType: %s", Integer.valueOf(i10));
        if (2 == i10) {
            this.f36513d.setVisibility(8);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(C6849R.id.app_download_btn_rl);
            this.f36641e = relativeLayout;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            if (layoutParams == null) {
                AbstractC7185ho.m43823c("ExBtnDetailView", "param is null");
                return;
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(C6849R.dimen.hiad_landing_bottom_btn_margin_bottom);
            layoutParams.topMargin = dimensionPixelSize;
            layoutParams.bottomMargin = dimensionPixelSize;
            AbstractC7185ho.m43818a("ExBtnDetailView", "bottomMargin: %s", Integer.valueOf(dimensionPixelSize));
            this.f36641e.setLayoutParams(layoutParams);
        }
    }

    public PPSExpandButtonDetailView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
