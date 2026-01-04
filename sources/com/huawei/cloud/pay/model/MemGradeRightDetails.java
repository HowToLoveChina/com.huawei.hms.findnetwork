package com.huawei.cloud.pay.model;

import android.text.TextUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* loaded from: classes5.dex */
public class MemGradeRightDetails {
    private int defaultFlag;
    private String gradeCode;
    private String gradeName;
    private int gradeType;
    private List<MemGradeRightDetail> rights;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getRights$0(MemGradeRightDetail memGradeRightDetail) {
        return !TextUtils.equals("WL", memGradeRightDetail.getRightCode());
    }

    public int getDefaultFlag() {
        return this.defaultFlag;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public String getGradeName() {
        return this.gradeName;
    }

    public int getGradeType() {
        return this.gradeType;
    }

    public List<MemGradeRightDetail> getRights() {
        List<MemGradeRightDetail> list = this.rights;
        return list == null ? new ArrayList(0) : (List) list.stream().filter(new Predicate() { // from class: com.huawei.cloud.pay.model.b
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MemGradeRightDetails.lambda$getRights$0((MemGradeRightDetail) obj);
            }
        }).collect(Collectors.toList());
    }

    public void setDefaultFlag(int i10) {
        this.defaultFlag = i10;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public void setGradeName(String str) {
        this.gradeName = str;
    }

    public void setGradeType(int i10) {
        this.gradeType = i10;
    }

    public void setRights(List<MemGradeRightDetail> list) {
        this.rights = list;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
