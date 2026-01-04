package com.huawei.android.hicloud.p088ui.uiextend.backup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.huawei.android.hicloud.p088ui.activity.BackupCleanRecordsActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupAppThinActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupOldDevicesCleanActivity;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import p015ak.C0209d;
import p514o9.C11839m;
import p684un.C13225d;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CleanupEntryView extends LinearLayout implements View.OnClickListener {
    public static final String BACKUP_CLEAR = "backup_clear";
    public static final int DEFAULT_SIZE = -1;
    public static final String INTELLIGENT_CLEAR = "intelligent_clear";
    public static final int OLD_DEVICE_REQUEST_CODE = 10000;
    public static final String OLD_DEVICE_SIZE = "old_device_size";
    public static final int OLD_RECORDS_REQUEST_CODE = 10001;
    private static final String TAG = "CleanupEntryView";
    private Activity activity;
    private CleanupItemView cleanupOldBackupRecord;
    private CleanupItemView cleanupOldDevice;
    private CleanupItemView reduceInstallPackage;
    private String reportTag;
    private long totalSize;

    public CleanupEntryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.totalSize = 0L;
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, R$layout.cleanup_entry_view, this);
        this.cleanupOldDevice = (CleanupItemView) C12809f.m76831d(this, R$id.cleanup_old_device);
        this.cleanupOldBackupRecord = (CleanupItemView) C12809f.m76831d(this, R$id.cleanup_old_backup_record);
        this.reduceInstallPackage = (CleanupItemView) C12809f.m76831d(this, R$id.reduce_install_package);
        this.cleanupOldDevice.setOnClickListener(this);
        this.cleanupOldBackupRecord.setOnClickListener(this);
        this.reduceInstallPackage.setOnClickListener(this);
        this.reduceInstallPackage.setVisibility(8);
    }

    private void reportItemClick(String str) {
        String str2 = this.reportTag + "_" + str;
        C13225d.m79490f1().m79585f0(str2, C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", str2, "1", "80");
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public void initSubTip() {
        CleanupItemView cleanupItemView = this.cleanupOldDevice;
        Context context = getContext();
        int i10 = R$string.cloudbackup_loading;
        cleanupItemView.setSubTitleText(context.getString(i10));
        this.cleanupOldDevice.setClickable(false);
        this.cleanupOldBackupRecord.setSubTitleText(getContext().getString(i10));
        this.cleanupOldBackupRecord.setClickable(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            C11839m.m70689w(TAG, "click too fast");
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.cleanup_old_device) {
            Intent intent = new Intent(getContext(), (Class<?>) CloudBackupOldDevicesCleanActivity.class);
            intent.putExtra("totalSize", this.totalSize);
            Activity activity = this.activity;
            if (activity != null) {
                activity.startActivityForResult(intent, 10000);
            }
            reportItemClick("click_to_clear_device_item");
            return;
        }
        if (id2 == R$id.cleanup_old_backup_record) {
            Intent intent2 = new Intent(getContext(), (Class<?>) BackupCleanRecordsActivity.class);
            Activity activity2 = this.activity;
            if (activity2 != null) {
                activity2.startActivityForResult(intent2, 10001);
            }
            reportItemClick("click_to_clear_records_item");
            return;
        }
        if (id2 == R$id.reduce_install_package) {
            getContext().startActivity(new Intent(getContext(), (Class<?>) CloudBackupAppThinActivity.class));
            reportItemClick("click_to_clear_package_item");
        }
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setDeviceErrorSubTip() {
        this.cleanupOldDevice.setSubTitleText(getContext().getString(R$string.backup_cleanup_loading_error_tip_1));
    }

    public void setEntry(String str) {
        this.reportTag = str;
    }

    public void setOldDeviceTip(int i10) throws Resources.NotFoundException {
        if (i10 < 1) {
            this.cleanupOldDevice.setSubTitleText(getContext().getString(R$string.backup_cleanup_no_old_device_sub_tip));
        } else {
            String strValueOf = String.valueOf(i10);
            String quantityString = getContext().getResources().getQuantityString(R$plurals.backup_cleanup_old_device_sub_tip_2, i10, Integer.valueOf(i10));
            int iIndexOf = quantityString.indexOf(strValueOf);
            if (iIndexOf == -1) {
                this.cleanupOldDevice.setSubTitleText(quantityString);
            } else {
                SpannableString spannableString = new SpannableString(quantityString);
                spannableString.setSpan(new ForegroundColorSpan(getContext().getColor(R$color.cleanup_number_color)), iIndexOf, strValueOf.length() + iIndexOf, 17);
                this.cleanupOldDevice.setSubTitleText(spannableString);
            }
        }
        this.cleanupOldDevice.setClickable(true);
    }

    public void setOldRecordsTip(int i10) throws Resources.NotFoundException {
        if (i10 < 1) {
            this.cleanupOldBackupRecord.setSubTitleText(getContext().getString(R$string.backup_cleanup_no_old_backup_record_sub_tip));
        } else {
            String strValueOf = String.valueOf(i10);
            String quantityString = getContext().getResources().getQuantityString(R$plurals.backup_cleanup_old_backup_record_sub_tip, i10, Integer.valueOf(i10));
            int iIndexOf = quantityString.indexOf(strValueOf);
            if (iIndexOf == -1) {
                this.cleanupOldBackupRecord.setSubTitleText(quantityString);
            } else {
                SpannableString spannableString = new SpannableString(quantityString);
                spannableString.setSpan(new ForegroundColorSpan(getContext().getColor(R$color.cleanup_number_color)), iIndexOf, strValueOf.length() + iIndexOf, 17);
                this.cleanupOldBackupRecord.setSubTitleText(spannableString);
            }
        }
        this.cleanupOldBackupRecord.setClickable(true);
    }

    public void setRecordErrorSubTip() {
        this.cleanupOldBackupRecord.setSubTitleText(getContext().getString(R$string.backup_cleanup_loading_error_tip_1));
    }

    public void setSpaceClearTitle() {
        this.cleanupOldDevice.setTitleText(getContext().getText(R$string.cloud_space_clear_device_item_title_new));
        this.cleanupOldBackupRecord.setTitleText(getContext().getText(R$string.cloud_space_clear_records_item_title_new));
    }

    public void setSubTip(int i10, int i11) throws Resources.NotFoundException {
        setOldDeviceTip(i10);
        setOldRecordsTip(i11);
    }

    public void setTotalSize(long j10) {
        this.totalSize = j10;
    }
}
