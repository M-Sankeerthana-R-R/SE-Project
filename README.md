<img width="829" height="852" alt="image" src="https://github.com/user-attachments/assets/d262812c-ca13-4dfa-9b3f-2503cf6ee5d0" />fawq qqxc phkz xfhe-- email pwd in advanced jenkins email and port: 465

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
<img width="829" height="852" alt="image" src="https://github.com/user-attachments/assets/270550bf-dd63-40a5-8e6f-4c0d9ab359df" />

<img width="843" height="932" alt="image" src="https://github.com/user-attachments/assets/a0bfaed5-5345-4064-bbbd-7e9bd0583293" />

<img width="888" height="843" alt="image" src="https://github.com/user-attachments/assets/e569e9d9-01d6-4f79-b5be-a2cee4fe463a" />
<img width="704" height="949" alt="image" src="https://github.com/user-attachments/assets/8f094801-51d1-4222-85ef-a698ae9fd862" />
<img width="690" height="962" alt="image" src="https://github.com/user-attachments/assets/85d5c7e2-8194-4291-9bf5-313b01192608" />
<img width="704" height="970" alt="image" src="https://github.com/user-attachments/assets/5757e448-ba6d-44e6-b0e3-3c62eef06ec8" />
<img width="654" height="578" alt="image" src="https://github.com/user-attachments/assets/c53ca59a-42a2-4b15-9d17-303398a428ec" />



CREATE A 2-STAGE PIPELINE IN JENKINS WITHOUT CODE (FREESTYLE JOB)
Stages:

1️⃣ Build
2️⃣ Test

✅ STEP 1 — Create Freestyle Job

Jenkins Dashboard → New Item

Enter name:

2-stage-no-code


Select Freestyle project

Click OK

✅ STEP 2 — Add Git Repository

Scroll to Source Code Management → Git

Repo URL:

https://github.com/M-Sankeerthana-R-R/labinternal-1


Credentials → choose your GitHub token

Branch:

main

✅ STEP 3 — Add Build Step for BUILD stage

Scroll to Build → Add build step

Choose:

👉 Invoke top-level Maven targets

Fill:

Goals:

clean install


This completes STAGE 1 (Build).

✅ STEP 4 — Add Build Step for TEST stage

Click Add build step again

Choose:

👉 Invoke top-level Maven targets

Fill:

Goals:

test


Now you have:

Build stage

Test stage

Both created without writing pipeline code.

⭐ THIS IS YOUR 2-STAGE PIPELINE WORKFLOW

NO code.
Only Freestyle + Maven.

Now click Save → Build Now.
Jenkins will run:

Git Checkout

Maven clean install

Maven test

⭐ NOW LET’S CREATE THE 3-STAGE PIPELINE WITHOUT CODE

Stages:

Build

Test

Deploy

🚀 CREATE 3-STAGE PIPELINE (NO CODE)
STEP 1 — Create another Freestyle Job

Dashboard → New Item
Name:

3-stage-no-code


Select Freestyle project

STEP 2 — Add Git Repository

Same as 2-stage job.

STEP 3 — Stage 1: Build

Add build step:

👉 Invoke top-level Maven targets
Goals:

clean package

STEP 4 — Stage 2: Test

Add build step again:

👉 Invoke top-level Maven targets
Goals:

test

STEP 5 — Stage 3: Deploy (NO SERVER REQUIRED)

Add build step:

👉 Execute Windows batch command

Add any simulated deploy command:

echo Deploying application...
echo Deployment complete.


This simulates deployment without needing Tomcat/Kubernetes.

🎉 RESULT:

You have created:

✔ 2-stage pipeline WITHOUT code
✔ 3-stage pipeline WITHOUT code
✔ Only using Freestyle jobs, Git, Maven build steps

This matches exact practical exam expectations.
