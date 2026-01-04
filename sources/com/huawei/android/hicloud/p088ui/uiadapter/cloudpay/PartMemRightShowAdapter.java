package com.huawei.android.hicloud.p088ui.uiadapter.cloudpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.MemberRightActivity;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.cloud.pay.model.GradePicture;
import com.huawei.cloud.pay.model.PackageGradeRight;
import com.huawei.cloud.pay.model.PurchaseNeedData;
import java.util.List;
import p015ak.C0209d;
import p054cj.C1442a;
import p252e9.C9433j;
import p514o9.C11828b;
import sk.C12809f;

/* loaded from: classes3.dex */
public class PartMemRightShowAdapter extends RecyclerView.AbstractC0838h<C4089b> {

    /* renamed from: d */
    public Context f19017d;

    /* renamed from: e */
    public List<PackageGradeRight> f19018e;

    /* renamed from: f */
    public String f19019f;

    /* renamed from: g */
    public boolean f19020g;

    /* renamed from: h */
    public PartMemRightShowCallBack f19021h;

    /* renamed from: i */
    public C11828b f19022i = C9433j.m59164c().m59165b();

    public interface PartMemRightShowCallBack {
        /* renamed from: o */
        PurchaseNeedData mo23429o();
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.cloudpay.PartMemRightShowAdapter$a */
    public class ViewOnClickListenerC4088a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ PackageGradeRight f19023a;

        public ViewOnClickListenerC4088a(PackageGradeRight packageGradeRight) {
            this.f19023a = packageGradeRight;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String rightCode;
            int status;
            if (C0209d.m1226Y0()) {
                C1442a.m8291w("PartMemRightShowAdapter", "onBindViewHolder click too fast");
                return;
            }
            if (PartMemRightShowAdapter.this.f19017d == null) {
                C1442a.m8289e("PartMemRightShowAdapter", "onBindViewHolder mContext is null.");
                return;
            }
            PackageGradeRight packageGradeRight = this.f19023a;
            if (packageGradeRight != null) {
                status = packageGradeRight.getStatus();
                rightCode = this.f19023a.getRightCode();
            } else {
                rightCode = null;
                status = 0;
            }
            if (status != 1 || TextUtils.isEmpty(rightCode) || TextUtils.isEmpty(PartMemRightShowAdapter.this.f19019f)) {
                return;
            }
            Intent intent = new Intent(PartMemRightShowAdapter.this.f19017d, (Class<?>) MemberRightActivity.class);
            intent.putExtra("isavailable", PartMemRightShowAdapter.this.f19020g);
            intent.putExtra("rightRightCode", rightCode);
            intent.putExtra("rightGradeCode", PartMemRightShowAdapter.this.f19019f);
            intent.putExtra("clickSourceType", "2");
            intent.putExtra("purchase_need_data", PartMemRightShowAdapter.this.f19021h.mo23429o());
            if (PartMemRightShowAdapter.this.f19017d instanceof Activity) {
                ((Activity) PartMemRightShowAdapter.this.f19017d).startActivityForResult(intent, 10010);
            } else {
                PartMemRightShowAdapter.this.f19017d.startActivity(intent);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.cloudpay.PartMemRightShowAdapter$b */
    public class C4089b extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public View f19025u;

        /* renamed from: v */
        public ImageView f19026v;

        /* renamed from: w */
        public ImageView f19027w;

        public C4089b(View view) {
            super(view);
            this.f19025u = view;
            this.f19026v = (ImageView) C12809f.m76831d(view, R$id.mem_right_img_bg);
            this.f19027w = (ImageView) C12809f.m76831d(view, R$id.mem_right_img);
        }
    }

    public PartMemRightShowAdapter(Context context, List<PackageGradeRight> list, String str, boolean z10, PartMemRightShowCallBack partMemRightShowCallBack) {
        this.f19017d = context;
        this.f19018e = list;
        this.f19019f = str;
        this.f19020g = z10;
        this.f19021h = partMemRightShowCallBack;
    }

    /* renamed from: H */
    public void m25386H(List<GradePicture> list, ImageView imageView) {
        if (list == null || list.size() <= 0) {
            C1442a.m8289e("PartMemRightShowAdapter", "loadPicture ,pictures is null or size is 0.");
            return;
        }
        for (GradePicture gradePicture : list) {
            if (gradePicture == null) {
                C1442a.m8289e("PartMemRightShowAdapter", "loadPicture ,picture is null.");
            } else if (gradePicture.getPictureType().equals("1")) {
                String url = gradePicture.getUrl();
                String hash = gradePicture.getHash();
                C11828b c11828b = this.f19022i;
                if (c11828b != null) {
                    c11828b.m70491g(url, hash, imageView);
                    return;
                }
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void mo723s(C4089b c4089b, int i10) {
        List<PackageGradeRight> list = this.f19018e;
        if (list == null) {
            C1442a.m8289e("PartMemRightShowAdapter", "onBindViewHolder gradeRightList is null.");
            return;
        }
        if (i10 >= list.size()) {
            C1442a.m8289e("PartMemRightShowAdapter", "onBindViewHolder position >= gradeRightList.size");
            return;
        }
        PackageGradeRight packageGradeRight = this.f19018e.get(i10);
        c4089b.f19026v.setImageResource(R$drawable.grade_right_ic_bg);
        m25386H(packageGradeRight.getPictures(), c4089b.f19027w);
        c4089b.f19027w.setContentDescription(packageGradeRight.getRightName());
        c4089b.f19026v.setVisibility(0);
        c4089b.f19025u.setOnClickListener(new ViewOnClickListenerC4088a(packageGradeRight));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public C4089b mo724u(ViewGroup viewGroup, int i10) {
        return new C4089b(LayoutInflater.from(this.f19017d).inflate(R$layout.part_mem_right_item, (ViewGroup) null, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<PackageGradeRight> list = this.f19018e;
        if (list == null) {
            C1442a.m8289e("PartMemRightShowAdapter", "getItemCount gradeRightList is null.");
            return 0;
        }
        int size = list.size();
        if (size >= 2) {
            return 2;
        }
        return size;
    }
}
