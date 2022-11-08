pipeline {
    def commit_message;
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                commit_message = echo "${env.commit_message}"
                echo ${commit_message}
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
