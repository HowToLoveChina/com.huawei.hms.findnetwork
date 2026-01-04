package com.huawei.android.hicloud.agreement.oobe;

/* loaded from: classes2.dex */
public class ContryGroupConfig {
    private CountryGroupObject[] countryGroupConfig;

    public CountryGroupObject[] getContryGroupConfig() {
        CountryGroupObject[] countryGroupObjectArr = this.countryGroupConfig;
        return countryGroupObjectArr != null ? (CountryGroupObject[]) countryGroupObjectArr.clone() : new CountryGroupObject[0];
    }

    public void setContryGroupConfig(CountryGroupObject[] countryGroupObjectArr) {
        if (countryGroupObjectArr != null) {
            this.countryGroupConfig = (CountryGroupObject[]) countryGroupObjectArr.clone();
        } else {
            this.countryGroupConfig = null;
        }
    }
}
