package com.huawei.android.hicloud.p088ui.uiadapter.cloudpay;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.cloud.pay.model.GradePicture;
import com.huawei.cloud.pay.model.PackageGradeRight;
import dk.EnumC9164e;
import java.util.ArrayList;
import java.util.List;
import p459lp.C11326d;
import p514o9.C11828b;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class RightGridAdapter extends BaseAdapter {

    /* renamed from: a */
    public List<PackageGradeRight> f19029a;

    /* renamed from: b */
    public Context f19030b;

    /* renamed from: c */
    public C11828b f19031c;

    /* renamed from: d */
    public String f19032d;

    /* renamed from: e */
    public int f19033e = -1;

    /* renamed from: f */
    public int f19034f = -1;

    /* renamed from: g */
    public boolean f19035g = false;

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.cloudpay.RightGridAdapter$a */
    public static /* synthetic */ class C4090a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f19036a;

        static {
            int[] iArr = new int[EnumC9164e.values().length];
            f19036a = iArr;
            try {
                iArr[EnumC9164e.LEVEL_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19036a[EnumC9164e.LEVEL_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19036a[EnumC9164e.LEVEL_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19036a[EnumC9164e.LEVEL_3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.cloudpay.RightGridAdapter$b */
    public static class C4091b {

        /* renamed from: a */
        public RelativeLayout f19037a;

        /* renamed from: b */
        public ImageView f19038b;

        /* renamed from: c */
        public ImageView f19039c;

        /* renamed from: d */
        public TextView f19040d;
    }

    public RightGridAdapter(Context context) {
        this.f19030b = context;
    }

    /* renamed from: a */
    public final List<PackageGradeRight> m25392a(List<PackageGradeRight> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (PackageGradeRight packageGradeRight : list) {
                if (packageGradeRight.getStatus() == 1) {
                    arrayList.add(packageGradeRight);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public int m25393b(String str) {
        int i10 = R$drawable.grade_right_back_default;
        if (TextUtils.isEmpty(str)) {
            return i10;
        }
        if (!C13452e.m80781L().m80887a1() && !TextUtils.equals(str, CloudBackupConstant.UserPackageInfo.TRIAL_MEMBER)) {
            if (TextUtils.equals(str, CloudBackupConstant.UserPackageInfo.ONE_T_MEMBER)) {
                return R$drawable.package_right_back_black_diamond;
            }
            int i11 = C4090a.f19036a[C11326d.m68044f(str).ordinal()];
            return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? R$drawable.grade_right_back_try : R$drawable.package_right_back_emerald : R$drawable.package_right_back_gold : R$drawable.package_right_back_silver : i10;
        }
        return R$drawable.grade_right_back_try;
    }

    /* renamed from: c */
    public int m25394c(String str) {
        int i10 = R$color.text_color_user_card_default;
        if (TextUtils.isEmpty(str) || C13452e.m80781L().m80887a1()) {
            return i10;
        }
        if (TextUtils.equals(str, CloudBackupConstant.UserPackageInfo.TRIAL_MEMBER)) {
            return R$color.text_color_user_card_try;
        }
        if (TextUtils.equals(str, CloudBackupConstant.UserPackageInfo.ONE_T_MEMBER)) {
            return R$color.text_color_user_card_diamond;
        }
        int i11 = C4090a.f19036a[C11326d.m68044f(str).ordinal()];
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? i10 : R$color.text_color_user_card_diamond : R$color.text_color_user_card_gold : R$color.text_color_user_card_silver : R$color.text_color_user_card_common;
    }

    /* renamed from: d */
    public View mo25395d() {
        Object systemService = this.f19030b.getSystemService("layout_inflater");
        LayoutInflater layoutInflater = systemService instanceof LayoutInflater ? (LayoutInflater) systemService : null;
        if (layoutInflater != null) {
            return layoutInflater.inflate(R$layout.right_grid_card_layout, (ViewGroup) null);
        }
        return null;
    }

    /* renamed from: e */
    public void m25396e(List<GradePicture> list, C4091b c4091b) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (GradePicture gradePicture : list) {
            if (gradePicture != null && gradePicture.getPictureType().equals("1")) {
                String url = gradePicture.getUrl();
                String hash = gradePicture.getHash();
                C11828b c11828b = this.f19031c;
                if (c11828b != null) {
                    c11828b.m70491g(url, hash, c4091b.f19038b);
                    return;
                }
                return;
            }
        }
    }

    /* renamed from: f */
    public void m25397f(int i10) {
        this.f19033e = i10;
    }

    /* renamed from: g */
    public void m25398g(List<PackageGradeRight> list, C11828b c11828b, boolean z10) {
        this.f19035g = z10;
        this.f19029a = m25392a(list);
        this.f19031c = c11828b;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<PackageGradeRight> list = this.f19029a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        List<PackageGradeRight> list;
        if (i10 >= getCount() || (list = this.f19029a) == null) {
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
        C4091b c4091b;
        List<PackageGradeRight> list;
        PackageGradeRight packageGradeRight;
        if (view == null) {
            C4091b c4091b2 = new C4091b();
            View viewMo25395d = mo25395d();
            c4091b2.f19037a = (RelativeLayout) C12809f.m76831d(viewMo25395d, R$id.right_icon_desc_layout);
            c4091b2.f19038b = (ImageView) C12809f.m76831d(viewMo25395d, R$id.grade_right_icon);
            c4091b2.f19039c = (ImageView) C12809f.m76831d(viewMo25395d, R$id.grade_right_back);
            c4091b2.f19040d = (TextView) C12809f.m76831d(viewMo25395d, R$id.right_desc_text);
            viewMo25395d.setTag(c4091b2);
            c4091b = c4091b2;
            view = viewMo25395d;
        } else {
            c4091b = (C4091b) view.getTag();
        }
        if (i10 >= getCount() || (list = this.f19029a) == null || (packageGradeRight = list.get(i10)) == null) {
            return view;
        }
        m25396e(packageGradeRight.getPictures(), c4091b);
        String rightName = packageGradeRight.getRightName();
        if (this.f19034f == -1) {
            this.f19034f = m25394c(this.f19032d);
        }
        if (rightName == null || !this.f19035g) {
            c4091b.f19040d.setVisibility(8);
            c4091b.f19040d.setText((CharSequence) null);
        } else {
            c4091b.f19040d.setVisibility(0);
            c4091b.f19040d.setText(rightName);
            c4091b.f19040d.setTextColor(this.f19030b.getColor(this.f19034f));
        }
        if (this.f19033e == -1) {
            this.f19033e = m25393b(this.f19032d);
        }
        c4091b.f19037a.setContentDescription(rightName);
        c4091b.f19037a.setAccessibilityDelegate(C2783d.m16078D0());
        c4091b.f19039c.setBackground(this.f19030b.getDrawable(this.f19033e));
        if (packageGradeRight.getStatus() == 0) {
            c4091b.f19037a.setAlpha(0.38f);
        } else {
            c4091b.f19037a.setAlpha(1.0f);
        }
        return view;
    }
}
