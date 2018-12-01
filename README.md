# Learn Java 8 SE

[SceneBuilder](https://gluonhq.com/products/scene-builder/)

## Design Patterns

Принципы OOD (объектно-ориентированного проектирования):
- инкапсулируйте все, что изменяется
- предпочитайте композицию наследованию
- программируйте на уровне интерфейсов
- стремитесь к слабой связанности взаисодействующих субъектов
- *Open Closed Principle*, классы должны быть открыты для расширения, но закрыты для изменения
- *Dependency Inversion Principle*, код должен зависеть от абстракций, а не от конкретных классов
- *Принцип минимальной информированности* (Закон Деметры) - общайтесь только с *близкими друзьями*. Объекты не должны знать внутренние зависимости и структуру своих компонентов.
- *Голливудский принцип* - не вызывайте нас, мы вас сами вызовем.

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

Command Pattern `./src/patterns/adapter`

*Адаптер* преобразует один интерфейс класса к другому интерфейсу, на который расчитывает клиент. Адаптер обеспечивает совместную работу классов, невозможную в обычных условиях из-за несовместимости интерфейсов.

### Facade

Command Pattern `./src/patterns/facade`

*Фасад* предоставляет унифицированный интерфейс к группе интерфейсов подсистемы. Фасад определяет высокоуровневый интерфейс, упрощающий работу с подсистемой.

### Template method

Template method Pattern `./src/patterns/template`

*Шаблонный метод* определяет "скелет" алгоритма в методе, оставляя определение реализации некоторых шагов субклассам. Субклассы могут переопределять некоторые части алгоритма без изменения его структуры.
