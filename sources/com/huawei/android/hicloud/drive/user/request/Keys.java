package com.huawei.android.hicloud.drive.user.request;

import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import com.huawei.hicloud.base.drive.user.model.PublicKey;
import java.io.IOException;
import p012ab.AbstractC0088c;

/* loaded from: classes3.dex */
public class Keys {
    private Drive drive;

    public Keys(Drive drive) {
        this.drive = drive;
    }

    public GetPublicKey getPublicKey() throws IOException {
        return new GetPublicKey(this.drive);
    }

    public List list() throws IOException {
        return new List(this.drive);
    }

    public static class GetPublicKey extends AbstractC0088c<PublicKey> {
        private static final String REST_PATH = "HiCloudUserInformationService/v1/keys/publicKey";

        @InterfaceC4648p
        private String tempKeyEncType;

        public GetPublicKey(Drive drive) throws IOException {
            super(drive, "GET", REST_PATH, null, PublicKey.class);
        }

        public String getTempKeyEncType() {
            return this.tempKeyEncType;
        }

        public void setTempKeyEncType(String str) {
            this.tempKeyEncType = str;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public GetPublicKey set(String str, Object obj) {
            return (GetPublicKey) super.set(str, obj);
        }
    }

    public static class List extends AbstractC0088c<com.huawei.hicloud.base.drive.user.model.Keys> {
        private static final String REST_PATH = "HiCloudUserInformationService/v1/keys";

        @InterfaceC4648p
        private String aad;

        @InterfaceC4648p
        private Integer clientTrustMode;

        @InterfaceC4648p
        private Integer dataType;

        @InterfaceC4648p
        private String keyEncType;

        @InterfaceC4648p
        private String keyVersion;

        @InterfaceC4648p
        private Integer taVersion;

        @InterfaceC4648p
        private String tcisid;

        @InterfaceC4648p
        private String tempKey;

        @InterfaceC4648p
        private String tempKeyEncType;

        public List(Drive drive) throws IOException {
            super(drive, "GET", REST_PATH, null, com.huawei.hicloud.base.drive.user.model.Keys.class);
        }

        public String getAad() {
            return this.aad;
        }

        public Integer getClientTrustMode() {
            return this.clientTrustMode;
        }

        public Integer getDataType() {
            return this.dataType;
        }

        public String getKeyEncType() {
            return this.keyEncType;
        }

        public String getKeyVersion() {
            return this.keyVersion;
        }

        public Integer getTaVersion() {
            return this.taVersion;
        }

        public String getTcisId() {
            return this.tcisid;
        }

        public String getTempKey() {
            return this.tempKey;
        }

        public String getTempKeyEncType() {
            return this.tempKeyEncType;
        }

        public void setAad(String str) {
            this.aad = str;
        }

        public void setClientTrustMode(Integer num) {
            this.clientTrustMode = num;
        }

        public void setDataType(Integer num) {
            this.dataType = num;
        }

        public void setKeyEncType(String str) {
            this.keyEncType = str;
        }

        public void setKeyVersion(String str) {
            this.keyVersion = str;
        }

        public void setTaVersion(Integer num) {
            this.taVersion = num;
        }

        public void setTcisId(String str) {
            this.tcisid = str;
        }

        public void setTempKey(String str) {
            this.tempKey = str;
        }

        public void setTempKeyEncType(String str) {
            this.tempKeyEncType = str;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public List set(String str, Object obj) {
            return (List) super.set(str, obj);
        }
    }
}
