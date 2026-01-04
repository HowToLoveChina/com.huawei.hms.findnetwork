package com.huawei.android.hicloud.p088ui.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.huawei.android.hicloud.p088ui.extend.C3948f;
import com.huawei.android.hicloud.p088ui.extend.ServiceStatusTipsBaseView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.uikit.hwtextview.widget.HwTextView;

/* loaded from: classes3.dex */
public class SyncStatusTipsView extends ServiceStatusTipsBaseView {

    /* renamed from: a */
    public HwTextView f19560a;

    public SyncStatusTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.huawei.android.hicloud.p088ui.extend.ServiceStatusTipsBaseView
    public int getServiceStatusTipLayout() {
        return R$layout.service_status_tip_layout;
    }

    @Override // com.huawei.android.hicloud.p088ui.extend.ServiceStatusTipsBaseView
    public CharSequence getTipsText() {
        int iM24067e = C3948f.m24064g().m24067e();
        String serviceNameText = getServiceNameText();
        if (iM24067e <= 0 || TextUtils.isEmpty(serviceNameText)) {
            return getContext().getString(R$string.service_text_default_sync);
        }
        return getContext().getResources().getQuantityString(iM24067e > 2 ? R$plurals.sync_and_backup_service_text2 : R$plurals.sync_and_backup_service_text1, iM24067e, serviceNameText, Integer.valueOf(iM24067e));
    }

    @Override // com.huawei.android.hicloud.p088ui.extend.ServiceStatusTipsBaseView
    public void setTipTextView(View view) {
        HwTextView hwTextView = (HwTextView) view.findViewById(R$id.tips_content);
        this.f19560a = hwTextView;
        hwTextView.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f19560a.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        this.f19560a.setLayoutParams(layoutParams);
        view.findViewById(R$id.tips_icon).setVisibility(8);
        view.findViewById(R$id.tips_divider).setVisibility(8);
    }

    public SyncStatusTipsView(Context context) {
        super(context);
    }

    @Override // com.huawei.android.hicloud.p088ui.extend.ServiceStatusTipsBaseView
    public HwTextView getTipTextView() {
        return this.f19560a;
    }
}
