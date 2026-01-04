package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class ReceiveActivityGiftReq extends Request {
    private String activity;
    private ExtendParams extendParams;

    public static class ExtendParams {
        private int userType;

        public int getUserType() {
            return this.userType;
        }

        public void setUserType(int i10) {
            this.userType = i10;
        }
    }

    public interface UserType {
        public static final int NEW_USER = 0;
        public static final int OLD_USER = 1;
    }

    public ReceiveActivityGiftReq(ExtendParams extendParams, String str) {
        super("receiveActivityGift");
        this.extendParams = extendParams;
        this.activity = str;
    }

    public String getActivity() {
        return this.activity;
    }

    public ExtendParams getExtendParams() {
        return this.extendParams;
    }

    public void setActivity(String str) {
        this.activity = str;
    }

    public void setExtendParams(ExtendParams extendParams) {
        this.extendParams = extendParams;
    }
}
