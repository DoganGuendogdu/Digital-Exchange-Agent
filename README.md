# Digital-Exchange-Agent

## 1. Documentation
### 1.1 Introduction

The goal of this project is to develop a **Digital Exchange Agent**—a digitalized transaction service accessible through a web application. It’s not intended to be a production-ready solution; for now, it's available for local setup only.

Imagine a situation where you need someone to sign a document, respond to an appointment suggestion, scan something for you, or even handle all of that at once. In such cases, a simple, centralized platform is the answer.  
With this agent, you can initiate any kind of transaction and wait for the recipient to respond. Then, just check your inbox for their reply.

This idea comes from a personal experience—I once needed a signed authorization document to pick up a package for someone, and I realized there had to be a more straightforward way to handle it. After looking into it, I found that many similar use cases exist and could benefit from a centralized approach.

At its core, the concept is simple: a transaction is required to fulfill a specific need.

This project also serves as a way to sharpen my skills as a Software Engineer by building something from the ground up. That includes planning, design, implementation, infrastructure, refactoring, and especially problem-solving. The process follows a *“get things done”* mindset—avoiding excessive planning in favor of practical execution.

While this is one of many projects I’ve worked on, here I’m diving deeper into Full Stack development with Java, using **JDK 24**, **Spring Boot Framework 4**, and **React**.

The main audience includes fellow developers and potential employers to whom I may present this project.

### 1.2 User Stories 
#### 1.2.1 Core Functionality
- I want a platform to centralize my digital transactions.  
- I want it to be secure, so I don’t worry about privacy or data.  
- I want to handle everything inside the platform—no external steps.  
- I want it to be simple and intuitive.

#### 1.2.2 Account Management
- I want to create an account and log in to access my transactions.

#### 1.2.3 Transaction Handling
- I want to create, send, and manage transactions.  
- I want to include one or multiple tasks per transaction.  
- I want to save transactions as templates and reuse them.  
- I want to edit templates to fit new needs.  
- I want to assign priority levels to transactions or tasks.  
- I want to set deadlines or expiry dates for transaction tasks.  
- I want to export transaction summaries as PDF or CSV.

#### 1.2.4 Task Management
- I want to add or remove tasks within a transaction.  
- I want tasks to use predefined templates for consistency and speed.  
- I want to add custom info to tasks when needed.

#### 1.2.5 Inbox & History
- I want an inbox to track recipient responses.  
- I want to receive an email or in-app notifications when a transaction is answered.
- I want to view sent transactions and their status.  
- I want to see a log of my past actions.

#### 1.2.6 Recovery
- I want to delete transactions and recover them if needed.  
- I want access to a bin to review deleted items.
