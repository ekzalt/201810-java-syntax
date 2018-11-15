package patterns.singleton;

/*
Вариант 2: создать инстанст заранее -
классический шаблон IDE. Заранее может создать
довольно большой объект и заблокировать для него ресурсы.
 */

public class SingleTemplate {
    private static SingleTemplate instance = new SingleTemplate();

    private SingleTemplate() {}

    public static SingleTemplate getInstance() {
        return instance;
    }

    public void getType() {
        System.out.println("I am prepared singleton");
    }
}
