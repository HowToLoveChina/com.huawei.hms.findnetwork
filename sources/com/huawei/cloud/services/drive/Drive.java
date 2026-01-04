package com.huawei.cloud.services.drive;

import android.content.Context;
import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.cloud.base.http.AbstractC4596b;
import com.huawei.cloud.base.http.C4615r;
import com.huawei.cloud.base.http.InterfaceC4614q;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4641i;
import com.huawei.cloud.base.util.C4642j;
import com.huawei.cloud.base.util.C4650r;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.client.grs.GRSRouting;
import com.huawei.cloud.services.drive.model.ChangeList;
import com.huawei.cloud.services.drive.model.Channel;
import com.huawei.cloud.services.drive.model.Comment;
import com.huawei.cloud.services.drive.model.CommentList;
import com.huawei.cloud.services.drive.model.File;
import com.huawei.cloud.services.drive.model.FileList;
import com.huawei.cloud.services.drive.model.HistoryVersion;
import com.huawei.cloud.services.drive.model.HistoryVersionList;
import com.huawei.cloud.services.drive.model.Reply;
import com.huawei.cloud.services.drive.model.ReplyList;
import com.huawei.cloud.services.drive.model.StartCursor;
import com.huawei.hms.drive.C5282f;
import com.huawei.hms.drive.C5289k;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import p340hi.C10209a;
import p523oi.C11903a;
import p579qi.AbstractC12361b;
import p579qi.InterfaceC12362c;
import p614ri.AbstractC12512a;
import p811yi.C13986a;
import p811yi.C13987b;
import p811yi.C13988c;

/* loaded from: classes5.dex */
public class Drive extends AbstractC12512a {
    protected static final String COMMON_SERVICE_PATH = "drive/common/v1/";
    protected static final String DEFAULT_BATCH_PATH = "batch/drive/v3";
    protected static final String DEFAULT_SERVICE_PATH = "drive/v1/";

    public class About {

        public class Get extends DriveRequest<com.huawei.cloud.services.drive.model.About> {
            private static final String REST_PATH = "about";

            public Get() {
                super(Drive.this, "GET", REST_PATH, null, com.huawei.cloud.services.drive.model.About.class);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<com.huawei.cloud.services.drive.model.About> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<com.huawei.cloud.services.drive.model.About> setForm2(String str) {
                return (Get) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<com.huawei.cloud.services.drive.model.About> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<com.huawei.cloud.services.drive.model.About> setQuotaId2(String str) {
                return (Get) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public About() {
        }

        public Get get() throws IOException {
            Get get = new Get();
            Drive.this.initialize(get);
            return get;
        }
    }

    public class Changes {

        public class GetStartCursor extends DriveRequest<StartCursor> {
            private static final String REST_PATH = "changes/getStartCursor";

            public GetStartCursor() {
                super(Drive.this, "GET", REST_PATH, null, StartCursor.class);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<StartCursor> setFields2(String str) {
                return (GetStartCursor) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<StartCursor> setForm2(String str) {
                return (GetStartCursor) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<StartCursor> setPrettyPrint2(Boolean bool) {
                return (GetStartCursor) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<StartCursor> setQuotaId2(String str) {
                return (GetStartCursor) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public GetStartCursor set(String str, Object obj) {
                return (GetStartCursor) super.set(str, obj);
            }
        }

        public class List extends DriveRequest<ChangeList> {
            private static final String REST_PATH = "changes";

            @InterfaceC4648p
            private String containers;

            @InterfaceC4648p
            private String cursor;

            @InterfaceC4648p
            private Boolean includeDeleted;

            @InterfaceC4648p
            private Integer pageSize;

            public List(String str) {
                super(Drive.this, "GET", REST_PATH, null, ChangeList.class);
                this.cursor = (String) C4627a0.m28392e(str, "Required parameter cursor must be specified.");
            }

            public String getContainers() {
                return this.containers;
            }

            public String getCursor() {
                return this.cursor;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public boolean isIncludeDeleted() {
                Boolean bool = this.includeDeleted;
                if (bool == null || bool == C4642j.f21289a) {
                    return true;
                }
                return bool.booleanValue();
            }

            public List setContainers(String str) {
                this.containers = str;
                return this;
            }

            public List setCursor(String str) {
                this.cursor = str;
                return this;
            }

            public List setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<ChangeList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<ChangeList> setForm2(String str) {
                return (List) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<ChangeList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<ChangeList> setQuotaId2(String str) {
                return (List) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public class Subscribe extends DriveRequest<Channel> {
            private static final String REST_PATH = "changes/subscribe";

            @InterfaceC4648p
            private String containers;

            @InterfaceC4648p
            private String cursor;

            @InterfaceC4648p
            private Boolean includeDeleted;

            @InterfaceC4648p
            private Integer pageSize;

            public Subscribe(String str, Channel channel) {
                super(Drive.this, "POST", REST_PATH, channel, Channel.class);
                this.cursor = (String) C4627a0.m28392e(str, "Required parameter cursor must be specified.");
            }

            public String getContainers() {
                return this.containers;
            }

            public String getCursor() {
                return this.cursor;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public boolean isIncludeDeleted() {
                Boolean bool = this.includeDeleted;
                if (bool == null || bool == C4642j.f21289a) {
                    return true;
                }
                return bool.booleanValue();
            }

            public Subscribe setContainers(String str) {
                this.containers = str;
                return this;
            }

            public Subscribe setCursor(String str) {
                this.cursor = str;
                return this;
            }

            public Subscribe setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public Subscribe setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Channel> setFields2(String str) {
                return (Subscribe) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<Channel> setForm2(String str) {
                return (Subscribe) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Channel> setPrettyPrint2(Boolean bool) {
                return (Subscribe) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<Channel> setQuotaId2(String str) {
                return (Subscribe) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Subscribe set(String str, Object obj) {
                return (Subscribe) super.set(str, obj);
            }
        }

        public Changes() {
        }

        public GetStartCursor getStartCursor() throws IOException {
            GetStartCursor getStartCursor = new GetStartCursor();
            Drive.this.initialize(getStartCursor);
            return getStartCursor;
        }

        public List list(String str) throws IOException {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }

        public Subscribe subscribe(String str, Channel channel) throws IOException {
            Subscribe subscribe = new Subscribe(str, channel);
            Drive.this.initialize(subscribe);
            return subscribe;
        }
    }

    public class Channels {

        public class Stop extends DriveRequest<Void> {
            private static final String REST_PATH = "channels/stop";

            public Stop(Channel channel) {
                super(Drive.this, "POST", REST_PATH, channel, Void.class);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Stop) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<Void> setForm2(String str) {
                return (Stop) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Stop) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<Void> setQuotaId2(String str) {
                return (Stop) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Stop set(String str, Object obj) {
                return (Stop) super.set(str, obj);
            }
        }

        public Channels() {
        }

        public Stop stop(Channel channel) throws IOException {
            Stop stop = new Stop(channel);
            Drive.this.initialize(stop);
            return stop;
        }
    }

    public class Comments {

        public class Create extends DriveRequest<Comment> {
            private static final String REST_PATH = "files/{fileId}/comments";

            @InterfaceC4648p
            private String fileId;

            public Create(String str, Comment comment) {
                super(Drive.this, "POST", REST_PATH, comment, Comment.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
                checkRequiredParameter(comment, "content");
                checkRequiredParameter(comment.getDescription(), "Comment.getDescription()");
            }

            public String getFileId() {
                return this.fileId;
            }

            public Create setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Comment> setFields2(String str) {
                return (Create) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<Comment> setForm2(String str) {
                return (Create) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Comment> setPrettyPrint2(Boolean bool) {
                return (Create) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<Comment> setQuotaId2(String str) {
                return (Create) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Create set(String str, Object obj) {
                return (Create) super.set(str, obj);
            }
        }

        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}";

            @InterfaceC4648p
            private String commentId;

            @InterfaceC4648p
            private String fileId;

            public Delete(String str, String str2) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
                this.commentId = (String) C4627a0.m28392e(str2, "Required parameter commentId must be specified.");
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Delete setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<Void> setForm2(String str) {
                return (Delete) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<Void> setQuotaId2(String str) {
                return (Delete) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        public class Get extends DriveRequest<Comment> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}";

            @InterfaceC4648p
            private String commentId;

            @InterfaceC4648p
            private String fileId;

            @InterfaceC4648p
            private Boolean includeDeleted;

            public Get(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, Comment.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
                this.commentId = (String) C4627a0.m28392e(str2, "Required parameter commentId must be specified.");
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public boolean isIncludeDeleted() {
                Boolean bool = this.includeDeleted;
                if (bool == null || bool == C4642j.f21289a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Get setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Get setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Comment> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<Comment> setForm2(String str) {
                return (Get) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Comment> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<Comment> setQuotaId2(String str) {
                return (Get) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public class List extends DriveRequest<CommentList> {
            private static final String REST_PATH = "files/{fileId}/comments";

            @InterfaceC4648p
            private String cursor;

            @InterfaceC4648p
            private String fileId;

            @InterfaceC4648p
            private Boolean includeDeleted;

            @InterfaceC4648p
            private Integer pageSize;

            @InterfaceC4648p
            private String startEditedTime;

            public List(String str) {
                super(Drive.this, "GET", REST_PATH, null, CommentList.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
            }

            public String getCursor() {
                return this.cursor;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public String getStartEditedTime() {
                return this.startEditedTime;
            }

            public boolean isIncludeDeleted() {
                Boolean bool = this.includeDeleted;
                if (bool == null || bool == C4642j.f21289a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public List setCursor(String str) {
                this.cursor = str;
                return this;
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public List setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            public List setStartEditedTime(String str) {
                this.startEditedTime = str;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<CommentList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<CommentList> setForm2(String str) {
                return (List) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<CommentList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<CommentList> setQuotaId2(String str) {
                return (List) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public class Update extends DriveRequest<Comment> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}";

            @InterfaceC4648p
            private String commentId;

            @InterfaceC4648p
            private String fileId;

            public Update(String str, String str2, Comment comment) {
                super(Drive.this, RequestMethod.PATCH, REST_PATH, comment, Comment.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
                this.commentId = (String) C4627a0.m28392e(str2, "Required parameter commentId must be specified.");
                checkRequiredParameter(comment, "content");
                checkRequiredParameter(comment.getDescription(), "Comment.getDescription()");
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Update setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Comment> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<Comment> setForm2(String str) {
                return (Update) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Comment> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<Comment> setQuotaId2(String str) {
                return (Update) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }

        public Comments() {
        }

        public Create create(String str, Comment comment) throws IOException {
            Create create = new Create(str, comment);
            Drive.this.initialize(create);
            return create;
        }

        public Delete delete(String str, String str2) throws IOException {
            Delete delete = new Delete(str, str2);
            Drive.this.initialize(delete);
            return delete;
        }

        public Get get(String str, String str2) throws IOException {
            Get get = new Get(str, str2);
            Drive.this.initialize(get);
            return get;
        }

        public List list(String str) throws IOException {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }

        public Update update(String str, String str2, Comment comment) throws IOException {
            Update update = new Update(str, str2, comment);
            Drive.this.initialize(update);
            return update;
        }
    }

    public class HistoryVersions {

        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/historyVersions/{historyVersionId}";

            @InterfaceC4648p
            private String fileId;

            @InterfaceC4648p
            private String historyVersionId;

            public Delete(String str, String str2) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
                this.historyVersionId = (String) C4627a0.m28392e(str2, "Required parameter historyVersionId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getHistoryVersionId() {
                return this.historyVersionId;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Delete setHistoryVersionId(String str) {
                this.historyVersionId = str;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<Void> setForm2(String str) {
                return (Delete) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<Void> setQuotaId2(String str) {
                return (Delete) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        public class Get extends DriveRequest<HistoryVersion> {
            private static final String REST_PATH = "files/{fileId}/historyVersions/{historyVersionId}";

            @InterfaceC4648p
            private Boolean acknowledgeDownloadRisk;

            @InterfaceC4648p
            private String fileId;

            @InterfaceC4648p
            private String historyVersionId;

            public Get(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, HistoryVersion.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
                this.historyVersionId = (String) C4627a0.m28392e(str2, "Required parameter historyVersionId must be specified.");
            }

            @Override // p579qi.AbstractC12361b
            public C4615r executeContent() throws IOException {
                return super.executeContent();
            }

            @Override // p579qi.AbstractC12361b
            public void executeContentAndDownloadTo(OutputStream outputStream) throws IOException {
                super.executeContentAndDownloadTo(outputStream);
            }

            @Override // p579qi.AbstractC12361b
            public InputStream executeContentAsInputStream() throws IOException {
                return super.executeContentAsInputStream();
            }

            public Boolean getAcknowledgeDownloadRisk() {
                return this.acknowledgeDownloadRisk;
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getHistoryVersionId() {
                return this.historyVersionId;
            }

            public boolean isAcknowledgeDownloadRisk() {
                Boolean bool = this.acknowledgeDownloadRisk;
                if (bool == null || bool == C4642j.f21289a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Get setAcknowledgeDownloadRisk(Boolean bool) {
                this.acknowledgeDownloadRisk = bool;
                return this;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Get setHistoryVersionId(String str) {
                this.historyVersionId = str;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<HistoryVersion> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<HistoryVersion> setForm2(String str) {
                return (Get) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<HistoryVersion> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<HistoryVersion> setQuotaId2(String str) {
                return (Get) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public class List extends DriveRequest<HistoryVersionList> {
            private static final String REST_PATH = "files/{fileId}/historyVersions";

            @InterfaceC4648p
            private String cursor;

            @InterfaceC4648p
            private String fileId;

            @InterfaceC4648p
            private Integer pageSize;

            public List(String str) {
                super(Drive.this, "GET", REST_PATH, null, HistoryVersionList.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
            }

            public String getCursor() {
                return this.cursor;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public List setCursor(String str) {
                this.cursor = str;
                return this;
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<HistoryVersionList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<HistoryVersionList> setForm2(String str) {
                return (List) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<HistoryVersionList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<HistoryVersionList> setQuotaId2(String str) {
                return (List) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public class Update extends DriveRequest<HistoryVersion> {
            private static final String REST_PATH = "files/{fileId}/historyVersions/{historyVersionId}";

            @InterfaceC4648p
            private String fileId;

            @InterfaceC4648p
            private String historyVersionId;

            public Update(String str, String str2, HistoryVersion historyVersion) {
                super(Drive.this, RequestMethod.PATCH, REST_PATH, historyVersion, HistoryVersion.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
                this.historyVersionId = (String) C4627a0.m28392e(str2, "Required parameter revisionId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getHistoryVersionId() {
                return this.historyVersionId;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Update setHistoryVersionId(String str) {
                this.historyVersionId = str;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<HistoryVersion> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<HistoryVersion> setForm2(String str) {
                return (Update) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<HistoryVersion> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<HistoryVersion> setQuotaId2(String str) {
                return (Update) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }

        public HistoryVersions() {
        }

        public Delete delete(String str, String str2) throws IOException {
            Delete delete = new Delete(str, str2);
            Drive.this.initialize(delete);
            return delete;
        }

        public Get get(String str, String str2) throws IOException {
            Get get = new Get(str, str2);
            Drive.this.initialize(get);
            return get;
        }

        public List list(String str) throws IOException {
            List list = new List(str);
            Drive.this.initialize(list);
            return list;
        }

        public Update update(String str, String str2, HistoryVersion historyVersion) throws IOException {
            Update update = new Update(str, str2, historyVersion);
            Drive.this.initialize(update);
            return update;
        }
    }

    public class Replies {

        public class Create extends DriveRequest<Reply> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies";

            @InterfaceC4648p
            private String commentId;

            @InterfaceC4648p
            private String fileId;

            public Create(String str, String str2, Reply reply) {
                super(Drive.this, "POST", REST_PATH, reply, Reply.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
                this.commentId = (String) C4627a0.m28392e(str2, "Required parameter commentId must be specified.");
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Create setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Create setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Reply> setFields2(String str) {
                return (Create) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<Reply> setForm2(String str) {
                return (Create) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Reply> setPrettyPrint2(Boolean bool) {
                return (Create) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<Reply> setQuotaId2(String str) {
                return (Create) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Create set(String str, Object obj) {
                return (Create) super.set(str, obj);
            }
        }

        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies/{replyId}";

            @InterfaceC4648p
            private String commentId;

            @InterfaceC4648p
            private String fileId;

            @InterfaceC4648p
            private String replyId;

            public Delete(String str, String str2, String str3) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
                this.commentId = (String) C4627a0.m28392e(str2, "Required parameter commentId must be specified.");
                this.replyId = (String) C4627a0.m28392e(str3, "Required parameter replyId must be specified.");
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getReplyId() {
                return this.replyId;
            }

            public Delete setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Delete setReplyId(String str) {
                this.replyId = str;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<Void> setForm2(String str) {
                return (Delete) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<Void> setQuotaId2(String str) {
                return (Delete) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        public class Get extends DriveRequest<Reply> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies/{replyId}";

            @InterfaceC4648p
            private String commentId;

            @InterfaceC4648p
            private String fileId;

            @InterfaceC4648p
            private Boolean includeDeleted;

            @InterfaceC4648p
            private String replyId;

            public Get(String str, String str2, String str3) {
                super(Drive.this, "GET", REST_PATH, null, Reply.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
                this.commentId = (String) C4627a0.m28392e(str2, "Required parameter commentId must be specified.");
                this.replyId = (String) C4627a0.m28392e(str3, "Required parameter replyId must be specified.");
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public String getReplyId() {
                return this.replyId;
            }

            public boolean isIncludeDeleted() {
                Boolean bool = this.includeDeleted;
                if (bool == null || bool == C4642j.f21289a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Get setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Get setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public Get setReplyId(String str) {
                this.replyId = str;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Reply> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<Reply> setForm2(String str) {
                return (Get) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Reply> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<Reply> setQuotaId2(String str) {
                return (Get) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public class List extends DriveRequest<ReplyList> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies";

            @InterfaceC4648p
            private String commentId;

            @InterfaceC4648p
            private String cursor;

            @InterfaceC4648p
            private String fileId;

            @InterfaceC4648p
            private Boolean includeDeleted;

            @InterfaceC4648p
            private Integer pageSize;

            public List(String str, String str2) {
                super(Drive.this, "GET", REST_PATH, null, ReplyList.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
                this.commentId = (String) C4627a0.m28392e(str2, "Required parameter commentId must be specified.");
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getCursor() {
                return this.cursor;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Boolean getIncludeDeleted() {
                return this.includeDeleted;
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public boolean isIncludeDeleted() {
                Boolean bool = this.includeDeleted;
                if (bool == null || bool == C4642j.f21289a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public List setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public List setCursor(String str) {
                this.cursor = str;
                return this;
            }

            public List setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public List setIncludeDeleted(Boolean bool) {
                this.includeDeleted = bool;
                return this;
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<ReplyList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<ReplyList> setForm2(String str) {
                return (List) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<ReplyList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<ReplyList> setQuotaId2(String str) {
                return (List) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public class Update extends DriveRequest<Reply> {
            private static final String REST_PATH = "files/{fileId}/comments/{commentId}/replies/{replyId}";

            @InterfaceC4648p
            private String commentId;

            @InterfaceC4648p
            private String fileId;

            @InterfaceC4648p
            private String replyId;

            public Update(String str, String str2, String str3, Reply reply) {
                super(Drive.this, RequestMethod.PATCH, REST_PATH, reply, Reply.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
                this.commentId = (String) C4627a0.m28392e(str2, "Required parameter commentId must be specified.");
                this.replyId = (String) C4627a0.m28392e(str3, "Required parameter replyId must be specified.");
                checkRequiredParameter(reply, "content");
                checkRequiredParameter(reply.getDescription(), "Reply.getContent()");
            }

            public String getCommentId() {
                return this.commentId;
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getReplyId() {
                return this.replyId;
            }

            public Update setCommentId(String str) {
                this.commentId = str;
                return this;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Update setReplyId(String str) {
                this.replyId = str;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Reply> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<Reply> setForm2(String str) {
                return (Update) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Reply> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<Reply> setQuotaId2(String str) {
                return (Update) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }

        public Replies() {
        }

        public Create create(String str, String str2, Reply reply) throws IOException {
            Create create = new Create(str, str2, reply);
            Drive.this.initialize(create);
            return create;
        }

        public Delete delete(String str, String str2, String str3) throws IOException {
            Delete delete = new Delete(str, str2, str3);
            Drive.this.initialize(delete);
            return delete;
        }

        public Get get(String str, String str2, String str3) throws IOException {
            Get get = new Get(str, str2, str3);
            Drive.this.initialize(get);
            return get;
        }

        public List list(String str, String str2) throws IOException {
            List list = new List(str, str2);
            Drive.this.initialize(list);
            return list;
        }

        public Update update(String str, String str2, String str3, Reply reply) throws IOException {
            Update update = new Update(str, str2, str3, reply);
            Drive.this.initialize(update);
            return update;
        }
    }

    public Drive(C10209a c10209a, Context context) {
        this(new Builder(c10209a, context));
    }

    public About about() {
        return new About();
    }

    public Changes changes() {
        return new Changes();
    }

    public Channels channels() {
        return new Channels();
    }

    public Comments comments() {
        return new Comments();
    }

    public Files files() {
        return new Files();
    }

    public HistoryVersions historyVersions() {
        return new HistoryVersions();
    }

    @Override // p579qi.AbstractC12360a
    public void initialize(AbstractC12361b<?> abstractC12361b) throws IOException {
        super.initialize(abstractC12361b);
    }

    public Replies replies() {
        return new Replies();
    }

    public static class Builder extends AbstractC12512a.a {
        private Context context;

        public Builder(C10209a c10209a, Context context) {
            super(new C5289k(context), C11903a.m71435l(), GRSRouting.getDriveURL(context), Drive.DEFAULT_SERVICE_PATH, c10209a);
            C4627a0.m28391d(context);
            C4627a0.m28391d(c10209a);
            C4627a0.m28391d(GRSRouting.getDriveURL(context));
            this.context = context;
            C5282f.m31717a(context, c10209a.m63358h());
            C13986a.m84003a(context);
            C13988c.m84010e(context);
            setBaseRequestInitializer((InterfaceC12362c) new DriveRequestInitializer());
            setBatchPath(Drive.DEFAULT_BATCH_PATH);
        }

        public Builder setAnonymousBody(List<String> list) {
            C4641i.m28436a(list);
            return this;
        }

        public Builder setAnonymousHeaders(List<String> list) {
            C4641i.m28437b(list);
            return this;
        }

        public Builder setLogLevel(int i10) {
            C4650r.m28486i(i10);
            return this;
        }

        public Builder setTimeOutSeconds(int i10) {
            C13987b.m84005b(i10);
            return this;
        }

        @Override // p614ri.AbstractC12512a.a, p579qi.AbstractC12360a.a
        public Drive build() {
            return new Drive(this);
        }

        @Override // p614ri.AbstractC12512a.a, p579qi.AbstractC12360a.a
        public Builder setApplicationName(String str) {
            return (Builder) super.setApplicationName(str);
        }

        @Override // p614ri.AbstractC12512a.a, p579qi.AbstractC12360a.a
        public Builder setBaseRequestInitializer(InterfaceC12362c interfaceC12362c) {
            return (Builder) super.setBaseRequestInitializer(interfaceC12362c);
        }

        @Override // p614ri.AbstractC12512a.a, p579qi.AbstractC12360a.a
        public Builder setHttpRequestInitializer(InterfaceC4614q interfaceC4614q) {
            return (Builder) super.setHttpRequestInitializer(interfaceC4614q);
        }

        @Override // p614ri.AbstractC12512a.a, p579qi.AbstractC12360a.a
        public Builder setIgnoreRequiredParameterVerify(boolean z10) {
            return (Builder) super.setIgnoreRequiredParameterVerify(z10);
        }
    }

    public class Files {

        public class Copy extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}/copy";

            @InterfaceC4648p
            private String fileId;

            public Copy(String str, File file) {
                super(Drive.this, "POST", REST_PATH, file, File.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public Copy setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Copy) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<File> setForm2(String str) {
                return (Copy) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Copy) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<File> setQuotaId2(String str) {
                return (Copy) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Copy set(String str, Object obj) {
                return (Copy) super.set(str, obj);
            }
        }

        public class Create extends DriveRequest<File> {
            private static final String REST_PATH = "files";

            public Create(File file) {
                super(Drive.this, "POST", REST_PATH, file, File.class);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Create) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<File> setForm2(String str) {
                return (Create) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Create) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<File> setQuotaId2(String str) {
                return (Create) super.setQuotaId2(str);
            }

            public Create(File file, AbstractC4596b abstractC4596b) {
                super(Drive.this, "POST", "/upload/" + Drive.this.getServicePath() + REST_PATH, file, File.class);
                initializeMediaUpload(abstractC4596b);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Create set(String str, Object obj) {
                return (Create) super.set(str, obj);
            }
        }

        public class Delete extends DriveRequest<Void> {
            private static final String REST_PATH = "files/{fileId}";

            @InterfaceC4648p
            private String baseCursor;

            @InterfaceC4648p
            private Long baseVersion;

            @InterfaceC4648p
            private String fileId;

            public Delete(String str) {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
            }

            public String getBaseCursor() {
                return this.baseCursor;
            }

            public Long getBaseVersion() {
                return this.baseVersion;
            }

            public String getFileId() {
                return this.fileId;
            }

            public Delete setBaseCursor(String str) {
                this.baseCursor = str;
                return this;
            }

            public Delete setBaseVersion(Long l10) {
                this.baseVersion = l10;
                return this;
            }

            public Delete setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (Delete) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<Void> setForm2(String str) {
                return (Delete) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Delete) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<Void> setQuotaId2(String str) {
                return (Delete) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Delete set(String str, Object obj) {
                return (Delete) super.set(str, obj);
            }
        }

        public class EmptyRecycle extends DriveRequest<Void> {
            private static final String REST_PATH = "files/recycle";

            @InterfaceC4648p
            private String containers;

            public EmptyRecycle() {
                super(Drive.this, "DELETE", REST_PATH, null, Void.class);
            }

            public String getContainers() {
                return this.containers;
            }

            public EmptyRecycle setContainers(String str) {
                this.containers = str;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Void> setFields2(String str) {
                return (EmptyRecycle) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<Void> setForm2(String str) {
                return (EmptyRecycle) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Void> setPrettyPrint2(Boolean bool) {
                return (EmptyRecycle) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<Void> setQuotaId2(String str) {
                return (EmptyRecycle) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public EmptyRecycle set(String str, Object obj) {
                return (EmptyRecycle) super.set(str, obj);
            }
        }

        public class Get extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}";

            @InterfaceC4648p
            private Boolean acknowledgeDownloadRisk;

            @InterfaceC4648p
            private String fileId;

            public Get(String str) {
                super(Drive.this, "GET", REST_PATH, null, File.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
                initializeMediaDownload();
            }

            @Override // p579qi.AbstractC12361b
            public C4615r executeContent() throws IOException {
                return super.executeContent();
            }

            @Override // p579qi.AbstractC12361b
            public void executeContentAndDownloadTo(OutputStream outputStream) throws IOException {
                super.executeContentAndDownloadTo(outputStream);
            }

            @Override // p579qi.AbstractC12361b
            public InputStream executeContentAsInputStream() throws IOException {
                return super.executeContentAsInputStream();
            }

            public Boolean getAcknowledgeDownloadRisk() {
                return this.acknowledgeDownloadRisk;
            }

            public String getFileId() {
                return this.fileId;
            }

            public boolean isAcknowledgeDownloadRisk() {
                Boolean bool = this.acknowledgeDownloadRisk;
                if (bool == null || bool == C4642j.f21289a) {
                    return false;
                }
                return bool.booleanValue();
            }

            public Get setAcknowledgeDownloadRisk(Boolean bool) {
                this.acknowledgeDownloadRisk = bool;
                return this;
            }

            public Get setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Get) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<File> setForm2(String str) {
                return (Get) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Get) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<File> setQuotaId2(String str) {
                return (Get) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Get set(String str, Object obj) {
                return (Get) super.set(str, obj);
            }
        }

        public class List extends DriveRequest<FileList> {
            private static final String REST_PATH = "files";

            @InterfaceC4648p
            private String containers;

            @InterfaceC4648p
            private String cursor;

            @InterfaceC4648p
            private String orderBy;

            @InterfaceC4648p
            private Integer pageSize;

            @InterfaceC4648p
            private String queryParam;

            public List() {
                super(Drive.this, "GET", REST_PATH, null, FileList.class);
            }

            public String getContainers() {
                return this.containers;
            }

            public String getCursor() {
                return this.cursor;
            }

            public String getOrderBy() {
                return this.orderBy;
            }

            public Integer getPageSize() {
                return this.pageSize;
            }

            public String getQueryParam() {
                return this.queryParam;
            }

            public List setContainers(String str) {
                this.containers = str;
                return this;
            }

            public List setCursor(String str) {
                this.cursor = str;
                return this;
            }

            public List setOrderBy(String str) {
                this.orderBy = str;
                return this;
            }

            public List setPageSize(Integer num) {
                this.pageSize = num;
                return this;
            }

            public List setQueryParam(String str) {
                this.queryParam = str;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<FileList> setFields2(String str) {
                return (List) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<FileList> setForm2(String str) {
                return (List) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<FileList> setPrettyPrint2(Boolean bool) {
                return (List) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<FileList> setQuotaId2(String str) {
                return (List) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public List set(String str, Object obj) {
                return (List) super.set(str, obj);
            }
        }

        public class Subscribe extends DriveRequest<Channel> {
            private static final String REST_PATH = "files/{fileId}/subscribe";

            @InterfaceC4648p
            private String fileId;

            public Subscribe(String str, Channel channel) {
                super(Drive.this, "POST", REST_PATH, channel, Channel.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
            }

            public String getFileId() {
                return this.fileId;
            }

            public Subscribe setFileId(String str) {
                this.fileId = str;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<Channel> setFields2(String str) {
                return (Subscribe) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<Channel> setForm2(String str) {
                return (Subscribe) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<Channel> setPrettyPrint2(Boolean bool) {
                return (Subscribe) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<Channel> setQuotaId2(String str) {
                return (Subscribe) super.setQuotaId2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Subscribe set(String str, Object obj) {
                return (Subscribe) super.set(str, obj);
            }
        }

        public class Update extends DriveRequest<File> {
            private static final String REST_PATH = "files/{fileId}";

            @InterfaceC4648p
            private String addParentFolder;

            @InterfaceC4648p
            private String baseCursor;

            @InterfaceC4648p
            private Long baseVersion;

            @InterfaceC4648p
            private String fileId;

            @InterfaceC4648p
            private String removeParentFolder;

            public Update(String str, File file) {
                super(Drive.this, RequestMethod.PATCH, REST_PATH, file, File.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
            }

            public String getAddParentFolder() {
                return this.addParentFolder;
            }

            public String getBaseCursor() {
                return this.baseCursor;
            }

            public Long getBaseVersion() {
                return this.baseVersion;
            }

            public String getFileId() {
                return this.fileId;
            }

            public String getRemoveParentFolder() {
                return this.removeParentFolder;
            }

            public Update setAddParentFolder(String str) {
                this.addParentFolder = str;
                return this;
            }

            public Update setBaseCursor(String str) {
                this.baseCursor = str;
                return this;
            }

            public Update setBaseVersion(Long l10) {
                this.baseVersion = l10;
                return this;
            }

            public Update setFileId(String str) {
                this.fileId = str;
                return this;
            }

            public Update setRemoveParentFolder(String str) {
                this.removeParentFolder = str;
                return this;
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setFields */
            public DriveRequest<File> setFields2(String str) {
                return (Update) super.setFields2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setForm */
            public DriveRequest<File> setForm2(String str) {
                return (Update) super.setForm2(str);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setPrettyPrint */
            public DriveRequest<File> setPrettyPrint2(Boolean bool) {
                return (Update) super.setPrettyPrint2(bool);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest
            /* renamed from: setQuotaId */
            public DriveRequest<File> setQuotaId2(String str) {
                return (Update) super.setQuotaId2(str);
            }

            public Update(String str, File file, AbstractC4596b abstractC4596b) {
                super(Drive.this, RequestMethod.PATCH, "/upload/" + Drive.this.getServicePath() + REST_PATH, file, File.class);
                this.fileId = (String) C4627a0.m28392e(str, "Required parameter fileId must be specified.");
                initializeMediaUpload(abstractC4596b);
            }

            @Override // com.huawei.cloud.services.drive.DriveRequest, p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
            public Update set(String str, Object obj) {
                return (Update) super.set(str, obj);
            }
        }

        public Files() {
        }

        public Copy copy(String str, File file) throws IOException {
            Copy copy = new Copy(str, file);
            Drive.this.initialize(copy);
            return copy;
        }

        public Create create(File file) throws IOException {
            Create create = new Create(file);
            Drive.this.initialize(create);
            return create;
        }

        public Delete delete(String str) throws IOException {
            Delete delete = new Delete(str);
            Drive.this.initialize(delete);
            return delete;
        }

        public EmptyRecycle emptyRecycle() throws IOException {
            EmptyRecycle emptyRecycle = new EmptyRecycle();
            Drive.this.initialize(emptyRecycle);
            return emptyRecycle;
        }

        public Get get(String str) throws IOException {
            Get get = new Get(str);
            Drive.this.initialize(get);
            return get;
        }

        public List list() throws IOException {
            List list = new List();
            Drive.this.initialize(list);
            return list;
        }

        public Subscribe subscribe(String str, Channel channel) throws IOException {
            Subscribe subscribe = new Subscribe(str, channel);
            Drive.this.initialize(subscribe);
            return subscribe;
        }

        public Update update(String str, File file) throws IOException {
            Update update = new Update(str, file);
            Drive.this.initialize(update);
            return update;
        }

        public Create create(File file, AbstractC4596b abstractC4596b) throws IOException {
            Create create = new Create(file, abstractC4596b);
            Drive.this.initialize(create);
            return create;
        }

        public Update update(String str, File file, AbstractC4596b abstractC4596b) throws IOException {
            Update update = new Update(str, file, abstractC4596b);
            Drive.this.initialize(update);
            return update;
        }
    }

    public Drive(Builder builder) {
        super(builder);
    }
}
