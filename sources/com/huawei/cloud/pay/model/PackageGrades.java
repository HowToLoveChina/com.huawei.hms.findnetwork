package com.huawei.cloud.pay.model;

import android.text.TextUtils;
import com.google.gson.Gson;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* loaded from: classes5.dex */
public class PackageGrades implements Serializable {
    private static final long serialVersionUID = 1;
    private long capacity;
    private String gradeCode;
    private String gradeName;
    private int recommended;
    private List<PackageGradeRight> rights;

    public static /* synthetic */ boolean lambda$getRights$0(PackageGradeRight packageGradeRight) {
        return !TextUtils.equals("WL", packageGradeRight.getRightCode());
    }

    public long getCapacity() {
        return this.capacity;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public String getGradeName() {
        return this.gradeName;
    }

    public int getRecommended() {
        return this.recommended;
    }

    public List<PackageGradeRight> getRights() {
        List<PackageGradeRight> list = this.rights;
        return list == null ? new ArrayList(0) : (List) list.stream().filter(new Predicate() { // from class: com.huawei.cloud.pay.model.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return PackageGrades.lambda$getRights$0((PackageGradeRight) obj);
            }
        }).collect(Collectors.toList());
    }

    public void setCapacity(long j10) {
        this.capacity = j10;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public void setGradeName(String str) {
        this.gradeName = str;
    }

    public void setRecommended(int i10) {
        this.recommended = i10;
    }

    public void setRights(List<PackageGradeRight> list) {
        this.rights = list;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
