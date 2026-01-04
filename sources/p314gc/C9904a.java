package p314gc;

import android.content.Context;
import android.view.View;
import com.huawei.android.hicloud.safeinfo.bean.LinkContents;
import com.huawei.android.hicloud.safeinfo.bean.SafeConfigBean;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.io.File;
import java.util.List;
import p015ak.C0213f;
import p015ak.C0234s;
import p334hc.C10137a;
import p459lp.C11327e;
import p514o9.C11839m;
import p616rk.C12515a;
import p684un.C13223b;
import p709vj.C13452e;

/* renamed from: gc.a */
/* loaded from: classes3.dex */
public class C9904a {

    /* renamed from: a */
    public static C9904a f48598a;

    /* renamed from: b */
    public static final Object f48599b = new Object();

    /* renamed from: b */
    public static C9904a m61488b() {
        C9904a c9904a;
        synchronized (f48599b) {
            try {
                if (f48598a == null) {
                    f48598a = new C9904a();
                }
                c9904a = f48598a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c9904a;
    }

    /* renamed from: a */
    public void m61489a(Context context) {
        if (context == null) {
            C11839m.m70687e("SafeInfoManager", "clearConfig context null");
            return;
        }
        File file = new File(context.getFilesDir() + "/HiCloudFooterLink.json");
        if (!file.exists()) {
            C11839m.m70687e("SafeInfoManager", "banner file not exist");
        } else if (file.delete()) {
            C11839m.m70688i("SafeInfoManager", "banner file del success");
        }
        C11327e.m68059b("HiCloudFooterLink");
    }

    /* renamed from: c */
    public LinkContents m61490c(SafeConfigBean safeConfigBean) {
        List<LinkContents> linkContents;
        String strM1628f = C0234s.m1628f();
        C11839m.m70686d("SafeInfoManager", "language is " + strM1628f);
        if (safeConfigBean == null || (linkContents = safeConfigBean.getLinkContents()) == null) {
            return null;
        }
        for (LinkContents linkContents2 : linkContents) {
            String language = linkContents2.getLanguage();
            if (language != null && language.equals(strM1628f)) {
                return linkContents2;
            }
        }
        return null;
    }

    /* renamed from: d */
    public String m61491d(LinkContents linkContents) {
        return linkContents == null ? "" : linkContents.getLinkText();
    }

    /* renamed from: e */
    public void m61492e(View view) {
        if (view == null) {
            return;
        }
        String strM80942m = C13452e.m80781L().m80942m();
        boolean zM61493f = m61493f();
        boolean zEquals = "CN".equals(strM80942m);
        C11839m.m70688i("SafeInfoManager", "hideSafeInfoRegion, is config invalid = " + zM61493f + " , is china user = " + zEquals);
        if (zM61493f || !zEquals) {
            view.setVisibility(8);
        }
    }

    /* renamed from: f */
    public boolean m61493f() {
        if (new File(C0213f.m1377a().getFilesDir() + "/HiCloudFooterLink.json").exists()) {
            C11839m.m70686d("SafeInfoManager", "config file is exists");
            return false;
        }
        C11327e.m68059b("HiCloudFooterLink");
        return true;
    }

    /* renamed from: g */
    public void m61494g(String str) {
        C12515a.m75110o().m75172d(new C10137a(str));
    }

    /* renamed from: h */
    public void m61495h(Context context) {
        String str = "clickBottomLink:hiCloudFootLink,clickUser:" + C13452e.m80781L().m80971t0();
        C13223b.m79473a(context, "hiCloudFootLink", str);
        UBAAnalyze.m29949J("CKC", "hiCloudFootLink", "value", str);
    }
}
