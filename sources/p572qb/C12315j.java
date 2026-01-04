package p572qb;

import android.content.Context;
import com.huawei.android.hicloud.manager.IPowerKitListener;
import com.huawei.hicloud.notification.RestoreNotifyUtil;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0219i;
import p046c4.C1383a;
import p046c4.InterfaceC1384b;
import p046c4.InterfaceC1385c;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p709vj.C13452e;
import p746wn.C13622a;
import pe.C12132a;
import pe.InterfaceC12133b;
import pe.InterfaceC12134c;

/* renamed from: qb.j */
/* loaded from: classes3.dex */
public class C12315j implements InterfaceC12133b, InterfaceC1384b, InterfaceC12134c, InterfaceC1385c {

    /* renamed from: k */
    public static final Object f57028k = new Object();

    /* renamed from: a */
    public Context f57029a;

    /* renamed from: b */
    public String f57030b;

    /* renamed from: c */
    public C12132a f57031c;

    /* renamed from: d */
    public C1383a f57032d;

    /* renamed from: e */
    public boolean f57033e;

    /* renamed from: f */
    public final AtomicInteger f57034f;

    /* renamed from: g */
    public boolean f57035g;

    /* renamed from: h */
    public boolean f57036h;

    /* renamed from: i */
    public long f57037i;

    /* renamed from: j */
    public List<IPowerKitListener> f57038j;

    /* renamed from: qb.j$b */
    public static class b {

        /* renamed from: a */
        public static C12315j f57039a = new C12315j();
    }

    public /* synthetic */ C12315j(a aVar) {
        this();
    }

    /* renamed from: f */
    public static C12315j m74059f() {
        return b.f57039a;
    }

    @Override // pe.InterfaceC12133b, p046c4.InterfaceC1384b
    /* renamed from: a */
    public void mo7939a() {
        C11839m.m70688i("HiCloudPowerKitManager", "powerKit onServiceDisconnected");
        Iterator<IPowerKitListener> it = this.f57038j.iterator();
        while (it.hasNext()) {
            it.next().mo16420b();
        }
        m74072p();
        this.f57033e = false;
    }

    @Override // pe.InterfaceC12133b, p046c4.InterfaceC1384b
    /* renamed from: b */
    public void mo7940b() {
        C11839m.m70688i("HiCloudPowerKitManager", "powerKit onServiceConnected");
        this.f57033e = true;
        Iterator<IPowerKitListener> it = this.f57038j.iterator();
        while (it.hasNext()) {
            it.next().mo16419a();
        }
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0094: MOVE (r12 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r14 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:92:0x0094 */
    /* renamed from: c */
    public boolean m74060c(String str, long j10, String str2) {
        boolean z10;
        C11839m.m70688i("HiCloudPowerKitManager", "applyByApplyType packageName: " + str + ", applyType: " + str2 + ", duration: " + j10);
        this.f57034f.incrementAndGet();
        boolean zM72751a = false;
        if (m74065i(str2)) {
            C11839m.m70688i("HiCloudPowerKitManager", "applyByApplyType, over baseline, applyType=" + str2);
            return false;
        }
        if (!this.f57033e) {
            m74063g();
        }
        if (!this.f57033e || (this.f57031c == null && this.f57032d == null)) {
            C11839m.m70688i("HiCloudPowerKitManager", "applyByApplyType power kit not connected");
            return false;
        }
        try {
            try {
                if (C0209d.m1277l1()) {
                    C1383a c1383a = this.f57032d;
                    if (c1383a != null) {
                        c1383a.m7937d(str, 65535, str2);
                        this.f57032d.m7937d(str, 512, str2);
                        boolean zM7935a = false;
                        for (int i10 = 0; !zM7935a && i10 < 2; i10++) {
                            zM7935a = this.f57032d.m7935a(str, 512, j10, str2);
                        }
                        for (int i11 = 0; !zM72751a && i11 < 2; i11++) {
                            zM72751a = this.f57032d.m7935a(str, 65535, j10, str2);
                        }
                    }
                } else {
                    C12132a c12132a = this.f57031c;
                    if (c12132a != null) {
                        c12132a.m72753d(str, 65535, str2);
                        this.f57031c.m72753d(str, 512, str2);
                        boolean zM72751a2 = false;
                        for (int i12 = 0; !zM72751a2 && i12 < 2; i12++) {
                            zM72751a2 = this.f57031c.m72751a(str, 512, j10, str2);
                        }
                        for (int i13 = 0; !zM72751a && i13 < 2; i13++) {
                            zM72751a = this.f57031c.m72751a(str, 65535, j10, str2);
                        }
                        m74067k(str2);
                    }
                }
                m74068l();
                C11839m.m70688i("HiCloudPowerKitManager", "applyByApplyType applyType: " + str2 + ", applyResult: " + zM72751a);
            } catch (Exception e10) {
                e = e10;
                zM72751a = z10;
                C11839m.m70687e("HiCloudPowerKitManager", "applyByApplyType api error: " + e);
                m74061d(zM72751a, str2);
                return zM72751a;
            }
        } catch (Exception e11) {
            e = e11;
        }
        m74061d(zM72751a, str2);
        return zM72751a;
    }

    /* renamed from: d */
    public final void m74061d(boolean z10, String str) {
        if (!C0219i.m1464b()) {
            C11839m.m70686d("HiCloudPowerKitManager", "applyResult, os version not match");
            return;
        }
        C11839m.m70686d("HiCloudPowerKitManager", "applyResult, applyType=" + str + ", applySuccess=" + z10);
        String[] strArrSplit = str.split("-");
        if ((strArrSplit.length > 0 ? strArrSplit[0] : "").equals("auto")) {
            String str2 = strArrSplit.length > 1 ? strArrSplit[1] : "";
            if (PowerKitApplyUtil.isInvalidGroup(str2)) {
                return;
            }
            if (z10) {
                PowerKitApplyUtil.getInstance().setOverBaseLineFlagNew(str2, false);
                PowerKitApplyUtil.getInstance().setLastPowerKitFailedTime(str2, 0L);
                return;
            }
            PowerKitApplyUtil.getInstance().setLastPowerKitFailedTime(str2, System.currentTimeMillis());
            PowerKitApplyUtil.getInstance().setOverBaseLineFlagNew(str2, true);
            C11839m.m70688i("HiCloudPowerKitManager", "reportOverBaseLine");
            C11060c c11060cM66626a = C11058a.m66626a(this.f57030b, "07003", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66664t("reportOverBaseLine");
            c11060cM66626a.m66665u("0");
            c11060cM66626a.m66635A(str);
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        }
    }

    /* renamed from: e */
    public long m74062e(String str) {
        if (str.equals(PowerKitApplyUtil.GROUP_ALBUM)) {
            return 900000L;
        }
        if (str.equals(PowerKitApplyUtil.GROUP_FINDDEVICE)) {
            return 600000L;
        }
        long j10 = this.f57037i;
        if (j10 == 0) {
            return 1800000L;
        }
        return j10;
    }

    /* renamed from: g */
    public void m74063g() {
        C11839m.m70688i("HiCloudPowerKitManager", "init");
        this.f57029a = C0213f.m1377a();
        try {
            if (C0209d.m1277l1()) {
                this.f57032d = C1383a.m7934b(this.f57029a, this);
            } else {
                this.f57031c = C12132a.m72750b(this.f57029a, this);
            }
            this.f57030b = C11058a.m66627b("07003");
        } catch (Exception e10) {
            C11839m.m70687e("HiCloudPowerKitManager", " HiCloudPowerKitManager Exception: " + e10);
        }
    }

    /* renamed from: h */
    public boolean m74064h(String str, long j10, int i10) {
        if (PowerKitApplyUtil.isInvalidGroup(str)) {
            return false;
        }
        long jM74062e = m74062e(str);
        C11839m.m70686d("HiCloudPowerKitManager", "isOverBaseLine, group=" + str + ", applyDuration=" + jM74062e);
        return i10 <= 0 || j10 < jM74062e;
    }

    /* renamed from: i */
    public boolean m74065i(String str) {
        if (!C0219i.m1464b()) {
            C11839m.m70686d("HiCloudPowerKitManager", "isOverBaseLineControl, os version not match");
            return false;
        }
        C11839m.m70686d("HiCloudPowerKitManager", "isOverBaseLineControl, applyType=" + str);
        String[] strArrSplit = str.split("-");
        if (!(strArrSplit.length > 0 ? strArrSplit[0] : "").equals("auto")) {
            return false;
        }
        String str2 = strArrSplit.length > 1 ? strArrSplit[1] : "";
        if (PowerKitApplyUtil.isInvalidGroup(str2)) {
            return false;
        }
        Boolean overBaseLineFlagNew = PowerKitApplyUtil.getInstance().getOverBaseLineFlagNew(str2);
        if (overBaseLineFlagNew != null && !overBaseLineFlagNew.booleanValue()) {
            C11839m.m70686d("HiCloudPowerKitManager", "isOverBaseLineControl overBaseLineFlag: " + overBaseLineFlagNew);
            return false;
        }
        long lastPowerKitFailedTime = PowerKitApplyUtil.getInstance().getLastPowerKitFailedTime(str2);
        C11839m.m70686d("HiCloudPowerKitManager", "isOverBaseLineControl time: " + lastPowerKitFailedTime);
        return System.currentTimeMillis() - lastPowerKitFailedTime <= 1800000;
    }

    /* renamed from: j */
    public boolean m74066j() {
        return this.f57033e;
    }

    /* renamed from: k */
    public final void m74067k(String str) {
        if (this.f57031c == null) {
            C11839m.m70689w("HiCloudPowerKitManager", "registerBaseLineListener, powerKit is null");
            return;
        }
        String[] strArrSplit = str.split("-");
        if (!(strArrSplit.length > 0 ? strArrSplit[0] : "").equals("auto")) {
            C11839m.m70686d("HiCloudPowerKitManager", "registerBaseLineListener, applyType=" + str);
            return;
        }
        if (this.f57036h) {
            C11839m.m70686d("HiCloudPowerKitManager", "registerBaseLineListener, isBaseLineListenerRegistered=true, applyType=" + str);
            return;
        }
        if (this.f57033e) {
            synchronized (f57028k) {
                try {
                    boolean zM72752c = this.f57031c.m72752c(this, 51);
                    this.f57036h = zM72752c;
                    C11839m.m70688i("HiCloudPowerKitManager", "registerBaseLineListener, applyType=" + str + ", isSuccsess=" + zM72752c);
                } catch (Exception e10) {
                    C11839m.m70687e("HiCloudPowerKitManager", "registerBaseLineListener, exception=" + e10.toString());
                }
            }
        }
    }

    /* renamed from: l */
    public final void m74068l() {
        boolean zM72752c;
        boolean zM7936c;
        if (this.f57033e) {
            try {
                if (this.f57031c == null && this.f57032d == null) {
                    return;
                }
                if (C0209d.m1277l1()) {
                    zM7936c = this.f57032d.m7936c(this, 50);
                } else {
                    if (this.f57035g) {
                        C11839m.m70686d("HiCloudPowerKitManager", "registerListener, isListenerRegistered=true");
                        return;
                    }
                    synchronized (f57028k) {
                        zM72752c = this.f57031c.m72752c(this, 50);
                        this.f57035g = zM72752c;
                    }
                    zM7936c = zM72752c;
                }
                C11839m.m70688i("HiCloudPowerKitManager", "powerKit registerListener sink success:" + zM7936c);
            } catch (Exception e10) {
                C11839m.m70687e("HiCloudPowerKitManager", "calling powerKit api error: " + e10.toString());
            }
        }
    }

    /* renamed from: m */
    public void m74069m(IPowerKitListener iPowerKitListener) {
        if (this.f57038j.contains(iPowerKitListener)) {
            return;
        }
        this.f57038j.add(iPowerKitListener);
    }

    /* renamed from: n */
    public final void m74070n(String str) {
        C11060c c11060cM66626a = C11058a.m66626a(this.f57030b, "07003", C13452e.m80781L().m80971t0());
        String str2 = str + "_over_base_line";
        c11060cM66626a.m66664t(str2);
        C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        C11839m.m70686d("HiCloudPowerKitManager", "reportBaseLineEvent, businessId=" + str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00a4  */
    /* JADX WARN: Type inference failed for: r0v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.String] */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m74071o(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "unApplyByApplyType packageName: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = ", applyType: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "HiCloudPowerKitManager"
            p514o9.C11839m.m70688i(r1, r0)
            boolean r0 = r6.f57033e
            r2 = 0
            if (r0 == 0) goto L97
            pe.a r0 = r6.f57031c
            if (r0 != 0) goto L2d
            c4.a r0 = r6.f57032d
            if (r0 != 0) goto L2d
            goto L97
        L2d:
            boolean r0 = p015ak.C0209d.m1277l1()     // Catch: android.os.RemoteException -> L50
            r3 = 1
            r4 = 512(0x200, float:7.17E-43)
            r5 = 65535(0xffff, float:9.1834E-41)
            if (r0 == 0) goto L52
            c4.a r0 = r6.f57032d     // Catch: android.os.RemoteException -> L50
            if (r0 == 0) goto L65
            boolean r0 = r0.m7937d(r7, r5, r8)     // Catch: android.os.RemoteException -> L50
            if (r0 == 0) goto L65
            c4.a r5 = r6.f57032d     // Catch: android.os.RemoteException -> L4d
            boolean r7 = r5.m7937d(r7, r4, r8)     // Catch: android.os.RemoteException -> L4d
            if (r7 == 0) goto L65
        L4b:
            r2 = r3
            goto L65
        L4d:
            r7 = move-exception
            r2 = r0
            goto L82
        L50:
            r7 = move-exception
            goto L82
        L52:
            pe.a r0 = r6.f57031c     // Catch: android.os.RemoteException -> L50
            if (r0 == 0) goto L65
            boolean r0 = r0.m72753d(r7, r5, r8)     // Catch: android.os.RemoteException -> L50
            if (r0 == 0) goto L65
            pe.a r5 = r6.f57031c     // Catch: android.os.RemoteException -> L4d
            boolean r7 = r5.m72753d(r7, r4, r8)     // Catch: android.os.RemoteException -> L4d
            if (r7 == 0) goto L65
            goto L4b
        L65:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: android.os.RemoteException -> L50
            r7.<init>()     // Catch: android.os.RemoteException -> L50
            java.lang.String r0 = "unApplyByApplyType applyType: "
            r7.append(r0)     // Catch: android.os.RemoteException -> L50
            r7.append(r8)     // Catch: android.os.RemoteException -> L50
            java.lang.String r8 = ", result: "
            r7.append(r8)     // Catch: android.os.RemoteException -> L50
            r7.append(r2)     // Catch: android.os.RemoteException -> L50
            java.lang.String r7 = r7.toString()     // Catch: android.os.RemoteException -> L50
            p514o9.C11839m.m70688i(r1, r7)     // Catch: android.os.RemoteException -> L50
            goto L9c
        L82:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "unApplyByApplyType api error: "
            r8.append(r0)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            p514o9.C11839m.m70687e(r1, r7)
            goto L9c
        L97:
            java.lang.String r7 = "unApplyByApplyType power kit not connected"
            p514o9.C11839m.m70689w(r1, r7)
        L9c:
            java.util.concurrent.atomic.AtomicInteger r7 = r6.f57034f
            int r7 = r7.decrementAndGet()
            if (r7 != 0) goto Lac
            java.lang.String r7 = "unApplyByApplyType size is 0"
            p514o9.C11839m.m70688i(r1, r7)
            r6.m74072p()
        Lac:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p572qb.C12315j.m74071o(java.lang.String, java.lang.String):boolean");
    }

    @Override // pe.InterfaceC12134c
    public void onPowerBaseLineUsing(String str, String str2, long j10, int i10, String str3) {
        StringBuilder sb2 = new StringBuilder("onPowerBaseLineUsing");
        sb2.append(", appAndGroup=");
        sb2.append(str2);
        sb2.append(", usageDuration=");
        sb2.append(j10);
        sb2.append(", usageCount=");
        sb2.append(i10);
        if (C0209d.m1257g1()) {
            String[] strArrSplit = str2.split("_");
            String str4 = strArrSplit.length > 1 ? strArrSplit[1] : "";
            if (m74064h(str4, j10, i10)) {
                String currentDate = RestoreNotifyUtil.getInstance().getCurrentDate();
                sb2.append(", overBaseLineFlag=");
                sb2.append(true);
                sb2.append(", overBaseLineDate=");
                sb2.append(currentDate);
                m74070n(str4);
            }
        }
        C11839m.m70688i("HiCloudPowerKitManager", sb2.toString());
        Iterator<IPowerKitListener> it = this.f57038j.iterator();
        while (it.hasNext()) {
            it.next().onPowerBaseLineUsing(str, str2, j10, i10, str3);
        }
    }

    @Override // pe.InterfaceC12134c, p046c4.InterfaceC1385c
    public void onPowerOverUsing(String str, int i10, long j10, long j11, String str2) {
        C11839m.m70688i("HiCloudPowerKitManager", "powerKit onPowerOverUsing module:" + str + " resourceType:" + i10 + " duration:" + j10 + " time:" + j11);
        Iterator<IPowerKitListener> it = this.f57038j.iterator();
        while (it.hasNext()) {
            it.next().onPowerOverUsing(str, i10, j10, j11, str2);
        }
    }

    @Override // pe.InterfaceC12134c, p046c4.InterfaceC1385c
    public void onStateChanged(int i10, int i11, int i12, String str, int i13) {
        C11839m.m70688i("HiCloudPowerKitManager", "onStateChanged stateType " + i10 + ", eventType " + i11);
        Iterator<IPowerKitListener> it = this.f57038j.iterator();
        while (it.hasNext()) {
            it.next().onStateChanged(i10, i11, i12, str, i13);
        }
    }

    /* renamed from: p */
    public final void m74072p() {
        m74074r();
        m74073q();
    }

    /* renamed from: q */
    public final void m74073q() {
        if (this.f57031c == null) {
            C11839m.m70689w("HiCloudPowerKitManager", "unregisterBaseLineListener, powerKit is null");
            return;
        }
        if (!this.f57036h) {
            C11839m.m70689w("HiCloudPowerKitManager", "unregisterBaseLineListener, isBaseLineListenerRegistered=false");
            return;
        }
        if (this.f57033e) {
            synchronized (f57028k) {
                try {
                    boolean zM72754e = this.f57031c.m72754e(this, 51);
                    this.f57036h = !zM72754e;
                    C11839m.m70688i("HiCloudPowerKitManager", "unregisterBaseLineListener, isSuccsess=" + zM72754e);
                } catch (Exception e10) {
                    C11839m.m70687e("HiCloudPowerKitManager", "unregisterBaseLineListener, exception=" + e10.toString());
                }
            }
        }
    }

    /* renamed from: r */
    public final void m74074r() {
        boolean zM72754e;
        boolean zM7938e;
        if (this.f57033e) {
            try {
                if (this.f57031c == null && this.f57032d == null) {
                    return;
                }
                if (C0209d.m1277l1()) {
                    zM7938e = this.f57032d.m7938e(this, 50);
                } else {
                    if (!this.f57035g) {
                        C11839m.m70686d("HiCloudPowerKitManager", "unregisterListener, isListenerRegistered=false");
                        return;
                    }
                    synchronized (f57028k) {
                        zM72754e = this.f57031c.m72754e(this, 50);
                        this.f57035g = !zM72754e;
                    }
                    zM7938e = zM72754e;
                }
                C11839m.m70688i("HiCloudPowerKitManager", "powerKit unregisterListener sink success:" + zM7938e);
            } catch (Exception e10) {
                C11839m.m70687e("HiCloudPowerKitManager", "calling powerKit api error: " + e10.toString());
            }
        }
    }

    public C12315j() {
        this.f57033e = false;
        this.f57034f = new AtomicInteger();
        this.f57035g = false;
        this.f57036h = false;
        this.f57037i = 0L;
        this.f57038j = new ArrayList();
    }
}
