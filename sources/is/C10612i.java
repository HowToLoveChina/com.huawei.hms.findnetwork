package is;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import ar.C1012a;
import as.C1016d;
import com.huawei.hms.location.HwLocationResult;
import hu.C10343b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import p784xq.C13850f;
import p819yq.C14035a;
import p852zq.AbstractC14365f;

/* renamed from: is.i */
/* loaded from: classes8.dex */
public final class C10612i {

    /* renamed from: a */
    public ConcurrentHashMap<AbstractC14365f, C10608e> f51011a;

    /* renamed from: b */
    public int f51012b;

    /* renamed from: c */
    public Handler f51013c;

    /* renamed from: is.i$a */
    public static class a {

        /* renamed from: a */
        public static final C10612i f51014a = new C10612i(0);
    }

    /* renamed from: is.i$b */
    public class b implements Handler.Callback {
        public b() {
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return C10612i.m65051e(C10612i.this, message);
        }
    }

    public C10612i() {
        this.f51012b = 0;
        this.f51011a = new ConcurrentHashMap<>();
        HandlerThread handlerThread = new HandlerThread("MaxWaitTimeManager");
        handlerThread.start();
        this.f51013c = new Handler(handlerThread.getLooper(), new b());
    }

    /* renamed from: a */
    public static C10612i m65050a() {
        return a.f51014a;
    }

    /* renamed from: e */
    public static boolean m65051e(C10612i c10612i, Message message) throws JSONException {
        AbstractC14365f abstractC14365f;
        C10608e c10608e;
        AbstractC14365f abstractC14365f2;
        C10608e c10608e2;
        c10612i.getClass();
        C13850f.m83120a(new StringBuilder("handleMessage msg what:"), message.what, "MaxWaitTimeManager");
        ConcurrentHashMap<AbstractC14365f, C10608e> concurrentHashMap = c10612i.f51011a;
        if (concurrentHashMap != null) {
            int i10 = message.what;
            if (i10 == 2147483636) {
                Object obj = message.obj;
                if (obj instanceof AbstractC14365f) {
                    AbstractC14365f abstractC14365f3 = (AbstractC14365f) obj;
                    C10608e c10608e3 = concurrentHashMap.get(abstractC14365f3);
                    if (c10608e3 == null) {
                        C1016d.m6183c("MaxWaitTimeManager", "updateLocations failed , no find bean");
                    } else {
                        Bundle data = message.getData();
                        if (data != null) {
                            Serializable serializableM63693o = new C10343b(data).m63693o("TAG_BEAN");
                            if (serializableM63693o instanceof C10608e) {
                                c10608e3.m65038h(((C10608e) serializableM63693o).m65035e());
                                c10612i.f51011a.put(abstractC14365f3, c10608e3);
                                C1016d.m6186f("MaxWaitTimeManager", "updateLocations success");
                            }
                        }
                    }
                    return true;
                }
            } else if (i10 != 2147483637) {
                Object obj2 = message.obj;
                if ((obj2 instanceof AbstractC14365f) && (c10608e2 = concurrentHashMap.get((abstractC14365f2 = (AbstractC14365f) obj2))) != null) {
                    c10612i.m65053c(abstractC14365f2, c10608e2);
                    Message messageObtainMessage = c10612i.f51013c.obtainMessage();
                    messageObtainMessage.what = c10608e2.m65032b();
                    messageObtainMessage.obj = abstractC14365f2;
                    c10612i.f51013c.sendMessageDelayed(messageObtainMessage, c10608e2.m65034d());
                }
            } else {
                Object obj3 = message.obj;
                if ((obj3 instanceof AbstractC14365f) && (c10608e = concurrentHashMap.get((abstractC14365f = (AbstractC14365f) obj3))) != null) {
                    c10612i.f51013c.removeMessages(c10608e.m65032b());
                    c10612i.m65053c(abstractC14365f, c10608e);
                    c10612i.f51011a.remove(abstractC14365f);
                    C1016d.m6186f("MaxWaitTimeManager", "removeMaxWaitTimeQueue success");
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public final void m65052b(C14035a c14035a, String str) {
        C1016d.m6186f("MaxWaitTimeManager", "removeMaxWaitTimeQueue transactionID:" + str);
        if (c14035a.m84187g() == null) {
            return;
        }
        AbstractC14365f abstractC14365fM84187g = c14035a.m84187g();
        if (this.f51011a.containsKey(abstractC14365fM84187g)) {
            Message messageObtainMessage = this.f51013c.obtainMessage(2147483637);
            messageObtainMessage.obj = abstractC14365fM84187g;
            this.f51013c.sendMessage(messageObtainMessage);
            C1016d.m6186f("MaxWaitTimeManager", "removeMaxWaitTimeQueue send msg");
        }
    }

    /* renamed from: c */
    public final void m65053c(AbstractC14365f abstractC14365f, C10608e c10608e) throws JSONException {
        String str;
        C1016d.m6186f("MaxWaitTimeManager", "callback maxWaitTime start :" + c10608e.m65033c());
        if (abstractC14365f == null) {
            C1016d.m6183c("MaxWaitTimeManager", "callback maxWaitTime failed , callback is null");
            return;
        }
        if (c10608e.m65035e() == null || c10608e.m65035e().size() <= 0) {
            str = "not need callback, locations size is null";
        } else {
            C1016d.m6186f("MaxWaitTimeManager", "callback locationResult size is " + c10608e.m65035e().size());
            Iterator<Location> it = c10608e.m65035e().iterator();
            while (it.hasNext()) {
                abstractC14365f.m85551d(new HwLocationResult(0, C1012a.m6166a(0), it.next()));
            }
            if (c10608e.m65035e() != null) {
                c10608e.m65035e().clear();
            }
            this.f51011a.put(abstractC14365f, c10608e);
            str = "callback maxWaitTime end";
        }
        C1016d.m6186f("MaxWaitTimeManager", str);
    }

    /* renamed from: d */
    public final void m65054d(AbstractC14365f abstractC14365f, String str, long j10) {
        String str2;
        C1016d.m6186f("MaxWaitTimeManager", "addMaxWaitTimeQueue start transactionID:" + str);
        if (this.f51012b == 1073741822) {
            C1016d.m6183c("MaxWaitTimeManager", "addMaxWaitTimeQueue failed , msgWhat is out of number");
            return;
        }
        if (this.f51011a == null) {
            this.f51011a = new ConcurrentHashMap<>();
        }
        if (this.f51011a.containsKey(abstractC14365f)) {
            C1016d.m6186f("MaxWaitTimeManager", "addMaxWaitTimeQueue update bean and restart queue");
            C10608e c10608e = this.f51011a.get(abstractC14365f);
            if (c10608e == null) {
                return;
            }
            c10608e.m65036f(j10);
            c10608e.m65037g(str);
            this.f51011a.putIfAbsent(abstractC14365f, c10608e);
            Message messageObtainMessage = this.f51013c.obtainMessage();
            messageObtainMessage.what = c10608e.m65032b();
            messageObtainMessage.obj = abstractC14365f;
            this.f51013c.removeMessages(c10608e.m65032b());
            this.f51013c.sendMessageDelayed(messageObtainMessage, j10);
            str2 = "addMaxWaitTimeQueue update bean and restart queue send msg";
        } else {
            C1016d.m6186f("MaxWaitTimeManager", "addMaxWaitTimeQueue new bean and start queue");
            this.f51011a.put(abstractC14365f, new C10608e(str, this.f51012b, j10, null));
            Message messageObtainMessage2 = this.f51013c.obtainMessage();
            messageObtainMessage2.what = this.f51012b;
            messageObtainMessage2.obj = abstractC14365f;
            this.f51013c.sendMessageDelayed(messageObtainMessage2, j10);
            this.f51012b++;
            str2 = "addMaxWaitTimeQueue new bean and restart queue send msg";
        }
        C1016d.m6186f("MaxWaitTimeManager", str2);
    }

    /* renamed from: f */
    public final boolean m65055f(String str, AbstractC14365f abstractC14365f, ArrayList arrayList) {
        C1016d.m6186f("MaxWaitTimeManager", "updateLocations start transactionID:" + str);
        if (this.f51011a.size() == 0) {
            C1016d.m6186f("MaxWaitTimeManager", "map is null , no need update");
            return false;
        }
        if (arrayList.isEmpty()) {
            C1016d.m6186f("MaxWaitTimeManager", "updateLocations failed , locations is null");
            return false;
        }
        if (!this.f51011a.containsKey(abstractC14365f)) {
            C1016d.m6183c("MaxWaitTimeManager", "updateLocations failed , not contains id");
            return false;
        }
        Message messageObtainMessage = this.f51013c.obtainMessage(2147483636);
        messageObtainMessage.obj = abstractC14365f;
        C10608e c10608e = new C10608e(str, -1, -1L, arrayList);
        C10343b c10343b = new C10343b();
        c10343b.m63700v("TAG_BEAN", c10608e);
        messageObtainMessage.setData(c10343b.m63683e());
        this.f51013c.sendMessage(messageObtainMessage);
        C1016d.m6186f("MaxWaitTimeManager", "updateLocations send msg");
        return true;
    }

    public /* synthetic */ C10612i(int i10) {
        this();
    }
}
