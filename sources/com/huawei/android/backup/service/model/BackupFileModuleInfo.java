package com.huawei.android.backup.service.model;

import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.InfoXmlUtils;
import java.util.Map;
import p006a5.AbstractC0048c;

/* loaded from: classes.dex */
public class BackupFileModuleInfo {
    private String checkMsgV3;
    private String encMsgV3;
    private String name;
    private int recordTotal;
    private int sdkSupport;
    private String tables;
    private int type;

    public BackupFileModuleInfo() {
    }

    private String getModuleName(String str) {
        for (Map.Entry<String, String> entry : BackupConstant.m13131e().entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public String getCheckMsgV3() {
        return this.checkMsgV3;
    }

    public String getClassName() {
        return BackupFileModuleInfo.class.getSimpleName();
    }

    public String getEncMsgV3() {
        return this.encMsgV3;
    }

    public String getName() {
        return this.name;
    }

    public int getRecordTotal() {
        return this.recordTotal;
    }

    public String getTables() {
        return this.tables;
    }

    public int getType() {
        return this.type;
    }

    public boolean hasRecord() {
        return this.recordTotal >= 1;
    }

    public boolean isLowVersion() {
        return this.sdkSupport < 14;
    }

    public void resetRecordTotal() {
        this.recordTotal = 1;
    }

    public void setCheckMsgV3(String str) {
        this.checkMsgV3 = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRecordTotal(int i10) {
        this.recordTotal = i10;
    }

    public void setSdkSupport(int i10) {
        this.sdkSupport = i10;
    }

    public void setTables(String str) {
        this.tables = str;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public void updateModuleInfo(int i10, int i11, String str) {
        this.recordTotal = i10;
        this.sdkSupport = i11;
        this.tables = str;
    }

    public void updateMsgV3(String str, String str2) {
        this.checkMsgV3 = str;
        this.encMsgV3 = str2;
    }

    public int writeInfo(AbstractC0048c abstractC0048c) {
        if (abstractC0048c == null) {
            return 2;
        }
        return InfoXmlUtils.m13162j(abstractC0048c, BackupFileModuleInfo.class, this);
    }

    public BackupFileModuleInfo(Class<?> cls) {
        if (cls == null) {
            return;
        }
        this.name = getModuleName(cls.getName());
        this.recordTotal = 0;
    }

    public BackupFileModuleInfo(String str) {
        this.name = str;
        this.recordTotal = 0;
    }
}
