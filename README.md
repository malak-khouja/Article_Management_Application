# Article Management System

A JavaFX-based desktop application for managing articles with a graphical user interface and database integration.

## 📋 Features

- **Create Articles** - Add new articles with code, label, quantity, and price information
- **View Articles** - Browse all articles with search and filter functionality
- **Update Articles** - Modify existing article details
- **Delete Articles** - Remove articles from the system
- **Database Integration** - Persistent data storage using JDBC
- **User-Friendly UI** - Intuitive interface built with JavaFX

## 📦 Requirements

- Java 11 or higher
- JavaFX SDK
- JDBC Database Driver
- Database configured in `database.Properties`

## 🚀 Installation & Setup

### Step 1: Clone or Download
Download the project to your local machine

### Step 2: Configure Database
Edit `src/database.Properties` and update:
- Database URL
- Username
- Password
- JDBC Driver class

### Step 3: Add JavaFX Libraries
- Add JavaFX SDK to your project classpath
- Configure in your IDE settings

### Step 4: Compile and Run
```bash
javac -d bin src/*.java
java -cp bin:lib/* interfacefx.interfacefx.src.App
```

## 💻 Usage

1. **Launch Application** - Run the App class
2. **Main Menu Options:**
   - **Create Article** - Enter code, label, quantity, and price
   - **View All Articles** - Search and browse all articles
   - **Update Article** - Modify article information
   - **Delete Article** - Remove articles

## 📁 Project Structure

```
interfacefx/
├── src/
│   ├── App.java                 # Main JavaFX application
│   ├── Article.java             # Article model
│   ├── ArticleDb.java           # Database operations (CRUD)
│   ├── DBConnection.java        # Database connection handler
│   ├── Client.java              # Client management
│   ├── Commande.java            # Order management
│   ├── Main.java                # Application entry point
│   ├── TestConnexion.java       # Connection tests
│   ├── database.Properties      # Database configuration
│   └── Opération.java           # Operations utilities
├── bin/
│   └── MainScene.fxml           # UI Layout file
└── lib/                         # External libraries
```

## 🛠️ Built With

- **JavaFX** - Modern Java UI framework
- **JDBC** - Database connectivity
- **Java 11+** - Programming language

## ✨ Key Features

- Input validation for all forms
- Error handling with user-friendly messages
- Real-time search functionality
- Modal dialogs for operations
- Responsive UI design
- Database connection management

## 📝 License

Educational project

## 👨‍💻 Author

Java Programming Project
