package vc;

import android.content.Context;
import com.huawei.android.hicloud.sync.contact.SyncProcessBase;
import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import java.util.List;
import p514o9.C11839m;
import p572qb.C12308f0;

/* renamed from: vc.a */
/* loaded from: classes3.dex */
public class C13397a extends SyncProcessBase {

    /* renamed from: a */
    public final List<UnstructData> f60409a;

    /* renamed from: b */
    public final String f60410b;

    /* renamed from: c */
    public final String f60411c;

    public C13397a(Context context, String str, String str2, String str3, String str4, String str5, List<UnstructData> list, String str6, String str7) {
        super(context, str, str2, str3, str4, str5);
        this.f60409a = list;
        this.f60410b = str6;
        this.f60411c = str7;
        C11839m.m70688i("AbortDownloadImpl", "AbortDownloadImpl ,type = " + this.mSyncType + ", dataType = " + this.mDataType + ", abortSize = " + list.size() + ", sessionId = " + str6);
    }

    /* renamed from: a */
    public void m80498a() {
        List<UnstructData> list = this.f60409a;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (UnstructData unstructData : this.f60409a) {
            if (unstructData != null) {
                String strM74003c = C12308f0.m74000d().m74003c(this.mSyncType, this.mDataType, unstructData);
                if (C12308f0.m74000d().m74004e(this.mSyncModulePackageName, strM74003c)) {
                    C12308f0.m74000d().m74002b(this.mSyncModulePackageName, strM74003c);
                    C11839m.m70689w("AbortDownloadImpl", "abort task success, taskkey = " + strM74003c);
                } else {
                    C11839m.m70689w("AbortDownloadImpl", "no need abort, fileName = " + unstructData.getName());
                }
            }
        }
    }
}
