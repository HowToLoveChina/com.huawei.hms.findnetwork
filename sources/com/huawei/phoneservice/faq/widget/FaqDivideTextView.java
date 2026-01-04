package com.huawei.phoneservice.faq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.huawei.phoneservice.faq.R$dimen;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;

/* loaded from: classes4.dex */
public class FaqDivideTextView extends AppCompatTextView {
    public FaqDivideTextView(Context context) {
        super(context);
        m52447r(context, null);
    }

    /* renamed from: r */
    public final void m52447r(Context context, AttributeSet attributeSet) {
        setAllCaps(true);
        Resources resources = context.getResources();
        int i10 = R$dimen.faq_sdk_list_item_padding_start;
        int dimension = (int) resources.getDimension(i10);
        int dimension2 = (int) context.getResources().getDimension(i10);
        if (!FaqCommonUtils.isEmui50OrLater()) {
            setGravity(16);
        } else {
            setGravity(80);
            setPadding(dimension, 0, dimension, dimension2);
        }
    }

    public FaqDivideTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m52447r(context, attributeSet);
    }

    public FaqDivideTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m52447r(context, attributeSet);
    }
}
