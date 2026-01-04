package be;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpacePayActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.MemberRightForPayActivity;
import com.huawei.android.p073ds.R$layout;
import com.huawei.cloud.pay.model.GradePicture;
import com.huawei.cloud.pay.model.MemGradeRight;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.LinkedHashMap;
import java.util.List;
import p054cj.C1442a;
import p336he.C10155f;
import p514o9.C11828b;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;

/* renamed from: be.d */
/* loaded from: classes3.dex */
public class C1168d extends RecyclerView.AbstractC0838h<C1169e> {

    /* renamed from: d */
    public Context f5522d;

    /* renamed from: e */
    public List<MemGradeRight> f5523e;

    /* renamed from: f */
    public C11828b f5524f;

    /* renamed from: g */
    public String f5525g;

    public C1168d(Context context, List<MemGradeRight> list, String str) {
        this.f5522d = context;
        this.f5523e = list;
        this.f5525g = str;
        if (context != null) {
            this.f5524f = new C11828b(context.getFilesDir() + "/gradeImageCache/");
        }
    }

    /* renamed from: E */
    public final GradePicture m7349E(List<GradePicture> list) {
        if (list == null || list.isEmpty()) {
            C1442a.m8289e("PaySuccessPrivilegesListAdapter", "getQualifiedPic gradePictureList is invalid.");
            return null;
        }
        for (GradePicture gradePicture : list) {
            if ("1".equals(gradePicture.getPictureType())) {
                return gradePicture;
            }
        }
        return null;
    }

    /* renamed from: F */
    public final /* synthetic */ void m7350F(MemGradeRight memGradeRight, boolean z10, View view) {
        m7353I(this.f5525g, memGradeRight.getRightCode());
        if (z10) {
            C1442a.m8291w("PaySuccessPrivilegesListAdapter", "new business not need jump");
            return;
        }
        Intent intent = new Intent(this.f5522d, (Class<?>) MemberRightForPayActivity.class);
        intent.putExtra("rightGradeCode", this.f5525g);
        intent.putExtra("rightRightCode", memGradeRight.getRightCode());
        intent.putExtra("isavailable", true);
        intent.putExtra("clickSourceType", "4");
        intent.putExtra("fromActivity", CloudSpacePayActivity.class.getSimpleName());
        Context context = this.f5522d;
        if (context != null) {
            context.startActivity(intent);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: G */
    public void mo723s(C1169e c1169e, int i10) {
        List<MemGradeRight> list = this.f5523e;
        if (list == null) {
            C1442a.m8289e("PaySuccessPrivilegesListAdapter", "memGradeRightList is null.");
            return;
        }
        if (list.size() == 0) {
            C1442a.m8291w("PaySuccessPrivilegesListAdapter", "memGradeRightList size is 0;");
            return;
        }
        final MemGradeRight memGradeRight = this.f5523e.get(i10);
        if (memGradeRight == null) {
            C1442a.m8289e("PaySuccessPrivilegesListAdapter", "memGradeRight is null.");
            return;
        }
        String rightName = memGradeRight.getRightName();
        if (TextUtils.isEmpty(rightName)) {
            C1442a.m8289e("PaySuccessPrivilegesListAdapter", "rightName is null.");
            return;
        }
        GradePicture gradePictureM7349E = m7349E(memGradeRight.getPictures());
        if (gradePictureM7349E == null) {
            C1442a.m8289e("PaySuccessPrivilegesListAdapter", "gradePicture is null.");
            return;
        }
        String url = gradePictureM7349E.getUrl();
        String hash = gradePictureM7349E.getHash();
        if (TextUtils.isEmpty(url) || TextUtils.isEmpty(hash)) {
            C1442a.m8289e("PaySuccessPrivilegesListAdapter", "pic url or hash is invalid.");
            return;
        }
        this.f5524f.m70496l(false);
        this.f5524f.m70491g(url, hash, c1169e.f5527v);
        c1169e.f5528w.setText(rightName);
        final boolean zM63293q = C10155f.m63293q(500L);
        c1169e.f5526u.setOnClickListener(new View.OnClickListener() { // from class: be.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5519a.m7350F(memGradeRight, zM63293q, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: H */
    public C1169e mo724u(ViewGroup viewGroup, int i10) {
        Context context = this.f5522d;
        if (context != null) {
            return new C1169e(LayoutInflater.from(context).inflate(R$layout.pay_sucess_privilege_list_model, viewGroup, false));
        }
        C1442a.m8291w("PaySuccessPrivilegesListAdapter", "onCreateViewHolder context is null");
        return null;
    }

    /* renamed from: I */
    public void m7353I(String str, String str2) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("grade_code", str);
            linkedHashMapM79497A.put("right_code", str2);
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_AFTER_PAY_PRIVILEGE_CLICK", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_AFTER_PAY_PRIVILEGE_CLICK", "1", "35", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("PaySuccessPrivilegesListAdapter", "reportPrivilegeClickEvent error occur:" + e10.getMessage());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<MemGradeRight> list = this.f5523e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
