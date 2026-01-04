package p680ui;

import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4647o;
import com.huawei.cloud.base.util.C4649q;
import com.huawei.cloud.base.util.C4655w;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: ui.c */
/* loaded from: classes.dex */
public class C13179c<V extends Serializable> extends AbstractC13177a<V> {

    /* renamed from: c */
    public HashMap<String, byte[]> f59707c;

    /* renamed from: d */
    public final Lock f59708d;

    public C13179c(InterfaceC13181e interfaceC13181e, String str) {
        super(interfaceC13181e, str);
        this.f59707c = C4655w.m28495a();
        this.f59708d = new ReentrantLock();
    }

    @Override // p680ui.InterfaceC13180d
    /* renamed from: a */
    public InterfaceC13180d<V> mo79227a(String str) throws IOException {
        if (str == null) {
            return this;
        }
        this.f59708d.lock();
        try {
            this.f59707c.remove(str);
            mo79230d();
            return this;
        } finally {
            this.f59708d.unlock();
        }
    }

    @Override // p680ui.InterfaceC13180d
    /* renamed from: b */
    public final InterfaceC13180d<V> mo79228b(String str, V v10) throws IOException {
        C4627a0.m28391d(str);
        C4627a0.m28391d(v10);
        this.f59708d.lock();
        try {
            this.f59707c.put(str, C4647o.m28481h(v10));
            mo79230d();
            return this;
        } finally {
            this.f59708d.unlock();
        }
    }

    @Override // p680ui.InterfaceC13180d
    /* renamed from: c */
    public final V mo79229c(String str) throws IOException {
        if (str == null) {
            return null;
        }
        this.f59708d.lock();
        try {
            return (V) C4647o.m28478e(this.f59707c.get(str));
        } finally {
            this.f59708d.unlock();
        }
    }

    @Override // p680ui.InterfaceC13180d
    public final InterfaceC13180d<V> clear() throws IOException {
        this.f59708d.lock();
        try {
            this.f59707c.clear();
            mo79230d();
            return this;
        } finally {
            this.f59708d.unlock();
        }
    }

    /* renamed from: d */
    public void mo79230d() throws IOException {
        throw null;
    }

    @Override // p680ui.InterfaceC13180d
    public boolean isEmpty() throws IOException {
        this.f59708d.lock();
        try {
            return this.f59707c.isEmpty();
        } finally {
            this.f59708d.unlock();
        }
    }

    @Override // p680ui.InterfaceC13180d
    public final Set<String> keySet() throws IOException {
        this.f59708d.lock();
        try {
            return Collections.unmodifiableSet(this.f59707c.keySet());
        } finally {
            this.f59708d.unlock();
        }
    }

    public String toString() {
        return C13182f.m79231a(this);
    }

    @Override // p680ui.InterfaceC13180d
    public final Collection<V> values() throws IOException {
        this.f59708d.lock();
        try {
            ArrayList arrayListM28482a = C4649q.m28482a();
            Iterator<byte[]> it = this.f59707c.values().iterator();
            while (it.hasNext()) {
                arrayListM28482a.add(C4647o.m28478e(it.next()));
            }
            List listUnmodifiableList = Collections.unmodifiableList(arrayListM28482a);
            this.f59708d.unlock();
            return listUnmodifiableList;
        } catch (Throwable th2) {
            this.f59708d.unlock();
            throw th2;
        }
    }
}
