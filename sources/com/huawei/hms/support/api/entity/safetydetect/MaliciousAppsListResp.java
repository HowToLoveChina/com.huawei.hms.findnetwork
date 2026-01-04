package com.huawei.hms.support.api.entity.safetydetect;

import com.huawei.hms.support.api.entity.safetydetect.base.BaseResp;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class MaliciousAppsListResp extends BaseResp {
    private ArrayList<MaliciousAppsData> maliciousAppsList = new ArrayList<>();

    public MaliciousAppsListResp(String str) {
        JSONArray jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("harmfulAppsList");
        for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
            this.maliciousAppsList.add(new MaliciousAppsData(jSONArrayOptJSONArray.getString(i10)));
        }
    }

    public ArrayList<MaliciousAppsData> getMaliciousAppsList() {
        return this.maliciousAppsList;
    }

    public void setMaliciousAppsList(ArrayList<MaliciousAppsData> arrayList) {
        this.maliciousAppsList = arrayList;
    }
}
