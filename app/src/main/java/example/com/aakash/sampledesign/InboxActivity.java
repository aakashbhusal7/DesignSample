package example.com.aakash.sampledesign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by aakash on 02August,2018
 */
public class InboxActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    Snackbar snackbar;
    SwitchCompat switchCompat;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        floatingActionButton=findViewById(R.id.fab);
        switchCompat=findViewById(R.id.switch_comp);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar=Snackbar.make(v,"FAB clicked",Snackbar.LENGTH_INDEFINITE);
                snackbar.setDuration(8000);
                snackbar.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });
                View view= snackbar.getView();
                view.setBackgroundColor(getResources().getColor(R.color.snackBarBackground));
                TextView t=view.findViewById(android.support.design.R.id.snackbar_text);
                t.setTextColor(getResources().getColor(R.color.snackBarText));

                snackbar.show();

            }
        });
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b){
                    Toast.makeText(getApplicationContext(), "switch is on",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"switch is off",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
