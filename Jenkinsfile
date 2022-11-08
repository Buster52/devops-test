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
                mailRecipients = 'gonzalezf.e@outlook.com'
                jobStatus = currentBuild.currentResult
                env.PROJNAME = 'devops-test'
                echo "projname is ${PROJNAME}"
                emailext body: 'Commit: env.commit_message',
            subject: "[Jenkins] ${jobStatus}",
            to: "${mailRecipients}"
            }
        }
    }
}
