package com.huawei.android.hicloud.p088ui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.sync.R$color;
import com.huawei.hicloud.sync.R$string;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class ClearMsgAlertDialog extends AlertDialogC13154a {

    /* renamed from: a */
    public Context f17866a;

    /* renamed from: com.huawei.android.hicloud.ui.dialog.ClearMsgAlertDialog$b */
    public static class DialogInterfaceOnClickListenerC3934b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3934b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -1) {
                NotifyLogger.m29915i("ClearMsgAlertDialog", "click confirm");
                MessageCenterManager.getInstance().clearAllMessages();
            } else if (i10 == -2) {
                NotifyLogger.m29915i("ClearMsgAlertDialog", "click cancel");
            }
            dialogInterface.dismiss();
        }
    }

    public ClearMsgAlertDialog(Context context) {
        super(context);
        this.f17866a = context;
        setMessage(context.getString(R$string.confirm_clear_message));
        setButton(-1, this.f17866a.getString(R$string.dialog_clear), new DialogInterfaceOnClickListenerC3934b());
        setButton(-2, this.f17866a.getString(R$string.dialog_cancel), new DialogInterfaceOnClickListenerC3934b());
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        getButton(-1).setTextColor(this.f17866a.getResources().getColor(R$color.enui50_red_color));
    }
}
