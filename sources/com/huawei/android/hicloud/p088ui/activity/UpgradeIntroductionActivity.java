package com.huawei.android.hicloud.p088ui.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import androidx.fragment.app.AbstractC0767y;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.huawei.android.dynamicfeature.plugin.language.LanguagePlugin;
import com.huawei.android.hicloud.p088ui.fragment.AbstractC3992m;
import com.huawei.android.hicloud.p088ui.fragment.C3993n;
import com.huawei.android.hicloud.p088ui.fragment.C3994o;
import com.huawei.android.hicloud.p088ui.fragment.C3995p;
import com.huawei.android.hicloud.p088ui.uiextend.HiCloudDotsPageIndicator;
import com.huawei.android.hicloud.p088ui.uiextend.UpgradeIntroViewPager;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0216g0;
import p015ak.C0219i;
import p015ak.C0236u;
import p252e9.C9438o;
import p514o9.C11829c;
import p514o9.C11836j;
import p514o9.C11839m;
import p514o9.C11842p;
import sk.C12808e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class UpgradeIntroductionActivity extends FragmentActivity {

    /* renamed from: A */
    public HiCloudDotsPageIndicator f16300A;

    /* renamed from: B */
    public HwButton f16301B;

    /* renamed from: C */
    public ArrayList<AbstractC3992m> f16302C;

    /* renamed from: D */
    public HwTextView f16303D;

    /* renamed from: E */
    public HwTextView f16304E;

    /* renamed from: F */
    public int f16305F;

    /* renamed from: G */
    public boolean f16306G = false;

    /* renamed from: y */
    public UpgradeIntroViewPager f16307y;

    /* renamed from: z */
    public C3527c f16308z;

    /* renamed from: com.huawei.android.hicloud.ui.activity.UpgradeIntroductionActivity$a */
    public class ViewOnClickListenerC3525a implements View.OnClickListener {
        public ViewOnClickListenerC3525a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (UpgradeIntroductionActivity.this.f16306G) {
                UpgradeIntroductionActivity.this.m22538s0();
            } else {
                UpgradeIntroductionActivity.this.m22535v0(-1);
            }
            C0236u.m1654e();
            C0236u.m1656g();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.UpgradeIntroductionActivity$b */
    public class C3526b implements ViewPager.InterfaceC0980i {
        public C3526b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageScrollStateChanged(int i10) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
            C11839m.m70686d("UpgradeIntroductionActivity", "onPageScrollStateChanged, state: " + i10);
            if (i10 == 1) {
                UpgradeIntroductionActivity.this.f16307y.setDefaultScroller();
            }
            UpgradeIntroductionActivity.this.m22534u0(i10);
            if (i10 == 0) {
                UpgradeIntroductionActivity.this.m22539t0();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageScrolled(int i10, float f10, int i11) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageSelected(int i10) {
            C11839m.m70686d("UpgradeIntroductionActivity", "onPageSelected, position: " + i10);
            if (UpgradeIntroductionActivity.this.f16302C == null || i10 >= UpgradeIntroductionActivity.this.f16302C.size()) {
                C11839m.m70686d("UpgradeIntroductionActivity", "onPageSelected, data or position error");
                return;
            }
            UpgradeIntroductionActivity.this.f16305F = i10;
            if (i10 == 0) {
                UpgradeIntroductionActivity.this.f16300A.startAutoPlayForPageOne();
            }
            UpgradeIntroductionActivity.this.m22540x0(i10);
            if (((AbstractC3992m) UpgradeIntroductionActivity.this.f16302C.get(i10)) == null) {
                C11839m.m70688i("UpgradeIntroductionActivity", "fragment in position is null");
                return;
            }
            for (int i11 = 0; i11 < UpgradeIntroductionActivity.this.f16302C.size(); i11++) {
                AbstractC3992m abstractC3992m = (AbstractC3992m) UpgradeIntroductionActivity.this.f16302C.get(i11);
                if (i10 == i11) {
                    abstractC3992m.mo24382M1();
                }
                abstractC3992m.mo24378I1();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.UpgradeIntroductionActivity$c */
    public static class C3527c extends AbstractC0767y {

        /* renamed from: o */
        public List<AbstractC3992m> f16311o;

        public C3527c(FragmentManager fragmentManager, List<AbstractC3992m> list) {
            super(fragmentManager);
            this.f16311o = list;
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public int getCount() {
            return this.f16311o.size();
        }

        @Override // androidx.fragment.app.AbstractC0767y
        public Fragment getItem(int i10) {
            return this.f16311o.get(i10);
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    /* renamed from: n0 */
    private int m22530n0() {
        Intent intent = getIntent();
        if (intent == null) {
            return 0;
        }
        return new HiCloudSafeIntent(intent).getIntExtra("navigation_dest", 0);
    }

    /* renamed from: o0 */
    private void m22531o0() throws Resources.NotFoundException {
        this.f16303D.setText(R$string.intro_main_title);
        this.f16304E.setText(R$string.intro_main_sub_title);
        this.f16302C = new ArrayList<>();
        if (C11842p.m70765S0()) {
            this.f16302C.add(new C3995p());
            this.f16302C.add(new C3993n());
            this.f16302C.add(new C3994o());
        } else {
            this.f16302C.add(new C3994o());
            this.f16302C.add(new C3993n());
            this.f16302C.add(new C3995p());
        }
        C3527c c3527c = new C3527c(m4473U(), this.f16302C);
        this.f16308z = c3527c;
        this.f16307y.setAdapter(c3527c);
        if (C11842p.m70765S0()) {
            this.f16307y.setCurrentItem(this.f16308z.getCount() - 1);
        }
        this.f16307y.addOnPageChangeListener(new C3526b());
        this.f16300A.setViewPager(this.f16307y);
    }

    /* renamed from: p0 */
    private void m22532p0() {
        if (C11842p.m70771U0()) {
            setContentView(R$layout.upgrade_introduction_layout_pad);
        } else if (C11842p.m70747M0(this)) {
            setContentView(R$layout.upgrade_introduction_layout_screen_expand);
        } else {
            setContentView(R$layout.upgrade_introduction_layout);
        }
    }

    /* renamed from: r0 */
    private void m22533r0() throws IllegalAccessException, IllegalArgumentException {
        this.f16307y = (UpgradeIntroViewPager) C12809f.m76829b(this, R$id.intro_gif_viewpager);
        this.f16300A = (HiCloudDotsPageIndicator) C12809f.m76829b(this, R$id.intro_dots_indicator);
        this.f16303D = (HwTextView) C12809f.m76829b(this, R$id.main_title_text);
        this.f16304E = (HwTextView) C12809f.m76829b(this, R$id.sub_title_text);
        HwButton hwButton = (HwButton) C12809f.m76829b(this, R$id.start_use_button);
        this.f16301B = hwButton;
        hwButton.setOnClickListener(new ViewOnClickListenerC3525a());
        m22536w0();
        if (C0219i.m1463a() < 17 || !C11829c.m70563b0(this)) {
            return;
        }
        C11829c.m70591k1(this);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 1024);
    }

    /* renamed from: u0 */
    public void m22534u0(int i10) {
        HiCloudDotsPageIndicator hiCloudDotsPageIndicator = this.f16300A;
        if (hiCloudDotsPageIndicator != null) {
            if (i10 == 1) {
                hiCloudDotsPageIndicator.stopAutoPlay();
            } else if (this.f16305F == 0) {
                hiCloudDotsPageIndicator.startAutoPlayForPageOne();
            } else {
                hiCloudDotsPageIndicator.startAutoPlay();
            }
        }
    }

    /* renamed from: v0 */
    public void m22535v0(int i10) {
        Intent intent = new Intent();
        intent.putExtra("navigation_dest", m22530n0());
        setResult(i10, intent);
        finish();
    }

    /* renamed from: w0 */
    private void m22536w0() {
        if (!C11842p.m70753O0(this) || C11842p.m70747M0(this)) {
            C11842p.m70874v1(this, this.f16301B);
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
        this.f16301B.setMinWidth(displayMetrics.widthPixels / 4);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        new LanguagePlugin().activityInit(this);
        super.onConfigurationChanged(configuration);
        m22532p0();
        m22533r0();
        m22531o0();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70686d("UpgradeIntroductionActivity", "onCreate");
        super.onCreate(bundle);
        C0216g0.m1402e(this).m1447y(new SafeIntent(getIntent()));
        C12808e.m76822a(this);
        if (!C9438o.m59204a().m59205b()) {
            m22538s0();
            finish();
            return;
        }
        C9438o.m59204a().m59206c(true);
        C0236u.m1653d();
        m22532p0();
        C11842p.m70714B0(this);
        m22533r0();
        m22531o0();
        m22537q0();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C0236u.m1656g();
        C11836j.m70658k().m70671n();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyDown(i10, keyEvent);
        }
        m22535v0(0);
        C0236u.m1654e();
        C0236u.m1656g();
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C0216g0.m1402e(this).m1447y(new SafeIntent(getIntent()));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C11839m.m70686d("UpgradeIntroductionActivity", "onResume");
        if (C9438o.m59204a().m59205b()) {
            return;
        }
        C0236u.m1656g();
        m22535v0(0);
    }

    /* renamed from: q0 */
    public final void m22537q0() {
        try {
            if (new SafeIntent(getIntent()).getIntExtra(NotifyConstants.NOTIFY_ID_KEY, -1) == 291) {
                this.f16306G = true;
            }
        } catch (Exception e10) {
            C11839m.m70687e("UpgradeIntroductionActivity", "initNavSource error, e = " + e10.toString());
        }
    }

    /* renamed from: s0 */
    public final void m22538s0() {
        Intent intent = new Intent();
        intent.setClass(this, NewHiSyncSettingActivity.class);
        startActivity(intent);
        finish();
    }

    /* renamed from: t0 */
    public final void m22539t0() {
        int currentItem = this.f16307y.getCurrentItem();
        if (currentItem < 0 || currentItem >= this.f16302C.size()) {
            C11839m.m70687e("UpgradeIntroductionActivity", "position out of range");
            return;
        }
        for (int i10 = 0; i10 < this.f16302C.size(); i10++) {
            AbstractC3992m abstractC3992m = this.f16302C.get(i10);
            if (abstractC3992m != null && currentItem == i10) {
                abstractC3992m.mo24380K1();
            }
        }
    }

    /* renamed from: x0 */
    public void m22540x0(int i10) {
        if (i10 == 0) {
            this.f16303D.setText(R$string.intro_main_title);
            this.f16304E.setText(R$string.intro_main_sub_title);
        } else {
            if (i10 == 1) {
                this.f16303D.setText(R$string.intro_backup_title);
                this.f16304E.setText(R$string.intro_backup_sub_title);
                return;
            }
            this.f16303D.setText(R$string.intro_strong_backup_title);
            if (AbstractC3992m.m24372G1()) {
                this.f16304E.setText(R$string.intro_strong_backup_sub_title);
            } else {
                this.f16304E.setText(R$string.intro_strong_backup_oversea_sub_title);
            }
        }
    }

    /* renamed from: y0 */
    public void m22541y0(int i10) {
        C11839m.m70688i("UpgradeIntroductionActivity", "setViewPosition, page content height: " + i10);
        if (i10 == 0) {
            C11839m.m70689w("UpgradeIntroductionActivity", "setViewPosition, pageContent is 0");
            return;
        }
        C11842p.m70736I1(this.f16300A, (((int) C11842p.m70844o(this, 8)) + i10) - ((int) C11842p.m70844o(this, 32)));
    }
}
