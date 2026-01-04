package com.huawei.android.hicloud.p088ui.uiextend.backup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.huawei.android.hicloud.p088ui.activity.BackupCleanRecordsActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupAppThinActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupOldDevicesCleanActivity;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import p514o9.C11839m;
import p684un.C13225d;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class RecommendCleanupItemView extends LinearLayout implements View.OnClickListener {
    private static final String TAG = "RecommendCleanupView";
    private Activity activity;
    private ImageView imageView;
    private int mItemType;
    private HwTextView recommendTextView;
    private long totalSize;
    private HwTextView tvTip1;
    private HwTextView tvTip2;

    public interface ItemType {
        public static final int CLEAR_DEVICE = 1;
        public static final int CLEAR_PACKAGE = 3;
        public static final int CLEAR_RECORDS = 2;
    }

    public RecommendCleanupItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.totalSize = 0L;
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, R$layout.recommend_cleanup_view_item, this);
        this.tvTip1 = (HwTextView) C12809f.m76831d(this, R$id.recommend_tip_1);
        this.tvTip2 = (HwTextView) C12809f.m76831d(this, R$id.recommend_tip_2);
        this.imageView = (ImageView) C12809f.m76831d(this, R$id.recommend_bg_iv);
        this.recommendTextView = (HwTextView) C12809f.m76831d(this, R$id.recommend_tv);
        C12809f.m76831d(this, R$id.clear_bt).setOnClickListener(this);
    }

    private void reportRecommendClearDeviceButton() {
        C13225d.m79490f1().m79585f0("recommend_click_to_clear_device_button", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "recommend_click_to_clear_device_button", "1", "80");
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.clear_bt) {
            C11839m.m70688i(TAG, "clear type: " + this.mItemType);
            int i10 = this.mItemType;
            if (i10 == 1) {
                Intent intent = new Intent(getContext(), (Class<?>) CloudBackupOldDevicesCleanActivity.class);
                intent.putExtra("totalSize", this.totalSize);
                Activity activity = this.activity;
                if (activity != null) {
                    activity.startActivityForResult(intent, 10000);
                }
                reportRecommendClearDeviceButton();
                return;
            }
            if (i10 == 2) {
                getContext().startActivity(new Intent(getContext(), (Class<?>) BackupCleanRecordsActivity.class));
            } else if (i10 == 3) {
                getContext().startActivity(new Intent(getContext(), (Class<?>) CloudBackupAppThinActivity.class));
            }
        }
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setImageView(Drawable drawable) {
        this.imageView.setImageDrawable(drawable);
    }

    public void setItemType(int i10) {
        this.mItemType = i10;
    }

    public void setMaxWidth(int i10) {
        C11839m.m70686d(TAG, "setMaxWidth  " + i10);
        if (i10 > 0) {
            this.recommendTextView.setMaxWidth(i10);
        }
    }

    public void setTips(int i10) throws Resources.NotFoundException {
        if (this.mItemType == 1) {
            SpannableString spannableString = new SpannableString(getContext().getResources().getQuantityString(R$plurals.recommend_old_device_tip_2, i10, Integer.valueOf(i10)));
            spannableString.setSpan(new AbsoluteSizeSpan(44, true), 0, String.valueOf(i10).length(), 17);
            String quantityString = getContext().getResources().getQuantityString(R$plurals.backup_cleanup_old_device_sub_tip_1, i10);
            this.tvTip1.setText(spannableString);
            this.tvTip2.setText(quantityString);
        }
    }

    public void setTotalSize(long j10) {
        this.totalSize = j10;
    }
}
