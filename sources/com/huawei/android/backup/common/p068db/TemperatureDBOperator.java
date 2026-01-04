package com.huawei.android.backup.common.p068db;

import android.content.Context;
import android.database.Cursor;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.hms.network.httpclient.util.PreConnectManager;
import java.text.DecimalFormat;
import java.util.ArrayList;
import p647t4.C12937c;

/* loaded from: classes.dex */
public class TemperatureDBOperator extends Operator<C12937c> {
    public TemperatureDBOperator(Context context) {
        super(context);
    }

    @Override // com.huawei.android.backup.common.p068db.Operator
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C12937c mo12587a(Cursor cursor) {
        C12937c c12937c = new C12937c();
        if (cursor == null) {
            return c12937c;
        }
        c12937c.m77677b(cursor.getInt(cursor.getColumnIndexOrThrow("temperature")));
        return c12937c;
    }

    /* renamed from: d */
    public double m12590d(int i10) throws Throwable {
        float size;
        ArrayList<C12937c> arrayListM12588b = m12588b(" SELECT temperature FROM temperature WHERE deviceType=? and record_time> ?", new String[]{String.valueOf(i10), String.valueOf(System.currentTimeMillis() - PreConnectManager.CONNECT_SUCCESS_INTERNAL)});
        int i11 = 0;
        if (arrayListM12588b == null || arrayListM12588b.isEmpty()) {
            size = 0.0f;
        } else {
            size = arrayListM12588b.size();
            int iM77676a = 0;
            while (i11 < size) {
                iM77676a += arrayListM12588b.get(i11).m77676a();
                i11++;
            }
            i11 = iM77676a;
        }
        double d10 = size != 0.0f ? i11 / size : 0.0d;
        try {
            d10 = Double.parseDouble(new DecimalFormat("###.0").format(d10));
        } catch (NumberFormatException e10) {
            C2111d.m12648d("TemperatureDbOperator", "NumberFormatException: " + e10.getMessage());
        }
        C2111d.m12653i("TemperatureDbOperator", "queryTemperature = " + d10);
        return d10;
    }
}
