package com.huawei.openalliance.p169ad.utils;

import com.huawei.openalliance.p169ad.beans.metadata.AdSource;
import com.huawei.openalliance.p169ad.beans.metadata.C6957Om;
import com.huawei.openalliance.p169ad.beans.metadata.ContentExt;
import com.huawei.openalliance.p169ad.beans.metadata.DefaultTemplate;
import com.huawei.openalliance.p169ad.beans.metadata.ImpEX;
import com.huawei.openalliance.p169ad.beans.metadata.InstallConfig;
import com.huawei.openalliance.p169ad.beans.metadata.LandpageAppWhiteList;
import com.huawei.openalliance.p169ad.beans.metadata.LandpageWebBlackList;
import com.huawei.openalliance.p169ad.beans.metadata.Monitor;
import com.huawei.openalliance.p169ad.beans.metadata.NegativeFb;
import com.huawei.openalliance.p169ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.Asset;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.MotionData;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateData;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb.Data;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb.Image;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb.ImageExt;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb.Title;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.openrtb.Video;
import com.huawei.openalliance.p169ad.inter.data.AbstractC7298a;
import com.huawei.openalliance.p169ad.inter.data.AdvertiserInfo;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.AudioInfo;
import com.huawei.openalliance.p169ad.inter.data.BiddingInfo;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.p169ad.inter.data.ImageInfo;
import com.huawei.openalliance.p169ad.inter.data.PermissionEntity;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.huawei.openalliance.ad.utils.cq */
/* loaded from: classes2.dex */
public class C7797cq extends ObjectInputStream {

    /* renamed from: a */
    private static final Class[] f36037a = {String.class, ArrayList.class, CopyOnWriteArrayList.class, LinkedList.class, HashMap.class, HashSet.class, Integer.class, Float.class, Boolean.class, Long.class, Byte.class, Character.class, Short.class, Double.class, Number.class, int[].class, double[].class, boolean[].class, short[].class, long[].class, byte[].class, float[].class, ImageInfo.class, VideoInfo.class, AppInfo.class, PermissionEntity.class, C7302e.class, LandpageWebBlackList.class, LandpageAppWhiteList.class, InstallConfig.class, ImpEX.class, C6957Om.class, AudioInfo.class, ContentExt.class, NegativeFb.class, FeedbackInfo.class, AdSource.class, Asset.class, AbstractC7298a.class, Data.class, Image.class, ImageExt.class, Video.class, Title.class, TemplateData.class, MotionData.class, AdvertiserInfo.class, DefaultTemplate.class, Monitor.class, PromoteInfo.class, BiddingInfo.class};

    public C7797cq(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException {
        for (Class cls : f36037a) {
            if (cls.getName().equals(objectStreamClass.getName())) {
                return super.resolveClass(objectStreamClass);
            }
        }
        throw new ClassNotFoundException("Class " + objectStreamClass.getName() + " is not allowed!");
    }
}
