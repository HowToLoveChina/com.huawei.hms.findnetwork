package bb;

import android.text.TextUtils;
import ck.C1443a;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import fk.C9721b;
import gp.C10028c;
import java.util.ArrayList;
import org.json.JSONArray;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0228m0;
import p260ek.C9499a;
import p514o9.C11839m;
import p514o9.C11842p;
import p709vj.C13452e;
import p846zj.C14306d;
import tm.C13040c;

/* renamed from: bb.a */
/* loaded from: classes3.dex */
public class C1160a {

    /* renamed from: a */
    public static final String f5459a = "a";

    /* renamed from: a */
    public static void m7250a(C4609l c4609l) {
        String str = C11842p.m70762R0() ? "pad" : "phone";
        int iM1225Y = C0209d.m1225Y(C0213f.m1377a());
        String strM1324x0 = C0209d.m1324x0();
        Object obj = C1443a.f6213a;
        c4609l.set("x-hw-app-version", obj);
        c4609l.set("x-hw-app-id", "10055832");
        c4609l.set("x-hw-device-type", Integer.valueOf(C13452e.m80781L().m80974u()));
        c4609l.set("x-hw-device-id", C0209d.m1209S1(C13452e.m80781L().m80954p()));
        c4609l.set("x-hw-deviceUUID", C0209d.m1209S1(C0228m0.m1597b().m1599c()));
        c4609l.set("x-hw-os-brand", C0209d.m1276l0());
        c4609l.set("x-hw-network", C0209d.m1228Z(iM1225Y));
        if (TextUtils.isEmpty(strM1324x0)) {
            strM1324x0 = "";
        }
        c4609l.set("x-hw-deviceUDID", strM1324x0);
        c4609l.set("x-hw-device-category", str);
        c4609l.set("x-hw-app-package-name", "com.huawei.hidisk");
        c4609l.set(JsbMapKeyNames.H5_USER_ID, C13452e.m80781L().m80971t0());
        c4609l.set("version", obj);
        c4609l.set("x-hw-device-manufacturer", C0209d.m1164E());
        c4609l.set("x-hw-device-brand", C0209d.m1160D());
        c4609l.set("x-hw-account-brand-id", C14306d.m85201b());
        c4609l.set("x-hw-app-brand-id", C0209d.m1156C());
        c4609l.set("x-hw-os", C0209d.m1315v());
    }

    /* renamed from: b */
    public static String m7251b(C4609l c4609l) {
        if (c4609l == null) {
            C11839m.m70687e(f5459a, "headers is null");
            return null;
        }
        Object obj = c4609l.get("X-New-Start-Cursor");
        if (!(obj instanceof ArrayList)) {
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        if (arrayList.isEmpty()) {
            return null;
        }
        Object obj2 = arrayList.get(0);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        return null;
    }

    /* renamed from: c */
    public static String m7252c() {
        if (!C10028c.m62182c0().m62221H1()) {
            C11839m.m70689w(f5459a, "getUserDomain return empty as terms is not confirmed ");
            return "";
        }
        try {
            C11839m.m70686d(f5459a, "start getUserDomain get cloud album url");
            return C13040c.m78609F().m78646f0();
        } catch (C9721b e10) {
            C11839m.m70687e(f5459a, "getUserDomain get cloud album url error ," + e10.toString());
            return "";
        }
    }

    /* renamed from: d */
    public static String m7253d(C4616s c4616s) {
        JSONArray jSONArrayM59433a;
        try {
            if (TextUtils.isEmpty(c4616s.m28319c())) {
                return "1";
            }
            String strM59436d = C9499a.m59436d(c4616s.m28319c(), VastAttribute.ERROR);
            return (TextUtils.isEmpty(strM59436d) || (jSONArrayM59433a = C9499a.m59433a(strM59436d, "errorDetail")) == null || jSONArrayM59433a.optJSONObject(0) == null) ? "1" : C9499a.m59436d(jSONArrayM59433a.optJSONObject(0).toString(), AddressConstants.Extras.EXTRA_NAME_ERR_CODE);
        } catch (Exception e10) {
            C11839m.m70687e(f5459a, "parseErrorCode error : " + e10.toString());
            return "1";
        }
    }
}
