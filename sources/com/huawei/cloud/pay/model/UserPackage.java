package com.huawei.cloud.pay.model;

import com.huawei.hicloud.base.bean.LastMemberInfo;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToLongFunction;
import p514o9.C11839m;
import p626ry.C12652a;

/* loaded from: classes5.dex */
public class UserPackage extends Response implements Serializable {
    private static final long serialVersionUID = 1;
    private int bmType;
    private BigDecimal deductAmount;
    private CloudSpace effectivePackage;
    private List<CloudSpace> effectivePackages;
    private MemGradeRights expiredGrideRights;
    private CloudSpace expiredPackage;
    private MemGradeRights gradeRights;
    private int isAutoPay;
    private int isConfirmObtainData;
    private LastMemberInfo lastMemberInfo;
    private long serverTime;
    private CloudSpace toBeEffectivePackage;
    private long totalCapacity;
    private long used;
    private int userPayType;
    private int gradeState = -1;
    private int dataOverDueDays = -1;
    public long memberRemainDays = -1;
    public long memberCountDownsVisible = -1;
    private int dataPeriod = -1;

    public static long getSerialVersionUID() {
        return 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$isPackagesAutoPay$0(CloudSpace cloudSpace) {
        return cloudSpace.getIsAutoPay() == 1;
    }

    public long getBaseCapacity() {
        return this.effectivePackage.getBaseCapacity();
    }

    public int getBmType() {
        return this.bmType;
    }

    public int getDataOverDueDays() {
        return this.dataOverDueDays;
    }

    public int getDataPeriod() {
        if (C12652a.m76180b(Integer.valueOf(this.dataPeriod))) {
            return -1;
        }
        return this.dataPeriod;
    }

    public BigDecimal getDeductAmount() {
        return this.deductAmount;
    }

    public CloudSpace getEffectivePackage() {
        return this.effectivePackage;
    }

    public List<CloudSpace> getEffectivePackages() {
        return this.effectivePackages;
    }

    public long getEffectivePackagesEndTime() {
        List<CloudSpace> list = this.effectivePackages;
        if (list != null && !list.isEmpty()) {
            try {
                return this.effectivePackages.stream().mapToLong(new ToLongFunction() { // from class: com.huawei.cloud.pay.model.f
                    @Override // java.util.function.ToLongFunction
                    public final long applyAsLong(Object obj) {
                        return ((CloudSpace) obj).getEndTime();
                    }
                }).max().getAsLong();
            } catch (Exception e10) {
                C11839m.m70687e("UserPackage", "getEffectivePackagesEndTime error : " + e10);
            }
        }
        return 0L;
    }

    public MemGradeRights getExpiredGrideRights() {
        return this.expiredGrideRights;
    }

    public CloudSpace getExpiredPackage() {
        return this.expiredPackage;
    }

    public MemGradeRights getGradeRights() {
        return this.gradeRights;
    }

    public int getGradeState() {
        return this.gradeState;
    }

    public int getIsAutoPay() {
        return this.isAutoPay;
    }

    public int getIsConfirmObtainData() {
        return this.isConfirmObtainData;
    }

    public LastMemberInfo getLastMemberInfo() {
        return this.lastMemberInfo;
    }

    public long getMemberCountDownsVisible() {
        return this.memberCountDownsVisible;
    }

    public long getMemberRemainDays() {
        return this.memberRemainDays;
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public CloudSpace getToBeEffectivePackage() {
        return this.toBeEffectivePackage;
    }

    public long getTotalCapacity() {
        return this.totalCapacity;
    }

    public long getUsed() {
        return this.used;
    }

    public int getUserPayType() {
        return this.userPayType;
    }

    public boolean isPackagesAutoPay() {
        List<CloudSpace> list = this.effectivePackages;
        if (list != null && !list.isEmpty()) {
            try {
                return this.effectivePackages.stream().filter(new Predicate() { // from class: com.huawei.cloud.pay.model.e
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return UserPackage.lambda$isPackagesAutoPay$0((CloudSpace) obj);
                    }
                }).count() > 0;
            } catch (Exception e10) {
                C11839m.m70687e("UserPackage", "getEffectivePackagesEndTime error : " + e10);
            }
        }
        return false;
    }

    public void setBmType(int i10) {
        this.bmType = i10;
    }

    public void setDataOverDueDays(int i10) {
        this.dataOverDueDays = i10;
    }

    public void setDataPeriod(int i10) {
        this.dataPeriod = i10;
    }

    public void setDeductAmount(BigDecimal bigDecimal) {
        this.deductAmount = bigDecimal;
    }

    public void setEffectivePackage(CloudSpace cloudSpace) {
        this.effectivePackage = cloudSpace;
    }

    public void setEffectivePackages(List<CloudSpace> list) {
        this.effectivePackages = list;
    }

    public void setExpiredGrideRights(MemGradeRights memGradeRights) {
        this.expiredGrideRights = memGradeRights;
    }

    public void setExpiredPackage(CloudSpace cloudSpace) {
        this.expiredPackage = cloudSpace;
    }

    public void setGradeRights(MemGradeRights memGradeRights) {
        this.gradeRights = memGradeRights;
    }

    public void setGradeState(int i10) {
        this.gradeState = i10;
    }

    public void setIsAutoPay(int i10) {
        this.isAutoPay = i10;
    }

    public void setIsConfirmObtainData(int i10) {
        this.isConfirmObtainData = i10;
    }

    public void setLastMemberInfo(LastMemberInfo lastMemberInfo) {
        this.lastMemberInfo = lastMemberInfo;
    }

    public void setMemberCountDownsVisible(long j10) {
        this.memberCountDownsVisible = j10;
    }

    public void setMemberRemainDays(long j10) {
        this.memberRemainDays = j10;
    }

    public void setServerTime(long j10) {
        this.serverTime = j10;
    }

    public void setToBeEffectivePackage(CloudSpace cloudSpace) {
        this.toBeEffectivePackage = cloudSpace;
    }

    public void setTotalCapacity(long j10) {
        this.totalCapacity = j10;
    }

    public void setUsed(long j10) {
        this.used = j10;
    }

    public void setUserPayType(int i10) {
        this.userPayType = i10;
    }
}
