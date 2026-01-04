package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.p088ui.common.CutOutProgressDialog;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.CloseAndDeleteBasicDataDialog;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import java.util.Optional;
import java.util.function.Consumer;
import p015ak.C0209d;
import p422k9.C11019b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p676ud.AlertDialogC13154a;
import p847zk.C14315h;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloseAndDeleteBasicDataDialog extends AlertDialogC13154a {
    private static final String TAG = "CloseAndDeleteBasicDataDialog";
    private final Handler.Callback baseBackupItemCallBack;
    private Activity mActivity;
    private TextView mBackupSubtitleView;
    private final UnionSwitch mBaseItemSwitch;
    private CheckBox mCheckBoxView;
    private ClickCallBack mClickCallBack;
    private DeleteCallBack mDeleteCallBack;
    private int mDeleteFrom;
    private CutOutProgressDialog mDeletingDialog;

    public class BtnOnClickListener implements DialogInterface.OnClickListener {
        public BtnOnClickListener() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C11839m.m70688i(CloseAndDeleteBasicDataDialog.TAG, "BtnOnClickListener onClick: " + i10);
            if (-1 == i10) {
                CloseAndDeleteBasicDataDialog.this.mClickCallBack.closeBackupAfterConfirm(CloseAndDeleteBasicDataDialog.this.mCheckBoxView != null && CloseAndDeleteBasicDataDialog.this.mCheckBoxView.isChecked());
            } else {
                CloseAndDeleteBasicDataDialog.this.mClickCallBack.onCancelDelete();
            }
            CloseAndDeleteBasicDataDialog.this.dismiss();
        }
    }

    public interface ClickCallBack {
        void closeBackupAfterConfirm(boolean z10);

        void onCancelDelete();
    }

    public interface DeleteCallBack {
        void deleteBaseAppSuccess();
    }

    public CloseAndDeleteBasicDataDialog(Activity activity, int i10, UnionSwitch unionSwitch) {
        super(activity);
        this.mClickCallBack = new ClickCallBack() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.CloseAndDeleteBasicDataDialog.1
            @Override // com.huawei.android.hicloud.ui.uiextend.dialog.CloseAndDeleteBasicDataDialog.ClickCallBack
            public void closeBackupAfterConfirm(boolean z10) {
                CloseAndDeleteBasicDataDialog.this.closeBackupAfterConfirm(z10);
            }

            @Override // com.huawei.android.hicloud.ui.uiextend.dialog.CloseAndDeleteBasicDataDialog.ClickCallBack
            public void onCancelDelete() {
                CloseAndDeleteBasicDataDialog.this.onCancelDelete();
            }
        };
        this.baseBackupItemCallBack = new Handler.Callback() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.s
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f19247a.lambda$new$0(message);
            }
        };
        this.mDeleteFrom = i10;
        this.mActivity = activity;
        this.mBaseItemSwitch = unionSwitch;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeBackupAfterConfirm(boolean z10) {
        C11839m.m70688i(TAG, "closeBackupAfterConfirm: " + z10);
        if (CBAccess.inBackup()) {
            showToast(R$string.delete_lock_conflict_toast);
            Optional.ofNullable(this.mBaseItemSwitch).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.n
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((UnionSwitch) obj).setCheckedProgrammatically(true);
                }
            });
            return;
        }
        if (!z10) {
            C14315h.m85262p().m85271J(false);
            deleteBaseAppSuccess();
        } else if (C0209d.m1333z1(this.mActivity)) {
            CloudBackupService.getInstance().deleteAllBaseAppModule(this.mDeleteFrom);
            showDeletingDialog();
        } else {
            C11829c.m70612r1(this.mActivity);
            C11839m.m70688i(TAG, "close failed network not connect.");
            new Handler().postDelayed(new Runnable() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19240a.lambda$closeBackupAfterConfirm$5();
                }
            }, 300L);
        }
    }

    private void closeDeletingDialog() {
        CutOutProgressDialog cutOutProgressDialog = this.mDeletingDialog;
        if (cutOutProgressDialog != null) {
            cutOutProgressDialog.dismiss();
        }
    }

    private void deleteBaseAppSuccess() {
        C11839m.m70688i(TAG, "delete baseapp success: " + this.mDeleteFrom);
        CloudBackupReport.reportCloseSuccess(Boolean.TRUE, this.mActivity);
        closeDeletingDialog();
        Optional.ofNullable(this.mDeleteCallBack).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.r
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((CloseAndDeleteBasicDataDialog.DeleteCallBack) obj).deleteBaseAppSuccess();
            }
        });
    }

    private void initView() {
        CBCallBack.getInstance().registerCallback(this.baseBackupItemCallBack);
        View viewInflate = LayoutInflater.from(this.mActivity).inflate(R$layout.dialog_delete_backup_basic_data, (ViewGroup) null);
        this.mCheckBoxView = (CheckBox) C12809f.m76831d(viewInflate, R$id.checkbox_close_switch);
        this.mBackupSubtitleView = (TextView) C12809f.m76831d(viewInflate, R$id.dialog_tips);
        setCanceledOnTouchOutside(false);
        setView(viewInflate);
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.m
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                return this.f19234a.lambda$initView$1(dialogInterface, i10, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeBackupAfterConfirm$5() {
        Optional.ofNullable(this.mBaseItemSwitch).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.p
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((UnionSwitch) obj).setCheckedProgrammatically(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initView$1(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return false;
        }
        onCancelDelete();
        dialogInterface.dismiss();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(Message message) {
        if (message.what != 33045 || message.arg2 != this.mDeleteFrom) {
            return false;
        }
        C11839m.m70688i(TAG, "delete base app end: " + message.arg1);
        closeDeletingDialog();
        Integer numM66437p = C11019b.m66371t().m66437p(message.arg1);
        if (numM66437p != null) {
            if (numM66437p.intValue() == R$string.delete_lock_conflict_toast) {
                numM66437p = Integer.valueOf(R$string.delete_failed_toast);
            }
            showToast(numM66437p.intValue());
            onCancelDelete();
        } else {
            deleteBaseAppSuccess();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCancelDelete() {
        Optional.ofNullable(this.mBaseItemSwitch).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.q
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((UnionSwitch) obj).setCheckedProgrammatically(true);
            }
        });
        dismiss();
    }

    private void showDeletingDialog() {
        if (this.mDeletingDialog == null) {
            this.mDeletingDialog = new CutOutProgressDialog(this.mActivity);
        }
        this.mDeletingDialog.setMessage(this.mActivity.getString(R$string.backup_clean_loading_msg));
        this.mDeletingDialog.setCancelable(false);
        this.mDeletingDialog.show();
    }

    private void showToast(int i10) {
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        C11841o.m70707c(activity, i10, 0);
    }

    public void onDestroy() {
        dismiss();
        CBCallBack.getInstance().unregisterCallback(this.baseBackupItemCallBack);
        closeDeletingDialog();
    }

    public void setCallBack(DeleteCallBack deleteCallBack) {
        this.mDeleteCallBack = deleteCallBack;
    }

    public void setClickCallBack(ClickCallBack clickCallBack) {
        this.mClickCallBack = clickCallBack;
    }

    public void show(boolean z10) {
        CheckBox checkBox = this.mCheckBoxView;
        if (checkBox != null) {
            Activity activity = this.mActivity;
            checkBox.setText(activity.getString(R$string.backup_delete_tip, activity.getString(R$string.backup_basic_module)));
            this.mCheckBoxView.setChecked(!z10);
            this.mCheckBoxView.setVisibility(z10 ? 8 : 0);
        }
        TextView textView = this.mBackupSubtitleView;
        if (textView != null) {
            Activity activity2 = this.mActivity;
            textView.setText(activity2.getString(R$string.backup_close_confirm_content, activity2.getString(R$string.backup_basic_module)));
        }
        BtnOnClickListener btnOnClickListener = new BtnOnClickListener();
        setButton(-1, this.mActivity.getString(R$string.btn_close_backup), btnOnClickListener);
        setButton(-2, this.mActivity.getString(R$string.cloudbackup_btn_cancel), btnOnClickListener);
        super.show();
        getButton(-1).setTextColor(this.mActivity.getColor(R$color.expansion_service_prompt_text_color));
    }
}
