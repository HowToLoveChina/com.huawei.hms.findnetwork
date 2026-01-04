package com.huawei.android.hicloud.oobe.p086ui.activity;

import ac.C0089a;
import ac.C0090b;
import ac.C0091c;
import ac.C0092d;
import ac.C0093e;
import ac.C0094f;
import ac.C0095g;
import ac.C0096h;
import ac.C0097i;
import ac.C0098j;
import android.accounts.OperationCanceledException;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$string;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBENavLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBETopView;
import com.huawei.android.hicloud.p088ui.extend.NotchBottomFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitOOBENavLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import fk.C9721b;
import hu.C10343b;
import huawei.android.widget.HwToolbar;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0219i;
import p015ak.C0234s;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p681uj.C13195l;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.InterfaceC13449b;
import sk.C12806c;
import sk.C12808e;
import sk.C12809f;

/* loaded from: classes3.dex */
public abstract class OOBEBaseActivity extends Activity implements View.OnClickListener, InterfaceC13449b {

    /* renamed from: d */
    public boolean f12344d;

    /* renamed from: f */
    public int f12346f;

    /* renamed from: g */
    public int f12347g;

    /* renamed from: h */
    public C0089a f12348h;

    /* renamed from: i */
    public RelativeLayout f12349i;

    /* renamed from: j */
    public OOBETopView f12350j;

    /* renamed from: k */
    public OOBENavLayout f12351k;

    /* renamed from: l */
    public NotchFitOOBENavLinearLayout f12352l;

    /* renamed from: m */
    public NotchBottomFitRelativeLayout f12353m;

    /* renamed from: n */
    public NotchTopFitRelativeLayout f12354n;

    /* renamed from: o */
    public NotchFitLinearLayout f12355o;

    /* renamed from: p */
    public NotchFitRelativeLayout f12356p;

    /* renamed from: q */
    public int f12357q;

    /* renamed from: t */
    public boolean f12360t;

    /* renamed from: v */
    public long f12362v;

    /* renamed from: w */
    public HwToolbar f12363w;

    /* renamed from: x */
    public HwButton f12364x;

    /* renamed from: y */
    public HwButton f12365y;

    /* renamed from: z */
    public View f12366z;

    /* renamed from: a */
    public int f12341a = 1;

    /* renamed from: b */
    public String f12342b = FaqConstants.DISABLE_HA_REPORT;

    /* renamed from: c */
    public boolean f12343c = false;

    /* renamed from: e */
    public boolean f12345e = false;

    /* renamed from: r */
    public boolean f12358r = false;

    /* renamed from: s */
    public boolean f12359s = false;

    /* renamed from: u */
    public List<View> f12361u = new ArrayList();

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.OOBEBaseActivity$a */
    public class ViewOnSystemUiVisibilityChangeListenerC2816a implements View.OnSystemUiVisibilityChangeListener {
        public ViewOnSystemUiVisibilityChangeListenerC2816a() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i10) {
            C11829c.m70585i1(OOBEBaseActivity.this.getWindow());
            C11829c.m70633y1(OOBEBaseActivity.this.getApplicationContext(), OOBEBaseActivity.this.getWindow());
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.OOBEBaseActivity$b */
    public class ViewOnSystemUiVisibilityChangeListenerC2817b implements View.OnSystemUiVisibilityChangeListener {
        public ViewOnSystemUiVisibilityChangeListenerC2817b() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i10) {
            C11829c.m70585i1(OOBEBaseActivity.this.getWindow());
            C11829c.m70633y1(OOBEBaseActivity.this.getApplicationContext(), OOBEBaseActivity.this.getWindow());
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.OOBEBaseActivity$c */
    public class ViewOnSystemUiVisibilityChangeListenerC2818c implements View.OnSystemUiVisibilityChangeListener {
        public ViewOnSystemUiVisibilityChangeListenerC2818c() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i10) {
            C11829c.m70588j1(OOBEBaseActivity.this.getWindow());
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.OOBEBaseActivity$d */
    public class ViewOnClickListenerC2819d implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ TextView f12370a;

        public ViewOnClickListenerC2819d(TextView textView) {
            this.f12370a = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextView textView = this.f12370a;
            if (textView != null) {
                OOBEBaseActivity.this.mo16592j0(textView);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.OOBEBaseActivity$e */
    public class C2820e extends AbstractC12367d {
        public C2820e() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws InterruptedException, C9721b {
            C13230i.m79545v();
            OOBEBaseActivity oOBEBaseActivity = OOBEBaseActivity.this;
            if (oOBEBaseActivity.f12358r || !C0209d.m1200P1(oOBEBaseActivity)) {
                return;
            }
            C13227f.m79492i1().m79561L0("20");
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.OOBEBaseActivity$f */
    public class ViewOnSystemUiVisibilityChangeListenerC2821f implements View.OnSystemUiVisibilityChangeListener {
        public ViewOnSystemUiVisibilityChangeListenerC2821f() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i10) {
            C11829c.m70585i1(OOBEBaseActivity.this.getWindow());
            C11829c.m70627w1(OOBEBaseActivity.this.getApplicationContext(), OOBEBaseActivity.this.getWindow());
        }
    }

    /* renamed from: x */
    private void m16549x() throws IllegalAccessException, IllegalArgumentException {
        View decorView;
        if (C0219i.m1463a() < 17 || !C11829c.m70563b0(this)) {
            return;
        }
        C11829c.m70591k1(this);
        Window window = getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1024);
    }

    /* renamed from: A */
    public void mo16550A() {
    }

    /* renamed from: A0 */
    public void mo16551A0() {
        C0089a c0089a = this.f12348h;
        if (c0089a != null) {
            c0089a.mo697j(this, this.f12350j, this.f12349i, this.f12351k);
        }
    }

    /* renamed from: B */
    public void mo16552B() {
    }

    /* renamed from: B0 */
    public void mo16553B0() {
        if (C11842p.m70759Q0() || this.f12341a == 2) {
            setRequestedOrientation(1);
        }
    }

    /* renamed from: C */
    public void mo16554C() {
    }

    /* renamed from: C0 */
    public abstract void mo16555C0();

    /* renamed from: D */
    public void mo16556D() {
        this.f12365y = (HwButton) findViewById(R$id.open_cloud_button);
        this.f12364x = (HwButton) findViewById(R$id.open_later);
        HwButton hwButton = this.f12365y;
        if (hwButton != null) {
            hwButton.setText(R$string.cloud_oobe_open_and_proceed);
        }
        View viewFindViewById = findViewById(R$id.open_or_later_frame);
        this.f12366z = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(this.f12363w != null ? 0 : 8);
        }
    }

    /* renamed from: E */
    public void m16557E() {
        List<View> listMo16610t = mo16610t();
        List<List<View>> listM70887y2 = C11842p.m70887y2(listMo16610t);
        if (C0219i.m1463a() >= 17 && C11829c.m70563b0(this)) {
            C12806c.m76821l(this, listMo16610t);
            C12806c.m76820k(this, listM70887y2.get(1));
        }
        m16594k0(listM70887y2.get(0));
        C12806c.m76820k(this, listM70887y2.get(0));
    }

    /* renamed from: F */
    public void m16558F() {
        C12515a.m75110o().m75172d(new C2820e());
    }

    /* renamed from: G */
    public void mo16559G() throws Resources.NotFoundException {
        this.f12349i = (RelativeLayout) C12809f.m76829b(this, R$id.oobe_start_main_frame);
        this.f12350j = (OOBETopView) C12809f.m76829b(this, R$id.oobe_start_top_frame);
        this.f12351k = (OOBENavLayout) C12809f.m76829b(this, R$id.oobe_nav_layout);
        this.f12352l = (NotchFitOOBENavLinearLayout) C12809f.m76829b(this, R$id.notch_fit_oobe_nav);
        this.f12353m = (NotchBottomFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_bottom_frame);
        this.f12354n = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_top_uniform_guide_frame);
        this.f12355o = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.oobe_nav_layout_frame);
        this.f12356p = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_oobe_start_main_frame);
        this.f12351k.setBackBtnClickListener(this);
        this.f12351k.setNextBtnClickListener(this);
        if (this.f12350j == null || !m16581d0() || m16593k() == null) {
            return;
        }
        this.f12350j.m17062l();
    }

    /* renamed from: H */
    public final void m16560H() {
        if (C0219i.m1463a() <= 14) {
            mo16561I();
            return;
        }
        if (C0219i.m1463a() >= 15 && C0219i.m1463a() < 17) {
            mo16562J();
        } else if (C0219i.m1463a() < 17 || C0219i.m1463a() >= 21) {
            mo16564M();
        } else {
            mo16563K();
        }
    }

    /* renamed from: I */
    public void mo16561I() {
    }

    /* renamed from: J */
    public void mo16562J() {
    }

    /* renamed from: K */
    public void mo16563K() {
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: L */
    public void mo13808L(Exception exc) {
    }

    /* renamed from: M */
    public void mo16564M() {
    }

    /* renamed from: N */
    public void m16565N() {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        Bundle extras = hiCloudSafeIntent.getExtras();
        this.f12342b = hiCloudSafeIntent.m29113i("is_password_verify_finished", FaqConstants.DISABLE_HA_REPORT);
        this.f12344d = hiCloudSafeIntent.getBooleanExtra("is_phone_finder_already_open", false);
        this.f12343c = hiCloudSafeIntent.getBooleanExtra("is_from_phonefinder_guide", false);
        this.f12359s = hiCloudSafeIntent.getBooleanExtra("is_from_oobe_recover", false);
        this.f12360t = hiCloudSafeIntent.getBooleanExtra("intent_from_settings", false);
        C11839m.m70686d("OOBEBaseActivity", "isHwIdPasswordVerified: " + this.f12342b + "isFromSetting: " + this.f12360t);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("mIsFromPhoneFinderGuide: ");
        sb2.append(this.f12343c);
        C11839m.m70686d("OOBEBaseActivity", sb2.toString());
        if (extras == null) {
            C11839m.m70687e("OOBEBaseActivity", "intEntryType，bundle is null");
            return;
        }
        C10343b c10343b = new C10343b(extras);
        this.f12341a = c10343b.m63687i(FamilyShareConstants.ENTRY_TYPE, 1);
        this.f12358r = c10343b.m63682d("is_from_mr_guide", false);
        this.f12345e = c10343b.m63682d(FamilyShareConstants.OPEN_FAMILY_SPACE_SHARE, false);
        this.f12346f = c10343b.m63687i("space_share_entry_type", -1);
        this.f12347g = c10343b.m63687i(FamilyShareConstants.EXTRA_KEY, -1);
        C11839m.m70688i("OOBEBaseActivity", "mEntryType=" + this.f12341a + "isFromOOBEBackup=" + this.f12359s);
        C11839m.m70686d("OOBEBaseActivity", "mOpenFamilySpaceShare: " + this.f12345e + this.f12346f + this.f12347g);
    }

    /* renamed from: O */
    public void mo16566O() {
        C0089a c0089aM16595l = m16595l();
        this.f12348h = c0089aM16595l;
        if (c0089aM16595l == null) {
            C11839m.m70687e("OOBEBaseActivity", "mLayoutHelper null");
            return;
        }
        Resources resources = getResources();
        if (resources == null) {
            C11839m.m70687e("OOBEBaseActivity", "resources null");
            return;
        }
        Configuration configuration = resources.getConfiguration();
        if (configuration == null) {
            C11839m.m70687e("OOBEBaseActivity", "configuration null");
        } else {
            mo16567P(configuration);
        }
    }

    /* renamed from: P */
    public void mo16567P(Configuration configuration) {
        if (C11842p.m70771U0() && !isInMultiWindowMode()) {
            if (configuration.orientation == 2) {
                this.f12348h.mo693f(this, this.f12350j, this.f12349i);
                if (mo16579c0()) {
                    this.f12348h.mo694g(this);
                }
            } else {
                this.f12348h.mo695h(this, this.f12350j, this.f12349i);
                if (mo16579c0()) {
                    this.f12348h.mo696i(this);
                }
            }
            mo16622z0();
            return;
        }
        if (C11842p.m70747M0(this)) {
            if (configuration.orientation == 2) {
                this.f12348h.mo689b(this, this.f12350j, this.f12349i, this.f12351k);
            } else {
                this.f12348h.mo690c(this, this.f12350j, this.f12349i, this.f12351k);
            }
            mo16609s0();
            return;
        }
        if (isInMultiWindowMode()) {
            this.f12348h.mo692e(this);
            mo16551A0();
        } else {
            if (configuration.orientation == 2) {
                this.f12348h.mo698k();
            } else {
                this.f12348h.mo699l();
            }
            mo16551A0();
        }
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: Q */
    public boolean mo13814Q(Bundle bundle) {
        return false;
    }

    /* renamed from: R */
    public void mo16568R() {
        if (C0219i.m1463a() <= 14) {
            mo16570T();
            return;
        }
        if (C0219i.m1463a() >= 15 && C0219i.m1463a() < 17) {
            mo16571U();
        } else if (C0219i.m1463a() < 17 || C0219i.m1463a() >= 21) {
            mo16569S();
        } else {
            mo16572V();
        }
    }

    /* renamed from: S */
    public abstract void mo16569S();

    /* renamed from: T */
    public abstract void mo16570T();

    /* renamed from: U */
    public abstract void mo16571U();

    /* renamed from: V */
    public abstract void mo16572V();

    @Override // p709vj.InterfaceC13449b
    /* renamed from: W */
    public void mo13820W(Bundle bundle) {
    }

    /* renamed from: X */
    public void mo16573X() {
        if (C0219i.m1463a() <= 14) {
            mo16575Z();
            return;
        }
        if (C0219i.m1463a() >= 15 && C0219i.m1463a() < 17) {
            mo16576a0();
        } else if (C0219i.m1463a() < 17 || C0219i.m1463a() >= 21) {
            mo16574Y();
        } else {
            mo16577b0();
        }
    }

    /* renamed from: Y */
    public abstract void mo16574Y();

    /* renamed from: Z */
    public abstract void mo16575Z();

    /* renamed from: a0 */
    public abstract void mo16576a0();

    /* renamed from: b0 */
    public abstract void mo16577b0();

    /* renamed from: c */
    public abstract int mo16578c();

    /* renamed from: c0 */
    public boolean mo16579c0() {
        return false;
    }

    /* renamed from: d */
    public int mo16580d() {
        return C0219i.m1463a() <= 14 ? mo16587h() : (C0219i.m1463a() < 15 || C0219i.m1463a() >= 17) ? (C0219i.m1463a() < 17 || C0219i.m1463a() >= 21) ? (C0219i.m1463a() < 21 || C0219i.m1463a() >= 23) ? (C0219i.m1463a() < 23 || C0219i.m1463a() >= 27) ? mo16578c() : mo16585g() : mo16583f() : mo16591j() : mo16589i();
    }

    /* renamed from: d0 */
    public boolean m16581d0() {
        return this.f12341a == 1 && C0219i.m1465c() && !this.f12358r;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: e */
    public void mo13829e(OperationCanceledException operationCanceledException) {
    }

    /* renamed from: e0 */
    public final void m16582e0(View view) {
        if (C0219i.m1463a() <= 14) {
            mo16586g0(view);
            return;
        }
        if (C0219i.m1463a() >= 15 && C0219i.m1463a() < 17) {
            mo16588h0(view);
        } else if (C0219i.m1463a() < 17 || C0219i.m1463a() >= 21) {
            mo16584f0(view);
        } else {
            mo16590i0(view);
        }
    }

    /* renamed from: f */
    public abstract int mo16583f();

    /* renamed from: f0 */
    public abstract void mo16584f0(View view);

    /* renamed from: g */
    public abstract int mo16585g();

    /* renamed from: g0 */
    public abstract void mo16586g0(View view);

    /* renamed from: h */
    public abstract int mo16587h();

    /* renamed from: h0 */
    public abstract void mo16588h0(View view);

    /* renamed from: i */
    public abstract int mo16589i();

    /* renamed from: i0 */
    public abstract void mo16590i0(View view);

    /* renamed from: j */
    public abstract int mo16591j();

    /* renamed from: j0 */
    public void mo16592j0(TextView textView) {
    }

    /* renamed from: k */
    public final HwToolbar m16593k() {
        if (this.f12363w == null) {
            this.f12363w = findViewById(R$id.hwtoolbar);
        }
        return this.f12363w;
    }

    /* renamed from: k0 */
    public void m16594k0(List<View> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f12361u.addAll(list);
    }

    /* renamed from: l */
    public final C0089a m16595l() {
        return C0219i.m1463a() <= 14 ? mo16602p() : (C0219i.m1463a() < 15 || C0219i.m1463a() >= 17) ? (C0219i.m1463a() < 17 || C0219i.m1463a() >= 21) ? C0219i.m1463a() < 23 ? m16598n() : (C0219i.m1463a() < 23 || C0219i.m1463a() >= 27) ? (!m16581d0() || m16593k() == null) ? m16597m() : m16608s() : m16600o() : m16606r() : mo16604q();
    }

    /* renamed from: l0 */
    public abstract void mo16596l0();

    /* renamed from: m */
    public C0089a m16597m() {
        return this.f12341a == 1 ? new C0097i() : new C0098j();
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: m0 */
    public void mo13838m0(Bundle bundle) {
    }

    /* renamed from: n */
    public C0089a m16598n() {
        return this.f12341a == 1 ? new C0094f() : new C0098j();
    }

    /* renamed from: n0 */
    public void mo16599n0() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /* renamed from: o */
    public C0089a m16600o() {
        return this.f12341a == 1 ? new C0095g() : new C0098j();
    }

    /* renamed from: o0 */
    public void m16601o0(int i10) {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(i10));
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 8701) {
            C13195l.m79272J().m79299O(this, this, i10, i11, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        if (view.getId() == R$id.oobe_nav_back_layout) {
            mo16568R();
        } else if (view.getId() == R$id.oobe_nav_next_layout || view.getId() == R$id.open_cloud_button) {
            mo16573X();
        }
        m16582e0(view);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C0234s.m1639q(this);
        super.onConfigurationChanged(configuration);
        mo16566O();
        mo16605q0();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        this.f12357q = C0219i.m1463a();
        setContentView(mo16580d());
        mo16596l0();
        m16565N();
        mo16599n0();
        m16549x();
        C12808e.m76822a(this);
        mo16620y0();
        mo16559G();
        m16557E();
        m16560H();
        mo16566O();
        mo16619y();
        mo16618x0();
        mo16553B0();
        m16616w();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        mo16555C0();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // android.app.Activity
    public void onResume() {
        this.f12362v = System.currentTimeMillis();
        super.onResume();
        mo16613u0();
    }

    /* renamed from: p */
    public C0089a mo16602p() {
        return new C0092d();
    }

    /* renamed from: p0 */
    public void m16603p0() {
        boolean z10 = !this.f12358r && C0209d.m1200P1(this);
        if (C0219i.m1463a() < 27) {
            m16615v0();
            return;
        }
        if (1 != this.f12341a || z10) {
            C11829c.m70624v1(this, getWindow());
            return;
        }
        C11829c.m70585i1(getWindow());
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new ViewOnSystemUiVisibilityChangeListenerC2821f());
        C11829c.m70627w1(this, getWindow());
    }

    /* renamed from: q */
    public C0089a mo16604q() {
        return this.f12341a == 1 ? new C0090b() : new C0091c();
    }

    /* renamed from: q0 */
    public void mo16605q0() {
        if (C11842p.m70759Q0() || this.f12341a == 2) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(-1);
        }
    }

    /* renamed from: r */
    public C0089a m16606r() {
        return this.f12341a == 1 ? new C0096h() : new C0093e();
    }

    /* renamed from: r0 */
    public void m16607r0(Dialog dialog) {
        C11829c.m70600n1(dialog, C0209d.m1200P1(this), this.f12341a == 1);
    }

    /* renamed from: s */
    public C0089a m16608s() {
        return this.f12341a == 1 ? new C0089a() : new C0098j();
    }

    /* renamed from: s0 */
    public void mo16609s0() {
        C0089a c0089a = this.f12348h;
        if (c0089a != null) {
            c0089a.mo688a(this, this.f12350j, this.f12349i, this.f12351k);
        }
    }

    /* renamed from: t */
    public List<View> mo16610t() {
        ArrayList arrayList = new ArrayList();
        NotchBottomFitRelativeLayout notchBottomFitRelativeLayout = this.f12353m;
        if (notchBottomFitRelativeLayout != null) {
            arrayList.add(notchBottomFitRelativeLayout);
        }
        NotchFitOOBENavLinearLayout notchFitOOBENavLinearLayout = this.f12352l;
        if (notchFitOOBENavLinearLayout != null) {
            arrayList.add(notchFitOOBENavLinearLayout);
        }
        return arrayList;
    }

    /* renamed from: t0 */
    public void m16611t0(TextView textView, String str, String str2) {
        if (textView == null || str == null || str2 == null) {
            C11839m.m70687e("OOBEBaseActivity", "setLinkableTxt params has null");
        } else {
            textView.setOnClickListener(new ViewOnClickListenerC2819d(textView));
            textView.setText(str2);
        }
    }

    /* renamed from: u */
    public int m16612u() {
        int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - this.f12362v) / 1000);
        if (iCurrentTimeMillis <= 0) {
            return 1;
        }
        return iCurrentTimeMillis;
    }

    /* renamed from: u0 */
    public void mo16613u0() {
        if (1 == this.f12341a) {
            C11829c.m70585i1(getWindow());
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new ViewOnSystemUiVisibilityChangeListenerC2816a());
            C11829c.m70633y1(this, getWindow());
        }
    }

    /* renamed from: v */
    public void m16614v() {
        if (!C11842p.m70753O0(this) || C11842p.m70771U0()) {
            C0209d.m1159C2(this);
        } else {
            C0209d.m1169F0(this);
        }
    }

    /* renamed from: v0 */
    public void m16615v0() {
        boolean z10 = !this.f12358r && C0209d.m1200P1(this);
        Window window = getWindow();
        if (window == null || 1 != this.f12341a || z10) {
            return;
        }
        C11829c.m70585i1(window);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(new ViewOnSystemUiVisibilityChangeListenerC2817b());
        C11829c.m70633y1(this, getWindow());
    }

    /* renamed from: w */
    public void m16616w() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (m16581d0()) {
            HwToolbar hwToolbarM16593k = m16593k();
            this.f12363w = hwToolbarM16593k;
            if (hwToolbarM16593k != null) {
                C11839m.m70686d("OOBEBaseActivity", "mHwToolbar != null");
                if (getActionBar() == null) {
                    C11839m.m70686d("OOBEBaseActivity", "getActionBar() == null");
                    this.f12363w.setVisibility(0);
                    setActionBar(this.f12363w);
                }
                ActionBar actionBar = getActionBar();
                if (actionBar == null) {
                    return;
                }
                actionBar.setDisplayShowTitleEnabled(false);
                actionBar.setDisplayHomeAsUpEnabled(true);
                C11842p.m70842n1(actionBar, new ColorDrawable(0));
                actionBar.setBackgroundDrawable(new ColorDrawable(0));
                C12809f.m76843p(this.f12351k, false);
                HwToolbar hwToolbar = this.f12363w;
                hwToolbar.setPadding(hwToolbar.getPaddingLeft(), C11842p.m70789a0(this), this.f12363w.getPaddingRight(), this.f12363w.getPaddingBottom());
            }
            mo16556D();
        }
    }

    /* renamed from: w0 */
    public void m16617w0() {
        if (1 == this.f12341a) {
            C11829c.m70588j1(getWindow());
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new ViewOnSystemUiVisibilityChangeListenerC2818c());
        }
    }

    /* renamed from: x0 */
    public void mo16618x0() {
        if (2 == this.f12341a) {
            this.f12351k.setVisibility(8);
        } else {
            this.f12351k.setVisibility(0);
        }
    }

    /* renamed from: y */
    public void mo16619y() {
        if (C0219i.m1463a() <= 14) {
            mo16621z();
            return;
        }
        if (C0219i.m1463a() >= 15 && C0219i.m1463a() < 17) {
            mo16550A();
        } else if (C0219i.m1463a() < 17 || C0219i.m1463a() >= 21) {
            mo16554C();
        } else {
            mo16552B();
        }
    }

    /* renamed from: y0 */
    public void mo16620y0() {
        if (1 != this.f12341a || getActionBar() == null) {
            return;
        }
        getActionBar().hide();
    }

    /* renamed from: z */
    public void mo16621z() {
    }

    /* renamed from: z0 */
    public void mo16622z0() {
        C0089a c0089a = this.f12348h;
        if (c0089a != null) {
            c0089a.mo691d(this, this.f12350j, this.f12349i, this.f12351k);
        }
    }
}
