package com.huawei.android.hicloud.p088ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.notification.BackupNotification;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p681uj.C13195l;
import p684un.C13227f;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudSpaceExpansionServiceActivity extends UIActivity implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: p */
    public NotchTopFitRelativeLayout f14521p;

    /* renamed from: q */
    public NotchFitLinearLayout f14522q;

    /* renamed from: r */
    public UnionSwitch f14523r;

    /* renamed from: s */
    public TextView f14524s;

    /* renamed from: t */
    public TextView f14525t;

    /* renamed from: u */
    public boolean f14526u = true;

    /* renamed from: v */
    public AlertDialog f14527v;

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceExpansionServiceActivity$a */
    public class DialogInterfaceOnKeyListenerC3249a implements DialogInterface.OnKeyListener {
        public DialogInterfaceOnKeyListenerC3249a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            if (i10 != 4) {
                return false;
            }
            CloudSpaceExpansionServiceActivity.this.f14526u = true;
            CloudSpaceExpansionServiceActivity.this.f14523r.setCheckedProgrammatically(CloudSpaceExpansionServiceActivity.this.f14526u);
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceExpansionServiceActivity$b */
    public static class C3250b extends AbstractC12367d {
        public C3250b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws InterruptedException {
            try {
                Thread.sleep(3000L);
                BackupNotification.getInstance().cancelBackupNotification();
            } catch (Exception e10) {
                C11839m.m70687e("CloudSpaceExpansionServiceActivity", "clear notification exception: " + e10.toString());
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.STOCK_ACTIVE;
        }

        public /* synthetic */ C3250b(DialogInterfaceOnKeyListenerC3249a dialogInterfaceOnKeyListenerC3249a) {
            this();
        }
    }

    /* renamed from: R1 */
    private void m20144R1() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        mo13327n1();
        m22365E1(R$string.function_item);
        this.f14521p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_cloud_space_expansion_service);
        this.f14522q = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.main_cloud_space_expansion_frame);
        this.f14523r = (UnionSwitch) C12809f.m76829b(this, R$id.expansion_service_switch);
        this.f14524s = (TextView) C12809f.m76829b(this, R$id.tv_function_item_desc1);
        this.f14525t = (TextView) C12809f.m76829b(this, R$id.tv_function_item_desc2);
        this.f14524s.setText(getString(R$string.function_item_desc1, 1));
        if (C10028c.m62182c0().m62395t1("funcfg_find_my_phone_globe")) {
            this.f14525t.setText(getString(R$string.function_item_desc2, 2));
        } else {
            this.f14525t.setText(getString(R$string.function_item_desc2_honors, 2));
        }
        mo19005p1();
    }

    /* renamed from: Q1 */
    public final void m20145Q1() {
        this.f14523r.setOnCheckedChangeListener(this);
        boolean zM62413x = C10028c.m62182c0().m62413x();
        this.f14526u = zM62413x;
        this.f14523r.setCheckedProgrammatically(zM62413x);
    }

    /* renamed from: S1 */
    public final /* synthetic */ void m20146S1(DialogInterface dialogInterface, int i10) {
        C11839m.m70686d("CloudSpaceExpansionServiceActivity", "stop");
        C13227f.m79492i1().m79585f0("extended_service_click_close_confirm_stop", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "extended_service_click_close_confirm_stop", "1", "100");
        m20150W1();
    }

    /* renamed from: T1 */
    public final /* synthetic */ void m20147T1(DialogInterface dialogInterface, int i10) {
        C11839m.m70686d("CloudSpaceExpansionServiceActivity", "cancel");
        C13227f.m79492i1().m79585f0("extended_service_click_close_confirm_cancel", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "extended_service_click_close_confirm_cancel", "1", "100");
        this.f14526u = true;
        this.f14523r.setCheckedProgrammatically(true);
    }

    /* renamed from: U1 */
    public final void m20148U1(int i10) {
        C10028c.m62182c0().m62272S1(this.f14526u);
        if (this.f14526u) {
            return;
        }
        C2783d.m16135e(this, i10);
    }

    /* renamed from: V1 */
    public final void m20149V1() throws IllegalAccessException, IllegalArgumentException {
        Resources resources = getResources();
        if (resources == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setOnKeyListener(new DialogInterfaceOnKeyListenerC3249a());
        builder.setTitle(resources.getString(R$string.stop_cloud_space_expansion_service)).setMessage(resources.getString(R$string.stop_cloud_space_expansion_service_desc)).setPositiveButton(resources.getString(R$string.function_item_stop_btn), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.y4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f17817a.m20146S1(dialogInterface, i10);
            }
        }).setNegativeButton(resources.getString(R$string.sync_data_merge_btn_confirm), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.z4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f17833a.m20147T1(dialogInterface, i10);
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        this.f14527v = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f14527v.setCanceledOnTouchOutside(false);
        this.f14527v.show();
        Button button = this.f14527v.getButton(-1);
        if (button != null) {
            button.setTextColor(getResources().getColor(R$color.red));
        }
    }

    /* renamed from: W1 */
    public final void m20150W1() {
        try {
            Intent intentM79271I = C13195l.m79271I(this, "hwid://com.huawei.hwid/VerifyPassword");
            if (intentM79271I == null) {
                return;
            }
            String strM80905e = C13452e.m80781L().m80905e();
            intentM79271I.putExtra("VERIFY_PASSWORD_TYPE", 0);
            intentM79271I.putExtra("accountType", strM80905e);
            startActivityForResult(intentM79271I, 1200);
        } catch (Exception e10) {
            C11839m.m70687e("CloudSpaceExpansionServiceActivity", "verifyPassWord exception" + e10.getMessage());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14521p);
        arrayList.add(this.f14522q);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        C11839m.m70688i("CloudSpaceExpansionServiceActivity", "requestCode:" + i10 + " resultCode: " + i11);
        if (i10 == 1200) {
            if (i11 == -1) {
                C11839m.m70688i("CloudSpaceExpansionServiceActivity", "verifyPassWord ok");
                m20148U1(11);
                C12515a.m75110o().m75172d(new C3250b(null));
            } else {
                this.f14526u = true;
                this.f14523r.setCheckedProgrammatically(true);
            }
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) throws IllegalAccessException, IllegalArgumentException {
        if (compoundButton == null) {
            C11839m.m70688i("CloudSpaceExpansionServiceActivity", "buttonView is null");
            return;
        }
        if (compoundButton.getId() == R$id.expansion_service_switch) {
            this.f14526u = z10;
            if (z10) {
                C11839m.m70686d("CloudSpaceExpansionServiceActivity", "checked");
                C13227f.m79492i1().m79585f0("extended_service_click_open_activity", C13452e.m80781L().m80971t0());
                UBAAnalyze.m29954O("PVC", "extended_service_click_open_activity", "1", "100");
                m20148U1(11);
                return;
            }
            C11839m.m70686d("CloudSpaceExpansionServiceActivity", "not checked");
            C13227f.m79492i1().m79585f0("extended_service_click_close_activity", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "extended_service_click_close_activity", "1", "100");
            m20149V1();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R$layout.activity_cloud_space_expansion_service);
        m20144R1();
        m20145Q1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AlertDialog alertDialog = this.f14527v;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f14527v = null;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        AlertDialog alertDialog = this.f14527v;
        if (alertDialog != null && alertDialog.isShowing()) {
            C11839m.m70686d("CloudSpaceExpansionServiceActivity", "mAlertDialog is showing,need close switch");
            return;
        }
        if (!C0209d.m1181J0(this)) {
            C11839m.m70688i("CloudSpaceExpansionServiceActivity", "not RunningForeground");
            return;
        }
        C11839m.m70688i("CloudSpaceExpansionServiceActivity", "onResume");
        boolean zM62413x = C10028c.m62182c0().m62413x();
        this.f14526u = zM62413x;
        this.f14523r.setCheckedProgrammatically(zM62413x);
    }
}
