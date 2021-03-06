# Learn Java SE

```bash

# jar java runner
java

# java compiler
javac

# show all java proceses
jcmd

# get report by prosess id to file
jstack <pid> <report.info>

```

## Programs

- [SceneBuilder](https://gluonhq.com/products/scene-builder/)

## Maven

[Maven](http://maven.apache.org/)

### Maven packages

[Maven search](https://search.maven.org/)

- [jackson-databind](https://github.com/FasterXML/jackson-databind) JSON parser/generator

## Gradle

[Gradle](https://gradle.org/)

## Web development (java back-end)

- [Netty](https://netty.io/) is an asynchronous event-driven network application framework
- [Undertow](http://undertow.io/) is a flexible performant web server written in java
- [FreeMarker](https://freemarker.apache.org/) is a template engine
- [OkHttp](http://square.github.io/okhttp/) HTTP & HTTP/2 client for Android and Java applications
- [Spring](http://spring.io/) Spring projects
- [Hibernate](http://hibernate.org/) Java ORM/ODM
- [JDK Documentation](https://docs.oracle.com/en/java/javase/11/) Oracle Java Documentation

## Design Patterns

Принципы OOD (объектно-ориентированного проектирования):
- инкапсулируйте все, что изменяется
- класс должен иметь только одну причину для изменения
- предпочитайте композицию наследованию
- программируйте на уровне интерфейсов
- стремитесь к слабой связанности взаисодействующих субъектов
- *Принцип минимальной информированности* (Закон Деметры) - общайтесь только с *близкими друзьями*. Объекты не должны знать внутренние зависимости и структуру своих компонентов.
- *Голливудский принцип* - не вызывайте нас, мы вас сами вызовем
- *Open Closed Principle*, классы должны быть открыты для расширения, но закрыты для изменения
- *Dependency Inversion Principle*, код должен зависеть от абстракций, а не от конкретных классов

### Strategy

Strategy Pattern `./src/patterns/strategy`

*Стратегия* определяет семейство алгоритмов, инкапсулирет каждый из них, обеспечивает им взаимозаменяемость, позволяет модифицировать алгоритмы независимо от их использования клиентом.

### Observer

Observer Pattern `./src/patterns/observer`

*Наблюдатель* определяет отношение "один ко многим" между объектами так, что при изменении состояния одного объекта (наблюдаемого), происходит оповещение и обновление всех зависимых объектов (наблюдателей).

### Decorator

Decorator Pattern `./src/patterns/decorator`

*Декоратор* динамически наделяет объект новыми возможностями, является гибкой альтернативой наследованию в области расширения функциональности.

### Factory

Factory Pattern `./src/patterns/factory`

*Абстрактная фабрика* предоставляет интерфейс для создания семейств взаимосвязанных объектов без указания их конкретных классов.

*Фабричный метод* определяет интерфейс создания объекта, но позволяет субклассам выбрать создаваемый экземпляр.

### Singleton

Singleton Pattern `./src/patterns/singleton`

*Одиночка* гарантирует, что класс имеет только один экземпляр, и предоставляет глобальную точку доступа к этому экземпляру.

Будьте внимательны при использовании загрузчиков классов! Они могут привести к созданию нескольких экземпляров.

### Command

Command Pattern `./src/patterns/command`

*Команда* инкапсулирует запрос в виде объекта, делая возможной параметризацию клиентских объектов с другими запросами, организацию очереди, регистрацию запросов, поддержку отмены операций.

### Adapter

Adapter Pattern `./src/patterns/adapter`

*Адаптер* преобразует один интерфейс класса к другому интерфейсу, на который расчитывает клиент. Адаптер обеспечивает совместную работу классов, невозможную в обычных условиях из-за несовместимости интерфейсов.

### Facade

Facade Pattern `./src/patterns/facade`

*Фасад* предоставляет унифицированный интерфейс к группе интерфейсов подсистемы. Фасад определяет высокоуровневый интерфейс, упрощающий работу с подсистемой.

### Template method

Template method Pattern `./src/patterns/template`

*Шаблонный метод* определяет "скелет" алгоритма в методе, оставляя определение реализации некоторых шагов субклассам. Субклассы могут переопределять некоторые части алгоритма без изменения его структуры.

### Iterator

Iterator Pattern `./src/patterns/iterator`

*Итератор* предоставляет механизм последовательного перебора элементов коллекции без раскрытия ее внутреннего представления.

### Composer

Composer Pattern `./src/patterns/composer`

*Компоновщик* объединяет объекты в древовидные структуры для представления иерархий "часть/целое". *Компоновщик* позволяет клиенту выполнять однородные операции с отдельными объектами и их совокупностями.

### State

State Pattern `./src/patterns/state`

*Состояние* управляет изменением поведения объекта при изменении его внутреннего состояния. Внешне это выглядит так, словно объект меняет свой класс.

### Proxy

Proxy Pattern `./src/patterns/proxy`

*Заместитель* предоставляет суррогатный объект, управляющий доступом к другому объекту.

Виды:
- *Удаленный Заместитель* управляет доступом у удаленному объекту.
- *Виртуальный Заместитель* управляет доступом к ресурсу, создание которого требует больших затрат ресурсов или времени.
- *Защитный Заместитель* контролирует доступ к ресурсу в соответствии с системой привилегий.
