package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.script.HiCloudActivesLanguageDBScript;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class HiCloudActivesLanguageOperator extends AbstractC0315c<CommonLanguageDbString> {
    private static final String TAG = "HiCloudActivesLanguageOperator";

    private String[] getBatchInsertArgs(CommonLanguageDbString commonLanguageDbString) {
        return new String[]{commonLanguageDbString.getLanguage(), commonLanguageDbString.getName(), commonLanguageDbString.getValue()};
    }

    public void batchInsert(ArrayList<CommonLanguageDbString> arrayList) throws Exception {
        NotifyLogger.m29913d(TAG, "batchInsert begin");
        ArrayList arrayList2 = new ArrayList();
        Iterator<CommonLanguageDbString> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(getBatchInsertArgs(it.next()));
        }
        execSQL4Batch(HiCloudActivesLanguageDBScript.INSERT_HICLOUD_ACTIVES_LANGUAGE, arrayList2);
    }

    public void clear() {
        NotifyLogger.m29913d(TAG, "clear ");
        try {
            execSQL(HiCloudActivesLanguageDBScript.CLEAR);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clear fail:" + e10.toString());
        }
    }

    public boolean hasRecord() {
        try {
            return queryCount(HiCloudActivesLanguageDBScript.GET_COUNT) > 0;
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "hasRecord exception:" + e10.toString());
            return false;
        }
    }

    public List<CommonLanguageDbString> queryString(String str, String str2, String str3, String str4) {
        NotifyLogger.m29913d(TAG, "queryString");
        try {
            return queryResult4Vo(HiCloudActivesLanguageDBScript.SQL_QUERY_STRING_VALUE, new String[]{str, str2 + '%', str3, str4});
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, e10.toString());
            return null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public CommonLanguageDbString getVo(Cursor cursor) {
        CommonLanguageDbString commonLanguageDbString = new CommonLanguageDbString();
        commonLanguageDbString.setLanguage(cursor.getString(0));
        commonLanguageDbString.setName(cursor.getString(1));
        commonLanguageDbString.setValue(cursor.getString(2));
        return commonLanguageDbString;
    }
}
