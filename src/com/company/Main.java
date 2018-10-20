package com.company;

import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello world");

        /*
        типы чисел
        byte - 8 bit, -128-127
        short - 16 bit, -32768-32767
        int - 32 bit, -2147483648-2147483647
        long - 64 bit, -9223372036854775808-9223372036854775807
        float - 32 bit (float f = 1.2f;)
        double - 64 bit (double d = 1.2;)

        типы строк
        char - 1 символ, 16 bit unicode (char sym = 'H';)
        String (String str = "Hello";)

        логические значения
        boolean
        */

        // преобразование типов
        byte b = 10;
        b = (byte) (b + 1);
        System.out.println(b);

        /*
        // чтение из cli
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        */

        /*
        if (result == 0) {
            System.out.println("no result");
        } else {
            System.out.println(result);
        }
        */

        /*
        switch (result) {
            case 0:
                System.out.println("no result");
                break;
            default:
                System.out.println(result);
        }
        */

        int month = 12;
        int salary = 2000;
        int bonus = 1000;

        int total = month == 12 ? salary + bonus : salary;

        System.out.println(total);

        /*
        циклы
        while () {}
        do {} while ();
        for () {}
        */

        // инициализация массива
        int[] nums1 = new int[] {1, 2, 3};
        int nums2[] = new int[] {10, 20, 30};
        int[] nums3 = {100, 200, 300};
        int[] nums4 = new int[4]; // длинна

        System.out.println(Arrays.toString(nums1));

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nums1[i] * nums1[i];
        }

        System.out.println(Arrays.toString(nums1));

        // многомерные массивы
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(matrix[1][1]);

        Employee employee = new Employee("Vasya", "Pupkin");
        employee.work(3);

        Person person = new Person(1, "John", "Smith");
        person.changeId();

        Developer developer = new Developer(5, "Pit", "Wood");
        developer.changeId();

        /*
        // использование вложенных инстансов
        Computer comp = new Computer();
        comp.i7.start();
        comp.ddr4.add();
        */

        // создание анонимных классов, как способ инкапсуляции свойств-инстансов
        new Computer() {
            public void start() {
                this.i7.start();
                this.ddr4.add();
            }
        }.start();

        // истанс от класса наследованного от абстрактного
        ShapeCircle circle = new ShapeCircle();
        circle.draw();
        // перегрузка метода
        circle.draw("white");

        // static - статические свойства и методы Класса

        /*
        final
        для свойств - невозможность ре-инициализации (создает константу)
        для методов - невозможность переопределить
        для классов - невозможность наследования
        */

        // в java массивы статической длинны,
        // если нужен расширяющися массив - используем ArrayList
        // быстрее при поиске и чтении
        ArrayList<Integer> arrDyn = new ArrayList<>();
        arrDyn.add(10);
        arrDyn.add(20);
        arrDyn.add(30);
        // arrDyn.remove(idx);
        // arrDyn.size();
        // arrDyn.clear();

        // аналог for...in (PHP, Python), for...of (JS)
        for (Integer value: arrDyn) System.out.println(value);

        // LinkedList - связный список
        // быстрее при добавлении

        // обработка исключений
        try {
            int n = 100 / 0;
        } catch (ArithmeticException error) {
            System.out.println(error);
        } catch (Exception error) {
            // можно добавлять множественные типы и общую ошибку Exception
            System.out.println(error);
        } finally {
            // опциональный блок
            System.out.println("finally block");
        }

        // запись/чтение файла
        FileWorker fileWorker = new FileWorker("./example_1.txt");
        fileWorker.writeFile();
        fileWorker.readFile();

        // работа с потоками

        // 1. наследование
        Thread thread1 = new ThreadWorker();
        // 2. имплементация
        Thread thread2 = new Thread(new ThreadRunner());
        // 3. анонимный класс
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) System.out.println("Thread anon " + i);
            }
        });
        // вызываем start - это создаст поток и вызовет run
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
