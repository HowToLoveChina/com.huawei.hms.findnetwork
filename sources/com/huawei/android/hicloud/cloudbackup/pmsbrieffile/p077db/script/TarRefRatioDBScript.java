package com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script;

/* loaded from: classes2.dex */
public class TarRefRatioDBScript {
    public static final String CACL_TAR_RATIO_AND_MARK = "replace into %1$s  (tar_ref_ratio,normal_file_sum_size,zero_file_count,origin_size,file_id,is_new_tar,is_cacl_end) SELECT sum(normal_file_sum_size + zero_file_count)/(origin_size + 0.0),sum(normal_file_sum_size),sum(zero_file_count), origin_size, file_id, is_new_tar,  ? FROM %1$s GROUP BY file_id";
    public static final String DELETE_NOT_CACL_END_ROW = "delete from %1$s where is_cacl_end = ?";
    public static final String REPLACE_INTO_TAR_REF_SUM_SIZE_FROM_FULLDB = "replace into %1$s (tar_ref_ratio,normal_file_sum_size,zero_file_count,origin_size,file_id,is_new_tar,is_cacl_end)SELECT 0,  sum(size),  0,  data4,  file_id||cloud_path,  ?,  ? FROM %2$s WHERE type = ? AND status IN (?,?) GROUP BY file_id||cloud_path;";
    public static final String REPLACE_INTO_TAR_REF_SUM_SIZE_FROM_SNAPSHOT = "replace into %1$s (tar_ref_ratio,normal_file_sum_size,zero_file_count,origin_size,file_id,is_new_tar,is_cacl_end)SELECT 0,  sum(size),  0,  data4,  file_id||cloud_path,  ?,  ? FROM %2$s WHERE type = ? AND status IN (?,?) AND root != ? GROUP BY file_id||cloud_path;";
    public static final String REPLACE_INTO_TAR_REF_ZERO_FILE_COUNT_FROM_FULLDB = "replace into %1$s (tar_ref_ratio,normal_file_sum_size,zero_file_count,origin_size,file_id,is_new_tar,is_cacl_end)SELECT 0,0,count(id),data4,file_id||cloud_path,?,?FROM %2$s WHERE type = ? AND status IN (?,?) AND size = 0 GROUP BY file_id||cloud_path;";
    public static final String REPLACE_INTO_TAR_REF_ZERO_FILE_COUNT_FROM_SNAPSHOT = "replace into %1$s (tar_ref_ratio,normal_file_sum_size,zero_file_count,origin_size,file_id,is_new_tar,is_cacl_end)SELECT 0,0,count(id),data4,file_id||cloud_path,?,?FROM %2$s WHERE type = ? AND status IN (?,?) AND root != ? AND size = 0 GROUP BY file_id||cloud_path;";
    public static final String SUM_FREE_SIZE_BY_RATIO = "SELECT SUM(origin_size - normal_file_sum_size - zero_file_count) FROM t_cacl_tar_refratio  WHERE ((is_new_tar = ? AND tar_ref_ratio < ?) OR (is_new_tar = ? AND tar_ref_ratio < ?)) and (origin_size - normal_file_sum_size - zero_file_count) > 0; ";
    public static final String UPDATA_ORIGIN_SIZE_FLAG_BY_ORIGIN_SIZE = "UPDATE %1$s SET origin_size = ?, is_new_tar = ? WHERE origin_size is null OR origin_size = 0 OR origin_size = ''";
}
