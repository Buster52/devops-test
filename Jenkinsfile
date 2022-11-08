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
        }
}
