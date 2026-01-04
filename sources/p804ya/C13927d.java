package p804ya;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.FailRet;
import com.huawei.android.hicloud.connect.progress.Retry;
import com.huawei.android.hicloud.drive.asset.AssetDownloaderProgressListener;
import com.huawei.android.hicloud.drive.asset.AssetMetadataTransport;
import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.hicloud.drive.cloudphoto.model.Attachment;
import com.huawei.android.hicloud.drive.cloudphoto.model.CompressInfo;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.drive.cloudphoto.model.MediaBatchGetResponse;
import com.huawei.android.hicloud.drive.cloudphoto.model.Resource;
import com.huawei.android.hicloud.drive.cloudphoto.model.SingleErrorMessage;
import com.huawei.android.hicloud.drive.cloudphoto.request.Assets;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.manager.CloudAlbumReFoundManager;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import fk.C9721b;
import gp.C10028c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p009a8.C0065c;
import p009a8.C0067e;
import p015ak.C0213f;
import p015ak.C0241z;
import p031b7.C1120a;
import p031b7.C1122c;
import p283fa.C9678a;
import p292fn.C9733f;
import p429kk.C11058a;
import p429kk.C11060c;
import p511o6.C11820b;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: ya.d */
/* loaded from: classes3.dex */
public class C13927d implements AssetMetadataTransport {

    /* renamed from: b */
    public AssetDownloaderProgressListener f62411b;

    /* renamed from: c */
    public String f62412c;

    /* renamed from: d */
    public String f62413d;

    /* renamed from: f */
    public boolean f62415f;

    /* renamed from: a */
    public C13924a f62410a = C9678a.m60442e().m60445d();

    /* renamed from: e */
    public Context f62414e = C0213f.m1377a();

    /* renamed from: ya.d$a */
    public class a extends AbstractC13926c<Media> {

        /* renamed from: a */
        public final /* synthetic */ String f62416a;

        /* renamed from: b */
        public final /* synthetic */ boolean f62417b;

        /* renamed from: c */
        public final /* synthetic */ FileInfo f62418c;

        /* renamed from: d */
        public final /* synthetic */ ArrayList f62419d;

        /* renamed from: e */
        public final /* synthetic */ int f62420e;

        /* renamed from: f */
        public final /* synthetic */ Map f62421f;

        /* renamed from: g */
        public final /* synthetic */ Map f62422g;

        public a(String str, boolean z10, FileInfo fileInfo, ArrayList arrayList, int i10, Map map, Map map2) {
            this.f62416a = str;
            this.f62417b = z10;
            this.f62418c = fileInfo;
            this.f62419d = arrayList;
            this.f62420e = i10;
            this.f62421f = map;
            this.f62422g = map2;
        }

        @Override // p804ya.AbstractC13926c
        /* renamed from: a */
        public void mo74862a(ErrorResp.Error error, C4609l c4609l) throws IOException {
            try {
                FailRet failRet = new FailRet();
                if ("content".equals(this.f62416a) && this.f62417b) {
                    C0065c.m432a().m434c(String.valueOf(error.getCode()), this.f62418c.getFileId(), this.f62418c.getSize());
                }
                failRet.setUniqueId(C1122c.m6814o0(this.f62418c));
                this.f62419d.add(failRet);
                C1120a.m6676e("CloudPhotoMediaDownloader", "getDownloadInfo JsonBatchCallback onFailure" + error.toString());
                C13927d.this.m83574c(this.f62420e, this.f62418c);
                C0067e.m443e().m444a(this.f62418c, this.f62420e, error.getCode().intValue());
            } catch (Exception e10) {
                C1120a.m6676e("CloudPhotoMediaDownloader", "CloudPhotoJsonBatchCallback Exception:" + e10.getMessage());
            }
        }

        @Override // p369ii.InterfaceC10510a
        /* renamed from: c */
        public void onSuccess(Media media, C4609l c4609l) throws IOException {
            C13927d.this.m83584m(media, c4609l, this.f62416a, this.f62421f, this.f62422g, this.f62418c);
        }
    }

    public C13927d(String str) {
        this.f62412c = str;
    }

    /* renamed from: c */
    public final void m83574c(int i10, FileInfo fileInfo) {
        String strM70401f = C11820b.m70401f(fileInfo.getAlbumId(), fileInfo.getUniqueId(), i10);
        Integer numM15193q = SyncSessionManager.m15153t().m15193q(strM70401f, 5);
        SyncSessionManager.m15153t().m15166M(strM70401f, Integer.valueOf(numM15193q != null ? 1 + numM15193q.intValue() : 1), 5);
    }

    /* renamed from: d */
    public final void m83575d(List<FileInfo> list, int i10, int i11) {
        if (list.size() == 1) {
            m83574c(i10, list.get(0));
            C0067e.m443e().m444a(list.get(0), i10, i11);
        }
    }

    /* renamed from: e */
    public final void m83576e(MediaBatchGetResponse mediaBatchGetResponse, C4609l c4609l, Map<String, FileInfo> map, String str, int i10, ArrayList<FailRet> arrayList, Map<String, Asset> map2, Map<String, String> map3) {
        List<SingleErrorMessage> failedMedia = mediaBatchGetResponse.getFailedMedia();
        if (failedMedia != null && !failedMedia.isEmpty()) {
            C1120a.m6675d("CloudPhotoMediaDownloader", "failedMedias size:" + failedMedia.size());
            for (SingleErrorMessage singleErrorMessage : failedMedia) {
                try {
                    if (singleErrorMessage.getId() == null) {
                        C1120a.m6676e("CloudPhotoMediaDownloader", "batchParseAssetAttachments:fields id is null");
                    } else {
                        FileInfo fileInfo = map.get(singleErrorMessage.getId());
                        if (fileInfo == null) {
                            C1120a.m6676e("CloudPhotoMediaDownloader", "batchParseAssetAttachments:mapRequest do not have the id where is from errorMessage");
                        } else {
                            FailRet failRet = new FailRet();
                            String userID = fileInfo.getUserID();
                            boolean zEquals = !TextUtils.isEmpty(userID) ? userID.equals(C13452e.m80781L().m80971t0()) : true;
                            try {
                                if ("content".equals(str) && zEquals) {
                                    C0065c.m432a().m434c(String.valueOf(singleErrorMessage.getError().getCode()), fileInfo.getFileId(), fileInfo.getSize());
                                }
                                failRet.setUniqueId(C1122c.m6814o0(fileInfo));
                                try {
                                    arrayList.add(failRet);
                                    C1120a.m6676e("CloudPhotoMediaDownloader", "getDownloadInfo JsonBatchCallback onFailure" + singleErrorMessage.getError().toString());
                                    try {
                                        m83574c(i10, fileInfo);
                                        C0067e.m443e().m444a(fileInfo, i10, singleErrorMessage.getError().getCode().intValue());
                                    } catch (Exception e10) {
                                        e = e10;
                                        C1120a.m6676e("CloudPhotoMediaDownloader", "batchParseAssetAttachments failedMedias Exception:" + e.getMessage());
                                    }
                                } catch (Exception e11) {
                                    e = e11;
                                }
                            } catch (Exception e12) {
                                e = e12;
                                C1120a.m6676e("CloudPhotoMediaDownloader", "batchParseAssetAttachments failedMedias Exception:" + e.getMessage());
                            }
                        }
                    }
                } catch (Exception e13) {
                    e = e13;
                }
            }
        }
        List<Media> media = mediaBatchGetResponse.getMedia();
        if (media == null || media.isEmpty()) {
            return;
        }
        C1120a.m6675d("CloudPhotoMediaDownloader", "succeedMedias size:" + media.size());
        for (Media media2 : media) {
            try {
            } catch (Exception e14) {
                C1120a.m6676e("CloudPhotoMediaDownloader", "batchParseAssetAttachments succeedMedias Exception:" + e14.getMessage());
            }
            if (media2.getId() == null) {
                C1120a.m6676e("CloudPhotoMediaDownloader", "batchParseAssetAttachments:fields id is null");
            } else if (map.get(media2.getId()) == null) {
                C1120a.m6676e("CloudPhotoMediaDownloader", "batchParseAssetAttachments:mapRequest do not have the id where is from succeedMedias");
            } else {
                m83584m(media2, c4609l, str, map2, map3, map.get(media2.getId()));
            }
        }
    }

    /* renamed from: f */
    public final boolean m83577f(Attachment attachment) {
        return (attachment == null || attachment.getAsset() == null) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x0228 A[Catch: all -> 0x0249, TRY_ENTER, TryCatch #5 {all -> 0x0249, blocks: (B:125:0x021e, B:128:0x0228, B:131:0x022f, B:135:0x0269, B:136:0x0288, B:134:0x024b), top: B:151:0x021e }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x024b A[Catch: all -> 0x0249, TryCatch #5 {all -> 0x0249, blocks: (B:125:0x021e, B:128:0x0228, B:131:0x022f, B:135:0x0269, B:136:0x0288, B:134:0x024b), top: B:151:0x021e }] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m83578g(java.io.File r37, java.lang.String r38, com.huawei.android.hicloud.drive.cloudphoto.model.Asset r39, int r40, java.util.Map<java.lang.String, java.lang.String> r41, com.huawei.android.p069cg.p072vo.FileInfo r42) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 833
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p804ya.C13927d.m83578g(java.io.File, java.lang.String, com.huawei.android.hicloud.drive.cloudphoto.model.Asset, int, java.util.Map, com.huawei.android.cg.vo.FileInfo):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:313:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x03cf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:341:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:379:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r31v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r31v3 */
    /* JADX WARN: Type inference failed for: r31v4 */
    /* JADX WARN: Type inference failed for: r31v5 */
    /* JADX WARN: Type inference failed for: r31v7 */
    /* JADX WARN: Type inference failed for: r31v8 */
    /* JADX WARN: Type inference failed for: r31v9 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m83579h(java.util.List<com.huawei.android.p069cg.p072vo.FileInfo> r27, int r28, java.util.Map<java.lang.String, com.huawei.android.hicloud.drive.cloudphoto.model.Asset> r29, java.util.Map<java.lang.String, java.lang.String> r30, boolean r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1067
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p804ya.C13927d.m83579h(java.util.List, int, java.util.Map, java.util.Map, boolean):void");
    }

    /* renamed from: i */
    public final String m83580i(Resource resource) {
        return (resource == null || resource.getDownloadUrl() == null || TextUtils.isEmpty(resource.getDownloadUrl().getUrl())) ? "" : resource.getDownloadUrl().getUrl();
    }

    /* renamed from: j */
    public final boolean m83581j(int i10) {
        if (CloudAlbumReFoundManager.m14515b().m14519e()) {
            for (String str : C1122c.m6686C0()) {
                if (str.equals(String.valueOf(i10))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: k */
    public final boolean m83582k(C9721b c9721b, Retry retry) {
        return 1001 == c9721b.m60659c() || 401 == c9721b.m60663g() || !retry.m16233b(false);
    }

    /* renamed from: l */
    public final boolean m83583l(String str) {
        return str.equals("smallthumbnail") || str.equals("thumbnail") || str.equals("largethumbnail");
    }

    /* renamed from: m */
    public final void m83584m(Media media, C4609l c4609l, String str, Map<String, Asset> map, Map<String, String> map2, FileInfo fileInfo) {
        List<Attachment> attachments = media.getAttachments();
        if (attachments == null) {
            C1120a.m6676e("CloudPhotoMediaDownloader", "attachments is null");
            return;
        }
        if (c4609l != null) {
            String strM28237v = c4609l.m28237v("x-hw-quicswitch");
            C1120a.m6675d("CloudPhotoMediaDownloader", "parseAssetAttachments isUseQuic = " + strM28237v);
            fileInfo.setUseQuic(C0241z.m1685c(strM28237v) == 1);
        } else {
            C1120a.m6678w("CloudPhotoMediaDownloader", "parseAssetAttachments lastHeaders is null");
        }
        HashMap map3 = new HashMap();
        for (Attachment attachment : attachments) {
            map3.put(attachment.getUsage(), attachment);
        }
        if (map3.containsKey(str)) {
            Attachment attachment2 = (Attachment) map3.get(str);
            m83594w(fileInfo, attachment2);
            if (!m83577f(attachment2)) {
                C1120a.m6676e("CloudPhotoMediaDownloader", "attachment or assert is null");
                fileInfo.setNeedAT(true);
                fileInfo.setNotEncrypted(C10028c.m62182c0().m62420y1());
                fileInfo.setDownloadCheckSize(media.getSize());
                fileInfo.setHashId(media.getHashId());
                fileInfo.setSha256(media.getSha256());
                map2.put(media.getId(), media.getContentDownloadLink());
                return;
            }
            if (!m83581j(media.getStatus().intValue())) {
                m83585n(media, attachment2.getAsset(), map, map2, fileInfo, str);
                return;
            }
            C1120a.m6677i("CloudPhotoMediaDownloader", "parseAssetAttachments status: " + media.getStatus());
            fileInfo.setNeedAT(true);
            fileInfo.setLostData(true);
            m83588q(fileInfo, attachment2.getAsset());
            map2.put(media.getId(), media.getContentDownloadLink());
            return;
        }
        if (str.equals("smallthumbnail")) {
            Attachment attachment3 = (Attachment) map3.get("thumbnail");
            if (m83577f(attachment3)) {
                m83594w(fileInfo, attachment3);
                Asset asset = attachment3.getAsset();
                asset.setName("small");
                m83585n(media, asset, map, map2, fileInfo, str);
                return;
            }
            m83594w(fileInfo, (Attachment) map3.get("content"));
            fileInfo.setNotEncrypted(C10028c.m62182c0().m62420y1());
            map2.put(media.getId(), media.getSmallThumbnailDownloadLink());
            fileInfo.setReplaceUrl(media.getContentDownloadLink());
            return;
        }
        if (str.equals("largethumbnail")) {
            Attachment attachment4 = (Attachment) map3.get("thumbnail");
            if (m83577f(attachment4)) {
                m83594w(fileInfo, attachment4);
                Asset asset2 = ((Attachment) map3.get("thumbnail")).getAsset();
                asset2.setName("large");
                m83585n(media, asset2, map, map2, fileInfo, str);
                return;
            }
            m83594w(fileInfo, (Attachment) map3.get("content"));
            fileInfo.setNotEncrypted(C10028c.m62182c0().m62420y1());
            map2.put(media.getId(), media.getThumbnailDownloadLink());
            fileInfo.setReplaceUrl(media.getContentDownloadLink());
        }
    }

    /* renamed from: n */
    public final void m83585n(Media media, Asset asset, Map<String, Asset> map, Map<String, String> map2, FileInfo fileInfo, String str) {
        String id2 = media.getId();
        if (m83581j(asset.getStatus().intValue()) && ("largethumbnail".equals(str) || "smallthumbnail".equals(str))) {
            map2.put(id2, "largethumbnail".equals(str) ? media.getThumbnailDownloadLink() : media.getSmallThumbnailDownloadLink());
            fileInfo.setLostData(true);
            return;
        }
        if (asset.getResource() == null) {
            C1120a.m6676e("CloudPhotoMediaDownloader", "has no resource");
            return;
        }
        Integer type = asset.getResource().getType();
        m83586o(fileInfo, str, asset);
        m83588q(fileInfo, asset);
        if (type != null && (type.intValue() == 0 || (CloudAlbumSettings.m14363h().m14375k() && type.intValue() == 6))) {
            map.put(id2, asset);
            return;
        }
        if (!"content".equals(str)) {
            if ("largethumbnail".equals(str)) {
                map2.put(id2, media.getThumbnailDownloadLink());
                fileInfo.setReplaceUrl(media.getContentDownloadLink());
                return;
            } else {
                map2.put(id2, media.getSmallThumbnailDownloadLink());
                fileInfo.setReplaceUrl(media.getContentDownloadLink());
                return;
            }
        }
        fileInfo.setDownloadCheckSize(media.getSize());
        fileInfo.setHashId(media.getHashId());
        fileInfo.setSha256(media.getSha256());
        boolean zM60720O = C9733f.m60705z().m60720O("cloudPhotoForceDownloadByFileProxy");
        if (type == null || (!(type.intValue() == 2 || type.intValue() == 1) || zM60720O)) {
            fileInfo.setNeedAT(true);
            map2.put(id2, media.getContentDownloadLink());
            return;
        }
        String strM83580i = m83580i(asset.getResource());
        if (!TextUtils.isEmpty(strM83580i)) {
            map2.put(id2, strM83580i);
        } else {
            fileInfo.setNeedAT(true);
            map2.put(id2, media.getContentDownloadLink());
        }
    }

    /* renamed from: o */
    public final void m83586o(FileInfo fileInfo, String str, Asset asset) {
        Resource resource;
        Integer type;
        if (!"content".equals(str) || (resource = asset.getResource()) == null || (type = resource.getType()) == null || 6 != type.intValue()) {
            return;
        }
        CompressInfo compressInfo = new CompressInfo();
        compressInfo.setCompressedSize(resource.getCompressedSize());
        compressInfo.setEncoding(resource.getEncoding());
        compressInfo.setType(type);
        C11060c c11060cM66626a = C11058a.m66626a(this.f62412c, "media_get_compress_info", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("101_0:1");
        c11060cM66626a.m66635A("download compress fileName: " + fileInfo.getFileName() + ", albumId: " + fileInfo.getAlbumId() + ", compressInfo: " + compressInfo.toReportString());
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, new LinkedHashMap());
    }

    @Override // com.huawei.android.hicloud.drive.asset.AssetMetadataTransport
    public Asset onCreateUploadUrl(String str, String str2, String str3, Asset asset, AssetMetadataTransport.C2796a c2796a) throws IOException {
        return null;
    }

    @Override // com.huawei.android.hicloud.drive.asset.AssetMetadataTransport
    public Resource onRefreshDownloadUrl(String str, String str2, String str3, Asset asset) throws IOException {
        Assets.Revisions.Get getAddHeader = this.f62410a.m83549f().revisions().get(str, str2, str3, "").addHeader("x-hw-media-owner-Id", (Object) this.f62413d);
        if (this.f62415f) {
            getAddHeader.setAlbumClientHeader(this.f62412c);
        }
        return getAddHeader.execute().getResource();
    }

    @Override // com.huawei.android.hicloud.drive.asset.AssetMetadataTransport
    public void onUploadCompleted(String str, String str2, String str3, Asset asset, boolean z10) throws IOException {
    }

    /* renamed from: p */
    public void m83587p(boolean z10) {
        this.f62415f = z10;
    }

    /* renamed from: q */
    public final void m83588q(FileInfo fileInfo, Asset asset) {
        if (asset == null) {
            C1120a.m6676e("CloudPhotoMediaDownloader", "setEncryptType asset is null");
            return;
        }
        Resource resource = asset.getResource();
        if (resource == null) {
            C1120a.m6676e("CloudPhotoMediaDownloader", "setEncryptType resource is null");
            return;
        }
        Integer type = resource.getType();
        if (type == null) {
            C1120a.m6676e("CloudPhotoMediaDownloader", "setEncryptType type is null");
            return;
        }
        if (C10028c.m62182c0().m62420y1()) {
            boolean z10 = true;
            if (type.intValue() != 1 && type.intValue() != 2) {
                z10 = false;
            }
            fileInfo.setNotEncrypted(z10);
        }
    }

    /* renamed from: r */
    public final void m83589r(C11060c c11060c, C4616s c4616s) {
        c11060c.m66665u("101_4312:1");
        c11060c.m66635A(c4616s.getMessage());
    }

    /* renamed from: s */
    public final void m83590s(C11060c c11060c, IOException iOException) {
        c11060c.m66665u("101_4313:1");
        c11060c.m66635A(iOException.getMessage());
    }

    /* renamed from: t */
    public void m83591t(AssetDownloaderProgressListener assetDownloaderProgressListener) {
        this.f62411b = assetDownloaderProgressListener;
    }

    /* renamed from: u */
    public void m83592u(String str) {
        this.f62413d = str;
    }

    /* renamed from: v */
    public final void m83593v(C11060c c11060c, ArrayList<FailRet> arrayList) {
        if (arrayList.size() > 0) {
            c11060c.m66665u("101_4312:1");
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<FailRet> it = arrayList.iterator();
            while (it.hasNext()) {
                stringBuffer.append(C1122c.m6740U0(it.next().getUniqueId()));
                stringBuffer.append(",");
            }
            c11060c.m66635A("Fails:" + stringBuffer.toString());
        }
    }

    /* renamed from: w */
    public final void m83594w(FileInfo fileInfo, Attachment attachment) {
        if (attachment == null) {
            C1120a.m6676e("CloudPhotoMediaDownloader", "setUploadTime attachment is null");
            return;
        }
        Asset asset = attachment.getAsset();
        if (asset == null) {
            C1120a.m6676e("CloudPhotoMediaDownloader", "setUploadTime asset is null");
            return;
        }
        C4644l createdTime = asset.getCreatedTime();
        if (createdTime == null) {
            C1120a.m6676e("CloudPhotoMediaDownloader", "setUploadTime createdTime is null");
        } else {
            fileInfo.setUploadTime(createdTime);
        }
    }
}
