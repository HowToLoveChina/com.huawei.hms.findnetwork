package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.sync.R$dimen;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p514o9.C11839m;
import p815ym.AbstractC14026a;
import sk.C12809f;
import tl.C13037p;

/* loaded from: classes3.dex */
public class SpaceSwitchSuggestAdapter extends BaseAdapter {

    /* renamed from: a */
    public LayoutInflater f18876a;

    /* renamed from: b */
    public OnSwitchStatusChangeListener f18877b;

    /* renamed from: n */
    public Context f18889n;

    /* renamed from: c */
    public final List<C13037p> f18878c = new ArrayList();

    /* renamed from: d */
    public final List<C13037p> f18879d = new ArrayList();

    /* renamed from: e */
    public final List<C13037p> f18880e = new ArrayList();

    /* renamed from: f */
    public C13037p f18881f = null;

    /* renamed from: g */
    public C13037p f18882g = null;

    /* renamed from: h */
    public C13037p f18883h = null;

    /* renamed from: i */
    public C13037p f18884i = null;

    /* renamed from: j */
    public boolean f18885j = false;

    /* renamed from: k */
    public boolean f18886k = false;

    /* renamed from: l */
    public int f18887l = 0;

    /* renamed from: m */
    public int f18888m = 0;

    /* renamed from: o */
    public boolean f18890o = false;

    public interface OnSwitchStatusChangeListener {
        /* renamed from: a */
        void mo25258a();
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.SpaceSwitchSuggestAdapter$a */
    public class ViewOnClickListenerC4069a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ C13037p f18891a;

        public ViewOnClickListenerC4069a(C13037p c13037p) {
            this.f18891a = c13037p;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SpaceSwitchSuggestAdapter.this.m25250s(this.f18891a)) {
                SpaceSwitchSuggestAdapter.this.f18885j = !r2.f18885j;
            } else {
                SpaceSwitchSuggestAdapter.this.f18886k = !r2.f18886k;
            }
            SpaceSwitchSuggestAdapter.this.m25238B();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.SpaceSwitchSuggestAdapter$b */
    public static class C4070b {

        /* renamed from: a */
        public ImageView f18893a;

        /* renamed from: b */
        public TextView f18894b;

        /* renamed from: c */
        public UnionSwitch f18895c;

        /* renamed from: d */
        public TextView f18896d;

        /* renamed from: e */
        public View f18897e;

        /* renamed from: f */
        public View f18898f;

        /* renamed from: g */
        public View f18899g;

        /* renamed from: h */
        public View f18900h;

        public C4070b(View view) {
            this.f18893a = null;
            this.f18894b = null;
            this.f18895c = null;
            this.f18896d = null;
            this.f18897e = null;
            this.f18898f = null;
            this.f18899g = null;
            this.f18900h = null;
            if (view == null) {
                C11839m.m70687e("SpaceSwitchSuggestAdapter", "ViewHolder is null");
                return;
            }
            this.f18893a = (ImageView) C12809f.m76831d(view, R$id.backup_option_list_item_icon);
            this.f18894b = (TextView) C12809f.m76831d(view, R$id.backup_option_list_item_title);
            this.f18895c = (UnionSwitch) C12809f.m76831d(view, R$id.backup_main_switch_btn);
            this.f18898f = C12809f.m76831d(view, R$id.switch_item_info);
            this.f18896d = (TextView) C12809f.m76831d(view, R$id.backup_option_view_more);
            this.f18897e = C12809f.m76831d(view, R$id.backup_option_view_more_view);
            this.f18899g = C12809f.m76831d(view, R$id.switch_category_divider);
            this.f18900h = C12809f.m76831d(view, R$id.switch_item_divider);
        }
    }

    public SpaceSwitchSuggestAdapter(Context context) {
        this.f18889n = context;
        this.f18876a = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: A */
    public final void m25237A(C4070b c4070b, C13037p c13037p) {
        c4070b.f18898f.setVisibility(8);
        c4070b.f18897e.setVisibility(0);
        c4070b.f18900h.setVisibility(8);
        c4070b.f18899g.setVisibility(8);
        m25257z(c4070b, c13037p);
        c4070b.f18897e.setOnClickListener(new ViewOnClickListenerC4069a(c13037p));
    }

    /* renamed from: B */
    public void m25238B() {
        if (this.f18890o) {
            return;
        }
        this.f18878c.clear();
        m25248q(this.f18880e, false, this.f18886k);
        m25248q(this.f18879d, true, this.f18885j);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18878c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        if (i10 >= 0 && i10 < this.f18878c.size()) {
            return this.f18878c.get(i10);
        }
        C11839m.m70689w("SpaceSwitchSuggestAdapter", "getItem position error: " + i10);
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        C4070b c4070b;
        C11839m.m70686d("SpaceSwitchSuggestAdapter", "SpaceSwitchOptionItem position: " + i10);
        List<C13037p> list = this.f18878c;
        if (list == null || i10 >= list.size()) {
            C11839m.m70689w("SpaceSwitchSuggestAdapter", "SpaceSwitchOptionItem list size is small.");
            return view;
        }
        C13037p c13037p = (C13037p) getItem(i10);
        if (c13037p == null) {
            C11839m.m70689w("SpaceSwitchSuggestAdapter", "SpaceSwitchOptionItem item is null.");
            return view;
        }
        if (view == null) {
            view = C12809f.m76832e(this.f18876a, R$layout.backup_switch_suggest_option);
            c4070b = new C4070b(view);
            view.setTag(c4070b);
        } else {
            c4070b = (C4070b) view.getTag();
        }
        view.setAccessibilityDelegate(C2783d.m16078D0());
        if (c4070b == null) {
            C11839m.m70689w("SpaceSwitchSuggestAdapter", "SpaceSwitchOptionItem viewHolder is null.");
            return view;
        }
        int iM78579e = c13037p.m78579e();
        if (iM78579e == 0) {
            m25255x(c4070b, c13037p, i10);
        } else if (iM78579e == 1) {
            m25256y(c4070b, c13037p);
        } else if (iM78579e != 2) {
            C11839m.m70687e("SpaceSwitchSuggestAdapter", "SpaceSwitchOptionItem item type error: " + c13037p.m78579e());
        } else {
            m25237A(c4070b, c13037p);
        }
        return view;
    }

    /* renamed from: h */
    public void m25239h(C13037p c13037p) {
        if (m25251t(c13037p)) {
            this.f18880e.add(c13037p);
        } else if (m25250s(c13037p)) {
            this.f18879d.add(c13037p);
        }
        this.f18878c.add(c13037p);
    }

    /* renamed from: i */
    public final boolean m25240i(C13037p c13037p, int i10) {
        if (m25250s(c13037p)) {
            return i10 < this.f18879d.size();
        }
        return i10 < (this.f18878c.size() - (this.f18886k ? 1 : 0)) - 1;
    }

    /* renamed from: j */
    public final void m25241j(boolean z10, boolean z11, List<C13037p> list) {
        if (AbstractC14026a.m84159a(list)) {
            return;
        }
        Iterator<C13037p> it = list.iterator();
        while (it.hasNext()) {
            it.next().m78588n(z11);
            m25242k(z10, z11);
        }
        notifyDataSetChanged();
    }

    /* renamed from: k */
    public final void m25242k(boolean z10, boolean z11) {
        if (z10) {
            if (z11) {
                this.f18887l--;
                return;
            } else {
                this.f18887l++;
                return;
            }
        }
        if (z11) {
            this.f18888m--;
        } else {
            this.f18888m++;
        }
    }

    /* renamed from: l */
    public final C13037p m25243l(boolean z10, boolean z11) {
        C13037p c13037p = new C13037p();
        c13037p.m78588n(true);
        if (!z11) {
            c13037p.m78584j(this.f18889n.getString(z10 ? R$string.member_data_backup : R$string.member_data_sync));
        }
        c13037p.m78590p(z10 ? 1 : 0);
        c13037p.m78587m(z11 ? 2 : 1);
        return c13037p;
    }

    /* renamed from: m */
    public final void m25244m(boolean z10) {
        if (z10) {
            C13037p c13037p = this.f18881f;
            if (c13037p != null) {
                c13037p.m78588n(this.f18887l == 0);
                return;
            }
            return;
        }
        C13037p c13037p2 = this.f18882g;
        if (c13037p2 != null) {
            c13037p2.m78588n(this.f18888m == 0);
        }
    }

    /* renamed from: n */
    public List<C13037p> m25245n() {
        ArrayList arrayList = new ArrayList(this.f18879d);
        arrayList.addAll(this.f18880e);
        return arrayList;
    }

    /* renamed from: o */
    public final C13037p m25246o(boolean z10, boolean z11) {
        return z10 ? z11 ? this.f18883h : this.f18881f : z11 ? this.f18884i : this.f18882g;
    }

    /* renamed from: p */
    public void m25247p(boolean z10) {
        this.f18890o = z10;
        if (z10) {
            C11839m.m70688i("SpaceSwitchSuggestAdapter", "initList mode is old");
            return;
        }
        if (!AbstractC14026a.m84159a(this.f18879d)) {
            this.f18881f = m25243l(true, false);
        }
        if (!AbstractC14026a.m84159a(this.f18880e)) {
            this.f18882g = m25243l(false, false);
        }
        if (this.f18879d.size() > 3) {
            this.f18883h = m25243l(true, true);
        }
        if (this.f18880e.size() > 3) {
            this.f18884i = m25243l(false, true);
        }
        m25238B();
    }

    /* renamed from: q */
    public final void m25248q(List<C13037p> list, boolean z10, boolean z11) {
        if (AbstractC14026a.m84159a(list)) {
            C11839m.m70689w("SpaceSwitchSuggestAdapter", "initModuleList list is null. " + z10);
            return;
        }
        this.f18878c.add(m25246o(z10, false));
        if (list.size() <= 3) {
            this.f18878c.addAll(list);
            return;
        }
        List<C13037p> list2 = this.f18878c;
        if (!z11) {
            list = list.subList(0, 3);
        }
        list2.addAll(list);
        this.f18878c.add(m25246o(z10, true));
    }

    /* renamed from: r */
    public boolean m25249r() {
        return (this.f18887l == this.f18879d.size()) && (this.f18888m == this.f18880e.size());
    }

    /* renamed from: s */
    public final boolean m25250s(C13037p c13037p) {
        return c13037p != null && c13037p.m78581g() == 1;
    }

    /* renamed from: t */
    public final boolean m25251t(C13037p c13037p) {
        return c13037p != null && c13037p.m78581g() == 0;
    }

    /* renamed from: u */
    public final /* synthetic */ void m25252u(C13037p c13037p, CompoundButton compoundButton, boolean z10) {
        c13037p.m78588n(z10);
        m25242k(m25250s(c13037p), z10);
        m25244m(m25250s(c13037p));
        OnSwitchStatusChangeListener onSwitchStatusChangeListener = this.f18877b;
        if (onSwitchStatusChangeListener != null) {
            onSwitchStatusChangeListener.mo25258a();
        }
        notifyDataSetChanged();
    }

    /* renamed from: v */
    public final /* synthetic */ void m25253v(C13037p c13037p, CompoundButton compoundButton, boolean z10) {
        c13037p.m78588n(z10);
        boolean zM25250s = m25250s(c13037p);
        m25241j(zM25250s, z10, zM25250s ? this.f18879d : this.f18880e);
        OnSwitchStatusChangeListener onSwitchStatusChangeListener = this.f18877b;
        if (onSwitchStatusChangeListener != null) {
            onSwitchStatusChangeListener.mo25258a();
        }
    }

    /* renamed from: w */
    public void m25254w(OnSwitchStatusChangeListener onSwitchStatusChangeListener) {
        this.f18877b = onSwitchStatusChangeListener;
    }

    /* renamed from: x */
    public final void m25255x(C4070b c4070b, final C13037p c13037p, int i10) {
        C11839m.m70686d("SpaceSwitchSuggestAdapter", "SpaceSwitchOptionItem appId: " + c13037p.m78575a());
        c4070b.f18898f.setVisibility(0);
        c4070b.f18898f.setMinimumHeight(this.f18889n.getResources().getDimensionPixelSize(R$dimen.list_min_height_with_icon));
        c4070b.f18893a.setVisibility(0);
        c4070b.f18894b.setVisibility(0);
        c4070b.f18895c.setVisibility(0);
        c4070b.f18897e.setVisibility(8);
        c4070b.f18900h.setVisibility(m25240i(c13037p, i10) ? 0 : 8);
        c4070b.f18899g.setVisibility(8);
        c4070b.f18895c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ae.d2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f424a.m25252u(c13037p, compoundButton, z10);
            }
        });
        c4070b.f18895c.setCheckedProgrammatically(c13037p.m78582h());
        c4070b.f18894b.setText(c13037p.m78576b());
        if (c13037p.m78577c() != null) {
            c4070b.f18893a.setImageBitmap(c13037p.m78577c());
        } else {
            c4070b.f18893a.setImageDrawable(c13037p.m78578d());
        }
    }

    /* renamed from: y */
    public final void m25256y(C4070b c4070b, final C13037p c13037p) {
        c4070b.f18898f.setVisibility(0);
        c4070b.f18898f.setMinimumHeight(this.f18889n.getResources().getDimensionPixelSize(R$dimen.list_min_height));
        c4070b.f18893a.setVisibility(8);
        c4070b.f18894b.setVisibility(0);
        c4070b.f18895c.setVisibility(0);
        c4070b.f18897e.setVisibility(8);
        c4070b.f18900h.setVisibility(8);
        c4070b.f18899g.setVisibility(0);
        c4070b.f18895c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ae.e2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f440a.m25253v(c13037p, compoundButton, z10);
            }
        });
        c4070b.f18895c.setCheckedProgrammatically(c13037p.m78582h());
        c4070b.f18894b.setText(c13037p.m78576b());
    }

    /* renamed from: z */
    public final void m25257z(C4070b c4070b, C13037p c13037p) {
        boolean z10 = this.f18886k;
        if (m25250s(c13037p)) {
            z10 = this.f18885j;
        }
        c4070b.f18896d.setText(this.f18889n.getString(z10 ? R$string.collapse : R$string.view_more));
    }
}
