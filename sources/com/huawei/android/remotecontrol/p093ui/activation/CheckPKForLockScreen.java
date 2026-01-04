package com.huawei.android.remotecontrol.p093ui.activation;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import bf.C1175a;
import com.huawei.android.remotecontrol.sdk.R$color;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.android.remotecontrol.util.NewHiSyncUtil;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.util.Timer;
import java.util.TimerTask;
import p520of.C11860j;
import p664u0.C13108a;
import p681uj.C13195l;
import p684un.C13230i;
import p709vj.C13452e;
import p709vj.InterfaceC13451d;
import p809yg.C13981a;
import p815ym.AbstractC14027b;
import sk.C12809f;

/* loaded from: classes4.dex */
public class CheckPKForLockScreen extends Activity {

    /* renamed from: a */
    public int f20664a;

    /* renamed from: b */
    public C4505d f20665b;

    /* renamed from: c */
    public Timer f20666c;

    /* renamed from: d */
    public NewHiSyncUtil f20667d;

    /* renamed from: e */
    public long f20668e;

    /* renamed from: g */
    public RelativeLayout f20670g;

    /* renamed from: h */
    public RelativeLayout f20671h;

    /* renamed from: f */
    public String f20669f = "";

    /* renamed from: i */
    public final InterfaceC13451d f20672i = new C4504c();

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.CheckPKForLockScreen$a */
    public class C4502a implements NewHiSyncUtil.InterfaceC4549c {
        public C4502a() {
        }

        @Override // com.huawei.android.remotecontrol.util.NewHiSyncUtil.InterfaceC4549c
        /* renamed from: a */
        public void mo27197a() {
            try {
                boolean zM80799E0 = C13452e.m80781L().m80799E0();
                C13195l c13195lM79272J = C13195l.m79272J();
                CheckPKForLockScreen checkPKForLockScreen = CheckPKForLockScreen.this;
                c13195lM79272J.m79326p(checkPKForLockScreen, 8909, zM80799E0, null, checkPKForLockScreen.f20672i);
            } catch (Exception e10) {
                C13981a.m83988e("CheckPKForLockScreen", "checkHwIdPasswordV2 error." + e10.getMessage());
            }
            C13230i.m79504I().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", "CheckPKForLockScreen", "set lock screen report pk:check password");
        }

        @Override // com.huawei.android.remotecontrol.util.NewHiSyncUtil.InterfaceC4549c
        /* renamed from: b */
        public void mo27198b() {
            CheckPKForLockScreen.this.m27461p();
            C13230i.m79504I().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", "CheckPKForLockScreen", "set lock screen report pk:check password cancel");
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.CheckPKForLockScreen$b */
    public class C4503b extends TimerTask {
        public C4503b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C13981a.m83989i("CheckPKForLockScreen", "pk update overtime, exit activity");
            C11860j.m71002J0("updatePKFromLockscreen", "updatePK", "pk update overtime, exit activity", null);
            CheckPKForLockScreen.this.m27456k();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.CheckPKForLockScreen$c */
    public class C4504c implements InterfaceC13451d {
        public C4504c() {
        }

        @Override // p709vj.InterfaceC13451d
        /* renamed from: a */
        public void mo17021a(ErrorStatus errorStatus) {
            C13981a.m83988e("CheckPKForLockScreen", "Account on error callback");
            CheckPKForLockScreen.this.m27456k();
        }

        @Override // p709vj.InterfaceC13451d
        /* renamed from: b */
        public void mo17022b(String str) {
            C13981a.m83989i("CheckPKForLockScreen", "Account on finish callback");
            C11860j.m71061i1(1, CheckPKForLockScreen.this.f20669f, str);
            CheckPKForLockScreen.this.m27456k();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.CheckPKForLockScreen$d */
    public class C4505d extends BroadcastReceiver {

        /* renamed from: a */
        public final CheckPKForLockScreen f20676a;

        public C4505d(CheckPKForLockScreen checkPKForLockScreen) {
            this.f20676a = checkPKForLockScreen;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C13981a.m83988e("CheckPKForLockScreen", "mLogoffReceiver intent is null");
                return;
            }
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            String action = hiCloudSafeIntent.getAction();
            if (action == null) {
                C13981a.m83988e("CheckPKForLockScreen", "mLogoffReceiver action is null");
                return;
            }
            this.f20676a.m27455j();
            int intExtra = hiCloudSafeIntent.getIntExtra(MapKeyNames.RESULT_CODE, -1);
            String str = "pk update result received, action = " + action + ", errorCode: " + intExtra;
            C13981a.m83989i("CheckPKForLockScreen", str + ", cost " + (System.currentTimeMillis() - CheckPKForLockScreen.this.f20668e) + "ms");
            C11860j.m71002J0("updatePKFromLockscreen", "updatePK", str, String.valueOf(System.currentTimeMillis() - CheckPKForLockScreen.this.f20668e));
            if (3211 != intExtra || this.f20676a.f20664a != 0) {
                this.f20676a.m27456k();
                return;
            }
            C13981a.m83989i("CheckPKForLockScreen", "timed out for 10 min, checkHwIdPassword");
            CheckPKForLockScreen.this.m27462q();
            CheckPKForLockScreen.this.f20669f = hiCloudSafeIntent.getStringExtra("publicKeyStr");
        }
    }

    /* renamed from: j */
    public void m27455j() {
        Timer timer = this.f20666c;
        if (timer != null) {
            timer.cancel();
            this.f20666c = null;
        }
    }

    /* renamed from: k */
    public final void m27456k() {
        AbstractC14027b.m84163b(new Runnable() { // from class: hg.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f49501a.m27460o();
            }
        });
    }

    /* renamed from: l */
    public final String m27457l(int i10) {
        Resources resources = getResources();
        if (resources == null) {
            return null;
        }
        return resources.getString(i10);
    }

    /* renamed from: m */
    public final void m27458m() {
        View decorView;
        Window window = getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setBackgroundResource(R$color.transparent);
        RelativeLayout relativeLayout = this.f20670g;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    /* renamed from: n */
    public final void m27459n() {
        getWindow().setStatusBarColor(getColor(R$color.hicloud_hmos_bg));
        getWindow().getDecorView().setBackgroundResource(R$color.pay_activity_harmony_bg);
        setContentView(R$layout.update_pk_layout);
        this.f20670g = (RelativeLayout) C12809f.m76829b(this, R$id.main_layout);
        this.f20671h = (RelativeLayout) C12809f.m76829b(this, R$id.loading_layout);
        if (getActionBar() != null) {
            getActionBar().hide();
        }
    }

    /* renamed from: o */
    public final /* synthetic */ void m27460o() {
        m27458m();
        RelativeLayout relativeLayout = this.f20670g;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        if (isFinishing() || isDestroyed()) {
            return;
        }
        setResult(-1);
        finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 8909) {
            C13195l.m79272J().m79298N(this, this.f20672i, i11, intent);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m27459n();
        this.f20667d = new NewHiSyncUtil(this);
        try {
            this.f20664a = new HiCloudSafeIntent(getIntent()).getIntExtra("changeType", -1);
        } catch (Throwable th2) {
            C13981a.m83989i("CheckPKForLockScreen", "catch error " + th2.getMessage());
        }
        this.f20665b = new C4505d(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("pkUpdateSucceed");
        intentFilter.addAction("pkUpdateFailed");
        C13108a.m78878b(this).m78880c(this.f20665b, intentFilter);
        C13981a.m83989i("CheckPKForLockScreen", "receive changeType " + this.f20664a);
        int i10 = this.f20664a;
        if (i10 == 0) {
            if (C1175a.m7390l(getApplicationContext(), C13452e.m80781L().m80971t0())) {
                this.f20668e = System.currentTimeMillis();
                C11860j.m71058h1(1, null);
                Timer timer = new Timer();
                this.f20666c = timer;
                timer.schedule(new C4503b(), 5000L);
            } else {
                C13981a.m83989i("CheckPKForLockScreen", "phone finder switch not opened");
                m27461p();
            }
        } else if (i10 != 1) {
            m27456k();
        } else {
            C11860j.m71058h1(0, null);
            m27456k();
        }
        C13230i.m79504I().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", "CheckPKForLockScreen", "set lock screen report pk");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        C11860j.m71002J0("updatePKFromLockscreen", "updatePK", "CheckPKForLockScreen onDestroy", String.valueOf(System.currentTimeMillis() - this.f20668e));
        m27455j();
        if (this.f20665b != null) {
            C13108a.m78878b(this).m78883f(this.f20665b);
            this.f20665b = null;
        }
        NewHiSyncUtil newHiSyncUtil = this.f20667d;
        if (newHiSyncUtil != null) {
            newHiSyncUtil.m27970a();
            this.f20667d = null;
        }
        super.onDestroy();
    }

    /* renamed from: p */
    public final void m27461p() {
        m27455j();
        m27456k();
    }

    /* renamed from: q */
    public final void m27462q() {
        if (this.f20667d == null) {
            C13981a.m83988e("CheckPKForLockScreen", "newHiSyncActivityUtil is null");
            m27461p();
            return;
        }
        RelativeLayout relativeLayout = this.f20671h;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        m27458m();
        this.f20667d.m27971b(this, m27457l(R$string.phonefinder_title_verify_id_passwd), m27457l(R$string.phonefinder_content_verify_id_passwd), m27457l(R$string.phonefinder_verify_now), m27457l(R$string.phonefinder_verify_later), new C4502a());
        C13230i.m79504I().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", "CheckPKForLockScreen", "set lock screen report pk:check password dialog");
    }
}
