package com.huawei.android.hicloud.p088ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBENavLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.notification.BackupNotificationManager;
import com.huawei.android.hicloud.report.CloudCommonReport;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0234s;
import p020ap.C1010e;
import p223db.C9062b;
import p514o9.C11829c;
import p514o9.C11836j;
import p514o9.C11839m;
import p681uj.C13195l;
import p684un.C13227f;
import p709vj.C13452e;
import p709vj.InterfaceC13450c;
import p837z9.C14163d;
import sk.C12809f;

/* loaded from: classes3.dex */
public class DataMigrationAuthActivity extends UIActivity {

    /* renamed from: p */
    public NotchTopFitRelativeLayout f14676p;

    /* renamed from: q */
    public NotchFitRelativeLayout f14677q;

    /* renamed from: r */
    public NotchFitLinearLayout f14678r;

    /* renamed from: s */
    public OOBENavLayout f14679s;

    /* renamed from: t */
    public AlertDialog f14680t;

    /* renamed from: u */
    public TextView f14681u;

    /* renamed from: v */
    public C3265c f14682v = new C3265c();

    /* renamed from: com.huawei.android.hicloud.ui.activity.DataMigrationAuthActivity$a */
    public class ViewOnClickListenerC3263a implements View.OnClickListener {
        public ViewOnClickListenerC3263a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, IllegalArgumentException {
            DataMigrationAuthActivity.this.m20329S1();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.DataMigrationAuthActivity$b */
    public class ViewOnClickListenerC3264b implements View.OnClickListener {
        public ViewOnClickListenerC3264b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C13227f.m79492i1().m79553F0("migrate_user_agree");
            CloudCommonReport.m17078b(DataMigrationAuthActivity.this, "user_agree", 0);
            C14163d.m84990g().m84996a(1);
            DataMigrationAuthActivity dataMigrationAuthActivity = DataMigrationAuthActivity.this;
            dataMigrationAuthActivity.setResult(-1, dataMigrationAuthActivity.getIntent());
            DataMigrationAuthActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.DataMigrationAuthActivity$c */
    public class C3265c implements InterfaceC13450c {
        public C3265c() {
        }

        @Override // p709vj.InterfaceC13450c
        /* renamed from: a */
        public void mo20330a(ErrorStatus errorStatus) {
            C11839m.m70686d("DataMigrationAuthActivity", "CHECKPASSWORD_ONERROR");
        }

        @Override // p709vj.InterfaceC13450c
        /* renamed from: b */
        public void mo20331b() {
            C11839m.m70686d("DataMigrationAuthActivity", "CHECKPASSWORD_ONFINISH");
            DataMigrationAuthActivity.this.m20327O1();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.DataMigrationAuthActivity$d */
    public class DialogInterfaceOnClickListenerC3266d implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
        public DialogInterfaceOnClickListenerC3266d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -1) {
                DataMigrationAuthActivity.this.m20328R1();
            } else {
                dialogInterface.dismiss();
            }
        }

        public /* synthetic */ DialogInterfaceOnClickListenerC3266d(DataMigrationAuthActivity dataMigrationAuthActivity, ViewOnClickListenerC3263a viewOnClickListenerC3263a) {
            this();
        }
    }

    /* renamed from: P1 */
    private void m20324P1() {
        C14163d.m84990g().m85011q(this);
    }

    /* renamed from: Q1 */
    private void m20325Q1() {
        this.f14676p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f14677q = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_auth_nav_layout);
        this.f14678r = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.notch_main_layout);
        this.f14679s = (OOBENavLayout) C12809f.m76829b(this, R$id.auth_nav_layout);
        if (getResources() != null) {
            this.f14679s.setMarginHorizontal(getResources().getDimensionPixelSize(R$dimen.margin_xl));
        }
        this.f14679s.setBackBtnClickListener(new ViewOnClickListenerC3263a());
        this.f14679s.setNextBtnClickListener(new ViewOnClickListenerC3264b());
        this.f14681u = (TextView) C12809f.m76829b(this, R$id.tip_3);
        if (!C0234s.m1636n().endsWith("zh")) {
            this.f14681u.setText(getString(R$string.migrate_terms_tip_3, getString(R$string.about_official_sites)));
            return;
        }
        this.f14681u.setText(getString(R$string.migrate_terms_tip_3, " " + getString(R$string.about_official_sites) + " "));
    }

    /* renamed from: N1 */
    public final void m20326N1() {
        C11839m.m70686d("DataMigrationAuthActivity", "enter closePhoneFinder()");
        C13195l.m79272J().m79324o(this, C1010e.m6125b().m6136a(this), 8906, this.f14682v);
    }

    /* renamed from: O1 */
    public final void m20327O1() {
        C11839m.m70686d("DataMigrationAuthActivity", "enter exitCloud()");
        C13227f.m79492i1().m79553F0("migrate_user_refused");
        CloudCommonReport.m17078b(this, "user_refused", 0);
        setResult(2);
        finish();
        C9062b.m57146k().m57155h(false, false);
    }

    /* renamed from: R1 */
    public void m20328R1() {
        boolean zM6139e = C1010e.m6125b().m6139e(this);
        C11839m.m70688i("DataMigrationAuthActivity", "phoneStatus: " + zM6139e);
        if (zM6139e && C0209d.m1166E1()) {
            m20326N1();
        } else {
            m20327O1();
        }
    }

    /* renamed from: S1 */
    public final void m20329S1() throws IllegalAccessException, IllegalArgumentException {
        if (this.f14680t == null) {
            AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
            this.f14680t = alertDialogCreate;
            C11829c.m70594l1(this, alertDialogCreate);
            this.f14680t.setTitle(R$string.hisync_exit_title);
            this.f14680t.setMessage(getString(R$string.hisync_exit_content));
            this.f14680t.setButton(-1, getString(R$string.hisync_exit_confirm), new DialogInterfaceOnClickListenerC3266d(this, null));
            this.f14680t.setButton(-2, getString(R$string.oobe_cancel_v2), new DialogInterfaceOnClickListenerC3266d(this, null));
        }
        if (this.f14680t.isShowing()) {
            return;
        }
        this.f14680t.show();
        Button button = this.f14680t.getButton(-1);
        if (button == null || getResources() == null) {
            return;
        }
        button.setTextColor(getResources().getColor(R$color.emui_functional_red));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14676p);
        arrayList.add(this.f14677q);
        arrayList.add(this.f14678r);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 8906) {
            C13195l.m79272J().m79297M(this, this.f14682v, i11, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70689w("DataMigrationAuthActivity", "hicloud is not login.");
            finish();
            return;
        }
        C11829c.m70633y1(this, getWindow());
        setContentView(R$layout.activity_data_migration_auth);
        C13227f.m79492i1().m79553F0("migrate_enter_auth_activity");
        CloudCommonReport.m17078b(this, "enter_auth_activity", 0);
        if (getActionBar() != null) {
            getActionBar().hide();
        }
        m20325Q1();
        mo19005p1();
        m20324P1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AlertDialog alertDialog = this.f14680t;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f14680t = null;
        }
        C11836j.m70658k().m70672o(this);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C11836j.m70658k().m70660b(this, 2);
        new BackupNotificationManager(this).cancelNotification(276);
        if (C14163d.m84990g().m85010p()) {
            setResult(-1, getIntent());
            finish();
        }
    }
}
