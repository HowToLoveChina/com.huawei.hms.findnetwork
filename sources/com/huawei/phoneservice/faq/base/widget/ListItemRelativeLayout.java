package com.huawei.phoneservice.faq.base.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.Keep;
import com.huawei.phoneservice.faq.base.util.FaqTahitiUtils;
import com.huawei.uikit.hwresources.C8732R;

@Keep
/* loaded from: classes4.dex */
public class ListItemRelativeLayout extends RelativeLayout {
    private Context mContext;

    public ListItemRelativeLayout(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        this.mContext = context;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        FaqTahitiUtils.setMargins(this, this.mContext.getResources().getDimensionPixelSize(C8732R.dimen.emui_dimens_max_start), this.mContext.getResources().getDimensionPixelSize(C8732R.dimen.emui_dimens_max_end));
        super.onConfigurationChanged(configuration);
    }

    public ListItemRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListItemRelativeLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init(context);
    }
}
