package af;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.remotecontrol.config.BtwlDevcieInfo;
import hk.C10280c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p514o9.C11837k;
import p521og.C11877j;
import p521og.C11881n;
import p809yg.C13981a;

/* renamed from: af.a */
/* loaded from: classes4.dex */
public class C0188a {
    /* renamed from: a */
    public static String m1064a(Context context) throws Throwable {
        C13981a.m83989i("BtwlConfigManager", "getBtwlConfigFromLocalFile");
        if (context == null) {
            C13981a.m83988e("BtwlConfigManager", "getBtwlConfigFromLocalFile context is null.");
            return null;
        }
        String str = context.getFilesDir() + "/bluetooth_white_list_local.json";
        if (!new File(str).exists()) {
            C13981a.m83989i("BtwlConfigManager", "getBtwlConfigFromLocalFile file is not exist.");
            C10280c.m63455c(context, "bluetooth_white_list_local.json", str);
        }
        return m1068e(str);
    }

    /* renamed from: b */
    public static List<BtwlDevcieInfo> m1065b(String str, String str2) throws JSONException {
        ArrayList arrayList = new ArrayList();
        try {
            String strM71362l = C11881n.m71362l(new JSONObject(str2), str);
            if (!TextUtils.isEmpty(strM71362l)) {
                JSONArray jSONArray = new JSONArray(strM71362l);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    BtwlDevcieInfo btwlDevcieInfo = new BtwlDevcieInfo();
                    btwlDevcieInfo.setBtwlDeviceType(jSONObject.getString("DeviceType"));
                    btwlDevcieInfo.setBtwlModelID(jSONObject.getString("ModelID"));
                    btwlDevcieInfo.setBtwlSubModelID(jSONObject.getString("SubmodelID"));
                    btwlDevcieInfo.setUrl(jSONObject.getString("url"));
                    arrayList.add(btwlDevcieInfo);
                }
            }
        } catch (JSONException e10) {
            C13981a.m83988e("BtwlConfigManager", "config file parseJson exception:" + e10.getMessage());
        }
        return arrayList;
    }

    /* renamed from: c */
    public static void m1066c(Context context) {
        if (TextUtils.isEmpty(C11877j.m71230R(context))) {
            C11877j.m71245Y0(context, m1064a(context));
        } else {
            C13981a.m83989i("BtwlConfigManager", "Btwl config already exist in SP");
        }
    }

    /* renamed from: d */
    public static List<BtwlDevcieInfo> m1067d(String str) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("BtwlConfigManager", "config file jsonString is empty");
            return arrayList;
        }
        List<BtwlDevcieInfo> listM1065b = m1065b("BTWL", str);
        List<BtwlDevcieInfo> listM1065b2 = m1065b("WEL", str);
        arrayList.addAll(listM1065b);
        arrayList.addAll(listM1065b2);
        return arrayList;
    }

    /* renamed from: e */
    public static String m1068e(String str) throws IOException {
        File file = new File(str);
        String strM1069f = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                strM1069f = m1069f(fileInputStream);
                fileInputStream.close();
            } finally {
            }
        } catch (Exception e10) {
            C13981a.m83988e("BtwlConfigManager", "config file not exist, msg:" + e10.getMessage());
        }
        return strM1069f;
    }

    /* renamed from: f */
    public static String m1069f(InputStream inputStream) throws Throwable {
        BufferedReader bufferedReader;
        StringBuffer stringBuffer = new StringBuffer();
        InputStreamReader inputStreamReader = null;
        try {
            InputStreamReader inputStreamReader2 = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            try {
                bufferedReader = new BufferedReader(inputStreamReader2);
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        stringBuffer.append(line);
                    } catch (IOException unused) {
                        inputStreamReader = inputStreamReader2;
                        try {
                            C13981a.m83988e("BtwlConfigManager", "read local config failed");
                            C11837k.m70680c(inputStream);
                            C11837k.m70682e(inputStreamReader);
                            C11837k.m70682e(bufferedReader);
                            return stringBuffer.toString();
                        } catch (Throwable th2) {
                            th = th2;
                            C11837k.m70680c(inputStream);
                            C11837k.m70682e(inputStreamReader);
                            C11837k.m70682e(bufferedReader);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStreamReader = inputStreamReader2;
                        C11837k.m70680c(inputStream);
                        C11837k.m70682e(inputStreamReader);
                        C11837k.m70682e(bufferedReader);
                        throw th;
                    }
                }
                C13981a.m83989i("BtwlConfigManager", "read local config str success");
                C11837k.m70680c(inputStream);
                C11837k.m70682e(inputStreamReader2);
            } catch (IOException unused2) {
                bufferedReader = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (IOException unused3) {
            bufferedReader = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
        }
        C11837k.m70682e(bufferedReader);
        return stringBuffer.toString();
    }

    /* renamed from: g */
    public static List<BtwlDevcieInfo> m1070g(Context context) {
        C13981a.m83989i("BtwlConfigManager", "reload local white list");
        m1066c(context);
        return m1067d(C11877j.m71230R(context));
    }
}
