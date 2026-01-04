package p650t7;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.hihttp.request.response.BaseResponse;
import com.huawei.android.hicloud.album.service.hihttp.request.response.ShareQueryResponse;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.AlbumsList;
import com.huawei.android.hicloud.drive.cloudphoto.request.Albums;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import com.huawei.hms.api.ConnectionResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import p009a8.C0068f;
import p031b7.C1120a;
import p031b7.C1122c;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p671u7.C13129a;
import p804ya.C13924a;

/* renamed from: t7.r */
/* loaded from: classes2.dex */
public class C12984r extends AbstractC12988v<ShareQueryResponse> {

    /* renamed from: g */
    public volatile Exception f59123g;

    /* renamed from: t7.r$b */
    public class b extends AbstractC12367d {

        /* renamed from: a */
        public CopyOnWriteArrayList<ShareAlbumData> f59124a;

        /* renamed from: b */
        public Album f59125b;

        /* renamed from: c */
        public C13924a f59126c;

        /* renamed from: d */
        public StringBuffer f59127d;

        /* renamed from: e */
        public CountDownLatch f59128e;

        /* renamed from: f */
        public int f59129f;

        /* renamed from: g */
        public Map<String, String> f59130g;

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                try {
                } catch (Exception e10) {
                    if (C12984r.this.f59123g == null) {
                        C12984r.this.f59123g = e10;
                    }
                    C1120a.m6676e("GetShareAlbumsExecutor", "GetShareAlbumDataTask Exception: " + e10.toString());
                }
                if (C12984r.this.f59123g != null) {
                    this.f59128e.countDown();
                    return;
                }
                ShareAlbumData shareAlbumDataM78971l = C13129a.m78971l(this.f59125b, this.f59126c, this.f59129f, this.f59130g);
                if (shareAlbumDataM78971l == null) {
                    C1120a.m6678w("GetShareAlbumsExecutor", "album data invalid: " + C1122c.m6740U0(this.f59125b.getId()));
                    StringBuffer stringBuffer = this.f59127d;
                    stringBuffer.append(",");
                    stringBuffer.append(C1122c.m6740U0(this.f59125b.getId()));
                } else if (this.f59129f == 2 || this.f59125b.getOwnedByMe().booleanValue()) {
                    shareAlbumDataM78971l.setResource(PowerKitApplyUtil.GROUP_ALBUM);
                    this.f59124a.add(shareAlbumDataM78971l);
                }
                C0068f.m459d().m468l();
                this.f59128e.countDown();
            } catch (Throwable th2) {
                this.f59128e.countDown();
                throw th2;
            }
        }

        public b(CopyOnWriteArrayList<ShareAlbumData> copyOnWriteArrayList, Album album, C13924a c13924a, StringBuffer stringBuffer, int i10, CountDownLatch countDownLatch, Map<String, String> map) {
            this.f59124a = copyOnWriteArrayList;
            this.f59125b = album;
            this.f59126c = c13924a;
            this.f59127d = stringBuffer;
            this.f59129f = i10;
            this.f59128e = countDownLatch;
            this.f59130g = map;
        }
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() {
        int iM6802l0;
        String string;
        String string2;
        StringBuilder sb2;
        String string3 = "OK";
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList<ShareAlbumData> arrayList = new ArrayList<>();
        ArrayList<ShareAlbumData> arrayList2 = new ArrayList<>();
        this.f59133f = new Bundle();
        try {
            try {
                Albums.List listAddHeader = this.f61708b.m83547d().list("nextCursor,albums(id,albumName,albumOwnerId,albumVersion,type,ownedByMe,resource,createdTime,source,properties,privilege,onlyFrdCanBeShared,owner(userId,displayName),permissions(userId,displayName,status,role,userAccount))").setQueryParam("albumType = 1 and sharedWithMe = true").addHeader("x-hw-trace-id", (Object) this.f61710d);
                m77935t(arrayList, this.f61708b.m83547d().list("nextCursor,albums(id,albumName,albumOwnerId,albumVersion,type,ownedByMe,resource,createdTime,source,properties,privilege,onlyFrdCanBeShared,owner(userId,displayName),permissions(userId,displayName,status,role,userAccount))").setQueryParam("albumType = 1").addHeader("x-hw-trace-id", (Object) this.f61710d), stringBuffer);
                m77936u(arrayList2, listAddHeader, stringBuffer);
                C1120a.m6677i("GetShareAlbumsExecutor", "ownShareList size: " + arrayList.size() + ", recShareList size: " + arrayList2.size());
                this.f59133f.putParcelableArrayList("OwnShareList", arrayList);
                this.f59133f.putParcelableArrayList("RecShareList", arrayList2);
                return "";
            } catch (IOException e10) {
                C1120a.m6676e("GetShareAlbumsExecutor", "GetShareAlbumsExecutor runTask IOException: " + e10.toString());
                if (e10 instanceof C4616s) {
                    iM6802l0 = C1122c.m6802l0((C4616s) e10);
                    string = e10.toString();
                } else {
                    iM6802l0 = C1122c.m6845x0(e10);
                    string = e10.toString();
                }
                string2 = stringBuffer.toString();
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
                C1120a.m6676e("GetShareAlbumsExecutor", "GetShareAlbumsExecutor runTask Exception: " + e11.toString());
                iM6802l0 = ConnectionResult.NETWORK_ERROR;
                string = e11.toString();
                string2 = stringBuffer.toString();
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
            String string4 = stringBuffer.toString();
            if (!TextUtils.isEmpty(string4)) {
                string3 = "OK" + string4;
            }
            this.f59133f.putInt("code", 0);
            this.f59133f.putString("info", string3);
        }
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public ShareQueryResponse mo77904k(Class<BaseResponse> cls) throws Exception {
        int iM6802l0;
        String string;
        String string2;
        StringBuilder sb2;
        C1120a.m6675d("GetShareAlbumsExecutor", "GetShareAlbumsExecutor execute recShareList");
        ShareQueryResponse shareQueryResponse = new ShareQueryResponse();
        String string3 = "OK";
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList<ShareAlbumData> arrayList = new ArrayList<>();
        this.f59133f = new Bundle();
        try {
            try {
                m77936u(arrayList, this.f61708b.m83547d().list("nextCursor,albums(id,albumName,albumOwnerId,albumVersion,type,ownedByMe,resource,createdTime,source,properties,privilege,onlyFrdCanBeShared,owner(userId,displayName),permissions(userId,displayName,status,role,userAccount))").setQueryParam("albumType = 1 and sharedWithMe = true").addHeader("x-hw-trace-id", (Object) this.f61710d), stringBuffer);
                C1120a.m6677i("GetShareAlbumsExecutor", "GetShareAlbumsExecutor recShareList size: " + arrayList.size());
                shareQueryResponse.setRecShareList(arrayList);
            } catch (IOException e10) {
                C1120a.m6676e("GetShareAlbumsExecutor", "GetShareAlbumsExecutor execute IOException: " + e10.toString());
                if (e10 instanceof C4616s) {
                    iM6802l0 = C1122c.m6802l0((C4616s) e10);
                    string = e10.toString();
                } else {
                    iM6802l0 = C1122c.m6845x0(e10);
                    string = e10.toString();
                }
                string2 = stringBuffer.toString();
                if (!TextUtils.isEmpty(string2)) {
                    sb2 = new StringBuilder();
                    sb2.append(string);
                    sb2.append(string2);
                    string = sb2.toString();
                }
                this.f59133f.putInt("code", iM6802l0);
                this.f59133f.putString("info", string);
                shareQueryResponse.setCode(iM6802l0);
                shareQueryResponse.setInfo(string);
                return shareQueryResponse;
            } catch (Exception e11) {
                C1120a.m6676e("GetShareAlbumsExecutor", "GetShareAlbumsExecutor execute Exception: " + e11.toString());
                iM6802l0 = ConnectionResult.NETWORK_ERROR;
                string = e11.toString();
                string2 = stringBuffer.toString();
                if (!TextUtils.isEmpty(string2)) {
                    sb2 = new StringBuilder();
                    sb2.append(string);
                    sb2.append(string2);
                    string = sb2.toString();
                }
                this.f59133f.putInt("code", iM6802l0);
                this.f59133f.putString("info", string);
                shareQueryResponse.setCode(iM6802l0);
                shareQueryResponse.setInfo(string);
                return shareQueryResponse;
            }
            return shareQueryResponse;
        } finally {
            String string4 = stringBuffer.toString();
            if (!TextUtils.isEmpty(string4)) {
                string3 = "OK" + string4;
            }
            this.f59133f.putInt("code", 0);
            this.f59133f.putString("info", string3);
            shareQueryResponse.setCode(0);
            shareQueryResponse.setInfo(string3);
        }
    }

    /* renamed from: t */
    public final void m77935t(ArrayList<ShareAlbumData> arrayList, Albums.List list, StringBuffer stringBuffer) throws Exception {
        String str = null;
        this.f59123g = null;
        Albums.List list2 = list;
        while (true) {
            AlbumsList albumsListExecute = list2.setCursor(str).execute();
            C1120a.m6675d("GetShareAlbumsExecutor", "own shareAlbumsList: " + albumsListExecute.toString());
            List<Album> albums = albumsListExecute.getAlbums();
            if (albums != null) {
                C1120a.m6677i("GetShareAlbumsExecutor", "own shareAlbums size: " + albums.size());
                CountDownLatch countDownLatch = new CountDownLatch(albums.size());
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                for (Album album : albums) {
                    if (album == null) {
                        countDownLatch.countDown();
                    } else {
                        C12515a.m75110o().m75175e(new b(copyOnWriteArrayList, album, this.f61708b, stringBuffer, 1, countDownLatch, null), false);
                    }
                }
                countDownLatch.await();
                if (this.f59123g != null) {
                    throw this.f59123g;
                }
                arrayList.addAll(copyOnWriteArrayList);
            }
            String nextCursor = albumsListExecute.getNextCursor();
            C0068f.m459d().m468l();
            if (TextUtils.isEmpty(nextCursor)) {
                return;
            }
            list2 = list;
            str = nextCursor;
        }
    }

    /* renamed from: u */
    public final void m77936u(ArrayList<ShareAlbumData> arrayList, Albums.List list, StringBuffer stringBuffer) throws Exception {
        HashMap map;
        String str = null;
        this.f59123g = null;
        HashMap map2 = new HashMap();
        while (true) {
            AlbumsList albumsListExecute = list.setCursor(str).execute();
            C1120a.m6675d("GetShareAlbumsExecutor", "rec shareAlbumsList: " + albumsListExecute.toString());
            List<Album> albums = albumsListExecute.getAlbums();
            if (albums != null) {
                C1120a.m6677i("GetShareAlbumsExecutor", "rec shareAlbums size: " + albums.size());
                CountDownLatch countDownLatch = new CountDownLatch(albums.size());
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                for (Album album : albums) {
                    if (album == null) {
                        countDownLatch.countDown();
                    } else if ("1.0".equals(album.getAlbumVersion()) && "group".equals(album.getResource())) {
                        countDownLatch.countDown();
                    } else {
                        C12515a.m75110o().m75175e(new b(copyOnWriteArrayList, album, this.f61708b, stringBuffer, 2, countDownLatch, map2), false);
                        map2 = map2;
                    }
                }
                map = map2;
                countDownLatch.await();
                if (this.f59123g != null) {
                    throw this.f59123g;
                }
                arrayList.addAll(copyOnWriteArrayList);
            } else {
                map = map2;
            }
            String nextCursor = albumsListExecute.getNextCursor();
            C0068f.m459d().m468l();
            if (TextUtils.isEmpty(nextCursor)) {
                return;
            }
            str = nextCursor;
            map2 = map;
        }
    }
}
