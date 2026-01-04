package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewGroup;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.NewHiSyncSettingActivity;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import p336he.C10157h;
import p514o9.C11839m;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class AddToDesktopDialog extends AlertDialogC13154a {
    private static final String TAG = "AddToDesktopDialog";
    private Context mContext;

    public class BtnOnClickListner implements DialogInterface.OnClickListener {
        public BtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            String str;
            if (-1 == i10) {
                if (AddToDesktopDialog.this.mContext == null) {
                    C11839m.m70687e(AddToDesktopDialog.TAG, "mContent is null, AddToDesktopDialog is unclickable ");
                    return;
                } else {
                    new C10157h().m63312a(AddToDesktopDialog.this.mContext, NewHiSyncSettingActivity.class);
                    str = "confirm";
                }
            } else if (-2 == i10) {
                AddToDesktopDialog.this.dismiss();
                str = "cancel";
            } else {
                str = "";
            }
            C2783d.m16082F0(str);
        }
    }

    public AddToDesktopDialog(Context context) {
        super(context);
        this.mContext = context;
        BtnOnClickListner btnOnClickListner = new BtnOnClickListner();
        setButton(-1, context.getString(R$string.add_to_desktop_button), btnOnClickListner);
        setButton(-2, context.getString(R$string.cloudbackup_btn_cancel), btnOnClickListner);
        setView(getLayoutInflater().inflate(R$layout.add_to_desktop_dialog, (ViewGroup) null));
    }
}
