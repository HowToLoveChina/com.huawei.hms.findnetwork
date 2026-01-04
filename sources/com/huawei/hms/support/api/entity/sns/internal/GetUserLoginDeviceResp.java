package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.List;

/* loaded from: classes8.dex */
public class GetUserLoginDeviceResp implements IMessageEntity {

    @Packed
    private List<DeviceInfo> deviceList;

    public static class DeviceInfo implements IMessageEntity {

        @Packed
        private String brandName;

        @Packed
        private String deviceID1;

        @Packed
        private String deviceID2;

        @Packed
        private Integer deviceIdType1;

        @Packed
        private Integer deviceIdType2;

        @Packed
        private String deviceModel;

        @Packed
        private String deviceName;

        @Packed
        private String deviceType;

        @Packed
        private String loginTime;

        @Packed
        private String logoutTime;

        @Packed
        private String manufactory;

        public String getBrandName() {
            return this.brandName;
        }

        public String getDeviceID1() {
            return this.deviceID1;
        }

        public String getDeviceID2() {
            return this.deviceID2;
        }

        public Integer getDeviceIdType1() {
            return this.deviceIdType1;
        }

        public Integer getDeviceIdType2() {
            return this.deviceIdType2;
        }

        public String getDeviceModel() {
            return this.deviceModel;
        }

        public String getDeviceName() {
            return this.deviceName;
        }

        public String getDeviceType() {
            return this.deviceType;
        }

        public String getLoginTime() {
            return this.loginTime;
        }

        public String getLogoutTime() {
            return this.logoutTime;
        }

        public String getManufactory() {
            return this.manufactory;
        }

        public void setBrandName(String str) {
            this.brandName = str;
        }

        public void setDeviceID1(String str) {
            this.deviceID1 = str;
        }

        public void setDeviceID2(String str) {
            this.deviceID2 = str;
        }

        public void setDeviceIdType1(Integer num) {
            this.deviceIdType1 = num;
        }

        public void setDeviceIdType2(Integer num) {
            this.deviceIdType2 = num;
        }

        public void setDeviceModel(String str) {
            this.deviceModel = str;
        }

        public void setDeviceName(String str) {
            this.deviceName = str;
        }

        public void setDeviceType(String str) {
            this.deviceType = str;
        }

        public void setLoginTime(String str) {
            this.loginTime = str;
        }

        public void setLogoutTime(String str) {
            this.logoutTime = str;
        }

        public void setManufactory(String str) {
            this.manufactory = str;
        }
    }

    public List<DeviceInfo> getDeviceList() {
        return this.deviceList;
    }

    public void setDeviceList(List<DeviceInfo> list) {
        this.deviceList = list;
    }
}
