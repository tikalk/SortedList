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
package com.tikalk.sortedlist;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

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
        Firebase db = new Firebase("https://sorted-list.firebaseio.com/catalogue");
        db.setAndroidContext(this);
        db.authAnonymously(new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                Toast.makeText(MainActivity.this, R.string.firebase_authenticated, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                Toast.makeText(MainActivity.this, R.string.firebase_error, Toast.LENGTH_SHORT).show();
            }
        });
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                System.out.println("!@# onChildAdded " + dataSnapshot + " " + s);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                System.out.println("!@# onChildChanged " + dataSnapshot + " " + s);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                System.out.println("!@# onChildRemoved " + dataSnapshot);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                System.out.println("!@# onChildMoved " + dataSnapshot + " " + s);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e(TAG, "Firebase cancelled: " + firebaseError.getMessage(), firebaseError.toException());
            }
        });
    }
}
