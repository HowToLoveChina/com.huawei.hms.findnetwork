package com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean;

import android.database.Cursor;

/* loaded from: classes2.dex */
public class PmsMetaStatus {
    public static final int STATUS_BATCH_BACKUP_SUCCESS_STATUS_UPDATED = 3;
    public static final int STATUS_DEFAULT_CREATE_FULL_BRIEF = 1;
    public static final int STATUS_DEFAULT_WAIT_PMS_CALL = 0;
    public static final int STATUS_PMS_BACKUP_BRIEF_FILE_GENERATED = 4;
    public static final int STATUS_PMS_DATA_PROCESS_DONE = 5;
    public static final int STATUS_TXT_INFO_VAILD = 2;
    private String data1 = "";
    private String data2 = "";
    private String data3 = "";
    private String data4 = "";
    private String data5 = "";
    private String data6 = "";
    private long modifytime;
    private int status;

    public static PmsMetaStatus getObject(Cursor cursor) {
        PmsMetaStatus pmsMetaStatus = new PmsMetaStatus();
        pmsMetaStatus.setStatus(cursor.getInt(0));
        pmsMetaStatus.setModifytime(cursor.getLong(1));
        pmsMetaStatus.setData1(cursor.getString(2));
        pmsMetaStatus.setData2(cursor.getString(3));
        pmsMetaStatus.setData3(cursor.getString(4));
        pmsMetaStatus.setData4(cursor.getString(5));
        pmsMetaStatus.setData5(cursor.getString(6));
        pmsMetaStatus.setData6(cursor.getString(7));
        return pmsMetaStatus;
    }

    public String[] getColumns() {
        return new String[]{String.valueOf(getStatus()), String.valueOf(getModifytime()), getData1(), getData2(), getData3(), getData4(), getData5(), getData6()};
    }

    public String getData1() {
        return this.data1;
    }

    public String getData2() {
        return this.data2;
    }

    public String getData3() {
        return this.data3;
    }

    public String getData4() {
        return this.data4;
    }

    public String getData5() {
        return this.data5;
    }

    public String getData6() {
        return this.data6;
    }

    public long getModifytime() {
        return this.modifytime;
    }

    public int getStatus() {
        return this.status;
    }

    public void setData1(String str) {
        this.data1 = str;
    }

    public void setData2(String str) {
        this.data2 = str;
    }

    public void setData3(String str) {
        this.data3 = str;
    }

    public void setData4(String str) {
        this.data4 = str;
    }

    public void setData5(String str) {
        this.data5 = str;
    }

    public void setData6(String str) {
        this.data6 = str;
    }

    public void setModifytime(long j10) {
        this.modifytime = j10;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }
}
