package com.huawei.hwidauth.datatype;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;
import org.xmlpull.v1.XmlSerializer;
import p432kq.C11143o;
import p640sq.C12836o;
import p640sq.C12843v;

/* loaded from: classes8.dex */
public class DeviceInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<DeviceInfo> CREATOR = new C6695a();

    /* renamed from: a */
    public String f31024a;

    /* renamed from: b */
    public String f31025b;

    /* renamed from: c */
    public String f31026c;

    /* renamed from: d */
    public String f31027d;

    /* renamed from: e */
    public String f31028e;

    /* renamed from: com.huawei.hwidauth.datatype.DeviceInfo$a */
    public class C6695a implements Parcelable.Creator<DeviceInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DeviceInfo createFromParcel(Parcel parcel) {
            return new DeviceInfo(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DeviceInfo[] newArray(int i10) {
            return new DeviceInfo[i10];
        }
    }

    public /* synthetic */ DeviceInfo(Parcel parcel, C6695a c6695a) {
        this(parcel);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0092 A[Catch: Exception -> 0x00a6, JSONException -> 0x00b1, TryCatch #2 {JSONException -> 0x00b1, Exception -> 0x00a6, blocks: (B:6:0x0012, B:8:0x0026, B:10:0x002c, B:12:0x0032, B:40:0x0083, B:41:0x0088, B:42:0x008d, B:43:0x0092, B:21:0x004f, B:24:0x0059, B:27:0x0063, B:30:0x006d, B:44:0x0097), top: B:52:0x0012 }] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hwidauth.datatype.DeviceInfo m38003c(android.content.Context r16, java.lang.String r17) throws org.json.JSONException, java.lang.IllegalArgumentException {
        /*
            java.lang.String r0 = "device is not json"
            boolean r1 = android.text.TextUtils.isEmpty(r17)
            java.lang.String r2 = "DeviceInfo"
            r3 = 1
            if (r1 == 0) goto L12
            java.lang.String r0 = "jsonStr is null."
            p640sq.C12836o.m77099d(r2, r0, r3)
            r0 = 0
            return r0
        L12:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> La6 org.json.JSONException -> Lb1
            r4 = r17
            r1.<init>(r4)     // Catch: java.lang.Exception -> La6 org.json.JSONException -> Lb1
            java.lang.String r4 = "deviceInfo"
            org.json.JSONArray r1 = r1.getJSONArray(r4)     // Catch: java.lang.Exception -> La6 org.json.JSONException -> Lb1
            r4 = 0
            java.lang.String r5 = ""
            r9 = r4
            r6 = r5
            r7 = r6
            r8 = r7
        L26:
            int r10 = r1.length()     // Catch: java.lang.Exception -> La6 org.json.JSONException -> Lb1
            if (r9 >= r10) goto L9f
            org.json.JSONObject r10 = r1.getJSONObject(r9)     // Catch: java.lang.Exception -> La6 org.json.JSONException -> Lb1
            if (r10 == 0) goto L97
            java.lang.String r11 = "deviceType"
            java.lang.String r11 = r10.optString(r11)     // Catch: java.lang.Exception -> La6 org.json.JSONException -> Lb1
            int r12 = r11.hashCode()     // Catch: java.lang.Exception -> La6 org.json.JSONException -> Lb1
            r13 = 48
            r14 = 2
            r15 = 3
            if (r12 == r13) goto L6d
            r13 = 54
            if (r12 == r13) goto L63
            r13 = 56
            if (r12 == r13) goto L59
            r13 = 57
            if (r12 == r13) goto L4f
            goto L77
        L4f:
            java.lang.String r12 = "9"
            boolean r11 = r11.equals(r12)     // Catch: java.lang.Exception -> La6 org.json.JSONException -> Lb1
            if (r11 == 0) goto L77
            r11 = r15
            goto L78
        L59:
            java.lang.String r12 = "8"
            boolean r11 = r11.equals(r12)     // Catch: java.lang.Exception -> La6 org.json.JSONException -> Lb1
            if (r11 == 0) goto L77
            r11 = r14
            goto L78
        L63:
            java.lang.String r12 = "6"
            boolean r11 = r11.equals(r12)     // Catch: java.lang.Exception -> La6 org.json.JSONException -> Lb1
            if (r11 == 0) goto L77
            r11 = r3
            goto L78
        L6d:
            java.lang.String r12 = "0"
            boolean r11 = r11.equals(r12)     // Catch: java.lang.Exception -> La6 org.json.JSONException -> Lb1
            if (r11 == 0) goto L77
            r11 = r4
            goto L78
        L77:
            r11 = -1
        L78:
            java.lang.String r12 = "deviceID"
            if (r11 == 0) goto L92
            if (r11 == r3) goto L8d
            if (r11 == r14) goto L88
            if (r11 == r15) goto L83
            goto L9c
        L83:
            java.lang.String r7 = r10.optString(r12)     // Catch: java.lang.Exception -> La6 org.json.JSONException -> Lb1
            goto L9c
        L88:
            java.lang.String r5 = r10.optString(r12)     // Catch: java.lang.Exception -> La6 org.json.JSONException -> Lb1
            goto L9c
        L8d:
            java.lang.String r8 = r10.optString(r12)     // Catch: java.lang.Exception -> La6 org.json.JSONException -> Lb1
            goto L9c
        L92:
            java.lang.String r6 = r10.optString(r12)     // Catch: java.lang.Exception -> La6 org.json.JSONException -> Lb1
            goto L9c
        L97:
            java.lang.String r10 = "jsonObject is null."
            p640sq.C12836o.m77099d(r2, r10, r3)     // Catch: java.lang.Exception -> La6 org.json.JSONException -> Lb1
        L9c:
            int r9 = r9 + 1
            goto L26
        L9f:
            r1 = r16
            com.huawei.hwidauth.datatype.DeviceInfo r0 = m38004d(r1, r5, r6, r7, r8)
            return r0
        La6:
            java.lang.String r1 = "func json2device, parse exception."
            p640sq.C12836o.m77099d(r2, r1, r3)
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        Lb1:
            java.lang.String r1 = "func json2device, json parse exception."
            p640sq.C12836o.m77099d(r2, r1, r3)
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwidauth.datatype.DeviceInfo.m38003c(android.content.Context, java.lang.String):com.huawei.hwidauth.datatype.DeviceInfo");
    }

    /* renamed from: d */
    public static DeviceInfo m38004d(Context context, String str, String str2, String str3, String str4) throws IllegalArgumentException {
        String str5;
        if (m38006h(str, str2, str3, str4)) {
            throw new IllegalArgumentException("all device id are empty， at least pass one param");
        }
        if (!TextUtils.isEmpty(str)) {
            C12836o.m77097b("DeviceInfo", "sn is not empty, use sn, device2 is udid", true);
            str5 = "8";
        } else if (!TextUtils.isEmpty(str2)) {
            C12836o.m77097b("DeviceInfo", "imei is not empty, use imei", true);
            str5 = "0";
            str = str2;
        } else if (TextUtils.isEmpty(str3)) {
            C12836o.m77097b("DeviceInfo", "imei is empty， use uuid", true);
            str = TextUtils.isEmpty(str4) ? C12843v.m77126c() : str4;
            str5 = "6";
        } else {
            C12836o.m77097b("DeviceInfo", "udid is not empty, use udid", true);
            str5 = "9";
            str = str3;
        }
        String strM77127d = C12843v.m77127d(context);
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.m38016r(strM77127d);
        deviceInfo.m38012n(str5);
        deviceInfo.m38008f(str);
        deviceInfo.m38010l(C12843v.m77124a());
        deviceInfo.m38014p(C12843v.m77125b(context));
        return deviceInfo;
    }

    /* renamed from: g */
    public static void m38005g(XmlSerializer xmlSerializer, DeviceInfo deviceInfo) throws IllegalStateException, IOException, IllegalArgumentException {
        if (xmlSerializer == null || deviceInfo == null) {
            return;
        }
        C11143o.m67049c(xmlSerializer, "deviceID", deviceInfo.m38007e());
        C11143o.m67049c(xmlSerializer, "uuid", deviceInfo.m38015q());
        C11143o.m67049c(xmlSerializer, JsbMapKeyNames.H5_DEVICE_TYPE, deviceInfo.m38011m());
        C11143o.m67049c(xmlSerializer, "terminalType", deviceInfo.m38009j());
        if (TextUtils.isEmpty(deviceInfo.m38013o())) {
            return;
        }
        C11143o.m67049c(xmlSerializer, "deviceAliasName", deviceInfo.m38013o());
    }

    /* renamed from: h */
    public static boolean m38006h(String str, String str2, String str3, String str4) throws IllegalArgumentException {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3) || !TextUtils.isEmpty(str4)) {
            return false;
        }
        C12836o.m77099d("DeviceInfo", "all device id are empty, at least pass one param", true);
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public String m38007e() {
        return this.f31026c;
    }

    /* renamed from: f */
    public final void m38008f(String str) {
        this.f31026c = str;
    }

    /* renamed from: j */
    public String m38009j() {
        return !TextUtils.isEmpty(this.f31027d) ? this.f31027d.toUpperCase(Locale.ENGLISH) : this.f31027d;
    }

    /* renamed from: l */
    public final void m38010l(String str) {
        this.f31027d = str;
    }

    /* renamed from: m */
    public String m38011m() {
        return this.f31025b;
    }

    /* renamed from: n */
    public final void m38012n(String str) {
        this.f31025b = str;
    }

    /* renamed from: o */
    public String m38013o() {
        return TextUtils.isEmpty(this.f31028e) ? m38009j() : this.f31028e;
    }

    /* renamed from: p */
    public final void m38014p(String str) {
        this.f31028e = str;
    }

    /* renamed from: q */
    public String m38015q() {
        return this.f31024a;
    }

    /* renamed from: r */
    public final void m38016r(String str) {
        this.f31024a = str;
    }

    public String toString() {
        return "{'mUUid':" + this.f31024a + "{'mDeviceAliasName':" + this.f31028e + ",'mDeviceID':" + this.f31026c + ",'mTerminalType':" + this.f31027d + ",'mDeviceType':" + this.f31025b + ",'mLoginTime':}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f31024a);
        parcel.writeString(this.f31026c);
        parcel.writeString(this.f31028e);
        parcel.writeString(this.f31025b);
        parcel.writeString(this.f31027d);
    }

    public DeviceInfo(Parcel parcel) {
        this.f31024a = parcel.readString();
        this.f31026c = parcel.readString();
        this.f31028e = parcel.readString();
        this.f31025b = parcel.readString();
        this.f31027d = parcel.readString();
    }

    public DeviceInfo() {
    }
}
