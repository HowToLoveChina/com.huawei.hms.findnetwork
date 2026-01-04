package om;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.task.GetOptionsInfoFromCloneTask;
import com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker;
import com.huawei.android.hicloud.p088ui.notification.BackupNotification;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.cloudbackup.p104v3.model.BackupItem;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import com.huawei.hicloud.router.data.UserBackupInfo;
import fk.C9721b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import mk.C11477c;
import p015ak.C0237v;
import p015ak.C0241z;
import p292fn.C9733f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12590s0;
import p618rm.C12591s1;
import p703v8.C13368e;
import p711vl.C13467g;
import p848zl.C14337f;
import p848zl.C14342k;
import tl.C13029h;
import tl.C13030i;
import tl.C13032k;
import tl.C13033l;
import tl.C13036o;

/* renamed from: om.k */
/* loaded from: classes6.dex */
public abstract class AbstractC11971k implements InterfaceC11973m {

    /* renamed from: l */
    public static final Object f55721l = new Object();

    /* renamed from: g */
    public long f55728g;

    /* renamed from: h */
    public long f55729h;

    /* renamed from: i */
    public boolean f55730i;

    /* renamed from: a */
    public C13032k f55722a = null;

    /* renamed from: b */
    public CloudBackupState f55723b = null;

    /* renamed from: c */
    public volatile Handler f55724c = null;

    /* renamed from: d */
    public volatile HandlerThread f55725d = null;

    /* renamed from: e */
    public final Set<Handler> f55726e = new HashSet();

    /* renamed from: f */
    public Handler f55727f = null;

    /* renamed from: j */
    public final Object f55731j = new Object();

    /* renamed from: k */
    public final Map<String, BackupItem> f55732k = new HashMap();

    /* renamed from: om.k$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AbstractC11971k.this.m72041W(message);
        }
    }

    /* renamed from: om.k$b */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            for (Handler handler : AbstractC11971k.this.f55726e) {
                if (handler == null) {
                    C11839m.m70686d(AbstractC11971k.this.mo72029I(), "callback handler is null");
                } else {
                    handler.handleMessage(message);
                }
            }
        }
    }

    /* renamed from: om.k$c */
    public static class c extends AbstractC12367d {

        /* renamed from: a */
        public final AbstractC11971k f55735a;

        /* renamed from: b */
        public final C13033l f55736b;

        public c(AbstractC11971k abstractC11971k, C13033l c13033l) {
            this.f55735a = abstractC11971k;
            this.f55736b = c13033l;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C11839m.m70688i("BaseBackupState", "updateLocalSpaceNotEnoughTask");
            C13033l c13033l = this.f55736b;
            if (c13033l == null || this.f55735a == null) {
                C11839m.m70688i("BaseBackupState", "cloudBackupStateOperator or backupState is null");
                return;
            }
            C13032k c13032kM78546d = c13033l.m78546d(1);
            if (c13032kM78546d != null && c13032kM78546d.m78532p() == 2 && c13032kM78546d.m78530n() == 1007) {
                CloudBackupState cloudBackupState = new CloudBackupState();
                c13032kM78546d.m78536t(cloudBackupState);
                if (cloudBackupState.isLocalSpaceNotEnoughChange()) {
                    return;
                }
                C11839m.m70688i("BaseBackupState", "click phonemanager change local not enough tip");
                c13032kM78546d.m78508E(256);
                this.f55736b.m78547e(c13032kM78546d);
                this.f55735a.mo72064p(false, 0);
            }
        }
    }

    /* renamed from: H */
    public static long m72015H(int i10) {
        return (i10 == 1 ? (i10 * 2) + 1 : i10 * 2) * 86400000;
    }

    /* renamed from: S */
    public static /* synthetic */ boolean m72016S(ICycleChecker iCycleChecker) {
        return !"1".equals(iCycleChecker.getType());
    }

    /* renamed from: T */
    public static boolean m72017T(CloudBackupState cloudBackupState) {
        return cloudBackupState.getReturnCode() == 0 || cloudBackupState.getReturnCode() == 1001 || (cloudBackupState.getReturnCode() == 3001 && cloudBackupState.isCloudSpaceNotEnoughDismiss()) || cloudBackupState.isOverDayErrTipDismiss();
    }

    /* renamed from: Z */
    private C13029h m72018Z(C13030i c13030i) {
        C13029h c13029hM78495f = null;
        if (C12591s1.m75931a().m75941k()) {
            try {
                return c13030i.m78495f(4);
            } catch (C9721b e10) {
                C11839m.m70686d(mo72029I(), "initFirst MANUAL_BACKUP backupTags query error: " + e10.getMessage());
                return null;
            }
        }
        try {
            c13029hM78495f = c13030i.m78495f(1);
        } catch (C9721b e11) {
            C11839m.m70686d(mo72029I(), "initFirst MANUAL_BACKUP backupTags query error: " + e11.getMessage());
        }
        if (c13029hM78495f != null) {
            return c13029hM78495f;
        }
        try {
            return c13030i.m78495f(2);
        } catch (C9721b e12) {
            C11839m.m70686d(mo72029I(), "initFirst AUTO_BACKUP backupTags query error: " + e12.getMessage());
            return c13029hM78495f;
        }
    }

    /* renamed from: A */
    public final void m72022A(CloudBackupState cloudBackupState) {
        Long lValueOf;
        Integer state = cloudBackupState.getState();
        if (state != null && state.intValue() == 2 && cloudBackupState.getReturnCode() == 3001) {
            if (cloudBackupState.getIsNextShow() == 1) {
                QuotaSpaceInfo quotaSpaceInfoM80224M = C13368e.m80184F().m80224M();
                long available = quotaSpaceInfoM80224M != null ? quotaSpaceInfoM80224M.getAvailable() : 0L;
                long jM72033M = m72033M(true);
                lValueOf = Long.valueOf(jM72033M);
                if (jM72033M > 0 && available - jM72033M > 0) {
                    C11839m.m70688i("BaseBackupState", "checkSpaceNotEnoughInfo available: " + available + " ,waitBackupSize: " + lValueOf);
                    cloudBackupState.setFlag(4096);
                    cloudBackupState.setWaitBackupSize(jM72033M);
                    cloudBackupState.setLastSuccessTime(0L);
                    return;
                }
            } else {
                lValueOf = null;
            }
            C13029h c13029hM72018Z = m72018Z(new C13030i());
            if (c13029hM72018Z == null) {
                C11839m.m70689w(mo72029I(), "checkSpaceNotEnoughInfo backupTags is null");
                return;
            }
            cloudBackupState.setWaitBackupSize(C0241z.m1689g(c13029hM72018Z.m78482u(), c13029hM72018Z.m78439E()));
            if (cloudBackupState.getIsNextShow() == 1) {
                if (lValueOf == null) {
                    lValueOf = Long.valueOf(m72033M(true));
                }
                if (lValueOf.longValue() > 0) {
                    C11839m.m70688i(mo72029I(), "checkSpaceNotEnoughInfo waitbackupsize: " + lValueOf);
                    cloudBackupState.setWaitBackupSize(lValueOf.longValue());
                }
            }
        }
    }

    /* renamed from: B */
    public final void m72023B(CloudBackupState cloudBackupState) {
        if (cloudBackupState.getState().intValue() == 3 && mo72050e() <= 0) {
            C13029h c13029hM72018Z = m72018Z(new C13030i());
            if (c13029hM72018Z == null) {
                C11839m.m70689w(mo72029I(), "checkTotalSize backupTags is null");
            } else if (c13029hM72018Z.m78439E() > 0) {
                mo72066r(c13029hM72018Z.m78439E());
            }
        }
    }

    /* renamed from: C */
    public final boolean m72024C() {
        boolean z10 = false;
        if (this.f55722a == null) {
            C11839m.m70689w(mo72029I(), "checkUpdate currentStateItem is null");
            return false;
        }
        boolean z11 = true;
        if (this.f55723b.getState().intValue() != this.f55722a.m78532p()) {
            this.f55722a.m78514K(this.f55723b.getState().intValue());
            z10 = true;
        }
        if (this.f55723b.getProgress() != this.f55722a.m78529m()) {
            this.f55722a.m78511H(this.f55723b.getProgress());
            z10 = true;
        }
        if (!TextUtils.equals(this.f55723b.getCurrentMoudle(), this.f55722a.m78519c())) {
            this.f55722a.m78539w(this.f55723b.getCurrentMoudle());
            z10 = true;
        }
        if (TextUtils.equals(String.valueOf(this.f55723b.getUid()), this.f55722a.m78522f())) {
            z11 = z10;
        } else {
            this.f55722a.m78542z(String.valueOf(this.f55723b.getUid()));
        }
        if (z11) {
            m72057h0();
        }
        return z11;
    }

    /* renamed from: D */
    public int m72025D() {
        boolean zMo72038R = mo72038R();
        boolean zMo72037Q = mo72037Q();
        C11839m.m70688i(mo72029I(), "getBackupOrRestoreBaseState inRestore: " + zMo72038R + ", inBackup: " + zMo72037Q);
        return zMo72038R ? 2 : 1;
    }

    /* renamed from: E */
    public abstract C13032k mo72026E(boolean z10, boolean z11);

    /* renamed from: F */
    public abstract int mo72027F();

    /* renamed from: G */
    public abstract String mo72028G(BackupItem backupItem, String str);

    /* renamed from: I */
    public abstract String mo72029I();

    /* renamed from: J */
    public abstract int mo72030J();

    /* renamed from: K */
    public long m72031K() {
        ICycleChecker iCycleChecker = ICycleChecker.get(new Predicate() { // from class: om.j
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return AbstractC11971k.m72016S((ICycleChecker) obj);
            }
        });
        return iCycleChecker.isCycleSatisfy() ? System.currentTimeMillis() : iCycleChecker.getTargetBackupTime();
    }

    /* renamed from: L */
    public abstract C13033l mo72032L();

    /* renamed from: M */
    public final long m72033M(boolean z10) {
        long jM69963a = C12590s0.m75923y(true).m69963a();
        boolean zM75158X0 = C12515a.m75110o().m75158X0(GetOptionsInfoFromCloneTask.class.getName());
        if ((jM69963a <= 0 || zM75158X0) && !z10) {
            mo72051e0();
        }
        return jM69963a;
    }

    /* renamed from: N */
    public abstract void mo72034N();

    /* renamed from: O */
    public final boolean m72035O() {
        Looper looper;
        if (this.f55725d == null) {
            this.f55725d = new HandlerThread("cloubackupState");
            this.f55725d.start();
            if (this.f55724c == null && this.f55725d != null && (looper = this.f55725d.getLooper()) != null) {
                this.f55724c = new a(looper);
            }
        }
        return this.f55724c != null;
    }

    /* renamed from: P */
    public abstract boolean mo72036P();

    /* renamed from: Q */
    public abstract boolean mo72037Q();

    /* renamed from: R */
    public abstract boolean mo72038R();

    /* renamed from: U */
    public void mo72039U(boolean z10, CloudBackupState cloudBackupState, boolean z11, long j10) {
        if (z11) {
            cloudBackupState.setState(4);
            cloudBackupState.setLastSuccessTime(j10);
            m72070y(cloudBackupState);
            if (m72017T(cloudBackupState)) {
                long jM72033M = m72033M(z10);
                cloudBackupState.setWaitBackupSize(jM72033M);
                C11839m.m70688i(mo72029I(), "getWaitBackupSize increase: " + jM72033M);
            }
        }
    }

    /* renamed from: V */
    public final void m72040V(boolean z10, boolean z11, CloudBackupState cloudBackupState) {
        long jQueryinitopentime;
        SettingOperator settingOperator = new SettingOperator();
        long jQuerylastsuccesstime = settingOperator.querylastsuccesstime();
        if (jQuerylastsuccesstime == 0) {
            if (!z10 && !z11) {
                mo72053f0();
            }
            jQueryinitopentime = settingOperator.queryinitopentime();
        } else {
            jQueryinitopentime = jQuerylastsuccesstime;
        }
        int iM81091f = C13467g.m81086c().m81091f();
        long jM72015H = m72015H(iM81091f);
        cloudBackupState.setNextStartTime(m72031K());
        boolean z12 = System.currentTimeMillis() - jQueryinitopentime > jM72015H;
        C11839m.m70686d(mo72029I(), "frequency: " + iM81091f + " ,isExpired: " + z12);
        cloudBackupState.setLastSuccessTime(jQuerylastsuccesstime);
        if (!z10) {
            mo72034N();
            m72023B(cloudBackupState);
            m72022A(cloudBackupState);
        }
        mo72039U(z11, cloudBackupState, z12, jQueryinitopentime);
    }

    /* renamed from: W */
    public final void m72041W(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            m72043Y(false, message.arg1);
        } else if (i10 == 2) {
            m72043Y(true, message.arg1);
        }
    }

    /* renamed from: X */
    public void m72042X(boolean z10, CloudBackupState cloudBackupState, boolean z11) {
        if (cloudBackupState.getId() != 1) {
            if (cloudBackupState.getId() == 2) {
                C13032k c13032kM78546d = mo72032L().m78546d(2);
                if (c13032kM78546d != null) {
                    if (!CBAccess.inRestoreTask() && CBAccess.hasRestoreTask()) {
                        c13032kM78546d.m78514K(2);
                    }
                    c13032kM78546d.m78536t(cloudBackupState);
                    return;
                }
                cloudBackupState.setState(2);
                C11839m.m70689w(mo72029I(), "processRestoreStateEnd isRetry: " + z10 + " stateItem is null");
                return;
            }
            return;
        }
        boolean z12 = cloudBackupState.getState() == null;
        if (!z12 && cloudBackupState.getState().intValue() == 0) {
            C11839m.m70688i(mo72029I(), "processBackupStateEnd is close");
            return;
        }
        C13032k c13032kMo72026E = !z11 ? mo72026E(z12, false) : null;
        if (c13032kMo72026E != null) {
            c13032kMo72026E.m78536t(cloudBackupState);
            if (!TextUtils.isEmpty(c13032kMo72026E.m78522f())) {
                cloudBackupState.setUid(C0241z.m1685c(c13032kMo72026E.m78522f()));
            }
            if (C14342k.m85520a(c13032kMo72026E.m78532p()) && z12) {
                cloudBackupState.setState(2);
                cloudBackupState.setReturnCode(1001);
            }
        } else {
            cloudBackupState.setState(mo72027F());
        }
        if (C14342k.m85520a(cloudBackupState.getState().intValue())) {
            C11839m.m70688i(mo72029I(), "processBackupStateEnd is backuping");
        } else {
            m72040V(z11, z10, cloudBackupState);
        }
    }

    /* renamed from: Y */
    public final void m72043Y(boolean z10, int i10) {
        List<UserBackupInfo.UserDeviceInfo> listM78568h;
        C11839m.m70686d(mo72029I(), "processState isRetry: " + z10);
        CloudBackupState cloudBackupState = new CloudBackupState();
        m72069x(cloudBackupState);
        if (C9733f.m60705z().m60720O("cloudBackupDeviceNameManagement") && (listM78568h = new C13036o().m78568h()) != null && !listM78568h.isEmpty() && !TextUtils.isEmpty(listM78568h.get(0).getDeviceName())) {
            String strM68633c = C11477c.m68633c(listM78568h.get(0).getDeviceName());
            cloudBackupState.setDeviceName(strM68633c);
            CloudBackupState cloudBackupState2 = this.f55723b;
            if (cloudBackupState2 != null && TextUtils.isEmpty(cloudBackupState2.getDeviceName())) {
                this.f55723b.setDeviceName(strM68633c);
            }
        }
        m72042X(z10, cloudBackupState, false);
        CloudBackupState cloudBackupState3 = this.f55723b;
        if (cloudBackupState3 != null) {
            cloudBackupState.setDisplayModule(cloudBackupState3.getDisplayModule());
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = mo72030J();
        messageObtain.arg1 = i10;
        messageObtain.arg2 = 0;
        messageObtain.obj = cloudBackupState;
        m72068w(messageObtain);
        C11839m.m70686d(mo72029I(), "processState " + cloudBackupState);
    }

    @Override // om.InterfaceC11973m
    /* renamed from: a */
    public synchronized void mo72044a(int i10, boolean z10) {
        if (2 == i10) {
            try {
                BackupNotification.getInstance().cancelBackupNotification();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f55730i = z10;
        this.f55728g = 0L;
        this.f55732k.clear();
        this.f55729h = 0L;
        C13033l c13033lMo72032L = mo72032L();
        C13032k c13032kM78546d = c13033lMo72032L.m78546d(i10);
        this.f55722a = c13032kM78546d;
        String str = "2";
        if (c13032kM78546d == null || c13032kM78546d.m78532p() == 3) {
            c13033lMo72032L.m78543a(i10);
            this.f55722a = new C13032k();
            str = "1";
        }
        if (!z10) {
            this.f55722a.m78504A(str);
        }
        this.f55722a.m78509F(i10);
        this.f55722a.m78513J(System.currentTimeMillis());
        this.f55722a.m78512I(0);
        this.f55722a.m78539w(null);
        this.f55722a.m78540x(String.valueOf(0));
        this.f55722a.m78510G(0);
        this.f55722a.m78514K(5);
        CloudBackupState cloudBackupState = new CloudBackupState();
        this.f55723b = cloudBackupState;
        this.f55722a.m78536t(cloudBackupState);
        m72057h0();
        mo72064p(false, 0);
    }

    /* renamed from: a0 */
    public synchronized void m72045a0() {
        try {
            if (this.f55724c != null) {
                Looper looper = this.f55724c.getLooper();
                this.f55724c = null;
                if (looper != null) {
                    looper.quit();
                }
            }
            this.f55725d = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: b0 */
    public final void m72046b0(String str, boolean z10) {
        if (z10) {
            mo72032L().m78543a(2);
            return;
        }
        if (this.f55722a == null) {
            C13032k c13032k = new C13032k();
            this.f55722a = c13032k;
            c13032k.m78509F(2);
        }
        this.f55722a.m78512I(C0241z.m1685c(str));
        this.f55722a.m78507D(System.currentTimeMillis());
        this.f55722a.m78514K(2);
        m72057h0();
    }

    /* renamed from: c0 */
    public final void m72047c0(int i10, BackupItem backupItem) {
        int i11;
        int i12;
        Integer num;
        int i13;
        String currentMoudle = this.f55723b.getCurrentMoudle();
        int iFloor = (int) Math.floor(i10 * 0.96d);
        int iIntValue = this.f55723b.getState().intValue();
        if (backupItem != null) {
            int iM29869c = backupItem.m29869c();
            int iM29876j = backupItem.m29876j();
            Integer numValueOf = Integer.valueOf(backupItem.m29859L());
            int iM71978g = (int) C11965e.m71974f().m71978g(backupItem);
            i11 = iM29869c;
            currentMoudle = (backupItem.m29863P() || backupItem.m29867U()) ? backupItem.m29871e() : backupItem.m29870d();
            i12 = iM71978g;
            num = numValueOf;
            i13 = iM29876j;
        } else {
            i11 = 0;
            i12 = 0;
            num = null;
            i13 = 0;
        }
        if (this.f55723b.getState().intValue() == 1) {
            iIntValue = 8;
        }
        this.f55723b.setCurrent(0);
        this.f55723b.setCount(0);
        this.f55723b.setPrepareSize(0L);
        if (num != null && (backupItem.m29863P() || backupItem.m29830O0())) {
            int iIntValue2 = num.intValue();
            if (iIntValue2 == 1 || iIntValue2 == 2) {
                if (backupItem.m29863P() && backupItem.m29869c() > 4) {
                    this.f55723b.setPrepareSize(backupItem.m29868a());
                }
                iIntValue = 6;
            } else if (iIntValue2 == 3 || iIntValue2 == 4 || iIntValue2 == 5) {
                if (backupItem.m29830O0()) {
                    this.f55723b.setCurrent(i11);
                    this.f55723b.setCount(i13);
                } else if (i13 > 4) {
                    this.f55723b.setPrepareSize(backupItem.m29868a());
                }
                iIntValue = 7;
            }
            this.f55723b.setModuleProgress(i12);
        }
        this.f55723b.setState(iIntValue);
        this.f55723b.setProgress(iFloor);
        this.f55723b.setCurrentMoudle(currentMoudle);
        m72024C();
        Message messageObtain = Message.obtain();
        messageObtain.what = mo72030J();
        messageObtain.arg2 = 1;
        messageObtain.obj = this.f55723b;
        C11839m.m70686d(mo72029I(), "sendBackupProgress: progress:" + iFloor + this.f55723b);
        m72068w(messageObtain);
    }

    @Override // om.InterfaceC11973m
    /* renamed from: d */
    public void mo72048d(Handler handler) {
        synchronized (f55721l) {
            this.f55726e.remove(handler);
        }
        if (this.f55726e.isEmpty()) {
            m72045a0();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* renamed from: d0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m72049d0(com.huawei.hicloud.cloudbackup.p104v3.model.BackupItem r9, com.huawei.hicloud.cloudbackup.p104v3.model.BackupItem r10, int r11, java.util.function.Supplier<java.lang.Float> r12) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: om.AbstractC11971k.m72049d0(com.huawei.hicloud.cloudbackup.v3.model.BackupItem, com.huawei.hicloud.cloudbackup.v3.model.BackupItem, int, java.util.function.Supplier):void");
    }

    @Override // om.InterfaceC11973m
    /* renamed from: e */
    public abstract long mo72050e();

    /* renamed from: e0 */
    public abstract void mo72051e0();

    @Override // om.InterfaceC11973m
    /* renamed from: f */
    public void mo72052f() {
        C12515a.m75110o().m75172d(new c(this, mo72032L()));
    }

    /* renamed from: f0 */
    public abstract void mo72053f0();

    @Override // om.InterfaceC11973m
    /* renamed from: g */
    public void mo72054g(Handler handler) {
        synchronized (f55721l) {
            this.f55726e.add(handler);
        }
    }

    /* renamed from: g0 */
    public void m72055g0() {
        mo72064p(false, 0);
    }

    @Override // om.InterfaceC11973m
    /* renamed from: h */
    public void mo72056h(C13029h c13029h, Integer num, boolean z10) {
        if (c13029h == null) {
            C11839m.m70689w(mo72029I(), "replaceStateByTags backupTags is null");
            return;
        }
        C13033l c13033lMo72032L = mo72032L();
        int i10 = c13029h.m78442H() == 3 ? 2 : 1;
        C13032k c13032kM78546d = c13033lMo72032L.m78546d(i10);
        if (c13032kM78546d == null) {
            c13032kM78546d = new C13032k();
        }
        if (num != null) {
            c13032kM78546d.m78514K(num.intValue());
        }
        c13032kM78546d.m78509F(i10);
        c13032kM78546d.m78538v(c13029h.m78465h());
        c13032kM78546d.m78506C(c13029h.m78488y());
        if (c13032kM78546d.m78530n() == 0 && z10) {
            c13032kM78546d.m78512I(C0241z.m1685c(c13029h.m78474q().replace("001_", "")));
        }
        c13032kM78546d.m78507D(c13029h.m78464f());
        c13033lMo72032L.m78547e(c13032kM78546d);
    }

    /* renamed from: h0 */
    public final void m72057h0() {
        mo72032L().m78547e(this.f55722a);
    }

    @Override // om.InterfaceC11973m
    /* renamed from: i */
    public synchronized void mo72058i(int i10) {
        C13032k c13032kM78546d = mo72032L().m78546d(i10);
        this.f55722a = c13032kM78546d;
        if (c13032kM78546d == null) {
            C11839m.m70689w(mo72029I(), "start currentState is null");
        } else {
            m72057h0();
        }
    }

    /* renamed from: i0 */
    public final void m72059i0(int i10) {
        ArrayList arrayList = new ArrayList(this.f55732k.values());
        Message messageObtain = Message.obtain();
        messageObtain.what = i10;
        messageObtain.obj = arrayList;
        CBCallBack.getInstance().sendMessage(messageObtain);
        this.f55732k.clear();
    }

    @Override // om.InterfaceC11973m
    /* renamed from: j */
    public synchronized void mo72060j(int i10, String str) {
        C13032k c13032kM78546d = mo72032L().m78546d(i10);
        this.f55722a = c13032kM78546d;
        if (c13032kM78546d == null) {
            C11839m.m70689w(mo72029I(), "start currentState is null");
            return;
        }
        c13032kM78546d.m78516M(str);
        this.f55722a.m78514K(1);
        this.f55722a.m78536t(this.f55723b);
        m72057h0();
        m72043Y(false, 0);
    }

    @Override // om.InterfaceC11973m
    /* renamed from: l */
    public synchronized void mo72061l(int i10, String str, boolean z10) {
        try {
            this.f55723b = null;
            this.f55722a = mo72032L().m78546d(i10);
            if (str != null) {
                str = str.replace("001_", "");
            }
            if (1 == i10) {
                m72067v(str, z10);
            } else if (2 == i10) {
                m72046b0(str, z10);
            } else {
                C11839m.m70689w(mo72029I(), "end id not backup or restore");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // om.InterfaceC11973m
    /* renamed from: n */
    public synchronized void mo72062n(int i10) {
        C13032k c13032kM78546d = mo72032L().m78546d(i10);
        this.f55722a = c13032kM78546d;
        this.f55730i = false;
        if (c13032kM78546d == null) {
            C11839m.m70689w(mo72029I(), "finish currentState is null");
            return;
        }
        c13032kM78546d.m78514K(9);
        this.f55722a.m78539w(null);
        this.f55722a.m78536t(this.f55723b);
        m72057h0();
        m72055g0();
    }

    @Override // om.InterfaceC11973m
    /* renamed from: o */
    public synchronized void mo72063o(BackupItem backupItem, BackupItem backupItem2, int i10, Supplier<Float> supplier) {
        CloudBackupState cloudBackupState = this.f55723b;
        if (cloudBackupState == null) {
            C11839m.m70689w(mo72029I(), "sendBackupProgress currentState is null in momery");
            return;
        }
        if (cloudBackupState.getReturnCode() == 3001) {
            C0237v.m1661c();
        }
        if (TextUtils.equals(this.f55723b.getVersion(), CBSBaseReq.CURRENT_API_VERSION)) {
            m72049d0(backupItem, backupItem2, i10, supplier);
        } else {
            m72047c0(0, backupItem);
        }
    }

    @Override // om.InterfaceC11973m
    /* renamed from: p */
    public synchronized void mo72064p(boolean z10, int i10) {
        try {
            C11839m.m70688i(mo72029I(), "get state start");
            if (m72035O()) {
                Message messageObtain = Message.obtain();
                messageObtain.arg1 = i10;
                messageObtain.what = z10 ? 2 : 1;
                this.f55724c.sendMessage(messageObtain);
            } else {
                C11839m.m70689w(mo72029I(), "state initOpr failed");
            }
            C11839m.m70688i(mo72029I(), "get state end");
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // om.InterfaceC11973m
    /* renamed from: q */
    public synchronized void mo72065q(float f10) {
        CloudBackupState cloudBackupState = this.f55723b;
        if (cloudBackupState == null) {
            C11839m.m70688i(mo72029I(), "sendBackupProgress currentStateItem is null in momery");
            return;
        }
        cloudBackupState.setProgress(f10);
        m72024C();
        Message messageObtain = Message.obtain();
        messageObtain.what = mo72030J();
        messageObtain.arg2 = 1;
        messageObtain.obj = this.f55723b;
        C11839m.m70686d(mo72029I(), "sendBackupProgress " + this.f55723b);
        m72068w(messageObtain);
    }

    @Override // om.InterfaceC11973m
    /* renamed from: r */
    public abstract void mo72066r(long j10);

    /* renamed from: v */
    public final void m72067v(String str, boolean z10) {
        boolean z11 = true;
        if (this.f55722a == null) {
            if (!mo72036P()) {
                C11839m.m70688i(mo72029I(), "backup end and backupswitch is close");
                return;
            } else {
                C13032k c13032k = new C13032k();
                this.f55722a = c13032k;
                c13032k.m78509F(1);
            }
        }
        int iM1685c = C0241z.m1685c(str);
        this.f55722a.m78512I(iM1685c);
        this.f55722a.m78540x(String.valueOf(0));
        this.f55722a.m78507D(System.currentTimeMillis());
        if (!z10 && !C14337f.f63677c.contains(Integer.valueOf(iM1685c))) {
            z11 = false;
        }
        this.f55722a.m78514K(z11 ? 3 : 2);
        m72057h0();
    }

    /* renamed from: w */
    public final void m72068w(Message message) {
        synchronized (this.f55731j) {
            try {
                if (this.f55727f == null) {
                    this.f55727f = new b(Looper.getMainLooper());
                }
                this.f55727f.sendMessage(message);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004c  */
    /* renamed from: x */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m72069x(com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState r7) {
        /*
            r6 = this;
            boolean r0 = r6.mo72038R()
            boolean r1 = r6.mo72037Q()
            r2 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r7.setId(r2)
            java.lang.String r2 = r6.mo72029I()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "checkBackupOrRestoreBaseState inRestore: "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r5 = ", inBackup: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            p514o9.C11839m.m70688i(r2, r4)
            if (r0 == 0) goto L3d
            r6 = 2
            r7.setId(r6)
            boolean r6 = com.huawei.android.hicloud.cloudbackup.process.CBAccess.inRestoreTask()
            if (r6 == 0) goto L4c
            goto L4d
        L3d:
            boolean r6 = r6.mo72036P()
            if (r6 != 0) goto L49
            r6 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            goto L4d
        L49:
            if (r1 == 0) goto L4c
            goto L4d
        L4c:
            r3 = 0
        L4d:
            if (r3 == 0) goto L56
            int r6 = r3.intValue()
            r7.setState(r6)
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: om.AbstractC11971k.m72069x(com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState):void");
    }

    /* renamed from: y */
    public final void m72070y(CloudBackupState cloudBackupState) {
        long startTime = cloudBackupState.getStartTime();
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        int cloudBackupIncompleteInterval = (hiCloudSysParamMapM60757p == null || hiCloudSysParamMapM60757p.getCloudBackupIncompleteInterval() <= 0) ? 14 : hiCloudSysParamMapM60757p.getCloudBackupIncompleteInterval();
        long j10 = cloudBackupIncompleteInterval * 86400000;
        C11839m.m70686d(mo72029I(), "processBackupStateEnd startTime: " + startTime + " ,cloudBackupIncompleteInterval: " + cloudBackupIncompleteInterval);
        if (startTime <= 0 || System.currentTimeMillis() - startTime <= j10) {
            return;
        }
        cloudBackupState.setFlag(16);
    }

    /* renamed from: z */
    public final void m72071z(boolean z10) {
        if (!z10 || System.currentTimeMillis() - this.f55729h <= RippleView.SINGLE_RIPPLE_TIME) {
            return;
        }
        this.f55729h = System.currentTimeMillis();
        if (this.f55730i) {
            ICBBroadcastManager.sendCloudBackupStateBroadcast(1, "", false);
        }
    }
}
