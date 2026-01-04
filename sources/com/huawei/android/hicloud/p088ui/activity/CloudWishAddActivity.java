package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import dj.C9158a;
import huawei.android.app.HwProgressDialog;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import p015ak.C0209d;
import p429kk.C11058a;
import p429kk.C11060c;
import p454lj.C11293p;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p684un.C13227f;
import p709vj.C13452e;
import p802y8.C13917a;
import p802y8.C13918b;
import p802y8.C13921e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudWishAddActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: A */
    public AlertDialog f14651A;

    /* renamed from: B */
    public HwProgressDialog f14652B;

    /* renamed from: C */
    public long f14653C;

    /* renamed from: p */
    public View f14654p;

    /* renamed from: q */
    public View f14655q;

    /* renamed from: r */
    public View f14656r;

    /* renamed from: s */
    public EditText f14657s;

    /* renamed from: t */
    public TextView f14658t;

    /* renamed from: u */
    public EditText f14659u;

    /* renamed from: v */
    public TextView f14660v;

    /* renamed from: w */
    public AutoSizeButton f14661w;

    /* renamed from: x */
    public TextWatcher f14662x;

    /* renamed from: y */
    public TextWatcher f14663y;

    /* renamed from: z */
    public HandlerC3259c f14664z;

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudWishAddActivity$b */
    public static class DialogInterfaceOnClickListenerC3258b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3258b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudWishAddActivity$c */
    public static class HandlerC3259c extends Handler {

        /* renamed from: a */
        public final WeakReference<CloudWishAddActivity> f14665a;

        public HandlerC3259c(CloudWishAddActivity cloudWishAddActivity) {
            super(Looper.getMainLooper());
            this.f14665a = new WeakReference<>(cloudWishAddActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CloudWishAddActivity cloudWishAddActivity = this.f14665a.get();
            if (cloudWishAddActivity == null) {
                C11839m.m70689w("CloudWishAddActivity", "activity null");
                return;
            }
            if (message == null) {
                C11839m.m70689w("CloudWishAddActivity", "msg null");
                return;
            }
            int i10 = message.what;
            C11839m.m70688i("CloudWishAddActivity", "handleMessage: " + i10);
            if (i10 == 2001) {
                cloudWishAddActivity.m20311V1(message.obj);
                return;
            }
            if (i10 == 2101) {
                cloudWishAddActivity.m20310U1(message.obj);
            } else if (i10 == 107) {
                cloudWishAddActivity.m20313X1();
            } else if (i10 == 108) {
                cloudWishAddActivity.m20312W1();
            }
        }
    }

    /* renamed from: B1 */
    private void m20295B1() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R$string.wish_list);
            int i10 = R$color.hicloud_hmos_bg;
            C11842p.m70842n1(actionBar, new ColorDrawable(getColor(i10)));
            actionBar.setBackgroundDrawable(new ColorDrawable(getColor(i10)));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        getWindow().setStatusBarColor(getColor(R$color.hicloud_hmos_bg));
    }

    /* renamed from: b2 */
    private void m20302b2() {
        m20306g2();
        m20309T1();
    }

    /* renamed from: c2 */
    private void m20303c2() {
        this.f14654p = C12809f.m76829b(this, R$id.main_layout);
        View viewM76829b = C12809f.m76829b(this, R$id.content_layout);
        this.f14655q = viewM76829b;
        viewM76829b.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.c5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f16492a.m20304d2(view);
            }
        });
        this.f14656r = C12809f.m76829b(this, R$id.query_loading_layout);
        View viewM76829b2 = C12809f.m76829b(this, R$id.ll_title_container);
        this.f14657s = (EditText) C12809f.m76829b(this, R$id.edt_wish_title);
        this.f14658t = (TextView) C12809f.m76829b(this, R$id.tv_count_limit_title);
        this.f14659u = (EditText) C12809f.m76829b(this, R$id.edt_wish_content);
        this.f14660v = (TextView) C12809f.m76829b(this, R$id.tv_count_limit_detail);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.btn_wish_add);
        this.f14661w = autoSizeButton;
        autoSizeButton.setOnClickListener(this);
        viewM76829b2.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.d5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17587a.m20305e2(view);
            }
        });
        C11842p.m70866t1(this, this.f14661w);
        C13918b.m83426D(this, this.f14658t, 0, 30);
        C13918b.m83426D(this, this.f14660v, 0, 200);
        C13917a c13917a = new C13917a();
        InputFilter.LengthFilter lengthFilter = new InputFilter.LengthFilter(30);
        InputFilter.LengthFilter lengthFilter2 = new InputFilter.LengthFilter(200);
        this.f14657s.setFilters(new InputFilter[]{c13917a, lengthFilter});
        this.f14659u.setFilters(new InputFilter[]{c13917a, lengthFilter2});
        this.f14662x = new C13921e(this, 1, this.f14658t);
        this.f14663y = new C13921e(this, 2, this.f14660v);
        this.f14657s.addTextChangedListener(this.f14662x);
        this.f14659u.addTextChangedListener(this.f14663y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d2 */
    public /* synthetic */ void m20304d2(View view) {
        C13918b.m83438u(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e2 */
    public /* synthetic */ void m20305e2(View view) {
        EditText editText = this.f14657s;
        if (editText != null) {
            editText.requestFocus();
        }
    }

    /* renamed from: g2 */
    private void m20306g2() {
        View view = this.f14656r;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* renamed from: R1 */
    public final void m20307R1() {
        AutoSizeButton autoSizeButton = this.f14661w;
        if (autoSizeButton != null) {
            autoSizeButton.setEnabled(true);
        }
        m20316a2();
    }

    /* renamed from: S1 */
    public final void m20308S1() throws JSONException {
        C11839m.m70688i("CloudWishAddActivity", "createWish");
        if (!C0209d.m1333z1(this)) {
            C11839m.m70687e("CloudWishAddActivity", "no network");
            m20317f2(getString(R$string.wish_list), getString(R$string.cloudpay_net_disconnect_alert));
            return;
        }
        m20318h2();
        AutoSizeButton autoSizeButton = this.f14661w;
        if (autoSizeButton != null) {
            autoSizeButton.setEnabled(false);
        }
        String string = this.f14657s.getText().toString();
        String string2 = this.f14659u.getText().toString();
        if (TextUtils.isEmpty(string)) {
            C11839m.m70687e("CloudWishAddActivity", "wish title is empty");
            m20317f2(getString(R$string.wish_list_wish_name), getString(R$string.wish_list_tips_title));
            m20307R1();
            return;
        }
        if (string.length() > 30) {
            C11839m.m70687e("CloudWishAddActivity", "wish title too long");
            m20317f2(getString(R$string.wish_list_wish_name), getString(R$string.wish_list_input_title_max, 30));
            m20307R1();
            return;
        }
        if (TextUtils.isEmpty(string2)) {
            C11839m.m70687e("CloudWishAddActivity", "wish detail is empty");
            m20317f2(getString(R$string.wish_list_wish_content), getString(R$string.wish_list_tips_detail));
            m20307R1();
        } else {
            if (string2.length() > 200) {
                C11839m.m70687e("CloudWishAddActivity", "wish detail too long");
                m20317f2(getString(R$string.wish_list_wish_content), getString(R$string.wish_list_input_detail_max, 200));
                m20307R1();
                return;
            }
            C11839m.m70688i("CloudWishAddActivity", "post wish request");
            C13918b.m83437m().m83455z(this.f14664z, string, string2, this.f14653C);
            C13227f.m79492i1().m79585f0("mecloud_setting_click_wish_list_post", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_setting_click_wish_list_post", "1", "4");
        }
    }

    /* renamed from: T1 */
    public final void m20309T1() {
        C11839m.m70688i("CloudWishAddActivity", "getUserInfo");
        C11060c c11060c = new C11060c();
        c11060c.m66636B("06008");
        c11060c.m66643I(C11058a.m66627b("06008"));
        c11060c.m66637C("com.huawei.hidisk\u0001_cloudspace");
        c11060c.m66670z("2.0");
        C9158a.m57503F().m57516N(this.f14664z, c11060c, true, "CloudWishAddActivity");
    }

    /* renamed from: U1 */
    public final void m20310U1(Object obj) {
        m20315Z1();
        C11839m.m70688i("CloudWishAddActivity", "handleGetUserPackageFailed");
    }

    /* renamed from: V1 */
    public final void m20311V1(Object obj) {
        C11839m.m70688i("CloudWishAddActivity", "handleGetUserPackageSuccess");
        m20315Z1();
        if (!(obj instanceof UserPackage)) {
            C11839m.m70687e("CloudWishAddActivity", "handleGetUserPackageSuccess obj is not UserPackage.");
            return;
        }
        CloudSpace cloudSpaceM67757a = C11293p.m67757a((UserPackage) obj);
        if (cloudSpaceM67757a != null) {
            this.f14653C = cloudSpaceM67757a.getCapacity();
        }
    }

    /* renamed from: W1 */
    public final void m20312W1() {
        AutoSizeButton autoSizeButton = this.f14661w;
        if (autoSizeButton != null) {
            autoSizeButton.setEnabled(true);
        }
        m20316a2();
        C11841o.m70708d(this, getString(R$string.wish_list_err_tips_failed), 0);
    }

    /* renamed from: X1 */
    public final void m20313X1() {
        AutoSizeButton autoSizeButton = this.f14661w;
        if (autoSizeButton != null) {
            autoSizeButton.setEnabled(true);
        }
        m20316a2();
        setResult(-1);
        finish();
    }

    /* renamed from: Y1 */
    public final void m20314Y1() {
        AlertDialog alertDialog = this.f14651A;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.f14651A.hide();
    }

    /* renamed from: Z1 */
    public final void m20315Z1() {
        View view = this.f14656r;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* renamed from: a2 */
    public final void m20316a2() {
        HwProgressDialog hwProgressDialog = this.f14652B;
        if (hwProgressDialog == null || !hwProgressDialog.isShowing()) {
            return;
        }
        this.f14652B.hide();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14654p);
        arrayList.add(this.f14655q);
        return arrayList;
    }

    /* renamed from: f2 */
    public final void m20317f2(String str, String str2) {
        if (this.f14651A == null) {
            this.f14651A = new AlertDialog.Builder(this).setTitle(str).setPositiveButton(getString(R$string.got_it), new DialogInterfaceOnClickListenerC3258b()).create();
        }
        this.f14651A.setTitle(str);
        this.f14651A.setMessage(str2);
        this.f14651A.show();
    }

    /* renamed from: h2 */
    public final void m20318h2() {
        if (this.f14652B == null) {
            HwProgressDialog hwProgressDialog = new HwProgressDialog(this);
            this.f14652B = hwProgressDialog;
            hwProgressDialog.setMessage(getString(R$string.wait_loging));
            this.f14652B.setCanceledOnTouchOutside(false);
            this.f14652B.setCancelable(false);
        }
        this.f14652B.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws JSONException {
        if (C0209d.m1226Y0()) {
            C11839m.m70689w("CloudWishAddActivity", "click too fast");
            return;
        }
        if (R$id.btn_wish_add == view.getId()) {
            C13918b.m83438u(this);
            m20308S1();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70866t1(this, this.f14661w);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C11839m.m70688i("CloudWishAddActivity", "onCreate");
        this.f14664z = new HandlerC3259c(this);
        setContentView(R$layout.activity_wish_list_add);
        m20295B1();
        m20303c2();
        mo19005p1();
        m20302b2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        m20316a2();
        m20314Y1();
        EditText editText = this.f14657s;
        if (editText != null && (textWatcher2 = this.f14662x) != null) {
            editText.removeTextChangedListener(textWatcher2);
        }
        EditText editText2 = this.f14659u;
        if (editText2 != null && (textWatcher = this.f14663y) != null) {
            editText2.removeTextChangedListener(textWatcher);
        }
        super.onDestroy();
    }
}
