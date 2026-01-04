package com.huawei.hms.locationSdk;

import android.app.PendingIntent;
import java.util.Objects;

/* renamed from: com.huawei.hms.locationSdk.c1 */
/* loaded from: classes8.dex */
public class C5702c1 extends AbstractC5763v1 {

    /* renamed from: b */
    private PendingIntent f25493b;

    /* renamed from: a */
    public void m33043a(PendingIntent pendingIntent) {
        this.f25493b = pendingIntent;
    }

    @Override // com.huawei.hms.locationSdk.AbstractC5763v1
    public boolean equals(Object obj) {
        PendingIntent pendingIntent;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || (pendingIntent = this.f25493b) == null) {
            return false;
        }
        return pendingIntent.equals(((C5702c1) obj).f25493b);
    }

    public int hashCode() {
        return Objects.hash(this.f25493b);
    }
}
