package com.huawei.openalliance.p169ad.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.MenuItem;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7335ji;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.NotifyMessageNames;
import com.huawei.openalliance.p169ad.constant.UrlConstant;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.views.feedback.InterfaceC8096f;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8124q;
import java.util.Locale;

/* loaded from: classes8.dex */
public class AdComplainActivity extends AbstractActivityC6903c implements C7335ji.a {

    /* renamed from: c */
    private static InterfaceC8096f f31624c;

    /* renamed from: a */
    private InterfaceC8124q f31625a;

    /* renamed from: b */
    private String f31626b;

    /* renamed from: a */
    private String m38584a(String str) {
        if (AbstractC7806cz.m48165b(str)) {
            return "";
        }
        return str + Locale.getDefault().getLanguage().toLowerCase(Locale.getDefault()) + "-" + Locale.getDefault().getCountry().toLowerCase(Locale.getDefault());
    }

    /* renamed from: d */
    private void m38586d() {
        InterfaceC8096f interfaceC8096f = f31624c;
        if (interfaceC8096f != null) {
            interfaceC8096f.mo50142b();
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6903c
    /* renamed from: b */
    public String mo38589b() {
        return this.f31626b;
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        m38586d();
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AbstractC7185ho.m43817a("AdComplainActivity", "onDestroy");
        C7335ji.m45308a().m45311b(NotifyMessageNames.AD_COMPLAIN_MESSAGE_NAME, this);
        InterfaceC8124q interfaceC8124q = this.f31625a;
        if (interfaceC8124q != null) {
            interfaceC8124q.mo50324d();
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        m38586d();
        finish();
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e
    /* renamed from: a */
    public void mo38587a() {
        AbstractC7185ho.m43820b("AdComplainActivity", "initLayout");
        if (Constants.MAGEZINE_PKG_NAME.equalsIgnoreCase(getApplicationContext().getPackageName())) {
            setShowWhenLocked(true);
        }
        setContentView(C6849R.layout.pure_web_activity_layout);
        String stringExtra = new SafeIntent(getIntent()).getStringExtra(MapKeyNames.COMPLAIN_H5_TITLE);
        this.f31626b = stringExtra;
        if (stringExtra == null) {
            this.f31626b = "";
        }
        InterfaceC8124q interfaceC8124q = (InterfaceC8124q) findViewById(C6849R.id.webview);
        this.f31625a = interfaceC8124q;
        interfaceC8124q.mo50322a(f31624c, Constants.GET_COMPLAIN_ADD_INFO_JS_NAME);
        String strM38584a = m38584a(C7124fh.m43316b(this).mo43324a(this, UrlConstant.BASE_COMPLAIN_H5_URL));
        if (TextUtils.isEmpty(strM38584a)) {
            AbstractC7185ho.m43823c("AdComplainActivity", "url is empty");
            finish();
        } else {
            AbstractC7185ho.m43821b("AdComplainActivity", "fullUrl= %s", AbstractC7819dl.m48375a(strM38584a));
            this.f31625a.mo50323a(strM38584a);
        }
        C7335ji.m45308a().m45310a(NotifyMessageNames.AD_COMPLAIN_MESSAGE_NAME, this);
    }

    /* renamed from: a */
    public static void m38585a(InterfaceC8096f interfaceC8096f) {
        f31624c = interfaceC8096f;
    }

    @Override // com.huawei.openalliance.p169ad.C7335ji.a
    /* renamed from: a */
    public void mo38588a(String str, Intent intent) {
        if (TextUtils.isEmpty(str) || intent == null) {
            AbstractC7185ho.m43820b("AdComplainActivity", "param is empty!");
            return;
        }
        AbstractC7185ho.m43818a("AdComplainActivity", "onMessageNotify msgName:%s", str);
        try {
            if (NotifyMessageNames.AD_COMPLAIN_ACTION.equals(new SafeIntent(intent).getAction())) {
                finish();
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("AdComplainActivity", "ad complain err: %s", th2.getClass().getSimpleName());
        }
    }
}
