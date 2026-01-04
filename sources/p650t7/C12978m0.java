package p650t7;

import android.os.Bundle;
import com.huawei.hms.api.ConnectionResult;
import p031b7.C1120a;
import p546p6.C12106s;
import p546p6.EnumC12107t;

/* renamed from: t7.m0 */
/* loaded from: classes2.dex */
public class C12978m0 extends AbstractC12988v {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [t7.m0, t7.v] */
    /* JADX WARN: Type inference failed for: r8v1, types: [t7.v] */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.os.BaseBundle, android.os.Bundle] */
    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() {
        String string = "OK";
        this.f59133f = new Bundle();
        int i10 = 0;
        try {
            try {
                C12106s.m72509c().m72520l(EnumC12107t.GENERAL_SYNC_SDK);
            } catch (Exception e10) {
                C1120a.m6676e("UnlockExecutor", "UnlockExecutor runTask Exception: " + e10.toString());
                i10 = ConnectionResult.NETWORK_ERROR;
                string = e10.toString();
            }
            return "";
        } finally {
            this.f59133f.putInt("code", i10);
            this.f59133f.putString("info", string);
        }
    }
}
