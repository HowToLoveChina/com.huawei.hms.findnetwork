package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.HicloudPushGuideConfigString;
import com.huawei.hicloud.notification.p106db.script.HicloudPushGuideLanguageScript;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class HiCloudPushGuideLanguageOperator extends AbstractC0315c<HicloudPushGuideConfigString> {
    private static final String TAG = "HiCloudPushGuideLanguageOperator";

    private String[] getBatchInsertArgs(HicloudPushGuideConfigString hicloudPushGuideConfigString) {
        return new String[]{hicloudPushGuideConfigString.getCountry(), hicloudPushGuideConfigString.getName(), hicloudPushGuideConfigString.getValue()};
    }

    public void batchInsert(ArrayList<HicloudPushGuideConfigString> arrayList) throws C9721b {
        NotifyLogger.m29913d(TAG, "batchInsert begin");
        ArrayList arrayList2 = new ArrayList();
        Iterator<HicloudPushGuideConfigString> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(getBatchInsertArgs(it.next()));
        }
        execSQL4Batch(HicloudPushGuideLanguageScript.INSERT_STRING, arrayList2);
    }

    public void clear() throws SQLException {
        NotifyLogger.m29913d(TAG, "clear");
        try {
            execSQL(HicloudPushGuideLanguageScript.CLEAR);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "clear fail: " + e10.getMessage());
        }
    }

    public boolean hasRecord() {
        NotifyLogger.m29913d(TAG, "hasRecord");
        try {
            return queryCount(HicloudPushGuideLanguageScript.QUERY_COUNT) > 0;
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, e10.toString());
            return false;
        }
    }

    public String queryContent(String str, String str2) throws Throwable {
        List<HicloudPushGuideConfigString> listQueryResult4Vo;
        NotifyLogger.m29913d(TAG, "queryContent by language and textName");
        try {
            listQueryResult4Vo = queryResult4Vo(HicloudPushGuideLanguageScript.QUERY_VALUE, new String[]{str, str2});
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "queryContent error." + e10.getMessage());
            listQueryResult4Vo = null;
        }
        if (listQueryResult4Vo == null || listQueryResult4Vo.size() <= 0) {
            return null;
        }
        return listQueryResult4Vo.get(0).getValue();
    }

    public List<HicloudPushGuideConfigString> queryString(String str, String str2, String str3, String str4) {
        NotifyLogger.m29913d(TAG, "queryString");
        try {
            return queryResult4Vo(HicloudPushGuideLanguageScript.SQL_QUERY_STRING_VALUE, new String[]{str, str2 + '%', str3, str4});
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, e10.toString());
            return null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public HicloudPushGuideConfigString getVo(Cursor cursor) {
        HicloudPushGuideConfigString hicloudPushGuideConfigString = new HicloudPushGuideConfigString();
        hicloudPushGuideConfigString.setCountry(cursor.getString(0));
        hicloudPushGuideConfigString.setName(cursor.getString(1));
        hicloudPushGuideConfigString.setValue(cursor.getString(2));
        return hicloudPushGuideConfigString;
    }
}
