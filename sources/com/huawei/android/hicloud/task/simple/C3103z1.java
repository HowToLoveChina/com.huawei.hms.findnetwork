package com.huawei.android.hicloud.task.simple;

import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupDeviceInfo;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import fk.C9721b;
import il.C10542o;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import p252e9.C9424a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;

/* renamed from: com.huawei.android.hicloud.task.simple.z1 */
/* loaded from: classes3.dex */
public class C3103z1 extends AbstractC12367d {

    /* renamed from: a */
    public Handler f13419a;

    public C3103z1(Handler handler) {
        this.f13419a = handler;
    }

    /* renamed from: d */
    public static int m18443d() {
        try {
            Map<String, CloudBackupDeviceInfo> deviceInfoMap = new C10542o().mo58476H(false, false, false).getDeviceInfoMap();
            AtomicInteger atomicInteger = new AtomicInteger(0);
            Iterator<Map.Entry<String, CloudBackupDeviceInfo>> it = deviceInfoMap.entrySet().iterator();
            while (it.hasNext()) {
                List<CloudRecoveryItem> recoveryItems = it.next().getValue().getRecoveryItems();
                if (recoveryItems != null && !recoveryItems.isEmpty()) {
                    recoveryItems.removeIf(new Predicate() { // from class: com.huawei.android.hicloud.task.simple.y1
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return C3103z1.m18445f((CloudRecoveryItem) obj);
                        }
                    });
                    if (recoveryItems.size() > 1) {
                        atomicInteger.addAndGet(recoveryItems.size() - 1);
                    }
                }
            }
            return atomicInteger.get();
        } catch (C9721b e10) {
            C11839m.m70687e("QueryCleanupConditionTask", "getCleanupRecords error: " + e10.toString());
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f8  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m18444e(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.task.simple.C3103z1.m18444e(java.lang.String):boolean");
    }

    /* renamed from: f */
    public static /* synthetic */ boolean m18445f(CloudRecoveryItem cloudRecoveryItem) {
        return !cloudRecoveryItem.isBackupCompleted() || cloudRecoveryItem.isRefurbishment();
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        Message messageObtain = Message.obtain(this.f13419a);
        boolean zM18444e = m18444e("manage");
        C9424a.m59104a().m59106c(zM18444e);
        messageObtain.obj = Boolean.valueOf(zM18444e);
        messageObtain.what = 1050;
        this.f13419a.sendMessage(messageObtain);
    }
}
