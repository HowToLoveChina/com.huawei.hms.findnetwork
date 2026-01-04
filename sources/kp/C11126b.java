package kp;

import android.database.SQLException;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;
import com.huawei.hicloud.notification.p106db.languageoperator.TextLinkLanguageOperator;
import com.huawei.hicloud.notification.task.BaseDownLoadFileTask;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.service.C5011f0;
import fk.C9721b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import jp.C10905a;
import jp.C10906b;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0227m;
import p015ak.C0234s;
import p292fn.C9734g;
import p616rk.C12515a;
import p783xp.C13843a;

/* renamed from: kp.b */
/* loaded from: classes7.dex */
public class C11126b {

    /* renamed from: a */
    public C5011f0 f52395a;

    /* renamed from: b */
    public String f52396b;

    /* renamed from: c */
    public HashMap<String, Drawable> f52397c;

    /* renamed from: kp.b$b */
    public static class b {

        /* renamed from: a */
        public static C11126b f52398a = new C11126b();
    }

    /* renamed from: m */
    public static C11126b m66896m() {
        return b.f52398a;
    }

    /* renamed from: u */
    public static /* synthetic */ int m66897u(C10906b c10906b, C10906b c10906b2) {
        return c10906b.m65937i() - c10906b2.m65937i();
    }

    /* renamed from: b */
    public void m66898b() throws IOException {
        NotifyLogger.m29915i("TextLinkConfigManager", "cachePictures");
        ArrayList<CommonPicture> arrayListM66906j = m66906j();
        if (arrayListM66906j.isEmpty()) {
            NotifyLogger.m29915i("TextLinkConfigManager", "pictures is empty");
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<CommonPicture> it = arrayListM66906j.iterator();
        while (it.hasNext()) {
            CommonPicture next = it.next();
            if (m66899c(next) && !hashSet.contains(next.getUrl())) {
                String url = next.getUrl();
                C12515a.m75110o().m75175e(new BaseDownLoadFileTask(url, m66911p(url), next.getHash(), null), false);
                hashSet.add(url);
            }
        }
    }

    /* renamed from: c */
    public final boolean m66899c(CommonPicture commonPicture) throws Throwable {
        String strM1591d;
        if (commonPicture == null) {
            return false;
        }
        String url = commonPicture.getUrl();
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        String hash = commonPicture.getHash();
        if (TextUtils.isEmpty(hash)) {
            return false;
        }
        try {
            strM1591d = C0227m.m1591d(m66911p(url));
        } catch (C9721b e10) {
            NotifyLogger.m29916w("TextLinkConfigManager", "getFileSha256 exception: " + e10.toString());
            strM1591d = null;
        }
        return TextUtils.isEmpty(strM1591d) || !hash.equals(strM1591d);
    }

    /* renamed from: d */
    public void m66900d() throws SQLException {
        NotifyLogger.m29915i("TextLinkConfigManager", "clear all files");
        m66902f();
        m66903g();
        m66904h();
    }

    /* renamed from: e */
    public final void m66901e() {
        new C11127c().clearLangVersionAndResult();
    }

    /* renamed from: f */
    public final void m66902f() throws SQLException {
        C11127c c11127c = new C11127c();
        c11127c.clearLanguageDb();
        c11127c.clearLangVersionAndResult();
        c11127c.clearCurrentLanguageDownloadResult();
        c11127c.deleteLanguageFile();
    }

    /* renamed from: g */
    public final void m66903g() {
        NotifyLogger.m29915i("TextLinkConfigManager", "delete cached pictures");
        C13843a.m83085g(m66910o());
    }

    /* renamed from: h */
    public final void m66904h() {
        File file = new File(this.f52395a.getConfigFilePath());
        if (!file.exists() || file.delete()) {
            return;
        }
        NotifyLogger.m29914e("TextLinkConfigManager", "delete config file failed");
    }

    /* renamed from: i */
    public final void m66905i() throws IOException {
        NotifyLogger.m29915i("TextLinkConfigManager", "start extractLanguage");
        C10905a c10905aM66908l = m66908l();
        if (c10905aM66908l != null) {
            new C11127c().extractCommonLanguage(c10905aM66908l.m65927b());
        }
    }

    /* renamed from: j */
    public final ArrayList<CommonPicture> m66906j() throws IOException {
        ArrayList<CommonPicture> arrayList = new ArrayList<>();
        C10905a c10905aM66908l = m66908l();
        if (c10905aM66908l != null && c10905aM66908l.m65926a() != null && c10905aM66908l.m65928c() != null) {
            for (C10906b c10906b : c10905aM66908l.m65926a()) {
                if (c10906b != null && c10906b.m65936h() != null) {
                    String strM65936h = c10906b.m65936h();
                    if (!TextUtils.isEmpty(strM65936h) && c10905aM66908l.m65928c().get(strM65936h) != null) {
                        arrayList.add(c10905aM66908l.m65928c().get(strM65936h));
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: k */
    public void m66907k() throws IOException {
        NotifyLogger.m29915i("TextLinkConfigManager", "requestConfig");
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                NotifyLogger.m29914e("TextLinkConfigManager", "request notice config exception: " + e10.toString());
                if (NotifyUtil.procFlowControlException(e10, this.f52396b)) {
                    return;
                }
                if (e10.m60659c() == 304) {
                    NotifyLogger.m29914e("TextLinkConfigManager", "HTTP_NOT_MODIFY extract sync module config");
                    m66905i();
                    m66898b();
                    return;
                } else {
                    if (!this.f52395a.isExceptionNeedRetry(e10) || i10 >= 2) {
                        return;
                    }
                    NotifyLogger.m29915i("TextLinkConfigManager", "getLatestConfig exception retry, retry num = " + i10);
                }
            }
            if (this.f52395a.getLatestConfig()) {
                NotifyLogger.m29915i("TextLinkConfigManager", "request config success");
                C9734g.m60767a().m60769c(this.f52396b);
                m66901e();
                m66905i();
                m66898b();
                return;
            }
            NotifyLogger.m29914e("TextLinkConfigManager", "getConfig failed");
            if (i10 >= 2) {
                return;
            }
            NotifyLogger.m29915i("TextLinkConfigManager", "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    /* renamed from: l */
    public C10905a m66908l() throws IOException {
        File file = new File(this.f52395a.getConfigFilePath());
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                String strM1290o2 = C0209d.m1290o2(fileInputStream);
                c10905a = C4633d0.m28404a(strM1290o2) ? null : (C10905a) new Gson().fromJson(strM1290o2, C10905a.class);
                fileInputStream.close();
            } finally {
            }
        } catch (Exception e10) {
            NotifyLogger.m29914e("TextLinkConfigManager", "config file not exitst, msg = " + e10.getMessage());
        }
        return c10905a;
    }

    /* renamed from: n */
    public final List<CommonLanguageDbString> m66909n(String str, String str2, String str3) {
        return new TextLinkLanguageOperator().queryString(str, str2, HNConstants.Language.EN_STANDARD, str3);
    }

    /* renamed from: o */
    public String m66910o() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C0213f.m1378b().getFilesDir());
        String str = File.separator;
        sb2.append(str);
        sb2.append("textLink");
        sb2.append(str);
        return sb2.toString();
    }

    /* renamed from: p */
    public String m66911p(String str) {
        return m66910o() + C0227m.m1593f(str);
    }

    /* renamed from: q */
    public final String m66912q(String str) {
        return NotifyUtil.getStringFromConfig(str, true, true, m66909n(C0234s.m1631i(), HNUtil.getCurrentBaseLanguage(), str));
    }

    /* renamed from: r */
    public C10906b[] m66913r() throws IOException {
        C10905a c10905aM66908l = m66908l();
        if (c10905aM66908l == null || c10905aM66908l.m65926a() == null || c10905aM66908l.m65926a().length <= 0) {
            return null;
        }
        C10906b[] c10906bArrM65926a = c10905aM66908l.m65926a();
        Arrays.sort(c10906bArrM65926a, new Comparator() { // from class: kp.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C11126b.m66897u((C10906b) obj, (C10906b) obj2);
            }
        });
        return c10906bArrM65926a;
    }

    /* renamed from: s */
    public Drawable m66914s(C10906b c10906b) throws IOException {
        if (c10906b != null && !TextUtils.isEmpty(c10906b.m65936h())) {
            String strM66911p = m66911p(c10906b.m65936h());
            if (TextUtils.isEmpty(strM66911p)) {
                return null;
            }
            try {
                Drawable drawable = this.f52397c.get(strM66911p);
                if (drawable != null) {
                    return drawable;
                }
                File file = new File(strM66911p);
                if (!file.exists()) {
                    return null;
                }
                Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(file));
                this.f52397c.put(strM66911p, drawableDecodeDrawable);
                return drawableDecodeDrawable;
            } catch (Exception e10) {
                NotifyLogger.m29914e("TextLinkConfigManager", "getPictureWithCache exception" + e10.getMessage());
            }
        }
        return null;
    }

    /* renamed from: t */
    public String m66915t(C10906b c10906b) {
        if (c10906b == null || TextUtils.isEmpty(c10906b.m65938j())) {
            return null;
        }
        return m66912q(c10906b.m65938j());
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
    
        if (p459lp.C11327e.m68063f(r7.f52396b) >= r2) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i("TextLinkConfigManager", "version updated, query config");
        m66907k();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i("TextLinkConfigManager", "version not updated, extract sync module config");
        m66905i();
        m66898b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
    
        return false;
     */
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m66916v() throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "request text link config version"
            java.lang.String r1 = "TextLinkConfigManager"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            r0 = 0
            r2 = r0
        L9:
            r3 = 2
            if (r2 > r3) goto L4e
            com.huawei.hicloud.service.f0 r4 = r7.f52395a     // Catch: fk.C9721b -> L13
            long r2 = r4.getConfigVersion()     // Catch: fk.C9721b -> L13
            goto L50
        L13:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "request text link config version exception "
            r5.append(r6)
            java.lang.String r6 = r4.toString()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r1, r5)
            com.huawei.hicloud.service.f0 r5 = r7.f52395a
            boolean r4 = r5.isExceptionNeedRetry(r4)
            if (r4 == 0) goto L4d
            if (r2 >= r3) goto L4d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "requestConfigVersion exception retry, retry num = "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r3)
            int r2 = r2 + 1
            goto L9
        L4d:
            return r0
        L4e:
            r2 = 0
        L50:
            java.lang.String r4 = r7.f52396b
            long r4 = p459lp.C11327e.m68063f(r4)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L64
            java.lang.String r0 = "version updated, query config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            r7.m66907k()
            r7 = 1
            return r7
        L64:
            java.lang.String r2 = "version not updated, extract sync module config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r2)
            r7.m66905i()
            r7.m66898b()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kp.C11126b.m66916v():boolean");
    }

    public C11126b() {
        this.f52397c = new HashMap<>();
        this.f52395a = new C5011f0(null);
        this.f52396b = "HiCloudTextLink";
    }
}
