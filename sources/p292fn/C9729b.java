package p292fn;

import android.text.TextUtils;
import aq.C1011a;
import ck.C1443a;
import cn.C1461a;
import com.huawei.hicloud.bean.CompatibleInfo;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: fn.b */
/* loaded from: classes6.dex */
public class C9729b {

    /* renamed from: a */
    public final HashMap<String, HashMap<String, CompatibleInfo>> f47967a = new HashMap<>();

    /* renamed from: fn.b$a */
    public static final class a {

        /* renamed from: a */
        public static C9729b f47968a = new C9729b();
    }

    /* renamed from: a */
    public static C9729b m60694a() {
        return a.f47968a;
    }

    /* renamed from: b */
    public void m60695b() throws JSONException {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            C1461a.m8360w("CompatibleManager", "compatible config not exist");
            return;
        }
        String compatibleFeatures = hiCloudSysParamMapM60757p.getCompatibleFeatures();
        if (TextUtils.isEmpty(compatibleFeatures)) {
            C1461a.m8360w("CompatibleManager", "no feature need compatible");
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(compatibleFeatures);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                String string = jSONArray.getString(i10);
                if (!TextUtils.isEmpty(string)) {
                    String[] strArrSplit = string.split("\\.");
                    if (strArrSplit.length >= 4) {
                        String str = strArrSplit[0];
                        Locale locale = Locale.ENGLISH;
                        String lowerCase = str.toLowerCase(locale);
                        HashMap<String, CompatibleInfo> map = this.f47967a.get(lowerCase);
                        if (map == null) {
                            map = new HashMap<>();
                            this.f47967a.put(lowerCase, map);
                        }
                        String lowerCase2 = strArrSplit[1].toLowerCase(locale);
                        CompatibleInfo compatibleInfo = new CompatibleInfo();
                        compatibleInfo.setFeature(lowerCase2);
                        compatibleInfo.setBeginVersion(strArrSplit[2]);
                        compatibleInfo.setEndVersion(strArrSplit[3]);
                        map.put(lowerCase2, compatibleInfo);
                    }
                }
            }
        } catch (JSONException e10) {
            C1461a.m8358e("CompatibleManager", "initCompatibleFeature error: " + e10.toString());
        }
    }

    /* renamed from: c */
    public boolean m60696c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C1461a.m8358e("CompatibleManager", "illegal module or feature");
            return false;
        }
        Locale locale = Locale.ENGLISH;
        HashMap<String, CompatibleInfo> map = this.f47967a.get(str.toLowerCase(locale));
        if (map == null) {
            C1461a.m8358e("CompatibleManager", "compatible map is null");
            return false;
        }
        String lowerCase = str2.toLowerCase(locale);
        if (!map.containsKey(lowerCase)) {
            C1461a.m8358e("CompatibleManager", "feature not exist");
            return false;
        }
        CompatibleInfo compatibleInfo = map.get(lowerCase);
        if (compatibleInfo == null) {
            C1461a.m8358e("CompatibleManager", "no compatible info");
            return false;
        }
        String beginVersion = compatibleInfo.getBeginVersion();
        String endVersion = compatibleInfo.getEndVersion();
        if (!C1011a.m6165e(beginVersion) || !C1011a.m6165e(endVersion)) {
            C1461a.m8358e("CompatibleManager", "illegal version number");
            return false;
        }
        String str3 = C1443a.f6213a;
        if (str3.compareTo(beginVersion) < 0) {
            C1461a.m8358e("CompatibleManager", "illegal begin version");
            return false;
        }
        if (str3.compareTo(endVersion) >= 0) {
            C1461a.m8358e("CompatibleManager", "illegal end version");
            return false;
        }
        C1461a.m8359i("CompatibleManager", "feature need compatible: " + lowerCase);
        return true;
    }
}
