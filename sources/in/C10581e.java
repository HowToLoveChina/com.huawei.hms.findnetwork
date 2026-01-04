package in;

import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notificationv2.bean.NotificationTask;
import gn.InterfaceC10024g;
import hn.C10326e;
import hn.C10327f;
import hn.C10329h;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import p457ln.C11320e;

/* renamed from: in.e */
/* loaded from: classes6.dex */
public class C10581e {

    /* renamed from: a */
    public Map<Integer, InterfaceC10024g> f50917a;

    /* renamed from: in.e$a */
    public static class a {

        /* renamed from: a */
        public static final C10581e f50918a = new C10581e();
    }

    public C10581e() {
        HashMap map = new HashMap();
        this.f50917a = map;
        map.put(1, new C10329h());
        this.f50917a.put(2, new C10326e());
        this.f50917a.put(3, new C10327f());
    }

    /* renamed from: c */
    public static C10581e m64892c() {
        return a.f50918a;
    }

    /* renamed from: d */
    public static /* synthetic */ Boolean m64893d(NotificationTask notificationTask, InterfaceC10024g interfaceC10024g) {
        return Boolean.valueOf(interfaceC10024g.mo62169a(notificationTask));
    }

    /* renamed from: b */
    public void m64894b(final NotificationTask notificationTask) {
        boolean zBooleanValue = ((Boolean) Optional.ofNullable(this.f50917a.get(Integer.valueOf(notificationTask.getType()))).map(new Function() { // from class: in.d
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C10581e.m64893d(notificationTask, (InterfaceC10024g) obj);
            }
        }).orElse(Boolean.FALSE)).booleanValue();
        NotifyLogger.m29915i("NotificationTaskManager", "checkNotifyTask isShow:" + zBooleanValue + ",task type: " + notificationTask.getType());
        if (zBooleanValue) {
            new C11320e().m67989a(notificationTask).sendNotify();
        }
    }
}
