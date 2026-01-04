package p737wd;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.notification.p106db.operator.DriveConfigOperator;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.sync.R$string;
import p514o9.C11839m;
import p676ud.AlertDialogC13154a;

/* renamed from: wd.a */
/* loaded from: classes3.dex */
public class AlertDialogC13588a extends AlertDialogC13154a {

    /* renamed from: a */
    public Context f61134a;

    public AlertDialogC13588a(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        this(context, "", "", onClickListener, onCancelListener);
    }

    /* renamed from: a */
    public void m81741a(String str) {
        DriveConfigService serviceById = new DriveConfigOperator().getServiceById(str);
        if (serviceById == null) {
            C11839m.m70687e("MergeAlertDialog", "can not find service");
            return;
        }
        String stringFromDriveConfig = NotifyUtil.getStringFromDriveConfig(serviceById.getName());
        if (TextUtils.isEmpty(stringFromDriveConfig)) {
            C11839m.m70687e("MergeAlertDialog", "mergeAlert Dialog display text is null");
        }
        setMessage(this.f61134a.getString(R$string.sync_data_merge_confirm_tips, stringFromDriveConfig));
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        show();
    }

    public AlertDialogC13588a(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        super(context);
        this.f61134a = context;
        str = TextUtils.isEmpty(str) ? this.f61134a.getString(R$string.notepad_switch_open_dialog_merge) : str;
        setButton(-2, TextUtils.isEmpty(str2) ? this.f61134a.getString(R$string.sync_data_merge_btn_confirm) : str2, onClickListener);
        setButton(-1, str, onClickListener);
        setOnCancelListener(onCancelListener);
    }
}
