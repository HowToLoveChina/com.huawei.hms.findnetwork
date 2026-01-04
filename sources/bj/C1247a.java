package bj;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.gson.Gson;
import com.huawei.cloud.pay.config.bean.BannerAfterPayItem;
import com.huawei.cloud.pay.config.bean.BannerAfterPayPicturesItem;
import com.huawei.cloud.pay.config.bean.HiCloudPayBanners;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.service.C5000a;
import fk.C9721b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import no.C11740c;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0227m;
import p052cb.C1414k;
import p054cj.C1442a;
import p292fn.C9734g;
import p454lj.C11278a;
import p514o9.C11829c;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p783xp.C13843a;

/* renamed from: bj.a */
/* loaded from: classes5.dex */
public class C1247a extends AbstractRunnableC12516b {

    /* renamed from: a */
    public Random f5664a = new Random();

    /* renamed from: b */
    public C5000a f5665b;

    /* renamed from: c */
    public int f5666c;

    public C1247a(int i10) {
        this.f5666c = i10;
    }

    /* renamed from: c */
    public final void m7464c() throws IOException {
        C1442a.m8290i("BannerAfterPayTask", "downloadConfig start.");
        if (this.f5665b == null) {
            this.f5665b = new C5000a(null);
        }
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                C1442a.m8289e("BannerAfterPayTask", "downloadConfig exception: " + e10.toString());
                if (NotifyUtil.procFlowControlException(e10, "HiCloudPayBanners") || !this.f5665b.isExceptionNeedRetry(e10) || i10 >= 2) {
                    return;
                }
                C1442a.m8290i("BannerAfterPayTask", "getLatestConfig exception retry, retry num: " + i10);
            }
            if (this.f5665b.getLatestConfig()) {
                C9734g.m60767a().m60769c("HiCloudPayBanners");
                Context contextM1377a = C0213f.m1377a();
                if (contextM1377a == null) {
                    C1442a.m8289e("BannerAfterPayTask", "downloadConfig context is null.");
                    return;
                }
                contextM1377a.getSharedPreferences("pay_after_banner_pic_info", 0).edit().clear().apply();
                C13843a.m83085g(contextM1377a.getFilesDir() + "/pay_after_banner_pic");
                m7467f(contextM1377a);
                return;
            }
            C1442a.m8289e("BannerAfterPayTask", "download banner config failed");
            if (i10 >= 2) {
                return;
            }
            C1442a.m8290i("BannerAfterPayTask", "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws IOException {
        int i10 = this.f5666c;
        if (i10 == 1) {
            m7468g();
        } else if (i10 == 2) {
            m7464c();
        }
    }

    /* renamed from: d */
    public final void m7465d(String str, String str2, String str3) throws C1414k {
        C1442a.m8290i("BannerAfterPayTask", "downloadPic");
        try {
            C11829c.m70598n(str, str2, new C11740c(str));
            File file = new File(str);
            if (!file.exists()) {
                throw new C1414k("download picture to local failed. picUrl = " + str2 + " destPath = " + str);
            }
            if (TextUtils.isEmpty(str3) || str3.equals(C0227m.m1591d(str))) {
                C0212e0.m1372v(C0213f.m1377a(), "pay_after_banner_pic_info", str2, str);
                C1442a.m8290i("BannerAfterPayTask", "downloadPic successs");
                return;
            }
            if (!file.delete()) {
                C1442a.m8289e("BannerAfterPayTask", "hash not equal, delete file failed, " + str2 + " destPath = " + str);
            }
            throw new C1414k("hash not equal. picUrl = " + str2 + " destPath = " + str);
        } catch (Exception e10) {
            C1442a.m8289e("BannerAfterPayTask", e10.toString());
        }
    }

    /* renamed from: e */
    public final boolean m7466e(String str) {
        Context contextM1377a = C0213f.m1377a();
        String strM1363m = C0212e0.m1363m(contextM1377a, "pay_after_banner_pic_info", str, null);
        if (TextUtils.isEmpty(strM1363m)) {
            C1442a.m8290i("BannerAfterPayTask", " SP pic record not exist, url = " + str);
            return false;
        }
        if (new File(strM1363m).exists()) {
            return true;
        }
        C1442a.m8289e("BannerAfterPayTask", "local pic file do not exist, SP record exist, url = " + str + " file path = " + strM1363m);
        C0212e0.m1374x(contextM1377a, "pay_after_banner_pic_info", str);
        return false;
    }

    /* renamed from: f */
    public final void m7467f(Context context) throws IOException {
        C1442a.m8290i("BannerAfterPayTask", "parseDownloadConfig");
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(context.getFilesDir() + "/HiCloudPayBanners.json"));
            try {
                m7469h((HiCloudPayBanners) new Gson().fromJson(C0209d.m1290o2(fileInputStream), HiCloudPayBanners.class));
                fileInputStream.close();
            } finally {
            }
        } catch (Exception e10) {
            C1442a.m8289e("BannerAfterPayTask", "parseDownloadConfig failed : " + e10.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        if (p459lp.C11327e.m68063f("HiCloudPayBanners") >= r2) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0066, code lost:
    
        p054cj.C1442a.m8290i("BannerAfterPayTask", "version updated, query config");
        m7464c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006f, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
    
        p054cj.C1442a.m8290i("BannerAfterPayTask", "localVersion >= latestVersion");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0075, code lost:
    
        return false;
     */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m7468g() throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "queryConfigVersion"
            java.lang.String r1 = "BannerAfterPayTask"
            p054cj.C1442a.m8290i(r1, r0)
            com.huawei.hicloud.service.a r0 = r7.f5665b
            if (r0 != 0) goto L13
            com.huawei.hicloud.service.a r0 = new com.huawei.hicloud.service.a
            r2 = 0
            r0.<init>(r2)
            r7.f5665b = r0
        L13:
            r0 = 0
            r2 = r0
        L15:
            r3 = 2
            if (r2 > r3) goto L5a
            com.huawei.hicloud.service.a r4 = r7.f5665b     // Catch: fk.C9721b -> L1f
            long r2 = r4.getConfigVersion()     // Catch: fk.C9721b -> L1f
            goto L5c
        L1f:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "queryConfigVersion exception: "
            r5.append(r6)
            java.lang.String r6 = r4.toString()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            p054cj.C1442a.m8289e(r1, r5)
            com.huawei.hicloud.service.a r5 = r7.f5665b
            boolean r4 = r5.isExceptionNeedRetry(r4)
            if (r4 == 0) goto L59
            if (r2 >= r3) goto L59
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "queryConfigVersion exception retry, retry num: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            p054cj.C1442a.m8290i(r1, r3)
            int r2 = r2 + 1
            goto L15
        L59:
            return r0
        L5a:
            r2 = 0
        L5c:
            java.lang.String r4 = "HiCloudPayBanners"
            long r4 = p459lp.C11327e.m68063f(r4)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L70
            java.lang.String r0 = "version updated, query config"
            p054cj.C1442a.m8290i(r1, r0)
            r7.m7464c()
            r7 = 1
            return r7
        L70:
            java.lang.String r7 = "localVersion >= latestVersion"
            p054cj.C1442a.m8290i(r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bj.C1247a.m7468g():boolean");
    }

    @Override // p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.BANNER_DOWNLOAD_FIX;
    }

    /* renamed from: h */
    public final void m7469h(HiCloudPayBanners hiCloudPayBanners) throws C1414k {
        C1442a.m8290i("BannerAfterPayTask", "startDownloadPic");
        if (hiCloudPayBanners == null) {
            C1442a.m8289e("BannerAfterPayTask", "startDownloadPic config is null.");
            return;
        }
        Iterator<BannerAfterPayItem> it = hiCloudPayBanners.getBannerAfterPay().iterator();
        while (it.hasNext()) {
            BannerAfterPayItem next = it.next();
            if (C11278a.m67691i(next.getBeginTime(), next.getEndTime())) {
                ArrayList<BannerAfterPayPicturesItem> pictures = next.getPictures();
                BannerAfterPayPicturesItem bannerAfterPayPicturesItemM67685c = C11278a.m67685c(pictures, C11278a.m67684b());
                if (bannerAfterPayPicturesItemM67685c == null) {
                    C1442a.m8289e("BannerAfterPayTask", "startDownloadPic portalPicItem is null.");
                } else {
                    String url = bannerAfterPayPicturesItemM67685c.getUrl();
                    if (TextUtils.isEmpty(url)) {
                        C1442a.m8289e("BannerAfterPayTask", "startDownloadPic portalPicItemUrl is null.");
                    } else if (URLUtil.isHttpsUrl(url)) {
                        Context contextM1377a = C0213f.m1377a();
                        if (!m7466e(url)) {
                            m7465d(contextM1377a.getFilesDir() + "/pay_after_banner_pic/" + (url.hashCode() + "" + this.f5664a.nextInt(10000) + "" + System.currentTimeMillis()), url, bannerAfterPayPicturesItemM67685c.getHash());
                        }
                        BannerAfterPayPicturesItem bannerAfterPayPicturesItemM67685c2 = C11278a.m67685c(pictures, C11278a.m67683a());
                        if (bannerAfterPayPicturesItemM67685c2 == null) {
                            C1442a.m8289e("BannerAfterPayTask", "startDownloadPic landscapePicItem is null.");
                        } else {
                            String url2 = bannerAfterPayPicturesItemM67685c2.getUrl();
                            if (TextUtils.isEmpty(url2)) {
                                C1442a.m8289e("BannerAfterPayTask", "startDownloadPic landscapePicItemUrl is null.");
                            } else if (!URLUtil.isHttpsUrl(url2)) {
                                C1442a.m8289e("BannerAfterPayTask", "landscapePicItemUrl not https: " + url2);
                            } else if (!url.equals(url2) && !m7466e(url2)) {
                                m7465d(contextM1377a.getFilesDir() + "/pay_after_banner_pic/" + (url2.hashCode() + "" + this.f5664a.nextInt(10000) + "" + System.currentTimeMillis()), url2, bannerAfterPayPicturesItemM67685c2.getHash());
                            }
                        }
                    } else {
                        C1442a.m8289e("BannerAfterPayTask", "portalPicItemUrl not https: " + url);
                    }
                }
            }
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void release() {
        C12515a.m75110o().m75165a1(this);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return true;
    }
}
