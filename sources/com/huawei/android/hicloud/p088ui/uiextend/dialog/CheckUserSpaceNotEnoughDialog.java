package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.huawei.android.hicloud.p088ui.activity.BackupNotificationActivity;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import p550pb.C12126b;
import p676ud.AlertDialogC13154a;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;

/* loaded from: classes3.dex */
public class CheckUserSpaceNotEnoughDialog extends AlertDialogC13154a {
    private Context mContext;
    private SpaceOnClickListner spaceOnClickListner;

    public class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        public DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            CheckUserSpaceNotEnoughDialog.this.dismiss();
            ((BackupNotificationActivity) CheckUserSpaceNotEnoughDialog.this.mContext).finish();
        }
    }

    public class SpaceOnClickListner implements DialogInterface.OnClickListener {
        public SpaceOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                Bundle bundle = new Bundle();
                C13230i.m79522d1(bundle, "4", "9");
                C12126b.m72707c("2", bundle);
                C13225d.m79490f1().m79585f0("mecloud_cloudspacedialog_notenough_upgrade", C13452e.m80781L().m80971t0());
                UBAAnalyze.m29954O("PVC", "mecloud_cloudspacedialog_notenough_upgrade", "4", "10");
                ((BackupNotificationActivity) CheckUserSpaceNotEnoughDialog.this.mContext).finish();
                return;
            }
            if (-2 == i10) {
                C13225d.m79490f1().m79585f0("mecloud_cloudspacedialog_notenough_later", C13452e.m80781L().m80971t0());
                UBAAnalyze.m29954O("PVC", "mecloud_cloudspacedialog_notenough_later", "4", "10");
                CheckUserSpaceNotEnoughDialog.this.dismiss();
                ((BackupNotificationActivity) CheckUserSpaceNotEnoughDialog.this.mContext).finish();
            }
        }
    }

    public CheckUserSpaceNotEnoughDialog(Context context) {
        super(context);
        this.spaceOnClickListner = new SpaceOnClickListner();
        this.mContext = context;
        initView();
    }

    public void initView() {
        setOnCancelListener(new DialogOnCancelListener());
    }

    public void show(int i10) {
        if (9 == i10) {
            setTitle(this.mContext.getString(R$string.space_not_enough_title));
            setMessage(this.mContext.getString(R$string.space_not_enough_message));
            setButton(-1, this.mContext.getString(R$string.upgrade_cloud_space), this.spaceOnClickListner);
            setButton(-2, this.mContext.getString(R$string.common_btn_close), this.spaceOnClickListner);
        }
        show();
    }
}
