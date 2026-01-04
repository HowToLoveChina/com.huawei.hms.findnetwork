package com.huawei.android.hicloud.p081cs.bean;

import java.io.File;

/* loaded from: classes3.dex */
public class Thumbnail {
    private File file;
    private String name;

    public Thumbnail(String str, File file) {
        this.name = str;
        this.file = file;
    }

    public File getFile() {
        return this.file;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "Thumbnail{name='" + this.name + "', file=" + this.file + '}';
    }
}
