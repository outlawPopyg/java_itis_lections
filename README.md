## Проблемы дублирования кода
Влияющая на сложность:
```java
if (x * x - 2 * x > 5 - x) {
	System.out.println(x * x - 2 * x);
} else {
   	System.out.println(5 - x);
}

// Лучше так
int a = x * x - 2 * x;
int b = 5 - x;
int max = a > b ? a : b;
```
Не влияющая на сложность:
```java
// n!! (1*3*5) если n нечет (2*4*6) если n чет
// типичное решение:
int n = 1;
if (n % 2 == 0) {
    int p = 1;
    for (int i = 2; i < n; i+= 2) {
        p *= i;
    }
} else {
    int p = 1;
    for (int i = 1; i < n; i += 2) {
        p *= 1;
    }
}

// Как правильнее:
int p = 1;
for (int i = 2 - n % 2; i <= n; i += 2) {
    p *= i;
}

// Или так:
int p = 1;
while (n >= 1) {
    p *= n;
    n -= 2;
}

```
Дублирование абсолютно одинакового кода - решается занесением под один цикл!


## Сложность алгоритмов
- O(1) - const
- O(n) - linear
- O(n^c) - polinom, c - const
- O(c^n) - exponentional, c - const
- O(log n) - log
___

Бинарный поиск
```java
public static int search(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        int mid;

        while (left <= right) {
            mid = (right-left) / 2 + left;

            if (target == a[mid]) {
                return mid;
            } else if (a[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
```

Мемоизация ( посчитать сумму факториалов - `1! + 2! + ... + n!`)

```java

// Так плохо!
public static int badSum(int n) {
    int s = 0;
    for (int i = 1; i <= n; i++) {
        int p = 1;
        for (int j = 1; j <= i; j++) {
            p *= j;
        }
        s += p;
    }
    return s;
}

// Так довольна таки неплохо
public static int sum(int n) {
    int s = 0;
    int p = 1;
    for (int i = 1; i <= n; i++) {
        // memoization
        p *= i;
        s += p;
    }

    return s;
}
```

## Потоковая обработка (сложность по памяти)
Потоковая обработка данных  – ситуация, когда решение в реальном времени обрабатывает данные, которые поступают также в реальном времени, в формате потока, генерируются непрерывно. В потоке сложно определить полный и целостный набор данных. Обычно компании не имеют возможности хранить такие данные в полном объёме, произвольный доступ к ним есть не всегда.
**Пример: сумма n чисел**
Не нужно хранить все входные данные в процессе работы (например в массиве)

## Двумерные массивы
Пример - таблица умножения
```java
int[][] multiply = new int[10][10];

for (int i = 0; i < 10; i++) {
    for (int j = 0; j < 10; j++) {
        multiply[j][i] = (i + 1) * (j + 1);
    }
}

for (int[] a : multiply) {
    System.out.println(Arrays.toString(a));
}
```

Ступенчатый массив
```java
int[][] a = new int[5][];
for (int i = 0; i < 5; i++) {
    a[i] = new int[5 - i];
}

for (int[] i : a) {
    System.out.println(Arrays.toString(i));
}
```
out: 
[0, 0, 0, 0, 0]
[0, 0, 0, 0]
[0, 0, 0]
[0, 0]
[0]

## Предикаты
```java
public static boolean check(int[] a) {
    for (int j : a) {
        if (j == 0) {
            return true;
        }
    }
    return false;
}

public static void main(String[] args) {
    int[] a = { 1, 2, 3, 0, -1};
    boolean flag = false;

    for (int i = 0; i < a.length && !flag; i++) {
        if (a[i] == 0) {
            flag = true;
        }
    }

    System.out.println(flag ? "Yes" : "No");

}
```

## Рекурсия
```java
public class Recursion {

    public static int rec(int x) {
        if (x == 1) {
            return x;
        }

        return x + rec(x - 1);
    }
    /*
    rec(5)
    5 + rec(4)
    5 + (4 + rec(3))
    5 + (4 + (3 + rec(2)))
    5 + (4 + (3 + (2 + rec(1))))
    5 + (4 + (3 + (2 + 1)))
    15 */

    public static int tailRec(int x, int runningTotal) {
        if (x == 0) {
            return runningTotal;
        }

        return tailRec(x-1, runningTotal + x);
    }

//    tailRec(5, 0)
//    tailRec(4, 5)
//    tailRec(3, 9)
//    tailRec(2, 12)
//    tailRec(1, 14)
//    tailRec(0, 15)
//    15

    public static void main(String[] args) {
        System.out.println(rec(5)); // 15
        System.out.println(tailRec(5, 0));
    }
}
```




## 1
```java
class Player {
	int hp;
	String name;
	String battleCry;

	// Что-то вроде параметров по умолчанию
	Player(String name) {
		this(name, "Lerroy Jenkins");
	}

	Player(String name, String battleCry) {
		hp = 100;
		this.name = name;
		this.battleCry = battleCry;
	}
}
```
## 2
```java
public class OOP2 {

	public void printA(int n) {
		System.out.println("A");
	}

	public static void main(String[] args) {
		printA(10); // Нельзя !
	}
}

// либо так
public class OOP2 {
	public static void printA(int n) {
		System.out.println("A");
	}

	public static void main(String[] args) {
		printA(10); // Нельзя !
	}
}


// либо так
public class OOP2 {

	public void printA(int n) {
		System.out.println("A");
	}

	public static void main(String[] args) {
		OOP2 x = new OOP2();
		x.printA(10); 
	}
}
```

### Если final class то от него нельзя наследоваться
### Если final у метода, то его нельзя переопределять в потомках

## 3
- Класс `Phone`, метод `call`
- Класс `SmartPhone` наследует `Phone`, переопределенный метод `call`, метод `takePhoto()`
```java
class Human {
	public void callWith(Phone p) {
		p.call();
	}
}

SmartPhone p = new SmartPhone();
Human h = new Human();
h.callWith(p);
```
- p.call() - сработает
- p.takePhoto() - нет

### Восходящее преобразование 
- Сужение интерфейса потомка до интерфейса родителя
- `Phone` p = new `SmartPhone()`;

## SOLID
### 1. разделение ответственности
У каждого ПО есть такая вещь как ось изменений - то есть те поля, методы, функции, которые постоянно меняются.
Если вы работаете на проекте, то вы с легкостью можете назвать эти классы, ф-ии и тд которые постоянно меняются.
Говорят, что ось изменений проходит через вот эти классы, ф-ии и тд. Принцип SRP говорит, что через ваш класс
проходит только одна ось изменеий. То есть ваш класс должен содержать поля и методы, относящиеся к одному вопросу.
Пример: Мы написали класс DataTemperature, у которого есть методы для работы со временем и температурой. К нам 
приходит Вася и говорит: "Мне нужно написать класс для работы со временем, можешь дать свой класс?". Мы отвечаем,
что в нашем классе есть и методы для измер-ия температуры. И Вася вырезает только то, что ему нужно. Теперь к нам 
приходит Петя и просит то же самое только ему нужно написать класс для изм-ия температуры. Он тоже вырезает некоторые
поля и методы. Затем мы отдаем тестировщикам класс, они находят кучу багов, мы их фиксим, но наши изменения не попадут
в классы Пети и Васи. А в их классах могут быть и ошибки, которые они собственноручно сделали. Правильно было написать
два разных класса: Data и Temperature. И создать DataTemperature который наследовался от этих двух.
</br>
![Иллюстрация](srp.png) 

### 2. классы открыты для расширения и закрыты для модификации
```java
// 2005
interface UserContacts {
	String getEmail();
	String getPhoneNumber();
}
// 2007
class User implements UserContacts {
	String getEmail() {...}
	String getPhoneNumber() {...}
}
// 2010
interface UserContacts {
	String getEmail();
	String getPhoneNumber();
	String getVKURL();
}
``` 
Скомиплированный в .class класс User (2007 год): у меня нет метода getVKURL()
### 3. Принцип подстановки Барбары Лисков
Замена в коде экземляров классов на экземпляры их подклассов (наследников) не должна влиять на правильность работы программы. **По простому**: Ф-ии, которые используют ссылки на базовые, должны иметь возможность использовать объекты подклассов, не зная об этом. То есть наследник не должен сужать возможности родителя.
```java
import java.util.*;

// Пример нарушение принципа Барбары Лисков


abstract class Shape {
	int height;
	int width;
	public abstract int square();
}

class Rectangle extends Shape {
	
	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int square() {
		return this.height * this.width;
	}
}

class Square extends Shape {
	
	public void setSide(int side) {
		this.height = side;
		this.width = side;
	}

	public int square() {
		return this.height * this.height;
	}
}

public class Liskov {
	public static void main(String[] args) {
		Rectangle rect = new Rectangle();
		rect.setWidth(10);
		rect.setHeight(4);
		System.out.println(rect.square());
	}
}

// из этого примера делаем вывод, что в меняя Rectangle на Square мы не добъемся
// желаемого результата а следовательно не можем использовать квадрат как наследник
// прямоугольника не меняя клиентский код
```
### 4. Принцип разделения интерфейса
Много интерфейсов, предназначенных для разных пользователей ( других классов ) лучше одного большого интерфейса, в который свален весь функционал.
```java
interface ISmartPhone {
	void call();
	void sendMessage();
	void makePhoto();
}
// домашний телефон
class LandPhone implements ISmartPhone {
	void call() {...} // реализовали
	void sendMessage() {} // домашний телефон не умеет отправлять смс
	void makePhoto() {} // и делать фотографии тоже не умеет
}
```
Как правильно
```java
interface ICall {
	void call();
}

interface ISendMessage {
	void sendMessage();
}

interface IMakePhoto {
	void makePhoto();
}

interface ISmartPhone extends ICall, ISendMessage, IMakePhoto {}

// домашний тел
class LandPhone implements ICall {
	void call() {...}
}
```
## Yet another "I" ;)
**interface segregation principle**
Клиенты не должны зависеть от методов, которые они не используют.

Принцип разделения интерфейсов говорит о том,
что слишком «толстые» интерфейсы необходимо разделять
на более маленькие и специфические, чтобы клиенты маленьких
интерфейсов знали только о методах, которые необходимы им в работе. В итоге, при изменении метода интерфейса не должны меняться клиенты, которые этот метод не используют.
```java
interface Shapable {
	public int area(); // площадь
	public int volume(); // объем
}

class Square implements Shapable {
	public int area() {
		// height * width
	}

	public int volume() {
		// нельзя найти объем у квадрата
	}
}

class Cuboid implements Shapable {
	public int area() {
		// вычисление площади пов-ти
	}

	public int volume() {
		// объем
	}
}

// метод volume в square и есть нарушение принципа. Класс зависит
// от метода

interface IArea {
	public int area(); // площадь
}

interface IVolume {
	public int volume(); // объем
}

class Square implements IArea {
	public int area() {
		// height * width
	}

	// теперь не зависит
}

class Cuboid implements IArea, IVolume {
	public int area() {
		// вычисление площади пов-ти
	}

	public int volume() {
		// объем
	}
}
```
### 5. Принцип инверсии зависимости 
Зависимости классов должны опираться на абстракции. Зависимости не должны опираться на конкретную реализацию. `Программируйте на уровне интерфейсов`