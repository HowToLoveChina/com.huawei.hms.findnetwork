package com.huawei.hms.push;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.DateUtil;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.api.push.PushException;
import com.huawei.hms.support.log.HMSLog;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class RemoteMessage implements Parcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;

    /* renamed from: c */
    private static final String[] f29621c;

    /* renamed from: d */
    private static final int[] f29622d;

    /* renamed from: e */
    private static final long[] f29623e;

    /* renamed from: f */
    private static final HashMap<String, Object> f29624f;

    /* renamed from: g */
    private static final HashMap<String, Object> f29625g;

    /* renamed from: h */
    private static final HashMap<String, Object> f29626h;

    /* renamed from: i */
    private static final HashMap<String, Object> f29627i;

    /* renamed from: j */
    private static final HashMap<String, Object> f29628j;

    /* renamed from: a */
    private Bundle f29629a;

    /* renamed from: b */
    private Notification f29630b;

    public static class Builder {

        /* renamed from: a */
        private final Bundle f29631a;

        /* renamed from: b */
        private final Map<String, String> f29632b;

        public Builder(String str) {
            Bundle bundle = new Bundle();
            this.f29631a = bundle;
            this.f29632b = new HashMap();
            bundle.putString(RemoteMessageConst.f29664TO, str);
        }

        public Builder addData(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("add data failed, key is null.");
            }
            this.f29632b.put(str, str2);
            return this;
        }

        public RemoteMessage build() throws JSONException {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : this.f29632b.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                try {
                    String string = jSONObject.toString();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(RemoteMessageConst.COLLAPSE_KEY, this.f29631a.getString(RemoteMessageConst.COLLAPSE_KEY));
                    jSONObject2.put("ttl", this.f29631a.getInt("ttl"));
                    jSONObject2.put(RemoteMessageConst.SEND_MODE, this.f29631a.getInt(RemoteMessageConst.SEND_MODE));
                    jSONObject2.put(RemoteMessageConst.RECEIPT_MODE, this.f29631a.getInt(RemoteMessageConst.RECEIPT_MODE));
                    JSONObject jSONObject3 = new JSONObject();
                    if (jSONObject.length() != 0) {
                        jSONObject3.put("data", string);
                    }
                    jSONObject3.put(RemoteMessageConst.MSGID, this.f29631a.getString(RemoteMessageConst.MSGID));
                    jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject3);
                    bundle.putByteArray(RemoteMessageConst.MSGBODY, jSONObject2.toString().getBytes(C6294m.f29674a));
                    bundle.putString(RemoteMessageConst.f29664TO, this.f29631a.getString(RemoteMessageConst.f29664TO));
                    bundle.putString(RemoteMessageConst.MSGTYPE, this.f29631a.getString(RemoteMessageConst.MSGTYPE));
                    return new RemoteMessage(bundle);
                } catch (JSONException unused) {
                    HMSLog.m36989w("RemoteMessage", "JSONException: parse message body failed.");
                    throw new PushException(PushException.EXCEPTION_SEND_FAILED);
                }
            } catch (JSONException unused2) {
                HMSLog.m36989w("RemoteMessage", "JSONException: parse data to json failed.");
                throw new PushException(PushException.EXCEPTION_SEND_FAILED);
            }
        }

        public Builder clearData() {
            this.f29632b.clear();
            return this;
        }

        public Builder setCollapseKey(String str) {
            this.f29631a.putString(RemoteMessageConst.COLLAPSE_KEY, str);
            return this;
        }

        public Builder setData(Map<String, String> map) {
            this.f29632b.clear();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f29632b.put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Builder setMessageId(String str) {
            this.f29631a.putString(RemoteMessageConst.MSGID, str);
            return this;
        }

        public Builder setMessageType(String str) {
            this.f29631a.putString(RemoteMessageConst.MSGTYPE, str);
            return this;
        }

        public Builder setReceiptMode(int i10) {
            if (i10 != 1 && i10 != 0) {
                throw new IllegalArgumentException("receipt mode can only be 0 or 1.");
            }
            this.f29631a.putInt(RemoteMessageConst.RECEIPT_MODE, i10);
            return this;
        }

        public Builder setSendMode(int i10) {
            if (i10 != 0 && i10 != 1) {
                throw new IllegalArgumentException("send mode can only be 0 or 1.");
            }
            this.f29631a.putInt(RemoteMessageConst.SEND_MODE, i10);
            return this;
        }

        public Builder setTtl(int i10) {
            if (i10 < 1 || i10 > 1296000) {
                throw new IllegalArgumentException("ttl must be greater than or equal to 1 and less than or equal to 1296000");
            }
            this.f29631a.putInt("ttl", i10);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    public static class Notification implements Serializable {

        /* renamed from: A */
        private final long[] f29633A;

        /* renamed from: B */
        private final String f29634B;

        /* renamed from: a */
        private final String f29635a;

        /* renamed from: b */
        private final String f29636b;

        /* renamed from: c */
        private final String[] f29637c;

        /* renamed from: d */
        private final String f29638d;

        /* renamed from: e */
        private final String f29639e;

        /* renamed from: f */
        private final String[] f29640f;

        /* renamed from: g */
        private final String f29641g;

        /* renamed from: h */
        private final String f29642h;

        /* renamed from: i */
        private final String f29643i;

        /* renamed from: j */
        private final String f29644j;

        /* renamed from: k */
        private final String f29645k;

        /* renamed from: l */
        private final String f29646l;

        /* renamed from: m */
        private final String f29647m;

        /* renamed from: n */
        private final Uri f29648n;

        /* renamed from: o */
        private final int f29649o;

        /* renamed from: p */
        private final String f29650p;

        /* renamed from: q */
        private final int f29651q;

        /* renamed from: r */
        private final int f29652r;

        /* renamed from: s */
        private final int f29653s;

        /* renamed from: t */
        private final int[] f29654t;

        /* renamed from: u */
        private final String f29655u;

        /* renamed from: v */
        private final int f29656v;

        /* renamed from: w */
        private final String f29657w;

        /* renamed from: x */
        private final int f29658x;

        /* renamed from: y */
        private final String f29659y;

        /* renamed from: z */
        private final String f29660z;

        public /* synthetic */ Notification(Bundle bundle, C6281a c6281a) {
            this(bundle);
        }

        /* renamed from: a */
        private Integer m36500a(String str) {
            if (str != null) {
                try {
                    return Integer.valueOf(str);
                } catch (NumberFormatException unused) {
                    HMSLog.m36989w("RemoteMessage", "NumberFormatException: get " + str + " failed.");
                }
            }
            return null;
        }

        public Integer getBadgeNumber() {
            return m36500a(this.f29657w);
        }

        public String getBody() {
            return this.f29638d;
        }

        public String[] getBodyLocalizationArgs() {
            String[] strArr = this.f29640f;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getBodyLocalizationKey() {
            return this.f29639e;
        }

        public String getChannelId() {
            return this.f29647m;
        }

        public String getClickAction() {
            return this.f29645k;
        }

        public String getColor() {
            return this.f29644j;
        }

        public String getIcon() {
            return this.f29641g;
        }

        public Uri getImageUrl() {
            String str = this.f29650p;
            if (str == null) {
                return null;
            }
            return Uri.parse(str);
        }

        public Integer getImportance() {
            return m36500a(this.f29659y);
        }

        public String getIntentUri() {
            return this.f29646l;
        }

        public int[] getLightSettings() {
            int[] iArr = this.f29654t;
            return iArr == null ? new int[0] : (int[]) iArr.clone();
        }

        public Uri getLink() {
            return this.f29648n;
        }

        public int getNotifyId() {
            return this.f29649o;
        }

        public String getSound() {
            return this.f29642h;
        }

        public String getTag() {
            return this.f29643i;
        }

        public String getTicker() {
            return this.f29660z;
        }

        public String getTitle() {
            return this.f29635a;
        }

        public String[] getTitleLocalizationArgs() {
            String[] strArr = this.f29637c;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getTitleLocalizationKey() {
            return this.f29636b;
        }

        public long[] getVibrateConfig() {
            long[] jArr = this.f29633A;
            return jArr == null ? new long[0] : (long[]) jArr.clone();
        }

        public Integer getVisibility() {
            return m36500a(this.f29634B);
        }

        public Long getWhen() {
            if (!TextUtils.isEmpty(this.f29655u)) {
                try {
                    return Long.valueOf(DateUtil.parseUtcToMillisecond(this.f29655u));
                } catch (StringIndexOutOfBoundsException unused) {
                    HMSLog.m36989w("RemoteMessage", "StringIndexOutOfBoundsException: parse when failed.");
                } catch (ParseException unused2) {
                    HMSLog.m36989w("RemoteMessage", "ParseException: parse when failed.");
                }
            }
            return null;
        }

        public boolean isAutoCancel() {
            return this.f29658x == 1;
        }

        public boolean isDefaultLight() {
            return this.f29651q == 1;
        }

        public boolean isDefaultSound() {
            return this.f29652r == 1;
        }

        public boolean isDefaultVibrate() {
            return this.f29653s == 1;
        }

        public boolean isLocalOnly() {
            return this.f29656v == 1;
        }

        private Notification(Bundle bundle) {
            this.f29635a = bundle.getString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f29638d = bundle.getString("content");
            this.f29636b = bundle.getString(RemoteMessageConst.Notification.TITLE_LOC_KEY);
            this.f29639e = bundle.getString(RemoteMessageConst.Notification.BODY_LOC_KEY);
            this.f29637c = bundle.getStringArray(RemoteMessageConst.Notification.TITLE_LOC_ARGS);
            this.f29640f = bundle.getStringArray(RemoteMessageConst.Notification.BODY_LOC_ARGS);
            this.f29641g = bundle.getString("icon");
            this.f29644j = bundle.getString(RemoteMessageConst.Notification.COLOR);
            this.f29642h = bundle.getString(RemoteMessageConst.Notification.SOUND);
            this.f29643i = bundle.getString("tag");
            this.f29647m = bundle.getString("channelId");
            this.f29645k = bundle.getString(RemoteMessageConst.Notification.CLICK_ACTION);
            this.f29646l = bundle.getString(RemoteMessageConst.Notification.INTENT_URI);
            this.f29649o = bundle.getInt(RemoteMessageConst.Notification.NOTIFY_ID);
            String string = bundle.getString("url");
            this.f29648n = !TextUtils.isEmpty(string) ? Uri.parse(string) : null;
            this.f29650p = bundle.getString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.f29651q = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS);
            this.f29652r = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_SOUND);
            this.f29653s = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS);
            this.f29654t = bundle.getIntArray(RemoteMessageConst.Notification.LIGHT_SETTINGS);
            this.f29655u = bundle.getString(RemoteMessageConst.Notification.WHEN);
            this.f29656v = bundle.getInt(RemoteMessageConst.Notification.LOCAL_ONLY);
            this.f29657w = bundle.getString(RemoteMessageConst.Notification.BADGE_SET_NUM, null);
            this.f29658x = bundle.getInt(RemoteMessageConst.Notification.AUTO_CANCEL);
            this.f29659y = bundle.getString("priority", null);
            this.f29660z = bundle.getString(RemoteMessageConst.Notification.TICKER);
            this.f29633A = bundle.getLongArray(RemoteMessageConst.Notification.VIBRATE_TIMINGS);
            this.f29634B = bundle.getString("visibility", null);
        }
    }

    /* renamed from: com.huawei.hms.push.RemoteMessage$a */
    public class C6281a implements Parcelable.Creator<RemoteMessage> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RemoteMessage createFromParcel(Parcel parcel) {
            return new RemoteMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RemoteMessage[] newArray(int i10) {
            return new RemoteMessage[i10];
        }
    }

    static {
        String[] strArr = new String[0];
        f29621c = strArr;
        int[] iArr = new int[0];
        f29622d = iArr;
        long[] jArr = new long[0];
        f29623e = jArr;
        HashMap<String, Object> map = new HashMap<>(8);
        f29624f = map;
        map.put(RemoteMessageConst.FROM, "");
        map.put(RemoteMessageConst.COLLAPSE_KEY, "");
        map.put(RemoteMessageConst.SEND_TIME, "");
        map.put("ttl", 86400);
        map.put(RemoteMessageConst.URGENCY, 2);
        map.put(RemoteMessageConst.ORI_URGENCY, 2);
        map.put(RemoteMessageConst.SEND_MODE, 0);
        map.put(RemoteMessageConst.RECEIPT_MODE, 0);
        HashMap<String, Object> map2 = new HashMap<>(8);
        f29625g = map2;
        map2.put(RemoteMessageConst.Notification.TITLE_LOC_KEY, "");
        map2.put(RemoteMessageConst.Notification.BODY_LOC_KEY, "");
        map2.put(RemoteMessageConst.Notification.NOTIFY_ICON, "");
        map2.put(RemoteMessageConst.Notification.TITLE_LOC_ARGS, strArr);
        map2.put(RemoteMessageConst.Notification.BODY_LOC_ARGS, strArr);
        map2.put(RemoteMessageConst.Notification.TICKER, "");
        map2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, "");
        map2.put("content", "");
        HashMap<String, Object> map3 = new HashMap<>(8);
        f29626h = map3;
        map3.put("icon", "");
        map3.put(RemoteMessageConst.Notification.COLOR, "");
        map3.put(RemoteMessageConst.Notification.SOUND, "");
        map3.put(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS, 1);
        map3.put(RemoteMessageConst.Notification.LIGHT_SETTINGS, iArr);
        map3.put(RemoteMessageConst.Notification.DEFAULT_SOUND, 1);
        map3.put(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS, 1);
        map3.put(RemoteMessageConst.Notification.VIBRATE_TIMINGS, jArr);
        HashMap<String, Object> map4 = new HashMap<>(8);
        f29627i = map4;
        map4.put("tag", "");
        map4.put(RemoteMessageConst.Notification.WHEN, "");
        map4.put(RemoteMessageConst.Notification.LOCAL_ONLY, 1);
        map4.put(RemoteMessageConst.Notification.BADGE_SET_NUM, "");
        map4.put("priority", "");
        map4.put(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        map4.put("visibility", "");
        map4.put("channelId", "");
        HashMap<String, Object> map5 = new HashMap<>(3);
        f29628j = map5;
        map5.put(RemoteMessageConst.Notification.CLICK_ACTION, "");
        map5.put(RemoteMessageConst.Notification.INTENT_URI, "");
        map5.put("url", "");
        CREATOR = new C6281a();
    }

    public RemoteMessage(Bundle bundle) {
        this.f29629a = m36493a(bundle);
    }

    /* renamed from: a */
    private Bundle m36493a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        JSONObject jSONObjectM36496b = m36496b(bundle);
        JSONObject jSONObjectM36495a = m36495a(jSONObjectM36496b);
        String string = JsonUtil.getString(jSONObjectM36495a, "data", null);
        bundle2.putString(RemoteMessageConst.ANALYTIC_INFO, JsonUtil.getString(jSONObjectM36495a, RemoteMessageConst.ANALYTIC_INFO, null));
        bundle2.putString(RemoteMessageConst.DEVICE_TOKEN, bundle.getString(RemoteMessageConst.DEVICE_TOKEN));
        JSONObject jSONObjectM36499d = m36499d(jSONObjectM36495a);
        JSONObject jSONObjectM36497b = m36497b(jSONObjectM36499d);
        JSONObject jSONObjectM36498c = m36498c(jSONObjectM36499d);
        if (bundle.getInt(RemoteMessageConst.INPUT_TYPE) == 1 && AbstractC6285d.m36510a(jSONObjectM36495a, jSONObjectM36499d, string)) {
            bundle2.putString("data", AbstractC6282a.m36503a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
            return bundle2;
        }
        String string2 = bundle.getString(RemoteMessageConst.f29664TO);
        String string3 = bundle.getString(RemoteMessageConst.MSGTYPE);
        String string4 = JsonUtil.getString(jSONObjectM36495a, RemoteMessageConst.MSGID, null);
        bundle2.putString(RemoteMessageConst.f29664TO, string2);
        bundle2.putString("data", string);
        bundle2.putString(RemoteMessageConst.MSGID, string4);
        bundle2.putString(RemoteMessageConst.MSGTYPE, string3);
        JsonUtil.transferJsonObjectToBundle(jSONObjectM36496b, bundle2, f29624f);
        bundle2.putBundle("notification", m36494a(jSONObjectM36496b, jSONObjectM36495a, jSONObjectM36499d, jSONObjectM36497b, jSONObjectM36498c));
        return bundle2;
    }

    /* renamed from: b */
    private static JSONObject m36496b(Bundle bundle) {
        try {
            return new JSONObject(AbstractC6282a.m36503a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
        } catch (JSONException unused) {
            HMSLog.m36989w("RemoteMessage", "JSONException:parse message body failed.");
            return null;
        }
    }

    /* renamed from: c */
    private static JSONObject m36498c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PARAM);
        }
        return null;
    }

    /* renamed from: d */
    private static JSONObject m36499d(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public String getAnalyticInfo() {
        return this.f29629a.getString(RemoteMessageConst.ANALYTIC_INFO);
    }

    public Map<String, String> getAnalyticInfoMap() {
        HashMap map = new HashMap();
        String string = this.f29629a.getString(RemoteMessageConst.ANALYTIC_INFO);
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String strValueOf = String.valueOf(itKeys.next());
                    map.put(strValueOf, String.valueOf(jSONObject.get(strValueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.m36989w("RemoteMessage", "JSONException: get analyticInfo from map failed.");
            }
        }
        return map;
    }

    public String getCollapseKey() {
        return this.f29629a.getString(RemoteMessageConst.COLLAPSE_KEY);
    }

    public String getData() {
        return this.f29629a.getString("data");
    }

    public Map<String, String> getDataOfMap() {
        HashMap map = new HashMap();
        String string = this.f29629a.getString("data");
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String strValueOf = String.valueOf(itKeys.next());
                    map.put(strValueOf, String.valueOf(jSONObject.get(strValueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.m36989w("RemoteMessage", "JSONException: get data from map failed");
            }
        }
        return map;
    }

    public String getFrom() {
        return this.f29629a.getString(RemoteMessageConst.FROM);
    }

    public String getMessageId() {
        return this.f29629a.getString(RemoteMessageConst.MSGID);
    }

    public String getMessageType() {
        return this.f29629a.getString(RemoteMessageConst.MSGTYPE);
    }

    public Notification getNotification() {
        Bundle bundle = this.f29629a.getBundle("notification");
        C6281a c6281a = null;
        if (this.f29630b == null && bundle != null) {
            this.f29630b = new Notification(bundle, c6281a);
        }
        if (this.f29630b == null) {
            this.f29630b = new Notification(new Bundle(), c6281a);
        }
        return this.f29630b;
    }

    public int getOriginalUrgency() {
        int i10 = this.f29629a.getInt(RemoteMessageConst.ORI_URGENCY);
        if (i10 == 1 || i10 == 2) {
            return i10;
        }
        return 0;
    }

    public int getReceiptMode() {
        return this.f29629a.getInt(RemoteMessageConst.RECEIPT_MODE);
    }

    public int getSendMode() {
        return this.f29629a.getInt(RemoteMessageConst.SEND_MODE);
    }

    public long getSentTime() {
        try {
            String string = this.f29629a.getString(RemoteMessageConst.SEND_TIME);
            if (TextUtils.isEmpty(string)) {
                return 0L;
            }
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            HMSLog.m36989w("RemoteMessage", "NumberFormatException: get sendTime error.");
            return 0L;
        }
    }

    public String getTo() {
        return this.f29629a.getString(RemoteMessageConst.f29664TO);
    }

    public String getToken() {
        return this.f29629a.getString(RemoteMessageConst.DEVICE_TOKEN);
    }

    public int getTtl() {
        return this.f29629a.getInt("ttl");
    }

    public int getUrgency() {
        int i10 = this.f29629a.getInt(RemoteMessageConst.URGENCY);
        if (i10 == 1 || i10 == 2) {
            return i10;
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeBundle(this.f29629a);
        parcel.writeSerializable(this.f29630b);
    }

    public RemoteMessage(Parcel parcel) {
        this.f29629a = parcel.readBundle();
        this.f29630b = (Notification) parcel.readSerializable();
    }

    /* renamed from: b */
    private static JSONObject m36497b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
        }
        return null;
    }

    /* renamed from: a */
    private Bundle m36494a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        Bundle bundle = new Bundle();
        JsonUtil.transferJsonObjectToBundle(jSONObject3, bundle, f29625g);
        JsonUtil.transferJsonObjectToBundle(jSONObject4, bundle, f29626h);
        JsonUtil.transferJsonObjectToBundle(jSONObject, bundle, f29627i);
        JsonUtil.transferJsonObjectToBundle(jSONObject5, bundle, f29628j);
        bundle.putInt(RemoteMessageConst.Notification.NOTIFY_ID, JsonUtil.getInt(jSONObject2, RemoteMessageConst.Notification.NOTIFY_ID, 0));
        return bundle;
    }

    /* renamed from: a */
    private static JSONObject m36495a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
        }
        return null;
    }
}
