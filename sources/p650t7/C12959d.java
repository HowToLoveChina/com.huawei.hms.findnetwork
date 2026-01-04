package p650t7;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.FileUpdatedResult;
import com.huawei.android.hicloud.album.service.p075vo.Version;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.drive.cloudphoto.request.CloudPhotoBatch;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hms.api.ConnectionResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p009a8.C0065c;
import p009a8.C0068f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p546p6.C12106s;
import p671u7.C13130b;
import p804ya.AbstractC13926c;

/* renamed from: t7.d */
/* loaded from: classes2.dex */
public class C12959d extends AbstractC12988v {

    /* renamed from: g */
    public List<FileData> f59034g;

    /* renamed from: h */
    public List<FileUpdatedResult> f59035h;

    /* renamed from: i */
    public List<FileData> f59036i = new ArrayList();

    /* renamed from: t7.d$a */
    public static class a extends AbstractC13926c<Media> {

        /* renamed from: a */
        public FileData f59037a;

        /* renamed from: b */
        public ArrayList<FileUpdatedResult> f59038b;

        /* renamed from: c */
        public List<FileData> f59039c;

        public a(ArrayList<FileUpdatedResult> arrayList, FileData fileData, List<FileData> list) {
            this.f59037a = fileData;
            this.f59038b = arrayList;
            this.f59039c = list;
        }

        @Override // p804ya.AbstractC13926c
        /* renamed from: a */
        public void mo74862a(ErrorResp.Error error, C4609l c4609l) {
            Integer code = error.getCode();
            String description = error.getDescription();
            C1120a.m6676e("CopyFilesExecutor", "file.copy error: " + code + ", info: " + description);
            if (404 == code.intValue()) {
                C0065c.m432a().m434c(String.valueOf(code), this.f59037a.getFileId(), this.f59037a.getSize());
                code = 2002;
            }
            this.f59038b.add(new FileUpdatedResult(this.f59037a.getLocalId(), this.f59037a.getUniqueId(), code.intValue(), description));
            this.f59039c.add(this.f59037a);
        }

        @Override // p369ii.InterfaceC10510a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Media media, C4609l c4609l) {
            FileUpdatedResult fileUpdatedResult = new FileUpdatedResult(media.getFileName(), media.getId(), this.f59037a.getLocalId(), "", String.valueOf(media.getEditedTime().m28458c()), true);
            if (media.getRecycledTime() != null) {
                fileUpdatedResult.setRecycletime(String.valueOf(media.getRecycledTime().m28458c()));
            }
            this.f59038b.add(fileUpdatedResult);
        }
    }

    public C12959d(List<FileData> list, List<FileUpdatedResult> list2) {
        this.f59034g = list;
        this.f59035h = list2;
    }

    /* renamed from: t */
    public static void m77896t(ArrayList<FileUpdatedResult> arrayList, List<FileData> list) {
        if (!Version.isSupportTimeStamp() || arrayList == null || arrayList.size() == 0 || list == null || list.size() == 0) {
            return;
        }
        Iterator<FileUpdatedResult> it = arrayList.iterator();
        while (it.hasNext()) {
            FileUpdatedResult next = it.next();
            Iterator<FileData> it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    FileData next2 = it2.next();
                    if (!TextUtils.isEmpty(next2.getLocalId()) && next2.getLocalId().equals(next.getLocalId())) {
                        next.setTimestamp(next2.getTimestamp());
                        break;
                    }
                }
            }
        }
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() throws Exception {
        List<FileUpdatedResult> list;
        this.f59133f = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        try {
            try {
                try {
                    CloudPhotoBatch cloudPhotoBatchM83551h = this.f61708b.m83551h();
                    int size = this.f59034g.size();
                    int i10 = 0;
                    for (FileData fileData : this.f59034g) {
                        Media media = new Media();
                        String albumId = fileData.getAlbumId();
                        if ("default-album-3".equals(albumId)) {
                            media.setAlbumId(fileData.getSrcAlbumId());
                            media.setRecycled(Boolean.TRUE);
                        } else {
                            media.setAlbumId(albumId);
                        }
                        media.setFavorite(Boolean.valueOf(fileData.isFavorite()));
                        media.setFileName(fileData.getFileName());
                        media.setOriginalFilename(fileData.getFileName());
                        C13130b.m78982k(media, fileData.getExpandString(), fileData.getFileType());
                        this.f61708b.m83556m().copy(fileData.getUniqueId() != null ? fileData.getUniqueId() : fileData.getFileId(), media).setFields2("fileName,id,editedTime,recycledTime").addHeader("x-hw-lock", (Object) C12106s.m72509c().m72512d(true).getSessionId()).addHeader("x-hw-trace-id", (Object) this.f61710d).queue(cloudPhotoBatchM83551h, new a(arrayList, fileData, this.f59036i));
                        i10++;
                        if (i10 % C1136q.d.m7148l() == 0 || size == i10) {
                            if (cloudPhotoBatchM83551h.size() > 0) {
                                cloudPhotoBatchM83551h.execute();
                                cloudPhotoBatchM83551h = this.f61708b.m83551h();
                                C0068f.m459d().m468l();
                            }
                        }
                    }
                    m77897q();
                    this.f59133f.putInt("code", 0);
                    this.f59133f.putString("info", "OK");
                    m77899s("OK");
                    list = this.f59035h;
                } catch (Exception e10) {
                    C1120a.m6676e("CopyFilesExecutor", "DeleteFilesExecutor runTask Exception: " + e10.toString());
                    String string = e10.toString();
                    for (FileData fileData2 : this.f59034g) {
                        arrayList.add(new FileUpdatedResult(fileData2.getLocalId(), fileData2.getUniqueId(), ConnectionResult.NETWORK_ERROR, string));
                    }
                    this.f59133f.putInt("code", ConnectionResult.NETWORK_ERROR);
                    this.f59133f.putString("info", string);
                    m77899s(string);
                    List<FileUpdatedResult> list2 = this.f59035h;
                    if (list2 != null && list2.size() > 0) {
                    }
                }
            } catch (IOException e11) {
                int iM77898r = m77898r(e11);
                String string2 = e11.toString();
                if (iM77898r != 0) {
                    for (FileData fileData3 : this.f59034g) {
                        arrayList.add(new FileUpdatedResult(fileData3.getLocalId(), fileData3.getUniqueId(), iM77898r, string2));
                    }
                }
                this.f59133f.putInt("code", iM77898r);
                this.f59133f.putString("info", string2);
                m77899s(string2);
                List<FileUpdatedResult> list3 = this.f59035h;
                if (list3 != null && list3.size() > 0) {
                }
            }
            if (list != null && list.size() > 0) {
                arrayList.addAll(this.f59035h);
            }
            m77896t(arrayList, this.f59034g);
            this.f59133f.putParcelableArrayList("FileUpdatedResultList", arrayList);
            return "";
        } catch (Throwable th2) {
            if (0 != 0) {
                for (FileData fileData4 : this.f59034g) {
                    arrayList.add(new FileUpdatedResult(fileData4.getLocalId(), fileData4.getUniqueId(), 0, "OK"));
                }
            }
            this.f59133f.putInt("code", 0);
            this.f59133f.putString("info", "OK");
            m77899s("OK");
            List<FileUpdatedResult> list4 = this.f59035h;
            if (list4 != null && list4.size() > 0) {
                arrayList.addAll(this.f59035h);
            }
            m77896t(arrayList, this.f59034g);
            this.f59133f.putParcelableArrayList("FileUpdatedResultList", arrayList);
            throw th2;
        }
    }

    /* renamed from: q */
    public final void m77897q() {
        Iterator<FileData> it = this.f59034g.iterator();
        while (it.hasNext()) {
            String strM6841w = C1122c.m6841w(it.next());
            Integer numM15193q = SyncSessionManager.m15153t().m15193q(strM6841w, 2);
            int iIntValue = 1;
            if (numM15193q != null) {
                iIntValue = 1 + numM15193q.intValue();
            }
            SyncSessionManager.m15153t().m15166M(strM6841w, Integer.valueOf(iIntValue), 2);
        }
    }

    /* renamed from: r */
    public final int m77898r(IOException iOException) {
        return !(iOException instanceof C4616s) ? C1122c.m6845x0(iOException) : C1122c.m6802l0((C4616s) iOException);
    }

    /* renamed from: s */
    public final void m77899s(String str) {
        if (this.f59036i.size() > 0) {
            this.f59133f.putInt("opsreportcode", 4312);
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<FileData> it = this.f59036i.iterator();
            while (it.hasNext()) {
                stringBuffer.append(C1122c.m6740U0(it.next().getFileId()));
                stringBuffer.append(",");
            }
            this.f59133f.putString("info", str + "Fails:" + stringBuffer.toString());
        }
    }
}
