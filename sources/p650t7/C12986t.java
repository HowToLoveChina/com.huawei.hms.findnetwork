package p650t7;

import android.os.Bundle;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.drive.cloudphoto.request.Medias;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hms.api.ConnectionResult;
import java.io.IOException;
import p031b7.C1120a;
import p031b7.C1122c;

/* renamed from: t7.t */
/* loaded from: classes2.dex */
public class C12986t extends AbstractC12988v {

    /* renamed from: g */
    public FileData f59132g;

    public C12986t(FileData fileData) {
        this.f59132g = fileData;
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() {
        int iM6802l0;
        String string;
        Bundle bundle = new Bundle();
        this.f59133f = bundle;
        bundle.putParcelable("FileInfo", this.f59132g);
        try {
            try {
                try {
                    Medias.Get fields2 = this.f61708b.m83556m().get(this.f59132g.getUniqueId() != null ? this.f59132g.getUniqueId() : this.f59132g.getFileId()).setFields2("signedDownloadLink");
                    fields2.getHeaders().put("x-hw-media-owner-Id", (Object) this.f59132g.getUserID());
                    Media mediaExecute = fields2.execute();
                    C1120a.m6675d("GetVideoPlayUrlExecutor", "media: " + mediaExecute.toString());
                    this.f59133f.putString("PlayUrl", mediaExecute.getSignedDownloadLink());
                    this.f59133f.putInt("code", 0);
                    this.f59133f.putString("info", "OK");
                    return "";
                } catch (IOException e10) {
                    C1120a.m6676e("GetVideoPlayUrlExecutor", "GetVideoPlayUrlExecutor runTask IOException: " + e10.toString());
                    if (e10 instanceof C4616s) {
                        iM6802l0 = C1122c.m6802l0((C4616s) e10);
                        string = e10.toString();
                    } else {
                        iM6802l0 = C1122c.m6845x0(e10);
                        string = e10.toString();
                    }
                    this.f59133f.putInt("code", iM6802l0);
                    this.f59133f.putString("info", string);
                    return "";
                }
            } catch (Exception e11) {
                C1120a.m6676e("GetVideoPlayUrlExecutor", "GetVideoPlayUrlExecutor runTask Exception: " + e11.toString());
                iM6802l0 = ConnectionResult.NETWORK_ERROR;
                string = e11.toString();
                this.f59133f.putInt("code", iM6802l0);
                this.f59133f.putString("info", string);
                return "";
            }
        } catch (Throwable th2) {
            this.f59133f.putInt("code", 0);
            this.f59133f.putString("info", "OK");
            throw th2;
        }
    }
}
