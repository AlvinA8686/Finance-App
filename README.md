Financial Dashboard & AI Assistant
A comprehensive Java Swing desktop application designed to empower users to take control of their personal finances. This tool provides an intuitive interface for tracking expenses, managing budgets, visualizing spending habits, and staying updated with the stock market. It also features a built-in AI assistant powered by Google's Gemini API for answering your financial questions.

✨ Features
Dynamic Dashboard: Log daily expenses by category, set monthly budgets, and get instant visual feedback on your spending (e.g., "Over Budget," "On Budget").

Detailed Expense Tracking: Drill down into specific spending categories for any given month to see an itemized breakdown of your transactions.

Data Visualization: Automatically generates a clean bar chart to visually represent your spending by category for any selected month and year.

Stock Market Tracker: Stay informed with the previous day's closing prices for major stocks (AAPL, GOOGL, MSFT, etc.), fetched in real-time from the Polygon.io API.

AI Financial Assistant: Have a financial question? Ask the integrated AI assistant, powered by the Google Gemini API, to get insightful answers directly within the app.

🛠️ Tech Stack
Core Framework: Java & Java Swing for the graphical user interface.

External APIs:

Polygon.io API: Used to fetch real-time stock market data.

Google Gemini API: Powers the AI financial assistant.

Dependencies: org.json library for parsing JSON data from APIs.

🚀 Getting Started
Follow these instructions to get the application running on your local machine.

Prerequisites
Java Development Kit (JDK) 11 or higher.

An IDE like NetBeans, IntelliJ IDEA, or Eclipse.

API keys for Polygon.io and Google Gemini.

Installation & Setup
Clone the repository:

git clone [https://github.com/your-username/your-repository-name.git](https://github.com/your-username/your-repository-name.git)
cd your-repository-name

Set up API Keys:
This application requires API keys to function correctly. You must set them up as environment variables.

POLYGON_API_KEY: Your API key from Polygon.io.

GEMINI_API_KEY: Your API key from Google AI Studio.

Create these two environment variables on your system and set their values to your respective API keys. The application reads these keys directly from your system's environment.

Build and Run:
Open the project in your preferred Java IDE. The main entry point for the application is in the App.java file. Compile and run this file to launch the application.

📋 Usage
Home Tab: Use the dropdowns to select a month and year. Enter an expense category and amount, then click "ADD" to log it. Use the right-hand panel to set your monthly budgets.

Tables Tab: Enter a year, month, and category to view and add detailed expense descriptions.

Graphs Tab: Input a year and month, then click "Update" to generate a visual bar chart of your spending.

Stocks Tab: Click the "Update" button to fetch the latest closing prices for the pre-listed stocks.

AI Tab: Type any financial question into the text box and click "Ask" to get a response from the AI assistant.

📄 License
This project is licensed under the MIT License. See the LICENSE file for details.
