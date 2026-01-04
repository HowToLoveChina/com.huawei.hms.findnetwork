package p690uu;

import com.huawei.hmf.tasks.Task;
import com.huawei.wearengine.device.Device;
import com.huawei.wearengine.monitor.MonitorData;
import com.huawei.wearengine.monitor.MonitorItem;
import java.util.concurrent.Callable;
import p208cq.C8943k;
import p558pu.C12227b;
import su.C12860b;

/* renamed from: uu.b */
/* loaded from: classes9.dex */
public final class C13254b {

    /* renamed from: a */
    public C13255c f59944a;

    /* renamed from: uu.b$a */
    public class a implements Callable<MonitorData> {

        /* renamed from: a */
        public final /* synthetic */ Device f59945a;

        /* renamed from: b */
        public final /* synthetic */ MonitorItem f59946b;

        public a(Device device, MonitorItem monitorItem) {
            this.f59945a = device;
            this.f59946b = monitorItem;
        }

        @Override // java.util.concurrent.Callable
        public MonitorData call() {
            C12860b.m77201e(this.f59945a, "Device can not be null!");
            C12860b.m77201e(this.f59946b, "MonitorItem can not be null!");
            MonitorData monitorDataQuery = C13254b.this.f59944a.query(this.f59945a, this.f59946b);
            if (monitorDataQuery != null) {
                return monitorDataQuery;
            }
            throw new C12227b(12);
        }
    }

    /* renamed from: uu.b$b */
    public static class b {

        /* renamed from: a */
        public static final C13254b f59948a = new C13254b(null);
    }

    public C13254b() {
        this.f59944a = new C13255c();
    }

    /* renamed from: b */
    public static C13254b m79647b() {
        return b.f59948a;
    }

    /* renamed from: c */
    public Task<MonitorData> m79648c(Device device, MonitorItem monitorItem) {
        return C8943k.m56662b(new a(device, monitorItem));
    }

    public /* synthetic */ C13254b(CallableC13253a callableC13253a) {
        this();
    }
}
