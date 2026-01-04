package com.huawei.android.backup.common.temperature;

import android.content.Context;
import com.huawei.android.backup.common.p068db.TemperatureDBOperator;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.hms.api.ConnectionResult;

/* loaded from: classes.dex */
public class TemperatureControl {

    /* renamed from: a */
    public TemperatureDBOperator f9514a;

    /* renamed from: b */
    public long f9515b;

    /* renamed from: c */
    public int f9516c;

    /* renamed from: d */
    public int f9517d;

    public TemperatureControl(Context context) {
        this.f9514a = new TemperatureDBOperator(context);
    }

    /* renamed from: a */
    public void m12591a() throws Throwable {
        int iM12592b = m12592b();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j10 = this.f9515b;
        if (j10 != 0 && jCurrentTimeMillis - j10 <= 60000) {
            int i10 = iM12592b - this.f9516c;
            this.f9517d = i10;
            if (i10 < 0) {
                this.f9517d = 0;
            }
        } else {
            m12593c(jCurrentTimeMillis, iM12592b);
        }
        int i11 = this.f9517d;
        if (i11 > 0) {
            this.f9516c = i11;
            m12594d(i11);
        }
    }

    /* renamed from: b */
    public final int m12592b() throws Throwable {
        TemperatureDBOperator temperatureDBOperator = this.f9514a;
        if (temperatureDBOperator != null) {
            double dM12590d = temperatureDBOperator.m12590d(0);
            double dM12590d2 = this.f9514a.m12590d(1);
            if (dM12590d <= dM12590d2) {
                dM12590d = dM12590d2;
            }
            if (dM12590d > 44.0d && dM12590d <= 46.0d) {
                return 3000;
            }
            if (dM12590d > 46.0d && dM12590d <= 49.0d) {
                return 6000;
            }
            if (dM12590d > 49.0d) {
                return ConnectionResult.NETWORK_ERROR;
            }
            C2111d.m12653i("TemperatureControl", "not need sleep");
        }
        return 0;
    }

    /* renamed from: c */
    public final void m12593c(long j10, int i10) {
        this.f9515b = j10;
        this.f9517d = i10;
    }

    /* renamed from: d */
    public final void m12594d(int i10) throws InterruptedException {
        try {
            C2111d.m12653i("TemperatureControl", "start sleep needSleepTime = " + i10);
            Thread.sleep((long) i10);
        } catch (InterruptedException e10) {
            C2111d.m12648d("TemperatureControl", "InterruptedException" + e10.getMessage());
        }
    }
}
