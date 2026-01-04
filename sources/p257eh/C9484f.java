package p257eh;

import android.content.Context;
import android.os.RemoteException;
import com.huawei.appgallery.coreservice.api.ApiClient;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.RequestHeader;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.RequireVersion;
import com.huawei.appmarket.framework.coreservice.DataHolder;
import com.huawei.appmarket.framework.coreservice.InterfaceC4584a;
import com.huawei.appmarket.framework.coreservice.Status;
import java.util.ArrayList;
import java.util.List;

/* renamed from: eh.f */
/* loaded from: classes4.dex */
public class C9484f<C extends BaseIPCRequest> implements InterfaceC9483e {

    /* renamed from: c */
    public static final List<String> f47255c;

    /* renamed from: a */
    public final Context f47256a;

    /* renamed from: b */
    public final C f47257b;

    static {
        ArrayList arrayList = new ArrayList();
        f47255c = arrayList;
        arrayList.add("method.cancelTask");
        arrayList.add("method.pauseTask");
        arrayList.add("method.queryTasks");
        arrayList.add("method.registerDownloadCallback");
        arrayList.add("method.resumeTask");
        arrayList.add("method.startDownloadTask");
        arrayList.add("method.unregisterDownloadCallback");
    }

    public C9484f(Context context, C c10) {
        this.f47256a = context;
        this.f47257b = c10;
    }

    @Override // p257eh.InterfaceC9483e
    /* renamed from: a */
    public final void mo59333a(ApiClient apiClient, InterfaceC4584a.a aVar) {
        String str;
        if (this.f47257b == null) {
            m59335c(aVar, 14);
            return;
        }
        InterfaceC9481c interfaceC9481cM59334b = m59334b(apiClient);
        if (interfaceC9481cM59334b != null) {
            DataHolder dataHolder = new DataHolder();
            RequestHeader requestHeader = new RequestHeader();
            requestHeader.m28057d(this.f47256a.getPackageName());
            requestHeader.m28056c(this.f47257b.getMediaPkg());
            RequireVersion requireVersion = (RequireVersion) this.f47257b.getClass().getAnnotation(RequireVersion.class);
            if (requireVersion != null) {
                requestHeader.m28055a(requireVersion.value());
            }
            dataHolder.m28117c(requestHeader);
            dataHolder.m28118d(this.f47257b.getMethod());
            dataHolder.m28116a(this.f47257b);
            try {
                interfaceC9481cM59334b.mo28042a(dataHolder, aVar);
                return;
            } catch (Exception e10) {
                str = "sync call ex:" + e10.getMessage();
            }
        } else {
            str = "can not find client";
        }
        C9490l.m59351c("transport", str);
        m59335c(aVar, 8);
    }

    /* renamed from: b */
    public final InterfaceC9481c m59334b(ApiClient apiClient) {
        if (apiClient instanceof C9479a) {
            return ((C9479a) apiClient).m59330a();
        }
        ApiClient delegate = apiClient.getDelegate();
        if (delegate instanceof C9479a) {
            return ((C9479a) delegate).m59330a();
        }
        return null;
    }

    /* renamed from: c */
    public final void m59335c(InterfaceC4584a interfaceC4584a, int i10) {
        if (interfaceC4584a != null) {
            try {
                interfaceC4584a.call(new Status(i10));
            } catch (RemoteException e10) {
                C9490l.m59350b("transport", "default failed call failed", e10);
            }
        }
    }
}
