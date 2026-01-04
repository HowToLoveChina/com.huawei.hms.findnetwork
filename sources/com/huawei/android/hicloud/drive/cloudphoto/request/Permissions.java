package com.huawei.android.hicloud.drive.cloudphoto.request;

import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.android.hicloud.drive.cloudphoto.model.Permission;
import com.huawei.android.hicloud.drive.cloudphoto.model.PermissionCreateRequest;
import com.huawei.android.hicloud.drive.cloudphoto.model.PermissionList;
import com.huawei.android.hicloud.drive.cloudphoto.model.PermissionUpdateRequest;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.Drive;
import java.io.IOException;
import p765x7.C13719a;
import p804ya.AbstractC13930g;

/* loaded from: classes3.dex */
public class Permissions {
    private Drive drive;

    public static class Create extends AbstractC13930g<Permission> {
        private static final String REST_PATH = "cloudPhoto/v1/albums/{albumId}/permissions";

        @InterfaceC4648p
        private String albumId;

        public Create(Drive drive, String str, PermissionCreateRequest permissionCreateRequest) throws IOException {
            super(drive, "POST", REST_PATH, permissionCreateRequest, Permission.class);
            this.albumId = C13719a.m82473a((String) C4627a0.m28392e(str, "Required parameter albumId must be specified."), getHeaders());
            checkRequiredParameter(permissionCreateRequest, "content");
            checkRequiredParameter(permissionCreateRequest.getRole(), "Permission.getRole()");
            checkRequiredParameter(permissionCreateRequest.getType(), "Permission.getType()");
        }

        public String getAlbumId() {
            return this.albumId;
        }

        public Create setAlbumId(String str) {
            this.albumId = C13719a.m82473a(str, getHeaders());
            return this;
        }

        @Override // p804ya.AbstractC13930g
        public Create addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public Create setFields2(String str) {
            return (Create) super.setFields2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setForm */
        public Create setForm2(String str) {
            return (Create) super.setForm2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setPrettyPrint */
        public Create setPrettyPrint2(Boolean bool) {
            return (Create) super.setPrettyPrint2(bool);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setQuotaId */
        public Create setQuotaId2(String str) {
            return (Create) super.setQuotaId2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Create set(String str, Object obj) {
            return (Create) super.set(str, obj);
        }
    }

    public static class Delete extends AbstractC13930g<Void> {
        private static final String REST_PATH = "cloudPhoto/v1/albums/{albumId}/permissions/{permissionId}";

        @InterfaceC4648p
        String albumId;

        @InterfaceC4648p
        String permissionId;

        public Delete(Drive drive, String str, String str2) throws IOException {
            super(drive, "DELETE", REST_PATH, null, Void.class);
            this.albumId = C13719a.m82473a((String) C4627a0.m28392e(str, "Required parameter albumId must be specified."), getHeaders());
            this.permissionId = (String) C4627a0.m28392e(str2, "Required parameter permissionId must be specified.");
        }

        public String getAlbumId() {
            return this.albumId;
        }

        public String getPermissionId() {
            return this.permissionId;
        }

        public Delete setAlbumId(String str) {
            this.albumId = C13719a.m82473a(str, getHeaders());
            return this;
        }

        public Delete setPermissionId(String str) {
            this.permissionId = str;
            return this;
        }

        @Override // p804ya.AbstractC13930g
        public Delete addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }
    }

    public static class Get extends AbstractC13930g<Permission> {
        private static final String REST_PATH = "cloudPhoto/v1/albums/{albumId}/permissions/{permissionId}";

        @InterfaceC4648p
        private String albumId;

        @InterfaceC4648p
        private String permissionId;

        public Get(Drive drive, String str, String str2) throws IOException {
            super(drive, "GET", REST_PATH, null, Permission.class);
            this.albumId = C13719a.m82473a((String) C4627a0.m28392e(str, "Required parameter albumId must be specified."), getHeaders());
            this.permissionId = (String) C4627a0.m28392e(str2, "Required parameter permissionId must be specified.");
        }

        public String getAlbumId() {
            return this.albumId;
        }

        public String getPermissionId() {
            return this.permissionId;
        }

        public Get setAlbumId(String str) {
            this.albumId = C13719a.m82473a(str, getHeaders());
            return this;
        }

        public Get setPermissionId(String str) {
            this.permissionId = str;
            return this;
        }

        @Override // p804ya.AbstractC13930g
        public Get addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public Get setFields2(String str) {
            return (Get) super.setFields2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setForm */
        public Get setForm2(String str) {
            return (Get) super.setForm2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setPrettyPrint */
        public Get setPrettyPrint2(Boolean bool) {
            return (Get) super.setPrettyPrint2(bool);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setQuotaId */
        public Get setQuotaId2(String str) {
            return (Get) super.setQuotaId2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public Get set(String str, Object obj) {
            return (Get) super.set(str, obj);
        }
    }

    public static class List extends AbstractC13930g<PermissionList> {
        private static final String REST_PATH = "cloudPhoto/v1/albums/{albumId}/permissions";

        @InterfaceC4648p
        private String albumId;

        @InterfaceC4648p
        private String cursor;

        @InterfaceC4648p
        private Integer pageSize;

        public List(Drive drive, String str) throws IOException {
            super(drive, "GET", REST_PATH, null, PermissionList.class);
            this.albumId = C13719a.m82473a((String) C4627a0.m28392e(str, "Required parameter albumId must be specified."), getHeaders());
        }

        public String getAlbumId() {
            return this.albumId;
        }

        public String getCursor() {
            return this.cursor;
        }

        public Integer getPageSize() {
            return this.pageSize;
        }

        public List setAlbumId(String str) {
            this.albumId = C13719a.m82473a(str, getHeaders());
            return this;
        }

        public List setCursor(String str) {
            this.cursor = str;
            return this;
        }

        public List setPageSize(Integer num) {
            this.pageSize = num;
            return this;
        }

        @Override // p804ya.AbstractC13930g
        public List addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setFields */
        public List setFields2(String str) {
            return (List) super.setFields2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setForm */
        public List setForm2(String str) {
            return (List) super.setForm2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setPrettyPrint */
        public List setPrettyPrint2(Boolean bool) {
            return (List) super.setPrettyPrint2(bool);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest
        /* renamed from: setQuotaId */
        public List setQuotaId2(String str) {
            return (List) super.setQuotaId2(str);
        }

        @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
        public List set(String str, Object obj) {
            return (List) super.set(str, obj);
        }
    }

    public static class Update extends AbstractC13930g<Permission> {
        private static final String REST_PATH = "cloudPhoto/v1/albums/{albumId}/permissions/{permissionId}";

        @InterfaceC4648p
        String albumId;

        @InterfaceC4648p
        String permissionId;

        public Update(Drive drive, PermissionUpdateRequest permissionUpdateRequest) throws IOException {
            super(drive, RequestMethod.PATCH, REST_PATH, permissionUpdateRequest, Permission.class);
        }

        public String getAlbumId() {
            return this.albumId;
        }

        public String getPermissionId() {
            return this.permissionId;
        }

        public Update setAlbumId(String str) {
            this.albumId = C13719a.m82473a(str, getHeaders());
            return this;
        }

        public Update setPermissionId(String str) {
            this.permissionId = str;
            return this;
        }

        @Override // p804ya.AbstractC13930g
        public Update addHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }
    }

    public Permissions(Drive drive) {
        this.drive = drive;
    }

    public Create create(String str, PermissionCreateRequest permissionCreateRequest) throws IOException {
        return new Create(this.drive, str, permissionCreateRequest);
    }

    public Delete delete(String str, String str2) throws IOException {
        return new Delete(this.drive, str, str2);
    }

    public Get get(String str, String str2) throws IOException {
        return new Get(this.drive, str, str2);
    }

    public List list(String str) throws IOException {
        return new List(this.drive, str);
    }

    public Update update(PermissionUpdateRequest permissionUpdateRequest) throws IOException {
        return new Update(this.drive, permissionUpdateRequest);
    }
}
