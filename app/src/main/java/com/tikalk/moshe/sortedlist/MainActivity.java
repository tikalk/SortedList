package com.tikalk.moshe.sortedlist;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends Activity {

    private RecyclerView catalogueList;
    private CatalogueListAdapter catalogueAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catalogueList = (RecyclerView) findViewById(android.R.id.list);
        catalogueAdapter = new CatalogueListAdapter(this);
        catalogueList.setAdapter(catalogueAdapter);
    }
}
