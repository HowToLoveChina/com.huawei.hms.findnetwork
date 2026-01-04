package com.huawei.android.hicloud.p088ui.activity;

import ae.C0181x1;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hicloud.notification.p106db.bean.NotifyTypeAndUriGoto;
import com.huawei.hicloud.notification.p106db.bean.RecommendCard;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.embedded.C5914f2;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p054cj.C1442a;
import p329h7.C10121i;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p664u0.C13108a;
import p684un.C13227f;
import p709vj.C13452e;
import p805yb.C13933c;
import sk.C12809f;

/* loaded from: classes3.dex */
public class RecommendDetailActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: p */
    public RelativeLayout f15857p;

    /* renamed from: q */
    public View f15858q;

    /* renamed from: r */
    public View f15859r;

    /* renamed from: s */
    public RelativeLayout f15860s;

    /* renamed from: t */
    public View f15861t;

    /* renamed from: u */
    public ListView f15862u;

    /* renamed from: v */
    public ArrayList<RecommendCard> f15863v;

    /* renamed from: w */
    public C0181x1 f15864w;

    /* renamed from: x */
    public C3455b f15865x;

    /* renamed from: com.huawei.android.hicloud.ui.activity.RecommendDetailActivity$b */
    public class C3455b extends BroadcastReceiver {
        public C3455b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = new SafeIntent(intent).getAction();
            if (!TextUtils.isEmpty(action) && action.equals(RecommendCardConstants.HOMEPAGE_RECOMMEND_REFRESH_FINISH_ACTION)) {
                C11839m.m70688i("RecommendDetailActivity", "receive refresh cards finish");
                RecommendDetailActivity.this.f15863v = RecommendCardManager.getInstance().getRecommendCardsFromCache(RecommendCardConstants.Entrance.HOMEPAGE);
                RecommendDetailActivity.this.m22010S1(false);
            }
        }
    }

    /* renamed from: Q1 */
    private void m22008Q1() {
        if (this.f15865x == null) {
            this.f15865x = new C3455b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(RecommendCardConstants.HOMEPAGE_RECOMMEND_REFRESH_FINISH_ACTION);
            C13108a.m78878b(this).m78880c(this.f15865x, intentFilter);
        }
    }

    /* renamed from: R1 */
    private void m22009R1() {
        this.f15857p = (RelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_top_layout);
        this.f15860s = (RelativeLayout) C12809f.m76829b(this, R$id.rl_card_list);
        this.f15862u = (ListView) C12809f.m76829b(this, R$id.recommend_card_list);
        this.f15858q = C12809f.m76829b(this, R$id.layout_no_information);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.set_no_information_timeout_str);
        if (textView != null) {
            textView.setVisibility(8);
        }
        this.f15861t = C12809f.m76829b(this, R$id.layout_nodata);
        View viewM76829b = C12809f.m76829b(this, R$id.layout_loading);
        this.f15859r = viewM76829b;
        viewM76829b.setVisibility(8);
        this.f15863v = RecommendCardManager.getInstance().getRecommendCardsFromCache(RecommendCardConstants.Entrance.HOMEPAGE);
        m22010S1(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S1 */
    public void m22010S1(boolean z10) {
        ArrayList<RecommendCard> arrayList = this.f15863v;
        if (arrayList == null || arrayList.size() == 0) {
            C11839m.m70689w("RecommendDetailActivity", "no data, finish");
            finish();
            return;
        }
        this.f15860s.setVisibility(0);
        this.f15858q.setVisibility(8);
        if (z10) {
            C0181x1 c0181x1 = new C0181x1(this, this.f15863v);
            this.f15864w = c0181x1;
            this.f15862u.setAdapter((ListAdapter) c0181x1);
            this.f15864w.m1018i(this);
        }
        C0181x1 c0181x12 = this.f15864w;
        if (c0181x12 != null) {
            c0181x12.m1016g(this.f15863v);
            this.f15864w.notifyDataSetChanged();
        }
    }

    /* renamed from: N1 */
    public void m22011N1(Intent intent, String str) {
        if (NotifyConstants.HICLOUD_DLAPP.equals(str)) {
            AdParametersExt adParametersExtM63035a = C10121i.m63035a();
            if (adParametersExtM63035a == null) {
                C1442a.m8290i("RecommendDetailActivity", "adParameters is null");
                return;
            }
            intent.putExtra("agd_resource_enable", adParametersExtM63035a.getEnabled());
            intent.putExtra("agd_resource_slot_id", adParametersExtM63035a.getAgdAdid());
            intent.putExtra("pps_threshold", adParametersExtM63035a.getThreshold());
        }
    }

    /* renamed from: O1 */
    public final void m22012O1(String str, RecommendCard recommendCard) {
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setData(uri);
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        intent.addFlags(C5914f2.f26733f);
        try {
            startActivity(intent);
            C2783d.m16086H0(recommendCard, true);
            C11841o.m70708d(this, getString(R$string.main_jump_third_party), 0);
        } catch (Exception e10) {
            C11839m.m70687e("RecommendDetailActivity", "startActivity ka exception: " + e10.getMessage());
            C2783d.m16084G0(recommendCard, true);
        }
    }

    /* renamed from: P1 */
    public final void m22013P1() {
        try {
            C13227f.m79492i1().m79585f0("detail_nps_banner_click", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "detail_nps_banner_click", "1", "66");
            RecommendCardManager.getInstance().removeNpsRecommandCard(RecommendCardConstants.Entrance.HOMEPAGE, true);
            startActivity(C13933c.m83668n().m83684q());
        } catch (Exception e10) {
            C11839m.m70687e("RecommendDetailActivity", "gotoNpsWebView exception: " + e10.toString());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15857p);
        arrayList.add(this.f15860s);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag;
        int id2 = view.getId();
        if (C0209d.m1226Y0() || id2 != R$id.recommend_detail_item || (tag = view.getTag()) == null) {
            return;
        }
        int iIntValue = ((Integer) tag).intValue();
        ArrayList<RecommendCard> arrayList = this.f15863v;
        if (arrayList == null) {
            C11839m.m70687e("RecommendDetailActivity", "recommendCards is null");
            return;
        }
        if (iIntValue >= arrayList.size()) {
            C11839m.m70687e("RecommendDetailActivity", "position inValid");
            return;
        }
        RecommendCard recommendCard = this.f15863v.get(iIntValue);
        if (recommendCard == null) {
            C11839m.m70687e("RecommendDetailActivity", "card is null");
            return;
        }
        NotifyTypeAndUriGoto notifyTypeAndUriGoto = recommendCard.getNotifyTypeAndUriGoto();
        if (notifyTypeAndUriGoto == null) {
            C11839m.m70687e("RecommendDetailActivity", "uriGoto is null");
            return;
        }
        String notifyType = notifyTypeAndUriGoto.getNotifyType();
        String notifyUri = notifyTypeAndUriGoto.getNotifyUri();
        C11839m.m70688i("RecommendDetailActivity", "notifyType: " + notifyType + ", notifyUri: " + notifyUri);
        if (TextUtils.equals(notifyType, NotifyConstants.HICLOUD_KA)) {
            m22012O1(notifyUri, recommendCard);
            return;
        }
        if (TextUtils.equals(notifyType, "nps")) {
            m22013P1();
            return;
        }
        Intent intentM70543S = C11829c.m70543S(notifyType, notifyUri, false, recommendCard);
        if (intentM70543S == null) {
            C11839m.m70687e("RecommendDetailActivity", "intent is null");
            return;
        }
        try {
            intentM70543S.putExtra("recommend_card_activity_id", recommendCard.getActivityId());
            intentM70543S.putExtra("recommend_card_activity_type", recommendCard.getActivityType());
            intentM70543S.putExtra("recommend_card_entrance", recommendCard.getEntrance());
            m22011N1(intentM70543S, notifyType);
            startActivity(intentM70543S);
            C2783d.m16092K0(recommendCard, true);
        } catch (Exception e10) {
            C11839m.m70687e("RecommendDetailActivity", "startActivity exception: " + e10.getMessage());
            C11842p.m70808f(this, notifyType, notifyUri, R$string.upgrade_filemanager_tip);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m22010S1(true);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R$layout.recommend_detail_layout);
        C11829c.m70609q1(this, getWindow());
        m22009R1();
        mo19005p1();
        mo13327n1();
        m22008Q1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        if (this.f15865x != null) {
            C13108a.m78878b(this).m78883f(this.f15865x);
            this.f15865x = null;
        }
        super.onDestroy();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        RecommendCardManager.getInstance().refreshRecommendCards(RecommendCardConstants.Entrance.HOMEPAGE, false, true);
    }
}
