# com.huawei.hms.findnetwork

queryOfflineLocation


    public String m8636a(String str, double d10, double d11, double d12, double d13, int i10, Handler handler) throws JSONException {
        this.f6524c = "";
        try {
            String strM8827f = C1540c.m8807a(LocationClient.mContext).m8827f();
            String str2 = C1534f.f6675u;
            C1534f.m8725c("GC_URL==https://newclient.map.baidu.com/client/infopass/infopass/mecp ,strKeyword =" + str);
            C1534f.m8725c("par = " + strM8827f);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JsbMapKeyNames.H5_LOC_LON, d10);
            jSONObject.put(JsbMapKeyNames.H5_LOC_LAT, d13);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(JsbMapKeyNames.H5_LOC_LON, d12);
            jSONObject2.put(JsbMapKeyNames.H5_LOC_LAT, d11);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("oem", "huawei");
            jSONObject3.put("prod", C1534f.f6660f + LocationClient.mContext.getPackageName());
            jSONObject3.put("mb", Build.PRODUCT);
            jSONObject3.put("os", OsType.ANDROID + Build.VERSION.RELEASE);
            jSONObject3.put("mpk", "9e3eb12274ec8961114fe5487682be41");
            jSONObject3.put("cuid", str2);
            jSONObject3.put("bloc", Jni.encodeOfflineLocationUpdateRequest(strM8827f));
            jSONObject3.put("bottomleft", jSONObject);
            jSONObject3.put("topright", jSONObject2);
            jSONObject3.put("keyword", str);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("method", "getPreciseGeocode");
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("serverid", jSONObject4);
            jSONObject5.put(RemoteMessageConst.MessageBody.PARAM, jSONObject3);
            C1534f.m8725c("obj =" + jSONObject5.toString());
            C1534f.m8725c("prod =SDKHW5.5.10:buildn817:" + LocationClient.mContext.getPackageName());
            this.f6524c = m8634a(C1534f.f6662h, jSONObject5);
        } catch (Exception e10) {
            C1534f.m8725c("GC出现异常");
            e10.printStackTrace();
        }
        return this.f6524c;
    }
