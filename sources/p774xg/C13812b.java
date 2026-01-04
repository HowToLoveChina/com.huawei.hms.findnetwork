package p774xg;

import android.content.ContentResolver;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.UserHandle;
import com.hihonor.android.provider.SettingsEx;
import com.huawei.android.provider.SettingsEx;
import com.huawei.android.remotecontrol.config.ParamConfig;
import com.huawei.hms.findnetwork.comm.request.bean.DisConnectLocation;
import com.huawei.hms.findnetwork.comm.request.bean.wear.OfflineLocationBean;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.p171db.bean.UserCloseRecord;
import java.util.ArrayList;
import mt.C11522i;
import p015ak.C0209d;
import p015ak.C0224k0;
import p244e1.AbstractC9377a;
import p244e1.C9378b;
import p244e1.C9380d;
import p244e1.C9381e;
import p514o9.C11839m;
import p809yg.C13981a;

/* renamed from: xg.b */
/* loaded from: classes4.dex */
public class C13812b {
    /* renamed from: a */
    public static String m82830a(DisConnectLocation disConnectLocation) {
        if (disConnectLocation == null || disConnectLocation.getFloorAcc() < 10) {
            return "";
        }
        if (disConnectLocation.getFloor() == -100 || disConnectLocation.getFloor() == 0) {
            C13981a.m83988e("LocationUtils", "getDisconnectFloor the floor is invalid.");
            return "";
        }
        return disConnectLocation.getFloor() + "F";
    }

    /* renamed from: b */
    public static String m82831b(Location location) {
        String string;
        if (m82845p(location, "floorAcc")) {
            return "";
        }
        Bundle extras = location.getExtras();
        return (extras.getInt("floorAcc") >= 10 && extras.containsKey("floor") && (string = extras.getString("floor")) != null) ? string : "";
    }

    /* renamed from: c */
    public static String m82832c(Location location) {
        return m82845p(location, "floorAcc") ? "" : String.valueOf(location.getExtras().getInt("floorAcc"));
    }

    /* renamed from: d */
    public static String m82833d(Location location) {
        String string;
        return (m82845p(location, "locCpTransId") || (string = location.getExtras().getString("locCpTransId")) == null) ? "" : string;
    }

    /* renamed from: e */
    public static String m82834e(Location location) {
        String string;
        return (m82845p(location, "locFenceTime") || (string = location.getExtras().getString("locFenceTime")) == null) ? "" : string;
    }

    /* renamed from: f */
    public static String m82835f(Location location) {
        String string;
        return (m82845p(location, "locSessionId") || (string = location.getExtras().getString("locSessionId")) == null) ? "" : string;
    }

    /* renamed from: g */
    public static int m82836g(Location location) {
        return m82845p(location, "locationRouter") ? ParamConfig.getInstance().getLocationRouter() : location.getExtras().getInt("locationRouter");
    }

    /* renamed from: h */
    public static int m82837h(Location location) {
        if (m82845p(location, "delayTime")) {
            return 0;
        }
        long j10 = location.getExtras().getLong("delayTime", 0L);
        return (int) (j10 >= 0 ? j10 : 0L);
    }

    /* renamed from: i */
    public static String m82838i(OfflineLocationBean offlineLocationBean) {
        if (offlineLocationBean == null || offlineLocationBean.getIndoor() != 1 || offlineLocationBean.getFloorAcc() < 10) {
            return "";
        }
        if (offlineLocationBean.getFloor() == -100) {
            C13981a.m83988e("LocationUtils", "getOfflineFloor the floor is invalid.");
            return "";
        }
        return offlineLocationBean.getFloor() + "F";
    }

    /* renamed from: j */
    public static int m82839j(Context context, String str, int i10) {
        if (context == null) {
            C13981a.m83988e("LocationUtils", "Secure putStringForUser context null");
            return i10;
        }
        try {
            ContentResolver contentResolver = context.getContentResolver();
            return C0209d.m1277l1() ? SettingsEx.Secure.getIntForUser(contentResolver, str, i10, 0) : SettingsEx.Secure.getIntForUser(contentResolver, str, i10, 0);
        } catch (Exception e10) {
            C11839m.m70687e("LocationUtils", "Secure getIntForUser exception:" + e10.getMessage());
            return i10;
        }
    }

    /* renamed from: k */
    public static String m82840k(Object obj) {
        C9378b c9378bM58766m;
        C9378b c9378b;
        String str;
        String str2;
        String str3;
        ArrayList arrayList;
        int i10;
        String strM58794N;
        int iM58791K;
        long jM58793M;
        double dM58788G;
        double dM58788G2;
        float fM58789H;
        String strM58794N2;
        String str4;
        C13981a.m83987d("queryStalkingTagRecords", "queryStalkingTagRecords raw data:" + obj.toString());
        try {
            c9378bM58766m = AbstractC9377a.m58766m(obj.toString());
        } catch (C9380d unused) {
            C13981a.m83988e("LocationUtils", "getStalkingTagString array error.");
            c9378bM58766m = null;
        }
        String str5 = "\"";
        String str6 = "\\\\\"";
        String str7 = "\\\"";
        if (c9378bM58766m == null) {
            return obj.toString().replace("\\\"", "\\\\\"").replace("\"", "\\\"");
        }
        ArrayList arrayList2 = new ArrayList();
        int i11 = 0;
        while (i11 < c9378bM58766m.size()) {
            Object obj2 = c9378bM58766m.get(i11);
            if (obj2 != null && (obj2 instanceof C9381e)) {
                C9381e c9381e = (C9381e) obj2;
                try {
                    strM58794N = c9381e.m58794N("macAddress");
                    iM58791K = c9381e.m58791K("rssi");
                    jM58793M = c9381e.m58793M(UserCloseRecord.TIME_STAMP);
                    dM58788G = c9381e.m58788G(JsbMapKeyNames.H5_LOC_LAT);
                    dM58788G2 = c9381e.m58788G(JsbMapKeyNames.H5_LOC_LON);
                    c9378b = c9378bM58766m;
                    try {
                        fM58789H = c9381e.m58789H("accuracy");
                        str = str5;
                        try {
                            strM58794N2 = c9381e.m58794N("mStandbyDevice");
                            str2 = str6;
                        } catch (C9380d unused2) {
                            str2 = str6;
                            str3 = str7;
                            arrayList = arrayList2;
                            i10 = i11;
                            C13981a.m83988e("LocationUtils", "getStalkingTagString obj error.");
                            i11 = i10 + 1;
                            arrayList2 = arrayList;
                            c9378bM58766m = c9378b;
                            str5 = str;
                            str6 = str2;
                            str7 = str3;
                        }
                    } catch (C9380d unused3) {
                        str = str5;
                        str2 = str6;
                        str3 = str7;
                        arrayList = arrayList2;
                        i10 = i11;
                        C13981a.m83988e("LocationUtils", "getStalkingTagString obj error.");
                        i11 = i10 + 1;
                        arrayList2 = arrayList;
                        c9378bM58766m = c9378b;
                        str5 = str;
                        str6 = str2;
                        str7 = str3;
                    }
                } catch (C9380d unused4) {
                    c9378b = c9378bM58766m;
                }
                try {
                    int iM58791K2 = c9381e.m58791K("floor");
                    str3 = str7;
                    try {
                        int iM58791K3 = c9381e.m58791K("indoor");
                        i10 = i11;
                        try {
                            int iM58791K4 = c9381e.m58791K("floorAcc");
                            StringBuilder sb2 = new StringBuilder();
                            ArrayList arrayList3 = arrayList2;
                            try {
                                sb2.append("getStalkingTagString: ");
                                sb2.append(iM58791K3);
                                sb2.append(", ");
                                sb2.append(iM58791K4);
                                C13981a.m83989i("LocationUtils", sb2.toString());
                                str4 = "";
                                if (iM58791K4 >= 10 && iM58791K2 != -100 && iM58791K2 != 0) {
                                    str4 = iM58791K2 + "F";
                                }
                                arrayList = arrayList3;
                            } catch (C9380d unused5) {
                                arrayList = arrayList3;
                            }
                        } catch (C9380d unused6) {
                            arrayList = arrayList2;
                        }
                    } catch (C9380d unused7) {
                        arrayList = arrayList2;
                        i10 = i11;
                        C13981a.m83988e("LocationUtils", "getStalkingTagString obj error.");
                        i11 = i10 + 1;
                        arrayList2 = arrayList;
                        c9378bM58766m = c9378b;
                        str5 = str;
                        str6 = str2;
                        str7 = str3;
                    }
                    try {
                        arrayList.add("{\"macAddress\":\"" + strM58794N + "\",\"rssi\":" + iM58791K + ",\"timeStamp\":" + jM58793M + ",\"latitude\":" + dM58788G + ",\"longitude\":" + dM58788G2 + ",\"accuracy\":" + fM58789H + ",\"mStandbyDevice\":\"" + strM58794N2 + "\",\"floor\":\"" + str4 + "\"}");
                    } catch (C9380d unused8) {
                        C13981a.m83988e("LocationUtils", "getStalkingTagString obj error.");
                        i11 = i10 + 1;
                        arrayList2 = arrayList;
                        c9378bM58766m = c9378b;
                        str5 = str;
                        str6 = str2;
                        str7 = str3;
                    }
                } catch (C9380d unused9) {
                    str3 = str7;
                    arrayList = arrayList2;
                    i10 = i11;
                    C13981a.m83988e("LocationUtils", "getStalkingTagString obj error.");
                    i11 = i10 + 1;
                    arrayList2 = arrayList;
                    c9378bM58766m = c9378b;
                    str5 = str;
                    str6 = str2;
                    str7 = str3;
                }
            } else {
                c9378b = c9378bM58766m;
                str = str5;
                str2 = str6;
                str3 = str7;
                arrayList = arrayList2;
                i10 = i11;
            }
            i11 = i10 + 1;
            arrayList2 = arrayList;
            c9378bM58766m = c9378b;
            str5 = str;
            str6 = str2;
            str7 = str3;
        }
        String str8 = str7;
        return arrayList2.toString().replace(str8, str6).replace(str5, str8);
    }

    /* renamed from: l */
    public static String m82841l(Context context, String str) {
        if (context == null) {
            C13981a.m83988e("LocationUtils", "Secure putStringForUser context null");
            return "";
        }
        try {
            ContentResolver contentResolver = context.getContentResolver();
            return C0209d.m1277l1() ? SettingsEx.System.getStringForUser(contentResolver, str, 0) : SettingsEx.System.getStringForUser(contentResolver, str, 0);
        } catch (Exception e10) {
            C11839m.m70687e("LocationUtils", "Secure getStringForUser exception:" + e10.getMessage());
            return "";
        }
    }

    /* renamed from: m */
    public static String m82842m(C11522i c11522i) {
        if (c11522i == null || c11522i.m68768d() < 10) {
            return "";
        }
        if (c11522i.m68767c() == -100 || c11522i.m68767c() == 0) {
            C13981a.m83988e("LocationUtils", "getTagBestFloor the floor is invalid.");
            return "";
        }
        return c11522i.m68767c() + "F";
    }

    /* renamed from: n */
    public static UserHandle m82843n(int i10) {
        try {
            return (UserHandle) UserHandle.class.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(i10));
        } catch (Exception e10) {
            C11839m.m70687e("LocationUtils", "getUserHandle error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: o */
    public static boolean m82844o(Location location) {
        return !m82831b(location).equals("");
    }

    /* renamed from: p */
    public static boolean m82845p(Location location, String str) {
        Bundle extras;
        if (location == null || (extras = location.getExtras()) == null) {
            return true;
        }
        return !extras.containsKey(str);
    }

    /* renamed from: q */
    public static boolean m82846q(Context context) {
        C13981a.m83989i("LocationUtils", "isLocationEnabledForUser");
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService(JsbMapKeyNames.H5_LOC);
            return ((Boolean) locationManager.getClass().getMethod("isLocationEnabledForUser", UserHandle.class).invoke(locationManager, m82843n(C0224k0.m1552g()))).booleanValue();
        } catch (Exception unused) {
            C13981a.m83988e("LocationUtils", "isLocationEnabledForUser exception");
            return false;
        }
    }

    /* renamed from: r */
    public static boolean m82847r(Context context, String str) {
        C13981a.m83989i("LocationUtils", "isProviderEnabledForUser:" + str);
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService(JsbMapKeyNames.H5_LOC);
            return ((Boolean) locationManager.getClass().getMethod("isProviderEnabledForUser", String.class, UserHandle.class).invoke(locationManager, str, m82843n(C0224k0.m1552g()))).booleanValue();
        } catch (Exception unused) {
            C13981a.m83988e("LocationUtils", "isProviderEnabledForUser exception");
            return false;
        }
    }

    /* renamed from: s */
    public static boolean m82848s(Context context, String str, int i10) {
        if (context == null) {
            C13981a.m83988e("LocationUtils", "Secure putStringForUser context null");
            return false;
        }
        try {
            ContentResolver contentResolver = context.getContentResolver();
            return C0209d.m1277l1() ? SettingsEx.Secure.putIntForUser(contentResolver, str, i10, 0) : SettingsEx.Secure.putIntForUser(contentResolver, str, i10, 0);
        } catch (Exception e10) {
            C11839m.m70687e("LocationUtils", "Secure putIntForUser exception:" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: t */
    public static boolean m82849t(Context context, String str, String str2) {
        if (context == null) {
            C13981a.m83988e("LocationUtils", "Secure putStringForUser context null");
            return false;
        }
        try {
            ContentResolver contentResolver = context.getContentResolver();
            return C0209d.m1277l1() ? SettingsEx.Secure.putStringForUser(contentResolver, str, str2, 0) : SettingsEx.Secure.putStringForUser(contentResolver, str, str2, 0);
        } catch (Exception e10) {
            C13981a.m83988e("LocationUtils", "Secure putStringForUser exception:" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: u */
    public static void m82850u(Context context, boolean z10) {
        C13981a.m83989i("LocationUtils", "setLocationEnabledForUser:" + z10);
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService(JsbMapKeyNames.H5_LOC);
            locationManager.getClass().getMethod("setLocationEnabledForUser", Boolean.TYPE, UserHandle.class).invoke(locationManager, Boolean.valueOf(z10), m82843n(C0224k0.m1552g()));
        } catch (Exception unused) {
            C13981a.m83988e("LocationUtils", "setLocationEnabledForUser exception");
        }
    }
}
