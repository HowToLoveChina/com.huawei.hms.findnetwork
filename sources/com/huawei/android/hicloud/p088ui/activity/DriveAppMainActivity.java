package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.dynamicfeature.plugin.language.LanguagePlugin;
import com.huawei.android.hicloud.p088ui.common.DisableSupportedRelativeLayout;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.sync.service.aidl.SyncObserverServiceInvoker;
import com.huawei.android.sync.R$id;
import com.huawei.android.sync.R$layout;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.notification.p106db.operator.DriveConfigOperator;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.intent.SafeIntent;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p514o9.C11829c;
import p514o9.C11836j;
import p514o9.C11839m;
import p514o9.C11842p;
import p676ud.AlertDialogC13157d;
import p684un.C13226e;
import p709vj.C13452e;
import p737wd.AlertDialogC13588a;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class DriveAppMainActivity extends HMSTermsProcessBaseActivity implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: A */
    public AlertDialogC13157d f14741A;

    /* renamed from: B */
    public AlertDialogC13588a f14742B;

    /* renamed from: p */
    public RelativeLayout f14743p;

    /* renamed from: q */
    public DisableSupportedRelativeLayout f14744q;

    /* renamed from: r */
    public UnionSwitch f14745r;

    /* renamed from: s */
    public HiCloudExceptionView f14746s;

    /* renamed from: t */
    public ImageView f14747t;

    /* renamed from: u */
    public RelativeLayout f14748u;

    /* renamed from: v */
    public TextView f14749v;

    /* renamed from: w */
    public TextView f14750w;

    /* renamed from: x */
    public TextView f14751x;

    /* renamed from: y */
    public C10028c f14752y;

    /* renamed from: z */
    public String f14753z;

    /* renamed from: com.huawei.android.hicloud.ui.activity.DriveAppMainActivity$a */
    public class DialogInterfaceOnCancelListenerC3273a implements DialogInterface.OnCancelListener {

        /* renamed from: a */
        public String f14754a;

        public DialogInterfaceOnCancelListenerC3273a(String str) {
            this.f14754a = str;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) throws Throwable {
            C11839m.m70688i("DriveAppMainActivity", "onCancel module:" + this.f14754a);
            DriveAppMainActivity.this.f14752y.m62336h2(this.f14754a, false);
            SyncObserverServiceInvoker.getInstance().notifyDriveConfigSwitchChanged(DriveAppMainActivity.this, this.f14754a, 0);
            C13226e.m79491f1().m79599w0(false, "CLOUDBACKUP_CLOSE_DRIVE_APP_SWITCH", this.f14754a);
            DriveAppMainActivity.this.f14745r.setChecked(false);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.DriveAppMainActivity$b */
    public class DialogInterfaceOnClickListenerC3274b implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public String f14756a;

        public DialogInterfaceOnClickListenerC3274b(String str) {
            this.f14756a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) throws Throwable {
            if (-1 == i10) {
                C11839m.m70688i("DriveAppMainActivity", "positive module:" + this.f14756a);
                DriveAppMainActivity.this.f14752y.m62336h2(this.f14756a, true);
                SyncObserverServiceInvoker syncObserverServiceInvoker = SyncObserverServiceInvoker.getInstance();
                DriveAppMainActivity driveAppMainActivity = DriveAppMainActivity.this;
                syncObserverServiceInvoker.notifyDriveConfigSwitchChanged(driveAppMainActivity, driveAppMainActivity.f14753z, 1);
                C13226e.m79491f1().m79599w0(true, "CLOUDBACKUP_OPEN_DRIVE_APP_SWITCH", DriveAppMainActivity.this.f14753z);
                return;
            }
            if (-2 == i10) {
                C11839m.m70688i("DriveAppMainActivity", "negative module:" + DriveAppMainActivity.this.f14753z);
                DriveAppMainActivity.this.f14752y.m62336h2(this.f14756a, false);
                SyncObserverServiceInvoker.getInstance().notifyDriveConfigSwitchChanged(DriveAppMainActivity.this, this.f14756a, 0);
                C13226e.m79491f1().m79599w0(false, "CLOUDBACKUP_CLOSE_DRIVE_APP_SWITCH", this.f14756a);
                DriveAppMainActivity.this.f14745r.setChecked(false);
            }
        }
    }

    /* renamed from: P1 */
    private void m20392P1() {
        if (this.f14746s != null) {
            if (C0209d.m1333z1(this)) {
                this.f14746s.m23914a();
            } else {
                this.f14746s.m23919i();
            }
        }
    }

    /* renamed from: Q1 */
    private void m20393Q1() {
        this.f14745r.setCheckedProgrammatically(this.f14752y.m62388s(this.f14753z));
    }

    /* renamed from: S1 */
    private void m20394S1() {
        AlertDialogC13588a alertDialogC13588a = this.f14742B;
        if (alertDialogC13588a != null) {
            alertDialogC13588a.dismiss();
            this.f14742B = null;
        }
    }

    /* renamed from: T1 */
    private void m20395T1() {
        if (m20400X1()) {
            setContentView(R$layout.drive_app_main);
        } else {
            setContentView(R$layout.drive_app_main_land);
        }
    }

    /* renamed from: W1 */
    private void m20396W1() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.f14743p = (RelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f14748u = (RelativeLayout) C12809f.m76829b(this, R$id.illustration_image_frame);
        UnionSwitch unionSwitch = (UnionSwitch) C12809f.m76829b(this, R$id.drive_app_main_switch_btn);
        this.f14745r = unionSwitch;
        unionSwitch.setOnCheckedChangeListener(this);
        if (!C0209d.m1166E1()) {
            this.f14744q.m23909a();
        }
        this.f14749v = (TextView) C12809f.m76829b(this, R$id.drive_app_main_title);
        this.f14750w = (TextView) C12809f.m76829b(this, R$id.drive_app_describe_msg);
        this.f14751x = (TextView) C12809f.m76829b(this, R$id.drive_app_switch_title);
        this.f14747t = (ImageView) C12809f.m76829b(this, R$id.illustration_apps);
        this.f14746s = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view);
        this.f14744q = (DisableSupportedRelativeLayout) C12809f.m76829b(this, R$id.drive_app_main_switch);
        if (!C0209d.m1166E1()) {
            this.f14744q.m23909a();
        }
        if (!m20400X1()) {
            m20398U1();
        }
        mo13327n1();
    }

    /* renamed from: R1 */
    public final void m20397R1() {
        AlertDialogC13157d alertDialogC13157d = this.f14741A;
        if (alertDialogC13157d != null) {
            alertDialogC13157d.dismiss();
            this.f14741A = null;
        }
        m20394S1();
    }

    /* renamed from: U1 */
    public final void m20398U1() {
        ((WindowManager) getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        ViewGroup.LayoutParams layoutParams = this.f14748u.getLayoutParams();
        layoutParams.height = C11842p.m70758Q(this) - (C11842p.m70852q(this) * 2);
        this.f14748u.setLayoutParams(layoutParams);
    }

    /* renamed from: V1 */
    public final void m20399V1() throws Throwable {
        Bitmap bitmapM70501B;
        String str;
        String strServiceGetMultiLanguageName;
        DriveConfigService serviceById = new DriveConfigOperator().getServiceById(this.f14753z);
        String str2 = "";
        if (serviceById != null) {
            String strServiceGetMultiLanguageName2 = NotifyUtil.serviceGetMultiLanguageName(serviceById.getName());
            bitmapM70501B = C11829c.m70501B(serviceById.getSubPageIconPath());
            if (serviceById.getDriveConfigServiceResource() != null) {
                String strServiceGetMultiLanguageName3 = NotifyUtil.serviceGetMultiLanguageName(serviceById.getDriveConfigServiceResource().getSubDesc());
                strServiceGetMultiLanguageName = NotifyUtil.serviceGetMultiLanguageName(serviceById.getDriveConfigServiceResource().getSubSwitchDesc());
                str = strServiceGetMultiLanguageName3;
                str2 = strServiceGetMultiLanguageName2;
                m20401Y1(str2);
                this.f14749v.setText(str2);
                this.f14750w.setText(str);
                this.f14751x.setText(strServiceGetMultiLanguageName);
                this.f14747t.setImageDrawable(new BitmapDrawable(getResources(), bitmapM70501B));
            }
            str = "";
            str2 = strServiceGetMultiLanguageName2;
        } else {
            bitmapM70501B = null;
            str = "";
        }
        strServiceGetMultiLanguageName = str;
        m20401Y1(str2);
        this.f14749v.setText(str2);
        this.f14750w.setText(str);
        this.f14751x.setText(strServiceGetMultiLanguageName);
        this.f14747t.setImageDrawable(new BitmapDrawable(getResources(), bitmapM70501B));
    }

    /* renamed from: X1 */
    public final boolean m20400X1() {
        return !C11842p.m70753O0(this) || C11842p.m70747M0(this) || C11842p.m70771U0();
    }

    /* renamed from: Y1 */
    public void m20401Y1(String str) {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(str);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14743p);
        arrayList.add(this.f14746s);
        return arrayList;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        m22378l1();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) throws Throwable {
        if (R$id.drive_app_main_switch_btn == compoundButton.getId()) {
            C11839m.m70688i("DriveAppMainActivity", "query module:" + this.f14753z + " switchStatus:" + z10);
            this.f14752y.m62336h2(this.f14753z, z10);
            if (!z10) {
                SyncObserverServiceInvoker.getInstance().notifyDriveConfigSwitchChanged(this, this.f14753z, 0);
                C13226e.m79491f1().m79599w0(false, "CLOUDBACKUP_CLOSE_DRIVE_APP_SWITCH", this.f14753z);
                return;
            }
            AlertDialogC13588a alertDialogC13588a = new AlertDialogC13588a(this, new DialogInterfaceOnClickListenerC3274b(this.f14753z), new DialogInterfaceOnCancelListenerC3273a(this.f14753z));
            this.f14742B = alertDialogC13588a;
            alertDialogC13588a.m81741a(this.f14753z);
            SyncObserverServiceInvoker.getInstance().notifyDriveConfigSwitchChanged(this, this.f14753z, 1);
            C13226e.m79491f1().m79599w0(true, "CLOUDBACKUP_OPEN_DRIVE_APP_SWITCH", this.f14753z);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Throwable {
        new LanguagePlugin().activityInit(this);
        super.onConfigurationChanged(configuration);
        m20395T1();
        m20396W1();
        mo19005p1();
        m20399V1();
        m20392P1();
        m20393Q1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        this.f14752y = C10028c.m62182c0();
        m20395T1();
        m20396W1();
        mo19005p1();
        this.f14753z = new SafeIntent(getIntent()).getStringExtra("entry_service_id");
        m20399V1();
        m20393Q1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C11836j.m70658k().m70672o(this);
        C11842p.m70836m(this);
        m20397R1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m20392P1();
        if (!C13452e.m80781L().m80842P0()) {
            finish();
        } else {
            m20393Q1();
            C11836j.m70658k().m70659a(this);
        }
    }
}
