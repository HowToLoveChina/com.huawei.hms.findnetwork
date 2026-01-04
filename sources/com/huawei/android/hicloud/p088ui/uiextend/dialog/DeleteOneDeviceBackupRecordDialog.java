package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class DeleteOneDeviceBackupRecordDialog extends AlertDialogC13154a {
    private ClickCallback clickCallback;
    private CheckBox closeBackupSwitch;
    private TextView dialogTips;
    private Context mContext;

    public class BtnOnClickListner implements DialogInterface.OnClickListener {
        public BtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (DeleteOneDeviceBackupRecordDialog.this.clickCallback == null) {
                return;
            }
            if (-1 == i10) {
                DeleteOneDeviceBackupRecordDialog.this.clickCallback.onDeleteConfirmed();
            } else {
                DeleteOneDeviceBackupRecordDialog.this.clickCallback.onCancelDelete();
            }
            DeleteOneDeviceBackupRecordDialog.this.dismiss();
        }
    }

    public interface ClickCallback {
        void onCancelDelete();

        void onDeleteConfirmed();
    }

    public DeleteOneDeviceBackupRecordDialog(Context context, ClickCallback clickCallback) {
        super(context);
        this.clickCallback = clickCallback;
        this.mContext = context;
        initView();
    }

    private void initView() {
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R$layout.dialog_delete_backup_record, (ViewGroup) null);
        this.dialogTips = (TextView) C12809f.m76831d(viewInflate, R$id.dialog_tips);
        CheckBox checkBox = (CheckBox) C12809f.m76831d(viewInflate, R$id.checkbox_close_switch);
        this.closeBackupSwitch = checkBox;
        checkBox.setChecked(true);
        setCanceledOnTouchOutside(false);
        setView(viewInflate);
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.i0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                return this.f19224a.lambda$initView$0(dialogInterface, i10, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initView$0(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return false;
        }
        this.clickCallback.onCancelDelete();
        dialogInterface.dismiss();
        return false;
    }

    public void show(String str, boolean z10) {
        setTitle(this.mContext.getString(z10 ? R$string.delete_backup_and_close_multiple_choice : R$string.delete_backup));
        BtnOnClickListner btnOnClickListner = new BtnOnClickListner();
        setButton(-1, this.mContext.getString(z10 ? R$string.backup_delete_and_close : R$string.confirm_delete_backup), btnOnClickListner);
        setButton(-2, this.mContext.getString(R$string.cloudbackup_btn_cancel), btnOnClickListner);
        String string = this.mContext.getString(z10 ? R$string.delete_and_close_backup_message : R$string.delete_backup_message, str);
        TextView textView = this.dialogTips;
        if (textView != null) {
            textView.setText(string);
        }
        this.closeBackupSwitch.setVisibility(8);
        show();
        getButton(-1).setTextColor(this.mContext.getColor(R$color.expansion_service_prompt_text_color));
    }

    public void showBackupDeleteAndClose(boolean z10) {
        setTitle(this.mContext.getString(z10 ? R$string.alert : R$string.manage_space_is_delete_record));
        BtnOnClickListner btnOnClickListner = new BtnOnClickListner();
        setButton(-1, this.mContext.getString(z10 ? R$string.permanently_deleted : R$string.backup_delete_and_close), btnOnClickListner);
        setButton(-2, this.mContext.getString(R$string.cloudbackup_btn_cancel), btnOnClickListner);
        String string = this.mContext.getString(z10 ? R$string.hints_delete_the_backup_content : R$string.delete_the_backup_content);
        TextView textView = this.dialogTips;
        if (textView != null) {
            textView.setText(string);
        }
        this.closeBackupSwitch.setVisibility(8);
        show();
        getButton(-1).setTextColor(this.mContext.getColor(R$color.expansion_service_prompt_text_color));
    }

    public void showBasicDeleteAndClose(String str) {
        setTitle(this.mContext.getString(R$string.backup_delete_and_close_basic));
        BtnOnClickListner btnOnClickListner = new BtnOnClickListner();
        setButton(-1, this.mContext.getString(R$string.backup_delete_and_close), btnOnClickListner);
        setButton(-2, this.mContext.getString(R$string.cloudbackup_btn_cancel), btnOnClickListner);
        String string = this.mContext.getString(R$string.delete_and_close_basic_backup_message, str);
        TextView textView = this.dialogTips;
        if (textView != null) {
            textView.setText(string);
        }
        this.closeBackupSwitch.setVisibility(8);
        show();
        getButton(-1).setTextColor(this.mContext.getColor(R$color.expansion_service_prompt_text_color));
    }
}
