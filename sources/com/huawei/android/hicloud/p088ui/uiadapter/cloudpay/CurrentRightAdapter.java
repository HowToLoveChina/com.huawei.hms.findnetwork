package com.huawei.android.hicloud.p088ui.uiadapter.cloudpay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.cloud.pay.model.GradePicture;
import com.huawei.cloud.pay.model.MemGradeRight;
import java.util.ArrayList;
import java.util.List;
import p398jj.ViewOnTouchListenerC10893b;
import p514o9.C11828b;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CurrentRightAdapter extends RecyclerView.AbstractC0838h<C4085b> {

    /* renamed from: d */
    public List<MemGradeRight> f19003d;

    /* renamed from: e */
    public Context f19004e;

    /* renamed from: f */
    public C11828b f19005f;

    /* renamed from: g */
    public OnItemClickListener f19006g;

    public interface OnItemClickListener {
        void onClick(int i10);
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.cloudpay.CurrentRightAdapter$a */
    public class ViewOnClickListenerC4084a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ int f19007a;

        public ViewOnClickListenerC4084a(int i10) {
            this.f19007a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CurrentRightAdapter.this.f19006g.onClick(this.f19007a);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.cloudpay.CurrentRightAdapter$b */
    public class C4085b extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public ImageView f19009u;

        /* renamed from: v */
        public RelativeLayout f19010v;

        public C4085b(View view) {
            super(view);
            this.f19009u = (ImageView) C12809f.m76831d(view, R$id.grade_right_icon);
            this.f19010v = (RelativeLayout) C12809f.m76831d(view, R$id.icon_layout);
        }
    }

    public CurrentRightAdapter(Context context) {
        this.f19004e = context;
    }

    /* renamed from: E */
    public static List<MemGradeRight> m25370E(List<MemGradeRight> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (MemGradeRight memGradeRight : list) {
                if (memGradeRight.getStatus() == 1) {
                    arrayList.add(memGradeRight);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: F */
    public View m25371F() {
        Object systemService = this.f19004e.getSystemService("layout_inflater");
        LayoutInflater layoutInflater = systemService instanceof LayoutInflater ? (LayoutInflater) systemService : null;
        if (layoutInflater != null) {
            return layoutInflater.inflate(R$layout.right_current_recycle_layout, (ViewGroup) null);
        }
        return null;
    }

    /* renamed from: G */
    public final void m25372G(List<GradePicture> list, C4085b c4085b) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (GradePicture gradePicture : list) {
            if (gradePicture != null && gradePicture.getPictureType().equals("1")) {
                String url = gradePicture.getUrl();
                String hash = gradePicture.getHash();
                C11828b c11828b = this.f19005f;
                if (c11828b != null) {
                    c11828b.m70491g(url, hash, c4085b.f19009u);
                    return;
                }
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public void mo723s(C4085b c4085b, int i10) {
        if (c4085b == null || i10 >= mo721e() || this.f19003d == null) {
            return;
        }
        if (this.f19006g != null) {
            c4085b.f4327a.setOnClickListener(new ViewOnClickListenerC4084a(i10));
        }
        c4085b.f4327a.setOnTouchListener(new ViewOnTouchListenerC10893b(this.f19004e, c4085b.f19010v, R$drawable.selected_foreground_oval));
        MemGradeRight memGradeRight = this.f19003d.get(i10);
        if (memGradeRight == null) {
            return;
        }
        c4085b.f4327a.setContentDescription(memGradeRight.getRightName());
        m25372G(memGradeRight.getPictures(), c4085b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public C4085b mo724u(ViewGroup viewGroup, int i10) {
        return new C4085b(m25371F());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<MemGradeRight> list = this.f19003d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: f */
    public long mo722f(int i10) {
        return i10;
    }
}
