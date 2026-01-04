package com.huawei.hianalytics.core;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.CommonHeaderEx;
import com.huawei.hianalytics.core.storage.DBUtil;
import com.huawei.hianalytics.core.storage.Property;

/* renamed from: com.huawei.hianalytics.core.b */
/* loaded from: classes5.dex */
public class C4736b extends AbstractC4735a<CommonHeaderEx> {

    /* renamed from: e */
    public static final String f21670e = "CREATE TABLE COMMON_HEADER_EX (" + CommonHeaderEx.COLUMN_HASHCODE.columnName + " TEXT PRIMARY KEY NOT NULL," + CommonHeaderEx.COLUMN_HEADER.columnName + " TEXT);";

    public C4736b(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase, CommonHeaderEx.TABLE_NAME);
    }

    /* renamed from: a */
    public static void m28792a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        DBUtil.dropTable(sQLiteDatabase, CommonHeaderEx.TABLE_NAME);
        HiLog.m28812w("CommonHeaderExDao", "dropTable");
    }

    @Override // com.huawei.hianalytics.core.AbstractC4735a
    /* renamed from: a */
    public CommonHeaderEx mo28784a(Cursor cursor) {
        Property property = CommonHeaderEx.COLUMN_HASHCODE;
        String string = cursor.getColumnIndex(property.columnName) == -1 ? "" : cursor.getString(cursor.getColumnIndex(property.columnName));
        Property property2 = CommonHeaderEx.COLUMN_HEADER;
        return new CommonHeaderEx(string, cursor.isNull(cursor.getColumnIndex(property2.columnName)) ? "" : cursor.getString(cursor.getColumnIndex(property2.columnName)));
    }

    @Override // com.huawei.hianalytics.core.AbstractC4735a
    /* renamed from: a */
    public void mo28786a(ContentValues contentValues, CommonHeaderEx commonHeaderEx) {
        CommonHeaderEx commonHeaderEx2 = commonHeaderEx;
        contentValues.clear();
        contentValues.put(CommonHeaderEx.COLUMN_HASHCODE.columnName, commonHeaderEx2.getEvtExHashCode());
        contentValues.put(CommonHeaderEx.COLUMN_HEADER.columnName, commonHeaderEx2.getCommonHeaderEx());
    }
}
