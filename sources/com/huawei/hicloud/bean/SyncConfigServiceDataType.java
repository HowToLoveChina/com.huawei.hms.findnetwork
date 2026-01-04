package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class SyncConfigServiceDataType implements Serializable {
    private static final long serialVersionUID = -6056785681920567224L;

    @SerializedName("rcycSync")
    private boolean rcycSync;
    private long recycleNum;
    private String serviceId;

    @SerializedName("showNum")
    private boolean showNum;
    private long sumNum;

    @SerializedName("typeId")
    private String typeId;

    @SerializedName("typeName")
    private String typeName;
    private DataTypeNum[] typeNum;

    public long getRecycleNum() {
        return this.recycleNum;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public long getSumNum() {
        return this.sumNum;
    }

    public String getTypeId() {
        return this.typeId;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public DataTypeNum[] getTypeNum() {
        DataTypeNum[] dataTypeNumArr = this.typeNum;
        return dataTypeNumArr != null ? (DataTypeNum[]) dataTypeNumArr.clone() : new DataTypeNum[0];
    }

    public boolean isRcycSync() {
        return this.rcycSync;
    }

    public boolean isShowNum() {
        return this.showNum;
    }

    public void setRcycSync(boolean z10) {
        this.rcycSync = z10;
    }

    public void setRecycleNum(long j10) {
        this.recycleNum = j10;
    }

    public void setServiceId(String str) {
        this.serviceId = str;
    }

    public void setShowNum(boolean z10) {
        this.showNum = z10;
    }

    public void setSumNum(long j10) {
        this.sumNum = j10;
    }

    public void setTypeId(String str) {
        this.typeId = str;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }

    public void setTypeNum(DataTypeNum[] dataTypeNumArr) {
        if (dataTypeNumArr != null) {
            this.typeNum = (DataTypeNum[]) dataTypeNumArr.clone();
        } else {
            this.typeNum = null;
        }
    }
}
