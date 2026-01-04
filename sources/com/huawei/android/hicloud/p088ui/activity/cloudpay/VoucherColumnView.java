package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.uiadapter.cloudpay.VoucherAdapter;
import com.huawei.android.p073ds.R$styleable;
import com.huawei.android.remotecontrol.p093ui.widget.TopAnimatorConfig;
import com.huawei.cloud.pay.R$color;
import com.huawei.cloud.pay.R$id;
import com.huawei.cloud.pay.R$layout;
import com.huawei.cloud.pay.R$plurals;
import com.huawei.cloud.pay.R$string;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.OnePackegeVouchers;
import com.huawei.cloud.pay.model.RecommendVouchers;
import com.huawei.cloud.pay.model.ReportVoucherInfo;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.cloud.pay.model.VoucherItemData;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p015ak.C0209d;
import p054cj.C1442a;
import p454lj.C11290m;
import p454lj.C11296s;
import p454lj.C11298u;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class VoucherColumnView extends LinearLayout implements VoucherAdapter.VoucherColumnCallback {

    /* renamed from: a */
    public Context f17433a;

    /* renamed from: b */
    public VoucherDialog f17434b;

    /* renamed from: c */
    public View f17435c;

    /* renamed from: d */
    public ImageView f17436d;

    /* renamed from: e */
    public TextView f17437e;

    /* renamed from: f */
    public TextView f17438f;

    /* renamed from: g */
    public ImageView f17439g;

    /* renamed from: h */
    public TextView f17440h;

    /* renamed from: i */
    public View f17441i;

    /* renamed from: j */
    public String f17442j;

    /* renamed from: k */
    public boolean f17443k;

    /* renamed from: l */
    public List<VoucherItemData> f17444l;

    /* renamed from: m */
    public List<Voucher> f17445m;

    /* renamed from: n */
    public UpdatePackagePriceCallback f17446n;

    /* renamed from: o */
    public int f17447o;

    /* renamed from: p */
    public int f17448p;

    /* renamed from: q */
    public RecommendVouchers f17449q;

    /* renamed from: r */
    public List<Voucher> f17450r;

    /* renamed from: s */
    public int f17451s;

    /* renamed from: t */
    public boolean f17452t;

    /* renamed from: u */
    public CloudPackage f17453u;

    /* renamed from: v */
    public BigDecimal f17454v;

    /* renamed from: w */
    public boolean f17455w;

    public interface UpdatePackagePriceCallback {
        /* renamed from: U */
        void mo23559U(BigDecimal bigDecimal, String str, List<Voucher> list);

        /* renamed from: m */
        void mo23575m();

        /* renamed from: n0 */
        void mo23577n0(String str);
    }

    public VoucherColumnView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17443k = true;
        this.f17445m = new ArrayList();
        this.f17451s = -1;
        this.f17452t = false;
        m23837g(context.obtainStyledAttributes(attributeSet, R$styleable.vouchercolumnview_attr));
        this.f17433a = context;
        m23836f();
    }

    private void setSelectVouchers(List<Voucher> list) {
        this.f17445m.clear();
        this.f17445m.addAll(list);
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.cloudpay.VoucherAdapter.VoucherColumnCallback
    /* renamed from: a */
    public void mo23831a(List<VoucherItemData> list, CloudPackage cloudPackage) {
        this.f17444l = list;
        if (list == null || list.isEmpty()) {
            C1442a.m8289e("VoucherColumnView", "updateVoucherState voucherItemDataList is empty.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (VoucherItemData voucherItemData : this.f17444l) {
            if (voucherItemData != null && voucherItemData.isSelected()) {
                arrayList.add(voucherItemData.getVoucher());
            }
        }
        setSelectVouchers(arrayList);
        m23842l(arrayList, cloudPackage, false, this.f17454v);
    }

    /* renamed from: b */
    public void m23832b() {
        View view = this.f17441i;
        if (view != null) {
            view.setBackground(null);
        }
    }

    /* renamed from: c */
    public void m23833c() {
        m23839i();
        VoucherDialog voucherDialog = this.f17434b;
        if (voucherDialog != null) {
            voucherDialog.m23852b();
        }
    }

    /* renamed from: d */
    public void m23834d() {
        float measuredWidth = getMeasuredWidth();
        float measuredWidth2 = this.f17439g.getMeasuredWidth();
        C1442a.m8290i("VoucherColumnView", "executeHilightAnim tansX=" + measuredWidth + ", hightWidth=" + measuredWidth2);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f17439g, "translationX", 0.0f, measuredWidth - measuredWidth2);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f17439g, TopAnimatorConfig.AnimatorType.ALPHA, 0.0f, 1.0f, 0.75f, 0.5f, 0.25f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(new C11298u(0.5f, 0.0f, 0.5f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(1250L);
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        animatorSet.start();
    }

    /* renamed from: e */
    public int m23835e(Context context) {
        if (context == null) {
            return 0;
        }
        int i10 = C11842p.m70876w(context).widthPixels;
        return (C11842p.m70771U0() && (context instanceof Activity) && C11842p.m70774V0((Activity) context)) ? (i10 * 6) / 10 : i10;
    }

    /* renamed from: f */
    public final void m23836f() {
        Context context = this.f17433a;
        if (context == null) {
            C1442a.m8289e("VoucherColumnView", "initView mContext is null.");
            return;
        }
        float fM1195O = C0209d.m1195O(context);
        if (fM1195O >= 3.2f) {
            this.f17435c = LayoutInflater.from(this.f17433a).inflate(this.f17452t ? R$layout.voucher_column_layout_3dot2 : R$layout.voucher_column_layout_2, this);
        } else if (fM1195O < 1.75f || fM1195O >= 3.2f) {
            this.f17435c = LayoutInflater.from(this.f17433a).inflate(R$layout.voucher_column_layout, this);
        } else {
            this.f17435c = LayoutInflater.from(this.f17433a).inflate(R$layout.voucher_column_layout_2, this);
        }
        this.f17447o = R$color.grade_card_volumn_text;
        this.f17436d = (ImageView) C12809f.m76831d(this.f17435c, R$id.voucher_column_iv);
        this.f17437e = (TextView) C12809f.m76831d(this.f17435c, R$id.voucher_column_select_text);
        this.f17438f = (TextView) C12809f.m76831d(this.f17435c, R$id.voucher_column_amount_text);
        this.f17440h = (TextView) C12809f.m76831d(this.f17435c, R$id.voucher_column_arrow_img);
        this.f17439g = (ImageView) C12809f.m76831d(this.f17435c, R$id.voucher_high_light);
        this.f17437e.setContentDescription(this.f17433a.getString(R$string.cloudpay_voucher_text));
        this.f17437e.setAccessibilityDelegate(C2783d.m16132d());
        this.f17441i = C12809f.m76831d(this.f17435c, R$id.voucher_colunm_container);
    }

    /* renamed from: g */
    public final void m23837g(TypedArray typedArray) {
        if (typedArray != null) {
            this.f17452t = typedArray.getBoolean(R$styleable.vouchercolumnview_attr_is_need_second_line_show, false);
        }
    }

    public int getColumnState() {
        return this.f17451s;
    }

    public ReportVoucherInfo getReportVoucherInfo() {
        CloudPackage cloudPackage;
        OnePackegeVouchers onePackegeVouchersM67837u;
        ReportVoucherInfo reportVoucherInfo = new ReportVoucherInfo();
        List<Voucher> list = this.f17450r;
        if (list != null && (cloudPackage = this.f17453u) != null && (onePackegeVouchersM67837u = C11296s.m67837u(list, cloudPackage, this.f17454v)) != null) {
            ArrayList arrayList = new ArrayList();
            List<Voucher> singleChoiceVoucherList = onePackegeVouchersM67837u.getSingleChoiceVoucherList();
            if (singleChoiceVoucherList != null && !singleChoiceVoucherList.isEmpty()) {
                arrayList.addAll(singleChoiceVoucherList);
            }
            List<Voucher> commonVoucherList = onePackegeVouchersM67837u.getCommonVoucherList();
            if (commonVoucherList != null && !commonVoucherList.isEmpty()) {
                arrayList.addAll(commonVoucherList);
            }
            reportVoucherInfo.setPackageVoucherList(C11296s.m67801Y(arrayList));
        }
        reportVoucherInfo.setSelectVoucherList(C11296s.m67801Y(this.f17445m));
        reportVoucherInfo.setRecommendVouchers(C11296s.m67794R(this.f17445m, this.f17449q));
        return reportVoucherInfo;
    }

    public List<Voucher> getSelectVouchers() {
        return this.f17445m;
    }

    public UpdatePackagePriceCallback getUpdatePackagePriceCallback() {
        return this.f17446n;
    }

    /* renamed from: h */
    public void m23838h() {
        this.f17442j = null;
        this.f17443k = true;
        List<VoucherItemData> list = this.f17444l;
        if (list != null) {
            list.clear();
        }
        List<Voucher> list2 = this.f17445m;
        if (list2 != null) {
            list2.clear();
        }
    }

    /* renamed from: i */
    public void m23839i() {
        VoucherDialog voucherDialog = this.f17434b;
        if (voucherDialog == null) {
            C1442a.m8289e("VoucherColumnView", "voucherdialog is null.");
            return;
        }
        Window window = voucherDialog.getWindow();
        if (window == null) {
            C1442a.m8289e("VoucherColumnView", "window is null.");
            return;
        }
        View decorView = window.getDecorView();
        if (decorView == null) {
            C1442a.m8289e("VoucherColumnView", "decorView is null.");
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (getResources() == null) {
            C1442a.m8289e("VoucherColumnView", "resources is null.");
            return;
        }
        int iM70825j0 = C11842p.m70825j0(this.f17433a);
        if (this.f17448p >= 9) {
            m23840j(window, attributes, iM70825j0);
            return;
        }
        decorView.measure(0, 0);
        int measuredHeight = decorView.getMeasuredHeight();
        if (measuredHeight <= iM70825j0) {
            iM70825j0 = measuredHeight;
        }
        m23840j(window, attributes, iM70825j0);
    }

    /* renamed from: j */
    public final void m23840j(Window window, WindowManager.LayoutParams layoutParams, int i10) {
        if (layoutParams == null) {
            C1442a.m8289e("VoucherColumnView", "attributes is null.");
            return;
        }
        Context context = this.f17433a;
        int iM70844o = (int) C11842p.m70844o(context, C11842p.m70829k0(context));
        if (iM70844o > m23835e(this.f17433a)) {
            iM70844o = 0;
        }
        if (iM70844o == 0) {
            iM70844o = -1;
        }
        layoutParams.width = iM70844o;
        if (i10 == 0) {
            i10 = -1;
        }
        layoutParams.height = i10;
        window.setAttributes(layoutParams);
    }

    /* renamed from: k */
    public void m23841k(List<Voucher> list, CloudPackage cloudPackage, boolean z10, String str, BigDecimal bigDecimal) {
        if (cloudPackage == null) {
            C1442a.m8289e("VoucherColumnView", "showColumnContent currentSelectedPackage is null.");
            return;
        }
        if (this.f17433a == null) {
            C1442a.m8289e("VoucherColumnView", "showColumnContent mContext is null.");
            return;
        }
        if (list == null) {
            C1442a.m8289e("VoucherColumnView", "showColumnContent voucherList is null.");
            m23848r();
            return;
        }
        this.f17454v = bigDecimal;
        BigDecimal bigDecimalM67838v = C11296s.m67838v(cloudPackage);
        this.f17453u = cloudPackage;
        String id2 = cloudPackage.getId();
        if (bigDecimalM67838v.compareTo(new BigDecimal(0)) == 0) {
            m23848r();
            String str2 = this.f17442j;
            if (str2 == null || !id2.equals(str2)) {
                this.f17443k = true;
                this.f17442j = id2;
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str) || !m23846p(list, cloudPackage, str)) {
            String str3 = this.f17442j;
            if (str3 == null || !id2.equals(str3)) {
                m23843m(list, cloudPackage, id2);
            } else {
                m23844n(list, cloudPackage, z10, bigDecimalM67838v);
            }
        }
    }

    /* renamed from: l */
    public void m23842l(List<Voucher> list, CloudPackage cloudPackage, boolean z10, BigDecimal bigDecimal) {
        if (z10) {
            this.f17450r = list;
        }
        m23841k(list, cloudPackage, z10, null, bigDecimal);
    }

    /* renamed from: m */
    public final void m23843m(List<Voucher> list, CloudPackage cloudPackage, String str) {
        this.f17443k = true;
        this.f17442j = str;
        OnePackegeVouchers onePackegeVouchersM67837u = C11296s.m67837u(list, cloudPackage, this.f17454v);
        if (onePackegeVouchersM67837u == null) {
            C1442a.m8289e("VoucherColumnView", "showVoucherDialog onePackegeVouchers is null.");
            m23848r();
            return;
        }
        RecommendVouchers recommendVouchersM67839w = C11296s.m67839w(cloudPackage, onePackegeVouchersM67837u, this.f17454v);
        this.f17449q = recommendVouchersM67839w;
        List<Voucher> voucherList = recommendVouchersM67839w.getVoucherList();
        if (voucherList == null || voucherList.isEmpty()) {
            m23848r();
        } else {
            setSelectVouchers(voucherList);
            m23847q(this.f17449q.getDiscountAmount(), cloudPackage);
        }
    }

    /* renamed from: n */
    public final void m23844n(List<Voucher> list, CloudPackage cloudPackage, boolean z10, BigDecimal bigDecimal) {
        if (z10) {
            return;
        }
        this.f17443k = false;
        if (!list.isEmpty()) {
            BigDecimal bigDecimal2 = new BigDecimal(0);
            Iterator<Voucher> it = list.iterator();
            while (it.hasNext()) {
                bigDecimal2 = bigDecimal2.add(C11296s.m67823k(cloudPackage, it.next(), this.f17454v));
            }
            if (bigDecimal2.compareTo(bigDecimal) < 0) {
                bigDecimal = bigDecimal2;
            }
            m23847q(bigDecimal, cloudPackage);
            return;
        }
        int i10 = 0;
        for (VoucherItemData voucherItemData : this.f17444l) {
            if (voucherItemData.getItemType() == 1 || voucherItemData.getItemType() == 2) {
                i10++;
            }
        }
        TextView textView = this.f17438f;
        Resources resources = this.f17433a.getResources();
        int i11 = R$plurals.cloudpay_cloumn_voucher_number;
        textView.setText(resources.getQuantityString(i11, i10, Integer.valueOf(i10)));
        this.f17438f.setContentDescription(this.f17433a.getResources().getQuantityString(i11, i10, Integer.valueOf(i10)));
        this.f17438f.setAccessibilityDelegate(C2783d.m16132d());
        this.f17451s = 1;
        TextView textView2 = this.f17440h;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        UpdatePackagePriceCallback updatePackagePriceCallback = this.f17446n;
        if (updatePackagePriceCallback != null) {
            updatePackagePriceCallback.mo23577n0(this.f17442j);
        }
    }

    /* renamed from: o */
    public final boolean m23845o(List<Voucher> list, CloudPackage cloudPackage, List<Voucher> list2) {
        String id2 = cloudPackage.getId();
        String str = this.f17442j;
        if (str == null || !id2.equals(str)) {
            this.f17442j = id2;
        }
        this.f17443k = false;
        if (list2.isEmpty()) {
            int size = list.size();
            ArrayList<Voucher> arrayList = new ArrayList();
            arrayList.addAll(list);
            for (Voucher voucher : arrayList) {
                if (BigDecimal.ZERO.compareTo(C11296s.m67823k(cloudPackage, voucher, this.f17454v)) == 0) {
                    size--;
                    list.remove(voucher);
                }
            }
            if (size == 0) {
                setVisibility(8);
                return true;
            }
            TextView textView = this.f17438f;
            Resources resources = this.f17433a.getResources();
            int i10 = R$plurals.cloudpay_cloumn_voucher_number;
            textView.setText(resources.getQuantityString(i10, size, Integer.valueOf(size)));
            this.f17438f.setContentDescription(this.f17433a.getResources().getQuantityString(i10, size, Integer.valueOf(size)));
            this.f17438f.setAccessibilityDelegate(C2783d.m16132d());
            this.f17451s = 1;
            TextView textView2 = this.f17440h;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        } else {
            BigDecimal bigDecimalAdd = BigDecimal.ZERO;
            Iterator<Voucher> it = list2.iterator();
            while (it.hasNext()) {
                bigDecimalAdd = bigDecimalAdd.add(C11296s.m67823k(cloudPackage, it.next(), this.f17454v));
            }
            BigDecimal bigDecimalM67838v = C11296s.m67838v(cloudPackage);
            if (bigDecimalAdd.compareTo(bigDecimalM67838v) >= 0) {
                bigDecimalAdd = bigDecimalM67838v;
            }
            m23847q(bigDecimalAdd, cloudPackage);
        }
        setSelectVouchers(list2);
        this.f17444l = C11296s.m67800X(C11296s.m67837u(list, cloudPackage, this.f17454v), list2, this.f17433a);
        return true;
    }

    /* renamed from: p */
    public final boolean m23846p(List<Voucher> list, CloudPackage cloudPackage, String str) {
        int size = list.size();
        Voucher voucher = null;
        int i10 = 0;
        while (i10 < size) {
            Voucher voucher2 = list.get(i10);
            if (str.equals(voucher2.getVoucherCode())) {
                i10 = size;
                voucher = voucher2;
            }
            i10++;
        }
        if (voucher == null) {
            return false;
        }
        String id2 = cloudPackage.getId();
        String str2 = this.f17442j;
        if (str2 == null || !id2.equals(str2)) {
            this.f17442j = id2;
        }
        this.f17443k = false;
        BigDecimal bigDecimalM67823k = C11296s.m67823k(cloudPackage, voucher, this.f17454v);
        BigDecimal bigDecimalM67838v = C11296s.m67838v(cloudPackage);
        if (bigDecimalM67823k.compareTo(bigDecimalM67838v) >= 0) {
            bigDecimalM67823k = bigDecimalM67838v;
        }
        m23847q(bigDecimalM67823k, cloudPackage);
        ArrayList arrayList = new ArrayList();
        arrayList.add(voucher);
        setSelectVouchers(arrayList);
        this.f17444l = C11296s.m67800X(C11296s.m67837u(list, cloudPackage, this.f17454v), arrayList, this.f17433a);
        return true;
    }

    /* renamed from: q */
    public final void m23847q(BigDecimal bigDecimal, CloudPackage cloudPackage) {
        TextView textView = this.f17438f;
        Context context = this.f17433a;
        int i10 = R$string.cloudpay_cloumn_discount;
        textView.setText(context.getString(i10, C11290m.m67749j(bigDecimal, cloudPackage.getCurrency(), cloudPackage.getSymbol())));
        this.f17438f.setContentDescription(this.f17433a.getString(i10, C11290m.m67749j(bigDecimal, cloudPackage.getCurrency(), cloudPackage.getSymbol())));
        this.f17438f.setAccessibilityDelegate(C2783d.m16132d());
        this.f17451s = 2;
        TextView textView2 = this.f17440h;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        UpdatePackagePriceCallback updatePackagePriceCallback = this.f17446n;
        if (updatePackagePriceCallback != null) {
            updatePackagePriceCallback.mo23559U(bigDecimal, this.f17442j, this.f17445m);
        }
    }

    /* renamed from: r */
    public final void m23848r() {
        this.f17445m.clear();
        TextView textView = this.f17438f;
        if (textView != null) {
            Context context = this.f17433a;
            int i10 = R$string.cloudpay_no_voucher;
            textView.setText(context.getString(i10));
            this.f17438f.setContentDescription(this.f17433a.getString(i10));
            this.f17438f.setAccessibilityDelegate(C2783d.m16132d());
            this.f17438f.setTextColor(ContextCompat.getColor(this.f17433a, this.f17447o));
            this.f17451s = 0;
        }
        TextView textView2 = this.f17440h;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        UpdatePackagePriceCallback updatePackagePriceCallback = this.f17446n;
        if (updatePackagePriceCallback != null) {
            updatePackagePriceCallback.mo23575m();
        }
    }

    /* renamed from: s */
    public void m23849s(List<Voucher> list, CloudPackage cloudPackage, boolean z10, List<Voucher> list2, BigDecimal bigDecimal) {
        if (cloudPackage == null) {
            C1442a.m8289e("VoucherColumnView", "showSelectVouchersColumn currentSelectedPackage is null.");
            return;
        }
        if (list == null || list.isEmpty()) {
            C1442a.m8289e("VoucherColumnView", "showSelectVouchersColumn voucherList is null.");
            m23848r();
            return;
        }
        this.f17454v = bigDecimal;
        BigDecimal bigDecimalM67838v = C11296s.m67838v(cloudPackage);
        this.f17453u = cloudPackage;
        String id2 = cloudPackage.getId();
        if (bigDecimalM67838v.compareTo(new BigDecimal(0)) == 0) {
            m23848r();
            String str = this.f17442j;
            if (str == null || !id2.equals(str)) {
                this.f17443k = true;
                this.f17442j = id2;
                return;
            }
            return;
        }
        if (list2 == null || !m23845o(list, cloudPackage, list2)) {
            String str2 = this.f17442j;
            if (str2 == null || !id2.equals(str2)) {
                m23843m(list, cloudPackage, id2);
            } else {
                m23844n(list, cloudPackage, z10, bigDecimalM67838v);
            }
        }
    }

    public void setUpdatePackagePriceCallback(UpdatePackagePriceCallback updatePackagePriceCallback) {
        this.f17446n = updatePackagePriceCallback;
    }

    public void setUseDardModeImg(boolean z10) {
        this.f17455w = z10;
    }

    /* renamed from: t */
    public void m23850t(List<Voucher> list, CloudPackage cloudPackage, BigDecimal bigDecimal) {
        OnePackegeVouchers onePackegeVouchersM67837u;
        if (cloudPackage == null) {
            C1442a.m8289e("VoucherColumnView", "showVoucherDialog currentSelectedPackage is null.");
            return;
        }
        if (list == null || list.isEmpty()) {
            C1442a.m8289e("VoucherColumnView", "showVoucherDialog voucherList is empty.");
            return;
        }
        if (this.f17434b == null) {
            if (this.f17433a == null) {
                C1442a.m8289e("VoucherColumnView", "showVoucherDialog mContext is null.");
                return;
            }
            this.f17434b = new VoucherDialog(this.f17433a);
        }
        if (C11296s.m67838v(cloudPackage).compareTo(new BigDecimal(0)) == 0 || (onePackegeVouchersM67837u = C11296s.m67837u(list, cloudPackage, bigDecimal)) == null) {
            return;
        }
        RecommendVouchers recommendVouchersM67839w = C11296s.m67839w(cloudPackage, onePackegeVouchersM67837u, bigDecimal);
        this.f17449q = recommendVouchersM67839w;
        this.f17448p = 0;
        if (this.f17443k) {
            this.f17434b.m23859i(onePackegeVouchersM67837u, recommendVouchersM67839w, cloudPackage, this, bigDecimal);
            this.f17448p = onePackegeVouchersM67837u.getCommonVoucherList().size() + onePackegeVouchersM67837u.getSingleChoiceVoucherList().size();
        } else {
            this.f17434b.m23860j(this.f17444l, recommendVouchersM67839w, cloudPackage, this, bigDecimal);
            this.f17448p = this.f17444l.size();
        }
        m23839i();
    }
}
