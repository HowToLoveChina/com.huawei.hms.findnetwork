package p617rl;

import android.database.Cursor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.cloudbackup.bean.AppVer;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreConfig;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreExclude;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import ml.AbstractC11478a;
import p514o9.C11839m;
import p682ul.C13216j;

/* renamed from: rl.d */
/* loaded from: classes6.dex */
public class C12520d extends AbstractC11478a<RestoreConfig> {

    /* renamed from: rl.d$b */
    public static class b extends TypeToken<List<AppVer>> {
        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* renamed from: rl.d$c */
    public static class c extends TypeToken<List<RestoreExclude>> {
        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* renamed from: rl.d$d */
    public static class d extends TypeToken<List<String>> {
        public d() {
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public C12520d() {
        super(C13216j.m79427l(C13216j.c.SETTING, null));
    }

    @Override // ml.AbstractC11478a
    /* renamed from: a */
    public String[] getColumns(RestoreConfig restoreConfig) {
        Gson gsonCreate = new GsonBuilder().serializeNulls().create();
        return new String[]{restoreConfig.getId(), restoreConfig.getAppId(), gsonCreate.toJson(restoreConfig.getAppVer()), gsonCreate.toJson(restoreConfig.getAppVersRegex()), gsonCreate.toJson(restoreConfig.getExclude()), restoreConfig.getData()};
    }

    @Override // ml.AbstractC11478a
    /* renamed from: b */
    public RestoreConfig getObject(Cursor cursor) {
        RestoreConfig restoreConfig = new RestoreConfig();
        restoreConfig.setId(cursor.getString(0));
        restoreConfig.setAppId(cursor.getString(1));
        Gson gson = new Gson();
        try {
            restoreConfig.setAppVer((List) gson.fromJson(cursor.getString(2), new b().getType()));
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("AppRestoreConfigOperator", "getObject appVer json syntax exception: " + e10.getMessage());
        }
        try {
            restoreConfig.setAppVersRegex((List) gson.fromJson(cursor.getString(3), new d().getType()));
        } catch (JsonSyntaxException e11) {
            C11839m.m70687e("AppRestoreConfigOperator", "getObject appVers json syntax exception: " + e11.getMessage());
        }
        try {
            restoreConfig.setExclude((List) gson.fromJson(cursor.getString(4), new c().getType()));
        } catch (JsonSyntaxException e12) {
            C11839m.m70687e("AppRestoreConfigOperator", "getObject exclude json syntax exception: " + e12.getMessage());
        }
        restoreConfig.setData(cursor.getString(5));
        return restoreConfig;
    }

    /* renamed from: c */
    public List<RestoreConfig> m75310c() {
        try {
            return query("select id, appId, appVer, appVersRegex, exclude, data from cloud_restore_config;", null);
        } catch (C9721b e10) {
            C11839m.m70687e("AppRestoreConfigOperator", "getAppBackupConfig error: " + e10.toString());
            return null;
        }
    }

    public void clear() {
        try {
            execSQL("delete from cloud_restore_config");
        } catch (C9721b e10) {
            C11839m.m70687e("AppRestoreConfigOperator", "execSQL clear error: " + e10.toString());
        }
    }

    /* renamed from: d */
    public void m75311d(List<RestoreConfig> list) throws C9721b {
        if (list == null || list.isEmpty()) {
            C11839m.m70687e("AppRestoreConfigOperator", "updateAppRestoreConfig restoreConfig is null or empty");
            return;
        }
        Gson gsonCreate = new GsonBuilder().serializeNulls().create();
        ArrayList arrayList = new ArrayList();
        for (RestoreConfig restoreConfig : list) {
            arrayList.add(new String[]{restoreConfig.getId(), restoreConfig.getAppId(), gsonCreate.toJson(restoreConfig.getAppVer()), gsonCreate.toJson(restoreConfig.getAppVersRegex()), gsonCreate.toJson(restoreConfig.getExclude()), restoreConfig.getData()});
        }
        try {
            execute("replace into cloud_restore_config(id, appId, appVer, appVersRegex, exclude, data) VALUES(?,?,?,?,?,?);", arrayList);
        } catch (C9721b e10) {
            C11839m.m70687e("AppRestoreConfigOperator", "updateAppRestoreConfig error: " + e10.toString());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "update app restore config exec error. " + e10.getMessage(), "execSQL");
        }
    }
}
