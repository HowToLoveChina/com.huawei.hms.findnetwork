package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.sync.R$string;
import java.util.LinkedHashMap;
import p015ak.C0212e0;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import sk.AlertDialogC12804a;

/* loaded from: classes3.dex */
public class SpaceSwitchOpenTipsDialog extends AlertDialogC12804a {
    private static final String TAG = "SpaceSwitchOpenTipsDialog";
    private String appName;
    private DialogClickCallback clickCallback;
    private boolean isAll;
    private Context mContext;

    public interface DialogClickCallback {
        void onSpaceRunningOutCancel();

        void onSpaceRunningOutOpen();
    }

    public SpaceSwitchOpenTipsDialog(Activity activity, String str, DialogClickCallback dialogClickCallback) {
        super(activity);
        this.mContext = activity;
        this.appName = str;
        this.clickCallback = dialogClickCallback;
        setButton(-1, activity.getString(R$string.cloudbackup_btn_ok), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.u0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f19254a.lambda$new$0(dialogInterface, i10);
            }
        });
        setButton(-2, this.mContext.getString(R$string.cloudbackup_btn_cancel), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.v0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f19256a.lambda$new$1(dialogInterface, i10);
            }
        });
        setCancelable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(DialogInterface dialogInterface, int i10) {
        this.clickCallback.onSpaceRunningOutOpen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(DialogInterface dialogInterface, int i10) {
        this.clickCallback.onSpaceRunningOutCancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(DialogInterface dialogInterface, int i10) {
        this.clickCallback.onSpaceRunningOutOpen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(DialogInterface dialogInterface, int i10) {
        this.clickCallback.onSpaceRunningOutCancel();
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.isAll) {
            setMessage(this.mContext.getString(R$string.space_all_switch_open_message));
        } else {
            setMessage(this.mContext.getString(R$string.space_switch_open_message, this.appName));
        }
        super.show();
        int iM1357g = C0212e0.m1357g(getContext(), "switch_suggest_dialog_sp", "dialog_switch_open_tips_num", 0) + 1;
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("show_num", Integer.valueOf(iM1357g));
        C0212e0.m1368r(getContext(), "switch_suggest_dialog_sp", "dialog_switch_open_tips_num", iM1357g);
        C13225d.m79490f1().m79591l0("action_code_backup_switch_open_tips_show", linkedHashMapM79499C);
        UBAAnalyze.m29954O("PVC", "action_code_backup_switch_open_tips_show", "1", "17");
    }

    public SpaceSwitchOpenTipsDialog(Activity activity, boolean z10, DialogClickCallback dialogClickCallback) {
        super(activity);
        this.mContext = activity;
        this.clickCallback = dialogClickCallback;
        this.isAll = z10;
        setButton(-1, activity.getString(R$string.cloudbackup_btn_ok), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.w0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f19258a.lambda$new$2(dialogInterface, i10);
            }
        });
        setButton(-2, this.mContext.getString(R$string.cloudbackup_btn_cancel), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.x0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f19259a.lambda$new$3(dialogInterface, i10);
            }
        });
        setCancelable(false);
    }
}
