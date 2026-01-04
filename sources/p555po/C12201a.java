package p555po;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;

/* renamed from: po.a */
/* loaded from: classes6.dex */
public class C12201a {

    /* renamed from: a */
    @SerializedName("backupAction")
    private String f56571a;

    /* renamed from: b */
    @SerializedName(CloudBackupConstant.BACKUP_DEVICE_ID)
    private String f56572b;

    /* renamed from: c */
    @SerializedName("files")
    private JsonArray f56573c;

    /* renamed from: a */
    public void m73352a(String str) {
        this.f56571a = str;
    }

    /* renamed from: b */
    public void m73353b(String str) {
        this.f56572b = str;
    }

    /* renamed from: c */
    public void m73354c(JsonArray jsonArray) {
        this.f56573c = jsonArray;
    }
}
