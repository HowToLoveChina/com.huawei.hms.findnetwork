package p660tu;

import com.huawei.hmf.tasks.Task;
import com.huawei.wearengine.device.Device;
import java.util.List;
import java.util.concurrent.Callable;
import p208cq.C8943k;
import p558pu.C12227b;

/* renamed from: tu.a */
/* loaded from: classes9.dex */
public final class C13071a {

    /* renamed from: b */
    public static volatile C13071a f59476b;

    /* renamed from: a */
    public C13072b f59477a = C13072b.m78843h();

    /* renamed from: tu.a$a */
    public class a implements Callable<List<Device>> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public List<Device> call() {
            List<Device> bondedDevices = C13071a.this.f59477a.getBondedDevices();
            if (bondedDevices != null) {
                return bondedDevices;
            }
            throw new C12227b(12);
        }
    }

    /* renamed from: tu.a$b */
    public class b implements Callable<Boolean> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() {
            return Boolean.valueOf(C13071a.this.f59477a.hasAvailableDevices());
        }
    }

    /* renamed from: c */
    public static C13071a m78837c() {
        if (f59476b == null) {
            synchronized (C13071a.class) {
                try {
                    if (f59476b == null) {
                        f59476b = new C13071a();
                    }
                } finally {
                }
            }
        }
        return f59476b;
    }

    /* renamed from: b */
    public Task<List<Device>> m78838b() {
        return C8943k.m56662b(new a());
    }

    /* renamed from: d */
    public Task<Boolean> m78839d() {
        return C8943k.m56662b(new b());
    }
}
