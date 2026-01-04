package p833z5;

import android.net.Uri;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.util.HashMap;
import p699v4.C13347p;

/* renamed from: z5.g */
/* loaded from: classes.dex */
public class C14137g {

    /* renamed from: a */
    public static final Uri f63214a = C13347p.m80079b("content://mms/part");

    /* renamed from: b */
    public static final HashMap<String, Integer> f63215b;

    static {
        HashMap<String, Integer> map = new HashMap<>(11);
        f63215b = map;
        map.put("_id", 3);
        map.put("mid", 3);
        map.put("seq", 2);
        map.put("ct", 1);
        map.put("chset", 7);
        map.put("fn", 1);
        map.put(JsbMapKeyNames.H5_CLIENT_ID, 1);
        map.put("cl", 1);
        map.put("_data", 1);
        map.put("text", 1);
        map.put("name", 1);
    }

    /* renamed from: a */
    public static HashMap<String, Integer> m84899a() {
        return f63215b;
    }
}
