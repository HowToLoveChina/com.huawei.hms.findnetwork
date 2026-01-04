package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes8.dex */
public class CtrlExt implements Serializable {
    public static final int DEF_MAX_DELAY_CLICK_TIME = 2000;
    public static final int DEF_MIN_DELAY_CLICK_TIME = 0;
    public static final String SMART = "1";
    public static final String UNSMART = "0";
    private static final long serialVersionUID = 30464300;
    private String impSmartCtrl;

    /* renamed from: a */
    public String m40013a() {
        return this.impSmartCtrl;
    }
}
