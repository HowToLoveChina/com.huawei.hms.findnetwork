package p650t7;

import android.os.Bundle;
import android.os.Parcelable;
import com.huawei.android.hicloud.album.service.hihttp.request.response.FileDeleteResponse;
import com.huawei.android.hicloud.album.service.hihttp.request.response.FileFailRet;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.FileUpdatedResult;
import com.huawei.android.hicloud.drive.cloudphoto.request.CloudPhotoBatch;
import com.huawei.android.hicloud.drive.cloudphoto.request.Medias;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.location.LocationRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import p009a8.C0065c;
import p009a8.C0068f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p546p6.C12106s;
import p804ya.AbstractC13926c;

/* renamed from: t7.g */
/* loaded from: classes2.dex */
public class C12965g extends AbstractC12988v {

    /* renamed from: g */
    public List<FileData> f59060g;

    /* renamed from: h */
    public String f59061h;

    /* renamed from: i */
    public int f59062i = 0;

    /* renamed from: j */
    public String f59063j = "OK";

    /* renamed from: t7.g$a */
    public static class a extends AbstractC13926c<Void> {

        /* renamed from: a */
        public FileData f59064a;

        /* renamed from: b */
        public List<FileFailRet> f59065b;

        /* renamed from: c */
        public List<String> f59066c;

        public a(FileData fileData, List<FileFailRet> list, List<String> list2) {
            this.f59064a = fileData;
            this.f59065b = list;
            this.f59066c = list2;
        }

        @Override // p804ya.AbstractC13926c
        /* renamed from: a */
        public void mo74862a(ErrorResp.Error error, C4609l c4609l) {
            FileFailRet fileFailRet = new FileFailRet();
            fileFailRet.setFileName(this.f59064a.getFileName());
            if (error.getCode() == null || error.getCode().intValue() != 404) {
                fileFailRet.setErrCode(1);
            } else {
                C0065c.m432a().m434c(String.valueOf(error.getCode()), this.f59064a.getFileId(), this.f59064a.getSize());
                fileFailRet.setErrCode(LocationRequest.PRIORITY_MAG_POSITION);
            }
            fileFailRet.setHash(this.f59064a.getHash());
            fileFailRet.setUniqueId(this.f59064a.getUniqueId());
            fileFailRet.setErrMsg(error.getDescription());
            this.f59065b.add(fileFailRet);
        }

        @Override // p369ii.InterfaceC10510a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r12, C4609l c4609l) throws IOException {
            this.f59066c.add(this.f59064a.getUniqueId());
        }
    }

    public C12965g(List<FileData> list, String str) {
        this.f59060g = list;
        this.f59061h = str;
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() throws Exception {
        this.f59133f = new Bundle();
        ArrayList arrayList = new ArrayList();
        try {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("start delete file: ");
                int i10 = 0;
                sb2.append(this.f59060g.get(0).getUniqueId());
                C1120a.m6675d("DeleteFilesExecutor", sb2.toString());
                CloudPhotoBatch cloudPhotoBatchM83551h = this.f61708b.m83551h();
                int size = this.f59060g.size();
                ArrayList arrayList2 = new ArrayList();
                for (FileData fileData : this.f59060g) {
                    Medias.Delete delete = this.f61708b.m83556m().delete(fileData.getUniqueId() != null ? fileData.getUniqueId() : fileData.getFileId());
                    delete.addHeader("x-hw-lock", (Object) C12106s.m72509c().m72512d(true).getSessionId());
                    delete.addHeader("x-hw-trace-id", (Object) this.f61710d);
                    delete.queue(cloudPhotoBatchM83551h, new a(fileData, arrayList, arrayList2));
                    i10++;
                    if (i10 % C1136q.d.m7148l() == 0 || size == i10) {
                        if (cloudPhotoBatchM83551h.size() > 0) {
                            cloudPhotoBatchM83551h.execute();
                            cloudPhotoBatchM83551h = this.f61708b.m83551h();
                            C0068f.m459d().m468l();
                        }
                    }
                }
                this.f59133f.putInt("code", this.f59062i);
                this.f59133f.putString("info", this.f59063j);
                FileDeleteResponse fileDeleteResponse = new FileDeleteResponse();
                C1120a.m6675d("DeleteFilesExecutor", "successList.size:" + arrayList2.size() + arrayList2.toString() + " failList.size:" + arrayList.size() + arrayList.toString());
                ArrayList<? extends Parcelable> arrayList3 = new ArrayList<>();
                if (arrayList2.size() > 0) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        arrayList3.add(new FileUpdatedResult((String) it.next()));
                    }
                }
                if (arrayList.size() > 0) {
                    StringBuilder sb3 = new StringBuilder("File fail lists");
                    for (FileFailRet fileFailRet : arrayList) {
                        FileUpdatedResult fileUpdatedResult = new FileUpdatedResult(fileFailRet.getUniqueId(), fileFailRet.getErrCode(), fileFailRet.getErrMsg());
                        arrayList3.add(fileUpdatedResult);
                        sb3.append(", uniqueId: ");
                        sb3.append(fileFailRet.getUniqueId());
                        sb3.append(", errCode: ");
                        sb3.append(fileFailRet.getErrCode());
                        sb3.append(", errMsg: ");
                        sb3.append(fileFailRet.getErrMsg());
                        sb3.append(System.lineSeparator());
                        SyncSessionManager.m15153t().m15177a("cloudphoto.file.batchdelete", this.f59061h, fileFailRet.getUniqueId());
                        if (SyncSessionManager.m15153t().m15155B("cloudphoto.file.batchdelete", this.f59061h, fileFailRet.getUniqueId())) {
                            fileUpdatedResult.setErrCode(140);
                            fileUpdatedResult.setErrMsg("delete the same files.");
                        }
                    }
                    this.f59133f.putString("errMsg", Arrays.toString(arrayList.toArray()));
                    C1120a.m6676e("DeleteFilesExecutor", sb3.toString());
                }
                this.f59133f.putParcelableArrayList("FileUpdatedResultList", arrayList3);
                this.f59133f.putInt("code", fileDeleteResponse.getCode());
                this.f59133f.putString("info", fileDeleteResponse.getInfo());
                this.f59063j += ",Success:" + arrayList2.size();
                m77908q();
            } catch (IOException e10) {
                if (e10 instanceof C4616s) {
                    this.f59062i = C1122c.m6802l0((C4616s) e10);
                    this.f59063j = e10.toString();
                } else {
                    this.f59062i = C1122c.m6845x0(e10);
                    this.f59063j = e10.toString();
                }
            } catch (Exception e11) {
                C1120a.m6676e("DeleteFilesExecutor", "DeleteFilesExecutor runTask Exception: " + e11.toString());
                this.f59062i = ConnectionResult.NETWORK_ERROR;
                this.f59063j = e11.toString();
            }
            m77909r(arrayList);
            return "";
        } catch (Throwable th2) {
            m77909r(arrayList);
            throw th2;
        }
    }

    /* renamed from: q */
    public final void m77908q() {
        Iterator<FileData> it = this.f59060g.iterator();
        while (it.hasNext()) {
            String strM6841w = C1122c.m6841w(it.next());
            Integer numM15193q = SyncSessionManager.m15153t().m15193q(strM6841w, 3);
            int iIntValue = 1;
            if (numM15193q != null) {
                iIntValue = 1 + numM15193q.intValue();
            }
            SyncSessionManager.m15153t().m15166M(strM6841w, Integer.valueOf(iIntValue), 3);
        }
    }

    /* renamed from: r */
    public final void m77909r(List<FileFailRet> list) {
        this.f59133f.putInt("code", this.f59062i);
        this.f59133f.putString("info", this.f59063j);
        if (list.size() > 0) {
            this.f59133f.putInt("opsreportcode", 4312);
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<FileFailRet> it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append(C1122c.m6740U0(it.next().getUniqueId()));
                stringBuffer.append(",");
            }
            this.f59133f.putString("info", this.f59063j + ",Fails:" + stringBuffer.toString());
        }
    }
}
