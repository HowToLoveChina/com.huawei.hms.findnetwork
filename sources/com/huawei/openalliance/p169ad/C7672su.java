package com.huawei.openalliance.p169ad;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.openalliance.p169ad.C7692tn;
import com.huawei.openalliance.p169ad.activity.SafeIntent;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.download.app.C7055l;
import com.huawei.openalliance.p169ad.inter.C7286a;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.C7830i;
import com.huawei.openalliance.p169ad.utils.C7831j;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;

/* renamed from: com.huawei.openalliance.ad.su */
/* loaded from: classes8.dex */
public class C7672su extends AbstractC7687ti {

    /* renamed from: c */
    private InterfaceC7615qq f35683c;

    public C7672su(Context context, ContentRecord contentRecord) {
        super(context, contentRecord);
        C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f()));
        this.f35683c = c7560ou;
        c7560ou.mo46590a(contentRecord);
    }

    /* renamed from: a */
    private void m47228a(Intent intent) {
        SafeIntent safeIntent = new SafeIntent(intent);
        String strM44218c = C7286a.m44210a().m44218c();
        AbstractC7185ho.m43820b("AppAction", "at is null ? " + TextUtils.isEmpty(strM44218c));
        if (TextUtils.isEmpty(strM44218c)) {
            return;
        }
        if (!m47230a(safeIntent.getDataString())) {
            AbstractC7185ho.m43820b("AppAction", "isHwPPSUri false.");
        } else if (C7830i.m48431c(this.f35700a)) {
            safeIntent.putExtra("accessToken", strM44218c);
        } else {
            AbstractC7185ho.m43820b("AppAction", "isHMSInstalled false.");
        }
    }

    /* renamed from: d */
    private void m47231d() {
        PromoteInfo promoteInfoM41485ag = this.f35701b.m41485ag();
        if (promoteInfoM41485ag == null || promoteInfoM41485ag.getType() != 1) {
            return;
        }
        AbstractC7185ho.m43817a("AppAction", "promoteInfo Type is FastApp");
        new C6922c(this.f35700a).m39118b(promoteInfoM41485ag.getName(), this.f35701b);
    }

    /* renamed from: e */
    private void m47232e() {
        String str;
        ApkInfo apkInfoM40339s;
        try {
            MetaData metaData = (MetaData) AbstractC7758be.m47739b(this.f35701b.m41563h(), MetaData.class, new Class[0]);
            this.f35683c.mo46588a(EventType.INTENTFAIL, (Integer) 1, Integer.valueOf((metaData == null || (apkInfoM40339s = metaData.m40339s()) == null || C7830i.m48427b(this.f35700a, apkInfoM40339s.m39626a()) == null) ? 1 : 2));
        } catch (IllegalStateException unused) {
            str = "recordOpenFailEvent IllegalStateException";
            AbstractC7185ho.m43823c("AppAction", str);
        } catch (Exception e10) {
            str = "recordOpenFailEvent " + e10.getClass().getSimpleName();
            AbstractC7185ho.m43823c("AppAction", str);
        }
    }

    /* renamed from: a */
    private void m47229a(Intent intent, String str) {
        if (intent == null || TextUtils.isEmpty(str) || str.indexOf("hwpps") <= 0) {
            return;
        }
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7687ti
    /* renamed from: a */
    public boolean mo47233a() {
        String str;
        AppInfo appInfoM41484af;
        String packageName;
        String strM41397H;
        C7692tn.a aVar;
        boolean z10;
        Intent intentM48426b;
        AbstractC7185ho.m43820b("AppAction", "handle app action");
        try {
            m47231d();
            appInfoM41484af = this.f35701b.m41484af();
            packageName = appInfoM41484af == null ? null : appInfoM41484af.getPackageName();
            strM41397H = this.f35701b.m41397H();
            aVar = new C7692tn.a();
            aVar.m47275a(appInfoM41484af).m47274a(this.f35701b);
            C7692tn c7692tnM47277a = aVar.m47277a();
            if (TextUtils.isEmpty(strM41397H) || !strM41397H.startsWith("hwpps")) {
                z10 = true;
            } else {
                strM41397H = strM41397H + "&PPSFromIntent=hwpps";
                z10 = false;
            }
            intentM48426b = C7830i.m48426b(this.f35700a, strM41397H, packageName, c7692tnM47277a);
        } catch (ActivityNotFoundException unused) {
            str = "activity not exist";
            AbstractC7185ho.m43823c("AppAction", str);
            m47232e();
            return m47249b();
        } catch (Exception unused2) {
            str = "handle intent url fail";
            AbstractC7185ho.m43823c("AppAction", str);
            m47232e();
            return m47249b();
        }
        if (intentM48426b == null) {
            AbstractC7185ho.m43823c("AppAction", "cannot find target activity");
            m47232e();
            return m47249b();
        }
        intentM48426b.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        m47229a(intentM48426b, strM41397H);
        m47228a(intentM48426b);
        if (appInfoM41484af != null) {
            aVar.m47275a(appInfoM41484af);
        }
        aVar.m47272a(intentM48426b);
        C7830i.m48412a(this.f35700a, intentM48426b, aVar.m47277a());
        m47248b(C7831j.m48455a(packageName, appInfoM41484af));
        C7055l.m42499a(this.f35700a, this.f35701b.m41484af());
        if (z10) {
            this.f35683c.mo46588a(EventType.INTENTSUCCESS, Integer.valueOf(C7831j.m48462b(packageName, appInfoM41484af)), (Integer) null);
        }
        return true;
    }

    /* renamed from: a */
    private boolean m47230a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (URLUtil.isNetworkUrl(str)) {
            AbstractC7185ho.m43820b("AppAction", "uri is http or https url.");
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            String host = uri.getHost();
            if (TextUtils.equals("hwpps", uri.getScheme())) {
                return TextUtils.equals(Constants.SCHEME_HOST, host);
            }
            return false;
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("AppAction", "isHwPPSUri exception." + th2.getClass().getSimpleName());
            return false;
        }
    }
}
