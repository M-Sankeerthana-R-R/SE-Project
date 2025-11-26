fawq qqxc phkz xfhe-- email pwd in advanced jenkins email and port: 465

2-stage pipeline: select pipeline project: add pipeline script:
{IF ON WINDOWS, REPLACE sh WITH bat}
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Pulling project from GitHub...'
                git url: 'https://github.com/M-Sankeerthana-R-R/SE-Project', branch: 'main', credentialsId: 'github-access'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'mvn test'
            }
        }
    }
}

3-stage pipeline
{IF ON WINDOWS, REPLACE sh WITH bat}
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Pulling project from GitHub...'
                git url: 'https://github.com/M-Sankeerthana-R-R/SE-Project', branch: 'main', credentialsId: 'github-access'
            }
        }
        stage('Build') {
            steps {
                echo 'Building application...'
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                echo 'Deployment simulated (no real server).'
            }
        }
    }
}

Scripted pipeline code:
node {
    stage('Build') {
        echo "Starting Build Stage..."
        bat 'mvn clean install'
    }

    stage('Test') {
        echo "Running Tests..."
        bat 'mvn test'
    }

    stage('Deploy') {
        echo "Deploying Application..."
        echo "Deployment simulated. (No real server configured)"
    }
}


1️⃣ How to Create a UML Project in StarUML

Open StarUML

Click File → New

In the Model Explorer (left side), right-click Model

Choose Add Diagram

Select the diagram you want (Use Case / Class / Sequence etc.)

2️⃣ USE CASE DIAGRAM — Steps

Right-click Model → Add Diagram → Use Case Diagram

Tools sidebar → drag:

Actor

Use Case

System Boundary

Draw connections:

Click Association → connect Actor → Use Case

Add relationships:

Right-click a Use Case → Add → Include / Extend

Rename elements by double-clicking.

✔ Output: Actors, Use Cases, Include/Extend relations.

3️⃣ CLASS DIAGRAM — Steps

Right-click Model → Add Diagram → Class Diagram

Drag:

Class

Interface

Package

To add attributes:

Double-click class → Add + attribute : type

To add methods:

Double-click → Add + method()

Add relations:

Association → normal arrow

Inheritance → hollow arrow

Aggregation → hollow diamond

Composition → filled diamond

Dependency → dashed arrow

✔ Output: Fully structured class diagram with relationships.

4️⃣ SEQUENCE DIAGRAM — Steps

Right-click Model → Add Diagram → Sequence Diagram

Drag:

Lifeline

Rename lifelines (User, UI, Controller, DB)

Add messages:

Click Message tool → draw arrow from one lifeline to another

Choose message type: Call, Return

Add activations:

Draw small rectangles automatically created when messages connect

✔ Output: Request–response flow vertically.

5️⃣ COMPONENT DIAGRAM — Steps

Right-click Model → Add Diagram → Component Diagram

Drag:

Component (rectangles)

Interface (Lollipop) or Provided/Required Interface

Connect components using:

Dependency (dashed arrow)

Rename:

UI Module, Auth Module, DB Module, Payment Module, etc.

✔ Output: Architecture-level structure.

ATM Machine

Use Case

    [User] ---> (Insert Card)
               (Enter PIN)
               (Select Transaction)
               (Withdraw Cash)
               (Check Balance)
               (Print Receipt)


Class

+----------------+    +----------------+    +-------------------+
|   User         |----|   Account      |----|  Transaction      |
|----------------|    |----------------|    |-------------------|
|+ cardNo        |    |+ accNo         |    |+ txnId            |
|+ name          |    |+ balance       |    |+ amount           |
|+ insertCard()  |    |+ deposit()     |    |+ execute()        |
|+ enterPIN()    |    |+ withdraw()    |    |+ getStatus()      |
+----------------+    +----------------+    +-------------------+

         \                             /
          \---+-----------------------+
              |   ATMController       |
              |-----------------------|
              |+ validateCard()       |
              |+ dispenseCash()       |
              |+ printReceipt()       |
              +-----------------------+


Sequence

User        ATM        Controller     BankServer     CashDispenser
|           |            |               |               |
|--insert-> |            |               |               |
|          -> validate ->|--authRequest->|               |
|          <- authOK ----|<--authReply---|               |
|--select-> |--withdraw-> |               |--debitAcct--->|
|          <- success ---|               |<--confirm-----|
|--collect->|--dispense-> |               |               |
|          <- cash ------|               |               |


Component

[UI Module] --> [ATM Controller] --> [Banking Service]
                     |                    |
                     v                    v
               [Transaction Engine]   [Database: Accounts]
                     |
                     v
               [Hardware Driver: Dispenser/Printer]

Online Ticket Reservation System

Use Case

[Customer] --> (Search Events) --> (Select Seats) --> (Make Payment) --> (Receive Ticket)
[Admin]    --> (Add Event)  --> (Manage Bookings)


Class

+----------------+   +----------------+   +------------------+
| Customer       |---| Reservation    |---| Payment          |
|----------------|   |----------------|   |------------------|
|+ custId        |   |+ resId         |   |+ paymentId       |
|+ search()      |   |+ seatList      |   |+ pay()           |
|+ book()        |   |+ confirm()     |   |+ refund()        |
+----------------+   +----------------+   +------------------+

           +-----------------+
           | Event           |
           |-----------------|
           |+ eventId        |
           |+ venue          |
           |+ getSeats()     |
           +-----------------+


Sequence

User     WebUI    BookingService   PaymentGateway   TicketSystem
|        |          |                |                |
|--search->|        |                |                |
|         ->list---->|                |                |
|--select->|--reserve->|              |                |
|         <-holdOK---|                |                |
|--pay---->|--charge->|--authorize--> |                |
|         <-paid-----|<-confirm-------|                |
|--ticket->|<-deliver-|                |                |


Component

[Web UI] --> [Booking Service] --> [Payment Service]
                 |                     |
                 v                     v
            [Seat Management]      [External PG]
                 |
                 v
            [Database: Events/Bookings]

Banking (Core Banking System)

Use Case

[Customer] -> (Open Account)
           -> (Deposit)
           -> (Withdraw)
           -> (Transfer Funds)
[BankStaff] -> (Approve Loan) -> (Generate Report)


Class

+---------------+   +--------------+   +---------------+
| Customer      |---| Account      |---| Transaction   |
|---------------|   |--------------|   |---------------|
|+ custId       |   |+ accNo       |   |+ txnId        |
|+ name         |   |+ balance     |   |+ amount       |
|+ requestLoan()|   |+ credit()    |   |+ execute()    |
+---------------+   +--------------+   +---------------+

       +------------------+
       | Loan             |
       |------------------|
       |+ loanId          |
       |+ apply()         |
       |+ approve()       |
       +------------------+


Sequence

Customer  InternetBanking  AccountService   ClearingHouse   DB
|         |                |               |               |
|--login->|                |               |               |
|--transfer->|--validate--> |--debitAcct--> |               |
|           <-validated----|<--confirm----- |--settle------>|
|--notify-> |<--success-----|               |               |


Component

[Web/Mobile App] -> [API Gateway] -> [Core Banking Services]
                       |                 |
                       v                 v
               [Auth Service]       [Transaction Engine]
                                           |
                                           v
                                      [DB: Accounts/Txns]

Library Management

Use Case

[Member] -> (Search Catalog) -> (Borrow Book) -> (Return Book) -> (Reserve Book)
[Librarian] -> (Add Book) -> (Manage Members) -> (Generate Reports)


Class

+---------------+   +----------------+   +----------------+
| Member        |---| Loan           |---| Book           |
|---------------|   |----------------|   |----------------|
|+ memberId     |   |+ loanId        |   |+ isbn          |
|+ name         |   |+ dueDate       |   |+ title         |
|+ borrow()     |   |+ renew()       |   |+ availability  |
+---------------+   +----------------+   +----------------+

         +------------------+
         | Catalog          |
         |------------------|
         |+ search()        |
         |+ addBook()       |
         +------------------+


Sequence

Member   UI     LibraryService   CatalogDB    Notification
|        |         |               |               |
|--search->|       |--queryCatalog->|               |
|        <-results--|               |               |
|--borrow->|--createLoan->|--updateBook->|           |
|        <-confirm----|<-ack-----------|--notify---->|


Component

[Catalog UI] -> [Library Service] -> [Loan Manager]
                     |                  |
                     v                  v
                 [Catalog DB]       [Member DB]
                     |
                     v
                [Notification Service]

E-commerce

Use Case

[Customer] -> (Browse Products) -> (Add to Cart) -> (Checkout) -> (Make Payment) -> (Track Order)
[Admin] -> (Add Product) -> (Manage Orders)


Class

+---------------+   +--------------+   +---------------+
| Customer      |---| Cart         |---| Order         |
|---------------|   |--------------|   |---------------|
|+ custId       |   |+ items       |   |+ orderId      |
|+ register()   |   |+ addItem()   |   |+ placeOrder() |
+---------------+   +--------------+   +---------------+

      +----------------+
      | Product        |
      |----------------|
      |+ productId     |
      |+ price         |
      |+ getDetails()  |
      +----------------+


Sequence

Customer  WebUI    ProductService   CartService    PaymentGateway   Shipping
|         |          |                |               |             |
|--browse->|--list->  |                |               |             |
|--add---->|--addItem->|--reserveStock->|               |             |
|--checkout->|--createOrder->|--charge->|--authorize---->|           |
|         <-paymentOK--|<-confirm------|<-confirm-------|           |
|--track-->|<-tracking--|                |               |            |


Component

[Web UI] -> [API Layer] -> [Product Service] -> [Inventory Service]
                            |                    |
                            v                    v
                        [Order Service]       [Payment Gateway]
                            |
                            v
                       [DB: Products/Orders/Users]

