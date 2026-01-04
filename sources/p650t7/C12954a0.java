package p650t7;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.FileUpdatedResult;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.drive.cloudphoto.model.MediaBatchUpdateRequest;
import com.huawei.android.hicloud.drive.cloudphoto.model.MediaBatchUpdateResponse;
import com.huawei.android.hicloud.drive.cloudphoto.model.SingleErrorMessage;
import com.huawei.android.hicloud.drive.cloudphoto.request.CloudPhotos;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.location.LocationRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import p009a8.C0065c;
import p009a8.C0068f;
import p031b7.C1120a;
import p031b7.C1122c;
import p546p6.C12106s;
import p671u7.C13130b;
import p804ya.AbstractC13926c;

/* renamed from: t7.a0 */
/* loaded from: classes2.dex */
public class C12954a0 extends AbstractC12988v {

    /* renamed from: g */
    public List<FileData> f58998g;

    /* renamed from: h */
    public String f58999h;

    /* renamed from: i */
    public List<FileData> f59000i = new ArrayList();

    /* renamed from: j */
    public int f59001j = 10;

    /* renamed from: t7.a0$a */
    public static class a extends AbstractC13926c<Media> {

        /* renamed from: a */
        public FileData f59002a;

        /* renamed from: b */
        public ArrayList<FileUpdatedResult> f59003b;

        /* renamed from: c */
        public List<FileData> f59004c;

        public a(FileData fileData, ArrayList<FileUpdatedResult> arrayList, List<FileData> list) {
            this.f59002a = fileData;
            this.f59003b = arrayList;
            this.f59004c = list;
        }

        @Override // p804ya.AbstractC13926c
        /* renamed from: a */
        public void mo74862a(ErrorResp.Error error, C4609l c4609l) {
            List<ErrorResp.ErrorMsg> errorDetail;
            ErrorResp.ErrorMsg errorMsg;
            Integer code = error.getCode();
            if (404 == code.intValue() && (errorDetail = error.getErrorDetail()) != null && !errorDetail.isEmpty() && (errorMsg = errorDetail.get(0)) != null && !TextUtils.isEmpty(errorMsg.getErrorParam())) {
                String errorParam = errorMsg.getErrorParam();
                if ("mediaId".equals(errorParam)) {
                    C0065c.m432a().m434c(String.valueOf(error.getCode()), this.f59002a.getFileId(), this.f59002a.getSize());
                    code = Integer.valueOf(LocationRequest.PRIORITY_MAG_POSITION);
                } else if ("albumId".equals(errorParam)) {
                    code = 302;
                }
            }
            this.f59003b.add(new FileUpdatedResult(this.f59002a.getUniqueId(), code.intValue(), error.getDescription()));
            this.f59004c.add(this.f59002a);
        }

        @Override // p369ii.InterfaceC10510a
        /* renamed from: c */
        public void onSuccess(Media media, C4609l c4609l) {
            String albumId = media.getAlbumId();
            Boolean recycled = media.getRecycled();
            if (recycled != null && recycled.booleanValue()) {
                albumId = "default-album-3";
            }
            this.f59003b.add(new FileUpdatedResult(media.getFileName(), media.getId(), albumId, this.f59002a.getAlbumName(), this.f59002a.getLpath()));
        }
    }

    public C12954a0(List<FileData> list, String str) {
        this.f58998g = list;
        this.f58999h = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:230:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0268 A[Catch: all -> 0x0243, TRY_LEAVE, TryCatch #2 {all -> 0x0243, blocks: (B:225:0x01c7, B:242:0x024c, B:244:0x0268, B:247:0x0271), top: B:265:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0271 A[Catch: all -> 0x0243, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0243, blocks: (B:225:0x01c7, B:242:0x024c, B:244:0x0268, B:247:0x0271), top: B:265:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x02d7  */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.os.BaseBundle, android.os.Bundle] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String mo77876l() throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 800
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p650t7.C12954a0.mo77876l():java.lang.String");
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: m */
    public Bundle mo77877m() {
        try {
            m77878q();
            ArrayList parcelableArrayList = this.f59133f.getParcelableArrayList("FileUpdatedResultList");
            if (parcelableArrayList != null) {
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    FileUpdatedResult fileUpdatedResult = (FileUpdatedResult) it.next();
                    if (fileUpdatedResult.getErrCode() == 302) {
                        SyncSessionManager.m15153t().m15177a("cloudphoto.file.batchupdate", this.f58999h, m77879r(fileUpdatedResult.getUniqueId()));
                    }
                }
            }
            return this.f59133f;
        } catch (Exception e10) {
            C1120a.m6676e("ModifyFilesExecutor", "ModifyFilesExecutor getResponseBundle Exception: " + e10);
            return this.f59133f;
        }
    }

    /* renamed from: q */
    public final void m77878q() {
        Iterator<FileData> it = this.f58998g.iterator();
        while (it.hasNext()) {
            String strM6841w = C1122c.m6841w(it.next());
            Integer numM15193q = SyncSessionManager.m15153t().m15193q(strM6841w, 1);
            SyncSessionManager.m15153t().m15166M(strM6841w, Integer.valueOf(numM15193q == null ? 1 : numM15193q.intValue() + 1), 1);
        }
    }

    /* renamed from: r */
    public final String m77879r(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (FileData fileData : this.f58998g) {
            if (str.equals(fileData.getUniqueId())) {
                return fileData.getAlbumId();
            }
        }
        return null;
    }

    /* renamed from: s */
    public final FileData m77880s(Media media) {
        for (FileData fileData : this.f58998g) {
            if (media.getId().equals(fileData.getUniqueId()) || media.getId().equals(fileData.getFileId())) {
                return fileData;
            }
        }
        return null;
    }

    /* renamed from: t */
    public final void m77881t(ArrayList<FileUpdatedResult> arrayList) {
        this.f59133f = new Bundle();
        int i10 = 0;
        while (i10 < this.f58998g.size()) {
            m77882u(this.f58998g, i10, arrayList);
            C0068f.m459d().m468l();
            i10 += this.f59001j;
        }
        if (this.f59000i.size() > 0) {
            this.f59133f.putInt("opsreportcode", 4312);
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<FileData> it = this.f59000i.iterator();
            while (it.hasNext()) {
                stringBuffer.append(C1122c.m6740U0(it.next().getFileId()));
                stringBuffer.append(",");
            }
            String string = this.f59133f.getString("info");
            this.f59133f.putString("info", string + "Fails:" + stringBuffer.toString());
        }
        C1120a.m6675d("ModifyFilesExecutor", "updatedResults size:" + arrayList.size());
    }

    /* renamed from: u */
    public final void m77882u(List<FileData> list, int i10, ArrayList<FileUpdatedResult> arrayList) {
        int iM6845x0;
        String string;
        try {
            try {
                try {
                    C1120a.m6677i("ModifyFilesExecutor", "start initModifyFilesRequest");
                    ArrayList arrayList2 = new ArrayList();
                    CloudPhotos cloudPhotosM83552i = this.f61708b.m83552i();
                    MediaBatchUpdateRequest mediaBatchUpdateRequest = new MediaBatchUpdateRequest();
                    for (int i11 = i10; i11 < list.size() && i11 < this.f59001j + i10; i11++) {
                        m77884w(list.get(i11), arrayList2, new Media());
                        mediaBatchUpdateRequest.setMedia(arrayList2);
                    }
                    CloudPhotos.BatchUpdate batchUpdate = cloudPhotosM83552i.batchUpdate(mediaBatchUpdateRequest, "albumId,fileName,id,recycled");
                    batchUpdate.addHeader("x-hw-lock", C12106s.m72509c().m72512d(true).getSessionId());
                    batchUpdate.setFields2("albumId,fileName,id,recycled");
                    batchUpdate.addHeader("x-hw-trace-id", this.f61710d);
                    m77883v(batchUpdate.execute(), arrayList, list);
                    C1120a.m6675d("ModifyFilesExecutor", "end initModifyFilesRequest medias size:" + arrayList2.size() + " files size:" + list.size());
                    this.f59133f.putInt("code", 0);
                    this.f59133f.putString("info", "OK");
                } catch (Exception e10) {
                    C1120a.m6676e("ModifyFilesExecutor", "ModifyFilesExecutor runTask Exception: " + e10.toString());
                    iM6845x0 = ConnectionResult.NETWORK_ERROR;
                    string = e10.toString();
                    this.f59133f.putInt("code", iM6845x0);
                    this.f59133f.putString("info", string);
                }
            } catch (IOException e11) {
                C1120a.m6676e("ModifyFilesExecutor", "ModifyFilesExecutor runTask IOException: " + e11.toString());
                iM6845x0 = !(e11 instanceof C4616s) ? C1122c.m6845x0(e11) : C1122c.m6802l0((C4616s) e11);
                string = e11.toString();
                this.f59133f.putInt("code", iM6845x0);
                this.f59133f.putString("info", string);
            }
        } catch (Throwable th2) {
            this.f59133f.putInt("code", 0);
            this.f59133f.putString("info", "OK");
            throw th2;
        }
    }

    /* renamed from: v */
    public final void m77883v(MediaBatchUpdateResponse mediaBatchUpdateResponse, ArrayList<FileUpdatedResult> arrayList, List<FileData> list) {
        List<ErrorResp.ErrorMsg> errorDetail;
        ErrorResp.ErrorMsg errorMsg;
        List<SingleErrorMessage> failedMedia = mediaBatchUpdateResponse.getFailedMedia();
        List<Media> media = mediaBatchUpdateResponse.getMedia();
        if (failedMedia != null && failedMedia.size() > 0) {
            for (SingleErrorMessage singleErrorMessage : failedMedia) {
                ErrorResp.Error error = singleErrorMessage.getError();
                Integer code = error.getCode();
                if (404 == code.intValue() && (errorDetail = error.getErrorDetail()) != null && !errorDetail.isEmpty() && (errorMsg = errorDetail.get(0)) != null && !TextUtils.isEmpty(errorMsg.getErrorParam())) {
                    String errorParam = errorMsg.getErrorParam();
                    if ("mediaId".equals(errorParam)) {
                        long size = 0;
                        for (FileData fileData : list) {
                            if (!TextUtils.isEmpty(singleErrorMessage.getId()) && singleErrorMessage.getId().equals(fileData.getFileId())) {
                                size = fileData.getSize();
                            }
                        }
                        C0065c.m432a().m434c(String.valueOf(error.getCode()), singleErrorMessage.getId(), size);
                        code = Integer.valueOf(LocationRequest.PRIORITY_MAG_POSITION);
                    } else if ("albumId".equals(errorParam)) {
                        code = 302;
                    }
                }
                arrayList.add(new FileUpdatedResult(singleErrorMessage.getId(), code.intValue(), error.getDescription()));
                FileData fileData2 = new FileData();
                fileData2.setFileId(singleErrorMessage.getId());
                this.f59000i.add(fileData2);
            }
        }
        if (media == null || media.size() <= 0) {
            return;
        }
        for (Media media2 : media) {
            String albumId = media2.getAlbumId();
            Boolean recycled = media2.getRecycled();
            if (recycled != null && recycled.booleanValue()) {
                albumId = "default-album-3";
            }
            String str = albumId;
            FileData fileDataM77880s = m77880s(media2);
            arrayList.add(fileDataM77880s != null ? new FileUpdatedResult(media2.getFileName(), media2.getId(), str, fileDataM77880s.getAlbumName(), fileDataM77880s.getLpath()) : new FileUpdatedResult(media2.getFileName(), media2.getId(), str, "", ""));
        }
    }

    /* renamed from: w */
    public final void m77884w(FileData fileData, List<Media> list, Media media) throws JSONException, NumberFormatException {
        String uniqueId = fileData.getUniqueId() != null ? fileData.getUniqueId() : fileData.getFileId();
        if ("default-album-3".equals(fileData.getAlbumId())) {
            media.setRecycled(Boolean.TRUE);
        } else {
            media.setRecycled(Boolean.FALSE);
            media.setAlbumId(fileData.getAlbumId());
        }
        media.setId(uniqueId);
        media.setFavorite(Boolean.valueOf(fileData.isFavorite()));
        media.setFileName(fileData.getFileName());
        media.setOriginalFilename(fileData.getFileName());
        C13130b.m78982k(media, fileData.getExpandString(), fileData.getFileType());
        list.add(media);
    }
}
