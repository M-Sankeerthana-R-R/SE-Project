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


