# 🏦 BANK-BUDDY

> A Java-based banking management system that simulates account operations, balance management, transaction tracking, and account controls through an interactive command-line interface.

![Java](https://img.shields.io/badge/Java-Programming-orange?logo=openjdk&logoColor=white)
![Interface](https://img.shields.io/badge/Interface-CLI-blue)
![Storage](https://img.shields.io/badge/Storage-In--Memory-lightgrey)
![Dependencies](https://img.shields.io/badge/Dependencies-Java%20Standard%20Library-green)
![License](https://img.shields.io/badge/License-Not%20Specified-lightgrey)

## 📑 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Architecture](#-architecture)
- [Tech Stack](#-tech-stack)
- [Project Objectives and Scope](#-project-objectives-and-scope)
- [Project Structure](#-project-structure)
- [Prerequisites](#-prerequisites)
- [Installation and Setup](#-installation-and-setup)
- [Usage Guide](#-usage-guide)
- [Transaction History and Data Persistence](#-transaction-history-and-data-persistence)
- [Limitations and Future Enhancements](#-limitations-and-future-enhancements)
- [Contributing](#-contributing)
- [License](#-license)
- [Author](#-author)

## 🚀 Overview

### Why

Managing account balances and tracking banking operations requires consistent handling of deposits, withdrawals, and account information. This project demonstrates how these operations can be modeled using object-oriented programming in Java.

### What

BANK-BUDDY is a command-line banking simulation that allows users to create multiple account objects, inspect account information, perform balance operations, lock or unlock accounts, calculate interest, and review transaction history.

### How

The application follows an object-oriented, in-memory processing model:

1. **Initialization:** The user specifies the number of depositors and enters their account details.
2. **Account creation:** Java creates a `BankAccount` object for each depositor.
3. **Operation selection:** An interactive menu allows the user to select an account operation.
4. **Business logic:** The corresponding method validates certain conditions and updates the account object.
5. **Feedback:** The application displays the result in the terminal and updates the in-memory transaction history where implemented.

### To Whom

This project is suitable for:

- Students learning Java and object-oriented programming.
- Beginners practicing classes, constructors, objects, and methods.
- Developers exploring menu-driven command-line applications.
- Learners studying basic banking operations and state management.

## ✨ Features

- **Account Management:** Create account objects with a generated account identifier, holder name, address, account type, and opening balance.
- **Balance Inquiry:** Display account information, including the current balance and account status.
- **Deposits and Withdrawals:** Credit or debit account balances with basic insufficient-balance checking for withdrawals.
- **Account Locking:** Lock an account to prevent deposits, withdrawals, and address modifications through the corresponding methods.
- **Interest Calculation:** Calculate interest using a supplied percentage rate and credit the result to the account balance.
- **Address Management:** Update an account holder's address.
- **Transaction History:** Record supported operations in an in-memory list and display the recorded entries.
- **Transaction Counter:** Display the total count maintained for successful deposits and withdrawals.
- **Interactive Menu:** Navigate the available operations through numbered terminal options.

## 🏗️ Architecture

BANK-BUDDY uses a simple, single-class application architecture.

```text
              User
               |
               v
        Command-Line Input
               |
               v
       BankAccount.main()
               |
               v
       Create Account Objects
               |
               v
         Interactive Menu
               |
       +-------+--------+
       |       |        |
       v       v        v
    Deposit  Withdraw  Account Controls
       |       |        |
       +-------+--------+
               |
               v
       Update Account State
               |
        +------+------+
        |             |
        v             v
   Account Balance  Transaction History
        |             |
        +------+------+
               |
               v
         Terminal Output
```

### Core Components

| Component | Responsibility |
|---|---|
| `BankAccount` | Represents a bank account and its associated state |
| Constructor | Initializes account details and the opening balance |
| `generateUID()` | Generates account identifiers using the `BA` prefix |
| `display()` | Prints account information and account status |
| `deposit()` | Adds an amount to the balance |
| `withdraw()` | Checks available funds and processes withdrawals |
| `changeAddress()` | Updates the account holder's address |
| `lockAccount()` / `unlockAccount()` | Change the account's lock status |
| `calculateInterest()` | Calculates and credits interest |
| `printTransactionHistory()` | Displays recorded account events |
| `main()` | Initializes accounts and manages the interactive menu |

## 🛠️ Tech Stack

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![OOP](https://img.shields.io/badge/Paradigm-Object--Oriented-blue)
![CLI](https://img.shields.io/badge/Interface-Command--Line-lightgrey)

| Technology | Purpose |
|---|---|
| Java | Implements account management and transaction logic |
| Java Standard Library | Provides console input, collections, and basic utilities |
| `Scanner` | Reads user input from the terminal |
| `ArrayList` | Stores transaction history in memory |
| Object-oriented programming | Encapsulates account data and operations in a class |
| Java compiler (`javac`) | Compiles the source code |
| Java runtime (`java`) | Executes the compiled application |

The application does not require a database, external dependencies, Maven, or Gradle for its current implementation.

## 🎯 Project Objectives and Scope

### Objectives

- Demonstrate object-oriented programming concepts in Java.
- Model banking accounts as objects with mutable state.
- Implement basic deposit and withdrawal operations.
- Provide account locking and unlocking functionality.
- Demonstrate simple interest calculations.
- Maintain an in-memory history of account events.
- Provide a user-friendly, menu-driven terminal interface.

### In Scope

- Creating multiple account objects during program initialization.
- Displaying account details.
- Deposits and withdrawals.
- Updating account addresses.
- Locking and unlocking accounts.
- Calculating and crediting interest.
- Displaying transaction counts and histories.

### Out of Scope

The current implementation does not provide:

- Persistent database or file storage.
- User authentication or PIN verification.
- Real bank integrations or actual money transfers.
- Inter-account transfers.
- Multi-user concurrency.
- Formal accounting or audit-grade transaction records.
- Production-grade financial security.

## 📂 Project Structure

```text
BANK-BUDDY/
├── BankAccount.java    # Account model, operations, and main menu
├── com/
│   └── ace/            # Java package directory, if used by the checkout
└── .gitattributes      # Git file handling configuration
```

The Java source declares the package `com.ace`. The compiler's `-d` option can generate the appropriate package directory structure when compiling from the repository root.

## 💻 Prerequisites

- **JDK 8 or later** is a reasonable baseline for this source code.
- A terminal or command prompt.
- Git, if you want to clone the repository.

Verify the Java installation:

```bash
java -version
javac -version
```

Both commands should report an available Java runtime and compiler.

## ⚙️ Installation and Setup

### 1. Clone the Repository

```bash
git clone https://github.com/pratikabhang/BANK-BUDDY.git
cd BANK-BUDDY
```

### 2. Compile the Java Source

From the repository root, run:

```bash
javac -d . BankAccount.java
```

The `-d .` option instructs the compiler to place generated class files under the appropriate package directory.

If your checkout places the source file under `com/ace/`, compile using its actual path instead:

```bash
javac -d . com/ace/BankAccount.java
```

Use the command that matches the file location in your local checkout.

### 3. Run the Application

Because the source declares `package com.ace`, launch it using its fully qualified class name:

```bash
java com.ace.BankAccount
```

The application will prompt you to enter the number of depositors and their account details.

No dependency installation or environment variable configuration is required.

## ▶️ Usage Guide

### 1. Initialize Accounts

When the program starts, enter the number of depositors.

For each account, provide:

- Account holder's name
- Account type
- Address or city
- Opening balance

The application creates an account object for each depositor and assigns a generated account identifier.

### 2. Select an Operation

The menu provides the following options:

| Option | Operation |
|---:|---|
| 1 | Print information for a depositor |
| 2 | Deposit money |
| 3 | Withdraw money |
| 4 | Change address |
| 5 | Lock account |
| 6 | Unlock account |
| 7 | Calculate interest |
| 8 | Print the total transaction count |
| 9 | Print transaction history |
| 10 | Exit |

Enter the relevant number and follow the prompts.

### 3. Example Session

The following is an illustrative interaction:

```text
Enter Number of depositors: 1

Enter Information for Depositor no. 1
Enter name: Rahul
Type of Account: Savings
Enter City: Pune
Enter Balance: ₹5000

MENU FOR ACCOUNT
1. Print information of any depositor
2. Add amount to the account of any depositor
3. Remove some amount from account of any depositor
4. Change Address of any depositor
5. Lock account
6. Unlock account
7. Calculate interest
8. Print total number of transactions
9. Print transaction history
10. Stop

Enter your Choice: 1
Depositor no.: 1
```

The generated account identifier begins with `BA`, followed by a sequential number beginning at `1000`.

### 4. Deposit Money

Choose option `2`, select a depositor, and enter the deposit amount.

The application increases the account balance and records a deposit entry in the transaction history.

### 5. Withdraw Money

Choose option `3`, select a depositor, and enter the withdrawal amount.

The application checks whether the requested amount exceeds the available balance. If sufficient funds are available, it reduces the balance and records the withdrawal.

### 6. Lock or Unlock an Account

- Choose option `5` to lock an account.
- Choose option `6` to unlock an account.

The account status is reflected in the account information display.

Locked accounts are prevented from depositing, withdrawing, and changing their address through the respective methods.

### 7. Calculate Interest

Choose option `7`, select a depositor, and enter the interest rate as a percentage.

For example, with a balance of ₹5,000 and a rate of 5%:

\[
\text{Interest} = \frac{5000 \times 5}{100} = ₹250
\]

The resulting balance becomes ₹5,250.

This is a simple percentage calculation, not a time-based interest model. The current implementation does not apply compounding or calculate interest over a specified period.

### 8. View Transaction History

Choose option `9` and select the depositor whose history you want to inspect.

The application prints the events recorded in that account's transaction history.

## 💾 Transaction History and Data Persistence

The application uses Java objects and an `ArrayList<String>` to store transaction history.

The following events are recorded by the corresponding methods:

- Deposits
- Successful withdrawals
- Address changes
- Account locking and unlocking
- Interest credits

The static transaction counter tracks successful deposits and withdrawals. It does not represent every event in the transaction history.

**Important limitations:**

- Account balances and transaction histories exist only in memory.
- All accounts are lost when the program terminates.
- Account identifiers restart from the initial counter when the application is restarted.
- Transaction history is not saved to a file or database.
- Monetary values use Java `double`, which is not appropriate for production-grade financial calculations where exact decimal arithmetic is required.

## 🔮 Limitations and Future Enhancements

Potential improvements include:

- Validate all numeric inputs and handle invalid input without terminating the application.
- Reject zero or negative deposit and withdrawal amounts.
- Use `BigDecimal` for precise monetary calculations.
- Prevent interest calculations on locked accounts if that matches the intended business rules.
- Separate account selection from internal array positions.
- Persist account data in a database or file.
- Save transaction records with timestamps and unique transaction IDs.
- Add authentication and account-owner authorization.
- Support transfers between accounts with atomic debit and credit operations.
- Add automated unit tests for account operations.
- Separate the application into model, service, and user-interface classes.
- Improve transaction counting and distinguish successful operations from other account events.

These are proposed enhancements and are not implemented features.

## 🤝 Contributing

Contributions, bug reports, and suggestions are welcome.

### Contribution Workflow

1. Fork the repository.
2. Clone your fork:

   ```bash
   git clone https://github.com/<your-username>/BANK-BUDDY.git
   cd BANK-BUDDY
   ```

3. Create a feature branch:

   ```bash
   git checkout -b feature/your-feature-name
   ```

4. Implement your changes.
5. Compile the project and test the affected operations.
6. Commit your changes:

   ```bash
   git add BankAccount.java
   git commit -m "Improve account transaction handling"
   ```

7. Push your branch:

   ```bash
   git push origin feature/your-feature-name
   ```

8. Open a pull request describing your changes and the tests performed.

### Contribution Guidelines

- Follow standard Java naming conventions.
- Keep methods focused and maintainable.
- Validate user input and account operations.
- Avoid committing sensitive information.
- Include test cases for new behavior.
- Update this README when functionality or setup requirements change.

## 📄 License

No `LICENSE` file is listed in the current repository root. The project's license is therefore **not specified**.

Add an appropriate license file before distributing or reusing the project under specific license terms.

## 👨‍💻 Author

**Pratik Abhang**

- GitHub: [@pratikabhang](https://github.com/pratikabhang)
- Repository: [BANK-BUDDY](https://github.com/pratikabhang/BANK-BUDDY)

---

⭐ If you find this project useful, consider starring the repository.

*Built with Java and object-oriented programming.*
