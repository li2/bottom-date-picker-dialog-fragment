package me.li2.bottomdialogfragment;

import java.util.Date;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import me.li2.bottomdialogfragment.DatePickerDialog.OnDatePickerClickListener;

public class MainActivity extends FragmentActivity {

    private Button mButton;
    private DatePickerDialog mDatePickerDialog;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mButton = (Button) findViewById(R.id.showDiaglogBtn);
        mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDatePickerDialog.isVisible()) {
                    mDatePickerDialog.dismiss();
                } else {
                    mDatePickerDialog.show(getSupportFragmentManager(), "date");;
                }
            }
        });
        
        mDatePickerDialog = new DatePickerDialog();
        mDatePickerDialog.setSelectedDate(new Date());
        mDatePickerDialog.show(getSupportFragmentManager(), "date");
        mDatePickerDialog.setOnDatePickerClickListener(new OnDatePickerClickListener() {
            @Override
            public void onCancelClick() {
                Toast.makeText(MainActivity.this, "cancel clicked", Toast.LENGTH_SHORT).show();
                mDatePickerDialog.dismiss();
            }
            
            @Override
            public void onAcceptClick(Date date) {
                Toast.makeText(MainActivity.this, "Accetp clicked" + date, Toast.LENGTH_SHORT).show();;
                mDatePickerDialog.dismiss();
            }
        });
    }
}
