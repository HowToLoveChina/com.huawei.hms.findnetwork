package com.huawei.hms.location;

import com.huawei.hms.core.aidl.IMessageEntity;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class LocationSceneResponse implements IMessageEntity {
    public static final String KEY_SUPPORT_MAG_POSITION = "MAG_POSITION_IS_SUPPORT";
    public static final int NOT_SUPPORT_MAG_POSITION = 0;
    public static final int SUPPORT_MAG_POSITION = 1;
    private HashMap<String, String> responseMap;
    private int sceneMode;

    public HashMap<String, String> getResponseMap() {
        return this.responseMap;
    }

    public int getSceneMode() {
        return this.sceneMode;
    }

    public void setResponseMap(HashMap<String, String> map) {
        this.responseMap = map;
    }

    public void setSceneMode(int i10) {
        this.sceneMode = i10;
    }
}
