package com.huawei.android.hicloud.cloudbackup.process.util;

import p818yp.C14034a;

/* loaded from: classes2.dex */
public class FileCategoryUtil {
    public static final int FILE_CATEGORY_APPLICATION = 6;
    public static final int FILE_CATEGORY_ARCHIVES = 5;
    public static final int FILE_CATEGORY_AUDIO = 2;
    public static final int FILE_CATEGORY_DIRECTORY = 0;
    public static final int FILE_CATEGORY_DOCUMENT = 3;
    public static final int FILE_CATEGORY_IMAGE = 1;
    public static final int FILE_CATEGORY_OTHER = 7;
    public static final int FILE_CATEGORY_VEDIO = 4;

    public static int getFileCategory(int i10) {
        if (C14034a.m84176m(i10)) {
            return 0;
        }
        if (C14034a.m84175l(i10)) {
            return 2;
        }
        if (C14034a.m84179p(i10)) {
            return 4;
        }
        if (C14034a.m84178o(i10)) {
            return 1;
        }
        if (C14034a.m84177n(i10)) {
            return 3;
        }
        if (C14034a.m84174k(i10)) {
            return 5;
        }
        return C14034a.m84173j(i10) ? 6 : 7;
    }
}
