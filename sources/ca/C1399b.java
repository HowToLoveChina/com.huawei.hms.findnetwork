package ca;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.URLUtil;
import ba.C1149c;
import ba.C1150d;
import ba.C1155i;
import ba.C1156j;
import ba.C1157k;
import ba.C1158l;
import com.huawei.hicloud.notification.p106db.bean.ConfigPictureParam;
import com.huawei.hicloud.notification.p106db.operator.HiCloudActivesLanguageOperator;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.service.C5015i;
import fk.C9721b;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0227m;
import p222da.C9059c;
import p253ea.C9439a;
import p292fn.C9734g;
import p459lp.C11327e;
import p514o9.C11839m;
import p616rk.C12515a;
import p664u0.C13108a;

/* renamed from: ca.b */
/* loaded from: classes3.dex */
public class C1399b {

    /* renamed from: e */
    public static final C1399b f5998e = new C1399b();

    /* renamed from: b */
    public C1149c f6000b;

    /* renamed from: a */
    public C5015i f5999a = new C5015i(null);

    /* renamed from: c */
    public Random f6001c = new Random();

    /* renamed from: d */
    public Context f6002d = C0213f.m1377a();

    /* renamed from: o */
    public static C1399b m8034o() {
        return f5998e;
    }

    /* renamed from: a */
    public final void m8035a(ArrayList<C9059c> arrayList, C1150d c1150d) {
        C1157k[] c1157kArrM7221a = c1150d.m7221a();
        if (c1157kArrM7221a == null || c1157kArrM7221a.length <= 0) {
            C11839m.m70687e("HiCloudActivesManager", "no awardsBannerPicturesObjects");
        } else {
            for (C1157k c1157k : c1157kArrM7221a) {
                m8045k(c1157k.m7232b(), c1157k.m7231a(), arrayList);
            }
        }
        C1158l[] c1158lArrM7224d = c1150d.m7224d();
        if (c1158lArrM7224d == null || c1158lArrM7224d.length <= 0) {
            C11839m.m70687e("HiCloudActivesManager", "no activiesTasksObjects");
            return;
        }
        for (C1158l c1158l : c1158lArrM7224d) {
            C1158l.a aVarM7233a = c1158l.m7233a();
            if (aVarM7233a != null) {
                m8045k(aVarM7233a.m7235b(), aVarM7233a.m7234a(), arrayList);
            }
        }
    }

    /* renamed from: b */
    public final void m8036b(C1150d[] c1150dArr, ArrayList<C9059c> arrayList) {
        for (C1150d c1150d : c1150dArr) {
            for (ConfigPictureParam configPictureParam : c1150d.m7223c()) {
                m8045k(configPictureParam.getUrl(), configPictureParam.getHash(), arrayList);
            }
            C1155i c1155iM7222b = c1150d.m7222b();
            if (c1155iM7222b == null) {
                C11839m.m70687e("HiCloudActivesManager", "No HiCloudActivesbuyPage");
            } else {
                ConfigPictureParam[] configPictureParamArrM7228a = c1155iM7222b.m7228a();
                if (configPictureParamArrM7228a == null) {
                    C11839m.m70687e("HiCloudActivesManager", "No buyPagePictureParams");
                } else {
                    for (ConfigPictureParam configPictureParam2 : configPictureParamArrM7228a) {
                        m8045k(configPictureParam2.getUrl(), configPictureParam2.getHash(), arrayList);
                    }
                }
            }
            m8035a(arrayList, c1150d);
        }
    }

    /* renamed from: c */
    public final boolean m8037c(C1149c c1149c) {
        C11839m.m70688i("HiCloudActivesManager", "cacheHiCloudActivesImage");
        if (c1149c == null) {
            C11839m.m70687e("HiCloudActivesManager", "cacheHiCloudActivesImage config null");
            return false;
        }
        C1156j c1156jM7220a = c1149c.m7220a();
        if (c1156jM7220a == null) {
            C11839m.m70687e("HiCloudActivesManager", "No HiCloudActivesResource");
            return false;
        }
        C1150d[] c1150dArrM7229a = c1156jM7220a.m7229a();
        if (c1150dArrM7229a.length <= 0) {
            C11839m.m70687e("HiCloudActivesManager", "No HiCloudActivesConfigObjects");
            return false;
        }
        ArrayList<C9059c> arrayList = new ArrayList<>();
        m8036b(c1150dArrM7229a, arrayList);
        if (arrayList.size() == 0) {
            C11839m.m70688i("HiCloudActivesManager", "no task needs to be execute");
            return false;
        }
        CountDownLatch countDownLatch = new CountDownLatch(arrayList.size());
        Iterator<C9059c> it = arrayList.iterator();
        while (it.hasNext()) {
            C9059c next = it.next();
            next.setCount(countDownLatch);
            C12515a.m75110o().m75175e(next, false);
        }
        try {
            if (!countDownLatch.await(30000L, TimeUnit.MILLISECONDS)) {
                C11839m.m70687e("HiCloudActivesManager", "banner picture download threads time out, total: " + arrayList.size() + " tasks. " + countDownLatch.getCount() + " task(s) time out");
            }
        } catch (InterruptedException e10) {
            C11839m.m70687e("HiCloudActivesManager", e10.toString());
        }
        return m8054u(arrayList);
    }

    /* renamed from: d */
    public final boolean m8038d(C1149c c1149c) {
        C11839m.m70688i("HiCloudActivesManager", "cacheLanguage");
        if (c1149c == null) {
            C11839m.m70687e("HiCloudActivesManager", "cacheLanguage config null");
            return false;
        }
        if (this.f6002d == null) {
            C11839m.m70687e("HiCloudActivesManager", "mContext is null");
            return false;
        }
        if (new File(this.f6002d.getFilesDir() + "/hicloud_actives_language.xml").exists()) {
            C11839m.m70687e("HiCloudActivesManager", "cacheLanguage xmlfile exist");
            return false;
        }
        C1156j c1156jM7220a = c1149c.m7220a();
        if (c1156jM7220a == null) {
            C11839m.m70687e("HiCloudActivesManager", "No hiCloudActivesResource");
            return false;
        }
        c1156jM7220a.m7230b();
        C11839m.m70687e("HiCloudActivesManager", "No hiCloudActivesLanguage");
        return false;
    }

    /* renamed from: e */
    public void m8039e() throws Throwable {
        C11839m.m70688i("HiCloudActivesManager", "checkLanguageDataBase");
        C1149c c1149cM8047m = m8047m();
        if (c1149cM8047m == null || this.f6002d == null) {
            C11839m.m70687e("HiCloudActivesManager", "checkLanguageDataBase() HiCloudActivesConfig is null or mContext is null.");
            return;
        }
        C1156j c1156jM7220a = c1149cM8047m.m7220a();
        if (c1156jM7220a == null) {
            C11839m.m70687e("HiCloudActivesManager", "No hiCloudActivesResource");
        } else {
            c1156jM7220a.m7230b();
            C11839m.m70687e("HiCloudActivesManager", "No hiCloudActivesLanguage");
        }
    }

    /* renamed from: f */
    public void m8040f() {
        synchronized (this) {
            m8043i();
            m8041g();
            m8042h();
        }
    }

    /* renamed from: g */
    public void m8041g() {
        new HiCloudActivesLanguageOperator().clear();
    }

    /* renamed from: h */
    public void m8042h() {
        File file = new File(this.f6002d.getFilesDir() + "/hicloud_actives_language.xml");
        if (!file.exists()) {
            C11839m.m70687e("HiCloudActivesManager", "hicloudactivesLanguageXml file not exist");
        } else {
            if (file.delete()) {
                return;
            }
            C11839m.m70687e("HiCloudActivesManager", "hicloudactivesLanguageXml file del failed");
        }
    }

    /* renamed from: i */
    public void m8043i() {
        if (this.f6002d == null) {
            C11839m.m70687e("HiCloudActivesManager", "mContext is null");
            return;
        }
        File file = new File(this.f6002d.getFilesDir() + "/HiCloudActivesConfig.json");
        if (!file.exists()) {
            C11839m.m70687e("HiCloudActivesManager", "hicloudactives file not exist");
        } else if (!file.delete()) {
            C11839m.m70687e("HiCloudActivesManager", "hicloudactives file del failed");
        }
        m8044j(this.f6002d.getFilesDir() + "/hicloudactivespictures");
        C0212e0.m1352b(this.f6002d, "hicloud_actives_path_url_pair");
        C11327e.m68059b("HiCloudActives");
    }

    /* renamed from: j */
    public final void m8044j(String str) {
        File[] fileArrListFiles;
        C11839m.m70688i("HiCloudActivesManager", "delete pictures in folder");
        File file = new File(str);
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (!file2.isDirectory() && !file2.delete()) {
                    C11839m.m70687e("HiCloudActivesManager", "del file failed, file name is " + file2.getPath());
                }
            }
        }
    }

    /* renamed from: k */
    public final void m8045k(String str, String str2, ArrayList<C9059c> arrayList) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("HiCloudActivesManager", "pictureUrl null");
            return;
        }
        if (!URLUtil.isHttpsUrl(str)) {
            C11839m.m70687e("HiCloudActivesManager", "pictureUrl not https: " + str);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            C11839m.m70687e("HiCloudActivesManager", "pictureHash null");
            return;
        }
        if (m8050q(str)) {
            return;
        }
        arrayList.add(new C9059c(this.f6002d.getFilesDir() + "/hicloudactivespictures/" + (C0227m.m1593f(str) + "" + this.f6001c.nextInt(10000) + "" + System.currentTimeMillis()), str, str2));
    }

    /* renamed from: l */
    public final void m8046l() throws Throwable {
        Context contextM1377a;
        C11839m.m70688i("HiCloudActivesManager", "getConfig() start");
        if (this.f5999a == null) {
            this.f5999a = new C5015i(null);
        }
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
                contextM1377a = C0213f.m1377a();
            } catch (C9721b e10) {
                String str = "getConfig() exception:" + e10.toString();
                C11839m.m70687e("HiCloudActivesManager", str);
                C9439a.m59208b(str, i10);
                if (NotifyUtil.procFlowControlException(e10, "HiCloudActives")) {
                    return;
                }
                if (e10.m60659c() == 304) {
                    C11839m.m70687e("HiCloudActivesManager", "HTTP_NOT_MODIFY extract sync module config");
                    return;
                } else {
                    if (!this.f5999a.isExceptionNeedRetry(e10) || i10 >= 2) {
                        return;
                    }
                    C11839m.m70688i("HiCloudActivesManager", "getLatestConfig exception retry, retry num: " + i10);
                }
            }
            if (contextM1377a == null) {
                C11839m.m70687e("HiCloudActivesManager", "getConfig() context is null.");
                return;
            }
            if (this.f5999a.getLatestConfig()) {
                C11839m.m70688i("HiCloudActivesManager", "getConfig success");
                C9734g.m60767a().m60769c("HiCloudActives");
                contextM1377a.getSharedPreferences("hicloud_actives_path_url_pair", 0).edit().clear().apply();
                m8044j(contextM1377a.getFilesDir() + "/hicloudactivespictures");
                if (new File(contextM1377a.getFilesDir() + "/hicloud_actives_language.xml").delete()) {
                    C11839m.m70688i("HiCloudActivesManager", "delete local language xml file successfully");
                }
                m8051r();
                return;
            }
            C11839m.m70687e("HiCloudActivesManager", "query hicloud actives config failed");
            C9439a.m59208b("query hicloud actives config failed.", i10);
            if (i10 >= 2) {
                return;
            }
            C11839m.m70688i("HiCloudActivesManager", "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ba.C1149c m8047m() throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r0 = "fileInputStream close error."
            java.lang.String r1 = "HiCloudActivesManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.content.Context r3 = r6.f6002d
            java.io.File r3 = r3.getFilesDir()
            r2.append(r3)
            java.lang.String r3 = "/HiCloudActivesConfig.json"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.io.File r3 = new java.io.File
            r3.<init>(r2)
            r2 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            java.lang.String r6 = r6.m8052s(r4)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            com.google.gson.Gson r3 = new com.google.gson.Gson     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            r3.<init>()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            java.lang.Class<ba.c> r5 = ba.C1149c.class
            java.lang.Object r6 = r3.fromJson(r6, r5)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            ba.c r6 = (ba.C1149c) r6     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            r4.close()     // Catch: java.io.IOException -> L3b
            goto L3e
        L3b:
            p514o9.C11839m.m70687e(r1, r0)
        L3e:
            r2 = r6
            goto L6a
        L40:
            r6 = move-exception
            r2 = r4
            goto L6b
        L43:
            r6 = move-exception
            goto L49
        L45:
            r6 = move-exception
            goto L6b
        L47:
            r6 = move-exception
            r4 = r2
        L49:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40
            r3.<init>()     // Catch: java.lang.Throwable -> L40
            java.lang.String r5 = "getConfigFile failed : "
            r3.append(r5)     // Catch: java.lang.Throwable -> L40
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L40
            r3.append(r6)     // Catch: java.lang.Throwable -> L40
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> L40
            p514o9.C11839m.m70687e(r1, r6)     // Catch: java.lang.Throwable -> L40
            if (r4 == 0) goto L6a
            r4.close()     // Catch: java.io.IOException -> L67
            goto L6a
        L67:
            p514o9.C11839m.m70687e(r1, r0)
        L6a:
            return r2
        L6b:
            if (r2 == 0) goto L74
            r2.close()     // Catch: java.io.IOException -> L71
            goto L74
        L71:
            p514o9.C11839m.m70687e(r1, r0)
        L74:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.C1399b.m8047m():ba.c");
    }

    /* renamed from: n */
    public String m8048n(String str) {
        return C0212e0.m1363m(this.f6002d, "hicloud_actives_path_url_pair", C0227m.m1593f(str), null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007a, code lost:
    
        if (p459lp.C11327e.m68063f("HiCloudActives") >= r2) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007c, code lost:
    
        p514o9.C11839m.m70688i("HiCloudActivesManager", "version updated, query config");
        m8046l();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0084, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0085, code lost:
    
        p514o9.C11839m.m70689w("HiCloudActivesManager", "getVersion fail. localVersion > latestVersion");
        m8051r();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008d, code lost:
    
        return;
     */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m8049p() throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.String r0 = "getVersion start"
            java.lang.String r1 = "HiCloudActivesManager"
            p514o9.C11839m.m70688i(r1, r0)
            com.huawei.hicloud.service.i r0 = r7.f5999a
            if (r0 != 0) goto L13
            com.huawei.hicloud.service.i r0 = new com.huawei.hicloud.service.i
            r2 = 0
            r0.<init>(r2)
            r7.f5999a = r0
        L13:
            r0 = 0
        L14:
            r2 = 2
            if (r0 > r2) goto L70
            com.huawei.hicloud.service.i r3 = r7.f5999a     // Catch: fk.C9721b -> L1e
            long r2 = r3.getConfigVersion()     // Catch: fk.C9721b -> L1e
            goto L72
        L1e:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "getHiCloudActivesConfigVersion exception:"
            r4.append(r5)
            java.lang.String r5 = r3.toString()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r6 = " retryNum = "
            r5.append(r6)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            p514o9.C11839m.m70687e(r1, r5)
            p253ea.C9439a.m59208b(r4, r0)
            com.huawei.hicloud.service.i r4 = r7.f5999a
            boolean r3 = r4.isExceptionNeedRetry(r3)
            if (r3 == 0) goto L6f
            if (r0 >= r2) goto L6f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getVersion exception retry, retry num: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            p514o9.C11839m.m70688i(r1, r2)
            int r0 = r0 + 1
            goto L14
        L6f:
            return
        L70:
            r2 = 0
        L72:
            java.lang.String r0 = "HiCloudActives"
            long r4 = p459lp.C11327e.m68063f(r0)
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 >= 0) goto L85
            java.lang.String r0 = "version updated, query config"
            p514o9.C11839m.m70688i(r1, r0)
            r7.m8046l()
            return
        L85:
            java.lang.String r0 = "getVersion fail. localVersion > latestVersion"
            p514o9.C11839m.m70689w(r1, r0)
            r7.m8051r()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.C1399b.m8049p():void");
    }

    /* renamed from: q */
    public final boolean m8050q(String str) {
        String strM1363m = C0212e0.m1363m(this.f6002d, "hicloud_actives_path_url_pair", C0227m.m1593f(str), null);
        if (TextUtils.isEmpty(strM1363m)) {
            C11839m.m70687e("HiCloudActivesManager", " SP record not exist, url = " + str);
            return false;
        }
        if (new File(strM1363m).exists()) {
            return true;
        }
        C11839m.m70687e("HiCloudActivesManager", "local file do not exist, SP record exist, url = " + str + " file path = " + strM1363m);
        C0212e0.m1374x(this.f6002d, "hicloud_actives_path_url_pair", C0227m.m1593f(str));
        return false;
    }

    /* renamed from: r */
    public final void m8051r() throws Throwable {
        C11839m.m70688i("HiCloudActivesManager", "parseDownloadConfig");
        if (C0213f.m1377a() == null) {
            C11839m.m70687e("HiCloudActivesManager", "parseDownloadConfig() context is null.");
            C9439a.m59207a("getConfig() context is null.");
            return;
        }
        C1149c c1149cM8047m = m8047m();
        this.f6000b = c1149cM8047m;
        boolean zM8037c = m8037c(c1149cM8047m);
        boolean zM8038d = m8038d(c1149cM8047m);
        if (zM8037c || zM8038d) {
            m8053t(false);
        }
    }

    /* renamed from: s */
    public final String m8052s(InputStream inputStream) {
        return C0209d.m1290o2(inputStream);
    }

    /* renamed from: t */
    public void m8053t(boolean z10) {
        if (this.f6002d == null) {
            C11839m.m70687e("HiCloudActivesManager", "send refresh view broadcast failed, mContext is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("needUpdateStorage", z10);
        intent.setAction("com.huawei.android.hicloud.HICLOUDACTIVE_REFRESH_VIEW");
        C13108a.m78878b(this.f6002d).m78881d(intent);
    }

    /* renamed from: u */
    public final boolean m8054u(ArrayList<C9059c> arrayList) {
        try {
            SharedPreferences.Editor editorEdit = this.f6002d.getSharedPreferences("hicloud_actives_path_url_pair", 0).edit();
            Iterator<C9059c> it = arrayList.iterator();
            while (it.hasNext()) {
                C9059c next = it.next();
                if (new File(next.getDestPath()).exists()) {
                    editorEdit.putString(C0227m.m1593f(next.getPicUrl()), next.getDestPath());
                }
            }
            editorEdit.apply();
            return true;
        } catch (Exception e10) {
            C11839m.m70687e("HiCloudActivesManager", "storeLocalPathInSpFile exception: " + e10.toString());
            return false;
        }
    }
}
