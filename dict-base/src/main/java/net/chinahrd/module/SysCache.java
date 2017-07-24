package net.chinahrd.module;

import java.util.List;
import java.util.Map;

import net.chinahrd.core.cache.CacheBlock;
import net.chinahrd.core.cache.CacheBlockConstructor;
import net.chinahrd.core.cache.CustomBlock;
import net.chinahrd.eis.permission.EisWebContext;
import net.chinahrd.entity.dto.KVItemDto;
import net.chinahrd.entity.dto.pc.admin.FunctionDto;
import net.chinahrd.entity.dto.pc.common.ConfigDto;
import net.chinahrd.utils.CollectionKit;

/**
 * 系统缓存
 *
 * @author htpeng
 */
public class SysCache {

    private final static String customerId = EisWebContext.getCustomerId();

    /**
     * 获得所有config值
     */
    public static CacheBlock<Map<String, List<String>>> config = new CacheBlockConstructor<Map<String, List<String>>>(
            "queryConfig")
            .getCustomBlock(new CustomBlock<Map<String, List<String>>>() {
                @SuppressWarnings("unchecked")
                @Override
                public Map<String, List<String>> formatData(Object o) {
                    Map<String, List<String>> resultMap = CollectionKit
                            .newMap();
                    if (null == o) {
                        return null;
                    }
                    List<ConfigDto> reList = (List<ConfigDto>) o;
                    // 用父机构ID分组
                    for (ConfigDto dto : reList) {
                        List<String> list = resultMap.get(dto.getConfigKey());
                        if (null == list) {
                            list = CollectionKit.newList();
                            // cala(list,dto.getConfigVal());
                            resultMap.put(dto.getConfigKey(), list);
                        }
                        cala(list, dto.getConfigVal());
                    }
                    return resultMap;
                }

                public void cala(List<String> list, String val) {
                    if (val != null) {
                        String[] arr = val.split(",");
                        for (int i = 0; i < arr.length; i++) {
                            list.add(arr[i]);
                        }
                    }

                }
            }, customerId);


    /**
     * 获得所有子孙机构ID by 父机构ID
     */
    public static CacheBlock<Map<String, List<String>>> cacheAllSubOrganId = new CacheBlockConstructor<Map<String, List<String>>>(
            "queryAllOrganRelation")
            .getCustomBlock(new CustomBlock<Map<String, List<String>>>() {
                @SuppressWarnings("unchecked")
                @Override
                public Map<String, List<String>> formatData(Object o) {
                    Map<String, List<String>> resultMap = CollectionKit
                            .newMap();
                    if (null == o) {
                        return null;
                    }
                    List<KVItemDto> reList = (List<KVItemDto>) o;
                    // 用父机构ID分组
                    for (KVItemDto kVItemDto : reList) {
                        // if(kVItemDto.getK().equals(kVItemDto.getV())){
                        // continue;
                        // }
                        List<String> list = resultMap.get(kVItemDto.getK());
                        if (null == list) {
                            list = CollectionKit.newList();
                            // list.add(kVItemDto.getV());
                            resultMap.put(kVItemDto.getK(), list);
                        }
                        list.add(kVItemDto.getV());
                    }

                    return resultMap;
                }
            }, customerId);

    /**
     * 获得所有子机构ID by 父机构ID
     */
    public static CacheBlock<Map<String, List<String>>> cacheUnderAllSubOrganId = new CacheBlockConstructor<Map<String, List<String>>>(
            "queryUnderAllOrganRelation")
            .getCustomBlock(new CustomBlock<Map<String, List<String>>>() {
                @SuppressWarnings("unchecked")
                @Override
                public Map<String, List<String>> formatData(Object o) {
                    Map<String, List<String>> resultMap = CollectionKit
                            .newMap();
                    if (null == o) {
                        return null;
                    }
                    List<KVItemDto> reList = (List<KVItemDto>) o;
                    // 用父机构ID分组
                    for (KVItemDto kVItemDto : reList) {
                        List<String> list = resultMap.get(kVItemDto.getK());
                        if (null == list) {
                            list = CollectionKit.newList();
                            resultMap.put(kVItemDto.getK(), list);
                        }
                        list.add(kVItemDto.getV());
                    }

                    return resultMap;
                }
            }, customerId);


    /**
     * 功能维
     */
    public static CacheBlock<List<FunctionDto>> queryFunction =
            new CacheBlockConstructor<List<FunctionDto>>("queryFunction").getDefaultBlock(customerId);

    public static CacheBlock<List<KVItemDto>> queryOrgan =
            new CacheBlockConstructor<List<KVItemDto>>("queryOrgan").getDefaultBlock(customerId);
}
