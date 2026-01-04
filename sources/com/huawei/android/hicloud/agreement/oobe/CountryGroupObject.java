package com.huawei.android.hicloud.agreement.oobe;

/* loaded from: classes2.dex */
public class CountryGroupObject {
    private String[] countryList;
    private String groupName;

    public String[] getCountryList() {
        String[] strArr = this.countryList;
        return strArr != null ? (String[]) strArr.clone() : new String[0];
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getGroupNameByCountry(String str) {
        String[] strArr = this.countryList;
        if (strArr == null) {
            return null;
        }
        for (String str2 : strArr) {
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                return this.groupName;
            }
        }
        return null;
    }

    public void setCountryList(String[] strArr) {
        if (strArr != null) {
            this.countryList = (String[]) strArr.clone();
        } else {
            this.countryList = null;
        }
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }
}
