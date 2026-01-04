package com.huawei.android.hicloud.p088ui.uiextend.backup;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import p514o9.C11839m;
import sk.C12809f;

/* loaded from: classes3.dex */
public class RecommendCleanupView extends LinearLayout {
    private static final String TAG = "RecommendCleanupView";
    private RecommendCleanupItemView installPackageCard;
    private RecommendCleanupItemView oldDeviceCard;
    private RecommendCleanupItemView oldRecordsCard;
    private long totalSize;

    public RecommendCleanupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.totalSize = 0L;
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, R$layout.recommend_cleanup_view, this);
        this.oldDeviceCard = (RecommendCleanupItemView) C12809f.m76831d(this, R$id.old_device_card);
        this.oldRecordsCard = (RecommendCleanupItemView) C12809f.m76831d(this, R$id.old_records_card);
        this.installPackageCard = (RecommendCleanupItemView) C12809f.m76831d(this, R$id.install_package_card);
        this.oldDeviceCard.setItemType(1);
        this.oldRecordsCard.setItemType(2);
        this.installPackageCard.setItemType(3);
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public void setActivity(Activity activity) {
        this.oldDeviceCard.setActivity(activity);
    }

    public void setMaxWidth(int i10) {
        C11839m.m70688i(TAG, "showOldDeviceCard setMaxWidth: " + i10);
        this.oldDeviceCard.setMaxWidth(i10);
    }

    public void setTotalSize(long j10) {
        this.totalSize = j10;
        RecommendCleanupItemView recommendCleanupItemView = this.oldDeviceCard;
        if (recommendCleanupItemView != null) {
            recommendCleanupItemView.setTotalSize(j10);
        }
    }

    public void showOldDeviceCard(int i10) throws Resources.NotFoundException {
        this.oldDeviceCard.setVisibility(0);
        this.oldDeviceCard.setTips(i10);
        this.oldRecordsCard.setVisibility(8);
        this.installPackageCard.setVisibility(8);
    }
}
