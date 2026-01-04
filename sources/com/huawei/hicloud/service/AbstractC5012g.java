package com.huawei.hicloud.service;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.C1461a;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hicloud.bean.App;
import com.huawei.hicloud.bean.Client;
import com.huawei.hicloud.bean.Config;
import com.huawei.hicloud.bean.Configs;
import com.huawei.hicloud.bean.Device;
import com.huawei.hicloud.bean.ErrorResp;
import com.huawei.hicloud.bean.FileInfo;
import com.huawei.hicloud.bean.GetLatestConfigReq;
import com.huawei.hicloud.bean.GetLatestConfigResp;
import com.huawei.hicloud.bean.GetSingleLatestConfigReq;
import com.huawei.hicloud.bean.GetSingleLatestConfigResp;
import com.huawei.hicloud.bean.GetVersionResp;
import com.huawei.hicloud.bean.Keys;
import com.huawei.hicloud.bean.Snapshot;
import com.huawei.hicloud.download.C4896a;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hwcloudjs.C6618c;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Events;
import fk.C9721b;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0219i;
import p015ak.C0234s;
import p015ak.C0239x;
import p429kk.C11058a;
import p429kk.C11060c;
import p459lp.C11327e;
import p459lp.C11328f;
import p527on.C11976a;
import p618rm.C12540b1;
import p709vj.C13452e;
import p710vk.C13459c;
import p710vk.C13460d;
import tm.C13040c;
import tn.InterfaceC13043a;

/* renamed from: com.huawei.hicloud.service.g */
/* loaded from: classes.dex */
public abstract class AbstractC5012g {
    private static final Gson GSON = new Gson();
    private static final String TAG = "GeneralBaseConfigService";
    private static final String UTF_8 = "UTF-8";
    protected String traceId;

    public AbstractC5012g(String str) {
        this.traceId = str;
    }

    private void clearTestFileIfExist() {
        try {
            File file = new File(getContext().getFilesDir() + "/mytestFile.txt");
            if (file.exists() && file.isFile() && !file.delete()) {
                C1461a.m8360w(TAG, "delete file failed");
            }
        } catch (Exception e10) {
            C1461a.m8358e(TAG, "delete file exception: " + e10.toString());
        }
    }

    public static byte[] doHash(String str) throws C9721b, NoSuchAlgorithmException {
        if (TextUtils.isEmpty(str)) {
            throw new C9721b(5005, "Unable to compute hash because doHash text is null");
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            return messageDigest.digest();
        } catch (Exception e10) {
            throw new C9721b(5005, "Unable to compute hash while signing request" + e10.getMessage());
        }
    }

    private static Context getContext() {
        return C0213f.m1377a();
    }

    private boolean isRetryException(C9721b c9721b) {
        int iM60659c = c9721b.m60659c();
        if (iM60659c == 1199 || iM60659c == 9100 || iM60659c == 5001 || iM60659c == 5002) {
            return true;
        }
        switch (iM60659c) {
            case ConnectionResult.RESOLUTION_REQUIRED /* 9001 */:
            case ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED /* 9002 */:
            case 9003:
            case ConnectionResult.SERVICE_UPDATING /* 9004 */:
            case ConnectionResult.SIGN_IN_FAILED /* 9005 */:
            case C6618c.f30770o /* 9006 */:
            case 9007:
                return true;
            default:
                return false;
        }
    }

    private App prepareApp() {
        App app = new App();
        app.setId("10055832");
        app.setVersion("16.0.0.300");
        app.setUserID(C13452e.m80781L().m80971t0());
        return app;
    }

    private Device prepareDevice() {
        Device device = new Device();
        device.setModel(Build.MODEL);
        device.setEmuiVersion(String.valueOf(C0219i.m1463a()));
        device.setRomVersion(C0209d.m1315v());
        device.setOsVersion(Build.VERSION.RELEASE);
        device.setHomeCountry(getServiceCountry());
        device.setRegisterCountry(C13452e.m80781L().m80942m());
        device.setLang(C0234s.m1627e());
        if (C0209d.m1170F1()) {
            device.setDeviceType("2");
        } else {
            device.setDeviceType("1");
        }
        device.setPlatform("1");
        String strM80970t = C13452e.m80781L().m80970t();
        strM80970t.hashCode();
        if (strM80970t.equals("0")) {
            device.setImei(C13452e.m80781L().m80954p());
        } else if (strM80970t.equals("9")) {
            device.setUdid(C13452e.m80781L().m80954p());
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            device.setDeliveryPlace(null);
            device.setPlmn(null);
            device.setOaid(null);
            device.setSn(null);
            int iM1272k0 = C0209d.m1272k0(contextM1377a);
            int iM1268j0 = C0209d.m1268j0(contextM1377a);
            device.setScreenWidth(iM1272k0);
            device.setScreenHeight(iM1268j0);
            device.setNetwork(C0209d.m1228Z(C0209d.m1225Y(contextM1377a)));
        }
        device.setAndroidApiLevel(Build.VERSION.SDK_INT);
        return device;
    }

    private void processException(String str, String str2, C9721b c9721b) throws C9721b, NumberFormatException {
        C1461a.m8358e(TAG, "processException, Cmd: " + str + " configPoint: " + str2 + " exception: " + c9721b.toString());
        if (c9721b.m60659c() != 9000) {
            if (!isRetryException(c9721b)) {
                throw c9721b;
            }
            C1461a.m8359i(TAG, "error need retry: " + c9721b.toString());
            throw new C9721b(5006, c9721b.getMessage());
        }
        if (c9721b.m60663g() == 429) {
            C1461a.m8359i(TAG, "Too many Requests.");
            throw new C9721b(c9721b.m60663g(), c9721b.getMessage());
        }
        if (c9721b.m60663g() != 400) {
            throw new C9721b(5006, c9721b.m60663g(), c9721b.getMessage());
        }
        try {
            ErrorResp errorResp = (ErrorResp) fromJson(c9721b.getMessage(), ErrorResp.class);
            if (errorResp == null) {
                throw c9721b;
            }
            String code = errorResp.getCode();
            if (TextUtils.isEmpty(code) || code.length() != 8) {
                throw c9721b;
            }
            int i10 = Integer.parseInt(code.substring(code.length() - 4, code.length()));
            if (str.equals("getLatestConfig") && i10 == 8) {
                C11327e.m68071n(str2, C11327e.m68064g(str2));
                C11327e.m68069l(str2, getServiceCountry());
            }
            throw new C9721b(400, i10, errorResp.getMessage());
        } catch (JsonSyntaxException e10) {
            C1461a.m8358e(TAG, "processException err : " + e10.getMessage());
            throw new C9721b(5004, "json exception");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.Closeable] */
    private String readFileToString(File file, String str) throws Throwable {
        Closeable closeable;
        ?? r72;
        Closeable closeable2;
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        Closeable closeable3;
        FileInputStream fileInputStream2 = null;
        string = null;
        String string = null;
        try {
            try {
                fileInputStream = new FileInputStream((File) file);
                try {
                    file = new InputStreamReader(fileInputStream, str);
                    try {
                        bufferedReader = new BufferedReader(file);
                    } catch (FileNotFoundException unused) {
                        bufferedReader = null;
                    } catch (IOException e10) {
                        e = e10;
                        bufferedReader = null;
                        closeable2 = file;
                    } catch (Throwable th2) {
                        th = th2;
                        str = null;
                        fileInputStream2 = fileInputStream;
                        closeable = file;
                        r72 = str;
                        C0209d.m1263i(fileInputStream2);
                        C0209d.m1263i(closeable);
                        C0209d.m1263i(r72);
                        throw th;
                    }
                } catch (FileNotFoundException unused2) {
                    file = 0;
                    bufferedReader = null;
                } catch (IOException e11) {
                    e = e11;
                    closeable2 = null;
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    file = 0;
                    str = null;
                }
            } catch (FileNotFoundException unused3) {
                file = 0;
                bufferedReader = null;
                fileInputStream = null;
            } catch (IOException e12) {
                e = e12;
                closeable2 = null;
                bufferedReader = null;
                fileInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                closeable = null;
                r72 = 0;
                C0209d.m1263i(fileInputStream2);
                C0209d.m1263i(closeable);
                C0209d.m1263i(r72);
                throw th;
            }
            try {
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb2.append(line);
                }
                string = sb2.toString();
                closeable3 = file;
            } catch (FileNotFoundException unused4) {
                C1461a.m8358e(TAG, "local hash file FileNotFoundException");
                closeable3 = file;
                C0209d.m1263i(fileInputStream);
                C0209d.m1263i(closeable3);
                C0209d.m1263i(bufferedReader);
                return string;
            } catch (IOException e13) {
                e = e13;
                closeable2 = file;
                C1461a.m8358e(TAG, "local hash file read IOException: " + e.toString());
                closeable3 = closeable2;
                C0209d.m1263i(fileInputStream);
                C0209d.m1263i(closeable3);
                C0209d.m1263i(bufferedReader);
                return string;
            }
            C0209d.m1263i(fileInputStream);
            C0209d.m1263i(closeable3);
            C0209d.m1263i(bufferedReader);
            return string;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private void reportReqException(C11060c c11060c, String str, C9721b c9721b) {
        c11060c.m66665u(String.valueOf(c9721b.m60659c()));
        HashMap map = new HashMap();
        map.put("config_point", str);
        map.put(TrackConstants$Events.EXCEPTION, c9721b.toString());
        C0239x.m1671c().m1672a(map);
        InterfaceC13043a interfaceC13043aM80810H = C13452e.m80781L().m80810H();
        if (interfaceC13043aM80810H != null) {
            interfaceC13043aM80810H.mo78693d(getContext(), c11060c, map);
        }
    }

    private void reportReqSuccess(C11060c c11060c, String str, String str2) {
        Keys keys = new Keys();
        keys.setKey(str);
        reportReqSuccess(c11060c, new Keys[]{keys}, str2);
    }

    private boolean writeStrToFile(Context context, String str, String str2) throws IOException {
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = context.openFileOutput(str2, 0);
                fileOutputStreamOpenFileOutput.write(str.getBytes("UTF-8"));
                fileOutputStreamOpenFileOutput.flush();
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (IOException unused) {
                    C1461a.m8358e(TAG, "writeStrToFile close error");
                }
                return true;
            } catch (Throwable th2) {
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException unused2) {
                        C1461a.m8358e(TAG, "writeStrToFile close error");
                    }
                }
                throw th2;
            }
        } catch (IOException e10) {
            C1461a.m8358e(TAG, e10.toString());
            if (fileOutputStreamOpenFileOutput == null) {
                return false;
            }
            try {
                fileOutputStreamOpenFileOutput.close();
                return false;
            } catch (IOException unused3) {
                C1461a.m8358e(TAG, "writeStrToFile close error");
                return false;
            }
        }
    }

    public boolean download(FileInfo fileInfo) {
        File file;
        File file2;
        String strM68074b;
        String hash;
        C1461a.m8359i(TAG, "download begin");
        String localTmpPath = getLocalTmpPath();
        C4896a c4896a = new C4896a(fileInfo.getUrl(), localTmpPath, 0L);
        try {
            C11976a.m72086g(c4896a.getUrl(), c4896a, null);
            file = new File(getConfigFilePath());
            file2 = new File(localTmpPath);
            strM68074b = C11328f.m68074b(doHash(readFileToString(file2, "UTF-8")));
            hash = fileInfo.getHash();
        } catch (C9721b e10) {
            C1461a.m8358e(TAG, "download error: " + e10.toString());
        } catch (Exception e11) {
            C1461a.m8358e(TAG, "do file hash error: " + e11.toString());
        }
        if (!TextUtils.isEmpty(strM68074b) && strM68074b.equals(hash)) {
            if (file.exists()) {
                C1461a.m8357d(TAG, "file exists need delete");
                if (!file.delete()) {
                    C1461a.m8360w(TAG, "download delete file is fail");
                }
            }
            if (file2.renameTo(file)) {
                C1461a.m8359i(TAG, "rename successful");
                return true;
            }
            return false;
        }
        C1461a.m8358e(TAG, "file hash error : server file hash is not equals to download file");
        if (!file2.delete()) {
            C1461a.m8359i(TAG, "tmp config file is delete failed");
        }
        return false;
    }

    public boolean downloadOmFile(Configs configs, String str, long j10) {
        Config config = configs.getConfig();
        if (config == null) {
            C1461a.m8358e(TAG, "omConfig is null");
            return false;
        }
        int type = config.getType();
        if (type != 0) {
            if (type != 1 || !writeStrToFile(getContext(), config.getContent(), getFileName())) {
                return false;
            }
            C11327e.m68071n(str, j10);
            C11327e.m68067j(str, config.getEtag());
            C11327e.m68065h(str, System.currentTimeMillis());
            C11327e.m68070m(str, getBuiltInVersion());
            C11327e.m68069l(str, getServiceCountry());
            return true;
        }
        FileInfo file = config.getFile();
        if (file == null) {
            C1461a.m8358e(TAG, "fileInfo is null");
            return false;
        }
        boolean zDownload = download(file);
        if (zDownload) {
            C11327e.m68071n(str, j10);
            C11327e.m68067j(str, config.getEtag());
            C11327e.m68068k(str, file.getHash());
            C11327e.m68065h(str, System.currentTimeMillis());
            C11327e.m68070m(str, getBuiltInVersion());
            C11327e.m68069l(str, getServiceCountry());
        }
        return zDownload;
    }

    public <T> T fromJson(String str, Class<T> cls) throws C9721b {
        try {
            return (T) GSON.fromJson(str, (Class) cls);
        } catch (JsonSyntaxException unused) {
            throw new C9721b(5004, "json err " + str);
        }
    }

    public abstract int getBuiltInVersion();

    public long getCfgVersion(String str) throws C9721b {
        return getCfgVersion(str, getGeneralConfigVersionAddress(), "getChangedCfgListEx");
    }

    public Client getClient() {
        Device devicePrepareDevice = prepareDevice();
        App appPrepareApp = prepareApp();
        Client client = new Client();
        client.setDevice(devicePrepareDevice);
        client.setApp(appPrepareApp);
        clearTestFileIfExist();
        return client;
    }

    public abstract String getConfigFilePath();

    public abstract long getConfigVersion() throws C9721b;

    public abstract String getFileName();

    public abstract String getGeneralConfigVersionAddress() throws C9721b;

    public abstract boolean getLatestConfig() throws C9721b;

    public boolean getLatestConfig(String str) throws C9721b {
        Keys keys = new Keys();
        keys.setKey(str);
        boolean zExists = getConfigFilePath() != null ? new File(getConfigFilePath()).exists() : false;
        if (zExists) {
            keys.setEtag(C11327e.m68061d(str));
        }
        return getLatestConfig(new Keys[]{keys}, zExists);
    }

    public abstract String getLatestConfigAddress() throws C9721b;

    public String getLocalTmpPath() {
        return getConfigFilePath() + ".tmp";
    }

    public long getOldCfgVersion(String str) throws C9721b {
        C1461a.m8357d(TAG, "getOldCfgVersion, configPoint is " + str);
        return getCfgVersion(str, C13040c.m78609F().m78611B() + "/configserver/v1/hicloud/configs/changes?key=" + str, "getChangedCfgList");
    }

    public boolean getOldLatestConfig(String str) throws C9721b, NumberFormatException {
        C1461a.m8359i(TAG, "getOldLatestConfig configPoint " + str);
        if (this.traceId == null) {
            this.traceId = C11058a.m66627b("07010");
        }
        C11060c c11060cM66626a = C11058a.m66626a(this.traceId, "getLatestConfig", C13452e.m80781L().m80971t0());
        try {
            String str2 = C13040c.m78609F().m78611B() + "/configserver/v1/hicloud/configs/" + str;
            C1461a.m8357d(TAG, "getLatestConfig, url is " + str2);
            boolean zExists = getConfigFilePath() != null ? new File(getConfigFilePath()).exists() : false;
            GetSingleLatestConfigReq getSingleLatestConfigReq = new GetSingleLatestConfigReq();
            Client client = getClient();
            getSingleLatestConfigReq.setEtag(C11327e.m68061d(str));
            getSingleLatestConfigReq.setClient(client);
            String str3 = (String) C11976a.m72086g(str2, new C13459c("", getSingleLatestConfigReq.toString(), this.traceId, str, zExists), c11060cM66626a);
            GetSingleLatestConfigResp getSingleLatestConfigResp = (GetSingleLatestConfigResp) fromJson(str3, GetSingleLatestConfigResp.class);
            if (getSingleLatestConfigResp == null) {
                C1461a.m8358e(TAG, "getLatestConfigResp is null");
                return false;
            }
            Config config = getSingleLatestConfigResp.getConfig();
            C1461a.m8359i(TAG, "getOldLatestConfig resp,configPoint " + str + "      resp is " + str3);
            if (config == null) {
                C11327e.m68071n(str, getSingleLatestConfigResp.getVersion());
                C11327e.m68065h(str, System.currentTimeMillis());
                throw new C9721b(304, "Config is no changed.");
            }
            reportReqSuccess(c11060cM66626a, str, str3);
            int type = config.getType();
            if (type != 0) {
                if (type != 1) {
                    return true;
                }
                if (!writeStrToFile(getContext(), config.getContent(), getFileName())) {
                    return false;
                }
                C11327e.m68071n(str, getSingleLatestConfigResp.getVersion());
                C11327e.m68067j(str, config.getEtag());
                C11327e.m68065h(str, System.currentTimeMillis());
                C11327e.m68070m(str, getBuiltInVersion());
                C11327e.m68069l(str, getServiceCountry());
                return true;
            }
            FileInfo file = config.getFile();
            if (file == null) {
                C1461a.m8358e(TAG, "fileInfo is null");
                return false;
            }
            boolean zDownload = download(file);
            C1461a.m8359i(TAG, "getOldLatestConfig downloadFileSuccess ");
            if (zDownload) {
                C11327e.m68071n(str, getSingleLatestConfigResp.getVersion());
                C11327e.m68067j(str, config.getEtag());
                C11327e.m68068k(str, file.getHash());
                C11327e.m68065h(str, System.currentTimeMillis());
                C11327e.m68070m(str, getBuiltInVersion());
                C11327e.m68069l(str, getServiceCountry());
            }
            return zDownload;
        } catch (JsonSyntaxException e10) {
            C1461a.m8358e(TAG, "getLatestConfig err : " + e10);
            throw new C9721b(5004, "json exception");
        } catch (C9721b e11) {
            reportReqException(c11060cM66626a, str, e11);
            processException("getLatestConfig", str, e11);
            throw e11;
        }
    }

    public String getServiceCountry() {
        return C13452e.m80781L().m80942m();
    }

    public boolean isExceptionNeedRetry(C9721b c9721b) {
        if (c9721b.m60659c() == 400) {
            int iM60663g = c9721b.m60663g();
            if (iM60663g != 2 && iM60663g != 5 && iM60663g != 8) {
                return true;
            }
        } else if (c9721b.m60659c() == 429 || c9721b.m60659c() == 5006) {
            return true;
        }
        return false;
    }

    public boolean isNeedUpdateConfig(String str) {
        return C11327e.m68062e(str) < getBuiltInVersion();
    }

    public long getCfgVersion(String str, String str2, String str3) throws C9721b {
        if (this.traceId == null) {
            this.traceId = C11058a.m66627b("07010");
        }
        C11060c c11060cM66626a = C11058a.m66626a(this.traceId, str3, C13452e.m80781L().m80971t0());
        try {
            try {
                C1461a.m8357d(TAG, "getCfgVersion, url is " + str2);
                Snapshot[] changes = ((GetVersionResp) fromJson((String) C11976a.m72086g(str2, new C13460d("", this.traceId), c11060cM66626a), GetVersionResp.class)).getChanges();
                if (changes == null || changes.length <= 0) {
                    throw new C9721b(5001, "no snapshot");
                }
                for (Snapshot snapshot : changes) {
                    if (snapshot != null) {
                        String key = snapshot.getKey();
                        if (!TextUtils.isEmpty(key) && key.equals(str)) {
                            long version = snapshot.getVersion();
                            reportReqSuccess(c11060cM66626a, str, String.valueOf(snapshot.getVersion()));
                            C11327e.m68072o(str, version);
                            C11327e.m68070m(str, getBuiltInVersion());
                            return version;
                        }
                    }
                }
                throw new C9721b(5002, "snapshot not match");
            } catch (JsonSyntaxException e10) {
                C1461a.m8358e(TAG, "getCfgVersion, e is: " + e10.getMessage());
                throw new C9721b(5004, "json exception");
            } catch (C9721b e11) {
                C1461a.m8358e(TAG, "getCfgVersion, CException is: " + e11);
                reportReqException(c11060cM66626a, str, e11);
                if (e11.m60659c() != 9000 || e11.m60663g() != 404) {
                    processException("getConfigVersion", str, e11);
                    throw e11;
                }
                C1461a.m8357d(TAG, "getOldCfgVersion ");
                long oldCfgVersion = getOldCfgVersion(str);
                C11327e.m68070m(str, getBuiltInVersion());
                return oldCfgVersion;
            }
        } catch (Throwable th2) {
            C11327e.m68070m(str, getBuiltInVersion());
            throw th2;
        }
    }

    private void reportReqSuccess(C11060c c11060c, Keys[] keysArr, String str) {
        c11060c.m66665u("0");
        HashMap map = new HashMap();
        map.put("config_point", keysArr[0].getKey());
        map.put("version", str);
        C0239x.m1671c().m1672a(map);
        InterfaceC13043a interfaceC13043aM80810H = C13452e.m80781L().m80810H();
        if (interfaceC13043aM80810H != null) {
            interfaceC13043aM80810H.mo78693d(getContext(), c11060c, map);
        }
    }

    public boolean getLatestConfig(Keys[] keysArr, boolean z10) throws C9721b, NumberFormatException {
        if (this.traceId == null) {
            this.traceId = C11058a.m66627b("07010");
        }
        C11060c c11060cM66626a = C11058a.m66626a(this.traceId, "getLatestConfig", C13452e.m80781L().m80971t0());
        try {
            String latestConfigAddress = getLatestConfigAddress();
            C1461a.m8357d(TAG, "getLatestConfig, url is " + latestConfigAddress + " traceId " + this.traceId);
            GetLatestConfigReq getLatestConfigReq = new GetLatestConfigReq();
            getLatestConfigReq.setClient(getClient());
            getLatestConfigReq.setKeys(keysArr);
            String str = (String) C11976a.m72086g(latestConfigAddress, new C13459c("", getLatestConfigReq.toString(), this.traceId, keysArr, z10), c11060cM66626a);
            C1461a.m8357d(TAG, "resp " + str);
            GetLatestConfigResp getLatestConfigResp = (GetLatestConfigResp) C12540b1.m75483a(str, GetLatestConfigResp.class);
            if (getLatestConfigResp != null) {
                List<Configs> configs = getLatestConfigResp.getConfigs();
                if (configs != null && !configs.isEmpty()) {
                    for (Configs configs2 : configs) {
                        reportReqSuccess(c11060cM66626a, keysArr, String.valueOf(configs2.getVersion()));
                        downloadOmFile(configs2, configs2.getKey(), configs2.getVersion());
                    }
                    return true;
                }
                C1461a.m8359i(TAG, "configList isEmpty ");
                return true;
            }
            throw new C9721b(304, "Config is no changed.");
        } catch (JsonSyntaxException e10) {
            C1461a.m8358e(TAG, "getLatestConfig err : " + e10.getMessage());
            throw new C9721b(5004, "json exception");
        } catch (C9721b e11) {
            C1461a.m8358e(TAG, "getLatestConfig, CException is: " + e11);
            reportReqException(c11060cM66626a, keysArr.toString(), e11);
            if (e11.m60659c() == 9000 && e11.m60663g() == 404) {
                C1461a.m8358e(TAG, "getOldLatestConfig");
                return getOldLatestConfig(keysArr[0].getKey());
            }
            processException("getLatestConfig", keysArr[0].getKey(), e11);
            throw e11;
        }
    }
}
