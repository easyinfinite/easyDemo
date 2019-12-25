package com.structure.list;

import com.alibaba.dubbo.common.utils.CollectionUtils;

import java.util.List;

/**
 * list对象比较，比较的对象必需重写equals和hashcode方法
 *
 * @author hanxiaoyu
 * @since 2019/12/25
 */
public class ListCompareUtil {

    public static <E> boolean isEqual(List<E> list1, List<E> list2) {
        // 两个list引用相同（包括两者都为空指针的情况）
        if (list1 == list2) {
            return true;
        }
        boolean isEmptyForListOne = CollectionUtils.isEmpty(list1);
        boolean isEmptyForListTwo = CollectionUtils.isEmpty(list2);
        // 两个list都为空（包括空指针、元素个数为0）
        if (isEmptyForListOne && isEmptyForListTwo) {
            return true;
        }
        //两个都不为空
        if (!isEmptyForListOne && !isEmptyForListTwo) {
            if (list1.size() == list2.size() && list1.containsAll(list2)) {
                return true;
            }
        }
        return false;
    }
}
