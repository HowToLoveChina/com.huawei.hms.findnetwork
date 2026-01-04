package com.huawei.opendevice.open;

import android.app.ActionBar;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C8191vm;
import com.huawei.openalliance.p169ad.InterfaceC7146gc;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.openalliance.p169ad.beans.metadata.OaidRecord;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7845x;
import java.util.Locale;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class OAIDSettingActivity extends BaseSettingActivity {

    /* renamed from: E */
    public C8191vm f38439E;

    /* renamed from: H */
    public TextView f38442H;

    /* renamed from: I */
    public InterfaceC7146gc f38443I;

    /* renamed from: D */
    public Switch f38438D = null;

    /* renamed from: F */
    public TextView f38440F = null;

    /* renamed from: G */
    public TextView f38441G = null;

    /* renamed from: J */
    public boolean f38444J = false;

    /* renamed from: K */
    public boolean f38445K = false;

    /* renamed from: com.huawei.opendevice.open.OAIDSettingActivity$a */
    public class RunnableC8252a implements Runnable {

        /* renamed from: com.huawei.opendevice.open.OAIDSettingActivity$a$a */
        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ boolean f38447a;

            public a(boolean z10) {
                this.f38447a = z10;
            }

            @Override // java.lang.Runnable
            public void run() {
                OAIDSettingActivity.this.f38438D.setChecked(this.f38447a);
                OAIDSettingActivity.this.f38439E.m50730a(true);
            }
        }

        public RunnableC8252a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7817dj.m48363a(new a("1".equals(OAIDSettingActivity.this.f38443I.mo43379bF())));
        }
    }

    /* renamed from: com.huawei.opendevice.open.OAIDSettingActivity$b */
    public class C8253b implements CompoundButton.OnCheckedChangeListener {
        public C8253b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) throws JSONException {
            OAIDSettingActivity.this.m51549a(z10);
        }
    }

    /* renamed from: C */
    public static boolean m51547C() {
        return true;
    }

    /* renamed from: d */
    public static void m51552d(Context context, String str, String str2) throws JSONException {
        new C6928i(context).m39205a(str, str2);
    }

    @Override // com.huawei.opendevice.open.BaseSettingActivity, com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e
    /* renamed from: a */
    public void mo38587a() {
        setContentView(C6849R.layout.opendevice_oaid_setting);
        this.f31812p = (ViewGroup) findViewById(C6849R.id.ll_content_root);
    }

    /* renamed from: f */
    public final void m51555f(String str, String str2) throws JSONException {
        m51552d(this, str, str2);
    }

    @Override // com.huawei.opendevice.open.BaseSettingActivity, com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e, com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) {
        StringBuilder sb2;
        String str;
        super.onCreate(bundle);
        this.f38445K = C6982bz.m41148a(this).mo41170a();
        boolean zM41152b = C6982bz.m41152b(this);
        this.f38444J = zM41152b;
        AbstractC7185ho.m43821b("OAIDSettingActivity", "onCreate, isInnerDevice: %s, isChina: %s", Boolean.valueOf(zM41152b), Boolean.valueOf(this.f38445K));
        if (this.f38444J && AbstractC7741ao.m47588j(this)) {
            AbstractC7741ao.m47564b(this, Constants.OAID_SETTING_URL);
        } else {
            if (this.f38445K) {
                try {
                    AbstractC7811dd.m48307b(this, 1);
                    this.f38443I = C7124fh.m43316b(this);
                    m51551c();
                    return;
                } catch (RuntimeException e10) {
                    e = e10;
                    sb2 = new StringBuilder();
                    str = "onCreate ";
                    sb2.append(str);
                    sb2.append(e.getClass().getSimpleName());
                    AbstractC7185ho.m43823c("OAIDSettingActivity", sb2.toString());
                    return;
                } catch (Throwable th2) {
                    e = th2;
                    sb2 = new StringBuilder();
                    str = "onCreate ex: ";
                    sb2.append(str);
                    sb2.append(e.getClass().getSimpleName());
                    AbstractC7185ho.m43823c("OAIDSettingActivity", sb2.toString());
                    return;
                }
            }
            AbstractC7741ao.m47589k(this);
        }
        finish();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        super.onBackPressed();
        return true;
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onResume() {
        super.onResume();
        C8191vm c8191vm = this.f38439E;
        if (c8191vm != null) {
            c8191vm.m50730a(false);
        }
        AbstractC7834m.m48479a(new RunnableC8252a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m51549a(boolean z10) throws JSONException {
        AbstractC7185ho.m43821b("OAIDSettingActivity", "handleAnonymousIdStatusChange, isChecked: %s", Boolean.valueOf(z10));
        if (this.f38443I == null) {
            this.f38443I = C7124fh.m43316b(this);
        }
        this.f38443I.mo43447d(z10);
        m51555f(z10 ? "51" : "36", z10 ? OaidRecord.LIMIT_OAID_OPEN_KEY : OaidRecord.LIMIT_OAID_CLOSE_KEY);
    }

    /* renamed from: c */
    private void m51551c() throws JSONException, Resources.NotFoundException {
        ActionBar actionBar = getActionBar();
        boolean zM48547c = C7845x.m48547c();
        if (actionBar != null) {
            if (m51547C()) {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
            actionBar.setTitle((zM48547c || !this.f38444J) ? C6849R.string.opendevice_hw_ad_service_new : C6849R.string.opendevice_title_oaid);
        }
        setTitle((zM48547c || !this.f38444J) ? C6849R.string.opendevice_hw_ad_service_new : C6849R.string.opendevice_title_oaid);
        this.f38442H = (TextView) findViewById(C6849R.id.opendevice_all_advertisers_tv);
        String string = getString(C6849R.string.opendevice_all_advertisers);
        if (!TextUtils.isEmpty(string)) {
            this.f38442H.setText(string.toUpperCase(Locale.getDefault()));
        }
        Switch r02 = (Switch) findViewById(C6849R.id.opendevice_limit_tracking_switch);
        this.f38438D = r02;
        if (!this.f38444J) {
            r02.setTrackDrawable(getResources().getDrawable(C6849R.drawable.hiad_switch_selector));
        }
        C8191vm c8191vm = new C8191vm(new C8253b());
        this.f38439E = c8191vm;
        this.f38438D.setOnCheckedChangeListener(c8191vm);
        this.f38440F = (TextView) findViewById(C6849R.id.opendevice_limit_tracking_tv);
        this.f38441G = (TextView) findViewById(C6849R.id.opendevice_limit_tracking_desc_tv);
        this.f38440F.setText(C6849R.string.opendevice_limit_ad_tracking);
        this.f38441G.setText(getString(C6849R.string.opendevice_item_reset_ad_des_new));
        TextView textView = (TextView) findViewById(C6849R.id.opendevice_oaid_privacy_tv);
        textView.setVisibility(0);
        try {
            int i10 = C6849R.string.opendevice_privacy_desc;
            int iIndexOf = getString(i10).indexOf("%1$s");
            int color = getResources().getColor(C6849R.color.hiad_dark_mode_tag_color);
            String string2 = getString(C6849R.string.opendevice_ad_privacy_statement);
            SpannableString spannableString = new SpannableString(getString(i10, string2));
            if (iIndexOf >= 0) {
                C8259b c8259b = new C8259b(this);
                c8259b.m51591a(PrivacyActivity.class);
                spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf, string2.length() + iIndexOf, 33);
                spannableString.setSpan(c8259b, iIndexOf, string2.length() + iIndexOf, 33);
                spannableString.setSpan(new ForegroundColorSpan(color), iIndexOf, string2.length() + iIndexOf, 33);
            }
            textView.setText(spannableString);
            textView.setMovementMethod(new C8261d(color, color));
        } catch (Resources.NotFoundException unused) {
            AbstractC7185ho.m43826d("OAIDSettingActivity", "getResources NotFoundException");
        }
        m51555f("38", OaidRecord.OPEN_OAID_SETTING_KEY);
    }
}
