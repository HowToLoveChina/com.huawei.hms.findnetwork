package com.huawei.android.hicloud.sync.service.aidl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigOperator;
import com.huawei.hicloud.request.opengw.bean.Result;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.network.embedded.C6010m7;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import fk.C9721b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import je.C10812z;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0219i;
import p514o9.C11839m;
import p572qb.C12303d;
import p608rb.C12486b;
import p664u0.C13108a;
import p783xp.C13843a;
import to.C13049a;

/* loaded from: classes3.dex */
public class SyncLogicServiceUtil {
    private static final String BASIC_TYPE = "UTF-8";
    private static final int CAPACITY = 128;
    public static final int OPERATION_TYPE_GET_DATA = 1;
    public static final int OPERATION_TYPE_SET_DATA = 2;
    private static final String TAG = "SyncLogicServiceUtil";

    public static Map<Integer, List<String>> buildFailErrorCodeMap(Map<String, Integer> map) {
        ArrayList arrayList = new ArrayList(map.keySet());
        ArrayList arrayList2 = new ArrayList(map.values());
        HashMap map2 = new HashMap();
        if (arrayList.size() > 0 && arrayList2.size() > 0 && arrayList.size() == arrayList2.size()) {
            C11839m.m70688i(TAG, "failIdList : " + arrayList.toString());
            C11839m.m70688i(TAG, "failErrorCodeList : " + arrayList2.toString());
            for (int i10 = 0; i10 < arrayList2.size(); i10++) {
                Integer num = (Integer) arrayList2.get(i10);
                num.intValue();
                String str = (String) arrayList.get(i10);
                List arrayList3 = !map2.containsKey(num) ? new ArrayList() : (List) map2.get(num);
                arrayList3.add(str);
                map2.put(num, arrayList3);
            }
        }
        return map2;
    }

    public static void callBack(String str, String str2, Context context, int i10, int i11) {
        if (str == null || str.isEmpty() || context == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(MapKeyNames.RESULT_CODE, i10);
        bundle.putString("sync_module_package_name", str2);
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.SENDCALLBACK");
        intent.putExtra("msgType", str);
        intent.putExtra("msgID", i11);
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(context).m78881d(intent);
    }

    public static Result deleteVfsFiles(String str, List<String> list, String str2) {
        int iM60659c;
        String string;
        String string2 = "";
        C13049a c13049a = new C13049a(CloudSyncUtil.m15995b0(str), str2);
        Result result = new Result();
        if (list.size() <= 0) {
            C11839m.m70689w(TAG, "deleteUnStructuredData no cloud file to delete.");
            return result;
        }
        C11839m.m70688i(TAG, "deleteUnStructuredData toDeleteCloudList size: " + list.size());
        String[] strArr = (String[]) list.toArray(new String[list.size()]);
        try {
            result = c13049a.m78736f0(strArr, false);
            string = "";
            iM60659c = 0;
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "deleteUnStructuredData: error message " + e10.toString());
            iM60659c = e10.m60659c();
            string = e10.toString();
        }
        int size = (result.getSuccessList() == null || result.getSuccessList().size() <= 0) ? 0 : result.getSuccessList().size();
        if (result.getFailList() != null && result.getFailList().size() > 0) {
            string2 = result.getFailList().get(0).toString();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("toRemoveFiles", String.valueOf(strArr.length));
        linkedHashMap.put("successRemoveSize", String.valueOf(size));
        linkedHashMap.put(C2126b.ERROR_MESSAGE_INFO, string2);
        C10812z.m65846o(C0213f.m1377a(), str, iM60659c, string, "03001", "local_remove_cloud_files", str2, linkedHashMap, false);
        return result;
    }

    public static void endSyncCallBack(String str, String str2, Context context) {
        callBack(str, str2, context, 0, 10009);
    }

    public static String getFileDir(String str, String str2) {
        return (str == null || str.length() <= 0) ? "" : getFullPath(str).substring(str2.length() + 1);
    }

    public static String getFileName(String str) {
        return (str == null || str.length() <= 0) ? "" : str.substring(str.lastIndexOf("/") + 1);
    }

    public static String getFullPath(String str) {
        return (str == null || str.length() <= 0) ? "" : str.substring(0, str.lastIndexOf("/"));
    }

    public static String getMessageDetial(int i10, Bundle bundle) {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("handleMessage callback,msg.what=");
        sb2.append(i10);
        sb2.append(", bundle=[");
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                sb2.append(str);
                sb2.append("=");
                sb2.append(bundle.get(str));
                sb2.append(";");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public static Uri getNormalDownloadProviderUri(String str, String str2, String str3) {
        C11839m.m70688i(TAG, "getNormalDownloadProviderUri: syncType = " + str + ", dataType = " + str2);
        if ("notepad".equals(str)) {
            return Uri.parse("content://" + C13843a.m83052D() + "/set_download_file");
        }
        if ("addressbook".equals(str)) {
            return new Uri.Builder().authority(C13843a.m83095q()).scheme("content").appendPath("set_download_file").build();
        }
        String packageNameForSyncConfig = getPackageNameForSyncConfig(str, str3);
        if (TextUtils.isEmpty(packageNameForSyncConfig)) {
            return null;
        }
        return new Uri.Builder().authority(packageNameForSyncConfig + ".cloudSync").scheme("content").appendPath("set_download_file").appendQueryParameter("datatype", str2).build();
    }

    public static Uri getNormalUploadProviderUri(String str, String str2, List<String> list, String str3) {
        C11839m.m70688i(TAG, "getNormalUploadProviderUri: syncType = " + str + ", dataType = " + str2 + ", luidList = " + list.toString());
        if ("notepad".equals(str)) {
            return Uri.parse("content://" + C13843a.m83052D() + "/get_upload_files");
        }
        if (!"addressbook".equals(str)) {
            String packageNameForSyncConfig = getPackageNameForSyncConfig(str, str3);
            if (TextUtils.isEmpty(packageNameForSyncConfig)) {
                return null;
            }
            return new Uri.Builder().authority(packageNameForSyncConfig + ".cloudSync").scheme("content").appendPath("get_upload_files").appendQueryParameter("luids", transArryListToStringTrim(list)).appendQueryParameter("datatype", str2).build();
        }
        C11839m.m70688i(TAG, "luidList.size = " + list.size());
        C11839m.m70686d(TAG, "luidList: " + list.toString());
        return new Uri.Builder().authority(C13843a.m83095q()).scheme("content").appendPath("get_upload_files").appendQueryParameter("raw_contact_ids", transArryListToStringTrim(list)).build();
    }

    private static String getPackageNameForSyncConfig(String str, String str2) {
        SyncConfigService serviceById;
        C11839m.m70688i(TAG, "getPackageNameForSyncConfig: syncType = " + str + ", callingPackageName = " + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C11839m.m70687e(TAG, "getPackageNameForSyncConfig: syncType or callingPackageName is null");
            return "";
        }
        LinkedHashMap<String, String> linkedHashMapM65833b = C10812z.m65833b(str2);
        String str3 = linkedHashMapM65833b.containsKey("packageName") ? linkedHashMapM65833b.get("packageName") : "";
        if (TextUtils.isEmpty(str3) && (serviceById = new SyncConfigOperator().getServiceById(str)) != null && serviceById.getApplications().length > 0) {
            str3 = serviceById.getApplications()[0];
        }
        C11839m.m70688i(TAG, "getPackageNameForSyncConfig: packageName = " + str3);
        return str3;
    }

    public static Uri getRequireDownloadProviderUri(String str, String str2, String str3, String str4) {
        String packageNameForSyncConfig = getPackageNameForSyncConfig(str, str4);
        if (TextUtils.isEmpty(packageNameForSyncConfig)) {
            return null;
        }
        return new Uri.Builder().authority(packageNameForSyncConfig + ".cloudSync").scheme("content").appendPath("set_download_file").appendQueryParameter("datatype", str2).appendQueryParameter("downloadname", str3).build();
    }

    public static Uri getRequireUploadProviderUri(String str, String str2, List<String> list, List<String> list2, String str3) {
        C11839m.m70688i(TAG, "getRequireUploadProviderUri: syncType = " + str + ", dataType = " + str2 + ", luidList = " + list.toString() + ", fileNames = " + list2.toString());
        String packageNameForSyncConfig = getPackageNameForSyncConfig(str, str3);
        if (TextUtils.isEmpty(packageNameForSyncConfig)) {
            return null;
        }
        return new Uri.Builder().authority(packageNameForSyncConfig + ".cloudSync").scheme("content").appendPath("get_upload_files").appendQueryParameter("luids", transArryListToStringTrim(list)).appendQueryParameter("filenames", transArryListToStringTrim(list2)).appendQueryParameter("datatype", str2).build();
    }

    public static boolean isSupportFileDir(String str, String str2) {
        if (str != null && !str.isEmpty()) {
            if (CloudSyncUtil.m16056w0(str)) {
                return true;
            }
            if (str.equals("addressbook")) {
                if (HNConstants.DataType.CONTACT.equals(str2)) {
                    return true;
                }
            } else if (str.equals("notepad") && isSupportNotepadFileDir(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSupportNotepadFileDir(String str) {
        return C0209d.m1293p1() || "note".equals(str) || "shorthand".equals(str) || "noteattachment".equals(str);
    }

    private static String listToString(List<String> list) {
        if (list != null) {
            return list.toString();
        }
        return null;
    }

    public static byte[] parseBeginSyncResult(Bundle bundle, String str) {
        return SyncLogicService.isPersistedDataSavedInCloudSyncSDK(str) ? parseCtagMapAndEtagMapToByteArr(bundle) : parseIdentifiedDataToByteArr(bundle);
    }

    public static JSONArray parseCtagInfoListToJsonArray(ArrayList<CtagInfo> arrayList) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null) {
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                CtagInfo ctagInfo = arrayList.get(i10);
                if (ctagInfo != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ctagName", ctagInfo.getCtagName());
                    jSONObject.put("ctagValue", ctagInfo.getCtagValue());
                    jSONObject.put("status", ctagInfo.getStatus());
                    jSONArray.put(jSONObject);
                }
            }
        }
        return jSONArray;
    }

    public static byte[] parseCtagMapAndEtagMapToByteArr(Bundle bundle) throws JSONException {
        try {
            ParcelableMap parcelableMap = (ParcelableMap) bundle.getParcelable("cloud_ctag_map");
            ParcelableMap parcelableMap2 = (ParcelableMap) bundle.getParcelable("cloud_etag_map");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cloud_ctag_map", parseCtagParcelableMapToJSONArray(parcelableMap));
            jSONObject.put("cloud_etag_map", parseEtagParcelableMapToJSONArray(parcelableMap2));
            return jSONObject.toString().getBytes("UTF-8");
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    public static JSONArray parseCtagParcelableMapToJSONArray(ParcelableMap<String, Ctag> parcelableMap) throws JSONException {
        Map<String, Ctag> map;
        JSONArray jSONArray = new JSONArray();
        if (parcelableMap != null && (map = parcelableMap.getMap()) != null && !map.isEmpty()) {
            for (Map.Entry<String, Ctag> entry : map.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    Ctag value = entry.getValue();
                    if (key != null && value != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(SyncProtocol.Constant.GUID, key);
                        jSONObject.put(SyncProtocol.Constant.CTAG, value.getCtag());
                        jSONObject.put("status", value.getStatus());
                        jSONObject.put("syncToken", value.getSyncToken());
                        jSONObject.put(SyncProtocol.Constant.EXPIRED, value.isExpired());
                        jSONArray.put(jSONObject);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static byte[] parseDownloadFileAbortResult(Bundle bundle) throws JSONException {
        UnstructData unstructData = (UnstructData) bundle.getParcelable("down_file_data");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("down_file_data", unstructData);
            jSONObject.put("syncType", bundle.getString("syncType"));
            jSONObject.put("dataType", bundle.getString("dataType"));
            jSONObject.put("session_id", bundle.getString("session_id"));
            return jSONObject.toString().getBytes("UTF-8");
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "parseDownloadFileAbortResult:" + e10.toString());
            return new byte[0];
        }
    }

    public static byte[] parseDownloadFileCompleteResult(Bundle bundle) throws JSONException {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("down_file_success_list");
        Serializable serializable = bundle.getSerializable("down_file_fail_map");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("down_file_success_list", parseUnstructDataListToJSONArray(parcelableArrayList));
            jSONObject.put("syncType", bundle.getString("syncType"));
            jSONObject.put("dataType", bundle.getString("dataType"));
            jSONObject.put("session_id", bundle.getString("session_id"));
            jSONObject.put("down_file_fail_map", parseSerializableMapToJSONArray((SerializableMap) serializable));
            return jSONObject.toString().getBytes("UTF-8");
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "parseDownloadFileCompleteResult:" + e10.toString());
            return new byte[0];
        }
    }

    public static byte[] parseDownloadFileFailResult(Bundle bundle) throws JSONException {
        UnstructData unstructData = (UnstructData) bundle.getParcelable("down_file_data");
        int i10 = bundle.getInt("down_file_error_code");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("down_file_data", unstructData);
            jSONObject.put("down_file_error_code", i10);
            jSONObject.put("syncType", bundle.getString("syncType"));
            jSONObject.put("dataType", bundle.getString("dataType"));
            jSONObject.put("session_id", bundle.getString("session_id"));
            return jSONObject.toString().getBytes("UTF-8");
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "parseDownloadFileFailResult:" + e10.toString());
            return new byte[0];
        }
    }

    public static byte[] parseDownloadFileProgressResult(Bundle bundle) throws JSONException {
        FileDownloadProgress fileDownloadProgress = (FileDownloadProgress) bundle.getParcelable("down_file_progress_data");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("down_file_progress_data", fileDownloadProgress);
            jSONObject.put("syncType", bundle.getString("syncType"));
            jSONObject.put("dataType", bundle.getString("dataType"));
            jSONObject.put("session_id", bundle.getString("session_id"));
            return jSONObject.toString().getBytes("UTF-8");
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "parseDownloadFileProgressResult:" + e10.toString());
            return new byte[0];
        }
    }

    public static byte[] parseDownloadFileSuccessResult(Bundle bundle) throws JSONException {
        UnstructData unstructData = (UnstructData) bundle.getParcelable("down_file_data");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("down_file_data", unstructData);
            jSONObject.put("syncType", bundle.getString("syncType"));
            jSONObject.put("dataType", bundle.getString("dataType"));
            jSONObject.put("session_id", bundle.getString("session_id"));
            return jSONObject.toString().getBytes("UTF-8");
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "parseDownloadFileSuccessResult:" + e10.toString());
            return new byte[0];
        }
    }

    public static byte[] parseDownloadSaveResult(Bundle bundle) throws JSONException {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("unstructresult");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("unstructfailresult");
        Serializable serializable = bundle.getSerializable("fail_error_code_map");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sucUnstructData", parseUnstructDataListToJSONArray(parcelableArrayList));
            jSONObject.put("failUnstructData", parseUnstructDataListToJSONArray(parcelableArrayList2));
            jSONObject.put("failErrorCodeMap", parseSerializableMapToJSONArray((SerializableMap) serializable));
            return jSONObject.toString().getBytes("UTF-8");
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "parseDownloadSaveResult:" + e10.toString());
            return new byte[0];
        }
    }

    public static byte[] parseDownloadUnstructResult(Bundle bundle) throws JSONException {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("unstructresult");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("unstructfailresult");
        Serializable serializable = bundle.getSerializable("fail_error_code_map");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sucDownUnstructData", parseUnstructDataListToJSONArray(parcelableArrayList));
            jSONObject.put("failDownUnstructData", parseUnstructDataListToJSONArray(parcelableArrayList2));
            jSONObject.put("syncType", "syncType");
            jSONObject.put("dataType", "dataType");
            jSONObject.put("failErrorCodeMap", parseSerializableMapToJSONArray((SerializableMap) serializable));
            return jSONObject.toString().getBytes("UTF-8");
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "parseDownloadUnstructResult:" + e10.toString());
            return new byte[0];
        }
    }

    public static byte[] parseEndsyncResult(Bundle bundle) throws JSONException {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("update_ctag_list");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("updateCtagList", parseCtagInfoListToJsonArray(parcelableArrayList));
            return jSONObject.toString().getBytes("UTF-8");
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "parseDownloadUnstructResult:" + e10.toString());
            return new byte[0];
        }
    }

    public static JSONArray parseEtagParcelableMapToJSONArray(ParcelableMap<String, Etag> parcelableMap) throws JSONException {
        Map<String, Etag> map;
        JSONArray jSONArray = new JSONArray();
        if (parcelableMap != null && (map = parcelableMap.getMap()) != null && !map.isEmpty()) {
            for (Map.Entry<String, Etag> entry : map.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    Etag value = entry.getValue();
                    if (key != null && value != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(SyncProtocol.Constant.GUID, key);
                        jSONObject.put("uuid", value.getUuid());
                        jSONObject.put(SyncProtocol.Constant.ETAG, value.getEtag());
                        jSONObject.put("status", value.getStatus());
                        jSONObject.put("operation", value.getOperation());
                        jSONArray.put(jSONObject);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static byte[] parseGetSyncLostListResult(Bundle bundle) throws JSONException {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("get_sync_lost_list_result");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lostRecordIdList", listToString(stringArrayList));
            return jSONObject.toString().getBytes("UTF-8");
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "parseGetSyncLostListResult:" + e10.toString());
            return new byte[0];
        }
    }

    public static byte[] parseIdentifiedDataToByteArr(Bundle bundle) throws JSONException {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("cadd");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("cmod");
        ArrayList<String> stringArrayList3 = bundle.getStringArrayList("cdel");
        ArrayList<String> stringArrayList4 = bundle.getStringArrayList("cconflict");
        ArrayList<String> stringArrayList5 = bundle.getStringArrayList("ladd");
        ArrayList<String> stringArrayList6 = bundle.getStringArrayList("lmod");
        ArrayList<String> stringArrayList7 = bundle.getStringArrayList("ldel");
        ArrayList<String> stringArrayList8 = bundle.getStringArrayList("Lconflict");
        ArrayList<String> stringArrayList9 = bundle.getStringArrayList("lmodcdel");
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("coperatemap");
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = parcelableArrayList;
        try {
            jSONObject.put("cadd", listToString(stringArrayList));
            jSONObject.put("cmod", listToString(stringArrayList2));
            jSONObject.put("cdel", listToString(stringArrayList3));
            jSONObject.put("cconflict", listToString(stringArrayList4));
            jSONObject.put("ladd", listToString(stringArrayList5));
            jSONObject.put("lmod", listToString(stringArrayList6));
            jSONObject.put("ldel", listToString(stringArrayList7));
            jSONObject.put("Lconflict", listToString(stringArrayList8));
            jSONObject.put("lmodcdel", listToString(stringArrayList9));
            JSONArray jSONArray = new JSONArray();
            int i10 = 0;
            while (arrayList != null && i10 < arrayList.size()) {
                JSONObject jSONObject2 = new JSONObject();
                ArrayList arrayList2 = arrayList;
                jSONObject2.put(SyncProtocol.Constant.GUID, ((SyncData) arrayList2.get(i10)).getGuid());
                jSONObject2.put(SyncProtocol.Constant.ETAG, ((SyncData) arrayList2.get(i10)).getEtag());
                if (((SyncData) arrayList2.get(i10)).getLuid() == null) {
                    jSONObject2.put(SyncProtocol.Constant.LUID, "");
                } else {
                    jSONObject2.put(SyncProtocol.Constant.LUID, ((SyncData) arrayList2.get(i10)).getLuid());
                }
                jSONArray.put(jSONObject2);
                i10++;
                arrayList = arrayList2;
            }
            jSONObject.put("coperatemap", jSONArray);
            return jSONObject.toString().getBytes("UTF-8");
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    public static String parseIncrementCtagMapToString(Map<String, Ctag> map) {
        StringBuilder sb2 = new StringBuilder();
        if (map == null || map.isEmpty()) {
            return "";
        }
        int i10 = 0;
        for (Map.Entry<String, Ctag> entry : map.entrySet()) {
            if (entry != null) {
                String key = entry.getKey();
                Ctag value = entry.getValue();
                if (key != null && value != null) {
                    if (i10 != 0) {
                        sb2.append(",{");
                    } else {
                        sb2.append("{");
                    }
                    sb2.append("\"");
                    sb2.append(SyncProtocol.Constant.GUID);
                    sb2.append("\"");
                    sb2.append(":");
                    sb2.append("\"");
                    sb2.append(key);
                    sb2.append("\"");
                    sb2.append(",");
                    sb2.append("\"");
                    sb2.append(SyncProtocol.Constant.CTAG);
                    sb2.append("\"");
                    sb2.append(":");
                    sb2.append("\"");
                    sb2.append(value.getCtag());
                    sb2.append("\"");
                    sb2.append(",");
                    sb2.append("\"");
                    sb2.append("status");
                    sb2.append("\"");
                    sb2.append(":");
                    sb2.append(value.getStatus());
                    sb2.append(",");
                    if (!TextUtils.isEmpty(value.getSyncToken())) {
                        sb2.append("\"");
                        sb2.append("syncToken");
                        sb2.append("\"");
                        sb2.append(":");
                        sb2.append("\"");
                        sb2.append(value.getSyncToken());
                        sb2.append("\"");
                        sb2.append(",");
                    }
                    sb2.append("\"");
                    sb2.append(SyncProtocol.Constant.EXPIRED);
                    sb2.append("\"");
                    sb2.append(":");
                    sb2.append(value.isExpired());
                    i10++;
                    sb2.append("}");
                }
            }
        }
        return sb2.toString();
    }

    public static String parseIncrementEtagMapToString(Map<String, Etag> map, boolean z10, boolean z11, String str) {
        StringBuilder sb2 = new StringBuilder();
        if (map == null || map.isEmpty()) {
            sb2.append(str);
            return sb2.toString();
        }
        int i10 = 0;
        for (Map.Entry<String, Etag> entry : map.entrySet()) {
            if (entry != null) {
                String key = entry.getKey();
                Etag value = entry.getValue();
                if (key != null && value != null) {
                    if (z10 && i10 == 0) {
                        sb2.append("{");
                    } else {
                        sb2.append(",{");
                    }
                    sb2.append("\"");
                    sb2.append(SyncProtocol.Constant.GUID);
                    sb2.append("\"");
                    sb2.append(":");
                    sb2.append("\"");
                    sb2.append(key);
                    sb2.append("\"");
                    sb2.append(",");
                    if (!TextUtils.isEmpty(value.getUuid())) {
                        sb2.append("\"");
                        sb2.append("uuid");
                        sb2.append("\"");
                        sb2.append(":");
                        sb2.append("\"");
                        sb2.append(value.getUuid());
                        sb2.append("\"");
                        sb2.append(",");
                    }
                    sb2.append("\"");
                    sb2.append(SyncProtocol.Constant.ETAG);
                    sb2.append("\"");
                    sb2.append(":");
                    sb2.append("\"");
                    sb2.append(value.getEtag());
                    sb2.append("\"");
                    sb2.append(",");
                    sb2.append("\"");
                    sb2.append("operation");
                    sb2.append("\"");
                    sb2.append(":");
                    sb2.append(value.getOperation());
                    sb2.append(",");
                    sb2.append("\"");
                    sb2.append("status");
                    sb2.append("\"");
                    sb2.append(":");
                    sb2.append(value.getStatus());
                    sb2.append("}");
                    i10++;
                }
            }
        }
        if (z11) {
            sb2.append(str);
        }
        return sb2.toString();
    }

    public static String parseIncrementQueryCloudData(ArrayList<SyncData> arrayList, boolean z10, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        if (arrayList == null || arrayList.isEmpty()) {
            sb2.append("]");
            return sb2.toString();
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            SyncData syncData = arrayList.get(i10);
            if (!z10 || i10 != 0) {
                sb2.append(",");
            }
            JSONObject jSONObject = new JSONObject();
            try {
                setSyncDataJsonObjectData(jSONObject, syncData);
                sb2.append(jSONObject.toString());
            } catch (JSONException e10) {
                C11839m.m70688i(TAG, "parseIncrementQueryCloudData JSONException " + e10.getMessage());
            }
        }
        if (z11) {
            sb2.append("]");
        }
        return sb2.toString();
    }

    public static byte[] parseQueryCloudData(ArrayList<SyncData> arrayList) {
        byte[] bArr = new byte[0];
        JSONArray jSONArray = new JSONArray();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            try {
                SyncData syncData = arrayList.get(i10);
                JSONObject jSONObject = new JSONObject();
                setSyncDataJsonObjectData(jSONObject, syncData);
                jSONArray.put(jSONObject);
            } catch (Exception e10) {
                C11839m.m70687e(TAG, "parseQueryCloudData:" + e10.toString());
                return bArr;
            }
        }
        return jSONArray.toString().getBytes("UTF-8");
    }

    public static JSONArray parseSerializableMapToJSONArray(SerializableMap<Integer, List<String>> serializableMap) throws JSONException {
        Map<Integer, List<String>> map;
        JSONArray jSONArray = new JSONArray();
        if (serializableMap != null && (map = serializableMap.getMap()) != null && !map.isEmpty()) {
            for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
                if (entry != null) {
                    int iIntValue = entry.getKey().intValue();
                    List<String> value = entry.getValue();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, iIntValue);
                    jSONObject.put("idList", listToString(value));
                    jSONArray.put(jSONObject);
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray parseSyncDataListToJSONArray(List<SyncData> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            SyncData syncData = list.get(i10);
            JSONObject jSONObject = new JSONObject();
            List<UnstructData> fileList = syncData.getFileList();
            List<UnstructData> downFileList = syncData.getDownFileList();
            List<UnstructData> deleteFileList = syncData.getDeleteFileList();
            JSONArray unstructDataListToJSONArray = parseUnstructDataListToJSONArray(fileList);
            JSONArray unstructDataListToJSONArray2 = parseUnstructDataListToJSONArray(downFileList);
            JSONArray unstructDataListToJSONArray3 = parseUnstructDataListToJSONArray(deleteFileList);
            jSONObject.put(SyncProtocol.Constant.LUID, syncData.getLuid());
            jSONObject.put(SyncProtocol.Constant.GUID, syncData.getGuid());
            jSONObject.put("unstruct_uuid", syncData.getUnstructUuid());
            jSONObject.put(SyncProtocol.Constant.ETAG, syncData.getEtag());
            jSONObject.put("data", syncData.getData());
            jSONObject.put("uuid", syncData.getUuid());
            jSONObject.put("status", syncData.getStatus());
            jSONObject.put(HicloudH5ConfigManager.KEY_HASH, syncData.getHash());
            jSONObject.put("downFileList", unstructDataListToJSONArray2);
            jSONObject.put("deleteFileList", unstructDataListToJSONArray3);
            jSONObject.put("filelist", unstructDataListToJSONArray);
            jSONObject.put("recycleStatus", syncData.getRecycleStatus());
            jSONObject.put(SyncProtocol.Constant.RECYCLE_TIME, syncData.getRecycleTime());
            if (syncData.getExtensionData() != null) {
                jSONObject.put("extensionData", syncData.getExtensionData());
            }
            if (syncData.getExtraParam() != null) {
                jSONObject.put("extraParam", syncData.getExtraParam());
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static JSONArray parseUnstructDataListToJSONArray(List<UnstructData> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                UnstructData unstructData = list.get(i10);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", unstructData.getId());
                jSONObject.put("unstruct_uuid", unstructData.getUnstructUuid());
                jSONObject.put("name", unstructData.getName());
                jSONObject.put(HicloudH5ConfigManager.KEY_HASH, unstructData.getHash());
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    public static byte[] parseUploadResult(Bundle bundle) throws JSONException {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("cadd");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("cmod");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("cdel");
        Serializable serializable = bundle.getSerializable("fail_error_code_map");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("addData", parseSyncDataListToJSONArray(parcelableArrayList));
            jSONObject.put("modifyData", parseSyncDataListToJSONArray(parcelableArrayList2));
            jSONObject.put("deleteData", listToString(stringArrayList));
            jSONObject.put("failErrorCodeMap", parseSerializableMapToJSONArray((SerializableMap) serializable));
            return jSONObject.toString().getBytes("UTF-8");
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "parseUploadResult:" + e10.toString());
            return new byte[0];
        }
    }

    private static void setSyncDataJsonObjectData(JSONObject jSONObject, SyncData syncData) throws JSONException {
        jSONObject.put(SyncProtocol.Constant.GUID, syncData.getGuid());
        jSONObject.put("data", syncData.getData());
        jSONObject.put("unstructUuid", syncData.getUnstructUuid() == null ? "" : syncData.getUnstructUuid());
        jSONObject.put("recycleStatus", syncData.getRecycleStatus());
        jSONObject.put(SyncProtocol.Constant.RECYCLE_TIME, syncData.getRecycleTime());
        if (syncData.getExtensionData() != null) {
            jSONObject.put("extensionData", syncData.getExtensionData());
        }
        if (syncData.getExtraParam() != null) {
            jSONObject.put("extraParam", syncData.getExtraParam());
        }
    }

    public static void startSyncFailedCallBack(String str, String str2, Context context, int i10) {
        callBack(str, str2, context, i10, 10001);
    }

    public static void syncApplyPowerkit(String str) {
        if (C0219i.m1463a() < 21) {
            C11839m.m70689w(TAG, "syncApplyPowerkit: sync powerkit only support upper 10.0.");
            return;
        }
        str.hashCode();
        if (!str.equals("addressbook")) {
            C11839m.m70688i(TAG, "isNeedApplypowerkit: no need apply powerkit.");
            return;
        }
        C11839m.m70688i(TAG, "Contacts startsync, apply powerkit");
        C12303d.m73958f().m73959d("user-contact_sync_apply", new C12486b());
    }

    public static void syncFailedCallBack(String str, String str2, Context context, int i10, int i11) {
        callBack(str, str2, context, i10, i11);
    }

    public static void syncRemovePowerkit(String str) {
        if (C0219i.m1463a() < 21) {
            C11839m.m70689w(TAG, "syncApplyPowerkit: sync powerkit only support upper 10.0.");
            return;
        }
        str.hashCode();
        if (!str.equals("addressbook")) {
            C11839m.m70688i(TAG, "isNeedApplypowerkit: no need remove powerkit.");
        } else {
            C11839m.m70688i(TAG, "Contacts endsync, remove powerkit");
            C12303d.m73958f().m73962h("user-contact_sync_apply");
        }
    }

    public static String transArryListToStringTrim(List<String> list) {
        if (list == null || list.size() == 0) {
            return C6010m7.f27500n;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        int i10 = 0;
        while (true) {
            if (i10 >= list.size()) {
                break;
            }
            sb2.append(list.get(i10));
            if (i10 == list.size() - 1) {
                sb2.append("]");
                break;
            }
            sb2.append(",");
            i10++;
        }
        C11839m.m70686d(TAG, "transArryListToStringTrim luidList：" + ((Object) sb2));
        return sb2.toString();
    }

    public static boolean isSupportFileDir(String str) {
        return "addressbook".equals(str) || "notepad".equals(str) || CloudSyncUtil.m16056w0(str);
    }
}
