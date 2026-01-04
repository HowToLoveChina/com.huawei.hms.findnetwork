package com.huawei.cloud.pay.model;

import java.util.List;

/* loaded from: classes5.dex */
public class CardPackageResp extends Response {
    private CardPackage cardPackage;
    private List<PackageGrades> packageGrades;

    public CardPackage getCardPackage() {
        return this.cardPackage;
    }

    public List<PackageGrades> getPackageGrades() {
        return this.packageGrades;
    }

    public void setCardPackage(CardPackage cardPackage) {
        this.cardPackage = cardPackage;
    }

    public void setPackageGrades(List<PackageGrades> list) {
        this.packageGrades = list;
    }
}
