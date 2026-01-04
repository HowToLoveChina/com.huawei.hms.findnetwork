package com.huawei.openalliance.p169ad.download.app;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.InterfaceC7615qq;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6934f;
import com.huawei.openalliance.p169ad.download.DownloadTask;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

@DataKeep
/* loaded from: classes2.dex */
public class AppDownloadTask extends DownloadTask {
    private static final String TAG = "AppDownloadTask";

    @InterfaceC6934f
    private String agVerifyCode;
    private Integer agdDownloadSource;
    private int apiVer;

    @InterfaceC6934f
    private AppInfo appInfo;
    private String apptaskInfo;
    private boolean autoOpenInLandingPage;
    private String contentId;
    private String curInstallWay;
    private String customData;
    private Integer downloadSource;
    private Integer downloadSourceMutable;

    @InterfaceC6934f
    private InterfaceC7615qq eventProcessor;
    private int installSource;

    @InterfaceC6934f
    private String installType;
    private boolean isTaskStarter;
    private String showId;
    private String slotId;

    @InterfaceC6934f
    private long startTime;
    private String templateId;
    private String userId;
    private String venusExt;

    @InterfaceC6934f
    private Queue<String> installWayQueue = new ConcurrentLinkedQueue();
    private int agRealFailedReason = 0;

    /* renamed from: com.huawei.openalliance.ad.download.app.AppDownloadTask$a */
    public static class C7040a {

        /* renamed from: a */
        private AppInfo f32333a;

        /* renamed from: b */
        private String f32334b;

        /* renamed from: c */
        private String f32335c;

        /* renamed from: d */
        private boolean f32336d;

        /* renamed from: e */
        private InterfaceC7615qq f32337e;

        /* renamed from: a */
        public C7040a m42265a(AppInfo appInfo) {
            this.f32333a = appInfo;
            return this;
        }

        /* renamed from: b */
        public C7040a m42270b(String str) {
            this.f32335c = str;
            return this;
        }

        /* renamed from: a */
        public C7040a m42266a(InterfaceC7615qq interfaceC7615qq) {
            this.f32337e = interfaceC7615qq;
            return this;
        }

        /* renamed from: a */
        public C7040a m42267a(String str) {
            this.f32334b = str;
            return this;
        }

        /* renamed from: a */
        public C7040a m42268a(boolean z10) {
            this.f32336d = z10;
            return this;
        }

        /* renamed from: a */
        public AppDownloadTask m42269a() {
            if (this.f32333a == null) {
                return null;
            }
            AppDownloadTask appDownloadTask = new AppDownloadTask();
            appDownloadTask.m42057a(this.f32336d);
            appDownloadTask.m42069d(this.f32334b);
            appDownloadTask.m42244a(this.f32337e);
            appDownloadTask.m42243a(this.f32333a);
            appDownloadTask.m42072e(this.f32335c);
            appDownloadTask.m42056a(this.f32333a.getDownloadUrl());
            appDownloadTask.m42061b(this.f32333a.getSafeDownloadUrl());
            appDownloadTask.m42066c(this.f32333a.getSha256());
            appDownloadTask.m42070d(this.f32333a.isCheckSha256());
            appDownloadTask.m42047a(this.f32333a.getFileSize());
            appDownloadTask.m42046a(0);
            appDownloadTask.m42218b(this.f32333a);
            return appDownloadTask;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.app.AppDownloadTask$b */
    public enum EnumC7041b {
        DOWN_LOAD_MODE_FROM_SELF,
        DOWN_LOAD_MODE_FROM_AG,
        DOWN_LOAD_MINI_FROM_AG,
        DOWN_LOAD_MODE_FROM_AG_SPECIFIED
    }

    /* renamed from: W */
    private boolean m42214W() {
        AppInfo appInfo = this.appInfo;
        return (appInfo == null || TextUtils.isEmpty(appInfo.getUniqueId()) || m42239S() == null || TextUtils.isEmpty(m42239S().m41478ab())) ? false : true;
    }

    /* renamed from: X */
    private boolean m42215X() {
        AppInfo appInfo = this.appInfo;
        if (appInfo == null) {
            return true;
        }
        if ("11".equals(appInfo.getPriorInstallWay())) {
            return false;
        }
        return TextUtils.isEmpty(this.appInfo.getPackageName()) || TextUtils.isEmpty(this.appInfo.getDownloadUrl()) || m42219c(this.appInfo) || this.appInfo.getFileSize() <= 0;
    }

    /* renamed from: Y */
    private boolean m42216Y() {
        Integer num;
        return this.installWayQueue.size() > 1 && ((num = this.agdDownloadSource) == null || num.intValue() == 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m42218b(AppInfo appInfo) {
        String strM44432v;
        if (appInfo == null) {
            return;
        }
        try {
            this.installWayQueue.clear();
            String strM44376b = appInfo.m44376b(this.downloadSource);
            if (!TextUtils.isEmpty(strM44376b)) {
                this.installWayQueue.offer(strM44376b);
            }
            strM44432v = appInfo.m44432v();
        } finally {
            try {
            } finally {
            }
        }
        if (TextUtils.isEmpty(strM44432v)) {
            return;
        }
        String[] strArrSplit = strM44432v.split(",");
        if (strArrSplit.length > 0) {
            for (String str : strArrSplit) {
                if (m42221s(str) || m42220r(str) || !m42215X()) {
                    this.installWayQueue.offer(str);
                }
            }
        }
    }

    /* renamed from: r */
    private boolean m42220r(String str) {
        AppInfo appInfo;
        return (!"7".equals(str) || (appInfo = this.appInfo) == null || TextUtils.isEmpty(appInfo.m44428t())) ? false : true;
    }

    /* renamed from: s */
    private boolean m42221s(String str) {
        return !TextUtils.isEmpty(str) && (str.equals("8") || str.equals("6") || str.equals("5"));
    }

    /* renamed from: B */
    public AppInfo m42222B() {
        AppInfo appInfo;
        String string;
        AppInfo appInfo2 = this.appInfo;
        if (appInfo2 != null && TextUtils.isEmpty(appInfo2.getUniqueId())) {
            if (m42239S() == null || TextUtils.isEmpty(m42239S().m41478ab())) {
                appInfo = this.appInfo;
                string = UUID.randomUUID().toString();
            } else {
                appInfo = this.appInfo;
                string = m42239S().m41478ab();
            }
            appInfo.m44433v(string);
        }
        if (m42214W() && !this.appInfo.getUniqueId().equals(m42239S().m41478ab())) {
            this.appInfo.m44433v(m42239S().m41478ab());
        }
        return this.appInfo;
    }

    /* renamed from: C */
    public InterfaceC7615qq m42223C() {
        return this.eventProcessor;
    }

    /* renamed from: D */
    public int m42224D() {
        return this.installSource;
    }

    /* renamed from: E */
    public String m42225E() {
        String strM42228H = m42228H();
        if (!TextUtils.isEmpty(strM42228H)) {
            return strM42228H;
        }
        AppInfo appInfo = this.appInfo;
        return appInfo != null ? appInfo.m44376b(this.downloadSource) : "4";
    }

    /* renamed from: F */
    public Integer m42226F() {
        return this.downloadSource;
    }

    /* renamed from: G */
    public String m42227G() {
        return this.venusExt;
    }

    /* renamed from: H */
    public String m42228H() {
        return this.curInstallWay;
    }

    /* renamed from: I */
    public boolean m42229I() {
        return "7".equals(m42225E());
    }

    /* renamed from: J */
    public boolean m42230J() {
        boolean z10 = false;
        if (!m42216Y()) {
            return false;
        }
        if (this.installWayQueue.poll() != null && !this.installWayQueue.isEmpty()) {
            z10 = true;
        }
        m42257j(this.installWayQueue.peek());
        return z10;
    }

    /* renamed from: K */
    public boolean m42231K() {
        AppInfo appInfo = this.appInfo;
        return (appInfo == null || TextUtils.isEmpty(appInfo.getPackageName()) || !m42221s(m42225E())) ? false : true;
    }

    /* renamed from: L */
    public EnumC7041b m42232L() {
        String strM42225E = m42225E();
        return (this.appInfo == null || !"5".equals(strM42225E)) ? (this.appInfo == null || !"6".equals(strM42225E)) ? (this.appInfo == null || !"8".equals(strM42225E)) ? EnumC7041b.DOWN_LOAD_MODE_FROM_SELF : EnumC7041b.DOWN_LOAD_MODE_FROM_AG_SPECIFIED : EnumC7041b.DOWN_LOAD_MINI_FROM_AG : EnumC7041b.DOWN_LOAD_MODE_FROM_AG;
    }

    /* renamed from: M */
    public String m42233M() {
        return this.slotId;
    }

    /* renamed from: N */
    public String m42234N() {
        return this.apptaskInfo;
    }

    /* renamed from: O */
    public String m42235O() {
        return this.showId;
    }

    /* renamed from: P */
    public String m42236P() {
        return this.agVerifyCode;
    }

    /* renamed from: Q */
    public String m42237Q() {
        return this.installType;
    }

    /* renamed from: R */
    public long m42238R() {
        return this.startTime;
    }

    /* renamed from: S */
    public ContentRecord m42239S() {
        InterfaceC7615qq interfaceC7615qq = this.eventProcessor;
        if (interfaceC7615qq != null) {
            return interfaceC7615qq.mo46574a();
        }
        return null;
    }

    /* renamed from: T */
    public int m42240T() {
        return this.agRealFailedReason;
    }

    /* renamed from: U */
    public boolean m42241U() {
        return this.isTaskStarter;
    }

    /* renamed from: V */
    public boolean m42242V() {
        return this.autoOpenInLandingPage;
    }

    /* renamed from: c */
    public void m42247c(Integer num) {
        this.agdDownloadSource = num;
    }

    /* renamed from: d */
    public void m42248d(int i10) {
        this.installSource = i10;
    }

    /* renamed from: e */
    public void m42250e(int i10) {
        this.apiVer = i10;
    }

    @Override // com.huawei.openalliance.p169ad.download.DownloadTask
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* renamed from: f */
    public void m42252f(int i10) {
        this.agRealFailedReason = i10;
    }

    /* renamed from: g */
    public void m42254g(String str) {
        this.customData = str;
    }

    /* renamed from: h */
    public void m42255h(String str) {
        this.userId = str;
    }

    @Override // com.huawei.openalliance.p169ad.download.DownloadTask
    public int hashCode() {
        return super.hashCode();
    }

    /* renamed from: i */
    public void m42256i(String str) {
        if (TextUtils.isEmpty(this.venusExt)) {
            this.venusExt = str;
        }
    }

    /* renamed from: j */
    public void m42257j(String str) {
        this.curInstallWay = str;
    }

    /* renamed from: k */
    public void m42258k(String str) {
        this.slotId = str;
    }

    /* renamed from: l */
    public void m42259l(String str) {
        this.apptaskInfo = str;
    }

    /* renamed from: m */
    public void m42260m(String str) {
        this.contentId = str;
    }

    @Override // com.huawei.openalliance.p169ad.download.DownloadTask
    /* renamed from: n */
    public String mo42082n() {
        AppInfo appInfo = this.appInfo;
        if (appInfo != null) {
            return appInfo.getPackageName();
        }
        return null;
    }

    /* renamed from: o */
    public void m42262o(String str) {
        this.agVerifyCode = str;
    }

    /* renamed from: p */
    public void m42263p(String str) {
        this.installType = str;
    }

    /* renamed from: q */
    public void m42264q(String str) {
        this.templateId = str;
    }

    /* renamed from: c */
    private boolean m42219c(AppInfo appInfo) {
        if (appInfo == null) {
            return true;
        }
        return appInfo.isCheckSha256() && TextUtils.isEmpty(appInfo.getSha256());
    }

    /* renamed from: a */
    public void m42243a(AppInfo appInfo) {
        this.appInfo = appInfo;
    }

    /* renamed from: b */
    public void m42246b(Integer num) {
        this.downloadSourceMutable = num;
    }

    /* renamed from: d */
    public void m42249d(long j10) {
        this.startTime = j10;
    }

    /* renamed from: e */
    public void m42251e(boolean z10) {
        this.isTaskStarter = z10;
    }

    /* renamed from: f */
    public void m42253f(boolean z10) {
        this.autoOpenInLandingPage = z10;
    }

    /* renamed from: n */
    public void m42261n(String str) {
        this.showId = str;
    }

    /* renamed from: a */
    public void m42244a(InterfaceC7615qq interfaceC7615qq) {
        this.eventProcessor = interfaceC7615qq;
    }

    /* renamed from: a */
    public void m42245a(Integer num) {
        if (this.downloadSource == null) {
            this.downloadSource = num;
        }
        this.downloadSourceMutable = num;
    }
}
