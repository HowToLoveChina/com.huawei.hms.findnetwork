package com.huawei.hianalytics.core;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.DBUtil;
import com.huawei.hianalytics.core.storage.Property;
import eu.C9560a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.core.d */
/* loaded from: classes5.dex */
public class C4738d extends AbstractC4735a<String> {

    /* renamed from: e */
    public static final Property f21674e;

    /* renamed from: f */
    public static final Property f21675f;

    /* renamed from: g */
    public static final Property f21676g;

    /* renamed from: h */
    public static final String f21677h;

    static {
        Property property = new Property(Integer.TYPE, "_id", 0);
        f21674e = property;
        Property property2 = new Property(String.class, "content", 1);
        f21675f = property2;
        Property property3 = new Property(String.class, "event_time", 2);
        f21676g = property3;
        f21677h = "CREATE TABLE IF NOT EXISTS METRIC_MC_INFO (" + property.columnName + " INTEGER PRIMARY KEY NOT NULL," + property2.columnName + " TEXT," + property3.columnName + " TEXT);";
    }

    public C4738d(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase, "METRIC_MC_INFO");
    }

    /* renamed from: a */
    public static void m28794a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        DBUtil.dropTable(sQLiteDatabase, "METRIC_MC_INFO");
        HiLog.m28812w("MetricMcInfoDao", "dropTable");
    }

    @Override // com.huawei.hianalytics.core.AbstractC4735a
    /* renamed from: a */
    public String mo28784a(Cursor cursor) throws JSONException {
        JSONObject jSONObject;
        Property property = f21674e;
        int i10 = cursor.getInt(property.index);
        String string = cursor.getString(f21675f.index);
        Property property2 = f21676g;
        String string2 = cursor.getString(property2.index);
        try {
            jSONObject = new JSONObject(C9560a.m59677f("HiAnalytics_Sdk_Public_Sp_Key", string));
            jSONObject.put(property.columnName, i10);
            jSONObject.put(property2.columnName, string2);
        } catch (JSONException e10) {
            jSONObject = new JSONObject();
            HiLog.m28808e("MetricMcInfoDao", e10.getMessage());
        }
        return jSONObject.toString();
    }

    @Override // com.huawei.hianalytics.core.AbstractC4735a
    /* renamed from: a */
    public void mo28786a(ContentValues contentValues, String str) {
        contentValues.clear();
        contentValues.put(f21675f.columnName, C9560a.m59680i("HiAnalytics_Sdk_Public_Sp_Key", str));
        contentValues.put(f21676g.columnName, String.valueOf(System.currentTimeMillis()));
    }
}
