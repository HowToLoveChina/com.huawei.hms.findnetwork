package vc;

import android.content.Context;
import com.huawei.android.hicloud.sync.bean.DownloadResult;
import com.huawei.android.hicloud.sync.contact.SyncProcessBase;
import com.huawei.android.hicloud.sync.protocol.C2931j;
import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import com.huawei.android.hicloud.sync.syncutil.C2981j;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import je.C10812z;
import p015ak.C0209d;
import p514o9.C11839m;
import p572qb.C12308f0;

/* renamed from: vc.e */
/* loaded from: classes3.dex */
public class C13401e extends SyncProcessBase {

    /* renamed from: a */
    public final List<UnstructData> f60433a;

    /* renamed from: b */
    public final boolean f60434b;

    /* renamed from: c */
    public final boolean f60435c;

    /* renamed from: d */
    public final String f60436d;

    /* renamed from: e */
    public final String f60437e;

    /* renamed from: f */
    public final String f60438f;

    /* renamed from: g */
    public final String f60439g;

    /* renamed from: h */
    public final ArrayList<String> f60440h;

    /* renamed from: i */
    public final Map<String, Integer> f60441i;

    /* renamed from: vc.e$a */
    public class a extends C13404h {

        /* renamed from: c */
        public final /* synthetic */ UnstructData f60442c;

        public a(UnstructData unstructData) {
            this.f60442c = unstructData;
        }

        @Override // vc.C13404h
        /* renamed from: d */
        public boolean mo80533d() {
            if (C13401e.this.f60435c || C0209d.m1225Y(((SyncProcessBase) C13401e.this).mContext) == 1) {
                return true;
            }
            m80591e(true, AuthCode.StatusCode.CERT_FINGERPRINT_ERROR);
            C11839m.m70689w("RequireDownloadFileImpl", "net status not permit, abort");
            return false;
        }

        @Override // vc.C13404h, com.huawei.android.hicloud.connect.progress.ICallback
        public void onProgress(long j10, long j11) {
            if (C13401e.this.f60434b) {
                C2981j.m17892f(((SyncProcessBase) C13401e.this).mContext, ((SyncProcessBase) C13401e.this).mSyncType, ((SyncProcessBase) C13401e.this).mDataType, ((SyncProcessBase) C13401e.this).mSyncModulePackageName, j10, j11, this.f60442c.getUnstructUuid(), this.f60442c, C13401e.this.f60438f);
            }
        }
    }

    public C13401e(Context context, String str, String str2, List<UnstructData> list, boolean z10, boolean z11, String str3, String str4, String str5, String str6, String str7) {
        super(context, str, str2, str4, str5, str6);
        this.f60440h = new ArrayList<>();
        this.f60441i = new HashMap();
        this.f60433a = new ArrayList(list);
        this.f60434b = z10;
        this.f60435c = z11;
        this.f60436d = str3;
        this.f60438f = str7;
        this.f60439g = str5;
        this.f60437e = this.mContext.getFilesDir() + "/sync/" + this.mDataType + "/sync_require_download";
        C11839m.m70686d("RequireDownloadFileImpl", "RequireDownloadFileImpl ,type = " + this.mSyncType + ", dataType = " + this.mDataType + ", downSize = " + list.size() + ", needProgress = " + z10 + ", forceDown = " + z11 + ", sessionId = " + str3);
    }

    /* renamed from: i */
    public void m80532i() throws Throwable {
        String str;
        String str2;
        String str3;
        String str4;
        String string;
        LinkedHashMap linkedHashMap;
        String str5;
        String str6;
        String str7;
        String str8;
        UnstructData next;
        Iterator<UnstructData> it;
        UnstructData unstructData;
        String str9 = "failList";
        String str10 = "sucSize";
        String str11 = "totalSize";
        String str12 = ", failSize = ";
        C11839m.m70688i("RequireDownloadFileImpl", "start require download files, sessionId = " + this.f60436d);
        HashMap map = new HashMap();
        try {
            Iterator<UnstructData> it2 = this.f60433a.iterator();
            while (it2.hasNext()) {
                try {
                    try {
                        next = it2.next();
                        try {
                            it = it2;
                            try {
                                str5 = str9;
                                try {
                                    str6 = str10;
                                } catch (Exception e10) {
                                    e = e10;
                                    str6 = str10;
                                    str7 = str11;
                                    str8 = str12;
                                    unstructData = next;
                                    try {
                                        C11839m.m70687e("RequireDownloadFileImpl", "addTask error " + e.getMessage() + ", id = " + unstructData.getId());
                                        this.f60441i.put(unstructData.getId(), Integer.valueOf(AuthCode.StatusCode.AUTH_INFO_NOT_EXIST));
                                        it2 = it;
                                        str9 = str5;
                                        str10 = str6;
                                        str11 = str7;
                                        str12 = str8;
                                    } catch (Exception e11) {
                                        e = e11;
                                        str = str5;
                                        str3 = str6;
                                        str4 = str7;
                                        str2 = str8;
                                        try {
                                            C11839m.m70687e("RequireDownloadFileImpl", "downloadFile error " + e.getMessage());
                                            C11839m.m70688i("RequireDownloadFileImpl", "require download files end, sucSize = " + this.f60440h.size() + str2 + this.f60441i.size());
                                            C2981j.m17890d(this.mContext, this.mSyncType, this.mDataType, this.mSyncModulePackageName, this.f60440h, this.f60441i, this.f60436d, this.f60438f);
                                            linkedHashMap = new LinkedHashMap(C10812z.m65833b(this.mSyncModulePackageName));
                                            linkedHashMap.put(str4, String.valueOf(this.f60433a.size()));
                                            linkedHashMap.put(str3, String.valueOf(this.f60440h.size()));
                                            string = this.f60441i.toString();
                                            linkedHashMap.put(str, string);
                                            C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, 0, "", "03001", "require_down_complete", this.f60439g, linkedHashMap, false);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            C11839m.m70688i("RequireDownloadFileImpl", "require download files end, sucSize = " + this.f60440h.size() + str2 + this.f60441i.size());
                                            C2981j.m17890d(this.mContext, this.mSyncType, this.mDataType, this.mSyncModulePackageName, this.f60440h, this.f60441i, this.f60436d, this.f60438f);
                                            LinkedHashMap linkedHashMap2 = new LinkedHashMap(C10812z.m65833b(this.mSyncModulePackageName));
                                            linkedHashMap2.put(str4, String.valueOf(this.f60433a.size()));
                                            linkedHashMap2.put(str3, String.valueOf(this.f60440h.size()));
                                            linkedHashMap2.put(str, this.f60441i.toString());
                                            C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, 0, "", "03001", "require_down_complete", this.f60439g, linkedHashMap2, false);
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    str6 = str10;
                                    str7 = str11;
                                    str8 = str12;
                                    str = str5;
                                    str3 = str6;
                                    str4 = str7;
                                    str2 = str8;
                                    C11839m.m70688i("RequireDownloadFileImpl", "require download files end, sucSize = " + this.f60440h.size() + str2 + this.f60441i.size());
                                    C2981j.m17890d(this.mContext, this.mSyncType, this.mDataType, this.mSyncModulePackageName, this.f60440h, this.f60441i, this.f60436d, this.f60438f);
                                    LinkedHashMap linkedHashMap22 = new LinkedHashMap(C10812z.m65833b(this.mSyncModulePackageName));
                                    linkedHashMap22.put(str4, String.valueOf(this.f60433a.size()));
                                    linkedHashMap22.put(str3, String.valueOf(this.f60440h.size()));
                                    linkedHashMap22.put(str, this.f60441i.toString());
                                    C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, 0, "", "03001", "require_down_complete", this.f60439g, linkedHashMap22, false);
                                    throw th;
                                }
                                try {
                                    str7 = str11;
                                    try {
                                        str8 = str12;
                                    } catch (Exception e12) {
                                        e = e12;
                                        str8 = str12;
                                        unstructData = next;
                                        C11839m.m70687e("RequireDownloadFileImpl", "addTask error " + e.getMessage() + ", id = " + unstructData.getId());
                                        this.f60441i.put(unstructData.getId(), Integer.valueOf(AuthCode.StatusCode.AUTH_INFO_NOT_EXIST));
                                        it2 = it;
                                        str9 = str5;
                                        str10 = str6;
                                        str11 = str7;
                                        str12 = str8;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        str8 = str12;
                                        str = str5;
                                        str3 = str6;
                                        str4 = str7;
                                        str2 = str8;
                                        C11839m.m70688i("RequireDownloadFileImpl", "require download files end, sucSize = " + this.f60440h.size() + str2 + this.f60441i.size());
                                        C2981j.m17890d(this.mContext, this.mSyncType, this.mDataType, this.mSyncModulePackageName, this.f60440h, this.f60441i, this.f60436d, this.f60438f);
                                        LinkedHashMap linkedHashMap222 = new LinkedHashMap(C10812z.m65833b(this.mSyncModulePackageName));
                                        linkedHashMap222.put(str4, String.valueOf(this.f60433a.size()));
                                        linkedHashMap222.put(str3, String.valueOf(this.f60440h.size()));
                                        linkedHashMap222.put(str, this.f60441i.toString());
                                        C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, 0, "", "03001", "require_down_complete", this.f60439g, linkedHashMap222, false);
                                        throw th;
                                    }
                                } catch (Exception e13) {
                                    e = e13;
                                    str7 = str11;
                                    str8 = str12;
                                    unstructData = next;
                                    C11839m.m70687e("RequireDownloadFileImpl", "addTask error " + e.getMessage() + ", id = " + unstructData.getId());
                                    this.f60441i.put(unstructData.getId(), Integer.valueOf(AuthCode.StatusCode.AUTH_INFO_NOT_EXIST));
                                    it2 = it;
                                    str9 = str5;
                                    str10 = str6;
                                    str11 = str7;
                                    str12 = str8;
                                } catch (Throwable th5) {
                                    th = th5;
                                    str7 = str11;
                                    str8 = str12;
                                    str = str5;
                                    str3 = str6;
                                    str4 = str7;
                                    str2 = str8;
                                    C11839m.m70688i("RequireDownloadFileImpl", "require download files end, sucSize = " + this.f60440h.size() + str2 + this.f60441i.size());
                                    C2981j.m17890d(this.mContext, this.mSyncType, this.mDataType, this.mSyncModulePackageName, this.f60440h, this.f60441i, this.f60436d, this.f60438f);
                                    LinkedHashMap linkedHashMap2222 = new LinkedHashMap(C10812z.m65833b(this.mSyncModulePackageName));
                                    linkedHashMap2222.put(str4, String.valueOf(this.f60433a.size()));
                                    linkedHashMap2222.put(str3, String.valueOf(this.f60440h.size()));
                                    linkedHashMap2222.put(str, this.f60441i.toString());
                                    C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, 0, "", "03001", "require_down_complete", this.f60439g, linkedHashMap2222, false);
                                    throw th;
                                }
                            } catch (Exception e14) {
                                e = e14;
                                str5 = str9;
                            }
                        } catch (Exception e15) {
                            e = e15;
                            str5 = str9;
                            str6 = str10;
                            str7 = str11;
                            str8 = str12;
                            it = it2;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        str5 = str9;
                    }
                    try {
                        try {
                            unstructData = next;
                        } catch (Exception e16) {
                            e = e16;
                            unstructData = next;
                            C11839m.m70687e("RequireDownloadFileImpl", "addTask error " + e.getMessage() + ", id = " + unstructData.getId());
                            this.f60441i.put(unstructData.getId(), Integer.valueOf(AuthCode.StatusCode.AUTH_INFO_NOT_EXIST));
                            it2 = it;
                            str9 = str5;
                            str10 = str6;
                            str11 = str7;
                            str12 = str8;
                        }
                        try {
                            map.put(unstructData.getId(), C12308f0.m74000d().m74001a(new C2931j(this.mContext, this.mSyncType, this.mDataType, this.mSyncModulePackageName, next.getUnstructUuid(), unstructData, this.f60436d, this.f60438f, this.f60439g, this.f60434b, new a(next))));
                        } catch (Exception e17) {
                            e = e17;
                            C11839m.m70687e("RequireDownloadFileImpl", "addTask error " + e.getMessage() + ", id = " + unstructData.getId());
                            this.f60441i.put(unstructData.getId(), Integer.valueOf(AuthCode.StatusCode.AUTH_INFO_NOT_EXIST));
                            it2 = it;
                            str9 = str5;
                            str10 = str6;
                            str11 = str7;
                            str12 = str8;
                        }
                        it2 = it;
                        str9 = str5;
                        str10 = str6;
                        str11 = str7;
                        str12 = str8;
                    } catch (Throwable th7) {
                        th = th7;
                        str = str5;
                        str3 = str6;
                        str4 = str7;
                        str2 = str8;
                        C11839m.m70688i("RequireDownloadFileImpl", "require download files end, sucSize = " + this.f60440h.size() + str2 + this.f60441i.size());
                        C2981j.m17890d(this.mContext, this.mSyncType, this.mDataType, this.mSyncModulePackageName, this.f60440h, this.f60441i, this.f60436d, this.f60438f);
                        LinkedHashMap linkedHashMap22222 = new LinkedHashMap(C10812z.m65833b(this.mSyncModulePackageName));
                        linkedHashMap22222.put(str4, String.valueOf(this.f60433a.size()));
                        linkedHashMap22222.put(str3, String.valueOf(this.f60440h.size()));
                        linkedHashMap22222.put(str, this.f60441i.toString());
                        C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, 0, "", "03001", "require_down_complete", this.f60439g, linkedHashMap22222, false);
                        throw th;
                    }
                } catch (Exception e18) {
                    e = e18;
                    str5 = str9;
                    str6 = str10;
                    str7 = str11;
                    str8 = str12;
                    str = str5;
                    str3 = str6;
                    str4 = str7;
                    str2 = str8;
                    C11839m.m70687e("RequireDownloadFileImpl", "downloadFile error " + e.getMessage());
                    C11839m.m70688i("RequireDownloadFileImpl", "require download files end, sucSize = " + this.f60440h.size() + str2 + this.f60441i.size());
                    C2981j.m17890d(this.mContext, this.mSyncType, this.mDataType, this.mSyncModulePackageName, this.f60440h, this.f60441i, this.f60436d, this.f60438f);
                    linkedHashMap = new LinkedHashMap(C10812z.m65833b(this.mSyncModulePackageName));
                    linkedHashMap.put(str4, String.valueOf(this.f60433a.size()));
                    linkedHashMap.put(str3, String.valueOf(this.f60440h.size()));
                    string = this.f60441i.toString();
                    linkedHashMap.put(str, string);
                    C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, 0, "", "03001", "require_down_complete", this.f60439g, linkedHashMap, false);
                }
            }
            str5 = str9;
            str6 = str10;
            str7 = str11;
            str8 = str12;
            for (String str13 : map.keySet()) {
                Future future = (Future) map.get(str13);
                if (future == null) {
                    C11839m.m70689w("RequireDownloadFileImpl", "future result is null, id = " + str13);
                    this.f60441i.put(str13, Integer.valueOf(AuthCode.StatusCode.AUTH_INFO_NOT_EXIST));
                } else {
                    try {
                        DownloadResult downloadResult = future.get() == null ? null : (DownloadResult) future.get();
                        if (downloadResult != null) {
                            if (downloadResult.getDownloadState() == 0) {
                                this.f60440h.add(downloadResult.getFileId());
                            } else {
                                this.f60441i.put(downloadResult.getFileId(), Integer.valueOf(downloadResult.getErrorCode()));
                            }
                        }
                    } catch (Exception e19) {
                        if (e19 instanceof CancellationException) {
                            C11839m.m70689w("RequireDownloadFileImpl", "future canceld, id = " + str13);
                            this.f60441i.put(str13, 6000);
                        } else {
                            C11839m.m70689w("RequireDownloadFileImpl", "future result error " + e19.getMessage() + ", id = " + str13);
                            this.f60441i.put(str13, Integer.valueOf(AuthCode.StatusCode.AUTH_INFO_NOT_EXIST));
                        }
                    }
                }
            }
            C11839m.m70688i("RequireDownloadFileImpl", "require download files end, sucSize = " + this.f60440h.size() + str8 + this.f60441i.size());
            C2981j.m17890d(this.mContext, this.mSyncType, this.mDataType, this.mSyncModulePackageName, this.f60440h, this.f60441i, this.f60436d, this.f60438f);
            linkedHashMap = new LinkedHashMap(C10812z.m65833b(this.mSyncModulePackageName));
            linkedHashMap.put(str7, String.valueOf(this.f60433a.size()));
            linkedHashMap.put(str6, String.valueOf(this.f60440h.size()));
            string = this.f60441i.toString();
            str = str5;
        } catch (Exception e20) {
            e = e20;
            String str14 = str12;
            str = str9;
            str2 = str14;
            String str15 = str11;
            str3 = str10;
            str4 = str15;
        } catch (Throwable th8) {
            th = th8;
            String str16 = str12;
            str = str9;
            str2 = str16;
            String str17 = str11;
            str3 = str10;
            str4 = str17;
        }
        linkedHashMap.put(str, string);
        C10812z.m65847p(this.mContext, this.mSyncType, this.mDataType, 0, "", "03001", "require_down_complete", this.f60439g, linkedHashMap, false);
    }
}
