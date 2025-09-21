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