import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));

        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT+1);

        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cb);
            new Thread(cars[i]).start();
        }


        try {
            cb.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            cb.await();
            cb.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }


        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}



/*
    Пример выполнения кода до корректировки:

        ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!
        Участник #2 готовится
        ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!
        ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!
        Участник #1 готовится
        Участник #4 готовится
        Участник #3 готовится
        Участник #3 готов
        Участник #3 начал этап: Дорога 60 метров
        Участник #2 готов
        Участник #2 начал этап: Дорога 60 метров
        Участник #1 готов
        Участник #1 начал этап: Дорога 60 метров
        Участник #4 готов
        Участник #4 начал этап: Дорога 60 метров
        Участник #3 закончил этап: Дорога 60 метров
        Участник #3 готовится к этапу(ждет): Тоннель 80 метров
        Участник #3 начал этап: Тоннель 80 метров
        Участник #2 закончил этап: Дорога 60 метров
        Участник #2 готовится к этапу(ждет): Тоннель 80 метров
        Участник #2 начал этап: Тоннель 80 метров
        Участник #1 закончил этап: Дорога 60 метров
        Участник #1 готовится к этапу(ждет): Тоннель 80 метров
        Участник #1 начал этап: Тоннель 80 метров
        Участник #4 закончил этап: Дорога 60 метров
        Участник #4 готовится к этапу(ждет): Тоннель 80 метров
        Участник #4 начал этап: Тоннель 80 метров
        Участник #2 закончил этап: Тоннель 80 метров
        Участник #2 начал этап: Дорога 40 метров
        Участник #3 закончил этап: Тоннель 80 метров
        Участник #3 начал этап: Дорога 40 метров
        Участник #2 закончил этап: Дорога 40 метров
        Участник #1 закончил этап: Тоннель 80 метров
        Участник #1 начал этап: Дорога 40 метров
        Участник #4 закончил этап: Тоннель 80 метров
        Участник #4 начал этап: Дорога 40 метров
        Участник #3 закончил этап: Дорога 40 метров
        Участник #1 закончил этап: Дорога 40 метров
        Участник #4 закончил этап: Дорога 40 метров


        Примерный результат:

        ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!
        Участник #2 готовится
        Участник #1 готовится
        Участник #4 готовится
        Участник #3 готовится
        Участник #2 готов
        Участник #4 готов
        Участник #1 готов
        Участник #3 готов
        ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!
        Участник #2 начал этап: Дорога 60 метров
        Участник #4 начал этап: Дорога 60 метров
        Участник #3 начал этап: Дорога 60 метров
        Участник #1 начал этап: Дорога 60 метров
        Участник #1 закончил этап: Дорога 60 метров
        Участник #3 закончил этап: Дорога 60 метров
        Участник #3 готовится к этапу(ждет): Тоннель 80 метров
        Участник #1 готовится к этапу(ждет): Тоннель 80 метров
        Участник #1 начал этап: Тоннель 80 метров
        Участник #3 начал этап: Тоннель 80 метров
        Участник #4 закончил этап: Дорога 60 метров
        Участник #4 готовится к этапу(ждет): Тоннель 80 метров
        Участник #2 закончил этап: Дорога 60 метров
        Участник #2 готовится к этапу(ждет): Тоннель 80 метров
        Участник #3 закончил этап: Тоннель 80 метров
        Участник #1 закончил этап: Тоннель 80 метров
        Участник #2 начал этап: Тоннель 80 метров
        Участник #4 начал этап: Тоннель 80 метров
        Участник #3 начал этап: Дорога 40 метров
        Участник #1 начал этап: Дорога 40 метров
        Участник #3 закончил этап: Дорога 40 метров
        Участник #3 - WIN
        Участник #1 закончил этап: Дорога 40 метров
        Участник #4 закончил этап: Тоннель 80 метров
        Участник #4 начал этап: Дорога 40 метров
        Участник #2 закончил этап: Тоннель 80 метров
        Участник #2 начал этап: Дорога 40 метров
        Участник #2 закончил этап: Дорога 40 метров
        Участник #4 закончил этап: Дорога 40 метров
        ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!
*/


