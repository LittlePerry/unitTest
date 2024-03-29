# Написать UI-автотесты

---
__Кейс 1 Разница двух целых чисел__
1. Открыть сайт https://testsheepnz.github.io/BasicCalculator.html
2. Проскроллить вниз до конца  
3. Выбрать сборку (Build) «Prototype»
4. Ввести в поле First number значение «2»
5. Ввести в поле Second number значение «3»
6. Выбрать операцию (Operation) «Subtract»
7. Нажать на кнопку «Calculate»
8. Проверить, что в поле ответа (Answer) значение равно «-1»
---
__Кейс 2 Конкатенация двух строк.__
1. Открыть сайт https://testsheepnz.github.io/BasicCalculator.html 
2. Проскроллить вниз до конца
3. Выбрать сборку (Build) «Prototype»
4. Ввести в поле First number значение «gs»
5. Ввести в поле Second number значение «bu»
6. Выбрать операцию (Operation) «Concatenate»
7. Нажать на кнопку «Calculate»
8. Проверить, что в поле ответа (Answer) значение равно «gsbu»
---
__Кейс 3 Появление сообщения при вводе строки в поле__
1. Открыть сайт https://testsheepnz.github.io/random-number.html 
2. Проскроллить вниз до конца
3. Выбрать сборку (Select Build) «Demo»
4. Нажать на кнопку «Roll the dice»
5. Ввести в поле значение «string»
6. Нажать на кнопку «Submit»
7. Проверить, что появилось сообщение «string: Not a number!»
---
Данные тесты были написаны и запускались из среды разработки IntelliJ IDEA.
Данный проект состоит из:
* chromedriver
    > Драйвер для запуска тестов в браузере Chrome.
    >> Браузер должен быть не ниже версии 89.0.4389.114.
* src\test\java\io\github\testsheepnz
    > Тут находятся сами тесты.
* CalculatePage
    > Содержит все элементы калькулятора, такие как, поля для ввода, кнопки и т.д.
* RollDicePage
    > Содержит все элементы страницы Roll the dice
* SubtractTest
    > Содержит тесты калькулятора, с 1-го по 2-ой кейс
* DiceTest
    > Содержит тесты страницы с костями
* ConfProperties
    > Класс для чтения записей в файле conf.properties, который находится по пути "src\test\resources".
    >> Данный файл содержит параметры, которые, для удобства, были вынесены в отдельный файл (название страницы, путь для chromedriver и т.д).

Данные тесты можно запускать, как сразу все (клик по классу и Run), так и по отдельности.
Информация о прохождении теста указана в консоли IntelliJ IDEA.
Стек технологий который мною был выбран:
* Java
* Junit
* Maven
* Selenium
* PageObject
---
