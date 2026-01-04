package com.huawei.location.gwi.config;

import com.huawei.location.activity.C6738e;
import es.C9544i;
import es.C9545j;
import java.io.File;
import p531or.C11991a;

/* loaded from: classes8.dex */
public class CarGwiSoFileConstant {
    public static final String ALG_NAME = "libCarGwiVdrV3";
    public static final String CAR_GWI_FILE_NAME = "libCarGwiVdrV3.7z";
    public static final long CAR_GWI_SPECIFY_INTERVAL = 86400000;
    public static final String CPU_API_NAME;
    public static final String FILE_PATH = C9545j.m59600a(C11991a.m72145a());
    public static final String GWI_VDR_SO_NAME = "libCarGwiVdrV3.so";
    public static final String SERVICE_TYPE = "CarGwi";
    public static final String SO_PATH;
    public static final String SP_CAR_GWI_FILE_NAME = "sp_libCarGwiSo_filename";
    public static final String SP_CAR_GWI_LAST_SAVE_TIME = "libCarGwi_last_time";
    public static final String SP_CAR_GWI_VERSION_NUM = "libCarGwi_version_num";
    public static final String SUB_TYPE = "libCarGwiVdrV3";
    public static final String UNPRESS_FOLDER_NAME = "libCarGwiVdrV3";

    static {
        String strM59592a = C9544i.m59592a();
        CPU_API_NAME = strM59592a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C9545j.m59600a(C11991a.m72145a()));
        String str = File.separator;
        sb2.append(str);
        sb2.append("libCarGwiVdrV3");
        sb2.append(str);
        sb2.append(strM59592a);
        SO_PATH = C6738e.m38291a(sb2, str, GWI_VDR_SO_NAME);
    }
}
