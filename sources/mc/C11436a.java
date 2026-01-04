package mc;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.android.hicloud.p088ui.activity.SiteChangeTipActivity;
import com.huawei.android.hicloud.p088ui.activity.SiteOfflineTipActivity;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import fk.C9721b;
import gp.C10028c;
import java.util.HashMap;
import p015ak.C0234s;
import p335hd.C10140c;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p616rk.C12515a;
import p664u0.C13108a;
import p709vj.C13452e;
import p746wn.C13622a;
import tm.C13040c;

/* renamed from: mc.a */
/* loaded from: classes3.dex */
public class C11436a {

    /* renamed from: a */
    public static final C11436a f53278a = new C11436a();

    /* renamed from: b */
    public static BroadcastReceiver f53279b = new a();

    /* renamed from: mc.a$a */
    public class a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            if (context == null) {
                C11839m.m70687e("SiteChangeUtil", "context is null");
                return;
            }
            C11839m.m70688i("SiteChangeUtil", "process SiteChangeUtil broadcast");
            if ("com.huawei.hicloud.REFRESH_URLS_SP_ACTION".equals(hiCloudSafeIntent.getAction())) {
                boolean zM80842P0 = C13452e.m80781L().m80842P0();
                boolean zM62221H1 = C10028c.m62182c0().m62221H1();
                if (!zM80842P0 || !zM62221H1) {
                    C11839m.m70687e("SiteChangeUtil", "hicloud not login or term not agree, do not process check broadcast");
                    return;
                }
                C12515a.m75110o().m75172d(new C10140c(null));
                C11436a.m68493i(hiCloudSafeIntent.getStringExtra("source"), context);
            }
        }
    }

    /* renamed from: d */
    public static C11436a m68492d() {
        return f53278a;
    }

    /* renamed from: i */
    public static void m68493i(String str, Context context) {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07014"), "07014", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        HashMap map = new HashMap();
        map.put("source", str);
        C13622a.m81969o(context, c11060cM66626a, map);
    }

    /* renamed from: b */
    public final String m68494b(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            C11839m.m70687e("SiteChangeUtil", "know more link build failed, ");
            return null;
        }
        return str + str2 + "lang=" + str3 + "&country=" + str4;
    }

    /* renamed from: c */
    public final String m68495c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str.hashCode();
        if (str.equals("siteChange")) {
            return "/staticPage/siteChange?";
        }
        if (str.equals("siteOffline")) {
            return "/staticPage/siteOffline?";
        }
        C11839m.m70687e("SiteChangeUtil", "site status not match");
        return "";
    }

    /* renamed from: e */
    public void m68496e(String str, Context context) {
        if (context == null) {
            C11839m.m70687e("SiteChangeUtil", "gotoKnowMore context is null");
            return;
        }
        try {
            String strM68494b = m68494b(C13040c.m78609F().m78625Q(), m68495c(str), C0234s.m1627e(), C13452e.m80781L().m80942m());
            if (TextUtils.isEmpty(strM68494b)) {
                C11839m.m70687e("SiteChangeUtil", "request uri is null");
            } else {
                m68498g(context, strM68494b);
            }
        } catch (C9721b e10) {
            C11839m.m70687e("SiteChangeUtil", "getKnowMoreUrl exception, e = " + e10.toString());
        }
    }

    /* renamed from: f */
    public void m68497f(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hicloud.REFRESH_URLS_SP_ACTION");
        C13108a.m78878b(context).m78880c(f53279b, intentFilter);
    }

    /* renamed from: g */
    public final void m68498g(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || intent.resolveActivity(packageManager) == null) {
                return;
            }
            context.startActivity(intent);
        } catch (Exception e10) {
            C11839m.m70687e("SiteChangeUtil", "jump to link error, e = " + e10.toString());
        }
    }

    /* renamed from: h */
    public void m68499h(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            C11839m.m70687e("SiteChangeUtil", "jumpToSiteTipsActivity, activity is null or finishing");
            return;
        }
        if (C13452e.m80781L().m80955p0().equals("siteChanged")) {
            Intent intent = new Intent();
            intent.setClass(activity, SiteChangeTipActivity.class);
            activity.startActivity(intent);
        } else if (C13452e.m80781L().m80955p0().equals("siteOffline")) {
            Intent intent2 = new Intent();
            intent2.setClass(activity, SiteOfflineTipActivity.class);
            activity.startActivity(intent2);
        }
    }

    /* renamed from: j */
    public void m68500j(Context context) {
        if (f53279b != null) {
            C13108a.m78878b(context).m78883f(f53279b);
        }
    }
}
