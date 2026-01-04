package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupNotificationTrebleBtnDialog;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.hicloud.notification.bean.BackupNotEnoughDisplayInfo;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.HiCloudNotificationManager;
import com.huawei.hicloud.notification.p106db.bean.NoticeContent;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import java.util.LinkedHashMap;
import je.C10798l;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p514o9.C11839m;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackupTrebleBtnAlertDialog extends BackupNotificationTrebleBtnDialog {
    private static final String TAG = "BackupTrebleBtnAlertDialog";
    private ImageView mIconImageView;
    private TextView titleTV;

    public BackupTrebleBtnAlertDialog(Context context) {
        super(context);
        initView();
    }

    private boolean setDialogMainText(TextView textView) {
        if (textView == null) {
            C11839m.m70687e(TAG, "setDialogMainText dialogTextFirst is null.");
            return false;
        }
        if (TextUtils.isEmpty(this.mainText)) {
            C11839m.m70687e(TAG, "setDialogMainText mainText is null.");
            return false;
        }
        if (this.mContext == null) {
            C11839m.m70687e(TAG, "setDialogMainText mContext is null.");
            return false;
        }
        long jM16190y = C2783d.m16190y();
        Resources resources = this.mContext.getResources();
        if (resources == null) {
            return true;
        }
        BackupNotEnoughDisplayInfo backupNotEnoughDisplayInfo = new BackupNotEnoughDisplayInfo();
        int i10 = (int) jM16190y;
        backupNotEnoughDisplayInfo.setUnBackupDays(resources.getQuantityString(R$plurals.cloud_backup_fail_days, i10, Integer.valueOf(i10)));
        if (this.backupNeedSpace <= 0) {
            this.backupNeedSpace = 0L;
        }
        if (this.notUsedSpace <= 0) {
            this.notUsedSpace = 0L;
        }
        Context context = this.mContext;
        long j10 = this.backupNeedSpace;
        long j11 = this.notUsedSpace;
        if (j10 < j11) {
            j10 = j11;
        }
        backupNotEnoughDisplayInfo.setBackupDataSize(C0223k.m1524g(context, j10));
        backupNotEnoughDisplayInfo.setRemainSpace(C0223k.m1524g(this.mContext, this.notUsedSpace));
        textView.setText(new HiCloudNotificationManager(this.mContext).replacePlaceForBackup(this.mainText, backupNotEnoughDisplayInfo));
        return true;
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupNotificationTrebleBtnDialog
    public void addExtraShowReportInfo(LinkedHashMap linkedHashMap) {
        linkedHashMap.put("is_new_dialog", Boolean.TRUE);
        linkedHashMap.put("recommend_space_needed", Long.valueOf(this.totalNeedSpace));
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupNotificationTrebleBtnDialog
    public void initView() {
        setOnCancelListener(new BackupNotificationTrebleBtnDialog.DialogOnCancelListener());
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R$layout.backup_not_enough_treble_new_dialog, (ViewGroup) null);
        this.view = viewInflate;
        this.mIconImageView = (ImageView) C12809f.m76831d(viewInflate, R$id.iv_backup_fail);
        this.titleTV = (TextView) C12809f.m76831d(this.view, R$id.space_not_enough_dialog_text_1);
        this.firstDescription = (TextView) C12809f.m76831d(this.view, R$id.space_not_enough_dialog_text_2);
        this.firstButton = (TextView) C12809f.m76831d(this.view, R$id.space_not_enough_treble_dialog_button_1);
        this.secondButton = (TextView) C12809f.m76831d(this.view, R$id.space_not_enough_treble_dialog_button_2);
        this.thirdButton = (TextView) C12809f.m76831d(this.view, R$id.space_not_enough_treble_dialog_button_3);
        this.viewDetailsArea = (RelativeLayout) C12809f.m76831d(this.view, R$id.view_details_area);
        this.noticeImage = (ImageView) C12809f.m76831d(this.view, R$id.view_details_image);
        this.noticeTextView = (TextView) C12809f.m76831d(this.view, R$id.view_details_text);
        this.firstButton.setOnClickListener(this);
        this.secondButton.setOnClickListener(this);
        this.thirdButton.setOnClickListener(this);
        float fM1195O = C0209d.m1195O(C0213f.m1377a());
        if (fM1195O >= 1.75f) {
            this.titleTV.setMaxLines(1);
        }
        if (fM1195O >= 3.2f) {
            this.firstDescription.setMaxLines(2);
        } else if (fM1195O >= 1.75f) {
            this.firstDescription.setMaxLines(3);
        }
        setView(this.view);
        if (C0209d.m1194N1(this.mContext)) {
            C10798l.m65720e(this.mIconImageView);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupNotificationTrebleBtnDialog
    public void prepareTitleAndMainText(NoticeContent noticeContent) {
        this.title = getStringWithDefault(noticeContent.getV4Title());
        this.mainText = getStringWithDefault(noticeContent.getV4MainText());
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupNotificationTrebleBtnDialog
    public void prepareTitleAndMainTextWithActivity(String str) {
        this.title = NoticeWithActivityUtil.getStrFromDBByResource(str, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_V4_POP_TITLE);
        this.mainText = NoticeWithActivityUtil.getStrFromDBByResource(str, NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_V4_MAIN_TEXT);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupNotificationTrebleBtnDialog
    public boolean setBackupInfoView() {
        TextView textView = this.titleTV;
        if (textView != null) {
            textView.setText(this.title);
        }
        if (this.titleTV == null) {
            C11839m.m70687e(TAG, "setBackupInfoView titleTV is null.");
            return false;
        }
        if (!TextUtils.isEmpty(this.title)) {
            return setDialogMainText(this.firstDescription);
        }
        C11839m.m70687e(TAG, "setBackupInfoView title is null.");
        return false;
    }

    public void startFrameAnimation() {
        ImageView imageView = this.mIconImageView;
        if (imageView != null) {
            C10798l.m65719d(imageView);
        }
    }

    public void stopFrameAnimation() {
        ImageView imageView = this.mIconImageView;
        if (imageView != null) {
            C10798l.m65721f(imageView);
        }
    }
}
