package com.huawei.android.hicloud.p088ui.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.fragment.app.AbstractC0767y;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.huawei.android.dynamicfeature.plugin.language.LanguagePlugin;
import com.huawei.android.hicloud.p088ui.fragment.C3983d;
import com.huawei.android.hicloud.p088ui.uiextend.HiCloudDotsPageIndicator;
import com.huawei.android.hicloud.p088ui.uiextend.UpgradeIntroViewPager;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0216g0;
import p015ak.C0219i;
import p015ak.C0236u;
import p252e9.C9436m;
import p514o9.C11829c;
import p514o9.C11836j;
import p514o9.C11839m;
import p514o9.C11842p;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12806c;
import sk.C12809f;

/* loaded from: classes3.dex */
public class NewBusinessIntroductionActivity extends FragmentActivity {

    /* renamed from: A */
    public HiCloudDotsPageIndicator f15590A;

    /* renamed from: B */
    public HwButton f15591B;

    /* renamed from: C */
    public LinkedList<C3983d> f15592C;

    /* renamed from: D */
    public HwTextView f15593D;

    /* renamed from: E */
    public HwTextView f15594E;

    /* renamed from: F */
    public int f15595F;

    /* renamed from: G */
    public List<View> f15596G = new ArrayList();

    /* renamed from: H */
    public View f15597H;

    /* renamed from: y */
    public UpgradeIntroViewPager f15598y;

    /* renamed from: z */
    public C3413b f15599z;

    /* renamed from: com.huawei.android.hicloud.ui.activity.NewBusinessIntroductionActivity$a */
    public class C3412a implements ViewPager.InterfaceC0980i {
        public C3412a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageScrollStateChanged(int i10) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
            C11839m.m70686d("NewBusinessIntroductionActivity", "onPageScrollStateChanged, state: " + i10);
            if (i10 == 1) {
                NewBusinessIntroductionActivity.this.f15598y.setDefaultScroller();
            }
            NewBusinessIntroductionActivity.this.m21660v0(i10);
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageScrolled(int i10, float f10, int i11) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageSelected(int i10) {
            C11839m.m70686d("NewBusinessIntroductionActivity", "onPageSelected, position: " + i10);
            if (NewBusinessIntroductionActivity.this.f15592C == null || i10 >= NewBusinessIntroductionActivity.this.f15592C.size()) {
                C11839m.m70686d("NewBusinessIntroductionActivity", "onPageSelected, data or position error");
                return;
            }
            NewBusinessIntroductionActivity.this.f15595F = i10;
            if (i10 == 0) {
                NewBusinessIntroductionActivity.this.f15590A.startAutoPlayForPageOne();
            }
            NewBusinessIntroductionActivity.this.m21664z0(i10);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.NewBusinessIntroductionActivity$b */
    public static class C3413b extends AbstractC0767y {

        /* renamed from: o */
        public List<C3983d> f15601o;

        public C3413b(FragmentManager fragmentManager, List<C3983d> list) {
            super(fragmentManager);
            this.f15601o = list;
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public int getCount() {
            return this.f15601o.size();
        }

        @Override // androidx.fragment.app.AbstractC0767y
        public Fragment getItem(int i10) {
            return this.f15601o.get(i10);
        }

        @Override // androidx.viewpager.widget.AbstractC0984a
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    /* renamed from: o0 */
    private void m21649o0() throws Resources.NotFoundException {
        HwTextView hwTextView = this.f15593D;
        int i10 = R$string.new_businessintro_page1_main_title;
        C12809f.m76840m(hwTextView, i10);
        HwTextView hwTextView2 = this.f15594E;
        int i11 = R$string.new_businessintro_page1_content;
        C12809f.m76840m(hwTextView2, i11);
        LinkedList<C3983d> linkedList = new LinkedList<>();
        this.f15592C = linkedList;
        linkedList.add(new C3983d(i10, i11, R$drawable.img_safely_store_your_data));
        C3983d c3983d = new C3983d(R$string.new_businessintro_page2_main_title, R$string.new_businessintro_page2_content_new, R$drawable.img_a_new_cloud_space);
        if (C11842p.m70765S0()) {
            this.f15592C.addFirst(c3983d);
        } else {
            this.f15592C.addLast(c3983d);
        }
        C3413b c3413b = new C3413b(m4473U(), this.f15592C);
        this.f15599z = c3413b;
        this.f15598y.setAdapter(c3413b);
        if (C11842p.m70765S0()) {
            this.f15598y.setCurrentItem(this.f15599z.getCount() - 1);
        }
        this.f15598y.addOnPageChangeListener(new C3412a());
        this.f15590A.setViewPager(this.f15598y);
    }

    /* renamed from: r0 */
    private void m21650r0() throws IllegalAccessException, IllegalArgumentException {
        this.f15597H = C12809f.m76829b(this, R$id.main_view_container);
        m21661w0();
        m21656q0();
        this.f15598y = (UpgradeIntroViewPager) C12809f.m76829b(this, R$id.intro_gif_viewpager);
        this.f15590A = (HiCloudDotsPageIndicator) C12809f.m76829b(this, R$id.intro_dots_indicator);
        this.f15593D = (HwTextView) C12809f.m76829b(this, R$id.main_title_text);
        this.f15594E = (HwTextView) C12809f.m76829b(this, R$id.sub_title_text);
        HwButton hwButton = (HwButton) C12809f.m76829b(this, R$id.start_use_button);
        this.f15591B = hwButton;
        hwButton.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.j7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17650a.m21657s0(view);
            }
        });
        m21663y0();
        this.f15597H.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.android.hicloud.ui.activity.k7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f17659a.m21658t0();
            }
        });
    }

    /* renamed from: A0 */
    public final void m21651A0() {
        try {
            Intent intent = new Intent();
            intent.setClass(this, MainActivity.class);
            C0209d.m1302r2(intent, "com.huawei.hidisk");
            startActivity(intent);
        } catch (Exception e10) {
            C11839m.m70688i("NewBusinessIntroductionActivity", "startMainActivity error " + e10);
        }
    }

    /* renamed from: l0 */
    public final int m21652l0() {
        Intent intent = getIntent();
        if (intent == null) {
            return 0;
        }
        return new HiCloudSafeIntent(intent).getIntExtra("navigation_dest", 0);
    }

    /* renamed from: m0 */
    public List<View> m21653m0() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(findViewById(R$id.main_view_container));
        arrayList.add(findViewById(R$id.fixed_area));
        arrayList.add(findViewById(R$id.viewpager_area));
        return arrayList;
    }

    /* renamed from: n0 */
    public final void m21654n0() {
        String[] strArrM59183c = C9436m.m59180d().m59183c();
        if (TextUtils.isEmpty(strArrM59183c[1])) {
            C11839m.m70689w("NewBusinessIntroductionActivity", "h5Url is empty");
            return;
        }
        if (!TextUtils.equals(strArrM59183c[0], "bmNewUserGuidPage")) {
            C11839m.m70689w("NewBusinessIntroductionActivity", "h5Url is not new user page");
            return;
        }
        if (!C13452e.m80781L().m80791C0()) {
            C11839m.m70689w("NewBusinessIntroductionActivity", "current user is not new basic");
            return;
        }
        try {
            C11839m.m70688i("NewBusinessIntroductionActivity", "getOperWebViewIntent");
            SafeIntent safeIntent = new SafeIntent(NotifyUtil.getOperWebViewIntent(this, strArrM59183c[1], 7));
            safeIntent.putExtra("is_support_orientation", false);
            safeIntent.putExtra("is_support_dark_mode", true);
            safeIntent.putExtra("page_source_type", strArrM59183c[0]);
            safeIntent.putExtra("actionbar_background", true);
            safeIntent.putExtra("isFormMainPage", true);
            startActivity(safeIntent);
            C9436m.m59180d().m59182b();
        } catch (Exception e10) {
            C11839m.m70687e("NewBusinessIntroductionActivity", "getOperWebViewIntent error: " + e10.getMessage());
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        new LanguagePlugin().activityInit(this);
        super.onConfigurationChanged(configuration);
        m21655p0();
        m21650r0();
        m21649o0();
        C12806c.m76820k(this, this.f15596G);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70686d("NewBusinessIntroductionActivity", "onCreate");
        super.onCreate(bundle);
        C0216g0.m1402e(this).m1447y(new SafeIntent(getIntent()));
        m21655p0();
        C11842p.m70710A0(this, C11842p.m70732H0(this));
        m21650r0();
        m21649o0();
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        C13227f.m79492i1().m79567R("mecloud_NewBusinessIntroductionActivity", linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", "mecloud_NewBusinessIntroductionActivity", linkedHashMapM79497A);
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
        m21662x0(0);
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
        C11839m.m70686d("NewBusinessIntroductionActivity", "onResume");
        C13452e.m80781L().m80965r2(false);
    }

    /* renamed from: p0 */
    public final void m21655p0() {
        setContentView(R$layout.new_business_introduction_layout);
    }

    /* renamed from: q0 */
    public void m21656q0() {
        List<View> listM21653m0 = m21653m0();
        List<List<View>> listM70887y2 = C11842p.m70887y2(listM21653m0);
        if (C0219i.m1463a() >= 17 && C11829c.m70563b0(this)) {
            C12806c.m76821l(this, listM21653m0);
            C12806c.m76820k(this, listM70887y2.get(1));
        }
        m21659u0(listM70887y2.get(0));
        C12806c.m76820k(this, listM70887y2.get(0));
    }

    /* renamed from: s0 */
    public final /* synthetic */ void m21657s0(View view) {
        m21662x0(-1);
    }

    /* renamed from: t0 */
    public final /* synthetic */ void m21658t0() {
        if (C11842p.m70753O0(this) && this.f15597H.getPaddingTop() == 0) {
            int iM70789a0 = C11842p.m70789a0(this);
            View view = this.f15597H;
            view.setPadding(view.getPaddingLeft(), iM70789a0, this.f15597H.getPaddingRight(), this.f15597H.getPaddingBottom());
        }
    }

    /* renamed from: u0 */
    public void m21659u0(List<View> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f15596G.addAll(list);
    }

    /* renamed from: v0 */
    public final void m21660v0(int i10) {
        HiCloudDotsPageIndicator hiCloudDotsPageIndicator = this.f15590A;
        if (hiCloudDotsPageIndicator != null) {
            if (i10 == 1) {
                hiCloudDotsPageIndicator.stopAutoPlay();
            } else if (this.f15595F == 0) {
                hiCloudDotsPageIndicator.startAutoPlayForPageOne();
            } else {
                hiCloudDotsPageIndicator.startAutoPlay();
            }
        }
    }

    /* renamed from: w0 */
    public void m21661w0() throws IllegalAccessException, IllegalArgumentException {
        if (C0219i.m1463a() < 17 || !C11829c.m70563b0(this)) {
            return;
        }
        C11829c.m70591k1(this);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 1024);
    }

    /* renamed from: x0 */
    public final void m21662x0(int i10) {
        Intent intent = new Intent();
        intent.putExtra("navigation_dest", m21652l0());
        setResult(i10, intent);
        if (C10028c.m62182c0().m62191B1()) {
            m21651A0();
        } else {
            m21654n0();
        }
        finish();
    }

    /* renamed from: y0 */
    public final void m21663y0() {
        if (!C11842p.m70753O0(this) || C11842p.m70747M0(this)) {
            C11842p.m70874v1(this, this.f15591B);
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
        this.f15591B.setMinWidth(displayMetrics.widthPixels / 4);
    }

    /* renamed from: z0 */
    public void m21664z0(int i10) {
        C12809f.m76840m(this.f15593D, this.f15592C.get(i10).m24368D1());
        C12809f.m76840m(this.f15594E, this.f15592C.get(i10).m24367C1());
    }
}
