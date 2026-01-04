package com.huawei.android.remotecontrol.facard.p089ui.activity;

import android.app.AlertDialog;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.remotecontrol.facard.adapter.FAEditListAdapter;
import com.huawei.android.remotecontrol.facard.p089ui.widget.HiCloudRadioView;
import com.huawei.android.remotecontrol.p093ui.BaseActivity;
import com.huawei.android.remotecontrol.p093ui.webview.WapFindPhoneActivity;
import com.huawei.android.remotecontrol.sdk.R$drawable;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.android.remotecontrol.sharing.bean.ShareGrantInfo;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.uikit.hwbutton.widget.HwButton;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0210d0;
import p256ef.C9465f;
import p337hf.C10162a;
import p337hf.C10163b;
import p514o9.C11842p;
import p521og.C11868a;
import p521og.C11880m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p676ud.AlertDialogC13156c;
import p709vj.C13452e;
import p809yg.C13981a;
import p846zj.C14306d;
import sk.C12809f;
import wf.InterfaceC13596a;

/* loaded from: classes4.dex */
public class FACardEditActivity extends BaseActivity implements InterfaceC13596a {

    /* renamed from: A */
    public AlertDialog f19792A;

    /* renamed from: C */
    public List<ShareGrantInfo> f19794C;

    /* renamed from: s */
    public RecyclerView f19801s;

    /* renamed from: t */
    public FAEditListAdapter f19802t;

    /* renamed from: u */
    public RelativeLayout f19803u;

    /* renamed from: v */
    public RelativeLayout f19804v;

    /* renamed from: w */
    public ScrollView f19805w;

    /* renamed from: x */
    public LinearLayout f19806x;

    /* renamed from: y */
    public TextView f19807y;

    /* renamed from: z */
    public TextView f19808z;

    /* renamed from: r */
    public int f19800r = 1;

    /* renamed from: B */
    public ArrayList<HiCloudRadioView> f19793B = new ArrayList<>();

    /* renamed from: D */
    public String f19795D = null;

    /* renamed from: E */
    public long f19796E = -1;

    /* renamed from: F */
    public int f19797F = -1;

    /* renamed from: G */
    public boolean f19798G = false;

    /* renamed from: H */
    public boolean f19799H = false;

    /* renamed from: com.huawei.android.remotecontrol.facard.ui.activity.FACardEditActivity$a */
    public class C4342a extends AbstractC12367d {
        public C4342a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ void m26184e() {
            if (!C9465f.m59265A().m59293J() && !FACardEditActivity.this.f19798G) {
                FACardEditActivity.this.m26173Y1();
                return;
            }
            FACardEditActivity.this.m26177b2();
            FACardEditActivity.this.f19803u.setVisibility(4);
            FACardEditActivity.this.f19804v.setVisibility(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$call$0() {
            FACardEditActivity fACardEditActivity = FACardEditActivity.this;
            C11880m.m71337d(fACardEditActivity, fACardEditActivity.getResources().getString(R$string.recovery_no_data_server_error));
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            if (!C9465f.m59265A().m59294K()) {
                FACardEditActivity.this.f19798G = true;
                FACardEditActivity.this.runOnUiThread(new Runnable() { // from class: ff.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f47914a.lambda$call$0();
                    }
                });
            }
            FACardEditActivity.this.runOnUiThread(new Runnable() { // from class: ff.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f47915a.m26184e();
                }
            });
        }
    }

    /* renamed from: c2 */
    private void m26169c2() {
        this.f19803u = (RelativeLayout) C12809f.m76829b(this, R$id.init_part);
        this.f19804v = (RelativeLayout) C12809f.m76829b(this, R$id.detail_part);
        ImageView imageView = (ImageView) C12809f.m76829b(this, R$id.activity_bg);
        imageView.setImageBitmap(C10162a.m63346a(C10163b.m63347a(((BitmapDrawable) WallpaperManager.getInstance(this).getDrawable()).getBitmap()), 50, true));
        imageView.setForeground(getDrawable(R$drawable.blur_fg));
        this.f19801s = (RecyclerView) C12809f.m76829b(this, R$id.list);
        this.f19805w = (ScrollView) C12809f.m76829b(this, R$id.list_group_holder);
        this.f19806x = (LinearLayout) C12809f.m76829b(this, R$id.list_group);
        this.f19807y = (TextView) C12809f.m76829b(this, R$id.description);
        this.f19808z = (TextView) C12809f.m76829b(this, R$id.description_device);
        C12809f.m76829b(this, R$id.ic_back_layout).setPadding(0, C11842p.m70789a0(this), 0, 0);
        C12809f.m76829b(this, R$id.ic_back_hot_space).setOnClickListener(new View.OnClickListener() { // from class: ff.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f47912a.m26170f2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f2 */
    public /* synthetic */ void m26170f2(View view) {
        onBackPressed();
    }

    @Override // wf.InterfaceC13596a
    /* renamed from: S */
    public void mo26171S(View view, int i10, int i11, boolean z10) {
        if (z10) {
            ShareGrantInfo shareGrantInfo = this.f19794C.get(i10);
            this.f19795D = shareGrantInfo.getSenderUserId();
            this.f19797F = i10;
            m26177b2();
            C9465f.m59265A().m59304W(this, this.f19796E, shareGrantInfo);
        }
    }

    /* renamed from: X1 */
    public final boolean m26172X1() {
        String callingPackage = getCallingPackage();
        if (TextUtils.isEmpty(callingPackage)) {
            C13981a.m83988e("FACardEditActivity", "calling pkg name empty");
            return false;
        }
        if (callingPackage.equals(NotifyConstants.InterfaceC4908FA.PACKAGE_NAME)) {
            return C0210d0.m1338f().m1342c(this, callingPackage, "com.huawei.hidisk");
        }
        C13981a.m83988e("FACardEditActivity", "not fa pkg name");
        return false;
    }

    /* renamed from: Y1 */
    public final void m26173Y1() {
        C13981a.m83989i("FACardEditActivity", "initModeNoShare");
        this.f19800r = 0;
        m26181h2();
        setContentView(R$layout.fa_share_guide);
        ((HwButton) C12809f.m76829b(this, R$id.button_confirm)).setOnClickListener(new View.OnClickListener() { // from class: ff.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f47913a.m26179e2(view);
            }
        });
        C9465f.m59265A().m59297P(this, false);
    }

    /* renamed from: Z1 */
    public final void m26174Z1() {
        C13981a.m83989i("FACardEditActivity", "initModeNotSupport");
        this.f19800r = 3;
        m26181h2();
        setContentView(R$layout.unavailable_function_tip);
        C9465f.m59265A().m59297P(this, false);
    }

    @Override // wf.InterfaceC13596a
    /* renamed from: a */
    public void mo26175a(View view, int i10, int i11) {
        FAEditListAdapter fAEditListAdapter = this.f19802t;
        if (fAEditListAdapter == null) {
            return;
        }
        m26176a2(fAEditListAdapter.m26155F(i10));
    }

    /* renamed from: a2 */
    public final void m26176a2(String str) {
        this.f19800r = 2;
        this.f19807y.setVisibility(4);
        this.f19808z.setVisibility(0);
        this.f19801s.setVisibility(4);
        this.f19794C = C9465f.m59265A().m59292I(str);
        this.f19793B.clear();
        this.f19806x.removeAllViews();
        boolean zEquals = str.equals(this.f19795D);
        int i10 = 0;
        while (i10 < this.f19794C.size()) {
            ShareGrantInfo shareGrantInfo = this.f19794C.get(i10);
            HiCloudRadioView hiCloudRadioView = new HiCloudRadioView(this, this, i10, zEquals && i10 == this.f19797F);
            hiCloudRadioView.setText(shareGrantInfo.getSenderDeviceName());
            this.f19793B.add(hiCloudRadioView);
            this.f19806x.addView(hiCloudRadioView);
            i10++;
        }
        this.f19805w.setVisibility(0);
    }

    /* renamed from: b2 */
    public final void m26177b2() {
        this.f19800r = 1;
        m26181h2();
        if (this.f19802t == null) {
            return;
        }
        this.f19807y.setVisibility(0);
        this.f19808z.setVisibility(4);
        this.f19802t.m26160M(this.f19795D, this.f19797F);
        this.f19802t.m26156G(C9465f.m59265A().m59289F());
        this.f19802t.m26159L(this);
        this.f19801s.setLayoutManager(new LinearLayoutManager(this));
        this.f19801s.setAdapter(this.f19802t);
        this.f19801s.setVisibility(this.f19802t.mo721e() > 0 ? 0 : 4);
        this.f19805w.setVisibility(4);
        if (this.f19798G) {
            return;
        }
        C9465f.m59265A().m59297P(this, this.f19802t.mo721e() > 0);
    }

    /* renamed from: d2 */
    public final void m26178d2() {
        C13981a.m83989i("FACardEditActivity", "jumpToWapFindPhone");
        C11868a.m71128d().m71130b(WapFindPhoneActivity.class);
        Intent intent = new Intent(this, (Class<?>) WapFindPhoneActivity.class);
        C0209d.m1302r2(intent, getPackageName());
        intent.putExtra("isFromInner", true);
        intent.putExtra(RemoteMessageConst.FROM, "fromFAClick");
        intent.putExtra("isEnableJs", true);
        intent.putExtra("isSystemAcc", true);
        intent.putExtra("needShowLoading", true);
        intent.putExtra("isAddShare", true);
        startActivityForResult(intent, 8912);
        finish();
    }

    /* renamed from: e2 */
    public final /* synthetic */ void m26179e2(View view) {
        onBackPressed();
    }

    /* renamed from: g2 */
    public final void m26180g2() {
        if (this.f19800r == 3) {
            return;
        }
        AlertDialogC13156c alertDialogC13156c = new AlertDialogC13156c(this, null, R$string.alert_net_disconnect_new);
        this.f19792A = alertDialogC13156c;
        alertDialogC13156c.show();
    }

    /* renamed from: h2 */
    public final void m26181h2() {
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            View decorView = window.getDecorView();
            if (C11842p.m70732H0(this) || this.f19800r == 1) {
                decorView.setSystemUiVisibility(1280);
            } else {
                decorView.setSystemUiVisibility(9472);
            }
            decorView.setFitsSystemWindows(true);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        int i10 = this.f19800r;
        if (i10 == 2) {
            m26177b2();
            return;
        }
        if (i10 != 3 && i10 != 0) {
            finishAffinity();
            super.onBackPressed();
        } else {
            setResult(1);
            finish();
            super.onBackPressed();
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getActionBar().hide();
        try {
            this.f19796E = getIntent().getLongExtra("formId", -1L);
        } catch (Exception e10) {
            C13981a.m83988e("FACardEditActivity", "intent getLongExtra exception:" + e10.getMessage());
        }
        if (!C11842p.m70768T0(this)) {
            setRequestedOrientation(1);
        }
        if (!m26172X1()) {
            finish();
            return;
        }
        if (!C13452e.m80781L().m80842P0()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(getPackageName(), "com.huawei.android.hicloud.ui.activity.NewHiSyncSettingActivity"));
            intent.setFlags(268468224);
            startActivity(intent);
            finish();
            return;
        }
        if (!C14306d.m85207h()) {
            m26174Z1();
            return;
        }
        setContentView(R$layout.fa_edit_main);
        m26169c2();
        if (getIntent() != null && "wap".equals(getIntent().getAction())) {
            m26178d2();
        } else {
            this.f19802t = new FAEditListAdapter(this);
            this.f19799H = true;
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AlertDialog alertDialog = this.f19792A;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f19792A = null;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f19799H) {
            boolean z10 = !C0209d.m1208S0(this);
            this.f19798G = z10;
            if (!z10) {
                this.f19803u.setVisibility(0);
                this.f19804v.setVisibility(4);
                C12515a.m75110o().m75172d(new C4342a());
            } else {
                C9465f.m59265A().m59295L();
                m26177b2();
                this.f19803u.setVisibility(4);
                this.f19804v.setVisibility(0);
                m26180g2();
            }
        }
    }
}
