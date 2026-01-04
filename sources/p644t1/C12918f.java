package p644t1;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import p506o1.C11786a;
import p629s1.C12665d;
import p665u1.InterfaceC13109a;

/* renamed from: t1.f */
/* loaded from: classes.dex */
public class C12918f {

    /* renamed from: a */
    public AtomicInteger f58933a = new AtomicInteger();

    /* renamed from: b */
    public LinkedHashMap<Integer, C11786a> f58934b = new LinkedHashMap<>();

    /* renamed from: c */
    public Context f58935c;

    /* renamed from: d */
    public int f58936d;

    public C12918f(Context context, int i10) {
        this.f58935c = context;
        this.f58936d = i10;
    }

    /* renamed from: a */
    public synchronized int m77561a(String str, int i10, int i11, int i12, int i13, InterfaceC13109a interfaceC13109a) {
        try {
            if (32 > this.f58936d) {
                m77565e();
            }
            int iM77563c = m77563c();
            C11786a c11786a = this.f58934b.get(Integer.valueOf(iM77563c));
            if (c11786a == null) {
                C12665d.a.m76243b("PlayerObjectPool", "PlayerObjectPool, playHaptic, null == player");
                return -1;
            }
            c11786a.mo70250b(str, i12, i13, i10, i11, interfaceC13109a);
            c11786a.mo70249a();
            c11786a.start();
            return iM77563c;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return -1;
        }
    }

    /* renamed from: b */
    public synchronized void m77562b() {
        try {
            for (Map.Entry<Integer, C11786a> entry : this.f58934b.entrySet()) {
                entry.getValue().stop();
                entry.getValue().release();
            }
            this.f58934b.clear();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: c */
    public final synchronized int m77563c() {
        int iIncrementAndGet;
        m77564d();
        iIncrementAndGet = this.f58933a.incrementAndGet() % Integer.MAX_VALUE;
        C11786a c11786aM70246d = C11786a.m70246d(this.f58935c, 2);
        if (c11786aM70246d != null) {
            this.f58934b.put(Integer.valueOf(iIncrementAndGet), c11786aM70246d);
        }
        return iIncrementAndGet;
    }

    /* renamed from: d */
    public final synchronized void m77564d() {
        try {
            C12665d.a.m76242a("PlayerObjectPool", "PlayerObjectPool shrink() mPlayers.size():" + this.f58934b.size() + ", MAX_SIZE:4");
            if (4 <= this.f58934b.size()) {
                if (C12665d.m76241c()) {
                    String str = "";
                    Iterator<Integer> it = this.f58934b.keySet().iterator();
                    while (it.hasNext()) {
                        str = str + it.next().intValue() + " ";
                    }
                    C12665d.a.m76242a("PlayerObjectPool", "PlayerObjectPool mPlayers keys before shrink:" + str);
                }
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<Integer, C11786a> entry : this.f58934b.entrySet()) {
                    if (!entry.getValue().isPlaying()) {
                        arrayList.add(entry.getKey());
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    Integer num = (Integer) it2.next();
                    C12665d.a.m76242a("PlayerObjectPool", "PlayerObjectPool will remove :" + num.intValue() + " as not playing!");
                    this.f58934b.get(num).release();
                    this.f58934b.remove(num);
                }
                int size = this.f58934b.size() - 3;
                if (size <= 0) {
                    C12665d.a.m76242a("PlayerObjectPool", "PlayerObjectPool, no need to shrink the playing ones!");
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                for (Map.Entry<Integer, C11786a> entry2 : this.f58934b.entrySet()) {
                    entry2.getValue().stop();
                    entry2.getValue().release();
                    arrayList2.add(entry2.getKey());
                    size--;
                    if (size == 0) {
                        break;
                    }
                }
                Iterator it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    Integer num2 = (Integer) it3.next();
                    C12665d.a.m76242a("PlayerObjectPool", "PlayerObjectPool will remove :" + num2.intValue() + " as oversize!");
                    this.f58934b.remove(num2);
                }
                if (C12665d.m76241c()) {
                    String str2 = "";
                    Iterator<Integer> it4 = this.f58934b.keySet().iterator();
                    while (it4.hasNext()) {
                        str2 = str2 + it4.next().intValue() + " ";
                    }
                    C12665d.a.m76242a("PlayerObjectPool", "PlayerObjectPool mPlayers current keys after shrink:" + str2);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: e */
    public synchronized void m77565e() {
        for (Map.Entry<Integer, C11786a> entry : this.f58934b.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().stop();
            }
        }
    }
}
