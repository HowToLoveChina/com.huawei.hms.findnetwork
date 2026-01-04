package p649t6;

import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.p069cg.bean.MediaFileBean;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import p031b7.C1120a;
import p512o7.C11824a;

/* renamed from: t6.j */
/* loaded from: classes2.dex */
public class C12950j extends AbstractC12949i<MediaFileBean> {
    public C12950j() {
        super(C11824a.m70445b());
    }

    /* renamed from: i */
    public void m77853i(String str) throws SQLException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m77847a("DELETE FROM t_photo_upload WHERE albumId = ? ", new String[]{str});
    }

    /* renamed from: j */
    public final String[] m77854j(MediaFileBean mediaFileBean) {
        FileInfo fileInfoM14329e = mediaFileBean.m14329e();
        return fileInfoM14329e == null ? new String[0] : new String[]{fileInfoM14329e.getUserID(), fileInfoM14329e.getAlbumId(), fileInfoM14329e.getShareId(), fileInfoM14329e.getFileName(), String.valueOf(fileInfoM14329e.getFileType()), String.valueOf(fileInfoM14329e.getCreateTime()), fileInfoM14329e.getHash(), String.valueOf(fileInfoM14329e.getSize()), fileInfoM14329e.getLpath(), fileInfoM14329e.getLocalThumbPath(), fileInfoM14329e.getLocalBigThumbPath(), fileInfoM14329e.getLocalRealPath(), String.valueOf(mediaFileBean.m14308K()), String.valueOf(mediaFileBean.m14346p()), fileInfoM14329e.getCreaterId(), fileInfoM14329e.getDataVersion(), fileInfoM14329e.getExpand(), String.valueOf(fileInfoM14329e.getLocalBatchId()), String.valueOf(fileInfoM14329e.getBatchId()), String.valueOf(fileInfoM14329e.getBatchCtime()), String.valueOf(fileInfoM14329e.isRename())};
    }

    @Override // p649t6.AbstractC12949i
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public MediaFileBean mo77732c(Cursor cursor) {
        MediaFileBean mediaFileBean = new MediaFileBean();
        mediaFileBean.m14330e0(cursor.getLong(0));
        FileInfo fileInfo = new FileInfo();
        fileInfo.setUserID(cursor.getString(1));
        fileInfo.setAlbumId(cursor.getString(2));
        fileInfo.setShareId(cursor.getString(3));
        fileInfo.setFileName(cursor.getString(4));
        fileInfo.setFileType(cursor.getInt(5));
        fileInfo.setCreateTime(cursor.getLong(6));
        fileInfo.setHash(cursor.getString(7));
        fileInfo.setSize(cursor.getLong(8));
        fileInfo.setLpath(cursor.getString(9));
        fileInfo.setLocalThumbPath(cursor.getString(10));
        fileInfo.setLocalBigThumbPath(cursor.getString(11));
        fileInfo.setLocalRealPath(cursor.getString(12));
        mediaFileBean.m14357w0(cursor.getInt(13));
        mediaFileBean.m14334g0(cursor.getInt(14));
        fileInfo.setCreaterId(cursor.getString(15));
        fileInfo.setDataVersion(cursor.getString(16));
        fileInfo.setExpand(cursor.getString(17));
        fileInfo.setLocalBatchId(cursor.getLong(18));
        try {
            fileInfo.setBatchId(Integer.parseInt(cursor.getString(19)));
        } catch (Exception unused) {
            C1120a.m6676e("PhotoUploadOperator", "batchId is null");
        }
        fileInfo.setBatchCtime(cursor.getLong(20));
        mediaFileBean.m14317T(fileInfo);
        return mediaFileBean;
    }

    @Override // p649t6.AbstractC12949i
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public MediaFileBean mo77733d(Cursor cursor) {
        return null;
    }

    /* renamed from: m */
    public void m77857m(MediaFileBean mediaFileBean) throws SQLException {
        if (mediaFileBean == null) {
            return;
        }
        String[] strArrM77854j = m77854j(mediaFileBean);
        if (strArrM77854j.length == 0) {
            return;
        }
        m77847a("INSERT OR IGNORE INTO t_photo_upload(userId,albumId,shareId,fileName,fileType,createTime,hash,size,lpath,localThumbPath,localBigThumbPath,localRealPath,uploadState,mobileNetUpload,createrId,dataVersion,expand,localBatchId,batchId,batchTime,isRename) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", strArrM77854j);
    }

    /* renamed from: n */
    public ArrayList<MediaFileBean> m77858n() throws Throwable {
        ArrayList<MediaFileBean> arrayListM77851g = m77851g("SELECT * FROM t_photo_upload", null);
        return arrayListM77851g == null ? new ArrayList<>() : arrayListM77851g;
    }

    /* renamed from: o */
    public String m77859o(FileInfo fileInfo) {
        ArrayList<String[]> arrayListM77850f;
        if (fileInfo != null && (arrayListM77850f = m77850f("SELECT localRealPath FROM t_photo_upload WHERE albumId = ? AND fileName = ? AND hash = ? AND size = ? ", new String[]{fileInfo.getAlbumId(), fileInfo.getFileName(), fileInfo.getHash(), String.valueOf(fileInfo.getSize())})) != null && !arrayListM77850f.isEmpty()) {
            Iterator<String[]> it = arrayListM77850f.iterator();
            while (it.hasNext()) {
                String[] next = it.next();
                if (next != null && next.length == 1) {
                    return next[0];
                }
            }
        }
        return null;
    }

    /* renamed from: p */
    public int m77860p(Media media) {
        ArrayList<MediaFileBean> arrayListM77851g;
        if (media == null || (arrayListM77851g = m77851g("SELECT uploadState FROM t_photo_upload WHERE albumId = ? AND fileName = ? AND hash = ? AND size = ? ", new String[]{media.getAlbumId(), media.getFileName(), media.getHashId(), String.valueOf(media.getSize().longValue())})) == null || arrayListM77851g.isEmpty()) {
            return 0;
        }
        return arrayListM77851g.get(0).m14308K();
    }

    /* renamed from: q */
    public void m77861q(FileInfo fileInfo) throws SQLException {
        m77847a("UPDATE t_photo_upload SET localThumbPath = ? , localBigThumbPath = ? , localRealPath = ? WHERE albumId = ? AND fileName = ? AND size = ? AND hash = ? ", new String[]{StringUtil.emptyIfBlank(fileInfo.getLocalThumbPath()), StringUtil.emptyIfBlank(fileInfo.getLocalBigThumbPath()), StringUtil.emptyIfBlank(fileInfo.getLocalRealPath()), StringUtil.emptyIfBlank(fileInfo.getAlbumId()), StringUtil.emptyIfBlank(fileInfo.getFileName()), StringUtil.emptyIfBlank(String.valueOf(fileInfo.getSize())), StringUtil.emptyIfBlank(fileInfo.getHash())});
    }

    /* renamed from: r */
    public void m77862r(MediaFileBean mediaFileBean) throws SQLException {
        if (mediaFileBean == null) {
            C1120a.m6676e("PhotoUploadOperator", "photoUploadItem is null");
            return;
        }
        FileInfo fileInfoM14329e = mediaFileBean.m14329e();
        if (fileInfoM14329e == null) {
            C1120a.m6676e("PhotoUploadOperator", "fileInfo is null");
            return;
        }
        C1120a.m6675d("PhotoUploadOperator", "status:" + String.valueOf(mediaFileBean.m14308K()) + " albumId:" + fileInfoM14329e.getAlbumId() + " fileName:" + fileInfoM14329e.getFileName() + " hash:" + fileInfoM14329e.getHash() + " size:" + String.valueOf(fileInfoM14329e.getSize()));
        m77847a("UPDATE t_photo_upload SET uploadState = ? WHERE albumId = ? and fileName = ? and hash = ? and size = ? ", new String[]{String.valueOf(mediaFileBean.m14308K()), fileInfoM14329e.getAlbumId(), fileInfoM14329e.getFileName(), fileInfoM14329e.getHash(), String.valueOf(fileInfoM14329e.getSize())});
    }
}
