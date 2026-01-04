package com.huawei.hianalytics.core;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.DBUtil;
import com.huawei.hianalytics.core.storage.Property;
import com.huawei.openalliance.p169ad.constant.Constants;
import eu.C9560a;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.core.e */
/* loaded from: classes5.dex */
public class C4739e extends AbstractC4735a<String> {

    /* renamed from: e */
    public static final Property f21678e;

    /* renamed from: f */
    public static final Property f21679f;

    /* renamed from: g */
    public static final Property f21680g;

    /* renamed from: h */
    public static final Property f21681h;

    /* renamed from: i */
    public static final Property f21682i;

    /* renamed from: j */
    public static final Property f21683j;

    /* renamed from: k */
    public static final String f21684k;

    static {
        Property property = new Property(Integer.TYPE, "_id", 0);
        f21678e = property;
        Property property2 = new Property(String.class, "item_id", 1);
        f21679f = property2;
        Property property3 = new Property(String.class, "metric_tag", 2);
        f21680g = property3;
        Property property4 = new Property(String.class, "event_time", 3);
        f21681h = property4;
        Property property5 = new Property(String.class, "content_type", 4);
        f21682i = property5;
        Property property6 = new Property(String.class, "content_code", 5);
        f21683j = property6;
        f21684k = "CREATE TABLE IF NOT EXISTS METRIC_MC_TAG (" + property.columnName + " INTEGER PRIMARY KEY NOT NULL," + property2.columnName + " TEXT," + property3.columnName + " TEXT," + property4.columnName + " TEXT," + property5.columnName + " TEXT," + property6.columnName + " TEXT);";
    }

    public C4739e(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase, "METRIC_MC_TAG");
    }

    /* renamed from: a */
    public int m28796a(List<String> list, String str) {
        if (list == null || list.isEmpty()) {
            return -1;
        }
        StringBuilder sb2 = new StringBuilder();
        String[] strArr = new String[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            strArr[i10] = list.get(i10);
            sb2.append(Constants.QUESTION_STR);
            if (i10 != list.size() - 1) {
                sb2.append(",");
            }
        }
        return m28788b(str + " in( " + ((Object) sb2) + " )", strArr);
    }

    /* renamed from: a */
    public static void m28795a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        DBUtil.dropTable(sQLiteDatabase, "METRIC_MC_TAG");
        HiLog.m28812w("MetricMcTagDao", "dropTable");
    }

    @Override // com.huawei.hianalytics.core.AbstractC4735a
    /* renamed from: a */
    public String mo28784a(Cursor cursor) throws JSONException {
        Property property = f21678e;
        int i10 = cursor.getInt(property.index);
        Property property2 = f21679f;
        String string = cursor.getString(property2.index);
        Property property3 = f21680g;
        String string2 = cursor.getString(property3.index);
        Property property4 = f21681h;
        String string3 = cursor.getString(property4.index);
        Property property5 = f21682i;
        String string4 = cursor.getString(property5.index);
        Property property6 = f21683j;
        String string5 = cursor.getString(property6.index);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(property.columnName, i10);
            jSONObject.put(property2.columnName, string);
            jSONObject.put(property3.columnName, C9560a.m59677f("HiAnalytics_Sdk_Public_Sp_Key", string2));
            jSONObject.put(property4.columnName, string3);
            jSONObject.put(property5.columnName, string4);
            jSONObject.put(property6.columnName, string5);
        } catch (JSONException e10) {
            HiLog.m28808e("MetricMcTagDao", e10.getMessage());
        }
        return jSONObject.toString();
    }

    @Override // com.huawei.hianalytics.core.AbstractC4735a
    /* renamed from: a */
    public void mo28786a(ContentValues contentValues, String str) {
        String str2 = str;
        contentValues.clear();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            Property property = f21679f;
            String strOptString = jSONObject.optString(property.columnName, "");
            Property property2 = f21680g;
            String strM59680i = C9560a.m59680i("HiAnalytics_Sdk_Public_Sp_Key", jSONObject.optString(property2.columnName, ""));
            Property property3 = f21681h;
            String strOptString2 = jSONObject.optString(property3.columnName, String.valueOf(System.currentTimeMillis()));
            Property property4 = f21682i;
            String strOptString3 = jSONObject.optString(property4.columnName, "MC");
            Property property5 = f21683j;
            String strOptString4 = jSONObject.optString(property5.columnName, "");
            contentValues.put(property.columnName, strOptString);
            contentValues.put(property2.columnName, strM59680i);
            contentValues.put(property3.columnName, strOptString2);
            contentValues.put(property4.columnName, strOptString3);
            contentValues.put(property5.columnName, strOptString4);
        } catch (JSONException unused) {
            HiLog.m28812w("MetricMcTagDao", "parse mcTag failed");
            contentValues.clear();
        }
    }
}
