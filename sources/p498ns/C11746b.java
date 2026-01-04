package p498ns;

import android.content.Context;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import java.util.List;
import p531or.C11991a;

/* renamed from: ns.b */
/* loaded from: classes8.dex */
public final class C11746b {

    /* renamed from: a */
    public Context f54310a;

    /* renamed from: b */
    public TelephonyManager f54311b;

    /* renamed from: ns.b$a */
    public interface a {
        /* renamed from: b */
        void mo68704b(List<CellInfo> list);
    }

    /* renamed from: ns.b$b */
    public class b extends TelephonyManager.CellInfoCallback {

        /* renamed from: a */
        public final /* synthetic */ a f54312a;

        public b(a aVar) {
            this.f54312a = aVar;
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public final void onCellInfo(List<CellInfo> list) {
            this.f54312a.mo68704b(list);
        }
    }

    public C11746b() {
        Context contextM72145a = C11991a.m72145a();
        this.f54310a = contextM72145a;
        Object systemService = contextM72145a.getSystemService("phone");
        if (systemService instanceof TelephonyManager) {
            this.f54311b = (TelephonyManager) systemService;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m70058a(p498ns.C11746b.a r5) {
        /*
            r4 = this;
            android.telephony.TelephonyManager r0 = r4.f54311b
            java.lang.String r1 = "CellScanManager"
            if (r0 != 0) goto L1d
            android.content.Context r0 = r4.f54310a
            java.lang.String r2 = "phone"
            java.lang.Object r0 = r0.getSystemService(r2)
            boolean r2 = r0 instanceof android.telephony.TelephonyManager
            if (r2 == 0) goto L17
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            r4.f54311b = r0
            goto L1d
        L17:
            java.lang.String r4 = "telephonyManager is null"
        L19:
            as.C1016d.m6183c(r1, r4)
            return
        L1d:
            android.content.Context r0 = r4.f54310a
            java.lang.String r2 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r0 = es.C9548m.m59619b(r0, r2)
            if (r0 != 0) goto L2a
            java.lang.String r4 = "do not ACCESS_FINE_LOCATION"
            goto L19
        L2a:
            android.telephony.TelephonyManager r0 = r4.f54311b     // Catch: java.lang.Exception -> L3d
            es.e r2 = es.C9540e.m59581d()     // Catch: java.lang.Exception -> L3d
            java.util.concurrent.ExecutorService r2 = r2.m59584c()     // Catch: java.lang.Exception -> L3d
            ns.b$b r3 = new ns.b$b     // Catch: java.lang.Exception -> L3d
            r3.<init>(r5)     // Catch: java.lang.Exception -> L3d
            r0.requestCellInfoUpdate(r2, r3)     // Catch: java.lang.Exception -> L3d
            goto L4b
        L3d:
            java.lang.String r0 = "requestCellInfoUpdate exception"
            as.C1016d.m6183c(r1, r0)
            android.telephony.TelephonyManager r4 = r4.f54311b
            java.util.List r4 = r4.getAllCellInfo()
            r5.mo68704b(r4)
        L4b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p498ns.C11746b.m70058a(ns.b$a):void");
    }
}
