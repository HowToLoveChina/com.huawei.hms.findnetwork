package p650t7;

import android.os.Bundle;
import com.huawei.android.hicloud.album.service.p075vo.CreateBatchResponse;
import com.huawei.android.hicloud.drive.cloudphoto.model.AlbumBatchId;
import com.huawei.android.hicloud.drive.cloudphoto.request.Albums;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hms.api.ConnectionResult;
import java.io.IOException;
import p031b7.C1120a;
import p031b7.C1122c;
import p546p6.C12106s;
import p546p6.EnumC12107t;

/* renamed from: t7.c */
/* loaded from: classes2.dex */
public class C12957c extends AbstractC12988v {

    /* renamed from: g */
    public String f59023g;

    /* renamed from: h */
    public String f59024h;

    public C12957c(String str, String str2) {
        this.f59023g = str;
        this.f59024h = str2;
    }

    /* JADX WARN: Finally extract failed */
    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() throws Exception {
        String string;
        String string2 = "OK";
        this.f59133f = new Bundle();
        int iM6802l0 = 0;
        Integer id2 = 0;
        long jM28458c = 0;
        try {
            try {
                Albums.BatchIds header = this.f61708b.m83547d().batchIds().setAlbumId(this.f59023g).setHeader("x-hw-lock", C12106s.m72509c().m72513e(EnumC12107t.SHARE_SYNC_SDK, false).getSessionId()).setHeader("x-hw-album-owner-Id", this.f59024h);
                header.setRiskToken();
                AlbumBatchId albumBatchIdExecute = header.execute();
                C1120a.m6675d("BatchCreateExecutor", "AlbumBatchId: " + albumBatchIdExecute.toString());
                id2 = albumBatchIdExecute.getId();
                jM28458c = albumBatchIdExecute.getBatchTime().m28458c();
            } catch (IOException e10) {
                if (e10 instanceof C4616s) {
                    iM6802l0 = C1122c.m6802l0((C4616s) e10);
                    string = e10.toString();
                } else {
                    iM6802l0 = C1122c.m6845x0(e10);
                    string = e10.toString();
                }
                string2 = string;
            } catch (Exception e11) {
                C1120a.m6676e("BatchCreateExecutor", "BatchCreateExecutor runTask Exception: " + e11.toString());
                iM6802l0 = ConnectionResult.NETWORK_ERROR;
                string2 = e11.toString();
            }
            this.f59133f.putInt("code", iM6802l0);
            this.f59133f.putString("info", string2);
            CreateBatchResponse createBatchResponse = new CreateBatchResponse(iM6802l0, string2);
            createBatchResponse.setBatchId(id2.intValue());
            createBatchResponse.setBatchCtime(jM28458c);
            this.f59133f.putParcelable("CreateBatchResponse", createBatchResponse);
            this.f59133f.putInt("code", iM6802l0);
            this.f59133f.putString("info", string2);
            return "";
        } catch (Throwable th2) {
            this.f59133f.putInt("code", 0);
            this.f59133f.putString("info", "OK");
            throw th2;
        }
    }
}
