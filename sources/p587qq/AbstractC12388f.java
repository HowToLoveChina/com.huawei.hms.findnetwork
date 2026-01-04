package p587qq;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.framework.network.restclient.Response;
import com.huawei.hms.framework.network.restclient.RestClient;
import com.huawei.hms.framework.network.restclient.ResultCallback;
import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import com.huawei.hms.framework.network.restclient.hwhttp.ResponseBody;
import com.huawei.openalliance.p169ad.constant.Constants;
import hu.C10343b;
import p432kq.AbstractC11138j;
import p557pq.C12203a;
import p640sq.C12833l;
import p640sq.C12836o;
import p640sq.InterfaceC12823b;

/* renamed from: qq.f */
/* loaded from: classes8.dex */
public abstract class AbstractC12388f<T extends AbstractC11138j> {

    /* renamed from: e */
    public static final String f57207e = "f";

    /* renamed from: a */
    public T f57208a;

    /* renamed from: b */
    public Context f57209b;

    /* renamed from: c */
    public String f57210c;

    /* renamed from: d */
    public d f57211d;

    /* renamed from: qq.f$a */
    public class a implements Runnable {

        /* renamed from: qq.f$a$a */
        public class C14512a implements ResultCallback<ResponseBody> {
            public C14512a() {
            }

            @Override // com.huawei.hms.framework.network.restclient.ResultCallback
            public void onFailure(Throwable th2) {
                C12836o.m77097b(AbstractC12388f.f57207e, "onFailure", true);
                AbstractC12388f.this.m74453b(2005, "request fail.");
            }

            @Override // com.huawei.hms.framework.network.restclient.ResultCallback
            public void onResponse(Response<ResponseBody> response) {
                C12836o.m77097b(AbstractC12388f.f57207e, "request onResponse", true);
                if (response == null) {
                    AbstractC12388f.this.m74453b(2005, "response is null.");
                } else {
                    AbstractC12388f abstractC12388f = AbstractC12388f.this;
                    abstractC12388f.mo74447d(abstractC12388f.f57208a, response);
                }
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC12388f abstractC12388f = AbstractC12388f.this;
            RestClient restClientM77084a = C12833l.m77084a(abstractC12388f.f57209b, abstractC12388f.f57210c);
            if (restClientM77084a == null) {
                C12836o.m77099d(AbstractC12388f.f57207e, "restClient is null.", true);
                AbstractC12388f.this.m74453b(2003, "restClient is null.");
                return;
            }
            InterfaceC12823b interfaceC12823b = (InterfaceC12823b) restClientM77084a.create(InterfaceC12823b.class);
            try {
                String strMo37999a = AbstractC12388f.this.f57208a.mo37999a();
                String strMo38002d = AbstractC12388f.this.f57208a.mo38002d();
                C12836o.m77097b(AbstractC12388f.f57207e, "request url  >>> " + strMo38002d + AbstractC12388f.this.f57210c, false);
                C12836o.m77097b(AbstractC12388f.f57207e, "request body >>> " + strMo37999a, false);
                interfaceC12823b.m76977a(AbstractC12388f.this.f57210c, RequestBody.create(" text/html; charset=utf-8", strMo37999a.getBytes(Constants.UTF_8))).enqueue(new C14512a());
            } catch (Exception e10) {
                C12836o.m77099d(AbstractC12388f.f57207e, "Exception:" + e10.getClass().getSimpleName(), true);
                AbstractC12388f.this.m74453b(2015, e10.getMessage());
            }
        }
    }

    /* renamed from: qq.f$b */
    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ C10343b f57214a;

        public b(C10343b c10343b) {
            this.f57214a = c10343b;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC12388f.this.f57211d.mo38164a(this.f57214a);
        }
    }

    /* renamed from: qq.f$c */
    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ int f57216a;

        /* renamed from: b */
        public final /* synthetic */ String f57217b;

        public c(int i10, String str) {
            this.f57216a = i10;
            this.f57217b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC12388f.this.f57211d.mo38163a(this.f57216a, this.f57217b);
        }
    }

    /* renamed from: qq.f$d */
    public interface d {
        /* renamed from: a */
        void mo38163a(int i10, String str);

        /* renamed from: a */
        void mo38164a(C10343b c10343b);
    }

    /* renamed from: a */
    public void m74452a() {
        C12203a.m73358d().execute(new a());
    }

    /* renamed from: b */
    public void m74453b(int i10, String str) {
        if (this.f57211d == null) {
            C12836o.m77097b(f57207e, "mCallback is null", true);
        } else {
            new Handler(Looper.getMainLooper()).post(new c(i10, str));
        }
    }

    /* renamed from: c */
    public void m74454c(C10343b c10343b) {
        if (this.f57211d == null) {
            C12836o.m77097b(f57207e, "mCallback is null", true);
        } else {
            new Handler(Looper.getMainLooper()).post(new b(c10343b));
        }
    }

    /* renamed from: d */
    public abstract void mo74447d(T t10, Response<ResponseBody> response);
}
