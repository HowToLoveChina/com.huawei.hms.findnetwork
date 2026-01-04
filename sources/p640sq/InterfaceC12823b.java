package p640sq;

import com.huawei.hms.framework.network.restclient.Submit;
import com.huawei.hms.framework.network.restclient.annotate.Body;
import com.huawei.hms.framework.network.restclient.annotate.GET;
import com.huawei.hms.framework.network.restclient.annotate.HeaderMap;
import com.huawei.hms.framework.network.restclient.annotate.POST;
import com.huawei.hms.framework.network.restclient.annotate.Url;
import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import com.huawei.hms.framework.network.restclient.hwhttp.ResponseBody;
import java.util.Map;

/* renamed from: sq.b */
/* loaded from: classes8.dex */
public interface InterfaceC12823b {
    @GET
    /* renamed from: a */
    Submit<ResponseBody> m76976a(@Url String str);

    @POST
    /* renamed from: a */
    Submit<ResponseBody> m76977a(@Url String str, @Body RequestBody requestBody);

    @POST
    /* renamed from: a */
    Submit<ResponseBody> m76978a(@Url String str, @Body RequestBody requestBody, @HeaderMap Map<String, String> map);
}
