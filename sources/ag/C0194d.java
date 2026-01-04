package ag;

import android.content.Context;
import com.huawei.hms.findnetwork.FindNetwork;
import com.huawei.hms.findnetwork.comm.request.bean.PairedDeviceInfo;
import com.huawei.hms.findnetwork.comm.request.callback.GrabTagLogListener;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;
import p575qe.C12347f;
import p616rk.C12515a;
import p809yg.C13981a;

/* renamed from: ag.d */
/* loaded from: classes4.dex */
public class C0194d {

    /* renamed from: c */
    public static final String f760c = C12347f.m74285n().m74301m().getFilesDir().getPath() + File.separator + "hicloud";

    /* renamed from: a */
    public ArrayList<C0195e> f761a;

    /* renamed from: b */
    public Map<C0195e, BlockingQueue<byte[]>> f762b;

    /* renamed from: ag.d$a */
    public class a implements GrabTagLogListener {

        /* renamed from: a */
        public final /* synthetic */ C0195e f763a;

        public a(C0195e c0195e) {
            this.f763a = c0195e;
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.GrabTagLogListener
        public void onFinished() {
            C13981a.m83989i("TagLogCollector", "queryTagLog finaish tagSn");
            this.f763a.m1091c(false);
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.GrabTagLogListener
        public void onGrabFail(int i10, String str) {
            C13981a.m83989i("TagLogCollector", "queryTagLog fail:" + str);
            this.f763a.m1091c(false);
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.GrabTagLogListener
        public void onGrabing(byte[] bArr) {
            C0194d.this.m1082c(this.f763a, bArr);
        }

        @Override // com.huawei.hms.findnetwork.comm.request.callback.GrabTagLogListener
        public void onStartGrab() {
            C13981a.m83989i("TagLogCollector", "queryTagLog start tagSn");
        }
    }

    /* renamed from: h */
    public static /* synthetic */ void m1081h(Exception exc) {
        C13981a.m83989i("TagLogCollector", "getTagLog paired devices fail. " + exc.toString());
    }

    /* renamed from: c */
    public void m1082c(C0195e c0195e, byte[] bArr) {
        Map<C0195e, BlockingQueue<byte[]>> map = this.f762b;
        if (map == null || map.get(c0195e) == null) {
            return;
        }
        this.f762b.get(c0195e).offer(bArr);
    }

    /* renamed from: d */
    public final void m1083d() {
        File[] fileArrListFiles = new File(f760c).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (file.getName().contains("log.bin")) {
                C13981a.m83987d("TagLogCollector", "delete old log file result:" + file.delete());
            }
        }
    }

    /* renamed from: e */
    public void m1084e(final Context context) {
        if (context == null) {
            C13981a.m83988e("TagLogCollector", "getTagLog context or tagSn is empty");
            return;
        }
        try {
            m1083d();
            FindNetwork.getFindNetworkEngine(context).queryPairedDevices().addOnSuccessListener(new InterfaceC8939g() { // from class: ag.b
                @Override // p208cq.InterfaceC8939g
                public final void onSuccess(Object obj) {
                    this.f758a.m1086g(context, (FindNetworkResult) obj);
                }
            }).addOnFailureListener(new InterfaceC8938f() { // from class: ag.c
                @Override // p208cq.InterfaceC8938f
                public final void onFailure(Exception exc) {
                    C0194d.m1081h(exc);
                }
            });
        } catch (Exception e10) {
            C13981a.m83988e("TagLogCollector", "queryDeviceDetail exception:" + e10.toString());
        }
    }

    /* renamed from: f */
    public void m1085f(int i10, ArrayList<C0195e> arrayList) {
        this.f761a = arrayList;
        this.f762b = new HashMap(i10);
        Iterator<C0195e> it = arrayList.iterator();
        while (it.hasNext()) {
            this.f762b.put(it.next(), new ArrayBlockingQueue(256));
        }
    }

    /* renamed from: g */
    public final /* synthetic */ void m1086g(Context context, FindNetworkResult findNetworkResult) {
        C13981a.m83989i("TagLogCollector", "getTagLog query paired devices success.");
        if (findNetworkResult == null) {
            C13981a.m83988e("TagLogCollector", "getTagLog query paired devices result is null");
            return;
        }
        List list = (List) findNetworkResult.getData();
        if (list == null) {
            C13981a.m83989i("TagLogCollector", "getTagLog getBindTagList data empty");
            return;
        }
        ArrayList<C0195e> arrayList = new ArrayList<>();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new C0195e(((PairedDeviceInfo) it.next()).getSn()));
        }
        C13981a.m83989i("TagLogCollector", "getTagLog getBindTagList:" + list.size());
        m1085f(list.size(), arrayList);
        m1087i();
        Iterator<C0195e> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            C0195e next = it2.next();
            try {
                FindNetwork.getFindNetworkEngine(context).grabDeviceLog(next.m1089a(), new a(next));
            } catch (Exception e10) {
                C13981a.m83988e("TagLogCollector", "queryDeviceDetail exception:" + e10.getMessage());
            }
        }
    }

    /* renamed from: i */
    public void m1087i() {
        for (Map.Entry<C0195e, BlockingQueue<byte[]>> entry : this.f762b.entrySet()) {
            C12515a.m75110o().m75175e(new C0191a(entry.getKey(), entry.getValue()), false);
        }
    }

    /* renamed from: j */
    public void m1088j() {
        Iterator<C0195e> it = this.f761a.iterator();
        while (it.hasNext()) {
            it.next().m1091c(false);
        }
        this.f761a.clear();
        this.f762b.clear();
    }
}
