package p737wd;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.huawei.android.hicloud.p088ui.dialog.DialogCallback;
import com.huawei.android.sync.R$string;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigOperator;
import com.huawei.hicloud.notification.util.NotifyUtil;
import p015ak.C0209d;
import p514o9.C11839m;
import p676ud.AlertDialogC13154a;

/* renamed from: wd.c */
/* loaded from: classes3.dex */
public class AlertDialogC13590c extends AlertDialogC13154a {

    /* renamed from: a */
    public Context f61147a;

    /* renamed from: b */
    public String f61148b;

    /* renamed from: c */
    public DialogCallback f61149c;

    /* renamed from: d */
    public String f61150d;

    /* renamed from: wd.c$a */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                AlertDialogC13590c.this.f61149c.mo21688s(AlertDialogC13590c.this.f61148b, AlertDialogC13590c.this.f61150d);
            } else if (-2 == i10) {
                AlertDialogC13590c.this.f61149c.mo21687p0(AlertDialogC13590c.this.f61148b);
            }
        }
    }

    /* renamed from: wd.c$b */
    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            AlertDialogC13590c.this.f61149c.mo21687p0(AlertDialogC13590c.this.f61148b);
        }
    }

    public AlertDialogC13590c(Context context, DialogCallback dialogCallback) {
        this(context, dialogCallback, "", "");
    }

    public void show(String str, String str2) throws Throwable {
        String string;
        this.f61148b = str;
        this.f61150d = str2;
        str.hashCode();
        switch (str) {
            case "addressbook":
                Context context = this.f61147a;
                string = context.getString(R$string.sync_data_merge_confirm_tips, context.getString(R$string.contact));
                break;
            case "calendar":
                Context context2 = this.f61147a;
                string = context2.getString(R$string.sync_data_merge_confirm_tips, context2.getString(R$string.calendar_sync_item));
                break;
            case "wlan":
                string = this.f61147a.getString(R$string.wlan_data_merge_confirm_tips, C0209d.m1262h2() ? this.f61147a.getResources().getString(R$string.wlan_sync) : this.f61147a.getResources().getString(R$string.wifi_sync));
                break;
            case "browser":
                string = this.f61147a.getString(R$string.browser_data_merge_confirm_tips);
                break;
            case "notepad":
                Context context3 = this.f61147a;
                string = context3.getString(R$string.sync_data_merge_confirm_tips, context3.getString(R$string.cloudbackup_back_item_notepad));
                break;
            default:
                SyncConfigService serviceById = new SyncConfigOperator().getServiceById(this.f61148b);
                if (serviceById != null) {
                    String stringFromSyncConfig = NotifyUtil.getStringFromSyncConfig(serviceById.getName());
                    if (TextUtils.isEmpty(stringFromSyncConfig)) {
                        C11839m.m70687e("MergeAlertDialog", "mergeAlert Dialog display text is null");
                    }
                    string = this.f61147a.getString(R$string.sync_data_merge_confirm_tips, stringFromSyncConfig);
                    break;
                } else {
                    C11839m.m70687e("MergeAlertDialog", "can not find service");
                    return;
                }
        }
        setMessage(string);
        show();
    }

    public AlertDialogC13590c(Context context, DialogCallback dialogCallback, String str, String str2) {
        super(context);
        this.f61149c = dialogCallback;
        this.f61147a = context;
        str = TextUtils.isEmpty(str) ? context.getString(R$string.notepad_switch_open_dialog_merge) : str;
        str2 = TextUtils.isEmpty(str2) ? context.getString(R$string.sync_data_merge_btn_confirm) : str2;
        a aVar = new a();
        setButton(-2, str2, aVar);
        setButton(-1, str, aVar);
        setOnCancelListener(new b());
    }
}
