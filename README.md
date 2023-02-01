[![Build status](https://ci.appveyor.com/api/projects/status/nlyenh8svptif86o?svg=true)](https://ci.appveyor.com/project/npetyaeva/javalessonpatterns)

### Модуль «Автоматизированное тестирование»

# Заказ доставки карты (изменение даты)

Необходимо автоматизировать тестирование новой функции формы заказа доставки карты:

Требования к содержимому полей:
- Город - один из административных центров субъектов РФ
- Дата - не ранее трёх дней с текущей даты
- Поле Фамилия и имя - разрешены только русские буквы, дефисы и пробелы
- Поле телефон - только цифры (11 цифр), символ + (на первом месте)
- Флажок согласия должен быть выставлен

Тестируемая функциональность: если заполнить форму повторно теми же данными за исключением "Даты встречи", то система предложит перепланировать время встречи.

