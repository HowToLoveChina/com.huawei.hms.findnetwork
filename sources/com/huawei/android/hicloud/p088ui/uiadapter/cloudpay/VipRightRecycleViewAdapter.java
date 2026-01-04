package com.huawei.android.hicloud.p088ui.uiadapter.cloudpay;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.cloud.pay.model.GradePicture;
import com.huawei.cloud.pay.model.MemGradeRightDetail;
import java.util.List;
import java.util.Map;
import p054cj.C1442a;
import p514o9.C11828b;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class VipRightRecycleViewAdapter extends RecyclerView.AbstractC0838h<RecyclerView.AbstractC0833c0> {

    /* renamed from: d */
    public final List<MemGradeRightDetail> f19041d;

    /* renamed from: e */
    public final LayoutInflater f19042e;

    /* renamed from: f */
    public final Activity f19043f;

    /* renamed from: g */
    public final C11828b f19044g;

    /* renamed from: h */
    public final String f19045h;

    /* renamed from: i */
    public boolean[] f19046i;

    /* renamed from: j */
    public View f19047j;

    /* renamed from: k */
    public int f19048k = 0;

    /* renamed from: l */
    public OnItemClickListener f19049l;

    public interface OnItemClickListener {
        /* renamed from: a */
        void mo23905a(C4093b c4093b, int i10);
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.cloudpay.VipRightRecycleViewAdapter$a */
    public class C4092a extends RecyclerView.AbstractC0833c0 {
        public C4092a(View view) {
            super(view);
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.cloudpay.VipRightRecycleViewAdapter$b */
    public class C4093b extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public final View f19052u;

        /* renamed from: v */
        public TextView f19053v;

        /* renamed from: w */
        public ImageView f19054w;

        /* renamed from: x */
        public TextView f19055x;

        /* renamed from: y */
        public TextView f19056y;

        /* renamed from: z */
        public ImageView f19057z;

        public C4093b(View view) {
            super(view);
            this.f19052u = view;
            this.f19054w = (ImageView) C12809f.m76831d(view, R$id.right_icon);
            this.f19055x = (TextView) C12809f.m76831d(view, R$id.right_title);
            this.f19056y = (TextView) C12809f.m76831d(view, R$id.right_introduction);
            this.f19053v = (TextView) C12809f.m76831d(view, R$id.desc_text);
            this.f19057z = (ImageView) C12809f.m76831d(view, R$id.arrow_icon);
        }

        /* renamed from: Q */
        public final /* synthetic */ void m25410Q(int i10, View view) {
            VipRightRecycleViewAdapter.this.f19049l.mo23905a(this, i10);
        }

        /* renamed from: R */
        public void m25411R(List<GradePicture> list, C4093b c4093b) {
            if (list == null || list.size() <= 0) {
                return;
            }
            for (GradePicture gradePicture : list) {
                if (gradePicture != null && gradePicture.getPictureType().equals("2")) {
                    String url = gradePicture.getUrl();
                    String hash = gradePicture.getHash();
                    if (VipRightRecycleViewAdapter.this.f19044g != null) {
                        VipRightRecycleViewAdapter.this.f19044g.m70491g(url, hash, c4093b.f19054w);
                        return;
                    }
                    return;
                }
            }
        }

        /* renamed from: S */
        public void m25412S(final int i10, MemGradeRightDetail memGradeRightDetail) {
            if (memGradeRightDetail == null) {
                return;
            }
            m25411R(memGradeRightDetail.getPictures(), this);
            this.f19055x.setText(memGradeRightDetail.getRightName());
            this.f19056y.setText(memGradeRightDetail.getRightShortDesc());
            Map i18ResourceMap = memGradeRightDetail.getI18ResourceMap();
            if (i18ResourceMap == null) {
                C1442a.m8289e("VipRightRecycleViewAdapter", "right getPropInsts is null");
                return;
            }
            String strM25405J = VipRightRecycleViewAdapter.this.m25405J(i18ResourceMap, "rightDesc");
            if (!TextUtils.isEmpty(strM25405J)) {
                this.f19053v.setText(strM25405J.replace("\\n", "\n"));
            }
            m25413T((VipRightRecycleViewAdapter.this.f19046i == null || i10 >= VipRightRecycleViewAdapter.this.f19046i.length) ? false : VipRightRecycleViewAdapter.this.f19046i[i10]);
            if (VipRightRecycleViewAdapter.this.f19049l != null) {
                this.f19052u.setOnClickListener(new View.OnClickListener() { // from class: be.j
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f5563a.m25410Q(i10, view);
                    }
                });
            }
        }

        /* renamed from: T */
        public void m25413T(boolean z10) {
            int i10 = C11842p.m70765S0() ? 90 : -90;
            if (z10) {
                this.f19053v.setVisibility(0);
                this.f19057z.setRotation(i10);
            } else {
                this.f19053v.setVisibility(8);
                this.f19057z.setRotation(0 - i10);
            }
        }
    }

    public VipRightRecycleViewAdapter(List<MemGradeRightDetail> list, LayoutInflater layoutInflater, Activity activity, C11828b c11828b, String str) {
        this.f19041d = list;
        this.f19042e = layoutInflater;
        this.f19043f = activity;
        this.f19044g = c11828b;
        this.f19045h = str;
    }

    /* renamed from: H */
    public void m25403H(View view) {
        this.f19047j = view;
        this.f19048k = 1;
    }

    /* renamed from: I */
    public MemGradeRightDetail m25404I(int i10) {
        return this.f19041d.get(i10);
    }

    /* renamed from: J */
    public final String m25405J(Map map, String str) {
        if (map != null && (map.get(str) instanceof String)) {
            return (String) map.get(str);
        }
        return null;
    }

    /* renamed from: K */
    public int m25406K() {
        return this.f19048k;
    }

    /* renamed from: L */
    public void m25407L(OnItemClickListener onItemClickListener) {
        this.f19049l = onItemClickListener;
    }

    /* renamed from: M */
    public void m25408M(int i10) {
        if (i10 < 0 || i10 >= mo721e()) {
            return;
        }
        boolean[] zArr = this.f19046i;
        if (zArr == null || zArr.length < mo721e()) {
            this.f19046i = new boolean[mo721e()];
        }
        this.f19046i[i10] = !r2[i10];
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        int i10 = this.f19048k;
        List<MemGradeRightDetail> list = this.f19041d;
        return i10 + (list == null ? 0 : list.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        return i10 < this.f19048k ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        if (abstractC0833c0 instanceof C4093b) {
            int i11 = this.f19048k;
            ((C4093b) abstractC0833c0).m25412S(i10 - i11, m25404I(i10 - i11));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        return i10 == 1 ? new C4093b(this.f19042e.inflate(R$layout.vip_right_list_item, viewGroup, false)) : new C4092a(this.f19047j);
    }
}
