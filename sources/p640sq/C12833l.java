package p640sq;

import android.content.Context;
import com.huawei.hms.framework.network.restclient.RestClient;
import com.huawei.hms.framework.network.restclient.RestClientGlobalInstance;

/* renamed from: sq.l */
/* loaded from: classes8.dex */
public class C12833l {
    /* renamed from: a */
    public static RestClient m77084a(Context context, String str) {
        RestClientGlobalInstance.getInstance().init(context);
        return new RestClient.Builder(context).baseUrl(str).build();
    }
}
