package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.SyncConfigString;
import com.huawei.hicloud.notification.p106db.script.SyncConfigLanguageScript;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class SyncConfigLanguageOperator extends AbstractC0315c<SyncConfigString> {
    private static final String TAG = "SyncConfigLanguageOperator";

    private String[] getBatchInsertArgs(SyncConfigString syncConfigString) {
        return new String[]{syncConfigString.getCountry(), syncConfigString.getName(), syncConfigString.getValue()};
    }

    public void batchInsert(ArrayList<SyncConfigString> arrayList) throws Exception {
        NotifyLogger.m29913d(TAG, "batchInsert begin");
        ArrayList arrayList2 = new ArrayList();
        Iterator<SyncConfigString> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(getBatchInsertArgs(it.next()));
        }
        execSQL4Batch(SyncConfigLanguageScript.SQL_INSERT, arrayList2);
    }

    public void clear() {
        NotifyLogger.m29913d(TAG, "clear ");
        try {
            execSQL(SyncConfigLanguageScript.CLEAR);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clear fail:" + e10.toString());
        }
    }

    public boolean hasRecord() {
        try {
            return queryCount(SyncConfigLanguageScript.GET_COUNT) > 0;
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "hasRecord exception:" + e10.toString());
            return false;
        }
    }

    public List<SyncConfigString> queryString(String str, String str2, String str3, String str4) {
        NotifyLogger.m29913d(TAG, "queryString");
        try {
            return queryResult4Vo(SyncConfigLanguageScript.SQL_QUERY_STRING_VALUE, new String[]{str, str2 + '%', str3, str4});
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, e10.toString());
            return null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public SyncConfigString getVo(Cursor cursor) {
        SyncConfigString syncConfigString = new SyncConfigString();
        syncConfigString.setCountry(cursor.getString(0));
        syncConfigString.setName(cursor.getString(1));
        syncConfigString.setValue(cursor.getString(2));
        return syncConfigString;
    }
}
