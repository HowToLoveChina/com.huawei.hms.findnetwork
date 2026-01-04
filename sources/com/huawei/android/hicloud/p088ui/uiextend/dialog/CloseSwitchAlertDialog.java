package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$string;
import p015ak.C0209d;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class CloseSwitchAlertDialog extends AlertDialogC13154a {
    private Context mContext;
    private CloseSyncDialogCallback mMainActivity;
    private String moduleName;

    public class CloseOnClickListner implements DialogInterface.OnClickListener {
        public CloseOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                CloseSwitchAlertDialog.this.mMainActivity.closeSyncRetainData(CloseSwitchAlertDialog.this.moduleName, "local_close_switch", 0);
                CloseSwitchAlertDialog.this.dismiss();
            } else if (-3 == i10) {
                CloseSwitchAlertDialog.this.mMainActivity.closeSyncDeleteData(CloseSwitchAlertDialog.this.moduleName, "local_close_switch", 0);
                CloseSwitchAlertDialog.this.dismiss();
            } else if (-2 == i10) {
                CloseSwitchAlertDialog.this.cancel();
            }
        }
    }

    public class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        public DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            CloseSwitchAlertDialog.this.mMainActivity.closeSyncCancel(CloseSwitchAlertDialog.this.moduleName);
        }
    }

    public CloseSwitchAlertDialog(Context context, CloseSyncDialogCallback closeSyncDialogCallback) {
        super(context);
        this.mMainActivity = closeSyncDialogCallback;
        this.mContext = context;
        setOnCancelListener(new DialogOnCancelListener());
        CloseOnClickListner closeOnClickListner = new CloseOnClickListner();
        setButton(-1, this.mContext.getString(R$string.retain_data), closeOnClickListner);
        setButton(-3, this.mContext.getString(R$string.delete_data), closeOnClickListner);
        setButton(-2, this.mContext.getString(R$string.cloudbackup_btn_cancel), closeOnClickListner);
    }

    public void show(String str) {
        String string;
        this.moduleName = str;
        str.hashCode();
        switch (str) {
            case "addressbook":
                Context context = this.mContext;
                string = context.getString(R$string.close_switch_title_new, context.getString(R$string.contact));
                break;
            case "calendar":
                Context context2 = this.mContext;
                string = context2.getString(R$string.close_switch_title_new, context2.getString(R$string.calendar_sync_item));
                break;
            case "wlan":
                string = this.mContext.getString(R$string.close_switch_title_new, C0209d.m1262h2() ? this.mContext.getResources().getString(R$string.wlan_sync) : this.mContext.getResources().getString(R$string.wifi_sync));
                break;
            case "browser":
                Context context3 = this.mContext;
                string = context3.getString(R$string.close_switch_title_new, context3.getString(R$string.browser));
                break;
            case "notepad":
                Context context4 = this.mContext;
                string = context4.getString(R$string.close_switch_title_new, context4.getString(R$string.cloudbackup_back_item_notepad));
                break;
            default:
                string = "";
                break;
        }
        setMessage(string);
        show();
        getButton(-3).setTextColor(this.mContext.getColor(R$color.enui50_red_color));
    }
}
