package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hicloud.sync.R$plurals;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import sk.C12809f;

/* loaded from: classes3.dex */
public class MembershipExpiredView extends FrameLayout {
    private static final String TAG = "MembershipExpiredView";
    private Context context;
    private HwTextView tipView;

    public MembershipExpiredView(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    private void initView() {
        this.tipView = (HwTextView) C12809f.m76831d(View.inflate(this.context, R$layout.membership_expired_layout, this), R$id.membership_expired_days);
    }

    public void setMaxWidth(int i10) {
        HwTextView hwTextView = this.tipView;
        if (hwTextView != null) {
            hwTextView.setMaxWidth(i10);
        }
    }

    public void setText(int i10) {
        HwTextView hwTextView = this.tipView;
        if (hwTextView != null) {
            hwTextView.setText(getContext().getResources().getQuantityString(R$plurals.storage_service_expired_day, i10, Integer.valueOf(i10)));
        }
    }

    public MembershipExpiredView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        initView();
    }
}
