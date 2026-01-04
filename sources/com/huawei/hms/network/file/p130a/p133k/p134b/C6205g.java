package com.huawei.hms.network.file.p130a.p133k.p134b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.file.api.RequestConfig;
import com.huawei.hms.network.file.core.C6227e;
import com.huawei.hms.network.file.core.task.InterfaceC6234e;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.core.util.Utils;
import com.huawei.hms.network.file.download.api.GetRequest;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.huawei.hms.network.file.a.k.b.g */
/* loaded from: classes8.dex */
public class C6205g extends AbstractC6201c<C6227e<GetRequest>> {
    public C6205g(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    /* renamed from: a */
    public int m36111a(Cursor cursor, GetRequest.Builder builder) {
        Object objM36106a;
        Object objM36106a2;
        Object objM36106a3;
        Object objM36106a4;
        builder.name(cursor.getString(cursor.getColumnIndex("name")));
        builder.fileSize(cursor.getLong(cursor.getColumnIndex("fileSize")));
        byte[] bArrM36085a = m36085a(cursor, "filePath");
        builder.filePath(bArrM36085a != null ? StringUtils.byte2Str(bArrM36085a) : "");
        builder.sha256(cursor.getString(cursor.getColumnIndex("fileSha256")));
        builder.offset(cursor.getLong(cursor.getColumnIndex("startPosition")));
        builder.m36137id(cursor.getLong(cursor.getColumnIndex("requestId")));
        byte[] bArrM36085a2 = m36085a(cursor, "headers");
        if (bArrM36085a2 != null && (objM36106a4 = C6204f.m36106a(bArrM36085a2)) != null) {
            builder.headers((Map) objM36106a4);
        }
        byte[] bArrM36085a3 = m36085a(cursor, "params");
        if (bArrM36085a3 != null && (objM36106a3 = C6204f.m36106a(bArrM36085a3)) != null) {
            builder.params((Map) objM36106a3);
        }
        byte[] bArrM36085a4 = m36085a(cursor, "logInfos");
        if (bArrM36085a4 != null && (objM36106a2 = C6204f.m36106a(bArrM36085a4)) != null) {
            builder.reportInfos((Map) objM36106a2);
        }
        byte[] bArrM36085a5 = m36085a(cursor, "configs");
        if (bArrM36085a5 != null && (objM36106a = C6204f.m36106a(bArrM36085a5)) != null) {
            builder.config((RequestConfig) objM36106a);
        }
        byte[] bArrM36085a6 = m36085a(cursor, "urls");
        if (bArrM36085a6 != null) {
            String strByte2Str = StringUtils.byte2Str(bArrM36085a6);
            if (!Utils.isBlank(strByte2Str)) {
                if (strByte2Str.contains(";")) {
                    String[] strArrSplit = strByte2Str.split(";");
                    if (strArrSplit.length > 0) {
                        builder.url(m36114a(strArrSplit[0]));
                        ArrayList arrayList = new ArrayList();
                        if (strArrSplit.length > 1) {
                            for (int i10 = 1; i10 < strArrSplit.length; i10++) {
                                arrayList.add(m36114a(strArrSplit[i10]));
                            }
                        }
                        builder.backupUrls(arrayList);
                    }
                } else {
                    builder.url(strByte2Str);
                }
            }
        }
        return cursor.getInt(cursor.getColumnIndex("status"));
    }

    @Override // com.huawei.hms.network.file.p130a.p133k.p134b.AbstractC6201c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ContentValues mo36077a(C6227e<GetRequest> c6227e, String str) {
        return a2(c6227e, str);
    }

    /* renamed from: c */
    public List<C6227e<GetRequest>> m36122c(String str) {
        return m36086b("manager=?", new String[]{str});
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public ContentValues a2(C6227e<GetRequest> c6227e, String str) {
        ContentValues contentValues = new ContentValues();
        GetRequest getRequest = (GetRequest) c6227e.m36210a();
        AbstractC6201c.m36076a(contentValues, "filePath", StringUtils.str2Byte(Utils.nullStrToEmpty(getRequest.getFilePath())));
        contentValues.put("fileSha256", Utils.nullStrToEmpty(getRequest.getSha256()));
        contentValues.put("fileSize", Long.valueOf(getRequest.getFileSize()));
        contentValues.put("manager", str);
        contentValues.put("name", Utils.nullStrToEmpty(getRequest.getName()));
        contentValues.put("requestId", Long.valueOf(getRequest.getId()));
        contentValues.put("startPosition", Long.valueOf(getRequest.getOffset()));
        contentValues.put("status", Integer.valueOf(c6227e.m36211b()));
        m36117a(contentValues, "headers", getRequest.getHeaders());
        m36117a(contentValues, "params", getRequest.getParams());
        m36117a(contentValues, "logInfos", getRequest.getReportInfos());
        m36117a(contentValues, "configs", getRequest.getConfig());
        m36118a(contentValues, "urls", getRequest.getUrl(), getRequest.getBackupUrls());
        return contentValues;
    }

    /* renamed from: b */
    public String m36121b(String str) {
        try {
            return URLEncoder.encode(str, Constants.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            FLogger.m36353i("DBDao", "encodeUrlString UnsupportedEncodingException", new Object[0]);
            return str;
        }
    }

    /* renamed from: a */
    public C6227e<GetRequest> m36112a(long j10) {
        return m36089c("requestId=?", new String[]{String.valueOf(j10)});
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.hms.network.file.p130a.p133k.p134b.AbstractC6201c
    /* renamed from: a */
    public C6227e<GetRequest> mo36078a(Cursor cursor) {
        GetRequest.Builder builder = new GetRequest.Builder();
        return new C6227e<>(builder.build(), m36111a(cursor, builder));
    }

    @Override // com.huawei.hms.network.file.p130a.p133k.p134b.AbstractC6201c
    /* renamed from: a */
    public String mo36079a() {
        return "download_request";
    }

    /* renamed from: a */
    public String m36113a(long j10, String str) {
        C6227e<GetRequest> c6227eM36112a = m36112a(j10);
        if (c6227eM36112a == null) {
            return null;
        }
        m36083a("requestId=? and manager=?", new String[]{String.valueOf(j10), str});
        return ((GetRequest) c6227eM36112a.m36210a()).getFilePath();
    }

    /* renamed from: a */
    public String m36114a(String str) {
        if (Utils.isBlank(str)) {
            return str;
        }
        try {
            return URLDecoder.decode(str, Constants.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            FLogger.m36353i("DBDao", "decodeUrlString UnsupportedEncodingException", new Object[0]);
            return str;
        }
    }

    /* renamed from: a */
    public Set<Long> m36115a(String str, int i10) {
        String str2;
        if (i10 >= 0) {
            str2 = "0," + i10;
        } else {
            str2 = null;
        }
        return m36081a("requestId", "manager=?", new String[]{str}, str2);
    }

    /* renamed from: a */
    public void m36116a(long j10, InterfaceC6234e.a aVar, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(aVar.ordinal()));
        m36082a(contentValues, "requestId=? and manager=?", new String[]{String.valueOf(j10), str});
    }

    /* renamed from: a */
    public void m36117a(ContentValues contentValues, String str, Object obj) {
        if (obj != null) {
            AbstractC6201c.m36076a(contentValues, str, C6204f.m36110a(obj));
        }
    }

    /* renamed from: a */
    public void m36118a(ContentValues contentValues, String str, String str2, List<String> list) {
        byte[] bArrStr2Byte;
        if (Utils.isBlank(str2)) {
            bArrStr2Byte = null;
        } else if (Utils.isEmpty(list)) {
            bArrStr2Byte = StringUtils.str2Byte(str2);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            arrayList.addAll(list);
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                if (i10 != 0) {
                    sb2.append(";");
                }
                sb2.append(m36121b((String) arrayList.get(i10)));
            }
            bArrStr2Byte = StringUtils.str2Byte(sb2.toString());
        }
        if (bArrStr2Byte != null) {
            AbstractC6201c.m36076a(contentValues, str, bArrStr2Byte);
        }
    }

    /* renamed from: a */
    public void m36119a(GetRequest getRequest, InterfaceC6234e.a aVar, String str) {
        m36082a(a2(new C6227e<>(getRequest, aVar.ordinal()), str), "requestId=? and manager=?", new String[]{String.valueOf(getRequest.getId()), str});
    }
}
