package com.study.dh.keeplearn.db;

import java.util.List;

/**
 * Created by dh on 2017/2/7.
 */

public class LoveDao {

    /**
     * 添加数据，如果有重复则覆盖
     *
     * @param shop
     */
    public static void insertLove(Shop shop) {
        BaseApplication.getDaoInstant().getShopDao().insertOrReplace(shop);
        //BaseApplication
    }

    /**
     * 删除数据
     *
     * @param id
     */
    public static void deleteLove(long id) {
        BaseApplication.getDaoInstant().getShopDao().deleteByKey(id);
    }

    /**
     * 更新数据
     *
     * @param shop
     */
    public static void updateLove(Shop shop) {
        BaseApplication.getDaoInstant().getShopDao().update(shop);
    }

    /**
     * 查询条件为Type=TYPE_LOVE的数据
     *
     * @return
     */
    public static List<Shop> queryLove() {
        return BaseApplication.getDaoInstant().getShopDao().queryBuilder().where(ShopDao.Properties.Type.eq(Shop.TYPE_LOVE)).list();
    }

    /**
     * 查询全部数据
     */
    public static List<Shop> queryAll() {
        return BaseApplication.getDaoInstant().getShopDao().loadAll();
    }

}