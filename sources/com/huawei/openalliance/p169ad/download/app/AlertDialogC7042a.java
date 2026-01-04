package com.huawei.openalliance.p169ad.download.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7845x;

/* renamed from: com.huawei.openalliance.ad.download.app.a */
/* loaded from: classes2.dex */
public class AlertDialogC7042a extends AlertDialog {

    /* renamed from: a */
    private a f32343a;

    /* renamed from: b */
    private boolean f32344b;

    /* renamed from: c */
    private AppInfo f32345c;

    /* renamed from: d */
    private ContentRecord f32346d;

    /* renamed from: e */
    private Context f32347e;

    /* renamed from: f */
    private C6928i f32348f;

    /* renamed from: com.huawei.openalliance.ad.download.app.a$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialogC7042a.this.f32348f.m39221e(AlertDialogC7042a.this.f32346d, "151");
            AlertDialogC7042a alertDialogC7042a = AlertDialogC7042a.this;
            alertDialogC7042a.m42275a(alertDialogC7042a.f32344b);
            AlertDialogC7042a.this.dismiss();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.app.a$2 */
    public class AnonymousClass2 implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ RadioGroup f32350a;

        /* renamed from: b */
        final /* synthetic */ CheckBox f32351b;

        public AnonymousClass2(RadioGroup radioGroup, CheckBox checkBox) {
            radioGroup = radioGroup;
            checkBox = checkBox;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AlertDialogC7042a.this.f32344b) {
                radioGroup.clearCheck();
            } else {
                checkBox.setChecked(true);
            }
            AlertDialogC7042a.this.f32344b = !r1.f32344b;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.app.a$3 */
    public class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AlertDialogC7042a.this.f32343a != null) {
                AlertDialogC7042a.this.f32348f.m39221e(AlertDialogC7042a.this.f32346d, "152");
                AlertDialogC7042a.this.f32343a.mo38731a();
            }
            AlertDialogC7042a alertDialogC7042a = AlertDialogC7042a.this;
            alertDialogC7042a.m42275a(alertDialogC7042a.f32344b);
            AlertDialogC7042a.this.dismiss();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.app.a$a */
    public interface a {
        /* renamed from: a */
        void mo38731a();

        /* renamed from: b */
        void mo38732b();
    }

    public AlertDialogC7042a(Context context, ContentRecord contentRecord, a aVar) {
        super(context);
        this.f32344b = true;
        this.f32347e = context;
        this.f32346d = contentRecord;
        this.f32343a = aVar;
        if (contentRecord != null) {
            this.f32345c = contentRecord.m41484af();
        }
        this.f32348f = new C6928i(context);
    }

    /* renamed from: a */
    public static int m42271a(int i10, int i11, boolean z10) {
        if (i10 > 3) {
            i10 -= 3;
        }
        int i12 = i11 != 1 ? 0 : 1;
        int i13 = z10 ? 0 : 2;
        AbstractC7185ho.m43818a("AppAllowInstallDialog", "pure mode is %s, install permission is %s", Integer.valueOf(i11), Boolean.valueOf(z10));
        return (i10 & i13) | (i10 & i12);
    }

    /* renamed from: c */
    private boolean m42279c() {
        return C7124fh.m43316b(this.f32347e).mo43431cb();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        AbstractC7185ho.m43820b("AppAllowInstallDialog", "dialog is dismissed");
        super.dismiss();
        m42282d();
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (!(this.f32347e instanceof Activity)) {
                window.setType(2038);
            }
            window.setBackgroundDrawableResource(C6849R.color.hiad_0_percent_black);
            if (C7845x.m48590o(this.f32347e)) {
                window.setGravity(80);
            }
            setCancelable(false);
            setContentView(C6849R.layout.hiad_app_allow_install_dialog_cotent);
            m42273a();
        }
    }

    @Override // android.app.Dialog
    public void show() throws Resources.NotFoundException {
        AbstractC7185ho.m43820b("AppAllowInstallDialog", "show appAllowInstallDialog");
        if (!m42279c()) {
            AbstractC7185ho.m43820b("AppAllowInstallDialog", "don't remind again!");
            a aVar = this.f32343a;
            if (aVar != null) {
                aVar.mo38731a();
                m42282d();
                return;
            }
            return;
        }
        if (this.f32346d == null || this.f32345c == null || m42277b().length() <= 0) {
            return;
        }
        if (this.f32345c.m44348E() == 0) {
            AbstractC7185ho.m43820b("AppAllowInstallDialog", "show toast popUp!");
            Toast.makeText(this.f32347e.getApplicationContext(), m42277b(), 0).show();
            this.f32348f.m39221e(this.f32346d, "149");
            m42282d();
            return;
        }
        try {
            super.show();
            AbstractC7185ho.m43820b("AppAllowInstallDialog", "show dialog popUp!");
            this.f32348f.m39221e(this.f32346d, "150");
        } catch (Exception unused) {
            m42282d();
            AbstractC7185ho.m43823c("AppAllowInstallDialog", "error occurs while showing dialog");
        }
    }

    /* renamed from: b */
    private String m42277b() throws Resources.NotFoundException {
        Resources resources;
        int i10;
        String string;
        Resources resources2;
        int i11;
        String string2;
        Resources resources3;
        int i12;
        String string3;
        ContentRecord contentRecord = this.f32346d;
        if (contentRecord == null) {
            AbstractC7185ho.m43820b("AppAllowInstallDialog", "contendRecord is null");
            return "";
        }
        int iM46455C = AbstractC7558os.m46455C(contentRecord.m41427W());
        if (AbstractC7806cz.m48165b(this.f32345c.m44350F())) {
            if (this.f32345c.m44348E() > 0) {
                resources = this.f32347e.getResources();
                i10 = C6849R.string.hiad_app_allow_permi;
            } else {
                resources = this.f32347e.getResources();
                i10 = C6849R.string.hiad_app_allow_permi_t;
            }
            string = resources.getString(i10);
        } else {
            string = this.f32345c.m44350F();
        }
        if (AbstractC7806cz.m48165b(this.f32345c.m44352G())) {
            if (this.f32345c.m44348E() > 0) {
                resources2 = this.f32347e.getResources();
                i11 = C6849R.string.hiad_app_allow_pure_mode;
            } else {
                resources2 = this.f32347e.getResources();
                i11 = C6849R.string.hiad_app_allow_pure_mode_t;
            }
            string2 = resources2.getString(i11);
        } else {
            string2 = this.f32345c.m44352G();
        }
        if (AbstractC7806cz.m48165b(this.f32345c.m44354H())) {
            if (this.f32345c.m44348E() > 0) {
                resources3 = this.f32347e.getResources();
                i12 = C6849R.string.hiad_app_allow_install_pure;
            } else {
                resources3 = this.f32347e.getResources();
                i12 = C6849R.string.hiad_app_allow_install_pure_t;
            }
            string3 = resources3.getString(i12);
        } else {
            string3 = this.f32345c.m44354H();
        }
        int iM42271a = m42271a(iM46455C, AbstractC7811dd.m48347w(this.f32347e), AbstractC7811dd.m48346v(this.f32347e));
        return iM42271a != 1 ? iM42271a != 2 ? iM42271a != 3 ? "" : string3 : string : string2;
    }

    /* renamed from: d */
    private void m42282d() {
        a aVar = this.f32343a;
        if (aVar != null) {
            aVar.mo38732b();
        }
    }

    /* renamed from: a */
    private void m42273a() {
        ((TextView) findViewById(C6849R.id.hiad_allow_install_title)).setText(getContext().getResources().getString(C6849R.string.hiad_app_allow_continue_install));
        ((TextView) findViewById(C6849R.id.hiad_allow_install_close)).setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.download.app.a.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlertDialogC7042a.this.f32348f.m39221e(AlertDialogC7042a.this.f32346d, "151");
                AlertDialogC7042a alertDialogC7042a = AlertDialogC7042a.this;
                alertDialogC7042a.m42275a(alertDialogC7042a.f32344b);
                AlertDialogC7042a.this.dismiss();
            }
        });
        ((TextView) findViewById(C6849R.id.hiad_allow_install_message)).setText(m42277b());
        RadioGroup radioGroup = (RadioGroup) findViewById(C6849R.id.hiad_allow_install_remind_again_parent);
        CheckBox checkBox = (CheckBox) findViewById(C6849R.id.hiad_allow_install_remind_again);
        checkBox.setChecked(this.f32344b);
        checkBox.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.download.app.a.2

            /* renamed from: a */
            final /* synthetic */ RadioGroup f32350a;

            /* renamed from: b */
            final /* synthetic */ CheckBox f32351b;

            public AnonymousClass2(RadioGroup radioGroup2, CheckBox checkBox2) {
                radioGroup = radioGroup2;
                checkBox = checkBox2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlertDialogC7042a.this.f32344b) {
                    radioGroup.clearCheck();
                } else {
                    checkBox.setChecked(true);
                }
                AlertDialogC7042a.this.f32344b = !r1.f32344b;
            }
        });
        TextView textView = (TextView) findViewById(C6849R.id.hiad_allow_install_accept);
        textView.setText(!AbstractC7806cz.m48165b(this.f32345c.m44356I()) ? this.f32345c.m44356I() : this.f32347e.getResources().getString(C6849R.string.hiad_app_allow_continue_btn));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.download.app.a.3
            public AnonymousClass3() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlertDialogC7042a.this.f32343a != null) {
                    AlertDialogC7042a.this.f32348f.m39221e(AlertDialogC7042a.this.f32346d, "152");
                    AlertDialogC7042a.this.f32343a.mo38731a();
                }
                AlertDialogC7042a alertDialogC7042a = AlertDialogC7042a.this;
                alertDialogC7042a.m42275a(alertDialogC7042a.f32344b);
                AlertDialogC7042a.this.dismiss();
            }
        });
    }

    /* renamed from: a */
    public void m42275a(boolean z10) {
        C7124fh.m43316b(this.f32347e).mo43455f(!z10);
    }
}
