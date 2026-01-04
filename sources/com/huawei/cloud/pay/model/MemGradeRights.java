package com.huawei.cloud.pay.model;

import android.text.TextUtils;
import com.google.gson.Gson;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* loaded from: classes5.dex */
public class MemGradeRights extends MemGrade implements Serializable {
    private static final long serialVersionUID = -2336907900532689257L;
    private long beginTime;
    private Long capacity;
    private int defaultFlag;
    private int gradeType;
    private List<MemGradeRight> rights;
    private int showSeq;

    public static /* synthetic */ boolean lambda$getRights$0(MemGradeRight memGradeRight) {
        return !TextUtils.equals("WL", memGradeRight.getRightCode());
    }

    public long getBeginTime() {
        return this.beginTime;
    }

    public Long getCapacity() {
        return this.capacity;
    }

    public int getDefaultFlag() {
        return this.defaultFlag;
    }

    public int getGradeType() {
        return this.gradeType;
    }

    public List<MemGradeRight> getRights() {
        List<MemGradeRight> list = this.rights;
        return list == null ? new ArrayList(0) : (List) list.stream().filter(new Predicate() { // from class: com.huawei.cloud.pay.model.c
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return MemGradeRights.lambda$getRights$0((MemGradeRight) obj);
            }
        }).collect(Collectors.toList());
    }

    public int getShowSeq() {
        return this.showSeq;
    }

    public void setBeginTime(long j10) {
        this.beginTime = j10;
    }

    public void setCapacity(Long l10) {
        this.capacity = l10;
    }

    public void setDefaultFlag(int i10) {
        this.defaultFlag = i10;
    }

    public void setGradeType(int i10) {
        this.gradeType = i10;
    }

    public void setRights(List<MemGradeRight> list) {
        this.rights = list;
    }

    public void setShowSeq(int i10) {
        this.showSeq = i10;
    }

    @Override // com.huawei.cloud.pay.model.MemGrade
    public String toString() {
        return new Gson().toJson(this);
    }
}
