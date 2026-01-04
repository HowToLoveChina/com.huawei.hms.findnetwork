package com.huawei.hianalytics.core;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.huawei.hianalytics.core.storage.DBUtil;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.hianalytics.core.storage.Property;

/* renamed from: com.huawei.hianalytics.core.c */
/* loaded from: classes5.dex */
public class C4737c extends AbstractC4735a<Event> {

    /* renamed from: f */
    public static final String f21671f;

    /* renamed from: g */
    public static final String f21672g;

    /* renamed from: e */
    public SQLiteStatement f21673e;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CREATE TABLE EVENT ( ");
        sb2.append(Event.COLUMN_ID.columnName);
        sb2.append(" INTEGER PRIMARY KEY, ");
        sb2.append(Event.COLUMN_EVT_ID.columnName);
        sb2.append(" TEXT, ");
        Property property = Event.COLUMN_EVT_TYPE;
        sb2.append(property.columnName);
        sb2.append(" TEXT, ");
        sb2.append(Event.COLUMN_CONTENT.columnName);
        sb2.append(" TEXT, ");
        sb2.append(Event.COLUMN_EVT_TIME.columnName);
        sb2.append(" TEXT, ");
        Property property2 = Event.COLUMN_SERVICE_TAG;
        sb2.append(property2.columnName);
        sb2.append(" TEXT, ");
        sb2.append(Event.COLUMN_SESSION_ID.columnName);
        sb2.append(" TEXT, ");
        sb2.append(Event.COLUMN_SESSION_NAME.columnName);
        sb2.append(" TEXT, ");
        sb2.append(Event.COLUMN_EVT_EX_HASH_CODE.columnName);
        sb2.append(" TEXT, ");
        Property property3 = Event.COLUMN_PROCESS_NAME;
        sb2.append(property3.columnName);
        sb2.append(" TEXT, ");
        sb2.append(Event.COLUMN_IS_ENCRYPTED.columnName);
        sb2.append(" INTEGER NOT NULL, ");
        Property property4 = Event.COLUMN_SUB_COUNT;
        sb2.append(property4.columnName);
        sb2.append(" INTEGER NOT NULL );");
        f21671f = sb2.toString();
        f21672g = "SELECT SUM(" + property4.columnName + ") FROM " + Event.TABLE_NAME + " WHERE " + property2.columnName + "=? AND " + property.columnName + "=? AND (" + property3.columnName + "=? OR " + property3.columnName + "=?)";
    }

    public C4737c(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase, Event.TABLE_NAME);
    }

    /* renamed from: a */
    public static void m28793a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        DBUtil.dropTable(sQLiteDatabase, Event.TABLE_NAME);
    }

    @Override // com.huawei.hianalytics.core.AbstractC4735a
    /* renamed from: b */
    public long mo28789b() {
        if (this.f21673e == null) {
            this.f21673e = this.f21667b.compileStatement("SELECT COUNT(*) FROM \"EVENT\"");
        }
        return this.f21673e.simpleQueryForLong();
    }

    @Override // com.huawei.hianalytics.core.AbstractC4735a
    /* renamed from: a */
    public Event mo28784a(Cursor cursor) {
        long j10 = cursor.getLong(cursor.getColumnIndex(Event.COLUMN_ID.columnName));
        String string = cursor.getString(cursor.getColumnIndex(Event.COLUMN_EVT_ID.columnName));
        String string2 = cursor.getString(cursor.getColumnIndex(Event.COLUMN_EVT_TYPE.columnName));
        String string3 = cursor.getString(cursor.getColumnIndex(Event.COLUMN_CONTENT.columnName));
        String string4 = cursor.getString(cursor.getColumnIndex(Event.COLUMN_EVT_TIME.columnName));
        String string5 = cursor.getString(cursor.getColumnIndex(Event.COLUMN_SERVICE_TAG.columnName));
        Property property = Event.COLUMN_SESSION_ID;
        String string6 = cursor.isNull(cursor.getColumnIndex(property.columnName)) ? "" : cursor.getString(cursor.getColumnIndex(property.columnName));
        Property property2 = Event.COLUMN_SESSION_NAME;
        String string7 = cursor.isNull(cursor.getColumnIndex(property2.columnName)) ? "" : cursor.getString(cursor.getColumnIndex(property2.columnName));
        Property property3 = Event.COLUMN_EVT_EX_HASH_CODE;
        String string8 = cursor.isNull(cursor.getColumnIndex(property3.columnName)) ? "" : cursor.getString(cursor.getColumnIndex(property3.columnName));
        String string9 = cursor.getString(cursor.getColumnIndex(Event.COLUMN_PROCESS_NAME.columnName));
        int i10 = cursor.getInt(cursor.getColumnIndex(Event.COLUMN_IS_ENCRYPTED.columnName));
        Property property4 = Event.COLUMN_SUB_COUNT;
        return new Event(Long.valueOf(j10), string, string2, string3, string4, string5, string6, string7, string8, string9, i10, cursor.isNull(cursor.getColumnIndex(property4.columnName)) ? 1 : cursor.getInt(cursor.getColumnIndex(property4.columnName)));
    }

    @Override // com.huawei.hianalytics.core.AbstractC4735a
    /* renamed from: a */
    public void mo28786a(ContentValues contentValues, Event event) {
        Event event2 = event;
        contentValues.clear();
        if (event2.getId() != null) {
            contentValues.put(Event.COLUMN_ID.columnName, event2.getId());
        }
        contentValues.put(Event.COLUMN_CONTENT.columnName, event2.getContent());
        contentValues.put(Event.COLUMN_EVT_EX_HASH_CODE.columnName, event2.getEvtExHashCode());
        contentValues.put(Event.COLUMN_EVT_ID.columnName, event2.getEvtid());
        contentValues.put(Event.COLUMN_EVT_TIME.columnName, event2.getEvttime());
        contentValues.put(Event.COLUMN_EVT_TYPE.columnName, event2.getEvttype());
        contentValues.put(Event.COLUMN_IS_ENCRYPTED.columnName, Integer.valueOf(event2.getIsEncrypted()));
        contentValues.put(Event.COLUMN_PROCESS_NAME.columnName, event2.getProcessname());
        contentValues.put(Event.COLUMN_SERVICE_TAG.columnName, event2.getServicetag());
        contentValues.put(Event.COLUMN_SESSION_ID.columnName, event2.getSessionid());
        contentValues.put(Event.COLUMN_SESSION_NAME.columnName, event2.getSessionname());
        contentValues.put(Event.COLUMN_SUB_COUNT.columnName, Integer.valueOf(event2.getSubCount()));
    }
}
