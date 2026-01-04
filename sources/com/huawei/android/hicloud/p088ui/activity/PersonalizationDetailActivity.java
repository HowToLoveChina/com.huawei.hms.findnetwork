package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.AdSwitchManager;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.router.R$string;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0234s;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p684un.C13227f;
import p709vj.C13452e;
import sk.C12809f;
import tm.C13040c;

/* loaded from: classes3.dex */
public class PersonalizationDetailActivity extends UIActivity implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: p */
    public NotchTopFitRelativeLayout f15779p;

    /* renamed from: q */
    public NotchFitRelativeLayout f15780q;

    /* renamed from: r */
    public NotchFitRelativeLayout f15781r;

    /* renamed from: s */
    public NotchFitRelativeLayout f15782s;

    /* renamed from: t */
    public NotchFitRelativeLayout f15783t;

    /* renamed from: u */
    public NotchFitRelativeLayout f15784u;

    /* renamed from: v */
    public UnionSwitch f15785v;

    /* renamed from: w */
    public UnionSwitch f15786w;

    /* renamed from: x */
    public UnionSwitch f15787x;

    /* renamed from: y */
    public SpanClickText f15788y;

    /* renamed from: z */
    public boolean f15789z = true;

    public static class JumpRecommendInfoUrlTask extends AbstractC12367d {

        /* renamed from: a */
        public Context f15790a;

        public JumpRecommendInfoUrlTask(Context context) {
            this.f15790a = context;
        }

        /* renamed from: c */
        public final String m21948c() {
            try {
                String strM78659m = C13040c.m78609F().m78659m();
                String strM1627e = C0234s.m1627e();
                return strM78659m + "/cch5/PPS/ads/ad-personalized.htm?country=" + C13452e.m80781L().m80942m() + Constants.LANGUAGE + strM1627e + "&version=latest";
            } catch (C9721b e10) {
                C11839m.m70687e("PersonalizationDetailActivity", "getRecommendInfoUrl error:" + e10.toString());
                return "";
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C11839m.m70688i("PersonalizationDetailActivity", "recommend link on click");
            if (this.f15790a == null) {
                C11839m.m70687e("PersonalizationDetailActivity", "context is null");
                return;
            }
            String strM21948c = m21948c();
            if (TextUtils.isEmpty(strM21948c)) {
                C11839m.m70688i("PersonalizationDetailActivity", "recommend link on click url empty");
                return;
            }
            try {
                Intent intent = new Intent();
                intent.setAction(NotifyConstants.Action.HICLOUD_WEBVIEW_ACTION);
                C0209d.m1302r2(intent, "com.huawei.hidisk");
                intent.putExtra("srcChannel", "0");
                intent.putExtra("salChannel", "0");
                intent.putExtra("url", strM21948c);
                intent.putExtra("is_support_orientation", true);
                intent.putExtra("is_support_dark_mode", true);
                intent.putExtra("title", this.f15790a.getString(R$string.HiCloud_app_name));
                intent.putExtra("isEnableJs", true);
                intent.putExtra("launch_web_type", -1);
                intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                if (intent.resolveActivity(this.f15790a.getPackageManager()) == null) {
                    intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(strM21948c));
                }
                this.f15790a.startActivity(intent);
            } catch (Exception e10) {
                C11839m.m70687e("PersonalizationDetailActivity", "JumpRecommendInfoUrlTask Exception: " + e10.toString());
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.STOCK_ACTIVE_CLICK_OPEN;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.PersonalizationDetailActivity$a */
    public class C3443a implements SpanClickText.ISpanClickListener {
        public C3443a() {
        }

        @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
        public void onClick() {
            if (C0209d.m1226Y0()) {
                C11839m.m70689w("PersonalizationDetailActivity", "fast click");
                return;
            }
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null) {
                C11839m.m70687e("PersonalizationDetailActivity", "context is null");
            } else {
                C12515a.m75110o().m75175e(new JumpRecommendInfoUrlTask(contextM1377a), false);
            }
        }
    }

    /* renamed from: M1 */
    private void m21942M1() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.f15779p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.notch_top_fit_frame);
        this.f15780q = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.personalization_ad_content_notch_fit);
        this.f15781r = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.personalization_ad_notch_fit);
        this.f15782s = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.personalization_ad_preference_notch_fit);
        this.f15783t = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.huawei_ad_notch_fit);
        this.f15788y = (SpanClickText) C12809f.m76829b(this, R$id.huawei_ad_switch_tips);
        this.f15784u = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.three_party_ad_notch_fit);
        this.f15785v = (UnionSwitch) C12809f.m76829b(this, R$id.personalization_ad_switch);
        this.f15786w = (UnionSwitch) C12809f.m76829b(this, R$id.huawei_ad_switch);
        UnionSwitch unionSwitch = (UnionSwitch) C12809f.m76829b(this, R$id.three_party_ad_switch);
        this.f15787x = unionSwitch;
        boolean z10 = true;
        boolean z11 = this.f15780q == null || this.f15779p == null || this.f15781r == null;
        boolean z12 = this.f15782s == null || this.f15783t == null || this.f15784u == null;
        if (this.f15785v != null && this.f15786w != null && unionSwitch != null) {
            z10 = false;
        }
        if (z11 || z12 || z10) {
            C11839m.m70687e("PersonalizationDetailActivity", "initView error");
            return;
        }
        if (this.f15788y == null) {
            C11839m.m70689w("PersonalizationDetailActivity", "ad tips is null.");
            return;
        }
        String string = getString(com.huawei.android.p073ds.R$string.learn_more_recommend_rule_link);
        m21947Q1(this.f15788y, getString(com.huawei.android.p073ds.R$string.huawei_ad_content_full, string), string);
        this.f15785v.setOnCheckedChangeListener(this);
        this.f15786w.setOnCheckedChangeListener(this);
        this.f15787x.setOnCheckedChangeListener(this);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(getColor(R$color.hicloud_hmos_bg));
        }
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            int i10 = R$color.hicloud_hmos_bg;
            C11842p.m70842n1(actionBar, new ColorDrawable(getColor(i10)));
            actionBar.setBackgroundDrawable(new ColorDrawable(getColor(i10)));
        }
        C11829c.m70609q1(this, getWindow());
    }

    /* renamed from: L1 */
    public final void m21943L1() {
        if (this.f15785v == null || this.f15786w == null || this.f15787x == null) {
            C11839m.m70687e("PersonalizationDetailActivity", "view error");
            return;
        }
        boolean personalizationAdSwitch = AdSwitchManager.getInstance().getPersonalizationAdSwitch();
        this.f15785v.setChecked(personalizationAdSwitch);
        if (personalizationAdSwitch) {
            this.f15786w.setChecked(AdSwitchManager.getInstance().getHuaweiAdSwitch());
            this.f15787x.setChecked(AdSwitchManager.getInstance().getThreeAdSwitch());
        } else {
            this.f15786w.setChecked(false);
            this.f15786w.setChecked(false);
        }
    }

    /* renamed from: N1 */
    public final void m21944N1(boolean z10) {
        UnionSwitch unionSwitch = this.f15786w;
        if (unionSwitch == null) {
            return;
        }
        unionSwitch.setChecked(z10);
        AdSwitchManager.getInstance().setHuaweiAdSwitch(z10);
    }

    /* renamed from: O1 */
    public final void m21945O1(boolean z10) {
        UnionSwitch unionSwitch = this.f15785v;
        if (unionSwitch == null) {
            return;
        }
        unionSwitch.setChecked(z10);
        AdSwitchManager.getInstance().setPersonalizationAdSwitch(z10);
    }

    /* renamed from: P1 */
    public final void m21946P1(boolean z10) {
        UnionSwitch unionSwitch = this.f15787x;
        if (unionSwitch == null) {
            return;
        }
        unionSwitch.setChecked(z10);
        AdSwitchManager.getInstance().setThreeAdSwitch(z10);
    }

    /* renamed from: Q1 */
    public final void m21947Q1(SpanClickText spanClickText, String str, String str2) {
        spanClickText.m15931c(str2, new C3443a());
        spanClickText.m15934g(str, false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15779p);
        arrayList.add(this.f15780q);
        arrayList.add(this.f15781r);
        arrayList.add(this.f15782s);
        arrayList.add(this.f15783t);
        arrayList.add(this.f15784u);
        return arrayList;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        if (compoundButton == null) {
            return;
        }
        if (this.f15785v == null || this.f15786w == null || this.f15787x == null) {
            C11839m.m70687e("PersonalizationDetailActivity", "view error");
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("switch_status", String.valueOf(z10));
        int id2 = compoundButton.getId();
        if (id2 == R$id.personalization_ad_switch) {
            C11839m.m70688i("PersonalizationDetailActivity", "personalization ad switch, isChecked: " + z10);
            if (!this.f15789z) {
                this.f15789z = true;
                C11839m.m70688i("PersonalizationDetailActivity", "no need open all switch");
                return;
            }
            m21945O1(z10);
            if (z10) {
                m21944N1(true);
                m21946P1(true);
            } else {
                m21944N1(false);
                m21946P1(false);
            }
            C13227f.m79492i1().m79567R("personalization_ad_switch", linkedHashMap);
            UBAAnalyze.m29958S("PVC", "personalization_ad_switch", "1", "4", linkedHashMap);
            return;
        }
        if (id2 == R$id.huawei_ad_switch) {
            C11839m.m70688i("PersonalizationDetailActivity", "huawei ad switch, isChecked: " + z10);
            m21944N1(z10);
            if (!z10 && !this.f15787x.isChecked()) {
                m21945O1(false);
            } else if (z10 && !this.f15785v.isChecked()) {
                this.f15789z = false;
                m21945O1(z10);
            }
            C13227f.m79492i1().m79567R("huawei_ad_switch", linkedHashMap);
            UBAAnalyze.m29958S("PVC", "huawei_ad_switch", "1", "4", linkedHashMap);
            return;
        }
        if (id2 == R$id.three_party_ad_switch) {
            C11839m.m70688i("PersonalizationDetailActivity", "three party ad switch, isChecked: " + z10);
            m21946P1(z10);
            if (!z10 && !this.f15786w.isChecked()) {
                m21945O1(false);
            } else if (z10 && !this.f15785v.isChecked()) {
                this.f15789z = false;
                m21945O1(z10);
            }
            C13227f.m79492i1().m79567R("three_party_ad_switch", linkedHashMap);
            UBAAnalyze.m29958S("PVC", "three_party_ad_switch", "1", "4", linkedHashMap);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i("PersonalizationDetailActivity", "onCreate");
        super.onCreate(bundle);
        setContentView(R$layout.personalization_detail_activity);
        m21942M1();
        mo19005p1();
        m21943L1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C11839m.m70688i("PersonalizationDetailActivity", "onDestroy");
        super.onDestroy();
    }
}
