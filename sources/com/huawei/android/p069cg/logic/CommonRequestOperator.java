package com.huawei.android.p069cg.logic;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.response.QueryUserSpaceResponse;
import org.json.JSONException;
import org.json.JSONObject;
import p031b7.C1120a;
import p031b7.C1136q;
import p511o6.C11819a;
import p701v6.C13357d;
import p701v6.C13361h;
import p709vj.C13452e;

/* loaded from: classes2.dex */
public class CommonRequestOperator {

    /* renamed from: a */
    public Context f10971a;

    public CommonRequestOperator(Context context) {
        this.f10971a = context;
    }

    /* renamed from: a */
    public FileInfo m14404a(String str, FileInfo fileInfo, String str2) throws JSONException {
        if (fileInfo != null && fileInfo.getHash() != null) {
            String strM80971t0 = TextUtils.isEmpty(fileInfo.getUserID()) ? C13452e.m80781L().m80971t0() : fileInfo.getUserID();
            try {
                JSONObject jSONObject = new JSONObject((TextUtils.isEmpty(fileInfo.getShareId()) ? new C13357d(this.f10971a, strM80971t0, fileInfo.getAlbumId(), str2, fileInfo.getHash(), fileInfo.getUniqueId()) : new C13357d(this.f10971a, strM80971t0, fileInfo.getAlbumId(), str2, fileInfo.getHash())).mo76565p());
                int i10 = jSONObject.getInt("code");
                C1120a.m6677i("CommonRequestOperator", "cloudphoto.file.getattach: " + i10);
                if (i10 == 401) {
                    C11819a.m70393a(true);
                    return null;
                }
                if (i10 != 0 || !jSONObject.has("urlList")) {
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject(jSONObject.getString("urlList"));
                if (jSONObject2.has(str)) {
                    fileInfo.setFileUrl(jSONObject2.getString(str));
                }
                return fileInfo;
            } catch (Exception e10) {
                C1120a.m6676e("CommonRequestOperator", "getAttachDownloadUrl error:" + e10.toString());
            }
        }
        return null;
    }

    /* renamed from: b */
    public String m14405b(String str) {
        QueryUserSpaceResponse queryUserSpaceResponseM80113o;
        JSONObject jSONObject = new JSONObject();
        try {
            queryUserSpaceResponseM80113o = new C13361h(this.f10971a, str).m80113o(QueryUserSpaceResponse.class);
        } catch (Exception e10) {
            C1120a.m6676e("CommonRequestOperator", "queryUserSpace error:" + e10.toString());
        }
        if (queryUserSpaceResponseM80113o == null) {
            C1120a.m6676e("CommonRequestOperator", "getUserSpace ret is empty");
            return null;
        }
        int code = queryUserSpaceResponseM80113o.getCode();
        C1120a.m6677i("CommonRequestOperator", "bapi.dbank.queryspace: " + code);
        if (code == 401) {
            C11819a.m70393a(true);
            return null;
        }
        if (code == 0) {
            long useSpaceSize = queryUserSpaceResponseM80113o.getUseSpaceSize();
            long totalSpaceSize = queryUserSpaceResponseM80113o.getTotalSpaceSize();
            jSONObject.put("useSpaceSize", useSpaceSize);
            jSONObject.put("totalSpaceSize", totalSpaceSize);
            jSONObject.put("cloudPhotoSize", queryUserSpaceResponseM80113o.getCloudPhotoSize());
            jSONObject.put("recyclePhotoSize", queryUserSpaceResponseM80113o.getRecyclePhotoSize());
            C1136q.b.m7112x1(this.f10971a, "userCapacityUsed", useSpaceSize);
            C1136q.b.m7112x1(this.f10971a, "userCapacityTotal", totalSpaceSize);
            C1136q.b.m7112x1(this.f10971a, "userCapacityRecordTime", System.currentTimeMillis());
            return jSONObject.toString();
        }
        return null;
    }
}
