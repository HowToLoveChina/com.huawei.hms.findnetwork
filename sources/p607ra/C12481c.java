package p607ra;

import android.text.TextUtils;
import com.huawei.android.hicloud.connect.progress.ICallback;
import com.huawei.android.hicloud.drive.clouddisk.asset.AssetDownloaderProgressListener;
import com.huawei.android.hicloud.drive.clouddisk.expand.CloudDriveMediaDownloader;
import com.huawei.android.hicloud.drive.clouddisk.expand.DriveExpand;
import com.huawei.android.hicloud.drive.clouddisk.expand.MediaDownloader;
import com.huawei.android.hicloud.drive.clouddisk.expand.MediaDownloaderProgressListener;
import com.huawei.android.hicloud.drive.clouddisk.expand.SyncDriveRequest;
import com.huawei.android.hicloud.drive.clouddisk.model.Asset;
import com.huawei.android.hicloud.drive.clouddisk.model.FileExpand;
import com.huawei.android.hicloud.drive.clouddisk.model.Resource;
import com.huawei.cloud.base.http.C4602e;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.hicloud.base.bean.DownloadItem;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import p363ia.C10463a;
import p390ja.C10756j;
import p429kk.C11058a;
import p514o9.C11839m;
import p606r9.C12478a;
import p652t9.EnumC12999a;
import p712vm.C13468a;
import ua.C13142a;
import za.C14165b;

/* renamed from: ra.c */
/* loaded from: classes3.dex */
public class C12481c implements MediaDownloaderProgressListener, AssetDownloaderProgressListener {

    /* renamed from: a */
    public DownloadItem f57470a;

    /* renamed from: d */
    public ICallback f57473d;

    /* renamed from: b */
    public CloudDriveMediaDownloader f57471b = null;

    /* renamed from: c */
    public MediaDownloader f57472c = null;

    /* renamed from: e */
    public long f57474e = 0;

    /* renamed from: f */
    public long f57475f = 0;

    /* renamed from: g */
    public String f57476g = C11058a.m66627b("09002");

    public C12481c(DownloadItem downloadItem, ICallback iCallback) {
        this.f57470a = downloadItem;
        this.f57473d = iCallback;
    }

    @Override // com.huawei.android.hicloud.drive.clouddisk.asset.AssetDownloaderProgressListener
    /* renamed from: a */
    public void mo16342a(C10756j c10756j) {
        C11839m.m70688i("DownloadTask", "progressChanged 1");
        if (c10756j == null) {
            C11839m.m70687e("DownloadTask", "progressChanged error:assetDownloader is null");
            return;
        }
        ICallback iCallback = this.f57473d;
        if (iCallback == null || iCallback.onStop()) {
            C11839m.m70687e("DownloadTask", "progressChanged error: downloadCallback is null or is stop");
        } else {
            m74956h(c10756j.m65530b0(), c10756j.m65532d0());
        }
    }

    /* renamed from: b */
    public final void m74950b() throws C9721b {
        CloudDriveMediaDownloader cloudDriveMediaDownloader = this.f57471b;
        if (cloudDriveMediaDownloader == null) {
            C11839m.m70688i("DownloadTask", "verifying hash and size, mediaDownloader is null");
            return;
        }
        Asset asset = cloudDriveMediaDownloader.getAsset();
        if (asset == null) {
            C11839m.m70688i("DownloadTask", "verifying hash and size, asset is null");
            return;
        }
        Resource resource = asset.getResource();
        if (resource == null) {
            C11839m.m70688i("DownloadTask", "verifying hash and size, resource is null");
            return;
        }
        File fileM63442h = C10278a.m63442h(this.f57470a.savePath);
        C11839m.m70688i("DownloadTask", "verifying hash and size, fileName: " + fileM63442h.getName());
        String sha256 = resource.getSha256();
        long jLongValue = resource.getLength().longValue();
        if (TextUtils.isEmpty(sha256)) {
            C11839m.m70688i("DownloadTask", "verifying hash and size, fileSha256 is null");
            long length = fileM63442h.length();
            if (jLongValue <= 0) {
                C11839m.m70688i("DownloadTask", "verifying hash and size, cloudLength is 0");
                return;
            }
            if (jLongValue == length) {
                return;
            }
            C11839m.m70688i("DownloadTask", "verifying hash and size, different length delete file isSuccess = " + fileM63442h.delete());
            throw new C9721b(2263, "different length");
        }
        String strM85039l = C14165b.m85039l(this.f57470a.savePath);
        Locale locale = Locale.ENGLISH;
        String lowerCase = sha256.toLowerCase(locale);
        if (TextUtils.isEmpty(strM85039l) || lowerCase.equals(strM85039l.toLowerCase(locale))) {
            C11839m.m70688i("DownloadTask", "verifying hash and size, success");
            return;
        }
        C11839m.m70688i("DownloadTask", "verifying hash and size, different hash delete file isSuccess = " + fileM63442h.delete());
        throw new C9721b(2263, "different hash");
    }

    /* renamed from: c */
    public void m74951c(boolean z10) throws C9721b, IOException {
        try {
            try {
                C11839m.m70688i("DownloadTask", "item save fileName is " + this.f57470a.getFileName() + " fileId: " + this.f57470a.getFileId() + " size: " + this.f57470a.getFileSize());
                DriveExpand driveExpandM64282d = C10463a.m64279e().m64282d();
                if (driveExpandM64282d == null) {
                    C11839m.m70687e("DownloadTask", "DriveExpand is NULL.");
                    throw new C9721b(1009, "DriveExpand is null");
                }
                String fileId = this.f57470a.getFileId();
                File fileM63442h = C10278a.m63442h(this.f57470a.savePath);
                DownloadItem downloadItem = this.f57470a;
                String str = downloadItem.savePath;
                if (downloadItem.getFileSize() == 0) {
                    C11839m.m70688i("DownloadTask", "download empty file: " + this.f57470a.getFileName() + ", result: " + fileM63442h.createNewFile());
                    return;
                }
                try {
                    m74953e(driveExpandM64282d, fileM63442h, str, fileId, z10);
                } catch (C9721b e10) {
                    C11839m.m70687e("DownloadTask", "downloadByV2 CException:" + e10.getMessage());
                    if (m74955g(e10) || e10.m60659c() == 1007) {
                        throw e10;
                    }
                    m74952d(driveExpandM64282d, fileM63442h, str, fileId, z10);
                }
            } catch (C9721b e11) {
                C11839m.m70687e("DownloadTask", "download cexcption code = " + e11.m60659c() + ", msg = " + e11.getMessage());
                if (!m74955g(e11)) {
                    throw e11;
                }
                throw new C9721b(430, e11.getMessage());
            }
        } catch (IOException e12) {
            C11839m.m70687e("DownloadTask", "download exception msg = " + e12.getMessage());
            C13468a c13468aM81100c = C13468a.m81100c();
            boolean zM81101b = c13468aM81100c.m81101b();
            String str2 = c13468aM81100c.toString() + e12.toString();
            if (zM81101b) {
                throw e12;
            }
            C11839m.m70687e("DownloadTask", "download exception check net fake true");
            throw new C9721b(430, str2);
        }
    }

    /* renamed from: d */
    public final void m74952d(DriveExpand driveExpand, File file, String str, String str2, boolean z10) throws C9721b, IOException {
        C11839m.m70688i("DownloadTask", "begin downloadByV1");
        DriveExpand.FilesExpand.GetDownloadAddress downloadAddress = driveExpand.filesExpand().getDownloadAddress(str2);
        if (z10) {
            C4609l headers = downloadAddress.getHeaders();
            headers.set("x-hw-open-app-id", C13142a.f59637b);
            downloadAddress.setHeaders(headers);
        }
        FileExpand fileExpand = (FileExpand) new SyncDriveRequest(downloadAddress).execute();
        if (fileExpand.getObjectInfoList() != null) {
            fileExpand.setId(str2);
            DriveExpand.FilesExpand.DownloadProcess downloadProcess = driveExpand.filesExpand().downloadProcess(fileExpand, "", this.f57476g, this.f57470a.getFileMD5());
            MediaDownloader mediaDownloader = downloadProcess.getMediaDownloader();
            this.f57472c = mediaDownloader;
            mediaDownloader.setProgressListener(this);
            downloadProcess.executeContentAndDownloadTo(new C4602e("", file), true, z10);
        } else {
            new C12478a(EnumC12999a.CLOUD_DRIVE, this.f57476g).m74915k(fileExpand.getDownloadURL(), m74954f(), str, this.f57470a.getFileSize(), this.f57473d);
        }
        m74950b();
    }

    /* renamed from: e */
    public final void m74953e(DriveExpand driveExpand, File file, String str, String str2, boolean z10) throws C9721b, IOException {
        C11839m.m70688i("DownloadTask", "begin downloadByV2: " + file.getPath());
        CloudDriveMediaDownloader cloudDriveMediaDownloader = new CloudDriveMediaDownloader(this.f57476g, "", driveExpand);
        this.f57471b = cloudDriveMediaDownloader;
        cloudDriveMediaDownloader.initAsset(str2, false, z10);
        if (this.f57471b.isSupportV2()) {
            this.f57471b.setListener(this);
            this.f57471b.download(file, str2, z10);
        } else {
            String downloadAddressURL = this.f57471b.getDownloadAddressURL();
            C11839m.m70686d("DownloadTask", "downloadUrl getDownloadAddressURL：" + downloadAddressURL);
            new C12478a(EnumC12999a.CLOUD_DRIVE, this.f57476g).m74915k(downloadAddressURL, m74954f(), str, this.f57470a.getFileSize(), this.f57473d);
        }
        m74950b();
    }

    /* renamed from: f */
    public final String m74954f() {
        String sha256 = this.f57470a.getSha256();
        return TextUtils.isEmpty(sha256) ? this.f57470a.getFileMD5() : sha256;
    }

    /* renamed from: g */
    public final boolean m74955g(C9721b c9721b) {
        return c9721b.m60659c() == 1535;
    }

    /* renamed from: h */
    public final void m74956h(long j10, long j11) {
        C11839m.m70688i("DownloadTask", this.f57470a.getFileId() + " progressChanged offset = " + j10 + ", total = " + j11);
        int iFloor = (int) Math.floor((((double) j10) / ((double) j11)) * 100.0d);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z10 = jCurrentTimeMillis - this.f57474e > 800;
        boolean z11 = iFloor == 0 || ((long) iFloor) - this.f57475f > 10;
        if (z10 || z11) {
            this.f57475f = iFloor;
            this.f57474e = jCurrentTimeMillis;
            this.f57473d.onProgress(j10, j11);
        }
    }

    @Override // com.huawei.android.hicloud.drive.clouddisk.expand.MediaDownloaderProgressListener
    public void progressChanged(MediaDownloader mediaDownloader) {
        C11839m.m70688i("DownloadTask", "progressChanged 2");
        if (mediaDownloader == null) {
            C11839m.m70687e("DownloadTask", "progressChanged error:downloader is null");
            return;
        }
        ICallback iCallback = this.f57473d;
        if (iCallback == null || iCallback.onStop()) {
            C11839m.m70687e("DownloadTask", "progressChanged error: downloadCallback is null or is stop");
        } else {
            m74956h(mediaDownloader.getProgressValue(), mediaDownloader.getTotalValue());
        }
    }
}
