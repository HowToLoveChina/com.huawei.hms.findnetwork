package p239dw;

import com.huawei.hms.network.httpclient.Submit;
import com.huawei.hms.network.restclient.anno.Body;
import com.huawei.hms.network.restclient.anno.GET;
import com.huawei.hms.network.restclient.anno.HeaderMap;
import com.huawei.hms.network.restclient.anno.POST;
import com.huawei.hms.network.restclient.anno.Url;
import java.util.Map;

/* renamed from: dw.r */
/* loaded from: classes9.dex */
public interface InterfaceC9350r {
    @GET
    /* renamed from: a */
    Submit<String> m58705a(@Url String str, @HeaderMap Map<String, String> map);

    @POST
    /* renamed from: a */
    Submit<String> m58706a(@Url String str, @HeaderMap Map<String, String> map, @Body String str2);
}
