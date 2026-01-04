package p432kq;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.framework.network.restclient.Response;
import com.huawei.hms.framework.network.restclient.RestClient;
import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import com.huawei.hms.framework.network.restclient.hwhttp.ResponseBody;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import p345hq.C10334a;
import p557pq.C12203a;
import p640sq.C12833l;
import p640sq.C12836o;
import p640sq.C12843v;
import p640sq.InterfaceC12823b;

/* renamed from: kq.d */
/* loaded from: classes8.dex */
public class AsyncTaskC11132d extends AsyncTask<AbstractC11138j, Void, Response<ResponseBody>> {

    /* renamed from: a */
    public AbstractC11138j f52423a;

    /* renamed from: b */
    public InterfaceC11137i f52424b;

    /* renamed from: c */
    public Context f52425c;

    /* renamed from: d */
    public String f52426d;

    /* renamed from: e */
    public Handler f52427e = new a(Looper.getMainLooper());

    /* renamed from: kq.d$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            int i10 = message.what;
            if (i10 == -2) {
                AsyncTaskC11132d.this.f52424b.onFailure(message.arg1, (String) message.obj);
            } else if (i10 == -1) {
                AsyncTaskC11132d.this.f52424b.onFailure(-1, "");
            } else if (i10 == 200) {
                AsyncTaskC11132d.this.f52424b.onSuccess((String) message.obj);
            }
            super.handleMessage(message);
        }
    }

    /* renamed from: kq.d$b */
    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Response f52429a;

        public b(Response response) {
            this.f52429a = response;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Response response = this.f52429a;
                if (response != null) {
                    int code = response.getCode();
                    if (200 != code || this.f52429a.getBody() == null) {
                        String str = new String(this.f52429a.getErrorBody(), Constants.UTF_8);
                        C12836o.m77097b("GwRequest", "errorData = " + str, false);
                        Message messageObtain = Message.obtain();
                        messageObtain.what = -2;
                        messageObtain.obj = str;
                        messageObtain.arg1 = code;
                        AsyncTaskC11132d.this.f52427e.sendMessage(messageObtain);
                    } else {
                        String str2 = new String(((ResponseBody) this.f52429a.getBody()).bytes(), Constants.UTF_8);
                        Message messageObtain2 = Message.obtain();
                        messageObtain2.what = 200;
                        messageObtain2.obj = str2;
                        AsyncTaskC11132d.this.f52427e.sendMessage(messageObtain2);
                    }
                } else {
                    C12836o.m77097b("GwRequest", "response null", true);
                    AsyncTaskC11132d.this.f52427e.sendEmptyMessage(-1);
                }
            } catch (IOException unused) {
                C12836o.m77099d("GwRequest", "IOException", true);
                AsyncTaskC11132d.this.f52427e.sendEmptyMessage(-1);
            } catch (RuntimeException unused2) {
                C12836o.m77099d("GwRequest", "RuntimeException", true);
                AsyncTaskC11132d.this.f52427e.sendEmptyMessage(-1);
            }
        }
    }

    public AsyncTaskC11132d(Context context, String str, AbstractC11138j abstractC11138j, InterfaceC11137i interfaceC11137i) {
        this.f52425c = context;
        this.f52426d = str;
        this.f52423a = abstractC11138j;
        this.f52424b = interfaceC11137i;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Response<ResponseBody> doInBackground(AbstractC11138j... abstractC11138jArr) {
        C12836o.m77097b("GwRequest", "doInBackground", true);
        Map<String, String> mapM63643b = C10334a.m63642a().m63643b(this.f52425c, this.f52426d, "com.huawei.cloud.hwid");
        if (mapM63643b == null) {
            C12836o.m77097b("GwRequest", "grs urlMap null", true);
            return null;
        }
        String str = mapM63643b.get("GwSilentCodeUrl");
        C12836o.m77097b("GwRequest", "gwSilentCodeUrl = " + str, false);
        if (TextUtils.isEmpty(str)) {
            C12836o.m77097b("GwRequest", "gwSilentCodeUrl null return", true);
            return null;
        }
        RestClient restClientM77084a = C12833l.m77084a(this.f52425c, str);
        if (restClientM77084a == null) {
            C12836o.m77099d("GwRequest", "restClient init failed", true);
            return null;
        }
        InterfaceC12823b interfaceC12823b = (InterfaceC12823b) restClientM77084a.create(InterfaceC12823b.class);
        C12836o.m77097b("GwRequest", "url = " + str + this.f52423a.mo38001c(), false);
        try {
            String strMo38000b = this.f52423a.mo38000b();
            C12836o.m77097b("GwRequest", "requestData = " + strMo38000b, false);
            return interfaceC12823b.m76978a(this.f52423a.mo38001c(), RequestBody.create(RequestBody.HEAD_VALUE_CONTENT_TYPE_URLENCODED, strMo38000b.getBytes(Constants.UTF_8)), m66939b()).execute();
        } catch (IOException unused) {
            C12836o.m77099d("GwRequest", "IOException", true);
            return null;
        } catch (RuntimeException unused2) {
            C12836o.m77099d("GwRequest", "IOException", true);
            this.f52424b.onFailure(-1, "");
            return null;
        }
    }

    /* renamed from: b */
    public Map<String, String> m66939b() {
        HashMap map = new HashMap();
        String strM77124a = C12843v.m77124a();
        if (TextUtils.isEmpty(strM77124a)) {
            strM77124a = "unkown";
        }
        map.put("terminal-type", strM77124a);
        C12836o.m77097b("GwRequest", "terminal-type:" + strM77124a, false);
        return map;
    }

    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Response<ResponseBody> response) {
        C12203a.m73358d().execute(new b(response));
    }
}
