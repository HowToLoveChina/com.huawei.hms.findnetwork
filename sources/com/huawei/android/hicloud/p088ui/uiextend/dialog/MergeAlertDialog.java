package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import com.huawei.android.hicloud.constant.backup.Constant;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigOperator;
import com.huawei.hicloud.notification.util.NotifyUtil;
import java.util.ArrayList;
import java.util.Iterator;
import p015ak.C0209d;
import p514o9.C11839m;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class MergeAlertDialog extends AlertDialogC13154a {
    private static final String TAG = "MergeAlertDialog";
    private DialogCallback dialogActivity;
    private int mClickOptType;
    private Context mContext;
    private String mModuleName;
    private String mTraceId;

    public class BtnOnClickListner implements DialogInterface.OnClickListener {
        public BtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                MergeAlertDialog.this.dialogActivity.onConfirmed(MergeAlertDialog.this.mModuleName, MergeAlertDialog.this.mTraceId, MergeAlertDialog.this.mClickOptType);
            } else if (-2 == i10) {
                MergeAlertDialog.this.dialogActivity.onCanceled(MergeAlertDialog.this.mModuleName, MergeAlertDialog.this.mClickOptType);
            }
        }
    }

    public class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        public DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            MergeAlertDialog.this.dialogActivity.onCanceled(MergeAlertDialog.this.mModuleName, MergeAlertDialog.this.mClickOptType);
        }
    }

    public MergeAlertDialog(Context context, DialogCallback dialogCallback, int i10) {
        this(context, dialogCallback, "", "", i10);
        this.mClickOptType = i10;
    }

    public String getMergeMessage(Context context, ArrayList<String> arrayList) throws Resources.NotFoundException {
        int templateResId;
        Resources resources;
        if (arrayList == null || context == null) {
            C11839m.m70687e(TAG, "getMergeMessage modules null");
            return "";
        }
        int size = arrayList.size();
        if (size <= 0) {
            C11839m.m70687e(TAG, "getMergeMessage no modules");
            return "";
        }
        int i10 = size < 7 ? size : 7;
        Object[] mergeStringArray = getMergeStringArray(context, i10, arrayList);
        if (mergeStringArray == null || mergeStringArray.length <= 0 || (templateResId = getTemplateResId(mergeStringArray, i10, size)) == 0 || (resources = context.getResources()) == null) {
            return "";
        }
        String string = resources.getString(templateResId, mergeStringArray);
        return (size <= 1 || size > 7) ? size > 7 ? resources.getString(R$string.sync_data_merge_confirm_tips_more, string) : string : resources.getString(R$string.sync_data_merge_confirm_tips, string);
    }

    public Object[] getMergeStringArray(Context context, int i10, ArrayList<String> arrayList) {
        if (arrayList == null || i10 < 0) {
            return new Object[0];
        }
        ArrayList<SyncConfigService> shownSyncServiceItems = NotifyUtil.getShownSyncServiceItems(this.mContext);
        ArrayList arrayList2 = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            String str = arrayList.get(i11);
            if (Constant.m16245e().containsKey(str)) {
                arrayList2.add(context.getString(Constant.m16245e().get(str).intValue()));
            } else {
                Iterator<SyncConfigService> it = shownSyncServiceItems.iterator();
                while (true) {
                    if (it.hasNext()) {
                        SyncConfigService next = it.next();
                        if (TextUtils.equals(str, next.getId())) {
                            arrayList2.add(next.getTitleText());
                            break;
                        }
                    }
                }
            }
        }
        return arrayList2.toArray(new Object[arrayList2.size()]);
    }

    public int getTemplateResId(Object[] objArr, int i10, int i11) {
        int iMin = Math.min(objArr.length, i10);
        if (i11 > 7 && iMin >= 7) {
            return Constant.m16241a().get(8).intValue();
        }
        return Constant.m16241a().get(Integer.valueOf(iMin)).intValue();
    }

    public void show(String str, String str2) {
        String string;
        this.mModuleName = str;
        this.mTraceId = str2;
        str.hashCode();
        switch (str) {
            case "addressbook":
                Context context = this.mContext;
                string = context.getString(R$string.sync_data_merge_confirm_tips, context.getString(R$string.contact));
                break;
            case "calendar":
                Context context2 = this.mContext;
                string = context2.getString(R$string.sync_data_merge_confirm_tips, context2.getString(R$string.calendar_sync_item));
                break;
            case "wlan":
                string = this.mContext.getString(R$string.wlan_data_merge_confirm_tips, C0209d.m1262h2() ? this.mContext.getResources().getString(R$string.wlan_sync) : this.mContext.getResources().getString(R$string.wifi_sync));
                break;
            case "browser":
                string = this.mContext.getString(R$string.browser_data_merge_confirm_tips);
                break;
            case "notepad":
                Context context3 = this.mContext;
                string = context3.getString(R$string.sync_data_merge_confirm_tips, context3.getString(R$string.cloudbackup_back_item_notepad));
                break;
            default:
                SyncConfigService serviceById = new SyncConfigOperator().getServiceById(this.mModuleName);
                if (serviceById != null) {
                    String stringFromSyncConfig = NotifyUtil.getStringFromSyncConfig(serviceById.getName());
                    if (TextUtils.isEmpty(stringFromSyncConfig)) {
                        C11839m.m70687e(TAG, "mergeAlert Dialog display text is null");
                    }
                    string = this.mContext.getString(R$string.sync_data_merge_confirm_tips, stringFromSyncConfig);
                    break;
                } else {
                    C11839m.m70687e(TAG, "can not find service");
                    return;
                }
        }
        setMessage(string);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        show();
    }

    public void showLocalDataMerge(String str, String str2) {
        this.mModuleName = "all_module";
        this.mTraceId = str2;
        setMessage(str);
        show();
    }

    public MergeAlertDialog(Context context, DialogCallback dialogCallback, String str, String str2, int i10) {
        super(context);
        this.dialogActivity = dialogCallback;
        this.mContext = context;
        this.mClickOptType = i10;
        str = TextUtils.isEmpty(str) ? context.getString(R$string.notepad_switch_open_dialog_merge) : str;
        str2 = TextUtils.isEmpty(str2) ? context.getString(R$string.sync_data_merge_btn_confirm) : str2;
        BtnOnClickListner btnOnClickListner = new BtnOnClickListner();
        setButton(-1, str, btnOnClickListner);
        setButton(-2, str2, btnOnClickListner);
        setOnCancelListener(new DialogOnCancelListener());
    }
}
