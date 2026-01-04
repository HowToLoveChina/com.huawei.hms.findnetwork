package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.huawei.hicloud.sync.R$color;
import com.huawei.hicloud.sync.R$drawable;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hicloud.sync.R$plurals;
import com.huawei.hicloud.sync.R$string;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import p514o9.C11839m;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class FullDataServiceTipView extends FrameLayout {
    private static final String TAG = "FullDataServiceTipView";
    private Context context;
    private View inflateView;
    private LinearLayout llBg;
    private HwTextView tipView;

    public FullDataServiceTipView(Context context) throws Resources.NotFoundException {
        super(context);
        this.context = context;
        initView();
    }

    private void initView() throws Resources.NotFoundException {
        View viewInflate = View.inflate(this.context, R$layout.full_data_service_tip_layout, this);
        this.inflateView = viewInflate;
        this.tipView = (HwTextView) C12809f.m76831d(viewInflate, R$id.full_data_service_tip);
        this.llBg = (LinearLayout) C12809f.m76831d(this.inflateView, R$id.ll_bg);
        show();
    }

    public void setMaxWidth(int i10) {
        HwTextView hwTextView = this.tipView;
        if (hwTextView != null) {
            hwTextView.setMaxWidth(i10);
        }
    }

    public void show() throws Resources.NotFoundException {
        setVisibility(8);
        long jM80853S = C13452e.m80781L().m80853S();
        C11839m.m70688i(TAG, "memberRemainDays = " + jM80853S + " ; gradeType = " + C13452e.m80781L().m80802F());
        if (jM80853S == -1) {
            return;
        }
        this.llBg.setBackground(this.context.getDrawable(R$drawable.full_data_service_remain_link));
        this.tipView.setTextColor(this.context.getColor(R$color.full_data_service_remain_link_text_color));
        int i10 = jM80853S == 0 ? 1 : (int) jM80853S;
        Context context = this.context;
        if (context == null || context.getResources() == null) {
            return;
        }
        String quantityString = this.context.getResources().getQuantityString(R$plurals.common_days, i10, Integer.valueOf(i10));
        if (C13452e.m80781L().m80887a1()) {
            this.tipView.setText(this.context.getResources().getQuantityString(R$plurals.full_service_trial_days, i10, Integer.valueOf(i10)));
        } else {
            this.tipView.setText(this.context.getResources().getString(R$string.cloud_home_page_package_reminder_three, quantityString));
        }
        setVisibility(0);
    }

    public FullDataServiceTipView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        this.context = context;
        initView();
    }
}
