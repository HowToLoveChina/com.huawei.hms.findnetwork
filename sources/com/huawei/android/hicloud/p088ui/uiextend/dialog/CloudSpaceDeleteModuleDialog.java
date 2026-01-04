package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import java.util.HashMap;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudSpaceDeleteModuleDialog extends AlertDialogC13154a {
    public static final int DIALOG_MULTIPLE_CHOICES = 1;
    public static final int DIALOG_SINGLE_CHOICE = 0;
    private String checkBoxText;
    private CheckBox checkboxCloseSwitch;
    private String currentAppId;
    private TextView dialogTips;
    private String dialogTipsText;
    private int dialogType;
    private boolean isBasicItem;
    private boolean isCloseBackup;
    private boolean isInWhiteList;
    private AlertDialogCallback mCallback;
    private Context mContext;
    private int position;

    public static class JsonTypeToken extends TypeToken<HashMap<String, Boolean>> {
        private JsonTypeToken() {
        }
    }

    public CloudSpaceDeleteModuleDialog(Context context, AlertDialogCallback alertDialogCallback, int i10, boolean z10, boolean z11) {
        super(context);
        this.isCloseBackup = z10;
        this.mCallback = alertDialogCallback;
        this.mContext = context;
        this.dialogType = i10;
        this.isInWhiteList = z11;
        initView();
    }

    private void initView() {
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R$layout.dialog_cloud_space_delete_module, (ViewGroup) null);
        this.dialogTips = (TextView) C12809f.m76831d(viewInflate, R$id.dialog_tips);
        CheckBox checkBox = (CheckBox) C12809f.m76831d(viewInflate, R$id.checkbox_close_switch);
        this.checkboxCloseSwitch = checkBox;
        checkBox.setVisibility(8);
        this.dialogTips.setText(getDialogTipsText());
        setCanceledOnTouchOutside(false);
        setView(viewInflate);
        setButton(-1, this.mContext.getString((!this.isCloseBackup || this.isInWhiteList) ? R$string.confirm_delete_backup : R$string.backup_delete_and_close), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.CloudSpaceDeleteModuleDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                CloudSpaceDeleteModuleDialog.this.mCallback.onClickPositive(CloudSpaceDeleteModuleDialog.this.currentAppId, CloudSpaceDeleteModuleDialog.this.isBasicItem);
            }
        });
        setButton(-2, this.mContext.getString(R$string.cloudbackup_btn_cancel), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.CloudSpaceDeleteModuleDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                CloudSpaceDeleteModuleDialog.this.mCallback.onClickNegative(CloudSpaceDeleteModuleDialog.this.position);
            }
        });
    }

    public String getCheckBoxText() {
        return this.checkBoxText;
    }

    public String getDialogTipsText() {
        return this.dialogTipsText;
    }

    public int getDialogType() {
        return this.dialogType;
    }

    public int getPosition() {
        return this.position;
    }

    public void setBasicItem(boolean z10) {
        this.isBasicItem = z10;
    }

    public void setCheckBoxText(String str) {
        this.checkBoxText = str;
        this.checkboxCloseSwitch.setText(str);
    }

    public void setCurrentAppId(String str) {
        this.currentAppId = str;
    }

    public void setDialogTipsText(String str) {
        this.dialogTipsText = str;
        this.dialogTips.setText(str);
    }

    public void setDialogType(int i10) {
        this.dialogType = i10;
    }

    public void setPosition(int i10) {
        this.position = i10;
    }

    public void show(String str, String str2) {
        super.show();
        setDialogTipsText(str);
        setCheckBoxText(str2);
        getButton(-1).setTextColor(this.mContext.getColor(R$color.expansion_service_prompt_text_color));
    }

    public void showHasTitleDialog(String str, String str2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dialogTips.getLayoutParams();
        Resources resources = this.mContext.getResources();
        int i10 = R$dimen.cloud_space_24_dp;
        layoutParams.setMargins(resources.getDimensionPixelSize(i10), 0, this.mContext.getResources().getDimensionPixelSize(i10), 0);
        setTitle(str);
        setDialogTipsText(str2);
        super.show();
        getButton(-1).setTextColor(this.mContext.getColor(R$color.expansion_service_prompt_text_color));
    }
}
