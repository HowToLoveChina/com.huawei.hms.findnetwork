package com.huawei.android.hicloud.cloudbackup.process.util;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.About;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p336he.C10155f;
import p429kk.C11058a;
import p514o9.C11839m;
import p618rm.C12590s0;
import p684un.C13225d;
import p709vj.C13452e;
import p711vl.C13466f;
import p814yl.C13998b0;
import p815ym.AbstractC14026a;
import pm.C12176c;
import tl.C13026e;
import tl.C13031j;

/* loaded from: classes2.dex */
public class BackupSwitchBmChanger {
    private static final String TAG = "BackupSwitchBmChanger";
    private List<String> bmModuleWhiteList;
    private String gradeCode;
    private boolean isAlreadyCheckBusinessModelSwitch;
    private boolean isNewBmType;
    private final boolean isRefurbish;
    private String traceId;

    public BackupSwitchBmChanger(boolean z10, boolean z11, String str) {
        this.isRefurbish = z10;
        this.traceId = str;
        init(z11);
    }

    private void checkBusinessModelSwitch() throws C9721b {
        if (isProcessInvalid()) {
            C11839m.m70689w(TAG, "checkBusinessModelSwitch processInvalid");
            return;
        }
        C13026e c13026e = new C13026e(false);
        List<BackupOptionItem> listM78397u = c13026e.m78397u();
        if (AbstractC14026a.m84159a(listM78397u)) {
            C11839m.m70689w(TAG, "checkBusinessModelSwitch allBackupItems isEmpty()");
            return;
        }
        C11839m.m70688i(TAG, "checkBusinessModelSwitch gradeCode: " + this.gradeCode);
        final ArrayList arrayList = new ArrayList();
        if (AbstractC14026a.m84159a(this.bmModuleWhiteList)) {
            C11839m.m70689w(TAG, "bmModuleWhiteList is empty");
        } else {
            if (CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE.equals(this.gradeCode)) {
                List list = (List) listM78397u.stream().filter(new C2629f()).filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.g
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return this.f11745a.lambda$checkBusinessModelSwitch$0((BackupOptionItem) obj);
                    }
                }).collect(Collectors.toList());
                list.forEach(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.h
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        BackupSwitchBmChanger.lambda$checkBusinessModelSwitch$1((BackupOptionItem) obj);
                    }
                });
                arrayList.addAll(list);
            }
            ((List) listM78397u.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.i
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return BackupSwitchBmChanger.lambda$checkBusinessModelSwitch$2((BackupOptionItem) obj);
                }
            }).filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.j
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return this.f11746a.lambda$checkBusinessModelSwitch$3((BackupOptionItem) obj);
                }
            }).collect(Collectors.toList())).forEach(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.k
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    BackupSwitchBmChanger.lambda$checkBusinessModelSwitch$4(arrayList, (BackupOptionItem) obj);
                }
            });
        }
        c13026e.m78383d(arrayList);
        this.isAlreadyCheckBusinessModelSwitch = true;
    }

    private void init(boolean z10) {
        if (this.isRefurbish) {
            return;
        }
        if (z10 && refreshInfoFromServer()) {
            return;
        }
        refreshInfoFromLocal();
    }

    private boolean isProcessInvalid() {
        return this.isRefurbish || !this.isNewBmType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$checkBusinessModelSwitch$0(BackupOptionItem backupOptionItem) {
        return !canModuleBeBackedUp(backupOptionItem.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkBusinessModelSwitch$1(BackupOptionItem backupOptionItem) {
        C11839m.m70688i(TAG, "checkBusinessModelSwitch appId: " + backupOptionItem.getAppId() + " switch close");
        backupOptionItem.setBackupSwitch(false);
        C13225d.m79490f1().m79596t0(backupOptionItem.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$checkBusinessModelSwitch$2(BackupOptionItem backupOptionItem) {
        return !backupOptionItem.getBackupSwitch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$checkBusinessModelSwitch$3(BackupOptionItem backupOptionItem) {
        return this.bmModuleWhiteList.contains(backupOptionItem.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkBusinessModelSwitch$4(List list, BackupOptionItem backupOptionItem) {
        backupOptionItem.setBackupSwitch(true);
        list.add(backupOptionItem);
        C11839m.m70688i(TAG, "checkBusinessModelSwitch appId: " + backupOptionItem.getAppId() + " switch open");
    }

    private void refreshInfoFromLocal() {
        if (TextUtils.isEmpty(this.gradeCode)) {
            this.gradeCode = C13466f.m81073d().m81079g("gradeCode", CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE);
        }
        boolean z10 = C13452e.m80781L().m80887a1() || C12590s0.m75869k1(this.gradeCode);
        this.isNewBmType = z10;
        if (!z10 || !TextUtils.equals(this.gradeCode, CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE)) {
            this.bmModuleWhiteList = null;
        } else if (AbstractC14026a.m84159a(this.bmModuleWhiteList)) {
            this.bmModuleWhiteList = (List) ((List) Optional.ofNullable(new C13031j().m78503d()).orElse(Collections.emptyList())).stream().map(new C2635l()).collect(Collectors.toList());
        }
    }

    private boolean refreshInfoFromServer() {
        if (this.traceId == null) {
            this.traceId = C11058a.m66627b("00000");
        }
        this.isNewBmType = C10155f.m63292p();
        try {
            About aboutM84094A = new C13998b0().m84094A("gradeCode,baseAppid,applistStrategy", this.traceId, "");
            this.gradeCode = C12176c.m73264f(aboutM84094A, this.traceId);
            this.bmModuleWhiteList = C12176c.m73267j(aboutM84094A);
            if (this.isNewBmType && TextUtils.equals(this.gradeCode, CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE)) {
                return true;
            }
            this.bmModuleWhiteList = null;
            return true;
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "refreshInfoFromServer error: " + e10.getMessage());
            return false;
        }
    }

    public boolean canModuleBeBackedUp(String str) {
        boolean z10 = true;
        if (isProcessInvalid()) {
            return true;
        }
        if (!AbstractC14026a.m84159a(this.bmModuleWhiteList) && !this.bmModuleWhiteList.contains(str)) {
            z10 = false;
        }
        if (!z10) {
            C13225d.m79490f1().m79596t0(str);
        }
        return z10;
    }

    public void checkBusinessModelSwitchOnce() {
        if (this.isAlreadyCheckBusinessModelSwitch) {
            C11839m.m70688i(TAG, "already checkBusinessModelSwitch");
            return;
        }
        try {
            checkBusinessModelSwitch();
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "checkBusinessModelSwitch error: " + e10.getMessage());
        }
    }
}
