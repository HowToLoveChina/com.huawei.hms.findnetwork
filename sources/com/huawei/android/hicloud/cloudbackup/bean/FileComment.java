package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class FileComment {
    List<String> paths;
    String pic;

    public List<String> getPaths() {
        List<String> list = this.paths;
        return list == null ? new ArrayList() : list;
    }

    public String getPic() {
        String str = this.pic;
        return str == null ? "" : str;
    }

    public void setPaths(List<String> list) {
        this.paths = list;
    }

    public void setPic(String str) {
        this.pic = str;
    }
}
