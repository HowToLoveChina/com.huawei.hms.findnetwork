package com.huawei.hicloud.notification.manager;

import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0213f;
import p015ak.C0239x;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p746wn.C13622a;

/* loaded from: classes6.dex */
public class CommonReportUtil {
    private static final String TAG = "NotificationReportUtil";

    public static void reportCloudStorageDeleteBtnClick(String str, String str2) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("module_name", str);
            jSONObject.put("btn_type", str2);
            HashMap map = new HashMap();
            map.put(NotifyConstants.CommonReportConstants.DELETE_BTN_KEY, jSONObject.toString());
            C0239x.m1671c().m1672a(map);
            reportOMEvent("07001", NotifyConstants.CommonReportConstants.OPERATION_NAME_DELETE_BTN_CLICK, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportCloudStorageDeleteBtnClick exception:" + e10.toString());
        }
    }

    public static void reportCloudStorageDeleteResult(String str, String str2) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("module_name", str);
            jSONObject.put("result", str2);
            HashMap map = new HashMap();
            map.put("result", jSONObject.toString());
            C0239x.m1671c().m1672a(map);
            reportOMEvent("07001", NotifyConstants.CommonReportConstants.OPERATION_NAME_DELETE_DATA_RESULT, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportCloudStorageDeleteBtnClick exception:" + e10.toString());
        }
    }

    public static void reportLocalDataCheck(ArrayList<String> arrayList) {
        int i10;
        if (arrayList == null) {
            return;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            int size = arrayList.size();
            int i11 = 0;
            while (true) {
                i10 = size - 1;
                if (i11 >= i10) {
                    break;
                }
                stringBuffer.append(arrayList.get(i11));
                stringBuffer.append(",");
                i11++;
            }
            stringBuffer.append(arrayList.size() > 0 ? arrayList.get(i10) : "");
            HashMap map = new HashMap();
            map.put(NotifyConstants.CommonReportConstants.KEY_MODULE_IN_CHECKLIST, stringBuffer.toString());
            C0239x.m1671c().m1672a(map);
            reportOMEvent("07011", "result", map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportSpaceNotifyCheck exception:" + e10.toString());
        }
    }

    public static void reportLocalDataCheckResult(String str, ArrayList<String> arrayList) {
        int i10;
        if (arrayList == null) {
            return;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            int size = arrayList.size();
            int i11 = 0;
            while (true) {
                i10 = size - 1;
                if (i11 >= i10) {
                    break;
                }
                stringBuffer.append(arrayList.get(i11));
                stringBuffer.append(",");
                i11++;
            }
            stringBuffer.append(arrayList.size() > 0 ? arrayList.get(i10) : "");
            HashMap map = new HashMap();
            map.put(NotifyConstants.CommonReportConstants.KEY_MODULE_IN_CHECKLIST, stringBuffer.toString());
            map.put("result", str);
            C0239x.m1671c().m1672a(map);
            reportOMEvent("07011", NotifyConstants.CommonReportConstants.OPERATION_NAME_LOCAL_DATA_CHECK, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportLocalDataCheckResult exception:" + e10.toString());
        }
    }

    public static void reportOMEvent(String str, String str2, Map<String, String> map) {
        try {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b(str), str, C13452e.m80781L().m80971t0());
            c11060cM66626a.m66636B(str2);
            c11060cM66626a.m66665u("0");
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportOMEvent exception:" + e10.toString());
        }
    }
}
