package p457ln;

import com.huawei.hicloud.notificationv2.bean.NotificationTask;

/* renamed from: ln.e */
/* loaded from: classes6.dex */
public class C11320e {
    /* renamed from: a */
    public InterfaceC11317b m67989a(NotificationTask notificationTask) {
        int type = notificationTask.getType();
        if (type != 1) {
            if (type == 2) {
                return new C11316a(notificationTask.getData());
            }
            if (type != 4) {
                return new C11319d();
            }
        }
        return new C11318c(notificationTask.getData());
    }
}
