package com.baidu.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.location.C1528a;
import com.baidu.location.p065a.C1534f;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class BDLocation implements Parcelable {
    public static final Parcelable.Creator<BDLocation> CREATOR = new Parcelable.Creator<BDLocation>() { // from class: com.baidu.location.BDLocation.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BDLocation createFromParcel(Parcel parcel) {
            return new BDLocation(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BDLocation[] newArray(int i10) {
            return new BDLocation[i10];
        }
    };
    public static final int LOCATION_WHERE_IN_CN = 1;
    public static final int LOCATION_WHERE_OUT_CN = 0;
    public static final int LOCATION_WHERE_UNKNOW = 2;
    public static final int OPERATORS_TYPE_MOBILE = 1;
    public static final int OPERATORS_TYPE_TELECOMU = 3;
    public static final int OPERATORS_TYPE_UNICOM = 2;
    public static final int OPERATORS_TYPE_UNKONW = 0;
    public static final int TypeBDLocationEmpty = -2;
    public static final int TypeCacheLocation = 65;
    public static final int TypeCriteriaException = 62;
    public static final int TypeGpsLocation = 61;
    public static final int TypeLocNotCorrect = 7;
    public static final int TypeNetWorkException = 63;
    public static final int TypeNetWorkLocation = 161;
    public static final int TypeNetworkException = 5;
    public static final int TypeNoRouteToHostException = 2;
    public static final int TypeNone = 0;
    public static final int TypeOffLineLocation = 66;
    public static final int TypeOffLineLocationFail = 67;
    public static final int TypeOffLineLocationNetworkFail = 68;
    public static final int TypeResponseEmpty = 8;
    public static final int TypeServerError = 167;
    public static final int TypeSocketException = 4;
    public static final int TypeSocketTimeoutException = 3;
    public static final int TypeStatusNot200 = 1;
    public static final int TypeThreadInterruptedException = 9;
    private String buildingid;
    private String floor;
    private boolean indoorLocMode;
    private boolean isCellChangeFlag;
    private C1528a mAddr;
    private String mAddrStr;
    private double mAltitude;
    private String mCoorType;
    private String mCu;
    private float mDerect;
    private boolean mHasAddr;
    private boolean mHasAltitude;
    private boolean mHasRadius;
    private boolean mHasSateNumber;
    private boolean mHasSpeed;
    private double mLatitude;
    private int mLocType;
    private int mLocationWhere;
    private double mLongitude;
    private int mOperators;
    private int mParkState;
    private float mRadius;
    private int mSatelliteNumber;
    private String mSemaAptag;
    private String mSemaPoiRegion;
    private String mSemaRegular;
    private float mSpeed;
    private String mTime;
    private String netWorkLocationType;

    public BDLocation() {
        this.mLocType = 0;
        this.mTime = null;
        this.mLatitude = Double.MIN_VALUE;
        this.mLongitude = Double.MIN_VALUE;
        this.mHasAltitude = false;
        this.mAltitude = Double.MIN_VALUE;
        this.mHasSpeed = false;
        this.mSpeed = 0.0f;
        this.mHasRadius = false;
        this.mRadius = 0.0f;
        this.mHasSateNumber = false;
        this.mSatelliteNumber = -1;
        this.mDerect = -1.0f;
        this.mCoorType = null;
        this.mHasAddr = false;
        this.mAddrStr = null;
        this.mSemaAptag = null;
        this.mSemaPoiRegion = null;
        this.mSemaRegular = null;
        this.isCellChangeFlag = false;
        this.mAddr = new C1528a.a().build();
        this.floor = null;
        this.buildingid = null;
        this.indoorLocMode = false;
        this.mParkState = 0;
        this.mLocationWhere = 1;
        this.netWorkLocationType = null;
        this.mCu = "";
    }

    private String getCuid() {
        return this.mCu;
    }

    private static String getModel() {
        return Build.MODEL;
    }

    private String getSemaPoiRegion() {
        return this.mSemaPoiRegion;
    }

    private String getSemaRegular() {
        return this.mSemaRegular;
    }

    private void setCellChangeFlag(Boolean bool) {
        this.isCellChangeFlag = bool.booleanValue();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddrStr() {
        return this.mAddr.address;
    }

    public C1528a getAddress() {
        return this.mAddr;
    }

    public double getAltitude() {
        return this.mAltitude;
    }

    public String getBuildingID() {
        return this.buildingid;
    }

    public String getCity() {
        return this.mAddr.city;
    }

    public String getCityCode() {
        return this.mAddr.cityCode;
    }

    public String getCoorType() {
        return this.mCoorType;
    }

    public String getCountry() {
        return this.mAddr.country;
    }

    public String getCountryCode() {
        return this.mAddr.countryCode;
    }

    public float getDerect() {
        return this.mDerect;
    }

    public float getDirection() {
        return this.mDerect;
    }

    public String getDistrict() {
        return this.mAddr.district;
    }

    public String getFloor() {
        return this.floor;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public int getLocType() {
        return this.mLocType;
    }

    public String getLocationTag() {
        return this.mSemaAptag;
    }

    public int getLocationWhere() {
        return this.mLocationWhere;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public String getNetworkLocationType() {
        return this.netWorkLocationType;
    }

    public int getOperators() {
        return this.mOperators;
    }

    public String getProvince() {
        return this.mAddr.province;
    }

    public float getRadius() {
        return this.mRadius;
    }

    public int getSatelliteNumber() {
        this.mHasSateNumber = true;
        return this.mSatelliteNumber;
    }

    @Deprecated
    public String getSemaAptag() {
        return this.mSemaAptag;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public String getStreet() {
        return this.mAddr.street;
    }

    public String getStreetNumber() {
        return this.mAddr.streetNumber;
    }

    public String getTime() {
        return this.mTime;
    }

    public boolean hasAddr() {
        return this.mHasAddr;
    }

    public boolean hasAltitude() {
        return this.mHasAltitude;
    }

    public boolean hasRadius() {
        return this.mHasRadius;
    }

    public boolean hasSateNumber() {
        return this.mHasSateNumber;
    }

    public boolean hasSpeed() {
        return this.mHasSpeed;
    }

    public boolean isCellChangeFlag() {
        return this.isCellChangeFlag;
    }

    public boolean isIndoorLocMode() {
        return this.indoorLocMode;
    }

    public int isParkAvailable() {
        return this.mParkState;
    }

    public void setAddr(C1528a c1528a) {
        if (c1528a != null) {
            this.mAddr = c1528a;
            this.mHasAddr = true;
        }
    }

    public void setAddrStr(String str) {
        this.mAddrStr = str;
        this.mHasAddr = str != null;
    }

    public void setAltitude(double d10) {
        this.mAltitude = d10;
        this.mHasAltitude = true;
    }

    public void setBuildingID(String str) {
        this.buildingid = str;
    }

    public void setCoorType(String str) {
        this.mCoorType = str;
    }

    public void setDirection(float f10) {
        this.mDerect = f10;
    }

    public void setFloor(String str) {
        this.floor = str;
    }

    public void setIndoorLocMode(boolean z10) {
        this.indoorLocMode = z10;
    }

    public void setLatitude(double d10) {
        this.mLatitude = d10;
    }

    public void setLocType(int i10) {
        this.mLocType = i10;
    }

    public void setLocationWhere(int i10) {
        this.mLocationWhere = i10;
    }

    public void setLongitude(double d10) {
        this.mLongitude = d10;
    }

    public void setNetworkLocationType(String str) {
        this.netWorkLocationType = str;
    }

    public void setOperators(int i10) {
        this.mOperators = i10;
    }

    public void setParkAvailable(int i10) {
        this.mParkState = i10;
    }

    public void setRadius(float f10) {
        this.mRadius = f10;
        this.mHasRadius = true;
    }

    public void setSatelliteNumber(int i10) {
        this.mSatelliteNumber = i10;
    }

    public void setSpeed(float f10) {
        this.mSpeed = f10;
        this.mHasSpeed = true;
    }

    public void setTime(String str) {
        this.mTime = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mLocType);
        parcel.writeString(this.mTime);
        parcel.writeDouble(this.mLatitude);
        parcel.writeDouble(this.mLongitude);
        parcel.writeDouble(this.mAltitude);
        parcel.writeFloat(this.mSpeed);
        parcel.writeFloat(this.mRadius);
        parcel.writeInt(this.mSatelliteNumber);
        parcel.writeFloat(this.mDerect);
        parcel.writeString(this.floor);
        parcel.writeInt(this.mParkState);
        parcel.writeString(this.buildingid);
        parcel.writeString(this.netWorkLocationType);
        parcel.writeString(this.mAddr.province);
        parcel.writeString(this.mAddr.city);
        parcel.writeString(this.mAddr.district);
        parcel.writeString(this.mAddr.street);
        parcel.writeString(this.mAddr.streetNumber);
        parcel.writeString(this.mAddr.cityCode);
        parcel.writeString(this.mAddr.address);
        parcel.writeString(this.mAddr.country);
        parcel.writeString(this.mAddr.countryCode);
        parcel.writeInt(this.mOperators);
        parcel.writeString(this.mCu);
        parcel.writeString(this.mSemaAptag);
        parcel.writeString(this.mSemaPoiRegion);
        parcel.writeString(this.mSemaRegular);
        parcel.writeInt(this.mLocationWhere);
        parcel.writeBooleanArray(new boolean[]{this.mHasAltitude, this.mHasSpeed, this.mHasRadius, this.mHasSateNumber, this.mHasAddr, this.isCellChangeFlag, this.indoorLocMode});
    }

    private BDLocation(Parcel parcel) {
        this.mLocType = 0;
        this.mTime = null;
        this.mLatitude = Double.MIN_VALUE;
        this.mLongitude = Double.MIN_VALUE;
        this.mHasAltitude = false;
        this.mAltitude = Double.MIN_VALUE;
        this.mHasSpeed = false;
        this.mSpeed = 0.0f;
        this.mHasRadius = false;
        this.mRadius = 0.0f;
        this.mHasSateNumber = false;
        this.mSatelliteNumber = -1;
        this.mDerect = -1.0f;
        this.mCoorType = null;
        this.mHasAddr = false;
        this.mAddrStr = null;
        this.mSemaAptag = null;
        this.mSemaPoiRegion = null;
        this.mSemaRegular = null;
        this.isCellChangeFlag = false;
        this.mAddr = new C1528a.a().build();
        this.floor = null;
        this.buildingid = null;
        this.indoorLocMode = false;
        this.mParkState = 0;
        this.mLocationWhere = 1;
        this.netWorkLocationType = null;
        this.mCu = "";
        this.mLocType = parcel.readInt();
        this.mTime = parcel.readString();
        this.mLatitude = parcel.readDouble();
        this.mLongitude = parcel.readDouble();
        this.mAltitude = parcel.readDouble();
        this.mSpeed = parcel.readFloat();
        this.mRadius = parcel.readFloat();
        this.mSatelliteNumber = parcel.readInt();
        this.mDerect = parcel.readFloat();
        this.floor = parcel.readString();
        this.mParkState = parcel.readInt();
        this.buildingid = parcel.readString();
        this.netWorkLocationType = parcel.readString();
        String string = parcel.readString();
        String string2 = parcel.readString();
        String string3 = parcel.readString();
        String string4 = parcel.readString();
        String string5 = parcel.readString();
        String string6 = parcel.readString();
        parcel.readString();
        String string7 = parcel.readString();
        this.mAddr = new C1528a.a().country(string7).countryCode(parcel.readString()).province(string).city(string2).cityCode(string6).district(string3).street(string4).streetNumber(string5).build();
        boolean[] zArr = new boolean[7];
        this.mOperators = parcel.readInt();
        this.mCu = parcel.readString();
        this.mSemaAptag = parcel.readString();
        this.mSemaPoiRegion = parcel.readString();
        this.mSemaRegular = parcel.readString();
        this.mLocationWhere = parcel.readInt();
        try {
            parcel.readBooleanArray(zArr);
            this.mHasAltitude = zArr[0];
            this.mHasSpeed = zArr[1];
            this.mHasRadius = zArr[2];
            this.mHasSateNumber = zArr[3];
            this.mHasAddr = zArr[4];
            this.isCellChangeFlag = zArr[5];
            this.indoorLocMode = zArr[6];
        } catch (Exception e10) {
            if (C1534f.f6655a) {
                e10.printStackTrace();
            }
        }
    }

    public BDLocation(BDLocation bDLocation) {
        this.mLocType = 0;
        this.mTime = null;
        this.mLatitude = Double.MIN_VALUE;
        this.mLongitude = Double.MIN_VALUE;
        this.mHasAltitude = false;
        this.mAltitude = Double.MIN_VALUE;
        this.mHasSpeed = false;
        this.mSpeed = 0.0f;
        this.mHasRadius = false;
        this.mRadius = 0.0f;
        this.mHasSateNumber = false;
        this.mSatelliteNumber = -1;
        this.mDerect = -1.0f;
        this.mCoorType = null;
        this.mHasAddr = false;
        this.mAddrStr = null;
        this.mSemaAptag = null;
        this.mSemaPoiRegion = null;
        this.mSemaRegular = null;
        this.isCellChangeFlag = false;
        this.mAddr = new C1528a.a().build();
        this.floor = null;
        this.buildingid = null;
        this.indoorLocMode = false;
        this.mParkState = 0;
        this.mLocationWhere = 1;
        this.netWorkLocationType = null;
        this.mCu = "";
        this.mLocType = bDLocation.mLocType;
        this.mTime = bDLocation.mTime;
        this.mLatitude = bDLocation.mLatitude;
        this.mLongitude = bDLocation.mLongitude;
        this.mHasAltitude = bDLocation.mHasAltitude;
        this.mAltitude = bDLocation.mAltitude;
        this.mHasSpeed = bDLocation.mHasSpeed;
        this.mSpeed = bDLocation.mSpeed;
        this.mHasRadius = bDLocation.mHasRadius;
        this.mRadius = bDLocation.mRadius;
        this.mHasSateNumber = bDLocation.mHasSateNumber;
        this.mSatelliteNumber = bDLocation.mSatelliteNumber;
        this.mDerect = bDLocation.mDerect;
        this.mCoorType = bDLocation.mCoorType;
        this.mHasAddr = bDLocation.mHasAddr;
        this.mAddrStr = bDLocation.mAddrStr;
        this.isCellChangeFlag = bDLocation.isCellChangeFlag;
        this.mAddr = new C1528a.a().country(bDLocation.mAddr.country).countryCode(bDLocation.mAddr.countryCode).province(bDLocation.mAddr.province).city(bDLocation.mAddr.city).cityCode(bDLocation.mAddr.cityCode).district(bDLocation.mAddr.district).street(bDLocation.mAddr.street).streetNumber(bDLocation.mAddr.streetNumber).build();
        this.floor = bDLocation.floor;
        this.buildingid = bDLocation.buildingid;
        this.mLocationWhere = bDLocation.mLocationWhere;
        this.mParkState = bDLocation.mParkState;
        this.indoorLocMode = bDLocation.indoorLocMode;
        this.netWorkLocationType = bDLocation.netWorkLocationType;
        this.mOperators = bDLocation.mOperators;
        this.mCu = bDLocation.mCu;
        this.mSemaAptag = bDLocation.mSemaAptag;
        this.mSemaPoiRegion = bDLocation.mSemaPoiRegion;
        this.mSemaRegular = bDLocation.mSemaRegular;
    }

    public BDLocation(String str) throws JSONException, NumberFormatException {
        String str2;
        int i10;
        String str3;
        this.mLocType = 0;
        this.mTime = null;
        this.mLatitude = Double.MIN_VALUE;
        this.mLongitude = Double.MIN_VALUE;
        this.mHasAltitude = false;
        this.mAltitude = Double.MIN_VALUE;
        this.mHasSpeed = false;
        this.mSpeed = 0.0f;
        this.mHasRadius = false;
        this.mRadius = 0.0f;
        this.mHasSateNumber = false;
        this.mSatelliteNumber = -1;
        this.mDerect = -1.0f;
        this.mCoorType = null;
        this.mHasAddr = false;
        this.mAddrStr = null;
        this.mSemaAptag = null;
        this.mSemaPoiRegion = null;
        this.mSemaRegular = null;
        this.isCellChangeFlag = false;
        this.mAddr = new C1528a.a().build();
        this.floor = null;
        this.buildingid = null;
        this.indoorLocMode = false;
        this.mParkState = 0;
        this.mLocationWhere = 1;
        this.netWorkLocationType = null;
        this.mCu = "";
        if (str == null || str.equals("")) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("result");
            int i11 = Integer.parseInt(jSONObject2.getString(VastAttribute.ERROR));
            setLocType(i11);
            setTime(jSONObject2.getString("time"));
            if (i11 == 61) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("content");
                JSONObject jSONObject4 = jSONObject3.getJSONObject("point");
                setLatitude(Double.parseDouble(jSONObject4.getString("y")));
                setLongitude(Double.parseDouble(jSONObject4.getString(Constants.MULTIPLE_SIGN)));
                setRadius(Float.parseFloat(jSONObject3.getString("radius")));
                setSpeed(Float.parseFloat(jSONObject3.getString("s")));
                setDirection(Float.parseFloat(jSONObject3.getString("d")));
                setSatelliteNumber(Integer.parseInt(jSONObject3.getString("n")));
                if (jSONObject3.has("h")) {
                    try {
                        setAltitude(jSONObject3.getDouble("h"));
                    } catch (Exception unused) {
                    }
                }
                try {
                    setLocationWhere(jSONObject3.has("in_cn") ? Integer.parseInt(jSONObject3.getString("in_cn")) : 1);
                } catch (Exception unused2) {
                }
                if (this.mLocationWhere == 0) {
                    str2 = "wgs84";
                    setCoorType(str2);
                    return;
                }
                setCoorType("gcj02");
            }
            if (i11 == 161) {
                JSONObject jSONObject5 = jSONObject.getJSONObject("content");
                JSONObject jSONObject6 = jSONObject5.getJSONObject("point");
                setLatitude(Double.parseDouble(jSONObject6.getString("y")));
                setLongitude(Double.parseDouble(jSONObject6.getString(Constants.MULTIPLE_SIGN)));
                setRadius(Float.parseFloat(jSONObject5.getString("radius")));
                if (jSONObject5.has("sema")) {
                    JSONObject jSONObject7 = jSONObject5.getJSONObject("sema");
                    if (jSONObject7.has("aptag")) {
                        String string = jSONObject7.getString("aptag");
                        if (!TextUtils.isEmpty(string)) {
                            this.mSemaAptag = string;
                        } else {
                            this.mSemaAptag = "";
                        }
                    }
                    if (jSONObject7.has("poiregion")) {
                        String string2 = jSONObject7.getString("poiregion");
                        if (!TextUtils.isEmpty(string2)) {
                            this.mSemaPoiRegion = string2;
                        }
                    }
                    if (jSONObject7.has("regular")) {
                        String string3 = jSONObject7.getString("regular");
                        if (!TextUtils.isEmpty(string3)) {
                            this.mSemaRegular = string3;
                        }
                    }
                }
                if (jSONObject5.has("addr")) {
                    String[] strArrSplit = jSONObject5.getString("addr").split(",");
                    int length = strArrSplit.length;
                    if (length > 0) {
                        str3 = strArrSplit[0];
                        i10 = 1;
                    } else {
                        i10 = 1;
                        str3 = null;
                    }
                    String str4 = length > i10 ? strArrSplit[i10] : null;
                    String str5 = length > 2 ? strArrSplit[2] : null;
                    String str6 = length > 3 ? strArrSplit[3] : null;
                    this.mAddr = new C1528a.a().country(length > 6 ? strArrSplit[6] : null).countryCode(length > 7 ? strArrSplit[7] : null).province(str3).city(str4).cityCode(length > 5 ? strArrSplit[5] : null).district(str5).street(str6).streetNumber(length > 4 ? strArrSplit[4] : null).build();
                    this.mHasAddr = true;
                } else {
                    this.mHasAddr = false;
                    setAddrStr(null);
                }
                if (jSONObject5.has("floor")) {
                    String string4 = jSONObject5.getString("floor");
                    this.floor = string4;
                    if (TextUtils.isEmpty(string4)) {
                        this.floor = null;
                    }
                }
                if (jSONObject5.has("loctp")) {
                    String string5 = jSONObject5.getString("loctp");
                    this.netWorkLocationType = string5;
                    if (TextUtils.isEmpty(string5)) {
                        this.netWorkLocationType = null;
                    }
                }
                if (jSONObject5.has("bldgid")) {
                    String string6 = jSONObject5.getString("bldgid");
                    this.buildingid = string6;
                    if (TextUtils.isEmpty(string6)) {
                        this.buildingid = null;
                    }
                }
                if (jSONObject5.has("ibav")) {
                    String string7 = jSONObject5.getString("ibav");
                    if (!TextUtils.isEmpty(string7) && !string7.equals("0")) {
                        this.mParkState = Integer.valueOf(string7).intValue();
                    } else {
                        this.mParkState = 0;
                    }
                }
                try {
                    setLocationWhere(jSONObject5.has("in_cn") ? Integer.parseInt(jSONObject5.getString("in_cn")) : 1);
                } catch (Exception unused3) {
                }
                if (this.mLocationWhere == 0) {
                    str2 = "wgs84";
                    setCoorType(str2);
                    return;
                }
            } else {
                if (i11 != 66 && i11 != 68) {
                    if (i11 == 167) {
                        setLocationWhere(2);
                        return;
                    }
                    return;
                }
                JSONObject jSONObject8 = jSONObject.getJSONObject("content");
                JSONObject jSONObject9 = jSONObject8.getJSONObject("point");
                setLatitude(Double.parseDouble(jSONObject9.getString("y")));
                setLongitude(Double.parseDouble(jSONObject9.getString(Constants.MULTIPLE_SIGN)));
                setRadius(Float.parseFloat(jSONObject8.getString("radius")));
                setCellChangeFlag(Boolean.valueOf(Boolean.parseBoolean(jSONObject8.getString("isCellChanged"))));
            }
            setCoorType("gcj02");
        } catch (Exception e10) {
            e10.printStackTrace();
            this.mLocType = 0;
            this.mHasAddr = false;
        }
    }
}
