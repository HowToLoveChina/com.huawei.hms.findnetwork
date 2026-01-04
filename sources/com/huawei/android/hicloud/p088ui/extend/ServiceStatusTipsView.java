package com.huawei.android.hicloud.p088ui.extend;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import aq.C1011a;
import com.huawei.hicloud.sync.R$color;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hicloud.sync.R$plurals;
import com.huawei.hicloud.sync.R$string;
import com.huawei.uikit.hwtextview.widget.HwTextView;

/* loaded from: classes3.dex */
public class ServiceStatusTipsView extends ServiceStatusTipsBaseView {

    /* renamed from: a */
    public HwTextView f17971a;

    /* renamed from: b */
    public ImageView f17972b;

    public ServiceStatusTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: d */
    public void m24016d() {
        ImageView imageView = this.f17972b;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    /* renamed from: e */
    public void m24017e() {
        ImageView imageView = this.f17972b;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.extend.ServiceStatusTipsBaseView
    public int getServiceStatusTipLayout() {
        return R$layout.service_status_new_tip_layout;
    }

    @Override // com.huawei.android.hicloud.p088ui.extend.ServiceStatusTipsBaseView
    public TextView getTipTextView() {
        return this.f17971a;
    }

    @Override // com.huawei.android.hicloud.p088ui.extend.ServiceStatusTipsBaseView
    public CharSequence getTipsText() throws Resources.NotFoundException {
        int iM24067e = C3948f.m24064g().m24067e();
        String serviceNameText = getServiceNameText();
        if (iM24067e <= 0 || TextUtils.isEmpty(serviceNameText)) {
            m24016d();
            return getContext().getString(R$string.service_text_default_new);
        }
        m24017e();
        String quantityString = getContext().getResources().getQuantityString(iM24067e > 2 ? R$plurals.service_text_tips2_new : R$plurals.service_text_tips1_new, iM24067e, serviceNameText, Integer.valueOf(iM24067e));
        if (quantityString == null) {
            return getContext().getString(R$string.service_text_default_new);
        }
        String strM6163c = C1011a.m6163c(Integer.valueOf(iM24067e));
        int iIndexOf = quantityString.indexOf(strM6163c);
        if (iIndexOf < 0 || strM6163c.length() + iIndexOf > quantityString.length()) {
            return quantityString;
        }
        SpannableString spannableString = new SpannableString(quantityString);
        spannableString.setSpan(new ForegroundColorSpan(getContext().getColor(R$color.emui_color_text_primary)), iIndexOf, strM6163c.length() + iIndexOf, 33);
        spannableString.setSpan(new StyleSpan(1), iIndexOf, strM6163c.length() + iIndexOf, 33);
        return spannableString;
    }

    @Override // com.huawei.android.hicloud.p088ui.extend.ServiceStatusTipsBaseView
    public void setTipTextView(View view) {
        this.f17971a = (HwTextView) view.findViewById(R$id.tips_content);
        this.f17972b = (ImageView) view.findViewById(R$id.tips_icon);
    }

    public ServiceStatusTipsView(Context context) {
        super(context);
    }
}
