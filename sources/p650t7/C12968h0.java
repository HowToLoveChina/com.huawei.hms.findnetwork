package p650t7;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.drive.cloudphoto.model.MediaList;
import com.huawei.android.hicloud.drive.cloudphoto.request.Medias;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.api.ConnectionResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p009a8.C0068f;
import p031b7.C1120a;
import p031b7.C1122c;
import p649t6.C12942b;
import p671u7.C13130b;

/* renamed from: t7.h0 */
/* loaded from: classes2.dex */
public class C12968h0 extends AbstractC12988v {

    /* renamed from: g */
    public String f59073g;

    /* renamed from: h */
    public String f59074h;

    /* renamed from: i */
    public int f59075i;

    /* renamed from: j */
    public int f59076j;

    /* renamed from: k */
    public C12942b f59077k;

    public C12968h0(String str, String str2, int i10, int i11, String str3) {
        this.f59073g = str;
        this.f59074h = str2;
        this.f59075i = i10;
        this.f59076j = i11;
        this.f61710d = str3;
        this.f59077k = new C12942b();
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() throws Throwable {
        String strM77757n;
        boolean z10;
        String string = "OK";
        this.f59133f = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        String str = "albumId = '" + this.f59074h + "'";
        int i10 = this.f59075i;
        if (i10 != 0) {
            strM77757n = this.f59077k.m77757n(this.f59074h, i10);
            if (TextUtils.isEmpty(strM77757n)) {
                C1120a.m6678w("ShareFilePageExecutor", "ShareFilePageExecutor transfer nextCursor error, clear cache");
                this.f59133f.putInt("code", FamilyShareConstants.StatusCode.FAMILY_SHARE_NOT_OPEN);
                this.f59133f.putString("info", "start to nextCursor error");
                C1122c.m6821q();
                return "";
            }
        } else {
            this.f59077k.m77753j(this.f59074h);
            strM77757n = null;
        }
        int iM6802l0 = 0;
        try {
            try {
                Medias.List fields2 = this.f61708b.m83556m().list("0").setPageSize(Integer.valueOf(this.f59076j)).setQueryParam(str).setOrderBy("createdTime desc").setCursor(strM77757n).setFields2("nextCursor,media(albumId,createdTime,editedTime,favorite,fileName,fileType,hashId,sha256,id,status,mediaOwnerId,properties,size,source,recycledTime,recycled,creator(userId,displayName),pictureMetadata,videoMetadata,cipher,description)");
                C4609l headers = fields2.getHeaders();
                headers.put("x-hw-album-owner-Id", (Object) this.f59073g);
                headers.set("x-hw-trace-id", this.f61710d);
                MediaList mediaListExecute = fields2.execute();
                if (C1443a.f6214b.booleanValue()) {
                    C1120a.m6675d("ShareFilePageExecutor", "MediaList: " + mediaListExecute.toString());
                }
                List<Media> media = mediaListExecute.getMedia();
                if (media != null) {
                    C1120a.m6677i("ShareFilePageExecutor", "mediaList size: " + media.size());
                    for (Media media2 : media) {
                        if (media2 != null) {
                            arrayList.add(new FileData(C13130b.m78987p(media2, false)));
                        }
                    }
                }
                String nextCursor = mediaListExecute.getNextCursor();
                if (TextUtils.isEmpty(nextCursor)) {
                    this.f59077k.m77753j(this.f59074h);
                    z10 = false;
                } else {
                    int i11 = this.f59075i + this.f59076j;
                    this.f59075i = i11;
                    this.f59077k.m77756m(this.f59074h, i11, nextCursor);
                    z10 = true;
                }
                this.f59133f.putParcelableArrayList("FileInfoList", arrayList);
                this.f59133f.putBoolean("HasMore", z10);
                this.f59133f.putInt("Start", this.f59075i);
                this.f59133f.putString("errMsg", "start: " + i10 + ", size: " + arrayList.size() + ", hasMore: " + z10 + ", cursor: " + C1122c.m6743V0(nextCursor, 6));
            } catch (IOException e10) {
                C1120a.m6676e("ShareFilePageExecutor", "ShareFilePageExecutor runTask IOException: " + e10.toString());
                if (e10 instanceof C4616s) {
                    C4616s c4616s = (C4616s) e10;
                    iM6802l0 = C1122c.m6802l0(c4616s);
                    string = e10.toString();
                    if (m77943n(iM6802l0, c4616s)) {
                        C1120a.m6678w("ShareFilePageExecutor", "ShareFilePageExecutor cursor invalid, clear cache");
                        C1122c.m6821q();
                    }
                } else {
                    iM6802l0 = C1122c.m6845x0(e10);
                    string = e10.toString();
                }
            } catch (Exception e11) {
                C1120a.m6676e("ShareFilePageExecutor", "ShareFilePageExecutor runTask Exception: " + e11.toString());
                iM6802l0 = ConnectionResult.NETWORK_ERROR;
                string = e11.toString();
            }
            this.f59133f.putInt("code", iM6802l0);
            this.f59133f.putString("info", string);
            C0068f.m459d().m468l();
            return "";
        } catch (Throwable th2) {
            this.f59133f.putInt("code", 0);
            this.f59133f.putString("info", "OK");
            throw th2;
        }
    }
}
