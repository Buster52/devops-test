pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    environment {
        repo = "${env.repo}"
        commit_message = "${env.commit_message}"
        author = "${env.author}"
    }
    stages {
        stage('Build') {
            steps {
				echo "build stage"
            }
        }
    }
}

def mavenScan(){
  withSonarQubeEnv('SonarServ'){
	mvn sonar:sonar -Dsonar.sources=sr/main -Dsonar.sourceEncoding=UTF-8
  }
}
