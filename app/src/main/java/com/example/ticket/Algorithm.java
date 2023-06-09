package com.example.ticket;

public class Algorithm {
    // создание пустого конструктора
    public Algorithm(){
    }
     // метод определения счастливый билет или нет
    public boolean isHappyTicket(String input) {
        int inputInt = Integer.parseInt(input); // конвертирование данных из String  в int
        // создание буферных переменных
        int s1 = 0, s2 = 0;
        for (int i = 0; i < 3; i++) {    // цикл заполнения первой половины числа
            s1 = s1+inputInt % 10;
            inputInt = inputInt / 10;
        }
        for (int i = 0; i < 3; i++)  {   // цикл заполнения второй половины числа
            s2 = s2+inputInt % 10;
            inputInt = inputInt / 10;
        }
        // проверка равенства
        if (s1 == s2) {  // если суммы равны
            return true;   // то билет счастливый
        }else {  // иначе
            return false; // билет не счастливый
        }
    }
    // метод определения следуующего счастливого биилета
    public int nextHappyTicketV1(String input){
        int inputInt = Integer.parseInt(input);
        if (!isHappyTicket(Integer.toString(inputInt))){ // если билет не счастливый
            while (!isHappyTicket(Integer.toString(inputInt))){   // то выполняется  цикл
                inputInt = inputInt+1;  // шаговой проверки следующих билетов до наступления счастливого билета
            }
            return inputInt;   // возвращается найденный счастливый билет
        }else {  //иначе вслучае изначально счастливого билета
            return inputInt;
        }
    }
    // метод определения следующего счастливого билет - быстрея
    public int nextHappyV2(String input){
        int inputInt = Integer.parseInt(input);
        int count = 0; // задание счетчика

        for (int i = inputInt; i <1_000_000; i++) {    //цикл проверки и поеска счастливаого билета
            int S1 = i % 10+(i/10)%10+(i/100)%10;  // подсчет суммы последних чисел
            int j = i/1000;
            int S2 = j % 10+(j/10)%10+(j/100)%10;   // подсчет суммы первых трех чисел
            if (S1 == S2) {   // проверка счастливого билета
                break; // выброс из цикла
            }else {  // иначе
                count++;  // увеличение счетчика на 1
            }
        }
        return inputInt+ count; // вывод счастливого билета
    }
}
