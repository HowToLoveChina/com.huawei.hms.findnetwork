package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.UrgencyString;
import com.huawei.hicloud.notification.p106db.script.UrgencyLanguageScript;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class UrgencyLanguageOperator extends AbstractC0315c<UrgencyString> {
    private static final String TAG = "UrgencyLanguageOperator";

    private String[] getBatchInsertArgs(UrgencyString urgencyString) {
        return new String[]{urgencyString.getVersion(), urgencyString.getCountry(), urgencyString.getName(), urgencyString.getValue()};
    }

    public void batchInsert(ArrayList<UrgencyString> arrayList) throws Exception {
        NotifyLogger.m29913d(TAG, "batchInsert begin");
        ArrayList arrayList2 = new ArrayList();
        Iterator<UrgencyString> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(getBatchInsertArgs(it.next()));
        }
        execSQL4Batch(UrgencyLanguageScript.SQL_INSERT, arrayList2);
    }

    public void clear() {
        NotifyLogger.m29913d(TAG, "clear ");
        try {
            execSQL(UrgencyLanguageScript.CLEAR);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clear fail:" + e10.toString());
        }
    }

    public boolean hasRecord() {
        try {
            return queryCount(UrgencyLanguageScript.GET_COUNT) > 0;
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "hasRecord exception:" + e10.toString());
            return false;
        }
    }

    public List<UrgencyString> queryString(String str, String str2, String str3, String str4) {
        NotifyLogger.m29913d(TAG, "queryString");
        try {
            return queryResult4Vo(UrgencyLanguageScript.SQL_QUERY_STRING_VALUE, new String[]{str, str2 + '%', str3, str4});
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, e10.toString());
            return null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public UrgencyString getVo(Cursor cursor) {
        UrgencyString urgencyString = new UrgencyString();
        urgencyString.setVersion(cursor.getString(0));
        urgencyString.setCountry(cursor.getString(1));
        urgencyString.setName(cursor.getString(2));
        urgencyString.setValue(cursor.getString(3));
        return urgencyString;
    }
}
