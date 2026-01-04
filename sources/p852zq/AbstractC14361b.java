package p852zq;

import android.app.PendingIntent;
import as.C1016d;
import com.huawei.location.router.interfaces.IRouterCallback;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import p852zq.C14362c;

/* renamed from: zq.b */
/* loaded from: classes8.dex */
public abstract class AbstractC14361b<T extends C14362c> {

    /* renamed from: a */
    public CopyOnWriteArrayList f63710a = new CopyOnWriteArrayList();

    /* renamed from: a */
    public final void m85534a(T t10) {
        if (t10 == null) {
            C1016d.m6186f(mo85535b(), "setCallBackInfo, null == locationCallBackInfo ");
            return;
        }
        C1016d.m6186f(mo85535b(), "setCallBackInfo callBackInfoList size is " + this.f63710a.size());
        if (this.f63710a.isEmpty()) {
            this.f63710a.add(t10);
            return;
        }
        if (!this.f63710a.isEmpty()) {
            for (int i10 = 0; i10 < this.f63710a.size(); i10++) {
                if (((C14362c) this.f63710a.get(i10)).equals(t10)) {
                    C1016d.m6186f(mo85535b(), "setCallBackInfo, update");
                    return;
                }
            }
        }
        this.f63710a.add(t10);
        C1016d.m6186f(mo85535b(), "setCallBackInfo end callBackInfoList size is " + this.f63710a.size());
    }

    /* renamed from: b */
    public abstract String mo85535b();

    /* renamed from: c */
    public final C14362c m85536c(PendingIntent pendingIntent) {
        if (this.f63710a.isEmpty()) {
            return null;
        }
        Iterator it = this.f63710a.iterator();
        while (it.hasNext()) {
            C14362c c14362c = (C14362c) it.next();
            if (c14362c.m85540b() != null && c14362c.m85540b().equals(pendingIntent)) {
                C1016d.m6186f(mo85535b(), "getInfoFromPendingIntent equals is true");
                return c14362c;
            }
        }
        return null;
    }

    /* renamed from: d */
    public final C14362c m85537d(IRouterCallback iRouterCallback) {
        if (this.f63710a.isEmpty()) {
            return null;
        }
        Iterator it = this.f63710a.iterator();
        while (it.hasNext()) {
            C14362c c14362c = (C14362c) it.next();
            if (c14362c.m85539a() != null && c14362c.m85539a().equals(iRouterCallback)) {
                C1016d.m6186f(mo85535b(), "getInfoFromRouterCallback equals is true");
                return c14362c;
            }
        }
        return null;
    }

    /* renamed from: e */
    public final void m85538e(T t10) {
        C1016d.m6186f(mo85535b(), "removeCallback callBackInfoList size is " + this.f63710a.size());
        if (this.f63710a.isEmpty()) {
            return;
        }
        Iterator it = this.f63710a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (next instanceof C14362c) {
                C14362c c14362c = (C14362c) next;
                if (c14362c.equals(t10)) {
                    C1016d.m6186f(mo85535b(), "removeCallback true");
                    this.f63710a.remove(c14362c);
                    break;
                }
            }
        }
        C1016d.m6186f(mo85535b(), "removeCallback end callBackInfoList size is " + this.f63710a.size());
    }
}
