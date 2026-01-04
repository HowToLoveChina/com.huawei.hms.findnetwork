package com.baidu.geocoder;

import android.content.Context;
import android.location.Address;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.geocoder.p064a.C1517a;
import com.baidu.geocoder.p064a.C1518b;
import com.baidu.geocoder.p064a.C1521e;
import com.baidu.geocoder.p064a.C1522f;
import com.baidu.geocoder.p064a.C1524h;
import com.baidu.location.LocationClient;
import com.baidu.location.p065a.C1534f;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class BaiduGeocodeProvider {

    /* renamed from: a */
    private double f6513a;

    /* renamed from: b */
    private double f6514b;

    /* renamed from: c */
    private Context f6515c;

    public BaiduGeocodeProvider(Context context) {
        LocationClient.mContext = context;
        C1518b.m8632a();
        this.f6515c = context;
    }

    /* renamed from: a */
    private static Address m8627a(C1522f c1522f) {
        if (c1522f == null) {
            return null;
        }
        Locale locale = Locale.getDefault();
        if (TextUtils.isEmpty(locale.getCountry())) {
            C1534f.m8725c("convertAddrInfo2Address,in china the countryStr is empty, new zh-CN Locale");
            locale = new Locale("zh", "CN");
        }
        Address address = new Address(locale);
        address.setCountryName(c1522f.f6533f);
        address.setLatitude(c1522f.f6532e);
        address.setLongitude(c1522f.f6531d);
        address.setAddressLine(0, c1522f.f6528a);
        address.setAdminArea(c1522f.f6535h);
        address.setLocality(c1522f.f6536i);
        address.setSubLocality(c1522f.f6537j);
        address.setThoroughfare(c1522f.f6538k);
        address.setSubThoroughfare(c1522f.f6539l);
        address.setCountryCode(c1522f.f6534g);
        C1534f.m8725c("GeoCodeResultParser,convertAddrInfo2Address(),Address:" + address.toString());
        ArrayList<C1524h> arrayList = c1522f.f6541n;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                C1524h c1524h = c1522f.f6541n.get(i10);
                if (c1524h != null) {
                    address.setAddressLine(i10 + 1, c1524h.m8658a());
                }
            }
        }
        return address;
    }

    public String onGetFromLocation(double d10, double d11, int i10, List<Address> list) {
        String strValueOf;
        C1534f.m8725c("dLati = " + d10 + ",dLongi = " + d11 + ",maxResults=" + i10);
        this.f6513a = (double) System.currentTimeMillis();
        C1534f.m8725c("time result:[Start reverseGeocoding......]");
        if (C1534f.m8719a(this.f6515c)) {
            C1534f.m8725c("in onGetFromLocation, dLati = " + d10 + ",dLongi = " + d11 + ",maxResults=" + i10);
            if (i10 < 0) {
                strValueOf = "rgeo result:[rgeo failed], reason:[maxResults < 0]";
            } else {
                C1517a c1517a = new C1517a();
                if (c1517a.m8629a(d11, d10, "")) {
                    Address addressM8627a = m8627a(c1517a.f6516a);
                    if (addressM8627a != null) {
                        C1534f.m8725c("rgeo result:[rego successful by Baidu]");
                        list.add(addressM8627a);
                    } else {
                        C1534f.m8725c("rgeo result:[rego failed by Baidu], reason:[no results found]");
                    }
                    this.f6514b = System.currentTimeMillis();
                    strValueOf = "time result:[A reverseGeocode by Baidu cost " + String.valueOf(this.f6514b - this.f6513a) + " ms ]";
                } else {
                    C1534f.m8725c("rgeo result:[rgeo network failed by Baidu], reason:[offline]");
                    strValueOf = String.valueOf(this.f6514b - this.f6513a);
                }
            }
        } else {
            strValueOf = "rgeo result:[rgeo failed], reason:[no active network]";
        }
        C1534f.m8725c(strValueOf);
        return null;
    }

    public String onGetFromLocationName(String str, double d10, double d11, double d12, double d13, int i10, List<Address> list) {
        String str2;
        C1534f.m8725c("locationName=" + str);
        if (str == null) {
            str2 = "geo result:[geo failed], reason:[locationName is null]";
        } else {
            String strM8628a = m8628a(str);
            C1534f.m8725c("locationName delete space [" + strM8628a + "]");
            if (C1518b.m8633b(strM8628a)) {
                C1518b.a aVarM8631a = C1518b.m8631a(strM8628a);
                String str3 = aVarM8631a.f6520a;
                String str4 = aVarM8631a.f6521b;
                Address address = new Address(Locale.getDefault());
                address.setLatitude(Double.parseDouble(str3));
                address.setLongitude(Double.parseDouble(str4));
                list.add(address);
                str2 = "geo result:[geo successful by Skyhook_CountryLevel_library]";
            } else if (!Settings.Secure.isLocationProviderEnabled(this.f6515c.getContentResolver(), "network")) {
                str2 = "geo result:[geo failed], reason:[network location disabled]";
            } else if (!C1534f.m8719a(this.f6515c)) {
                str2 = "geo result:[geo failed], reason:[no active network]";
            } else if (i10 < 0) {
                str2 = "geo result:[geo failed], reason:[maxResults < 0]";
            } else {
                C1534f.m8725c("in onGetFromLocation, locationName = " + strM8628a + ",lowerLeftLatitude  = " + d10 + ",lowerLeftLongitude = " + d11 + ",upperRightLatitude = " + d12 + ",upperRightLongitude= " + d13 + ",maxResults =" + i10);
                C1517a c1517a = new C1517a();
                if (c1517a.m8630a(strM8628a, d11, d12, d13, d10, i10)) {
                    int size = c1517a.f6517b.size();
                    C1534f.m8725c("mGeoCode.mAreaPoi.size() = " + c1517a.f6517b.size());
                    for (int i11 = 0; i11 < size; i11++) {
                        C1524h c1524h = c1517a.f6517b.get(i11);
                        Address address2 = new Address(Locale.getDefault());
                        address2.setLatitude(c1524h.m8673h());
                        address2.setLongitude(c1524h.m8672g());
                        address2.setAddressLine(0, c1524h.m8661b());
                        address2.setFeatureName(c1524h.m8658a());
                        address2.setPhone(c1524h.m8664c());
                        address2.setPostalCode(c1524h.m8667d());
                        C1522f c1522f = c1517a.f6516a;
                        if (c1522f != null) {
                            address2.setAdminArea(c1522f.f6535h);
                            address2.setLocality(c1517a.f6516a.f6536i);
                            address2.setSubLocality(c1517a.f6516a.f6537j);
                            address2.setThoroughfare(c1517a.f6516a.f6538k);
                        }
                        String strM8669e = c1524h.m8669e();
                        if (strM8669e == null || "null".equals(strM8669e) || "".equals(strM8669e.trim())) {
                            str2 = "geo result:[geo failed], reason:[no results found. A foreign city??]";
                        } else {
                            list.add(address2);
                        }
                    }
                    if (size == 0 && c1517a.f6516a != null) {
                        Address address3 = new Address(Locale.getDefault());
                        C1522f c1522f2 = c1517a.f6516a;
                        C1521e c1521eM8711a = C1534f.m8711a(c1522f2.f6532e, c1522f2.f6531d);
                        address3.setLatitude(c1521eM8711a.m8642a());
                        address3.setLongitude(c1521eM8711a.m8644b());
                        list.add(address3);
                        C1534f.m8725c("geo result:[geo successful by Baidu]");
                    }
                    return null;
                }
                str2 = "geo result:[geo failed], reason:[json error]";
            }
        }
        C1534f.m8725c(str2);
        return null;
    }

    public void setUuid(String str) {
        C1534f.f6675u = str;
    }

    /* renamed from: a */
    private String m8628a(String str) {
        return str.replaceAll(" ", "");
    }
}
