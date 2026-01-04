package p216d4;

import org.json.JSONArray;
import org.json.JSONObject;
import p384j4.AbstractC10705d;

/* renamed from: d4.g */
/* loaded from: classes.dex */
public class C9010g {
    /* renamed from: a */
    public static C9001b0 m56886a(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("imageInfo");
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        C9001b0 c9001b0 = new C9001b0();
        for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
            if (jSONObjectOptJSONObject != null) {
                c9001b0.m56868e(jSONObjectOptJSONObject.optInt("width"));
                c9001b0.m56865b(jSONObjectOptJSONObject.optInt("height"));
                c9001b0.m56866c(jSONObjectOptJSONObject.optString("url"));
            }
        }
        return c9001b0;
    }

    /* renamed from: b */
    public static C9001b0 m56887b(JSONObject jSONObject) {
        JSONObject jSONObjectM65364y = AbstractC10705d.m65364y(jSONObject.optString("metaData"));
        if (jSONObjectM65364y == null) {
            return null;
        }
        return jSONObjectM65364y.has("videoInfo") ? m56888c(jSONObjectM65364y) : m56886a(jSONObjectM65364y);
    }

    /* renamed from: c */
    public static C9001b0 m56888c(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("videoInfo");
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        C9001b0 c9001b0 = new C9001b0();
        double dOptDouble = jSONObjectOptJSONObject.optDouble("videoRatio");
        c9001b0.m56865b(1000);
        c9001b0.m56868e((int) (dOptDouble * 1000.0d));
        return c9001b0;
    }
}
