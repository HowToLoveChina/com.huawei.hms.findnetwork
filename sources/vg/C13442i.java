package vg;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.findnetwork.FindNetwork;
import com.huawei.hms.findnetwork.comm.request.bean.DeviceDetail;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import eg.AbstractC9478g;
import fk.C9721b;
import java.util.function.Consumer;
import p015ak.C0225l;
import p227dg.C9120m0;
import p575qe.C12347f;
import p616rk.C12515a;
import p809yg.C13981a;
import p851zp.InterfaceC14356c;
import vg.C13442i;

/* renamed from: vg.i */
/* loaded from: classes4.dex */
public class C13442i {

    /* renamed from: a */
    public static FindNetworkCallback<Void> f60545a = null;

    /* renamed from: b */
    public static String f60546b = "";

    /* renamed from: c */
    public static DeviceDetail f60547c;

    /* renamed from: d */
    public static Consumer<Integer> f60548d;

    /* renamed from: e */
    public static Consumer<Integer> f60549e;

    /* renamed from: vg.i$a */
    public class a extends FindNetworkCallback<Void> {
        /* renamed from: a */
        public final void m80768a(FindNetworkResult findNetworkResult) {
            int respCode = findNetworkResult.getRespCode();
            C13981a.m83989i("LongConnectManager", "createLongConnection, result: " + respCode);
            if (C13442i.f60548d != null) {
                C13442i.f60548d.accept(Integer.valueOf(respCode));
            }
            if (C13442i.f60549e != null) {
                C13442i.f60549e.accept(Integer.valueOf(respCode));
            }
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onFail(FindNetworkResult<Void> findNetworkResult) {
            C13981a.m83989i("LongConnectManager", "createLongConnection fail");
            m80768a(findNetworkResult);
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback
        public void onSuccess(FindNetworkResult<Void> findNetworkResult) {
            C13981a.m83989i("LongConnectManager", "createLongConnection success");
            m80768a(findNetworkResult);
        }
    }

    /* renamed from: vg.i$b */
    public class b extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ Context f60550a;

        /* renamed from: b */
        public final /* synthetic */ String f60551b;

        public b(Context context, String str) {
            this.f60550a = context;
            this.f60551b = str;
        }

        /* renamed from: e */
        public static /* synthetic */ Task m80771e(Context context, String str) throws Exception {
            return FindNetwork.getFindNetworkEngine(context).createLongConnection(str, C13442i.f60545a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f */
        public static /* synthetic */ void m80772f(Exception exc) {
            C13981a.m83988e("LongConnectManager", "createLongConnectDevice exception:" + exc.getMessage());
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            final Context context = this.f60550a;
            final String str = this.f60551b;
            C0225l.m1577a(new InterfaceC14356c() { // from class: vg.j
                @Override // p851zp.InterfaceC14356c
                public final Object execute() {
                    return C13442i.b.m80771e(context, str);
                }
            }, new Consumer() { // from class: vg.k
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C13442i.b.m80772f((Exception) obj);
                }
            });
        }
    }

    /* renamed from: vg.i$c */
    public static class c {

        /* renamed from: a */
        public static final C13442i f60553a = new C13442i();
    }

    /* renamed from: j */
    public static C13442i m80758j() {
        if (f60545a == null) {
            f60545a = new a();
        }
        return c.f60553a;
    }

    /* renamed from: l */
    public static /* synthetic */ Task m80759l(Context context, String str) throws Exception {
        return FindNetwork.getFindNetworkEngine(context).updateLongConnectionParams(str);
    }

    /* renamed from: n */
    public static /* synthetic */ Task m80761n(Context context) throws Exception {
        return FindNetwork.getFindNetworkEngine(context).updateLongConnectionParams(f60546b);
    }

    /* renamed from: h */
    public void m80763h(String str, Consumer<Integer> consumer, Consumer<Integer> consumer2) {
        C13981a.m83989i("LongConnectManager", "createLongConnectDevice, deviceId: " + C9120m0.m57351R(str) + ", currentConnectDevice: " + C9120m0.m57351R(f60546b));
        if (consumer != null) {
            f60548d = consumer;
        }
        if (consumer2 != null) {
            f60549e = consumer2;
        }
        if (!TextUtils.equals(f60546b, str)) {
            f60546b = str;
        }
        C12515a.m75110o().m75172d(new b(C12347f.m74285n().m74301m(), str));
    }

    /* renamed from: i */
    public DeviceDetail m80764i() {
        return f60547c;
    }

    /* renamed from: k */
    public boolean m80765k() {
        return TextUtils.isEmpty(f60546b);
    }

    /* renamed from: p */
    public void m80766p(DeviceDetail deviceDetail) {
        f60547c = deviceDetail;
    }

    /* renamed from: q */
    public void m80767q(final Context context, final String str) {
        C13981a.m83989i("LongConnectManager", "updateLongConnection, deviceId: " + C9120m0.m57351R(str) + ", currentConnectDevice: " + C9120m0.m57351R(f60546b));
        m80758j().m80766p(null);
        C0225l.m1577a(new InterfaceC14356c() { // from class: vg.e
            @Override // p851zp.InterfaceC14356c
            public final Object execute() {
                return C13442i.m80759l(context, str);
            }
        }, new Consumer() { // from class: vg.f
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C13981a.m83988e("LongConnectManager", "updateLongConnection exception");
            }
        });
        if (!TextUtils.equals(str, f60546b)) {
            C0225l.m1577a(new InterfaceC14356c() { // from class: vg.g
                @Override // p851zp.InterfaceC14356c
                public final Object execute() {
                    return C13442i.m80761n(context);
                }
            }, new Consumer() { // from class: vg.h
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C13981a.m83988e("LongConnectManager", "updateLongConnection exception");
                }
            });
        }
        f60546b = "";
    }
}
