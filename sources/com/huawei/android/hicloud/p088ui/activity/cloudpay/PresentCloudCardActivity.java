package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherColumnView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.HiCloudItemView;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.GradeCardView;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.GradeCardDisplayBean;
import com.huawei.cloud.pay.model.PresentAuthResp;
import com.huawei.cloud.pay.model.SelectVouchers;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardDefaultResourceBean;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.phone.hwedittext.widget.HwEditText;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import dj.C9158a;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import p015ak.C0209d;
import p054cj.C1442a;
import p252e9.C9433j;
import p454lj.C11296s;
import p514o9.C11828b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p684un.C13230i;
import p709vj.C13452e;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class PresentCloudCardActivity extends BuyPackageBaseActivity implements View.OnClickListener, VoucherColumnView.UpdatePackagePriceCallback {

    /* renamed from: A1 */
    public View f17325A1;

    /* renamed from: h1 */
    public GradeCardView f17326h1;

    /* renamed from: i1 */
    public VoucherColumnView f17327i1;

    /* renamed from: j1 */
    public LinearLayout f17328j1;

    /* renamed from: k1 */
    public GradeCardDisplayBean f17329k1;

    /* renamed from: m1 */
    public HwEditText f17331m1;

    /* renamed from: n1 */
    public AutoSizeButton f17332n1;

    /* renamed from: o1 */
    public NotchTopFitLinearLayout f17333o1;

    /* renamed from: p1 */
    public NotchFitRelativeLayout f17334p1;

    /* renamed from: q1 */
    public RelativeLayout f17335q1;

    /* renamed from: r1 */
    public ScrollView f17336r1;

    /* renamed from: s1 */
    public View f17337s1;

    /* renamed from: t1 */
    public View f17338t1;

    /* renamed from: u1 */
    public TextView f17339u1;

    /* renamed from: v1 */
    public HiCloudItemView f17340v1;

    /* renamed from: w1 */
    public HwTextView f17341w1;

    /* renamed from: x1 */
    public AlertDialog f17342x1;

    /* renamed from: z1 */
    public View f17344z1;

    /* renamed from: l1 */
    public C11828b f17330l1 = C9433j.m59164c().m59165b();

    /* renamed from: y1 */
    public boolean f17343y1 = false;

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.PresentCloudCardActivity$a */
    public class C3646a implements InputFilter {
        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
            if (charSequence.equals(" ")) {
                return "";
            }
            return null;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.PresentCloudCardActivity$b */
    public static class C3647b implements TextWatcher {

        /* renamed from: a */
        public AutoSizeButton f17345a;

        /* renamed from: b */
        public HwEditText f17346b;

        /* renamed from: c */
        public HwTextView f17347c;

        /* renamed from: d */
        public Context f17348d;

        /* renamed from: e */
        public WeakReference<PresentCloudCardActivity> f17349e;

        public /* synthetic */ C3647b(WeakReference weakReference, Context context, AutoSizeButton autoSizeButton, HwEditText hwEditText, HwTextView hwTextView, C3646a c3646a) {
            this(weakReference, context, autoSizeButton, hwEditText, hwTextView);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            C1442a.m8288d("PresentCloudCardActivity", "afterTextChanged");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            C1442a.m8288d("PresentCloudCardActivity", "beforeTextChanged");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            PresentCloudCardActivity presentCloudCardActivity;
            C1442a.m8288d("PresentCloudCardActivity", "onTextChanged");
            HwTextView hwTextView = this.f17347c;
            if (hwTextView != null) {
                hwTextView.setText((CharSequence) null);
                this.f17347c.setVisibility(8);
            }
            WeakReference<PresentCloudCardActivity> weakReference = this.f17349e;
            if (weakReference != null && (presentCloudCardActivity = weakReference.get()) != null) {
                presentCloudCardActivity.m23742U5(false);
            }
            if (!this.f17346b.getText().toString().isEmpty()) {
                this.f17346b.setHint((CharSequence) null);
                this.f17345a.setClickable(true);
                this.f17345a.setAlpha(1.0f);
            } else {
                SpannableString spannableString = new SpannableString(this.f17348d.getString(R$string.cloudpay_present_cloud_card_input_text_tip));
                spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString.length(), 33);
                this.f17346b.setHint(spannableString);
                this.f17345a.setClickable(false);
                this.f17345a.setAlpha(0.38f);
            }
        }

        public C3647b(WeakReference<PresentCloudCardActivity> weakReference, Context context, AutoSizeButton autoSizeButton, HwEditText hwEditText, HwTextView hwTextView) {
            this.f17349e = weakReference;
            this.f17348d = context;
            this.f17345a = autoSizeButton;
            this.f17346b = hwEditText;
            this.f17347c = hwTextView;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.PresentCloudCardActivity$c */
    public static class DialogInterfaceOnClickListenerC3648c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3648c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
        }

        public /* synthetic */ DialogInterfaceOnClickListenerC3648c(C3646a c3646a) {
            this();
        }
    }

    /* renamed from: L5 */
    private void m23726L5() {
        this.f17333o1 = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit);
        this.f17334p1 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.layout_main);
        this.f17335q1 = (RelativeLayout) C12809f.m76829b(this, R$id.inner_main_layout);
        this.f17336r1 = (ScrollView) C12809f.m76829b(this, R$id.scroll_present_view);
        this.f17337s1 = C12809f.m76829b(this, R$id.notch_fit_load_view);
        View viewM76829b = C12809f.m76829b(this, R$id.layout_nodata);
        this.f17344z1 = viewM76829b;
        viewM76829b.setOnClickListener(this);
        View viewM76829b2 = C12809f.m76829b(this, R$id.layout_nonetwork);
        this.f17325A1 = viewM76829b2;
        viewM76829b2.setOnClickListener(this);
        this.f17338t1 = C12809f.m76829b(this, R$id.layout_loading);
        this.f17339u1 = (TextView) C12809f.m76829b(this, R$id.cloudpay_loading_text);
        this.f17326h1 = (GradeCardView) C12809f.m76829b(this, R$id.card_view);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.present_btn);
        this.f17332n1 = autoSizeButton;
        autoSizeButton.setOnClickListener(this);
        this.f17332n1.setAlpha(0.38f);
        this.f17332n1.setClickable(false);
        C11842p.m70866t1(this, this.f17332n1);
        this.f17341w1 = (HwTextView) C12809f.m76829b(this, R$id.input_edit_text_error_tip);
        HwEditText hwEditText = (HwEditText) C12809f.m76829b(this, R$id.input_edit_text);
        this.f17331m1 = hwEditText;
        hwEditText.addTextChangedListener(new C3647b(new WeakReference(this), this, this.f17332n1, this.f17331m1, this.f17341w1, null));
        m23727T5(this.f17331m1);
        HiCloudItemView hiCloudItemView = (HiCloudItemView) C12809f.m76829b(this, R$id.choose_from_contacts);
        this.f17340v1 = hiCloudItemView;
        hiCloudItemView.setOnClickListener(this);
        if (!C0209d.m1184K0(this, C13843a.m83094p(this))) {
            this.f17340v1.setVisibility(8);
        }
        VoucherColumnView voucherColumnView = (VoucherColumnView) C12809f.m76829b(this, R$id.present_voucher_column);
        this.f17327i1 = voucherColumnView;
        voucherColumnView.setUseDardModeImg(true);
        this.f17327i1.setUpdatePackagePriceCallback(this);
        this.f17327i1.setOnClickListener(this);
        GradeCardDefaultResourceBean gradeCardDefaultResourceBean = new GradeCardDefaultResourceBean();
        gradeCardDefaultResourceBean.setVoucherColumnTextColor(R$color.voucher_card_select_color);
        gradeCardDefaultResourceBean.setVoucherArrowDrawable(R$drawable.voucher_arrow_for_purchase_cloud_card);
        gradeCardDefaultResourceBean.setVoucherNonClickableColumnTextColor(R$color.voucher_non_clickable_normal_color);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.voucher_colunm_container);
        this.f17328j1 = linearLayout;
        linearLayout.setBackground(getDrawable(R$drawable.voucher_column_card_bg));
        m28587n1();
        mo23770l1();
        m23728V5();
    }

    /* renamed from: T5 */
    public static void m23727T5(EditText editText) {
        editText.setFilters(new InputFilter[]{new C3646a(), new InputFilter.LengthFilter(128)});
    }

    /* renamed from: V5 */
    private void m23728V5() {
        C11842p.m70760Q1(this, C12809f.m76829b(this, R$id.layout_nonet_icon));
        C11842p.m70760Q1(this, this.f17338t1);
        C11842p.m70760Q1(this, C12809f.m76829b(this, R$id.layout_no_service_icon));
    }

    /* renamed from: X5 */
    private void m23729X5() {
        this.f17325A1.setVisibility(0);
        this.f17338t1.setVisibility(8);
        this.f17344z1.setVisibility(8);
        this.f17334p1.setVisibility(8);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: B1 */
    public void mo19444B1() {
        m28577K1(540, this.f17335q1, this.f17336r1);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: C1 */
    public void mo19445C1() {
        m28577K1(472, this.f17335q1, this.f17336r1);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: E1 */
    public void mo19447E1() {
        m28577K1(ErrorCode.ERROR_SIGTOOL_FAIL, this.f17335q1, this.f17336r1);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: F1 */
    public void mo19448F1() {
        m28577K1(466, this.f17335q1, this.f17336r1);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: G1 */
    public void mo19449G1() {
        m28577K1(472, this.f17335q1, this.f17336r1);
    }

    /* renamed from: G5 */
    public final void m23730G5() {
        if (C0209d.m1226Y0()) {
            C1442a.m8291w("PresentCloudCardActivity", "present_btn click too fast");
            return;
        }
        if (mo19458S4()) {
            C1442a.m8289e("PresentCloudCardActivity", "present button no net");
            return;
        }
        if (this.f17329k1 == null) {
            C1442a.m8289e("PresentCloudCardActivity", "present button click card data is null");
            return;
        }
        m23739Q5(this.f17343y1 ? 1 : 0);
        m22817Z4(this.f17327i1.getSelectVouchers());
        C9158a.m57503F().m57522T(this.f16524O, this.f17331m1.getText().toString(), this.f17329k1.getId());
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: H1 */
    public void mo19450H1() {
        m28576J1(this.f17335q1, this.f17336r1);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: H3 */
    public void mo19451H3(Bundle bundle) {
    }

    /* renamed from: H5 */
    public int m23731H5() {
        return R$layout.present_cloud_card_layout;
    }

    /* renamed from: I5 */
    public final String[] m23732I5(Uri uri) {
        String[] strArr = new String[2];
        if (uri == null) {
            C1442a.m8289e("PresentCloudCardActivity", "get phone contacts error, uri is null");
            return strArr;
        }
        ContentResolver contentResolver = getContentResolver();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contentResolver.query(uri, null, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    strArr[0] = cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
                    strArr[1] = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                }
            } catch (Exception e10) {
                C1442a.m8289e("PresentCloudCardActivity", "query error, exception: " + e10.toString());
                if (cursorQuery != null) {
                }
            }
            return strArr;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* renamed from: J5 */
    public final void m23733J5(int i10, Intent intent) throws JSONException {
        if (i10 != 10001) {
            if (i10 == 10002) {
                m22759E4();
                setResult(-1);
                finish();
                return;
            } else if (i10 != 10007) {
                if (i10 == 10013) {
                    mo22790P3(intent);
                    return;
                }
                C1442a.m8289e("PresentCloudCardActivity", "invalid requestCode = " + i10);
                return;
            }
        }
        mo22829d4(intent);
    }

    /* renamed from: K5 */
    public final void m23734K5(IBinder iBinder) {
        if (iBinder != null) {
            this.f17331m1.clearFocus();
            Object systemService = getSystemService("input_method");
            if (systemService instanceof InputMethodManager) {
                ((InputMethodManager) systemService).hideSoftInputFromWindow(iBinder, 2);
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: L2 */
    public void mo22779L2(int i10) throws IllegalAccessException, IllegalArgumentException {
        if (i10 == 56) {
            m23743W5(getString(R$string.cloudpay_present_cloud_card_other_situation));
        } else {
            super.mo22779L2(i10);
        }
    }

    /* renamed from: M5 */
    public final boolean m23735M5(View view, MotionEvent motionEvent) {
        if (!(view instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i10 = iArr[0];
        int i11 = iArr[1];
        return motionEvent.getX() <= ((float) i10) || motionEvent.getX() >= ((float) (view.getWidth() + i10)) || motionEvent.getY() <= ((float) i11) || motionEvent.getY() >= ((float) (view.getHeight() + i11));
    }

    /* renamed from: N5 */
    public final void m23736N5() {
        Intent intent = getIntent();
        if (intent == null) {
            C1442a.m8289e("PresentCloudCardActivity", "parseIntentData error, intent is null");
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        Serializable serializableExtra = safeIntent.getSerializableExtra("selected_card_data");
        if (serializableExtra instanceof GradeCardDisplayBean) {
            this.f17329k1 = (GradeCardDisplayBean) serializableExtra;
        }
        Serializable serializableExtra2 = safeIntent.getSerializableExtra("selected_package");
        if (serializableExtra2 instanceof CloudSpace) {
            this.f16520M = (CloudSpace) serializableExtra2;
        }
        Serializable serializableExtra3 = safeIntent.getSerializableExtra("params");
        if (serializableExtra3 instanceof GetClientUIConfigResp) {
            this.f16538V = (GetClientUIConfigResp) serializableExtra3;
        }
        Serializable serializableExtra4 = safeIntent.getSerializableExtra("user");
        if (serializableExtra4 instanceof UserPackage) {
            this.f21452m = (UserPackage) serializableExtra4;
        }
        Serializable serializableExtra5 = safeIntent.getSerializableExtra("select_vouchers");
        if (serializableExtra5 instanceof SelectVouchers) {
            this.f16563j0.clear();
            this.f16563j0.addAll(((SelectVouchers) serializableExtra5).getSelectVoucherList());
        }
        Serializable serializableExtra6 = safeIntent.getSerializableExtra("package_for_present");
        if (serializableExtra6 instanceof CloudPackage) {
            this.f16564k0 = (CloudPackage) serializableExtra6;
        }
    }

    /* renamed from: O5 */
    public final void m23737O5(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("PresentCloudCardActivity", "number is null");
            return;
        }
        String strReplaceAll = str.replaceAll(" ", "");
        this.f17331m1.setText((CharSequence) null);
        this.f17331m1.setText(strReplaceAll);
        this.f17343y1 = true;
    }

    /* renamed from: P5 */
    public final void m23738P5() {
        m22842j4("UNIFORM_CLOUDPAY_PRESENT_CARD_CLICK_CHOOSE_CONTACT", C13230i.m79497A(C13452e.m80781L().m80971t0()));
    }

    /* renamed from: Q5 */
    public final void m23739Q5(int i10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("account_source", String.valueOf(i10));
        m22842j4("UNIFORM_CLOUDPAY_PRESENT_CARD_CLICK_PRESENT", linkedHashMapM79497A);
    }

    /* renamed from: R5 */
    public final void m23740R5() {
        m22842j4("UNIFORM_CLOUDPAY_ENTER_PRESENT_CARD_ACTIVITY", C13230i.m79497A(C13452e.m80781L().m80971t0()));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: S4 */
    public boolean mo19458S4() {
        if (C11296s.m67786J(this)) {
            return false;
        }
        C11829c.m70612r1(this);
        return true;
    }

    /* renamed from: S5 */
    public final void m23741S5() {
        m22842j4("UNIFORM_CLOUDPAY_GIVE_PACKAGE_TIME_LIMIT_DIALOG_SHOW", C13230i.m79497A(C13452e.m80781L().m80971t0()));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: T3 */
    public void mo19460T3() {
        C1442a.m8290i("PresentCloudCardActivity", "initData()");
        m28588o1("06012");
        if (!C11296s.m67786J(this)) {
            m23729X5();
            return;
        }
        this.f16535T0 = null;
        mo19474g5();
        VoucherColumnView voucherColumnView = this.f17327i1;
        if (voucherColumnView != null) {
            voucherColumnView.m23838h();
        }
        if (!C11296s.m67787K() || !C11296s.m67789M(this) || this.f16564k0 == null) {
            this.f16535T0 = new ArrayList();
            mo19479s5();
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f16564k0.getId());
            C9158a.m57503F().m57555t(this.f16524O, arrayList);
        }
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.VoucherColumnView.UpdatePackagePriceCallback
    /* renamed from: U */
    public void mo23559U(BigDecimal bigDecimal, String str, List<Voucher> list) {
    }

    /* renamed from: U5 */
    public void m23742U5(boolean z10) {
        this.f17343y1 = z10;
    }

    /* renamed from: W5 */
    public void m23743W5(String str) throws IllegalAccessException, IllegalArgumentException {
        if (this.f17342x1 == null) {
            AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
            this.f17342x1 = alertDialogCreate;
            C11829c.m70594l1(this, alertDialogCreate);
        }
        this.f17342x1.setMessage(str);
        this.f17342x1.setButton(-1, getString(R$string.cloudpay_present_cloud_card_dialog_button_text), new DialogInterfaceOnClickListenerC3648c(null));
        this.f17342x1.show();
    }

    /* renamed from: Y5 */
    public final void m23744Y5() {
        List<Voucher> list;
        if (!C11296s.m67787K() || !C11296s.m67789M(this) || (list = this.f16535T0) == null || list.isEmpty()) {
            this.f17327i1.setVisibility(8);
        } else {
            this.f17327i1.setVisibility(0);
            this.f17327i1.m23849s(this.f16535T0, this.f16564k0, true, this.f16563j0, BigDecimal.ZERO);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            View currentFocus = getCurrentFocus();
            if (m23735M5(currentFocus, motionEvent)) {
                m23734K5(currentFocus.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: g5 */
    public void mo19474g5() {
        this.f17338t1.setVisibility(0);
        this.f17344z1.setVisibility(8);
        this.f17334p1.setVisibility(8);
        this.f17325A1.setVisibility(8);
        this.f17339u1.setText(R$string.cloudpay_loading);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: h1 */
    public List<View> mo19475h1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f17333o1);
        arrayList.add(this.f17337s1);
        arrayList.add(this.f17334p1);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: h5 */
    public void mo19476h5() {
        this.f17334p1.setVisibility(0);
        this.f17338t1.setVisibility(8);
        this.f17344z1.setVisibility(8);
        this.f17325A1.setVisibility(8);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: i1 */
    public String mo23018i1() {
        return "PresentCloudCardActivity";
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: i4 */
    public void mo22839i4() {
        if (this.f16563j0.size() > 0) {
            C1442a.m8290i("PresentCloudCardActivity", "refresh vouchers");
            mo19460T3();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: k5 */
    public void mo19477k5() {
        this.f17344z1.setVisibility(0);
        this.f17338t1.setVisibility(8);
        this.f17334p1.setVisibility(8);
        this.f17325A1.setVisibility(8);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: l5 */
    public void mo19478l5() {
        this.f17338t1.setVisibility(0);
        this.f17334p1.setVisibility(8);
        this.f17344z1.setVisibility(8);
        this.f17325A1.setVisibility(8);
        this.f17339u1.setText(R$string.cloudpay_loading);
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.VoucherColumnView.UpdatePackagePriceCallback
    /* renamed from: m */
    public void mo23575m() {
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.VoucherColumnView.UpdatePackagePriceCallback
    /* renamed from: n0 */
    public void mo23577n0(String str) {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: n3 */
    public void mo22852n3(Message message) throws IllegalAccessException, IllegalArgumentException {
        if (message == null) {
            C11839m.m70687e("PresentCloudCardActivity", "dealPresentAuthFailed, msg is null");
            return;
        }
        int i10 = message.arg1;
        C11839m.m70687e("PresentCloudCardActivity", "dealPresentAuthFailed, errorCode = " + i10 + ", error msg = " + message.obj);
        if (i10 == 27) {
            m23743W5(getString(R$string.over_present_current_package_time_limit));
            m23741S5();
            return;
        }
        if (i10 == 209) {
            m23743W5(getString(R$string.cloudpay_present_cloud_card_to_self));
            return;
        }
        if (i10 != 206) {
            if (i10 == 207) {
                m23743W5(getString(R$string.cloudpay_present_cloud_card_not_active));
                return;
            }
            switch (i10) {
                case 107:
                case 108:
                case 109:
                    break;
                default:
                    switch (i10) {
                        case 201:
                        case 202:
                            break;
                        case 203:
                        case 204:
                            m23743W5(getString(R$string.cloudpay_present_cloud_card_account_error));
                            break;
                        default:
                            m23743W5(getString(R$string.cloudpay_present_cloud_card_other_situation));
                            break;
                    }
                    return;
            }
        }
        m23743W5(getString(R$string.cloudpay_present_cloud_card_has_other_grade));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: o3 */
    public void mo22856o3(Object obj) throws IllegalAccessException, IllegalArgumentException {
        if (!(obj instanceof PresentAuthResp)) {
            m23743W5(getString(R$string.cloudpay_present_cloud_card_other_situation));
            return;
        }
        PresentAuthResp presentAuthResp = (PresentAuthResp) obj;
        if (presentAuthResp.getResultCode() != 0) {
            m23743W5(getString(R$string.cloudpay_present_cloud_card_other_situation));
            return;
        }
        this.f17341w1.setVisibility(8);
        this.f17341w1.setText((CharSequence) null);
        m22898z2(presentAuthResp.getClientReceiverAccount(), m22882v2());
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws JSONException {
        C1442a.m8290i("PresentCloudCardActivity", "onActivityResult requestCode = " + i10 + " resultCode = " + i11);
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1000) {
            if (i11 == -1) {
                m23737O5(m23732I5(hiCloudSafeIntent.getData())[1]);
            }
        } else if (i11 == -1) {
            m23733J5(i10, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.present_btn) {
            m23730G5();
            return;
        }
        if (id2 == R$id.choose_from_contacts) {
            if (C0209d.m1226Y0()) {
                C1442a.m8291w("PresentCloudCardActivity", "choose_from_contacts click too fast");
                return;
            }
            m23738P5();
            try {
                startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 1000);
                return;
            } catch (Exception e10) {
                C1442a.m8289e("PresentCloudCardActivity", "startActivityForResult exception: " + e10.toString());
                return;
            }
        }
        if (R$id.layout_nodata == id2) {
            mo19460T3();
            return;
        }
        if (R$id.layout_nonetwork == id2) {
            mo19460T3();
            return;
        }
        if (R$id.present_voucher_column == id2) {
            if (C0209d.m1226Y0()) {
                C1442a.m8291w("PresentCloudCardActivity", "present_voucher_column click too fast");
                return;
            } else {
                this.f17327i1.m23850t(this.f16535T0, this.f16564k0, BigDecimal.ZERO);
                return;
            }
        }
        C11839m.m70686d("PresentCloudCardActivity", "some view clicked, view id is " + id2);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m23728V5();
        C11842p.m70866t1(this, this.f17332n1);
        VoucherColumnView voucherColumnView = this.f17327i1;
        if (voucherColumnView != null) {
            voucherColumnView.m23833c();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f16515J0 = true;
        super.onCreate(bundle);
        m23740R5();
        setContentView(m23731H5());
        m23726L5();
        m23736N5();
        mo19460T3();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AlertDialog alertDialog = this.f17342x1;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f17342x1 = null;
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SpannableString spannableString = new SpannableString(getString(R$string.cloudpay_present_cloud_card_input_text_tip));
        spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString.length(), 33);
        HwEditText hwEditText = this.f17331m1;
        if (hwEditText != null) {
            hwEditText.setHint(new SpannedString(spannableString));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: s5 */
    public void mo19479s5() {
        if (this.f16538V == null || this.f16535T0 == null || this.f16520M == null || this.f21452m == null || this.f17329k1 == null) {
            return;
        }
        C1442a.m8290i("PresentCloudCardActivity", "showView()");
        GradeCardView gradeCardView = this.f17326h1;
        if (gradeCardView == null) {
            C1442a.m8289e("PresentCloudCardActivity", "initData params or cardView is null.");
            return;
        }
        gradeCardView.setData(this.f17329k1, this.f16538V.getRightTitle(), this.f17330l1, false);
        m23744Y5();
        mo19476h5();
    }
}
