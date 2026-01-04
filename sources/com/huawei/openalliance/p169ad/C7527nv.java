package com.huawei.openalliance.p169ad;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.openalliance.p169ad.C7692tn;
import com.huawei.openalliance.p169ad.activity.SafeIntent;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.constant.Config;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.listeners.IPPSWebEventCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7791ck;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7830i;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@SuppressLint({"SetJavaScriptEnabled"})
/* renamed from: com.huawei.openalliance.ad.nv */
/* loaded from: classes8.dex */
public class C7527nv extends C7336jj<InterfaceC8130w> implements InterfaceC7542oj<InterfaceC8130w> {

    /* renamed from: d */
    private static final String f34969d = "nv";

    /* renamed from: e */
    private InterfaceC7615qq f34970e;

    /* renamed from: f */
    private Context f34971f;

    /* renamed from: g */
    private AdLandingPageData f34972g;

    /* renamed from: i */
    private IPPSWebEventCallback f34974i;

    /* renamed from: j */
    private C6922c f34975j;

    /* renamed from: k */
    private C6928i f34976k;

    /* renamed from: m */
    private long f34978m;

    /* renamed from: n */
    private Long f34979n;

    /* renamed from: p */
    private String f34981p;

    /* renamed from: h */
    private boolean f34973h = false;

    /* renamed from: l */
    private Boolean f34977l = Boolean.FALSE;

    /* renamed from: o */
    private boolean f34980o = false;

    /* renamed from: com.huawei.openalliance.ad.nv$a */
    public static class a implements Runnable {

        /* renamed from: a */
        private WebView f34991a;

        public a(WebView webView) {
            this.f34991a = webView;
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView webView = this.f34991a;
            if (webView != null) {
                webView.clearHistory();
            }
        }
    }

    public C7527nv(Context context, AdLandingPageData adLandingPageData, InterfaceC8130w interfaceC8130w) {
        m46225a(context, interfaceC8130w);
        mo46240a(adLandingPageData);
    }

    /* renamed from: a */
    private Intent m46222a(Uri uri) throws URISyntaxException {
        String str;
        String str2;
        try {
            String scheme = uri.getScheme();
            if (!scheme.equals("http") && !scheme.equals("https")) {
                if (!scheme.equals(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK)) {
                    return new Intent("android.intent.action.VIEW", uri);
                }
                Intent uri2 = Intent.parseUri(uri.toString(), 1);
                if (uri2.getData() != null) {
                    uri2 = uri2.setDataAndTypeAndNormalize(uri2.getData(), uri2.getType());
                }
                uri2.setComponent(null);
                uri2.setSelector(null);
                uri2.addCategory("android.intent.category.BROWSABLE");
                return uri2;
            }
            return null;
        } catch (RuntimeException unused) {
            str = f34969d;
            str2 = "getIntent RuntimeException";
            AbstractC7185ho.m43823c(str, str2);
            return null;
        } catch (Exception unused2) {
            str = f34969d;
            str2 = "getIntent Exception";
            AbstractC7185ho.m43823c(str, str2);
            return null;
        }
    }

    /* renamed from: l */
    private Set<String> m46235l() {
        MetaData metaData;
        AdLandingPageData adLandingPageData = this.f34972g;
        if (adLandingPageData != null && (metaData = (MetaData) AbstractC7758be.m47739b(adLandingPageData.m44319t(), MetaData.class, new Class[0])) != null) {
            List<String> listM40268E = metaData.m40268E();
            if (!AbstractC7760bg.m47767a(listM40268E)) {
                return new HashSet(listM40268E);
            }
        }
        return new HashSet();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7542oj
    /* renamed from: c */
    public String mo46249c(String str) {
        if (AbstractC7806cz.m48177g(str, this.f34981p) && AbstractC7741ao.m47552a(this.f34972g)) {
            str = AbstractC7806cz.m48168c(this.f34972g.getAppInfo().getAppName());
        }
        return str == null ? this.f34971f.getResources().getString(C6849R.string.hiad_detail) : TextUtils.equals(str, "about:blank") ? " " : str;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7542oj
    /* renamed from: d */
    public void mo46252d(long j10) {
        this.f34979n = Long.valueOf(j10);
        this.f34980o = true;
    }

    /* renamed from: h */
    public void m46253h() {
        this.f34975j.m39116b(this.f34972g);
    }

    /* renamed from: i */
    public void m46254i() {
        this.f34976k.m39201a(this.f34972g);
    }

    /* renamed from: j */
    public void m46255j() {
        this.f34976k.m39212b(this.f34972g);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    @Override // com.huawei.openalliance.p169ad.InterfaceC7542oj
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long mo46256k() {
        /*
            r7 = this;
            java.lang.Long r0 = r7.f34979n
            r1 = 0
            if (r0 == 0) goto L12
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.Long r0 = r7.f34979n
            long r5 = r0.longValue()
        L10:
            long r3 = r3 - r5
            goto L20
        L12:
            long r3 = r7.f34978m
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 <= 0) goto L1f
            long r3 = java.lang.System.currentTimeMillis()
            long r5 = r7.f34978m
            goto L10
        L1f:
            r3 = r1
        L20:
            com.huawei.openalliance.ad.inter.data.AdLandingPageData r0 = r7.f34972g
            int r0 = r0.getAdType()
            r5 = 7
            if (r0 != r5) goto L2e
            boolean r7 = r7.f34980o
            if (r7 != 0) goto L2e
            goto L2f
        L2e:
            r1 = r3
        L2f:
            boolean r7 = com.huawei.openalliance.p169ad.AbstractC7185ho.m43819a()
            if (r7 == 0) goto L44
            java.lang.String r7 = com.huawei.openalliance.p169ad.C7527nv.f34969d
            java.lang.Long r0 = java.lang.Long.valueOf(r1)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r3 = "getWebHasShownTime, webShowTime, duration: %s"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43818a(r7, r3, r0)
        L44:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7527nv.mo46256k():long");
    }

    public C7527nv(Context context, InterfaceC8130w interfaceC8130w) {
        m46225a(context, interfaceC8130w);
    }

    /* renamed from: b */
    private Intent m46232b(Intent intent) {
        SafeIntent safeIntent = new SafeIntent(intent);
        Set<String> setM46235l = m46235l();
        String scheme = safeIntent.getScheme();
        if (!AbstractC7760bg.m47767a(setM46235l) && m46228a(safeIntent, setM46235l, scheme)) {
            return safeIntent;
        }
        Set<String> setMo43420bu = C7124fh.m43316b(this.f34971f).mo43420bu();
        if (AbstractC7760bg.m47767a(setMo43420bu)) {
            return null;
        }
        if (m46228a(safeIntent, setMo43420bu, scheme)) {
            return safeIntent;
        }
        if (this.f34977l.booleanValue() || !Constants.SCHEME_MARKET.equalsIgnoreCase(scheme) || !C7830i.m48419a(this.f34971f, "com.huawei.appmarket")) {
            return null;
        }
        safeIntent.setPackage("com.huawei.appmarket");
        return safeIntent;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7542oj
    /* renamed from: c */
    public void mo46250c() {
        this.f34975j.m39082a(this.f34972g);
    }

    /* renamed from: a */
    private C7830i.a m46224a(Intent intent) {
        Set<C7830i.a> setM48411a = C7830i.m48411a(this.f34971f, intent);
        if (setM48411a == null || setM48411a.isEmpty()) {
            return null;
        }
        if (setM48411a.size() > 1 && C6982bz.m41152b(this.f34971f)) {
            return null;
        }
        Iterator<C7830i.a> it = setM48411a.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    /* renamed from: b */
    public String m46246b(String str) {
        return str;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7542oj
    /* renamed from: c */
    public void mo46251c(long j10) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a(f34969d, "setWebOpenTime, webOpenTime= %s", Long.valueOf(j10));
        }
        this.f34978m = j10;
        this.f34979n = null;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7542oj
    /* renamed from: a */
    public void mo46236a() {
        IPPSWebEventCallback iPPSWebEventCallback = this.f34974i;
        if (iPPSWebEventCallback != null) {
            iPPSWebEventCallback.onWebOpen();
        }
        InterfaceC7615qq interfaceC7615qq = this.f34970e;
        if (interfaceC7615qq != null) {
            interfaceC7615qq.mo46624g();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7542oj
    /* renamed from: b */
    public void mo46247b() {
        IPPSWebEventCallback iPPSWebEventCallback = this.f34974i;
        if (iPPSWebEventCallback != null) {
            iPPSWebEventCallback.onWebloadFinish();
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a(f34969d, "onWebloadFinish");
        }
        if (this.f34979n == null) {
            this.f34979n = Long.valueOf(System.currentTimeMillis());
        }
        InterfaceC7615qq interfaceC7615qq = this.f34970e;
        if (interfaceC7615qq != null) {
            interfaceC7615qq.mo46625h();
        }
    }

    /* renamed from: b */
    public static void m46233b(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setLoadsImagesAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAllowFileAccess(false);
        settings.setCacheMode(-1);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setGeolocationEnabled(false);
        settings.setAllowContentAccess(false);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7542oj
    /* renamed from: a */
    public void mo46237a(int i10) {
        long jCurrentTimeMillis;
        IPPSWebEventCallback iPPSWebEventCallback = this.f34974i;
        if (iPPSWebEventCallback != null) {
            iPPSWebEventCallback.onWebClose(i10);
        }
        if (this.f34979n != null) {
            jCurrentTimeMillis = System.currentTimeMillis() - this.f34979n.longValue();
            this.f34979n = null;
        } else if (this.f34978m > 0) {
            jCurrentTimeMillis = System.currentTimeMillis() - this.f34978m;
            this.f34978m = 0L;
        } else {
            jCurrentTimeMillis = 0;
        }
        long j10 = (this.f34972g.getAdType() != 7 || this.f34980o) ? jCurrentTimeMillis : 0L;
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a(f34969d, "onWebClose, duration: %s", Long.valueOf(j10));
        }
        InterfaceC7615qq interfaceC7615qq = this.f34970e;
        if (interfaceC7615qq != null) {
            interfaceC7615qq.mo46578a(i10, j10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7542oj
    /* renamed from: a */
    public void mo46238a(int i10, int i11) {
        this.f34976k.m39197a(i10, i11, AbstractC7572pf.m46743a(this.f34972g));
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7542oj
    /* renamed from: b */
    public void mo46248b(InterfaceC7615qq interfaceC7615qq) {
        this.f34970e = interfaceC7615qq;
    }

    /* renamed from: a */
    private void m46225a(Context context, InterfaceC8130w interfaceC8130w) {
        this.f34971f = context;
        mo45316a((C7527nv) interfaceC8130w);
        this.f34975j = new C6922c(context);
        this.f34976k = new C6928i(context);
        this.f34981p = C7124fh.m43316b(context).mo43065am();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7542oj
    /* renamed from: a */
    public void mo46239a(WebView webView) {
        String str;
        StringBuilder sb2;
        String str2;
        if (webView == null) {
            return;
        }
        m46233b(webView);
        WebSettings settings = webView.getSettings();
        m46227a(settings);
        try {
            String userAgentString = settings.getUserAgentString();
            if (userAgentString != null && userAgentString.indexOf(Constants.PPS_UA) < 0) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(userAgentString);
                sb3.append(" ");
                sb3.append(Constants.PPS_UA);
                sb3.append("/");
                sb3.append(Config.SDK_VERSION);
                if (this.f34971f != null) {
                    sb3.append(" ");
                    sb3.append(this.f34971f.getPackageName());
                    sb3.append("/");
                    sb3.append(C7830i.m48409a(this.f34971f));
                }
                userAgentString = sb3.toString();
                settings.setUserAgentString(userAgentString);
            }
            AbstractC7185ho.m43818a(f34969d, "UserAgent:%s", userAgentString);
        } catch (RuntimeException e10) {
            e = e10;
            str = f34969d;
            sb2 = new StringBuilder();
            str2 = "add useragent RuntimeException:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43826d(str, sb2.toString());
        } catch (Exception e11) {
            e = e11;
            str = f34969d;
            sb2 = new StringBuilder();
            str2 = "add useragent Exception:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43826d(str, sb2.toString());
        }
    }

    /* renamed from: a */
    private void m46226a(WebView webView, final C7830i.a aVar, final Intent intent, final C7692tn c7692tn) {
        View viewInflate = LayoutInflater.from(this.f34971f).inflate(C6849R.layout.hiad_open_app_dialog, (ViewGroup) null);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(C6849R.id.hiad_open_app_nomore_remind);
        TextView textView = (TextView) viewInflate.findViewById(C6849R.id.hiad_open_app_tips);
        String strM48443b = aVar.m48443b();
        if (TextUtils.isEmpty(strM48443b) || !C6982bz.m41152b(this.f34971f)) {
            strM48443b = this.f34971f.getString(C6849R.string.hiad_default_app_name);
            checkBox.setVisibility(8);
        }
        textView.setText(this.f34971f.getString(C6849R.string.hiad_landing_page_open_app, strM48443b));
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.huawei.openalliance.ad.nv.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                C7527nv.this.f34973h = z10;
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f34971f);
        builder.setView(viewInflate);
        builder.setPositiveButton(C6849R.string.hiad_dialog_allow, new DialogInterface.OnClickListener() { // from class: com.huawei.openalliance.ad.nv.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                C7527nv.this.m46254i();
                C7830i.m48412a(C7527nv.this.f34971f, intent, c7692tn);
                if (C7527nv.this.f34973h) {
                    C7124fh.m43316b(C7527nv.this.f34971f).mo43328a(aVar.m48442a(), true);
                }
            }
        });
        builder.setNeutralButton(C6849R.string.hiad_dialog_reject, new DialogInterface.OnClickListener() { // from class: com.huawei.openalliance.ad.nv.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                C7527nv.this.m46255j();
                if (C7527nv.this.f34973h) {
                    C7124fh.m43316b(C7527nv.this.f34971f).mo43328a(aVar.m48442a(), false);
                }
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        if (!(webView.getContext() instanceof Activity)) {
            alertDialogCreate.getWindow().setType(2003);
        }
        alertDialogCreate.show();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7542oj
    /* renamed from: a */
    public final void mo46240a(AdLandingPageData adLandingPageData) {
        if (adLandingPageData != null) {
            this.f34972g = adLandingPageData;
            Context context = this.f34971f;
            C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, adLandingPageData.getAdType()));
            this.f34970e = c7560ou;
            c7560ou.mo46590a(adLandingPageData.m44329y());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7542oj
    /* renamed from: a */
    public void mo46241a(IPPSWebEventCallback iPPSWebEventCallback) {
        this.f34974i = iPPSWebEventCallback;
    }

    /* renamed from: a */
    private void m46227a(final Object obj) {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.nv.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7791ck.m48060a(obj, C7527nv.this.f34972g.m44287e());
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7542oj
    @SuppressLint({"JavascriptInterface"})
    /* renamed from: a */
    public void mo46242a(Object obj, String str, WebView webView) {
        if (webView != null) {
            AbstractC7185ho.m43817a(f34969d, "inject js");
            webView.addJavascriptInterface(obj, str);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7542oj
    /* renamed from: a */
    public void mo46243a(String str, WebView webView) {
        if (!AbstractC7806cz.m48165b(str)) {
            if (!str.startsWith("https://") && !str.startsWith("http://")) {
                str = "https://" + str;
            }
            str = m46246b(str);
        }
        if (webView != null) {
            if (m46230a(str, webView.getContext())) {
                webView.loadUrl("about:blank");
            } else {
                webView.loadUrl(str);
            }
            AbstractC7817dj.m48364a(new a(webView), 1000L);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7542oj
    /* renamed from: a */
    public void mo46244a(String str, String str2, String str3) {
        this.f34975j.m39106a(str, str2, str3, this.f34972g);
    }

    /* renamed from: a */
    private boolean m46228a(Intent intent, Set<String> set, String str) {
        boolean z10;
        Iterator<String> it = set.iterator();
        while (true) {
            z10 = false;
            if (!it.hasNext()) {
                break;
            }
            String[] strArrSplit = it.next().split(":");
            if (strArrSplit.length == 2 && (strArrSplit[0].equalsIgnoreCase(str) || strArrSplit[0].equalsIgnoreCase("*"))) {
                z10 = true;
                intent.setPackage(strArrSplit[1]);
                if (Constants.SCHEME_MARKET.equalsIgnoreCase(str)) {
                    this.f34977l = Boolean.TRUE;
                }
                if (m46224a(intent) != null) {
                    break;
                }
            }
        }
        return z10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7542oj
    /* renamed from: a */
    public boolean mo46245a(WebView webView, Uri uri) throws URISyntaxException {
        Intent intentM46222a = m46222a(uri);
        if (intentM46222a == null) {
            if (!C7124fh.m43316b(this.f34971f).mo43467j(AbstractC7806cz.m48182k(uri.toString()))) {
                return false;
            }
            mo46250c();
            return true;
        }
        try {
            Intent intentM46232b = m46232b(intentM46222a);
            if (intentM46232b != null) {
                try {
                    m46253h();
                    intentM46222a = intentM46232b;
                } catch (RuntimeException | Exception unused) {
                    intentM46222a = intentM46232b;
                    AbstractC7185ho.m43823c(f34969d, "shouldOverrideUrlLoading error");
                    this.f34971f.startActivity(intentM46222a);
                    return false;
                }
            }
            C7830i.a aVarM46224a = m46224a(intentM46222a);
            if (aVarM46224a == null) {
                AbstractC7185ho.m43820b(f34969d, "shouldOverrideUrlLoading, queryIntentActivities failed");
                return true;
            }
            String strM48442a = aVarM46224a.m48442a();
            if (C6982bz.m41152b(this.f34971f) && !C7124fh.m43316b(this.f34971f).mo43464i(strM48442a)) {
                AbstractC7185ho.m43820b(f34969d, "shouldOverrideUrlLoading, whilelist check failed");
                return true;
            }
            Boolean boolMo43468k = C7124fh.m43316b(this.f34971f).mo43468k(strM48442a);
            intentM46222a.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            C7692tn.a aVar = new C7692tn.a();
            ContentRecord contentRecordMo46574a = this.f34189a;
            if (contentRecordMo46574a == null) {
                InterfaceC7615qq interfaceC7615qq = this.f34970e;
                contentRecordMo46574a = interfaceC7615qq == null ? null : interfaceC7615qq.mo46574a();
            }
            aVar.m47274a(contentRecordMo46574a).m47279c(strM48442a).m47272a(intentM46222a);
            if (boolMo43468k != null) {
                if (boolMo43468k.booleanValue()) {
                    C7830i.m48412a(this.f34971f, intentM46222a, aVar.m47277a());
                }
                return true;
            }
            if (C7124fh.m43316b(this.f34971f).mo43352aS()) {
                m46226a(webView, aVarM46224a, intentM46222a, aVar.m47277a());
            } else {
                C7830i.m48412a(this.f34971f, intentM46222a, aVar.m47277a());
            }
            return true;
        } catch (RuntimeException | Exception unused2) {
        }
    }

    /* renamed from: a */
    private boolean m46230a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!C7124fh.m43316b(context).mo43467j(AbstractC7806cz.m48182k(str))) {
            return false;
        }
        AbstractC7185ho.m43820b(f34969d, "url is blocked");
        mo46250c();
        return true;
    }
}
