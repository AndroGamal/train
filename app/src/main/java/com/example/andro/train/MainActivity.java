package com.example.andro.train;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ListView listView;
    Button select, sign_in;
   static boolean color = true;
    EditText name, pass;
    TextView textemail;
    SharedPreferences.Editor email;
    SharedPreferences read;
    String em;
    NavigationView navigationView;
  static View[] ArrayView ;
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
        name = findViewById(R.id.name);
        pass = findViewById(R.id.pass);
        listView = findViewById(R.id.list_view);
        sign_in = findViewById(R.id.sign_in_bot);
        select = findViewById(R.id.select);
        ArrayView=new View[4];
        ArrayView[0]= findViewById(R.id.tic);
        ArrayView[1]= findViewById(R.id.paypal);
        ArrayView[2]=findViewById(R.id.t);
        ArrayView[3]=findViewById(R.id.sign_in);
         select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color) {
                    select.setBackgroundResource(R.color.colorPrimaryDark);
                    color = false;
                    Start.list.get(myadapter.s).setSelect(true);
                } else {
                    select.setBackgroundResource(android.R.color.darker_gray);
                    color = true;
                    Start.list.get(myadapter.s).setSelect(false);
                }
            }
        });
        listView.setAdapter(new myadapter(this, R.layout.one_train_journey, Start.list));
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        textemail = navigationView.getHeaderView(0).findViewById(R.id.emailt);
        email = getSharedPreferences("Email", MODE_MULTI_PROCESS).edit();
        read = getSharedPreferences("Email", MODE_MULTI_PROCESS);
        em = read.getString("email", "Null");
        textemail.setText(em);
        if (em == "Null") {
            navigationView.setCheckedItem(R.id.log_in);
            set_Enable_Menu(false);
        }
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email.putString("email", name.getText().toString());
                email.commit();
                textemail.setText(read.getString("email", "Null"));
                set_Enable_Menu(true);
                navigationView.setCheckedItem(R.id.ticket);
                show_one_layout(ArrayView[0], ArrayView);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (findViewById(R.id.t).getVisibility() == View.VISIBLE) {
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
        } else if (id == R.id.cansel) {

        } else if (id == R.id.log_out) {
            email.clear();
            email.commit();
            set_Enable_Menu(false);

        } else {
            Toast.makeText(this, "please sign in", Toast.LENGTH_SHORT).show();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void set_Enable_Menu(boolean enable_menu) {
        navigationView.getMenu().findItem(R.id.ticket).setEnabled(enable_menu);
        navigationView.getMenu().findItem(R.id.nav_send).setEnabled(enable_menu);
        navigationView.getMenu().findItem(R.id.paybal).setEnabled(enable_menu);
        navigationView.getMenu().findItem(R.id.nav_manage).setEnabled(enable_menu);
        navigationView.getMenu().findItem(R.id.nav_slideshow).setEnabled(enable_menu);
        navigationView.getMenu().findItem(R.id.cansel).setEnabled(enable_menu);

    }

    static void show_one_layout(View id, View[] ID_list) {
            for (View v : ID_list) {
                v.setVisibility(View.GONE);
            }
            id.setVisibility(View.VISIBLE);


    }

}

