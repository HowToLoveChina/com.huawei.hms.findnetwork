package com.huawei.android.hicloud.p088ui.activity;

import android.R;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.app.ActionBarEx;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.sync.R$color;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hicloud.sync.R$string;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huawei.openalliance.p169ad.constant.Action;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0226l0;
import p020ap.C1010e;
import p336he.C10161l;
import p472m7.C11427b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p681uj.C13195l;
import p684un.C13227f;
import p709vj.C13452e;
import p742wj.C13612b;
import p783xp.C13843a;
import p846zj.C14303a;
import sk.C12809f;
import tm.C13040c;

/* loaded from: classes3.dex */
public class AboutActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: M */
    public static final String[] f13433M = {"android.permission.CALL_PHONE"};

    /* renamed from: A */
    public LinearLayout f13434A;

    /* renamed from: B */
    public RelativeLayout f13435B;

    /* renamed from: C */
    public RelativeLayout f13436C;

    /* renamed from: D */
    public AlertDialog f13437D;

    /* renamed from: E */
    public RelativeLayout f13438E;

    /* renamed from: F */
    public RelativeLayout f13439F;

    /* renamed from: G */
    public TextView f13440G;

    /* renamed from: H */
    public ImageView f13441H;

    /* renamed from: I */
    public HiCloudExceptionView f13442I;

    /* renamed from: J */
    public HiCloudExceptionView f13443J;

    /* renamed from: K */
    public String f13444K = "";

    /* renamed from: L */
    public Handler f13445L = new HandlerC3107a();

    /* renamed from: p */
    public NotchTopFitRelativeLayout f13446p;

    /* renamed from: q */
    public NotchFitLinearLayout f13447q;

    /* renamed from: r */
    public NotchFitRelativeLayout f13448r;

    /* renamed from: s */
    public RelativeLayout f13449s;

    /* renamed from: t */
    public RelativeLayout f13450t;

    /* renamed from: u */
    public RelativeLayout f13451u;

    /* renamed from: v */
    public RelativeLayout f13452v;

    /* renamed from: w */
    public RelativeLayout f13453w;

    /* renamed from: x */
    public RelativeLayout f13454x;

    /* renamed from: y */
    public LinearLayout f13455y;

    /* renamed from: z */
    public LinearLayout f13456z;

    /* renamed from: com.huawei.android.hicloud.ui.activity.AboutActivity$a */
    public class HandlerC3107a extends Handler {
        public HandlerC3107a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 1001) {
                if (i10 != 1002) {
                    return;
                }
                AboutActivity.this.m18502Z1(message.obj.toString());
                return;
            }
            Object obj = message.obj;
            if (obj == null) {
                C11839m.m70687e("AboutActivity", "getOpenSourceUrl return null");
            }
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                AboutActivity.this.f13442I.m23914a();
                AboutActivity.this.f13443J.m23919i();
                return;
            }
            AboutActivity.this.f13443J.m23914a();
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str + "/staticpage/opensource/files_v2.html"));
            try {
                AboutActivity.this.startActivity(intent);
            } catch (Exception unused) {
                C11839m.m70687e("AboutActivity", "OPEN_SOURCE_NOTICES handle intent exception");
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.AboutActivity$b */
    public class ViewOnClickListenerC3108b implements View.OnClickListener {
        public ViewOnClickListenerC3108b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AboutActivity.this.m18500X1();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.AboutActivity$c */
    public class C3109c extends AbstractC12367d {
        public C3109c() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            String strM78625Q;
            try {
                strM78625Q = C13040c.m78609F().m78625Q();
            } catch (C9721b e10) {
                C11839m.m70687e("AboutActivity", "getOpenSourceUrl exception:" + e10.toString());
                strM78625Q = "";
            }
            if (!TextUtils.isEmpty(strM78625Q)) {
                AboutActivity.this.f13443J.m23914a();
            } else {
                AboutActivity.this.f13442I.m23914a();
                AboutActivity.this.f13443J.m23919i();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.AboutActivity$d */
    public class DialogInterfaceOnClickListenerC3110d implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3110d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C11839m.m70686d("AboutActivity", "showStopCloudServicesDialog---stop");
            AboutActivity.this.m18516p2();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.AboutActivity$e */
    public class DialogInterfaceOnClickListenerC3111e implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3111e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C11839m.m70686d("AboutActivity", "showStopCloudServicesDialog---cancel");
            if (AboutActivity.this.f13437D != null) {
                AboutActivity.this.f13437D.dismiss();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.AboutActivity$f */
    public class C3112f extends AbstractC12367d {
        public C3112f() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            String strM78625Q;
            try {
                strM78625Q = C13040c.m78609F().m78625Q();
            } catch (C9721b e10) {
                C11839m.m70687e("AboutActivity", "linkOfficialSites exception:" + e10.toString());
                strM78625Q = "";
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 1002;
            messageObtain.obj = strM78625Q;
            AboutActivity.this.f13445L.sendMessage(messageObtain);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.AboutActivity$g */
    public class C3113g extends AbstractC12367d {
        public C3113g() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            String strM78620L;
            try {
                strM78620L = C13040c.m78609F().m78620L();
            } catch (C9721b e10) {
                C11839m.m70687e("AboutActivity", "getOpenSourceUrl exception:" + e10.toString());
                strM78620L = "";
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 1001;
            messageObtain.obj = strM78620L;
            AboutActivity.this.f13445L.sendMessage(messageObtain);
        }
    }

    /* renamed from: W1 */
    public static String[] m18493W1() {
        return (String[]) f13433M.clone();
    }

    /* renamed from: e2 */
    private void m18494e2() {
        if (this.f13453w == null || this.f13451u == null || !C11829c.m70532M0()) {
            return;
        }
        this.f13453w.setVisibility(0);
        this.f13451u.setVisibility(0);
    }

    /* renamed from: f2 */
    private void m18495f2() throws Resources.NotFoundException {
        this.f13442I = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view1);
        HiCloudExceptionView hiCloudExceptionView = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view2);
        this.f13443J = hiCloudExceptionView;
        hiCloudExceptionView.setContent(R$string.exception_connect_server_fail_msg);
        this.f13443J.m23916c();
        this.f13443J.m23915b();
        this.f13443J.setRetryClickListener(new ViewOnClickListenerC3108b());
        m18513m2();
        m18512l2();
        this.f13446p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f13447q = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.about_useagree);
        this.f13455y = (LinearLayout) C12809f.m76829b(this, R$id.notch_fit_frame);
        this.f13454x = (RelativeLayout) C12809f.m76829b(this, R$id.about_main_layout);
        this.f13448r = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.top_margin_frame);
        this.f13452v = (RelativeLayout) C12809f.m76829b(this, R$id.hicloud_about_open_source_permission);
        this.f13453w = (RelativeLayout) C12809f.m76829b(this, R$id.hicloud_function_item_permission);
        this.f13435B = (RelativeLayout) C12809f.m76829b(this, R$id.hicloud_stop_service_item);
        this.f13436C = (RelativeLayout) C12809f.m76829b(this, R$id.rl_stop_service_divider);
        this.f13438E = (RelativeLayout) C12809f.m76829b(this, R$id.customer_service_phone_item);
        this.f13439F = (RelativeLayout) C12809f.m76829b(this, R$id.rl_phone_divider);
        this.f13440G = (TextView) C12809f.m76829b(this, R$id.phone_text);
        this.f13441H = (ImageView) C12809f.m76829b(this, R$id.customer_service_phone_right_arrow);
        this.f13435B.setOnClickListener(this);
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            this.f13435B.setVisibility(0);
            this.f13436C.setVisibility(0);
            this.f13438E.setVisibility(0);
            this.f13439F.setVisibility(0);
        }
        this.f13449s = (RelativeLayout) C12809f.m76829b(this, R$id.about_card_frame);
        this.f13452v.setOnClickListener(this);
        this.f13453w.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.about_official);
        this.f13450t = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.f13451u = (RelativeLayout) C12809f.m76829b(this, R$id.notch_fit_divider2);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.huawei_ltd);
        this.f13438E.setOnClickListener(this);
        if (C0209d.m1293p1() || C0209d.m1258g2(this)) {
            this.f13441H.setVisibility(8);
            this.f13438E.setClickable(false);
        }
        textView.setText(getString(R$string.copyright_ratdata201908, 2012, 2025));
        m22381r1();
        m18506d2();
        m18499V1();
    }

    /* renamed from: k2 */
    private void m18496k2() {
        if (C0209d.m1195O(this) >= 1.75f) {
            setContentView(R$layout.about_activity_font_scale);
        } else {
            setContentView(R$layout.about_activity);
        }
    }

    /* renamed from: T1 */
    public final void m18497T1(String str) {
        if (str == null) {
            C11839m.m70687e("AboutActivity", "phoneNumber is null");
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(NavigationUtils.TEL_SCHEMA_PREF + str));
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            startActivity(intent);
        } catch (Exception unused) {
            C11839m.m70687e("AboutActivity", "call telephone error ");
        }
    }

    /* renamed from: U1 */
    public final void m18498U1(String str) {
        C11839m.m70688i("AboutActivity", "callPhone");
        if (m18503a2("android.permission.CALL_PHONE")) {
            m18497T1(str);
        } else {
            requestPermissions(m18493W1(), 3);
        }
    }

    /* renamed from: V1 */
    public final void m18499V1() {
        LinearLayout linearLayout = this.f13456z;
        if (linearLayout != null) {
            C11842p.m70882x1(this, linearLayout);
        }
        LinearLayout linearLayout2 = this.f13434A;
        if (linearLayout2 != null) {
            C11842p.m70795b2(this, linearLayout2);
        }
    }

    /* renamed from: X1 */
    public final void m18500X1() {
        C12515a.m75110o().m75175e(new C3113g(), false);
    }

    /* renamed from: Y1 */
    public final void m18501Y1() {
        Intent intent = new Intent();
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.setAction("com.huawei.android.hicloud.ui.activity.CloudSpaceExpansionServiceActivity");
        try {
            startActivity(intent);
        } catch (Exception e10) {
            C11839m.m70687e("AboutActivity", "start ExpansionService Activity error: " + e10.toString());
        }
    }

    /* renamed from: Z1 */
    public final void m18502Z1(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("AboutActivity", "handleJumpToInstructions host is empty set default");
            str = "";
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str + "/"));
        try {
            startActivity(intent);
        } catch (Exception unused) {
            C11839m.m70687e("AboutActivity", "linkOfficialSites handle intent exception");
        }
    }

    /* renamed from: a2 */
    public boolean m18503a2(String... strArr) {
        for (String str : strArr) {
            if (checkSelfPermission(str) != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b2 */
    public void m18504b2(String str, boolean z10, View.OnClickListener onClickListener) {
        if (C0209d.m1312u0() < 11) {
            setTheme(R.style.Theme);
            return;
        }
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            if (C0209d.m1212T1()) {
                ActionBarEx.setStartIcon(actionBar, z10, (Drawable) null, onClickListener);
            } else {
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
            if (str != null) {
                actionBar.setTitle(str);
            }
        }
    }

    /* renamed from: c2 */
    public final void m18505c2() {
        if (C0209d.m1312u0() < 11) {
            setTheme(R.style.Theme);
        } else {
            m18504b2(getResources().getString(R$string.setting_about_new), false, null);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f13446p);
        arrayList.add(this.f13447q);
        arrayList.add(this.f13442I);
        arrayList.add(this.f13443J);
        arrayList.add(this.f13448r);
        arrayList.add(this.f13449s);
        return arrayList;
    }

    /* renamed from: d2 */
    public final void m18506d2() {
        this.f13456z = (LinearLayout) C12809f.m76829b(this, R$id.about_card_layout);
        this.f13434A = (LinearLayout) C12809f.m76829b(this, R$id.about_useagree_column);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: f1 */
    public int mo18507f1() {
        return R$id.about_scroll_view;
    }

    /* renamed from: g2 */
    public final /* synthetic */ void m18508g2(Intent intent) {
        sendBroadcast(intent);
    }

    /* renamed from: h2 */
    public final void m18509h2() {
        C12515a.m75110o().m75175e(new C3112f(), false);
    }

    /* renamed from: i2 */
    public final void m18510i2(String str) {
        C11839m.m70688i("AboutActivity", "notifyPhoneFinderClose");
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("AboutActivity", "notify phone finder: verifyToken is empty");
        } else if (C1010e.m6125b().m6138d(this)) {
            C1010e.m6125b().m6157w(getApplicationContext(), str);
        } else {
            C11839m.m70688i("AboutActivity", "notify phone finder: phone close");
        }
    }

    /* renamed from: j2 */
    public void m18511j2() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Resources resources = getResources();
        if (resources != null) {
            int color = resources.getColor(R$color.hicloud_hmos_bg);
            C0209d.m1306s2(getActionBar(), this, color);
            Window window = getWindow();
            if (window != null) {
                window.setStatusBarColor(color);
            }
        }
    }

    /* renamed from: l2 */
    public final void m18512l2() {
        SpanClickText spanClickText = (SpanClickText) C12809f.m76829b(this, R$id.about_ipc_filing);
        if (!C13452e.m80781L().m80803F0().booleanValue()) {
            spanClickText.setVisibility(8);
            return;
        }
        spanClickText.setVisibility(0);
        String string = getString(R$string.about_icp_filing_no, "17040376", "202A");
        String string2 = getString(R$string.about_icp_filing, string);
        spanClickText.m15931c(string, new C11427b(this, "icp_filing"));
        spanClickText.m15934g(string2, false);
    }

    /* renamed from: m2 */
    public final void m18513m2() {
        SpanClickText spanClickText = (SpanClickText) C12809f.m76829b(this, R$id.useragreement_about);
        String string = getString(C13452e.m80781L().m80803F0().booleanValue() ? R$string.user_agreement : R$string.cloud_service_terms_text);
        String string2 = getString(C13452e.m80781L().m80803F0().booleanValue() ? R$string.privacy_statement : R$string.cloud_service_privacy_statement);
        String string3 = getString(R$string.about_policy, string, string2);
        spanClickText.m15931c(string, new C11427b(this, C13452e.m80781L().m80803F0().booleanValue() ? "user_agreement_cn" : "user_agreement"));
        spanClickText.m15931c(string2, new C11427b(this, C13452e.m80781L().m80803F0().booleanValue() ? "privacy_statement_cn" : "privacy_statement"));
        spanClickText.m15934g(string3, false);
    }

    /* renamed from: n2 */
    public final void m18514n2() {
        TextView textView = (TextView) C12809f.m76829b(this, R$id.version_value);
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.version);
        textView.setText("16.0.0.300");
        int i10 = R$string.version_number;
        textView2.setContentDescription(C0209d.m1303s(getString(i10), "16.0.0.300"));
        textView.setContentDescription(C0209d.m1303s(getString(i10), "16.0.0.300"));
    }

    /* renamed from: o2 */
    public final void m18515o2() throws IllegalAccessException, IllegalArgumentException {
        Resources resources = getResources();
        if (resources == null) {
            return;
        }
        int i10 = R$string.stop_cloud_service_desc_1;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(resources.getString(R$string.stop_cloud_space_service)).setMessage(resources.getString(i10)).setPositiveButton(resources.getString(R$string.cancel), new DialogInterfaceOnClickListenerC3111e()).setNegativeButton(resources.getString(R$string.stop_use_cloud_space), new DialogInterfaceOnClickListenerC3110d());
        AlertDialog alertDialogCreate = builder.create();
        this.f13437D = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f13437D.show();
        Button button = this.f13437D.getButton(-2);
        if (button != null) {
            button.setTextColor(getResources().getColor(R$color.enui50_red_color));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        C11839m.m70688i("AboutActivity", "requestCode:" + i10 + " resultCode: " + i11);
        if (i10 == 1212) {
            if (i11 == -1) {
                C11839m.m70688i("AboutActivity", "verifyPassWord ok");
                if (intent != null) {
                    this.f13444K = new HiCloudSafeIntent(intent).getStringExtra(CommonConstant.KEY_ID_TOKEN);
                }
                Intent intentM81892w = C13612b.m81829B().m81892w();
                if (intentM81892w == null) {
                    C11839m.m70687e("AboutActivity", "getAccountLogoutIntent intent is null.");
                    return;
                } else {
                    startActivityForResult(intentM81892w, 1213);
                    C14303a.m85185a().m85193i(false);
                }
            } else {
                C11839m.m70688i("AboutActivity", "verifyPassWord fail");
            }
        } else if (i10 == 1213) {
            C11839m.m70688i("AboutActivity", "stop use cloud space services");
            if (i11 == -1) {
                m18510i2(this.f13444K);
                C13227f.m79492i1().m79585f0("click_stop_success_cloud_services", C13452e.m80781L().m80971t0());
                UBAAnalyze.m29954O("PVC", "click_stop_success_cloud_services", "1", "100");
                final Intent intent2 = new Intent();
                C0209d.m1302r2(intent2, "com.huawei.hidisk");
                intent2.setAction(Action.ACTION_HW_ACCOUNT_LOGOUT);
                intent2.putExtra(JsbMapKeyNames.H5_USER_ID, C13452e.m80781L().m80971t0());
                C13452e.m80781L().m80953o2(true);
                C0226l0.m1585e(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f16465a.m18508g2(intent2);
                    }
                }, 1000L);
            }
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException {
        if (!C0209d.m1333z1(this)) {
            this.f13443J.m23914a();
            this.f13442I.m23919i();
            return;
        }
        this.f13442I.m23914a();
        if (C0209d.m1226Y0()) {
            return;
        }
        if (view.getId() == R$id.hicloud_about_open_source_permission) {
            Intent intent = new Intent();
            intent.setAction(NotifyConstants.Action.HICLOUD_WEBVIEW_ACTION);
            C0209d.m1302r2(intent, "com.huawei.hidisk");
            intent.putExtra("srcChannel", "0");
            intent.putExtra("salChannel", "0");
            intent.putExtra("url", "file:///android_asset/web/OpenSourceSoftwareNotice.html");
            intent.putExtra("if_local_html_file", true);
            intent.putExtra("title", "OPEN SOURCE SOFTWARE NOTICE");
            intent.putExtra("isEnableJs", true);
            intent.putExtra("launch_web_type", -1);
            intent.putExtra("is_support_orientation", true);
            intent.putExtra("is_support_dark_mode", true);
            startActivity(intent);
            return;
        }
        if (view.getId() == R$id.about_official) {
            m18509h2();
            return;
        }
        if (view.getId() == R$id.hicloud_function_item_permission) {
            C13227f.m79492i1().m79585f0("extended_service_click_about", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "extended_service_click_about", "1", "100");
            m18501Y1();
        } else if (view.getId() == R$id.hicloud_stop_service_item) {
            C13227f.m79492i1().m79585f0("click_stop_cloud_services", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "click_stop_cloud_services", "1", "100");
            m18515o2();
        } else if (view.getId() == R$id.customer_service_phone_item) {
            m18498U1(this.f13440G.getText().toString());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m18499V1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        C10161l.m63342b().m63345d(this);
        m18505c2();
        m18511j2();
        m18496k2();
        m18495f2();
        mo19005p1();
        m18514n2();
        m18494e2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C10161l.m63342b().m63344c(this);
        C11842p.m70836m(this);
        this.f13445L.removeCallbacksAndMessages(null);
        this.f13445L = null;
        super.onDestroy();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f13442I != null) {
            if (!C0209d.m1333z1(this)) {
                this.f13443J.m23914a();
                this.f13442I.m23919i();
                return;
            }
            this.f13442I.m23914a();
        }
        if (this.f13443J != null) {
            C12515a.m75110o().m75175e(new C3109c(), false);
        }
    }

    /* renamed from: p2 */
    public final void m18516p2() {
        try {
            Intent intentM79271I = C13195l.m79271I(this, "hwid://com.huawei.hwid/VerifyPasswordV2");
            if (intentM79271I == null) {
                C11839m.m70687e("AboutActivity", "hmsPackage is invalid!");
                C11841o.m70707c(this, R$string.phonefinder_remand_download_hms, 0);
            } else {
                intentM79271I.putExtra("VERIFY_PWD_TYPE", C13452e.m80781L().m80799E0() ? 3 : 0);
                intentM79271I.putExtra("callingpackage", getPackageName());
                intentM79271I.putExtra("idTokenSignAlg", 1);
                startActivityForResult(intentM79271I, CommonConstant.RETCODE.NEED_UPDATE_STATICKIT);
            }
        } catch (Exception e10) {
            C11839m.m70687e("AboutActivity", "checkHwIdPasswordV2 exception: " + e10.getMessage());
            C11841o.m70707c(this, R$string.phonefinder_remand_download_hms, 0);
        }
    }
}
