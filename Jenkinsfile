pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                echo env.commit_message
                sh 'mvn clean install'
            }
        }
        stage('Email') {
            steps {
                env.PROJNAME = 'devops-test'
                echo "projname is ${PROJNAME}"
                emailext body: 'Commit: env.commit_message',
            subject: "[Jenkins] Job Execution",
            to: "gonzalezf.e@outlook.com"
            }
        }
    }
}
