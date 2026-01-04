package com.huawei.updatesdk.p191b.p202i;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.huawei.updatesdk.p177a.p178a.C8774a;
import com.huawei.updatesdk.p177a.p178a.p183d.p184i.C8789c;
import com.huawei.updatesdk.p191b.p201h.C8833a;
import com.huawei.updatesdk.p191b.p201h.C8835c;

/* renamed from: com.huawei.updatesdk.b.i.a */
/* loaded from: classes9.dex */
public class C8837a {

    /* renamed from: a */
    private InterfaceC8838b f45188a;

    /* renamed from: b */
    private final Context f45189b;

    /* renamed from: c */
    private AlertDialog f45190c;

    /* renamed from: d */
    private final AlertDialog.Builder f45191d;

    /* renamed from: e */
    private DialogInterface.OnShowListener f45192e;

    /* renamed from: f */
    private DialogInterface.OnDismissListener f45193f;

    /* renamed from: com.huawei.updatesdk.b.i.a$a */
    public class a implements DialogInterface.OnShowListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            C8837a.this.m56345a(dialogInterface);
            if (C8837a.this.f45192e != null) {
                C8837a.this.f45192e.onShow(dialogInterface);
            }
        }
    }

    /* renamed from: com.huawei.updatesdk.b.i.a$b */
    public class b implements DialogInterface.OnDismissListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (C8837a.this.f45193f != null) {
                C8837a.this.f45193f.onDismiss(dialogInterface);
            }
        }
    }

    /* renamed from: com.huawei.updatesdk.b.i.a$c */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C8837a.this.f45188a != null) {
                C8837a.this.f45188a.mo56362a();
            }
        }
    }

    /* renamed from: com.huawei.updatesdk.b.i.a$d */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C8837a.this.f45188a != null) {
                C8837a.this.f45188a.mo56363b();
            }
        }
    }

    /* renamed from: com.huawei.updatesdk.b.i.a$e */
    public interface e {
        /* renamed from: a */
        void mo56361a();
    }

    public C8837a(Context context, String str, CharSequence charSequence) {
        this.f45189b = context;
        this.f45191d = C8789c.m56116l() ? new AlertDialog.Builder(context) : (context.getResources().getConfiguration().uiMode & 48) == 32 ? new AlertDialog.Builder(context, R.style.Theme.DeviceDefault.Dialog.Alert) : new AlertDialog.Builder(context, R.style.Theme.DeviceDefault.Light.Dialog.Alert);
        this.f45191d.setTitle(str);
        this.f45191d.setPositiveButton(C8835c.m56335c(context, "upsdk_third_app_dl_sure_cancel_download"), (DialogInterface.OnClickListener) null);
        this.f45191d.setNegativeButton(C8835c.m56335c(context, "upsdk_cancel"), (DialogInterface.OnClickListener) null);
        this.f45191d.setMessage(charSequence);
    }

    /* renamed from: a */
    public static C8837a m56344a(Context context, String str, CharSequence charSequence) {
        return new C8837a(context, str, charSequence);
    }

    /* renamed from: b */
    private void m56348b(e eVar) {
        try {
            this.f45190c = this.f45191d.create();
            C8789c.m56105f().m56120a(this.f45190c.getWindow());
            this.f45190c.setCanceledOnTouchOutside(false);
            this.f45190c.setOnShowListener(new a());
            this.f45190c.setOnDismissListener(new b());
            this.f45190c.show();
            this.f45190c.getButton(-1).requestFocus();
        } catch (Exception e10) {
            if (eVar != null) {
                eVar.mo56361a();
            }
            C8774a.m56008a("BaseAlertDialog", "show dlg error, e: " + e10.getMessage());
        }
    }

    /* renamed from: c */
    public void m56360c() {
        AlertDialog.Builder builder = this.f45191d;
        if (builder == null) {
            return;
        }
        builder.setNegativeButton((CharSequence) null, (DialogInterface.OnClickListener) null);
    }

    /* renamed from: a */
    public void m56350a() {
        try {
            AlertDialog alertDialog = this.f45190c;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f45190c = null;
            }
        } catch (IllegalArgumentException unused) {
            C8774a.m56009b("BaseAlertDialog", "dialog dismiss IllegalArgumentException");
        }
    }

    /* renamed from: b */
    public boolean m56359b() {
        AlertDialog alertDialog = this.f45190c;
        return alertDialog != null && alertDialog.isShowing();
    }

    /* renamed from: a */
    public void m56351a(int i10, String str) {
        Button button;
        AlertDialog alertDialog = this.f45190c;
        if (alertDialog == null || (button = alertDialog.getButton(i10)) == null) {
            return;
        }
        button.setText(str);
        button.setAllCaps(true);
    }

    /* renamed from: a */
    public void m56352a(DialogInterface.OnDismissListener onDismissListener) {
        this.f45193f = onDismissListener;
    }

    /* renamed from: a */
    public void m56353a(DialogInterface.OnKeyListener onKeyListener) {
        AlertDialog alertDialog = this.f45190c;
        if (alertDialog != null) {
            alertDialog.setOnKeyListener(onKeyListener);
        }
    }

    /* renamed from: a */
    public void m56354a(DialogInterface.OnShowListener onShowListener) {
        this.f45192e = onShowListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m56345a(DialogInterface dialogInterface) {
        AlertDialog alertDialog = (AlertDialog) dialogInterface;
        alertDialog.getButton(-1).setOnClickListener(new c());
        Button button = alertDialog.getButton(-2);
        if (button != null) {
            button.setOnClickListener(new d());
        }
    }

    /* renamed from: a */
    public void m56355a(View view) {
        ImageView imageView;
        if (this.f45191d != null) {
            if ((C8833a.m56305f().m56308a() >= 17 || C8833a.m56305f().m56309b() > 0) && (imageView = (ImageView) view.findViewById(C8835c.m56331a(view.getContext(), "divider"))) != null) {
                imageView.setVisibility(8);
            }
            this.f45191d.setMessage((CharSequence) null);
            this.f45191d.setView(view);
        }
    }

    /* renamed from: a */
    public void m56356a(e eVar) {
        Context context = this.f45189b;
        if (context != null && !((Activity) context).isFinishing()) {
            if (m56359b()) {
                return;
            }
            m56348b(eVar);
        } else {
            C8774a.m56009b("BaseAlertDialog", "context == null or activity isFinishing");
            if (eVar != null) {
                eVar.mo56361a();
            }
        }
    }

    /* renamed from: a */
    public void m56357a(InterfaceC8838b interfaceC8838b) {
        this.f45188a = interfaceC8838b;
    }

    /* renamed from: a */
    public void m56358a(boolean z10) {
        AlertDialog alertDialog = this.f45190c;
        if (alertDialog != null) {
            alertDialog.setCancelable(z10);
        }
    }
}
