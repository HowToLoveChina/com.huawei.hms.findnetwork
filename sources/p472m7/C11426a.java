package p472m7;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.hicloud.notification.manager.AdSwitchManager;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hicloud.sync.R$plurals;
import com.huawei.hicloud.sync.R$string;
import p015ak.C0209d;
import p514o9.C11829c;
import p514o9.C11839m;
import p846zj.C14306d;
import sk.C12809f;

/* renamed from: m7.a */
/* loaded from: classes2.dex */
public class C11426a implements SpanClickText.ISpanClickListener {

    /* renamed from: a */
    public Context f53253a;

    /* renamed from: b */
    public String f53254b;

    /* renamed from: c */
    public boolean f53255c;

    /* renamed from: m7.a$a */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            AdSwitchManager.getInstance().setDialogSwitchStatus(AdSwitchManager.getInstance().getTempdialogSwitchStatus());
        }
    }

    /* renamed from: m7.a$b */
    public class b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ AlertDialog f53257a;

        public b(AlertDialog alertDialog) {
            this.f53257a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C11839m.m70688i("PrivacyClickListener", "click close personalization dialog");
            AlertDialog alertDialog = this.f53257a;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            AdSwitchManager.getInstance().setTempdialogSwitchStatus(AdSwitchManager.getInstance().getDialogSwitchStatus());
        }
    }

    /* renamed from: m7.a$c */
    public class c implements CompoundButton.OnCheckedChangeListener {
        public c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            C11839m.m70688i("PrivacyClickListener", "personalization dialog switch isChecked: " + z10);
            AdSwitchManager.getInstance().setTempdialogSwitchStatus(z10);
        }
    }

    public C11426a(Context context, String str, boolean z10) {
        this.f53253a = context;
        this.f53254b = str;
        this.f53255c = z10;
    }

    @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
    public void onClick() {
        if (C0209d.m1226Y0()) {
            C11839m.m70689w("PrivacyClickListener", "fast click");
            return;
        }
        if (this.f53253a == null) {
            C11839m.m70687e("PrivacyClickListener", "onClick mContext is null");
            return;
        }
        C11839m.m70688i("PrivacyClickListener", "clickType: " + this.f53254b);
        String str = this.f53254b;
        str.hashCode();
        if (str.equals("added_services")) {
            try {
                View viewInflate = LayoutInflater.from(this.f53253a).inflate(R$layout.personalization_dialog, (ViewGroup) null);
                AlertDialog alertDialogCreate = new AlertDialog.Builder(this.f53253a).setCustomTitle(null).setView(viewInflate).setNeutralButton(this.f53253a.getText(R$string.conform), new a()).create();
                ((RelativeLayout) C12809f.m76831d(viewInflate, R$id.ly_personalization_dialog_close)).setOnClickListener(new b(alertDialogCreate));
                UnionSwitch unionSwitch = (UnionSwitch) C12809f.m76831d(viewInflate, R$id.personalization_dialog_switch);
                unionSwitch.setOnCheckedChangeListener(new c());
                unionSwitch.setChecked(AdSwitchManager.getInstance().getDialogSwitchStatus());
                Window window = alertDialogCreate.getWindow();
                if (window != null) {
                    window.setFlags(1024, 1024);
                }
                C11829c.m70600n1(alertDialogCreate, C0209d.m1200P1(this.f53253a), this.f53255c);
                alertDialogCreate.setCancelable(false);
                alertDialogCreate.show();
                return;
            } catch (Exception e10) {
                C11839m.m70687e("PrivacyClickListener", "start add services dialog exception: " + e10.toString());
                return;
            }
        }
        if (str.equals("permission_description")) {
            try {
                LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f53253a);
                boolean zM1277l1 = C0209d.m1277l1();
                boolean zM85208i = C14306d.m85208i();
                View viewInflate2 = zM1277l1 ? layoutInflaterFrom.inflate(R$layout.permission_description_honors, (ViewGroup) null) : zM85208i ? layoutInflaterFrom.inflate(R$layout.permission_description_second_country, (ViewGroup) null) : layoutInflaterFrom.inflate(R$layout.permission_description, (ViewGroup) null);
                TextView textView = (TextView) C12809f.m76831d(viewInflate2, R$id.permission_detail);
                if (textView != null && this.f53253a.getResources() != null) {
                    if (zM1277l1 || zM85208i) {
                        textView.setText(this.f53253a.getResources().getQuantityString(R$plurals.privacy_dialog_title_content_new, 7, 7));
                    } else {
                        textView.setText(this.f53253a.getResources().getQuantityString(R$plurals.privacy_dialog_title_content_new, 10, 10));
                    }
                }
                AlertDialog alertDialogCreate2 = new AlertDialog.Builder(this.f53253a).setCustomTitle(null).setView(viewInflate2).setNeutralButton(this.f53253a.getText(R$string.beta_ok), (DialogInterface.OnClickListener) null).create();
                Window window2 = alertDialogCreate2.getWindow();
                if (window2 != null) {
                    window2.setFlags(1024, 1024);
                }
                C11829c.m70600n1(alertDialogCreate2, C0209d.m1200P1(this.f53253a), this.f53255c);
                alertDialogCreate2.setCancelable(false);
                alertDialogCreate2.show();
            } catch (Exception e11) {
                C11839m.m70687e("PrivacyClickListener", "start permission dialog exception: " + e11.toString());
            }
        }
    }

    public C11426a(Context context, String str) {
        this.f53255c = false;
        this.f53253a = context;
        this.f53254b = str;
    }
}
