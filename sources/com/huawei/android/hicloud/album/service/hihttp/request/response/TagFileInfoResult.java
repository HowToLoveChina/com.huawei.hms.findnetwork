package com.huawei.android.hicloud.album.service.hihttp.request.response;

import com.huawei.android.hicloud.album.service.p075vo.SmartFileData;
import java.util.ArrayList;
import java.util.Iterator;
import p031b7.C1120a;

/* loaded from: classes2.dex */
public class TagFileInfoResult extends BaseResponse {
    private static final String TAG = "TagFileInfoResult";
    private String cursor;
    private ArrayList<TagFileInfoResponse> tagFileList;

    public String getCursor() {
        return this.cursor;
    }

    public ArrayList<TagFileInfoResponse> getTagFileList() {
        return this.tagFileList;
    }

    public void setCursor(String str) {
        this.cursor = str;
    }

    public void setTagFileList(ArrayList<TagFileInfoResponse> arrayList) {
        this.tagFileList = arrayList;
    }

    public ArrayList<SmartFileData> transToTagFileInfo(ArrayList<TagFileInfoResponse> arrayList) {
        if (arrayList == null) {
            C1120a.m6676e(TAG, "transToTagFileInfo tagFileList is null");
            return null;
        }
        ArrayList<SmartFileData> arrayList2 = new ArrayList<>();
        Iterator<TagFileInfoResponse> it = arrayList.iterator();
        while (it.hasNext()) {
            TagFileInfoResponse next = it.next();
            SmartFileData smartFileData = new SmartFileData();
            smartFileData.setFaceFileId(next.getFaceFileId());
            smartFileData.setCategoryId(next.getCategoryId());
            smartFileData.setAlbumList(next.getAlbumIdList());
            smartFileData.setCreateTime(next.getCreateTime());
            smartFileData.setFaceId(next.getFaceId());
            smartFileData.setFileId(next.getFileId());
            smartFileData.setHash(next.getHash());
            smartFileData.setHeight(next.getHeight());
            smartFileData.setLocalBigThumbPath(next.getLocalBigThumbPath());
            smartFileData.setLocalRealPath(next.getLocalRealPath());
            smartFileData.setLocalThumbPath(next.getLocalThumbPath());
            smartFileData.setCategoryId(next.getCategoryId());
            smartFileData.setNlinks(next.getNlinks());
            smartFileData.setOtype(next.getOtype());
            Attribute attributes = next.getAttributes();
            if (attributes != null) {
                smartFileData.setSpConfidence(attributes.getSpConfidence());
                smartFileData.setOrientation(attributes.getOrientation());
                smartFileData.setTotalFaceNum(attributes.getTotalFaceNum());
            }
            smartFileData.setTagId(next.getTagId());
            smartFileData.setThumbUrl(next.getThumbUrl());
            smartFileData.setVersion(next.getVersion());
            smartFileData.setWidth(next.getWidth());
            smartFileData.setX(next.getX());
            smartFileData.setY(next.getY());
            arrayList2.add(smartFileData);
        }
        return arrayList2;
    }
}
