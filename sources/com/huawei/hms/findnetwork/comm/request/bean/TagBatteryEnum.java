package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public enum TagBatteryEnum {
    BATTERY_FULL(4, 100, "Full"),
    BATTERY_MEDIUM(3, 70, "Medium"),
    BATTERY_LOW(2, 30, "Low"),
    BATTERY_CRITICALLY(1, 10, "Critically low"),
    BATTERY_ILLEGAL(0, 0, "Illegal");

    private String batteryDescription;
    private int batteryLevel;
    private int num;

    TagBatteryEnum(int i10, int i11, String str) {
        this.num = i10;
        this.batteryLevel = i11;
        this.batteryDescription = str;
    }

    public static String getTagBatteryDescription(int i10) {
        TagBatteryEnum tagBatteryEnum = BATTERY_FULL;
        if (tagBatteryEnum.batteryLevel == i10) {
            return tagBatteryEnum.batteryDescription;
        }
        TagBatteryEnum tagBatteryEnum2 = BATTERY_MEDIUM;
        if (tagBatteryEnum2.batteryLevel == i10) {
            return tagBatteryEnum2.batteryDescription;
        }
        TagBatteryEnum tagBatteryEnum3 = BATTERY_LOW;
        if (tagBatteryEnum3.batteryLevel == i10) {
            return tagBatteryEnum3.batteryDescription;
        }
        TagBatteryEnum tagBatteryEnum4 = BATTERY_CRITICALLY;
        return tagBatteryEnum4.batteryLevel == i10 ? tagBatteryEnum4.batteryDescription : BATTERY_ILLEGAL.batteryDescription;
    }

    public static TagBatteryEnum getTagBatteryEnum(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? BATTERY_ILLEGAL : BATTERY_CRITICALLY : BATTERY_LOW : BATTERY_MEDIUM : BATTERY_FULL;
    }

    public static int getTagBatteryLevel(String str) {
        TagBatteryEnum tagBatteryEnum = BATTERY_FULL;
        if (tagBatteryEnum.batteryDescription.equals(str)) {
            return tagBatteryEnum.batteryLevel;
        }
        TagBatteryEnum tagBatteryEnum2 = BATTERY_MEDIUM;
        if (tagBatteryEnum2.batteryDescription.equals(str)) {
            return tagBatteryEnum2.batteryLevel;
        }
        TagBatteryEnum tagBatteryEnum3 = BATTERY_LOW;
        if (tagBatteryEnum3.batteryDescription.equals(str)) {
            return tagBatteryEnum3.batteryLevel;
        }
        TagBatteryEnum tagBatteryEnum4 = BATTERY_CRITICALLY;
        return tagBatteryEnum4.batteryDescription.equals(str) ? tagBatteryEnum4.batteryLevel : BATTERY_ILLEGAL.batteryLevel;
    }

    public static int getTagBatteryMaxLevel() {
        return BATTERY_FULL.num;
    }

    public String getBatteryDescription() {
        return this.batteryDescription;
    }

    public int getBatteryLevel() {
        return this.batteryLevel;
    }

    public int getNum() {
        return this.num;
    }
}
