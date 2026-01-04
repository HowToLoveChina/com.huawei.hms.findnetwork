package com.huawei.android.hicloud.oobe.p086ui.activity;

import ac.C0089a;
import ac.C0099k;
import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ck.C1443a;
import com.huawei.android.hicloud.commonlib.view.CommonDialogInterface;
import com.huawei.android.hicloud.oobe.R$dimen;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$layout;
import com.huawei.android.hicloud.oobe.R$string;
import com.huawei.android.hicloud.oobe.p086ui.uiadapter.OOBERecoverySuccessAdapter;
import com.huawei.android.hicloud.p088ui.extend.NotchBottomFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.TextBannerView;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import gp.C10028c;
import hu.C10343b;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import mk.C11477c;
import p015ak.C0209d;
import p015ak.C0219i;
import p020ap.C1007b;
import p034bc.C1162b;
import p422k9.C11019b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11840n;
import p514o9.C11842p;
import p684un.C13227f;
import p709vj.InterfaceC13456i;
import sk.C12809f;

/* loaded from: classes3.dex */
public class OOBERecoveringActivity extends OOBEBaseActivity implements View.OnClickListener {

    /* renamed from: B */
    public RelativeLayout f12434B;

    /* renamed from: C */
    public TextView f12435C;

    /* renamed from: D */
    public TextView f12436D;

    /* renamed from: E */
    public ProgressBar f12437E;

    /* renamed from: F */
    public RelativeLayout f12438F;

    /* renamed from: G */
    public RelativeLayout f12439G;

    /* renamed from: H */
    public ListView f12440H;

    /* renamed from: I */
    public Button f12441I;

    /* renamed from: J */
    public HwButton f12442J;

    /* renamed from: K */
    public CommonDialogInterface f12443K;

    /* renamed from: L */
    public CommonDialogInterface f12444L;

    /* renamed from: M */
    public CommonDialogInterface f12445M;

    /* renamed from: P */
    public OOBERecoverySuccessAdapter f12448P;

    /* renamed from: Q */
    public TextView f12449Q;

    /* renamed from: S */
    public TextBannerView f12451S;

    /* renamed from: T */
    public NotchFitLinearLayout f12452T;

    /* renamed from: A */
    public boolean f12433A = false;

    /* renamed from: N */
    public ArrayList<String> f12446N = new ArrayList<>();

    /* renamed from: O */
    public ArrayList<String> f12447O = new ArrayList<>();

    /* renamed from: R */
    public List<String> f12450R = new ArrayList();

    /* renamed from: U */
    public Handler.Callback f12453U = new C2833a();

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.OOBERecoveringActivity$a */
    public class C2833a implements Handler.Callback {
        public C2833a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Bundle data;
            String str;
            String strM66450w;
            if (C11019b.m66371t().m66396P(message.what)) {
                C11839m.m70686d("OOBERecoveringActivity", "CMD_START_CLOUDBACKUP ");
                return false;
            }
            if (C11019b.m66371t().m66392L(message.what)) {
                List list = (List) message.obj;
                OOBERecoveringActivity.this.f12447O.clear();
                OOBERecoveringActivity.this.f12446N.clear();
                for (Object obj : list) {
                    String string = OOBERecoveringActivity.this.getString(R$string.system_data);
                    if (obj instanceof String) {
                        str = (String) obj;
                        strM66450w = C11019b.m66371t().m66450w(OOBERecoveringActivity.this, str);
                    } else {
                        str = "";
                        strM66450w = "";
                    }
                    if (strM66450w != null) {
                        if (strM66450w.equals(string)) {
                            OOBERecoveringActivity.this.f12446N.add(str);
                        } else {
                            OOBERecoveringActivity.this.f12447O.add(str);
                        }
                    }
                }
                C11839m.m70688i("OOBERecoveringActivity", " restoreadapter size=" + OOBERecoveringActivity.this.f12448P.getCount());
                return false;
            }
            if (!C11019b.m66371t().m66395O(message.what)) {
                if (C11019b.m66371t().m66393M(message.what)) {
                    OOBERecoveringActivity.this.m16693S0(message.getData());
                    return false;
                }
                if (!C11019b.m66371t().m66394N(message.what) || (data = message.getData()) == null) {
                    return false;
                }
                OOBERecoveringActivity.this.m16684L0(data.getString("speed"));
                return false;
            }
            if (((Boolean) message.obj).booleanValue()) {
                OOBERecoveringActivity.this.m16695U0();
                return false;
            }
            C11839m.m70687e("OOBERecoveringActivity", "CMD_END_CBRESTORE_FIRST errCode = " + message.arg1);
            OOBERecoveringActivity.this.m16688X0(message.arg1);
            OOBERecoveringActivity.this.f12351k.m17046h();
            OOBERecoveringActivity oOBERecoveringActivity = OOBERecoveringActivity.this;
            if (oOBERecoveringActivity.f12341a == 1) {
                C11829c.m70585i1(oOBERecoveringActivity.f12444L.getWindow());
                C11829c.m70569d0(OOBERecoveringActivity.this.f12444L);
                C11840n.m70695f(OOBERecoveringActivity.this.f12444L);
            }
            OOBERecoveringActivity.this.f12444L.show();
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.OOBERecoveringActivity$b */
    public class C2834b implements InterfaceC13456i {
        public C2834b() {
        }

        @Override // p709vj.InterfaceC13456i
        public void loginResult(boolean z10) {
            if (!C0209d.m1333z1(OOBERecoveringActivity.this) || !z10 || !C11019b.m66371t().m66400T()) {
                OOBERecoveringActivity.this.setResult(-1);
                OOBERecoveringActivity.this.finish();
                return;
            }
            Class clsM66441r = C11019b.m66371t().m66441r("OOBEPhoneFinderActivity");
            if (clsM66441r != null) {
                Intent intent = new Intent(OOBERecoveringActivity.this, (Class<?>) clsM66441r);
                intent.putExtra(RemoteMessageConst.FROM, OOBERecoveringActivity.this.getPackageName());
                OOBERecoveringActivity.this.startActivityForResult(intent, 10005);
            }
        }
    }

    /* renamed from: K0 */
    public static String m16683K0(int i10) {
        try {
            return NumberFormat.getPercentInstance().format(new BigDecimal(i10).divide(new BigDecimal(100)).doubleValue());
        } catch (Exception unused) {
            C11839m.m70687e("OOBERecoveringActivity", "getLocaleFormatNum params invalid error");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public void m16684L0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f12449Q.setVisibility(8);
        this.f12451S.setVisibility(0);
        this.f12451S.m24045m(str, 1);
    }

    /* renamed from: N0 */
    private void m16685N0() {
        HiCloudSafeIntent hiCloudSafeIntent;
        Bundle extras;
        OOBERecoverySuccessAdapter oOBERecoverySuccessAdapter = new OOBERecoverySuccessAdapter(this);
        this.f12448P = oOBERecoverySuccessAdapter;
        this.f12440H.setAdapter((ListAdapter) oOBERecoverySuccessAdapter);
        C11019b.m66371t().m66428k0(this.f12453U);
        Intent intent = getIntent();
        if (intent == null || (extras = (hiCloudSafeIntent = new HiCloudSafeIntent(intent)).getExtras()) == null) {
            return;
        }
        C10343b c10343b = new C10343b(extras);
        int intExtra = hiCloudSafeIntent.getIntExtra("current_status", 1);
        if (1 != intExtra) {
            if (2 == intExtra) {
                String strM66439q = C11019b.m66371t().m66439q();
                if (TextUtils.isEmpty(strM66439q)) {
                    return;
                }
                String string = getString(R$string.recovering_processing, C11019b.m66371t().m66452x(this, strM66439q));
                TextView textView = this.f12435C;
                if (textView != null) {
                    textView.setText(string);
                    return;
                }
                return;
            }
            return;
        }
        String strM63694p = c10343b.m63694p("backup_id");
        String strM63694p2 = c10343b.m63694p(C6148x2.DEVICE_ID);
        String strM63694p3 = c10343b.m63694p("backup_version");
        C11019b.m66371t().m66423i(c10343b.m63694p("backup_device_id"), C11477c.m68633c(strM63694p2), strM63694p3, c10343b.m63687i("device_type", 0), strM63694p, this.f12341a, c10343b.m63681c("is_refurbishment"), c10343b.m63681c("is_temp_backup"), c10343b.m63682d("isNewBmRecord", false));
        String string2 = getString(R$string.cloudbackup_prepare_data);
        TextView textView2 = this.f12435C;
        if (textView2 != null) {
            textView2.setText(string2);
        }
    }

    /* renamed from: O0 */
    private void m16686O0() {
        this.f12452T = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.ll_top);
        this.f12449Q = (TextView) C12809f.m76829b(this, R$id.restore_tv);
        this.f12451S = (TextBannerView) C12809f.m76829b(this, R$id.restore_tbv);
        this.f12435C = (TextView) C12809f.m76829b(this, R$id.oobe_recovering_main_title);
        this.f12436D = (TextView) C12809f.m76829b(this, R$id.oobe_recovering_progress_text);
        this.f12438F = (RelativeLayout) C12809f.m76829b(this, R$id.oobe_recovering_success_frame);
        this.f12439G = (RelativeLayout) C12809f.m76829b(this, R$id.recovering_main_frame);
        this.f12440H = (ListView) C12809f.m76829b(this, R$id.oobe_recovering_success_content);
        this.f12437E = (ProgressBar) C12809f.m76829b(this, R$id.recovering_progressbar);
        if (C0219i.m1463a() >= 17) {
            HwButton hwButton = (HwButton) C12809f.m76829b(this, R$id.oobe_recovery_continue_button);
            this.f12442J = hwButton;
            hwButton.setOnClickListener(this);
            C11842p.m70874v1(this, this.f12442J);
        } else {
            Button button = (Button) C12809f.m76829b(this, R$id.oobe_recovery_continue_button);
            this.f12441I = button;
            button.setOnClickListener(this);
        }
        this.f12434B = (RelativeLayout) C12809f.m76829b(this, R$id.oobe_recovery_buttons);
        this.f12443K = C11019b.m66371t().m66412c0(this);
        this.f12444L = C11019b.m66371t().m66408a0(this);
        this.f12445M = C11019b.m66371t().m66410b0(this);
        int i10 = this.f12341a;
        if (1 == i10) {
            CommonDialogInterface commonDialogInterface = this.f12443K;
            if (commonDialogInterface != null) {
                commonDialogInterface.setIsOOBE(true);
            }
        } else if (2 == i10) {
            m16601o0(R$string.from_hisync);
        }
        TextView textView = this.f12449Q;
        int i11 = R$string.recovering_tips_net;
        textView.setText(getString(i11));
        this.f12450R.add(getString(i11));
        this.f12450R.add(getString(i11));
        this.f12451S.setDatas(this.f12450R);
        this.f12449Q.setVisibility(0);
        this.f12451S.setVisibility(8);
        this.f12351k.m17042d();
        m16557E();
    }

    /* renamed from: Q0 */
    private void m16687Q0() {
        C1162b.m7257a().m7258b(this, new C2834b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X0 */
    public void m16688X0(int i10) {
        if (i10 == 1002) {
            this.f12444L.setMessage(getString(R$string.restore_failed_net_disable));
            return;
        }
        if (i10 == 1004) {
            this.f12444L.setMessage(getString(R$string.cloud_restore_failed_battery_2, C0209d.m1232a0(m16683K0(C1007b.m5980s().m6030v()))));
            return;
        }
        if (i10 == 1007) {
            this.f12444L.setMessage(getString(R$string.cloud_restore_failed_local_space_2));
            return;
        }
        if (i10 != 3107) {
            if (i10 == 3109) {
                this.f12444L.setMessage(getString(R$string.restore_failed_not_exist));
                return;
            }
            if (i10 != 3307) {
                if (i10 == 3911) {
                    this.f12444L.setMessage(getString(R$string.recovery_no_data_server_error));
                    return;
                }
                if (i10 == 3913) {
                    this.f12444L.setMessage(getString(R$string.retore_failed_backup_clear_tip));
                    return;
                }
                switch (i10) {
                    case 3103:
                    case 3104:
                    case 3105:
                        break;
                    default:
                        switch (i10) {
                            case 3203:
                            case 3204:
                            case 3205:
                                break;
                            default:
                                switch (i10) {
                                }
                                return;
                        }
                }
                this.f12444L.setMessage(getString(R$string.restore_failed_net_error));
                return;
            }
        }
        this.f12444L.setMessage(getString(R$string.restore_failed_sever_error));
    }

    /* renamed from: Y0 */
    private void m16689Y0() {
        ViewGroup.LayoutParams layoutParams = ((ViewGroup) C12809f.m76829b(this, R$id.recovering_scrollview)).getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).setMargins(0, C11842p.m70852q(this), 0, 0);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: A0 */
    public void mo16551A0() {
        RelativeLayout relativeLayout;
        C0089a c0089a = this.f12348h;
        if (c0089a != null && (relativeLayout = this.f12349i) != null) {
            c0089a.mo700m(this, relativeLayout);
        }
        super.mo16551A0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: C0 */
    public void mo16555C0() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: I */
    public void mo16561I() {
        m16686O0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: J */
    public void mo16562J() {
        m16686O0();
        m16697W0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: K */
    public void mo16563K() {
        m16601o0(R$string.from_hisync);
        m16686O0();
        m16697W0();
        if (this.f12341a == 1) {
            m16689Y0();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: M */
    public void mo16564M() {
        mo16563K();
    }

    /* renamed from: M0 */
    public final void m16690M0() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
    }

    /* renamed from: P0 */
    public final boolean m16691P0() {
        return C0219i.m1463a() >= 17 && C0219i.m1463a() < 21;
    }

    /* renamed from: R0 */
    public final void m16692R0(ListView listView, BaseAdapter baseAdapter) {
        baseAdapter.notifyDataSetChanged();
        C11019b.m66371t().m66383F0(listView, baseAdapter);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: S */
    public void mo16569S() {
        mo16572V();
    }

    /* renamed from: S0 */
    public final void m16693S0(Bundle bundle) {
        String str;
        float fM63685g = new C10343b(bundle).m63685g(VastAttribute.PROGRESS, 0.0f);
        C11839m.m70688i("OOBERecoveringActivity", "onProgressUpdate progress=" + fM63685g);
        if (this.f12436D != null && this.f12437E != null) {
            NumberFormat percentInstance = NumberFormat.getPercentInstance();
            percentInstance.setMinimumFractionDigits(2);
            try {
                str = percentInstance.format(new BigDecimal(fM63685g).divide(new BigDecimal(100)).doubleValue());
            } catch (Exception unused) {
                C11839m.m70687e("OOBERecoveringActivity", "getLocaleFormatNum params invalid error.");
                str = "";
            }
            C11839m.m70688i("OOBERecoveringActivity", "onProgressUpdate progress=" + str);
            this.f12436D.setText(str);
            this.f12437E.setProgress((int) fM63685g);
        }
        String string = getString(R$string.recovering_processing_new, "");
        TextView textView = this.f12435C;
        if (textView != null) {
            textView.setText(string);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: T */
    public void mo16570T() {
        if (C11019b.m66371t().m66380E()) {
            this.f12443K.customShow();
        }
    }

    /* renamed from: T0 */
    public void m16694T0() {
        setResult(0);
        finish();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: U */
    public void mo16571U() {
        mo16570T();
    }

    /* renamed from: U0 */
    public void m16695U0() {
        this.f12448P.m17031c();
        this.f12448P.m17029a(this.f12447O);
        if (this.f12448P.getCount() < 0) {
            return;
        }
        this.f12433A = true;
        this.f12439G.setVisibility(8);
        this.f12438F.setVisibility(0);
        int iM1463a = C0219i.m1463a();
        Resources resources = getResources();
        if (iM1463a >= 17 && iM1463a < 21 && resources != null) {
            float dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.margin_xl);
            C11842p.m70823i2(this.f12349i, dimensionPixelSize);
            this.f12351k.setMarginHorizontal((int) dimensionPixelSize);
        }
        this.f12351k.m17039a();
        m16690M0();
        if (1 == this.f12341a) {
            this.f12351k.m17049k();
        } else {
            this.f12434B.setVisibility(0);
        }
        if (this.f12446N.size() > 0) {
            this.f12448P.m17030b("other_setting");
        }
        m16692R0(this.f12440H, this.f12448P);
        C11019b.m66371t().m66449v0(this, true);
        C10028c.m62182c0().m62336h2("recovery by backup", true);
        C11019b.m66371t().m66381E0(this);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: V */
    public void mo16572V() {
        mo16570T();
    }

    /* renamed from: V0 */
    public void m16696V0() {
        setResult(-1);
        finish();
    }

    /* renamed from: W0 */
    public final void m16697W0() {
        if (C0209d.m1202Q0()) {
            this.f12351k.setNextBtnText(getString(R$string.allset_format));
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: Y */
    public void mo16574Y() {
        mo16577b0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: Z */
    public void mo16575Z() {
        if (C1443a.f6216d.booleanValue()) {
            setResult(-1);
            finish();
        } else if (C10028c.m62182c0().m62395t1("funcfg_find_my_phone_globe")) {
            m16687Q0();
        } else {
            setResult(-1);
            finish();
        }
    }

    /* renamed from: Z0 */
    public void m16698Z0() {
        if (C11019b.m66371t().m66384G()) {
            C11019b.m66371t().m66407a();
            setResult(0);
            finish();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: a0 */
    public void mo16576a0() {
        setResult(-1);
        finish();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: b0 */
    public void mo16577b0() {
        if (C0209d.m1202Q0()) {
            setResult(-1);
            finish();
        } else {
            setResult(1001);
            finish();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: c */
    public int mo16578c() {
        return R$layout.oobe_hisync_recovering;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: f */
    public int mo16583f() {
        return R$layout.oobe_hisync_recovering;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: f0 */
    public void mo16584f0(View view) {
        mo16588h0(view);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: g */
    public int mo16585g() {
        return mo16578c();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: g0 */
    public void mo16586g0(View view) {
        mo16588h0(view);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: h */
    public int mo16587h() {
        return R$layout.oobe_hisync_recovering_emui8;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: h0 */
    public void mo16588h0(View view) {
        if (view.getId() == R$id.oobe_recovery_continue_button) {
            if (!C11019b.m66371t().m66380E() || !C11019b.m66371t().m66417f(this)) {
                setResult(-1);
                finish();
                return;
            }
            if (this.f12341a == 1) {
                C11829c.m70585i1(this.f12445M.getWindow());
                C11829c.m70569d0(this.f12445M);
                C11840n.m70695f(this.f12445M);
            }
            this.f12445M.show();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: i */
    public int mo16589i() {
        return R$layout.oobe_hisync_recovering_emui81;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: i0 */
    public void mo16590i0(View view) {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: j */
    public int mo16591j() {
        return R$layout.oobe_hisync_recovering_emui9;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: l0 */
    public void mo16596l0() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: n0 */
    public void mo16599n0() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (-1 == i11) {
            setResult(-1);
            finish();
        } else {
            setResult(0);
            finish();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i10 = this.f12341a;
        if (2 == i10) {
            m16601o0(R$string.from_hisync);
        } else if (1 == i10) {
            this.f12443K.setIsOOBE(true);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        m16685N0();
        if (bundle != null && bundle.getBoolean("is_restore_success", false)) {
            this.f12446N.addAll(bundle.getStringArrayList("restore_success_list"));
            this.f12448P.m17029a(bundle.getStringArrayList("success_adapter_list"));
            m16695U0();
        } else {
            if (!m16691P0() || getResources() == null) {
                return;
            }
            float dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.margin_l);
            C11842p.m70823i2(this.f12349i, dimensionPixelSize);
            this.f12351k.setMarginHorizontal((int) dimensionPixelSize);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f12453U != null) {
            C11019b.m66371t().m66379D0(this.f12453U);
        }
        CommonDialogInterface commonDialogInterface = this.f12444L;
        if (commonDialogInterface != null) {
            commonDialogInterface.dismiss();
        }
        CommonDialogInterface commonDialogInterface2 = this.f12443K;
        if (commonDialogInterface2 != null) {
            commonDialogInterface2.dismiss();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            if (C11019b.m66371t().m66380E()) {
                this.f12443K.customShow();
            } else {
                setResult(0);
                finish();
            }
        }
        return false;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (C11019b.m66371t().m66380E()) {
            this.f12443K.customShow();
            return true;
        }
        setResult(0);
        finish();
        return true;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        if (1 == this.f12341a) {
            C13227f.m79492i1().m79577X(this);
            UBAAnalyze.m29964Y("PVC", getClass().getCanonicalName(), "1", "18", super.m16612u());
        } else {
            C13227f.m79492i1().m79580Z("com.huawei.android.hicloud.ui.activity.OOBERecoveringActivityFromSetting");
            UBAAnalyze.m29964Y("PVC", "com.huawei.android.hicloud.ui.activity.OOBERecoveringActivityFromSetting", "1", "18", super.m16612u());
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (1 == this.f12341a) {
            C13227f.m79492i1().m79582b0(this);
            UBAAnalyze.m29967a0("PVC", getClass().getCanonicalName(), "1", "18");
        } else {
            C13227f.m79492i1().m79584d0("com.huawei.android.hicloud.ui.activity.OOBERecoveringActivityFromSetting");
            UBAAnalyze.m29967a0("PVC", "com.huawei.android.hicloud.ui.activity.OOBERecoveringActivityFromSetting", "1", "18");
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f12433A) {
            bundle.putBoolean("is_restore_success", true);
            bundle.putStringArrayList("restore_success_list", this.f12446N);
            bundle.putStringArrayList("success_adapter_list", this.f12448P.m17032d());
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: p */
    public C0089a mo16602p() {
        return new C0099k(this.f12341a);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: s0 */
    public void mo16609s0() {
        RelativeLayout relativeLayout;
        C0089a c0089a = this.f12348h;
        if (c0089a != null && (relativeLayout = this.f12349i) != null) {
            c0089a.mo700m(this, relativeLayout);
        }
        super.mo16609s0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: t */
    public List<View> mo16610t() {
        ArrayList arrayList = new ArrayList();
        NotchBottomFitRelativeLayout notchBottomFitRelativeLayout = this.f12353m;
        if (notchBottomFitRelativeLayout != null) {
            arrayList.add(notchBottomFitRelativeLayout);
        }
        NotchFitLinearLayout notchFitLinearLayout = this.f12452T;
        if (notchFitLinearLayout != null) {
            arrayList.add(notchFitLinearLayout);
        }
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: u0 */
    public void mo16613u0() {
        if (C0219i.m1463a() >= 17) {
            super.m16617w0();
        } else {
            super.mo16613u0();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: y0 */
    public void mo16620y0() {
        if (this.f12357q < 17) {
            super.mo16620y0();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: z0 */
    public void mo16622z0() {
        RelativeLayout relativeLayout;
        C0089a c0089a = this.f12348h;
        if (c0089a != null && (relativeLayout = this.f12349i) != null) {
            c0089a.mo700m(this, relativeLayout);
        }
        super.mo16622z0();
    }
}
