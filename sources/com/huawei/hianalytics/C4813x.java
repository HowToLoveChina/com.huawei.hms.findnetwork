package com.huawei.hianalytics;

import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.x */
/* loaded from: classes5.dex */
public class C4813x {

    /* renamed from: a */
    public int f21974a;

    /* renamed from: a */
    public long f21975a;

    /* renamed from: a */
    public String f21976a;

    /* renamed from: a */
    public final List<a> f21977a;

    /* renamed from: b */
    public long f21978b;

    /* renamed from: b */
    public String f21979b;

    /* renamed from: c */
    public long f21980c;

    /* renamed from: c */
    public String f21981c;

    /* renamed from: d */
    public String f21982d;

    /* renamed from: e */
    public String f21983e;

    /* renamed from: f */
    public String f21984f;

    /* renamed from: g */
    public String f21985g;

    /* renamed from: com.huawei.hianalytics.x$a */
    public static class a {

        /* renamed from: a */
        public final long f21986a;

        /* renamed from: a */
        public final boolean f21987a;

        public a(boolean z10, long j10) {
            this.f21987a = z10;
            this.f21986a = j10;
        }
    }

    public C4813x() {
        this.f21976a = "";
        this.f21979b = "";
        this.f21981c = "";
        this.f21982d = "";
        this.f21983e = "";
        this.f21984f = "";
        this.f21975a = 0L;
        this.f21978b = 0L;
        this.f21974a = 0;
        this.f21985g = "";
        this.f21980c = 0L;
        this.f21977a = new ArrayList();
    }

    /* renamed from: a */
    public JSONObject m29055a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("item_id", this.f21979b);
        jSONObject.put("mc_title", this.f21981c);
        jSONObject.put("mc_artist", this.f21982d);
        jSONObject.put("mc_album", this.f21984f);
        jSONObject.put("mc_duration", this.f21983e);
        jSONObject.put("play_start_time", this.f21975a);
        jSONObject.put("play_duration", this.f21978b);
        jSONObject.put("favorite_state", this.f21974a);
        jSONObject.put(MapKeyNames.PACKAGE_NAME, this.f21985g);
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C4813x.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f21979b, ((C4813x) obj).f21979b);
    }

    public int hashCode() {
        return Objects.hash(this.f21979b);
    }

    public C4813x(String str) {
        JSONObject jSONObject = new JSONObject(str);
        this.f21976a = jSONObject.optString("_id", "");
        this.f21979b = jSONObject.optString("item_id", "");
        this.f21981c = jSONObject.optString("mc_title", "");
        this.f21982d = jSONObject.optString("mc_artist", "");
        this.f21984f = jSONObject.optString("mc_album", "");
        this.f21983e = jSONObject.optString("mc_duration", "");
        this.f21975a = jSONObject.optLong("play_start_time", 0L);
        this.f21978b = jSONObject.optLong("play_duration", 0L);
        this.f21974a = jSONObject.optInt("favorite_state", 0);
        this.f21985g = jSONObject.optString(MapKeyNames.PACKAGE_NAME, "");
        this.f21980c = jSONObject.optLong("event_time", 0L);
        this.f21977a = new ArrayList();
    }
}
