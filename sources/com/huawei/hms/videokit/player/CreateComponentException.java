package com.huawei.hms.videokit.player;

/* loaded from: classes8.dex */
public class CreateComponentException extends Exception {
    public static final int LOAD_PLUGIN_EXCEPTION = 0;
    public static final int UNINIT_EXCEPTION = 1;

    public CreateComponentException(int i10) {
    }

    public CreateComponentException(int i10, String str) {
        super(str);
    }
}
