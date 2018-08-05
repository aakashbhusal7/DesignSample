package example.com.aakash.sampledesign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by aakash on 03August,2018
 */
public class DraftsActivity extends AppCompatActivity {
    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drafts);
        bottomNavigationView= findViewById(R.id.bottom_navigation);
        toolbar=findViewById(R.id.toolbar);
        textView=findViewById(R.id.txt_view);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case(R.id.recent):
                        textView.setText(getResources().getText(R.string.recent));
                        return true;
                    case (R.id.favorites):
                        textView.setText(getResources().getText(R.string.favorites));
                        return true;
                    case (R.id.music):
                        textView.setText(getResources().getText(R.string.music));
                        return true;
                }
                return true;
            }
        });
    }
}
