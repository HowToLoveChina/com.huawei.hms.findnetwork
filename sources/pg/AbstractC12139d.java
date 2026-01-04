package pg;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.remotecontrol.util.account.bean.AccountInfo;
import p520of.C11860j;
import p576qf.InterfaceC12348a;
import p809yg.C13981a;

/* renamed from: pg.d */
/* loaded from: classes4.dex */
public abstract class AbstractC12139d {

    /* renamed from: a */
    public static volatile AccountInfo f56282a;

    /* renamed from: b */
    public static final Object f56283b = new Object();

    /* renamed from: c */
    public static void m72764c(Context context) {
        C13981a.m83989i("FindAccountHelper", "clearAccountData");
        C12136a.m72755a(context);
        m72765d();
    }

    /* renamed from: d */
    public static void m72765d() {
        C13981a.m83989i("FindAccountHelper", "clearAccountInfo");
        synchronized (f56283b) {
            try {
                if (f56282a != null) {
                    f56282a = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: e */
    public static AccountInfo m72766e(Context context) {
        return m72767f(context, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0012 A[Catch: all -> 0x000e, Exception -> 0x0020, TRY_ENTER, TryCatch #0 {Exception -> 0x0020, blocks: (B:38:0x0012, B:41:0x0022, B:43:0x0026), top: B:52:0x0010, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0022 A[Catch: all -> 0x000e, Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:38:0x0012, B:41:0x0022, B:43:0x0026), top: B:52:0x0010, outer: #1 }] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.android.remotecontrol.util.account.bean.AccountInfo m72767f(android.content.Context r3, boolean r4) {
        /*
            java.lang.Object r0 = pg.AbstractC12139d.f56283b
            monitor-enter(r0)
            if (r3 != 0) goto L10
            qe.f r3 = p575qe.C12347f.m74285n()     // Catch: java.lang.Throwable -> Le
            android.content.Context r3 = r3.m74301m()     // Catch: java.lang.Throwable -> Le
            goto L10
        Le:
            r3 = move-exception
            goto L4b
        L10:
            if (r4 == 0) goto L22
            java.lang.String r4 = "FindAccountHelper"
            java.lang.String r1 = "getAccountInfo from anti"
            p809yg.C13981a.m83989i(r4, r1)     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L20
            com.huawei.android.remotecontrol.util.account.bean.AccountInfo r3 = pg.C12136a.m72758d(r3)     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L20
            pg.AbstractC12139d.f56282a = r3     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L20
            goto L47
        L20:
            r3 = move-exception
            goto L2d
        L22:
            com.huawei.android.remotecontrol.util.account.bean.AccountInfo r4 = pg.AbstractC12139d.f56282a     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L20
            if (r4 != 0) goto L47
            com.huawei.android.remotecontrol.util.account.bean.AccountInfo r3 = pg.C12136a.m72758d(r3)     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L20
            pg.AbstractC12139d.f56282a = r3     // Catch: java.lang.Throwable -> Le java.lang.Exception -> L20
            goto L47
        L2d:
            java.lang.String r4 = "FindAccountHelper"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le
            r1.<init>()     // Catch: java.lang.Throwable -> Le
            java.lang.String r2 = "getAccountInfo err:"
            r1.append(r2)     // Catch: java.lang.Throwable -> Le
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Throwable -> Le
            r1.append(r3)     // Catch: java.lang.Throwable -> Le
            java.lang.String r3 = r1.toString()     // Catch: java.lang.Throwable -> Le
            p809yg.C13981a.m83988e(r4, r3)     // Catch: java.lang.Throwable -> Le
        L47:
            com.huawei.android.remotecontrol.util.account.bean.AccountInfo r3 = pg.AbstractC12139d.f56282a     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            return r3
        L4b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: pg.AbstractC12139d.m72767f(android.content.Context, boolean):com.huawei.android.remotecontrol.util.account.bean.AccountInfo");
    }

    /* renamed from: g */
    public static boolean m72768g(Context context) {
        AccountInfo accountInfoM72766e = m72766e(context);
        if (accountInfoM72766e == null) {
            C13981a.m83990w("FindAccountHelper", "acc is empty");
            return false;
        }
        if (TextUtils.isEmpty(accountInfoM72766e.getUserID4RC())) {
            C13981a.m83990w("FindAccountHelper", "uid is empty");
            return false;
        }
        if (!TextUtils.isEmpty(accountInfoM72766e.getAccountName())) {
            return true;
        }
        C13981a.m83990w("FindAccountHelper", "accName is empty");
        return false;
    }

    /* renamed from: h */
    public static boolean m72769h(Context context) {
        AccountInfo accountInfoM72766e = m72766e(context);
        if (accountInfoM72766e == null) {
            return false;
        }
        return "CN".equalsIgnoreCase(accountInfoM72766e.getCountryCode());
    }

    /* renamed from: i */
    public static /* synthetic */ void m72770i(boolean z10) {
        if (z10) {
            return;
        }
        C11860j.m71010N0("updateFrpAndClearData");
    }

    /* renamed from: j */
    public static /* synthetic */ void m72771j(boolean z10) {
        if (z10) {
            return;
        }
        C11860j.m71010N0("updateFrpMessage");
    }

    /* renamed from: k */
    public static void m72772k(Context context, InterfaceC12348a interfaceC12348a) {
        synchronized (f56283b) {
            try {
                if (f56282a != null) {
                    C13981a.m83989i("FindAccountHelper", "updateAccountInfoSelf");
                    C12136a.m72761g(true, f56282a, context, interfaceC12348a);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: l */
    public static void m72773l(AccountInfo accountInfo) {
        C13981a.m83989i("FindAccountHelper", "updateCacheAccountInfo");
        if (accountInfo == null) {
            C13981a.m83989i("FindAccountHelper", "updateCacheAccountInfo,accountIn is null");
            return;
        }
        synchronized (f56283b) {
            try {
                if (f56282a == null) {
                    f56282a = new AccountInfo();
                }
                f56282a.setAccountName(accountInfo.getAccountName());
                f56282a.setDeviceID(accountInfo.getDeviceID());
                f56282a.setDeviceIDType(accountInfo.getDeviceIDType());
                f56282a.setDeviceType(accountInfo.getDeviceType());
                f56282a.setChallengeString(accountInfo.getChallengeString());
                f56282a.setServiceToken(accountInfo.getServiceToken());
                f56282a.setSiteID4RC(accountInfo.getSiteID4RC());
                f56282a.setUserID4RC(accountInfo.getUserID4RC());
                f56282a.setDeviceTicket(accountInfo.getDeviceTicket());
                f56282a.setAccountType(accountInfo.getAccountType());
                f56282a.setFrpMessage(accountInfo.getFrpMessage());
                f56282a.setUserKey(accountInfo.getUserKey());
                f56282a.setCountryCode(accountInfo.getCountryCode());
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: m */
    public static void m72774m(Context context, String str, String str2) {
        if (f56282a != null) {
            C13981a.m83989i("FindAccountHelper", "updateFrpAndClearData");
            f56282a.setFrpMessage(str);
            f56282a.setClearCmdData(str2);
            C11860j.m71000I0(f56282a.getDeviceID(), "remote clear, updateMessage");
            m72772k(context, new InterfaceC12348a() { // from class: pg.c
                @Override // p576qf.InterfaceC12348a
                public final void onResult(boolean z10) {
                    AbstractC12139d.m72770i(z10);
                }
            });
        }
    }

    /* renamed from: n */
    public static void m72775n(Context context, String str) {
        if (f56282a != null) {
            C13981a.m83989i("FindAccountHelper", "updateFrpMessage");
            f56282a.setFrpMessage(str);
            C11860j.m71000I0(f56282a.getDeviceID(), "remote clear, updateMessage");
            m72772k(context, new InterfaceC12348a() { // from class: pg.b
                @Override // p576qf.InterfaceC12348a
                public final void onResult(boolean z10) {
                    AbstractC12139d.m72771j(z10);
                }
            });
        }
    }

    /* renamed from: o */
    public static void m72776o(Context context, InterfaceC12348a interfaceC12348a) {
        synchronized (f56283b) {
            try {
                if (f56282a != null) {
                    C13981a.m83989i("FindAccountHelper", "updateTAChallenge");
                    C12136a.m72761g(false, f56282a, context, interfaceC12348a);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
