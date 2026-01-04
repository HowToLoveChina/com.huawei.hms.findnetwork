package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.p088ui.activity.BackupOptionsActivity;
import com.huawei.android.hicloud.p088ui.activity.BackupOptionsDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.BackupOptionsRefurbishActivity;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import p015ak.C0209d;
import p514o9.C11829c;
import p514o9.C11839m;
import p676ud.AlertDialogC13154a;
import p847zk.C14329v;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloseOptionStatusDialog extends AlertDialogC13154a {
    private static final int DELETE_FAILED_FOR_NETWORT_ERROR = -2;
    private static final int DELETE_FAILED_FOR_NOT_CHECKED = -1;
    private static final boolean DELETE_TIP_CHECK_DEFAULT_STATUS = true;
    private static final String TAG = "CloseOptionStatusDialog";
    private String appId;
    private CheckBox cbDeleteTip;
    private BackupOptionItem clickItem;
    private boolean isChecked;
    private Activity mActivity;
    private String showingModule;
    private TextView tvAppModuleTip;

    public class BtnOnClickListener implements DialogInterface.OnClickListener {
        public BtnOnClickListener() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                CloseOptionStatusDialog.this.positiveDialog();
            } else {
                CloseOptionStatusDialog.this.cancelDialog();
            }
            dialogInterface.dismiss();
        }
    }

    public CloseOptionStatusDialog(Activity activity) {
        super(activity);
        this.mActivity = activity;
        BtnOnClickListener btnOnClickListener = new BtnOnClickListener();
        initView();
        setButton(-1, this.mActivity.getString(R$string.btn_close_backup), btnOnClickListener);
        setButton(-2, this.mActivity.getString(R$string.cloudbackup_btn_cancel), btnOnClickListener);
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.w
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                return this.f19257a.lambda$new$0(dialogInterface, i10, keyEvent);
            }
        });
    }

    public void cancelDialog() {
        Activity activity = this.mActivity;
        if (activity instanceof BackupOptionsActivity) {
            ((BackupOptionsActivity) activity).m18957Q2(this.appId, this.isChecked, this.clickItem);
        } else if (activity instanceof BackupOptionsDetailActivity) {
            ((BackupOptionsDetailActivity) activity).m19077q2(this.appId, this.isChecked);
        } else if (activity instanceof BackupOptionsRefurbishActivity) {
            ((BackupOptionsRefurbishActivity) activity).m19151k2(this.appId, this.isChecked);
        }
        this.showingModule = null;
    }

    private void initView() {
        View viewM76832e = C12809f.m76832e(LayoutInflater.from(this.mActivity), R$layout.dialog_backup_option);
        this.tvAppModuleTip = (TextView) C12809f.m76831d(viewM76832e, R$id.tv_app_module_tip);
        this.cbDeleteTip = (CheckBox) C12809f.m76831d(viewM76832e, R$id.cb_delete_tip);
        setCanceledOnTouchOutside(false);
        setView(viewM76832e);
    }

    public /* synthetic */ boolean lambda$new$0(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return false;
        }
        cancelDialog();
        dialogInterface.dismiss();
        return false;
    }

    public static /* synthetic */ void lambda$positiveDialog$1(Consumer consumer) {
        consumer.accept(-2);
    }

    public static /* synthetic */ void lambda$positiveDialog$2(Consumer consumer) {
        consumer.accept(-1);
    }

    public void positiveDialog() {
        Consumer<Integer> consumerM18970X3 = null;
        this.showingModule = null;
        boolean zIsChecked = this.cbDeleteTip.isChecked();
        Activity activity = this.mActivity;
        if (activity instanceof BackupOptionsActivity) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.appId);
            if (!this.isChecked) {
                List<BackupOptionItem> twinAppsList = this.clickItem.getTwinAppsList();
                if (!twinAppsList.isEmpty()) {
                    Iterator<BackupOptionItem> it = twinAppsList.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getAppId());
                    }
                }
            } else if (SplitAppUtil.isTwinApp(this.clickItem.getSplitApkType(), this.clickItem.getOriBackupAppName())) {
                arrayList.add(this.clickItem.getOriBackupAppName());
            }
            consumerM18970X3 = ((BackupOptionsActivity) this.mActivity).m18970X3(arrayList, this.isChecked, zIsChecked);
        } else if (activity instanceof BackupOptionsDetailActivity) {
            String str = this.appId;
            if (str == null) {
                ((BackupOptionsDetailActivity) activity).m19067M2(this.isChecked);
            } else {
                ((BackupOptionsDetailActivity) activity).m19068N2(str, this.isChecked, zIsChecked);
            }
        } else if (activity instanceof BackupOptionsRefurbishActivity) {
            ((BackupOptionsRefurbishActivity) activity).m19130N2(this.appId, this.isChecked);
        }
        C11839m.m70688i(TAG, "positiveDialog checked = " + zIsChecked);
        if (!zIsChecked) {
            Optional.ofNullable(consumerM18970X3).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.y
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    CloseOptionStatusDialog.lambda$positiveDialog$2((Consumer) obj);
                }
            });
            return;
        }
        if (!C0209d.m1333z1(this.mActivity)) {
            C11829c.m70612r1(this.mActivity);
            Optional.ofNullable(consumerM18970X3).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.x
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    CloseOptionStatusDialog.lambda$positiveDialog$1((Consumer) obj);
                }
            });
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.appId);
        List<BackupOptionItem> twinAppsList2 = this.clickItem.getTwinAppsList();
        if (!twinAppsList2.isEmpty()) {
            Iterator<BackupOptionItem> it2 = twinAppsList2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next().getAppId());
            }
        }
        C14329v.m85349e0().m85409U(arrayList2, consumerM18970X3);
    }

    public String getShowingModule() {
        return this.showingModule;
    }

    public void show(String str, String str2, boolean z10, boolean z11) {
        String string = this.mActivity.getString(R$string.backup_close_confirm_content, str);
        this.isChecked = z10;
        this.appId = str2;
        this.showingModule = str2;
        this.tvAppModuleTip.setText(string);
        if (z11) {
            this.cbDeleteTip.setText(this.mActivity.getString(R$string.backup_delete_tip, str));
            this.cbDeleteTip.setVisibility(0);
            this.cbDeleteTip.setChecked(true);
        } else {
            this.cbDeleteTip.setVisibility(8);
        }
        show();
    }

    public void showAllDialog(boolean z10, boolean z11) {
        this.tvAppModuleTip.setText(this.mActivity.getString(R$string.backup_close_confirm_content_all_data));
        this.isChecked = z10;
        this.appId = null;
        if (z11) {
            this.cbDeleteTip.setText(this.mActivity.getString(R$string.backup_delete_all_tip));
            this.cbDeleteTip.setVisibility(0);
            this.cbDeleteTip.setChecked(false);
        } else {
            this.cbDeleteTip.setVisibility(8);
        }
        show();
    }

    public void showHasTitleDialog(String str, String str2, String str3, String str4, boolean z10, BackupOptionItem backupOptionItem) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.tvAppModuleTip.getLayoutParams();
        Resources resources = this.mActivity.getResources();
        int i10 = R$dimen.cloud_space_24_dp;
        layoutParams.setMargins(resources.getDimensionPixelSize(i10), 0, this.mActivity.getResources().getDimensionPixelSize(i10), 0);
        this.clickItem = backupOptionItem;
        setTitle(str);
        this.isChecked = false;
        this.appId = str4;
        this.showingModule = str4;
        this.tvAppModuleTip.setText(str2);
        if (z10) {
            this.cbDeleteTip.setText(str3);
            this.cbDeleteTip.setVisibility(0);
            this.cbDeleteTip.setChecked(true);
        } else {
            this.cbDeleteTip.setVisibility(8);
        }
        super.show();
    }
}
