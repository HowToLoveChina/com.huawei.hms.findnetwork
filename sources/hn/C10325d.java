package hn;

import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.ICloudSpaceProxy;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notificationv2.bean.C4972b;
import com.huawei.hicloud.notificationv2.bean.NotificationTask;
import gn.EnumC10018a;
import gn.InterfaceC10023f;
import gp.C10028c;
import java.util.ArrayList;
import java.util.List;

/* renamed from: hn.d */
/* loaded from: classes6.dex */
public class C10325d implements InterfaceC10023f {

    /* renamed from: a */
    public static final List<Integer> f49998a;

    static {
        ArrayList arrayList = new ArrayList();
        f49998a = arrayList;
        arrayList.add(2);
    }

    /* renamed from: a */
    public final NotificationTask m63591a(C4972b c4972b) {
        if (c4972b.m29933b() != 3) {
            return null;
        }
        return new NotificationTask(0L, c4972b.m29932a(), 2);
    }

    /* renamed from: b */
    public boolean m63592b() {
        if (!C10028c.m62182c0().m62388s("backup_key")) {
            NotifyLogger.m29915i("BackupFailDecisionMaker", "backup switch is not open");
            return true;
        }
        ICloudSpaceProxy spaceProxy = CloudSpaceNotifyUtil.getInstance().getSpaceProxy();
        if (spaceProxy == null) {
            NotifyLogger.m29914e("BackupFailDecisionMaker", "spaceProxy is null");
            return true;
        }
        if (spaceProxy.isNoMoreRemindSwitchChecked()) {
            NotifyLogger.m29915i("BackupFailDecisionMaker", "no more remind switch checked.");
            return true;
        }
        if (spaceProxy.isBackupFailNoticeFrequencySatisfy()) {
            return false;
        }
        NotifyLogger.m29915i("BackupFailDecisionMaker", "backup fail noticefrequency not Satisfy.");
        return true;
    }

    @Override // gn.InterfaceC10023f
    public EnumC10018a identity() {
        return EnumC10018a.BACKUP_FAIL;
    }

    @Override // gn.InterfaceC10023f
    public boolean isValid() {
        return super.isValid();
    }

    @Override // gn.InterfaceC10023f
    /* renamed from: o */
    public void mo62168o(C4972b c4972b, List<NotificationTask> list) {
        if (c4972b == null) {
            NotifyLogger.m29915i("BackupFailDecisionMaker", "event is null");
            return;
        }
        NotificationTask notificationTaskM63591a = m63591a(c4972b);
        if (notificationTaskM63591a == null) {
            NotifyLogger.m29915i("BackupFailDecisionMaker", "no need to add notificationTask,event id is:" + c4972b.m29933b());
            return;
        }
        if (m63592b()) {
            NotifyLogger.m29915i("BackupFailDecisionMaker", "precondition not satisfied");
            return;
        }
        list.add(notificationTaskM63591a);
        NotifyLogger.m29913d("BackupFailDecisionMaker", "notificationTask type:" + notificationTaskM63591a.getType());
    }
}
