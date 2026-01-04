package p683um;

import android.text.TextUtils;
import com.huawei.cloud.services.drive.DriveScopes;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.sns.HuaweiSns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p399jk.AbstractC10896a;
import p681uj.C13193j;

/* renamed from: um.b */
/* loaded from: classes6.dex */
public class C13221b {

    /* renamed from: a */
    public static final HashMap<String, String> f59865a = new HashMap<>();

    /* renamed from: a */
    public static List<Scope> m79454a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Scope(m79456c("MOBILE_FLAG")));
        arrayList.add(new Scope(m79456c("MOBILE_NUMBER")));
        arrayList.add(new Scope(m79456c("LOGIN_ACCOUNT")));
        arrayList.add(new Scope(m79456c("BASE_PROFILE")));
        return arrayList;
    }

    /* renamed from: b */
    public static List<String> m79455b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(m79456c("MOBILE_FLAG"));
        arrayList.add(m79456c("MOBILE_NUMBER"));
        arrayList.add(m79456c("LOGIN_ACCOUNT"));
        arrayList.add(m79456c("BASE_PROFILE"));
        return arrayList;
    }

    /* renamed from: c */
    public static String m79456c(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        m79458e();
        return f59865a.getOrDefault(str, str);
    }

    /* renamed from: d */
    public static List<Scope> m79457d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(HuaweiSns.SCOPE_SNS_READ);
        arrayList.add(HuaweiSns.SCOPE_SNS_WRITE);
        arrayList.add(C13193j.f59737a);
        arrayList.add(new Scope(m79456c("DEVICE_INFO")));
        arrayList.add(new Scope(C13193j.f59738b));
        arrayList.add(new Scope(DriveScopes.SCOPE_DRIVE));
        arrayList.add(new Scope(DriveScopes.SCOPE_DRIVE_APPDATA));
        arrayList.add(new Scope(m79456c("COUNTRY_SCOPE")));
        arrayList.add(new Scope(m79456c("CLOUD_PHOTO_SCOPE")));
        arrayList.add(new Scope(m79456c("CLOUD_BACKUP_SCOPE")));
        arrayList.add(new Scope(m79456c("ACCOUNT_AGE_RANGE")));
        arrayList.addAll(m79454a());
        arrayList.add(new Scope(m79456c("ACCOUNT_FLAGS")));
        arrayList.add(new Scope(m79456c("SCOPE_STATE_REGISTER")));
        return arrayList;
    }

    /* renamed from: e */
    public static void m79458e() throws JSONException {
        try {
            HashMap<String, String> map = f59865a;
            if (!map.isEmpty()) {
                AbstractC10896a.m65888w("HmsScopeManager", "initScope size is " + map.size());
                return;
            }
            AbstractC10896a.m65887i("HmsScopeManager", "initScope start ," + map.size());
            JSONObject jSONObject = new JSONObject(C0209d.m1290o2(C0213f.m1377a().getAssets().open("Scope.json")));
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String string = jSONObject.getString(next);
                AbstractC10896a.m65885d("HmsScopeManager", "initScope ::  " + next + " : " + string);
                f59865a.put(next, string);
            }
            AbstractC10896a.m65887i("HmsScopeManager", "initScope end , " + f59865a.size());
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HmsScopeManager", "initScope:" + e10);
        }
    }
}
