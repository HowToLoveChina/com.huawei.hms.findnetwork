package p390ja;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import bb.C1160a;
import ck.C1443a;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.PmsMetaDBScript;
import com.huawei.android.hicloud.drive.clouddisk.asset.AssetDownloaderProgressListener;
import com.huawei.android.hicloud.drive.clouddisk.asset.AssetMetadataTransport;
import com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk.InputSource;
import com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk.SeekableInput;
import com.huawei.android.hicloud.drive.clouddisk.expand.DriveExpand;
import com.huawei.android.hicloud.drive.clouddisk.expand.SyncDriveRequest;
import com.huawei.android.hicloud.drive.clouddisk.expand.p085db.Status;
import com.huawei.android.hicloud.drive.clouddisk.model.Asset;
import com.huawei.android.hicloud.drive.clouddisk.model.Digest;
import com.huawei.android.hicloud.drive.clouddisk.model.DownloadBuilder;
import com.huawei.android.hicloud.drive.clouddisk.model.Layer;
import com.huawei.android.hicloud.drive.clouddisk.model.Resource;
import com.huawei.android.hicloud.drive.clouddisk.model.SliceObject;
import com.huawei.android.hicloud.security.bean.UserKeyObject;
import com.huawei.cloud.base.http.C4602e;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4611n;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.cloud.base.util.C4626a;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.services.drive.Drive;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.hicloud.base.drive.model.EndpointUrl;
import com.huawei.hicloud.base.drive.model.KeyChain;
import com.huawei.hicloud.base.slice.Slice;
import com.huawei.hicloud.base.slice.SliceEnumeration;
import com.huawei.hicloud.base.slice.SliceItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.network.file.api.Progress;
import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.api.Response;
import com.huawei.hms.network.file.api.exception.NetWorkErrorException;
import com.huawei.hms.network.file.api.exception.NetworkException;
import com.huawei.hms.network.file.api.exception.ServerException;
import com.huawei.hms.network.file.download.api.DownloadManager;
import com.huawei.hms.network.file.download.api.FileRequestCallback;
import com.huawei.hms.network.file.download.api.GetRequest;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import ma.C11434a;
import na.C11655a;
import na.C11656b;
import na.C11659e;
import na.C11660f;
import p015ak.C0209d;
import p363ia.C10463a;
import p423ka.C11022b;
import p423ka.C11023c;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p652t9.EnumC12999a;
import p653ta.C13000a;
import p653ta.C13001b;
import p767x9.C13735d;
import ua.C13142a;
import za.C14164a;
import za.C14165b;

/* renamed from: ja.j */
/* loaded from: classes3.dex */
public class C10756j extends AbstractC10747a {

    /* renamed from: R */
    public static final Object f51399R = new Object();

    /* renamed from: S */
    public static final Object f51400S = new Object();

    /* renamed from: A */
    public UserKeyObject f51401A;

    /* renamed from: B */
    public UserKeyObject f51402B;

    /* renamed from: C */
    public boolean f51403C;

    /* renamed from: D */
    public boolean f51404D;

    /* renamed from: F */
    public C10766t f51406F;

    /* renamed from: G */
    public long f51407G;

    /* renamed from: H */
    public long f51408H;

    /* renamed from: I */
    public long f51409I;

    /* renamed from: J */
    public long f51410J;

    /* renamed from: K */
    public long f51411K;

    /* renamed from: L */
    public long f51412L;

    /* renamed from: M */
    public long f51413M;

    /* renamed from: N */
    public AssetDownloaderProgressListener f51414N;

    /* renamed from: P */
    public C11060c f51416P;

    /* renamed from: Q */
    public boolean f51417Q;

    /* renamed from: c */
    public C4602e f51419c;

    /* renamed from: d */
    public C4602e f51420d;

    /* renamed from: h */
    public Asset f51424h;

    /* renamed from: j */
    public String f51426j;

    /* renamed from: l */
    public byte[] f51428l;

    /* renamed from: m */
    public byte[] f51429m;

    /* renamed from: n */
    public CountDownLatch f51430n;

    /* renamed from: o */
    public DownloadBuilder f51431o;

    /* renamed from: t */
    public long f51436t;

    /* renamed from: y */
    public AssetMetadataTransport f51441y;

    /* renamed from: e */
    public Digest f51421e = null;

    /* renamed from: f */
    public Digest f51422f = null;

    /* renamed from: i */
    public int f51425i = 0;

    /* renamed from: k */
    public boolean f51427k = false;

    /* renamed from: p */
    public List<DownloadBuilder> f51432p = new ArrayList();

    /* renamed from: q */
    public List<Long> f51433q = new ArrayList();

    /* renamed from: r */
    public List<SliceItem<SliceObject>> f51434r = new ArrayList();

    /* renamed from: s */
    public List<List<SliceItem<SliceObject>>> f51435s = new ArrayList();

    /* renamed from: u */
    public Map<String, Long> f51437u = new HashMap();

    /* renamed from: v */
    public long f51438v = 0;

    /* renamed from: w */
    public C9721b f51439w = null;

    /* renamed from: x */
    public File f51440x = m65473a();

    /* renamed from: z */
    public List<C11656b> f51442z = new ArrayList();

    /* renamed from: E */
    public List<C11659e> f51405E = new ArrayList();

    /* renamed from: O */
    public d f51415O = d.NOT_STARTED;

    /* renamed from: g */
    public SQLiteDatabase f51423g = C11022b.m66460b();

    /* renamed from: b */
    public EnumC12999a f51418b = EnumC12999a.CLOUD_DISK_BITMAP;

    /* renamed from: ja.j$a */
    public class a implements SeekableInput {

        /* renamed from: a */
        public long f51443a;

        /* renamed from: b */
        public C11659e f51444b;

        /* renamed from: c */
        public final /* synthetic */ int f51445c;

        /* renamed from: d */
        public final /* synthetic */ List f51446d;

        public a(int i10, List list) {
            this.f51445c = i10;
            this.f51446d = list;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            C11659e c11659e = this.f51444b;
            if (c11659e != null) {
                c11659e.m69624c();
            }
            this.f51446d.add(this.f51444b);
        }

        @Override // com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk.SeekableInput
        public void read(byte[] bArr, int i10, int i11) {
            C11659e c11659e = this.f51444b;
            if (c11659e != null) {
                c11659e.m69630k(this.f51443a, i11);
            }
        }

        @Override // com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk.SeekableInput
        public void seek(long j10) throws IOException {
            this.f51443a = j10;
            if (this.f51444b == null) {
                Layer layerM65528Z = C10756j.this.m65528Z(this.f51445c);
                this.f51444b = new C11659e(layerM65528Z.getObjects(), layerM65528Z.getSliceSize().intValue(), layerM65528Z.getLength().longValue(), this.f51445c);
            }
        }
    }

    /* renamed from: ja.j$b */
    public class b implements SeekableInput {

        /* renamed from: a */
        public long f51448a;

        /* renamed from: b */
        public C11659e f51449b;

        /* renamed from: c */
        public Map<String, RandomAccessFile> f51450c = new HashMap();

        /* renamed from: d */
        public byte[] f51451d = null;

        /* renamed from: e */
        public String f51452e = "";

        /* renamed from: f */
        public final /* synthetic */ int f51453f;

        public b(int i10) {
            this.f51453f = i10;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f51451d = null;
            this.f51452e = "";
            Iterator<Map.Entry<String, RandomAccessFile>> it = this.f51450c.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    it.next().getValue().close();
                } catch (IOException e10) {
                    C11839m.m70687e("AssetDownloader", "close RandomAccessFile:" + e10.toString());
                }
            }
        }

        @Override // com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk.SeekableInput
        public void read(byte[] bArr, int i10, int i11) throws Throwable {
            int iMin;
            int i12;
            byte[] bArr2;
            String str;
            int i13;
            RandomAccessFile randomAccessFile;
            C11659e c11659e = this.f51449b;
            if (c11659e == null) {
                return;
            }
            try {
                int i14 = i11;
                List<C11660f> listM69631l = c11659e.m69631l(this.f51448a, i14);
                int i15 = 0;
                for (int i16 = 0; i16 < listM69631l.size(); i16 = i12 + 1) {
                    int iM69629h = (int) (this.f51448a / this.f51449b.m69629h());
                    long jM69629h = this.f51448a - (this.f51449b.m69629h() * iM69629h);
                    C11660f c11660f = listM69631l.get(i16);
                    if (c11660f.m69637f() == iM69629h && (iMin = (int) Math.min(this.f51449b.m69629h() - jM69629h, i14)) > 0) {
                        byte[] bArr3 = new byte[iMin];
                        byte[] bArr4 = this.f51451d;
                        File fileM69615h = c11660f.m69636e().m69615h();
                        if (fileM69615h.getName().equals(this.f51452e)) {
                            i12 = i16;
                            bArr2 = bArr4;
                        } else {
                            RandomAccessFile randomAccessFile2 = null;
                            try {
                                try {
                                    if (this.f51450c.containsKey(fileM69615h.getName())) {
                                        randomAccessFile = this.f51450c.get(fileM69615h.getName());
                                    } else {
                                        randomAccessFile = new RandomAccessFile(fileM69615h, "r");
                                        try {
                                            this.f51450c.put(fileM69615h.getName(), randomAccessFile);
                                        } catch (Exception e10) {
                                            e = e10;
                                            randomAccessFile2 = randomAccessFile;
                                            C11839m.m70687e("AssetDownloader", "AesUtils read:" + e.toString());
                                            throw e;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            randomAccessFile2 = randomAccessFile;
                                            if (randomAccessFile2 != null) {
                                                randomAccessFile2.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    RandomAccessFile randomAccessFile3 = randomAccessFile;
                                    byte[] bArr5 = new byte[(int) randomAccessFile3.length()];
                                    i12 = i16;
                                    randomAccessFile3.seek(0L);
                                    C11839m.m70686d("AssetDownloader", "openCloudFile " + fileM69615h.getName() + " read: " + randomAccessFile3.read(bArr5));
                                    randomAccessFile3.close();
                                    this.f51452e = fileM69615h.getName();
                                    this.f51451d = bArr5;
                                    bArr2 = bArr5;
                                } catch (Exception e11) {
                                    e = e11;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        try {
                            i13 = (int) jM69629h;
                            str = "AssetDownloader";
                        } catch (RuntimeException e12) {
                            e = e12;
                            str = "AssetDownloader";
                        }
                        try {
                            C11434a.m68488a(bArr2, c11660f.m69639h().getPlainLength().intValue(), C10756j.this.f51428l, C10756j.this.f51429m, i13, bArr3, 0, iMin);
                            System.arraycopy(bArr3, 0, bArr, i10 + i15, iMin);
                            i14 -= iMin;
                            this.f51448a += iMin;
                            i15 += iMin;
                        } catch (RuntimeException e13) {
                            e = e13;
                            C11839m.m70687e(str, "AesUtils decrypt:" + e.toString());
                            throw e;
                        }
                    } else {
                        i12 = i16;
                    }
                }
            } catch (Exception e14) {
                throw new IOException(e14);
            }
        }

        @Override // com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk.SeekableInput
        public void seek(long j10) throws IOException {
            this.f51448a = j10;
            if (this.f51449b == null) {
                for (int i10 = 0; i10 < C10756j.this.f51405E.size(); i10++) {
                    if (((C11659e) C10756j.this.f51405E.get(i10)).m69627f() == this.f51453f) {
                        this.f51449b = (C11659e) C10756j.this.f51405E.get(i10);
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: ja.j$c */
    public class c extends AbstractRunnableC12516b {

        /* renamed from: a */
        public DownloadBuilder f51455a;

        /* renamed from: b */
        public CountDownLatch f51456b;

        public c(DownloadBuilder downloadBuilder, CountDownLatch countDownLatch) {
            this.f51455a = downloadBuilder;
            this.f51456b = countDownLatch;
        }

        /* renamed from: c */
        public final void m65552c(Closeable closeable) throws IOException {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e10) {
                    C11839m.m70689w("AssetDownloader", "close error: " + e10);
                }
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            StringBuilder sb2;
            C11839m.m70688i("AssetDownloader", "CopySliceTask begin：" + this.f51455a.getUuid());
            if (C10756j.this.f51427k || C10756j.this.f51439w != null) {
                this.f51456b.countDown();
                C11839m.m70689w("AssetDownloader", "copy end as cancel or exception");
                return;
            }
            File file = new File(C10756j.this.f51440x, this.f51455a.getUuid());
            try {
                try {
                    C10756j.this.m65534f0();
                    m65553d(C10756j.this.f51419c.m28187f(), file, this.f51455a.getOffset());
                } catch (C9721b e10) {
                    String string = e10.toString();
                    C11839m.m70687e("AssetDownloader", "copy file error: " + string);
                    if (!TextUtils.isEmpty(string) && string.contains("ENOSPC")) {
                        C11839m.m70689w("AssetDownloader", "copy file has no enough space.");
                        C10756j.this.m65523U(new C9721b(1007, e10.toString(), "Download"));
                        if (file.exists()) {
                            C11839m.m70686d("AssetDownloader", "copy file exits, delete = " + file.delete());
                        }
                        this.f51456b.countDown();
                        return;
                    }
                    C10756j.this.m65523U(e10);
                    if (file.exists()) {
                        sb2 = new StringBuilder();
                    }
                } catch (Exception e11) {
                    C11839m.m70687e("AssetDownloader", "copy file exception error: " + e11.toString());
                    if (file.exists()) {
                        sb2 = new StringBuilder();
                    }
                }
                if (file.exists()) {
                    sb2 = new StringBuilder();
                    sb2.append("copy file exits, delete = ");
                    sb2.append(file.delete());
                    C11839m.m70686d("AssetDownloader", sb2.toString());
                }
                this.f51456b.countDown();
            } catch (Throwable th2) {
                if (file.exists()) {
                    C11839m.m70686d("AssetDownloader", "copy file exits, delete = " + file.delete());
                }
                this.f51456b.countDown();
                throw th2;
            }
        }

        /* renamed from: d */
        public void m65553d(File file, File file2, long j10) throws Throwable {
            RandomAccessFile randomAccessFile;
            FileInputStream fileInputStream;
            long length = file2.length();
            if (length > 1024000) {
                length = 1024000;
            }
            byte[] bArr = new byte[(int) length];
            Closeable closeable = null;
            try {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    C11839m.m70689w("AssetDownloader", "copySliceFile mkdirs = " + parentFile.mkdirs());
                }
                fileInputStream = new FileInputStream(file2);
                try {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (IOException e10) {
                    e = e10;
                    randomAccessFile = null;
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = null;
                }
            } catch (IOException e11) {
                e = e11;
                randomAccessFile = null;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
            }
            try {
                randomAccessFile.seek(j10);
                while (true) {
                    int i10 = fileInputStream.read(bArr);
                    if (i10 == -1) {
                        m65552c(fileInputStream);
                        m65552c(randomAccessFile);
                        return;
                    }
                    randomAccessFile.write(bArr, 0, i10);
                }
            } catch (IOException e12) {
                e = e12;
                closeable = fileInputStream;
                try {
                    throw new C9721b(4005, "copy slice file error: " + e.getMessage());
                } catch (Throwable th4) {
                    th = th4;
                    m65552c(closeable);
                    m65552c(randomAccessFile);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                closeable = fileInputStream;
                m65552c(closeable);
                m65552c(randomAccessFile);
                throw th;
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.DRIVE;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void release() {
            C12515a.m75110o().m75165a1(this);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public boolean syncLock() {
            return false;
        }
    }

    /* renamed from: ja.j$d */
    public enum d {
        NOT_STARTED,
        OBJECTS_DOWNLOAD_START,
        INIT_USER_KEY,
        OBJECTS_DOWNLOAD_DECRYPT,
        DOWNLOAD_COMPLETED
    }

    /* renamed from: ja.j$e */
    public class e extends AbstractRunnableC12516b {

        /* renamed from: a */
        public DownloadBuilder f51464a;

        /* renamed from: b */
        public CountDownLatch f51465b;

        public e(DownloadBuilder downloadBuilder, CountDownLatch countDownLatch) {
            this.f51464a = downloadBuilder;
            this.f51465b = countDownLatch;
        }

        /* renamed from: c */
        private void m65554c(File file) throws Throwable {
            try {
                C11839m.m70688i("AssetDownloader", "retryDecrypt start.");
                if (TextUtils.isEmpty(C10756j.this.f51426j)) {
                    C11839m.m70688i("AssetDownloader", "retryDecrypt fileid is null.");
                    return;
                }
                DriveExpand driveExpandM64282d = C10463a.m64279e().m64282d();
                if (driveExpandM64282d == null) {
                    C11839m.m70689w("AssetDownloader", "retryDecrypt drive null");
                    return;
                }
                Drive.Files.Get get = driveExpandM64282d.files().get(C10756j.this.f51426j);
                get.setFields2("id,size,sha256,md5");
                if (C10756j.this.f51417Q) {
                    C4609l headers = get.getHeaders();
                    headers.set("x-hw-open-app-id", C13142a.f59637b);
                    get.setHeaders(headers);
                }
                Object obj = ((com.huawei.cloud.services.drive.model.File) new SyncDriveRequest(get).execute()).get("md5");
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (!TextUtils.isEmpty(str)) {
                        C14165b.m85029b(C10756j.this.f51419c.m28187f(), file, this.f51464a.getOffset(), C14165b.m85032e(str), C14165b.m85034g(str));
                        C11839m.m70688i("AssetDownloader", "fileMd5 retryDecrypt success.");
                    }
                }
                C11839m.m70687e("AssetDownloader", "retry decrypt success.");
            } catch (C9721b e10) {
                C11839m.m70687e("AssetDownloader", "retry decrypt file error: " + e10.toString());
                C10756j.this.m65523U(e10);
            } catch (Exception e11) {
                C11839m.m70687e("AssetDownloader", "retry decrypt file exception error: " + e11.toString());
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            StringBuilder sb2;
            C11839m.m70688i("AssetDownloader", "decrypt begin：" + this.f51464a.getUuid());
            if (C10756j.this.f51427k || C10756j.this.f51439w != null) {
                this.f51465b.countDown();
                C11839m.m70689w("AssetDownloader", "decrypt end as cancel or exception");
                return;
            }
            File file = new File(C10756j.this.f51440x, this.f51464a.getUuid());
            try {
                try {
                    C10756j.this.m65534f0();
                    C14165b.m85029b(C10756j.this.f51419c.m28187f(), file, this.f51464a.getOffset(), C10756j.this.f51428l, C10756j.this.f51429m);
                } catch (C9721b e10) {
                    String string = e10.toString();
                    C11839m.m70687e("AssetDownloader", "decrypt file error: " + string);
                    if (!TextUtils.isEmpty(string) && string.contains("ENOSPC")) {
                        C11839m.m70689w("AssetDownloader", "decrypt file has no enough space.");
                        C10756j.this.m65523U(new C9721b(1007, e10.toString(), "Download"));
                        if (file.exists()) {
                            C11839m.m70686d("AssetDownloader", "decrypt file exits, delete = " + file.delete());
                        }
                        this.f51465b.countDown();
                        return;
                    }
                    if (e10.m60659c() == 4005) {
                        m65554c(file);
                    } else {
                        C10756j.this.m65523U(e10);
                    }
                    if (file.exists()) {
                        sb2 = new StringBuilder();
                    }
                } catch (Exception e11) {
                    C11839m.m70687e("AssetDownloader", "decrypt file exception error: " + e11.toString());
                    if (file.exists()) {
                        sb2 = new StringBuilder();
                    }
                }
                if (file.exists()) {
                    sb2 = new StringBuilder();
                    sb2.append("decrypt file exits, delete = ");
                    sb2.append(file.delete());
                    C11839m.m70686d("AssetDownloader", sb2.toString());
                }
                this.f51465b.countDown();
            } catch (Throwable th2) {
                if (file.exists()) {
                    C11839m.m70686d("AssetDownloader", "decrypt file exits, delete = " + file.delete());
                }
                this.f51465b.countDown();
                throw th2;
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.DRIVE;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void release() {
            C12515a.m75110o().m75165a1(this);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public boolean syncLock() {
            return false;
        }
    }

    /* renamed from: ja.j$f */
    public class f extends FileRequestCallback {

        /* renamed from: a */
        public DownloadBuilder f51467a;

        /* renamed from: b */
        public CountDownLatch f51468b;

        /* renamed from: c */
        public int f51469c;

        /* renamed from: d */
        public EndpointUrl f51470d;

        /* renamed from: e */
        public C11656b f51471e;

        public f(DownloadBuilder downloadBuilder, EndpointUrl endpointUrl, CountDownLatch countDownLatch, int i10) {
            this.f51467a = downloadBuilder;
            this.f51468b = countDownLatch;
            this.f51469c = i10;
            this.f51470d = endpointUrl;
        }

        private void release() {
            CountDownLatch countDownLatch = this.f51468b;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        /* renamed from: a */
        public boolean m65555a(NetworkException networkException, int i10) {
            return C10756j.this.f51403C ? i10 < 3 && ((networkException instanceof ServerException) || (networkException instanceof NetWorkErrorException)) : i10 < 1 && (networkException instanceof ServerException);
        }

        /* renamed from: b */
        public final void m65556b(Map<String, List<String>> map, File file) throws Throwable {
            InputStream bufferedInputStream;
            C11839m.m70686d("AssetDownloader", "parseDownloadFile");
            InputStream inputStream = null;
            try {
                File fileM1279m = C0209d.m1279m(C10756j.this.f51440x + "/" + UUID.randomUUID().toString());
                RandomAccessFile randomAccessFile = new RandomAccessFile(fileM1279m, "rw");
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                    try {
                        C4611n c4611nM65561c = C10757k.m65561c(map);
                        if (c4611nM65561c == null || !c4611nM65561c.m28254g().equals("multipart")) {
                            long jM65562d = C10757k.m65562d(map);
                            byte[] bArr = new byte[ARImageMetadata.SHADING_MODE];
                            randomAccessFile.seek(jM65562d);
                            while (true) {
                                int i10 = fileInputStream.read(bArr);
                                if (i10 == -1) {
                                    break;
                                } else {
                                    randomAccessFile.write(bArr, 0, i10);
                                }
                            }
                        } else {
                            C11655a c11655a = new C11655a(bufferedInputStream, "--" + c4611nM65561c.m28252e("boundary"), randomAccessFile);
                            while (c11655a.f54069c) {
                                c11655a.m69605b();
                            }
                        }
                        if (fileM1279m.renameTo(file)) {
                            this.f51471e.m69619l(file);
                            m65558d(fileInputStream);
                            m65558d(bufferedInputStream);
                        } else {
                            C11839m.m70687e("AssetDownloader", "response parse renameTo error " + fileM1279m.getName());
                            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "parseDownloadFile rename error");
                        }
                    } catch (IOException e10) {
                        e = e10;
                        inputStream = fileInputStream;
                        try {
                            C11839m.m70686d("AssetDownloader", "parse success download file exception:" + e.toString());
                            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, e.toString());
                        } catch (Throwable th2) {
                            th = th2;
                            m65558d(inputStream);
                            m65558d(bufferedInputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = fileInputStream;
                        m65558d(inputStream);
                        m65558d(bufferedInputStream);
                        throw th;
                    }
                } catch (IOException e11) {
                    e = e11;
                    bufferedInputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedInputStream = null;
                }
            } catch (IOException e12) {
                e = e12;
                bufferedInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedInputStream = null;
            }
        }

        /* renamed from: c */
        public final void m65557c(GetRequest getRequest) throws C9721b {
            Object obj;
            C11839m.m70686d("AssetDownloader", "retryDownload");
            EndpointUrl endpointUrl = this.f51470d;
            C10756j.this.m65527Y((endpointUrl == null || (obj = endpointUrl.get("client_endpointVersion")) == null) ? 0 : ((Integer) obj).intValue());
            EndpointUrl endpointUrlM65525W = C10756j.this.m65525W(this.f51467a.getObject(), C10756j.this.f51424h);
            if (endpointUrlM65525W == null) {
                throw new C9721b(4309, this.f51467a.getObject() + " has no endpointUrl");
            }
            this.f51470d = endpointUrlM65525W;
            if (C10756j.this.f51403C) {
                this.f51470d.getHeaders().put("range", this.f51471e.m69613f());
            }
            C10756j.this.f51433q.add(Long.valueOf(C13735d.m82531s().m82541k(C10756j.this.f51418b, DownloadManager.newGetRequestBuilder().filePath(C10756j.this.f51440x + "/" + this.f51467a.getUuid()).offset(getRequest.getOffset()).name(this.f51467a.getUuid()).config(C13735d.m82528e()).url(endpointUrlM65525W.getUrl()).headers(endpointUrlM65525W.getHeaders()).enableSlice(false), -1L, this).getId()));
        }

        /* renamed from: d */
        public final void m65558d(InputStream inputStream) throws IOException {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e10) {
                    C11839m.m70687e("AssetDownloader", "safeClose exceptions:" + e10.toString());
                }
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public /* bridge */ /* synthetic */ void onException(Request request, NetworkException networkException, Response response) {
            onException((GetRequest) request, networkException, (Response<GetRequest, File, Closeable>) response);
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onSuccess(Response<GetRequest, File, Closeable> response) {
            int status;
            Status status2;
            C11839m.m70688i("AssetDownloader", "taskId [" + ((GetRequest) response.getRequest()).getId() + "]slice object [" + this.f51467a.getObject() + "] cache [" + this.f51467a.getUuid() + "] download end.");
            try {
                try {
                    C10756j.this.m65534f0();
                    status = this.f51467a.getStatus();
                    status2 = Status.SUCCESS;
                } catch (C9721b e10) {
                    C11839m.m70687e("AssetDownloader", "taskId [" + ((GetRequest) response.getRequest()).getId() + "]slice object [" + this.f51467a.getObject() + "] cache [" + this.f51467a.getUuid() + "] download error." + e10);
                    C10756j.this.m65523U(e10);
                }
                if (status == status2.value()) {
                    C11839m.m70688i("AssetDownloader", "has already success");
                    return;
                }
                if (C10756j.this.f51403C) {
                    m65556b(response.getResponseHeader(), response.getContent());
                }
                new C11023c(this.f51467a.setStatus(status2.value())).m66463c(C10756j.this.f51423g);
                C11839m.m70688i("AssetDownloader", "taskId [" + ((GetRequest) response.getRequest()).getId() + "]slice object [" + this.f51467a.getObject() + "] cache [" + this.f51467a.getUuid() + "] download success");
            } finally {
                release();
            }
        }

        public void onException(GetRequest getRequest, NetworkException networkException, Response<GetRequest, File, Closeable> response) {
            C11839m.m70687e("AssetDownloader", "taskId [" + getRequest.getId() + "]slice object [" + this.f51467a.getObject() + "] cache [" + this.f51467a.getUuid() + "] download error. " + networkException.toString());
            if (this.f51467a.getStatus() == Status.SUCCESS.value()) {
                release();
                return;
            }
            int iM1331z = C0209d.m1331z(networkException.getMessage());
            C11839m.m70687e("AssetDownloader", "error code is : " + iM1331z);
            if (m65555a(networkException, this.f51469c)) {
                C11839m.m70688i("AssetDownloader", "taskId [" + getRequest.getId() + "]slice object [" + this.f51467a.getObject() + "] cache [" + this.f51467a.getUuid() + " retry again:" + this.f51469c);
                try {
                    m65557c(getRequest);
                    this.f51469c++;
                    return;
                } catch (Exception unused) {
                    C10756j.this.m65523U(new C9721b(4307, networkException.toString(), "Download"));
                }
            } else if (iM1331z == 10043005) {
                C10756j.this.m65523U(new C9721b(1007, networkException.toString(), "Download"));
            } else if (iM1331z == 404) {
                C10756j.this.m65523U(new C9721b(4307, 404, networkException.toString(), "Download"));
                C11839m.m70687e("AssetDownloader", "download fileName：" + this.f51467a.getPath() + " resource_not_found, exception: " + networkException.toString());
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(RemoteMessageConst.FROM, "AssetDownloader");
                linkedHashMap.put(ContentResource.FILE_NAME, this.f51467a.getPath());
                C13000a.m78150e(404, networkException.toString(), C11058a.m66627b("09002"), "download_resource_not_found", linkedHashMap);
            } else {
                C10756j.this.m65523U(new C9721b(4307, -1, networkException.toString(), "Download", Integer.toString(iM1331z)));
            }
            release();
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public void onProgress(GetRequest getRequest, Progress progress) {
            C11839m.m70686d("AssetDownloader", "slice object [" + this.f51467a.getObject() + "] download progress = " + progress.getProgress() + "size = " + progress.getFinishedSize());
            C10756j.m65481E(C10756j.this, progress.getFinishedSize());
            C10756j.this.f51437u.put(this.f51467a.getObject(), Long.valueOf(progress.getFinishedSize()));
            if (C10756j.this.f51414N != null) {
                C10756j.this.f51414N.mo16342a(C10756j.this);
            }
        }

        @Override // com.huawei.hms.network.file.api.Callback
        public GetRequest onStart(GetRequest getRequest) {
            C11839m.m70688i("AssetDownloader", "taskId [" + getRequest.getId() + "]slice object [" + this.f51467a.getObject() + "] cache [" + this.f51467a.getUuid() + "] onStart.");
            try {
                C10756j.this.m65534f0();
                this.f51470d = C10756j.this.m65525W(this.f51467a.getObject(), C10756j.this.f51424h);
                if (C10756j.this.f51403C) {
                    this.f51470d.getHeaders().put("range", this.f51471e.m69613f());
                }
                EndpointUrl endpointUrl = this.f51470d;
                if (endpointUrl != null && endpointUrl.getHeaders() != null && this.f51470d.getUrl() != null) {
                    GetRequest getRequestBuild = getRequest.newBuilder().url(this.f51470d.getUrl()).headers(this.f51470d.getHeaders()).build();
                    C11839m.m70686d("AssetDownloader", "GetRequest url：" + getRequestBuild.getUrl());
                    C11839m.m70686d("AssetDownloader", "GetRequest headers：" + getRequestBuild.getHeaders());
                    return getRequestBuild;
                }
                C11839m.m70687e("AssetDownloader", "endpointUrl is invalid.");
                C10756j.this.m65523U(new C9721b(4309, "endpointUrl is null"));
                return getRequest;
            } catch (Exception e10) {
                C11839m.m70687e("AssetDownloader", "taskId [" + getRequest.getId() + "]slice object [" + this.f51467a.getObject() + "] cache [" + this.f51467a.getUuid() + "] onStart." + e10);
                C10756j.this.m65523U(new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, e10.toString()));
                return getRequest;
            }
        }

        public f(DownloadBuilder downloadBuilder, C11656b c11656b, EndpointUrl endpointUrl, CountDownLatch countDownLatch, int i10) {
            this.f51467a = downloadBuilder;
            this.f51468b = countDownLatch;
            this.f51469c = i10;
            this.f51471e = c11656b;
            this.f51470d = endpointUrl;
        }
    }

    public C10756j(AssetMetadataTransport assetMetadataTransport, String str, Asset asset, boolean z10) {
        this.f51417Q = false;
        this.f51441y = assetMetadataTransport;
        this.f51424h = asset;
        this.f51426j = str;
        this.f51417Q = z10;
    }

    /* renamed from: E */
    public static /* synthetic */ long m65481E(C10756j c10756j, long j10) {
        long j11 = c10756j.f51438v + j10;
        c10756j.f51438v = j11;
        return j11;
    }

    /* renamed from: g0 */
    public static /* synthetic */ boolean m65488g0(int i10, C11656b c11656b) {
        return c11656b.m69611d() == i10;
    }

    /* renamed from: k0 */
    public static /* synthetic */ SeekableInput m65493k0() {
        return C10766t.m65578r(null);
    }

    /* renamed from: n0 */
    public static /* synthetic */ int m65497n0(SliceObject sliceObject, SliceObject sliceObject2) {
        return sliceObject.getNumber().intValue() - sliceObject.getNumber().intValue();
    }

    /* renamed from: A0 */
    public void m65510A0(d dVar) {
        this.f51415O = dVar;
        AssetDownloaderProgressListener assetDownloaderProgressListener = this.f51414N;
        if (assetDownloaderProgressListener != null) {
            assetDownloaderProgressListener.mo16342a(this);
        }
    }

    /* renamed from: I */
    public void m65511I() {
        this.f51427k = true;
    }

    /* renamed from: J */
    public final void m65512J() {
        StringBuilder sb2;
        C11839m.m70686d("AssetDownloader", "checkLayerSlice decryptFileKey fek:" + C14164a.m85022a(this.f51428l) + " iv:" + C14164a.m85022a(this.f51429m));
        int i10 = 0;
        while (i10 < this.f51424h.getResource().getLayers().size()) {
            final int i11 = i10 + 1;
            C11839m.m70686d("AssetDownloader", "checkLayerSlice " + i11);
            List list = (List) this.f51442z.stream().filter(new Predicate() { // from class: ja.c
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C10756j.m65488g0(i11, (C11656b) obj);
                }
            }).collect(Collectors.toList());
            if (list.size() > 0) {
                File fileM1279m = C0209d.m1279m(this.f51440x + "/" + UUID.randomUUID().toString());
                try {
                    try {
                        Layer layerM65528Z = m65528Z(i11);
                        int i12 = 0;
                        while (true) {
                            if (i12 < list.size()) {
                                C11656b c11656b = (C11656b) list.get(i12);
                                C11839m.m70686d("AssetDownloader", "decrypt layer " + layerM65528Z.getSeq() + " netSlice " + c11656b);
                                C11839m.m70688i("AssetDownloader", "slice range/length:" + c11656b.m69613f() + "/" + c11656b.m69615h().length() + " " + c11656b.m69616i().getId());
                                if (c11656b.m69615h().length() != c11656b.m69616i().getLength().longValue()) {
                                    C11839m.m70689w("AssetDownloader", "slice is not equal, can not decrypt and check :" + c11656b.m69616i().getId());
                                    sb2 = new StringBuilder();
                                    break;
                                }
                                C11839m.m70686d("AssetDownloader", "slice " + c11656b.m69616i().getId() + " length success.");
                                C14165b.m85029b(fileM1279m, c11656b.m69615h(), c11656b.m69612e(), this.f51428l, this.f51429m);
                                i12++;
                            } else {
                                if (C14165b.m85035h(fileM1279m).m85045a().equals(layerM65528Z.getSha256())) {
                                    C11839m.m70686d("AssetDownloader", "layer " + layerM65528Z.getSeq() + " success.");
                                } else {
                                    C11839m.m70689w("AssetDownloader", "layer is not equal:" + layerM65528Z.getSeq());
                                }
                                sb2 = new StringBuilder();
                            }
                        }
                    } catch (Exception e10) {
                        C11839m.m70687e("AssetDownloader", "layer " + i11 + " error:" + e10.getMessage());
                        sb2 = new StringBuilder();
                    }
                    sb2.append("layer ");
                    sb2.append(i11);
                    sb2.append(" delete temp cache:");
                    sb2.append(fileM1279m.delete());
                    C11839m.m70686d("AssetDownloader", sb2.toString());
                } catch (Throwable th2) {
                    C11839m.m70686d("AssetDownloader", "layer " + i11 + " delete temp cache:" + fileM1279m.delete());
                    throw th2;
                }
            }
            i10 = i11;
        }
    }

    /* renamed from: K */
    public final void m65513K() throws C9721b, SQLException {
        C11839m.m70688i("AssetDownloader", "copySlices");
        this.f51430n = new CountDownLatch(this.f51432p.size());
        ArrayList arrayList = new ArrayList();
        boolean z10 = this.f51432p.size() > 2;
        Iterator<DownloadBuilder> it = this.f51432p.iterator();
        while (it.hasNext()) {
            c cVar = new c(it.next(), this.f51430n);
            arrayList.add(cVar);
            if (z10) {
                C12515a.m75110o().m75172d(cVar);
            } else {
                cVar.run();
            }
        }
        if (z10) {
            try {
                m65550y0();
                m65551z0();
            } finally {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((c) it2.next()).cancel();
                }
            }
        } else {
            m65551z0();
        }
        C11839m.m70686d("AssetDownloader", "copySlices file [" + this.f51419c.m28187f().getName() + "] end");
    }

    /* renamed from: L */
    public final void m65514L() throws C9721b, SQLException {
        C11839m.m70688i("AssetDownloader", "decryptDeltaSlices");
        try {
            try {
                File fileM63442h = C10278a.m63442h(C10279b.m63452a(this.f51419c.m28187f()) + PmsMetaDBScript.TEMP_SUFFIX);
                this.f51406F.m65579h(new BufferedOutputStream(new FileOutputStream(fileM63442h)), new IntFunction() { // from class: ja.e
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i10) {
                        return this.f51393a.m65537j0(i10);
                    }
                });
                if (fileM63442h.renameTo(this.f51419c.m28187f())) {
                    this.f51412L = System.currentTimeMillis();
                } else {
                    C11839m.m70687e("AssetDownloader", "rename from _temp failed.");
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "rename error");
                }
            } catch (IOException e10) {
                C11839m.m70687e("AssetDownloader", "createDownloadPatch make, applyTo" + e10.toString());
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "IOException digest error");
            } catch (Exception e11) {
                C11839m.m70687e("AssetDownloader", "createDownloadPatch make, applyTo" + e11.toString());
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "Exception digest error");
            }
        } finally {
            m65551z0();
        }
    }

    /* renamed from: M */
    public final void m65515M() throws C9721b {
        C11839m.m70688i("AssetDownloader", "decryptFileKey");
        try {
            this.f51428l = C14164a.m85026e(C14164a.m85023b(this.f51424h.getCipher().getKeyChains().get(0).getEkey(), m65529a0()));
            this.f51429m = C14164a.m85026e(this.f51424h.getCipher().getIv());
        } catch (Exception e10) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "compute file key and iv error: " + e10.getMessage());
        }
    }

    /* renamed from: N */
    public final void m65516N() throws C9721b, SQLException {
        C11839m.m70688i("AssetDownloader", "decryptSlices");
        this.f51430n = new CountDownLatch(this.f51432p.size());
        ArrayList arrayList = new ArrayList();
        boolean z10 = this.f51432p.size() > 2;
        Iterator<DownloadBuilder> it = this.f51432p.iterator();
        while (it.hasNext()) {
            e eVar = new e(it.next(), this.f51430n);
            arrayList.add(eVar);
            if (z10) {
                C12515a.m75110o().m75172d(eVar);
            } else {
                eVar.run();
            }
        }
        if (z10) {
            try {
                m65550y0();
                m65551z0();
            } finally {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((e) it2.next()).cancel();
                }
            }
        } else {
            m65551z0();
        }
        C11839m.m70686d("AssetDownloader", "decrypt file [" + this.f51419c.m28187f().getName() + "] end");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01e7 A[SYNTHETIC] */
    /* renamed from: O */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m65517O() throws java.lang.InterruptedException, fk.C9721b, android.database.SQLException {
        /*
            Method dump skipped, instructions count: 541
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p390ja.C10756j.m65517O():void");
    }

    /* renamed from: P */
    public final void m65518P() throws InterruptedException, C9721b, SQLException {
        C11839m.m70688i("AssetDownloader", "doDownloadDeltaSlice");
        this.f51408H = System.currentTimeMillis();
        Iterator<C11659e> it = this.f51405E.iterator();
        while (it.hasNext()) {
            this.f51442z.addAll(it.next().m69628g());
        }
        this.f51413M = System.currentTimeMillis();
        int size = this.f51442z.size();
        List<DownloadBuilder> listM66462b = new C11023c(this.f51431o).m66462b(this.f51423g);
        this.f51430n = new CountDownLatch(size);
        for (int i10 = 0; i10 < size; i10++) {
            C11656b c11656b = this.f51442z.get(i10);
            DownloadBuilder data1 = new DownloadBuilder(this.f51426j).setPath(this.f51431o.getPath()).setNum(i10).setUuid(UUID.randomUUID().toString()).setObject(c11656b.m69610c()).setData1(c11656b.m69613f());
            for (DownloadBuilder downloadBuilder : listM66462b) {
                if (data1.getData1().equals(downloadBuilder.getData1()) && data1.equals(downloadBuilder)) {
                    break;
                }
            }
            this.f51432p.add(data1);
            if (data1.getStatus() == Status.SUCCESS.value()) {
                File fileM63442h = C10278a.m63442h(this.f51440x + "/" + data1.getUuid());
                if (fileM63442h.exists()) {
                    this.f51430n.countDown();
                    this.f51437u.put(c11656b.m69610c(), Long.valueOf(c11656b.m69614g()));
                    AssetDownloaderProgressListener assetDownloaderProgressListener = this.f51414N;
                    if (assetDownloaderProgressListener != null) {
                        assetDownloaderProgressListener.mo16342a(this);
                    }
                    c11656b.m69619l(fileM63442h);
                    C11839m.m70686d("AssetDownloader", "slice object [" + data1.getObject() + "] already download.");
                } else {
                    C11839m.m70686d("AssetDownloader", "slice object [" + data1.getObject() + "] download cache has been deleted.");
                    data1.reset();
                    EndpointUrl endpointUrlM65525W = m65525W(c11656b.m69610c(), this.f51424h);
                    endpointUrlM65525W.getHeaders().put("range", c11656b.m69613f());
                    GetRequest getRequestM82541k = C13735d.m82531s().m82541k(this.f51418b, DownloadManager.newGetRequestBuilder().filePath(this.f51440x + "/" + data1.getUuid()).offset(0L).name(data1.getUuid()).config(C13735d.m82528e()).url(endpointUrlM65525W.getUrl()).headers(endpointUrlM65525W.getHeaders()).enableSlice(false), data1.getTaskId(), new f(data1, c11656b, endpointUrlM65525W, this.f51430n, 0));
                    this.f51433q.add(Long.valueOf(getRequestM82541k.getId()));
                    new C11023c(data1.setTaskId(getRequestM82541k.getId())).m66463c(this.f51423g);
                }
            } else {
                EndpointUrl endpointUrlM65525W2 = m65525W(c11656b.m69610c(), this.f51424h);
                endpointUrlM65525W2.getHeaders().put("range", c11656b.m69613f());
                GetRequest getRequestM82541k2 = C13735d.m82531s().m82541k(this.f51418b, DownloadManager.newGetRequestBuilder().filePath(this.f51440x + "/" + data1.getUuid()).offset(0L).name(data1.getUuid()).config(C13735d.m82528e()).url(endpointUrlM65525W2.getUrl()).headers(endpointUrlM65525W2.getHeaders()).enableSlice(false), data1.getTaskId(), new f(data1, c11656b, endpointUrlM65525W2, this.f51430n, 0));
                this.f51433q.add(Long.valueOf(getRequestM82541k2.getId()));
                new C11023c(data1.setTaskId(getRequestM82541k2.getId())).m66463c(this.f51423g);
            }
        }
        try {
            m65550y0();
        } catch (C9721b e10) {
            C13735d.m82531s().m82545o(this.f51418b, this.f51433q);
            C11839m.m70687e("AssetDownloader", e10.toString());
            throw e10;
        }
    }

    /* renamed from: Q */
    public void m65519Q(File file, Asset asset, C13001b c13001b) throws Exception {
        C11839m.m70688i("AssetDownloader", "download file start " + this.f51426j + " name:" + asset.getName() + " useDeltaSync:" + this.f51403C);
        this.f51407G = System.currentTimeMillis();
        try {
            this.f51419c = new C4602e("", file);
            if (file != null && file.exists()) {
                C11839m.m70688i("AssetDownloader", "download file with local file to diff:" + C10279b.m63452a(file));
                this.f51420d = new C4602e("", file);
            }
            c13001b.m78159i("get_download_url_v2");
            m65510A0(d.INIT_USER_KEY);
            if (asset.getResource() == null) {
                m65527Y(this.f51425i);
            }
            List<SliceObject> objects = asset.getResource().getObjects();
            if (objects != null && objects.size() > 0) {
                this.f51416P.m66667w(objects.get(0).getBucket());
                this.f51416P.m66638D(asset.getId());
            }
            if (this.f51404D) {
                C11839m.m70688i("AssetDownloader", "download plantxet");
                m65520R(c13001b);
            } else if (this.f51403C) {
                C11839m.m70688i("AssetDownloader", "download layer");
                m65522T(c13001b);
            } else {
                C11839m.m70688i("AssetDownloader", "download asset");
                m65521S(c13001b);
            }
            m65510A0(d.DOWNLOAD_COMPLETED);
            this.f51416P.m66635A("success");
            this.f51416P.m66640F(String.valueOf(this.f51438v));
            this.f51416P.m66642H(String.valueOf(System.currentTimeMillis() - this.f51407G));
            C11839m.m70686d("AssetDownloader", "download file end. cost:prepareTime:" + (this.f51409I - this.f51407G) + " digestTime:" + (this.f51410J - this.f51409I) + " diffTime:" + (this.f51411K - this.f51410J) + " makeTime:" + (this.f51408H - this.f51411K) + " downloadTime:" + (this.f51413M - this.f51408H) + " applyTime:" + (this.f51412L - this.f51413M));
        } catch (Exception e10) {
            C11839m.m70687e("AssetDownloader", "download file end CException:" + e10.toString());
            this.f51416P.m66640F(String.valueOf(this.f51438v));
            throw e10;
        }
    }

    /* renamed from: R */
    public final void m65520R(C13001b c13001b) throws InterruptedException, C9721b, SQLException {
        c13001b.m78159i("prepare_slices_plaintext");
        m65544s0();
        m65534f0();
        c13001b.m78159i("object_download_plaintext");
        m65510A0(d.OBJECTS_DOWNLOAD_START);
        this.f51416P.m66664t("object_download_plaintext");
        m65517O();
        m65510A0(d.OBJECTS_DOWNLOAD_DECRYPT);
        c13001b.m78159i("download_copy_v2");
        this.f51416P.m66664t("download_copy");
        m65513K();
        c13001b.m78159i("download");
        this.f51416P.m66664t("download");
    }

    /* renamed from: S */
    public final void m65521S(C13001b c13001b) throws InterruptedException, C9721b, SQLException {
        c13001b.m78159i("prepare_slices_v2");
        m65544s0();
        m65534f0();
        c13001b.m78159i("object_download_v2");
        m65510A0(d.OBJECTS_DOWNLOAD_START);
        this.f51416P.m66664t("object_download");
        m65517O();
        m65510A0(d.OBJECTS_DOWNLOAD_DECRYPT);
        c13001b.m78159i("download_decrypt_v2");
        this.f51416P.m66664t("download_decrypt");
        m65515M();
        m65516N();
        c13001b.m78159i("download");
        this.f51416P.m66664t("download");
    }

    /* renamed from: T */
    public final void m65522T(C13001b c13001b) throws InterruptedException, C9721b, SQLException {
        c13001b.m78159i("prepare_layerSlices_v2");
        m65543r0();
        this.f51409I = System.currentTimeMillis();
        m65534f0();
        m65510A0(d.OBJECTS_DOWNLOAD_START);
        c13001b.m78159i("make_download_delta_v2");
        this.f51416P.m66664t("make_download_delta");
        m65541p0();
        c13001b.m78159i("decrypt_fileKey_v2");
        m65515M();
        c13001b.m78159i("object_download_delta_v2");
        this.f51416P.m66664t("object_download_delta");
        m65518P();
        if (C1443a.f6214b.booleanValue() && this.f51420d == null) {
            m65512J();
        }
        c13001b.m78159i("download_delta_decrypt_v2");
        this.f51416P.m66664t("download_delta_decrypt");
        m65514L();
        c13001b.m78159i("download");
        this.f51416P.m66664t("download_delta");
    }

    /* renamed from: U */
    public final void m65523U(C9721b c9721b) {
        synchronized (f51399R) {
            try {
                if (this.f51439w == null) {
                    this.f51439w = c9721b;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: V */
    public final List<SliceItem<SliceObject>> m65524V(Map<String, Object> map) {
        ArrayList arrayList = new ArrayList();
        SliceEnumeration<SliceObject> sliceEnumerationM65531c0 = m65531c0(this.f51424h.getResource().getObjects(), map, this.f51424h.getResource().getLength().longValue(), this.f51424h.getResource().getSliceSize(), false);
        if (sliceEnumerationM65531c0.hasMoreSlices() && (map.get("length") instanceof C4626a)) {
            for (SliceItem<SliceObject> sliceItem : sliceEnumerationM65531c0.nextSlice(((BigDecimal) ((Map) map.get("length")).get("small")).longValue()).getSliceItems()) {
                if (!this.f51424h.getName().equals("small")) {
                    break;
                }
                arrayList.add(sliceItem);
            }
        }
        if (sliceEnumerationM65531c0.hasMoreSlices() && (map.get("length") instanceof C4626a)) {
            for (SliceItem<SliceObject> sliceItem2 : sliceEnumerationM65531c0.nextSlice(((BigDecimal) ((Map) map.get("length")).get("large")).longValue()).getSliceItems()) {
                if (!this.f51424h.getName().equals("large")) {
                    break;
                }
                arrayList.add(sliceItem2);
            }
        }
        return arrayList;
    }

    /* renamed from: W */
    public final EndpointUrl m65525W(String str, Asset asset) {
        synchronized (f51400S) {
            try {
                if (asset.getResource().getLayers() != null) {
                    for (int i10 = 0; i10 < asset.getResource().getLayers().size(); i10++) {
                        for (SliceObject sliceObject : asset.getResource().getLayers().get(i10).getObjects()) {
                            if (sliceObject.getId().equals(str)) {
                                EndpointUrl endpointUrlM65526X = m65526X(sliceObject);
                                endpointUrlM65526X.set("client_endpointVersion", (Object) Integer.valueOf(this.f51425i));
                                return endpointUrlM65526X;
                            }
                        }
                    }
                }
                for (SliceObject sliceObject2 : asset.getResource().getObjects()) {
                    if (sliceObject2.getId().equals(str)) {
                        EndpointUrl endpointUrlM65526X2 = m65526X(sliceObject2);
                        endpointUrlM65526X2.set("client_endpointVersion", (Object) Integer.valueOf(this.f51425i));
                        return endpointUrlM65526X2;
                    }
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: X */
    public final EndpointUrl m65526X(SliceObject sliceObject) {
        this.f51390a = Boolean.valueOf(sliceObject.getAccelerateDownloadUrl() != null);
        return sliceObject.getAccelerateDownloadUrl() != null ? sliceObject.getAccelerateDownloadUrl() : sliceObject.getDownloadUrl();
    }

    /* renamed from: Y */
    public final void m65527Y(int i10) throws C9721b {
        C11839m.m70688i("AssetDownloader", "getDownloadUrl");
        Asset asset = new Asset();
        Resource resource = new Resource();
        resource.setId(this.f51424h.getId());
        asset.setResource(resource);
        try {
            synchronized (f51400S) {
                try {
                    if (i10 == this.f51425i) {
                        this.f51424h.setResource(this.f51441y.onRefreshDownloadUrl(this.f51426j, this.f51424h.getId(), this.f51424h.getVersionId(), asset, this.f51417Q));
                        this.f51425i++;
                    } else {
                        C11839m.m70688i("AssetDownloader", "downloadUrlVersion is " + i10 + " is not equal to resourceVersion " + this.f51425i);
                    }
                } finally {
                }
            }
        } catch (C4616s e10) {
            C11839m.m70687e("AssetDownloader", "getDownloadUrl HttpResponseException result : " + e10.toString());
            throw new C9721b(4312, e10.m28322f(), e10.m28319c(), "assets.revisions.get", C1160a.m7253d(e10));
        } catch (IOException e11) {
            throw new C9721b(4313, "getDownload Url error: " + e11.getMessage());
        }
    }

    /* renamed from: Z */
    public final Layer m65528Z(int i10) {
        for (int i11 = 0; i11 < this.f51424h.getResource().getLayers().size(); i11++) {
            if (i10 == this.f51424h.getResource().getLayers().get(i11).getSeq().intValue()) {
                return this.f51424h.getResource().getLayers().get(i11);
            }
        }
        return null;
    }

    /* renamed from: a0 */
    public final byte[] m65529a0() throws C9721b {
        C11839m.m70688i("AssetDownloader", "getMatchUserKey");
        if (this.f51424h.getCipher() == null) {
            throw new C9721b(4309, "file content has no Cipher");
        }
        List<KeyChain> keyChains = this.f51424h.getCipher().getKeyChains();
        if (keyChains == null || keyChains.size() == 0) {
            throw new C9721b(4309, "file content has no keyChains in Cipher");
        }
        String id2 = keyChains.get(0).getId();
        if (TextUtils.isEmpty(id2) || id2.equals(this.f51401A.getUserKeyGuid())) {
            return this.f51401A.getUserKey();
        }
        if (id2.equals(this.f51402B.getUserKeyGuid())) {
            return this.f51402B.getUserKey();
        }
        throw new C9721b(4309, "no match userKey.");
    }

    /* renamed from: b0 */
    public long m65530b0() {
        Iterator<Long> it = this.f51437u.values().iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        return jLongValue;
    }

    /* renamed from: c0 */
    public final SliceEnumeration<SliceObject> m65531c0(List<SliceObject> list, Map<String, Object> map, long j10, Long l10, boolean z10) {
        long jLongValue;
        long jLongValue2;
        C11839m.m70686d("AssetDownloader", "get slice enumeration by objects.");
        Long l11 = l10 == null ? Long.MAX_VALUE : l10;
        long jLongValue3 = ((j10 - 1) / l11.longValue()) + 1;
        C4627a0.m28395h(((long) list.size()) >= jLongValue3, "objects is not valid.");
        if (z10) {
            jLongValue2 = j10 % l11.longValue() == 0 ? l11.longValue() : j10 % l11.longValue();
            jLongValue = jLongValue3;
        } else {
            Object obj = map.get("length");
            long jLongValue4 = obj instanceof C4626a ? ((BigDecimal) ((Map) obj).get("small")).longValue() : obj instanceof BigDecimal ? ((BigDecimal) obj).longValue() : 0L;
            jLongValue = 1 + ((jLongValue4 - 1) / l11.longValue());
            jLongValue2 = jLongValue4 % l11.longValue() == 0 ? l11.longValue() : jLongValue4 % l11.longValue();
        }
        return new SliceEnumeration<>(list, new C10767u(jLongValue, l11.longValue(), jLongValue2));
    }

    /* renamed from: d0 */
    public long m65532d0() {
        return this.f51436t;
    }

    /* renamed from: e0 */
    public void m65533e0(UserKeyObject userKeyObject, UserKeyObject userKeyObject2) {
        C11839m.m70688i("AssetDownloader", "initUserKey");
        this.f51401A = userKeyObject;
        this.f51402B = userKeyObject2;
    }

    /* renamed from: f0 */
    public final void m65534f0() throws C9721b {
        if (this.f51427k) {
            throw new C9721b(1001, "user cancel.");
        }
        C9721b c9721b = this.f51439w;
        if (c9721b != null) {
            throw c9721b;
        }
    }

    /* renamed from: h0 */
    public final /* synthetic */ SeekableInput m65535h0() {
        C4602e c4602e = this.f51420d;
        return C10766t.m65578r(c4602e == null ? null : c4602e.m28187f());
    }

    /* renamed from: j0 */
    public final /* synthetic */ InputSource m65537j0(final int i10) {
        return i10 == 0 ? new InputSource() { // from class: ja.h
            @Override // com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk.InputSource
            /* renamed from: a */
            public final SeekableInput mo16345a() {
                return this.f51396a.m65535h0();
            }
        } : new InputSource() { // from class: ja.i
            @Override // com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk.InputSource
            /* renamed from: a */
            public final SeekableInput mo16345a() {
                return this.f51397a.m65536i0(i10);
            }
        };
    }

    /* renamed from: l0 */
    public final /* synthetic */ SeekableInput m65538l0(int i10) {
        return m65540o0(i10, this.f51405E);
    }

    /* renamed from: m0 */
    public final /* synthetic */ InputSource m65539m0(final int i10) {
        return i10 == 0 ? new InputSource() { // from class: ja.f
            @Override // com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk.InputSource
            /* renamed from: a */
            public final SeekableInput mo16345a() {
                return C10756j.m65493k0();
            }
        } : new InputSource() { // from class: ja.g
            @Override // com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk.InputSource
            /* renamed from: a */
            public final SeekableInput mo16345a() {
                return this.f51394a.m65538l0(i10);
            }
        };
    }

    /* renamed from: o0 */
    public final SeekableInput m65540o0(int i10, List<C11659e> list) {
        return new a(i10, list);
    }

    /* renamed from: p0 */
    public final void m65541p0() throws C9721b {
        C11839m.m70688i("AssetDownloader", "makeDeltaSyncSlice");
        try {
            C11839m.m70686d("AssetDownloader", "cloudDigest fragments count:" + this.f51422f.getFragments().size());
            this.f51421e = null;
            C4602e c4602e = this.f51420d;
            if (c4602e != null) {
                this.f51421e = C10757k.m65560b(this.f51422f, c4602e.m28187f());
            } else {
                this.f51421e = new Digest(this.f51422f.getTag(), this.f51422f.getBlockSize(), new ArrayList());
            }
            C11839m.m70686d("AssetDownloader", "localDigest fragments count:" + this.f51421e.getFragments().size());
            this.f51410J = System.currentTimeMillis();
            C11839m.m70688i("AssetDownloader", "createDownloadPatch");
            this.f51406F = C10766t.m65570i(this.f51424h.getResource().getLength().longValue(), this.f51421e, this.f51422f);
            this.f51411K = System.currentTimeMillis();
            int[] iArr = new int[this.f51424h.getResource().getLayers().size()];
            for (int i10 = 0; i10 < this.f51424h.getResource().getLayers().size(); i10++) {
                iArr[i10] = this.f51424h.getResource().getLayers().get(i10).getSliceSize().intValue();
            }
            C11839m.m70688i("AssetDownloader", "digestFile make");
            this.f51406F.m65580q(iArr, new IntFunction() { // from class: ja.d
                @Override // java.util.function.IntFunction
                public final Object apply(int i11) {
                    return this.f51392a.m65539m0(i11);
                }
            });
            this.f51408H = System.currentTimeMillis();
        } catch (IOException | NoSuchAlgorithmException e10) {
            C11839m.m70687e("AssetDownloader", "makeDeltaSyncSlice " + e10.toString());
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "IOException digest error");
        } catch (Exception e11) {
            C11839m.m70687e("AssetDownloader", "makeDeltaSyncSlice make, applyTo" + e11.toString());
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "Exception digest error");
        }
    }

    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public final SeekableInput m65536i0(int i10) {
        return new b(i10);
    }

    /* renamed from: r0 */
    public final void m65543r0() throws C9721b {
        C11839m.m70686d("AssetDownloader", "prepareLayerSlices");
        this.f51431o = new DownloadBuilder(this.f51426j).setPath(this.f51419c.m28187f().getPath());
        Map<String, Object> attributes = this.f51424h.getResource().getAttributes();
        if (attributes == null || attributes.get("length") == null) {
            attributes = this.f51424h.getAttributes();
        }
        boolean zIsEmpty = TextUtils.isEmpty(this.f51424h.getName());
        long jLongValue = this.f51424h.getResource().getLength().longValue();
        if (zIsEmpty) {
            List<Layer> layers = this.f51424h.getResource().getLayers();
            C11839m.m70686d("AssetDownloader", "layers size :" + layers.size());
            for (int i10 = 0; i10 < layers.size(); i10++) {
                SliceEnumeration<SliceObject> sliceEnumerationM65531c0 = m65531c0(layers.get(i10).getObjects(), attributes, layers.get(i10).getLength().longValue(), layers.get(i10).getSliceSize(), true);
                if (!sliceEnumerationM65531c0.hasMoreSlices()) {
                    throw new C9721b(4001, "amount of files does not match with dbank_s3_file");
                }
                Slice<SliceObject> sliceNextSlice = sliceEnumerationM65531c0.nextSlice(jLongValue);
                this.f51436t += sliceNextSlice.getLength();
                List<SliceItem<SliceObject>> sliceItems = sliceNextSlice.getSliceItems();
                this.f51434r = sliceItems;
                this.f51435s.add(sliceItems);
            }
        } else {
            if (jLongValue == -1) {
                throw new C9721b(4310, "no attachment length");
            }
            this.f51434r = m65524V(attributes);
        }
        List<Layer> layers2 = this.f51424h.getResource().getLayers();
        for (int i11 = 0; i11 < layers2.size(); i11++) {
            Layer layer = layers2.get(i11);
            int iLongValue = (int) (layer.getLength().longValue() / layer.getSliceSize().longValue());
            for (int i12 = 0; i12 < layer.getObjects().size(); i12++) {
                if (layer.getObjects().get(i12).getNumber().intValue() < iLongValue) {
                    layer.getObjects().get(i12).setPlainLength(layer.getSliceSize());
                } else {
                    layer.getObjects().get(i12).setPlainLength(Long.valueOf(layer.getLength().longValue() - (iLongValue * layer.getSliceSize().longValue())));
                }
            }
        }
    }

    /* renamed from: s0 */
    public final void m65544s0() throws C9721b {
        C11839m.m70688i("AssetDownloader", "prepareSlices");
        this.f51431o = new DownloadBuilder(this.f51426j).setPath(this.f51419c.m28187f().getPath());
        List<SliceObject> objects = this.f51424h.getResource().getObjects();
        if (objects == null || objects.size() == 0) {
            throw new C9721b(4309, "file content has no objectInfoList");
        }
        Map<String, Object> attributes = this.f51424h.getResource().getAttributes();
        if (attributes == null || attributes.get("length") == null) {
            attributes = this.f51424h.getAttributes();
        }
        if (!TextUtils.isEmpty(this.f51424h.getName())) {
            this.f51434r = m65524V(attributes);
            return;
        }
        objects.sort(new Comparator() { // from class: ja.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C10756j.m65497n0((SliceObject) obj, (SliceObject) obj2);
            }
        });
        for (int i10 = 0; i10 < objects.size(); i10++) {
            this.f51434r.add(new SliceItem<>(objects.get(i10), i10, 0L, objects.get(i10).getLength().longValue()));
            this.f51436t += objects.get(i10).getLength().longValue();
        }
    }

    /* renamed from: t0 */
    public void m65545t0(Digest digest) {
        this.f51422f = digest;
    }

    /* renamed from: u0 */
    public void m65546u0(boolean z10) {
        this.f51404D = z10;
    }

    /* renamed from: v0 */
    public void m65547v0(AssetDownloaderProgressListener assetDownloaderProgressListener) {
        this.f51414N = assetDownloaderProgressListener;
    }

    /* renamed from: w0 */
    public void m65548w0(C11060c c11060c) {
        this.f51416P = c11060c;
    }

    /* renamed from: x0 */
    public void m65549x0(boolean z10) {
        this.f51403C = z10;
    }

    /* renamed from: y0 */
    public final void m65550y0() throws InterruptedException, C9721b {
        m65534f0();
        while (this.f51430n.getCount() > 0 && !this.f51427k && this.f51439w == null) {
            try {
                C11839m.m70686d("AssetDownloader", "syncLock await" + this.f51430n.await(400L, TimeUnit.MILLISECONDS));
            } catch (InterruptedException e10) {
                C11839m.m70689w("AssetDownloader", "lock wait error." + e10);
                this.f51439w = new C9721b(1001, "thread has been interrupted");
            }
        }
        C9721b c9721b = this.f51439w;
        if (c9721b != null) {
            throw c9721b;
        }
        m65534f0();
    }

    /* renamed from: z0 */
    public final void m65551z0() throws SQLException {
        for (int i10 = 0; i10 < this.f51442z.size(); i10++) {
            this.f51442z.get(i10).m69609b();
        }
        Iterator<DownloadBuilder> it = this.f51432p.iterator();
        while (it.hasNext()) {
            String uuid = it.next().getUuid();
            if (uuid != null && !uuid.isEmpty()) {
                File file = new File(this.f51440x, uuid);
                if (file.exists()) {
                    C11839m.m70686d("AssetDownloader", "finally cache file exits, delete = " + file.delete());
                }
            }
        }
        DownloadBuilder downloadBuilder = this.f51431o;
        if (downloadBuilder != null) {
            new C11023c(downloadBuilder).m66461a(this.f51423g);
        }
    }
}
