package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.C4626a;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.math.BigDecimal;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class MediaAssetAttribute extends C11707b {

    @InterfaceC4648p
    private Object length;

    @InterfaceC4648p
    private SmallLargeStrPair offset;

    @InterfaceC4648p
    private PictureMetaData pictureMetadata;

    @InterfaceC4648p
    private Object sha256;

    @InterfaceC4648p
    private VideoMetaData videoMetadata;

    public static final class SmallLargePair extends C11707b {

        @InterfaceC4648p
        private Long large;

        @InterfaceC4648p
        private Long small;

        public Long getLarge() {
            return this.large;
        }

        public Long getSmall() {
            return this.small;
        }

        public void setLarge(Long l10) {
            this.large = l10;
        }

        public void setSmall(Long l10) {
            this.small = l10;
        }
    }

    public static final class SmallLargeStrPair extends C11707b {

        @InterfaceC4648p
        private String large;

        @InterfaceC4648p
        private String small;

        public String getLarge() {
            return this.large;
        }

        public String getSmall() {
            return this.small;
        }

        public void setLarge(String str) {
            this.large = str;
        }

        public void setSmall(String str) {
            this.small = str;
        }
    }

    public SmallLargePair getLength() {
        if (this.length instanceof C4626a) {
            try {
                SmallLargePair smallLargePair = new SmallLargePair();
                smallLargePair.setSmall(Long.valueOf(((BigDecimal) ((Map) this.length).get("small")).longValue()));
                smallLargePair.setLarge(Long.valueOf(((BigDecimal) ((Map) this.length).get("large")).longValue()));
                return smallLargePair;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public SmallLargeStrPair getOffset() {
        return this.offset;
    }

    public PictureMetaData getPictureMetaData() {
        return this.pictureMetadata;
    }

    public SmallLargeStrPair getSha256() {
        if (this.sha256 instanceof C4626a) {
            try {
                SmallLargeStrPair smallLargeStrPair = new SmallLargeStrPair();
                smallLargeStrPair.setSmall((String) ((Map) this.sha256).get("small"));
                smallLargeStrPair.setLarge((String) ((Map) this.sha256).get("large"));
                return smallLargeStrPair;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public VideoMetaData getVideoMetaData() {
        return this.videoMetadata;
    }

    public void setLength(SmallLargePair smallLargePair) {
        this.length = smallLargePair;
    }

    public void setOffset(SmallLargeStrPair smallLargeStrPair) {
        this.offset = smallLargeStrPair;
    }

    public void setPictureMetaData(PictureMetaData pictureMetaData) {
        this.pictureMetadata = pictureMetaData;
    }

    public void setVideoMetaData(VideoMetaData videoMetaData) {
        this.videoMetadata = videoMetaData;
    }
}
