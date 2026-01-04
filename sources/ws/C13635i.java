package ws;

import android.text.TextUtils;
import as.C1016d;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.location.activity.C6738e;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import es.C9540e;
import es.C9542g;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import p531or.C11991a;
import p786xs.C13855b;
import p786xs.C13856c;
import p786xs.C13859f;
import p786xs.C13860g;
import p786xs.C13861h;

/* renamed from: ws.i */
/* loaded from: classes8.dex */
public final class C13635i {

    /* renamed from: e */
    public static final String f61309e;

    /* renamed from: f */
    public static final String f61310f;

    /* renamed from: g */
    public static final String f61311g;

    /* renamed from: h */
    public static final String f61312h;

    /* renamed from: i */
    public static String f61313i;

    /* renamed from: j */
    public static double f61314j;

    /* renamed from: k */
    public static double f61315k;

    /* renamed from: a */
    public int f61316a = 25;

    /* renamed from: b */
    public int f61317b = 30;

    /* renamed from: c */
    public C13636j f61318c;

    /* renamed from: d */
    public C13631e f61319d;

    /* renamed from: ws.i$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f61320a;

        public a(String str) {
            this.f61320a = str;
        }

        @Override // java.lang.Runnable
        public final void run() throws IOException {
            Thread.currentThread().setName("SDM-TileStoreManager-" + hashCode());
            C13635i.m81996j(C13635i.this, this.f61320a);
        }
    }

    /* renamed from: ws.i$b */
    public class b extends TypeToken<C13631e> {
    }

    static {
        String str;
        try {
            str = C11991a.m72145a().getCacheDir().getCanonicalPath() + File.separator;
        } catch (IOException unused) {
            C1016d.m6183c("FileUtils", "Failed to obtain the store dir path.");
            str = null;
        }
        f61309e = str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("CityAdmin");
        String str2 = File.separator;
        sb2.append(str2);
        f61310f = sb2.toString();
        f61311g = str + "CityInfo" + str2;
        f61312h = str + "TileList" + str2;
        f61314j = 0.0d;
        f61315k = 0.0d;
    }

    public C13635i(int i10, int i11) {
        m81998b(i10);
        m82000h(i11);
    }

    /* renamed from: d */
    public static void m81991d(C13635i c13635i) {
        String str;
        synchronized (c13635i) {
            try {
                C13636j c13636j = c13635i.f61318c;
                if (c13636j != null) {
                    String strM82004c = c13636j.m82004c();
                    String strM82002a = c13635i.f61318c.m82002a();
                    String strM82003b = c13635i.f61318c.m82003b();
                    String str2 = f61310f;
                    String strM83177d = C13859f.m83177d(str2, strM82004c);
                    if (TextUtils.isEmpty(strM83177d) || TextUtils.isEmpty(strM82003b)) {
                        str = "The adminJson file data is abnormal.";
                    } else {
                        File file = new File(strM83177d);
                        if (file.exists()) {
                            String strM83182a = C13860g.m83182a(strM83177d, strM82002a);
                            if (!TextUtils.isEmpty(strM83182a) && strM83182a.equals(strM82003b)) {
                                str = "The file is the latest version.";
                            } else if (file.getParentFile().delete()) {
                                C1016d.m6183c("TileStoreManager", "Failed to delete the file.");
                            }
                        }
                        if (C13856c.m83166b(strM83177d, strM82004c, strM82002a, strM82003b) && !C13859f.m83181h(strM83177d, str2, file.getName().replace(FeedbackWebConstants.SUFFIX, ""))) {
                            C1016d.m6183c("TileStoreManager", "Failed to unzip the adminJson file.");
                        }
                    }
                    C1016d.m6181a("TileStoreManager", str);
                }
            } finally {
            }
        }
    }

    /* renamed from: e */
    public static C13628b m81992e(String str, List list) {
        if (!TextUtils.isEmpty(str) && list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C13628b c13628b = (C13628b) it.next();
                if (c13628b != null) {
                    String strM81986c = c13628b.m81986c();
                    if (TextUtils.isEmpty(strM81986c)) {
                        continue;
                    } else {
                        if (strM81986c.endsWith(str + FeedbackWebConstants.SUFFIX)) {
                            return c13628b;
                        }
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: f */
    public static C13631e m81993f(String str) {
        String str2;
        File file = new File(C6738e.m38291a(new StringBuilder(), f61311g, str));
        if (!file.exists() || System.currentTimeMillis() - file.lastModified() >= 604800000) {
            return null;
        }
        try {
            return (C13631e) C9542g.m59588a().fromJson(C13859f.m83174a(file.getCanonicalPath()), new b().getType());
        } catch (JsonSyntaxException unused) {
            str2 = "json syntax error";
            C1016d.m6183c("TileStoreManager", str2);
            return null;
        } catch (IOException unused2) {
            str2 = "Invalid file path";
            C1016d.m6183c("TileStoreManager", str2);
            return null;
        }
    }

    /* renamed from: g */
    public static C13861h m81994g() {
        return new C13861h(f61315k, f61314j);
    }

    /* renamed from: i */
    public static void m81995i(C13635i c13635i) {
        String str;
        synchronized (c13635i) {
            if (c13635i.f61318c == null) {
                String strM83165a = C13856c.m83165a("CITYADMIN-WKT");
                if (TextUtils.isEmpty(strM83165a)) {
                    C1016d.m6181a("TileStoreManager", "get adminJson from cloud is fail");
                } else {
                    try {
                        List list = (List) C9542g.m59588a().fromJson(strM83165a, new C13637k().getType());
                        if (list == null || list.size() == 0) {
                            str = "adminJsonList is null";
                        } else {
                            C13636j c13636j = (C13636j) list.get(0);
                            if (c13636j == null) {
                                str = "tempAdminJson is null";
                            } else {
                                c13635i.f61318c = c13636j;
                                C13859f.m83179f(new File(f61309e + "CityAdminJson"), C9542g.m59588a().toJson(c13635i.f61318c));
                            }
                        }
                        C1016d.m6181a("TileStoreManager", str);
                    } catch (JsonSyntaxException unused) {
                        C1016d.m6183c("TileStoreManager", "json syntax error");
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0069 A[Catch: JsonSyntaxException -> 0x006d, TRY_LEAVE, TryCatch #2 {JsonSyntaxException -> 0x006d, blocks: (B:54:0x0054, B:56:0x0069), top: B:71:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m81996j(ws.C13635i r7, java.lang.String r8) throws java.io.IOException {
        /*
            java.lang.String r0 = "json syntax error"
            java.lang.String r1 = "TileStoreManager"
            r7.getClass()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 1
        Ld:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r8)
            java.lang.String r5 = "_"
            r4.append(r5)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = p786xs.C13856c.m83165a(r4)
            ws.h r5 = new ws.h     // Catch: com.google.gson.JsonSyntaxException -> L3e
            r5.<init>()     // Catch: com.google.gson.JsonSyntaxException -> L3e
            java.lang.reflect.Type r5 = r5.getType()     // Catch: com.google.gson.JsonSyntaxException -> L3e
            com.google.gson.Gson r6 = es.C9542g.m59588a()     // Catch: com.google.gson.JsonSyntaxException -> L3e
            java.lang.Object r4 = r6.fromJson(r4, r5)     // Catch: com.google.gson.JsonSyntaxException -> L3e
            java.util.List r4 = (java.util.List) r4     // Catch: com.google.gson.JsonSyntaxException -> L3e
            if (r4 == 0) goto L42
            r2.addAll(r4)     // Catch: com.google.gson.JsonSyntaxException -> L3f
            goto L42
        L3e:
            r4 = 0
        L3f:
            as.C1016d.m6183c(r1, r0)
        L42:
            if (r4 == 0) goto L50
            int r4 = r4.size()
            r5 = 59
            if (r4 >= r5) goto L4d
            goto L50
        L4d:
            int r3 = r3 + 1
            goto Ld
        L50:
            java.lang.String r3 = p786xs.C13856c.m83165a(r8)
            ws.d r4 = new ws.d     // Catch: com.google.gson.JsonSyntaxException -> L6d
            r4.<init>()     // Catch: com.google.gson.JsonSyntaxException -> L6d
            java.lang.reflect.Type r4 = r4.getType()     // Catch: com.google.gson.JsonSyntaxException -> L6d
            com.google.gson.Gson r5 = es.C9542g.m59588a()     // Catch: com.google.gson.JsonSyntaxException -> L6d
            java.lang.Object r3 = r5.fromJson(r3, r4)     // Catch: com.google.gson.JsonSyntaxException -> L6d
            java.util.List r3 = (java.util.List) r3     // Catch: com.google.gson.JsonSyntaxException -> L6d
            if (r3 == 0) goto L70
            r2.addAll(r3)     // Catch: com.google.gson.JsonSyntaxException -> L6d
            goto L70
        L6d:
            as.C1016d.m6183c(r1, r0)
        L70:
            int r0 = r2.size()
            if (r0 <= 0) goto Lab
            ws.e r0 = new ws.e
            r0.<init>(r8, r2)
            r7.f61319d = r0
            com.google.gson.Gson r0 = es.C9542g.m59588a()
            ws.e r7 = r7.f61319d
            java.lang.String r7 = r0.toJson(r7)
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = ws.C13635i.f61311g
            java.lang.String r8 = com.huawei.location.activity.C6738e.m38291a(r1, r2, r8)
            r0.<init>(r8)
            java.io.File r8 = r0.getParentFile()
            boolean r8 = r8.exists()
            if (r8 != 0) goto La8
            java.io.File r8 = r0.getParentFile()
            r8.mkdirs()
        La8:
            p786xs.C13859f.m83179f(r0, r7)
        Lab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ws.C13635i.m81996j(ws.i, java.lang.String):void");
    }

    /* renamed from: a */
    public final C13629c m81997a(String str) throws IOException {
        if (TextUtils.isEmpty(f61309e)) {
            C1016d.m6186f("TileStoreManager", "store dir is empty");
            return new C13629c(3, null);
        }
        if (TextUtils.isEmpty(f61313i)) {
            C1016d.m6186f("TileStoreManager", "Failed to get tile,currCityCode is empty");
            return new C13629c(3, null);
        }
        if (this.f61319d == null) {
            this.f61319d = m81993f(f61313i);
        }
        C13631e c13631e = this.f61319d;
        if (c13631e == null) {
            C1016d.m6186f("TileStoreManager", "Failed to get tile,cityInfo cache is null");
            String str2 = f61313i;
            synchronized (this) {
                C1016d.m6186f("TileStoreManager", "get cityInfo form cloud");
                C9540e.m59581d().m59582a(new a(str2));
            }
            return new C13629c(2, null);
        }
        C13628b c13628bM81992e = m81992e(str, c13631e.m81989a());
        if (c13628bM81992e == null) {
            C1016d.m6181a("TileStoreManager", "current location does not have tile info");
            return new C13629c(3, null);
        }
        String strM81986c = c13628bM81992e.m81986c();
        String str3 = f61312h;
        String strM83177d = C13859f.m83177d(str3, strM81986c);
        String strM81984a = c13628bM81992e.m81984a();
        String strM81985b = c13628bM81992e.m81985b();
        if (TextUtils.isEmpty(strM83177d)) {
            C1016d.m6181a("TileStoreManager", "get filePath from downloadUrl error");
            return new C13629c(3, null);
        }
        File file = new File(strM83177d);
        if (!file.exists()) {
            C1016d.m6186f("TileStoreManager", "tile zip file does not exist");
            if (C13855b.m83163b() >= this.f61316a) {
                C1016d.m6186f("TileStoreManager", "The maximum number of downloads per day is exceeded.");
            } else {
                C13855b.m83164c();
                C13859f.m83178e(this.f61317b, str3);
                C9540e.m59581d().m59582a(new RunnableC13632f(strM83177d, strM81986c, strM81984a, strM81985b));
            }
            return new C13629c(2, null);
        }
        String strM83182a = C13860g.m83182a(strM83177d, strM81984a);
        if (!TextUtils.isEmpty(strM83182a) && strM83182a.equals(strM81985b)) {
            C1016d.m6186f("TileStoreManager", "get tilePath success from the tileStore.");
            return new C13629c(1, strM83177d);
        }
        C1016d.m6186f("TileStoreManager", "The signature information is incorrect.");
        if (file.delete()) {
            C1016d.m6183c("TileStoreManager", "Failed to delete the file.");
        }
        if (C13855b.m83163b() >= this.f61316a) {
            C1016d.m6186f("TileStoreManager", "The maximum number of downloads per day is exceeded.");
        } else {
            C13855b.m83164c();
            C13859f.m83178e(this.f61317b, str3);
            C9540e.m59581d().m59582a(new RunnableC13632f(strM83177d, strM81986c, strM81984a, strM81985b));
        }
        return new C13629c(2, null);
    }

    /* renamed from: b */
    public final void m81998b(int i10) {
        if (i10 > 0) {
            this.f61316a = i10;
        } else {
            C1016d.m6186f("TileStoreManager", "tileDailyMaxNum is Invalid.");
        }
    }

    /* renamed from: c */
    public final synchronized void m81999c(String str) {
        C1016d.m6186f("TileStoreManager", "get cityInfo form cloud");
        C9540e.m59581d().m59582a(new a(str));
    }

    /* renamed from: h */
    public final void m82000h(int i10) {
        if (i10 > 0) {
            this.f61317b = i10;
        } else {
            C1016d.m6186f("TileStoreManager", "storeFileMaxNum is Invalid.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0237  */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m82001k(double r12, double r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 628
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ws.C13635i.m82001k(double, double):boolean");
    }
}
