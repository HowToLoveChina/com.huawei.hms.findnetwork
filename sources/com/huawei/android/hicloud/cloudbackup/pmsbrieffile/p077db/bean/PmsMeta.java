package com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean;

import android.database.Cursor;

/* loaded from: classes2.dex */
public class PmsMeta {
    public static final int ATTR_DIR = 1;
    public static final int ATTR_FILE = 0;
    public static final int ISVALID_CHANGED = 1;
    public static final int ISVALID_DEFAULT = 0;
    public static final int ISVALID_NOT_EXIST = 2;
    public static final int STATUS_COPY_DONE = 1;
    public static final int STATUS_DEFAULT = 0;
    public static final int STATUS_LAST_ALREADY_EXIST = 2;
    public static final int STATUS_LAST_ALREADY_EXIST_MID = -2;
    public static final int STATUS_UPLOAD_SUCCESS = 3;
    public static final int STATUS_UPLOAD_SUCCESS_MID = -3;
    public static final String UPLOAD_DELETE_FLAG_DEFAULT = "0";
    public static final String UPLOAD_DELETE_FLAG_SUCCESS = "1";
    protected String data;
    private int encoded;
    protected String filePath;

    /* renamed from: id */
    protected int f11677id;
    protected int isdir;
    protected String mode;
    protected long modifytime;
    protected String name;
    protected long size;
    protected int status = 0;
    protected int isvalid = 0;
    protected String data1 = "";
    protected String data2 = "";
    protected String data3 = "";
    protected String data4 = "";
    protected String data5 = "";
    protected String data6 = "";

    public static PmsMeta getObject(Cursor cursor) {
        PmsMeta pmsMeta = new PmsMeta();
        pmsMeta.setId(cursor.getInt(0));
        pmsMeta.setFilePath(cursor.getString(1));
        pmsMeta.setData(cursor.getString(2));
        pmsMeta.setName(cursor.getString(3));
        pmsMeta.setEncoded(cursor.getInt(4));
        pmsMeta.setMode(cursor.getString(5));
        pmsMeta.setIsdir(cursor.getInt(6));
        pmsMeta.setSize(cursor.getLong(7));
        pmsMeta.setModifytime(cursor.getLong(8));
        pmsMeta.setStatus(cursor.getInt(9));
        pmsMeta.setIsvalid(cursor.getInt(10));
        pmsMeta.setData1(cursor.getString(11));
        pmsMeta.setData2(cursor.getString(12));
        pmsMeta.setData3(cursor.getString(13));
        pmsMeta.setData4(cursor.getString(14));
        pmsMeta.setData5(cursor.getString(15));
        pmsMeta.setData6(cursor.getString(16));
        return pmsMeta;
    }

    public String[] getColumns() {
        return new String[]{String.valueOf(getId()), getFilePath(), getData(), getName(), String.valueOf(getEncoded()), getMode(), String.valueOf(getIsdir()), String.valueOf(getSize()), String.valueOf(getModifytime()), String.valueOf(getStatus()), String.valueOf(getIsvalid()), getData1(), getData2(), getData3(), getData4(), getData5(), getData6()};
    }

    public String getData() {
        return this.data;
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

    public int getEncoded() {
        return this.encoded;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getId() {
        return this.f11677id;
    }

    public int getIsdir() {
        return this.isdir;
    }

    public int getIsvalid() {
        return this.isvalid;
    }

    public String getMode() {
        return this.mode;
    }

    public long getModifytime() {
        return this.modifytime;
    }

    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    public int getStatus() {
        return this.status;
    }

    public void setData(String str) {
        this.data = str;
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

    public void setEncoded(int i10) {
        this.encoded = i10;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setId(int i10) {
        this.f11677id = i10;
    }

    public void setIsdir(int i10) {
        this.isdir = i10;
    }

    public void setIsvalid(int i10) {
        this.isvalid = i10;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public void setModifytime(long j10) {
        this.modifytime = j10;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSize(long j10) {
        this.size = j10;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

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
        return stringBuffer.toString();
    }
}
