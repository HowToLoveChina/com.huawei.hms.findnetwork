package com.huawei.hwcloudjs.p152c;

import com.huawei.hwcloudjs.p164f.C6659d;
import com.huawei.hwcloudjs.service.jsapi.JsCoreApi;
import com.huawei.hwcloudjs.service.jsmsg.NativeMsg;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hwcloudjs.c.a */
/* loaded from: classes8.dex */
public class C6619a {

    /* renamed from: a */
    private static final String f30781a = "EventUtils";

    /* renamed from: b */
    private static final String f30782b = "javascript:hbs.handleMessage(%s);";

    /* renamed from: c */
    private static final String f30783c = "_event_type";

    /* renamed from: d */
    private static final String f30784d = "_event_type_inner";

    /* renamed from: e */
    private static final String f30785e = "_event_type_3rd";

    /* renamed from: f */
    private static final String f30786f = "_event_index";

    /* renamed from: g */
    private static final String f30787g = "_event_args";

    /* renamed from: h */
    public static final String f30788h = "event_inner_error";

    /* renamed from: i */
    public static final String f30789i = "event_inner_ready";

    /* renamed from: j */
    public static final String f30790j = "ChannelMessageEvent_";

    /* renamed from: a */
    public static String m37757a(NativeMsg nativeMsg) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f30783c, f30785e);
            String type = nativeMsg.getType();
            if ("channelMessage".equals(type) && (nativeMsg instanceof JsCoreApi.ChannelMessageReq)) {
                JsCoreApi.ChannelMessageReq channelMessageReq = (JsCoreApi.ChannelMessageReq) nativeMsg;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f30790j);
                sb2.append(channelMessageReq.getChannelName());
                type = sb2.toString();
            }
            jSONObject.put(f30786f, type);
            jSONObject.put(f30787g, nativeMsg.toJsonString());
        } catch (JSONException unused) {
            C6659d.m37881b(f30781a, "gen3rdEvent error", true);
        }
        return String.format(Locale.ENGLISH, f30782b, jSONObject.toString());
    }

    /* renamed from: a */
    public static String m37758a(String str, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(f30783c, f30784d);
            jSONObject2.put(f30786f, str);
            jSONObject2.put(f30787g, jSONObject.toString());
        } catch (JSONException unused) {
            C6659d.m37881b(f30781a, "genInnerEvent error", true);
        }
        return String.format(Locale.ENGLISH, f30782b, jSONObject2.toString());
    }
}
