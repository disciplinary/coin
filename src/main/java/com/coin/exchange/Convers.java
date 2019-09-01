package com.coin.exchange;

import com.coin.exchange.bitcola.domain.BitcolaPair;
import com.coin.facade.response.Pair;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.*;

public abstract class Convers {

    /**
     * 复制集合
     */
    public static <T,K> List<T> copyList(List<K> sourceList, Class<T> clazz) {
        if (CollectionUtils.isEmpty(sourceList)) {
            return null;
        }

        ArrayList<T> target = new ArrayList<>();
        sourceList.forEach(k -> target.add(convert(k, clazz)));
        return target;
    }
    /**
     * 复制集合
     */
    public static <T,K> Set<T> copySet(Set<K> sourceList, Class<T> clazz) {
        if (CollectionUtils.isEmpty(sourceList)) {
            return null;
        }

        Set<T> target = new HashSet<>();
        sourceList.forEach(k -> target.add(convert(k, clazz)));
        return target;
    }

    /**
     * 复制对象
     */
    public static <T,K> T convert(K source, Class<T> clazz) {
        T t = BeanUtils.instantiate(clazz);
        BeanUtils.copyProperties(source, t);
        return t;
    }

    public static void main(String[] args) {
        BitcolaPair bitcolaPair =new BitcolaPair();
        bitcolaPair.setPair("1");
        Pair pair =    convert(bitcolaPair, Pair.class);
        System.out.println(pair.getPair());

      List<BitcolaPair> list = new ArrayList<>();
        BitcolaPair bitcolaPair1 =new BitcolaPair();
        bitcolaPair1.setPair("2");
        list.add(bitcolaPair);
        list.add(bitcolaPair1);
        List<Pair> pairlist =    copyList(list, Pair.class);
        System.out.println(pairlist.get(1).getPair());
    }

}
