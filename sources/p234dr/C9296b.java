package p234dr;

import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import as.C1016d;
import java.util.List;
import p695v0.ExecutorC13317e;

/* renamed from: dr.b */
/* loaded from: classes8.dex */
public final class C9296b {

    /* renamed from: a */
    public static final byte[] f46654a = new byte[0];

    /* renamed from: dr.b$a */
    public class a extends TelephonyManager.CellInfoCallback {
        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public final void onCellInfo(List<CellInfo> list) {
            synchronized (C9296b.f46654a) {
                C9296b.f46654a.notifyAll();
            }
        }
    }

    /* renamed from: a */
    public static void m58594a(TelephonyManager telephonyManager) {
        String str;
        a aVar = new a();
        byte[] bArr = f46654a;
        synchronized (bArr) {
            try {
                telephonyManager.requestCellInfoUpdate(new ExecutorC13317e(), aVar);
                bArr.wait(1000L);
            } catch (InterruptedException unused) {
                str = "Get cell sleep interrupted!";
                C1016d.m6183c("RefreshByCellInfoCallback", str);
            } catch (Exception unused2) {
                str = "Request cellInfoUpdate failed";
                C1016d.m6183c("RefreshByCellInfoCallback", str);
            }
        }
    }
}
