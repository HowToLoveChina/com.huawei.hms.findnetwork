package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.bean.HomepagePackageExpiresCardItemBean;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.List;
import p431ko.C11081g;
import p514o9.C11839m;
import p616rk.C12515a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class ExpirationCardItemAdapter extends RecyclerView.AbstractC0838h<RecyclerView.AbstractC0833c0> {

    /* renamed from: d */
    public final Context f18741d;

    /* renamed from: e */
    public List<HomepagePackageExpiresCardItemBean> f18742e;

    /* renamed from: f */
    public long f18743f = 0;

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.ExpirationCardItemAdapter$a */
    public static class C4052a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public final TextView f18744u;

        /* renamed from: v */
        public final TextView f18745v;

        /* renamed from: w */
        public final TextView f18746w;

        /* renamed from: x */
        public final TextView f18747x;

        /* renamed from: y */
        public final TextView f18748y;

        /* renamed from: z */
        public RelativeLayout f18749z;

        public C4052a(View view) {
            super(view);
            this.f18744u = (TextView) C12809f.m76831d(view, R$id.expiration_item_title);
            this.f18745v = (TextView) C12809f.m76831d(view, R$id.expiration_item_content);
            this.f18746w = (TextView) C12809f.m76831d(view, R$id.expiration_item_button);
            this.f18747x = (TextView) C12809f.m76831d(view, R$id.expiration_item_button2);
            this.f18748y = (TextView) C12809f.m76831d(view, R$id.recommend);
            this.f18749z = (RelativeLayout) C12809f.m76831d(view, R$id.expiration_item_layout);
        }
    }

    public ExpirationCardItemAdapter(Context context) {
        this.f18741d = context;
    }

    /* renamed from: F */
    public final boolean m25020F() {
        long j10 = this.f18743f;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f18743f = jCurrentTimeMillis;
        return jCurrentTimeMillis - j10 <= 1000;
    }

    /* renamed from: G */
    public final void m25021G(String str, String str2) throws URISyntaxException {
        try {
            if (this.f18741d != null) {
                Intent uri = Intent.parseUri(str2, 1);
                C11839m.m70688i("ExpirationCardItemAdapter", "intent: " + uri + ", url: " + str2);
                this.f18741d.startActivity(uri);
                C12515a.m75110o().m75172d(new C11081g(str, RecommendCardConstants.Entrance.HOMEPAGE, C13452e.m80781L().m80815I0() ? 12 : C13452e.m80781L().m80819J0() ? 13 : C13452e.m80781L().m80823K0() ? 14 : -1));
                m25024J(str);
            }
        } catch (Exception e10) {
            C11839m.m70687e("ExpirationCardItemAdapter", "jump deeplink exception: " + e10);
        }
    }

    /* renamed from: H */
    public final /* synthetic */ void m25022H(C4052a c4052a, HomepagePackageExpiresCardItemBean homepagePackageExpiresCardItemBean, View view) throws URISyntaxException {
        m25021G(c4052a.f18746w.getVisibility() == 0 ? homepagePackageExpiresCardItemBean.getButton() : homepagePackageExpiresCardItemBean.getButton2(), c4052a.f18746w.getVisibility() == 0 ? homepagePackageExpiresCardItemBean.getButtonLinkUrl() : homepagePackageExpiresCardItemBean.getButtonLinkUrl2());
    }

    /* renamed from: I */
    public final /* synthetic */ void m25023I(String str, String str2, TextView textView, View view) throws URISyntaxException {
        if (m25020F()) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            if (textView != null) {
                m25021G(str2, str);
            }
        } else {
            C11839m.m70687e("ExpirationCardItemAdapter", "linkUrl is empty, text: " + str2);
        }
    }

    /* renamed from: J */
    public final void m25024J(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("dataPeriod", String.valueOf(C13452e.m80781L().m80946n()));
        linkedHashMapM79497A.put("buttonText", str);
        C13227f.m79492i1().m79567R("expiration_card_click", linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", "expiration_card_click", linkedHashMapM79497A);
    }

    /* renamed from: K */
    public void m25025K(List<HomepagePackageExpiresCardItemBean> list) {
        this.f18742e = list;
    }

    /* renamed from: L */
    public final void m25026L(final TextView textView, final String str, final String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        textView.setText(str);
        textView.setOnClickListener(new View.OnClickListener() { // from class: ae.h1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws URISyntaxException {
                this.f479a.m25023I(str2, str, textView, view);
            }
        });
    }

    /* renamed from: M */
    public final void m25027M(View view, boolean z10) {
        if (view != null) {
            view.setVisibility(z10 ? 0 : 8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<HomepagePackageExpiresCardItemBean> list = this.f18742e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        List<HomepagePackageExpiresCardItemBean> list = this.f18742e;
        if (list == null || list.isEmpty()) {
            C11839m.m70687e("ExpirationCardItemAdapter", "cardItemDataList is null");
            return;
        }
        final C4052a c4052a = (C4052a) abstractC0833c0;
        final HomepagePackageExpiresCardItemBean homepagePackageExpiresCardItemBean = this.f18742e.get(i10);
        if (homepagePackageExpiresCardItemBean != null) {
            c4052a.f18744u.setText(homepagePackageExpiresCardItemBean.getTitle());
            c4052a.f18745v.setText(homepagePackageExpiresCardItemBean.getContent());
            m25027M(c4052a.f18745v, homepagePackageExpiresCardItemBean.isContentIsShow());
            c4052a.f18748y.setText(homepagePackageExpiresCardItemBean.getRecommendation());
            m25027M(c4052a.f18748y, homepagePackageExpiresCardItemBean.isRecommendationIsShow());
            m25026L(c4052a.f18746w, homepagePackageExpiresCardItemBean.getButton(), homepagePackageExpiresCardItemBean.getButtonLinkUrl());
            m25027M(c4052a.f18746w, homepagePackageExpiresCardItemBean.isButtonIsShow());
            m25026L(c4052a.f18747x, homepagePackageExpiresCardItemBean.getButton2(), homepagePackageExpiresCardItemBean.getButtonLinkUrl2());
            m25027M(c4052a.f18747x, homepagePackageExpiresCardItemBean.isButton2IsShow());
            if (homepagePackageExpiresCardItemBean.isButtonIsShow() && homepagePackageExpiresCardItemBean.isButton2IsShow()) {
                c4052a.f18749z.setBackgroundResource(0);
                c4052a.f18749z.setOnClickListener(null);
            } else {
                if (c4052a.f18746w.getVisibility() == 8 && c4052a.f18747x.getVisibility() == 8) {
                    return;
                }
                c4052a.f18749z.setBackgroundResource(R$drawable.emui50_list_selector_card_down);
                c4052a.f18749z.setOnClickListener(new View.OnClickListener() { // from class: ae.g1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) throws URISyntaxException {
                        this.f466a.m25022H(c4052a, homepagePackageExpiresCardItemBean, view);
                    }
                });
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        return new C4052a(LayoutInflater.from(this.f18741d).inflate(R$layout.expiration_card_item, viewGroup, false));
    }
}
