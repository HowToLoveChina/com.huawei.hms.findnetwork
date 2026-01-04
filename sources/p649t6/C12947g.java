package p649t6;

import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.baidu.location.p065a.C1529a;
import com.huawei.android.hicloud.album.service.p075vo.DayModeGroup;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.drive.cloudphoto.model.PictureMetaData;
import com.huawei.android.hicloud.drive.cloudphoto.model.ScaDetail;
import com.huawei.android.hicloud.drive.cloudphoto.model.ScaDetailList;
import com.huawei.android.hicloud.drive.cloudphoto.model.VideoMetaData;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.base.drive.user.model.User;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import p015ak.C0241z;
import p031b7.C1120a;
import p031b7.C1132m;
import p512o7.C11824a;
import p514o9.C11829c;
import p523oi.C11903a;
import p671u7.C13129a;

/* renamed from: t6.g */
/* loaded from: classes2.dex */
public class C12947g extends AbstractC12949i<Media> {
    public C12947g() {
        super(C11824a.m70445b());
    }

    /* renamed from: r */
    private ArrayList<Media> m77787r(ArrayList<Media> arrayList) {
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    /* renamed from: A */
    public final void m77788A(Cursor cursor, Media media, int i10) {
        if (i10 != 4) {
            PictureMetaData pictureMetaDataM77789B = m77789B(cursor.getString(12));
            if (pictureMetaDataM77789B == null || pictureMetaDataM77789B.getRotation() == null) {
                return;
            }
            media.setRotation(pictureMetaDataM77789B.getRotation().intValue());
            return;
        }
        VideoMetaData videoMetaDataM77790C = m77790C(cursor.getString(13));
        if (videoMetaDataM77790C != null && videoMetaDataM77790C.getRotation() != null) {
            media.setRotation(videoMetaDataM77790C.getRotation().intValue());
        }
        if (videoMetaDataM77790C == null || videoMetaDataM77790C.getDurationTime() == null) {
            return;
        }
        media.setVideoTimeDuration(videoMetaDataM77790C.getDurationTime().intValue());
    }

    /* renamed from: B */
    public final PictureMetaData m77789B(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (PictureMetaData) C11903a.m71435l().mo69832e(str).m69886u(PictureMetaData.class);
        } catch (IOException unused) {
            C1120a.m6676e("MediaDataOperator", "processPictureMetaData IOException");
            return null;
        }
    }

    /* renamed from: C */
    public final VideoMetaData m77790C(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (VideoMetaData) C11903a.m71435l().mo69832e(str).m69886u(VideoMetaData.class);
        } catch (IOException unused) {
            C1120a.m6676e("MediaDataOperator", "processVideoMetaData IOException");
            return null;
        }
    }

    /* renamed from: D */
    public ArrayList<DayModeGroup> m77791D(String str) throws Throwable {
        C1120a.m6677i("MediaDataOperator", "queryAlbumDayModeGroupList");
        ArrayList<DayModeGroup> arrayList = new ArrayList<>();
        ArrayList<String[]> arrayListM77850f = m77850f("SELECT day_mode, count(1) as count FROM t_media indexed by idx_query_day_mode WHERE opType != 4 and albumType = 0 and recycled = 0 and albumId = ? group by day_mode order by day_mode desc ", new String[]{str});
        if (arrayListM77850f != null && !arrayListM77850f.isEmpty()) {
            m77832u(arrayList, arrayListM77850f);
        }
        return arrayList;
    }

    /* renamed from: E */
    public ArrayList<Media> m77792E(long j10, long j11) {
        return m77787r(m77851g("SELECT localId,albumId,batchId,createdTime,editedTime,description,favorite,fileName,fileType,mediaId,mediaOwnerId,mediaCreatorId,pictureMetadata,videoMetadata,properties,recycled,recycledTime,scaDetail,size,source,opType,localThumbPath,localBigThumbPath,localRealPath,albumVersion,albumType,hashId,sha256,videoThumbId,thumbFileId,lcdFileId,mediaCreatorName,batchV1Id,batchV1Time,localBatchId,uploadState,hwBurstType FROM t_media indexed by idx_op_type WHERE opType = 4 limit ?,? ", new String[]{String.valueOf(j10), String.valueOf(j11)}));
    }

    /* renamed from: F */
    public ArrayList<Media> m77793F() {
        C1120a.m6677i("MediaDataOperator", "queryAllGeneralFavorite");
        return m77787r(m77852h("SELECT localId,albumId,batchId,createdTime,editedTime,description,favorite,fileName,fileType,mediaId,mediaOwnerId,mediaCreatorId,pictureMetadata,videoMetadata,properties,recycled,recycledTime,scaDetail,size,source,opType,localThumbPath,localBigThumbPath,localRealPath,albumVersion,albumType,hashId,sha256,videoThumbId,thumbFileId,lcdFileId,mediaCreatorName,batchV1Id,batchV1Time,localBatchId,uploadState,hwBurstType FROM t_media indexed by idx_query_album_c_time WHERE opType != 4 and favorite = 1 and albumType = 0 and recycled = 0 and albumId in (SELECT albumId FROM t_album WHERE type = 0 and opType != 4 and recycled != 1 and hide != 1) order by createdTime desc ", null));
    }

    /* renamed from: G */
    public ArrayList<Media> m77794G(long j10, long j11) {
        C1120a.m6677i("MediaDataOperator", "queryAllGeneralFavorite");
        return m77787r(m77852h("SELECT localId,albumId,batchId,createdTime,editedTime,description,favorite,fileName,fileType,mediaId,mediaOwnerId,mediaCreatorId,pictureMetadata,videoMetadata,properties,recycled,recycledTime,scaDetail,size,source,opType,localThumbPath,localBigThumbPath,localRealPath,albumVersion,albumType,hashId,sha256,videoThumbId,thumbFileId,lcdFileId,mediaCreatorName,batchV1Id,batchV1Time,localBatchId,uploadState,hwBurstType FROM t_media indexed by idx_query_album_c_time WHERE opType != 4 and favorite = 1 and albumType = 0 and recycled = 0 and albumId in (SELECT albumId FROM t_album WHERE type = 0 and opType != 4 and recycled != 1 and hide != 1) order by createdTime desc limit ?,? ", new String[]{String.valueOf(j10), String.valueOf(j11)}));
    }

    /* renamed from: H */
    public ArrayList<Media> m77795H(long j10, long j11) {
        C1120a.m6677i("MediaDataOperator", "queryAllGeneralLimit " + j10 + ", " + j11);
        return m77787r(m77852h("SELECT localId,albumId,batchId,createdTime,editedTime,description,favorite,fileName,fileType,mediaId,mediaOwnerId,mediaCreatorId,pictureMetadata,videoMetadata,properties,recycled,recycledTime,scaDetail,size,source,opType,localThumbPath,localBigThumbPath,localRealPath,albumVersion,albumType,hashId,sha256,videoThumbId,thumbFileId,lcdFileId,mediaCreatorName,batchV1Id,batchV1Time,localBatchId,uploadState,hwBurstType FROM t_media indexed by idx_query_album_c_time WHERE opType != 4 and albumType = 0 and recycled = 0 and albumId in (SELECT albumId FROM t_album WHERE type = 0 and opType != 4 and recycled != 1 and hide != 1) order by createdTime desc limit ?,? ", new String[]{String.valueOf(j10), String.valueOf(j11)}));
    }

    /* renamed from: I */
    public ArrayList<Media> m77796I() {
        C1120a.m6677i("MediaDataOperator", "queryAllGeneralVideo");
        return m77787r(m77852h("SELECT localId,albumId,batchId,createdTime,editedTime,description,favorite,fileName,fileType,mediaId,mediaOwnerId,mediaCreatorId,pictureMetadata,videoMetadata,properties,recycled,recycledTime,scaDetail,size,source,opType,localThumbPath,localBigThumbPath,localRealPath,albumVersion,albumType,hashId,sha256,videoThumbId,thumbFileId,lcdFileId,mediaCreatorName,batchV1Id,batchV1Time,localBatchId,uploadState,hwBurstType FROM t_media indexed by idx_query_album_c_time WHERE opType != 4 and fileType = 4 and albumType = 0 and recycled = 0 and albumId in (SELECT albumId FROM t_album WHERE type = 0 and opType != 4 and recycled != 1 and hide != 1) order by createdTime desc", null));
    }

    /* renamed from: J */
    public ArrayList<Media> m77797J(long j10, long j11) {
        C1120a.m6677i("MediaDataOperator", "queryAllGeneralVideoLimit");
        return m77787r(m77852h("SELECT localId,albumId,batchId,createdTime,editedTime,description,favorite,fileName,fileType,mediaId,mediaOwnerId,mediaCreatorId,pictureMetadata,videoMetadata,properties,recycled,recycledTime,scaDetail,size,source,opType,localThumbPath,localBigThumbPath,localRealPath,albumVersion,albumType,hashId,sha256,videoThumbId,thumbFileId,lcdFileId,mediaCreatorName,batchV1Id,batchV1Time,localBatchId,uploadState,hwBurstType FROM t_media indexed by idx_query_album_c_time WHERE opType != 4 and fileType = 4 and albumType = 0 and recycled = 0 and albumId in (SELECT albumId FROM t_album WHERE type = 0 and opType != 4 and recycled != 1 and hide != 1) order by createdTime desc limit ?,? ", new String[]{String.valueOf(j10), String.valueOf(j11)}));
    }

    /* renamed from: K */
    public ArrayList<Media> m77798K(String str, long j10, long j11) {
        C1120a.m6677i("MediaDataOperator", "queryByAlbumIdLimit " + j10 + ", " + j11);
        return m77787r(m77852h("SELECT localId,albumId,batchId,createdTime,editedTime,description,favorite,fileName,fileType,mediaId,mediaOwnerId,mediaCreatorId,pictureMetadata,videoMetadata,properties,recycled,recycledTime,scaDetail,size,source,opType,localThumbPath,localBigThumbPath,localRealPath,albumVersion,albumType,hashId,sha256,videoThumbId,thumbFileId,lcdFileId,mediaCreatorName,batchV1Id,batchV1Time,localBatchId,uploadState,hwBurstType FROM t_media indexed by idx_query_album_c_time WHERE albumId = ? and opType != 4 and recycled = 0 order by createdTime desc limit ?,? ", new String[]{str, String.valueOf(j10), String.valueOf(j11)}));
    }

    /* renamed from: L */
    public ArrayList<Media> m77799L(String str, long j10, long j11) {
        C1120a.m6677i("MediaDataOperator", "queryByAlbumIdLimit4CoverBgqueryByAlbumIdLimit4CoverBg " + j10 + ", " + j11);
        return CloudAlbumSettings.m14363h().m14374j() ? m77787r(m77852h("SELECT localId,albumId,batchId,createdTime,editedTime,description,favorite,fileName,fileType,mediaId,mediaOwnerId,mediaCreatorId,pictureMetadata,videoMetadata,properties,recycled,recycledTime,scaDetail,size,source,opType,localThumbPath,localBigThumbPath,localRealPath,albumVersion,albumType,hashId,sha256,videoThumbId,thumbFileId,lcdFileId,mediaCreatorName,batchV1Id,batchV1Time,localBatchId,uploadState,hwBurstType FROM t_media indexed by idx_query_album_c_time WHERE albumId = ? and opType != 4 and opType != 1 and recycled = 0 and fileType != 4 and (scaRank = 0 or scaRank = 1 or (scaState != 1 and scaState != 2)) order by createdTime desc limit ?,? ", new String[]{str, String.valueOf(j10), String.valueOf(j11)})) : m77787r(m77852h("SELECT localId,albumId,batchId,createdTime,editedTime,description,favorite,fileName,fileType,mediaId,mediaOwnerId,mediaCreatorId,pictureMetadata,videoMetadata,properties,recycled,recycledTime,scaDetail,size,source,opType,localThumbPath,localBigThumbPath,localRealPath,albumVersion,albumType,hashId,sha256,videoThumbId,thumbFileId,lcdFileId,mediaCreatorName,batchV1Id,batchV1Time,localBatchId,uploadState,hwBurstType FROM t_media indexed by idx_query_album_c_time WHERE albumId = ? and opType != 4 and opType != 1 and recycled = 0 and fileType != 4 order by createdTime desc limit ?,? ", new String[]{str, String.valueOf(j10), String.valueOf(j11)}));
    }

    /* renamed from: M */
    public ArrayList<Media> m77800M(String str, long j10, long j11) throws Throwable {
        ArrayList<Media> arrayList = new ArrayList<>();
        ArrayList<String[]> arrayListM77850f = m77850f("SELECT localThumbPath,localBigThumbPath,mediaId FROM t_media indexed by idx_query_album_c_time WHERE albumId = ? and opType != 4 and recycled = 0 ORDER BY createdTime desc limit ?,? ", new String[]{str, String.valueOf(j10), String.valueOf(j11)});
        if (arrayListM77850f != null && !arrayListM77850f.isEmpty()) {
            Iterator<String[]> it = arrayListM77850f.iterator();
            while (it.hasNext()) {
                String[] next = it.next();
                if (next != null && next.length == 3) {
                    Media media = new Media();
                    media.setLocalThumbPath(next[0]);
                    media.setLocalBigThumbPath(next[1]);
                    media.setId(next[2]);
                    arrayList.add(media);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: N */
    public ArrayList<Media> m77801N(String str, long j10, long j11) {
        return m77787r(m77851g("SELECT localId,albumId,batchId,createdTime,editedTime,description,favorite,fileName,fileType,mediaId,mediaOwnerId,mediaCreatorId,pictureMetadata,videoMetadata,properties,recycled,recycledTime,scaDetail,size,source,opType,localThumbPath,localBigThumbPath,localRealPath,albumVersion,albumType,hashId,sha256,videoThumbId,thumbFileId,lcdFileId,mediaCreatorName,batchV1Id,batchV1Time,localBatchId,uploadState,hwBurstType FROM t_media indexed by idx_query_album_e_time WHERE albumId = ? and opType != 4 and recycled = 0 ORDER BY editedTime desc limit ?,? ", new String[]{str, String.valueOf(j10), String.valueOf(j11)}));
    }

    /* renamed from: O */
    public Media m77802O(String str) {
        ArrayList<Media> arrayListM77851g = m77851g("SELECT localId,albumId,batchId,createdTime,editedTime,description,favorite,fileName,fileType,mediaId,mediaOwnerId,mediaCreatorId,pictureMetadata,videoMetadata,properties,recycled,recycledTime,scaDetail,size,source,opType,localThumbPath,localBigThumbPath,localRealPath,albumVersion,albumType,hashId,sha256,videoThumbId,thumbFileId,lcdFileId,mediaCreatorName,batchV1Id,batchV1Time,localBatchId,uploadState,hwBurstType FROM t_media indexed by idx_media_id WHERE mediaId = ? ", new String[]{str});
        Media next = null;
        if (arrayListM77851g != null) {
            Iterator<Media> it = arrayListM77851g.iterator();
            while (it.hasNext()) {
                next = it.next();
                if (next.containsKey("id")) {
                    C1132m.m6921c().m6922a(next.getId(), next);
                }
            }
        }
        return next;
    }

    /* renamed from: P */
    public int m77803P() {
        C1120a.m6677i("MediaDataOperator", "queryCountGeneralPic");
        return m77849e("SELECT count(1) from t_media indexed by idx_query_count where opType != 4 and albumType = 0 and recycled = 0 and fileType != 4 and albumId in (SELECT albumId FROM t_album WHERE type = 0 and opType != 4 and recycled != 1 and hide != 1) and (hwBurstType != 2 or (hwBurstType = 2 and albumId||substr(fileName, 1, length(fileName) - length('000.JPG')) NOT IN (SELECT albumId||substr(fileName, 1, length(fileName) - length('000_COVER.JPG')) FROM t_media WHERE hwBurstType = 1)))", null);
    }

    /* renamed from: Q */
    public int m77804Q() {
        C1120a.m6677i("MediaDataOperator", "queryCountGeneralVideo");
        return m77849e("SELECT count(1) from t_media indexed by idx_query_count where opType != 4 and albumType = 0 and recycled = 0 and fileType = 4 and albumId in (SELECT albumId FROM t_album WHERE type = 0 and opType != 4 and recycled != 1 and hide != 1) ", null);
    }

    /* renamed from: R */
    public int m77805R() {
        C1120a.m6677i("MediaDataOperator", "queryCountShareAll");
        return m77849e("SELECT count(1) from t_media indexed by idx_query_count where albumType = 1 and opType != 4 and recycled = 0  ", null);
    }

    /* renamed from: S */
    public ArrayList<DayModeGroup> m77806S() throws Throwable {
        C1120a.m6677i("MediaDataOperator", "queryDayModeGroupList");
        ArrayList<DayModeGroup> arrayList = new ArrayList<>();
        ArrayList<String[]> arrayListM77850f = m77850f("SELECT day_mode, count(1) as count FROM t_media indexed by idx_query_day_mode WHERE opType != 4 and albumType = 0 and recycled = 0 and albumId in (SELECT albumId FROM t_album WHERE type = 0 and opType != 4 and recycled != 1 and hide != 1) group by day_mode order by day_mode desc ", null);
        if (arrayListM77850f != null && !arrayListM77850f.isEmpty()) {
            m77832u(arrayList, arrayListM77850f);
        }
        return arrayList;
    }

    /* renamed from: T */
    public Media m77807T(String str) throws Throwable {
        ArrayList<Media> arrayListM77851g = m77851g("SELECT localId,albumId,batchId,createdTime,editedTime,description,favorite,fileName,fileType,mediaId,mediaOwnerId,mediaCreatorId,pictureMetadata,videoMetadata,properties,recycled,recycledTime,scaDetail,size,source,opType,localThumbPath,localBigThumbPath,localRealPath,albumVersion,albumType,hashId,sha256,videoThumbId,thumbFileId,lcdFileId,mediaCreatorName,batchV1Id,batchV1Time,localBatchId,uploadState,hwBurstType FROM t_media indexed by idx_media_id WHERE mediaId = ? and opType != 4", new String[]{str});
        Media next = null;
        if (arrayListM77851g != null) {
            Iterator<Media> it = arrayListM77851g.iterator();
            while (it.hasNext()) {
                next = it.next();
            }
        }
        return next;
    }

    /* renamed from: U */
    public ArrayList<DayModeGroup> m77808U() throws Throwable {
        C1120a.m6677i("MediaDataOperator", "queryFavoriteDayModeGroupList");
        ArrayList<DayModeGroup> arrayList = new ArrayList<>();
        ArrayList<String[]> arrayListM77850f = m77850f("SELECT day_mode, count(1) as count FROM t_media indexed by idx_query_day_mode WHERE opType != 4 and favorite = 1 and albumType = 0 and recycled = 0 and albumId in (SELECT albumId FROM t_album WHERE type = 0 and opType != 4 and recycled != 1 and hide != 1) group by day_mode order by day_mode desc ", null);
        if (arrayListM77850f != null && !arrayListM77850f.isEmpty()) {
            m77832u(arrayList, arrayListM77850f);
        }
        return arrayList;
    }

    /* renamed from: V */
    public Media m77809V(String str, String str2) {
        ArrayList<Media> arrayListM77851g = m77851g("SELECT localId,albumId,batchId,createdTime,editedTime,description,favorite,fileName,fileType,mediaId,mediaOwnerId,mediaCreatorId,pictureMetadata,videoMetadata,properties,recycled,recycledTime,scaDetail,size,source,opType,localThumbPath,localBigThumbPath,localRealPath,albumVersion,albumType,hashId,sha256,videoThumbId,thumbFileId,lcdFileId,mediaCreatorName,batchV1Id,batchV1Time,localBatchId,uploadState,hwBurstType FROM t_media indexed by idx_query_upload_name WHERE opType != 4 AND recycled = 0 AND albumId = ? AND hashId = ? order by albumId ", new String[]{str, str2});
        if (arrayListM77851g == null || arrayListM77851g.isEmpty()) {
            return null;
        }
        return arrayListM77851g.get(0);
    }

    /* renamed from: W */
    public Media m77810W(String str, String str2) {
        ArrayList<Media> arrayListM77851g = m77851g("SELECT localId,albumId,batchId,createdTime,editedTime,description,favorite,fileName,fileType,mediaId,mediaOwnerId,mediaCreatorId,pictureMetadata,videoMetadata,properties,recycled,recycledTime,scaDetail,size,source,opType,localThumbPath,localBigThumbPath,localRealPath,albumVersion,albumType,hashId,sha256,videoThumbId,thumbFileId,lcdFileId,mediaCreatorName,batchV1Id,batchV1Time,localBatchId,uploadState,hwBurstType FROM t_media indexed by idx_query_upload_name WHERE opType != 4 AND recycled = 0 AND albumId = ? AND fileName = ? order by albumId ", new String[]{str, str2});
        if (arrayListM77851g == null || arrayListM77851g.isEmpty()) {
            return null;
        }
        return arrayListM77851g.get(0);
    }

    /* renamed from: X */
    public ArrayList<Media> m77811X(String str, long j10, long j11) {
        C1120a.m6677i("MediaDataOperator", "queryByAlbumIdLimit " + j10 + ", " + j11);
        return m77787r(m77852h("SELECT localId,albumId,batchId,createdTime,editedTime,description,favorite,fileName,fileType,mediaId,mediaOwnerId,mediaCreatorId,pictureMetadata,videoMetadata,properties,recycled,recycledTime,scaDetail,size,source,opType,localThumbPath,localBigThumbPath,localRealPath,albumVersion,albumType,hashId,sha256,videoThumbId,thumbFileId,lcdFileId,mediaCreatorName,batchV1Id,batchV1Time,localBatchId,uploadState,hwBurstType FROM t_media indexed by idx_query_album_c_time WHERE opType != 4 and fileType != 4 and albumType = 1 and recycled = 0 and albumId = ? order by createdTime desc limit ?,? ", new String[]{str, String.valueOf(j10), String.valueOf(j11)}));
    }

    /* renamed from: Y */
    public ArrayList<DayModeGroup> m77812Y(String str) {
        C1120a.m6677i("MediaDataOperator", "queryShareDayModeGroupList");
        ArrayList<DayModeGroup> arrayList = new ArrayList<>();
        ArrayList<String[]> arrayListM77850f = m77850f("SELECT day_mode, count(1) as count FROM t_media indexed by idx_query_day_mode WHERE opType != 4 and albumType = 1 and recycled = 0 and albumId = ? group by day_mode order by day_mode desc ", new String[]{str});
        if (arrayListM77850f != null && !arrayListM77850f.isEmpty()) {
            m77832u(arrayList, arrayListM77850f);
        }
        return arrayList;
    }

    /* renamed from: Z */
    public ArrayList<DayModeGroup> m77813Z(String str) {
        C1120a.m6677i("MediaDataOperator", "querySharePicDayModeGroupList");
        ArrayList<DayModeGroup> arrayList = new ArrayList<>();
        ArrayList<String[]> arrayListM77850f = m77850f("SELECT day_mode, count(1) as count FROM t_media indexed by idx_query_day_mode WHERE opType != 4 and fileType != 4 and albumType = 1 and recycled = 0 and albumId = ? group by day_mode order by day_mode desc ", new String[]{str});
        if (arrayListM77850f != null && !arrayListM77850f.isEmpty()) {
            m77832u(arrayList, arrayListM77850f);
        }
        return arrayList;
    }

    /* renamed from: a0 */
    public ArrayList<DayModeGroup> m77814a0(String str) {
        C1120a.m6677i("MediaDataOperator", "querySharePicDayModeGroupList4CoverBg");
        ArrayList<DayModeGroup> arrayList = new ArrayList<>();
        ArrayList<String[]> arrayListM77850f = CloudAlbumSettings.m14363h().m14374j() ? m77850f("SELECT day_mode, count(1) as count FROM t_media indexed by idx_query_day_mode WHERE opType != 4 and opType != 1 and fileType != 4 and albumType = 1 and recycled = 0 and (scaRank = 0 or scaRank = 1 or (scaState != 1 and scaState != 2)) and albumId = ? group by day_mode order by day_mode desc ", new String[]{str}) : m77850f("SELECT day_mode, count(1) as count FROM t_media indexed by idx_query_day_mode WHERE opType != 4 and opType != 1 and fileType != 4 and albumType = 1 and recycled = 0 and albumId = ? group by day_mode order by day_mode desc ", new String[]{str});
        if (arrayListM77850f != null && !arrayListM77850f.isEmpty()) {
            m77832u(arrayList, arrayListM77850f);
        }
        return arrayList;
    }

    /* renamed from: b0 */
    public ArrayList<DayModeGroup> m77815b0(String str) {
        C1120a.m6677i("MediaDataOperator", "queryShareVideoDayModeGroupList");
        ArrayList<DayModeGroup> arrayList = new ArrayList<>();
        ArrayList<String[]> arrayListM77850f = m77850f("SELECT day_mode, count(1) as count FROM t_media indexed by idx_query_day_mode WHERE opType != 4 and fileType = 4 and albumType = 1 and recycled = 0 and albumId = ? group by day_mode order by day_mode desc ", new String[]{str});
        if (arrayListM77850f != null && !arrayListM77850f.isEmpty()) {
            m77832u(arrayList, arrayListM77850f);
        }
        return arrayList;
    }

    /* renamed from: c0 */
    public ArrayList<Media> m77816c0(String str, long j10, long j11) {
        C1120a.m6677i("MediaDataOperator", "queryByAlbumIdLimit " + j10 + ", " + j11);
        return m77787r(m77852h("SELECT localId,albumId,batchId,createdTime,editedTime,description,favorite,fileName,fileType,mediaId,mediaOwnerId,mediaCreatorId,pictureMetadata,videoMetadata,properties,recycled,recycledTime,scaDetail,size,source,opType,localThumbPath,localBigThumbPath,localRealPath,albumVersion,albumType,hashId,sha256,videoThumbId,thumbFileId,lcdFileId,mediaCreatorName,batchV1Id,batchV1Time,localBatchId,uploadState,hwBurstType FROM t_media indexed by idx_query_album_c_time WHERE opType != 4 and fileType = 4 and albumType = 1 and recycled = 0 and albumId = ? order by createdTime desc limit ?,? ", new String[]{str, String.valueOf(j10), String.valueOf(j11)}));
    }

    /* renamed from: d0 */
    public ArrayList<DayModeGroup> m77817d0() throws Throwable {
        C1120a.m6677i("MediaDataOperator", "queryVideoDayModeGroupList");
        ArrayList<DayModeGroup> arrayList = new ArrayList<>();
        ArrayList<String[]> arrayListM77850f = m77850f("SELECT day_mode, count(1) as count FROM t_media indexed by idx_query_day_mode WHERE opType != 4 and fileType = 4 and albumType = 0 and recycled = 0 and albumId in (SELECT albumId FROM t_album WHERE type = 0 and opType != 4 and recycled != 1 and hide != 1) group by day_mode order by day_mode desc ", null);
        if (arrayListM77850f != null && !arrayListM77850f.isEmpty()) {
            m77832u(arrayList, arrayListM77850f);
        }
        return arrayList;
    }

    /* renamed from: e0 */
    public void m77818e0(Media media) throws SQLException {
        String[] strArr = new String[22];
        strArr[0] = StringUtil.emptyIfBlank(String.valueOf(media.getEditedTime().m28458c()));
        strArr[1] = StringUtil.emptyIfBlank(media.getDescription());
        strArr[2] = StringUtil.emptyIfBlank(String.valueOf((media.getFavorite() != null && media.getFavorite().booleanValue()) ? 1 : 0));
        strArr[3] = StringUtil.emptyIfBlank(media.getId());
        strArr[4] = StringUtil.emptyIfBlank(media.getPictureMetaData() == null ? null : media.getPictureMetaData().toString());
        strArr[5] = StringUtil.emptyIfBlank(media.getVideoMetaData() == null ? null : media.getVideoMetaData().toString());
        strArr[6] = StringUtil.emptyIfBlank(new JSONObject(media.getProperties()).toString());
        strArr[7] = StringUtil.emptyIfBlank(String.valueOf((media.getRecycled() == null || !media.getRecycled().booleanValue()) ? 0 : 1));
        strArr[8] = StringUtil.emptyIfBlank(String.valueOf(media.getRecycledTime() == null ? 0L : media.getRecycledTime().m28458c()));
        strArr[9] = StringUtil.emptyIfBlank(m77834w(media.getScaDetail()));
        strArr[10] = StringUtil.emptyIfBlank(media.getSource());
        strArr[11] = StringUtil.emptyIfBlank(String.valueOf(0));
        strArr[12] = StringUtil.emptyIfBlank(media.getSha256());
        strArr[13] = StringUtil.emptyIfBlank(media.getCreator() != null ? media.getCreator().getDisplayName() : null);
        Map<String, String> properties = media.getProperties();
        if (properties.containsKey("batchCtime")) {
            media.setBatchV1Time(C0241z.m1689g(properties.get("batchCtime"), 0L));
        }
        if (properties.containsKey("batchId")) {
            media.setBatchV1Id(C0241z.m1689g(properties.get("batchId"), 0L));
        }
        strArr[14] = StringUtil.emptyIfBlank(String.valueOf(media.getBatchV1Id()));
        strArr[15] = StringUtil.emptyIfBlank(String.valueOf(media.getBatchV1Time()));
        strArr[16] = StringUtil.emptyIfBlank(String.valueOf(media.getScaRank4DB()));
        strArr[17] = StringUtil.emptyIfBlank(String.valueOf(media.getScaState4DB()));
        strArr[18] = StringUtil.emptyIfBlank(media.getAlbumId());
        strArr[19] = StringUtil.emptyIfBlank(media.getFileName());
        strArr[20] = StringUtil.emptyIfBlank(String.valueOf(media.getSize()));
        strArr[21] = StringUtil.emptyIfBlank(media.getHashId());
        m77847a("UPDATE t_media SET editedTime = ? , description = ? , favorite = ? , mediaId = ? , pictureMetadata = ? , videoMetadata = ? , properties = ? , recycled = ? , recycledTime = ? , scaDetail = ? , source = ? , opType = ? , sha256 = ? , mediaCreatorName = ? , batchV1Id = ? , batchV1Time = ? , scaRank = ? , scaState = ? WHERE albumId = ? AND fileName = ? AND size = ? AND hashId = ? ", strArr);
    }

    /* renamed from: f0 */
    public void m77819f0(FileInfo fileInfo) throws SQLException {
        m77847a("UPDATE t_media SET localThumbPath = ? , localBigThumbPath = ? , localRealPath = ? WHERE albumId = ? AND fileName = ? AND size = ? AND hashId = ? ", new String[]{StringUtil.emptyIfBlank(fileInfo.getLocalThumbPath()), StringUtil.emptyIfBlank(fileInfo.getLocalBigThumbPath()), StringUtil.emptyIfBlank(fileInfo.getLocalRealPath()), StringUtil.emptyIfBlank(fileInfo.getAlbumId()), StringUtil.emptyIfBlank(fileInfo.getFileName()), StringUtil.emptyIfBlank(String.valueOf(fileInfo.getSize())), StringUtil.emptyIfBlank(fileInfo.getHash())});
    }

    /* renamed from: g0 */
    public void m77820g0(FileInfo fileInfo, int i10) throws SQLException {
        C1120a.m6675d("MediaDataOperator", "updateSavePath: " + i10 + ", fileInfo: " + fileInfo.toString());
        String[] strArr = new String[2];
        strArr[1] = StringUtil.emptyIfBlank(fileInfo.getUniqueId());
        if (i10 == 0) {
            strArr[0] = StringUtil.emptyIfBlank(fileInfo.getLocalRealPath());
            m77847a("UPDATE t_media SET localRealPath = ? WHERE mediaId= ? ", strArr);
        } else if (1 == i10) {
            strArr[0] = StringUtil.emptyIfBlank(fileInfo.getLocalBigThumbPath());
            m77847a("UPDATE t_media SET localBigThumbPath = ? WHERE mediaId= ? ", strArr);
        } else if (2 == i10) {
            strArr[0] = StringUtil.emptyIfBlank(fileInfo.getLocalThumbPath());
            m77847a("UPDATE t_media SET localThumbPath = ? WHERE mediaId= ? ", strArr);
        }
    }

    /* renamed from: i */
    public void m77821i(ArrayList<Album> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<Album> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new String[]{String.valueOf(it.next().getId())});
        }
        m77848b("DELETE FROM t_media WHERE albumId = ? ", arrayList2);
    }

    /* renamed from: j */
    public void m77822j(ArrayList<Media> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<Media> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new String[]{String.valueOf(it.next().getLocalId())});
        }
        m77848b("DELETE FROM t_media WHERE localId = ? ", arrayList2);
    }

    /* renamed from: k */
    public void m77823k(ArrayList<Media> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<Media> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new String[]{String.valueOf(it.next().getId())});
        }
        m77848b("DELETE FROM t_media WHERE mediaId = ? ", arrayList2);
    }

    /* renamed from: l */
    public void m77824l(ArrayList<Media> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<Media> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(m77830s(it.next()));
        }
        m77848b("INSERT OR IGNORE INTO t_media(albumId,batchId,createdTime,editedTime,description,favorite,fileName,fileType,mediaId,mediaOwnerId,mediaCreatorId,pictureMetadata,videoMetadata,properties,recycled,recycledTime,scaDetail,size,source,opType,localThumbPath,localBigThumbPath,localRealPath,albumVersion,albumType,hashId,sha256,videoThumbId,thumbFileId,lcdFileId,mediaCreatorName,batchV1Id,batchV1Time,localBatchId,uploadState,hwBurstType,day_mode,month_mode,scaRank,scaState) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", arrayList2);
    }

    /* renamed from: m */
    public void m77825m(ArrayList<Media> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<Media> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(m77831t(it.next()));
        }
        m77848b("UPDATE t_media SET albumId = ?,batchId = ?,createdTime = ?,editedTime = ?,description = ?,favorite = ?,fileName = ?,fileType = ?,mediaOwnerId = ?,mediaCreatorId = ?,pictureMetadata = ?,videoMetadata = ?,properties = ?,recycled = ?,recycledTime = ?,scaDetail = ?,size = ?,source = ?,opType = ?,localThumbPath = ?,localBigThumbPath = ?,localRealPath = ?,albumVersion = ?,albumType = ?,hashId = ?,sha256 = ?,videoThumbId = ?,thumbFileId = ?,lcdFileId = ?,mediaCreatorName = ?,batchV1Id = ?,batchV1Time = ?,localBatchId = ?,uploadState = ?,hwBurstType = ?,scaRank = ?,scaState = ? where mediaId = ? ", arrayList2);
    }

    /* renamed from: n */
    public void m77826n(ArrayList<Media> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<Media> it = arrayList.iterator();
        while (it.hasNext()) {
            Media next = it.next();
            arrayList2.add(new String[]{String.valueOf(next.getOpType()), next.getId()});
        }
        m77848b("UPDATE t_media SET opType = ? WHERE mediaId = ? ", arrayList2);
    }

    /* renamed from: o */
    public void m77827o(String str, String str2) throws SQLException {
        m77847a("DELETE FROM t_media WHERE albumId = ? and hashId = ? ", new String[]{str, str2});
    }

    /* renamed from: p */
    public void m77828p(String str) {
        m77847a("DELETE FROM t_media WHERE albumId = ? and opType = 1 ", new String[]{str});
    }

    /* renamed from: q */
    public void m77829q(String str, String str2) {
        m77847a("DELETE FROM t_media WHERE albumId = ? and hashId = ? and opType = 1 ", new String[]{str, str2});
    }

    /* renamed from: s */
    public final String[] m77830s(Media media) {
        String[] strArr = new String[40];
        int i10 = 0;
        strArr[0] = StringUtil.emptyIfBlank(media.getAlbumId());
        strArr[1] = StringUtil.emptyIfBlank(media.getBatchId());
        strArr[2] = StringUtil.emptyIfBlank(String.valueOf(media.getCreatedTime().m28458c()));
        strArr[3] = StringUtil.emptyIfBlank(String.valueOf(media.getEditedTime().m28458c()));
        strArr[4] = StringUtil.emptyIfBlank(media.getDescription());
        strArr[5] = StringUtil.emptyIfBlank(String.valueOf((media.getFavorite() != null && media.getFavorite().booleanValue()) ? 1 : 0));
        strArr[6] = StringUtil.emptyIfBlank(media.getFileName());
        strArr[7] = StringUtil.emptyIfBlank(String.valueOf(media.getFileType() == null ? 1 : media.getFileType().intValue()));
        strArr[8] = StringUtil.emptyIfBlank(media.getId());
        strArr[9] = StringUtil.emptyIfBlank(media.getMediaOwnerId());
        strArr[10] = StringUtil.emptyIfBlank(media.getCreator() == null ? null : media.getCreator().getUserId());
        strArr[11] = StringUtil.emptyIfBlank(media.getPictureMetaData() == null ? null : media.getPictureMetaData().toString());
        strArr[12] = StringUtil.emptyIfBlank(media.getVideoMetaData() == null ? null : media.getVideoMetaData().toString());
        strArr[13] = StringUtil.emptyIfBlank(new JSONObject(media.getProperties()).toString());
        if (media.getRecycled() != null && media.getRecycled().booleanValue()) {
            i10 = 1;
        }
        strArr[14] = StringUtil.emptyIfBlank(String.valueOf(i10));
        strArr[15] = StringUtil.emptyIfBlank(String.valueOf(media.getRecycledTime() == null ? 0L : media.getRecycledTime().m28458c()));
        strArr[16] = StringUtil.emptyIfBlank(m77834w(media.getScaDetail()));
        strArr[17] = StringUtil.emptyIfBlank(String.valueOf(media.getSize() != null ? media.getSize().longValue() : 0L));
        strArr[18] = StringUtil.emptyIfBlank(media.getSource());
        strArr[19] = StringUtil.emptyIfBlank(String.valueOf(media.getOpType()));
        strArr[20] = StringUtil.emptyIfBlank(media.getLocalThumbPath());
        strArr[21] = StringUtil.emptyIfBlank(media.getLocalBigThumbPath());
        strArr[22] = StringUtil.emptyIfBlank(media.getLocalRealPath());
        strArr[23] = StringUtil.emptyIfBlank(media.getAlbumVersion());
        strArr[24] = StringUtil.emptyIfBlank(String.valueOf(media.getAlbumType()));
        strArr[25] = StringUtil.emptyIfBlank(media.getHashId());
        strArr[26] = StringUtil.emptyIfBlank(media.getSha256());
        strArr[27] = StringUtil.emptyIfBlank(media.getVideoThumbId());
        strArr[28] = StringUtil.emptyIfBlank(media.getThumbFileId());
        strArr[29] = StringUtil.emptyIfBlank(media.getLcdFileId());
        strArr[30] = StringUtil.emptyIfBlank(media.getCreator() != null ? media.getCreator().getDisplayName() : null);
        strArr[31] = StringUtil.emptyIfBlank(String.valueOf(media.getBatchV1Id()));
        strArr[32] = StringUtil.emptyIfBlank(String.valueOf(media.getBatchV1Time()));
        strArr[33] = StringUtil.emptyIfBlank(String.valueOf(media.getLocalBatchId()));
        strArr[34] = StringUtil.emptyIfBlank(String.valueOf(media.getUploadState()));
        strArr[35] = StringUtil.emptyIfBlank(String.valueOf(media.getHwBurstType()));
        String strM70622v = C11829c.m70622v(C1529a.f6579e, media.getCreatedTime().m28458c());
        String strM70622v2 = C11829c.m70622v("yyyyMM", media.getCreatedTime().m28458c());
        strArr[36] = StringUtil.emptyIfBlank(strM70622v);
        strArr[37] = StringUtil.emptyIfBlank(strM70622v2);
        strArr[38] = StringUtil.emptyIfBlank(String.valueOf(media.getScaRank4DB()));
        strArr[39] = StringUtil.emptyIfBlank(String.valueOf(media.getScaState4DB()));
        return strArr;
    }

    /* renamed from: t */
    public final String[] m77831t(Media media) {
        String[] strArr = new String[38];
        int i10 = 0;
        strArr[0] = StringUtil.emptyIfBlank(media.getAlbumId());
        strArr[1] = StringUtil.emptyIfBlank(media.getBatchId());
        strArr[2] = StringUtil.emptyIfBlank(String.valueOf(media.getCreatedTime().m28458c()));
        strArr[3] = StringUtil.emptyIfBlank(String.valueOf(media.getEditedTime().m28458c()));
        strArr[4] = StringUtil.emptyIfBlank(media.getDescription());
        strArr[5] = StringUtil.emptyIfBlank(String.valueOf((media.getFavorite() != null && media.getFavorite().booleanValue()) ? 1 : 0));
        strArr[6] = StringUtil.emptyIfBlank(media.getFileName());
        strArr[7] = StringUtil.emptyIfBlank(String.valueOf(media.getFileType() == null ? 1 : media.getFileType().intValue()));
        strArr[8] = StringUtil.emptyIfBlank(media.getMediaOwnerId());
        strArr[9] = StringUtil.emptyIfBlank(media.getCreator() == null ? null : media.getCreator().getUserId());
        strArr[10] = StringUtil.emptyIfBlank(media.getPictureMetaData() == null ? null : media.getPictureMetaData().toString());
        strArr[11] = StringUtil.emptyIfBlank(media.getVideoMetaData() == null ? null : media.getVideoMetaData().toString());
        strArr[12] = StringUtil.emptyIfBlank(new JSONObject(media.getProperties()).toString());
        if (media.getRecycled() != null && media.getRecycled().booleanValue()) {
            i10 = 1;
        }
        strArr[13] = StringUtil.emptyIfBlank(String.valueOf(i10));
        strArr[14] = StringUtil.emptyIfBlank(String.valueOf(media.getRecycledTime() == null ? 0L : media.getRecycledTime().m28458c()));
        strArr[15] = StringUtil.emptyIfBlank(m77834w(media.getScaDetail()));
        strArr[16] = StringUtil.emptyIfBlank(String.valueOf(media.getSize() != null ? media.getSize().longValue() : 0L));
        strArr[17] = StringUtil.emptyIfBlank(media.getSource());
        strArr[18] = StringUtil.emptyIfBlank(String.valueOf(media.getOpType()));
        strArr[19] = StringUtil.emptyIfBlank(media.getLocalThumbPath());
        strArr[20] = StringUtil.emptyIfBlank(media.getLocalBigThumbPath());
        strArr[21] = StringUtil.emptyIfBlank(media.getLocalRealPath());
        strArr[22] = StringUtil.emptyIfBlank(media.getAlbumVersion());
        strArr[23] = StringUtil.emptyIfBlank(String.valueOf(media.getAlbumType()));
        strArr[24] = StringUtil.emptyIfBlank(media.getHashId());
        strArr[25] = StringUtil.emptyIfBlank(media.getSha256());
        strArr[26] = StringUtil.emptyIfBlank(media.getVideoThumbId());
        strArr[27] = StringUtil.emptyIfBlank(media.getThumbFileId());
        strArr[28] = StringUtil.emptyIfBlank(media.getLcdFileId());
        strArr[29] = StringUtil.emptyIfBlank(media.getCreator() != null ? media.getCreator().getDisplayName() : null);
        strArr[30] = StringUtil.emptyIfBlank(String.valueOf(media.getBatchV1Id()));
        strArr[31] = StringUtil.emptyIfBlank(String.valueOf(media.getBatchV1Time()));
        strArr[32] = StringUtil.emptyIfBlank(String.valueOf(media.getLocalBatchId()));
        strArr[33] = StringUtil.emptyIfBlank(String.valueOf(media.getUploadState()));
        strArr[34] = StringUtil.emptyIfBlank(String.valueOf(media.getHwBurstType()));
        strArr[35] = StringUtil.emptyIfBlank(String.valueOf(media.getScaRank4DB()));
        strArr[36] = StringUtil.emptyIfBlank(String.valueOf(media.getScaState4DB()));
        strArr[37] = StringUtil.emptyIfBlank(String.valueOf(media.getId()));
        return strArr;
    }

    /* renamed from: u */
    public final void m77832u(ArrayList<DayModeGroup> arrayList, ArrayList<String[]> arrayList2) {
        Iterator<String[]> it = arrayList2.iterator();
        while (it.hasNext()) {
            String[] next = it.next();
            if (next != null && next.length == 2) {
                String str = next[0];
                int iM1686d = C0241z.m1686d(next[1], 0);
                DayModeGroup dayModeGroup = new DayModeGroup();
                dayModeGroup.setDayMode(str);
                dayModeGroup.setCount(iM1686d);
                arrayList.add(dayModeGroup);
            }
        }
    }

    /* renamed from: v */
    public final List<ScaDetail> m77833v(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        try {
            return ((ScaDetailList) C11903a.m71435l().mo69832e(str).m69886u(ScaDetailList.class)).getScaDetails();
        } catch (IOException unused) {
            C1120a.m6676e("MediaDataOperator", "getScaDetailList IOException");
            return new ArrayList();
        }
    }

    /* renamed from: w */
    public final String m77834w(List<ScaDetail> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        ScaDetailList scaDetailList = new ScaDetailList();
        scaDetailList.setScaDetails(list);
        return scaDetailList.toString();
    }

    @Override // p649t6.AbstractC12949i
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public Media mo77732c(Cursor cursor) {
        Media media = new Media();
        media.setLocalId(cursor.getLong(0));
        media.setAlbumId(cursor.getString(1));
        media.setBatchId(cursor.getString(2));
        media.setCreatedTime(new C4644l(cursor.getLong(3)));
        media.setEditedTime(new C4644l(cursor.getLong(4)));
        media.setDescription(cursor.getString(5));
        media.setFavorite(Boolean.valueOf(cursor.getInt(6) == 1));
        media.setFileName(cursor.getString(7));
        media.setFileType(Integer.valueOf(cursor.getInt(8)));
        media.setId(cursor.getString(9));
        media.setMediaOwnerId(cursor.getString(10));
        media.setCreator(new User());
        media.getCreator().setUserId(cursor.getString(11));
        media.setPictureMetaData(m77789B(cursor.getString(12)));
        media.setVideoMetaData(m77790C(cursor.getString(13)));
        media.setProperties(C13129a.m78968i(cursor.getString(14)));
        media.setRecycled(Boolean.valueOf(cursor.getInt(15) == 1));
        media.setRecycledTime(new C4644l(cursor.getLong(16)));
        media.setScaDetail(m77833v(cursor.getString(17)));
        media.setSize(Long.valueOf(cursor.getLong(18)));
        media.setSource(cursor.getString(19));
        media.setOpType(cursor.getInt(20));
        media.setLocalThumbPath(cursor.getString(21));
        media.setLocalBigThumbPath(cursor.getString(22));
        media.setLocalRealPath(cursor.getString(23));
        media.setAlbumVersion(cursor.getString(24));
        media.setAlbumType(cursor.getInt(25));
        media.setHashId(cursor.getString(26));
        media.setSha256(cursor.getString(27));
        media.setVideoThumbId(cursor.getString(28));
        media.setThumbFileId(cursor.getString(29));
        media.setLcdFileId(cursor.getString(30));
        media.getCreator().setDisplayName(cursor.getString(31));
        media.setBatchV1Id(cursor.getLong(32));
        media.setBatchV1Time(cursor.getLong(33));
        media.setLocalBatchId(cursor.getLong(34));
        media.setUploadState(cursor.getInt(35));
        media.setHwBurstType(cursor.getInt(36));
        m77788A(cursor, media, cursor.getInt(8));
        return media;
    }

    @Override // p649t6.AbstractC12949i
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public Media mo77733d(Cursor cursor) {
        Media media = new Media();
        media.setAlbumId(cursor.getString(1));
        media.setCreatedTime(new C4644l(cursor.getLong(3)));
        media.setFavorite(Boolean.valueOf(cursor.getInt(6) == 1));
        media.setId(cursor.getString(9));
        int i10 = cursor.getInt(8);
        media.setFileType(Integer.valueOf(i10));
        m77788A(cursor, media, i10);
        return media;
    }

    /* renamed from: z */
    public void m77837z(FileInfo fileInfo, Album album) {
        String strEmptyIfBlank = StringUtil.emptyIfBlank(fileInfo.getAlbumId());
        String strEmptyIfBlank2 = StringUtil.emptyIfBlank(String.valueOf(fileInfo.getBatchId()));
        String strEmptyIfBlank3 = StringUtil.emptyIfBlank(String.valueOf(fileInfo.getCreateTime()));
        String strEmptyIfBlank4 = StringUtil.emptyIfBlank(fileInfo.getFileName());
        String strEmptyIfBlank5 = StringUtil.emptyIfBlank(String.valueOf(fileInfo.getFileType()));
        String strEmptyIfBlank6 = StringUtil.emptyIfBlank(String.valueOf(fileInfo.getSize()));
        String strEmptyIfBlank7 = StringUtil.emptyIfBlank(fileInfo.getLocalThumbPath());
        String strEmptyIfBlank8 = StringUtil.emptyIfBlank(fileInfo.getLocalBigThumbPath());
        String strEmptyIfBlank9 = StringUtil.emptyIfBlank(fileInfo.getLocalRealPath());
        String strEmptyIfBlank10 = StringUtil.emptyIfBlank(album.getAlbumVersion());
        String strEmptyIfBlank11 = StringUtil.emptyIfBlank(String.valueOf(album.getType()));
        String strEmptyIfBlank12 = StringUtil.emptyIfBlank(fileInfo.getHash());
        String strEmptyIfBlank13 = StringUtil.emptyIfBlank(fileInfo.getUserID());
        String strEmptyIfBlank14 = StringUtil.emptyIfBlank(fileInfo.getCreaterId());
        String strEmptyIfBlank15 = StringUtil.emptyIfBlank(String.valueOf(1));
        String strEmptyIfBlank16 = StringUtil.emptyIfBlank(String.valueOf(0));
        String strEmptyIfBlank17 = StringUtil.emptyIfBlank(String.valueOf(fileInfo.getCreateTime()));
        String strEmptyIfBlank18 = StringUtil.emptyIfBlank(String.valueOf(fileInfo.getLocalBatchId()));
        String strM70622v = C11829c.m70622v(C1529a.f6579e, fileInfo.getCreateTime());
        String strM70622v2 = C11829c.m70622v("yyyyMM", fileInfo.getCreateTime());
        String strEmptyIfBlank19 = StringUtil.emptyIfBlank(strM70622v);
        String strEmptyIfBlank20 = StringUtil.emptyIfBlank(strM70622v2);
        PictureMetaData pictureMetaData = new PictureMetaData();
        pictureMetaData.setRotation(Integer.valueOf(fileInfo.getOrientation()));
        m77847a("INSERT OR REPLACE INTO t_media(albumId,batchId,createdTime,fileName,fileType,size,localThumbPath,localBigThumbPath,localRealPath,albumVersion,albumType,hashId,mediaOwnerId,mediaCreatorId,opType,recycled,editedTime,localBatchId,day_mode,month_mode,pictureMetaData) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new String[]{strEmptyIfBlank, strEmptyIfBlank2, strEmptyIfBlank3, strEmptyIfBlank4, strEmptyIfBlank5, strEmptyIfBlank6, strEmptyIfBlank7, strEmptyIfBlank8, strEmptyIfBlank9, strEmptyIfBlank10, strEmptyIfBlank11, strEmptyIfBlank12, strEmptyIfBlank13, strEmptyIfBlank14, strEmptyIfBlank15, strEmptyIfBlank16, strEmptyIfBlank17, strEmptyIfBlank18, strEmptyIfBlank19, strEmptyIfBlank20, pictureMetaData.toString()});
    }
}
