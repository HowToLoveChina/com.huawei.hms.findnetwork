package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.hicloud.p088ui.activity.DiskAppDetailActivity;
import com.huawei.android.p073ds.R$string;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class DiskDeleteDialog extends AlertDialogC13154a {
    private Context mContext;

    public class BtnOnClickListner implements DialogInterface.OnClickListener {
        public BtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            ((DiskAppDetailActivity) DiskDeleteDialog.this.mContext).m20386W1(false);
            if (-1 == i10) {
                ((DiskAppDetailActivity) DiskDeleteDialog.this.mContext).m20385V1();
                DiskDeleteDialog.this.dismiss();
            } else if (-2 == i10) {
                DiskDeleteDialog.this.dismiss();
            }
        }
    }

    public DiskDeleteDialog(Context context, String str) {
        String string;
        super(context);
        this.mContext = context;
        BtnOnClickListner btnOnClickListner = new BtnOnClickListner();
        setButton(-2, context.getString(R$string.cloudbackup_btn_cancel), btnOnClickListner);
        if ("notepad".equals(str)) {
            setButton(-1, context.getString(R$string.cloudbackup_btn_delete_all), btnOnClickListner);
            string = this.mContext.getString(R$string.module_data_delete_alert_notepad);
        } else if ("gallerydelete".equals(str)) {
            setButton(-1, context.getString(R$string.clear_button), btnOnClickListner);
            string = this.mContext.getString(R$string.hicloud_gallery_recycle_clear_tips);
        } else {
            setButton(-1, context.getString(R$string.cloudbackup_btn_delete), btnOnClickListner);
            string = this.mContext.getString(R$string.module_data_delete_alert_new);
        }
        setMessage(string);
    }

    public void show(String str) {
        show();
    }
}
