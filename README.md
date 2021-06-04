# apps20liubas-hw1
Дане завдання призначене для роботи з масивами, циклами та умовними конструкціями. А також для ознайомлення зі стандартним циклом розробки з використанням системи контролю версій GitHub та системи постійної сборки (Continuous Integration - CI). 
Система постійної сборки (CI) призначена для аналізу якості вихідного коду, його компіляції, та запуску тестів. Код для сборки CI бере з репозиторію. Даний підхід є обов'язковий при командній роботі над проектом.

Інструкція:
Скачайте архів з шаблоном проекту TemperatureSeries та розархівуйте його 
Додайте його в локальний Git репозиторій
Перейдіть в командному рядку до директорії TemperatureSeries
Виконайте команди:
> git init 
> git add *
> git commit -m "TemperatureSeries initial commit"
Створіть на своєму GitHub новий репозиторій з іменем за наступним шаблоном apps20<surname>-hw1 (наприкад apps20dobosevych-hw1)
Знову перейдіть в директорію TemperatureSeries і виконайте наступну команду 
> git remote add origin https://github.com/<user_name>/apps20<surname>-hw1.git (наприклад,
git remote add origin https://github.com/dobosevych/apps20dobosevych-hw1.git
)
Виконайте команду 
> git push -u origin master

Після цього може відкрити проект в IDE і почати виконувати завдання

Важливо: https://github.com/dobosevych/apps20dobosevych-hw1.git

не змінюйте структуру шаблоного проекту та не видаляйте файли checkstyle.xml, pom.xml
класи які необхідно редагувати під час виконання завдання:
TemperatureSeries/src/main/java/ua/edu/ucu/tempseries/TemperatureSeriesAnalysis.java
TemperatureSeries/src/main/java/ua/edu/ucu/tempseries/TempSummaryStatistics.java
TemperatureSeries/src/test/java/ua/edu/ucu/tempseries/TemperatureSeriesAnalysisTest.java
при коміті проекту в локальний репозиторій (та на GitHub) необхідно щоб виключно були закомічені: src/, checkstyle.xml, pom.xml. Директорію target/, яка буде створена під час компіляції комітити не треба.

Завдання:
Реалізувати наступні методи для класу TemperatureSeriesAnalysis по роботі з рядом значень температур. 
Написати тести у TemperatureSeriesAnalysisTest.java (по аналогії з тими що є у прикладі) для перевірки коректності реалізованих методів.

Опис методів наведено нижче.

- double average()
Обчислює середнє значення температури. Якщо ряд порожній, генерує IllegalArgumentException.

- double deviation()
Обчислю середньоквадратичне відхилення. Якщо ряд порожній, генерує IllegalArgumentException.

- double min()
Повертає мінімальну температуру. Якщо ряд порожній, генерує IllegalArgumentException.

- double max()
Повертає максимальну температуру. Якщо ряд порожній, генерує IllegalArgumentException.

- double findTempClosestToZero()
Повертає значення температури найближче до 0. Якщо ряд порожній, генерує IllegalArgumentException.
Якщо у ряді є декілька значень однаково наближених до 0 (наприклад -0.2 і 0.2), то повертається додатнє значення (тобто 0.2)

- double findTempClosestToValue(double tempValue)
Аналогічно попередньому методі, тільки повертається значення найближче до заданого tempValue

- double[] findTempsLessThan(double tempValue)
Повертає масив зі значеннями температури менше заданого tempValue.

- double[] findTempsGreaterThan(double tempValue)
Повертає масив зі значеннями температури більше або рівне заданому tempValue.

- TempSummaryStatistics summaryStatistics()
Повертає immutable екземпляр классу TempSummaryStatistics в якому міститься інформація:
- double avgTemp;
- double devTemp;
- double minTemp;
- double maxTemp;
Якщо ряд порожній, генерує IllegalArgumentException.

- int addTemps(double ... temps)
Додає в кінець ряду вже існуючих даних нові значення температур, і повертає сумарне число значень температур. Структура (масив) в класі TemperatureSeriesAnalysis для зберігання вже переданих температур повинна збільшуватися в 2 рази, якщо в ній немає місця для зберігання нових значень.

Додаткові вимоги:
клас TemperatureSeriesAnalysis повинен мати конструктор за замовченням та конструктор з параметром який приймає початковий ряд температур
якщо в переданому ряді температур, зустрічається хоча б одне значення менше ніж -273С, то все значення з даного ряду не повинні додаватися до основного ряду і має генеруватись InputMismatchException (throw new InputMismatchException())
при реалізації не використовувати динамічні масиви (ArrayList) і зв'язані списки (LinkedList)
