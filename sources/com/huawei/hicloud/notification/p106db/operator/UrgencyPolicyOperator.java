package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.UrgencyPolicy;
import com.huawei.hicloud.notification.p106db.script.UrgencyPolicyScript;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class UrgencyPolicyOperator extends AbstractC0315c<UrgencyPolicy> {
    private static final String TAG = "UrgencyPolicyOperator";

    public void batchInsert(List<UrgencyPolicy> list) throws Exception {
        NotifyLogger.m29913d(TAG, "batchInsert begin");
        ArrayList arrayList = new ArrayList();
        Iterator<UrgencyPolicy> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(getBatchInsertArgs(it.next()));
        }
        execSQL4Batch(UrgencyPolicyScript.SQL_POLICY_INSERT, arrayList);
    }

    public void clear() {
        NotifyLogger.m29913d(TAG, "clear ");
        try {
            execSQL(UrgencyPolicyScript.CLEAR);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clear fail:" + e10.toString());
        }
    }

    public List<UrgencyPolicy> getAllPolicy() throws Throwable {
        try {
            List<UrgencyPolicy> listQueryResult4Vo = queryResult4Vo(UrgencyPolicyScript.SQL_GET_ALL_POLICY, null);
            if (listQueryResult4Vo != null) {
                return listQueryResult4Vo;
            }
            NotifyLogger.m29916w(TAG, "policies is null, return empty list");
            return Collections.emptyList();
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "getAllPolicy exception:" + e10.toString());
            return Collections.emptyList();
        }
    }

    public String[] getBatchInsertArgs(UrgencyPolicy urgencyPolicy) {
        return new String[]{urgencyPolicy.getId(), urgencyPolicy.getScenarioJsonStr(), urgencyPolicy.getActionJsonStr(), urgencyPolicy.getNoticeTypeJsonStr(), urgencyPolicy.getNoticeJsonStr(), urgencyPolicy.getTopJsonStr(), urgencyPolicy.getDetailJsonStr()};
    }

    public boolean hasRecord() {
        try {
            return queryCount(UrgencyPolicyScript.GET_COUNT) > 0;
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "hasRecord exception:" + e10.toString());
            return false;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public UrgencyPolicy getVo(Cursor cursor) {
        UrgencyPolicy urgencyPolicy = new UrgencyPolicy();
        urgencyPolicy.setId(cursor.getString(0));
        urgencyPolicy.setScenarioStr(cursor.getString(1));
        urgencyPolicy.setActionStr(cursor.getString(2));
        urgencyPolicy.setNoticeTypeStr(cursor.getString(3));
        urgencyPolicy.setNoticeStr(cursor.getString(4));
        urgencyPolicy.setOnTopStr(cursor.getString(5));
        urgencyPolicy.setDetailStr(cursor.getString(6));
        return urgencyPolicy;
    }
}
