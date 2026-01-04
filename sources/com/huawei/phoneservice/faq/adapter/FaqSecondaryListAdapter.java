package com.huawei.phoneservice.faq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.huawei.phoneservice.faq.R$id;
import com.huawei.phoneservice.faq.R$layout;
import com.huawei.phoneservice.faq.base.tracker.FaqTrack;
import com.huawei.phoneservice.faq.base.util.FaqTahitiUtils;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.faq.base.widget.ListItemRelativeLayout;
import com.huawei.phoneservice.faq.p174ui.FaqQuestionDetailActivity;
import com.huawei.phoneservice.faq.response.C8342b;
import com.huawei.uikit.hwresources.C8732R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class FaqSecondaryListAdapter extends BaseAdapter {

    /* renamed from: a */
    public Context f38565a;

    /* renamed from: c */
    public String f38567c;

    /* renamed from: d */
    public String f38568d;

    /* renamed from: e */
    public String f38569e;

    /* renamed from: f */
    public String f38570f;

    /* renamed from: g */
    public String f38571g;

    /* renamed from: h */
    public String f38572h;

    /* renamed from: i */
    public String f38573i;

    /* renamed from: j */
    public String f38574j;

    /* renamed from: k */
    public String f38575k;

    /* renamed from: l */
    public String f38576l;

    /* renamed from: m */
    public String f38577m;

    /* renamed from: n */
    public String f38578n;

    /* renamed from: o */
    public String f38579o;

    /* renamed from: p */
    public String f38580p;

    /* renamed from: q */
    public String f38581q;

    /* renamed from: r */
    public String f38582r;

    /* renamed from: s */
    public String f38583s;

    /* renamed from: t */
    public String f38584t;

    /* renamed from: u */
    public String f38585u;

    /* renamed from: b */
    public String f38566b = null;

    /* renamed from: v */
    public String f38586v = "";

    /* renamed from: w */
    public List<C8342b.a> f38587w = new ArrayList();

    /* renamed from: com.huawei.phoneservice.faq.adapter.FaqSecondaryListAdapter$a */
    public class ViewOnClickListenerC8282a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ int f38588a;

        public ViewOnClickListenerC8282a(int i10) {
            this.f38588a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            C8342b.a aVar = (C8342b.a) FaqSecondaryListAdapter.this.f38587w.get(this.f38588a);
            FaqQuestionDetailActivity.m52169z0(FaqSecondaryListAdapter.this.f38565a, FaqSecondaryListAdapter.this.m51713N(), FaqSecondaryListAdapter.this.m51715P(), aVar.m51995c(), aVar.m51997e(), FaqSecondaryListAdapter.this.m51724i(), aVar.m51994b(), FaqSecondaryListAdapter.this.m51732r(), FaqSecondaryListAdapter.this.m51738x(), FaqSecondaryListAdapter.this.m51718a(), FaqSecondaryListAdapter.this.m51703D(), FaqSecondaryListAdapter.this.m51730p(), FaqSecondaryListAdapter.this.m51722g(), FaqSecondaryListAdapter.this.m51707H(), FaqSecondaryListAdapter.this.m51705F(), FaqSecondaryListAdapter.this.m51736v(), FaqSecondaryListAdapter.this.m51740z(), FaqSecondaryListAdapter.this.m51734t(), FaqSecondaryListAdapter.this.m51726l(), false, FaqSecondaryListAdapter.this.m51709J(), FaqSecondaryListAdapter.this.m51711L(), FaqSecondaryListAdapter.this.m51701B(), aVar.m51996d());
            FaqTrack.event(FaqSecondaryListAdapter.this.f38568d + "+SDK+Category", "Click on FAQ", FaqSecondaryListAdapter.this.m51728n() + "+" + aVar.m51995c());
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.adapter.FaqSecondaryListAdapter$b */
    public static class C8283b {

        /* renamed from: a */
        public TextView f38590a;

        /* renamed from: b */
        public View f38591b;

        /* renamed from: c */
        public ListItemRelativeLayout f38592c;
    }

    public FaqSecondaryListAdapter(Context context) {
        this.f38565a = context;
    }

    /* renamed from: A */
    public void m51700A(String str) {
        this.f38570f = str;
    }

    /* renamed from: B */
    public String m51701B() {
        return this.f38584t;
    }

    /* renamed from: C */
    public void m51702C(String str) {
        this.f38579o = str;
    }

    /* renamed from: D */
    public String m51703D() {
        return this.f38572h;
    }

    /* renamed from: E */
    public void m51704E(String str) {
        this.f38584t = str;
    }

    /* renamed from: F */
    public String m51705F() {
        return this.f38577m;
    }

    /* renamed from: G */
    public void m51706G(String str) {
        this.f38572h = str;
    }

    /* renamed from: H */
    public String m51707H() {
        return this.f38576l;
    }

    /* renamed from: I */
    public void m51708I(String str) {
        this.f38577m = str;
    }

    /* renamed from: J */
    public String m51709J() {
        return this.f38582r;
    }

    /* renamed from: K */
    public void m51710K(String str) {
        this.f38576l = str;
    }

    /* renamed from: L */
    public String m51711L() {
        return this.f38583s;
    }

    /* renamed from: M */
    public void m51712M(String str) {
        this.f38586v = str;
    }

    /* renamed from: N */
    public String m51713N() {
        return this.f38573i;
    }

    /* renamed from: O */
    public void m51714O(String str) {
        this.f38582r = str;
    }

    /* renamed from: P */
    public String m51715P() {
        return this.f38574j;
    }

    /* renamed from: Q */
    public void m51716Q(String str) {
        this.f38583s = str;
    }

    /* renamed from: R */
    public void m51717R(String str) {
        this.f38574j = str;
    }

    /* renamed from: a */
    public String m51718a() {
        return this.f38571g;
    }

    /* renamed from: c */
    public final void m51719c(int i10, View view) {
        view.setOnClickListener(new ViewOnClickListenerC8282a(i10));
    }

    /* renamed from: d */
    public void m51720d(String str) {
        this.f38571g = str;
    }

    /* renamed from: e */
    public void m51721e(List<C8342b.a> list) {
        this.f38587w.addAll(list);
        notifyDataSetChanged();
    }

    /* renamed from: g */
    public String m51722g() {
        return this.f38575k;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f38587w.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewInflate;
        C8283b c8283b;
        if (view == null) {
            c8283b = new C8283b();
            viewInflate = LayoutInflater.from(this.f38565a).inflate(R$layout.faq_sdk_adapter_faq_secondary_list_item, viewGroup, false);
            c8283b.f38590a = (TextView) viewInflate.findViewById(R$id.tv_name);
            c8283b.f38591b = viewInflate.findViewById(R$id.divider_view);
            c8283b.f38592c = (ListItemRelativeLayout) viewInflate.findViewById(R$id.item_rl);
            viewInflate.setTag(c8283b);
        } else {
            viewInflate = view;
            c8283b = (C8283b) view.getTag();
        }
        FaqTahitiUtils.setMargins(c8283b.f38592c, this.f38565a.getResources().getDimensionPixelOffset(C8732R.dimen.emui_dimens_max_start), this.f38565a.getResources().getDimensionPixelOffset(C8732R.dimen.emui_dimens_max_end));
        c8283b.f38591b.setVisibility(i10 == getCount() + (-1) ? 8 : 0);
        c8283b.f38590a.setText(this.f38587w.get(i10).m51995c());
        m51719c(i10, viewInflate);
        return viewInflate;
    }

    /* renamed from: h */
    public void m51723h(String str) {
        this.f38575k = str;
    }

    /* renamed from: i */
    public String m51724i() {
        return this.f38567c;
    }

    /* renamed from: k */
    public void m51725k(String str) {
        this.f38567c = str;
    }

    /* renamed from: l */
    public String m51726l() {
        return this.f38581q;
    }

    /* renamed from: m */
    public void m51727m(String str) {
        this.f38581q = str;
    }

    /* renamed from: n */
    public String m51728n() {
        return this.f38585u;
    }

    /* renamed from: o */
    public void m51729o(String str) {
        this.f38585u = str;
    }

    /* renamed from: p */
    public String m51730p() {
        return this.f38568d;
    }

    /* renamed from: q */
    public void m51731q(String str) {
        this.f38568d = str;
    }

    /* renamed from: r */
    public String m51732r() {
        return this.f38569e;
    }

    /* renamed from: s */
    public void m51733s(String str) {
        this.f38569e = str;
    }

    /* renamed from: t */
    public String m51734t() {
        return this.f38580p;
    }

    /* renamed from: u */
    public void m51735u(String str) {
        this.f38580p = str;
    }

    /* renamed from: v */
    public String m51736v() {
        return this.f38578n;
    }

    /* renamed from: w */
    public void m51737w(String str) {
        this.f38578n = str;
    }

    /* renamed from: x */
    public String m51738x() {
        return this.f38570f;
    }

    /* renamed from: y */
    public void m51739y(String str) {
        this.f38573i = str;
    }

    /* renamed from: z */
    public String m51740z() {
        return this.f38579o;
    }
}
