package p833z5;

import android.net.Uri;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.network.embedded.C6148x2;
import java.util.HashMap;
import p699v4.C13347p;

/* renamed from: z5.h */
/* loaded from: classes.dex */
public class C14138h {

    /* renamed from: a */
    public static final Uri f63216a = C13347p.m80079b("content://mms");

    /* renamed from: b */
    public static final HashMap<String, Integer> f63217b;

    static {
        HashMap<String, Integer> map = new HashMap<>(37);
        f63217b = map;
        map.put("_id", 3);
        map.put(CrashHianalyticsData.THREAD_ID, 3);
        map.put(CallLogCons.DATE, 3);
        map.put("date_sent", 3);
        map.put("msg_box", 2);
        map.put("read", 2);
        map.put("creator", 1);
        map.put("m_id", 1);
        map.put("sub", 1);
        map.put("sub_cs", 2);
        map.put("ct_t", 1);
        map.put("ct_l", 1);
        map.put("exp", 2);
        map.put("m_cls", 1);
        map.put("m_type", 2);
        map.put("v", 2);
        map.put("m_size", 7);
        map.put("pri", 8);
        map.put("rr", 8);
        map.put("rpt_a", 8);
        map.put("resp_st", 8);
        map.put("st", 7);
        map.put("tr_id", 1);
        map.put("retr_st", 8);
        map.put("retr_txt", 1);
        map.put("retr_txt_cs", 8);
        map.put(C6148x2.READ_STATUS, 8);
        map.put("ct_cls", 8);
        map.put("resp_txt", 1);
        map.put("d_tm", 8);
        map.put("d_rpt", 8);
        map.put("locked", 2);
        map.put("seen", 2);
        map.put(CallLogCons.SUBID, 2);
        map.put("phone_id", 2);
        map.put("network_type", 8);
    }

    /* renamed from: a */
    public static HashMap<String, Integer> m84900a() {
        return f63217b;
    }

    /* renamed from: b */
    public static boolean m84901b(int i10) {
        return i10 == 128 || i10 == 132;
    }
}
