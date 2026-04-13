# 🔐 Java Account System (Secure File-Based Authentication)

![Java](https://img.shields.io/badge/Language-Java-orange)
![Status](https://img.shields.io/badge/Status-Active-success)
![Level](https://img.shields.io/badge/Level-Beginner--Intermediate-blue)
![Storage](https://img.shields.io/badge/Storage-File%20Based-lightgrey)
![Security](https://img.shields.io/badge/Security-Basic%20Practices-yellow)

---

## 📌 Overview
A **secure console-based authentication system in Java** that supports account creation and login with **persistent storage and improved security practices**.

This project evolves from a simple login system into a **modular, file-backed authentication system**, demonstrating real-world programming concepts.

---

## ✨ Features
- 🔐 Secure password input using `Console.readPassword()`
- 🧠 Passwords stored as `char[]` (not `String`)
- ♻️ Sensitive data cleared using `Arrays.fill()`
- 👤 Username uniqueness validation
- 🔑 Login authentication system
- 🚫 Maximum of 3 login attempts
- 🧾 Persistent storage using `database.bin`
- 📂 Object serialization for saving users
- 🔄 Automatic database initialization
- 🧹 Console clearing for better user experience
- 🧱 Clean OOP structure (separated concerns)

---

## 🖥️ Demo (Sample Flow)
```bash
===== Options =====
SIGN UP        [1]
SIGN IN        [2]
EXIT           [3]
===== Options =====

Option: 1

===== SIGN UP =====
Create a username: chrisoft
Create a password: ******
Confirm your password: ******

Success: Account created successfully!
```

---

## 🗂️ Project Structure
```
📦 Java-Account-System
 ┣ 📜 Main.java              # Entry point & menu system
 ┣ 📜 Account.java           # Sign up & login logic
 ┣ 📜 DatabaseService.java   # File handling & validation
 ┣ 📜 User.java              # User model (Serializable)
 ┣ 📂 database.bin           # Stored user data (auto-generated)
```

---

## ⚙️ How It Works

### 📝 Sign Up
- Input username  
- Check if username exists  
- Input secure password (hidden)  
- Validate password length  
- Confirm password  
- Save to file (`database.bin`)  

### 🔑 Sign In
- Input username  
- Validate existence  
- Input password (hidden)  
- Verify credentials  
- Grant or deny access  

---

## 🔐 Security Practices Implemented
| Practice | Description |
|--------|------------|
| Hidden Input | Uses `Console.readPassword()` |
| char[] Passwords | Avoids immutable `String` storage |
| Memory Clearing | Uses `Arrays.fill()` |
| Attempt Limiting | Prevents brute-force attempts |
| Input Validation | Ensures proper user input |

---

## 🧠 Concepts Demonstrated
- Object-Oriented Programming (OOP)
- File Handling & Serialization
- Collections (`ArrayList`)
- Java Streams API
- Exception Handling
- Secure Coding Basics
- Modular Design Principles

---

## 🚀 Getting Started

### ✅ Requirements
- Java 8 or higher
- Run in a **real terminal** (IMPORTANT for `Console`)

### ▶️ Run the Program
```bash
javac Main.java
java Main
```

---

## ⚠️ Limitations
- ❌ No password hashing (plain storage for learning)
- ❌ Local file only (no real database)
- ❌ No GUI (console-based only)

---

## 🔮 Future Improvements
- 🔒 Add password hashing (e.g. BCrypt)
- 🗄️ Replace file storage with a database (MySQL)
- 🌐 Build a GUI or web version
- 📧 Add email verification
- 🔑 Implement session handling

---

## 📸 Screenshots
> Add screenshots here to make your repo stand out 👀

---

## 👨‍💻 Author
**Christian A. Gulfan**  
Aspiring Software Developer 🚀  

---

## 🤝 Credits
Special thanks to **Charles Tinoy** for:
- Improving security practices  
- Introducing file-based storage  
- Helping structure cleaner, modular code  

---

## ⭐ Project Insight
This project demonstrates my progression from:
> Basic login systems ➜ Structured, secure, and persistent authentication systems

---

## 💬 Quote
> “Secure code isn’t just about functionality — it’s about responsibility.” 🔐  
