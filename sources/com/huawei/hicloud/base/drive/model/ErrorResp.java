package com.huawei.hicloud.base.drive.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes6.dex */
public class ErrorResp extends C11707b {

    @InterfaceC4648p
    private Error error;

    public static class Error extends C11707b {

        @InterfaceC4648p
        private Integer code;

        @InterfaceC4648p
        private String description;

        @InterfaceC4648p
        private ErrorData errorData;

        @InterfaceC4648p
        private List<ErrorMsg> errorDetail;

        public Error() {
        }

        public Integer getCode() {
            return this.code;
        }

        public String getDescription() {
            return this.description;
        }

        public ErrorData getErrorData() {
            return this.errorData;
        }

        public List<ErrorMsg> getErrorDetail() {
            return this.errorDetail;
        }

        public Error setCode(Integer num) {
            this.code = num;
            return this;
        }

        public Error setDescription(String str) {
            this.description = str;
            return this;
        }

        public void setErrorData(ErrorData errorData) {
            this.errorData = errorData;
        }

        public Error setErrorDetail(List<ErrorMsg> list) {
            this.errorDetail = list;
            return this;
        }

        public Error(int i10, String str) {
            this.code = Integer.valueOf(i10);
            this.description = str;
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
        public Error set(String str, Object obj) {
            return (Error) super.set(str, obj);
        }
    }

    public static class ErrorData extends C11707b {

        @InterfaceC4648p
        public String fileId;

        public String getFileId() {
            return this.fileId;
        }

        public void setFileId(String str) {
            this.fileId = str;
        }
    }

    public Error getError() {
        return this.error;
    }

    public ErrorResp setError(Error error) {
        this.error = error;
        return this;
    }

    public static class ErrorMsg extends C11707b {

        @InterfaceC4648p
        private Double delayRequestTime;

        @InterfaceC4648p
        private String description;

        @InterfaceC4648p
        private String domain;

        @InterfaceC4648p
        private String errorCode;

        @InterfaceC4648p
        private String errorParam;

        @InterfaceC4648p
        private String errorPos;

        @InterfaceC4648p
        private String reason;

        public Double getDelayRequestTime() {
            return this.delayRequestTime;
        }

        public String getDescription() {
            return this.description;
        }

        public String getDomain() {
            return this.domain;
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public String getErrorParam() {
            return this.errorParam;
        }

        public String getErrorPos() {
            return this.errorPos;
        }

        public String getReason() {
            return this.reason;
        }

        public void setDelayRequestTime(double d10) {
            this.delayRequestTime = Double.valueOf(d10);
        }

        public ErrorMsg setDescription(String str) {
            this.description = str;
            return this;
        }

        public ErrorMsg setDomain(String str) {
            this.domain = str;
            return this;
        }

        public ErrorMsg setErrorCode(String str) {
            this.errorCode = str;
            return this;
        }

        public ErrorMsg setErrorParam(String str) {
            this.errorParam = str;
            return this;
        }

        public ErrorMsg setErrorPos(String str) {
            this.errorPos = str;
            return this;
        }

        public ErrorMsg setReason(String str) {
            this.reason = str;
            return this;
        }

        @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
        public ErrorMsg set(String str, Object obj) {
            return (ErrorMsg) super.set(str, obj);
        }
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public ErrorResp set(String str, Object obj) {
        return (ErrorResp) super.set(str, obj);
    }
}
