# lab01
## 1) Concepts of encapsulation, inheritance, and polymorphism
1. Encapsulation: Encapsulation is the concept of bundling data and methods that operate on that data within a single unit, typically a class. It restricts direct access to some of an object's components, which can prevent the accidental modification of data. In java, encapsulation is achieved using access modifiers like private, protected, and public.
2. - mutator methods (setters) to modify private fields
   - accessor methods (getters) to retrieve private fields <br> 
3. - this : A keyword in Java that refers to the current object.
   - super : A keyword in Java that refers to the parent class of the current object.
4. Inheritance: Inheritance is a mechanism in which a new class called a subclass inherits properties and behavior  from an existing class called a superclass or parent class. It is implemented using the keyward "extends" in Java.
5. Polymorphism: Polymorphism is the ability of a single function or method to operate in different ways based on the object that it is acting upon. In Java, polymorphism is mainly achieved through method overriding and method overloading. The three types of polymorphism are:
   - Compile-time polymorphism (method overloading)
   - Runtime polymorphism (method overriding)
   - parametric polymorphism
6. The relation between inheritance and subtype polymorphism is that inheritance allows a subclass to inherit methods and properties from a superclass, enabling the subclass to be treated as an instance of the superclass. This allows for polymorphic behavior, where a method can operate on objects of different classes that share a common superclass.
## 3) Constructors, factory methods and singletons
### 1. Object Initialization Process

1. **Memory Allocation**  
   Memory is allocated for the object, and all instance variables are initialized to their default values:
   - Numeric types (`int`, `double`, etc.): `0` or `0.0`
   - `char`: `'\u0000'`
   - `boolean`: `false`
   - Object references: `null`

2. **Static Initialization**
   - Static variables and static constants are initialized in the order they are declared in the class.
   - Static blocks are executed in the order they appear in the class.
   - This happens only once, the first time the class is loaded.

3. **Superclass Initialization**
   - The constructor of the superclass (`Object` or another parent class) is called.
   - If not explicitly specified, the default constructor is invoked implicitly.

4. **Instance Variable Initialization**
   - Instance variables are initialized to their default values (if not already initialized in the declaration).

5. **Anonymous Blocks**
   - Anonymous (non-static) blocks are executed in the order they appear in the class.
   - These blocks can access instance variables and methods.

6. **Constructor Execution**
   - The constructor of the class is executed.
   - If the constructor explicitly calls another constructor (using `this()` or `super()`), that call is executed first.
   - The constructor can override the default values of instance variables.
### 2. Inheritance tree and Constructors call
   - Objects
   │
   ├── B1
   │    └── D1
   │         └── D9
   │
   ├── B2   
   │
   ├── B3
   │    ├── D4
   │    ├── D6
   │    └── D7
   │
   └── B4
        └── D8



- 1. `B1` and `D1`**
- `D1` extends `B1`.
- When a `D1` object is created:
   1. The `B1` constructor is called first (implicitly via `super()` in `D1`).
   2. Then, the `D1` constructor is executed.

  **Output:**
---

- 2. `B2`**
- `B2` has a private constructor, so it cannot be extended.
- Attempting to create a subclass like `D2` results in a compilation error.

---

- 3. `B3` and its Subclasses**
#### **`D4`**
- The `D4` constructor explicitly calls `super(1)` to invoke the `B3(int x)` constructor.

**Output:**#### **`D6`**
- The `D6` constructor explicitly calls `super(x)` to invoke the `B3(int x)` constructor.

**Output:**#### **`D7`**
- `D7` has two constructors:
   1. The parameterized constructor (`D7(int x)`) explicitly calls `super(x)`.
   2. The parameterless constructor (`D7()`) calls `this(1)` to invoke the parameterized constructor.

**Output:**---

- 4. `B4` and `D8`**
- `D8` extends `B4`.
- When a `D8` object is created:
   1. The `B4` constructor is called first (implicitly via `super()` in `D8`).
   2. Then, the `D8` constructor is executed.

**Output:**---

- 5. `D9`**
- `D9` extends `D1`.
- When a `D9` object is created:
   1. The `B1` constructor is called first (implicitly via `super()` in `D1`).
   2. The `D1` constructor is executed.
   3. The instance initializer block in `D9` is executed, initializing `d4`.
   4. The `D7` constructor is executed during the initialization of `d7`.
   5. The `D9` constructor is executed, initializing `d1`.

**Output:**
<br><br>
### 3.Comparison between Constructors and Factory Methods
| **Aspect**      | **Constructor**                                                  | **Factory Methods**                                                              |
|------------------|------------------------------------------------------------------|----------------------------------------------------------------------------------|
| **Definition**   | Special methods used to initialize objects when they are created | Static or instance methods that return an instance of a class.                   |
| **Return type**  | Always returns a new instance of the class it belongs to         | Can return an instance of the same class, a subclass, or even a cached instance. |
| **Flexibility**  | Limited to creating new instances                                | Can implement complex logic, reuse existing objects, or return different types.  |
| **Naming**       | Must have the same name as the class                             | Can have any name, often descriptive of the instance being created.              |
| **Overloading**  | Can be overloaded to provide multiple ways to initialize an object | Can also be overloaded, offering more descriptive method names.                  |
| **Inheritance**  | Cannot be inherited or overridden                                | Can be inherited and overridden in subclasses.                                   |
| **Polymorphism** | Not applicable                                                  | Can utilize polymorphism by returning different types based on conditions.       |

### 4.Singleton Design Pattern
- Configuration Management: A singleton can be used to manage application-wide configuration settings, ensuring that all parts of the application access the same configuration instance.
- Logging: A singleton is often used for logging purposes to ensure that all log messages are written to the same log file or output stream.

## 4)  Immutable objects/classes and Java Records
1. The strategies to create immutable classes in Java are:
   - Declare the class as `final` to prevent subclassing.
   - Make all fields `private` and `final` to ensure they cannot be modified after initialization.
   - Provide no setter methods, only getter methods for accessing field values.
   - Initialize all fields through the constructor.
   - If a field is a mutable object, return a copy of it in the getter method instead of the original object.
### 2. Comparison between Immutable Classes and immutable objects
| **Aspect**         | **Immutable Class**                                        | **Immutable Object** |
|--------------------|------------------------------------------------------------|----------------------|
| **Definition**     | A class designed such that all the instances are immutable.| An instance of an immutable class that cannot be modified after creation. |
| **scope**          | Applies to the entire class and all its instances.          | Applies to a specific instance of a class. |
| **implementation** | Archieved by making all fields *final*, *private*, *no setters* and defensive| Achieved by creating an instance that is never modified (even if the class allows modification).
| **inheritance**    | Immutable classes are often declared as *final* to prevent subclassing.| Immutable objects can be created from both immutable and mutable classes.|

3. - Thread-Safety: Immutable objects are inherently thread-safe since their state cannot be changed after creation. This eliminates the need for synchronization when accessing immutable objects from multiple threads.
   - Caching and Performance: Immutable objects can be cached and reused without concern for unintended modifications. This can lead to performance improvements, especially in scenarios where the same object is frequently accessed.
   - Simplicity and Predictability: Immutable objects are easier to reason about since their state remains constant. This can lead to fewer bugs and more maintainable code.
4. - Data Transfer Objects (DTOs):
     Java Records are ideal for creating lightweight, immutable classes to transfer data between different layers of an application.
   - Value Objects: Records are perfect for representing value objects, which are immutable and primarily used to encapsulate a set of related data
## 5) Overriding hashCode(), equals() and toString() 
1. The difference between "==" and equals() in Java is:
   - "==" is a reference comparison operator that checks if two references point to the same object in memory.
   - equals() is a method that checks for value equality, meaning it compares the actual content of the objects to determine if they are logically equivalent.
2. The formula o1.equals(o2) ⇒ hashCode(o1) == hashCode(o2) means that if two objects o1 and o2 are considered equal according to the equals() method, then their hash codes (as returned by the hashCode() method) must also be equal. 
### Explanation:
- Contract Between equals() and hashCode():The hashCode() method is used to generate a hash code (an integer) for an object, which is typically used in hash-based collections like HashMap or HashSet.<br>
The equals() method determines whether two objects are logically equivalent.

## 2) Static members(variables/constants and methods)
1. 1. Static Variable (Field / Class Member)

       - A variable that belongs to the class, not to any specific object.

        - Shared across all instances of the class.

       - Initialized once when the class is loaded.

       - Can be accessed using the class name or through an object.
   2. Static Constant
      - A static variable declared with the final keyword.

      - Its value cannot change after initialization.

      - Used for class-wide constant values.

      - Convention: written in UPPER_CASE.
   3. Static Method
      - A method that belongs to the class, not to any specific object.

      - Can be called without creating an instance of the class.

      - Cannot access instance variables or methods directly (can only access static members).

      - Often used for utility or helper methods.
2. Static constants is often public because they are meant to be accessed globally without needing an instance of the class. Making them public allows other classes to easily reference these constants, promoting code reusability and consistency across the application. Additionally, since static constants are immutable (declared with the final keyword), there is no risk of their values being changed, making it safe to expose them publicly.
3. Static methods do not have access to instance members (methods and fields) because static methods belong to the class itself rather than to any specific instance of the class. Since instance members are tied to a particular object, they require an instance to be accessed. Static methods, on the other hand, can be called without creating an instance of the class, so they do not have a reference to any specific object and therefore cannot access instance members directly.
4. A common application of a static method is in utility classes, such as a method to calculate the maximum of two numbers. Static methods are ideal for such tasks because they do not depend on instance-specific data.<br><br><br>


# Lab02
## 1) Final variables,methods and classes
1. Done 
2. The benefits of constants in programming is:
- Ease of Maintenance: Constants provide a single point of definition for values that are used multiple times throughout the code. If a value needs to be changed, it can be updated in one place rather than searching through the entire codebase.
- Reusability: Constants can be reused across different parts of the program, promoting code reuse and reducing redundancy.
- Error Prevention: Using constants helps prevent accidental changes to values that should remain constant, reducing the likelihood of bugs and errors in the code.
- Global Accessibility: Constants can be declared as public static final, making them accessible from anywhere in the program without needing to create an instance of the class.
3. The use of "final" in the following is: 
- Local variable: A local variable declared as final cannot be reassigned after it has been initialized. 
- Instance variable: An instance variable declared as final must be initialized when it is declared or in the constructor, and cannot be changed afterward.
- static constant: A static constant declared as final is a class-level variable that cannot be changed after it has been initialized. It is typically used for values that are meant to be constant and shared across all instances of the class.
- Method : A method declared as final cannot be overridden by subclasses. 
- Class: A class declared as final cannot be subclassed or extended.
4. - NO, because the fields can be declared with mutable classes so even if private, it does not guarantee its final state.
- Yes, since all the fields are declare private with primitive type, the absence of setters, making the class final and initializing all the fields through the constructor.
5. The class is not immutable because the private field "values" is not declare with primitive type so it can be modified after the object is created(An array is mutable and actually the getter returns an array).
6. NEED TO DO

## 2) Enumeration classes

1. Done
2. Done
3. The code is actually correct, but it is not Thread-safe because if more than one thread access the getValue() method aat the same time it can lead to an inconsistent result.
4. NEED TO DO

## 3) Nested Classes
1. DONE
2. 
|Concept|Static Nested Class|Inner Class|local classes|Anonymous classes|
|-------|------------------|-----------|-------------|------------------|
|declaration|Declared static within another class|Declared non-static within another class|Declared within a method or a block|Declared and instantiated in a single expression|
|Access to outer class members|Can access static members of the outer class directly|Can access both static and instance members of the outer class|Can access both static and instance members of the outer class|Can access both static and instance members of the outer class|
|Instantiation|Can be instantiated without an instance of the outer class|Requires an instance of the outer class to be instantiated|Can be instantiated only within the method or block where it is defined|Cannot have a constructor, instantiated at the point of declaration|
|can have static members|Yes|No|No|No|
|Use cases|Used for grouping related classes that are only used in one place, or for creating utility classes|Used when the inner class needs to access instance members of the outer class|Used for defining a class that is only relevant within a specific method or block|Used for implementing interfaces or extending classes in a concise way, often for event handling or callbacks|
3. - Yes, an inner class can be used in a class other than the class in which it is nested, but it requires an instance of the outer class to be instantiated first.
- Not in local class.
4. NEED TO DO

## 4) Abstract Data Types and Interfaces
1. DONE. It is a type that is is define just as the level of behavior from the point of view of a user of the data type. It is defined by its behavior (semantics) from the point of view of a user, of the data, specifically in terms of possible values, possible operations on data of this type, and the behavior of these operations.
2. The main difference between an abstract class and an interface in Java is that An abstract class defines a base with shared state and behavior (single inheritance). While an interface defines a contract for behavior that can be implemented by any class (multiple inheritance).
3. The members of java interface are: 
-  Abstract methods
- Default methods
- Static methods 
- Private methods 
- Constants.
4. The correct ones are :
````java
abstract class D {protected  void m1();}
abstract class E { abstract void m1();}
````
5. The correct one is:
````java
interface D { void m1(); }
````
6. A-->interface<br>C-->class<br>D-->C(So an object from D is an instance of C)<br>B-->D(So an object from B is an instance of D and C)<br>B->implements A(So an object from B is an instance of A too)<br>Therefor so an object from B is an instance of A, B, C and D.<br>
### Output:
````java
True
True
````
## 5) Functional Interfaces and Lambda Expressions
1. Done, A functional interface is an interface that contains exactly one abstract method. They can have multiple default or static methods, but only one abstract method. While  a lambda expression is a concise way to represent an instance of a functional interface using an expression. It provides a clear and concise way to implement the single abstract method of the functional interface without the need for a separate class.
2. The relationship between functional interface and lambda expression is that a lambda expression is used to provide the implementation of the single abstract method defined in a functional interface. When a lambda expression is assigned to a variable of a functional interface type, it effectively creates an instance of that functional interface with the behavior defined by the lambda expression.
3. ```java
   @FunctionalInterface
    public interface VoidToInt {
    int apply();
    }
    @FunctionalInterface
    public interface IntToVoid {
    void apply(int x);
    }
    
    @FunctionalInterface
    public interface IntToInt {
    int apply(int x);
    }
    
    @FunctionalInterface
    public interface IntIntToVoid {
    void apply(int x, int y);
    }

    ```
   ```java
   public class AnonymousClassImplementations {
    public static void main(String[] args) {
     
        VoidToInt voidToInt = new VoidToInt() {
            @Override
            public int apply() {
                return 42;
            }
        };

    
        IntToVoid intToVoid = new IntToVoid() {
            @Override
            public void apply(int x) {
                System.out.println("Received: " + x);
            }
        };

       
        IntToInt intToInt = new IntToInt() {
            @Override
            public int apply(int x) {
                return x * x;
            }
        };

      
        IntIntToVoid intIntToVoid = new IntIntToVoid() {
            @Override
            public void apply(int x, int y) {
                System.out.println("Sum: " + (x + y));
            }
        };

      
        System.out.println(voidToInt.apply());
        intToVoid.apply(10);
        System.out.println(intToInt.apply(5));
        intIntToVoid.apply(3, 7);
    }
    }
    ```
   ```java
   public class LambdaImplementations {
    public static void main(String[] args) {
      
        VoidToInt voidToInt = () -> 42;

    
        IntToVoid intToVoid = x -> System.out.println("Received: " + x);

       
        IntToInt intToInt = x -> x * x;

        
        IntIntToVoid intIntToVoid = (x, y) -> System.out.println("Sum: " + (x + y));

   
        System.out.println(voidToInt.apply());
        intToVoid.apply(10);
        System.out.println(intToInt.apply(5));
        intIntToVoid.apply(3, 7);
    }
    }
    ```




