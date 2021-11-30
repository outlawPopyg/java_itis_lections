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
Замена в коде экземляров классов на экземпляры их подклассов (наследников) не должна влиять на правильность работы программы. *По простому*: Ф-ии, которые используют ссылки на базовые, должны иметь возможность использовать объекты подклассов, не зная об этом.