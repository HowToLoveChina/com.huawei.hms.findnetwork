package p680ui;

import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4655w;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/* renamed from: ui.b */
/* loaded from: classes.dex */
public abstract class AbstractC13178b implements InterfaceC13181e {

    /* renamed from: c */
    public static final Pattern f59704c = Pattern.compile("\\w{1,30}");

    /* renamed from: a */
    public final Lock f59705a = new ReentrantLock();

    /* renamed from: b */
    public final Map<String, InterfaceC13180d<? extends Serializable>> f59706b = C4655w.m28495a();

    /* renamed from: a */
    public abstract <V extends Serializable> InterfaceC13180d<V> mo79225a(String str) throws IOException;

    /* renamed from: b */
    public final <V extends Serializable> InterfaceC13180d<V> m79226b(String str) throws IOException {
        Pattern pattern = f59704c;
        C4627a0.m28390c(pattern.matcher(str).matches(), "%s does not match pattern %s", str, pattern);
        this.f59705a.lock();
        try {
            InterfaceC13180d<V> interfaceC13180dMo79225a = (InterfaceC13180d) this.f59706b.get(str);
            if (interfaceC13180dMo79225a == null) {
                interfaceC13180dMo79225a = mo79225a(str);
                this.f59706b.put(str, interfaceC13180dMo79225a);
            }
            return interfaceC13180dMo79225a;
        } finally {
            this.f59705a.unlock();
        }
    }
}
