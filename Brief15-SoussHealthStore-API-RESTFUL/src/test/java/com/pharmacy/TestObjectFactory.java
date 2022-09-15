package com.pharmacy;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import com.pharmacy.entities.Category;
import com.pharmacy.entities.CategoryEnum;
import com.pharmacy.entities.Product;
import com.pharmacy.entities.Role;
import com.pharmacy.entities.User;

public class TestObjectFactory {

    public static Product newEmptyProduct() {
        Product product = new Product();
        product.setId(1L);
        return product;
    }

    public static Product newProduct(Long id, String name, CategoryEnum categoryName) {
        Product product = new Product();
        Category category = new Category();
        category.setName(categoryName);
        product.setCategory(category);
        product.setId(id);
        product.setName(name);
        return product;
    }

    private static User newNormalUser(Long id) {
        Role role = new Role();
        role.setId(2L);
        role.setName("USER_ROLE");

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = new User();
        user.setId(id);
        user.setUsername("dummy");
        user.setRoles(roles);
        user.setPassword("dummy");
        user.setActive(1);

        return user;
    }

    private static User newAdminlUser(Long id) {
        Role role = new Role();
        role.setId(1L);
        role.setName("ADMIN_ROLE");

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = new User();
        user.setId(id);
        user.setUsername("dummy");
        user.setRoles(roles);
        user.setPassword("dummy");
        user.setActive(1);

        return user;
    }

//    public static InventoryItem newInventoryItemForProduct(Long productId) {
//        InventoryItem item = new InventoryItem();
//        item.setProduct(newProduct(productId, "test", CategoryName.AEROSOL));
//        item.setStock((int)(10.0 * Math.random()));
//        float salePrice = round((float)(10.0 * Math.random()), 2);
//        item.setSalePrice(salePrice);
//        //TODO: the Date type is pretty much deprecated
//        //TODO: dont think this works
//        item.setExpirationDate(between(new Date(2020, 03, 20), new Date(2022, 02, 11)));
//        return item;
//    }






    // ----------------------- Helper methods -----------------------------

    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    public static Date between(Date startInclusive, Date endExclusive) {
        long startMillis = startInclusive.getTime();
        long endMillis = endExclusive.getTime();
        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(startMillis, endMillis);

        return new Date(randomMillisSinceEpoch);
    }

}
