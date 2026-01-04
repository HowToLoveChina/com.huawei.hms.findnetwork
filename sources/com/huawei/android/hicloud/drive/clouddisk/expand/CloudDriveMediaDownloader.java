package com.huawei.android.hicloud.drive.clouddisk.expand;

import android.text.TextUtils;
import com.huawei.android.hicloud.drive.clouddisk.asset.AssetDownloaderProgressListener;
import com.huawei.android.hicloud.drive.clouddisk.asset.AssetMetadataTransport;
import com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk.Chunking;
import com.huawei.android.hicloud.drive.clouddisk.expand.DriveExpand;
import com.huawei.android.hicloud.drive.clouddisk.model.Asset;
import com.huawei.android.hicloud.drive.clouddisk.model.Attachment;
import com.huawei.android.hicloud.drive.clouddisk.model.Digest;
import com.huawei.android.hicloud.drive.clouddisk.model.FileExpand;
import com.huawei.android.hicloud.drive.clouddisk.model.Resource;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.services.drive.DriveRequest;
import com.huawei.hicloud.base.drive.model.EndpointUrl;
import fk.C9721b;
import java.io.IOException;
import java.util.List;
import la.C11264b;
import p390ja.C10756j;
import p390ja.C10757k;
import p514o9.C11839m;
import p653ta.C13001b;
import ua.C13142a;

/* loaded from: classes3.dex */
public class CloudDriveMediaDownloader implements AssetMetadataTransport {
    private static final int[] DISPERSED_DOWNLOAD_CODE = {4307};
    private static final int DOWNLOAD_TYPE_ASSET = 3;
    private static final int DOWNLOAD_TYPE_CIPHER_ASSET = 0;
    private static final int DOWNLOAD_TYPE_CIPHER_LAYER = 4;
    private static final String TAG = "CloudDriveMediaDownloader";
    private Asset asset;
    private String attachmentName;
    private Digest cloudDigest;
    private C10756j downloader;
    private DriveExpand drive;
    private AssetDownloaderProgressListener mListener;
    private C13001b mReporter;
    private String traceID;
    private DownloadType downloadType = DownloadType.URL;
    private boolean isCancel = false;
    public int reportResourceType = -1;

    public enum DownloadType {
        LAYER,
        ASSET,
        URL,
        PLAINTEXT_ASSET
    }

    public CloudDriveMediaDownloader(String str, String str2, DriveExpand driveExpand) {
        this.attachmentName = "";
        this.drive = driveExpand;
        this.traceID = str;
        this.attachmentName = str2;
    }

    private void dealDownloadType() {
        Asset asset = this.asset;
        if (asset == null) {
            C11839m.m70688i(TAG, "has no asset");
            this.downloadType = DownloadType.URL;
            return;
        }
        if (asset.getResource().getType() == null) {
            this.downloadType = DownloadType.URL;
            C11839m.m70688i(TAG, "dealDownloadType type is null.");
            return;
        }
        int iIntValue = this.asset.getResource().getType().intValue();
        this.reportResourceType = iIntValue;
        Digest cloudDigest = getCloudDigest(this.asset);
        this.cloudDigest = cloudDigest;
        Chunking chunkingM67607a = cloudDigest != null ? C11264b.m67607a(cloudDigest.getTag()) : null;
        boolean z10 = false;
        boolean z11 = iIntValue == 4 && (this.asset.getResource().getLayers() != null && this.asset.getResource().getLayers().size() > 0) && !TextUtils.isEmpty(this.asset.getResource().getDigestStr());
        boolean z12 = iIntValue == 0 && this.asset.getResource().getObjects() != null && this.asset.getResource().getObjects().size() > 0;
        if (iIntValue == 3 && this.asset.getResource().getObjects() != null && this.asset.getResource().getObjects().size() > 0) {
            z10 = true;
        }
        if (z11 && chunkingM67607a != null) {
            this.downloadType = DownloadType.LAYER;
            C11839m.m70688i(TAG, "use V2 deltaSync download process. layers:" + this.asset.getResource().getLayers().size() + "  algorithm:" + chunkingM67607a.mo16343a() + " digest:" + this.asset.getResource().getDigestStr().length());
            return;
        }
        if (z12) {
            this.downloadType = DownloadType.ASSET;
            C11839m.m70688i(TAG, "use V2 normal cipher download process.");
        } else if (z10) {
            this.downloadType = DownloadType.PLAINTEXT_ASSET;
            C11839m.m70688i(TAG, "use V2 normal download process.");
        } else {
            this.downloadType = DownloadType.URL;
            C11839m.m70688i(TAG, "use auto url download process.");
        }
    }

    private Digest getCloudDigest(Asset asset) {
        if (asset != null && asset.getResource() != null && asset.getResource().getDigest() != null) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                Digest digestM65559a = C10757k.m65559a(asset.getResource().getDigest());
                C11839m.m70688i(TAG, "deserialize cloudDigest cost：" + (System.currentTimeMillis() - jCurrentTimeMillis));
                return digestM65559a;
            } catch (IOException unused) {
            }
        }
        return null;
    }

    private boolean isCancel() {
        return this.isCancel;
    }

    public void cancel() {
        C11839m.m70688i(TAG, "cancel");
        this.isCancel = true;
        C10756j c10756j = this.downloader;
        if (c10756j != null) {
            c10756j.m65511I();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:150:0x018e, code lost:
    
        r14.m81568d(r13);
        r15.put(com.huawei.openalliance.p169ad.p171db.bean.ContentResource.FILE_NAME, r22.getName());
        r15.put("downloadType", r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x01a3, code lost:
    
        if (r21.asset.getProperties() != null) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x01a5, code lost:
    
        r3 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x01a8, code lost:
    
        r3 = r17;
        r9 = r21.asset.getProperties().get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x01b7, code lost:
    
        r15.put(r3, r9);
        p653ta.C13000a.m78149d(r21.mReporter, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x01bf, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void download(java.io.File r22, java.lang.String r23, boolean r24) throws fk.C9721b {
        /*
            Method dump skipped, instructions count: 745
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.drive.clouddisk.expand.CloudDriveMediaDownloader.download(java.io.File, java.lang.String, boolean):void");
    }

    public Asset getAsset() {
        return this.asset;
    }

    public String getDownloadAddressURL() {
        Resource resource;
        EndpointUrl downloadUrl;
        Asset asset = this.asset;
        return (asset == null || (resource = asset.getResource()) == null || (downloadUrl = resource.getDownloadUrl()) == null) ? "" : downloadUrl.getUrl();
    }

    public String getTag() {
        return TAG;
    }

    public FileExpand initAsset(String str, boolean z10, boolean z11) throws C9721b, IOException {
        String str2;
        String str3;
        C11839m.m70688i(TAG, "initAsset");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z10) {
            str2 = "smallThumbnailDownloadLink,thumbnailDownloadLink,id,attachments(usage,asset(properties,attributes,cipher,id,versionId,resource(type,attributes,id,state,hash,sha256,length,digest,objects,sliceSize,layers(id,state,seq,length,sha256,sliceSize,objects),downloadUrl)))";
            str3 = "thumbnail";
        } else {
            str2 = "contentDownloadLink,id,attachments(usage,asset(properties,attributes,cipher,id,versionId,resource(type,attributes,id,state,hash,sha256,length,digest,objects,sliceSize,layers(id,state,seq,length,sha256,sliceSize,objects),downloadUrl)))";
            str3 = "content";
        }
        DriveRequest<FileExpand> fields2 = this.drive.filesExpand().getEx(str).setUsage(str3).setFields2(str2);
        if (z11) {
            C4609l headers = fields2.getHeaders();
            headers.set("x-hw-open-app-id", C13142a.f59637b);
            fields2.setHeaders(headers);
        }
        FileExpand fileExpand = (FileExpand) new SyncDriveRequest(fields2).execute();
        C11839m.m70686d(TAG, "query asset cost：" + (System.currentTimeMillis() - jCurrentTimeMillis));
        List<Attachment> attachments = fileExpand.getAttachments();
        if (attachments == null) {
            C11839m.m70686d(TAG, "has no attachments");
            C11839m.m70688i(TAG, "use file proxy url download process.");
            this.downloadType = DownloadType.URL;
            return fileExpand;
        }
        String str4 = TextUtils.isEmpty(this.attachmentName) ? "content" : "thumbnail";
        for (Attachment attachment : attachments) {
            if (attachment.getUsage().equals(str4)) {
                Asset asset = attachment.getAsset();
                this.asset = asset;
                asset.setName(this.attachmentName);
            }
        }
        dealDownloadType();
        return fileExpand;
    }

    public boolean isSupportV2() {
        DownloadType downloadType = this.downloadType;
        return downloadType == DownloadType.LAYER || downloadType == DownloadType.ASSET || downloadType == DownloadType.PLAINTEXT_ASSET;
    }

    @Override // com.huawei.android.hicloud.drive.clouddisk.asset.AssetMetadataTransport
    public Resource onRefreshDownloadUrl(String str, String str2, String str3, Asset asset, boolean z10) throws C9721b, IOException {
        DriveExpand.Revisions.Get get = this.drive.revisions().get(str, str2, str3, "attributes,cipher,id,versionId,resource(attributes,id,state,hash,sha256,length,digest,objects,sliceSize,layers(id,state,seq,length,sha256,sliceSize,objects))");
        if (z10) {
            C4609l headers = get.getHeaders();
            headers.set("x-hw-open-app-id", C13142a.f59637b);
            get.setHeaders(headers);
        }
        return ((Asset) new SyncDriveRequest(get).execute()).getResource();
    }

    public void setListener(AssetDownloaderProgressListener assetDownloaderProgressListener) {
        this.mListener = assetDownloaderProgressListener;
    }
}
