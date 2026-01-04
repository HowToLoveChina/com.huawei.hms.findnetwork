package com.huawei.android.hicloud.task.simple;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.android.hicloud.cloudbackup.bean.AppBackupSwitchListApp;
import com.huawei.android.hicloud.cloudbackup.bean.AppBackupSwitchRecommendConfig;
import com.huawei.android.hicloud.cloudbackup.process.task.QueryOmAppBackupScopeTask;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupAppEstimateUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.network.embedded.C5863b6;
import dj.C9158a;
import fk.C9721b;
import gp.C10028c;
import hu.C10343b;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p336he.C10155f;
import p422k9.C11019b;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p617rl.C12519c;
import p617rl.C12526j;
import p664u0.C13108a;
import p703v8.C13367d;
import p703v8.C13368e;
import p815ym.AbstractC14026a;
import p848zl.C14333b;
import p850zo.InterfaceC14351b;
import tl.C13026e;

/* renamed from: com.huawei.android.hicloud.task.simple.a1 */
/* loaded from: classes3.dex */
public class C3011a1 extends AbstractC12367d {

    /* renamed from: a */
    public List<String> f13132a;

    /* renamed from: b */
    public final boolean f13133b;

    /* renamed from: c */
    public final Consumer<List<AppBackupSwitchListApp>> f13134c;

    /* renamed from: g */
    public a f13138g;

    /* renamed from: h */
    public Boolean f13139h;

    /* renamed from: d */
    public long f13135d = 0;

    /* renamed from: e */
    public final C13026e f13136e = new C13026e();

    /* renamed from: f */
    public final Context f13137f = C0213f.m1377a();

    /* renamed from: i */
    public List<String> f13140i = new ArrayList();

    /* renamed from: com.huawei.android.hicloud.task.simple.a1$a */
    public static class a extends BroadcastReceiver {

        /* renamed from: a */
        public Consumer<QuotaSpaceInfo> f13141a;

        public a(Consumer<QuotaSpaceInfo> consumer) {
            this.f13141a = consumer;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C11839m.m70689w("GuideBackupSwitchTask", "intent null");
                return;
            }
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            if ("com.huawei.hicloud.QUERY_QUOTA_INFO_FINISHED".equals(hiCloudSafeIntent.getAction())) {
                C11839m.m70688i("GuideBackupSwitchTask", "query space info result=" + new C10343b(hiCloudSafeIntent.getExtras()).m63686h("result"));
                this.f13141a.accept(C13368e.m80184F().m80223L());
            }
        }
    }

    public C3011a1(boolean z10, Consumer<List<AppBackupSwitchListApp>> consumer) {
        this.f13134c = consumer;
        this.f13133b = z10;
    }

    /* renamed from: D */
    public static List<AppBackupSwitchListApp> m18131D(List<AppBackupSwitchListApp> list) {
        return list == null ? new ArrayList() : (List) list.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.task.simple.p0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C3011a1.m18145c0((AppBackupSwitchListApp) obj);
            }
        }).collect(Collectors.toList());
    }

    /* renamed from: G */
    public static long m18132G(AppBackupSwitchListApp appBackupSwitchListApp) {
        long jM18133H;
        long jM18133H2;
        if (appBackupSwitchListApp.getPackageName().equals("soundrecorder")) {
            jM18133H = m18133H("soundrecorder");
            jM18133H2 = m18133H("callRecorder");
        } else {
            if (!appBackupSwitchListApp.getPackageName().equals(NavigationUtils.SMS_SCHEMA_PREF)) {
                return m18133H(appBackupSwitchListApp.getPackageName());
            }
            jM18133H = m18133H(NavigationUtils.SMS_SCHEMA_PREF);
            jM18133H2 = m18133H("chatSms");
        }
        return jM18133H + jM18133H2;
    }

    /* renamed from: H */
    public static long m18133H(String str) {
        BackupOptionItem backupOptionItemQueryMergeTwinItem = TransferedUtil.queryMergeTwinItem(str, false);
        if (backupOptionItemQueryMergeTwinItem == null || backupOptionItemQueryMergeTwinItem.getTotalIncrease() <= 0) {
            return 0L;
        }
        return backupOptionItemQueryMergeTwinItem.getTotalIncrease();
    }

    /* renamed from: Q */
    public static /* synthetic */ void m18134Q(Consumer consumer) {
        consumer.accept(new ArrayList());
    }

    /* renamed from: R */
    public static /* synthetic */ void m18135R(Consumer consumer) {
        consumer.accept(new ArrayList());
    }

    /* renamed from: S */
    public static /* synthetic */ void m18136S(Consumer consumer) {
        consumer.accept(new ArrayList());
    }

    /* renamed from: T */
    public static /* synthetic */ void m18137T(Consumer consumer) {
        consumer.accept(new ArrayList());
    }

    /* renamed from: V */
    public static /* synthetic */ void m18138V(Consumer consumer) {
        consumer.accept(new ArrayList());
    }

    /* renamed from: X */
    public static /* synthetic */ void m18139X(Consumer consumer) {
        consumer.accept(new ArrayList());
    }

    /* renamed from: Y */
    public static /* synthetic */ void m18140Y(Consumer consumer) {
        consumer.accept(new ArrayList());
    }

    /* renamed from: Z */
    public static /* synthetic */ void m18141Z(Consumer consumer) {
        consumer.accept(new ArrayList());
    }

    /* renamed from: a0 */
    public static /* synthetic */ void m18142a0(Consumer consumer) {
        consumer.accept(new ArrayList());
    }

    /* renamed from: b0 */
    public static /* synthetic */ void m18143b0(Consumer consumer) {
        consumer.accept(new ArrayList());
    }

    /* renamed from: c0 */
    public static /* synthetic */ boolean m18145c0(AppBackupSwitchListApp appBackupSwitchListApp) {
        if (appBackupSwitchListApp.getType() == 1) {
            return ("callRecorder".equals(appBackupSwitchListApp.getPackageName()) || "chatSms".equals(appBackupSwitchListApp.getPackageName())) ? false : true;
        }
        return true;
    }

    /* renamed from: d0 */
    public static /* synthetic */ void m18147d0(Consumer consumer) {
        consumer.accept(new ArrayList());
    }

    /* renamed from: e0 */
    public static /* synthetic */ void m18149e0(Consumer consumer) {
        consumer.accept(new ArrayList());
    }

    /* renamed from: j0 */
    private void m18154j0() {
        if (this.f13138g != null) {
            C13108a.m78878b(this.f13137f).m78883f(this.f13138g);
            this.f13138g = null;
        }
    }

    /* renamed from: A */
    public boolean m18167A(QuotaSpaceInfo quotaSpaceInfo, AppBackupSwitchRecommendConfig appBackupSwitchRecommendConfig, long j10) {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (appBackupSwitchRecommendConfig.getCacheExpires() * C5863b6.g.f26453g <= System.currentTimeMillis() - interfaceC9282a.mo58419d1(this.f13137f)) {
            C11839m.m70689w("GuideBackupSwitchTask", "checkEstimatedPhotoSize LocalDataDailyInterval has expired!");
            return false;
        }
        long jMo58405Y0 = interfaceC9282a.mo58405Y0(this.f13137f);
        if (jMo58405Y0 < 0) {
            C11839m.m70689w("GuideBackupSwitchTask", "checkEstimatedPhotoSize lastDailySize no exit!");
            return false;
        }
        long j11 = jMo58405Y0 - j10;
        C11839m.m70686d("GuideBackupSwitchTask", "checkEstimatedPhotoSize lastDailySize:" + jMo58405Y0 + ",galleryUsedSize:" + j10 + ",estimatedSizeAdd:" + j11);
        if (j11 < 0) {
            j11 = 0;
        }
        this.f13135d += j11;
        C11839m.m70686d("GuideBackupSwitchTask", "checkEstimatedPhotoSize spaceInfoAvailable:" + quotaSpaceInfo.getAvailable() + "estimatedSize:" + this.f13135d + ",spaceInfoTotal * endThreshold:" + (quotaSpaceInfo.getTotal() * appBackupSwitchRecommendConfig.getEndCalcThreshold()));
        if (quotaSpaceInfo.getAvailable() - this.f13135d > quotaSpaceInfo.getTotal() * appBackupSwitchRecommendConfig.getEndCalcThreshold()) {
            return true;
        }
        C11839m.m70689w("GuideBackupSwitchTask", "checkEstimatedPhotoSize: available-estimatedSize < TotalSpace * endCalcThreshold,not need show break!");
        this.f13135d = 0L;
        return false;
    }

    /* renamed from: B */
    public final void m18168B(AppBackupSwitchRecommendConfig appBackupSwitchRecommendConfig, Consumer<QuotaSpaceInfo> consumer) {
        QuotaSpaceInfo quotaSpaceInfoM80223L = C13368e.m80184F().m80223L();
        if (quotaSpaceInfoM80223L != null) {
            consumer.accept(quotaSpaceInfoM80223L);
            return;
        }
        long jM80179c = C13367d.m80179c();
        C11839m.m70686d("GuideBackupSwitchTask", "cache space time:" + jM80179c);
        boolean z10 = System.currentTimeMillis() - jM80179c < ((long) appBackupSwitchRecommendConfig.getQuotaInfoCacheExpires()) * C5863b6.g.f26453g;
        QuotaSpaceInfo quotaSpaceInfoM80178b = C13367d.m80178b();
        C11839m.m70686d("GuideBackupSwitchTask", "cache available:" + z10);
        if (z10 && quotaSpaceInfoM80178b != null) {
            consumer.accept(quotaSpaceInfoM80178b);
            C11839m.m70688i("GuideBackupSwitchTask", "use cache space info");
        } else {
            C11839m.m70688i("GuideBackupSwitchTask", "query space info");
            m18174K(consumer);
            C13368e.m80184F().m80250o0();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0216 A[SYNTHETIC] */
    /* renamed from: C */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.huawei.android.hicloud.cloudbackup.bean.AppBackupSwitchListApp> m18169C(java.util.List<com.huawei.android.hicloud.cloudbackup.bean.AppBackupSwitchListApp> r19, com.huawei.hicloud.base.bean.QuotaSpaceInfo r20, com.huawei.android.hicloud.cloudbackup.bean.AppBackupSwitchRecommendConfig r21, long r22) throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 623
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.task.simple.C3011a1.m18169C(java.util.List, com.huawei.hicloud.base.bean.QuotaSpaceInfo, com.huawei.android.hicloud.cloudbackup.bean.AppBackupSwitchRecommendConfig, long):java.util.List");
    }

    /* renamed from: E */
    public final void m18170E(final QuotaSpaceInfo quotaSpaceInfo, final C12526j c12526j, InterfaceC9282a interfaceC9282a) {
        if (quotaSpaceInfo == null || c12526j == null || interfaceC9282a == null) {
            C11839m.m70687e("GuideBackupSwitchTask", "spaceInfo or operator or cloudAlbumRouter is null");
            Optional.ofNullable(this.f13134c).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.task.simple.i0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C3011a1.m18147d0((Consumer) obj);
                }
            });
            return;
        }
        final List<AppBackupSwitchListApp> listM18131D = m18131D(c12526j.m75417s());
        C11839m.m70688i("GuideBackupSwitchTask", "appBackupSwitchListApps size = " + listM18131D.size());
        if (BackupAppEstimateUtil.isShow() && m18173J(listM18131D) && !BackupAppEstimateUtil.isValid()) {
            C11839m.m70688i("GuideBackupSwitchTask", "backup estimate not satisfied");
            Optional.ofNullable(this.f13134c).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.task.simple.j0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C3011a1.m18149e0((Consumer) obj);
                }
            });
            return;
        }
        this.f13140i = m18171F();
        if (!interfaceC9282a.mo58417d(this.f13137f)) {
            interfaceC9282a.mo58438k0(this.f13137f, new InterfaceC14351b() { // from class: com.huawei.android.hicloud.task.simple.l0
                @Override // p850zo.InterfaceC14351b
                public final void onResult(Bundle bundle) {
                    this.f13324a.m18184h0(listM18131D, quotaSpaceInfo, c12526j, bundle);
                }
            });
        } else {
            C11839m.m70688i("GuideBackupSwitchTask", "cloudAlbum is open, not need query galleryUsedSize");
            Optional.ofNullable(this.f13134c).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.task.simple.k0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f13310a.m18182f0(listM18131D, quotaSpaceInfo, c12526j, (Consumer) obj);
                }
            });
        }
    }

    /* renamed from: F */
    public final List<String> m18171F() {
        return (List) NotifyUtil.getShownSyncServiceItems(this.f13137f).stream().map(new Function() { // from class: com.huawei.android.hicloud.task.simple.r0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((SyncConfigService) obj).getId();
            }
        }).collect(Collectors.toList());
    }

    /* renamed from: I */
    public final List<String> m18172I() {
        if (!AbstractC14026a.m84159a(this.f13132a)) {
            return this.f13132a;
        }
        try {
            this.f13132a = new C12519c().m75297h(1);
        } catch (C9721b e10) {
            C11839m.m70689w("GuideBackupSwitchTask", "get virtuals error: " + e10.getMessage());
        }
        if (AbstractC14026a.m84159a(this.f13132a)) {
            this.f13132a = new ArrayList();
        }
        return this.f13132a;
    }

    /* renamed from: J */
    public final boolean m18173J(List<AppBackupSwitchListApp> list) {
        if (list == null || list.isEmpty()) {
            C11839m.m70689w("GuideBackupSwitchTask", "has third app from om: switch App list is empty");
            return false;
        }
        C11839m.m70688i("GuideBackupSwitchTask", "third app size from om:" + ((List) list.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.task.simple.o0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f13344a.m18185i0((AppBackupSwitchListApp) obj);
            }
        }).collect(Collectors.toList())).size());
        return !r2.isEmpty();
    }

    /* renamed from: K */
    public final void m18174K(Consumer<QuotaSpaceInfo> consumer) {
        if (this.f13138g == null) {
            this.f13138g = new a(consumer);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.hicloud.QUERY_QUOTA_INFO_FINISHED");
            C13108a.m78878b(this.f13137f).m78880c(this.f13138g, intentFilter);
        }
    }

    /* renamed from: L */
    public final boolean m18175L(String str) {
        return !m18177N(str);
    }

    /* renamed from: M */
    public boolean m18176M(AppBackupSwitchListApp appBackupSwitchListApp) {
        return appBackupSwitchListApp.getType() == 0 ? m18179P(appBackupSwitchListApp.getPackageName()) : (m18175L(appBackupSwitchListApp.getPackageName()) && m18178O() && C0209d.m1184K0(this.f13137f, appBackupSwitchListApp.getPackageName())) || m18177N(appBackupSwitchListApp.getPackageName());
    }

    /* renamed from: N */
    public final boolean m18177N(String str) {
        List<String> listM18172I = m18172I();
        if (AbstractC14026a.m84159a(listM18172I) || !listM18172I.contains(str)) {
            return C14333b.m85476k().contains(str);
        }
        return true;
    }

    /* renamed from: O */
    public final boolean m18178O() {
        Boolean bool = this.f13139h;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean boolValueOf = Boolean.valueOf(BackupAppEstimateUtil.isSwitch3rdApp());
        this.f13139h = boolValueOf;
        return boolValueOf.booleanValue();
    }

    /* renamed from: P */
    public final boolean m18179P(String str) {
        str.hashCode();
        switch (str) {
            case "addressbook":
                return C10155f.m63302z() && C11019b.m66371t().m66401U("funcfg_contacts");
            case "gallery":
                return C10028c.m62183d0(this.f13137f).m62395t1("funcfg_gallery") && !C0209d.m1293p1();
            case "calendar":
                return C10155f.m63297u() && C11019b.m66371t().m66401U("funcfg_calendar");
            case "wlan":
                return C10028c.m62183d0(this.f13137f).m62395t1("funcfg_wlan");
            case "browser":
                return C10155f.m63296t(this.f13137f) && !C0209d.m1293p1();
            case "notepad":
                return C10155f.m63252E() && C11019b.m66371t().m66401U("funcfg_notes") && C0209d.m1215U1(this.f13137f);
            default:
                return this.f13140i.contains(str);
        }
    }

    /* renamed from: U */
    public final /* synthetic */ void m18180U(C12526j c12526j, QuotaSpaceInfo quotaSpaceInfo) {
        m18187z(quotaSpaceInfo, c12526j);
        m18154j0();
    }

    /* renamed from: W */
    public final /* synthetic */ boolean m18181W(QuotaSpaceInfo quotaSpaceInfo, C12526j c12526j, InterfaceC9282a interfaceC9282a, Message message) {
        if (message == null) {
            C11839m.m70687e("GuideBackupSwitchTask", "query code fail");
            Optional.ofNullable(this.f13134c).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.task.simple.g0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C3011a1.m18143b0((Consumer) obj);
                }
            });
            return false;
        }
        C11839m.m70688i("GuideBackupSwitchTask", "query code msg = " + message.what);
        if (message.what == 7038) {
            m18170E(quotaSpaceInfo, c12526j, interfaceC9282a);
        } else {
            Optional.ofNullable(this.f13134c).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.task.simple.h0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C3011a1.m18138V((Consumer) obj);
                }
            });
        }
        return false;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C11839m.m70688i("GuideBackupSwitchTask", "GuideBackupSwitchTask is run");
        if (!C0209d.m1166E1()) {
            C11839m.m70688i("GuideBackupSwitchTask", "not owner user, do not show suggest dialog");
            Optional.ofNullable(this.f13134c).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.task.simple.f0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C3011a1.m18134Q((Consumer) obj);
                }
            });
            return;
        }
        if (!C10028c.m62182c0().m62413x()) {
            C11839m.m70688i("GuideBackupSwitchTask", "CloudSpaceFunctionItemSwitch not enable, do not show suggest dialog");
            Optional.ofNullable(this.f13134c).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.task.simple.q0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C3011a1.m18135R((Consumer) obj);
                }
            });
        } else {
            if (C12515a.m75110o().m75158X0(QueryOmAppBackupScopeTask.class.getName())) {
                C11839m.m70688i("GuideBackupSwitchTask", "QueryOmAppBackupScopeTask is not completed, do not show suggest dialog");
                Optional.ofNullable(this.f13134c).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.task.simple.s0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        C3011a1.m18136S((Consumer) obj);
                    }
                });
                return;
            }
            final C12526j c12526j = new C12526j();
            if (c12526j.m75390f1(4)) {
                m18168B(c12526j.m75393h(), new Consumer() { // from class: com.huawei.android.hicloud.task.simple.u0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f13384a.m18180U(c12526j, (QuotaSpaceInfo) obj);
                    }
                });
            } else {
                C11839m.m70688i("GuideBackupSwitchTask", "om config not enable, do not show suggest dialog");
                Optional.ofNullable(this.f13134c).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.task.simple.t0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        C3011a1.m18137T((Consumer) obj);
                    }
                });
            }
        }
    }

    /* renamed from: f0 */
    public final /* synthetic */ void m18182f0(List list, QuotaSpaceInfo quotaSpaceInfo, C12526j c12526j, Consumer consumer) {
        consumer.accept(m18169C(list, quotaSpaceInfo, c12526j.m75393h(), 0L));
    }

    /* renamed from: g0 */
    public final /* synthetic */ void m18183g0(List list, QuotaSpaceInfo quotaSpaceInfo, C12526j c12526j, long j10, Consumer consumer) {
        consumer.accept(m18169C(list, quotaSpaceInfo, c12526j.m75393h(), j10));
    }

    /* renamed from: h0 */
    public final /* synthetic */ void m18184h0(final List list, final QuotaSpaceInfo quotaSpaceInfo, final C12526j c12526j, Bundle bundle) {
        final long j10 = bundle == null ? 0L : bundle.getLong("photoTotalSize");
        C11839m.m70688i("GuideBackupSwitchTask", "cloudAlbumRouter getUsedSize galleryUsedSize = " + j10);
        Optional.ofNullable(this.f13134c).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.task.simple.n0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f13336a.m18183g0(list, quotaSpaceInfo, c12526j, j10, (Consumer) obj);
            }
        });
    }

    /* renamed from: i0 */
    public final /* synthetic */ boolean m18185i0(AppBackupSwitchListApp appBackupSwitchListApp) {
        return appBackupSwitchListApp.getType() == 1 && m18175L(appBackupSwitchListApp.getPackageName());
    }

    /* renamed from: y */
    public boolean m18186y(AppBackupSwitchListApp appBackupSwitchListApp) {
        if (C4633d0.m28404a(appBackupSwitchListApp.getPackageName())) {
            C11839m.m70689w("GuideBackupSwitchTask", "package name is null, not show guide switch dialog");
            return true;
        }
        if (appBackupSwitchListApp.getType() == 0) {
            return StringUtil.equals(appBackupSwitchListApp.getPackageName(), HNConstants.DataType.MEDIA) ? ((InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class)).mo58417d(this.f13137f) : C10028c.m62182c0().m62388s(appBackupSwitchListApp.getPackageName());
        }
        BackupOptionItem backupOptionItemM78401y = this.f13136e.m78401y(appBackupSwitchListApp.getPackageName());
        return backupOptionItemM78401y != null && backupOptionItemM78401y.getBackupSwitch();
    }

    /* renamed from: z */
    public final void m18187z(final QuotaSpaceInfo quotaSpaceInfo, final C12526j c12526j) {
        AppBackupSwitchRecommendConfig appBackupSwitchRecommendConfigM75393h = c12526j.m75393h();
        if (quotaSpaceInfo == null || quotaSpaceInfo.getAvailable() <= quotaSpaceInfo.getTotal() * appBackupSwitchRecommendConfigM75393h.getStartCheckThreshold()) {
            C11839m.m70688i("GuideBackupSwitchTask", "available space under check threshold");
            Optional.ofNullable(this.f13134c).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.task.simple.v0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C3011a1.m18139X((Consumer) obj);
                }
            });
            return;
        }
        if (C0212e0.m1357g(this.f13137f, "switch_suggest_dialog_sp", "dialog_switch_suggest_num_new", 0) >= appBackupSwitchRecommendConfigM75393h.getRecommendRetryTimes()) {
            C11839m.m70688i("GuideBackupSwitchTask", "notify number limited");
            Optional.ofNullable(this.f13134c).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.task.simple.w0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C3011a1.m18140Y((Consumer) obj);
                }
            });
            return;
        }
        long jM1359i = C0212e0.m1359i(this.f13137f, "switch_suggest_dialog_sp", "guide_backup_switch_notify_time", 0L);
        float recommendNotifyInterval = (r5 + 1) * appBackupSwitchRecommendConfigM75393h.getRecommendNotifyInterval() * appBackupSwitchRecommendConfigM75393h.getRecommendRetryRate();
        C11839m.m70688i("GuideBackupSwitchTask", "current recommend time:" + recommendNotifyInterval);
        if (recommendNotifyInterval * 8.64E7f > System.currentTimeMillis() - jM1359i) {
            C11839m.m70688i("GuideBackupSwitchTask", "current time less than recommend interval");
            Optional.ofNullable(this.f13134c).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.task.simple.x0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C3011a1.m18141Z((Consumer) obj);
                }
            });
            return;
        }
        final InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (!interfaceC9282a.mo58417d(this.f13137f)) {
            long jMo58419d1 = interfaceC9282a.mo58419d1(this.f13137f);
            long cacheExpires = c12526j.m75393h().getCacheExpires();
            boolean z10 = C5863b6.g.f26453g * cacheExpires > System.currentTimeMillis() - jMo58419d1;
            C11839m.m70688i("GuideBackupSwitchTask", "cacheExpires:" + cacheExpires + ", last LocalDataDailyTime : " + jMo58419d1 + " , isEnable : " + z10);
            if (!z10) {
                Optional.ofNullable(this.f13134c).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.task.simple.y0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        C3011a1.m18142a0((Consumer) obj);
                    }
                });
                return;
            }
        }
        if (!this.f13133b) {
            m18170E(quotaSpaceInfo, c12526j, interfaceC9282a);
            return;
        }
        C11060c c11060c = new C11060c();
        c11060c.m66664t("06008");
        c11060c.m66643I(C11058a.m66627b("06008"));
        C9158a.m57503F().m57515M(new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.huawei.android.hicloud.task.simple.z0
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f13415a.m18181W(quotaSpaceInfo, c12526j, interfaceC9282a, message);
            }
        }), 3, c11060c, false, false, "GuideBackupSwitchTask");
    }
}
