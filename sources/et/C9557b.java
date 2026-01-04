package et;

import android.location.Location;
import as.C1016d;
import com.huawei.location.vdr.listener.IVdrLocationListener;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: et.b */
/* loaded from: classes8.dex */
public final class C9557b {

    /* renamed from: b */
    public static volatile C9557b f47472b;

    /* renamed from: c */
    public static final byte[] f47473c = new byte[0];

    /* renamed from: a */
    public ArrayList f47474a = new ArrayList(10);

    /* renamed from: c */
    public static C9557b m59666c() {
        if (f47472b == null) {
            synchronized (f47473c) {
                try {
                    if (f47472b == null) {
                        f47472b = new C9557b();
                    }
                } finally {
                }
            }
        }
        return f47472b;
    }

    /* renamed from: a */
    public final void m59667a(IVdrLocationListener iVdrLocationListener) {
        synchronized (f47473c) {
            try {
                if (iVdrLocationListener == null) {
                    return;
                }
                if (this.f47474a == null) {
                    this.f47474a = new ArrayList();
                }
                m59670e(iVdrLocationListener);
                C1016d.m6186f("VdrLocationListenerManager", "add vdrLocationListener to vdrLocationListenerList, size is : " + this.f47474a.size());
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public final boolean m59668b() {
        boolean z10;
        synchronized (f47473c) {
            try {
                ArrayList arrayList = this.f47474a;
                z10 = arrayList == null || arrayList.size() == 0;
            } finally {
            }
        }
        return z10;
    }

    /* renamed from: d */
    public final void m59669d(Location location) {
        synchronized (f47473c) {
            try {
                ArrayList arrayList = this.f47474a;
                if (arrayList != null && arrayList.size() != 0) {
                    for (int i10 = 0; i10 < this.f47474a.size(); i10++) {
                        ((IVdrLocationListener) this.f47474a.get(i10)).onVdrLocationChanged(location);
                    }
                }
            } finally {
            }
        }
    }

    /* renamed from: e */
    public final void m59670e(IVdrLocationListener iVdrLocationListener) {
        synchronized (f47473c) {
            try {
                if (m59668b()) {
                    this.f47474a.add(iVdrLocationListener);
                    C1016d.m6186f("VdrLocationListenerManager", "vdrLocationListenerList is empty, add uuid here, uuid is: " + iVdrLocationListener.getUuid());
                    return;
                }
                for (int i10 = 0; i10 < this.f47474a.size(); i10++) {
                    if (((IVdrLocationListener) this.f47474a.get(i10)).getUuid().equals(iVdrLocationListener.getUuid())) {
                        this.f47474a.set(i10, iVdrLocationListener);
                        C1016d.m6186f("VdrLocationListenerManager", "replace uuid here, uuid is: " + iVdrLocationListener.getUuid());
                        return;
                    }
                }
                this.f47474a.add(iVdrLocationListener);
                C1016d.m6186f("VdrLocationListenerManager", "new add uuid here, uuid is: " + iVdrLocationListener.getUuid());
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: f */
    public final void m59671f(String str) {
        synchronized (f47473c) {
            if (str != null) {
                try {
                    ArrayList arrayList = this.f47474a;
                    if (arrayList != null && arrayList.size() != 0) {
                        Iterator it = this.f47474a.iterator();
                        while (it.hasNext()) {
                            IVdrLocationListener iVdrLocationListener = (IVdrLocationListener) it.next();
                            if (iVdrLocationListener.getUuid().equals(str)) {
                                this.f47474a.remove(iVdrLocationListener);
                                C1016d.m6186f("VdrLocationListenerManager", "remove vdrLocationListener from vdrLocationListenerList, size is : " + this.f47474a.size() + ", uuid is: " + str);
                                return;
                            }
                        }
                    }
                } finally {
                }
            }
        }
    }
}
