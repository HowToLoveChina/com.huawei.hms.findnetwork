package p358i5;

import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.util.HashMap;

/* renamed from: i5.c */
/* loaded from: classes.dex */
public class C10444c {

    /* renamed from: a */
    public static final HashMap<String, Integer> f50401a;

    static {
        HashMap<String, Integer> map = new HashMap<>(32);
        f50401a = map;
        map.put("number", 1);
        map.put(CallLogCons.DATE, 3);
        map.put("duration", 2);
        map.put("type", 2);
        map.put("new", 2);
        map.put("countryiso", 1);
        map.put("voicemail_uri", 1);
        map.put("is_read", 7);
        map.put("geocoded_location", 1);
        map.put("lookup_uri", 1);
        map.put("matched_number", 1);
        map.put("normalized_number", 1);
        map.put("photo_id", 2);
        map.put("formatted_number", 1);
        map.put("_data", 1);
        map.put("has_content", 2);
        map.put("mime_type", 1);
        map.put("source_data", 1);
        map.put("source_package", 1);
        map.put(CommonConstant.ReqAccessTokenParam.STATE_LABEL, 2);
        map.put("numbertype", 2);
        map.put(CallLogCons.SUBSCRIPTION, 2);
        map.put("is_encrypted", 2);
        map.put(CallLogCons.SUBID, 2);
        map.put(CallLogCons.RINGTIME, 2);
        map.put("presentation", 2);
        map.put(CallLogCons.DATAUSAGE, 2);
        map.put(CallLogCons.FEATURES, 2);
        map.put(CallLogCons.SUBCOMPONENTNAME, 1);
        map.put(CallLogCons.SUBSCRIPTIONID, 1);
        map.put(CallLogCons.TRANSCRIPTION, 1);
        map.put("hw_is_satellite", 2);
        map.put("hicall_device_com_id", 1);
        map.put("hicall_aggregation_id", 1);
        map.put("data1", 1);
        map.put("data2", 1);
        map.put("data3", 1);
        map.put("data4", 1);
        map.put("data5", 1);
        map.put("meetime_call_type", 2);
        map.put("alias_name", 1);
    }

    /* renamed from: a */
    public static HashMap<String, Integer> m64240a() {
        return f50401a;
    }
}
