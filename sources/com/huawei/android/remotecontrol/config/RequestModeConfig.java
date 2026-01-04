package com.huawei.android.remotecontrol.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/* loaded from: classes4.dex */
public class RequestModeConfig {
    private static final String CLIENT_MODE_TYPE_BACKEND = "backend";
    private static final String CLIENT_MODE_TYPE_FRONTEND = "frontend";
    public static final String TAG = "RequestModeConfig";
    private static final Map<Integer, String> REQ_MODE_MAP = new HashMap();
    private static final RequestModeConfig INSTANCE = new RequestModeConfig();

    private RequestModeConfig() {
    }

    public static RequestModeConfig getInstance() {
        return INSTANCE;
    }

    public String getMode(Integer num) {
        return (String) Optional.ofNullable(REQ_MODE_MAP.get(num)).orElse(CLIENT_MODE_TYPE_FRONTEND);
    }

    public void setMode(Integer num, boolean z10) {
        REQ_MODE_MAP.put(num, z10 ? CLIENT_MODE_TYPE_FRONTEND : CLIENT_MODE_TYPE_BACKEND);
    }
}
