package com.huawei.hicloud.router.data;

import java.io.Serializable;

/* loaded from: classes.dex */
public class SmallPictureInfo implements Serializable {
    private static final long serialVersionUID = 9028729318383211952L;
    private int rotationId;
    private String smallPicPath;

    public int getRotationId() {
        return this.rotationId;
    }

    public String getSmallPicPath() {
        return this.smallPicPath;
    }

    public void setRotationId(int i10) {
        this.rotationId = i10;
    }

    public void setSmallPicPath(String str) {
        this.smallPicPath = str;
    }
}
