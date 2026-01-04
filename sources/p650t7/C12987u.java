package p650t7;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.hihttp.request.response.BaseResponse;
import com.huawei.android.hicloud.album.service.hihttp.request.response.GroupQueryResponse;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
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

/* renamed from: t7.u */
/* loaded from: classes2.dex */
public class C12987u extends AbstractC12988v<GroupQueryResponse> {
    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() {
        int iM6802l0;
        String string;
        String string2;
        StringBuilder sb2;
        String string3 = "OK";
        StringBuilder sb3 = new StringBuilder();
        ArrayList<ShareAlbumData> arrayList = new ArrayList<>();
        this.f59133f = new Bundle();
        try {
            try {
                Albums.List queryParam = this.f61708b.m83547d().list("nextCursor,albums(id,albumName,albumOwnerId,albumVersion,type,ownedByMe,resource,createdTime,source,properties,privilege,onlyFrdCanBeShared,owner(userId,displayName),permissions(userId,displayName,status,role,userAccount))").setQueryParam("albumType = 1 and sharedWithMe = true");
                queryParam.addHeader("x-hw-trace-id", (Object) this.f61710d);
                m77940r(arrayList, queryParam, sb3);
                C1120a.m6677i("GroupAlbumsExecutor", "groupList size: " + arrayList.size());
                this.f59133f.putParcelableArrayList("GroupInfoList", arrayList);
                return "";
            } catch (IOException e10) {
                C1120a.m6676e("GroupAlbumsExecutor", "GroupAlbumsExecutor runTask IOException: " + e10.toString());
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
                C1120a.m6676e("GroupAlbumsExecutor", "GroupAlbumsExecutor runTask Exception: " + e11.toString());
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
        } finally {
            String string4 = sb3.toString();
            if (!TextUtils.isEmpty(string4)) {
                string3 = "OK" + string4;
            }
            this.f59133f.putInt("code", 0);
            this.f59133f.putString("info", string3);
        }
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public GroupQueryResponse mo77904k(Class<BaseResponse> cls) throws Exception {
        int iM6802l0;
        String string;
        String string2;
        StringBuilder sb2;
        C1120a.m6675d("GroupAlbumsExecutor", "GroupAlbumsExecutor execute");
        GroupQueryResponse groupQueryResponse = new GroupQueryResponse();
        String string3 = "OK";
        StringBuilder sb3 = new StringBuilder();
        ArrayList<ShareAlbumData> arrayList = new ArrayList<>();
        this.f59133f = new Bundle();
        try {
            try {
                m77940r(arrayList, this.f61708b.m83547d().list("nextCursor,albums(id,albumName,albumOwnerId,albumVersion,type,ownedByMe,resource,createdTime,source,properties,privilege,onlyFrdCanBeShared,owner(userId,displayName),permissions(userId,displayName,status,role,userAccount))").setQueryParam("albumType = 1 and sharedWithMe = true").addHeader("x-hw-trace-id", (Object) this.f61710d), sb3);
                C1120a.m6677i("GroupAlbumsExecutor", "GroupAlbumsExecutor groupList size: " + arrayList.size());
                groupQueryResponse.setGroupList(arrayList);
            } catch (IOException e10) {
                C1120a.m6676e("GroupAlbumsExecutor", "GroupAlbumsExecutor execute IOException: " + e10.toString());
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
                groupQueryResponse.setCode(iM6802l0);
                groupQueryResponse.setInfo(string);
                return groupQueryResponse;
            } catch (Exception e11) {
                C1120a.m6676e("GroupAlbumsExecutor", "GroupAlbumsExecutor execute Exception: " + e11.toString());
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
                groupQueryResponse.setCode(iM6802l0);
                groupQueryResponse.setInfo(string);
                return groupQueryResponse;
            }
            return groupQueryResponse;
        } finally {
            String string4 = sb3.toString();
            if (!TextUtils.isEmpty(string4)) {
                string3 = "OK" + string4;
            }
            this.f59133f.putInt("code", 0);
            this.f59133f.putString("info", string3);
            groupQueryResponse.setCode(0);
            groupQueryResponse.setInfo(string3);
        }
    }

    /* renamed from: r */
    public final void m77940r(ArrayList<ShareAlbumData> arrayList, Albums.List list, StringBuilder sb2) throws Exception {
        String nextCursor = null;
        do {
            AlbumsList albumsListExecute = list.setCursor(nextCursor).execute();
            C1120a.m6675d("GroupAlbumsExecutor", "groupAlbumList: " + albumsListExecute.toString());
            List<Album> albums = albumsListExecute.getAlbums();
            if (albums != null) {
                C1120a.m6677i("GroupAlbumsExecutor", "groupAlbumList size: " + albums.size());
                for (Album album : albums) {
                    if (album != null && "1.0".equals(album.getAlbumVersion()) && "group".equals(album.getResource())) {
                        ShareAlbumData shareAlbumDataM78971l = C13129a.m78971l(album, this.f61708b, 4, null);
                        if (shareAlbumDataM78971l == null) {
                            C1120a.m6678w("GroupAlbumsExecutor", "album data invalid: " + C1122c.m6740U0(album.getId()));
                            sb2.append(",");
                            sb2.append(C1122c.m6740U0(album.getId()));
                        } else {
                            arrayList.add(shareAlbumDataM78971l);
                        }
                    }
                }
            }
            nextCursor = albumsListExecute.getNextCursor();
            C0068f.m459d().m468l();
        } while (!TextUtils.isEmpty(nextCursor));
    }
}
