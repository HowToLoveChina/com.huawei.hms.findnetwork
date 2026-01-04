package com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudspace.bean.UserCloudSpaceUseInfo;
import com.huawei.android.hicloud.task.simple.C3040h2;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.TerminationRetentionData;
import com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface;
import java.lang.ref.WeakReference;
import p054cj.C1442a;
import p292fn.C9733f;
import p450le.C11273b;
import p616rk.C12515a;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CancelAutoRenewalConfirmDialog extends AlertDialogC13154a {
    private static final long DEFAULT_USE_SPACE = 5368709120L;
    private static final String TAG = "CancelAutoRenewalConfirmDialog";
    private TextView cancelConfirmTipsText1;
    private final Context context;
    private final QueryUseInfoHandler handler;
    private View llConfirmTipOne;
    private View llConfirmTipTwo;
    private final WelfarePickAndCancelRenewalInterface mCancelAutoRenewalInterface;
    private C3040h2 queryUserCloudInfoTask;
    private RetentionDialog retentionDialog;
    private TerminationRetentionData terminationRetentionData;

    public class ClickListener implements DialogInterface.OnClickListener {
        public ClickListener() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (CancelAutoRenewalConfirmDialog.this.terminationRetentionData == null) {
                C1442a.m8289e(CancelAutoRenewalConfirmDialog.TAG, "onClick, terminationRetentionData is null.");
                CancelAutoRenewalConfirmDialog.this.dismiss();
                return;
            }
            if (i10 == -1) {
                CancelAutoRenewalConfirmDialog.this.dismiss();
                if (CancelAutoRenewalConfirmDialog.this.terminationRetentionData.isFromIAP() && CancelAutoRenewalConfirmDialog.this.mCancelAutoRenewalInterface != null) {
                    CancelAutoRenewalConfirmDialog.this.mCancelAutoRenewalInterface.retentionSuccessIAP();
                }
                if (CancelAutoRenewalConfirmDialog.this.mCancelAutoRenewalInterface != null) {
                    CancelAutoRenewalConfirmDialog.this.mCancelAutoRenewalInterface.reportCancelAutoRenewalResultFailed("cancel_auto_renewal_result_confirm_dialog_negative");
                    return;
                }
                return;
            }
            if (i10 == -2) {
                if (C9733f.m60705z().m60763v("businessTerminationRetentionPopup") != 1) {
                    if (CancelAutoRenewalConfirmDialog.this.mCancelAutoRenewalInterface != null) {
                        C1442a.m8290i(CancelAutoRenewalConfirmDialog.TAG, "onClick, switch close, check password.");
                        CancelAutoRenewalConfirmDialog.this.mCancelAutoRenewalInterface.checkConfirmCancelPassword();
                    } else {
                        C1442a.m8289e(CancelAutoRenewalConfirmDialog.TAG, "onClick, welfarePickInterface is null.");
                    }
                } else if (!C11273b.m67652g(CancelAutoRenewalConfirmDialog.this.terminationRetentionData.getUserPackage())) {
                    if (CancelAutoRenewalConfirmDialog.this.terminationRetentionData.isFromIAP() ? C11273b.m67653h(CancelAutoRenewalConfirmDialog.this.terminationRetentionData) : C11273b.m67654i(CancelAutoRenewalConfirmDialog.this.terminationRetentionData.getGetClientUIConfigResp(), CancelAutoRenewalConfirmDialog.this.terminationRetentionData.getUserPackage())) {
                        C1442a.m8289e(CancelAutoRenewalConfirmDialog.TAG, "onClick, retention text is empty.");
                        if (CancelAutoRenewalConfirmDialog.this.mCancelAutoRenewalInterface != null) {
                            CancelAutoRenewalConfirmDialog.this.mCancelAutoRenewalInterface.checkConfirmCancelPassword();
                        } else {
                            C1442a.m8289e(CancelAutoRenewalConfirmDialog.TAG, "onClick, switch open, welfarePickInterface is null.");
                        }
                    } else {
                        CancelAutoRenewalConfirmDialog.this.showRetentionDialog();
                    }
                } else if (CancelAutoRenewalConfirmDialog.this.mCancelAutoRenewalInterface != null) {
                    CancelAutoRenewalConfirmDialog.this.mCancelAutoRenewalInterface.checkConfirmCancelPassword();
                } else {
                    C1442a.m8289e(CancelAutoRenewalConfirmDialog.TAG, "onClick, switch open, not multiple renew, welfarePickInterface is null.");
                }
                if (CancelAutoRenewalConfirmDialog.this.mCancelAutoRenewalInterface != null) {
                    CancelAutoRenewalConfirmDialog.this.mCancelAutoRenewalInterface.reportButtonPositiveClicked();
                }
                CancelAutoRenewalConfirmDialog.this.dismiss();
            }
        }
    }

    public static class QueryUseInfoHandler extends Handler {
        protected static final int MSG_CANCEL_TASK = -1;
        protected static final int TIME_OUT = 1000;
        private final WeakReference<CancelAutoRenewalConfirmDialog> dialogReference;

        public QueryUseInfoHandler(CancelAutoRenewalConfirmDialog cancelAutoRenewalConfirmDialog) {
            this.dialogReference = new WeakReference<>(cancelAutoRenewalConfirmDialog);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            CancelAutoRenewalConfirmDialog cancelAutoRenewalConfirmDialog = this.dialogReference.get();
            if (cancelAutoRenewalConfirmDialog != null) {
                int i10 = message.what;
                if (i10 == -1) {
                    cancelAutoRenewalConfirmDialog.cancelTask();
                    return;
                }
                if (i10 != 7057) {
                    return;
                }
                removeMessages(-1);
                Object obj = message.obj;
                if (obj instanceof UserCloudSpaceUseInfo) {
                    cancelAutoRenewalConfirmDialog.refreshTips((UserCloudSpaceUseInfo) obj);
                }
            }
        }
    }

    public CancelAutoRenewalConfirmDialog(Context context, WelfarePickAndCancelRenewalInterface welfarePickAndCancelRenewalInterface, TerminationRetentionData terminationRetentionData) {
        super(context);
        this.context = context;
        this.mCancelAutoRenewalInterface = welfarePickAndCancelRenewalInterface;
        this.terminationRetentionData = terminationRetentionData;
        this.handler = new QueryUseInfoHandler(this);
        initView(context);
    }

    private void initView(Context context) {
        if (context == null) {
            C1442a.m8290i(TAG, "context is null, initView Failed");
            return;
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.cancel_auto_renewal_confirm_dialog_layout, (ViewGroup) null);
        this.llConfirmTipOne = C12809f.m76831d(viewInflate, R$id.ll_confirm_tip_one);
        this.llConfirmTipTwo = C12809f.m76831d(viewInflate, R$id.ll_confirm_tip_two);
        this.cancelConfirmTipsText1 = (TextView) C12809f.m76831d(viewInflate, R$id.cancel_confirm_tips1);
        ClickListener clickListener = new ClickListener();
        setTitle(R$string.cloudpay_cancel_continuous_monthly_new);
        setView(viewInflate);
        setButton(-1, context.getString(R$string.cloudpay_exit_cancel_continuous_monthly_second), clickListener);
        setButton(-2, context.getString(R$string.cloudpay_conform_cancel_continuous_monthly_new), clickListener);
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.huawei.android.hicloud.ui.uiextend.cloudpay.dialog.CancelAutoRenewalConfirmDialog.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                if (i10 != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                if (CancelAutoRenewalConfirmDialog.this.terminationRetentionData == null) {
                    C1442a.m8289e(CancelAutoRenewalConfirmDialog.TAG, "initView, terminationRetentionData is null.");
                    CancelAutoRenewalConfirmDialog.this.dismiss();
                    return false;
                }
                if (CancelAutoRenewalConfirmDialog.this.mCancelAutoRenewalInterface == null) {
                    C1442a.m8289e(CancelAutoRenewalConfirmDialog.TAG, "initView, mCancelAutoRenewalInterface is null.");
                    CancelAutoRenewalConfirmDialog.this.dismiss();
                    return false;
                }
                CancelAutoRenewalConfirmDialog.this.mCancelAutoRenewalInterface.backPressEvent("CANCENL_RENEW_DIALOG_PRESS_BACK");
                if (!CancelAutoRenewalConfirmDialog.this.terminationRetentionData.isFromIAP()) {
                    CancelAutoRenewalConfirmDialog.this.dismiss();
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRetentionDialog() {
        RetentionDialog retentionDialog = new RetentionDialog(this.context, false, this.mCancelAutoRenewalInterface, this.terminationRetentionData);
        this.retentionDialog = retentionDialog;
        retentionDialog.setCanceledOnTouchOutside(false);
        this.retentionDialog.show();
    }

    public void cancelTask() {
        C3040h2 c3040h2 = this.queryUserCloudInfoTask;
        if (c3040h2 != null) {
            c3040h2.cancel();
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        cancelTask();
        super.dismiss();
    }

    public void refreshTips(UserCloudSpaceUseInfo userCloudSpaceUseInfo) {
        if (!isShowing() || userCloudSpaceUseInfo == null || this.context == null) {
            C1442a.m8290i(TAG, "tipOne and tipTwo is GONE,because dialog is not showing or useInfo is null");
            return;
        }
        long cloudUsage = userCloudSpaceUseInfo.getCloudUsage();
        if (cloudUsage > DEFAULT_USE_SPACE) {
            this.llConfirmTipTwo.setVisibility(0);
        } else {
            C1442a.m8290i(TAG, "tipTwo is GONE,because useSpace is " + cloudUsage);
        }
        if (cloudUsage > 0) {
            int imageCount = userCloudSpaceUseInfo.getImageCount();
            int videoCount = userCloudSpaceUseInfo.getVideoCount();
            String string = this.context.getString(R$string.cloud_space_cancel_auto_renewal_space_tip_one, userCloudSpaceUseInfo.getCloudUsageWithUnit());
            String imageCountWithUnit = userCloudSpaceUseInfo.getImageCountWithUnit(this.context, R$plurals.cloud_space_cancel_auto_renewal_photo_tip_one);
            String videoCountWithUnit = userCloudSpaceUseInfo.getVideoCountWithUnit(this.context, R$plurals.cloud_space_cancel_auto_renewal_video_tip_one);
            C1442a.m8290i(TAG, "tipOne detail is GONE,because imageCount is  " + imageCount + " and videoCount is " + videoCount);
            this.cancelConfirmTipsText1.setText((imageCount <= 0 || videoCount <= 0) ? (TextUtils.isEmpty(imageCountWithUnit) || imageCount <= 0 || videoCount != 0) ? (imageCount != 0 || TextUtils.isEmpty(videoCountWithUnit) || videoCount <= 0) ? this.context.getString(R$string.cloud_space_cancel_auto_renewal_no_media_tip_one, string) : this.context.getString(R$string.cloud_space_cancel_auto_renewal_photo_tip_one_update, string, videoCountWithUnit) : this.context.getString(R$string.cloud_space_cancel_auto_renewal_photo_tip_one_update, string, imageCountWithUnit) : this.context.getString(R$string.cloud_space_cancel_auto_renewal_two_media_tip_one, string, imageCountWithUnit, videoCountWithUnit));
            this.llConfirmTipOne.setVisibility(0);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        View view = this.llConfirmTipOne;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.llConfirmTipTwo;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        C3040h2 c3040h2 = this.queryUserCloudInfoTask;
        if (c3040h2 != null) {
            c3040h2.cancel();
        }
        this.handler.sendEmptyMessageDelayed(-1, 1000L);
        this.queryUserCloudInfoTask = new C3040h2(this.handler);
        C12515a.m75110o().m75175e(this.queryUserCloudInfoTask, false);
        super.show();
    }
}
