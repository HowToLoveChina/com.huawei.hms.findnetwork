package com.huawei.openalliance.p169ad;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.C7830i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.tt */
/* loaded from: classes8.dex */
public class C7698tt {

    /* renamed from: a */
    private static final Map<String, String> f35738a = new HashMap<String, String>() { // from class: com.huawei.openalliance.ad.tt.1
        {
            put("WX", "com.tencent.mm");
            put("QQ", "com.tencent.mobileqq");
            put("WB", "com.sina.weibo");
            put("weLink", Constants.WELINK_PKG_NAME);
        }
    };

    /* renamed from: b */
    private static final Map<String, Integer> f35739b = new HashMap<String, Integer>() { // from class: com.huawei.openalliance.ad.tt.2
        {
            put("WX", Integer.valueOf(C6849R.string.hiad_share_wx));
            put("QQ", Integer.valueOf(C6849R.string.hiad_share_qq));
        }
    };

    /* renamed from: c */
    private Dialog f35740c;

    /* renamed from: d */
    private View f35741d;

    /* renamed from: e */
    private final Activity f35742e;

    /* renamed from: f */
    private final C7706ua f35743f;

    /* renamed from: g */
    private List<String> f35744g = new ArrayList();

    /* renamed from: h */
    private Map<String, String> f35745h = new HashMap();

    /* renamed from: i */
    private C6922c f35746i;

    public C7698tt(Activity activity, C7706ua c7706ua) {
        this.f35742e = activity;
        this.f35743f = c7706ua;
        m47320d();
    }

    /* renamed from: d */
    private void m47320d() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("PPSShareDialog", "initDialog");
        }
        if (this.f35742e == null) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43817a("PPSShareDialog", "initDialog filed : context is null");
            }
        } else {
            m47322e();
            this.f35745h = C7124fh.m43316b(this.f35742e.getApplicationContext()).mo43066an();
            m47323f();
            this.f35746i = new C6922c(this.f35742e.getApplicationContext());
        }
    }

    /* renamed from: e */
    private void m47322e() {
        this.f35740c = new Dialog(this.f35742e, C6849R.style.HIAD_share_dialog);
        View viewInflate = LayoutInflater.from(this.f35742e).inflate(C6849R.layout.bottom_share_layout, (ViewGroup) null);
        this.f35741d = viewInflate;
        this.f35740c.setContentView(viewInflate);
        this.f35740c.setCanceledOnTouchOutside(true);
        this.f35740c.setCancelable(true);
        Window window = this.f35740c.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            window.setDimAmount(0.0f);
            attributes.gravity = 80;
            attributes.width = this.f35742e.getResources().getDisplayMetrics().widthPixels;
        }
    }

    /* renamed from: f */
    private void m47323f() {
        m47310a(C6849R.id.share_wx, "WX", 1);
        m47310a(C6849R.id.share_wx_moments, "WX", 2);
        m47310a(C6849R.id.share_qq, "QQ", 1);
        m47310a(C6849R.id.share_qq_qzone, "QQ", 2);
        m47310a(C6849R.id.share_weibo, "WB", -1);
        m47310a(C6849R.id.share_weLink, "weLink", -1);
        m47310a(C6849R.id.share_more, "more", -1);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("PPSShareDialog", "initShareButton end");
        }
    }

    /* renamed from: d */
    private boolean m47321d(String str) {
        if (C7830i.m48419a(this.f35742e, f35738a.get(str))) {
            return true;
        }
        if (!AbstractC7185ho.m43819a()) {
            return false;
        }
        AbstractC7185ho.m43818a("PPSShareDialog", "checkForInstall : %s filed", str);
        return false;
    }

    /* renamed from: a */
    public void m47324a() {
        Dialog dialog;
        if (this.f35742e == null || this.f35743f == null || (dialog = this.f35740c) == null) {
            AbstractC7185ho.m43817a("PPSShareDialog", "context,nativeAd or dialog is empty");
        } else {
            dialog.show();
        }
    }

    /* renamed from: b */
    public void m47326b() {
        Dialog dialog = this.f35740c;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f35740c.dismiss();
    }

    /* renamed from: a */
    private void m47310a(int i10, final String str, final int i11) {
        View viewFindViewById = this.f35741d.findViewById(i10);
        if ("QQ".equals(str) || "WX".equals(str)) {
            if (m47314a(str, viewFindViewById)) {
                return;
            }
        } else if ("WB".equals(str)) {
            if (!m47316b(str) || !m47321d(str)) {
                viewFindViewById.setVisibility(8);
                return;
            }
        } else if ("weLink".equals(str) && (!m47319c(str) || !m47321d(str))) {
            viewFindViewById.setVisibility(8);
            return;
        }
        m47312a(str);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.tt.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C7698tt.this.m47313a(str, i11);
                C7698tt.this.f35746i.m39099a(str, C7698tt.this.f35743f.m47349f());
                AbstractC7185ho.m43818a("PPSShareDialog", "click %s share", str);
            }
        });
    }

    /* renamed from: b */
    private boolean m47316b(String str) {
        if (this.f35745h.get(str) != null) {
            return m47319c(str);
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("PPSShareDialog", "checkForAppId : %s filed", str);
        }
        return false;
    }

    /* renamed from: c */
    private boolean m47319c(String str) {
        if (C7707ub.m47351a(str)) {
            return true;
        }
        if (!AbstractC7185ho.m43819a()) {
            return false;
        }
        AbstractC7185ho.m43818a("PPSShareDialog", "checkForDependencies : %s filed", str);
        return false;
    }

    /* renamed from: a */
    public void m47325a(DialogInterface.OnDismissListener onDismissListener) {
        Dialog dialog = this.f35740c;
        if (dialog != null) {
            dialog.setOnDismissListener(onDismissListener);
        }
    }

    /* renamed from: a */
    private void m47312a(String str) {
        String str2 = f35738a.get(str);
        if (this.f35744g.contains(str2)) {
            return;
        }
        this.f35744g.add(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m47313a(java.lang.String r4, int r5) {
        /*
            r3 = this;
            com.huawei.openalliance.ad.uc r0 = new com.huawei.openalliance.ad.uc
            r0.<init>()
            java.util.Map<java.lang.String, java.lang.String> r1 = r3.f35745h
            java.lang.Object r1 = r1.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            r0.m47355a(r1)
            r1 = 1
            if (r1 != r5) goto L19
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
        L15:
            r0.m47354a(r5)
            goto L1f
        L19:
            r1 = 2
            if (r1 != r5) goto L1f
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            goto L15
        L1f:
            java.lang.String r5 = "more"
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L2c
            java.util.List<java.lang.String> r5 = r3.f35744g
            r0.m47356a(r5)
        L2c:
            r3.m47326b()
            com.huawei.openalliance.ad.ua r5 = r3.f35743f
            java.lang.String r5 = r5.m47341a()
            if (r5 == 0) goto L3f
            java.lang.String r1 = "http"
            boolean r5 = r5.startsWith(r1)
            if (r5 != 0) goto L4e
        L3f:
            com.huawei.openalliance.ad.ua r5 = r3.f35743f
            java.util.Map<java.lang.String, java.lang.String> r1 = r3.f35745h
            java.lang.String r2 = "defImg"
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            r5.m47344a(r1)
        L4e:
            android.app.Activity r5 = r3.f35742e
            com.huawei.openalliance.ad.ua r3 = r3.f35743f
            com.huawei.openalliance.p169ad.C7707ub.m47350a(r4, r5, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7698tt.m47313a(java.lang.String, int):void");
    }

    /* renamed from: a */
    private boolean m47314a(final String str, View view) {
        if (!m47316b(str)) {
            view.setVisibility(8);
            return true;
        }
        if (m47321d(str)) {
            return false;
        }
        m47312a(str);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.tt.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Toast.makeText(C7698tt.this.f35742e, C7698tt.this.f35742e.getResources().getString(C6849R.string.hiad_share_app_not_install, C7698tt.this.f35742e.getResources().getString(((Integer) C7698tt.f35739b.get(str)).intValue())), 0).show();
                AbstractC7185ho.m43818a("PPSShareDialog", "click %s share : app not support", str);
            }
        });
        return true;
    }
}
