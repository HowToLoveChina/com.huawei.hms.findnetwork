package in;

import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notificationv2.bean.C4972b;
import com.huawei.hicloud.notificationv2.bean.NotificationTask;
import gn.InterfaceC10021d;
import gn.InterfaceC10023f;
import java.util.ArrayList;
import java.util.function.Consumer;
import p815ym.AbstractC14026a;

/* renamed from: in.c */
/* loaded from: classes6.dex */
public class C10579c implements InterfaceC10021d {
    /* renamed from: e */
    public static /* synthetic */ void m64890e(NotificationTask notificationTask) {
        C10581e.m64892c().m64894b(notificationTask);
    }

    @Override // gn.InterfaceC10021d
    /* renamed from: a */
    public void mo62166a(final C4972b c4972b) {
        final ArrayList arrayList = new ArrayList();
        InterfaceC10023f.get().forEach(new Consumer() { // from class: in.a
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((InterfaceC10023f) obj).mo62168o(c4972b, arrayList);
            }
        });
        if (AbstractC14026a.m84159a(arrayList)) {
            NotifyLogger.m29915i("BackupEventDecisionCenter", "notificationTaskList is empty.");
        } else {
            arrayList.forEach(new Consumer() { // from class: in.b
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C10579c.m64890e((NotificationTask) obj);
                }
            });
        }
    }
}
