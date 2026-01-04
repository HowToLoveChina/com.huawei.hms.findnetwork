package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.uikit.hwtextview.widget.HwTextView;
import p015ak.C0209d;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackupThirdAppOpenNotEnoughDialog extends AlertDialogC13154a implements View.OnClickListener {
    private TextView backupCoditionTip;
    private TextView cancel;
    private Context mContext;
    private ProgressBar mLoadingView;
    private TextView mTitleTv;
    private HwTextView managerSpace;
    private NotEnoughDialogClickCallback notEnoughDialogClickCallback;
    private AutoSizeButton upgradeBtn;

    public interface NotEnoughDialogClickCallback {
        void onCancel();

        void onJumpManagerSpacePage();

        void onJumpUpgradeCloudSpace();
    }

    public BackupThirdAppOpenNotEnoughDialog(Context context, NotEnoughDialogClickCallback notEnoughDialogClickCallback) {
        super(context);
        this.mContext = context;
        this.notEnoughDialogClickCallback = notEnoughDialogClickCallback;
        initView(context);
    }

    private void initView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.backup_third_app_open_not_enough_dialog, (ViewGroup) null);
        this.backupCoditionTip = (TextView) C12809f.m76831d(viewInflate, R$id.tv_backup_condition);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76831d(viewInflate, R$id.upgrade_space_entrance);
        this.upgradeBtn = autoSizeButton;
        autoSizeButton.setOnClickListener(this);
        HwTextView hwTextView = (HwTextView) C12809f.m76831d(viewInflate, R$id.manage_space_entrance);
        this.managerSpace = hwTextView;
        hwTextView.setOnClickListener(this);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.cancel);
        this.cancel = textView;
        textView.setOnClickListener(this);
        this.mLoadingView = (ProgressBar) C12809f.m76831d(viewInflate, R$id.space_entrance_loading_bar);
        this.mTitleTv = (TextView) C12809f.m76831d(viewInflate, R$id.dialog_title);
        setCanceledOnTouchOutside(false);
        setView(viewInflate);
        setCancelable(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.upgrade_space_entrance) {
            NotEnoughDialogClickCallback notEnoughDialogClickCallback = this.notEnoughDialogClickCallback;
            if (notEnoughDialogClickCallback != null) {
                notEnoughDialogClickCallback.onJumpUpgradeCloudSpace();
                return;
            }
            return;
        }
        if (id2 == R$id.manage_space_entrance) {
            NotEnoughDialogClickCallback notEnoughDialogClickCallback2 = this.notEnoughDialogClickCallback;
            if (notEnoughDialogClickCallback2 != null) {
                notEnoughDialogClickCallback2.onJumpManagerSpacePage();
                return;
            }
            return;
        }
        if (id2 == R$id.cancel) {
            NotEnoughDialogClickCallback notEnoughDialogClickCallback3 = this.notEnoughDialogClickCallback;
            if (notEnoughDialogClickCallback3 != null) {
                notEnoughDialogClickCallback3.onCancel();
            }
            dismiss();
        }
    }

    public void setTipContent(String str) {
        if (TextUtils.equals(this.mContext.getResources().getString(R$string.app_data_all), str)) {
            this.backupCoditionTip.setText(this.mContext.getResources().getString(R$string.backup_check_no_enough_dialog_title_for_all));
        } else {
            this.backupCoditionTip.setText(this.mContext.getResources().getString(R$string.backup_option_no_enough_space_tip, str));
        }
    }

    public void setTitleTips(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mTitleTv.setVisibility(0);
        this.mTitleTv.setText(str);
    }

    public void showOrHideLoadingView(boolean z10) {
        ProgressBar progressBar = this.mLoadingView;
        if (progressBar != null) {
            progressBar.setVisibility(z10 ? 0 : 8);
        }
    }
}
