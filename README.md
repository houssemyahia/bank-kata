# **Bank Kata**

## **Description**

This project is an implementation of the **Bank Account Kata**, which involves modeling a banking account management system. It allows users to make deposits, withdrawals, view the transaction history, and generate a formatted statement of all performed operations.

---

## **Features**

1. **Deposit and Withdrawal Management**:
   - Enables adding or withdrawing funds from an account, with validation (e.g., no withdrawal beyond the available balance, no negative amounts).

2. **Transaction History**:
   - Stores all transactions (deposits, withdrawals) associated with an account.
   - Each transaction includes metadata such as the date, type of operation, amount, and resulting balance.

3. **Formatted Statement (Statement Printing)**:
   - Generates a plain-text statement containing:
      - Account information (owner, currency, creation date).
      - A detailed table of transactions.

4. **Unit Testing**:
   - Verifies the behavior of services (`AccountService`, `TransactionService`, `TransactionFormatterService`) and edge cases.

---

## **Project Structure**

```
src/
├── main/
│   ├── java/
│   │   └── com.bankkata/
│   │       ├── model/
│   │       │   ├── Account.java
│   │       │   ├── Transaction.java
│   │       │   ├── TransactionType.java
│   │       ├── service/
│   │       │   ├── AccountService.java
│   │       │   ├── AccountServiceImpl.java
│   │       │   ├── TransactionFormatterService.java
│   │       │   ├── TransactionFormatterServiceImpl.java
│   │       │   ├── TransactionService.java
│   │       │   ├── TransactionServiceImpl.java
├── test/
│   ├── java/
│   │   └── com.bankkata/
│   │       ├── service/
│   │       │   ├── AccountServiceTest.java
│   │       │   ├── TransactionFormatterServiceTest.java
│   │       │   ├── TransactionServiceTest.java
```

---

## **Technologies Used**

- **Java**: Version 17.
- **JUnit 5**: Unit testing framework.
- **Mockito**: Used for mocking in tests.

---

## **Classes and Services**

### **Model (`model`)**

1. **`Account`**:
   - Represents a bank account.
   - Attributes:
      - `accountId`: Unique identifier for the account.
      - `ownerName`: Name of the account owner.
      - `currency`: Currency used by the account.
      - `createdAt`: Account creation date.
      - `balance`: Current account balance.
      - `transactions`: List of transactions associated with the account.

2. **`Transaction`**:
   - Represents a transaction (deposit or withdrawal).
   - Attributes:
      - `date`: Transaction date.
      - `type`: Type of operation (`DEPOSIT` or `WITHDRAWAL`).
      - `amount`: Transaction amount.
      - `balanceAfterTransaction`: Balance after the transaction.

3. **`TransactionType`**:
   - Enumeration for transaction types:
      - `DEPOSIT`
      - `WITHDRAWAL`

---

### **Services (`service`)**

1. **`AccountService` and `AccountServiceImpl`**:
   - Handles main banking operations:
      - `deposit(Account account, double amount)`: Perform a deposit.
      - `withdraw(Account account, double amount)`: Perform a withdrawal.

2. **`TransactionService` and `TransactionServiceImpl`**:
   - Manages transaction recording and retrieval:
      - `recordTransaction(Account account, TransactionType type, double amount)`: Records a transaction.
      - `getTransactionHistory(Account account)`: Retrieves the transaction history.

3. **`TransactionFormatterService` and `TransactionFormatterServiceImpl`**:
   - Formats banking statements into plain text.
   - Main method: `format(Account account)`.

---

## **Sample Output**

### **Account with Transactions**
```
Account Owner: John Doe
Currency: USD
Created At: 2025-01-09T10:00

Date                | Type       | Amount   | Balance
-----------------------------------------------------
2025-01-09T10:30    | DEPOSIT    | 100.00   | 100.00  
2025-01-09T10:35    | WITHDRAWAL | 50.00    | 50.00   
```

### **Account Without Transactions**
```
Account Owner: John Doe
Currency: USD
Created At: 2025-01-09T10:00

Date                | Type       | Amount   | Balance
-----------------------------------------------------
No transactions available for this account.
```

---

## **Build and Execution Instructions**

### **Prerequisites**
- Java 17.
- Maven 3.x installed.

### **Compilation**
Run the following command to compile the project:
```bash
mvn clean compile
```

### **Run Tests**
To execute all tests:
```bash
mvn test
```

---

## **Areas for Improvement**

1. **Exception Management**:
   - Add specific exceptions like `InvalidTransactionException` or `InsufficientFundsException` for better error handling.

2. **Persistence**:
   - Add support for saving accounts and transactions to a database or file.

3. **Alternative Formatting**:
   - Provide additional formats for the statement, such as JSON or PDF.

4. **API Implementation**:
   - Introduce a RESTful API to expose the core functionalities (e.g., deposits, withdrawals, fetching transaction history).
   - This would allow other systems or applications to interact with the banking service programmatically.
   - Frameworks like Spring Boot or Jakarta EE could be considered for API implementation if the constraints allow.

5. **User Interface**:
   - Add a command-line interface (CLI) or graphical interface for better interactivity.

---

## **Developer**

- **Name**: Houssem Eddine Yahia
- **Email**: houssem.eddine.yh@gmail.com