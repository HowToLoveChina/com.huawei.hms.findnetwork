package com.huawei.hms.network.file.upload.api;

import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.core.util.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public abstract class BodyRequest extends Request {
    private final Map<String, List<FileEntity>> filePostEntityMap;
    private final List<FileEntity> filePutEntity;

    public static abstract class Builder<T extends Request.Builder> extends Request.Builder<T> {
        private List<FileEntity> fileEntities;
        private Map<String, List<FileEntity>> fileParamsMap;

        public Builder() {
            this.fileParamsMap = new HashMap();
        }

        public T fileParams(String str, List<FileEntity> list) {
            Utils.checkNpParamsWithException("fileParams of key", str);
            Utils.checkNpParamsWithException("fileParams of files", list);
            this.fileParamsMap.put(str, list);
            return this;
        }

        public Builder(BodyRequest bodyRequest) {
            super(bodyRequest);
            this.fileParamsMap = new HashMap();
            this.fileEntities = bodyRequest.filePutEntity;
            this.fileParamsMap = BodyRequest.cloneMaps(bodyRequest.filePostEntityMap);
        }

        public T fileParams(String str, FileEntity... fileEntityArr) {
            Utils.checkNpParamsWithException("fileParams of key", str);
            Utils.checkNpParamsWithException("fileParams of files", fileEntityArr);
            ArrayList arrayList = new ArrayList();
            for (FileEntity fileEntity : fileEntityArr) {
                Utils.checkNpParamsWithException("fileParams of files item:", fileEntity);
                arrayList.add(fileEntity);
            }
            this.fileParamsMap.put(str, arrayList);
            return this;
        }

        public T fileParams(List<FileEntity> list) {
            Utils.checkNpParamsWithException("fileEntities", list);
            this.fileEntities = list;
            return this;
        }
    }

    public BodyRequest(Builder builder) {
        super(builder);
        this.filePutEntity = builder.fileEntities;
        this.filePostEntityMap = cloneMaps(builder.fileParamsMap);
    }

    public static Map<String, List<FileEntity>> cloneMaps(Map<String, List<FileEntity>> map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        return map2;
    }

    public List<FileEntity> getFileEntityList() {
        return this.filePutEntity;
    }

    public Map<String, List<FileEntity>> getFileEntityMap() {
        return Collections.unmodifiableMap(this.filePostEntityMap);
    }

    @Override // com.huawei.hms.network.file.api.Request
    public String toString() {
        return "BodyRequest{, config=" + this.config + ", name='" + this.name + "', id=" + this.f29341id + '}';
    }
}
