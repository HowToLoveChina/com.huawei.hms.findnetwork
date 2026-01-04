package com.huawei.android.hicloud.cloudbackup.util;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.bean.BackupStateProviderReqPara;
import com.huawei.android.hicloud.cloudbackup.bean.BackupTimeWindowBean;
import com.huawei.android.hicloud.cloudbackup.bean.RefurbishRestoreFailInfo;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupStateUtil;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Device;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import com.huawei.hicloud.request.notify.constant.NotifyErr;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import fk.C9721b;
import gp.C10028c;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mk.C11476b;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p292fn.C9733f;
import p429kk.C11058a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p617rl.C12526j;
import p618rm.C12590s0;
import p618rm.C12591s1;
import p709vj.C13452e;
import p711vl.C13466f;
import p711vl.C13467g;
import p814yl.C13998b0;
import p815ym.AbstractC14026a;
import tl.C13027f;
import tl.C13028g;
import tl.C13029h;
import tl.C13030i;
import tl.C13032k;
import tl.C13033l;
import tl.C13034m;

/* loaded from: classes2.dex */
public class CloudBackupStateUtil {
    public static final int BACKUP_STATE_DELETED = -1;
    private static final int BACKUP_STATE_FINSH = 1;
    public static final int BACKUP_STATE_PAUSE = 3;
    public static final int BACKUP_STATE_PROCESS = 2;
    public static final int BACKUP_STATE_PULL = 0;
    public static final int CLOUD_BACKUP_ING = 1;
    public static final int CLOUD_RESTORE_ING = 2;
    public static final int COMMON_BAK_TYPE = 3;
    public static final int DEFAULT_TIMEOUT = 60;
    public static final int NO_BACKUP_RESTORE_ING = 0;
    public static final int OH_BAK_TYPE = 4;
    public static final int REFURBISH_BACKUP_ING = 3;
    public static final int REFURBISH_PREPARE_ING = 0;
    public static final int REFURBISH_RESTORE_ING = 4;
    public static final int REFURBISH_TASK_ING = 1;
    public static final int RESTORE_STATE_CANCEL = -2;
    public static final int RESTORE_STATE_FAIL = -1;
    public static final int RESTORE_STATE_PAUSE = 2;
    public static final int RESTORE_STATE_PROCESS = 0;
    public static final int RESTORE_STATE_SUCCESS = 1;
    private static final String TAG = "CloudBackupStateUtil";
    private static CloudBackupStateUtil instance;
    private GetBackupInfoProviderTask task = null;

    public static class GetBackupInfoProviderTask extends AbstractC12367d {
        private final CompletableFuture<MatrixCursor> completableFuture = new CompletableFuture<>();
        private final BackupStateProviderReqPara reqPara;

        public GetBackupInfoProviderTask(BackupStateProviderReqPara backupStateProviderReqPara) {
            this.reqPara = backupStateProviderReqPara;
        }

        private int getBackupVersion(Bak bak) {
            return "V4".equals(bak.getBackupVersion()) ? 4 : 3;
        }

        private long getTimeValue(C4644l c4644l) {
            if (c4644l == null) {
                return 0L;
            }
            return c4644l.m28458c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$call$0(Device device) {
            return TextUtils.equals(device.getDevicePathName(), C11476b.m68626h(C13452e.m80781L().m80950o()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$call$1(Bak bak) {
            return this.reqPara.getCategory().contains(bak.getBakCategory());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$call$2(Bak bak) {
            return this.reqPara.getBackupVersion().contains(Integer.valueOf(getBackupVersion(bak)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$call$3(Bak bak) {
            Integer num = 0;
            if (!num.equals(bak.getBackupStatus())) {
                Integer num2 = 1;
                if (!num2.equals(bak.getBackupStatus())) {
                    return false;
                }
            }
            return true;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            String backupDeviceId;
            C11839m.m70688i(CloudBackupStateUtil.TAG, "GetBackupInfoProviderTask start: " + this.reqPara);
            MatrixCursor initCursor = CloudBackupStateUtil.getInitCursor();
            if (this.reqPara == null) {
                C11839m.m70687e(CloudBackupStateUtil.TAG, "GetBackupInfoTask reqPara is null");
                CloudBackupStateUtil.endResultSet(initCursor, this.completableFuture, 4);
                return;
            }
            C13998b0 c13998b0 = new C13998b0();
            String strM66627b = C11058a.m66627b("02102");
            boolean zContains = this.reqPara.getCategory().contains(Integer.valueOf(C0241z.m1685c("2")));
            boolean zContains2 = this.reqPara.getCategory().contains(Integer.valueOf(C0241z.m1685c("3")));
            boolean zContains3 = this.reqPara.getBackupVersion().contains(4);
            try {
                backupDeviceId = c13998b0.m84137z(CloudBackupConstant.BACKUP_DEVICE_ID, strM66627b).getBackupDeviceId();
            } catch (C9721b e10) {
                C11839m.m70687e(CloudBackupStateUtil.TAG, "request backupDeviceId error: " + e10.getMessage());
                backupDeviceId = null;
            }
            try {
                List<Device> listM84132c0 = c13998b0.m84132c0("nextCursor,devices", strM66627b, zContains, zContains2, zContains3, true, backupDeviceId, true, false);
                ArrayList arrayList = new ArrayList();
                C13029h c13029hBuildBackupInfoFromLocal = CloudBackupStateUtil.buildBackupInfoFromLocal(arrayList);
                if (AbstractC14026a.m84159a(listM84132c0)) {
                    C11839m.m70688i(CloudBackupStateUtil.TAG, "devices is empty");
                } else {
                    Device deviceOrElse = listM84132c0.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.util.o
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return CloudBackupStateUtil.GetBackupInfoProviderTask.lambda$call$0((Device) obj);
                        }
                    }).findFirst().orElse(null);
                    if (deviceOrElse == null || AbstractC14026a.m84159a(deviceOrElse.getBaks())) {
                        C11839m.m70688i(CloudBackupStateUtil.TAG, "currentDevice bak is empty");
                    } else {
                        arrayList.addAll(deviceOrElse.getBaks());
                    }
                }
                List<Bak> list = (List) arrayList.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.util.p
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return this.f11803a.lambda$call$1((Bak) obj);
                    }
                }).filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.util.q
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return this.f11804a.lambda$call$2((Bak) obj);
                    }
                }).filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.util.r
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return CloudBackupStateUtil.GetBackupInfoProviderTask.lambda$call$3((Bak) obj);
                    }
                }).collect(Collectors.toList());
                if (AbstractC14026a.m84159a(list)) {
                    C11839m.m70688i(CloudBackupStateUtil.TAG, "baks is empty");
                    CloudBackupStateUtil.endResultSet(initCursor, this.completableFuture, 0);
                    return;
                }
                boolean zInBackup = CBAccess.inBackup();
                for (Bak bak : list) {
                    Integer backupStatus = bak.getBackupStatus();
                    Integer num = 0;
                    if (num.equals(backupStatus)) {
                        initCursor.addRow(new Object[]{0, bak.getId(), bak.getBakCategory(), 1, Long.valueOf(getTimeValue(bak.getStartTime())), Long.valueOf(getTimeValue(bak.getEndTime())), Integer.valueOf(getBackupVersion(bak)), Long.valueOf(bak.getTotalSize()), 0});
                    }
                    Integer num2 = 1;
                    if (num2.equals(backupStatus) && c13029hBuildBackupInfoFromLocal != null) {
                        if (TextUtils.equals(bak.getId(), c13029hBuildBackupInfoFromLocal.m78465h())) {
                            boolean zIsTempBackup = bak.isTempBackup();
                            if (!zIsTempBackup || CBAccess.hasValidTempBackup()) {
                                int i10 = zInBackup ? 2 : 3;
                                C13033l c13033l = new C13033l();
                                if (zIsTempBackup) {
                                    c13033l = new C13034m();
                                }
                                initCursor.addRow(new Object[]{0, bak.getId(), bak.getBakCategory(), Integer.valueOf(i10), Long.valueOf(getTimeValue(bak.getStartTime())), Long.valueOf(getTimeValue(bak.getEndTime())), Integer.valueOf(getBackupVersion(bak)), 0, Integer.valueOf(c13033l.m78546d(1) != null ? (int) Math.floor(r8.m78529m()) : 0)});
                            } else {
                                C11839m.m70688i(CloudBackupStateUtil.TAG, "local temp backup invalid: " + c13029hBuildBackupInfoFromLocal.m78465h() + " ,cloud: " + bak.getId());
                            }
                        } else {
                            C11839m.m70688i(CloudBackupStateUtil.TAG, "backupId not match local: " + c13029hBuildBackupInfoFromLocal.m78465h() + " ,cloud: " + bak.getId());
                        }
                    }
                }
                C11839m.m70688i(CloudBackupStateUtil.TAG, "GetBackupInfoProviderTask success: " + initCursor.getCount());
                this.completableFuture.complete(initCursor);
            } catch (C9721b e11) {
                C11839m.m70687e(CloudBackupStateUtil.TAG, "GetBackupInfoTask error: " + e11.getMessage());
                CloudBackupStateUtil.endResultSet(initCursor, this.completableFuture, 5);
            }
        }

        public CompletableFuture<MatrixCursor> getCompletableFuture() {
            return this.completableFuture;
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.BACKUP_STATE_INFO_QUERY_PROVIDER;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C13029h buildBackupInfoFromLocal(List<Bak> list) throws C9721b {
        String str;
        C13030i c13030i = new C13030i();
        C13029h c13029hM78495f = c13030i.m78495f(4);
        if (c13029hM78495f == null) {
            c13029hM78495f = c13030i.m78495f(5);
            if (c13029hM78495f == null) {
                c13029hM78495f = c13030i.m78495f(2);
                str = "1";
                if (c13029hM78495f == null) {
                    c13029hM78495f = c13030i.m78495f(1);
                }
            } else {
                str = "3";
            }
        } else {
            str = "2";
        }
        if (c13029hM78495f == null) {
            C11839m.m70688i(TAG, "backupTags is null");
        } else if ("empty_default_id".equals(c13029hM78495f.m78465h())) {
            Bak bak = new Bak();
            bak.setStartTime(new C4644l(c13029hM78495f.m78440F()));
            bak.setId(c13029hM78495f.m78465h());
            bak.setBackupStatus(1);
            bak.setBackupVersion(CBSBaseReq.CURRENT_API_VERSION);
            bak.setBakCategory(Integer.valueOf(C0241z.m1685c(str)));
            list.add(bak);
        }
        return c13029hM78495f;
    }

    public static boolean checkBroadcastId(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i(TAG, "checkBroadcastId backId is null.");
            return false;
        }
        C13466f c13466fM81073d = C13466f.m81073d();
        String strM81079g = i10 == 1 ? c13466fM81073d.m81079g("broadcast_backupId", "") : c13466fM81073d.m81079g("broadcast_restoreId", "");
        if (!TextUtils.isEmpty(strM81079g) && strM81079g.equals(str)) {
            return true;
        }
        C11839m.m70688i(TAG, "checkBroadcastId，backId is null.");
        return false;
    }

    private Cursor dealBackupNoIdOrDefaultId(C13032k c13032k, int i10, boolean z10) {
        if (c13032k == null) {
            C11839m.m70688i(TAG, "deal default backup task, current state is null.");
            return null;
        }
        MatrixCursor matrixCursorInitBackupCursor = initBackupCursor();
        boolean zM81075b = C13466f.m81073d().m81075b("myHuawei_start_backup_task", false);
        String strM78518b = c13032k.m78518b();
        C11839m.m70688i(TAG, "deal default backup task, backupId: " + strM78518b + ", isStartTask: " + zM81075b + ", inBackup: " + z10);
        if ((TextUtils.isEmpty(strM78518b) || "empty_default_id".equals(strM78518b)) && zM81075b && !z10) {
            C11839m.m70688i(TAG, "deal default backup task, no task return null.");
            return null;
        }
        int cloudBackupStateItemState = getCloudBackupStateItemState(c13032k, true);
        int iM78528l = c13032k.m78528l();
        C11839m.m70688i(TAG, "deal default backupStatus: " + cloudBackupStateItemState + ", backupState: " + i10 + ", progress: " + iM78528l);
        matrixCursorInitBackupCursor.addRow(new Object[]{c13032k.m78518b(), Integer.valueOf(cloudBackupStateItemState), Long.valueOf(c13032k.m78531o()), Long.valueOf(c13032k.m78526j()), Integer.valueOf(i10), Integer.valueOf(iM78528l)});
        return matrixCursorInitBackupCursor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void endResultSet(final MatrixCursor matrixCursor, CompletableFuture<MatrixCursor> completableFuture, int i10) {
        matrixCursor.addRow(new Object[]{Integer.valueOf(i10), null, null, null, null, null, null, null, null});
        Optional.ofNullable(completableFuture).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.util.l
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((CompletableFuture) obj).complete(matrixCursor);
            }
        });
    }

    private static int getBackupRecordInfosState(C13028g c13028g, boolean z10) {
        int iM78414c = c13028g.m78414c();
        int i10 = 1;
        if (z10) {
            i10 = iM78414c == 1 ? 1 : 3;
        } else if (iM78414c != 1) {
            i10 = iM78414c != 3 ? -1 : -2;
        }
        C11839m.m70688i(TAG, "getBackupRecordInfosState state: " + iM78414c + " isBackup: " + z10 + " result: " + i10);
        return i10;
    }

    public static String getBroadcastId(int i10) {
        C13466f c13466fM81073d = C13466f.m81073d();
        return i10 == 1 ? c13466fM81073d.m81079g("broadcast_backupId", "") : c13466fM81073d.m81079g("broadcast_restoreId", "");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0061 A[PHI: r6
  0x0061: PHI (r6v2 int) = (r6v1 int), (r6v1 int), (r6v0 int) binds: [B:33:0x0079, B:34:0x007b, B:19:0x005f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int getCloudBackupStateItemState(tl.C13032k r9, boolean r10) {
        /*
            int r0 = r9.m78532p()
            java.lang.String r1 = ", response: "
            java.lang.String r2 = "CloudBackupStateUtil"
            r3 = 2
            r4 = 1
            r5 = 3
            if (r10 == 0) goto L43
            boolean r9 = com.huawei.android.hicloud.cloudbackup.process.CBAccess.inBackup()
            boolean r10 = p848zl.C14342k.m85520a(r0)
            if (r10 == 0) goto L1a
            if (r9 == 0) goto L1a
            goto L1f
        L1a:
            if (r0 != r5) goto L1e
            r3 = r4
            goto L1f
        L1e:
            r3 = r5
        L1f:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r4 = "getCloudBackupStateItemState backup state: "
            r10.append(r4)
            r10.append(r0)
            java.lang.String r0 = ", hasBackTaskTask: "
            r10.append(r0)
            r10.append(r9)
            r10.append(r1)
            r10.append(r3)
            java.lang.String r9 = r10.toString()
            p514o9.C11839m.m70686d(r2, r9)
            goto La8
        L43:
            int r9 = r9.m78530n()
            vj.e r10 = p709vj.C13452e.m80781L()
            int r10 = r10.m80916g0()
            r6 = 0
            if (r10 != r5) goto L54
            r7 = r4
            goto L55
        L54:
            r7 = r6
        L55:
            boolean r8 = p848zl.C14342k.m85520a(r0)
            if (r8 == 0) goto L63
            boolean r4 = com.huawei.android.hicloud.cloudbackup.process.CBAccess.inRestore()
            if (r4 == 0) goto L7e
        L61:
            r3 = r6
            goto L7e
        L63:
            r6 = -1
            if (r0 != r5) goto L6c
            if (r7 == 0) goto L69
            goto L6a
        L69:
            r4 = r6
        L6a:
            r3 = r4
            goto L7e
        L6c:
            r5 = 1001(0x3e9, float:1.403E-42)
            if (r9 != r5) goto L72
            r3 = -2
            goto L7e
        L72:
            boolean r5 = isRestorePause(r9)
            if (r5 == 0) goto L79
            goto L7e
        L79:
            if (r9 != 0) goto L61
            if (r7 == 0) goto L61
            goto L6a
        L7e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "getCloudBackupStateItemState return code: "
            r4.append(r5)
            r4.append(r9)
            java.lang.String r9 = ", restore status: "
            r4.append(r9)
            r4.append(r10)
            java.lang.String r9 = ", restore state: "
            r4.append(r9)
            r4.append(r0)
            r4.append(r1)
            r4.append(r3)
            java.lang.String r9 = r4.toString()
            p514o9.C11839m.m70688i(r2, r9)
        La8:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.util.CloudBackupStateUtil.getCloudBackupStateItemState(tl.k, boolean):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MatrixCursor getInitCursor() {
        return new MatrixCursor(new String[]{MapKeyNames.RESULT_CODE, "backupId", Constants.AUTOCONTENT_CATEGORY, "backupStatus", "backupStartTime", "backupEndTime", "backupVersion", "backupSize", VastAttribute.PROGRESS});
    }

    public static synchronized CloudBackupStateUtil getInstance() {
        try {
            if (instance == null) {
                instance = new CloudBackupStateUtil();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return instance;
    }

    private String[] getRestoreFailList(String str, int i10) {
        String[] strArr = new String[0];
        if (TextUtils.isEmpty(str)) {
            return strArr;
        }
        if (i10 != -1 && i10 != 1) {
            return strArr;
        }
        RefurbishRestoreFailInfo refurbishRestoreFailInfoM75862i2 = C12590s0.m75862i2();
        return !TextUtils.equals(str, refurbishRestoreFailInfoM75862i2.getBackupId()) ? strArr : refurbishRestoreFailInfoM75862i2.getFailList();
    }

    private MatrixCursor getRestoreState(String str, int i10, long j10, long j11) {
        MatrixCursor matrixCursorInitRestoreCursor;
        if (i10 == -1 || i10 == 1) {
            String[] restoreFailList = getRestoreFailList(str, i10);
            C11839m.m70688i(TAG, "getRestoreState state , moduleFailList = " + restoreFailList.length);
            if (restoreFailList.length > 0) {
                matrixCursorInitRestoreCursor = initRestoreFailCursor();
                matrixCursorInitRestoreCursor.addRow(new Object[]{str, Integer.valueOf(i10), Long.valueOf(j10), Long.valueOf(j11), 1, Integer.valueOf(restoreFailList.length)});
            } else {
                matrixCursorInitRestoreCursor = initRestoreCursor();
                matrixCursorInitRestoreCursor.addRow(new Object[]{str, Integer.valueOf(i10), Long.valueOf(j10), Long.valueOf(j11), 1});
            }
        } else {
            matrixCursorInitRestoreCursor = initRestoreCursor();
            matrixCursorInitRestoreCursor.addRow(new Object[]{str, Integer.valueOf(i10), Long.valueOf(j10), Long.valueOf(j11), 1});
        }
        C11839m.m70688i(TAG, "getRestoreState state = " + i10);
        return matrixCursorInitRestoreCursor;
    }

    private MatrixCursor initBackupCursor() {
        return new MatrixCursor(new String[]{"backupId", "backupStatus", "backupStartTime", "backupSuccessTime", "backupState", VastAttribute.PROGRESS});
    }

    private MatrixCursor initRestoreCursor() {
        return new MatrixCursor(new String[]{"restoreId", "restoreStatus", "restoreStartTime", "restoreSuccessTime", "restoreState"});
    }

    private MatrixCursor initRestoreFailCursor() {
        return new MatrixCursor(new String[]{"restoreId", "restoreStatus", "restoreStartTime", "restoreSuccessTime", "restoreState", "failAppList"});
    }

    public static boolean isFromSystemRetreadTask(int i10, String str) {
        return C10028c.m62182c0().m62325f1() || checkBroadcastId(i10, str);
    }

    private static boolean isRestorePause(int i10) {
        if (i10 == 1002 || i10 == 3900) {
            return true;
        }
        switch (i10) {
            case 1104:
            case 1105:
            case 1106:
            case NotifyErr.NET_DISABLE_HMS_ERROR /* 1107 */:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$queryBackupInfo$0(Integer num) {
        return (TextUtils.equals(String.valueOf(num), "1") || TextUtils.equals(String.valueOf(num), "2") || TextUtils.equals(String.valueOf(num), "3")) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$queryBackupInfo$1(Integer num) {
        return (num.intValue() == 4 || num.intValue() == 3) ? false : true;
    }

    private Cursor queryCurrentBackupState(String str) {
        C11839m.m70688i(TAG, "queryCurrentBackupState start.");
        MatrixCursor matrixCursorInitBackupCursor = initBackupCursor();
        try {
            C13032k c13032kM78546d = new C13033l().m78546d(1);
            if (c13032kM78546d == null) {
                C11839m.m70688i(TAG, "queryCurrentBackupState currentState is null");
                return null;
            }
            int cloudBackupStateItemState = getCloudBackupStateItemState(c13032kM78546d, true);
            if (!TextUtils.isEmpty(c13032kM78546d.m78518b())) {
                str = c13032kM78546d.m78518b();
            }
            matrixCursorInitBackupCursor.addRow(new Object[]{str, Integer.valueOf(cloudBackupStateItemState), Long.valueOf(c13032kM78546d.m78531o()), Long.valueOf(c13032kM78546d.m78526j()), 1, Integer.valueOf(c13032kM78546d.m78528l())});
            return matrixCursorInitBackupCursor;
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "queryCurrentBackupState query error: " + e10.toString());
            return null;
        }
    }

    private Cursor queryCurrentRestoreState(String str) {
        long jM78421j;
        int i10;
        long jCurrentTimeMillis;
        String strM78518b = str;
        C11839m.m70688i(TAG, "queryCurrentRestoreState start.");
        MatrixCursor matrixCursorInitRestoreCursor = initRestoreCursor();
        try {
            C13032k c13032kM78546d = new C13033l().m78546d(2);
            if (c13032kM78546d != null) {
                int cloudBackupStateItemState = getCloudBackupStateItemState(c13032kM78546d, false);
                if (!TextUtils.isEmpty(c13032kM78546d.m78518b())) {
                    strM78518b = c13032kM78546d.m78518b();
                }
                matrixCursorInitRestoreCursor.addRow(new Object[]{strM78518b, Integer.valueOf(cloudBackupStateItemState), Long.valueOf(c13032kM78546d.m78531o()), Long.valueOf(c13032kM78546d.m78526j()), 1});
                return matrixCursorInitRestoreCursor;
            }
            C11839m.m70688i(TAG, "queryCurrentRestoreState currentState is null");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C13028g c13028gM78408f = new C13027f().m78408f(strM78518b);
            if (c13028gM78408f == null) {
                int iM80916g0 = C13452e.m80781L().m80916g0();
                i10 = 3 == iM80916g0 ? 1 : 8 == iM80916g0 ? -2 : -1;
                jCurrentTimeMillis = System.currentTimeMillis();
                C11839m.m70688i(TAG, "queryRestoreState restoreId no record, state: " + i10);
                jM78421j = 0;
            } else {
                int backupRecordInfosState = getBackupRecordInfosState(c13028gM78408f, false);
                jM78421j = c13028gM78408f.m78421j();
                long jM78419h = c13028gM78408f.m78419h();
                C11839m.m70688i(TAG, "queryRestoreState restoreId has record, state: " + backupRecordInfosState);
                i10 = backupRecordInfosState;
                jCurrentTimeMillis = jM78419h;
            }
            matrixCursorInitRestoreCursor.addRow(new Object[]{strM78518b, Integer.valueOf(i10), Long.valueOf(jM78421j), Long.valueOf(jCurrentTimeMillis), 1});
            return matrixCursorInitRestoreCursor;
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "queryCurrentRestoreState error:" + e10.toString());
            return null;
        }
    }

    public static void recordBroadcastBackupId(int i10, String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i(TAG, "recordBroadCastBackupId backupId is null");
        } else if (z10) {
            if (i10 == 1) {
                C13466f.m81073d().m81084l("broadcast_backupId", str);
            } else {
                C13466f.m81073d().m81084l("broadcast_restoreId", str);
            }
        }
    }

    public Cursor getTimeWindowConfig() {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{CloudBackupConstant.TimeWindowConstant.KEY_TIMING_INTERVAL, CloudBackupConstant.TimeWindowConstant.KEY_PERIOD_RANDOM_FACTOR, CloudBackupConstant.TimeWindowConstant.STAND_ALONE_TASK});
        BackupTimeWindowBean backupTimeWindowBeanM75421u = new C12526j().m75421u();
        matrixCursor.addRow(new Object[]{Integer.valueOf(backupTimeWindowBeanM75421u.getTimingInterval()), Integer.valueOf(backupTimeWindowBeanM75421u.getPeriodRandomFactor()), Integer.valueOf(backupTimeWindowBeanM75421u.getStandAloneTask())});
        return matrixCursor;
    }

    public Cursor queryBackupInfo(String[] strArr, Context context) {
        MatrixCursor initCursor = getInitCursor();
        C11839m.m70688i(TAG, "queryBackupInfo start");
        if (!C0209d.m1333z1(context)) {
            C11839m.m70687e(TAG, "network not Connected");
            endResultSet(initCursor, null, 1);
            return initCursor;
        }
        boolean zM80842P0 = C13452e.m80781L().m80842P0();
        if (!zM80842P0) {
            C11839m.m70687e(TAG, "isHiCloudLogin :" + zM80842P0);
            endResultSet(initCursor, null, 2);
            return initCursor;
        }
        if (strArr == null || strArr.length == 0) {
            C11839m.m70687e(TAG, "selectionArgs is empty ");
            endResultSet(initCursor, null, 4);
            return initCursor;
        }
        try {
            BackupStateProviderReqPara backupStateProviderReqPara = (BackupStateProviderReqPara) new Gson().fromJson(strArr[0], BackupStateProviderReqPara.class);
            List<Integer> category = backupStateProviderReqPara.getCategory();
            if (AbstractC14026a.m84159a(category)) {
                C11839m.m70687e(TAG, "category is empty ");
                endResultSet(initCursor, null, 4);
                return initCursor;
            }
            if (category.stream().anyMatch(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.util.m
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CloudBackupStateUtil.lambda$queryBackupInfo$0((Integer) obj);
                }
            })) {
                C11839m.m70687e(TAG, "categoryIllegal");
                endResultSet(initCursor, null, 4);
                return initCursor;
            }
            List<Integer> backupVersion = backupStateProviderReqPara.getBackupVersion();
            int i10 = 3;
            if (AbstractC14026a.m84159a(backupVersion)) {
                ArrayList arrayList = new ArrayList();
                C11839m.m70688i(TAG, "backupVersion use default");
                arrayList.add(4);
                arrayList.add(3);
                backupStateProviderReqPara.setBackupVersion(arrayList);
            } else if (backupVersion.stream().anyMatch(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.util.n
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CloudBackupStateUtil.lambda$queryBackupInfo$1((Integer) obj);
                }
            })) {
                C11839m.m70687e(TAG, "backupVersionIllegal");
                endResultSet(initCursor, null, 4);
                return initCursor;
            }
            Integer timeOut = backupStateProviderReqPara.getTimeOut();
            if (timeOut == null || timeOut.intValue() <= 0) {
                backupStateProviderReqPara.setTimeOut(60);
            }
            this.task = new GetBackupInfoProviderTask(backupStateProviderReqPara);
            C12515a.m75110o().m75175e(this.task, false);
            try {
                return this.task.getCompletableFuture().get(backupStateProviderReqPara.getTimeOut().intValue(), TimeUnit.SECONDS);
            } catch (TimeoutException unused) {
                C11839m.m70689w(TAG, "GetBackupInfoTask timeout");
                endResultSet(initCursor, null, i10);
                C11839m.m70688i(TAG, "GetBackupInfoTask success: " + initCursor.getCount());
                return initCursor;
            } catch (Exception e10) {
                C11839m.m70689w(TAG, "GetBackupInfoTask error: " + e10.getMessage());
                i10 = 5;
                endResultSet(initCursor, null, i10);
                C11839m.m70688i(TAG, "GetBackupInfoTask success: " + initCursor.getCount());
                return initCursor;
            }
        } catch (Exception e11) {
            C11839m.m70687e(TAG, "queryBackupInfo error: " + e11.getMessage());
            endResultSet(initCursor, null, 4);
            return initCursor;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035 A[Catch: all -> 0x0040, Exception -> 0x0044, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0040, blocks: (B:12:0x0035, B:20:0x0047, B:23:0x004e, B:24:0x0090, B:27:0x00cb, B:29:0x00e7, B:35:0x00f9), top: B:43:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0047 A[Catch: all -> 0x0040, Exception -> 0x0044, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0040, blocks: (B:12:0x0035, B:20:0x0047, B:23:0x004e, B:24:0x0090, B:27:0x00cb, B:29:0x00e7, B:35:0x00f9), top: B:43:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011a  */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.os.Bundle queryBackupRestoreState(int r17, java.lang.String r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.util.CloudBackupStateUtil.queryBackupRestoreState(int, java.lang.String):android.os.Bundle");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.database.Cursor queryBackupState(java.lang.String[] r18) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.util.CloudBackupStateUtil.queryBackupState(java.lang.String[]):android.database.Cursor");
    }

    public Cursor queryRestoreId() {
        String strM81079g = C13466f.m81073d().m81079g("refurbishRestoreId", "");
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"restoreId"});
        C11839m.m70688i(TAG, "queryRestoreId:" + strM81079g);
        matrixCursor.addRow(new Object[]{strM81079g});
        return matrixCursor;
    }

    public Cursor queryRestoreState(String[] strArr) {
        C11839m.m70688i(TAG, "query restore state.");
        try {
            C13032k c13032kM78546d = new C13033l().m78546d(2);
            if (strArr != null && strArr.length != 0 && !TextUtils.isEmpty(strArr[0])) {
                String str = strArr[0];
                if (c13032kM78546d != null) {
                    if (TextUtils.isEmpty(c13032kM78546d.m78518b()) && CBAccess.isMyhuaweiPullRestoreTask()) {
                        C11839m.m70688i(TAG, "queryRestoreState selectionArgs is null");
                        return getRestoreState(str, getCloudBackupStateItemState(c13032kM78546d, false), c13032kM78546d.m78531o(), c13032kM78546d.m78526j());
                    }
                    if (TextUtils.equals(str, c13032kM78546d.m78518b())) {
                        return getRestoreState(c13032kM78546d.m78518b(), getCloudBackupStateItemState(c13032kM78546d, false), c13032kM78546d.m78531o(), c13032kM78546d.m78526j());
                    }
                }
                C13028g c13028gM78408f = new C13027f().m78408f(str);
                if (c13028gM78408f == null) {
                    C11839m.m70688i(TAG, "queryRestoreState restoreId no record");
                    return null;
                }
                int backupRecordInfosState = getBackupRecordInfosState(c13028gM78408f, false);
                C11839m.m70688i(TAG, "query restore finish,curState is:" + backupRecordInfosState);
                return getRestoreState(c13028gM78408f.m78413b(), backupRecordInfosState, c13028gM78408f.m78421j(), c13028gM78408f.m78419h());
            }
            if (c13032kM78546d == null) {
                C11839m.m70688i(TAG, "queryRestoreState currentState is null");
                return null;
            }
            if (TextUtils.isEmpty(c13032kM78546d.m78518b()) && CBAccess.isMyhuaweiPullRestoreTask()) {
                C11839m.m70688i(TAG, "queryRestoreState id is null");
                return null;
            }
            return getRestoreState(c13032kM78546d.m78518b(), getCloudBackupStateItemState(c13032kM78546d, false), c13032kM78546d.m78531o(), c13032kM78546d.m78526j());
        } catch (Exception unused) {
            C11839m.m70687e(TAG, "queryRestoreState query tag error.");
            return null;
        }
    }

    public Cursor queryTempBackupStatus() {
        C11839m.m70686d(TAG, "queryTempBackupStatus enter.");
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{MapKeyNames.RESULT_CODE, "interimBackupSwitch"});
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70688i(TAG, "queryTempBackupStatus:not login");
            matrixCursor.addRow(new Object[]{2, 0});
            return matrixCursor;
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e(TAG, "context is null");
            matrixCursor.addRow(new Object[]{5, 0});
            return matrixCursor;
        }
        if (!C0209d.m1333z1(contextM1377a)) {
            C11839m.m70688i(TAG, "no network");
            matrixCursor.addRow(new Object[]{1, 0});
            return matrixCursor;
        }
        int iM60763v = C9733f.m60705z().m60763v("cloudBackupTempBackup");
        C11839m.m70688i(TAG, "interimBackupSwitch:" + iM60763v);
        matrixCursor.addRow(new Object[]{0, Integer.valueOf(iM60763v)});
        return matrixCursor;
    }

    public Cursor queryVersionState(String[] strArr) {
        C11839m.m70688i(TAG, "queryVersionState start.");
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"version", "inBackupOrRestore", "refEffeDays"});
        int i10 = C12591s1.m75931a().m75941k() ? 3 : CBAccess.inRestore() ? C12591s1.m75931a().m75938h() ? 4 : 2 : (C12591s1.m75931a().m75935e() || C12591s1.m75931a().m75936f()) ? 1 : 0;
        C12591s1.m75931a().m75948r();
        matrixCursor.addRow(new Object[]{Integer.valueOf(CloudBackupAppDataUtil.getRefurbishVersion(false)), Integer.valueOf(i10), Integer.valueOf(C13467g.m81086c().m81089d("refurbish_backup_record_refeffe_days", 3))});
        C11839m.m70688i(TAG, "queryVersionState end, state: " + i10);
        return matrixCursor;
    }
}
