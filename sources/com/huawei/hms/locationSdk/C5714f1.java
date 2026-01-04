package com.huawei.hms.locationSdk;

import android.app.PendingIntent;
import java.util.Objects;

/* renamed from: com.huawei.hms.locationSdk.f1 */
/* loaded from: classes8.dex */
public class C5714f1 extends AbstractC5763v1 {

    /* renamed from: b */
    private PendingIntent f25511b;

    /* renamed from: a */
    public void m33080a(PendingIntent pendingIntent) {
        this.f25511b = pendingIntent;
    }

    @Override // com.huawei.hms.locationSdk.AbstractC5763v1
    public boolean equals(Object obj) {
        PendingIntent pendingIntent;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || (pendingIntent = this.f25511b) == null) {
            return false;
        }
        return pendingIntent.equals(((C5714f1) obj).f25511b);
    }

    public int hashCode() {
        return Objects.hash(this.f25511b);
    }
}
