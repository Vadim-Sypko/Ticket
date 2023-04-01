package com.example.ticket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //создание полей для вывода на экран нужных значений
    private EditText ticketNumberIn; // поле ввода номера билета
    private Button button; // кнопка обработки информации
    private TextView ticketInfoOut; // поле вывода результирующей информауии

    //создание поля для алгоритма
    private String ticketNumber = " "; // переменная для записи входного значения

    // создадим объект алгоритма что бы мы могли получить доступ к его методам
    Algorithm algorithm = new Algorithm();

    //вывод на экран полученных значений
    @Override
    protected void onCreate(Bundle savedInstanceState) {   // создание жизненого цикла октивности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);    // присваивание жизненому циклу активности представления activity_main

        // присваивание перменным активити элементов представлений activity_main
        ticketNumberIn = findViewById(R.id.ticketNumberIn);
        button = findViewById(R.id.button);
        ticketInfoOut = findViewById(R.id.ticketInfoOut);

        //выполнение действий при нажитии кнопки
        button.setOnClickListener(listener); //обработка нажитий кнопки
    }
    //объект  обработки нажатия кнопки
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //считывание введенного значания
            ticketNumber = ticketNumberIn.getText().toString();

            //использование алгоритма для определения счастливого билета
            if (algorithm.isHappyTicket(ticketNumber)) { //если номер билета счастливый то об этом выводитсмя информация на экран
                ticketInfoOut.setText("ДАННЫЙ НОМЕР БИЛЕТА СЧАТЛИВЫЙ "+ algorithm.nextHappyTicketV1(ticketNumber));
            }else {  // иначе производится поиск даного билета с последующим выводом на экран
                ticketInfoOut.setText("ДАНЫЙ НОМЕР БИЛЕТА НЕ СЧАСТЛИВЫЙБ, СЛЕДУЮЩИМ СЧАСТЛИВЫМ НОМЕРОМ ЯВЛЯЕТСЯ "+algorithm.nextHappyTicketV1(ticketNumber));
            }
        }
    };
}