# OOP-Demo-Project

# 🐾 OOP Four Pillars — Animal Kingdom

A beginner-friendly Java project that demonstrates all **four pillars of Object-Oriented Programming** through a simple Animal Kingdom simulation. All source code lives in a **single `.java` file** — perfect for learning and quick reference.

---

## 📋 Table of Contents

- [About](#about)
- [OOP Pillars Covered](#oop-pillars-covered)
- [Project Structure](#project-structure)
- [Classes Overview](#classes-overview)
- [Getting Started](#getting-started)
- [Sample Output](#sample-output)
- [Concepts at a Glance](#concepts-at-a-glance)

---

## About

This project is a minimal Java console application that models an animal shelter with three animal types — `Dog`, `Cat`, and `Bird`. It is intentionally simple so that each OOP concept stands out clearly without boilerplate noise.

> **Goal:** Understand Abstraction, Encapsulation, Inheritance, and Polymorphism through readable, real-world code.

---

## OOP Pillars Covered

| # | Pillar | Where It Appears |
|---|--------|-----------------|
| 1 | **Abstraction** | `Animal` is an `abstract` class — it defines *what* animals do (e.g., `speak()`) without saying *how* |
| 2 | **Encapsulation** | Fields in `Animal` and `AnimalShelter` are `private`; data is accessed only through getters and public methods |
| 3 | **Inheritance** | `Dog`, `Cat`, and `Bird` all `extend Animal`, reusing shared logic like `breathe()` and `toString()` |
| 4 | **Polymorphism** | `shelter.makeAllSpeak()` calls `speak()` on each animal — the correct version runs automatically at runtime |

---

## Project Structure

```
AnimalKingdom.java          ← Single file containing all classes
```

All classes in one file for simplicity. Only `Main` is `public` (Java requires the filename to match the public class).

---

## Classes Overview

### `Animal` *(abstract)*
The base class for all animals. Defines shared state (`name`, `age`) and behaviour (`breathe()`, `toString()`). Forces all subclasses to implement `speak()` via an abstract method.

```java
abstract class Animal {
    private String name;
    private int age;
    public abstract void speak();   // subclasses must implement this
    public void breathe() { ... }   // shared concrete method
}
```

### `Dog extends Animal`
A concrete animal with a `breed` field and a unique `fetch()` action. Overrides `speak()` to bark.

### `Cat extends Animal`
A concrete animal that tracks whether it is indoor or outdoor. Overrides `speak()` to meow.

### `Bird extends Animal`
A concrete animal with a `wingSpanCm` field and a `fly()` action. Overrides `speak()` to tweet.

### `AnimalShelter`
Manages a private array of `Animal` objects. Demonstrates encapsulation by hiding internal storage and exposing only controlled operations: `addAnimal()`, `listAnimals()`, `makeAllSpeak()`.

### `Main`
Entry point. Creates animal instances, adds them to the shelter, and exercises all four OOP pillars.

---

## Getting Started

### Prerequisites

- Java **11 or higher**

Check your version:
```bash
java --version
```

### Compile

```bash
javac AnimalKingdom.java
```

### Run

```bash
java AnimalKingdom
```

## Sample Output

```
========================================
   OOP Four Pillars — Animal Kingdom
========================================

[ Adding animals to shelter ]
  Added: Bruno
  Added: Luna
  Added: Tweety

--- Animals in Happy Paws ---
  1. Bruno (age 3)
  2. Luna (age 2)
  3. Tweety (age 1)

--- All animals speak ---
Bruno says: Woof! Woof!
Luna says: Meow~
Tweety says: Tweet! Tweet!

--- Special actions ---
Bruno the Labrador fetches the ball!
Luna is an indoor cat.
Tweety is flying with 15.5cm wingspan!

--- Breathing (inherited method) ---
Bruno is breathing.
Luna is breathing.
Tweety is breathing.

========================================
  Total animals in shelter: 3
========================================
```

---

## Concepts at a Glance

```
Animal  (abstract)
│
├── Dog    → speak() = "Woof!"    + fetch()
├── Cat    → speak() = "Meow~"    + showType()
└── Bird   → speak() = "Tweet!"   + fly()

AnimalShelter
└── holds Animal[]  →  makeAllSpeak()  →  Polymorphism in action
```

---

## Key Takeaways

- **Abstraction** lets you define a contract without exposing implementation details.
- **Encapsulation** protects data integrity and hides internal complexity.
- **Inheritance** eliminates code duplication by sharing common logic in a parent class.
- **Polymorphism** allows one method call to produce different results depending on the actual object type at runtime.

---

## License

This project is released for educational purposes. Free to use, share, and modify.
