package com.huawei.android.hicloud.album.service.logic.callable;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import com.huawei.android.hicloud.drive.asset.AssetMetadataTransport;
import com.huawei.android.hicloud.drive.asset.C2798b;
import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.hicloud.drive.cloudphoto.model.Attachment;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.drive.cloudphoto.model.Resource;
import com.huawei.android.hicloud.drive.cloudphoto.request.AlbumAssets;
import com.huawei.android.hicloud.drive.cloudphoto.request.Albums;
import com.huawei.cloud.base.http.C4616s;
import fk.C9721b;
import ga.C9899b;
import hk.C10278a;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import p009a8.C0069g;
import p015ak.C0209d;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1124e;
import p283fa.C9678a;
import p429kk.C11058a;
import p429kk.C11060c;
import p546p6.C12091d;
import p546p6.C12096i;
import p709vj.C13452e;
import p733w9.C13576a;
import p746wn.C13622a;
import p804ya.C13924a;

/* loaded from: classes2.dex */
public class CloudAlbumDownloadBabyHeadPicCallable implements Callable<Object>, AssetMetadataTransport {
    public static final String DEFAULT_HEAD_EXT = ".jpg";
    private static final String NOT_FOUND = "404";
    private static final String TAG = "CloudAlbumDownloadBabyHeadPicCallable";
    private String albumId;
    private String albumOwnerId;
    private String cachePath;
    private C13924a cloudPhoto;
    private Context context;
    private String fileName;
    private ImageView imageView;
    private Media media;
    private C11060c stat;
    private String traceId;

    public CloudAlbumDownloadBabyHeadPicCallable(Context context, String str, ImageView imageView, Media media, String str2) {
        this.context = context;
        this.albumId = str;
        this.imageView = imageView;
        String strM6755Z0 = C1122c.m6755Z0("04019");
        this.traceId = strM6755Z0;
        this.stat = C11058a.m66626a(strM6755Z0, "download_babyHeadPic", C13452e.m80781L().m80971t0());
        this.media = media;
        this.albumOwnerId = str2;
    }

    private boolean checkNeedDownload(Asset asset) {
        if (C1122c.m6837u1(this.cachePath)) {
            try {
                if (C2798b.m16331l(C10278a.m63442h(this.cachePath)).m16340a().equalsIgnoreCase(asset.getResource().getSha256())) {
                    return false;
                }
            } catch (Exception e10) {
                C1120a.m6676e(TAG, "checkNeedDownload " + e10.toString());
            }
            C1122c.m6694F(this.cachePath);
        }
        return true;
    }

    private void downloadAsset(Asset asset) {
        if (!C1122c.m6797k(this.cachePath, true)) {
            C1120a.m6678w(TAG, "downloadBabyHeadPic checkCachePath is invalid ");
            return;
        }
        if (!checkNeedDownload(asset)) {
            C1120a.m6678w(TAG, "downloadBabyHeadPic no need ");
            return;
        }
        try {
            C9899b c9899b = new C9899b(this, this.albumId, asset, 0L, true, false, 0);
            c9899b.m61463b0(this.stat);
            c9899b.m61443H(C10278a.m63442h(this.cachePath), asset, 1);
            this.stat.m66665u("0:1");
            this.stat.m66635A("OK");
            if (C1122c.m6837u1(this.cachePath)) {
                C1120a.m6675d(TAG, "download cachePath: " + this.cachePath);
                ImageView imageView = this.imageView;
                if (imageView == null || !this.albumId.equals(imageView.getTag())) {
                    return;
                }
                C12091d.q0 q0Var = new C12091d.q0(C0209d.m1311u(this.cachePath), this.imageView);
                Activity activityM6730R = C1122c.m6730R(this.imageView);
                if (activityM6730R != null) {
                    activityM6730R.runOnUiThread(q0Var);
                }
            }
        } catch (C9721b e10) {
            C1120a.m6676e(TAG, "download file end CException:" + e10.toString());
            if (String.valueOf(e10.m60659c()).contains(NOT_FOUND)) {
                this.stat.m66665u("117_" + e10.m60662f() + "_OBS:1");
            } else {
                this.stat.m66665u("117_" + e10.m60662f() + ":1");
            }
            this.stat.m66635A(e10.m60658b() + "=>" + e10.getMessage());
        }
    }

    private void downloadBabyHeadPic() {
        C13924a c13924aM60445d = C9678a.m60442e().m60445d();
        this.cloudPhoto = c13924aM60445d;
        if (c13924aM60445d == null) {
            C1120a.m6676e(TAG, "downloadBabyHeadPic cloudPhoto is null ");
            return;
        }
        try {
            Albums.Get getAddHeader = c13924aM60445d.m83547d().get(this.albumId, "id,albumOwnerId,attachments").addHeader("x-hw-album-owner-Id", (Object) this.albumOwnerId);
            getAddHeader.setAlbumClientHeader(this.traceId);
            List<Attachment> attachments = getAddHeader.execute().getAttachments();
            if (attachments != null && attachments.size() == 1) {
                Attachment attachment = attachments.get(0);
                if (attachment != null && "baby".equals(attachment.getUsage())) {
                    Asset asset = attachment.getAsset();
                    if (asset != null && asset.getResource() != null && asset.getResource().getType() != null && asset.getResource().getType().intValue() == 0) {
                        downloadAsset(asset);
                        return;
                    }
                    C1120a.m6678w(TAG, "downloadBabyHeadPic resource is invalid ");
                    setDefaultHeadPic();
                    return;
                }
                C1120a.m6678w(TAG, "downloadBabyHeadPic usage is invalid ");
                setDefaultHeadPic();
                return;
            }
            C1120a.m6677i(TAG, "downloadBabyHeadPic attachment is null ");
            setDefaultHeadPic();
        } catch (C4616s e10) {
            C1120a.m6676e(TAG, "downloadBabyHeadPic HttpResponseException " + e10.toString());
        } catch (Exception e11) {
            C1120a.m6676e(TAG, "downloadBabyHeadPic Exception " + e11.toString());
        }
    }

    private void setDefaultHeadPic() {
        if (this.media != null) {
            this.imageView.setTag(C0069g.m479y().m480A(this.media));
            C12096i.m72418I().m72474x(this.media, this.imageView);
        }
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        this.fileName = this.albumId + DEFAULT_HEAD_EXT;
        this.cachePath = C1124e.m6871o(this.context) + "/.cloudShare/thumb/headPic/" + this.fileName;
        C1120a.m6675d(TAG, "fileName: " + this.fileName + ", cachePath: " + this.cachePath);
        C13576a c13576aM81565a = C13576a.m81565a();
        if (!c13576aM81565a.m81566b(this.cachePath)) {
            C1120a.m6676e(TAG, "download file [" + this.cachePath + "] path repeat.");
            return null;
        }
        try {
            if (C1122c.m6837u1(this.cachePath)) {
                C1120a.m6675d(TAG, "already exist cachePath: " + this.cachePath);
                ImageView imageView = this.imageView;
                if (imageView != null && this.albumId.equals(imageView.getTag())) {
                    C12091d.q0 q0Var = new C12091d.q0(C0209d.m1311u(this.cachePath), this.imageView);
                    Activity activityM6730R = C1122c.m6730R(this.imageView);
                    if (activityM6730R != null) {
                        activityM6730R.runOnUiThread(q0Var);
                    }
                }
            }
            downloadBabyHeadPic();
            c13576aM81565a.m81568d(this.cachePath);
            HashMap map = new HashMap();
            map.put("thumbType", "babyHeadPic");
            map.put("albumId", this.albumId);
            C13622a.m81969o(C0213f.m1377a(), this.stat, map);
            return null;
        } catch (Throwable th2) {
            c13576aM81565a.m81568d(this.cachePath);
            HashMap map2 = new HashMap();
            map2.put("thumbType", "babyHeadPic");
            map2.put("albumId", this.albumId);
            C13622a.m81969o(C0213f.m1377a(), this.stat, map2);
            throw th2;
        }
    }

    public String getTag() {
        return TAG;
    }

    @Override // com.huawei.android.hicloud.drive.asset.AssetMetadataTransport
    public Asset onCreateUploadUrl(String str, String str2, String str3, Asset asset, AssetMetadataTransport.C2796a c2796a) {
        return null;
    }

    @Override // com.huawei.android.hicloud.drive.asset.AssetMetadataTransport
    public Resource onRefreshDownloadUrl(String str, String str2, String str3, Asset asset) throws IOException {
        AlbumAssets.Revisions.Get getAddHeader = this.cloudPhoto.m83545b().revisions().get(str, str2, str3, "").addHeader("x-hw-album-owner-Id", (Object) this.albumOwnerId);
        getAddHeader.setAlbumClientHeader(this.traceId);
        return getAddHeader.execute().getResource();
    }

    public Resource onRefreshUploadUrl(String str, String str2, String str3, Asset asset) {
        return null;
    }

    @Override // com.huawei.android.hicloud.drive.asset.AssetMetadataTransport
    public void onUploadCompleted(String str, String str2, String str3, Asset asset, boolean z10) {
    }
}
