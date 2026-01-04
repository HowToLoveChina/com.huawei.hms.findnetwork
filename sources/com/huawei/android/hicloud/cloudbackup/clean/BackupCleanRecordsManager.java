package com.huawei.android.hicloud.cloudbackup.clean;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupDeviceInfo;
import com.huawei.android.hicloud.notification.CleanNotifyManager;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.PushCmd;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import fk.C9721b;
import il.C10542o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12590s0;
import p684un.C13225d;
import p709vj.C13452e;
import p746wn.C13622a;
import p814yl.C13998b0;

/* loaded from: classes2.dex */
public class BackupCleanRecordsManager {
    public static final int DELETE_BACKUP_RECORD_CONFLICT = 1;
    public static final int MSG_DELETE_BACKUP_RECORD_FAILED = 4;
    public static final int MSG_DELETE_BACKUP_RECORD_SUCCEED = 3;
    private static final String TAG = "BackupCleanRecordsManager";
    private AtomicInteger cleanRecordsNum;
    private ArrayList<CloudBackupDeviceInfo> recordsList;

    /* renamed from: com.huawei.android.hicloud.cloudbackup.clean.BackupCleanRecordsManager$1 */
    public class C24701 extends AbstractC12367d {
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ CloudRecoveryItem val$item;

        public C24701(CloudRecoveryItem cloudRecoveryItem, Handler handler) {
            cloudRecoveryItem = cloudRecoveryItem;
            handler = handler;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            try {
                new C13998b0().m84130a0(cloudRecoveryItem.getBackupDeviceId(), cloudRecoveryItem.getBackupId(), C12590s0.m75921x1(cloudRecoveryItem.getVersion()) ? "V1" : cloudRecoveryItem.getVersion(), C11058a.m66627b("02007"), "delete_single_from_backup_clean");
                Iterator it = BackupCleanRecordsManager.this.recordsList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CloudBackupDeviceInfo cloudBackupDeviceInfo = (CloudBackupDeviceInfo) it.next();
                    if (cloudBackupDeviceInfo.getRecoveryItems().contains(cloudRecoveryItem)) {
                        cloudBackupDeviceInfo.getRecoveryItems().remove(cloudRecoveryItem);
                        if (cloudBackupDeviceInfo.getRecoveryItems().size() == 1) {
                            it.remove();
                            C11839m.m70688i(BackupCleanRecordsManager.TAG, "deleteBackupRecord: iterator.remove device");
                        }
                        C11839m.m70688i(BackupCleanRecordsManager.TAG, "deleteBackupRecord");
                        BackupCleanRecordsManager.this.cleanRecordsNum.decrementAndGet();
                    }
                }
                handler.obtainMessage(3).sendToTarget();
            } catch (C9721b e10) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 4;
                messageObtain.arg1 = 0;
                if (String.valueOf(e10.m60663g()).endsWith(String.valueOf(4291))) {
                    messageObtain.arg1 = 1;
                }
                handler.sendMessage(messageObtain);
                C11839m.m70687e(BackupCleanRecordsManager.TAG, "removeBackupRecords error: " + e10.getMessage());
            }
        }
    }

    public static class SingleHolder {
        private static final BackupCleanRecordsManager INSTANCE = new BackupCleanRecordsManager();

        private SingleHolder() {
        }
    }

    public /* synthetic */ BackupCleanRecordsManager(C24701 c24701) {
        this();
    }

    public static BackupCleanRecordsManager getInstance() {
        return SingleHolder.INSTANCE;
    }

    public static /* synthetic */ boolean lambda$queryAllBackupRecords$0(CloudRecoveryItem cloudRecoveryItem) {
        return !cloudRecoveryItem.isBackupCompleted() || cloudRecoveryItem.isRefurbishment();
    }

    public static /* synthetic */ int lambda$queryAllBackupRecords$1(CloudBackupDeviceInfo cloudBackupDeviceInfo, CloudBackupDeviceInfo cloudBackupDeviceInfo2) {
        return Long.compare(cloudBackupDeviceInfo2.getRecoveryItems().get(0).getBackupEndTime(), cloudBackupDeviceInfo.getRecoveryItems().get(0).getBackupEndTime());
    }

    private void reportDeleteBackupRecordSucceed(long j10) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("delete_count", String.valueOf(1));
        linkedHashMap.put("delete_space_size", String.valueOf(j10));
        C13225d.m79490f1().m79567R("backup_cleanup_delete_record", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "backup_cleanup_delete_record", linkedHashMap);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02007"), "02007", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
    }

    public void deleteBackupRecord(CloudRecoveryItem cloudRecoveryItem, Handler handler) {
        if (cloudRecoveryItem == null || handler == null) {
            C11839m.m70687e(TAG, "removeBackupRecords error: item or handler is null");
        } else {
            C12515a.m75110o().m75175e(new AbstractC12367d() { // from class: com.huawei.android.hicloud.cloudbackup.clean.BackupCleanRecordsManager.1
                final /* synthetic */ Handler val$handler;
                final /* synthetic */ CloudRecoveryItem val$item;

                public C24701(CloudRecoveryItem cloudRecoveryItem2, Handler handler2) {
                    cloudRecoveryItem = cloudRecoveryItem2;
                    handler = handler2;
                }

                @Override // p616rk.AbstractRunnableC12516b
                public void call() throws C9721b {
                    try {
                        new C13998b0().m84130a0(cloudRecoveryItem.getBackupDeviceId(), cloudRecoveryItem.getBackupId(), C12590s0.m75921x1(cloudRecoveryItem.getVersion()) ? "V1" : cloudRecoveryItem.getVersion(), C11058a.m66627b("02007"), "delete_single_from_backup_clean");
                        Iterator it = BackupCleanRecordsManager.this.recordsList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            CloudBackupDeviceInfo cloudBackupDeviceInfo = (CloudBackupDeviceInfo) it.next();
                            if (cloudBackupDeviceInfo.getRecoveryItems().contains(cloudRecoveryItem)) {
                                cloudBackupDeviceInfo.getRecoveryItems().remove(cloudRecoveryItem);
                                if (cloudBackupDeviceInfo.getRecoveryItems().size() == 1) {
                                    it.remove();
                                    C11839m.m70688i(BackupCleanRecordsManager.TAG, "deleteBackupRecord: iterator.remove device");
                                }
                                C11839m.m70688i(BackupCleanRecordsManager.TAG, "deleteBackupRecord");
                                BackupCleanRecordsManager.this.cleanRecordsNum.decrementAndGet();
                            }
                        }
                        handler.obtainMessage(3).sendToTarget();
                    } catch (C9721b e10) {
                        Message messageObtain = Message.obtain();
                        messageObtain.what = 4;
                        messageObtain.arg1 = 0;
                        if (String.valueOf(e10.m60663g()).endsWith(String.valueOf(4291))) {
                            messageObtain.arg1 = 1;
                        }
                        handler.sendMessage(messageObtain);
                        C11839m.m70687e(BackupCleanRecordsManager.TAG, "removeBackupRecords error: " + e10.getMessage());
                    }
                }
            }, false);
        }
    }

    public CopyOnWriteArrayList<CloudBackupDeviceInfo> getAllBackupRecords() {
        return new CopyOnWriteArrayList<>(this.recordsList);
    }

    public int getCleanRecordsNum() {
        return this.cleanRecordsNum.get();
    }

    public void notifyDeleteBackupRecordSucceed(PushCmd.Delete delete) {
        if (delete == null) {
            C11839m.m70687e(TAG, "notifyDeleteBackupRecordSucceed: result is null");
            return;
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e(TAG, "notifyDeleteBackupRecordSucceed: context is null");
            return;
        }
        C11839m.m70688i(TAG, "notifyDeleteBackupRecordSucceed:");
        reportDeleteBackupRecordSucceed(delete.getDelSpaceSize().longValue());
        CleanNotifyManager cleanNotifyManager = new CleanNotifyManager(contextM1377a);
        Bundle bundle = new Bundle();
        bundle.putString("delete_notify_info_title", contextM1377a.getString(R$string.backup_record_delete_complete));
        bundle.putInt("source", delete.getSceneId().intValue());
        bundle.putInt("delete_notify_info_number", 1);
        bundle.putLong("delete_notify_info_size", delete.getDelSpaceSize().longValue());
        Intent intent = new Intent();
        intent.putExtra("delete_notify_info", bundle);
        cleanNotifyManager.m16515b(intent);
    }

    public void queryAllBackupRecords() throws C9721b {
        try {
            Map<String, CloudBackupDeviceInfo> deviceInfoMap = new C10542o().mo58476H(false, false, false).getDeviceInfoMap();
            this.recordsList.clear();
            this.cleanRecordsNum.set(0);
            Iterator<Map.Entry<String, CloudBackupDeviceInfo>> it = deviceInfoMap.entrySet().iterator();
            while (it.hasNext()) {
                CloudBackupDeviceInfo value = it.next().getValue();
                List<CloudRecoveryItem> recoveryItems = value.getRecoveryItems();
                if (recoveryItems != null && !recoveryItems.isEmpty()) {
                    recoveryItems.removeIf(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.clean.a
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return BackupCleanRecordsManager.lambda$queryAllBackupRecords$0((CloudRecoveryItem) obj);
                        }
                    });
                    if (recoveryItems.size() > 1) {
                        this.cleanRecordsNum.addAndGet(recoveryItems.size() - 1);
                        Collections.sort(recoveryItems);
                        this.recordsList.add(value);
                    }
                }
            }
            this.recordsList.sort(new Comparator() { // from class: com.huawei.android.hicloud.cloudbackup.clean.b
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return BackupCleanRecordsManager.lambda$queryAllBackupRecords$1((CloudBackupDeviceInfo) obj, (CloudBackupDeviceInfo) obj2);
                }
            });
            C11839m.m70688i(TAG, "queryAllBackupRecords: cleanRecordsNum=" + this.cleanRecordsNum.get());
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "queryAllBackupRecords error: " + e10.getMessage());
            throw e10;
        }
    }

    private BackupCleanRecordsManager() {
        this.recordsList = new ArrayList<>();
        this.cleanRecordsNum = new AtomicInteger();
    }
}
