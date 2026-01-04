package com.huawei.android.hicloud.sync.service.aidl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigOperator;
import com.huawei.hms.network.embedded.C6010m7;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import je.C10812z;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0219i;
import p514o9.C11839m;
import p572qb.C12303d;
import p664u0.C13108a;

/* loaded from: classes3.dex */
public class GenSyncLogicServiceUtil {
    private static final String BASIC_TYPE = "UTF-8";
    private static final int CAPACITY = 128;
    public static final int OPERATION_TYPE_GET_DATA = 1;
    public static final int OPERATION_TYPE_GET_VALID_IDS = 3;
    public static final int OPERATION_TYPE_SET_DATA = 2;
    private static final String TAG = "SyncLogicServiceUtil";

    public static void callBack(String str, String str2, Context context, int i10, int i11) {
        if (str == null || str.isEmpty() || context == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(MapKeyNames.RESULT_CODE, i10);
        bundle.putString("sync_module_package_name", str2);
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.GENSENDCALLBACK");
        intent.putExtra("msgType", str);
        intent.putExtra("msgID", i11);
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(context).m78881d(intent);
    }

    public static void endSyncCallBack(String str, String str2, Context context) {
        callBack(str, str2, context, 0, 10009);
    }

    public static String getMessageDetial(int i10, Bundle bundle) {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("handleMessage callback,msg.what: ");
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

    private static String getPackageNameForSyncConfig(String str, String str2) {
        SyncConfigService serviceById;
        C11839m.m70688i(TAG, "getPackageNameForSyncConfig: syncType: " + str + ", callingPackageName: " + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C11839m.m70687e(TAG, "getPackageNameForSyncConfig: syncType or callingPackageName is null");
            return "";
        }
        LinkedHashMap<String, String> linkedHashMapM65833b = C10812z.m65833b(str2);
        String str3 = linkedHashMapM65833b.containsKey("packageName") ? linkedHashMapM65833b.get("packageName") : "";
        if (TextUtils.isEmpty(str3) && (serviceById = new SyncConfigOperator().getServiceById(str)) != null && serviceById.getApplications().length > 0) {
            str3 = serviceById.getApplications()[0];
        }
        C11839m.m70688i(TAG, "getPackageNameForSyncConfig: packageName: " + str3);
        return str3;
    }

    public static Uri getProviderUri(int i10, String str, String str2, ArrayList<String> arrayList, String str3) {
        C11839m.m70688i(TAG, "getProviderUri: operationType = " + i10 + ", syncType = " + str + ", datatype " + str2);
        if (i10 == 1) {
            return operationTypeGetData(str, str2, arrayList, str3);
        }
        if (i10 == 2) {
            return operationtTypeSetData(str, str3);
        }
        if (i10 != 3) {
            return null;
        }
        return operationtTypeGetValidIds(str, str2, str3);
    }

    private static String listToString(List<String> list) {
        if (list != null) {
            return list.toString();
        }
        return null;
    }

    private static Uri operationTypeGetData(String str, String str2, ArrayList<String> arrayList, String str3) {
        String packageNameForSyncConfig = getPackageNameForSyncConfig(str, str3);
        if (TextUtils.isEmpty(packageNameForSyncConfig)) {
            return null;
        }
        return new Uri.Builder().authority(packageNameForSyncConfig + ".cloudSync").scheme("content").appendPath("get_upload_files").appendQueryParameter("datatype", str2).appendQueryParameter("luids", transArryListToStringTrim(arrayList)).build();
    }

    private static Uri operationtTypeGetValidIds(String str, String str2, String str3) {
        String packageNameForSyncConfig = getPackageNameForSyncConfig(str, str3);
        if (TextUtils.isEmpty(packageNameForSyncConfig)) {
            return null;
        }
        return new Uri.Builder().authority(packageNameForSyncConfig + ".cloudSync").appendQueryParameter("data_type", str2).build();
    }

    private static Uri operationtTypeSetData(String str, String str2) {
        String packageNameForSyncConfig = getPackageNameForSyncConfig(str, str2);
        if (TextUtils.isEmpty(packageNameForSyncConfig)) {
            return null;
        }
        return new Uri.Builder().authority(packageNameForSyncConfig + ".cloudSync").scheme("content").appendPath("set_download_file").build();
    }

    public static Uri operationtTypeTaskTd(String str, String str2, ArrayList<String> arrayList, String str3, int i10) {
        String packageNameForSyncConfig = getPackageNameForSyncConfig(str, str3);
        if (TextUtils.isEmpty(packageNameForSyncConfig)) {
            return null;
        }
        return new Uri.Builder().authority(packageNameForSyncConfig + ".cloudSync").scheme("content").appendPath("get_upload_files_by_taskId").appendQueryParameter("datatype", str2).appendQueryParameter("luids", transArryListToStringTrim(arrayList)).appendQueryParameter("code", String.valueOf(i10)).build();
    }

    public static byte[] parseBeginSyncResult(Bundle bundle, String str) {
        return parseCtagMapAndEtagMapToByteArr(bundle);
    }

    public static byte[] parseCtagMapAndEtagMapToByteArr(Bundle bundle) throws JSONException {
        try {
            ParcelableMap parcelableMap = (ParcelableMap) bundle.getParcelable("cloud_ctag_map");
            ParcelableMap parcelableMap2 = (ParcelableMap) bundle.getParcelable("cloud_etag_map");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cloud_ctag_map", SyncLogicServiceUtil.parseCtagParcelableMapToJSONArray(parcelableMap));
            jSONObject.put("cloud_etag_map", SyncLogicServiceUtil.parseEtagParcelableMapToJSONArray(parcelableMap2));
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        } catch (ClassCastException unused2) {
            return new byte[0];
        } catch (JSONException unused3) {
            return new byte[0];
        }
    }

    public static byte[] parseDownloadSaveResult(Bundle bundle) throws JSONException {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("unstructresult");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("unstructfailresult");
        Serializable serializable = bundle.getSerializable("fail_error_code_map");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sucUnstructData", SyncLogicServiceUtil.parseUnstructDataListToJSONArray(parcelableArrayList));
            jSONObject.put("failUnstructData", SyncLogicServiceUtil.parseUnstructDataListToJSONArray(parcelableArrayList2));
            jSONObject.put("failErrorCodeMap", SyncLogicServiceUtil.parseSerializableMapToJSONArray((SerializableMap) serializable));
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e10) {
            C11839m.m70687e(TAG, "parseDownloadSaveResult:" + e10.toString());
            return new byte[0];
        } catch (ClassCastException e11) {
            C11839m.m70687e(TAG, "parseUploadResult:" + e11.toString());
            return new byte[0];
        } catch (JSONException e12) {
            C11839m.m70687e(TAG, "parseDownloadSaveResult:" + e12.toString());
            return new byte[0];
        }
    }

    public static byte[] parseDownloadUnstructResult(Bundle bundle) throws JSONException {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("unstructresult");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("unstructfailresult");
        Serializable serializable = bundle.getSerializable("fail_error_code_map");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sucDownUnstructData", SyncLogicServiceUtil.parseUnstructDataListToJSONArray(parcelableArrayList));
            jSONObject.put("failDownUnstructData", SyncLogicServiceUtil.parseUnstructDataListToJSONArray(parcelableArrayList2));
            jSONObject.put("failErrorCodeMap", SyncLogicServiceUtil.parseSerializableMapToJSONArray((SerializableMap) serializable));
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e10) {
            C11839m.m70687e(TAG, "parseDownloadUnstructResult:" + e10.toString());
            return new byte[0];
        } catch (ClassCastException e11) {
            C11839m.m70687e(TAG, "parseDownloadUnstructResult:" + e11.toString());
            return new byte[0];
        } catch (JSONException e12) {
            C11839m.m70687e(TAG, "parseDownloadUnstructResult:" + e12.toString());
            return new byte[0];
        }
    }

    public static byte[] parseEndsyncResult(Bundle bundle) throws JSONException {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("update_ctag_list");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("updateCtagList", SyncLogicServiceUtil.parseCtagInfoListToJsonArray(parcelableArrayList));
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e10) {
            C11839m.m70687e(TAG, "parseDownloadUnstructResult:" + e10.toString());
            return new byte[0];
        } catch (JSONException e11) {
            C11839m.m70687e(TAG, "parseDownloadUnstructResult:" + e11.toString());
            return new byte[0];
        }
    }

    public static byte[] parseGetSyncLostListResult(Bundle bundle) throws JSONException {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("get_sync_lost_list_result");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lostRecordIdList", listToString(stringArrayList));
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException | JSONException e10) {
            C11839m.m70687e(TAG, "parseGetSyncLostListResult:" + e10.toString());
            return new byte[0];
        }
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
            } catch (UnsupportedEncodingException e10) {
                C11839m.m70687e(TAG, "parseQueryCloudData:" + e10.toString());
                return bArr;
            } catch (JSONException e11) {
                C11839m.m70687e(TAG, "parseQueryCloudData:" + e11.toString());
                return bArr;
            }
        }
        return jSONArray.toString().getBytes("UTF-8");
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
            JSONArray unstructDataListToJSONArray = SyncLogicServiceUtil.parseUnstructDataListToJSONArray(fileList);
            JSONArray unstructDataListToJSONArray2 = SyncLogicServiceUtil.parseUnstructDataListToJSONArray(downFileList);
            JSONArray unstructDataListToJSONArray3 = SyncLogicServiceUtil.parseUnstructDataListToJSONArray(deleteFileList);
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
            jSONArray.put(jSONObject);
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
            jSONObject.put("failErrorCodeMap", SyncLogicServiceUtil.parseSerializableMapToJSONArray((SerializableMap) serializable));
            return jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e10) {
            C11839m.m70687e(TAG, "parseUploadResult:" + e10.toString());
            return new byte[0];
        } catch (ClassCastException e11) {
            C11839m.m70687e(TAG, "parseUploadResult:" + e11.toString());
            return new byte[0];
        } catch (JSONException e12) {
            C11839m.m70687e(TAG, "parseUploadResult:" + e12.toString());
            return new byte[0];
        }
    }

    private static void setSyncDataJsonObjectData(JSONObject jSONObject, SyncData syncData) throws JSONException {
        jSONObject.put(SyncProtocol.Constant.GUID, syncData.getGuid());
        jSONObject.put("data", syncData.getData());
        jSONObject.put("unstructUuid", syncData.getUnstructUuid() == null ? "" : syncData.getUnstructUuid());
        jSONObject.put("recycleStatus", syncData.getRecycleStatus());
        jSONObject.put(SyncProtocol.Constant.RECYCLE_TIME, syncData.getRecycleTime());
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

    public static String transArryListToStringTrim(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return C6010m7.f27500n;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        int i10 = 0;
        while (true) {
            if (i10 >= arrayList.size()) {
                break;
            }
            sb2.append(arrayList.get(i10));
            if (i10 == arrayList.size() - 1) {
                sb2.append("]");
                break;
            }
            sb2.append(",");
            i10++;
        }
        C11839m.m70686d(TAG, "transArryListToStringTrim luidList：" + ((Object) sb2));
        return sb2.toString();
    }
}
