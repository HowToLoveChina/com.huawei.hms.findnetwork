package com.huawei.location.base.activity;

import com.huawei.location.base.activity.constant.MovementConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class ActivityRecognitionConstantsMapping {
    private static final int UN_VALID_VAL = -1;
    private static Map<Integer, String> activityTypeMap = new HashMap(10);
    private static Map<String, Integer> activityTypeOppositeMap = new HashMap(10);
    private static Map<Integer, Integer> transitionTypeMap = new HashMap(2);
    private static Map<Integer, Integer> transitionTypeOppositeMap = new HashMap(2);

    static {
        transitionTypeMap.put(0, 1);
        transitionTypeMap.put(1, 2);
        transitionTypeOppositeMap.put(1, 0);
        transitionTypeOppositeMap.put(2, 1);
        activityTypeMap.put(0, MovementConstants.MSDP_MOVEMENT_IN_VEHICLE);
        activityTypeMap.put(1, MovementConstants.MSDP_MOVEMENT_ON_BICYCLE);
        activityTypeMap.put(2, MovementConstants.MSDP_MOVEMENT_ON_FOOT);
        activityTypeMap.put(3, MovementConstants.MSDP_MOVEMENT_STILL);
        activityTypeMap.put(4, "android.activity_recognition.unknown");
        activityTypeMap.put(7, MovementConstants.MSDP_MOVEMENT_WALKING);
        activityTypeMap.put(8, MovementConstants.MSDP_MOVEMENT_RUNNING);
        activityTypeMap.put(10, MovementConstants.MSDP_MOVEMENT_ELEVATOR);
        activityTypeMap.put(9, MovementConstants.MSDP_MOVEMENT_FAST_WALKING);
        activityTypeOppositeMap.put(MovementConstants.MSDP_MOVEMENT_IN_VEHICLE, 0);
        activityTypeOppositeMap.put(MovementConstants.MSDP_MOVEMENT_ON_BICYCLE, 1);
        activityTypeOppositeMap.put(MovementConstants.MSDP_MOVEMENT_ON_FOOT, 2);
        activityTypeOppositeMap.put(MovementConstants.MSDP_MOVEMENT_STILL, 3);
        activityTypeOppositeMap.put("android.activity_recognition.unknown", 4);
        activityTypeOppositeMap.put(MovementConstants.MSDP_MOVEMENT_WALKING, 7);
        activityTypeOppositeMap.put(MovementConstants.MSDP_MOVEMENT_RUNNING, 8);
        activityTypeOppositeMap.put(MovementConstants.MSDP_MOVEMENT_ELEVATOR, 10);
        activityTypeOppositeMap.put(MovementConstants.MSDP_MOVEMENT_FAST_WALKING, 9);
    }

    public static String getActivityType(Integer num) {
        String str;
        return (num == null || (str = activityTypeMap.get(num)) == null) ? "" : str;
    }

    public static Map<Integer, String> getActivityTypeMap() {
        return activityTypeMap;
    }

    public static Integer getActivityTypeOpposite(String str) {
        Integer num;
        if (str == null || "".equals(str) || (num = activityTypeOppositeMap.get(str)) == null) {
            return -1;
        }
        return num;
    }

    public static Map<String, Integer> getActivityTypeOppositeMap() {
        return activityTypeOppositeMap;
    }

    public static Integer getTransitionType(Integer num) {
        Integer num2;
        if (num == null || (num2 = transitionTypeMap.get(num)) == null) {
            return -1;
        }
        return num2;
    }

    public static Map<Integer, Integer> getTransitionTypeMap() {
        return transitionTypeMap;
    }

    public static Integer getTransitionTypeOpposite(Integer num) {
        Integer num2;
        if (num == null || (num2 = transitionTypeOppositeMap.get(num)) == null) {
            return -1;
        }
        return num2;
    }

    public static Map<Integer, Integer> getTransitionTypeOppositeMap() {
        return transitionTypeOppositeMap;
    }

    public static void setActivityTypeOppositeMap(Map<String, Integer> map) {
        activityTypeOppositeMap = map;
    }

    public static void setTransitionTypeOppositeMap(Map<Integer, Integer> map) {
        transitionTypeOppositeMap = map;
    }
}
