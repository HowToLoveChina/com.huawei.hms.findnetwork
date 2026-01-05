package p239dw;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.network.restclient.dnkeeper.InterfaceC5483d;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p857zv.Exception_C14389c;

/* renamed from: dw.w */
/* loaded from: classes9.dex */
public class C9355w {
    /* renamed from: a */
    public static String m58715a(String str) throws JSONException, Exception_C14389c {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TrackConstants$Opers.REQUEST, str);
            return jSONObject.toString();
        } catch (JSONException e10) {
            StringBuilder sbM58651a = C9320b.m58651a("getReqBody error : ");
            sbM58651a.append(e10.getMessage());
            throw new Exception_C14389c(1002L, sbM58651a.toString());
        }
    }

    /* renamed from: b */
    public static Map<String, String> m58716b(String str, String str2, String str3) {
        String string;
        HashMap map = new HashMap();
        map.put("Content-Type", InterfaceC5483d.f25084j);
        if (!TextUtils.isEmpty(str)) {
            map.put("X-App-ID", str);
        }
        map.put("X-Client-Version", "1.0.4.315");
        String str4 = Build.MODEL;
        map.put("terminalType", str4);
        map.put("X-Request-ID", str3);
        map.put("X-Credential-Terminal", "aucs");
        HashMap map2 = new HashMap();
        map2.put("terminalType", str4);
        map2.put("appPkgName", str2);
        map2.put("callTime", String.valueOf(System.currentTimeMillis()));
        if (map2.size() == 0) {
            string = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry entry : map2.entrySet()) {
                sb2.append((String) entry.getKey());
                sb2.append("=");
                sb2.append((String) entry.getValue());
                sb2.append(",");
            }
            sb2.deleteCharAt(sb2.lastIndexOf(","));
            string = sb2.toString();
        }
        map.put("X-RequestContext", string);
        return map;
    }
}
