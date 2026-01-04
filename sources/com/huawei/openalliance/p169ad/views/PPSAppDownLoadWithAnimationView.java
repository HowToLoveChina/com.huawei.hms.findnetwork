package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.util.AttributeSet;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;

/* loaded from: classes2.dex */
public class PPSAppDownLoadWithAnimationView extends PPSAppDetailView {
    public PPSAppDownLoadWithAnimationView(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.p169ad.views.PPSAppDetailView
    /* renamed from: a */
    public int mo48921a(Context context) {
        return AbstractC7741ao.m47592n(context) ? C6849R.layout.hiad_app_download_elderly_font_with_animation_template : C6849R.layout.hiad_app_download_with_animation_template;
    }

    @Override // com.huawei.openalliance.p169ad.views.PPSAppDetailView
    /* renamed from: b */
    public void mo48964b(Context context) {
        this.f36511b = (AppDownloadButton) findViewById(C6849R.id.app_download_btn);
    }

    public PPSAppDownLoadWithAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PPSAppDownLoadWithAnimationView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
