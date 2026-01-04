package hm;

import android.text.TextUtils;
import cm.AbstractC1455a;
import cm.C1460f;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppList;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Asset;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.BakRefresh;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Lock;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.LockCreate;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.LockKeepResult;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.Recover;
import com.huawei.uikit.hwdatepicker.utils.HwConstants;
import fk.C9721b;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import p514o9.C11839m;
import p814yl.C14000c0;

/* renamed from: hm.n0 */
/* loaded from: classes6.dex */
public class C10309n0 {

    /* renamed from: a */
    public final String f49943a;

    @FunctionalInterface
    /* renamed from: hm.n0$a */
    public interface a<T, R> {
        R apply(T t10) throws C9721b;
    }

    public C10309n0(String str) {
        this.f49943a = str;
    }

    /* renamed from: A */
    public static /* synthetic */ Boolean m63466A(C1460f c1460f, AtomicReference atomicReference, C9721b c9721b) throws C9721b {
        return Boolean.valueOf(m63470H(c1460f, atomicReference, c9721b));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Recover$Revisions$Get] */
    /* renamed from: B */
    public static /* synthetic */ CloudBackupV3Request m63467B(String str, AtomicReference atomicReference, String str2, boolean z10, String str3, String str4, String str5, String str6, String str7, List list, String str8, boolean z11, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Recover.Revisions.Get get = cloudBackupV3Server.recover().asset().revisions().get();
        Recover.Revisions.Get lockId = get.setFields(str).setLockId((String) atomicReference.get());
        if (str2 == null || str2.isEmpty()) {
            str2 = "origin";
        }
        lockId.setCdnType(str2);
        if (z10) {
            get.setCloudPath(str3);
        } else {
            get.setKindId(str4).setRecordId(str5).setAssetId(str6).setVersionId(str7);
        }
        if (list != null && !list.isEmpty()) {
            get.setObjectIds(list);
        }
        if (!TextUtils.isEmpty(str8)) {
            get.setHeader("x-hw-bakId", (Object) str8);
        }
        get.setHeader("x-hw-accept-encoding", "sparse");
        if (z11) {
            get.setAutoFix(true);
        }
        return get;
    }

    /* renamed from: D */
    public static /* synthetic */ Boolean m63468D(AbstractC1455a abstractC1455a, AtomicReference atomicReference, C9721b c9721b) throws C9721b {
        return Boolean.valueOf(m63470H(abstractC1455a, atomicReference, c9721b));
    }

    /* renamed from: G */
    public static <T> T m63469G(Callable<T> callable, a<C9721b, Boolean> aVar) throws C9721b {
        int i10 = 0;
        while (true) {
            try {
                return callable.call();
            } catch (Exception e10) {
                if (!(e10 instanceof C9721b)) {
                    throw new C9721b(HwConstants.LUNAR_YEAR_MIN, e10.getMessage());
                }
                C9721b c9721b = (C9721b) e10;
                if (c9721b.m60659c() == 3923 && i10 < 1) {
                    C11839m.m70689w("CloudRestoreV3Service", "retry lock refresh: " + i10);
                    if (!aVar.apply(c9721b).booleanValue()) {
                        break;
                    }
                    i10++;
                } else {
                    break;
                }
                throw c9721b;
            }
        }
    }

    /* renamed from: H */
    public static boolean m63470H(AbstractC1455a abstractC1455a, AtomicReference<String> atomicReference, C9721b c9721b) throws C9721b {
        if (abstractC1455a == null) {
            return false;
        }
        return abstractC1455a.mo8332g(c9721b, atomicReference.get());
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Recover$Apps$List] */
    /* renamed from: r */
    public static /* synthetic */ CloudBackupV3Request m63484r(String str, String str2, String str3, AtomicReference atomicReference, String str4, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Recover.Apps.List list = cloudBackupV3Server.recover().apps().list();
        list.setFields(str).setPageSize(100).setBackupDeviceId(str2).setBakId(str3).setLockId((String) atomicReference.get()).setHeader("x-hw-masking-apps-version", (Object) "V1").setHeader("x-hw-appduplicator", (Object) "1");
        if (!TextUtils.isEmpty(str4)) {
            list.setCursor(str4);
        }
        return list;
    }

    /* renamed from: t */
    public static /* synthetic */ Boolean m63485t(C1460f c1460f, AtomicReference atomicReference, C9721b c9721b) throws C9721b {
        return Boolean.valueOf(m63470H(c1460f, atomicReference, c9721b));
    }

    /* renamed from: v */
    public static /* synthetic */ Boolean m63486v(boolean z10, C1460f c1460f, AtomicReference atomicReference, C9721b c9721b) throws C9721b {
        return Boolean.valueOf(z10 && m63470H(c1460f, atomicReference, c9721b));
    }

    /* renamed from: w */
    public static /* synthetic */ CloudBackupV3Request m63487w(LockCreate lockCreate, String str, String str2, AtomicReference atomicReference, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Recover.Lock.KeepLock keepLock = cloudBackupV3Server.recover().lock().keepLock(lockCreate);
        keepLock.setBackupDeviceId(str).setBakId(str2).setLockId((String) atomicReference.get());
        return keepLock;
    }

    /* renamed from: x */
    public static /* synthetic */ CloudBackupV3Request m63488x(String str, String str2, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Recover.Lock.Get get = cloudBackupV3Server.recover().lock().get();
        get.setBackupDeviceId(str).setBakId(str2);
        return get;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.huawei.hicloud.cloudbackup.v3.server.request.Recover$Device$Bak$Refresh] */
    /* renamed from: y */
    public static /* synthetic */ CloudBackupV3Request m63489y(BakRefresh bakRefresh, String str, String str2, AtomicReference atomicReference, String str3, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Recover.Device.Bak.Refresh refresh = cloudBackupV3Server.recover().device().bak().refresh(cloudBackupV3Server, bakRefresh);
        refresh.setFields(str).setBackupDeviceId(str2).setLockId((String) atomicReference.get()).setBakId(str3);
        return refresh;
    }

    /* renamed from: C */
    public final /* synthetic */ Asset m63490C(final AtomicReference atomicReference, AbstractC1455a abstractC1455a, final String str, final String str2, final boolean z10, final String str3, final String str4, final String str5, final String str6, final String str7, final List list, final String str8, final boolean z11, Runnable runnable, BiConsumer biConsumer) throws Exception {
        atomicReference.set(m63497p(abstractC1455a));
        return m63496o(new C14000c0<>(new C14000c0.a() { // from class: hm.b0
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C10309n0.m63467B(str, atomicReference, str2, z10, str3, str4, str5, str6, str7, list, str8, z11, cloudBackupV3Server);
            }
        }), runnable, biConsumer);
    }

    /* renamed from: E */
    public Lock m63491E(final String str, final String str2) throws C9721b {
        return (Lock) new C14000c0(new C14000c0.a() { // from class: hm.m0
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C10309n0.m63488x(str, str2, cloudBackupV3Server);
            }
        }).m84139b("Recover.Lock.get", this.f49943a);
    }

    /* renamed from: F */
    public void m63492F(final String str, final String str2, final C1460f c1460f, final BakRefresh bakRefresh) throws C9721b {
        final AtomicReference atomicReference = new AtomicReference();
        m63469G(new Callable() { // from class: hm.a0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f49766a.m63501z(atomicReference, c1460f, bakRefresh, str, str2);
            }
        }, new a() { // from class: hm.e0
            @Override // hm.C10309n0.a
            public final Object apply(Object obj) {
                return C10309n0.m63466A(c1460f, atomicReference, (C9721b) obj);
            }
        });
    }

    /* renamed from: I */
    public final C9721b m63493I(ErrorResp.Error error, C9721b c9721b) {
        List<ErrorResp.ErrorMsg> errorDetail;
        if (error == null || (errorDetail = error.getErrorDetail()) == null || errorDetail.isEmpty()) {
            return c9721b;
        }
        ErrorResp.ErrorMsg errorMsg = errorDetail.get(0);
        String errorCode = errorMsg.getErrorCode();
        int iIntValue = error.getCode().intValue();
        String description = error.getDescription();
        if (iIntValue == 400 && errorCode.endsWith(String.valueOf(4004)) && description.contains("lock not found")) {
            return new C9721b(3923, 4004, "lock not found");
        }
        if (iIntValue != 404 || !errorCode.endsWith(String.valueOf(4041))) {
            return c9721b;
        }
        return new C9721b(3922, 4041, "server source not exist." + errorMsg.getDescription());
    }

    /* renamed from: J */
    public Asset m63494J(final String str, final String str2, final boolean z10, final AbstractC1455a abstractC1455a, final String str3, final List<String> list, final String str4, final boolean z11, final String str5, final String str6, final String str7, final String str8, final Runnable runnable, final BiConsumer<String, String> biConsumer) throws C9721b {
        final AtomicReference atomicReference = new AtomicReference();
        return (Asset) m63469G(new Callable() { // from class: hm.i0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f49877a.m63490C(atomicReference, abstractC1455a, str3, str4, z10, str2, str5, str6, str7, str8, list, str, z11, runnable, biConsumer);
            }
        }, new a() { // from class: hm.j0
            @Override // hm.C10309n0.a
            public final Object apply(Object obj) {
                return C10309n0.m63468D(abstractC1455a, atomicReference, (C9721b) obj);
            }
        });
    }

    /* renamed from: n */
    public AppList m63495n(final String str, final String str2, final String str3, final String str4, final C1460f c1460f, final String str5) throws C9721b {
        final AtomicReference atomicReference = new AtomicReference();
        return (AppList) m63469G(new Callable() { // from class: hm.g0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f49851a.m63499s(atomicReference, c1460f, str, str3, str4, str2, str5);
            }
        }, new a() { // from class: hm.h0
            @Override // hm.C10309n0.a
            public final Object apply(Object obj) {
                return C10309n0.m63485t(c1460f, atomicReference, (C9721b) obj);
            }
        });
    }

    /* renamed from: o */
    public final Asset m63496o(C14000c0<Asset> c14000c0, Runnable runnable, BiConsumer<String, String> biConsumer) throws C9721b {
        try {
            Asset assetM84139b = c14000c0.m84139b("Recover.asset.revisions.get", this.f49943a);
            if (assetM84139b.getState().intValue() != 0) {
                throw new C9721b(3911, "state invalid", "Recover.asset.revisions.get");
            }
            if (assetM84139b.getResource() != null) {
                C10321z.m63502C0(assetM84139b, c14000c0);
                return assetM84139b;
            }
            runnable.run();
            throw new C9721b(3911, "resource invalid", "Recover.asset.revisions.get");
        } catch (C9721b e10) {
            C9721b c9721bM63493I = m63493I(c14000c0.m84140c(), e10);
            if (c9721bM63493I.m60659c() != 3922 || c9721bM63493I.m60663g() != 4041) {
                throw c9721bM63493I;
            }
            runnable.run();
            biConsumer.accept("102_404", "download error. " + c9721bM63493I);
            throw c9721bM63493I;
        }
    }

    /* renamed from: p */
    public final String m63497p(AbstractC1455a abstractC1455a) {
        if (abstractC1455a == null || abstractC1455a.mo8329d() == null) {
            return null;
        }
        return abstractC1455a.mo8329d().getLockId();
    }

    /* renamed from: q */
    public LockKeepResult m63498q(final boolean z10, final String str, final String str2, final C1460f c1460f) throws C9721b {
        final AtomicReference atomicReference = new AtomicReference();
        final ThreadLocal threadLocal = new ThreadLocal();
        m63469G(new Callable() { // from class: hm.k0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f49914a.m63500u(c1460f, atomicReference, str, str2, threadLocal);
            }
        }, new a() { // from class: hm.l0
            @Override // hm.C10309n0.a
            public final Object apply(Object obj) {
                return C10309n0.m63486v(z10, c1460f, atomicReference, (C9721b) obj);
            }
        });
        return (LockKeepResult) threadLocal.get();
    }

    /* renamed from: s */
    public final /* synthetic */ AppList m63499s(final AtomicReference atomicReference, C1460f c1460f, final String str, final String str2, final String str3, final String str4, String str5) throws Exception {
        atomicReference.set(m63497p(c1460f));
        C14000c0 c14000c0 = new C14000c0(new C14000c0.a() { // from class: hm.d0
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C10309n0.m63484r(str, str2, str3, atomicReference, str4, cloudBackupV3Server);
            }
        });
        try {
            return (AppList) c14000c0.m84139b("Recover.device.bak.apps.list", str5);
        } catch (C9721b e10) {
            throw m63493I(c14000c0.m84140c(), e10);
        }
    }

    /* renamed from: u */
    public final /* synthetic */ Void m63500u(C1460f c1460f, final AtomicReference atomicReference, final String str, final String str2, ThreadLocal threadLocal) throws Exception {
        C11839m.m70688i("CloudRestoreV3Service", "keep lock");
        Lock lockMo8329d = c1460f.mo8329d();
        if (lockMo8329d == null) {
            throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Recover.Lock.keepLock");
        }
        atomicReference.set(lockMo8329d.getLockId());
        final LockCreate lockCreate = new LockCreate();
        lockCreate.setKeepLockTime(new C4644l(System.currentTimeMillis()).toString());
        C14000c0 c14000c0 = new C14000c0(new C14000c0.a() { // from class: hm.c0
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C10309n0.m63487w(lockCreate, str, str2, atomicReference, cloudBackupV3Server);
            }
        });
        try {
            threadLocal.set((LockKeepResult) c14000c0.m84139b("Recover.Lock.keepLock", this.f49943a));
            return null;
        } catch (C9721b e10) {
            throw m63493I(c14000c0.m84140c(), e10);
        }
    }

    /* renamed from: z */
    public final /* synthetic */ Object m63501z(final AtomicReference atomicReference, C1460f c1460f, final BakRefresh bakRefresh, final String str, final String str2) throws Exception {
        atomicReference.set(m63497p(c1460f));
        final String str3 = "id,backupStatus";
        C14000c0 c14000c0 = new C14000c0(new C14000c0.a() { // from class: hm.f0
            @Override // p814yl.C14000c0.a
            /* renamed from: a */
            public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                return C10309n0.m63489y(bakRefresh, str3, str, atomicReference, str2, cloudBackupV3Server);
            }
        });
        try {
            c14000c0.m84139b("Recover.device.bak.refresh", this.f49943a);
            return null;
        } catch (C9721b e10) {
            throw m63493I(c14000c0.m84140c(), e10);
        }
    }
}
