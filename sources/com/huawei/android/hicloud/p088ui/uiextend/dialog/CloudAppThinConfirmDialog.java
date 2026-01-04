package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupAppThinActivity;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.ThinAppStatus;
import java.util.ArrayList;
import java.util.Iterator;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class CloudAppThinConfirmDialog extends AlertDialogC13154a implements DialogInterface.OnClickListener {
    Context mContext;

    public CloudAppThinConfirmDialog(Context context) {
        super(context);
        this.mContext = context;
        setButton(-1, context.getString(R$string.cloudbackup_btn_ok), this);
        setButton(-2, context.getString(R$string.cloudbackup_btn_cancel), this);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        if (i10 == -1) {
            ((CloudBackupAppThinActivity) this.mContext).m19230U1();
        }
    }

    public void show(ArrayList<ThinAppStatus> arrayList) {
        Resources resources = this.mContext.getResources();
        if (resources == null) {
            return;
        }
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<ThinAppStatus> it = arrayList.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                if (it.next().getAction() == 0) {
                    i10++;
                }
            }
            setMessage(resources.getQuantityString(R$plurals.app_dialog_tip, i10, Integer.valueOf(i10)));
        }
        show();
    }
}
