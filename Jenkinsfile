pipeline {
    agent any

    tools {
        maven 'maven'
    }

    environment {
        CUCUMBER_JSON = 'target/cucumber.json'
        CUCUMBER_HTML = 'target/cucumber-report.html'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/master']],
                    userRemoteConfigs: [[url: 'https://github.com/WASSIM2020/erudaxis.git']]
                ])
            }
        }

        stage('Install Dependencies') {
            steps {
                bat 'mvn clean install -U -DskipTests'
            }
        }

        stage('Run Cucumber Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: "${CUCUMBER_JSON}, ${CUCUMBER_HTML}, /**", allowEmptyArchive: false
            }
        }
    }

    post {
        always {
            script {
                catchError(buildResult: 'UNSTABLE', stageResult: 'FAILURE') {
                    cucumber(
                        jsonReportDirectory: 'target',
                        fileIncludePattern: '**/cucumber.json'
                    )
                }
            }

            junit allowEmptyResults: true, testResults: 'target/surefire-reports/**/*.xml'
        }
    }
}
