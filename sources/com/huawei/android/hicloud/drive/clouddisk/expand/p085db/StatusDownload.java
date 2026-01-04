package com.huawei.android.hicloud.drive.clouddisk.expand.p085db;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.android.hicloud.drive.clouddisk.model.DownloadBuilder;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class StatusDownload {
    private static final String DELETE = "delete from t_restore_status where hmac = ? and path = ?";
    private static final String QUERY = "select hmac, path, num, object, synckey, taskId, uuid, status, data1, data2, data3 from t_restore_status where hmac = ? and path = ? order by num asc ";
    private static final String REPLACE = "replace into t_restore_status(hmac, path, num, object, synckey, taskId, uuid, status, data1, data2, data3) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String TAG = "StatusDownload";
    private DownloadBuilder builder;

    public StatusDownload(DownloadBuilder downloadBuilder) {
        this.builder = downloadBuilder;
    }

    public void delete(SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            DownloadBuilder downloadBuilder = this.builder;
            sQLiteDatabase.execSQL(DELETE, new Object[]{downloadBuilder.hmac, downloadBuilder.path});
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "statusDownload, delete download status error " + e10.getMessage());
        }
    }

    public List<DownloadBuilder> query(SQLiteDatabase sQLiteDatabase) throws C9721b {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            try {
                DownloadBuilder downloadBuilder = this.builder;
                cursorRawQuery = sQLiteDatabase.rawQuery(QUERY, new String[]{downloadBuilder.hmac, downloadBuilder.path});
                if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                    do {
                        DownloadBuilder downloadBuilder2 = new DownloadBuilder(this.builder.hmac);
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
                C11839m.m70687e(TAG, "statusDownload, query download status error " + e10.getMessage());
                throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "statusDownload, query download status error " + e10.getMessage());
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    public void replace(SQLiteDatabase sQLiteDatabase) throws C9721b, SQLException {
        try {
            DownloadBuilder downloadBuilder = this.builder;
            DownloadBuilder downloadBuilder2 = this.builder;
            DownloadBuilder downloadBuilder3 = this.builder;
            DownloadBuilder downloadBuilder4 = this.builder;
            sQLiteDatabase.execSQL(REPLACE, new Object[]{downloadBuilder.hmac, downloadBuilder.path, Integer.valueOf(downloadBuilder.num), downloadBuilder2.object, downloadBuilder2.synckey, Long.valueOf(downloadBuilder2.taskId), downloadBuilder3.uuid, Integer.valueOf(downloadBuilder3.status), downloadBuilder4.data1, downloadBuilder4.data2, downloadBuilder4.data3});
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "statusDownload, replace download status error " + e10.getMessage());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "statusDownload, replace download slices error " + e10.getMessage());
        }
    }
}
