# Java CLO Assessment System

## Overview

The **Java CLO Assessment System** is a console-based application designed to help educators and institutions evaluate **Course Learning Outcomes (CLOs)** based on student performance across multiple assessments. The system allows calculation of **CLO fulfillment percentages** for individual students and the class as a whole, enabling data-driven insights into learning effectiveness.

This project serves as a foundation for building a **web-based CLO evaluation platform**, with the logic validated and tested in a Java console environment.

---

## Features

* Input student marks for **Midterm, Final, and Assignment assessments**.
* Support for **multiple CLOs** per course.
* Automatic calculation of:

  * Individual student **CLO fulfillment percentages**
  * Class-level **average CLO fulfillment**
* Configurable **maximum scores** per assessment type:

  * Midterm: 5 points
  * Final: 12.5 points
  * Assignment: 10 points
* Provides **clear and structured output** for instructors to review performance.
* Easily extensible for **web integration** or additional assessment types.

---

## Technology Stack

* **Programming Language:** Java (JDK 11+ recommended)
* **Build Tools:** Optional (Maven/Gradle if extended for web integration)
* **IDE:** IntelliJ IDEA / Eclipse / VS Code with Java support

---

## System Requirements

* Java Development Kit (JDK 11 or above)
* Terminal or Command Prompt for running console application
* Optional: Git for version control

---

## Usage Instructions

### 1. Clone the repository

```bash
git clone https://github.com/yourusername/java-clo-assessment.git
cd java-clo-assessment
```

### 2. Compile the project

```bash
javac Main.java
```

### 3. Run the application

```bash
java Main
```

### 4. Input Data

* Enter the **number of students**.
* Enter the **maximum scores** for each assessment (default: Midterm 5, Final 12.5, Assignment 10).
* Input each student’s marks **per CLO** for all assessment types.

### 5. View Results

* The program calculates and displays:

  * Individual student CLO fulfillment percentages.
  * Class average CLO fulfillment per CLO.

---

## Example Output

```
Enter number of students: 3
Enter marks for Student 1:
Midterm: 4
Final: 11
Assignment: 9
CLO1 fulfillment: 90%
CLO2 fulfillment: 85%
...
Class average CLO fulfillment:
CLO1: 88%
CLO2: 82%
...
```

---

## Project Structure

```
java-clo-assessment/
│
├─ Main.java               # Entry point of the application
├─ Student.java            # Class to store student data
├─ CLOCalculator.java      # Logic for calculating CLO fulfillment
├─ README.md               # Project documentation
└─ ...                     # Additional supporting classes if any
```

---

## Future Enhancements

* Web-based interface using **Java Spring Boot** or **Django with Java backend API**.
* **Database integration** (MySQL/PostgreSQL) to store student records.
* **Graphical visualizations** of CLO fulfillment (charts, reports).
* **Automated CSV import/export** for bulk student assessment data.
* Support for **dynamic CLO and assessment configuration** per course.

---

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-name`).
3. Make your changes.
4. Commit your work (`git commit -m "Add feature"`).
5. Push to the branch (`git push origin feature-name`).
6. Open a Pull Request.

---

## License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

---

## Contact

**Author:** Khalid Muhammad
**Email:** khalidmuhammad.official.com
**GitHub:** [[https://github.com/km-wahid](https://github.com/km-wahid)]
