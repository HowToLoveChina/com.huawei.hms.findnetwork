package p423ka;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.android.hicloud.drive.clouddisk.model.DownloadBuilder;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p514o9.C11839m;

/* renamed from: ka.c */
/* loaded from: classes3.dex */
public class C11023c {

    /* renamed from: a */
    public DownloadBuilder f52102a;

    public C11023c(DownloadBuilder downloadBuilder) {
        this.f52102a = downloadBuilder;
    }

    /* renamed from: a */
    public void m66461a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            DownloadBuilder downloadBuilder = this.f52102a;
            sQLiteDatabase.execSQL("delete from t_slice_download_status where hmac = ? and path = ?", new Object[]{downloadBuilder.hmac, downloadBuilder.path});
        } catch (Exception e10) {
            C11839m.m70687e("SliceDownloadStatus", "sliceDownloadStatus, delete download status error " + e10.getMessage());
        }
    }

    /* renamed from: b */
    public List<DownloadBuilder> m66462b(SQLiteDatabase sQLiteDatabase) throws C9721b {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            try {
                DownloadBuilder downloadBuilder = this.f52102a;
                cursorRawQuery = sQLiteDatabase.rawQuery("select hmac, path, num, object, synckey, taskId, uuid, status, data1, data2, data3 from t_slice_download_status where hmac = ? and path = ? order by num asc ", new String[]{downloadBuilder.hmac, downloadBuilder.path});
                if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                    do {
                        DownloadBuilder downloadBuilder2 = new DownloadBuilder(this.f52102a.hmac);
                        downloadBuilder2.hmac = cursorRawQuery.getString(0);
                        downloadBuilder2.path = cursorRawQuery.getString(1);
                        downloadBuilder2.num = cursorRawQuery.getInt(2);
                        downloadBuilder2.object = cursorRawQuery.getString(3);
                        downloadBuilder2.synckey = cursorRawQuery.getString(4);
                        downloadBuilder2.taskId = cursorRawQuery.getLong(5);
                        downloadBuilder2.uuid = cursorRawQuery.getString(6);
                        downloadBuilder2.status = cursorRawQuery.getInt(7);
                        downloadBuilder2.data1 = cursorRawQuery.getString(8);
                        downloadBuilder2.data2 = cursorRawQuery.getString(9);
                        downloadBuilder2.data3 = cursorRawQuery.getString(10);
                        arrayList.add(downloadBuilder2);
                    } while (cursorRawQuery.moveToNext());
                }
                return arrayList;
            } catch (Exception e10) {
                C11839m.m70687e("SliceDownloadStatus", "sliceDownloadStatus, query download status error " + e10.getMessage());
                throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "sliceDownloadStatus, query download status error " + e10.getMessage());
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    /* renamed from: c */
    public void m66463c(SQLiteDatabase sQLiteDatabase) throws C9721b, SQLException {
        try {
            DownloadBuilder downloadBuilder = this.f52102a;
            DownloadBuilder downloadBuilder2 = this.f52102a;
            DownloadBuilder downloadBuilder3 = this.f52102a;
            DownloadBuilder downloadBuilder4 = this.f52102a;
            sQLiteDatabase.execSQL("replace into t_slice_download_status(hmac, path, num, object, synckey, taskId, uuid, status, data1, data2, data3) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", new Object[]{downloadBuilder.hmac, downloadBuilder.path, Integer.valueOf(downloadBuilder.num), downloadBuilder2.object, downloadBuilder2.synckey, Long.valueOf(downloadBuilder2.taskId), downloadBuilder3.uuid, Integer.valueOf(downloadBuilder3.status), downloadBuilder4.data1, downloadBuilder4.data2, downloadBuilder4.data3});
        } catch (Exception e10) {
            C11839m.m70687e("SliceDownloadStatus", "sliceDownloadStatus, replace download status error " + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "sliceDownloadStatus, replace download slices error " + e10.getMessage());
        }
    }
}
