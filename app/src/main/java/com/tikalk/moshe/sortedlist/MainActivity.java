/*
 * BSD 3-Clause License
 *
 * Copyright (c) 2017, Tikal Knowledge, Ltd.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * * Neither the name of the copyright holder nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.tikalk.moshe.sortedlist;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {

    private static final String[] URL = {
            "https://static.pexels.com/photos/102129/pexels-photo-102129.jpeg",
            "https://static.pexels.com/photos/45982/pexels-photo-45982.jpeg",
            "https://static.pexels.com/photos/45055/pexels-photo-45055.jpeg",
            "https://static.pexels.com/photos/45057/pexels-photo-45057.jpeg",
            "https://static.pexels.com/photos/251454/pexels-photo-251454.jpeg",
            "https://static.pexels.com/photos/292999/pexels-photo-292999.jpeg",
            "https://static.pexels.com/photos/1597/fashion-man-person-wristwatch.jpg",
            "https://static.pexels.com/photos/5108/fashion-man-person-winter.jpeg",
            "https://static.pexels.com/photos/297933/pexels-photo-297933.jpeg",
            "https://static.pexels.com/photos/298863/pexels-photo-298863.jpeg",
            "https://static.pexels.com/photos/87004/substances-colorful-color-pattern-87004.jpeg",
    };

    private RecyclerView catalogueList;
    private CatalogueListAdapter catalogueAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catalogueList = (RecyclerView) findViewById(android.R.id.list);
        catalogueAdapter = new CatalogueListAdapter(this);
        catalogueList.setAdapter(catalogueAdapter);

        populateCatalogue();
    }

    private void populateCatalogue() {
        final Random random = new Random();
        final int count = random.nextInt(100);

        Product product;
        String id;
        String stockKeepingUnit;
        String brand;
        double currentPrice;
        String safetyTag;
        String size;
        int category;
        String title;
        String colour;
        boolean stocked;
        double basePrice;
        List<String> imageUrls;
        String productId;
        int rank;
        String url;

        for (int i = 0; i < count; i++) {
            id = Integer.toString(i);
            stockKeepingUnit = Integer.toHexString(i);
            brand = "Pexel";
            currentPrice = random.nextDouble() * 1000;
            safetyTag = null;
            size = "Medium";
            category = 0;
            title = "`Title " + i;
            colour = "orange";
            stocked = true;
            basePrice = currentPrice - (random.nextDouble() * 100);
            url = URL[random.nextInt(URL.length)];
            imageUrls = Arrays.asList(url);
            productId = id;
            rank = Math.abs(random.nextInt());
            product = new Product(id, stockKeepingUnit, brand, currentPrice, safetyTag, size, category, title, colour, stocked, basePrice, imageUrls, productId, rank);
            catalogueAdapter.addProduct(product);
        }
    }
}
