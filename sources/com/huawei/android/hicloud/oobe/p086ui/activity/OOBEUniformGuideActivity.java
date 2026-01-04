package com.huawei.android.hicloud.oobe.p086ui.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.hicloud.notification.manager.AdSwitchManager;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0209d;
import p015ak.C0219i;
import p422k9.C11019b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p684un.C13227f;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class OOBEUniformGuideActivity extends UniformGuideBaseActivity implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.OOBEUniformGuideActivity$a */
    public class ViewOnSystemUiVisibilityChangeListenerC2835a implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: a */
        public final /* synthetic */ Window f12456a;

        public ViewOnSystemUiVisibilityChangeListenerC2835a(Window window) {
            this.f12456a = window;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i10) {
            C11829c.m70585i1(this.f12456a);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: C0 */
    public void mo16555C0() {
        super.mo16555C0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: C2 */
    public void mo16699C2() {
        m16973e3();
        m16975f3();
        C11829c.m70582h1(this, this.f12568H0);
        C11019b.m66371t().m66419g(this);
        C13227f.m79492i1().m79560L(this, C13452e.m80781L().m80971t0());
        m16558F();
        C10028c.m62182c0().m62377p3("is_all_guide_over", true);
        C11019b.m66371t().m66381E0(this);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: D2 */
    public void mo16700D2() {
        super.mo16700D2();
    }

    /* renamed from: H3 */
    public final void m16701H3() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        C11829c.m70585i1(window);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new ViewOnSystemUiVisibilityChangeListenerC2835a(window));
        if (C0219i.m1463a() >= 27) {
            C11829c.m70630x1(this, window);
        } else {
            C11829c.m70633y1(this, window);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: Y */
    public void mo16574Y() {
        super.mo16700D2();
        AdSwitchManager.getInstance().saveAdSwitch();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: k2 */
    public void mo16702k2() {
        super.mo16702k2();
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            m16976h3(true);
        }
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.oobe_start_main_frame);
        if (C0219i.m1463a() < 27 || relativeLayout == null) {
            return;
        }
        C11842p.m70811f2(relativeLayout, C11842p.m70864t(this));
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: l0 */
    public void mo16596l0() {
        super.mo16596l0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f12350j.m17063m();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (C0209d.m1198P(this) && !this.f12358r && C0209d.m1200P1(this)) {
            C11839m.m70688i("OOBEUniformGuideActivity", "setLaterStatus auto close ");
            setResult(-1);
            finish();
        }
        this.f12350j.m17061k();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: u0 */
    public void mo16613u0() {
        if (C0209d.m1269j1()) {
            m16701H3();
        } else {
            m16603p0();
        }
    }
}
