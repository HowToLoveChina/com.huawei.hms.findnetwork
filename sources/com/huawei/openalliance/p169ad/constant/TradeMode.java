package com.huawei.openalliance.p169ad.constant;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public interface TradeMode {
    public static final String PDB = "PDB";

    /* renamed from: PD */
    public static final String f32146PD = "PD";
    public static final String NPD = "NPD";

    /* renamed from: PA */
    public static final String f32145PA = "PA";
    public static final String RTB = "RTB";
    public static final List<String> OPTIONAL_VALUE = Arrays.asList(PDB, f32146PD, NPD, f32145PA, RTB);
    public static final List<String> DEFAULT_VALUE = Arrays.asList(RTB);
}
