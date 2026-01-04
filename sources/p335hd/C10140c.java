package p335hd;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hicloud.bean.BasicBaseResp;
import com.huawei.hicloud.request.basic.bean.GetUserPublicInfoResp;
import fk.C9721b;
import gp.C10028c;
import io.C10582a;
import java.util.HashMap;
import java.util.Map;
import p015ak.C0209d;
import p015ak.C0213f;
import p429kk.C11058a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p681uj.C13192i;
import p709vj.C13452e;
import p846zj.C14306d;
import tm.C13040c;
import tm.C13041d;

/* renamed from: hd.c */
/* loaded from: classes3.dex */
public class C10140c extends AbstractC12367d {

    /* renamed from: a */
    public String f49431a;

    /* renamed from: b */
    public Handler f49432b;

    /* renamed from: c */
    public boolean f49433c;

    /* renamed from: d */
    public Map<String, String> f49434d;

    public C10140c(Handler handler) {
        this.f49434d = new HashMap();
        this.f49431a = C11058a.m66627b("07012");
        this.f49432b = handler;
        this.f49433c = false;
    }

    /* renamed from: c */
    public final void m63188c(GetUserPublicInfoResp getUserPublicInfoResp) {
        if (getUserPublicInfoResp == null) {
            C11839m.m70687e("CheckGRSUrlsTask", "resp is null");
        }
        int result = getUserPublicInfoResp.getResult();
        if (result == 0) {
            m63189d(getUserPublicInfoResp);
            return;
        }
        switch (result) {
            case 705:
            case BasicBaseResp.COUNTRY_NO_SITE_MATCH /* 706 */:
            case BasicBaseResp.COUNTRY_OFF_LINE /* 707 */:
                m63196l();
                break;
            default:
                m63192g();
                break;
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        Context contextM1377a;
        try {
            try {
                C11839m.m70688i("CheckGRSUrlsTask", "start execute");
                if (this.f49433c) {
                    C13041d.m78675e().m78684j(false);
                }
                C14306d.m85214o();
                contextM1377a = C0213f.m1377a();
            } catch (C9721b e10) {
                C11839m.m70687e("CheckGRSUrlsTask", "getUserPublicInfo exception: " + e10.toString());
                m63192g();
                if (this.f49433c) {
                }
            }
            if (contextM1377a != null && !C0209d.m1333z1(contextM1377a)) {
                m63195k();
                if (this.f49433c) {
                    C13041d.m78675e().m78684j(true);
                }
                C11839m.m70688i("CheckGRSUrlsTask", "end execute");
                return;
            }
            if (C13192i.m79258g().m79259d() == 2) {
                C11839m.m70688i("CheckGRSUrlsTask", "hms service unavailable");
                m63194j();
                if (this.f49433c) {
                    C13041d.m78675e().m78684j(true);
                }
                C11839m.m70688i("CheckGRSUrlsTask", "end execute");
                return;
            }
            this.f49434d = C13040c.m78609F().m78631W();
            if (C13041d.m78675e().m78677b(this.f49434d)) {
                C11839m.m70688i("CheckGRSUrlsTask", "do not check");
                m63193h();
                if (this.f49433c) {
                    C13041d.m78675e().m78684j(true);
                }
                C11839m.m70688i("CheckGRSUrlsTask", "end execute");
                return;
            }
            String str = this.f49434d.get("basic-encrypt");
            if (TextUtils.isEmpty(str)) {
                str = this.f49434d.get(CloudBackupConstant.RestoreDataDictionaryType.BASIC);
                if (TextUtils.isEmpty(str)) {
                    C11839m.m70687e("CheckGRSUrlsTask", "parseResponse error");
                    m63192g();
                    if (this.f49433c) {
                        C13041d.m78675e().m78684j(true);
                    }
                    C11839m.m70688i("CheckGRSUrlsTask", "end execute");
                    return;
                }
            }
            m63188c(new C10582a(this.f49431a).m64940j(str));
            if (this.f49433c) {
                C13041d.m78675e().m78684j(true);
            }
            C11839m.m70688i("CheckGRSUrlsTask", "end execute");
        } catch (Throwable th2) {
            if (this.f49433c) {
                C13041d.m78675e().m78684j(true);
            }
            C11839m.m70688i("CheckGRSUrlsTask", "end execute");
            throw th2;
        }
    }

    /* renamed from: d */
    public final void m63189d(GetUserPublicInfoResp getUserPublicInfoResp) {
        C11839m.m70688i("CheckGRSUrlsTask", "processSuccess");
        m63191f(getUserPublicInfoResp);
        if (m63190e()) {
            C10028c.m62182c0().m62377p3("urls_sp_version", true);
            m63193h();
        } else {
            C11839m.m70687e("CheckGRSUrlsTask", "save grs urls fail");
            m63192g();
        }
    }

    /* renamed from: e */
    public final boolean m63190e() {
        Map<String, String> map = this.f49434d;
        if (map != null && map.size() > 0) {
            return C13041d.m78675e().m78683i(this.f49434d);
        }
        C11839m.m70687e("CheckGRSUrlsTask", "urlsMap is null");
        return false;
    }

    /* renamed from: f */
    public final void m63191f(GetUserPublicInfoResp getUserPublicInfoResp) {
        HashMap<String, String> resultMap = getUserPublicInfoResp.getResultMap();
        if (resultMap != null) {
            String str = resultMap.get("siteInfo");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            C13452e.m80781L().m80844P2(str);
        }
    }

    /* renamed from: g */
    public final void m63192g() {
        C13040c.m78609F().m78651i();
        C13040c.m78609F().m78652i0(C0213f.m1377a(), C13452e.m80781L().m80942m(), true);
        if (this.f49432b != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 9;
            this.f49432b.sendMessage(messageObtain);
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.GET_USER_PUBLIC_INFO;
    }

    /* renamed from: h */
    public final void m63193h() {
        if (this.f49432b != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 8;
            this.f49432b.sendMessage(messageObtain);
        }
    }

    /* renamed from: j */
    public final void m63194j() {
        if (this.f49432b != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 11;
            this.f49432b.sendMessage(messageObtain);
        }
    }

    /* renamed from: k */
    public final void m63195k() {
        if (this.f49432b != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 12;
            this.f49432b.sendMessage(messageObtain);
        }
    }

    /* renamed from: l */
    public final void m63196l() {
        if (this.f49432b != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 10;
            this.f49432b.sendMessage(messageObtain);
        }
    }

    public C10140c(Handler handler, boolean z10) {
        this.f49434d = new HashMap();
        this.f49431a = C11058a.m66627b("07012");
        this.f49432b = handler;
        this.f49433c = z10;
    }
}
