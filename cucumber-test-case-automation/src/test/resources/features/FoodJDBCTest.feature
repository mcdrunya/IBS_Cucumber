# language: ru

@db
@all
@AddFoodJDBC
Функция: Добавление товара в БД через JDBC


  @correct
  Сценарий: Добавление товара
    * отображается таблица "FOOD"
    * пользователь добавляет продукт "Apple" типа "Fruit" и "false"
    * отображается добавленный продукт "Apple" типа "Fruit" и "false"
    * пользователь удаляет продукт "Apple" типа "Fruit" и "false"
    * продукт "Apple" типа "Fruit" и "false" был удален


