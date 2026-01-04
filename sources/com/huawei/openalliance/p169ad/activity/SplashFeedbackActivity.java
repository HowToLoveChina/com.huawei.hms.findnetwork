package com.huawei.openalliance.p169ad.activity;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8124q;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes8.dex */
public class SplashFeedbackActivity extends AbstractActivityC6903c {

    /* renamed from: a */
    private InterfaceC8124q f31775a;

    /* renamed from: b */
    private String f31776b;

    /* renamed from: com.huawei.openalliance.ad.activity.SplashFeedbackActivity$1 */
    public class RunnableC68971 implements Runnable {
        public RunnableC68971() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String strMo43324a = C7124fh.m43316b(SplashFeedbackActivity.this).mo43324a(SplashFeedbackActivity.this, "h5Server");
            String strM48151a = AbstractC7806cz.m48151a(SplashFeedbackActivity.this, "haid_h5_content_server");
            if (TextUtils.isEmpty(strMo43324a) && C6982bz.m41148a(SplashFeedbackActivity.this).mo41175d()) {
                AbstractC7185ho.m43820b("SplashFeedbackActivity", "grs url return null or empty, use local defalut url.");
                strMo43324a = strM48151a;
            }
            String strM38758a = SplashFeedbackActivity.this.m38758a(strMo43324a + "/cch5/pps-jssdk/h5-splashfeedback/index.html", SplashFeedbackActivity.this);
            if (TextUtils.isEmpty(strM38758a)) {
                AbstractC7185ho.m43820b("SplashFeedbackActivity", "url is null");
                SplashFeedbackActivity.this.finish();
            } else {
                AbstractC7185ho.m43821b("SplashFeedbackActivity", "url= %s", AbstractC7819dl.m48375a(strM38758a));
                SplashFeedbackActivity.this.f31775a.mo50323a(strM38758a);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.activity.SplashFeedbackActivity$a */
    public static class C6898a {

        /* renamed from: a */
        private Context f31778a;

        /* renamed from: b */
        private int f31779b;

        /* renamed from: c */
        private String f31780c;

        public C6898a(Context context, int i10, String str) {
            this.f31778a = context;
            this.f31779b = i10;
            this.f31780c = str;
        }

        @JavascriptInterface
        public void back() {
            AbstractC7185ho.m43817a("SplashFeedbackActivity", "back");
            Context context = this.f31778a;
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        }

        @JavascriptInterface
        public String getSplashFeedbackBtnText() {
            return this.f31780c;
        }

        @JavascriptInterface
        public boolean isDarkMode() {
            return AbstractC7811dd.m48342r(this.f31778a);
        }

        @JavascriptInterface
        public boolean openLinkInBrowser(String str) {
            return AbstractC7741ao.m47550a(this.f31778a, str);
        }

        @JavascriptInterface
        public void submit(String str, int i10) {
            String strM48153a;
            String str2;
            AbstractC7185ho.m43818a("SplashFeedbackActivity", "submit:%s %s", str, Integer.valueOf(i10));
            C6928i c6928i = new C6928i(this.f31778a.getApplicationContext());
            c6928i.m39208a("148", "" + this.f31779b, "" + i10, AbstractC7806cz.m48170d(str));
            if (i10 == 1) {
                c6928i.m39208a("147", "", "", "");
                Map<String, String> mapM47729a = !TextUtils.isEmpty(C7124fh.m43316b(this.f31778a).mo43430ca()) ? AbstractC7758be.m47729a(C7124fh.m43316b(this.f31778a).mo43430ca()) : null;
                if (mapM47729a == null) {
                    mapM47729a = new HashMap<>();
                }
                int i11 = this.f31779b;
                if (i11 == 1 || i11 == 4) {
                    strM48153a = AbstractC7806cz.m48153a(Long.valueOf(System.currentTimeMillis()));
                    str2 = Constants.SWIPE_TYPE;
                } else {
                    if (i11 == 2 || i11 == 3) {
                        strM48153a = AbstractC7806cz.m48153a(Long.valueOf(System.currentTimeMillis()));
                        str2 = Constants.TWIST_TYPE;
                    }
                    C7124fh.m43316b(this.f31778a).mo43486t(mapM47729a.toString());
                }
                mapM47729a.put(str2, strM48153a);
                C7124fh.m43316b(this.f31778a).mo43486t(mapM47729a.toString());
            }
            back();
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        InterfaceC8124q interfaceC8124q = this.f31775a;
        if (interfaceC8124q != null) {
            interfaceC8124q.mo50324d();
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return false;
    }

    /* renamed from: a */
    public String m38758a(String str, Context context) {
        if (AbstractC7806cz.m48165b(str)) {
            return "";
        }
        return str + Constants.QUESTION_STR + Constants.LANGUAGE_ASSIGN_STR + (Locale.getDefault().getLanguage().toLowerCase(Locale.getDefault()) + "-" + Locale.getDefault().getCountry().toUpperCase(Locale.getDefault())) + Constants.SCRIPT + AbstractC7811dd.m48344t(context) + Constants.VERSION + System.currentTimeMillis();
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e
    /* renamed from: a */
    public void mo38587a() {
        AbstractC7185ho.m43817a("SplashFeedbackActivity", "initLayout");
        setContentView(C6849R.layout.pure_web_activity_layout);
        new C6928i(getApplicationContext()).m39208a("146", "", "", "");
        int intExtra = new SafeIntent(getIntent()).getIntExtra(MapKeyNames.SPLASH_CLICKABLE_TYPE, 0);
        this.f31776b = C7124fh.m43316b(this).mo43399bZ();
        InterfaceC8124q interfaceC8124q = (InterfaceC8124q) findViewById(C6849R.id.webview);
        this.f31775a = interfaceC8124q;
        interfaceC8124q.mo50322a(new C6898a(this, intExtra, this.f31776b), "_ISplashFeedbackJS");
        AbstractC7834m.m48481b(new Runnable() { // from class: com.huawei.openalliance.ad.activity.SplashFeedbackActivity.1
            public RunnableC68971() {
            }

            @Override // java.lang.Runnable
            public void run() {
                String strMo43324a = C7124fh.m43316b(SplashFeedbackActivity.this).mo43324a(SplashFeedbackActivity.this, "h5Server");
                String strM48151a = AbstractC7806cz.m48151a(SplashFeedbackActivity.this, "haid_h5_content_server");
                if (TextUtils.isEmpty(strMo43324a) && C6982bz.m41148a(SplashFeedbackActivity.this).mo41175d()) {
                    AbstractC7185ho.m43820b("SplashFeedbackActivity", "grs url return null or empty, use local defalut url.");
                    strMo43324a = strM48151a;
                }
                String strM38758a = SplashFeedbackActivity.this.m38758a(strMo43324a + "/cch5/pps-jssdk/h5-splashfeedback/index.html", SplashFeedbackActivity.this);
                if (TextUtils.isEmpty(strM38758a)) {
                    AbstractC7185ho.m43820b("SplashFeedbackActivity", "url is null");
                    SplashFeedbackActivity.this.finish();
                } else {
                    AbstractC7185ho.m43821b("SplashFeedbackActivity", "url= %s", AbstractC7819dl.m48375a(strM38758a));
                    SplashFeedbackActivity.this.f31775a.mo50323a(strM38758a);
                }
            }
        });
    }
}
