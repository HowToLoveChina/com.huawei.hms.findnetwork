package com.huawei.hicloud.notification.manager;

import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class NotificationReportManager {
    private static final NotificationReportManager INSTANCE = new NotificationReportManager();
    private static final String TAG = "NotificationReportManager";
    private JSONArray mReportContent;
    private int mOrder = 0;
    private Random traceRandom = new Random();

    private NotificationReportManager() {
    }

    private String createTrace() {
        return String.valueOf(this.traceRandom.nextInt(10000));
    }

    public static NotificationReportManager getInstance() {
        return INSTANCE;
    }

    public void addActivitySpaceCheckInfo(String str, String str2, String str3, int i10, String str4) throws JSONException {
        try {
            if (this.mReportContent == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            int i11 = this.mOrder + 1;
            this.mOrder = i11;
            jSONObject.put(NotifyConstants.NotificationReport.KEY_ORDER, i11);
            jSONObject.put(NotifyConstants.NotificationReport.KEY_MORE_THAN, str);
            jSONObject.put(NotifyConstants.NotificationReport.KEY_LESS_THAN, str2);
            jSONObject.put(NotifyConstants.NotificationReport.KEY_CURRENT_VALUE, str3);
            jSONObject.put(NotifyConstants.NotificationReport.KEY_SPACE_CTYPE, i10);
            jSONObject.put(NotifyConstants.NotificationReport.KEY_RULE_TYPE, str4);
            this.mReportContent.put(jSONObject);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "addSpaceCheckInfo exception:" + e10.toString());
        }
    }

    public void addSpaceCheckInfo(String str, String str2, String str3, String str4) throws JSONException {
        try {
            if (this.mReportContent == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            int i10 = this.mOrder + 1;
            this.mOrder = i10;
            jSONObject.put(NotifyConstants.NotificationReport.KEY_ORDER, i10);
            jSONObject.put(NotifyConstants.NotificationReport.KEY_MORE_THAN, str);
            jSONObject.put(NotifyConstants.NotificationReport.KEY_LESS_THAN, str2);
            jSONObject.put(NotifyConstants.NotificationReport.KEY_CURRENT_VALUE, str3);
            jSONObject.put(NotifyConstants.NotificationReport.KEY_RULE_TYPE, str4);
            this.mReportContent.put(jSONObject);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "addSpaceCheckInfo exception:" + e10.toString());
        }
    }

    public void addSpaceInfo(String str) throws JSONException {
        try {
            if (this.mReportContent == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotifyConstants.NotificationReport.KEY_SPACE_INFO, str);
            this.mReportContent.put(jSONObject);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "addSpaceCheckInfo exception:" + e10.toString());
        }
    }

    public void begin() throws JSONException {
        try {
            String strCreateTrace = createTrace();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("trace_id", strCreateTrace);
            JSONArray jSONArray = new JSONArray();
            this.mReportContent = jSONArray;
            jSONArray.put(jSONObject);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "addSpaceCheckInfo exception:" + e10.toString());
        }
    }

    public String getContent() {
        try {
            if (this.mReportContent == null) {
                return "";
            }
            return "" + this.mReportContent.toString();
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getContent exception:" + e10.toString());
            return "";
        }
    }

    public void reset() {
        this.mOrder = 0;
        this.mReportContent = null;
    }
}
