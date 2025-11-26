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


