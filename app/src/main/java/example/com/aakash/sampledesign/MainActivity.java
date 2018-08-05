package example.com.aakash.sampledesign;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawerLayout= findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        switch (id){
            case R.id.inbox:
                startActivity(new Intent(MainActivity.this, InboxActivity.class));
                break;
            case R.id.starred:
                Toast.makeText(getApplicationContext(),"Starred",Toast.LENGTH_SHORT).show();
                break;
            case R.id.sent_mail:
                Toast.makeText(getApplicationContext(),"Sent Mail",Toast.LENGTH_SHORT).show();
                break;
            case R.id.drafts:
                startActivity(new Intent(MainActivity.this,DraftsActivity.class));
                break;
            case R.id.spam:
                Toast.makeText(getApplicationContext(),"Spam",Toast.LENGTH_SHORT).show();
                break;
            case R.id.trash:
                startActivity(new Intent(MainActivity.this, TrashActivity.class));
                break;
            case R.id.receipts:
                Toast.makeText(getApplicationContext(),"Receipts",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_setting:
                Toast.makeText(getApplicationContext(),"Settings",Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
