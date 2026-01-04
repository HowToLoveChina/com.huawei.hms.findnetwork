package com.huawei.openalliance.p169ad.download;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6934f;
import com.huawei.openalliance.p169ad.beans.inner.DownloadBlockInfo;
import com.huawei.openalliance.p169ad.beans.inner.HttpConnection;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import java.util.concurrent.atomic.AtomicLong;

@DataKeep
/* loaded from: classes2.dex */
public class DownloadTask implements Comparable<DownloadTask> {

    @InterfaceC6934f
    private static final AtomicLong SEQ = new AtomicLong(0);
    private boolean allowedMobileNetowrk;
    private ContentResource contentResource;

    @InterfaceC6934f
    private DownloadBlockInfo downloadBlockInfo;
    private boolean downloadFromSafeUrl;
    private long downloadStartSize;
    private long downloadedSize;
    private long fileTotalSize;

    @InterfaceC6934f
    private HttpConnection httpConnection;

    /* renamed from: id */
    private int f32246id;
    private String localPath;
    private int priority;
    private int progress;
    private int redirectCount;
    private String redirectUrl;
    private String safeUrl;
    private String sha256;
    private String tmpLocalPath;
    private String url;

    @InterfaceC6934f
    private RunnableC7065h worker;

    @InterfaceC6934f
    private final byte[] lock = new byte[0];
    private boolean checkSha256 = true;

    @InterfaceC6934f
    private EnumC7062e status = EnumC7062e.IDLE;

    @InterfaceC6934f
    private EnumC7030b failedReason = EnumC7030b.NONE;

    @InterfaceC6934f
    private EnumC7031c pauseReason = EnumC7031c.NONE;

    @InterfaceC6934f
    private EnumC7029a downloadMode = EnumC7029a.DOWNLOAD_NOW;
    private boolean canceled = false;
    private final long seqNum = SEQ.getAndIncrement();

    /* renamed from: com.huawei.openalliance.ad.download.DownloadTask$a */
    public enum EnumC7029a {
        DOWNLOAD_NOW(0),
        WAITING_WIFI_DOWNLOAD(1);


        /* renamed from: c */
        private int f32250c;

        EnumC7029a(int i10) {
            this.f32250c = i10;
        }

        /* renamed from: a */
        public int m42095a() {
            return this.f32250c;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.DownloadTask$b */
    public enum EnumC7030b {
        NONE(0),
        CONN_FAILED(1),
        NO_SPACE(2),
        FILE_SIZE_ERROR(3),
        FILE_SHA256_ERROR(4),
        NO_NETWORK(5),
        MOBILE_NETWORK(6),
        USER_CANCEL(7);


        /* renamed from: i */
        int f32260i;

        EnumC7030b(int i10) {
            this.f32260i = i10;
        }

        /* renamed from: a */
        public int m42096a() {
            return this.f32260i;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.download.DownloadTask$c */
    public enum EnumC7031c {
        NONE(0),
        USER_CLICK(1),
        NETWORK_CHANGED(2),
        WAITING_WIFI_DOWNLOAD(3),
        HW_VIDEO(100);


        /* renamed from: f */
        private int f32267f;

        EnumC7031c(int i10) {
            this.f32267f = i10;
        }

        /* renamed from: a */
        public int m42098a() {
            return this.f32267f;
        }

        /* renamed from: a */
        public static EnumC7031c m42097a(int i10) {
            for (EnumC7031c enumC7031c : values()) {
                if (enumC7031c.m42098a() == i10) {
                    return enumC7031c;
                }
            }
            return NONE;
        }
    }

    /* renamed from: A */
    public ContentResource m42043A() {
        return this.contentResource;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return -1;
        }
        int i10 = downloadTask.priority - this.priority;
        if (i10 == 0) {
            return this.seqNum >= downloadTask.seqNum ? 1 : -1;
        }
        return i10;
    }

    /* renamed from: b */
    public String m42058b() {
        return this.safeUrl;
    }

    /* renamed from: c */
    public String m42063c() {
        return this.sha256;
    }

    /* renamed from: d */
    public String m42068d() {
        return this.localPath;
    }

    /* renamed from: e */
    public String m42071e() {
        return this.tmpLocalPath;
    }

    public boolean equals(Object obj) {
        if (obj != null) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof DownloadTask) && TextUtils.equals(mo42082n(), ((DownloadTask) obj).mo42082n())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public long m42073f() {
        return this.fileTotalSize;
    }

    /* renamed from: g */
    public long m42075g() {
        return this.downloadedSize;
    }

    /* renamed from: h */
    public EnumC7029a m42076h() {
        return this.downloadMode;
    }

    public int hashCode() {
        return mo42082n() != null ? mo42082n().hashCode() : super.hashCode();
    }

    /* renamed from: i */
    public EnumC7062e m42077i() {
        EnumC7062e enumC7062e;
        synchronized (this.lock) {
            enumC7062e = this.status;
        }
        return enumC7062e;
    }

    /* renamed from: j */
    public EnumC7030b m42078j() {
        return this.failedReason;
    }

    /* renamed from: k */
    public int m42079k() {
        return this.priority;
    }

    /* renamed from: l */
    public int m42080l() {
        return this.progress;
    }

    /* renamed from: m */
    public long m42081m() {
        return this.seqNum;
    }

    /* renamed from: n */
    public String mo42082n() {
        return m42045a();
    }

    /* renamed from: o */
    public boolean m42083o() {
        return this.allowedMobileNetowrk;
    }

    /* renamed from: p */
    public EnumC7031c m42084p() {
        return this.pauseReason;
    }

    /* renamed from: q */
    public boolean m42085q() {
        return this.canceled;
    }

    /* renamed from: r */
    public boolean m42086r() {
        return this.downloadFromSafeUrl;
    }

    /* renamed from: s */
    public String m42087s() {
        return this.redirectUrl;
    }

    /* renamed from: t */
    public int m42088t() {
        return this.redirectCount;
    }

    /* renamed from: u */
    public HttpConnection m42089u() {
        return this.httpConnection;
    }

    /* renamed from: v */
    public RunnableC7065h m42090v() {
        return this.worker;
    }

    /* renamed from: w */
    public void m42091w() {
        RunnableC7065h runnableC7065hM42090v = m42090v();
        if (runnableC7065hM42090v != null) {
            runnableC7065hM42090v.m42623a(this);
        }
    }

    /* renamed from: x */
    public DownloadBlockInfo m42092x() {
        return this.downloadBlockInfo;
    }

    /* renamed from: y */
    public void m42093y() {
        DownloadBlockInfo downloadBlockInfo = this.downloadBlockInfo;
        if (downloadBlockInfo == null) {
            return;
        }
        downloadBlockInfo.m39395a(this.downloadStartSize <= 0 && this.downloadedSize == this.fileTotalSize);
    }

    /* renamed from: z */
    public boolean m42094z() {
        return this.checkSha256;
    }

    /* renamed from: a */
    public String m42045a() {
        return this.url;
    }

    /* renamed from: b */
    public void m42059b(int i10) {
        this.progress = i10;
    }

    /* renamed from: c */
    public void m42064c(int i10) {
        this.redirectCount = i10;
    }

    /* renamed from: d */
    public void m42069d(String str) {
        this.localPath = str;
    }

    /* renamed from: e */
    public void m42072e(String str) {
        this.tmpLocalPath = str;
    }

    /* renamed from: f */
    public void m42074f(String str) {
        this.redirectUrl = str;
    }

    /* renamed from: a */
    public void m42046a(int i10) {
        this.priority = i10;
    }

    /* renamed from: b */
    public void m42060b(long j10) {
        this.downloadedSize = j10;
    }

    /* renamed from: c */
    public void m42065c(long j10) {
        this.downloadStartSize = j10;
    }

    /* renamed from: d */
    public void m42070d(boolean z10) {
        this.checkSha256 = z10;
    }

    /* renamed from: a */
    public void m42047a(long j10) {
        this.fileTotalSize = j10;
    }

    /* renamed from: b */
    public void m42061b(String str) {
        this.safeUrl = str;
    }

    /* renamed from: c */
    public void m42066c(String str) {
        this.sha256 = str;
    }

    /* renamed from: a */
    public void m42048a(DownloadBlockInfo downloadBlockInfo) {
        this.downloadBlockInfo = downloadBlockInfo;
    }

    /* renamed from: b */
    public void m42062b(boolean z10) {
        this.canceled = z10;
    }

    /* renamed from: c */
    public void m42067c(boolean z10) {
        this.downloadFromSafeUrl = z10;
    }

    /* renamed from: a */
    public void m42049a(HttpConnection httpConnection) {
        this.httpConnection = httpConnection;
    }

    /* renamed from: a */
    public void m42050a(ContentResource contentResource) {
        this.contentResource = contentResource;
    }

    /* renamed from: a */
    public void m42051a(EnumC7029a enumC7029a) {
        this.downloadMode = enumC7029a;
    }

    /* renamed from: a */
    public void m42052a(EnumC7030b enumC7030b) {
        this.failedReason = enumC7030b;
    }

    /* renamed from: a */
    public void m42053a(EnumC7031c enumC7031c) {
        this.pauseReason = enumC7031c;
    }

    /* renamed from: a */
    public void m42054a(EnumC7062e enumC7062e) {
        synchronized (this.lock) {
            this.status = enumC7062e;
        }
    }

    /* renamed from: a */
    public void m42055a(RunnableC7065h runnableC7065h) {
        this.worker = runnableC7065h;
    }

    /* renamed from: a */
    public void m42056a(String str) {
        this.url = str;
    }

    /* renamed from: a */
    public void m42057a(boolean z10) {
        this.allowedMobileNetowrk = z10;
    }
}
