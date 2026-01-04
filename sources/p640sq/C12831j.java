package p640sq;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.restclient.Response;
import com.huawei.hms.framework.network.restclient.RestClient;
import com.huawei.hms.framework.network.restclient.hwhttp.ResponseBody;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.IOException;
import java.util.Date;
import p345hq.C10334a;
import p460lq.C11335b;
import p530oq.C11988a;
import p557pq.C12203a;

/* renamed from: sq.j */
/* loaded from: classes8.dex */
public class C12831j {

    /* renamed from: sq.j$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f58580a;

        public a(Context context) {
            this.f58580a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C12831j.m77080d(this.f58580a);
            } catch (IOException unused) {
                C12836o.m77099d("GlobalDownloadUtil", "Error occured when download global Asyn.", true);
            }
        }
    }

    /* renamed from: a */
    public static void m77077a(Context context) {
        if (m77079c(context)) {
            C12203a.m73358d().execute(new a(context));
        }
    }

    /* renamed from: c */
    public static boolean m77079c(Context context) {
        C12836o.m77097b("GlobalDownloadUtil", "check needUpdateProp ", true);
        long jM77081e = m77081e(context);
        long time = new Date().getTime();
        if (jM77081e > time) {
            jM77081e = 0;
        }
        if (jM77081e == 0 || time - jM77081e > 86400000) {
            C12836o.m77097b("GlobalDownloadUtil", "need check prop", true);
            return true;
        }
        C12836o.m77097b("GlobalDownloadUtil", "no need check prop", true);
        return false;
    }

    /* renamed from: d */
    public static boolean m77080d(Context context) throws IOException {
        C12836o.m77097b("GlobalDownloadUtil", "Start syn download global.", true);
        String strM63646e = C10334a.m63642a().m63646e(context, "com.huawei.cloud.hwid", "Root");
        if (TextUtils.isEmpty(strM63646e)) {
            C12836o.m77099d("GlobalDownloadUtil", "asUrl is null", true);
            throw new IOException("asUrl is null");
        }
        String str = strM63646e + "/AccountServer/global_cfg_for_android_mobile.xml";
        RestClient restClientM77084a = C12833l.m77084a(context, strM63646e);
        if (restClientM77084a == null) {
            C12836o.m77099d("GlobalDownloadUtil", "restClient init Failed", true);
            throw new IOException("ERROR");
        }
        try {
            Response<ResponseBody> responseExecute = ((InterfaceC12823b) restClientM77084a.create(InterfaceC12823b.class)).m76976a(str).execute();
            if (responseExecute == null || responseExecute.getBody() == null || !responseExecute.isOK()) {
                return false;
            }
            C12836o.m77097b("GlobalDownloadUtil", "downloadGlobalCountrySiteSyn Succ", true);
            C12835n.m77095h(context, "global_cfg_for_android_mobile.xml", new String(responseExecute.getBody().bytes(), Constants.UTF_8));
            C11335b.m68098g().m68106h(context);
            C11988a.m72133k(context).m72142i("lastupdate", String.valueOf(System.currentTimeMillis()));
            return true;
        } catch (IOException e10) {
            C12836o.m77099d("GlobalDownloadUtil", "IOException", true);
            throw new IOException("IOException[don't set proxy]:" + e10.getClass().getSimpleName());
        }
    }

    /* renamed from: e */
    public static long m77081e(Context context) {
        long j10;
        try {
            return Long.parseLong(C11988a.m72133k(context).m72136c("lastupdate", "0"));
        } catch (Exception e10) {
            C12836o.m77099d("GlobalDownloadUtil", "get string lastUpdate " + e10.getClass().getSimpleName(), true);
            try {
                long jM72135b = C11988a.m72133k(context).m72135b("lastupdate", 0L);
                if (jM72135b > 0) {
                    try {
                        C11988a.m72133k(context).m72142i("lastupdate", String.valueOf(jM72135b));
                    } catch (Exception e11) {
                        e = e11;
                        j10 = jM72135b;
                        C12836o.m77099d("GlobalDownloadUtil", "get long lastUpdate " + e.getClass().getSimpleName(), true);
                        return j10;
                    }
                }
                return jM72135b;
            } catch (Exception e12) {
                e = e12;
                j10 = 0;
            }
        }
    }
}
