# Learn Java 8 SE

[SceneBuilder](https://gluonhq.com/products/scene-builder/)

## Design Patterns

Принципы OOD (объектно-ориентированного проектирования):
- инкапсулируйте все, что изменяется
- предпочитайте композицию наследованию
- программируйте на уровне интерфейсов
- стремитесь к слабой связанности взаисодействующих субъектов
- Open/Closed, классы должны быть открыты для расширения, но закрыты для изменения

### Strategy

Strategy Pattern `./src/patterns/strategy`

*Стратегия* определяет семейство алгоритмов, инкапсулирет каждый из них, обеспечивает им взаимозаменяемость, позволяет модифицировать алгоритмы независимо от их использования клиентом.

### Observer

Observer Pattern `./src/patterns/observer`

*Наблюдатель* определяет отношение "один ко многим" между объектами так, что при изменении состояния одного объекта (наблюдаемого), происходит оповещение и обновление всех зависимых объектов (наблюдателей).

### Decorator

Decorator Pattern `./src/patterns/decorator`

*Декоратор* динамически наделяет объект новыми возможностями, является гибкой альтернативой наследованию в области расширения функциональности.
