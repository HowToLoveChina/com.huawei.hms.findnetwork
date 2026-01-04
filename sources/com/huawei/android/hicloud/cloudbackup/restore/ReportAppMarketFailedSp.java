package com.huawei.android.hicloud.cloudbackup.restore;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.cloudbackup.bean.ReportAppMarketInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p015ak.C0214f0;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class ReportAppMarketFailedSp {
    private static final String FILE_NAME = "cloudbackup_app_report_failed_record";
    private static final ReportAppMarketFailedSp INSTANCE = new ReportAppMarketFailedSp();
    private static final String TAG = "ReportAppMarketFailedSp";
    private SharedPreferences preferences;

    private ReportAppMarketFailedSp() {
    }

    public static ReportAppMarketFailedSp getInstance() {
        return INSTANCE;
    }

    public synchronized List<ReportAppMarketInfo> getReportInfoAll() {
        SharedPreferences sharedPreferences = this.preferences;
        if (sharedPreferences == null) {
            return null;
        }
        Map<String, ?> all = sharedPreferences.getAll();
        if (all != null && !all.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<?> it = all.values().iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add((ReportAppMarketInfo) new Gson().fromJson(it.next().toString(), ReportAppMarketInfo.class));
                } catch (JsonSyntaxException e10) {
                    C11839m.m70687e(TAG, "getReportInfoAll json syntax exception: " + e10.getMessage());
                }
            }
            C11839m.m70686d(TAG, "getReportInfoAll: size=" + arrayList.size());
            return arrayList;
        }
        return null;
    }

    public synchronized void init(Context context) {
        this.preferences = C0214f0.m1382b(context, FILE_NAME, 0);
    }

    public synchronized void putReportInfo(ReportAppMarketInfo reportAppMarketInfo) {
        if (this.preferences == null) {
            return;
        }
        if (reportAppMarketInfo == null) {
            return;
        }
        boolean zCommit = this.preferences.edit().putString(reportAppMarketInfo.getSpKey(), new Gson().toJson(reportAppMarketInfo)).commit();
        C11839m.m70686d(TAG, "putReportInfo: " + zCommit);
    }

    public synchronized void removeReportInfo(String str) {
        if (this.preferences == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean zCommit = this.preferences.edit().remove(str).commit();
        C11839m.m70686d(TAG, "removeReportInfo: " + zCommit);
    }
}
