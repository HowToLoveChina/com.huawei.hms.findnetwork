package p472m7;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.router.R$string;
import fk.C9721b;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p514o9.C11827a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import tm.C13040c;

/* renamed from: m7.b */
/* loaded from: classes2.dex */
public class C11427b implements SpanClickText.ISpanClickListener {

    /* renamed from: a */
    public Context f53260a;

    /* renamed from: b */
    public String f53261b;

    /* renamed from: m7.b$a */
    public static class a extends AbstractC12367d {

        /* renamed from: a */
        public Context f53262a;

        /* renamed from: b */
        public String f53263b;

        public a(Context context, String str) {
            this.f53262a = context;
            this.f53263b = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            String strM78669v = "";
            try {
                strM78669v = C13040c.m78609F().m78669v();
                C11839m.m70688i("TermsClickListener", "GetConsumerUrlTask");
            } catch (C9721b e10) {
                C11839m.m70687e("TermsClickListener", "getTermsUrlHost error " + e10.toString());
            }
            C11427b.m68471d(strM78669v, this.f53262a, this.f53263b);
        }
    }

    public C11427b(Context context, String str) {
        this.f53260a = context;
        this.f53261b = str;
    }

    /* renamed from: b */
    public static String m68470b(String str, String str2) throws C9721b {
        if ("icp_filing".equals(str2)) {
            return C13040c.m78609F().m78610A();
        }
        return str + C11827a.m70483h(str2);
    }

    /* renamed from: d */
    public static void m68471d(String str, Context context, String str2) {
        C11839m.m70688i("TermsClickListener", "gotoTerms");
        if (context == null) {
            C11839m.m70687e("TermsClickListener", "context is null ");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("TermsClickListener", "host is empty, go to term failed");
            return;
        }
        try {
            String strM68470b = m68470b(str, str2);
            C11839m.m70686d("TermsClickListener", "webview requestUri:" + strM68470b);
            Intent intent = new Intent();
            intent.setAction(NotifyConstants.Action.HICLOUD_WEBVIEW_ACTION);
            C0209d.m1302r2(intent, "com.huawei.hidisk");
            intent.putExtra("srcChannel", "0");
            intent.putExtra("salChannel", "0");
            intent.putExtra("url", strM68470b);
            intent.putExtra("title", context.getString(R$string.HiCloud_app_name));
            intent.putExtra("isEnableJs", true);
            intent.putExtra("launch_web_type", -1);
            intent.putExtra("if_use_browser_when_url_not_in_white_list", true);
            intent.putExtra("is_support_orientation", true);
            intent.putExtra("is_support_dark_mode", true);
            if (intent.resolveActivity(context.getPackageManager()) == null || (!str2.equals("user_agreement_cn") && !str2.equals("privacy_statement_cn"))) {
                intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(strM68470b));
            }
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                C11839m.m70688i("TermsClickListener", "packageManager is null");
            } else if (intent.resolveActivity(packageManager) != null) {
                C11839m.m70688i("TermsClickListener", "gotoTerms---startActivity");
                context.startActivity(intent);
            } else {
                C11839m.m70688i("TermsClickListener", "resolveActivity is null");
            }
            LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            linkedHashMapM79499C.put("productType", str2);
            C13227f.m79492i1().m79591l0("mecloud_agrenment_click", linkedHashMapM79499C);
            UBAAnalyze.m29957R("PVC", "mecloud_agrenment_click", "1", "34", "productType", str2);
        } catch (Exception e10) {
            C11839m.m70687e("TermsClickListener", "gotoTerms exception " + e10.getMessage());
        }
    }

    /* renamed from: c */
    public void m68472c(Context context, String str) {
        C12515a.m75110o().m75172d(new a(context, str));
    }

    @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
    public void onClick() {
        if (this.f53260a == null) {
            C11839m.m70687e("TermsClickListener", "onClick mContext is null");
            return;
        }
        C11839m.m70688i("TermsClickListener", "termType" + this.f53261b);
        m68472c(this.f53260a, this.f53261b);
    }
}
