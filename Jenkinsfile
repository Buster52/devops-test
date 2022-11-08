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
                def mailRecipients = 'gonzalezf.e@outlook.com'
                def jobStatus = currentBuild.currentResult
                env.PROJNAME = 'devops-test'
                echo "projname is ${PROJNAME}"
                emailext body: 'Commit: env.commit_message',
            subject: "[Jenkins] ${jobStatus}",
            to: "${mailRecipients}"
            }
        }
    }
}
