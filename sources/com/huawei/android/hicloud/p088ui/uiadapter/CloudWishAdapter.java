package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.CloudWish;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import p015ak.C0241z;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudWishAdapter extends RecyclerView.AbstractC0838h<RecyclerView.AbstractC0833c0> {

    /* renamed from: d */
    public final Context f18714d;

    /* renamed from: g */
    public OnItemClickListener f18717g;

    /* renamed from: h */
    public OnItemLongClickListener f18718h;

    /* renamed from: i */
    public OnCheckClickListener f18719i;

    /* renamed from: e */
    public final List<CloudWish> f18715e = new ArrayList();

    /* renamed from: f */
    public final List<CloudWish> f18716f = new ArrayList();

    /* renamed from: j */
    public int f18720j = 2;

    /* renamed from: k */
    public boolean f18721k = false;

    public interface OnCheckClickListener {
        /* renamed from: Y */
        void mo20271Y(CloudWish cloudWish, int i10);
    }

    public interface OnItemClickListener {
        /* renamed from: p */
        void mo20286p(CloudWishAdapter cloudWishAdapter, CloudWish cloudWish, int i10);
    }

    public interface OnItemLongClickListener {
        /* renamed from: F */
        boolean mo20270F(CloudWishAdapter cloudWishAdapter, CloudWish cloudWish, int i10);
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.CloudWishAdapter$a */
    public class ViewOnClickListenerC4046a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ CloudWish f18722a;

        /* renamed from: b */
        public final /* synthetic */ int f18723b;

        public ViewOnClickListenerC4046a(CloudWish cloudWish, int i10) {
            this.f18722a = cloudWish;
            this.f18723b = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CloudWishAdapter.this.f18719i != null) {
                CloudWishAdapter.this.f18719i.mo20271Y(this.f18722a, this.f18723b);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.CloudWishAdapter$b */
    public class ViewOnClickListenerC4047b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ CloudWish f18725a;

        /* renamed from: b */
        public final /* synthetic */ int f18726b;

        public ViewOnClickListenerC4047b(CloudWish cloudWish, int i10) {
            this.f18725a = cloudWish;
            this.f18726b = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CloudWishAdapter.this.f18717g != null) {
                CloudWishAdapter.this.f18717g.mo20286p(CloudWishAdapter.this, this.f18725a, this.f18726b);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.CloudWishAdapter$c */
    public class ViewOnLongClickListenerC4048c implements View.OnLongClickListener {

        /* renamed from: a */
        public final /* synthetic */ CloudWish f18728a;

        /* renamed from: b */
        public final /* synthetic */ int f18729b;

        public ViewOnLongClickListenerC4048c(CloudWish cloudWish, int i10) {
            this.f18728a = cloudWish;
            this.f18729b = i10;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (CloudWishAdapter.this.f18718h != null) {
                return CloudWishAdapter.this.f18718h.mo20270F(CloudWishAdapter.this, this.f18728a, this.f18729b);
            }
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.CloudWishAdapter$d */
    public static class C4049d extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public View f18731u;

        public C4049d(View view) {
            super(view);
            this.f18731u = C12809f.m76831d(view, R$id.wish_more);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.CloudWishAdapter$e */
    public static class C4050e extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public View f18732u;

        /* renamed from: v */
        public TextView f18733v;

        /* renamed from: w */
        public TextView f18734w;

        /* renamed from: x */
        public CheckBox f18735x;

        public C4050e(View view) {
            super(view);
            this.f18732u = C12809f.m76831d(view, R$id.content_layout);
            this.f18733v = (TextView) C12809f.m76831d(view, R$id.tv_wish_title);
            this.f18734w = (TextView) C12809f.m76831d(view, R$id.tv_wish_date);
            this.f18735x = (CheckBox) C12809f.m76831d(view, R$id.cb_wish);
        }
    }

    public CloudWishAdapter(Context context) {
        this.f18714d = context;
    }

    /* renamed from: G */
    public void m25001G(List<CloudWish> list) {
        this.f18715e.addAll(list);
    }

    /* renamed from: H */
    public List<CloudWish> m25002H() {
        return this.f18715e;
    }

    /* renamed from: I */
    public List<CloudWish> m25003I() {
        return this.f18716f;
    }

    /* renamed from: J */
    public CloudWish m25004J(int i10) {
        if (i10 < 0 || i10 >= this.f18715e.size()) {
            return null;
        }
        return this.f18715e.get(i10);
    }

    /* renamed from: K */
    public boolean m25005K() {
        return this.f18721k;
    }

    /* renamed from: L */
    public boolean m25006L() {
        return this.f18720j == 1;
    }

    /* renamed from: M */
    public void m25007M(boolean z10) {
        this.f18721k = z10;
        m5213j();
    }

    /* renamed from: N */
    public void m25008N(OnCheckClickListener onCheckClickListener) {
        this.f18719i = onCheckClickListener;
    }

    /* renamed from: O */
    public void m25009O(OnItemClickListener onItemClickListener) {
        this.f18717g = onItemClickListener;
    }

    /* renamed from: P */
    public void m25010P(OnItemLongClickListener onItemLongClickListener) {
        this.f18718h = onItemLongClickListener;
    }

    /* renamed from: Q */
    public void m25011Q() {
        this.f18720j = 3;
    }

    /* renamed from: R */
    public void m25012R() {
        this.f18720j = 2;
    }

    /* renamed from: S */
    public void m25013S() {
        this.f18720j = 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        return this.f18715e.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        return i10 >= this.f18715e.size() ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        if (abstractC0833c0 instanceof C4049d) {
            C4049d c4049d = (C4049d) abstractC0833c0;
            if (this.f18720j == 1) {
                c4049d.f18731u.setVisibility(0);
                return;
            } else {
                c4049d.f18731u.setVisibility(8);
                return;
            }
        }
        if (abstractC0833c0 instanceof C4050e) {
            C4050e c4050e = (C4050e) abstractC0833c0;
            CloudWish cloudWishM25004J = m25004J(i10);
            String title = cloudWishM25004J.getTitle();
            if (!TextUtils.isEmpty(title)) {
                c4050e.f18733v.setText(title);
            }
            String createTime = cloudWishM25004J.getCreateTime();
            if (!TextUtils.isEmpty(title)) {
                c4050e.f18734w.setText(this.f18714d.getString(R$string.wish_list_wish_date2, DateFormat.getDateFormat(this.f18714d).format(new Date(C0241z.m1688f(createTime)))));
            }
            if (this.f18721k) {
                c4050e.f18735x.setVisibility(0);
                c4050e.f18735x.setChecked(cloudWishM25004J.isChecked());
                c4050e.f18735x.setOnClickListener(new ViewOnClickListenerC4046a(cloudWishM25004J, i10));
            } else {
                c4050e.f18735x.setVisibility(8);
                c4050e.f18735x.setChecked(false);
                c4050e.f18735x.setOnCheckedChangeListener(null);
            }
            if (this.f18715e.size() == 1) {
                c4050e.f18732u.setBackground(ContextCompat.getDrawable(this.f18714d, R$drawable.wish_list_bg_selector_radio));
            } else if (i10 == 0) {
                c4050e.f18732u.setBackground(ContextCompat.getDrawable(this.f18714d, R$drawable.wish_list_bg_selector_top));
            } else if (i10 == this.f18715e.size() - 1) {
                c4050e.f18732u.setBackground(ContextCompat.getDrawable(this.f18714d, R$drawable.wish_list_bg_selector_bottom));
            } else {
                c4050e.f18732u.setBackground(ContextCompat.getDrawable(this.f18714d, R$drawable.wish_list_bg_selector_rect));
            }
            c4050e.f18732u.setOnClickListener(new ViewOnClickListenerC4047b(cloudWishM25004J, i10));
            c4050e.f18732u.setOnLongClickListener(new ViewOnLongClickListenerC4048c(cloudWishM25004J, i10));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        return 2 == i10 ? new C4049d(LayoutInflater.from(this.f18714d).inflate(R$layout.item_wish_list_footer, viewGroup, false)) : new C4050e(LayoutInflater.from(this.f18714d).inflate(R$layout.item_wish_list, viewGroup, false));
    }
}
