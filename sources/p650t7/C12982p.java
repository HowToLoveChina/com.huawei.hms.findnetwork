package p650t7;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.p075vo.GeneralAlbumData;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.AlbumsList;
import com.huawei.android.hicloud.drive.cloudphoto.request.Albums;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hms.api.ConnectionResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p009a8.C0068f;
import p031b7.C1120a;
import p031b7.C1122c;
import p671u7.C13129a;

/* renamed from: t7.p */
/* loaded from: classes2.dex */
public class C12982p extends AbstractC12988v {
    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() {
        int iM6802l0;
        String string;
        String string2;
        StringBuilder sb2;
        String str;
        StringBuilder sb3 = new StringBuilder();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        this.f59133f = new Bundle();
        try {
            try {
                Albums.List queryParam = this.f61708b.m83547d().list("nextCursor,albums(id,albumName,albumOwnerId,type,localPath,recycled,properties,createdTime,source)").setQueryParam("albumType = 0");
                queryParam.addHeader("x-hw-trace-id", (Object) this.f61710d);
                String nextCursor = null;
                do {
                    AlbumsList albumsListExecute = queryParam.setCursor(nextCursor).execute();
                    C1120a.m6675d("GetGeneralAlbumsExecutor", "albumsList: " + albumsListExecute.toString());
                    List<Album> albums = albumsListExecute.getAlbums();
                    if (albums != null) {
                        C1120a.m6677i("GetGeneralAlbumsExecutor", "albums size: " + albums.size());
                        for (Album album : albums) {
                            if (album != null) {
                                GeneralAlbumData generalAlbumDataM78970k = C13129a.m78970k(album);
                                if (generalAlbumDataM78970k == null) {
                                    C1120a.m6678w("GetGeneralAlbumsExecutor", "album data invalid: " + C1122c.m6740U0(album.getId()));
                                    sb3.append(",");
                                    sb3.append(C1122c.m6740U0(album.getId()));
                                } else {
                                    arrayList.add(generalAlbumDataM78970k);
                                }
                            }
                        }
                    }
                    nextCursor = albumsListExecute.getNextCursor();
                    C0068f.m459d().m468l();
                } while (!TextUtils.isEmpty(nextCursor));
                this.f59133f.putParcelableArrayList("AlbumInfoList", arrayList);
                String string3 = sb3.toString();
                str = TextUtils.isEmpty(string3) ? "OK" : "OK" + string3;
                this.f59133f.putInt("code", 0);
                this.f59133f.putString("info", str);
                return "";
            } catch (IOException e10) {
                C1120a.m6676e("GetGeneralAlbumsExecutor", "GetGeneralAlbumsExecutor runTask IOException: " + e10.toString());
                if (e10 instanceof C4616s) {
                    iM6802l0 = C1122c.m6802l0((C4616s) e10);
                    string = e10.toString();
                } else {
                    iM6802l0 = C1122c.m6845x0(e10);
                    string = e10.toString();
                }
                string2 = sb3.toString();
                if (!TextUtils.isEmpty(string2)) {
                    sb2 = new StringBuilder();
                    sb2.append(string);
                    sb2.append(string2);
                    string = sb2.toString();
                }
                this.f59133f.putInt("code", iM6802l0);
                this.f59133f.putString("info", string);
                return "";
            } catch (Exception e11) {
                C1120a.m6676e("GetGeneralAlbumsExecutor", "GetGeneralAlbumsExecutor runTask Exception: " + e11.toString());
                iM6802l0 = ConnectionResult.NETWORK_ERROR;
                string = e11.toString();
                string2 = sb3.toString();
                if (!TextUtils.isEmpty(string2)) {
                    sb2 = new StringBuilder();
                    sb2.append(string);
                    sb2.append(string2);
                    string = sb2.toString();
                }
                this.f59133f.putInt("code", iM6802l0);
                this.f59133f.putString("info", string);
                return "";
            }
        } catch (Throwable th2) {
            String string4 = sb3.toString();
            str = TextUtils.isEmpty(string4) ? "OK" : "OK" + string4;
            this.f59133f.putInt("code", 0);
            this.f59133f.putString("info", str);
            throw th2;
        }
    }
}
