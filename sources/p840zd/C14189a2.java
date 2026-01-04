package p840zd;

import com.google.gson.Gson;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupDataManager;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;
import p015ak.C0213f;
import p015ak.C0221j;
import p429kk.C11058a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p617rl.C12526j;
import p618rm.C12565k;
import p618rm.C12590s0;
import p684un.C13225d;
import p711vl.C13465e;
import p848zl.C14333b;

/* renamed from: zd.a2 */
/* loaded from: classes3.dex */
public class C14189a2 extends AbstractC12367d {

    /* renamed from: a */
    public long f63358a;

    /* renamed from: b */
    public long f63359b;

    /* renamed from: c */
    public long f63360c;

    /* renamed from: d */
    public final C14229k2 f63361d = new C14229k2();

    /* renamed from: e */
    public final List<String> f63362e = new ArrayList();

    /* renamed from: f */
    public final Vector<String> f63363f = new Vector<>();

    private void getBackupModuleInfo() throws InterruptedException {
        C11839m.m70688i("TempBackupModuleDataTask", "getBackupModuleInfo enter");
        Vector vector = new Vector();
        this.f63359b = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        C12515a.m75110o().m75172d(new C14261s2(countDownLatch, this.f63362e, this.f63363f, vector));
        C12515a.m75110o().m75172d(new C14277w2(countDownLatch, this.f63363f, vector));
        C12515a.m75110o().m75172d(new C14273v2(countDownLatch, this.f63362e, this.f63363f, vector));
        try {
            C11839m.m70688i("TempBackupModuleDataTask", "await start, countDownLatch: " + countDownLatch.getCount());
            countDownLatch.await();
            C11839m.m70688i("TempBackupModuleDataTask", "await end, countDownLatch: " + countDownLatch.getCount());
        } catch (InterruptedException e10) {
            C11839m.m70687e("TempBackupModuleDataTask", "getBackupModuleInfo interruptedException: " + e10.getMessage());
        }
        this.f63360c = System.currentTimeMillis();
        m85060f();
        CloudBackupReport.reportSwitchBeans(vector, C11058a.m66627b(null), false, true);
        calculate();
        C11839m.m70688i("TempBackupModuleDataTask", "getBackupModuleInfo exit");
    }

    private void initSupportPmsMove() {
        C11839m.m70688i("TempBackupModuleDataTask", "initPmsMoveOrderSupported start.");
        try {
            C12565k.m75529o();
        } catch (Exception e10) {
            C11839m.m70687e("TempBackupModuleDataTask", "error: " + e10.getMessage());
        }
        C11839m.m70688i("TempBackupModuleDataTask", "initPmsMoveOrderSupported end.");
    }

    private void reportCloneTaskException(Exception exc) {
        String strM66627b = C11058a.m66627b("02013");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("traceID", strM66627b);
        linkedHashMap.put(VastAttribute.ERROR, exc.getMessage());
        linkedHashMap.put("stack", C12590s0.m75731C0(exc));
        linkedHashMap.put("backupType", "tempBackup");
        C13225d.m79490f1().m79567R("cloudbackup_option_module_status_exception", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "cloudbackup_option_module_status_exception", linkedHashMap);
    }

    public final void calculate() {
        List<BackupOptionItem> listM78397u = this.f63361d.m78397u();
        ArrayList arrayList = new ArrayList();
        if (listM78397u != null && !listM78397u.isEmpty()) {
            long j10 = 0;
            long j11 = 0;
            long j12 = 0;
            for (BackupOptionItem backupOptionItem : listM78397u) {
                if (backupOptionItem.is3rdAppTwin() && !backupOptionItem.isModuleSplitExist()) {
                    arrayList.add(backupOptionItem);
                } else if (!HNConstants.DataType.MEDIA.equals(backupOptionItem.getAppId()) || ICBUtil.isSupportGallery(C0213f.m1377a())) {
                    long totalIncrease = backupOptionItem.getTotalIncrease();
                    String parent = backupOptionItem.getParent();
                    if ("thirdAppData".equals(parent)) {
                        j11 += totalIncrease;
                    } else if ("virtualApp".equals(parent)) {
                        j12 += totalIncrease;
                    } else {
                        j10 += totalIncrease;
                    }
                }
            }
            C11839m.m70688i("TempBackupModuleDataTask", "increaseSys = " + j10 + ", increase3rd = " + j11 + ", increaseVir = " + j12);
            reportGetDataTimeAndSize(j10, j11, j12);
        }
        if (!arrayList.isEmpty()) {
            this.f63361d.m78388i(arrayList);
            arrayList.forEach(new Consumer() { // from class: zd.z1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f63512a.m85059e((BackupOptionItem) obj);
                }
            });
        }
        C13465e.m81052f().m81072u(System.currentTimeMillis());
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C11839m.m70688i("TempBackupModuleDataTask", "TempBackupModuleDataTask start");
        try {
            try {
                this.f63358a = System.currentTimeMillis();
                initSupportPmsMove();
                C0221j.m1509s(C0213f.m1377a());
                m85058d();
                this.f63361d.m78387h(this.f63362e);
                this.f63361d.m78387h(C12590s0.m75727B0());
                getBackupModuleInfo();
            } catch (Exception e10) {
                C11839m.m70687e("TempBackupModuleDataTask", "TempBackupModuleDataTask error : " + e10.getMessage());
                reportCloneTaskException(e10);
            }
        } finally {
            C11839m.m70688i("TempBackupModuleDataTask", "TempBackupModuleDataTask end");
            TempBackupDataManager.m24501i().m24512p(null);
        }
    }

    /* renamed from: d */
    public final void m85058d() {
        C11839m.m70688i("TempBackupModuleDataTask", "initBlackList enter");
        this.f63362e.addAll(C2157a.m13200h());
        this.f63362e.addAll(new C12526j().m75386e());
        this.f63362e.addAll(C14333b.m85454J());
        C11839m.m70688i("TempBackupModuleDataTask", "initBlackList exit: " + Arrays.toString(this.f63362e.toArray()));
    }

    /* renamed from: e */
    public final /* synthetic */ void m85059e(BackupOptionItem backupOptionItem) {
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(backupOptionItem.getAppId(), this.f63361d);
        if (backupOptionItemQueryItem != null) {
            TempBackupDataManager.m24501i().m24504f(backupOptionItemQueryItem);
        }
    }

    /* renamed from: f */
    public final void m85060f() {
        String str;
        int i10;
        int size = this.f63363f.size();
        int i11 = (size / 50) + (size % 50 == 0 ? 0 : 1);
        C11839m.m70686d("TempBackupModuleDataTask", String.format(Locale.ENGLISH, "report appIds are： %s, total report batch times is: %s", new Gson().toJson(this.f63363f), Integer.valueOf(i11)));
        for (int i12 = 0; i12 < size; i12 += 50) {
            int i13 = (i12 / 50) + 1;
            if (i13 == 1 && i13 != i11) {
                i10 = i12 + 50;
                str = "start";
            } else if (i13 <= 1 || i13 >= i11) {
                str = "end";
                i10 = size;
            } else {
                i10 = i12 + 50;
                str = "ing";
            }
            reportOneStage(str, this.f63363f.subList(i12, i10));
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.OPTIONS_SIZE_TASK;
    }

    public final void reportGetDataTimeAndSize(long j10, long j11, long j12) {
        String strM66627b = C11058a.m66627b("02013");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("traceID", strM66627b);
        linkedHashMap.put(FrequencyManager.H5DialogConstant.BEGIN_TIME, String.valueOf(this.f63358a));
        linkedHashMap.put("endTime", String.valueOf(System.currentTimeMillis()));
        linkedHashMap.put("cloneBeginTime", String.valueOf(this.f63359b));
        linkedHashMap.put("cloneEndTime", String.valueOf(this.f63360c));
        linkedHashMap.put("thirdBeginTime", "getThirdAppDataStart");
        linkedHashMap.put("thirdEndTime", "getThirdAppDataEnd");
        linkedHashMap.put("dataSize", String.valueOf(j10 + j11 + j12));
        linkedHashMap.put("sysDataSize", String.valueOf(j10));
        linkedHashMap.put("thirdDataSize", String.valueOf(j11));
        linkedHashMap.put("virtualDataSize", String.valueOf(j12));
        linkedHashMap.put("backupType", "tempBackup");
        C13225d.m79490f1().m79567R("cloudbackup_option_get_data_period", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "cloudbackup_option_get_data_period", linkedHashMap);
    }

    public final void reportOneStage(String str, List<String> list) {
        String strM66627b = C11058a.m66627b("02013");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("traceID", strM66627b);
        linkedHashMap.put("backupType", "tempBackup");
        linkedHashMap.put("batchFlag", str);
        linkedHashMap.put("app", new Gson().toJson(list).replaceAll("[\\[\\]\"]", ""));
        C13225d.m79490f1().m79567R("backupTransactionPrepare", linkedHashMap);
        UBAAnalyze.m29947H("PVC", "backupTransactionPrepare", linkedHashMap);
    }
}
