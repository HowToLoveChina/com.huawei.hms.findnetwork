package com.huawei.android.hicloud.p088ui.activity;

import android.accounts.OperationCanceledException;
import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.view.View;
import android.widget.LinearLayout;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.oobe.p086ui.activity.SimplifyOOBEQueryinfoActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import mc.C11436a;
import p015ak.C0209d;
import p514o9.C11839m;
import p514o9.C11842p;
import p674ub.C13149f;
import p684un.C13222a;
import p709vj.C13452e;
import p742wj.C13612b;
import sk.C12809f;

/* loaded from: classes3.dex */
public class PhoneFinderWelcomeActivity extends WelcomeBaseActivity {

    /* renamed from: i1 */
    public String f15803i1;

    /* renamed from: j1 */
    public NotchTopFitRelativeLayout f15804j1 = null;

    /* renamed from: k1 */
    public C13149f f15805k1 = new C13149f();

    public static class WelcomeFinishResultReceiver extends ResultReceiver {

        /* renamed from: a */
        public final Handler f15806a;

        public WelcomeFinishResultReceiver(WeakReference<Handler> weakReference) {
            super(weakReference.get());
            this.f15806a = weakReference.get();
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i10, Bundle bundle) {
            if (this.f15806a == null) {
                C11839m.m70688i("PhoneFinderWelcomeActivity", "handler is null");
            } else if (1 == i10) {
                C11839m.m70686d("PhoneFinderWelcomeActivity", "phonefinderwelcomactivity finish");
                this.f15806a.sendEmptyMessage(9);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.PhoneFinderWelcomeActivity$a */
    public class RunnableC3444a implements Runnable {
        public RunnableC3444a() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            PhoneFinderWelcomeActivity.this.finish();
        }
    }

    /* renamed from: Z3 */
    private boolean m21952Z3() {
        if (!C13452e.m80781L().m80803F0().booleanValue()) {
            this.f15805k1.m79065c(this, getIntent(), C13222a.m79465g(this));
        }
        this.f16411n0 = new WelcomeFinishResultReceiver(new WeakReference(this.f16402h1));
        m22647i2();
        m22671u1();
        m22640d3();
        m21958a4();
        m22651k2();
        m22645h2();
        if (!this.f16344E0) {
            m22655m3();
            return false;
        }
        C11839m.m70686d("PhoneFinderWelcomeActivity", "logout is processing");
        m22593F3();
        return false;
    }

    /* renamed from: b4 */
    private void m21953b4() {
        C13612b.m81829B().m81856U(this, this);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: B3 */
    public void mo21954B3() {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: C1 */
    public void mo21666C1() {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: C2 */
    public void mo21955C2(int i10, int i11, int i12, int i13) {
        super.mo21955C2(i10, i11, i12, i13);
        C11842p.m70827j2(this.f16420s, 0);
        LinearLayout linearLayout = this.f16377V;
        if (linearLayout != null) {
            linearLayout.setVisibility(i13);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: E2 */
    public void mo21667E2() {
        C11839m.m70686d("PhoneFinderWelcomeActivity", "loginProcess");
        mo21956I3();
        if (C11842p.m70774V0(this)) {
            C13612b.m81829B().m81856U(this, this);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: I3 */
    public void mo21956I3() {
        if (isFinishing()) {
            C11839m.m70687e("PhoneFinderWelcomeActivity", "showDialog activity is finished");
            return;
        }
        if (this.f16347G == null) {
            this.f16347G = new ProgressDialog(this);
        }
        if (this.f16347G.isShowing()) {
            return;
        }
        this.f16347G.setMessage(getResources().getString(R$string.wait_loging));
        this.f16347G.setCancelable(false);
        this.f16347G.show();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: M1 */
    public void mo20569M1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.mo20569M1();
        C11839m.m70686d("PhoneFinderWelcomeActivity", "finish self");
        finish();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: O2 */
    public void mo20682O2() {
        super.mo20682O2();
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            this.f15805k1.m79065c(this, getIntent(), C13222a.m79465g(this));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: V2 */
    public void mo21957V2() {
        C11839m.m70688i("PhoneFinderWelcomeActivity", "goto obtain config");
        Intent intent = new Intent(this, (Class<?>) SimplifyOOBEQueryinfoActivity.class);
        this.f16432y = 3;
        intent.putExtra(RemoteMessageConst.FROM, this.f15803i1);
        intent.putExtra(FamilyShareConstants.ENTRY_TYPE, this.f16432y);
        startActivityForResult(intent, 10014);
        m22635a2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.CommonActivity
    /* renamed from: X0 */
    public List<View> mo18477X0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15804j1);
        arrayList.add(this.f16420s);
        return arrayList;
    }

    /* renamed from: a4 */
    public final void m21958a4() {
        Intent intent = getIntent();
        if (intent != null) {
            try {
                this.f15803i1 = intent.getStringExtra(RemoteMessageConst.FROM);
            } catch (RuntimeException unused) {
                C11839m.m70688i("PhoneFinderWelcomeActivity", "intent Serializable error.");
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: c2 */
    public void mo21959c2() {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, p709vj.InterfaceC13449b
    /* renamed from: e */
    public void mo13829e(OperationCanceledException operationCanceledException) {
        super.mo13829e(operationCanceledException);
        if (C11842p.m70774V0(this)) {
            return;
        }
        this.f16402h1.postDelayed(new RunnableC3444a(), 200L);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: e2 */
    public void mo21960e2() {
        setContentView(R$layout.new_welcom_layout);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R$string.start_finder_phone_new);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, android.app.Activity
    public void finish() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.finish();
        new HwAnimationReflection(this).m15927c(2);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: g2 */
    public void mo21961g2() {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: l2 */
    public void mo21962l2() {
        this.f15804j1 = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.phonefinder_welcome_notch_layout);
        this.f16377V = (LinearLayout) C12809f.m76829b(this, R$id.welcome_frame);
        this.f16420s = C12809f.m76829b(this, R$id.query_failed_frame);
        this.f16422t = (SpanClickText) C12809f.m76829b(this, R$id.query_failed_email);
        this.f16335A = (LinearLayout) C12809f.m76829b(this, R$id.query_info_layout);
        HwButton hwButton = (HwButton) C12809f.m76829b(this, R$id.start_button);
        this.f16418r = hwButton;
        hwButton.setOnClickListener(this);
        m18479Z0();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (SystemClock.elapsedRealtime() - this.f16430x < 1500) {
            C11839m.m70689w("PhoneFinderWelcomeActivity", "click the start button twice too fast");
            return;
        }
        super.onClick(view);
        this.f16430x = SystemClock.elapsedRealtime();
        if (view.getId() == R$id.start_button) {
            m21953b4();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (C0209d.m1173G1(this)) {
            C11839m.m70688i("PhoneFinderWelcomeActivity", "onConfigurationChanged(), isPrivacyUser, now exit Cloud!");
            m22602L3();
            return;
        }
        m22651k2();
        m22645h2();
        m22599J3();
        if (this.f16415p0) {
            m22591E3();
        }
        m22594G3();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C11839m.m70688i("PhoneFinderWelcomeActivity", "onCreate");
        if (C13452e.m80781L().m80912f1()) {
            C11839m.m70687e("PhoneFinderWelcomeActivity", "site not match");
            C11436a.m68492d().m68499h(this);
            finish();
        } else if (C0209d.m1173G1(this)) {
            C11839m.m70688i("PhoneFinderWelcomeActivity", "isPrivacyUser, now exit Cloud!");
            m22602L3();
        } else {
            if (m21952Z3()) {
                return;
            }
            m22642f2();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f16411n0 = null;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C11839m.m70688i("PhoneFinderWelcomeActivity", "onNewIntent");
        setIntent(intent);
        m21952Z3();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
