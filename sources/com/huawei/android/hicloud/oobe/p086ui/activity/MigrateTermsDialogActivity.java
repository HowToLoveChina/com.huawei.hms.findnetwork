package com.huawei.android.hicloud.oobe.p086ui.activity;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.android.hicloud.oobe.R$anim;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$layout;
import com.huawei.android.hicloud.oobe.R$string;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0209d;
import p015ak.C0234s;
import p422k9.C11019b;
import p684un.C13227f;
import sk.C12808e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class MigrateTermsDialogActivity extends Activity {

    /* renamed from: a */
    public Context f12330a = null;

    /* renamed from: b */
    public AlertDialog f12331b = null;

    /* renamed from: c */
    public boolean f12332c = false;

    /* renamed from: d */
    public boolean f12333d = false;

    /* renamed from: e */
    public long f12334e;

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.MigrateTermsDialogActivity$a */
    public class ViewOnClickListenerC2814a implements View.OnClickListener {
        public ViewOnClickListenerC2814a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MigrateTermsDialogActivity.this.f12332c = true;
            MigrateTermsDialogActivity.this.m16539d();
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.MigrateTermsDialogActivity$b */
    public class ViewOnClickListenerC2815b implements View.OnClickListener {
        public ViewOnClickListenerC2815b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MigrateTermsDialogActivity.this.f12332c = true;
            MigrateTermsDialogActivity.this.f12333d = true;
            MigrateTermsDialogActivity.this.m16539d();
        }
    }

    /* renamed from: d */
    public final void m16539d() {
        AlertDialog alertDialog = this.f12331b;
        if (alertDialog != null) {
            alertDialog.cancel();
            this.f12331b = null;
        }
    }

    /* renamed from: e */
    public int m16540e() {
        int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - this.f12334e) / 1000);
        if (iCurrentTimeMillis <= 0) {
            return 1;
        }
        return iCurrentTimeMillis;
    }

    /* renamed from: f */
    public void m16541f() {
        View viewInflate = LayoutInflater.from(this.f12330a).inflate(R$layout.hicloud_migrate_terms_dialog, (ViewGroup) null);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.migrate_terms_num_1);
        TextView textView2 = (TextView) C12809f.m76831d(viewInflate, R$id.migrate_terms_num_2);
        TextView textView3 = (TextView) C12809f.m76831d(viewInflate, R$id.migrate_terms_num_3);
        int i10 = R$string.agreement_content_num;
        textView.setText(getString(i10, 1));
        textView2.setText(getString(i10, 2));
        textView3.setText(getString(i10, 3));
        TextView textView4 = (TextView) C12809f.m76831d(viewInflate, R$id.migrate_terms_content_1);
        TextView textView5 = (TextView) C12809f.m76831d(viewInflate, R$id.migrate_terms_content_2);
        TextView textView6 = (TextView) C12809f.m76831d(viewInflate, R$id.migrate_terms_content_3);
        textView4.setText(getString(R$string.hicloud_migrate_terms_of_service_180531));
        textView5.setText(getString(R$string.hicloud_migrate_terms_of_service_2_170303_wifi_1));
        int i11 = R$string.hicloud_migrate_terms_of_service_7_wifi;
        textView6.setText(getString(i11));
        if (C0209d.m1262h2()) {
            textView5.setText(getString(R$string.hicloud_migrate_terms_of_service_2_170303_wlan_1));
            textView6.setText(getString(R$string.hicloud_migrate_terms_of_service_7_wlan));
        } else {
            textView5.setText(getString(R$string.hicloud_migrate_terms_of_service_2_wifi));
            textView6.setText(getString(i11));
        }
        String string = getString(R$string.hicloud_migrate_terms_of_service_title_180531);
        String string2 = getString(R$string.cloud_service_legal_privacy_text);
        SpannableString spannableString = new SpannableString(getString(R$string.hicloud_migrate_terms_of_service_8, string2));
        int iIndexOf = spannableString.toString().indexOf(string2);
        ClickableSpan clickableSpanM66403W = C11019b.m66371t().m66403W(this.f12330a, 3);
        if (clickableSpanM66403W != null) {
            spannableString.setSpan(clickableSpanM66403W, iIndexOf, string2.length() + iIndexOf, 33);
        }
        TextView textView7 = (TextView) C12809f.m76831d(viewInflate, R$id.content_text_2);
        LinkMovementMethod linkMovementMethodM66404X = C11019b.m66371t().m66404X();
        if (linkMovementMethodM66404X != null) {
            textView7.setMovementMethod(linkMovementMethodM66404X);
        }
        textView7.setHighlightColor(this.f12330a.getColor(R.color.transparent));
        textView7.setText(spannableString);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this.f12330a).create();
        this.f12331b = alertDialogCreate;
        alertDialogCreate.setCancelable(false);
        this.f12331b.setView(viewInflate, 0, 0, 0, 0);
        this.f12331b.setTitle(string);
        ((Button) C12809f.m76831d(viewInflate, R$id.nagative_btn)).setOnClickListener(new ViewOnClickListenerC2814a());
        ((Button) C12809f.m76831d(viewInflate, R$id.positive_btn)).setOnClickListener(new ViewOnClickListenerC2815b());
        this.f12331b.show();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R$anim.activity_close, 0);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C0234s.m1639q(this);
        super.onConfigurationChanged(configuration);
        m16539d();
        m16541f();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C12808e.m76822a(this);
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.f12330a = this;
        m16541f();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        m16539d();
        this.f12332c = false;
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        C13227f.m79492i1().m79577X(this);
        UBAAnalyze.m29964Y("PVC", getClass().getCanonicalName(), "1", "18", m16540e());
    }

    @Override // android.app.Activity
    public void onResume() {
        this.f12334e = System.currentTimeMillis();
        super.onResume();
        C13227f.m79492i1().m79582b0(this);
        UBAAnalyze.m29967a0("PVC", getClass().getCanonicalName(), "1", "18");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (this.f12332c) {
            if (this.f12333d) {
                setResult(-1);
            } else {
                setResult(0);
            }
            finish();
        }
    }
}
