package com.huawei.hms.videokit.player;

import com.huawei.hms.common.util.Logger;
import com.huawei.hms.network.embedded.C5963j;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.videokit.player.bean.content.Picture;
import com.huawei.hms.videokit.player.bean.content.PictureItem;
import com.huawei.hms.videokit.player.bean.recommend.C6547a;
import com.huawei.hms.videokit.player.bean.recommend.RecommendVideo;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.IOException;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.videokit.player.g0 */
/* loaded from: classes8.dex */
public final class C6559g0 {
    /* renamed from: a */
    private static Picture m37368a(JSONObject jSONObject) {
        Picture picture = new Picture();
        if (jSONObject == null) {
            return picture;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("verticalPoster");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            PictureItem[] pictureItemArr = new PictureItem[jSONArrayOptJSONArray.length()];
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                pictureItemArr[i10] = m37370b(jSONArrayOptJSONArray.optJSONObject(i10));
            }
            picture.setVerticalPoster(pictureItemArr);
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("title");
        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
            PictureItem[] pictureItemArr2 = new PictureItem[jSONArrayOptJSONArray2.length()];
            for (int i11 = 0; i11 < jSONArrayOptJSONArray2.length(); i11++) {
                pictureItemArr2[i11] = m37370b(jSONArrayOptJSONArray2.optJSONObject(i11));
            }
            picture.setHorizontalPoster(pictureItemArr2);
        }
        return picture;
    }

    /* renamed from: b */
    private static PictureItem m37370b(JSONObject jSONObject) {
        PictureItem pictureItem = new PictureItem();
        if (jSONObject == null) {
            return pictureItem;
        }
        try {
            pictureItem.setSize(jSONObject.optString("size", ""));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("url");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                String[] strArr = new String[jSONArrayOptJSONArray.length()];
                for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                    strArr[i10] = (String) jSONArrayOptJSONArray.get(i10);
                }
                pictureItem.setUrl(strArr);
            }
        } catch (JSONException e10) {
            Logger.m30738e("DeserializeHelper", "getPictureItem", e10);
        }
        return pictureItem;
    }

    /* renamed from: c */
    private static RecommendVideo m37371c(JSONObject jSONObject) {
        RecommendVideo recommendVideo = new RecommendVideo();
        String strOptString = jSONObject.optString("mvId", "");
        Picture pictureM37368a = m37368a(jSONObject.optJSONObject("picture"));
        String strOptString2 = jSONObject.optString("vodName", "");
        String strOptString3 = jSONObject.optString("summary", "");
        String strOptString4 = jSONObject.optString("categoryType", "");
        String strOptString5 = jSONObject.optString("score", "");
        long jOptLong = jSONObject.optLong("playNum", 0L);
        String strOptString6 = jSONObject.optString("playParam", "");
        recommendVideo.setVideoId(strOptString);
        recommendVideo.setPicture(pictureM37368a);
        recommendVideo.setTitle(strOptString2);
        recommendVideo.setDescHead(strOptString3);
        recommendVideo.setCategory(strOptString4);
        recommendVideo.setScore(strOptString5);
        recommendVideo.setPlayNum(jOptLong);
        recommendVideo.setPlayParam(strOptString6);
        return recommendVideo;
    }

    /* renamed from: a */
    public static C6547a m37369a(Response<ResponseBody> response) {
        String str;
        C6547a c6547a = new C6547a();
        if (response != null && response.getBody() != null) {
            try {
                String str2 = new String(response.getBody().bytes(), Charset.forName(Constants.UTF_8));
                Logger.m30735d("DeserializeHelper", "getRecommendVideo responseData:" + str2);
                JSONObject jSONObject = new JSONObject(str2);
                int iOptInt = jSONObject.optInt(C5963j.f27041j, 0);
                String strOptString = jSONObject.optString("retMsg", "");
                c6547a.m37238b(iOptInt);
                c6547a.m37239b(strOptString);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                if (iOptInt == 0 && jSONObjectOptJSONObject != null) {
                    c6547a.m37235a(m37371c(jSONObjectOptJSONObject));
                }
            } catch (IOException e10) {
                e = e10;
                str = "getRecommendVideo IO";
                Logger.m30738e("DeserializeHelper", str, e);
                return c6547a;
            } catch (JSONException e11) {
                e = e11;
                str = "getRecommendVideo JSON";
                Logger.m30738e("DeserializeHelper", str, e);
                return c6547a;
            }
        }
        return c6547a;
    }
}
