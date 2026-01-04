package com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean;

import android.database.Cursor;

/* loaded from: classes2.dex */
public class PmsMetaV3 extends PmsMeta {
    private int flag;
    private int type;
    private long uploadSuccessTime;
    private String hash1 = "";
    private String hash2 = "";
    private String cloud_path = "";
    private String cloud_hash = "";
    private String file_id = "";
    private String assert_id = "";
    private String version_id = "";

    public static PmsMetaV3 getObject(Cursor cursor) {
        PmsMetaV3 pmsMetaV3 = new PmsMetaV3();
        pmsMetaV3.setId(cursor.getInt(0));
        pmsMetaV3.setFilePath(cursor.getString(1));
        pmsMetaV3.setData(cursor.getString(2));
        pmsMetaV3.setName(cursor.getString(3));
        pmsMetaV3.setEncoded(cursor.getInt(4));
        pmsMetaV3.setMode(cursor.getString(5));
        pmsMetaV3.setIsdir(cursor.getInt(6));
        pmsMetaV3.setSize(cursor.getLong(7));
        pmsMetaV3.setModifytime(cursor.getLong(8));
        pmsMetaV3.setStatus(cursor.getInt(9));
        pmsMetaV3.setIsvalid(cursor.getInt(10));
        pmsMetaV3.setType(cursor.getInt(11));
        pmsMetaV3.setHash1(cursor.getString(12));
        pmsMetaV3.setHash2(cursor.getString(13));
        pmsMetaV3.setCloudPath(cursor.getString(14));
        pmsMetaV3.setCloudHash(cursor.getString(15));
        pmsMetaV3.setFileId(cursor.getString(16));
        pmsMetaV3.setAssertId(cursor.getString(17));
        pmsMetaV3.setVersionId(cursor.getString(18));
        pmsMetaV3.setFlag(cursor.getInt(19));
        pmsMetaV3.setUploadSuccessTime(cursor.getLong(20));
        pmsMetaV3.setData1(cursor.getString(21));
        pmsMetaV3.setData2(cursor.getString(22));
        pmsMetaV3.setData3(cursor.getString(23));
        pmsMetaV3.setData4(cursor.getString(24));
        pmsMetaV3.setData5(cursor.getString(25));
        pmsMetaV3.setData6(cursor.getString(26));
        return pmsMetaV3;
    }

    public String getAssertId() {
        String str = this.assert_id;
        return str == null ? "" : str;
    }

    public String getCloudHash() {
        String str = this.cloud_hash;
        return str == null ? "" : str;
    }

    public String getCloudPath() {
        String str = this.cloud_path;
        return str == null ? "" : str;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMeta
    public String[] getColumns() {
        return new String[]{String.valueOf(getId()), getFilePath(), getData(), getName(), String.valueOf(getEncoded()), getMode(), String.valueOf(getIsdir()), String.valueOf(getSize()), String.valueOf(getModifytime()), String.valueOf(getStatus()), String.valueOf(getIsvalid()), String.valueOf(getType()), getHash1(), getHash2(), getCloudPath(), getCloudHash(), getFileId(), getAssertId(), getVersionId(), String.valueOf(getFlag()), String.valueOf(getUploadSuccessTime()), getData1(), getData2(), getData3(), getData4(), getData5(), getData6()};
    }

    public String getFileId() {
        String str = this.file_id;
        return str == null ? "" : str;
    }

    public int getFlag() {
        return this.flag;
    }

    public String getHash1() {
        String str = this.hash1;
        return str == null ? "" : str;
    }

    public String getHash2() {
        String str = this.hash2;
        return str == null ? "" : str;
    }

    public int getType() {
        return this.type;
    }

    public long getUploadSuccessTime() {
        return this.uploadSuccessTime;
    }

    public String getVersionId() {
        String str = this.version_id;
        return str == null ? "" : str;
    }

    public void setAssertId(String str) {
        this.assert_id = str;
    }

    public void setCloudHash(String str) {
        this.cloud_hash = str;
    }

    public void setCloudPath(String str) {
        this.cloud_path = str;
    }

    public void setFileId(String str) {
        this.file_id = str;
    }

    public void setFlag(int i10) {
        this.flag = i10;
    }

    public void setHash1(String str) {
        this.hash1 = str;
    }

    public void setHash2(String str) {
        this.hash2 = str;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public void setUploadSuccessTime(long j10) {
        this.uploadSuccessTime = j10;
    }

    public void setVersionId(String str) {
        this.version_id = str;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMeta
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.filePath);
        stringBuffer.append(";");
        stringBuffer.append(this.mode);
        stringBuffer.append(";");
        stringBuffer.append(this.isdir);
        stringBuffer.append(";");
        stringBuffer.append(this.size);
        stringBuffer.append(";");
        stringBuffer.append(this.modifytime / 1000);
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }
}
