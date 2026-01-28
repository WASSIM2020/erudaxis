pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'JAVA_HOME'
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/WASSIM2020/erudaxis.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install -U DskipTests'
            }
        }

        stage('Tests') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            publishHTML([
                reportDir: 'target/cucumber-reports',
                reportFiles: 'index.html',
                reportName: 'Cucumber Report'
            ])
        }

        failure {
            echo '❌ Les tests ont échoué'
        }

        success {
            echo '✅ Build et tests OK'
        }
    }
}
