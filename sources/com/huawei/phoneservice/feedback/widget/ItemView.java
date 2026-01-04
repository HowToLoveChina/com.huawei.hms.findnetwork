package com.huawei.phoneservice.feedback.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.huawei.phoneservice.faq.base.util.FaqTahitiUtils;
import com.huawei.uikit.hwresources.C8732R;

/* loaded from: classes5.dex */
public class ItemView extends RelativeLayout {

    /* renamed from: a */
    public Context f40013a;

    public ItemView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        FaqTahitiUtils.setWidth(this, this.f40013a.getResources().getDimensionPixelOffset(C8732R.dimen.emui_dimens_max_start));
    }

    public ItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f40013a = context;
    }
}
