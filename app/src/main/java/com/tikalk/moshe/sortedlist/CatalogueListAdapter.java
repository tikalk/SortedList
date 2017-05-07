package com.tikalk.moshe.sortedlist;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.util.SortedListAdapterCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Product catalogue list adapter.
 *
 * @author Moshe Waisberg
 */
public class CatalogueListAdapter extends RecyclerView.Adapter<CatalogueViewHolder> {

    private final SortedList<Product> products;
    private final Map<String, Product> productsById = new HashMap<>();

    public CatalogueListAdapter(Context context) {
        this.products = new SortedList<Product>(Product.class, new SortedListAdapterCallback<Product>(this) {
            private final CatalogueComparator comparator = new CatalogueComparator();

            @Override
            public int compare(Product item1, Product item2) {
                return comparator.compare(item1, item2);
            }

            @Override
            public boolean areContentsTheSame(Product oldItem, Product newItem) {
                return comparator.compare(oldItem, newItem) == 0;
            }

            @Override
            public boolean areItemsTheSame(Product item1, Product item2) {
                return item1.equals(item2);
            }
        });
    }

    @Override
    public CatalogueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.list_item_catalogue, parent, false);
        final CatalogueViewHolder holder = new CatalogueViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CatalogueViewHolder holder, int position) {
        Product product = getProduct(position);
        holder.bind(product);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    /**
     * Get the product.
     *
     * @param position the position.
     * @return the product.
     */
    public Product getProduct(int position) {
        return products.get(position);
    }

    /**
     * Get the product.
     *
     * @param id the id.
     * @return the product.
     */
    @Nullable
    public Product getProduct(String id) {
        if (id == null) {
            return null;
        }
        return productsById.get(id);
    }

    /**
     * Set the list of image paths.
     *
     * @param products the list of products.
     */
    public void setProducts(@Nullable List<Product> products) {
        this.products.beginBatchedUpdates();
        this.products.clear();
        productsById.clear();

        if (products != null) {
            this.products.addAll(products);

            Product product;
            final int count = products.size();
            for (int i = 0; i < count; i++) {
                product = products.get(i);
                productsById.put(product.getId(), product);
            }
        }
        this.products.endBatchedUpdates();
        //called by SortedList: notifyDataSetChanged();
    }

    /**
     * Add an image path.
     *
     * @param product the product.
     */
    public void addProduct(Product product) {
        String id = product.getId();
        if (products.add(product) >= 0) {
            productsById.put(id, product);
            //called by SortedList: notifyDataSetChanged();
        }
    }

    /**
     * Get the product position.
     *
     * @param product the product to find.
     * @return the index.
     */
    public int indexOfProduct(Product product) {
        return products.indexOf(product);
    }

    /**
     * Get the product position.
     *
     * @param id the product id to find.
     * @return the index.
     */
    public int indexOfProduct(String id) {
        return indexOfProduct(productsById.get(id));
    }
}
