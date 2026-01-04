package be;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.PurchaseCloudCardActivity;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.GradeCardSmallView;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.GradeCardDisplayBean;
import com.huawei.cloud.pay.model.PackageGrades;
import java.util.List;
import p398jj.ViewOnTouchListenerC10893b;
import p514o9.C11828b;
import sk.C12809f;

/* renamed from: be.a */
/* loaded from: classes3.dex */
public class C1165a extends BaseAdapter {

    /* renamed from: a */
    public List<CloudPackage> f5474a;

    /* renamed from: b */
    public List<PackageGrades> f5475b;

    /* renamed from: c */
    public Activity f5476c;

    /* renamed from: d */
    public int f5477d = -1;

    /* renamed from: e */
    public String f5478e;

    /* renamed from: f */
    public C11828b f5479f;

    /* renamed from: be.a$b */
    public static class b implements View.OnClickListener {

        /* renamed from: a */
        public int f5480a;

        /* renamed from: b */
        public Activity f5481b;

        public b(Activity activity, int i10) {
            this.f5481b = activity;
            this.f5480a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity = this.f5481b;
            if (activity instanceof PurchaseCloudCardActivity) {
                ((PurchaseCloudCardActivity) activity).m23759Q5(this.f5480a);
            }
        }
    }

    /* renamed from: be.a$c */
    public static class c {

        /* renamed from: a */
        public ImageView f5482a;

        /* renamed from: b */
        public GradeCardSmallView f5483b;

        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public C1165a(Activity activity) {
        this.f5476c = activity;
    }

    /* renamed from: a */
    public final PackageGrades m7276a(CloudPackage cloudPackage, List<PackageGrades> list) {
        String gradeCode = cloudPackage.getGradeCode();
        if (TextUtils.isEmpty(gradeCode)) {
            return null;
        }
        for (PackageGrades packageGrades : list) {
            if (gradeCode.equals(packageGrades.getGradeCode())) {
                return packageGrades;
            }
        }
        return null;
    }

    /* renamed from: b */
    public final View m7277b() {
        Object systemService = this.f5476c.getSystemService("layout_inflater");
        LayoutInflater layoutInflater = systemService instanceof LayoutInflater ? (LayoutInflater) systemService : null;
        if (layoutInflater != null) {
            return layoutInflater.inflate(R$layout.purchase_card_grid_item_layout, (ViewGroup) null);
        }
        return null;
    }

    /* renamed from: c */
    public void m7278c(List<CloudPackage> list, List<PackageGrades> list2, String str, C11828b c11828b) {
        this.f5474a = list;
        this.f5475b = list2;
        this.f5478e = str;
        this.f5479f = c11828b;
        notifyDataSetChanged();
    }

    /* renamed from: d */
    public void m7279d(int i10) {
        this.f5477d = i10;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<CloudPackage> list = this.f5474a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        List<CloudPackage> list;
        if (i10 >= getCount() || (list = this.f5474a) == null) {
            return null;
        }
        return list.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        c cVar;
        CloudPackage cloudPackage;
        PackageGrades packageGradesM7276a;
        if (view == null) {
            c cVar2 = new c();
            View viewM7277b = m7277b();
            cVar2.f5483b = (GradeCardSmallView) C12809f.m76831d(viewM7277b, R$id.small_card_view);
            cVar2.f5482a = (ImageView) C12809f.m76831d(viewM7277b, R$id.grade_card_checkbox);
            viewM7277b.setTag(cVar2);
            cVar = cVar2;
            view = viewM7277b;
        } else {
            cVar = (c) view.getTag();
        }
        List<CloudPackage> list = this.f5474a;
        if (list == null || this.f5476c == null || (cloudPackage = list.get(i10)) == null || (packageGradesM7276a = m7276a(cloudPackage, this.f5475b)) == null) {
            return view;
        }
        cVar.f5483b.setData(new GradeCardDisplayBean(cloudPackage, packageGradesM7276a), this.f5478e, this.f5479f, false);
        Resources resources = this.f5476c.getResources();
        if (resources != null) {
            if (this.f5477d == i10) {
                cVar.f5482a.setBackground(resources.getDrawable(R$drawable.grade_card_selected));
                view.setAccessibilityDelegate(C2783d.m16128b1(true));
            } else {
                cVar.f5482a.setBackground(resources.getDrawable(R$drawable.grade_card_unselected));
                view.setAccessibilityDelegate(C2783d.m16128b1(false));
            }
        }
        view.setOnClickListener(new b(this.f5476c, i10));
        view.setOnTouchListener(new ViewOnTouchListenerC10893b(this.f5476c, cVar.f5483b, R$drawable.selected_foreground_rectangle_for_card));
        return view;
    }
}
