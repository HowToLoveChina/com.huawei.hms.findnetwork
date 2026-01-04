package com.huawei.android.hicloud.hisync.model;

import com.huawei.hms.identity.entity.UserAddress;

/* loaded from: classes3.dex */
public class H5UserAddress {
    private static final String TAG = "H5UserAddress";
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String administrativeArea;
    private String companyName;
    private String countryCode;
    private String countryISOCode;
    private String emailAddress;
    private String locality;
    private String name;
    private String phoneNumber;
    private String postalNumber;

    public H5UserAddress(UserAddress userAddress) {
        this.addressLine1 = userAddress.getAddressLine1();
        this.addressLine2 = userAddress.getAddressLine2();
        this.addressLine3 = userAddress.getAddressLine3();
        this.addressLine4 = userAddress.getAddressLine4();
        this.addressLine5 = userAddress.getAddressLine5();
        this.administrativeArea = userAddress.getAdministrativeArea();
        this.companyName = userAddress.getCompanyName();
        this.countryCode = userAddress.getCountryCode();
        this.countryISOCode = userAddress.getCountryISOCode();
        this.emailAddress = userAddress.getEmailAddress();
        this.locality = userAddress.getLocality();
        this.name = userAddress.getName();
        this.phoneNumber = userAddress.getPhoneNumber();
        this.postalNumber = userAddress.getPostalNumber();
    }

    public String getAddressLine1() {
        return this.addressLine1;
    }

    public String getAddressLine2() {
        return this.addressLine2;
    }

    public String getAddressLine3() {
        return this.addressLine3;
    }

    public String getAddressLine4() {
        return this.addressLine4;
    }

    public String getAddressLine5() {
        return this.addressLine5;
    }

    public String getAdministrativeArea() {
        return this.administrativeArea;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getCountryISOCode() {
        return this.countryISOCode;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getLocality() {
        return this.locality;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getPostalNumber() {
        return this.postalNumber;
    }

    public void setAddressLine1(String str) {
        this.addressLine1 = str;
    }

    public void setAddressLine2(String str) {
        this.addressLine2 = str;
    }

    public void setAddressLine3(String str) {
        this.addressLine3 = str;
    }

    public void setAddressLine4(String str) {
        this.addressLine4 = str;
    }

    public void setAddressLine5(String str) {
        this.addressLine5 = str;
    }

    public void setAdministrativeArea(String str) {
        this.administrativeArea = str;
    }

    public void setCompanyName(String str) {
        this.companyName = str;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setCountryISOCode(String str) {
        this.countryISOCode = str;
    }

    public void setEmailAddress(String str) {
        this.emailAddress = str;
    }

    public void setLocality(String str) {
        this.locality = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public void setPostalNumber(String str) {
        this.postalNumber = str;
    }
}
