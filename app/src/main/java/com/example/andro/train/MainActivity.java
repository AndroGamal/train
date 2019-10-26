package com.example.andro.train;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ListView listView;
    Button sign_in;
    EditText name, pass;
    static TextView textemail, num;
    SharedPreferences.Editor email;
    SharedPreferences read;
    String em;
    NavigationView navigationView;
    static View[] ArrayView;
    static RecyclerView recycler, recycler_my;
    static MyAdapter_Recycler mAdapter;
    static MyAdapter_myticket_Recycler mAdapter_my;
    static int i = 0;
    Animation animation;
    ImageView imageView;
    static ArrayList<java_train_journey> my_ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        animation = AnimationUtils.loadAnimation(this, R.anim.button);
        my_ticket = new ArrayList<>();
        imageView = findViewById(R.id.imageView3);
        imageView.setEnabled(false);
        //imageView.setAnimation(animation);
        recycler = findViewById(R.id.r);
        recycler_my = findViewById(R.id.r_my);
        name = findViewById(R.id.name);
        pass = findViewById(R.id.pass);
        listView = findViewById(R.id.list_view);
        sign_in = findViewById(R.id.sign_in_bot);
        num = findViewById(R.id.num);
        //num.setAnimation(animation);
        ArrayView = new View[6];
        ArrayView[0] = findViewById(R.id.tic);
        ArrayView[1] = findViewById(R.id.paypal);
        ArrayView[2] = findViewById(R.id.t);
        ArrayView[3] = findViewById(R.id.sign_in);
        ArrayView[4] = findViewById(R.id.recs);
        ArrayView[5] = findViewById(R.id.recs_my);
        listView.setAdapter(new myadapter(this, R.layout.one_train_journey, Start.list));
        mAdapter = new MyAdapter_Recycler(this, R.layout.object_tecket, Start.list);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(mAdapter);
        mAdapter_my = new MyAdapter_myticket_Recycler(this, R.layout.object_my_ticket, my_ticket);
        recycler_my.setLayoutManager(new LinearLayoutManager(this));
        recycler_my.setAdapter(mAdapter_my);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        textemail = navigationView.getHeaderView(0).findViewById(R.id.emailt);
        email = getSharedPreferences("Email", MODE_MULTI_PROCESS).edit();
        read = getSharedPreferences("Email", MODE_MULTI_PROCESS);
        em = read.getString("email", "Null");
        textemail.setText(em);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(animation);
                show_one_layout(ArrayView[1], ArrayView);
            }
        });
        if (em == "Null") {
            navigationView.setCheckedItem(R.id.log_in);
            set_Enable_Menu(false);
        } else {
            navigationView.setCheckedItem(R.id.ticket);
            show_one_layout(ArrayView[0], ArrayView);
            imageView.setEnabled(true);
        }
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!sign_in.getText().toString().isEmpty() && !pass.getText().toString().isEmpty()) {
                    email.putString("email", name.getText().toString());
                    email.commit();
                    textemail.setText(read.getString("email", "Null"));
                    set_Enable_Menu(true);
                    navigationView.setCheckedItem(R.id.ticket);
                    show_one_layout(ArrayView[0], ArrayView);
                    imageView.setEnabled(true);
                } else {
                    Toast.makeText(MainActivity.this, "you must write email and password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (findViewById(R.id.recs).getVisibility() == View.VISIBLE) {
            show_one_layout(ArrayView[0], ArrayView);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();
        if (id == R.id.ticket) {
            show_one_layout(ArrayView[0], ArrayView);
        } else if (id == R.id.paybal) {
            show_one_layout(ArrayView[1], ArrayView);
        } else if (id == R.id.log_in) {
            show_one_layout(ArrayView[3], ArrayView);
        } else if (id == R.id.my_ticket) {
            show_one_layout(ArrayView[5], ArrayView);
        } else if (id == R.id.log_out) {
            email.clear();
            email.commit();
            set_Enable_Menu(false);
            show_one_layout(ArrayView[3], ArrayView);
            navigationView.setCheckedItem(R.id.log_in);

        } else {
            Toast.makeText(this, "please sign in", Toast.LENGTH_SHORT).show();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void set_Enable_Menu(boolean enable_menu) {
        navigationView.getMenu().findItem(R.id.ticket).setEnabled(enable_menu);
        navigationView.getMenu().findItem(R.id.paybal).setEnabled(enable_menu);
        navigationView.getMenu().findItem(R.id.my_ticket).setEnabled(enable_menu);

    }

    static void show_one_layout(View id, View[] ID_list) {
        for (View v : ID_list) {
            v.setVisibility(View.GONE);
        }
        id.setVisibility(View.VISIBLE);


    }

}

