package p420k7;

import android.content.Context;
import android.content.DialogInterface;
import bo.InterfaceC1268b;
import com.huawei.hicloud.sync.R$color;
import com.huawei.hicloud.sync.R$string;
import gp.C10028c;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p514o9.C11839m;
import p676ud.AlertDialogC13154a;

/* renamed from: k7.a */
/* loaded from: classes2.dex */
public class AlertDialogC11014a extends AlertDialogC13154a {

    /* renamed from: a */
    public Context f52079a;

    /* renamed from: b */
    public InterfaceC1268b f52080b;

    /* renamed from: k7.a$a */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            InterfaceC1268b interfaceC1268b;
            if (-1 == i10) {
                InterfaceC1268b interfaceC1268b2 = AlertDialogC11014a.this.f52080b;
                if (interfaceC1268b2 != null) {
                    interfaceC1268b2.mo7531n(false);
                }
            } else if (-3 == i10) {
                InterfaceC1268b interfaceC1268b3 = AlertDialogC11014a.this.f52080b;
                if (interfaceC1268b3 != null) {
                    interfaceC1268b3.mo7531n(true);
                }
            } else if (-2 == i10 && (interfaceC1268b = AlertDialogC11014a.this.f52080b) != null) {
                interfaceC1268b.mo7530X();
            }
            AlertDialogC11014a.this.dismiss();
        }
    }

    public AlertDialogC11014a(Context context, InterfaceC1268b interfaceC1268b) {
        super(context);
        this.f52080b = interfaceC1268b;
        this.f52079a = context;
        initView();
    }

    private void initView() {
        a aVar = new a();
        setButton(-1, this.f52079a.getString(R$string.retain_data), aVar);
        setButton(-3, this.f52079a.getString(R$string.delete_data), aVar);
        setButton(-2, this.f52079a.getString(R$string.cloudbackup_btn_cancel), aVar);
        setCancelable(false);
        setTitle(this.f52079a.getString(R$string.exit_account_alert_title));
        setMessage(m66364b());
    }

    /* renamed from: a */
    public final List<String> m66363a() {
        ArrayList arrayList = new ArrayList();
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (c10028cM62182c0 == null) {
            C11839m.m70687e("ProcessLocalSyncDataDialog", "getEnabledSyncModuleStr: backupSetting is null");
            return arrayList;
        }
        boolean zM62388s = c10028cM62182c0.m62388s("addressbook");
        boolean zM62388s2 = c10028cM62182c0.m62388s("calendar");
        boolean zM62388s3 = c10028cM62182c0.m62388s("notepad");
        boolean zM62388s4 = c10028cM62182c0.m62388s("wlan");
        if (zM62388s) {
            arrayList.add(this.f52079a.getString(R$string.contact));
        }
        if (zM62388s2) {
            arrayList.add(this.f52079a.getString(R$string.exit_account_alert_calendar_tips));
        }
        if (zM62388s3) {
            arrayList.add(this.f52079a.getString(R$string.cloudbackup_back_item_notepad));
        }
        if (zM62388s4) {
            if (C0209d.m1262h2()) {
                arrayList.add(this.f52079a.getString(R$string.wlan_sync));
            } else {
                arrayList.add(this.f52079a.getString(R$string.wifi_sync));
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public final String m66364b() {
        List<String> listM66363a = m66363a();
        int size = listM66363a.size();
        if (size == 1) {
            return this.f52079a.getString(R$string.exit_account_alert_tips_1, listM66363a.get(0));
        }
        if (size == 2) {
            return this.f52079a.getString(R$string.exit_account_alert_tips_2, listM66363a.get(0), listM66363a.get(1));
        }
        if (size == 3) {
            return this.f52079a.getString(R$string.exit_account_alert_tips_3, listM66363a.get(0), listM66363a.get(1), listM66363a.get(2));
        }
        if (size == 4) {
            return this.f52079a.getString(R$string.exit_account_alert_tips_4, listM66363a.get(0), listM66363a.get(1), listM66363a.get(2), listM66363a.get(3));
        }
        C11839m.m70687e("ProcessLocalSyncDataDialog", "Logout tips number is wrong");
        return "";
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        getButton(-3).setTextColor(this.f52079a.getColor(R$color.enui50_red_color));
    }
}
