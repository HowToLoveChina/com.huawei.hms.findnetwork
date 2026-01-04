package com.huawei.hicloud.notification.p106db.operator;

import android.database.Cursor;
import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.StockActiveConfigLanguageString;
import com.huawei.hicloud.notification.p106db.script.StockActiveConfigLanguageScript;
import fk.C9721b;
import p016an.AbstractC0315c;

/* loaded from: classes6.dex */
public class StockActiveConfigLanguageOperator extends AbstractC0315c<StockActiveConfigLanguageString> {
    private static final String TAG = "StockActiveConfigLanguageOperator";

    public void clear() throws SQLException {
        NotifyLogger.m29913d(TAG, "clear");
        try {
            execSQL(StockActiveConfigLanguageScript.CLEAR);
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "clear fail: " + e10.getMessage());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p016an.AbstractC0315c
    public StockActiveConfigLanguageString getVo(Cursor cursor) {
        StockActiveConfigLanguageString stockActiveConfigLanguageString = new StockActiveConfigLanguageString();
        stockActiveConfigLanguageString.setCountry(cursor.getString(0));
        stockActiveConfigLanguageString.setName(cursor.getString(1));
        stockActiveConfigLanguageString.setValue(cursor.getString(2));
        return stockActiveConfigLanguageString;
    }
}
