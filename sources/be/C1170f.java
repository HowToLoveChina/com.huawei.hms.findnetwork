package be;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.GradePackageCardView;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.WorryFreeGradePackageCardView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.FilterAvailabalGradePackage;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.cloud.pay.model.Voucher;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import p054cj.C1442a;
import sk.C12809f;

/* renamed from: be.f */
/* loaded from: classes3.dex */
public class C1170f extends RecyclerView.AbstractC0838h<a> {

    /* renamed from: d */
    public Context f5529d;

    /* renamed from: e */
    public ArrayList<FilterAvailabalGradePackage> f5530e;

    /* renamed from: f */
    public GetClientUIConfigResp f5531f;

    /* renamed from: g */
    public String f5532g;

    /* renamed from: h */
    public List<Voucher> f5533h;

    /* renamed from: i */
    public a f5534i;

    /* renamed from: j */
    public BigDecimal f5535j;

    /* renamed from: k */
    public UserPackage f5536k;

    /* renamed from: be.f$a */
    public class a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public GradePackageCardView f5537u;

        /* renamed from: v */
        public WorryFreeGradePackageCardView f5538v;

        public a(View view) {
            super(view);
            if (view == null) {
                C1442a.m8290i("RecommendCardAdapter", "itemView is null");
            } else {
                this.f5537u = (GradePackageCardView) C12809f.m76831d(view, R$id.member_card_fragment);
                this.f5538v = (WorryFreeGradePackageCardView) C12809f.m76831d(view, R$id.worry_free_member_card_fragment);
            }
        }
    }

    public C1170f(Context context, ArrayList<FilterAvailabalGradePackage> arrayList, GetClientUIConfigResp getClientUIConfigResp, String str, List<Voucher> list, UserPackage userPackage) {
        this.f5533h = new ArrayList();
        C1442a.m8291w("RecommendCardAdapter", "RecommendCardAdapter");
        this.f5529d = context;
        this.f5530e = arrayList;
        this.f5531f = getClientUIConfigResp;
        this.f5532g = str;
        this.f5533h = list;
        this.f5536k = userPackage;
        if (userPackage != null) {
            this.f5535j = userPackage.getDeductAmount();
        }
    }

    /* renamed from: D */
    public void m7354D() {
        a aVar = this.f5534i;
        if (aVar == null || aVar.f5537u == null) {
            return;
        }
        this.f5534i.f5537u.m23576n();
    }

    /* renamed from: E */
    public final boolean m7355E(a aVar, int i10) {
        if (this.f5529d == null || aVar == null || this.f5531f == null) {
            C1442a.m8291w("RecommendCardAdapter", "onBindViewHolder context is null");
            return false;
        }
        if (i10 > 2) {
            C1442a.m8291w("RecommendCardAdapter", "recommend list > 3 , position = " + i10);
            return false;
        }
        ArrayList<FilterAvailabalGradePackage> arrayList = this.f5530e;
        if (arrayList != null && !arrayList.isEmpty()) {
            return true;
        }
        C1442a.m8291w("RecommendCardAdapter", "recommendPackagesList is null or empty.");
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: F */
    public void mo723s(a aVar, int i10) {
        if (m7355E(aVar, i10)) {
            FilterAvailabalGradePackage filterAvailabalGradePackage = this.f5530e.get(i10);
            if (filterAvailabalGradePackage == null) {
                C1442a.m8289e("RecommendCardAdapter", "filterAvailabalGradePackage is null.");
            } else {
                m7358H(filterAvailabalGradePackage, aVar, !TextUtils.isEmpty(this.f5532g) && this.f5532g.equals(filterAvailabalGradePackage.getGradeCode()));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: G */
    public a mo724u(ViewGroup viewGroup, int i10) {
        C1442a.m8291w("RecommendCardAdapter", "onCreateViewHolder");
        Context context = this.f5529d;
        if (context == null) {
            C1442a.m8291w("RecommendCardAdapter", "onCreateViewHolder context is null");
            return null;
        }
        a aVar = new a(LayoutInflater.from(context).inflate(R$layout.recommend_member_card_item, viewGroup, false));
        this.f5534i = aVar;
        return aVar;
    }

    /* renamed from: H */
    public final void m7358H(FilterAvailabalGradePackage filterAvailabalGradePackage, a aVar, boolean z10) {
        if (filterAvailabalGradePackage == null) {
            C1442a.m8290i("RecommendCardAdapter", "refreshData filterAvailabalGradePackage is null.");
            return;
        }
        List<CloudPackage> incrementList = filterAvailabalGradePackage.getIncrementList();
        if (incrementList == null || incrementList.size() <= 0) {
            aVar.f5537u.setUser(this.f5536k);
            aVar.f5537u.m23552N(filterAvailabalGradePackage, this.f5531f, false, z10, this.f5533h, null, null, this.f5535j, (Activity) this.f5529d);
            aVar.f5538v.setVisibility(8);
            aVar.f5537u.setVisibility(0);
            aVar.f5537u.m23580q();
            return;
        }
        CloudPackage cloudPackage = incrementList.get(0);
        if (cloudPackage == null) {
            C1442a.m8290i("RecommendCardAdapter", "refreshData selectPackage is null.");
        } else if (cloudPackage.getProductType() == 12) {
            aVar.f5537u.setVisibility(8);
            aVar.f5538v.setVisibility(0);
            aVar.f5538v.m23900i(filterAvailabalGradePackage, this.f5531f, (Activity) this.f5529d);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        ArrayList<FilterAvailabalGradePackage> arrayList = this.f5530e;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }
}
