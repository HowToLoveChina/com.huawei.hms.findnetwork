package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import p514o9.C11839m;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class SpaceShareUpgradePackageDialog extends AlertDialogC13154a {
    private static final String TAG = "SpaceShareUpgradePackageDialog";
    private SpaceShareUpgradeCallback mActivity;

    public class BtnOnClickListner implements DialogInterface.OnClickListener {
        public BtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (SpaceShareUpgradePackageDialog.this.mActivity == null) {
                C11839m.m70687e(SpaceShareUpgradePackageDialog.TAG, "mActivity is null");
            } else if (-1 == i10) {
                SpaceShareUpgradePackageDialog.this.mActivity.onConfirmedUpgrade();
            } else if (-2 == i10) {
                SpaceShareUpgradePackageDialog.this.mActivity.onCanceledUpgrade();
            }
        }
    }

    public SpaceShareUpgradePackageDialog(Context context, SpaceShareUpgradeCallback spaceShareUpgradeCallback, String str, String str2) {
        super(context);
        this.mActivity = spaceShareUpgradeCallback;
        BtnOnClickListner btnOnClickListner = new BtnOnClickListner();
        setButton(-1, str, btnOnClickListner);
        setButton(-2, str2, btnOnClickListner);
    }

    public void showDialog(String str) {
        setMessage(str);
        show();
    }
}
