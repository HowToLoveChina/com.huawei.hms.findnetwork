package p611rf;

import org.json.JSONException;
import org.json.JSONObject;
import p809yg.C13981a;

/* renamed from: rf.c */
/* loaded from: classes4.dex */
public class C12495c {
    /* renamed from: a */
    public static String m74995a(String str) {
        long jValueOf = 0L;
        try {
            jValueOf = Long.valueOf(new JSONObject(str).getLong("time"));
        } catch (JSONException unused) {
            C13981a.m83988e("BindResult", "getChallengeTime JSONException");
        }
        return String.valueOf(jValueOf);
    }

    /* renamed from: b */
    public static String m74996b(String str) {
        try {
            return new JSONObject(str).getString("challengeToken");
        } catch (JSONException unused) {
            C13981a.m83988e("BindResult", "getChallengeToken JSONException");
            return "";
        }
    }

    /* renamed from: c */
    public static String m74997c(String str) {
        try {
            return new JSONObject(str).getString("version");
        } catch (Exception unused) {
            C13981a.m83988e("BindResult", "getServerVersion Exception");
            return "";
        }
    }
}
