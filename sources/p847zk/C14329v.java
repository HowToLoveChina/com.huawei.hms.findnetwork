package p847zk;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.restore.CloudRestoreClient;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.p088ui.activity.C3808n4;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.About;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.App;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppDetailsInfo;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppSizeInfo;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Attachment;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.basic.bean.CBSAllDevicesRsp;
import com.huawei.hicloud.request.basic.bean.CBSSyncRecordDeviceInfo;
import fk.C9721b;
import gl.C9961b;
import io.C10582a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mk.C11476b;
import p015ak.C0213f;
import p015ak.C0241z;
import p336he.C10153d;
import p429kk.C11058a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12540b1;
import p618rm.C12547e;
import p618rm.C12580p;
import p618rm.C12590s0;
import p618rm.C12591s1;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p814yl.C13998b0;
import p815ym.AbstractC14026a;
import p847zk.C14329v;
import p848zl.C14333b;
import p848zl.C14338g;
import p848zl.C14339h;
import pm.C12174b;
import pm.C12176c;
import pm.C12177d;
import tl.C13026e;

/* renamed from: zk.v */
/* loaded from: classes6.dex */
public class C14329v {

    /* renamed from: a */
    public final Map<String, C14318k> f63598a;

    /* renamed from: b */
    public C14318k f63599b;

    /* renamed from: c */
    public List<AppDetailsInfo> f63600c;

    /* renamed from: d */
    public AtomicInteger f63601d;

    /* renamed from: e */
    public String f63602e;

    /* renamed from: f */
    public String f63603f;

    /* renamed from: g */
    public boolean f63604g;

    /* renamed from: h */
    public C13998b0 f63605h;

    /* renamed from: i */
    public final List<String> f63606i;

    /* renamed from: j */
    public final Object f63607j;

    /* renamed from: k */
    public String f63608k;

    /* renamed from: l */
    public List<CBSSyncRecordDeviceInfo> f63609l;

    /* renamed from: zk.v$a */
    public class a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f63610a;

        /* renamed from: b */
        public final /* synthetic */ List f63611b;

        public a(String str, List list) {
            this.f63610a = str;
            this.f63611b = list;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                String strM66627b = C11058a.m66627b("02105");
                HashMap map = new HashMap();
                map.put(this.f63610a, Boolean.FALSE);
                C14329v.this.m85435q0();
                C14329v.this.f63605h.m84105I0(CloudBackupService.getInstance().getBackupDeviceId(), map, this.f63611b, strM66627b);
                if (C14329v.this.f63604g) {
                    CloudBackupService.getInstance().refreshSwitchStatusAsync(false);
                }
            } catch (C9721b e10) {
                C11839m.m70688i("CloudSpaceStateManager", "postAppsSwitch  error: " + e10);
            }
        }
    }

    /* renamed from: zk.v$b */
    public class b extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ List f63613a;

        /* renamed from: b */
        public final /* synthetic */ Consumer f63614b;

        public b(List list, Consumer consumer) {
            this.f63613a = list;
            this.f63614b = consumer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public static /* synthetic */ void m85440e(Consumer consumer) {
            consumer.accept(4037);
        }

        /* renamed from: f */
        public static /* synthetic */ void m85441f(int i10, Consumer consumer) {
            consumer.accept(Integer.valueOf(i10));
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            boolean z10;
            if (this.f63613a == null) {
                C11839m.m70689w("CloudSpaceStateManager", "deleteAppModule appIds null");
                return;
            }
            ArrayList arrayList = new ArrayList();
            final int iM60663g = 0;
            try {
                if (this.f63613a.isEmpty()) {
                    List<BackupOptionItem> listM78400x = new C13026e().m78400x("thirdAppData");
                    if (!listM78400x.isEmpty()) {
                        Iterator<BackupOptionItem> it = listM78400x.iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().getAppId());
                        }
                    }
                } else {
                    arrayList.addAll(this.f63613a);
                }
            } catch (C9721b e10) {
                C11839m.m70687e("CloudSpaceStateManager", "deleteAppModule error " + e10);
                iM60663g = e10.m60663g();
                z10 = false;
            }
            if (arrayList.isEmpty()) {
                C11839m.m70689w("CloudSpaceStateManager", "deleteAppModule appList isEmpty");
                return;
            }
            String strM66627b = C11058a.m66627b("02103");
            C14329v.this.m85430l0(arrayList);
            C14329v.this.m85435q0();
            if (!C14329v.this.f63605h.m84112M(arrayList, "backupDeviceIdV1V2", strM66627b)) {
                C11839m.m70688i("CloudSpaceStateManager", "deleteAppModule appId: " + arrayList.toString() + " notexist");
                Optional.ofNullable(this.f63614b).ifPresent(new Consumer() { // from class: zk.w
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        C14329v.b.m85440e((Consumer) obj);
                    }
                });
                return;
            }
            C14329v.this.m85400P0(arrayList);
            C14329v.this.f63605h.m84128Y("backupDeviceIdV1V2", arrayList, strM66627b);
            z10 = true;
            Optional.ofNullable(this.f63614b).ifPresent(new Consumer() { // from class: zk.x
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C14329v.b.m85441f(iM60663g, (Consumer) obj);
                }
            });
            LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            linkedHashMapM79499C.put("appId", arrayList.toString());
            linkedHashMapM79499C.put("isCurrent", String.valueOf(true));
            linkedHashMapM79499C.put("isSuccess", String.valueOf(z10));
            C13225d.m79490f1().m79591l0("backup_option_app_delete", linkedHashMapM79499C);
        }
    }

    /* renamed from: zk.v$c */
    public class c extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ List f63616a;

        /* renamed from: b */
        public final /* synthetic */ boolean f63617b;

        /* renamed from: c */
        public final /* synthetic */ String f63618c;

        /* renamed from: d */
        public final /* synthetic */ long f63619d;

        /* renamed from: e */
        public final /* synthetic */ int f63620e;

        /* renamed from: f */
        public final /* synthetic */ int f63621f;

        public c(List list, boolean z10, String str, long j10, int i10, int i11) {
            this.f63616a = list;
            this.f63617b = z10;
            this.f63618c = str;
            this.f63619d = j10;
            this.f63620e = i10;
            this.f63621f = i11;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                try {
                    String strM66627b = C11058a.m66627b("02103");
                    C14329v.this.m85430l0(this.f63616a);
                    C14329v.this.m85435q0();
                    C14329v.this.f63605h.m84128Y(C14329v.this.f63602e, this.f63616a, strM66627b);
                    if (this.f63617b) {
                        C14329v.this.m85381C0(C11476b.m68626h(this.f63618c), this.f63616a);
                    }
                    C14329v.this.m85413W(this.f63616a);
                    if (TextUtils.equals(this.f63618c, C13452e.m80781L().m80950o()) && !C12591s1.m75931a().m75941k()) {
                        CloudBackupService.getInstance().deleteLocalRecordCache();
                    }
                    C14329v c14329v = C14329v.this;
                    c14329v.m85398O0(this.f63616a, this.f63617b, true, c14329v.f63604g, this.f63619d, this.f63620e, this.f63621f);
                } catch (C9721b e10) {
                    C11839m.m70688i("CloudSpaceStateManager", "deleteAppModule e " + e10);
                    C14329v.this.m85418Y0(this.f63616a, false);
                    Message message = new Message();
                    message.what = 33042;
                    message.arg1 = 1;
                    if (String.valueOf(e10.m60663g()).endsWith(String.valueOf(4291))) {
                        message.obj = 1;
                    } else if (C14339h.m85516o().contains(Integer.valueOf(e10.m60659c())) || C14339h.m85514m().contains(Integer.valueOf(e10.m60659c()))) {
                        message.obj = 0;
                    } else {
                        message.obj = 2;
                    }
                    CBCallBack.getInstance().sendMessage(message);
                    C14329v c14329v2 = C14329v.this;
                    c14329v2.m85398O0(this.f63616a, this.f63617b, false, c14329v2.f63604g, this.f63619d, this.f63620e, this.f63621f);
                } catch (Exception e11) {
                    C11839m.m70688i("CloudSpaceStateManager", "deleteAppModule Exception " + e11);
                    C14329v.this.m85418Y0(this.f63616a, false);
                    Message message2 = new Message();
                    message2.what = 33042;
                    message2.arg1 = 1;
                    message2.obj = 2;
                    CBCallBack.getInstance().sendMessage(message2);
                    C14329v c14329v22 = C14329v.this;
                    c14329v22.m85398O0(this.f63616a, this.f63617b, false, c14329v22.f63604g, this.f63619d, this.f63620e, this.f63621f);
                }
            } catch (Throwable th2) {
                C14329v c14329v3 = C14329v.this;
                c14329v3.m85398O0(this.f63616a, this.f63617b, false, c14329v3.f63604g, this.f63619d, this.f63620e, this.f63621f);
                throw th2;
            }
        }
    }

    /* renamed from: zk.v$d */
    public class d extends AbstractC12367d {

        /* renamed from: a */
        public final List<String> f63623a;

        /* renamed from: b */
        public final String f63624b;

        /* renamed from: c */
        public final CountDownLatch f63625c;

        public d(List<String> list, String str, CountDownLatch countDownLatch) {
            this.f63623a = list;
            this.f63624b = str;
            this.f63625c = countDownLatch;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            List<AppSizeInfo> listM84116O;
            String strM66627b = C11058a.m66627b("02103");
            ArrayList arrayList = new ArrayList();
            Integer num = null;
            try {
                try {
                    try {
                        C14329v.this.m85435q0();
                        listM84116O = C14329v.this.f63605h.m84116O(this.f63623a, this.f63624b, strM66627b);
                    } catch (C9721b e10) {
                        C11839m.m70687e("AppSizeTask", e10.getMessage());
                        Integer num2 = 0;
                        if (e10.m60659c() == 3911 && e10.m60663g() == 5009) {
                            num2 = 5009;
                        }
                        C14329v.this.f63601d.addAndGet(-this.f63623a.size());
                        C14329v.this.m85414W0(this.f63623a, num2.intValue());
                    }
                } catch (Exception e11) {
                    Integer.valueOf(0);
                    C11839m.m70687e("AppSizeTask", e11.getMessage());
                    C14329v.this.f63601d.addAndGet(-this.f63623a.size());
                    C14329v.this.m85414W0(this.f63623a, 0);
                }
                if (!TextUtils.equals(C14329v.this.f63602e, this.f63624b)) {
                    C11839m.m70688i("AppSizeTask", "AppSizeTask : request backupDeviceId not same");
                    C14329v.this.f63601d.addAndGet(-this.f63623a.size());
                    C14329v.this.m85416X0(listM84116O, this.f63624b, strM66627b);
                    this.f63625c.countDown();
                    return;
                }
                C11839m.m70688i("AppSizeTask", "appSizeInfoList size: " + listM84116O.size());
                C14329v.this.m85403R(this.f63623a, listM84116O);
                C14329v.this.f63601d.addAndGet(-this.f63623a.size());
                C14329v.this.m85416X0(listM84116O, this.f63624b, strM66627b);
                this.f63625c.countDown();
            } catch (Throwable th2) {
                C14329v.this.f63601d.addAndGet(-this.f63623a.size());
                if (0 == 0) {
                    C14329v.this.m85416X0(arrayList, this.f63624b, strM66627b);
                } else {
                    C14329v.this.m85414W0(this.f63623a, num.intValue());
                }
                this.f63625c.countDown();
                throw th2;
            }
        }
    }

    /* renamed from: zk.v$e */
    public class e extends AbstractC12367d {

        /* renamed from: a */
        public final String f63627a;

        /* renamed from: b */
        public final String f63628b;

        public e(String str, String str2) {
            this.f63627a = str;
            this.f63628b = str2;
        }

        /* renamed from: c */
        public final boolean m85442c(String str, String str2) {
            About aboutM84137z;
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            try {
                aboutM84137z = C14329v.this.f63605h.m84137z("bakSourceStrategy", str);
            } catch (Exception e10) {
                C11839m.m70687e("CloudSpaceStateManager", "checkDeviceIsV2 error " + e10);
            }
            if (aboutM84137z != null && aboutM84137z.getBakSourceStrategy() != null) {
                for (Map.Entry<String, Object> entry : aboutM84137z.getBakSourceStrategy().entrySet()) {
                    String key = entry.getKey();
                    String strValueOf = String.valueOf(entry.getValue());
                    if (!TextUtils.isEmpty(key) && key.contains(str2)) {
                        return "1".equals(strValueOf);
                    }
                }
                return false;
            }
            return false;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            CBSAllDevicesRsp cBSAllDevicesRspM64917R;
            String strM66627b = C11058a.m66627b("02103");
            try {
                if (!C14329v.this.f63604g && (cBSAllDevicesRspM64917R = new C10582a(null).m64917R(6)) != null) {
                    C14329v.this.f63609l = cBSAllDevicesRspM64917R.getDeviceList();
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 33037;
                CBCallBack.getInstance().sendMessage(messageObtain);
                C14329v.this.m85435q0();
                if (m85442c(strM66627b, this.f63628b)) {
                    C11839m.m70688i("CloudSpaceStateManager", "device record is v2 ");
                    Message messageObtain2 = Message.obtain();
                    messageObtain2.what = 33022;
                    messageObtain2.arg1 = 1;
                    CBCallBack.getInstance().sendMessage(messageObtain2);
                    return;
                }
                List<AppSizeInfo> listM84110L = C14329v.this.f63605h.m84110L(this.f63627a, strM66627b);
                if (C1443a.f6214b.booleanValue()) {
                    for (int i10 = 0; i10 < listM84110L.size(); i10++) {
                        C11839m.m70686d("CloudSpaceStateManager", "DetailTask apps:i:" + i10 + C12540b1.m75485c(listM84110L.get(i10)));
                    }
                }
                if (!TextUtils.equals(C14329v.this.f63602e, this.f63627a)) {
                    C11839m.m70688i("CloudSpaceStateManager", "DetailTask : request backupDeviceId not same");
                    return;
                }
                C14329v.this.m85382D0(C14329v.this.m85432n0(listM84110L, this.f63627a), this.f63627a, strM66627b, false);
                if (C14329v.this.f63609l != null) {
                    C14329v.this.f63599b.m85330g(C14329v.this.f63609l);
                }
                C14329v.this.m85412V0();
                m85443d(C14329v.this.m85384F0());
                Message messageObtain3 = Message.obtain();
                messageObtain3.what = 33022;
                messageObtain3.arg1 = 0;
                CBCallBack.getInstance().sendMessage(messageObtain3);
                C14329v.this.m85387I0();
                C14329v.this.m85392L0();
                C14329v.this.m85383E0();
            } catch (Exception e10) {
                C11839m.m70687e("CloudSpaceStateManager", "DetailTask,Exception   e " + e10.getMessage());
                Message messageObtain4 = Message.obtain();
                messageObtain4.what = 33022;
                messageObtain4.arg1 = 1;
                CBCallBack.getInstance().sendMessage(messageObtain4);
            }
        }

        /* renamed from: d */
        public final void m85443d(CountDownLatch countDownLatch) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            while (countDownLatch != null && countDownLatch.getCount() > 0) {
                try {
                } catch (InterruptedException e10) {
                    C11839m.m70689w("CloudSpaceStateManager", "syncLock await interrupted. " + e10);
                }
                if (System.currentTimeMillis() - jCurrentTimeMillis > 5000) {
                    C11839m.m70688i("CloudSpaceStateManager", "syncLock await timeout: 5000ms");
                    return;
                } else if (countDownLatch.await(400L, TimeUnit.MILLISECONDS)) {
                    C11839m.m70686d("CloudSpaceStateManager", "syncLock await success");
                }
            }
        }
    }

    /* renamed from: zk.v$f */
    public static class f {

        /* renamed from: a */
        public static final C14329v f63630a = new C14329v(null);
    }

    /* renamed from: zk.v$g */
    public class g extends AbstractC12367d {

        /* renamed from: a */
        public final String f63631a;

        /* renamed from: b */
        public final String f63632b;

        public g(String str, String str2) {
            this.f63631a = str;
            this.f63632b = str2;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                C13998b0 c13998b0 = new C13998b0();
                String strM66627b = C11058a.m66627b("02017");
                List listM85434p0 = C14329v.this.m85434p0(c13998b0.m84100G("nextCursor,apps(backupAppStatus,id,backupDeviceId,backupAppName,properties,apkType,fileCount,attachments(assetId,versionId),packageVersion,appTotalSize,attachmentsSize,splitApkType,oriBackupAppName)", this.f63631a, this.f63632b, strM66627b, "icon"));
                C10153d.m63238b().put(this.f63632b, Boolean.TRUE);
                C14329v.this.m85382D0(listM85434p0, this.f63632b, strM66627b, true);
                C14329v c14329v = C14329v.this;
                List<AppDetailsInfo> listM85404R0 = c14329v.m85404R0(c14329v.m85424c0());
                if (C14329v.this.f63599b != null) {
                    C14329v.this.f63599b.m85332j(listM85404R0);
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 33023;
                messageObtain.arg1 = 0;
                CBCallBack.getInstance().sendMessage(messageObtain);
                C14329v.this.m85389J0(listM85404R0, this.f63631a);
                C14329v c14329v2 = C14329v.this;
                c14329v2.m85390K0(c14329v2.f63600c);
            } catch (C9721b e10) {
                C11839m.m70687e("CloudSpaceStateManager", "TempAppsTask,Exception:" + e10.getMessage());
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 33023;
                messageObtain2.arg1 = 1;
                CBCallBack.getInstance().sendMessage(messageObtain2);
            }
        }
    }

    public /* synthetic */ C14329v(a aVar) {
        this();
    }

    /* renamed from: A0 */
    public static /* synthetic */ void m85334A0(HashMap map, HashMap map2, AppDetailsInfo appDetailsInfo) {
        if (AbstractC14026a.m84159a(appDetailsInfo.getAttachments())) {
            return;
        }
        map.put(appDetailsInfo.getBackupAppName(), appDetailsInfo.getAttachments().get(0));
        map2.put(appDetailsInfo.getBackupAppName(), appDetailsInfo.getId());
    }

    /* renamed from: K */
    public static Map<Integer, AppDetailsInfo> m85343K(Map<Integer, AppDetailsInfo> map, AppDetailsInfo appDetailsInfo, int i10, String str) {
        if (map.containsKey(Integer.valueOf(i10))) {
            AppDetailsInfo appDetailsInfo2 = map.get(Integer.valueOf(i10));
            if (appDetailsInfo2 != null) {
                appDetailsInfo2.getChildList().add(appDetailsInfo);
                if (Objects.equals(appDetailsInfo.getBackupAppName(), str)) {
                    appDetailsInfo2.setBackupAppName(appDetailsInfo.getBackupAppName());
                }
                appDetailsInfo2.update();
            }
        } else {
            CopyOnWriteArrayList<AppDetailsInfo> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.add(appDetailsInfo);
            AppDetailsInfo appDetailsInfo3 = new AppDetailsInfo();
            appDetailsInfo3.setBackupAppName(appDetailsInfo.getBackupAppName());
            appDetailsInfo3.setApkType(6);
            appDetailsInfo3.setParentId("thirdAppData");
            appDetailsInfo3.setChildList(copyOnWriteArrayList);
            appDetailsInfo3.update();
            map.put(Integer.valueOf(i10), appDetailsInfo3);
        }
        return map;
    }

    /* renamed from: e0 */
    public static C14329v m85349e0() {
        return f.f63630a;
    }

    /* renamed from: j0 */
    public static void m85355j0(List<AppDetailsInfo> list, List<AppDetailsInfo> list2, AppDetailsInfo appDetailsInfo, Map<String, String> map) {
        if (map == null) {
            C11839m.m70688i("CloudSpaceStateManager", "hand3rdNewBmType properties is null");
            return;
        }
        if (m85365r0(appDetailsInfo)) {
            appDetailsInfo.setParentId("baseData");
        } else {
            appDetailsInfo.setParentId("thirdAppData");
            list2.add(appDetailsInfo);
        }
        list.add(appDetailsInfo);
    }

    /* renamed from: k0 */
    public static void m85357k0(List<AppDetailsInfo> list, List<AppDetailsInfo> list2, List<AppDetailsInfo> list3, AppDetailsInfo appDetailsInfo, Map<String, String> map) {
        if (map == null) {
            C11839m.m70688i("CloudSpaceStateManager", "handle3rdOldBmType properties is null");
            return;
        }
        if (String.valueOf(1).equals(map.get("appwithdata"))) {
            appDetailsInfo.setParentId("thirdAppData");
            list3.add(appDetailsInfo);
        } else {
            appDetailsInfo.setParentId("baseData");
            list2.add(appDetailsInfo);
            list.add(appDetailsInfo);
        }
    }

    /* renamed from: r0 */
    public static boolean m85365r0(AppDetailsInfo appDetailsInfo) {
        if (appDetailsInfo == null) {
            C11839m.m70688i("CloudSpaceStateManager", "isBaseDatamodule info is null");
            return false;
        }
        Map<String, String> properties = appDetailsInfo.getProperties();
        if (properties != null) {
            return TextUtils.equals(properties.getOrDefault("bmAppDataType", null), "1");
        }
        C11839m.m70688i("CloudSpaceStateManager", "isBaseDatamodule properties is null");
        return false;
    }

    /* renamed from: u0 */
    public static /* synthetic */ int m85369u0(AppDetailsInfo appDetailsInfo, AppDetailsInfo appDetailsInfo2) {
        return C12580p.m75591y(appDetailsInfo.getBackupAppName(), appDetailsInfo2.getBackupAppName());
    }

    /* renamed from: v0 */
    public static /* synthetic */ boolean m85371v0(String str, AppDetailsInfo appDetailsInfo) {
        return TextUtils.equals(appDetailsInfo.getBackupAppName(), str);
    }

    /* renamed from: w0 */
    public static /* synthetic */ boolean m85373w0(String str, AppDetailsInfo appDetailsInfo) {
        return TextUtils.equals(appDetailsInfo.getBackupAppName(), str);
    }

    /* renamed from: x0 */
    public static /* synthetic */ boolean m85375x0(List list, AppDetailsInfo appDetailsInfo) {
        return list.contains(appDetailsInfo.getBackupAppName());
    }

    /* renamed from: y0 */
    public static /* synthetic */ void m85377y0(List list, AppDetailsInfo appDetailsInfo) {
        list.add(appDetailsInfo.getBackupAppName());
    }

    /* renamed from: z0 */
    public static /* synthetic */ void m85379z0(final List list, AppDetailsInfo appDetailsInfo) {
        CopyOnWriteArrayList<AppDetailsInfo> childList = appDetailsInfo.getChildList();
        if (childList != null) {
            childList.forEach(new Consumer() { // from class: zk.u
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C14329v.m85377y0(list, (AppDetailsInfo) obj);
                }
            });
        }
    }

    /* renamed from: B0 */
    public final AppDetailsInfo m85380B0(List<AppDetailsInfo> list, AppDetailsInfo appDetailsInfo, AppDetailsInfo appDetailsInfo2, String str) {
        if (appDetailsInfo == null) {
            CopyOnWriteArrayList<AppDetailsInfo> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.add(appDetailsInfo2);
            appDetailsInfo = new AppDetailsInfo();
            appDetailsInfo.setBackupAppName(str);
            appDetailsInfo.setApkType(0);
            appDetailsInfo.setChildList(copyOnWriteArrayList);
            appDetailsInfo.update();
            list.add(appDetailsInfo);
        } else {
            appDetailsInfo.getChildList().add(appDetailsInfo2);
            appDetailsInfo.update();
        }
        appDetailsInfo.setTemp(appDetailsInfo2.isTemp());
        return appDetailsInfo;
    }

    /* renamed from: C0 */
    public final void m85381C0(String str, List<String> list) {
        C12515a.m75110o().m75175e(new a(str, list), false);
    }

    /* renamed from: D0 */
    public final void m85382D0(List<AppDetailsInfo> list, String str, String str2, boolean z10) {
        C11839m.m70688i("CloudSpaceStateManager", "queryDeviceAppListSuccess  appSizeInfoList " + list.size());
        m85393M(list, str, str2, z10);
    }

    /* renamed from: E0 */
    public final void m85383E0() {
        List<AppDetailsInfo> listM75498f = C12547e.m75495e().m75498f();
        if (listM75498f == null || listM75498f.isEmpty()) {
            C11839m.m70687e("CloudSpaceStateManager", "querySingleBasicDataAppIcon baseDataAll is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        for (AppDetailsInfo appDetailsInfo : listM75498f) {
            if (!C14333b.m85483r().containsKey(appDetailsInfo.getBackupAppName())) {
                arrayList.add(appDetailsInfo);
                List<Attachment> attachments = appDetailsInfo.getAttachments();
                if (!AbstractC14026a.m84159a(attachments)) {
                    map.put(appDetailsInfo.getBackupAppName(), attachments.get(0));
                    map2.put(appDetailsInfo.getBackupAppName(), appDetailsInfo.getId());
                }
            }
        }
        C11839m.m70686d("CloudSpaceStateManager", "querySingleBasicDataAppIcon: downLoadApps" + arrayList);
        if (map.isEmpty()) {
            C11839m.m70688i("CloudSpaceStateManager", "querySingleBasicDataAppIcon attachmentHashMap is empty ");
        } else {
            CloudBackup3rdIconUtil.download3rdIconsV3(C11058a.m66627b("02017"), map, map2);
        }
    }

    /* renamed from: F0 */
    public final CountDownLatch m85384F0() {
        if (this.f63599b == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(C14333b.m85452H());
        arrayList.remove("soundrecorder");
        arrayList.remove(NavigationUtils.SMS_SCHEMA_PREF);
        arrayList.removeAll(m85426f0());
        AppDetailsInfo appDetailsInfoM85417Y = m85417Y("thirdAppData", this.f63599b.m85325b());
        if (appDetailsInfoM85417Y != null && appDetailsInfoM85417Y.getChildList() != null && !appDetailsInfoM85417Y.getChildList().isEmpty()) {
            Iterator<AppDetailsInfo> it = appDetailsInfoM85417Y.getChildList().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getBackupAppName());
            }
        }
        C11839m.m70688i("CloudSpaceStateManager", "size = " + arrayList.size() + "queryThirdAppSize: " + arrayList);
        return m85388J(arrayList);
    }

    /* renamed from: G0 */
    public final List<String> m85385G0(CopyOnWriteArrayList<AppDetailsInfo> copyOnWriteArrayList, List<String> list) {
        if (AbstractC14026a.m84159a(copyOnWriteArrayList)) {
            return new ArrayList();
        }
        final ArrayList arrayList = new ArrayList(Arrays.asList("soundrecorder", NavigationUtils.SMS_SCHEMA_PREF));
        arrayList.removeAll(list);
        List list2 = (List) copyOnWriteArrayList.stream().filter(new Predicate() { // from class: zk.l
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C14329v.m85375x0(arrayList, (AppDetailsInfo) obj);
            }
        }).collect(Collectors.toList());
        final ArrayList arrayList2 = new ArrayList();
        list2.forEach(new Consumer() { // from class: zk.m
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C14329v.m85379z0(arrayList2, (AppDetailsInfo) obj);
            }
        });
        return arrayList2;
    }

    /* renamed from: H0 */
    public final void m85386H0(CopyOnWriteArrayList<AppDetailsInfo> copyOnWriteArrayList, List<String> list) {
        List<String> listM85385G0 = m85385G0(copyOnWriteArrayList, list);
        m85388J(listM85385G0);
        C11839m.m70688i("CloudSpaceStateManager", "sys is empty = " + listM85385G0.size() + " querySounderRecorderAndSms: " + listM85385G0);
    }

    /* renamed from: I0 */
    public final void m85387I0() {
        if (this.f63599b == null) {
            return;
        }
        List<String> arrayList = new ArrayList<>();
        CopyOnWriteArrayList<AppDetailsInfo> copyOnWriteArrayListM85325b = this.f63599b.m85325b();
        List<String> listM85327d = this.f63599b.m85327d();
        AppDetailsInfo appDetailsInfoM85417Y = m85417Y("baseData", copyOnWriteArrayListM85325b);
        if (appDetailsInfoM85417Y == null || appDetailsInfoM85417Y.getChildList() == null) {
            m85394M0(copyOnWriteArrayListM85325b, listM85327d);
            m85386H0(copyOnWriteArrayListM85325b, listM85327d);
            return;
        }
        Iterator<AppDetailsInfo> it = appDetailsInfoM85417Y.getChildList().iterator();
        while (it.hasNext()) {
            AppDetailsInfo next = it.next();
            if (next != null) {
                String backupAppName = next.getBackupAppName();
                if ("soundrecorder".equals(backupAppName) || NavigationUtils.SMS_SCHEMA_PREF.equals(backupAppName)) {
                    CopyOnWriteArrayList<AppDetailsInfo> childList = next.getChildList();
                    if (childList != null && !childList.isEmpty()) {
                        Iterator<AppDetailsInfo> it2 = childList.iterator();
                        while (it2.hasNext()) {
                            arrayList.add(it2.next().getBackupAppName());
                        }
                    }
                } else if (next.getApkType() == 0 || next.getApkType() == 2 || !next.has3rdData() || next.isNextSystemModule()) {
                    arrayList.add(backupAppName);
                }
            }
        }
        arrayList.removeAll(listM85327d);
        C11839m.m70688i("CloudSpaceStateManager", "size = " + arrayList.size() + "querySystemAppSize: " + arrayList);
        m85388J(arrayList);
    }

    /* renamed from: J */
    public final CountDownLatch m85388J(List<String> list) {
        int size = list.size();
        CountDownLatch countDownLatch = new CountDownLatch(size % 10 == 0 ? size / 10 : (size / 10) + 1);
        int iMin = 0;
        while (true) {
            int i10 = iMin;
            if (size <= iMin) {
                this.f63601d.addAndGet(size);
                return countDownLatch;
            }
            iMin = Math.min(iMin + 10, size);
            List<String> listSubList = list.subList(i10, iMin);
            C12177d.m73274b().m73275a(listSubList.toString(), new d(listSubList, this.f63602e, countDownLatch));
        }
    }

    /* renamed from: J0 */
    public final void m85389J0(List<AppDetailsInfo> list, String str) {
        if (list == null || list.isEmpty()) {
            return;
        }
        C11839m.m70688i("CloudSpaceStateManager", "queryTempAppIcon: " + list);
        C12515a.m75110o().m75172d(new C12174b(list, C0213f.m1377a(), str));
    }

    /* renamed from: K0 */
    public final void m85390K0(List<AppDetailsInfo> list) {
        if (AbstractC14026a.m84159a(list)) {
            return;
        }
        final HashMap map = new HashMap();
        final HashMap map2 = new HashMap();
        list.forEach(new Consumer() { // from class: zk.p
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C14329v.m85334A0(map, map2, (AppDetailsInfo) obj);
            }
        });
        C11839m.m70686d("CloudSpaceStateManager", "queryTempSingleBasicDataAppIcon: downLoadApps" + list);
        if (map.isEmpty() || map2.isEmpty()) {
            C11839m.m70688i("CloudSpaceStateManager", "queryTempSingleBasicDataAppIcon attachmentHashMap is empty ");
        } else {
            CloudBackup3rdIconUtil.download3rdIconsV3(C11058a.m66627b("02017"), map, map2);
        }
    }

    /* renamed from: L */
    public final void m85391L(List<AppDetailsInfo> list, List<AppDetailsInfo> list2, List<AppDetailsInfo> list3, List<AppDetailsInfo> list4, boolean z10, List<String> list5) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        list.sort(new Comparator() { // from class: zk.q
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C14329v.m85369u0((AppDetailsInfo) obj, (AppDetailsInfo) obj2);
            }
        });
        if (!list2.isEmpty()) {
            AppDetailsInfo appDetailsInfo = new AppDetailsInfo();
            appDetailsInfo.setBackupAppName("baseData");
            appDetailsInfo.setApkType(0);
            appDetailsInfo.setTemp(z10);
            CopyOnWriteArrayList<AppDetailsInfo> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList2.addAll(list);
            copyOnWriteArrayList2.addAll(list2);
            copyOnWriteArrayList2.addAll(list3);
            copyOnWriteArrayList2.addAll(list4);
            appDetailsInfo.setChildList(copyOnWriteArrayList2);
            appDetailsInfo.update();
            copyOnWriteArrayList.add(appDetailsInfo);
        }
        copyOnWriteArrayList.addAll(list);
        copyOnWriteArrayList.addAll(list3);
        if (!list4.isEmpty()) {
            list4.sort(new Comparator() { // from class: zk.r
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return C12580p.m75576j((AppDetailsInfo) obj, (AppDetailsInfo) obj2);
                }
            });
            AppDetailsInfo appDetailsInfo2 = new AppDetailsInfo();
            appDetailsInfo2.setBackupAppName("thirdAppData");
            appDetailsInfo2.setApkType(1);
            appDetailsInfo2.setChildList(new CopyOnWriteArrayList<>(list4));
            appDetailsInfo2.setTemp(z10);
            appDetailsInfo2.update();
            copyOnWriteArrayList.add(appDetailsInfo2);
        }
        this.f63599b = new C14318k(list5, copyOnWriteArrayList, this.f63609l);
        C11839m.m70688i("CloudSpaceStateManager", "buildBackupItemList  mCurrentDeviceCache done ");
    }

    /* renamed from: L0 */
    public final void m85392L0() {
        AppDetailsInfo appDetailsInfoM85417Y;
        CopyOnWriteArrayList<AppDetailsInfo> childList;
        C14318k c14318k = this.f63599b;
        if (c14318k == null || (appDetailsInfoM85417Y = m85417Y("thirdAppData", c14318k.m85325b())) == null || appDetailsInfoM85417Y.isEmpty() || (childList = appDetailsInfoM85417Y.getChildList()) == null || childList.isEmpty()) {
            return;
        }
        C11839m.m70688i("CloudSpaceStateManager", "queryThirdAppIcon: " + childList);
        C12515a.m75110o().m75172d(new C12174b(childList, C0213f.m1377a(), this.f63602e));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: M */
    public final void m85393M(List<AppDetailsInfo> list, String str, String str2, boolean z10) {
        Map map;
        ArrayList arrayList;
        ArrayList arrayList2;
        AppDetailsInfo appDetailsInfoM85380B0;
        ArrayList arrayList3;
        List<String> list2;
        AppDetailsInfo appDetailsInfo;
        String str3;
        C14329v c14329v;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        C14329v c14329v2;
        AppDetailsInfo appDetailsInfo2;
        String str4;
        AppDetailsInfo appDetailsInfo3;
        String str5;
        C14329v c14329v3;
        AppDetailsInfo appDetailsInfo4;
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        Map map2 = new HashMap();
        this.f63600c.clear();
        boolean zM85437t0 = m85437t0(str);
        List<String> listM85427g0 = m85427g0();
        ArrayList arrayList13 = new ArrayList(C14333b.m85452H());
        String str6 = "callRecorder";
        arrayList13.add("callRecorder");
        String str7 = "chatSms";
        arrayList13.add("chatSms");
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        CopyOnWriteArrayList<AppDetailsInfo> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        Iterator<AppDetailsInfo> it = list.iterator();
        ArrayList arrayList16 = arrayList9;
        ArrayList arrayList17 = arrayList15;
        AppDetailsInfo appDetailsInfo5 = null;
        Map map3 = map2;
        ArrayList arrayList18 = arrayList12;
        AppDetailsInfo appDetailsInfo6 = null;
        while (true) {
            map = map3;
            AppDetailsInfo appDetailsInfo7 = appDetailsInfo5;
            if (!it.hasNext()) {
                break;
            }
            AppDetailsInfo next = it.next();
            AppDetailsInfo appDetailsInfo8 = appDetailsInfo6;
            String backupAppName = next.getBackupAppName();
            ArrayList arrayList19 = arrayList7;
            Map<String, String> properties = next.getProperties();
            String str8 = str6;
            int iM1685c = C0241z.m1685c(CloudRestoreClient.value(properties, "appShowType"));
            String str9 = str7;
            String strValue = CloudRestoreClient.value(properties, "AggVirtualAppId");
            ArrayList arrayList20 = arrayList13;
            StringBuilder sb2 = new StringBuilder();
            ArrayList arrayList21 = arrayList11;
            sb2.append("appshowtype: ");
            sb2.append(iM1685c);
            sb2.append(" virtualappid:");
            sb2.append(strValue);
            sb2.append(" appname: ");
            sb2.append(backupAppName);
            sb2.append(" ,apkType: ");
            sb2.append(next.getApkType());
            sb2.append(" ,properties: ");
            sb2.append(properties);
            C11839m.m70688i("CloudSpaceStateManager", sb2.toString());
            int apkType = next.getApkType();
            if (zM85437t0 && m85365r0(next) && !C14338g.m85501a(next.getApkType())) {
                arrayList14.add(backupAppName);
            }
            next.setTemp(z10);
            if (next.isSystemDataOrBaseData(listM85427g0, zM85437t0)) {
                next.setParentId("baseData");
                next.setBasicItem(true);
                if (C14333b.f63654f.contains(next.getBackupAppName())) {
                    copyOnWriteArrayList.add(next);
                } else {
                    arrayList10.add(next);
                    arrayList8.add(next);
                }
                map3 = map;
                arrayList5 = arrayList17;
                arrayList4 = arrayList18;
                appDetailsInfoM85380B0 = appDetailsInfo8;
                arrayList6 = arrayList16;
                arrayList3 = arrayList19;
                arrayList2 = arrayList20;
                arrayList = arrayList21;
            } else if (apkType == 2) {
                next.setVirtualApp(true);
                next.setParentId("virtualApp");
                arrayList = arrayList21;
                arrayList.add(next);
                map3 = map;
                arrayList5 = arrayList17;
                arrayList4 = arrayList18;
                appDetailsInfoM85380B0 = appDetailsInfo8;
                arrayList6 = arrayList16;
                arrayList3 = arrayList19;
                arrayList2 = arrayList20;
            } else {
                arrayList = arrayList21;
                arrayList2 = arrayList20;
                if (arrayList2.contains(next.getBackupAppName())) {
                    next.setParentId("system_show_data");
                    if (NavigationUtils.SMS_SCHEMA_PREF.equals(backupAppName)) {
                        c14329v2 = this;
                        appDetailsInfo2 = appDetailsInfo8;
                        arrayList3 = arrayList19;
                        str4 = str8;
                        appDetailsInfo3 = appDetailsInfo7;
                    } else if (str9.equals(backupAppName)) {
                        c14329v2 = this;
                        str9 = str9;
                        appDetailsInfo2 = appDetailsInfo8;
                        appDetailsInfo3 = appDetailsInfo7;
                        arrayList3 = arrayList19;
                        str4 = str8;
                    } else {
                        if ("soundrecorder".equals(backupAppName)) {
                            arrayList3 = arrayList19;
                            str5 = str8;
                            c14329v3 = this;
                            appDetailsInfo4 = appDetailsInfo8;
                        } else {
                            str5 = str8;
                            if (str5.equals(backupAppName)) {
                                c14329v3 = this;
                                appDetailsInfo4 = appDetailsInfo8;
                                arrayList3 = arrayList19;
                            } else {
                                arrayList3 = arrayList19;
                                arrayList3.add(next);
                                arrayList5 = arrayList17;
                                str9 = str9;
                                appDetailsInfoM85380B0 = appDetailsInfo8;
                                arrayList6 = arrayList16;
                                appDetailsInfo = appDetailsInfo7;
                                map3 = map;
                                str3 = str5;
                                list2 = listM85427g0;
                                c14329v = this;
                                arrayList4 = arrayList18;
                            }
                        }
                        appDetailsInfoM85380B0 = c14329v3.m85380B0(arrayList3, appDetailsInfo4, next, "soundrecorder");
                        str9 = str9;
                        list2 = listM85427g0;
                        c14329v = c14329v3;
                        arrayList6 = arrayList16;
                        appDetailsInfo = appDetailsInfo7;
                        map3 = map;
                        arrayList5 = arrayList17;
                        str3 = str5;
                        arrayList4 = arrayList18;
                    }
                    AppDetailsInfo appDetailsInfoM85380B02 = c14329v2.m85380B0(arrayList3, appDetailsInfo3, next, NavigationUtils.SMS_SCHEMA_PREF);
                    map3 = map;
                    appDetailsInfo = appDetailsInfoM85380B02;
                    str3 = str4;
                    list2 = listM85427g0;
                    c14329v = c14329v2;
                    appDetailsInfoM85380B0 = appDetailsInfo2;
                    arrayList6 = arrayList16;
                    arrayList5 = arrayList17;
                    arrayList4 = arrayList18;
                } else {
                    appDetailsInfoM85380B0 = appDetailsInfo8;
                    arrayList3 = arrayList19;
                    list2 = listM85427g0;
                    appDetailsInfo = appDetailsInfo7;
                    str3 = str8;
                    c14329v = this;
                    if (apkType == 6 && iM1685c >= 4 && z10) {
                        Map mapM85343K = m85343K(map, next, iM1685c, strValue);
                        arrayList5 = arrayList17;
                        arrayList4 = arrayList18;
                        map3 = mapM85343K;
                    } else {
                        map3 = map;
                        if (apkType == 6 && z10) {
                            c14329v.f63600c.add(next);
                        }
                        if (next.getExistSplit().booleanValue()) {
                            next.setParentId("thirdAppData");
                            arrayList4 = arrayList18;
                            arrayList4.add(next);
                            arrayList5 = arrayList17;
                        } else {
                            arrayList4 = arrayList18;
                            if (zM85437t0) {
                                arrayList5 = arrayList17;
                                m85355j0(arrayList5, arrayList4, next, properties);
                            } else {
                                arrayList5 = arrayList17;
                                arrayList6 = arrayList16;
                                m85357k0(arrayList6, arrayList10, arrayList4, next, properties);
                            }
                        }
                    }
                    arrayList6 = arrayList16;
                }
                arrayList18 = arrayList4;
                arrayList7 = arrayList3;
                arrayList11 = arrayList;
                arrayList17 = arrayList5;
                arrayList16 = arrayList6;
                arrayList13 = arrayList2;
                listM85427g0 = list2;
                str6 = str3;
                appDetailsInfo6 = appDetailsInfoM85380B0;
                appDetailsInfo5 = appDetailsInfo;
                str7 = str9;
            }
            list2 = listM85427g0;
            appDetailsInfo = appDetailsInfo7;
            str3 = str8;
            c14329v = this;
            arrayList18 = arrayList4;
            arrayList7 = arrayList3;
            arrayList11 = arrayList;
            arrayList17 = arrayList5;
            arrayList16 = arrayList6;
            arrayList13 = arrayList2;
            listM85427g0 = list2;
            str6 = str3;
            appDetailsInfo6 = appDetailsInfoM85380B0;
            appDetailsInfo5 = appDetailsInfo;
            str7 = str9;
        }
        ArrayList arrayList22 = arrayList17;
        ArrayList arrayList23 = arrayList7;
        ArrayList arrayList24 = arrayList11;
        ArrayList arrayList25 = arrayList16;
        ArrayList arrayList26 = arrayList18;
        if (z10) {
            for (Iterator it2 = map.values().iterator(); it2.hasNext(); it2 = it2) {
                AppDetailsInfo appDetailsInfo9 = (AppDetailsInfo) it2.next();
                arrayList23.add(appDetailsInfo9);
                this.f63600c.add(appDetailsInfo9);
            }
        }
        if (zM85437t0 && !arrayList14.isEmpty()) {
            arrayList25.addAll(arrayList22);
        }
        C12547e.m75495e().m75500i(arrayList25);
        if (!AbstractC14026a.m84159a(copyOnWriteArrayList)) {
            AppDetailsInfo appDetailsInfo10 = new AppDetailsInfo();
            appDetailsInfo10.setBasicItem(true);
            appDetailsInfo10.setParentId("baseData");
            appDetailsInfo10.setBackupAppName("basic_system_data");
            appDetailsInfo10.setChildList(copyOnWriteArrayList);
            arrayList8.add(0, appDetailsInfo10);
        }
        C12547e.m75495e().m75501j(arrayList8);
        if (arrayList24.size() > 0) {
            CloudBackup3rdIconUtil.downloadVirtualIcon();
        }
        C11839m.m70688i("CloudSpaceStateManager", "baseModuleList: " + arrayList14);
        m85391L(arrayList23, arrayList10, arrayList24, arrayList26, z10, arrayList14);
    }

    /* renamed from: M0 */
    public final void m85394M0(CopyOnWriteArrayList<AppDetailsInfo> copyOnWriteArrayList, List<String> list) {
        List<String> listM85429i0 = m85429i0(copyOnWriteArrayList, list);
        m85388J(listM85429i0);
        C11839m.m70688i("CloudSpaceStateManager", "sys is empty = " + listM85429i0.size() + " queryVirtualList: " + listM85429i0);
    }

    /* renamed from: N */
    public void m85395N() {
        C11839m.m70688i("CloudSpaceStateManager", "cancelCurrentAllTask");
        C12515a.m75110o().m75166b(e.class.getName());
        C12515a.m75110o().m75166b(d.class.getName());
        this.f63608k = null;
    }

    /* renamed from: N0 */
    public void m85396N0(String str) {
        if (this.f63598a.size() <= 0 || TextUtils.isEmpty(str) || !this.f63598a.containsKey(str)) {
            return;
        }
        C11839m.m70688i("CloudSpaceStateManager", "removeDeleteDeviceCache");
        this.f63598a.remove(str);
    }

    /* renamed from: O */
    public boolean m85397O(long j10) {
        List<HashMap<String, String>> listM61798k = C9961b.m61788i().m61798k();
        if (listM61798k == null || listM61798k.size() == 0) {
            C11839m.m70687e("CloudSpaceStateManager", "checkAppVersion：empty version range");
            return false;
        }
        try {
            C11839m.m70686d("CloudSpaceStateManager", "checkAppVersion： " + listM61798k);
            for (int i10 = 0; i10 < listM61798k.size(); i10++) {
                HashMap<String, String> map = listM61798k.get(i10);
                String str = map.containsKey("start") ? map.get("start") : null;
                String str2 = map.containsKey("end") ? map.get("end") : null;
                if (j10 >= C0241z.m1688f(str) && j10 <= C0241z.m1688f(str2)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            C11839m.m70687e("CloudSpaceStateManager", "checkAppVersion Exception");
            return false;
        }
    }

    /* renamed from: O0 */
    public void m85398O0(List<String> list, boolean z10, boolean z11, boolean z12, long j10, int i10, int i11) {
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("appId", list.toString());
        linkedHashMapM79499C.put("isCheck", String.valueOf(z10));
        linkedHashMapM79499C.put("deleteSize", String.valueOf(j10));
        linkedHashMapM79499C.put("isCurrent", String.valueOf(z12));
        linkedHashMapM79499C.put("isSuccess", String.valueOf(z11));
        linkedHashMapM79499C.put("deleteReportEntry", String.valueOf(i10));
        if (i11 >= 0) {
            linkedHashMapM79499C.put("bmFullDataAppCount", String.valueOf(i11));
        }
        C13225d.m79490f1().m79591l0("mecloud_cloudspace_click_backup_app_detele", linkedHashMapM79499C);
        UBAAnalyze.m29947H("PVC", "mecloud_cloudspace_click_backup_app_detele", linkedHashMapM79499C);
    }

    /* renamed from: P */
    public void m85399P() {
        m85401Q();
    }

    /* renamed from: P0 */
    public final void m85400P0(ArrayList<String> arrayList) {
        if (arrayList.contains("soundrecorder")) {
            arrayList.remove("callRecorder");
        }
        if (arrayList.contains(NavigationUtils.SMS_SCHEMA_PREF)) {
            arrayList.remove("chatSms");
        }
    }

    /* renamed from: Q */
    public final void m85401Q() {
        C14318k c14318k = this.f63599b;
        if (c14318k == null) {
            return;
        }
        CopyOnWriteArrayList<AppDetailsInfo> copyOnWriteArrayListM85325b = c14318k.m85325b();
        AppDetailsInfo appDetailsInfoM85417Y = m85417Y("thirdAppData", copyOnWriteArrayListM85325b);
        AppDetailsInfo appDetailsInfoM85417Y2 = m85417Y("baseData", copyOnWriteArrayListM85325b);
        int i10 = 2;
        if (appDetailsInfoM85417Y2 == null || !appDetailsInfoM85417Y2.isRequestDone()) {
            if (appDetailsInfoM85417Y != null && appDetailsInfoM85417Y.isRequestDone()) {
                i10 = 1;
            } else if (this.f63601d.get() != 0) {
                i10 = 0;
            }
        } else if (appDetailsInfoM85417Y2.getRequestStatus() == 1) {
            this.f63599b.m85331h();
        }
        if (i10 == 0) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 34334;
        messageObtain.arg1 = i10;
        CBCallBack.getInstance().sendMessage(messageObtain);
    }

    /* renamed from: Q0 */
    public final void m85402Q0(AppDetailsInfo appDetailsInfo) {
        C11839m.m70686d("CloudSpaceStateManager", "sendOneModuleUpdateMessage" + appDetailsInfo.toString());
        Message messageObtain = Message.obtain();
        messageObtain.what = 34333;
        messageObtain.obj = appDetailsInfo;
        Bundle bundle = new Bundle();
        bundle.putSerializable("AppDetailsInfo", appDetailsInfo);
        messageObtain.setData(bundle);
        CBCallBack.getInstance().sendMessage(messageObtain);
    }

    /* renamed from: R */
    public final void m85403R(List<String> list, List<AppSizeInfo> list2) {
        ArrayList arrayList = new ArrayList();
        Iterator<AppSizeInfo> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getBackupAppName());
        }
        for (String str : list) {
            if (!arrayList.contains(str)) {
                AppDetailsInfo appDetailsInfo = new AppDetailsInfo();
                appDetailsInfo.setBackupAppName(str);
                appDetailsInfo.setTotalSize(0L);
                appDetailsInfo.setAppSize(0L);
                list2.add(appDetailsInfo);
            }
        }
    }

    /* renamed from: R0 */
    public final List<AppDetailsInfo> m85404R0(List<AppDetailsInfo> list) {
        ArrayList arrayList = new ArrayList(list);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AppDetailsInfo appDetailsInfo = (AppDetailsInfo) it.next();
            if ("thirdAppData".equals(appDetailsInfo.getBackupAppName())) {
                arrayList2.addAll(appDetailsInfo.getChildList());
                it.remove();
                break;
            }
        }
        arrayList.addAll(arrayList2);
        arrayList.sort(new C3808n4());
        return arrayList;
    }

    /* renamed from: S */
    public final void m85405S() {
        CopyOnWriteArrayList<AppDetailsInfo> copyOnWriteArrayListM85325b;
        AppDetailsInfo appDetailsInfoM85417Y;
        C14318k c14318k = this.f63599b;
        if (c14318k == null || (appDetailsInfoM85417Y = m85417Y("thirdAppData", (copyOnWriteArrayListM85325b = c14318k.m85325b()))) == null || appDetailsInfoM85417Y.getChildList() == null || !appDetailsInfoM85417Y.getChildList().isEmpty()) {
            return;
        }
        copyOnWriteArrayListM85325b.remove(appDetailsInfoM85417Y);
        Message message = new Message();
        message.what = 34444;
        CBCallBack.getInstance().sendMessage(message);
    }

    /* renamed from: S0 */
    public boolean m85406S0(String str) {
        String str2 = this.f63608k;
        if (str2 == null) {
            return true;
        }
        return TextUtils.equals(str, str2);
    }

    /* renamed from: T */
    public void m85407T() {
        this.f63598a.clear();
        this.f63599b = null;
        this.f63601d = new AtomicInteger(0);
        this.f63606i.clear();
    }

    /* renamed from: T0 */
    public final void m85408T0(AppDetailsInfo appDetailsInfo, AppSizeInfo appSizeInfo) {
        if (appDetailsInfo != null) {
            AppDetailsInfo appDetailsInfo2 = new AppDetailsInfo();
            appDetailsInfo2.copy(appDetailsInfo);
            CopyOnWriteArrayList<AppDetailsInfo> childList = appDetailsInfo.getChildList();
            if (childList != null && !childList.isEmpty()) {
                String backupAppName = appSizeInfo.getBackupAppName();
                Iterator<AppDetailsInfo> it = childList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AppDetailsInfo next = it.next();
                    AppDetailsInfo appDetailsInfo3 = new AppDetailsInfo();
                    appDetailsInfo3.copy(next);
                    if (backupAppName.equals(next.getBackupAppName())) {
                        next.update(appSizeInfo);
                        next.update();
                        if (!"soundrecorder".equals(backupAppName) && !"callRecorder".equals(backupAppName) && !NavigationUtils.SMS_SCHEMA_PREF.equals(backupAppName) && !"chatSms".equals(backupAppName) && !next.isSame(appDetailsInfo3)) {
                            m85402Q0(next);
                        }
                    }
                }
            } else {
                appDetailsInfo.update(appSizeInfo);
            }
            appDetailsInfo.update();
            if (appDetailsInfo.isSame(appDetailsInfo2)) {
                return;
            }
            m85402Q0(appDetailsInfo);
        }
    }

    /* renamed from: U */
    public void m85409U(List<String> list, Consumer<Integer> consumer) {
        C12515a.m75110o().m75172d(new b(list, consumer));
    }

    /* renamed from: U0 */
    public final void m85410U0(AppDetailsInfo appDetailsInfo, AppDetailsInfo appDetailsInfo2) {
        if (appDetailsInfo != null) {
            CopyOnWriteArrayList<AppDetailsInfo> childList = appDetailsInfo.getChildList();
            if (childList != null && !childList.isEmpty()) {
                String backupAppName = appDetailsInfo2.getBackupAppName();
                Iterator<AppDetailsInfo> it = childList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AppDetailsInfo next = it.next();
                    if (backupAppName.equals(next.getBackupAppName())) {
                        next.copy(appDetailsInfo2);
                        next.update();
                        if (!"soundrecorder".equals(backupAppName) && !"callRecorder".equals(backupAppName) && !NavigationUtils.SMS_SCHEMA_PREF.equals(backupAppName) && !"chatSms".equals(backupAppName)) {
                            m85402Q0(next);
                        }
                    }
                }
            } else {
                appDetailsInfo.copy(appDetailsInfo2);
            }
            appDetailsInfo.update();
            m85402Q0(appDetailsInfo);
        }
    }

    /* renamed from: V */
    public final void m85411V(List<String> list, boolean z10, String str, long j10, int i10, int i11) {
        C12515a.m75110o().m75175e(new c(list, z10, str, j10, i10, i11), false);
    }

    /* renamed from: V0 */
    public final void m85412V0() {
        Long l10;
        if (this.f63598a.size() >= 5) {
            HashMap map = new HashMap(1);
            String str = null;
            for (Map.Entry<String, C14318k> entry : this.f63598a.entrySet()) {
                String key = entry.getKey();
                C14318k value = entry.getValue();
                if (value != null) {
                    long jM85328e = value.m85328e();
                    if (map.size() > 0 && str != null && map.get(str) != null && (l10 = (Long) map.get(str)) != null && jM85328e < l10.longValue()) {
                        map.put(key, Long.valueOf(jM85328e));
                        C11839m.m70686d("CloudSpaceStateManager", "DetailTask,updateCache tempMap tempKey = " + key + " ,requestTime " + jM85328e);
                        str = key;
                    }
                    if (str == null) {
                        map.put(key, Long.valueOf(jM85328e));
                        C11839m.m70686d("CloudSpaceStateManager", "DetailTask,updateCache tempMap tempKey = " + key + " ,requestTime " + jM85328e);
                        str = key;
                    }
                }
            }
            C11839m.m70686d("CloudSpaceStateManager", "DetailTask,updateCache remove tempKey = " + str);
            this.f63598a.remove(str);
            C11839m.m70686d("CloudSpaceStateManager", "DetailTask,MAX_CACHE_SIZE remove");
        }
        this.f63598a.put(this.f63603f, this.f63599b);
    }

    /* renamed from: W */
    public final void m85413W(List<String> list) {
        CopyOnWriteArrayList<AppDetailsInfo> copyOnWriteArrayList;
        Iterator<AppDetailsInfo> it;
        Iterator<AppDetailsInfo> it2;
        synchronized (this.f63607j) {
            try {
                if (this.f63599b == null) {
                    return;
                }
                this.f63606i.addAll(list);
                C11839m.m70688i("CloudSpaceStateManager", "deleteDeviceAppSuccess ， appNameList = " + list.size());
                CopyOnWriteArrayList<AppDetailsInfo> copyOnWriteArrayListM85325b = this.f63599b.m85325b();
                if (copyOnWriteArrayListM85325b == null) {
                    C11839m.m70688i("CloudSpaceStateManager", "updateDataFailReq ， detailsInfos = null");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<AppDetailsInfo> it3 = copyOnWriteArrayListM85325b.iterator();
                long j10 = 0;
                long totalSize = 0;
                while (it3.hasNext()) {
                    AppDetailsInfo next = it3.next();
                    if (!"baseData".equals(next.getBackupAppName())) {
                        for (String str : list) {
                            boolean z10 = str.equals("callRecorder") || str.equals("chatSms");
                            CopyOnWriteArrayList<AppDetailsInfo> childList = next.getChildList();
                            if (TextUtils.equals(str, next.getBackupAppName())) {
                                if (!arrayList.contains(str) && next.getTotalSize() > j10) {
                                    arrayList.add(str);
                                    if (!z10) {
                                        totalSize += next.getTotalSize();
                                    }
                                    C11839m.m70688i("CloudSpaceStateManager", "delete module ， appId = " + str + " , totalSize = " + next.getTotalSize());
                                }
                                copyOnWriteArrayListM85325b.remove(next);
                            } else if (childList != null && !childList.isEmpty()) {
                                Iterator<AppDetailsInfo> it4 = childList.iterator();
                                while (it4.hasNext()) {
                                    AppDetailsInfo next2 = it4.next();
                                    if (TextUtils.equals(str, next2.getBackupAppName())) {
                                        if (arrayList.contains(str) || next2.getTotalSize() <= 0) {
                                            copyOnWriteArrayList = copyOnWriteArrayListM85325b;
                                            it = it3;
                                            it2 = it4;
                                        } else {
                                            arrayList.add(str);
                                            if (!z10) {
                                                totalSize += next2.getTotalSize();
                                            }
                                            copyOnWriteArrayList = copyOnWriteArrayListM85325b;
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append("delete module ， appId = ");
                                            sb2.append(str);
                                            sb2.append(" , totalSize = ");
                                            it = it3;
                                            it2 = it4;
                                            sb2.append(next2.getTotalSize());
                                            C11839m.m70688i("CloudSpaceStateManager", sb2.toString());
                                        }
                                        childList.remove(next2);
                                        next.update();
                                    } else {
                                        copyOnWriteArrayList = copyOnWriteArrayListM85325b;
                                        it = it3;
                                        it2 = it4;
                                    }
                                    it3 = it;
                                    copyOnWriteArrayListM85325b = copyOnWriteArrayList;
                                    it4 = it2;
                                }
                            }
                            it3 = it3;
                            j10 = 0;
                            copyOnWriteArrayListM85325b = copyOnWriteArrayListM85325b;
                        }
                    } else if (AbstractC14026a.m84159a(next.getChildList())) {
                        C11839m.m70688i("CloudSpaceStateManager", "baseData child list is empty");
                    } else {
                        CopyOnWriteArrayList<AppDetailsInfo> childList2 = next.getChildList();
                        for (final String str2 : list) {
                            if (!arrayList.contains(str2)) {
                                arrayList.add(str2);
                            }
                            C12547e.m75495e().m75498f().removeIf(new Predicate() { // from class: zk.s
                                @Override // java.util.function.Predicate
                                public final boolean test(Object obj) {
                                    return C14329v.m85371v0(str2, (AppDetailsInfo) obj);
                                }
                            });
                            childList2.removeIf(new Predicate() { // from class: zk.t
                                @Override // java.util.function.Predicate
                                public final boolean test(Object obj) {
                                    return C14329v.m85373w0(str2, (AppDetailsInfo) obj);
                                }
                            });
                        }
                        next.update();
                    }
                }
                this.f63606i.removeAll(arrayList);
                m85405S();
                C11839m.m70688i("CloudSpaceStateManager", "delete module ， size  = " + list.size() + " , deletetotalSize = " + totalSize);
                Message message = new Message();
                message.what = 33042;
                message.obj = Long.valueOf(totalSize);
                message.arg1 = 0;
                CBCallBack.getInstance().sendMessage(message);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: W0 */
    public final void m85414W0(List<String> list, int i10) {
        synchronized (this.f63607j) {
            try {
                if (this.f63599b != null && list != null && list.size() > 0) {
                    C11839m.m70688i("CloudSpaceStateManager", "updateDataFailReqNew ， appNameList = " + list.size() + " ,errorCode = " + i10);
                    CopyOnWriteArrayList<AppDetailsInfo> copyOnWriteArrayListM85325b = this.f63599b.m85325b();
                    if (copyOnWriteArrayListM85325b == null) {
                        C11839m.m70688i("CloudSpaceStateManager", "updateDataFailReq ， detailsInfos = null");
                        return;
                    }
                    for (AppDetailsInfo appDetailsInfo : copyOnWriteArrayListM85325b) {
                        for (String str : list) {
                            CopyOnWriteArrayList<AppDetailsInfo> childList = appDetailsInfo.getChildList();
                            if (TextUtils.equals(str, appDetailsInfo.getBackupAppName())) {
                                appDetailsInfo.updateRequestFail(i10);
                                m85402Q0(appDetailsInfo);
                            } else if (childList != null && !childList.isEmpty()) {
                                for (AppDetailsInfo appDetailsInfo2 : childList) {
                                    if (TextUtils.equals(str, appDetailsInfo2.getBackupAppName())) {
                                        appDetailsInfo2.updateRequestFail(i10);
                                        appDetailsInfo2.update();
                                        m85410U0(appDetailsInfo, appDetailsInfo2);
                                    }
                                }
                            }
                        }
                    }
                    m85401Q();
                }
            } finally {
            }
        }
    }

    /* renamed from: X */
    public void m85415X(List<String> list, boolean z10, String str, long j10, int i10, int i11) {
        m85418Y0(list, true);
        m85411V(list, z10, str, j10, i10, i11);
    }

    /* renamed from: X0 */
    public final void m85416X0(List<AppSizeInfo> list, String str, String str2) {
        if (this.f63599b == null || list == null || list.size() <= 0) {
            return;
        }
        synchronized (this.f63607j) {
            m85420Z0(list, str, str2);
        }
    }

    /* renamed from: Y */
    public final AppDetailsInfo m85417Y(String str, List<AppDetailsInfo> list) {
        if (list != null && !list.isEmpty()) {
            for (AppDetailsInfo appDetailsInfo : list) {
                if (appDetailsInfo.getBackupAppName().equals(str)) {
                    return appDetailsInfo;
                }
            }
        }
        return null;
    }

    /* renamed from: Y0 */
    public final void m85418Y0(List<String> list, boolean z10) {
        C14318k c14318k = this.f63599b;
        if (c14318k == null) {
            return;
        }
        for (AppDetailsInfo appDetailsInfo : c14318k.m85325b()) {
            for (String str : list) {
                if (TextUtils.equals(str, appDetailsInfo.getBackupAppName())) {
                    AppDetailsInfo appDetailsInfo2 = new AppDetailsInfo();
                    appDetailsInfo2.copy(appDetailsInfo);
                    appDetailsInfo2.setUiStyle(z10 ? 2 : 0);
                    m85402Q0(appDetailsInfo2);
                } else if (appDetailsInfo.getChildList() != null && !appDetailsInfo.getChildList().isEmpty()) {
                    for (AppDetailsInfo appDetailsInfo3 : appDetailsInfo.getChildList()) {
                        if (TextUtils.equals(str, appDetailsInfo3.getBackupAppName())) {
                            AppDetailsInfo appDetailsInfo4 = new AppDetailsInfo();
                            appDetailsInfo4.copy(appDetailsInfo3);
                            appDetailsInfo4.setUiStyle(z10 ? 2 : 0);
                            m85402Q0(appDetailsInfo4);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: Z */
    public List<CBSSyncRecordDeviceInfo> m85419Z() {
        return this.f63609l;
    }

    /* renamed from: Z0 */
    public final void m85420Z0(List<AppSizeInfo> list, String str, String str2) {
        if (list == null || this.f63599b == null) {
            C11839m.m70688i("CloudSpaceStateManager", "updateItemSize detailsInfos or mCurrentDeviceCache = null");
            return;
        }
        C11839m.m70688i("CloudSpaceStateManager", "updateItemSizeNew ， updateModules.size（）" + list.size());
        boolean zM85437t0 = m85437t0(str);
        List<String> listM85421a0 = m85421a0(zM85437t0);
        ArrayList arrayList = new ArrayList(C14333b.m85452H());
        arrayList.add("callRecorder");
        arrayList.add("chatSms");
        CopyOnWriteArrayList<AppDetailsInfo> copyOnWriteArrayListM85325b = this.f63599b.m85325b();
        List<String> listM85327d = this.f63599b.m85327d();
        AppDetailsInfo appDetailsInfoM85417Y = m85417Y("baseData", copyOnWriteArrayListM85325b);
        m85422a1(list);
        List<String> listM85429i0 = m85429i0(copyOnWriteArrayListM85325b, listM85327d);
        for (AppSizeInfo appSizeInfo : list) {
            String backupAppName = appSizeInfo.getBackupAppName();
            int apkType = appSizeInfo.getApkType();
            if (appSizeInfo.isSystemDataOrBaseData(listM85421a0, zM85437t0)) {
                m85408T0(m85417Y("baseData", copyOnWriteArrayListM85325b), appSizeInfo);
            } else if (apkType == 2 || listM85429i0.contains(backupAppName)) {
                m85408T0(m85417Y(backupAppName, copyOnWriteArrayListM85325b), appSizeInfo);
                m85408T0(appDetailsInfoM85417Y, appSizeInfo);
            } else if (arrayList.contains(backupAppName)) {
                if ("chatSms".equals(backupAppName)) {
                    backupAppName = NavigationUtils.SMS_SCHEMA_PREF;
                }
                if ("callRecorder".equals(backupAppName)) {
                    backupAppName = "soundrecorder";
                }
                m85408T0(m85417Y(backupAppName, copyOnWriteArrayListM85325b), appSizeInfo);
                m85408T0(appDetailsInfoM85417Y, appSizeInfo);
            } else {
                m85408T0(m85417Y("thirdAppData", this.f63599b.m85325b()), appSizeInfo);
                m85408T0(appDetailsInfoM85417Y, appSizeInfo);
            }
        }
        m85401Q();
    }

    /* renamed from: a0 */
    public final List<String> m85421a0(boolean z10) {
        return z10 ? new ArrayList() : new ArrayList(C14333b.m85482q());
    }

    /* renamed from: a1 */
    public final void m85422a1(List<AppSizeInfo> list) {
        if (list == null || list.isEmpty() || this.f63606i.isEmpty()) {
            return;
        }
        ArrayList<AppSizeInfo> arrayList = new ArrayList(list);
        ArrayList arrayList2 = new ArrayList();
        long j10 = 0;
        for (String str : this.f63606i) {
            for (AppSizeInfo appSizeInfo : arrayList) {
                if (TextUtils.equals(str, appSizeInfo.getBackupAppName())) {
                    long totalSize = appSizeInfo.getTotalSize();
                    j10 += totalSize;
                    C11839m.m70688i("CloudSpaceStateManager", "updateRemoveNotCalculationSize : module = " + str + " , totleSize = " + totalSize);
                    arrayList2.add(str);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        this.f63606i.removeAll(arrayList2);
        C11839m.m70688i("CloudSpaceStateManager", "updateRemoveNotCalculationSize : UpdatetotleSize = " + j10);
        Message messageObtain = Message.obtain();
        messageObtain.what = 33334;
        messageObtain.obj = Long.valueOf(j10);
        CBCallBack.getInstance().sendMessage(messageObtain);
    }

    /* renamed from: b0 */
    public List<AppDetailsInfo> m85423b0() {
        AppDetailsInfo appDetailsInfoM85417Y;
        ArrayList arrayList = new ArrayList();
        C14318k c14318k = this.f63599b;
        if (c14318k != null && (appDetailsInfoM85417Y = m85417Y("thirdAppData", c14318k.m85325b())) != null && !appDetailsInfoM85417Y.getChildList().isEmpty()) {
            arrayList.addAll(appDetailsInfoM85417Y.getChildList());
        }
        return arrayList;
    }

    /* renamed from: c0 */
    public List<AppDetailsInfo> m85424c0() {
        ArrayList arrayList = new ArrayList();
        C14318k c14318k = this.f63599b;
        if (c14318k != null) {
            arrayList.addAll(c14318k.m85325b());
        }
        C11839m.m70688i("CloudSpaceStateManager", "getDetailInfos size: " + arrayList);
        return arrayList;
    }

    /* renamed from: d0 */
    public C14318k m85425d0() {
        return this.f63599b;
    }

    /* renamed from: f0 */
    public final List<String> m85426f0() {
        Boolean bool = C10153d.m63237a().get(this.f63602e);
        return (bool == null || !bool.booleanValue()) ? new ArrayList() : C12176c.m73271n(null);
    }

    /* renamed from: g0 */
    public final List<String> m85427g0() {
        return new ArrayList(C14333b.m85482q());
    }

    /* renamed from: h0 */
    public List<AppDetailsInfo> m85428h0() {
        ArrayList arrayList = new ArrayList();
        C14318k c14318k = this.f63599b;
        if (c14318k != null) {
            arrayList.addAll(c14318k.m85329f());
        }
        C11839m.m70686d("CloudSpaceStateManager", "getTempApps detailsInfo: " + arrayList);
        return arrayList;
    }

    /* renamed from: i0 */
    public final List<String> m85429i0(CopyOnWriteArrayList<AppDetailsInfo> copyOnWriteArrayList, List<String> list) {
        if (AbstractC14026a.m84159a(copyOnWriteArrayList)) {
            return new ArrayList();
        }
        List<String> list2 = (List) copyOnWriteArrayList.stream().filter(new Predicate() { // from class: zk.n
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((AppDetailsInfo) obj).isVirtualApp();
            }
        }).map(new Function() { // from class: zk.o
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((AppDetailsInfo) obj).getBackupAppName();
            }
        }).collect(Collectors.toList());
        list2.removeAll(list);
        return list2;
    }

    /* renamed from: l0 */
    public final void m85430l0(List<String> list) {
        C12590s0.m75730C(list);
    }

    /* renamed from: m0 */
    public void m85431m0(boolean z10, String str, String str2, String str3) {
        C14318k c14318k;
        this.f63608k = str3;
        this.f63604g = z10;
        C11839m.m70686d("CloudSpaceStateManager", "initBackupDeviceCloudSpaceState");
        this.f63602e = str;
        this.f63603f = C11476b.m68626h(str2);
        if (this.f63598a.size() > 0 && !TextUtils.isEmpty(this.f63603f) && (c14318k = this.f63598a.get(this.f63603f)) != null) {
            long jCurrentTimeMillis = System.currentTimeMillis() - c14318k.m85328e();
            if (jCurrentTimeMillis >= 0 && jCurrentTimeMillis <= 3000) {
                this.f63599b = c14318k;
                Message messageObtain = Message.obtain();
                messageObtain.what = 33022;
                messageObtain.arg1 = 0;
                CBCallBack.getInstance().sendMessage(messageObtain);
                m85401Q();
                C11839m.m70686d("CloudSpaceStateManager", "initBackupDeviceCloudSpaceState, user cache data");
                return;
            }
            this.f63598a.remove(this.f63603f);
            C11839m.m70686d("CloudSpaceStateManager", "initBackupDeviceCloudSpaceState,data time out");
        }
        C12515a.m75110o().m75172d(new e(str, this.f63603f));
    }

    /* renamed from: n0 */
    public final List<AppDetailsInfo> m85432n0(List<AppSizeInfo> list, String str) {
        ArrayList arrayList = new ArrayList();
        Boolean bool = C10153d.m63237a().get(str);
        boolean z10 = bool == null || bool.booleanValue();
        for (AppSizeInfo appSizeInfo : list) {
            AppDetailsInfo appDetailsInfo = new AppDetailsInfo();
            appDetailsInfo.setApkType(Integer.valueOf(appSizeInfo.getApkType()));
            appDetailsInfo.setBackupAppName(appSizeInfo.getBackupAppName());
            appDetailsInfo.setProperties(appSizeInfo.getProperties());
            appDetailsInfo.setAttachments(appSizeInfo.getAttachments());
            appDetailsInfo.setTotalSize(appSizeInfo.getTotalSize());
            appDetailsInfo.setAppSize(Long.valueOf(appSizeInfo.getAppSize()));
            appDetailsInfo.setId(appSizeInfo.getId());
            appDetailsInfo.setBackupId(appSizeInfo.getBackupId());
            appDetailsInfo.setExistSplit(appSizeInfo.getExistSplit());
            appDetailsInfo.setOriBackupAppName(appSizeInfo.getOriBackupAppName());
            appDetailsInfo.setSplitApkType(appSizeInfo.getSplitApkType());
            arrayList.add(appDetailsInfo);
            z10 = appSizeInfo.getProperties() != null && z10 && m85436s0(appSizeInfo.getProperties().get("bmAppDataType"));
        }
        if (bool == null) {
            C10153d.m63237a().put(str, Boolean.valueOf(z10));
        }
        return arrayList;
    }

    /* renamed from: o0 */
    public void m85433o0(String str, String str2) {
        C12515a.m75110o().m75172d(new g(str, str2));
    }

    /* renamed from: p0 */
    public final List<AppDetailsInfo> m85434p0(List<App> list) {
        ArrayList arrayList = new ArrayList();
        for (App app : list) {
            AppDetailsInfo appDetailsInfo = new AppDetailsInfo();
            appDetailsInfo.setApkType(app.getApkType());
            appDetailsInfo.setBackupAppName(app.getBackupAppName());
            appDetailsInfo.setProperties(app.getProperties());
            appDetailsInfo.setAttachments(app.getAttachments() == null ? new ArrayList<>() : app.getAttachments());
            long jLongValue = 0;
            appDetailsInfo.setTotalSize(app.getAppTotalSize() == null ? 0L : app.getAppTotalSize().longValue());
            if (app.getAttachmentsSize() != null) {
                jLongValue = app.getAttachmentsSize().longValue();
            }
            appDetailsInfo.setAppSize(Long.valueOf(jLongValue));
            appDetailsInfo.setId(app.getId());
            appDetailsInfo.setRequestStatus(1);
            appDetailsInfo.setBackupId(app.getBackupDeviceId());
            appDetailsInfo.setSplitApkType(app.getSplitApkType());
            appDetailsInfo.setOriBackupAppName(app.getOriBackupAppName());
            arrayList.add(appDetailsInfo);
        }
        return arrayList;
    }

    /* renamed from: q0 */
    public final void m85435q0() {
        if (this.f63605h == null) {
            this.f63605h = new C13998b0();
        }
    }

    /* renamed from: s0 */
    public final boolean m85436s0(String str) {
        if (str == null) {
            return false;
        }
        int iM1686d = C0241z.m1686d(str, 0);
        return iM1686d == 1 || iM1686d == 2;
    }

    /* renamed from: t0 */
    public final boolean m85437t0(String str) {
        Boolean bool;
        if (Boolean.TRUE.equals(C10153d.m63238b().get(str)) || (bool = C10153d.m63237a().get(str)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public C14329v() {
        this.f63598a = new ConcurrentHashMap();
        this.f63599b = null;
        this.f63600c = new ArrayList();
        this.f63601d = new AtomicInteger(0);
        this.f63606i = new ArrayList();
        this.f63607j = new Object();
        this.f63609l = new ArrayList();
    }
}
