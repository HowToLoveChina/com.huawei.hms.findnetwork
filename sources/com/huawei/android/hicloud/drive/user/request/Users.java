package com.huawei.android.hicloud.drive.user.request;

import com.huawei.cloud.services.drive.Drive;
import com.huawei.hicloud.base.drive.user.model.User;
import com.huawei.hicloud.base.drive.user.model.UserList;
import com.huawei.hicloud.base.drive.user.model.UsersListRequest;
import java.io.IOException;
import p012ab.AbstractC0088c;

/* loaded from: classes3.dex */
public class Users {
    private Drive drive;

    public static class List extends AbstractC0088c<UserList> {
        private static final String REST_PATH = "HiCloudUserInformationService/v1/users";

        public List(Drive drive, UsersListRequest usersListRequest) throws IOException {
            super(drive, "POST", REST_PATH, usersListRequest, UserList.class);
        }

        public List setHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }
    }

    public static class UserInfo extends AbstractC0088c<User> {
        private static final String REST_PATH = "HiCloudUserInformationService/v1/users?fields=accountFlag";

        public UserInfo(Drive drive, UsersInfoRequest usersInfoRequest) throws IOException {
            super(drive, "GET", REST_PATH, null, User.class);
        }

        public UserInfo setHeader(String str, Object obj) {
            getHeaders().set(str, obj);
            return this;
        }
    }

    public Users(Drive drive) {
        this.drive = drive;
    }

    public List list(UsersListRequest usersListRequest) throws IOException {
        return new List(this.drive, usersListRequest);
    }

    public UserInfo userInfo(UsersInfoRequest usersInfoRequest) throws IOException {
        return new UserInfo(this.drive, usersInfoRequest);
    }
}
