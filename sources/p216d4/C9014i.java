package p216d4;

import com.huawei.openalliance.p169ad.constant.AssetAlias;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MetaCreativeType;
import com.huawei.openalliance.p169ad.p171db.bean.ContentTemplateRecord;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: d4.i */
/* loaded from: classes.dex */
public class C9014i {
    /* renamed from: a */
    public static void m56919a(JSONObject jSONObject, C9001b0 c9001b0) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(MetaCreativeType.IMG);
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        c9001b0.m56868e(jSONObjectOptJSONObject.optInt("W"));
        c9001b0.m56865b(jSONObjectOptJSONObject.optInt("H"));
        c9001b0.m56866c(jSONObjectOptJSONObject.optString("url"));
    }

    /* renamed from: b */
    public static void m56920b(JSONObject jSONObject, C9001b0 c9001b0) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(Constants.VIDEO_SUB_DIR);
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        c9001b0.m56868e(jSONObjectOptJSONObject.optInt("W"));
        c9001b0.m56865b(jSONObjectOptJSONObject.optInt("H"));
    }

    /* renamed from: c */
    public static C9001b0 m56921c(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(ContentTemplateRecord.ASSETS);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        C9001b0 c9001b0 = new C9001b0();
        for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
            String strOptString = jSONObjectOptJSONObject.optString("alias");
            if (strOptString.startsWith(AssetAlias.VIDEO)) {
                m56920b(jSONObjectOptJSONObject, c9001b0);
            } else if (strOptString.startsWith(AssetAlias.IMAGE)) {
                m56919a(jSONObjectOptJSONObject, c9001b0);
            }
        }
        return c9001b0;
    }
}
