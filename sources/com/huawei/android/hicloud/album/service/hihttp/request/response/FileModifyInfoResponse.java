package com.huawei.android.hicloud.album.service.hihttp.request.response;

import com.huawei.android.hicloud.album.service.p075vo.SimplifyInfo;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class FileModifyInfoResponse extends BaseResponse {
    private String cursor;
    private ArrayList<SimplifyInfo> fileList;
    private int total;

    public String getCursor() {
        return this.cursor;
    }

    public ArrayList<SimplifyInfo> getFileList() {
        return this.fileList;
    }

    public int getTotal() {
        return this.total;
    }

    public void setCursor(String str) {
        this.cursor = str;
    }

    public void setFileList(ArrayList<SimplifyInfo> arrayList) {
        this.fileList = arrayList;
    }

    public void setTotal(int i10) {
        this.total = i10;
    }

    public String toString() {
        return "FileModifyInfoResponse{fileList=" + this.fileList + ", cursor='" + this.cursor + "', total=" + this.total + '}';
    }
}
