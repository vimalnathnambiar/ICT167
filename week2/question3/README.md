# Question 3

Author: Vimalnath Nambiar  
Date: 31-07-2023

    1. Modular Design Principle
    - Modular design is a design principle that encourages dividing a large program into smaller, manageable, and independent modules (functions or methods in this case) that perform specific tasks. In the above program, each option in the menu is implemented as a separate method (optionA(), optionB(), optionC(), etc.). This modular approach enhances the readability, maintainability, and reusability of the code. Each method handles a specific functionality, making it easier to understand and modify individual parts of the program without affecting the others.

    2. Single Responsibility Principle
    - The Single Responsibility Principle (SRP) states that each module or class should have only one reason to change. In the above program, each method represents a specific task, and each task has its own distinct responsibility. For example, optionE() is responsible for checking if a number is prime, optionC() is responsible for displaying numbers and calculating the sum of odd numbers, etc. This design adheres to SRP because each method has a single responsibility, making the code more maintainable and easier to debug.

    3. Any other design principle
    - KISS (Keep It Simple, Stupid): The code is kept simple, straightforward, and easy to understand. The menu-driven structure with separate methods for each option simplifies the overall flow of the program.

    - Encapsulation: The program uses methods to encapsulate the implementation details of each task, hiding the complexity and providing a clear interface for interaction.

    - High Cohesion and Low Coupling: Each method in the program is focused on a specific task, ensuring high cohesion. The methods are loosely coupled with each other, promoting modularity and maintainability.

<!-- ## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies). -->
