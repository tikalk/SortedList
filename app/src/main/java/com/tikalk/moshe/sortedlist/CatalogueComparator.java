package com.tikalk.moshe.sortedlist;

import java.util.Comparator;

/**
 * Product comparator. Top-ranked products are at the top.
 *
 * @author Moshe Waisberg
 */
public class CatalogueComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        int c = o2.getRank() - o1.getRank();
        if (c != 0) {
            return c;
        }
        return o1.getId().compareTo(o2.getId());
    }
}
