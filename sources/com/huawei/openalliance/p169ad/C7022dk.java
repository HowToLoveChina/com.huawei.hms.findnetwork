package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.Scheme;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7801cu;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.dk */
/* loaded from: classes8.dex */
public class C7022dk {

    /* renamed from: a */
    private C7023dl f32218a;

    /* renamed from: b */
    private FileObserverC7024dm f32219b;

    /* renamed from: c */
    private final byte[] f32220c = new byte[0];

    /* renamed from: d */
    private Context f32221d;

    /* renamed from: e */
    private SoftReference<List<String>> f32222e;

    /* renamed from: f */
    private String f32223f;

    /* renamed from: g */
    private String f32224g;

    public C7022dk(Context context, String str) {
        this.f32223f = "DiskCacheManager_" + str;
        if (context == null) {
            return;
        }
        this.f32224g = str;
        this.f32221d = context.getApplicationContext();
        m41952b(context, str);
    }

    /* renamed from: a */
    private C7023dl m41950a(boolean z10) {
        C7023dl c7023dl;
        synchronized (this.f32220c) {
            try {
                C7023dl c7023dl2 = this.f32218a;
                if (c7023dl2 == null) {
                    AbstractC7185ho.m43820b(this.f32224g, "fileDiskCache is null, recreate");
                    m41952b(this.f32221d, this.f32224g);
                } else if (z10) {
                    File fileM42003a = c7023dl2.m42003a();
                    if (fileM42003a != null) {
                        try {
                            if (!fileM42003a.exists()) {
                                this.f32218a = null;
                                m41952b(this.f32221d, this.f32224g);
                            }
                        } catch (Exception e10) {
                            AbstractC7185ho.m43823c(this.f32223f, "init diskcache error:" + e10.getClass().getSimpleName());
                        }
                    } else {
                        this.f32218a = null;
                        m41952b(this.f32221d, this.f32224g);
                    }
                }
                c7023dl = this.f32218a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7023dl;
    }

    /* renamed from: d */
    public static String m41953d(String str) {
        return Scheme.DISKCACHE.toString() + AbstractC7801cu.m48126a(str);
    }

    /* renamed from: i */
    public static boolean m41954i(String str) {
        return str != null && str.startsWith(Scheme.DISKCACHE.toString());
    }

    /* renamed from: k */
    public static String m41955k(String str) {
        String string = Scheme.DISKCACHE.toString();
        if (str == null || !str.startsWith(string)) {
            return null;
        }
        return str.substring(string.length());
    }

    /* renamed from: l */
    public static String m41956l(String str) {
        String[] strArrSplit;
        int length;
        if (AbstractC7806cz.m48165b(str) || (length = (strArrSplit = str.split(File.separator)).length) == 0) {
            return str;
        }
        String str2 = strArrSplit[length - 1];
        if (AbstractC7806cz.m48165b(str2)) {
            return str;
        }
        return Scheme.DISKCACHE + str2;
    }

    /* renamed from: b */
    public int m41964b() {
        C7023dl c7023dlM41950a = m41950a(false);
        if (c7023dlM41950a == null) {
            return 0;
        }
        return c7023dlM41950a.m42014c();
    }

    /* renamed from: c */
    public long m41967c() {
        C7023dl c7023dlM41950a = m41950a(false);
        if (c7023dlM41950a == null) {
            return 0L;
        }
        return c7023dlM41950a.m42011b();
    }

    /* renamed from: e */
    public String m41970e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strM41953d = m41953d(str);
        return m41973f(strM41953d) ? strM41953d : "";
    }

    /* renamed from: f */
    public String m41972f() {
        return this.f32224g;
    }

    /* renamed from: g */
    public boolean m41974g(String str) {
        String strM41968c = m41968c(str);
        return strM41968c != null && AbstractC7731ae.m47464d(new File(strM41968c));
    }

    /* renamed from: h */
    public void m41975h(String str) {
        C7023dl c7023dlM41950a = m41950a(true);
        if (c7023dlM41950a == null) {
            AbstractC7185ho.m43823c(this.f32223f, "fileDiskCache is null");
            return;
        }
        String strM41955k = m41955k(str);
        if (TextUtils.isEmpty(strM41955k)) {
            return;
        }
        c7023dlM41950a.m42008a(strM41955k);
    }

    /* renamed from: j */
    public void m41976j(String str) {
        String strM41955k;
        C7023dl c7023dlM41950a = m41950a(true);
        if (c7023dlM41950a == null || (strM41955k = m41955k(str)) == null) {
            return;
        }
        try {
            c7023dlM41950a.m42015c(strM41955k);
        } catch (Exception e10) {
            AbstractC7185ho.m43823c(this.f32223f, "deleteCacheFile " + e10.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public static File m41951a(Context context, String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        if (AbstractC7806cz.m48165b(str) || Constants.NORMAL_CACHE.equals(str)) {
            StringBuilder sb2 = new StringBuilder();
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append(Constants.PPS_ROOT_PATH);
            sb2.append(str2);
            sb2.append("pps_diskcache");
            return new File(cacheDir, sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder();
        String str3 = File.separator;
        sb3.append(str3);
        sb3.append(Constants.PPS_ROOT_PATH);
        sb3.append(str3);
        sb3.append("pps_new_diskcache");
        sb3.append(str3);
        sb3.append(str);
        return new File(cacheDir, sb3.toString());
    }

    /* renamed from: b */
    public String m41965b(String str) {
        C7023dl c7023dlM41950a = m41950a(false);
        if (c7023dlM41950a == null) {
            return null;
        }
        return c7023dlM41950a.m42012b(str);
    }

    /* renamed from: c */
    public String m41968c(String str) {
        String strM41955k = m41955k(str);
        if (strM41955k != null) {
            return m41965b(strM41955k);
        }
        return null;
    }

    /* renamed from: d */
    public void m41969d() {
        if (this.f32222e != null) {
            this.f32222e = null;
        }
    }

    /* renamed from: e */
    public List<String> m41971e() {
        SoftReference<List<String>> softReference = this.f32222e;
        List<String> list = softReference != null ? softReference.get() : null;
        return AbstractC7760bg.m47767a(list) ? new ArrayList() : list;
    }

    /* renamed from: f */
    public boolean m41973f(String str) {
        String strM41968c = m41968c(str);
        return strM41968c != null && AbstractC7731ae.m47458b(strM41968c);
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m41957a() {
        /*
            r4 = this;
            byte[] r0 = r4.f32220c
            monitor-enter(r0)
            com.huawei.openalliance.ad.dl r1 = r4.f32218a     // Catch: java.lang.Throwable -> Le
            r2 = 0
            if (r1 == 0) goto L1d
            r1.m42016d()     // Catch: java.lang.Throwable -> L10 java.lang.Exception -> L12
        Lb:
            r4.f32218a = r2     // Catch: java.lang.Throwable -> Le
            goto L1d
        Le:
            r4 = move-exception
            goto L39
        L10:
            r1 = move-exception
            goto L1a
        L12:
            java.lang.String r1 = r4.f32223f     // Catch: java.lang.Throwable -> L10
            java.lang.String r3 = "clear cache error"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43826d(r1, r3)     // Catch: java.lang.Throwable -> L10
            goto Lb
        L1a:
            r4.f32218a = r2     // Catch: java.lang.Throwable -> Le
            throw r1     // Catch: java.lang.Throwable -> Le
        L1d:
            com.huawei.openalliance.ad.dm r1 = r4.f32219b     // Catch: java.lang.Throwable -> Le
            if (r1 == 0) goto L34
            r1.stopWatching()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
        L24:
            r4.f32219b = r2     // Catch: java.lang.Throwable -> Le
            goto L34
        L27:
            r1 = move-exception
            goto L31
        L29:
            java.lang.String r1 = r4.f32223f     // Catch: java.lang.Throwable -> L27
            java.lang.String r3 = "stop watching error"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43826d(r1, r3)     // Catch: java.lang.Throwable -> L27
            goto L24
        L31:
            r4.f32219b = r2     // Catch: java.lang.Throwable -> Le
            throw r1     // Catch: java.lang.Throwable -> Le
        L34:
            r4.m41969d()     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            return
        L39:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7022dk.m41957a():void");
    }

    /* renamed from: b */
    public void m41966b(long j10) {
        C7023dl c7023dlM41950a = m41950a(false);
        if (c7023dlM41950a == null) {
            return;
        }
        c7023dlM41950a.m42013b(j10);
    }

    /* renamed from: b */
    private boolean m41952b(Context context, String str) {
        File fileM41951a;
        String str2;
        StringBuilder sb2;
        String str3;
        if (this.f32218a != null) {
            return true;
        }
        if (context == null || (fileM41951a = m41951a(context, str)) == null) {
            return false;
        }
        try {
            FileObserverC7024dm fileObserverC7024dm = new FileObserverC7024dm(fileM41951a);
            this.f32219b = fileObserverC7024dm;
            fileObserverC7024dm.startWatching();
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c(this.f32223f, "start fileListener failed, " + th2.getClass().getSimpleName());
            AbstractC7185ho.m43815a(3, th2);
            this.f32219b = null;
        }
        try {
            InterfaceC7146gc interfaceC7146gcM43316b = C7124fh.m43316b(context);
            C7023dl c7023dl = new C7023dl(fileM41951a, interfaceC7146gcM43316b.mo43359aZ() * 1048576, interfaceC7146gcM43316b.mo43364av());
            this.f32218a = c7023dl;
            c7023dl.m42013b(interfaceC7146gcM43316b.mo43374bA().longValue());
            this.f32218a.m42007a(new C7020di(context, str));
            this.f32218a.m42006a(this);
            return true;
        } catch (IllegalStateException e10) {
            e = e10;
            str2 = this.f32223f;
            sb2 = new StringBuilder();
            str3 = "Unable to create FileDiskCache";
            sb2.append(str3);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c(str2, sb2.toString());
            return false;
        } catch (Exception e11) {
            e = e11;
            str2 = this.f32223f;
            sb2 = new StringBuilder();
            str3 = "Unable to create FileDiskCache ex: ";
            sb2.append(str3);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c(str2, sb2.toString());
            return false;
        }
    }

    /* renamed from: a */
    public void m41958a(int i10) {
        C7023dl c7023dlM41950a = m41950a(false);
        if (c7023dlM41950a == null) {
            return;
        }
        c7023dlM41950a.m42004a(i10);
    }

    /* renamed from: a */
    public void m41959a(long j10) {
        C7023dl c7023dlM41950a = m41950a(false);
        if (c7023dlM41950a == null) {
            return;
        }
        c7023dlM41950a.m42005a(j10);
    }

    /* renamed from: a */
    public void m41960a(String str, int i10) {
        C7023dl c7023dlM41950a = m41950a(true);
        if (c7023dlM41950a == null) {
            AbstractC7185ho.m43823c(this.f32223f, "fileDiskCache is null");
            return;
        }
        String strM41955k = m41955k(str);
        if (TextUtils.isEmpty(strM41955k)) {
            return;
        }
        c7023dlM41950a.m42009a(strM41955k, i10);
    }

    /* renamed from: a */
    public void m41961a(List<String> list, boolean z10) {
        if (AbstractC7760bg.m47767a(list)) {
            return;
        }
        try {
            SoftReference<List<String>> softReference = this.f32222e;
            List<String> arrayList = softReference != null ? softReference.get() : null;
            if (AbstractC7760bg.m47767a(arrayList)) {
                arrayList = new ArrayList<>();
            } else if (z10) {
                arrayList.clear();
            }
            arrayList.addAll(list);
            this.f32222e = new SoftReference<>(arrayList);
        } catch (Throwable th2) {
            AbstractC7185ho.m43827d(this.f32223f, "updateCacheExcludeList exception: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public boolean m41962a(File file, String str, ContentResource contentResource) {
        String str2;
        String str3;
        C7023dl c7023dlM41950a = m41950a(true);
        if (c7023dlM41950a == null) {
            str2 = this.f32223f;
            str3 = "fileDiskCache is null";
        } else {
            if (contentResource != null) {
                contentResource.m41636e(this.f32224g);
            }
            String strM41955k = m41955k(str);
            if (strM41955k == null || file == null || !file.exists()) {
                str2 = this.f32223f;
                str3 = "param error";
            } else {
                try {
                    return c7023dlM41950a.m42010a(strM41955k, file, contentResource);
                } catch (Exception e10) {
                    str2 = this.f32223f;
                    str3 = "putOuterFileToCache " + e10.getClass().getSimpleName();
                }
            }
        }
        AbstractC7185ho.m43823c(str2, str3);
        return false;
    }

    /* renamed from: a */
    public boolean m41963a(String str) {
        FileObserverC7024dm fileObserverC7024dm = this.f32219b;
        if (fileObserverC7024dm != null) {
            return fileObserverC7024dm.m42021a(str);
        }
        return false;
    }
}
