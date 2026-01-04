package com.huawei.hms.videokit.player;

import com.huawei.hms.network.httpclient.RequestBody;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.Submit;
import com.huawei.hms.network.restclient.anno.Body;
import com.huawei.hms.network.restclient.anno.FieldMap;
import com.huawei.hms.network.restclient.anno.FormUrlEncoded;
import com.huawei.hms.network.restclient.anno.HeaderMap;
import com.huawei.hms.network.restclient.anno.POST;
import com.huawei.hms.network.restclient.anno.Url;
import java.util.Map;

/* renamed from: com.huawei.hms.videokit.player.u */
/* loaded from: classes8.dex */
public interface InterfaceC6601u {
    @POST
    /* renamed from: a */
    Submit<ResponseBody> m37696a(@Url String str, @HeaderMap Map<String, String> map, @Body RequestBody requestBody);

    @FormUrlEncoded
    @POST
    /* renamed from: a */
    Submit<ResponseBody> m37697a(@Url String str, @HeaderMap Map<String, String> map, @FieldMap Map<String, String> map2);
}
