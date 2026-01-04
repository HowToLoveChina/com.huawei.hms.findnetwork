package p649t6;

import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.BabyInfo;
import com.huawei.android.hicloud.drive.cloudphoto.model.Permission;
import com.huawei.android.hicloud.drive.cloudphoto.model.PermissionList;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mk.C11477c;
import org.json.JSONObject;
import p015ak.C0241z;
import p031b7.C1120a;
import p031b7.C1122c;
import p512o7.C11824a;
import p523oi.C11903a;
import p671u7.C13129a;

/* renamed from: t6.a */
/* loaded from: classes2.dex */
public class C12941a extends AbstractC12949i<Album> {
    public C12941a() {
        super(C11824a.m70445b());
    }

    /* renamed from: A */
    public Album m77726A(String str, boolean z10) {
        C1120a.m6677i("AlbumDataOperator", "queryByAlbumId");
        ArrayList<Album> arrayListM77851g = m77851g("SELECT albumId,albumName,albumOwnerId,albumVersion,babyInfo,backgroundImage,coverImage,createdTime,editedTime,localPath,onlyFrdCanBeShared,permissions,privilege,properties,resource,shareType,source,type,opType,hide,defaultAlbum,topAlbum,nextCursor,recycled,flversion FROM t_album indexed by album_idx_album_id WHERE albumId = ? ", new String[]{str});
        Album next = null;
        if (arrayListM77851g != null) {
            Iterator<Album> it = arrayListM77851g.iterator();
            while (it.hasNext()) {
                next = it.next();
            }
        }
        if (next != null && z10) {
            m77728C(next);
        }
        return next;
    }

    /* renamed from: B */
    public ArrayList<Album> m77727B(int i10, boolean z10) {
        C1120a.m6677i("AlbumDataOperator", "queryByType");
        ArrayList<Album> arrayListM77851g = m77851g("SELECT albumId,albumName,albumOwnerId,albumVersion,babyInfo,backgroundImage,coverImage,createdTime,editedTime,localPath,onlyFrdCanBeShared,permissions,privilege,properties,resource,shareType,source,type,opType,hide,defaultAlbum,topAlbum,nextCursor,recycled,flversion FROM t_album indexed by album_idx_album_type WHERE type = ? and opType != 4 and recycled != 1 and hide != 1 ", new String[]{String.valueOf(i10)});
        if (arrayListM77851g != null && z10) {
            Iterator<Album> it = arrayListM77851g.iterator();
            while (it.hasNext()) {
                Album next = it.next();
                if (next != null) {
                    m77728C(next);
                }
            }
        }
        return m77739n(arrayListM77851g);
    }

    /* renamed from: C */
    public final void m77728C(Album album) {
        int iM77849e = album.getType().intValue() == 0 ? m77849e("SELECT count(1) from t_media indexed by idx_query_count where albumId = ? and fileType != 4 and opType != 4 and recycled = 0 and (hwBurstType NOT IN (2) or (hwBurstType = 2 and albumId||substr(fileName, 1, length(fileName) - length('000.JPG')) NOT IN (SELECT albumId||substr(fileName, 1, length(fileName) - length('000_COVER.JPG')) FROM t_media WHERE hwBurstType = 1 and albumId = ?)))", new String[]{album.getId(), album.getId()}) : m77849e("SELECT count(1) from t_media indexed by idx_query_count where albumId = ? and fileType != 4 and opType != 4 and recycled = 0 ", new String[]{album.getId()});
        int iM77849e2 = m77849e("SELECT count(1) from t_media indexed by idx_query_count where albumId = ? and fileType = 4 and opType != 4 and recycled = 0 ", new String[]{album.getId()});
        album.setPicCount(iM77849e);
        album.setVideoCount(iM77849e2);
    }

    /* renamed from: D */
    public void m77729D(Album album) throws SQLException {
        if (album == null) {
            return;
        }
        m77847a("UPDATE t_album SET privilege = ? , properties = ? WHERE albumId = ? ", new String[]{StringUtil.emptyIfBlank(String.valueOf(album.getPrivilege())), StringUtil.emptyIfBlank(new JSONObject(album.getProperties()).toString()), album.getId()});
    }

    /* renamed from: E */
    public void m77730E(long j10, String str) throws SQLException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m77847a("UPDATE t_album SET flversion = ? WHERE albumId = ? ", new String[]{String.valueOf(j10), str});
    }

    /* renamed from: F */
    public void m77731F(String str, String str2) throws SQLException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        m77847a("UPDATE t_album SET nextCursor = ? WHERE albumId = ? ", new String[]{str, str2});
    }

    /* renamed from: i */
    public void m77734i(ArrayList<Album> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<Album> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new String[]{String.valueOf(it.next().getId())});
        }
        m77848b("DELETE FROM t_album WHERE albumId = ? ", arrayList2);
    }

    /* renamed from: j */
    public void m77735j(ArrayList<Album> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<Album> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(m77740o(it.next()));
        }
        m77848b("INSERT OR IGNORE INTO t_album(albumId,albumName,albumOwnerId,albumVersion,babyInfo,backgroundImage,coverImage,createdTime,editedTime,localPath,onlyFrdCanBeShared,permissions,privilege,properties,resource,shareType,source,type,opType,hide,defaultAlbum,topAlbum,nextCursor,recycled,flversion) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", arrayList2);
    }

    /* renamed from: k */
    public void m77736k(ArrayList<Album> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<Album> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(m77740o(it.next()));
        }
        m77848b("REPLACE INTO t_album(albumId,albumName,albumOwnerId,albumVersion,babyInfo,backgroundImage,coverImage,createdTime,editedTime,localPath,onlyFrdCanBeShared,permissions,privilege,properties,resource,shareType,source,type,opType,hide,defaultAlbum,topAlbum,nextCursor,recycled,flversion) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", arrayList2);
    }

    /* renamed from: l */
    public void m77737l(ArrayList<Album> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<Album> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(m77741p(it.next()));
        }
        m77848b("UPDATE t_album SET permissions = ? WHERE albumId = ? ", arrayList2);
    }

    /* renamed from: m */
    public void m77738m() throws SQLException {
        m77847a("DELETE FROM t_album ", null);
    }

    /* renamed from: n */
    public final ArrayList<Album> m77739n(ArrayList<Album> arrayList) {
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    /* renamed from: o */
    public final String[] m77740o(Album album) {
        String[] strArr = new String[25];
        int i10 = 0;
        strArr[0] = album.getId();
        strArr[1] = StringUtil.emptyIfBlank(album.getAlbumName());
        strArr[2] = StringUtil.emptyIfBlank(album.getAlbumOwnerId());
        strArr[3] = StringUtil.emptyIfBlank(album.getAlbumVersion());
        strArr[4] = StringUtil.emptyIfBlank(album.getBabyInfo() == null ? null : C11477c.m68634d(album.getBabyInfo().toString()));
        strArr[5] = StringUtil.emptyIfBlank(album.getBackgroundImage());
        strArr[6] = StringUtil.emptyIfBlank(album.getCoverImage());
        C4644l createdTime = album.getCreatedTime();
        strArr[7] = StringUtil.emptyIfBlank(String.valueOf(createdTime == null ? 0L : createdTime.m28458c()));
        C4644l editedTime = album.getEditedTime();
        strArr[8] = StringUtil.emptyIfBlank(String.valueOf(editedTime != null ? editedTime.m28458c() : 0L));
        strArr[9] = StringUtil.emptyIfBlank(album.getLocalPath());
        strArr[10] = StringUtil.emptyIfBlank(String.valueOf((album.getOnlyFrdCanBeShared() != null && album.getOnlyFrdCanBeShared().booleanValue()) ? 1 : 0));
        strArr[11] = StringUtil.emptyIfBlank(m77742q(album.getPermissions()));
        strArr[12] = StringUtil.emptyIfBlank(String.valueOf(album.getPrivilege()));
        strArr[13] = StringUtil.emptyIfBlank(new JSONObject(album.getProperties()).toString());
        strArr[14] = StringUtil.emptyIfBlank(album.getResource());
        strArr[15] = StringUtil.emptyIfBlank(String.valueOf(album.getShareType() == null ? 0 : album.getShareType().intValue()));
        strArr[16] = StringUtil.emptyIfBlank(album.getSource());
        strArr[17] = StringUtil.emptyIfBlank(String.valueOf(album.getType() == null ? 0 : album.getType().intValue()));
        strArr[18] = StringUtil.emptyIfBlank(String.valueOf(album.getOpType()));
        strArr[19] = StringUtil.emptyIfBlank(String.valueOf(album.isHide() ? 1 : 0));
        strArr[20] = StringUtil.emptyIfBlank(String.valueOf(album.isDefaultAlbum() ? 1 : 0));
        strArr[21] = StringUtil.emptyIfBlank(String.valueOf(album.isTopAlbum() ? 1 : 0));
        strArr[22] = StringUtil.emptyIfBlank(album.getNextCursor());
        if (album.getRecycled() != null && album.getRecycled().booleanValue()) {
            i10 = 1;
        }
        strArr[23] = StringUtil.emptyIfBlank(String.valueOf(i10));
        strArr[24] = StringUtil.emptyIfBlank(String.valueOf(album.getFlversion()));
        return strArr;
    }

    /* renamed from: p */
    public final String[] m77741p(Album album) {
        return new String[]{m77742q(album.getPermissions()), album.getId()};
    }

    /* renamed from: q */
    public final String m77742q(List<Permission> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        PermissionList permissionList = new PermissionList();
        permissionList.setPermissions(list);
        return permissionList.toString();
    }

    /* renamed from: r */
    public Album m77743r(Album album) {
        if (album != null && !TextUtils.isEmpty(album.getId())) {
            int iM77849e = album.getType().intValue() == 0 ? m77849e("SELECT count(1) from t_media indexed by idx_query_count where albumId = ? and fileType != 4 and opType != 4 and recycled = 0 and (hwBurstType NOT IN (2) or (hwBurstType = 2 and albumId||substr(fileName, 1, length(fileName) - length('000.JPG')) NOT IN (SELECT albumId||substr(fileName, 1, length(fileName) - length('000_COVER.JPG')) FROM t_media WHERE hwBurstType = 1 and albumId = ?)))", new String[]{album.getId(), album.getId()}) : m77849e("SELECT count(1) from t_media indexed by idx_query_count where albumId = ? and fileType != 4 and opType != 4 and recycled = 0 ", new String[]{album.getId()});
            int iM77849e2 = m77849e("SELECT count(1) from t_media indexed by idx_query_count where albumId = ? and fileType = 4 and opType != 4 and recycled = 0 ", new String[]{album.getId()});
            album.setPicCount(iM77849e);
            album.setVideoCount(iM77849e2);
        }
        return album;
    }

    @Override // p649t6.AbstractC12949i
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Album mo77732c(Cursor cursor) throws Throwable {
        Album album = new Album();
        album.setId(cursor.getString(0));
        album.setAlbumName(cursor.getString(1));
        album.setAlbumOwnerId(cursor.getString(2));
        album.setAlbumVersion(cursor.getString(3));
        album.setBabyInfo(m77747v(cursor.getString(4)));
        album.setBackgroundImage(cursor.getString(5));
        album.setCoverImage(cursor.getString(6));
        album.setCreatedTime(new C4644l(cursor.getLong(7)));
        album.setEditedTime(new C4644l(cursor.getLong(8)));
        album.setLocalPath(cursor.getString(9));
        album.setOnlyFrdCanBeShared(Boolean.valueOf(cursor.getInt(10) == 1));
        album.setPermissions(m77749x(cursor.getString(11)));
        album.setPrivilege(Integer.valueOf(cursor.getInt(12)));
        album.setProperties(C13129a.m78968i(cursor.getString(13)));
        album.setResource(cursor.getString(14));
        album.setShareType(Integer.valueOf(cursor.getInt(15)));
        album.setSource(cursor.getString(16));
        album.setType(Integer.valueOf(cursor.getInt(17)));
        album.setOpType(cursor.getInt(18));
        album.setHide(cursor.getInt(19) == 1);
        album.setDefaultAlbum(cursor.getInt(20) == 1);
        album.setTopAlbum(cursor.getInt(21) == 1);
        album.setNextCursor(cursor.getString(22));
        album.setRecycled(Boolean.valueOf(cursor.getInt(23) == 1));
        album.setFlversion(cursor.getLong(24));
        m77746u(album);
        m77748w(album);
        return album;
    }

    @Override // p649t6.AbstractC12949i
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public Album mo77733d(Cursor cursor) {
        return null;
    }

    /* renamed from: u */
    public final void m77746u(Album album) {
        String albumOwnerId = album.getAlbumOwnerId();
        if (TextUtils.isEmpty(albumOwnerId)) {
            album.setAlbumOwnerName("");
            return;
        }
        for (Permission permission : album.getPermissions()) {
            if (permission != null && albumOwnerId.equals(permission.getUserId())) {
                album.setAlbumOwnerName(permission.getDisplayName());
                return;
            }
        }
    }

    /* renamed from: v */
    public final BabyInfo m77747v(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strM68631a = C11477c.m68631a(str);
        if (TextUtils.isEmpty(strM68631a)) {
            return null;
        }
        try {
            return (BabyInfo) C11903a.m71435l().mo69832e(strM68631a).m69886u(BabyInfo.class);
        } catch (IOException unused) {
            C1120a.m6676e("AlbumDataOperator", "processBabyInfo IOException");
            return null;
        }
    }

    /* renamed from: w */
    public final void m77748w(Album album) throws Throwable {
        String[] strArr;
        if (album.getType().intValue() == 0) {
            return;
        }
        album.setFileUpdateTime(album.getCreatedTime().m28458c());
        Map<String, String> properties = album.getProperties();
        if (properties.containsKey("lastUploadTime")) {
            album.setFileUpdateTime(new C4644l(properties.get("lastUploadTime")).m28458c());
            return;
        }
        ArrayList<String[]> arrayListM77850f = m77850f("SELECT batchV1Time FROM t_media indexed by idx_batch_v1_time WHERE albumId = ? and opType != 4 and recycled = 0 order by batchV1Time desc limit 1 ", new String[]{album.getId()});
        if (arrayListM77850f == null || arrayListM77850f.isEmpty() || (strArr = arrayListM77850f.get(0)) == null || strArr.length == 0) {
            return;
        }
        long jM1689g = C0241z.m1689g(strArr[0], 0L);
        if (jM1689g != 0) {
            album.setFileUpdateTime(jM1689g);
        }
    }

    /* renamed from: x */
    public final List<Permission> m77749x(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        try {
            return C1122c.m6709K(((PermissionList) C11903a.m71435l().mo69832e(str).m69886u(PermissionList.class)).getPermissions());
        } catch (IOException unused) {
            C1120a.m6676e("AlbumDataOperator", "processSharePermissionList IOException");
            return new ArrayList();
        }
    }

    /* renamed from: y */
    public ArrayList<Album> m77750y(boolean z10) throws Throwable {
        C1120a.m6677i("AlbumDataOperator", "queryAll");
        ArrayList<Album> arrayListM77851g = m77851g("SELECT albumId,albumName,albumOwnerId,albumVersion,babyInfo,backgroundImage,coverImage,createdTime,editedTime,localPath,onlyFrdCanBeShared,permissions,privilege,properties,resource,shareType,source,type,opType,hide,defaultAlbum,topAlbum,nextCursor,recycled,flversion FROM t_album ", null);
        if (arrayListM77851g != null && z10) {
            Iterator<Album> it = arrayListM77851g.iterator();
            while (it.hasNext()) {
                Album next = it.next();
                if (next != null) {
                    m77728C(next);
                }
            }
        }
        return m77739n(arrayListM77851g);
    }

    /* renamed from: z */
    public ArrayList<Album> m77751z() {
        return m77739n(m77851g("SELECT albumId,albumName,albumOwnerId,albumVersion,babyInfo,backgroundImage,coverImage,createdTime,editedTime,localPath,onlyFrdCanBeShared,permissions,privilege,properties,resource,shareType,source,type,opType,hide,defaultAlbum,topAlbum,nextCursor,recycled,flversion FROM t_album indexed by album_idx_op_type WHERE opType = 4 ", null));
    }
}
