package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.RestoreNotifyContent;
import com.huawei.hicloud.notification.p106db.script.RestoreNotifyLanguageScript;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class RestoreNotifyLanguageOperator extends AbstractC0315c<RestoreNotifyContent> {
    private static final String TAG = "RestoreNotifyLanguageOperator";

    public void batchInsert(List<RestoreNotifyContent> list) {
        NotifyLogger.m29913d(TAG, "batchInsert begin");
        ArrayList arrayList = new ArrayList();
        Iterator<RestoreNotifyContent> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(getBatchInsertArgs(it.next()));
        }
        try {
            execSQL4Batch(RestoreNotifyLanguageScript.SQL_RESTORE_LANGUAGE_INSERT, arrayList);
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "batchInsert exception:" + e10.toString());
        }
    }

    public void clear() throws SQLException {
        NotifyLogger.m29913d(TAG, "clear ");
        try {
            execSQL(RestoreNotifyLanguageScript.CLEAR);
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "clear fail:" + e10.toString());
        }
    }

    public String[] getBatchInsertArgs(RestoreNotifyContent restoreNotifyContent) {
        return new String[]{restoreNotifyContent.getId(), restoreNotifyContent.getLoginState(), restoreNotifyContent.getLanguage(), restoreNotifyContent.getTitle(), restoreNotifyContent.getSubTitle()};
    }

    public RestoreNotifyContent getRestoreNotifyContent(String str, String str2) throws Throwable {
        try {
            List<RestoreNotifyContent> listQueryResult4Vo = queryResult4Vo(RestoreNotifyLanguageScript.SQL_GET_RESTORE_CONTENT, new String[]{str, str2});
            if (listQueryResult4Vo != null) {
                return listQueryResult4Vo.get(0);
            }
            NotifyLogger.m29916w(TAG, "policies is null, return empty list");
            return null;
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "getRestoreNotifyLanguage exception:" + e10.toString());
            return null;
        }
    }

    public RestoreNotifyContent getRestoreNotifyContentByLanguage(String str, String str2) throws Throwable {
        try {
            List<RestoreNotifyContent> listQueryResult4Vo = queryResult4Vo(RestoreNotifyLanguageScript.SQL_GET_RESTORE_CONTENT_BY_LANGUAGE, new String[]{str, str2 + '%'});
            if (listQueryResult4Vo != null) {
                return listQueryResult4Vo.get(0);
            }
            NotifyLogger.m29916w(TAG, "policies is null, return empty list");
            return null;
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "getRestoreNotifyLanguage exception:" + e10.toString());
            return null;
        }
    }

    public boolean hasRecord() {
        try {
            return queryCount(RestoreNotifyLanguageScript.GET_COUNT) > 0;
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "hasRecord exception:" + e10.toString());
            return false;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public RestoreNotifyContent getVo(Cursor cursor) {
        RestoreNotifyContent restoreNotifyContent = new RestoreNotifyContent();
        restoreNotifyContent.setId(cursor.getString(0));
        restoreNotifyContent.setLoginState(cursor.getString(1));
        restoreNotifyContent.setLanguage(cursor.getString(2));
        restoreNotifyContent.setTitle(cursor.getString(3));
        restoreNotifyContent.setSubTitle(cursor.getString(4));
        return restoreNotifyContent;
    }
}
