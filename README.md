#### [Task1](./src/vsu/pustoslov/task1/Task1.java)

10\) Известны длины сторон a, b, c треугольника.
Вычислить высоты этого треугольника.
***
#### [Task2](./src/vsu/pustoslov/task2/Task2.java)

14\) Проверить, можно ли вписать в треугольник 
со сторонами A, B, C круг с радиусом R 
(заодно проверить возможность существования такого 
треугольника).
***
#### [Task3](./src/vsu/pustoslov/task3)

>Условный оператор + функции + классы + перечисления 
>\+ декомпозиция задачи (разбиение на подзадачи) + формальный подход.

На изображениях ниже (для каждого варианта свое) приводится 
часть координатной плоскости (-10 <= x <= 10, -10 <= y <= 10) 
с графиками функций (парабола, линия) и фигурами (круг, прямоугольник). 
Размер одной клетки сетки – 1 (единица). 
Таким образом параметры функций и фигур 
можно однозначно определить из рисунка.

Области, на которые разбивается плоскость графиками и контурами фигур, 
закрашены разными цветами (белый, серый, желтый, оранжевый, голубой, зеленый). 
Необходимо реализовать программу, которая для точки (x, y) 
определяет цвет области, в которую данная точка попадает. 
Будем считать, что если точка (x, y) попадает на линию 
графика функции или контура фигуры, то правильным 
ответом будет цвет любой соседней области. 
Также стоит заметить, что некоторые комбинации линий 
предполагают их пересечение за пределами изображенного 
на рисунке фрагмента плоскости поэтому, 
чтобы исключить неопределенность ответа, 
допустимыми значениями (x, y) являются только такие, 
которые попадают в приведенное изображение.

В программе должна быть реализована функция (статический метод), 
которая для точки (x, y) возвращает 
цвет точки на изображении.

В методе Main необходимо для несколько заранее выбранных 
точек на рисунке (обязательно должны быть охвачены все области, 
на которые разбивается плоскость) распечатать результат, 
который возвращает getColor (и самостоятельно убедиться, 
что данная функция работает корректно). 
Также программа должна запрашивать координаты 
одной произвольной точки, и для нее 
таким же образом печатать результат.

![Number 9](https://sun9-45.userapi.com/Q_tWqBuWZsyr0XYnf2tbqAI4hMcvX4K5kFgTFA/8yhYHZewD-4.jpg)
***
#### [Task4](./src/vsu/pustoslov/task4/Task4.java)

27*\) Дано натуральное k. Напечатать k-ую цифру 
последовательности 12345678910111213…,
в которой выписаны подряд все натуральные числа.
Строки и массивы не использовать.
***
#### [Task5](./src/vsu/pustoslov/task5/Task5.java)

Напечатать в консоле следующую фигуру.

![Number9](https://sun9-30.userapi.com/X0lxDS7OFGvkduwDpAP-jC5BWdXK9VWS6l3q_w/sGU4nfHqcnQ.jpg)

Для печати реализовать отдельную функцию с параметрами.

Для различных вариантов могут быть заданы следующие параметры:

+ h – высота фигуры

+ w – ширина фигуры

+ s – размер фигуры

Для каждого варианта указаны допустимые значения данных параметров, 
а также в скобках приведены значения 
параметров для приведенного примера.

*Запрещено использовать строки, массивы, а также 
управлять курсором, можно только использовать циклы, 
условный оператор, а также Console.Write(...) и Console.WriteLine(…).*
***
#### [Task6](./src/vsu/pustoslov/task6)

При некоторых заданных x (допустимые значения x – интервал (-R, R)), 
n и e, определяемых вводом, вычислить:

1) сумму n слагаемых заданного вида;

2) сумму тех слагаемых, которые по абсолютной величине больше e;

3) сумму тех слагаемых, которые по абсолютной величине больше e/10;

4) значение функции с помощью методов Math.

При вычислениях необходимо выразить an (n-ый член ряда) 
как зависимость от n, an-1 и x, т.е. виде an = f(n, an-1, x). 
Другие варианты решения не принимаются.

Использовать только 1 цикл.

![Number_19](https://sun9-50.userapi.com/GvItSwr0nHVc6QsEuO7h2nmmK8jjfjp1mm8m0g/ZMNv2fOrfks.jpg)
***
#### [Task7](./src/vsu/pustoslov/task7)

13\) Вводится массив целых чисел. 
Посчитать количество элементов массива, 
больших или равных среднему арифметическому 
элементов массива, отличных от минимального 
(если все элементы массива одинаковые, то ответ – 0).

##### Важно!

+ Для вычислений использовать отдельную функцию solution 
(необходимые параметры и возвращаемое значение определяются 
условием конкретного варианта задачи). 
В некоторых задачах потребуются также дополнительные функции.

+ Заранее придумать не менее 10 различных тестов, 
охватывающих как типичные, так и все возможные граничные 
(наиболее невероятные и показательные) ситуации. 
Программа при запуске должна прогонять эти тесты 
(для каждого теста распечатывать входной массив и результат), 
а также предлагать пользователю задать произвольный массив 
в качестве входных данных.

+ Для ввода и, если необходимо, вывода одномерных массивов 
разработать отдельные функции.
***
#### [Task8](./src/vsu/pustoslov/task8)

17\) Создать новый квадратный двумерный массив 
из переданного двумерного массива, 
обрезав от последнего лишние строки или столбцы, 
т.е. такие, для которых нет соответствующих столбцов или строк.

##### Важно!

Входные данные для этой задачи должны читаться из текстового файла, 
а выходные – записываться в текстовый файл.
 
 Данная задача должна быть оформлена двумя способами:
 
 1) в виде консольного приложения с разбором параметров командной строки,
 
 2) в виде оконного приложения, где двумерный массив 
 можно задать в JTable. При этом должна быть возможность 
 загрузить данный из файла в JTable 
 (реализованная в виде двух функций: чтение данных из файла
 в двумерный массив и отображение двумерного массива в JTable),
 а также сохранить данные из JTable в файл (реализованная в виде двух 
 функций: чтение данных из JTable в двумерный массив 
 и запись двумерного массива в файл).
 
 *Функции, реализующие логику задачи и чтение 
 / запись данных из файлов / 
 в файлы, должны быть оформлены в виде отдельного модуля 
 (в отдельном файле). Этот модуль без каких-либо изменений должен использоваться в двух программах: с консольным
 интерфейсом
 (файлы для чтения / записи задаются в параметрах командной строки)
 и оконным интерфейсом.*

+ Заранее придумать не менее 5 различных тестов, охватывающих как типичные, так и все возможные граничные (наиболее
  невероятные и показательные) ситуации.
  (Сохранить в текстовых файлах input01.txt, input02.txt и т. д.)

+ Решение, естественно, должно быть оформлено в виде отдельной функции. В реализации обязательно использовать
  вспомогательные функции
  (в этой задаче, какие именно вспомогательные функции использовать, не расписано, вы должны самостоятельно решить,
  какие именно будут удобны для вашего варианта).

+ В данных задачах, если явно не оговорено иное, предполагается, что все строки двумерного массива имеют одинаковую
  длину, т.е. массив является прямоугольным. В реализации разрешено также использовать вместо прямоугольных массивов
  ступенчатые массивы
  (т.е. массивы массивов или списки списков). В этом случае необходимо дополнительно реализовать функцию проверки
  «прямоугольности» ступенчатого массива, которую применять для проверки корректности данных перед обработкой.

***

#### [Task9](./src/vsu/pustoslov/task9)

24\) Создать новый список из элементов переданного списка, которые встречаются чётное количество раз, взятых по одному
разу. Элементы должны располагаться в созданном списке в порядке их появления в переданном списке, если элементы
последнего просматривать с конца списка, например:

{7, 1, 17, 3, 10, 10, 5, 17, 5, 7, 8, 2, 3, 10, 4, 5, 3, 10, 5} превратится в {5, 10, 7, 17}

Реализовать в виде функции:
`public static List <Integer> createNewList
(List<Integer> list)`

Для удобства реализовать дополнительную функцию:
`public static int countOf (List<Integer> list, int value)`

##### Важно!

Входные данные для этой задачи должны читаться из текстового файла, а выходные – записываться в текстовый файл.

В файле каждый набор чисел (массив / список), а также другие параметры, если они предусмотрены условием задачи, должны
быть записаны на отдельной строке.

Данная задача должна быть оформлена двумя способами:

1) В виде консольного приложения с разбором параметров командной строки,

2) В виде оконного приложения, где двумерный массив можно задать в JTable. При этом должна быть возможность загрузить
   данный из файла в JTable
   (реализованная в виде двух функций: чтение данных из файла в двумерный массив и отображение двумерного массива в
   JTable), а также сохранить данные из JTable в файл
   (реализованная в виде двух функций:
   чтение данных из JTable в двумерный массив и запись двумерного массива в файл).

*Функции, реализующие логику задачи и чтение / запись данных из файлов / в файлы, должны быть оформлены в виде
отдельного модуля (в отдельном файле). Этот модуль без каких-либо изменений должен использоваться в двух программах:
с консольным интерфейсом (файлы для чтения / записи задаются в параметрах командной строки)
и оконным интерфейсом.*

+ Заранее придумать не менее 10 различных тестов, охватывающих как типичные, так и все возможные граничные (наиболее
  невероятные и показательные) ситуации.
  (Сохранить в текстовых файлах input01.txt, input02.txt и т. д.)
  Решение, естественно, должно быть оформлено в виде отдельной функции. В реализации обязательно использовать
  вспомогательные функции.


+ Запрещено использовать любые стандартные (уже реализованные в библиотеке языка Java)
  функции и методы массивов и списков (за исключением создания списка, получения размера и добавления нового элемента).
  Аналоги стандартных функций необходимо реализовать
  (какие – для каждого варианта указано отдельно).

***

#### [Task10](./src/vsu/pustoslov/task10)

26\) Прайс-лист содержит следующую информацию о планшетах: название модели, объем памяти, рейтинг модели среди
пользователей (цифра от 1 до 5), стоимость. У вас есть N денег, вам необходимо купить самый хороший планшет, на который
вам хватит денег. Для вас приоритетным является объём памяти, в случае одинакового объема – рейтинг модели. Если
подходящих моделей будет несколько, вы выберете Samsung или Asus (присутствует в названии модели), а затем все
остальные. Если по этим критериям вам подходят несколько моделей – выбирайте любой.

Входные данные соответствуют предыдущей задачи (см. текст выше), однако теперь вам надо купить K самых дешевых планшетов
с объемом памяти не ниже M и рейтингом не ниже R (призы победителям олимпиады). Какой планшет вы выберете, и сколько
денег вы потратите?

##### Важно!

В задаче обязательно использовать свои (описанные в вашей программе) составные типы данных (структуры или классы). Для
представления набора объектов лучше использовать списки (массивы также допустимы, но менее удобны для данной задачи).

##### Данная задача должна быть оформлена двумя способами:

1) в виде консольного приложения;

2) в виде оконного приложения, где массив объектов можно задать в JTable. При этом должна быть возможность загрузить
   данный из файла в JTable (реализованная в виде двух функций: чтение данных из файла в двумерный массив и отображение
   двумерного массива в JTable), а также сохранить данные из JTable в файл (реализованная в виде двух функций:
   чтение данных из JTable в двумерный массив и запись двумерного массива в файл).

+ Функции, реализующие логику задачи и чтение / запись данных из файлов / в файлы, должны быть оформлены в виде
  отдельного модуля (в отдельном файле). Этот модуль без каких-либо изменений должен использоваться в двух программах:
  с консольным интерфейсом (файлы для чтения / записи задаются в параметрах командной строки) и оконным интерфейсом.
  

+ Данные в файлах должны храниться в следующем виде: каждая отдельная строка описывает отдельный объект. Соответственно
  строки состоят из нескольких элементов (чисел, строк), каждый из которых описывает отдельный атрибут объекта.
  Например, набор линий вида ax + by + c = 0 будет храниться в текстовом файле в следующем виде:

  4 5 4

  10 2 12

  5 34 23

  и т.д.

  где каждая строка описывает отдельную линию с параметрами a, b, c.

*Заранее придумать не менее 5 различных тестов, охватывающих как типичные, так и все возможные граничные
(наиболее невероятные и показательные) ситуации. (Сохранить в текстовых файлах input01.txt, input02.txt и т. д.)*

Решение, естественно, должно быть оформлено в виде отдельной функции. В реализации обязательно использовать
вспомогательные функции примерно так же, как в предыдущих Задачах № 8 - 9 (в этой задаче, какие именно вспомогательные
функции использовать, не расписано, вы должны самостоятельно решить, какие именно будут удобны для вашего варианта).

***

#### [Task11](./src/vsu/pustoslov/task11)

15\) Написать функции представления арабского числа римским и наоборот. Арабские числа представлять целочисленным типом
данных, римские — строкой.