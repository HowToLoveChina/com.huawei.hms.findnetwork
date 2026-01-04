package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.script.HiCloudSceneHomePageBannerScript;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class HiCloudSceneHomePageBannerOperator extends AbstractC0315c<CommonLanguageDbString> {
    private static final String TAG = "HiCloudSceneHomePageBannerOperator";

    public void batchInsert(ArrayList<CommonLanguageDbString> arrayList) throws C9721b {
        NotifyLogger.m29913d(TAG, "batchInsert begin");
        ArrayList arrayList2 = new ArrayList();
        Iterator<CommonLanguageDbString> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(RecommendCardManager.getInstance().getBatchInsertArgs(it.next()));
        }
        execSQL4Batch(HiCloudSceneHomePageBannerScript.INSERT_STRING, arrayList2);
    }

    public void clear() throws SQLException {
        NotifyLogger.m29913d(TAG, "clear");
        try {
            execSQL(HiCloudSceneHomePageBannerScript.CLEAR);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "clear fail: " + e10.getMessage());
        }
    }

    public boolean hasRecord() {
        NotifyLogger.m29913d(TAG, "hasRecord");
        try {
            return queryCount(HiCloudSceneHomePageBannerScript.QUERY_COUNT) > 0;
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "hasRecord exception: " + e10.toString());
            return false;
        }
    }

    public List<CommonLanguageDbString> queryString(String str, String str2, String str3, String str4) {
        NotifyLogger.m29913d(TAG, "queryString");
        try {
            return queryResult4Vo(HiCloudSceneHomePageBannerScript.SQL_QUERY_STRING_VALUE, new String[]{str, str2 + '%', str3, str4});
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
