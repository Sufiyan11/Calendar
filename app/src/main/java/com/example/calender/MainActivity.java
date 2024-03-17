package com.example.calender;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    CalendarView calendarView;
    Calendar calendar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView=findViewById(R.id.calenderView);
        calendar=Calendar.getInstance();
        getDate();

        TextView textView=findViewById(R.id.dateView);
        SimpleDateFormat fmt = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());;
        Date date = Calendar.getInstance().getTime();
        String strDate = fmt.format(date);
        textView.setText(strDate);
    }
    public void getDate(){
        long date=calendarView.getDate();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yy", Locale.getDefault());
        calendar.setTimeInMillis(date);
        String selected_date=simpleDateFormat.format(calendar.getTime());
    }
    public void setDate(int day,int month,int year){

        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month-1);
        calendar.set(Calendar.DAY_OF_MONTH,day);
        long milli=calendar.getTimeInMillis();
        calendarView.setDate(milli);
    }
}