package hn;

import android.text.TextUtils;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.ICloudSpaceProxy;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notificationv2.bean.NotificationTask;
import gn.InterfaceC10024g;
import p015ak.C0241z;

/* renamed from: hn.e */
/* loaded from: classes6.dex */
public class C10326e implements InterfaceC10024g {
    @Override // gn.InterfaceC10024g
    /* renamed from: a */
    public boolean mo62169a(NotificationTask notificationTask) {
        if (TextUtils.isEmpty(notificationTask.getData())) {
            NotifyLogger.m29915i("BackupFailPopUpDecision", "data is empty,no need to handle");
            return false;
        }
        int iM1685c = C0241z.m1685c(notificationTask.getData());
        ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
        if (spaceProxy != null) {
            return spaceProxy.isBackupEndCodeSatisfy(iM1685c);
        }
        return false;
    }
}
