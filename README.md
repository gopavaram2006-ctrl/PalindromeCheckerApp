# PalindromeCheckerApp

Repository: https://github.com/gopavaram2006-ctrl/PalindromeCheckerApp


This repository contains a simple Java console application that verifies whether a string is a palindrome.

## Project Structure

```
sharath/
└── src/
    └── PalindromeCheckerApp.java
```

All use cases are implemented in a single class as required.

## Usage

Compile and run the application using your preferred IDE (e.g., IntelliJ) or from command line:

```sh
javac src/PalindromeCheckerApp.java
java -cp src PalindromeCheckerApp
```

Example output after adding UC8:
```
Welcome to the Palindrome Checker App!
This application can verify whether a given string is a palindrome.

UC2 - Hardcoded palindrome check:
  String to test: racecar
  Is palindrome? true

UC8 - Linked list palindrome check:
  Input: level
  Is palindrome? true
```

The application currently includes:

- **UC1**: Welcome message module
- **UC2**: Hardcoded palindrome check
- **UC8**: Linked list based palindrome check (example input "level")

Additional use cases can be added within the same class.

## Git Workflow (summary)

Follow these general steps to work with the project:

1. Initialize the local repository:
   ```sh
   git init
   git branch -M main
   git remote add origin https://github.com/<your-username>/PalindromeCheckerApp.git
   ```
2. Commit initial setup:
   ```sh
   git add .
   git commit -m "Base application setup"
   git push origin main
   ```
3. Create and switch to `develop` branch:
   ```sh
   git checkout -b develop
   git push -u origin develop
   ```
4. For each use case, create a feature branch off of `develop`, implement changes, commit and push, then merge back into `develop`.

Remember:

- Branch names are case-sensitive.
- Feature branches are temporary and should be deleted after merging.
- `develop` serves as the integration branch.

Happy coding!
