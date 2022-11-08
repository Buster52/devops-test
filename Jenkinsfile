pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    environment {
        commit_message = "${env.commit_message}"
    }
    stages {
        stage('Build') {
            steps {
                echo "env: ${env.commit_message}"
                echo "global: ${commit_message}"
                sh 'mvn clean install'
            }
        }
        stage('Email') {
            steps {
                emailext body: 'Commit: ${commit_message}',
            subject: '[Jenkins] Job Execution',
            to: 'gonzalezf.e@outlook.com'
            }
        }
    }
}
