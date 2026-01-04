package com.huawei.phoneservice.faq.p174ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.huawei.phoneservice.faq.FaqBaseActivity;
import com.huawei.phoneservice.faq.R$id;
import com.huawei.phoneservice.faq.R$layout;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.tracker.FaqTrack;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqMemoryLeakUtils;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.faq.utils.C8414d;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.tencent.p204mm.opensdk.openapi.IWXAPI;
import com.tencent.p204mm.opensdk.openapi.WXAPIFactory;
import java.util.Locale;

/* loaded from: classes4.dex */
public class FaqShareActivity extends FaqBaseActivity implements View.OnClickListener {

    /* renamed from: A */
    public View f39122A;

    /* renamed from: B */
    public View f39123B;

    /* renamed from: C */
    public String f39124C;

    /* renamed from: D */
    public String f39125D;

    /* renamed from: E */
    public String f39126E;

    /* renamed from: F */
    public String f39127F;

    /* renamed from: G */
    public String f39128G;

    /* renamed from: H */
    public String f39129H;

    /* renamed from: I */
    public String f39130I;

    /* renamed from: J */
    public String f39131J;

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqShareActivity$a */
    public class ViewOnClickListenerC8396a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ String f39132a;

        /* renamed from: b */
        public final /* synthetic */ IWXAPI f39133b;

        /* renamed from: c */
        public final /* synthetic */ String f39134c;

        /* renamed from: d */
        public final /* synthetic */ byte[] f39135d;

        public ViewOnClickListenerC8396a(String str, IWXAPI iwxapi, String str2, byte[] bArr) {
            this.f39132a = str;
            this.f39133b = iwxapi;
            this.f39134c = str2;
            this.f39135d = bArr;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            FaqTrack.event(FaqShareActivity.this.f39126E + "+SDK+Detail", String.format(Locale.getDefault(), "Share in %1$s", "微信"), String.format(Locale.getDefault(), "%1$s", FaqShareActivity.this.f39124C));
            String str = this.f39132a;
            IWXAPI iwxapi = this.f39133b;
            FaqShareActivity faqShareActivity = FaqShareActivity.this;
            C8414d.m52387i(str, iwxapi, faqShareActivity, faqShareActivity.f39124C, this.f39134c, FaqShareActivity.this.f39125D, this.f39135d);
            FaqShareActivity.this.m52264u0();
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.ui.FaqShareActivity$b */
    public class ViewOnClickListenerC8397b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ String f39137a;

        /* renamed from: b */
        public final /* synthetic */ IWXAPI f39138b;

        /* renamed from: c */
        public final /* synthetic */ String f39139c;

        /* renamed from: d */
        public final /* synthetic */ byte[] f39140d;

        public ViewOnClickListenerC8397b(String str, IWXAPI iwxapi, String str2, byte[] bArr) {
            this.f39137a = str;
            this.f39138b = iwxapi;
            this.f39139c = str2;
            this.f39140d = bArr;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            FaqTrack.event(FaqShareActivity.this.f39126E + "+SDK+Detail", String.format(Locale.getDefault(), "Share in %1$s", "微信朋友圈"), String.format(Locale.getDefault(), "%1$s", FaqShareActivity.this.f39124C));
            String str = this.f39137a;
            IWXAPI iwxapi = this.f39138b;
            FaqShareActivity faqShareActivity = FaqShareActivity.this;
            C8414d.m52383e(str, iwxapi, faqShareActivity, faqShareActivity.f39124C, this.f39139c, FaqShareActivity.this.f39125D, this.f39140d);
            FaqShareActivity.this.m52264u0();
        }
    }

    /* renamed from: p0 */
    public static void m52260p0(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intent intent = new Intent(context, (Class<?>) FaqShareActivity.class);
        intent.putExtra("title", str);
        intent.putExtra("url", str2);
        intent.putExtra("country", str3);
        intent.putExtra(FaqConstants.FAQ_CHANNEL, str4);
        intent.putExtra(FaqConstants.FAQ_WECHATID, str5);
        intent.putExtra(FaqConstants.FAQ_WEIBOID, str6);
        intent.putExtra(FaqConstants.FAQ_PICID, str7);
        intent.putExtra("totadescriptionl", str8);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public void m52264u0() {
        View view = this.f39123B;
        if (view != null && view.getVisibility() == 0) {
            this.f39123B.setVisibility(8);
        }
        View view2 = this.f39122A;
        if (view2 != null && view2.getVisibility() == 0) {
            this.f39122A.setVisibility(8);
        }
        onBackPressed();
    }

    /* renamed from: v0 */
    private void m52265v0() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f39124C = intent.getStringExtra("title");
            this.f39125D = intent.getStringExtra("url");
            this.f39126E = intent.getStringExtra(FaqConstants.FAQ_CHANNEL);
            this.f39127F = intent.getStringExtra("country");
            this.f39128G = intent.getStringExtra(FaqConstants.FAQ_WECHATID);
            this.f39129H = intent.getStringExtra(FaqConstants.FAQ_WEIBOID);
            this.f39130I = intent.getStringExtra(FaqConstants.FAQ_PICID);
            this.f39131J = intent.getStringExtra("totadescriptionl");
        }
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: f */
    public void mo51677f() {
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: f0 */
    public int mo51678f0() {
        return R$layout.faq_sdk_share_layout;
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: h0 */
    public void mo51671h0() {
        this.f39122A.setOnClickListener(this);
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: i0 */
    public void mo51672i0() throws Throwable {
        this.f39122A = findViewById(R$id.faq_sdk_share_mask);
        this.f39123B = findViewById(R$id.faq_sdk_share_layout_view);
        try {
            if (TextUtils.isEmpty(this.f39128G)) {
                C8414d.m52381c(this.f39126E, this, this.f39124C, this.f39125D);
                return;
            }
            IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(this, this.f39128G, true);
            if (iwxapiCreateWXAPI == null || !iwxapiCreateWXAPI.isWXAppInstalled()) {
                iwxapiCreateWXAPI = null;
            }
            m52266q0(iwxapiCreateWXAPI, this.f39128G, this.f39130I);
        } catch (Throwable th2) {
            FaqLogger.m51840e("FaqShareActivity", "share failed because of " + th2.getMessage());
            C8414d.m52381c(this.f39126E, this, this.f39124C, this.f39125D);
            m52264u0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!NoDoubleClickUtil.isDoubleClick(view) && view.getId() == R$id.faq_sdk_share_mask) {
            onBackPressed();
        }
    }

    @Override // com.huawei.phoneservice.faq.FaqBaseActivity, com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        m52265v0();
        requestWindowFeature(1);
        getWindow().addFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK);
        setContentView(mo51678f0());
        super.onCreate(bundle);
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() throws Throwable {
        FaqMemoryLeakUtils.fixMemoryLeak(this);
        super.onDestroy();
    }

    /* renamed from: q0 */
    public final void m52266q0(IWXAPI iwxapi, String str, String str2) throws Throwable {
        if (iwxapi == null) {
            C8414d.m52381c(this.f39126E, this, this.f39124C, this.f39125D);
            m52264u0();
            return;
        }
        String str3 = TextUtils.isEmpty(this.f39131J) ? this.f39124C : this.f39131J;
        this.f39131J = str3;
        byte[] bArrM52384f = C8414d.m52384f(this, str2);
        this.f39123B.setVisibility(0);
        this.f39122A.setVisibility(0);
        View viewFindViewById = this.f39123B.findViewById(R$id.faq_sdk_wechat_share);
        View viewFindViewById2 = this.f39123B.findViewById(R$id.faq_sdk_wxfriend_share);
        viewFindViewById.setVisibility(0);
        viewFindViewById2.setVisibility(0);
        String str4 = str3;
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC8396a(str, iwxapi, str4, bArrM52384f));
        viewFindViewById2.setOnClickListener(new ViewOnClickListenerC8397b(str, iwxapi, str4, bArrM52384f));
    }
}
