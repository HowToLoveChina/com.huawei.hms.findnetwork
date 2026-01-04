package p833z5;

import android.net.Uri;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.network.p129ai.C5799g0;
import java.util.HashMap;
import p699v4.C13347p;

/* renamed from: z5.i */
/* loaded from: classes.dex */
public class C14139i {

    /* renamed from: a */
    public static final Uri f63218a = C13347p.m80079b("content://sms");

    /* renamed from: b */
    public static final HashMap<String, Integer> f63219b;

    static {
        HashMap<String, Integer> map = new HashMap<>(23);
        f63219b = map;
        map.put("type", 2);
        map.put(CrashHianalyticsData.THREAD_ID, 3);
        map.put(C5799g0.f25867g, 1);
        map.put(CallLogCons.DATE, 3);
        map.put("read", 5);
        map.put("seen", 2);
        map.put("status", 2);
        map.put("subject", 1);
        map.put("body", 1);
        map.put("protocol", 2);
        map.put("creator", 1);
        map.put("reply_path_present", 5);
        map.put("service_center", 1);
        map.put("locked", 2);
        map.put("error_code", 2);
        map.put("msg_src", 2);
        map.put("msg_id", 1);
        map.put("date_sent", 3);
        map.put(CallLogCons.SUBID, 2);
        map.put("phone_id", 2);
        map.put("network_type", 7);
        map.put("group_id", 2);
        map.put("addr_body", 1);
        map.put("time_body", 1);
        map.put("hw_is_satellite", 2);
    }

    /* renamed from: a */
    public static HashMap<String, Integer> m84902a() {
        return f63219b;
    }
}
