
[![Stars](https://img.shields.io/github/stars/QuitttCat/CSE-108-Object-Oriented-Programming-Language-Sessional?style=flat-square&logo=github)](https://github.com/QuitttCat/CSE-108-Object-Oriented-Programming-Language-Sessional/stargazers)
[![Forks](https://img.shields.io/github/forks/QuitttCat/CSE-108-Object-Oriented-Programming-Language-Sessional?style=flat-square&logo=github)](https://github.com/QuitttCat/CSE-108-Object-Oriented-Programming-Language-Sessional/network/members)
![Repo Size](https://img.shields.io/github/repo-size/QuitttCat/CSE-108-Object-Oriented-Programming-Language-Sessional?style=flat-square)
[![License](https://img.shields.io/github/license/QuitttCat/CSE-108-Object-Oriented-Programming-Language-Sessional?style=flat-square)](LICENSE)
![Last Commit](https://img.shields.io/github/last-commit/QuitttCat/CSE-108-Object-Oriented-Programming-Language-Sessional?style=flat-square&logo=git)
# FoodForces – A Restaurant Food Delivery System
**A real-time multi-client food delivery system** built with **JavaFX** (client) and **Socket Programming** (server) for **CSE 108 – OOP Sessional**, BUET.

---

## Key Features

| Feature                               | Description                                                                                 |
|--------------------------------------|---------------------------------------------------------------------------------------------|
| **Customer Features**                |                                                                                             |
| Search Restaurants by Name, Price, Zip Code, Category                                   |
| Search Restaurants by Score Range (e.g., 4.0 – 5.0)                                             |
| View Restaurant Menu & Search Food by Name/Category                                         |
| Add/Remove items from Cart with live total price                                               |
| Place Order (real-time delivery to restaurant)                                               |
| **Restaurant Manager Features**      |                                                                                             |
| Secure Login using Restaurant Name + ID as password                                            |
| Real-time Order Dashboard (live incoming orders)                                            |
| See customer name + ordered items instantly                                                    |
| Log out safely (removes from active server map)                                                |
| **Admin/Offline Mode**               |                                                                                             |
| Add new Restaurants & Food items via console (persists on restart)                           |
| Data loaded from `restaurant.txt` and `food.txt` on server startup                             |
| **Networking**                       |                                                                                             |
| Multi-threaded Server using Socket + Object Streams                                          |
| Real-time bidirectional communication (no polling)                                            |
| Clean disconnection handling & logout support                                                 |

---

## Tech Stack

### Languages
![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=openjdk)

### GUI Framework
![JavaFX](https://img.shields.io/badge/JavaFX-21-success?style=flat-square&logo=java)

### Networking
![Sockets](https://img.shields.io/badge/Sockets-TCP-blue?style=flat-square)
![Object Serialization](https://img.shields.io/badge/Serialization-ObjectStream-green?style=flat-square)

### IDE & Tools
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-Editor-black?style=flat-square&logo=intellij-idea)
![VS Code](https://img.shields.io/badge/VSCode-Editor-blue?style=flat-square&logo=visualstudiocode)
![Git](https://img.shields.io/badge/Git-VersionControl-orange?style=flat-square&logo=git)



---


- Login Type Selection  
- Customer Search Interface  
- Food Cart & Ordering  
- Restaurant Real-time Order Dashboard  

---

## How to Run

1. **Start the Server**
   ```bash
   javac Networking/Server.java
   java Networking.Server
   ```
   → Server runs on `port 33333` and loads data from `.txt` files.

2. **Run the Client (Multiple instances allowed!)**
   ```bash
   javac DelivarySystem/Client.java
   java DelivarySystem.Client
   ```

3. **Offline Admin Mode** (in server console)
   - Add new restaurants
   - Add food items dynamically

---

## Author

**Niloy Kumar Mondal**  
Student ID: **2105044**  
Department of CSE, **BUET**  
GitHub: [@QuitttCat](https://github.com/QuitttCat)

---


## Star & Support

If this project helped you understand **OOP + JavaFX + Networking**, please give it a star!  
Your support means a lot! ❤️
